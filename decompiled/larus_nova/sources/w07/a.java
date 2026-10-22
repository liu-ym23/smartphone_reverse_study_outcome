package w07;

import android.net.Uri;
import android.util.Log;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CacheKeyFactory f557816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f557817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f557818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f557819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f557820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f557821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f557822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Method f557823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Method f557824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f557825j;

    public a() {
    }

    public static int a(CloseableImage r100) {
        if (r100 != null) goto L6;
        return 1;
    L6:
        if (f557817b != null) goto L12;
        f557817b = CloseableImage.class.getMethod("isHitBitmapMemoryCache", new Class[0]);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Log.getStackTraceString(th);
    L12:
        if (b(f557817b, r100) == false) goto L16;
        return 5;
    L16:
        if (f557818c != null) goto L22;
        f557818c = CloseableImage.class.getMethod("isHitEncodeMemoryCache", new Class[0]);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Log.getStackTraceString(th);
    L22:
        if (b(f557818c, r100) == false) goto L26;
        return 4;
    L26:
        if (f557819d != null) goto L32;
        f557819d = CloseableImage.class.getMethod("isHitDiskCache", new Class[0]);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Log.getStackTraceString(th);
    L32:
        if (b(f557819d, r100) == false) goto L36;
        return 3;
    L36:
        if (f557820e != null) goto L42;
        f557820e = CloseableImage.class.getMethod("isRequestInternet", new Class[0]);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        Log.getStackTraceString(th);
    L42:
        if (b(f557820e, r100) == false) goto L45;
        return 2;
    L45:
        return 1;
    }

    public static boolean b(Method r100, Object r101) {
        if (r100 != null) goto L9;
    L8:
        return false;
    L9:
        return Boolean.TRUE.equals(r100.invoke(r101, new Object[0]));
    L6:
        e = move-exception;
        Log.getStackTraceString(e);
        goto L8
    }

    public static void c(ImageRequestBuilder r100, Uri r101) {
        if (f557823h == null) goto L17;
    L8:
        Method r102 = f557823h;
        if (r102 == null) goto L19;
        r102.invoke(r100, new Object[]{r101});     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Log.getStackTraceString(th);
        return;
    L19:
        return;
    L17:
        f557823h = ImageRequestBuilder.class.getDeclaredMethod("setCacheKeyUri", new Class[]{Uri.class});     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Log.getStackTraceString(th);
        goto L8
    }

    public static void d(ImageRequestBuilder r100, int r101) {
        if (f557825j == false) goto L16;
    L9:
        Method r102 = f557824i;
        if (r102 == null) goto L20;
        r102.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Log.getStackTraceString(th);
        return;
    L20:
        return;
    L16:
        f557824i = ImageRequestBuilder.class.getMethod("setSampleSize", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
    L8:
        f557825j = true;
    L6:
        th = move-exception;
        Log.getStackTraceString(th);
        goto L8
    }

    public static void e(ImageRequestBuilder r100, int r101, int r102) {
        if (f557821f != null) goto L9;
        f557821f = ImageRequestBuilder.class.getMethod("setTargetWidth", new Class[]{Integer.TYPE});     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        Log.getStackTraceString(th);
    L9:
        if (f557822g == null) goto L23;
    L14:
        Method r103 = f557821f;
        if (r103 != null) goto L17;
        return;
    L17:
        if (f557822g == null) goto L30;
        r103.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L20
        f557822g.invoke(r100, new Object[]{Integer.valueOf(r102)});     // Catch: Exception -> L20
        return;
    L20:
        e = move-exception;
        Log.getStackTraceString(e);
        return;
    L30:
        return;
    L23:
        f557822g = ImageRequestBuilder.class.getMethod("setTargetHeight", new Class[]{Integer.TYPE});     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Log.getStackTraceString(th);
        goto L14
    }
}
