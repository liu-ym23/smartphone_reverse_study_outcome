package com.bytedance.common.jato.view;

import android.os.Build;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class ViewUtils {
    private static volatile int inited = -1;
    private static Field mAnimationHost;
    private static Field mNativeRenderNode;
    private static Field mOwningView;
    private static Field mView;
    private static Field renderNode;

    public ViewUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean checkInit() {
        if (inited != (-1)) goto L19;
        monitor-enter(ViewUtils.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (inited == (-1)) goto L9;
    L13:
        monitor-exit(ViewUtils.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (init() == false) goto L11;
        int r100 = 1;
    L12:
        inited = r100;     // Catch: Throwable -> L15
        goto L13
    L11:
        r100 = 0;
    L19:
        if (inited != 1) goto L24;
        return true;
    L24:
        return false;
    }

    public static boolean init() {
        Field r100 = View.class.getDeclaredField("mRenderNode");     // Catch: Throwable -> L7
        renderNode = r100;     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        Field r101 = renderNode.getType().getDeclaredField("mNativeRenderNode");     // Catch: Throwable -> L7
        mNativeRenderNode = r101;     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        Field r102 = renderNode.getType().getDeclaredField("mOwningView");     // Catch: Throwable -> L7
        mOwningView = r102;     // Catch: Throwable -> L7
        r102.setAccessible(true);     // Catch: Throwable -> L7
    L6:
        return true;
    L5:
        Field r103 = renderNode.getType().getDeclaredField("mAnimationHost");     // Catch: Throwable -> L7
        mAnimationHost = r103;     // Catch: Throwable -> L7
        r103.setAccessible(true);     // Catch: Throwable -> L7
        Field r104 = INVOKESTATIC_com_bytedance_common_jato_view_ViewUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.ViewAnimationHostBridge").getDeclaredField("mView");     // Catch: Throwable -> L7
        mView = r104;     // Catch: Throwable -> L7
        r104.setAccessible(true);     // Catch: Throwable -> L7
    L7:
        return false;
    }

    public static String getRenderNodeClassName() {
        if (checkInit() == true) goto L7;
        return null;
    L7:
        return renderNode.getType().getName();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_jato_view_ViewUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static long getRenderNodePtr(View r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        if (checkInit() == false) goto L16;
        Object r101 = renderNode.get(r100);     // Catch: IllegalAccessException -> L11
        if (r101 == null) goto L15;
        return mNativeRenderNode.getLong(r101);
    L15:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static View getViewFromRenderNode(Object r100) {
        if (r100 != null) goto L5;
    L15:
        return null;
    L5:
        if (checkInit() == false) goto L15;
        if (Build.VERSION.SDK_INT < 29) goto L10;
        Object r101 = mAnimationHost.get(r100);     // Catch: IllegalAccessException -> L16
        if (r101 == null) goto L15;
        return (View) mView.get(r101);
    L10:
        return (View) mOwningView.get(r100);
    }
}
