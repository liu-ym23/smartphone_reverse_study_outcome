package com.bytedance.common.jato.gfx;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.TextureView;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public class TextureViewUtil {
    private static Field sOnFrameAvailableHandlerField;
    private static Class sOppoTextureViewClass;

    public static class SurfaceHandler extends Handler {
        private Handler mOriginHandler;
        private boolean mUseAsyncMsg;

        public SurfaceHandler(Handler r100, boolean r101) {
            super(r100.getLooper());
            this.mOriginHandler = r100;
            this.mUseAsyncMsg = r101;
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message r100, long r101) {
            if (this.mUseAsyncMsg == false) goto L8;
            if (Build.VERSION.SDK_INT < 22) goto L8;
            r100.setAsynchronous(true);
        L8:
            return this.mOriginHandler.sendMessageAtFrontOfQueue(r100);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        String r100 = Build.BRAND;
        if (r100 == null) goto L19;
        String r101 = r100.toLowerCase();
        if (TextUtils.equals(r101, AppConstants.CHANNEL_OPPO) == false) goto L7;
    L17:
        sOppoTextureViewClass = INVOKESTATIC_com_bytedance_common_jato_gfx_TextureViewUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.OppoBaseTextureView");     // Catch: ClassNotFoundException -> L16
        goto L19
    L7:
        if (TextUtils.equals(r101, "oneplus") == true) goto L17;
        if (TextUtils.equals(r101, "realme") == true) goto L17;
    L19:
        Field r102 = SurfaceTexture.class.getDeclaredField("mOnFrameAvailableHandler");     // Catch: NoSuchFieldException -> L13
        sOnFrameAvailableHandlerField = r102;     // Catch: NoSuchFieldException -> L13
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L13
        return;
    L13:
        e = move-exception;
        e.toString();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_jato_gfx_TextureViewUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static void hookSurfaceTextureHandler(SurfaceTexture r100, boolean r101) {
        Handler r102 = (Handler) sOnFrameAvailableHandlerField.get(r100);     // Catch: Exception -> L10
        if (r102 != null) goto L6;
        return;
    L6:
        if ((r102 instanceof SurfaceHandler) == false) goto L8;
        return;
    L8:
        SurfaceHandler r103 = new SurfaceHandler(r102, r101);     // Catch: Exception -> L10
        sOnFrameAvailableHandlerField.set(r100, r103);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.toString();
    }

    public static void optimizeHandler(TextureView r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (sOnFrameAvailableHandlerField == null) goto L17;
        Class r102 = sOppoTextureViewClass;
        if (r102 != null) goto L9;
    L11:
        SurfaceTexture r103 = r100.getSurfaceTexture();
        if (r103 == null) goto L16;
        hookSurfaceTextureHandler(r103, r101);
        return;
    L16:
        return;
    L9:
        if (r102.isInstance(r100) == false) goto L11;
        return;
    }
}
