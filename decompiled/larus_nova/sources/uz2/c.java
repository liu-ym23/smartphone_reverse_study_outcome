package uz2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f552179a = null;

    static {
        f552179a = new d();
    }

    public static a b(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        a r100 = new a();
        Context r101 = r110.getContext();
        if (r101 != null) goto L5;
    L25:
        r100.f552176e = 4;
        r100.f552177f = "context or context.getResources is null";
        r100.f552172a = 3;
        return r100;
    L5:
        if (r101.getResources() == null) goto L25;
        int r102 = r110.getWidth();
        int r103 = r110.getHeight();
        if (r102 <= 0) goto L12;
        if (r103 <= 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        return r100;
    L16:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L19;
        r100.f552176e = 2;
        r100.f552177f = "current thread is not main thread.";
        r100.f552172a = 3;
        return r100;
    L19:
        long r105 = System.currentTimeMillis();
        b r111 = e.a(r110);     // Catch: Throwable -> L22
        r100.f552174c = System.currentTimeMillis() - r105;     // Catch: Throwable -> L22
        a(r111.f552178a, r100);     // Catch: Throwable -> L22
        r100.f552173b = (System.currentTimeMillis() - r105) - r100.f552174c;     // Catch: Throwable -> L22
        r100.f552175d = System.currentTimeMillis() - r105;     // Catch: Throwable -> L22
        return r100;
    L22:
        th = move-exception;
        r100.f552176e = 4;
        r100.f552177f = th.getMessage();
        r100.f552172a = 3;
        r100.f552175d = System.currentTimeMillis() - r105;
        return r100;
    L12:
        r100.f552176e = 4;
        r100.f552177f = "width and height must be > 0";
        r100.f552172a = 3;
        r104 = false;
        goto L13
    }

    public static void a(Bitmap r110, a r111) {
        if (r110 == null) goto L27;
        r110.getConfig();
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (r100 <= 0) goto L31;
        if (r101 <= 0) goto L32;
        int r102 = r110.getPixel(0, 0);
        d r103 = f552179a;
        r103.f552180a = r102;
        int r112 = r110.getWidth();
        int r113 = r110.getHeight();
        int r114 = 1;
        if (r112 <= 0) goto L22;
        if (r113 <= 0) goto L22;
        int r104 = r103.f552180a;
        if (r104 != 0) goto L13;
        r104 = r110.getPixel(0, 0);
    L13:
        int r115 = r104;
        int[] r116 = new int[r112];
        Arrays.fill(r116, r115);
        int[] r105 = new int[r112];
        int r106 = 0;
    L14:
        if (r106 >= r113) goto L19;
        int r117 = r106;
        int[] r118 = r105;
        r110.getPixels(r105, 0, r112, 0, r106, r112, 1);
        if (Arrays.equals(r116, r118) == false) goto L17;
        r106 = r117 + 1;
        r105 = r118;
        goto L14
    L17:
        boolean r119 = false;
    L20:
        if (r119 == false) goto L23;
        Integer.toHexString(r115);
    L23:
        if (r119 == true) goto L26;
        r114 = 2;
    L26:
        r111.f552172a = r114;
        return;
    L19:
        r119 = true;
    L22:
        r119 = false;
        goto L23
    L32:
        return;
    L31:
        return;
    L27:
        r111.f552176e = 3;
        r111.f552177f = "bitmap is null.";
        r111.f552172a = 3;
    }
}
