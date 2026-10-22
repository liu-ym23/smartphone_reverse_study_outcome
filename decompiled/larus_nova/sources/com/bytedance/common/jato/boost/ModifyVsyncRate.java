package com.bytedance.common.jato.boost;

import android.view.Choreographer;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class ModifyVsyncRate {
    private static volatile int inited;
    private static Field mDisplayEventReceiver;
    private static Field mReceiverPtr;

    public ModifyVsyncRate() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static native boolean nativeInit(long r100);

    private static native int nativeSetRate(int r100);

    private static void initInner() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Field r100 = Choreographer.class.getDeclaredField("mDisplayEventReceiver");
        mDisplayEventReceiver = r100;
        r100.setAccessible(true);
        Field r101 = INVOKESTATIC_com_bytedance_common_jato_boost_ModifyVsyncRate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.DisplayEventReceiver").getDeclaredField("mReceiverPtr");
        mReceiverPtr = r101;
        r101.setAccessible(true);
    }

    static {
        JatoNativeLoader.loadLibrary();
        inited = -1;
        mDisplayEventReceiver = null;
        mReceiverPtr = null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_jato_boost_ModifyVsyncRate_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean init(Choreographer r100) {
        if (inited != (-1)) goto L8;
        initInner();     // Catch: Throwable -> L6
        inited = 1;     // Catch: Throwable -> L6
    L6:
        inited = 0;
    L8:
        if (inited == 1) goto L13;
    L11:
        return false;
    L13:
        Object r101 = mDisplayEventReceiver.get(r100);     // Catch: Throwable -> L12
        return nativeInit(((Long) mReceiverPtr.get(r101)).longValue());
    }

    public static int setRate(int r100) {
        return nativeSetRate(Math.min(Math.max(r100, 1), 120));
    }

    public static int setVsyncFps(int r100) {
        if (r100 >= 60) goto L9;
        if (r100 <= 0) goto L9;
        return setRate(Math.round(60 / r100));
    L9:
        return setRate(1);
    }
}
