package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class BlurUtils {
    private static final int BLUR_DEFAULT_SAMPLING = 1;
    private static final int DEFAULT_ITERATIONS = 3;
    private static final String TAG = "BlurUtils";
    private static Method sCreateBlurEffect = null;
    private static Class sRenderEffectClass = null;
    private static Method sSetNodeRenderEffect = null;
    private static Method sSetRenderEffect = null;
    private static boolean sSupportRenderEffect = true;

    public BlurUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static native void nativeIterativeBoxBlur(Bitmap r100, int r101, int r102);

    private static boolean isSupportRenderEffect() {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L7:
        return false;
    L5:
        if (sSupportRenderEffect == false) goto L7;
        return true;
    }

    private static boolean prepareRenderEffect() {
        if (sRenderEffectClass == null) goto L23;
    L7:
        Class r100 = sRenderEffectClass;
        if (r100 == null) goto L16;
        if (sCreateBlurEffect != null) goto L16;
        Class<?> r101 = Float.TYPE;     // Catch: NoSuchMethodException -> L13
        sCreateBlurEffect = r100.getMethod("createBlurEffect", new Class[]{r101, r101, Shader.TileMode.class});     // Catch: NoSuchMethodException -> L13
    L13:
        LLog.e(TAG, "prepareRenderEffectClass failed");
        return false;
    L16:
        if (sRenderEffectClass != null) goto L18;
    L20:
        return false;
    L18:
        if (sCreateBlurEffect == null) goto L20;
        return true;
    L23:
        sRenderEffectClass = INVOKESTATIC_com_lynx_tasm_utils_BlurUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.graphics.RenderEffect");     // Catch: ClassNotFoundException -> L6
    L6:
        return false;
    }

    private static boolean prepareRenderNodeSetMethod() {
        if (prepareRenderEffect() == true) goto L6;
        return false;
    L6:
        if (sSetNodeRenderEffect == null) goto L12;
    L11:
        return true;
    L12:
        sSetNodeRenderEffect = RenderNode.class.getMethod("setRenderEffect", new Class[]{sRenderEffectClass});     // Catch: NoSuchMethodException -> L9
    L9:
        LLog.e(TAG, "prepareRenderNodeRenderEffectMethods failed");
        sSupportRenderEffect = false;
        return false;
    }

    private static boolean prepareViewSetMethod() {
        if (prepareRenderEffect() == true) goto L6;
        return false;
    L6:
        if (sSetRenderEffect == null) goto L12;
    L11:
        return true;
    L12:
        sSetRenderEffect = View.class.getMethod("setRenderEffect", new Class[]{sRenderEffectClass});     // Catch: NoSuchMethodException -> L9
    L9:
        LLog.e(TAG, "prepareRenderEffectMethods failed");
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_utils_BlurUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static boolean removeEffect(View r100) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (prepareViewSetMethod() == true) goto L13;
        sSupportRenderEffect = false;
        return false;
    L13:
        sSetRenderEffect.invoke(r100, new Object[]{null});     // Catch: Throwable -> L11
        return true;
    L11:
        sSupportRenderEffect = false;
        return false;
    }

    public static boolean createEffect(RenderNode r100, float r101) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (r101 > 0.0f) goto L9;
        return false;
    L9:
        if (prepareRenderNodeSetMethod() == true) goto L21;
        sSupportRenderEffect = false;
        return false;
    L21:
        sSetNodeRenderEffect.invoke(r100, new Object[]{sCreateBlurEffect.invoke(null, new Object[]{Float.valueOf(r101), Float.valueOf(r101), Shader.TileMode.CLAMP})});     // Catch: Throwable -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18
        return true;
    L14:
        e = move-exception;
        LLog.e(TAG, "createNodeEffect failed " + e.getMessage());
        sSupportRenderEffect = false;
        return false;
    }

    public static void iterativeBoxBlur(Bitmap r100, int r101) {
        if (r100 != null) goto L6;
        LLog.w("Blur", "bitmap is null");
        return;
    L6:
        if (r101 > 0) goto L14;
        LLog.w("Blur", "radius <= 0");
        return;
    L14:
        TraceEvent.beginSection("image.BlurUtils.nativeIterativeBoxBlur");     // Catch: RuntimeException -> L11
        nativeIterativeBoxBlur(r100, 3, r101);     // Catch: RuntimeException -> L11
        TraceEvent.endSection("image.BlurUtils.nativeIterativeBoxBlur");     // Catch: RuntimeException -> L11
        return;
    L11:
        e = move-exception;
        LLog.w("Blur", e.getMessage());
    }

    public static boolean createEffect(View r100, float r101) {
        if (isSupportRenderEffect() == true) goto L6;
        return false;
    L6:
        if (r101 > 0.0f) goto L9;
        return false;
    L9:
        if (prepareViewSetMethod() == true) goto L21;
        sSupportRenderEffect = false;
        return false;
    L21:
        sSetRenderEffect.invoke(r100, new Object[]{sCreateBlurEffect.invoke(null, new Object[]{Float.valueOf(r101), Float.valueOf(r101), Shader.TileMode.CLAMP})});     // Catch: Throwable -> L14 IllegalArgumentException -> L16 IllegalAccessException -> L18
        return true;
    L14:
        e = move-exception;
        LLog.e(TAG, "createViewEffect failed " + e.getMessage());
        sSupportRenderEffect = false;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Bitmap rs(Context r100, Bitmap r101, float r102) throws RSRuntimeException {
        RenderScript r103 = null;
        ScriptIntrinsicBlur r104 = null;
        RenderScript r105 = RenderScript.create(r100);     // Catch: Throwable -> L16
        r105.setMessageHandler(new RenderScript.RSMessageHandler());     // Catch: Throwable -> L13
        Allocation r106 = Allocation.createFromBitmap(r105, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Throwable -> L13
        Allocation r107 = Allocation.createTyped(r105, r106.getType());     // Catch: Throwable -> L11
        r104 = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: Throwable -> L9
        r104.setInput(r106);     // Catch: Throwable -> L9
        r104.setRadius(r102);     // Catch: Throwable -> L9
        r104.forEach(r107);     // Catch: Throwable -> L9
        r107.copyTo(r101);     // Catch: Throwable -> L9
        r105.destroy();
        r106.destroy();
        r107.destroy();
        r104.destroy();
        return r101;
    L9:
        th = th;
        ScriptIntrinsicBlur r108 = r104;
        r103 = r105;
        ScriptIntrinsicBlur r109 = r108;
    L18:
        if (r103 == null) goto L20;
        r103.destroy();
    L20:
        if (r106 == null) goto L22;
        r106.destroy();
    L22:
        if (r107 == null) goto L24;
        r107.destroy();
    L24:
        if (r109 == 0) goto L26;
        r109.destroy();
    L26:
        throw th;
    L11:
        th = th;
        r107 = null;
    L15:
        r103 = r105;
        r109 = r107;
    L13:
        th = th;
        r106 = null;
        r107 = null;
    L16:
        th = th;
        r109 = 0;
        r106 = null;
        r107 = null;
        goto L18
    }

    public static Bitmap blur(Context r100, Bitmap r110, int r111, int r112, float r113, int r114) {
        if (r111 == 0) goto L20;
        if (r112 != 0) goto L6;
        return null;
    L6:
        if (r114 <= 1) goto L8;
        boolean r101 = true;
    L9:
        Boolean r102 = Boolean.valueOf(r101);
        if (r102.booleanValue() == false) goto L12;
        Bitmap r115 = Bitmap.createScaledBitmap(r110, r111 / r114, r112 / r114, true);
    L22:
        r115 = rs(r100, r115, r113);     // Catch: RSRuntimeException -> L15
    L17:
        if (r102.booleanValue() == false) goto L19;
        int[] r103 = new int[r111 * r112];
        Bitmap.createScaledBitmap(r115, r111, r112, true).getPixels(r103, 0, r111, 0, 0, r111, r112);
        r110.setPixels(r103, 0, r111, 0, 0, r111, r112);
    L19:
        return r110;
    L15:
        iterativeBoxBlur(r115, (int) r113);
        goto L17
    L12:
        r115 = r110;
        goto L22
    L8:
        r101 = false;
        goto L9
    L20:
        return null;
    }
}
