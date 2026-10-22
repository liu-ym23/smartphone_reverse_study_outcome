package m8a;

import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxImageService;
import com.optimize.statistics.FrescoTraceListener;
import i8a.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f512523a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f512524b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f512525c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Method f512526d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Method f512527e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f512528f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f512529g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f512530h = true;

    static {
        f512523a = ImageDecodeOptionsBuilder.class.getDeclaredMethod("setPreDecodeFrameCount", new Class[]{Integer.TYPE});     // Catch: Throwable -> L5
    L26:
        f512524b = AnimatedDrawable2.class.getDeclaredMethod("setPrivateFrameScheduler", new Class[]{FrameScheduler.class});     // Catch: Throwable -> L9
    L24:
        f512526d = ImageRequestBuilder.class.getDeclaredMethod("setProgressiveRenderingAnimatedEnabled", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L13
    L20:
        f512527e = ImageRequestBuilder.class.getDeclaredMethod("setProgressiveRenderingHeicEnabled", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
        return;
    L13:
        th = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
    L9:
        th = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
    L5:
        th = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
        goto L26
    }

    public static void a(ImageRequestBuilder r100) {
        b(r100, Bitmap.Config.ARGB_8888, false);
    }

    public static void c(AnimatedDrawable2 r100) {
        Method r101 = f512524b;
        if (r101 != null) goto L13;
        return;
    L13:
        r101.invoke(r100, new Object[]{new DropFramesFrameScheduler(r100.getAnimationBackend())});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10
    L16:
        return;
    L10:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        return;
    L8:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
    }

    public static boolean d(AnimatedDrawable2 r100) {
        if (f512529g == true) goto L6;
        return false;
    L6:
        if (f512525c != null) goto L23;
        f512525c = AnimatedDrawable2.class.getDeclaredMethod("pause", new Class[0]);     // Catch: NoSuchMethodException -> L9
    L9:
        e = move-exception;
        f512529g = false;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        return false;
    L23:
        f512525c.invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L15 IllegalAccessException -> L18
        return true;
    L18:
        e = move-exception;
        f512529g = false;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        return false;
    L15:
        e = move-exception;
        f512529g = false;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        return false;
    }

    public static void e(ImageRequestBuilder r100, Map<String, String> r101) {
        if (f512530h == true) goto L6;
        return;
    L6:
        if (f512528f == null) goto L19;
    L17:
        f512528f.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
        return;
    L19:
        f512528f = ImageRequestBuilder.class.getDeclaredMethod("setCustomParam", new Class[]{Map.class});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(th));
        f512530h = false;
    }

    public static void b(ImageRequestBuilder r100, Bitmap.Config r101, boolean r102) {
        if (r101 != null) goto L5;
        r101 = Bitmap.Config.ARGB_8888;
    L5:
        ImageDecodeOptionsBuilder r103 = new ImageDecodeOptionsBuilder().setBitmapConfig(r101);
        Method r104 = f512523a;
        if (r104 != null) goto L20;
    L14:
        if (r102 == false) goto L18;
        ILynxImageService r105 = (ILynxImageService) n.c().a(ILynxImageService.class);
        if (r105 == null) goto L18;
        r105.setCustomImageDecoder(r103);
    L18:
        r100.setImageDecodeOptions(r103.build());
        return;
    L20:
        r104.invoke(r103, new Object[]{0});     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12
    L12:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
    L10:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        goto L14
    }
}
