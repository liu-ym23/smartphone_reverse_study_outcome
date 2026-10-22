package mq7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Arrays;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f514895a = null;

    /* JADX INFO: renamed from: mq7.a$a, reason: collision with other inner class name */
    public static class C6843a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f514896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f514897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f514898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f514899d;

        public C6843a() {
            this.f514896a = 3;
            this.f514898c = -1;
        }
    }

    static {
        f514895a = new b();
    }

    public static C6843a a(View r100) {
        nq7.a r101 = new nq7.a();
        C6843a r102 = new C6843a();
        boolean r103 = false;
        if (r100 != null) goto L5;
        r102.f514898c = 1;
        r102.f514899d = "view is null.";
        r102.f514896a = 3;
        boolean r104 = false;
    L6:
        if (r104 == false) goto L30;
        Context r105 = r100.getContext();
        if (r105 != null) goto L11;
    L29:
        r102.f514898c = 4;
        r102.f514899d = "context or context.getResources is null";
        r102.f514896a = 3;
        goto L30
    L11:
        if (r105.getResources() == null) goto L29;
        int r106 = r100.getWidth();
        int r107 = r100.getHeight();
        if (r106 <= 0) goto L18;
        if (r107 <= 0) goto L18;
        r103 = true;
    L19:
        if (r103 == false) goto L30;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L24;
        r102.f514898c = 2;
        r102.f514899d = "current thread is not main thread.";
        r102.f514896a = 3;
        goto L30
    L24:
        long r108 = System.currentTimeMillis();
        b(r100, r101, r102);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r102.f514898c = 4;
        r102.f514899d = th.getMessage();
        r102.f514896a = 3;
        r102.f514897b = System.currentTimeMillis() - r108;
    L18:
        r102.f514898c = 4;
        r102.f514899d = "width and height must be > 0";
        r102.f514896a = 3;
    L30:
        return r102;
    L5:
        r104 = true;
        goto L6
    }

    public static void b(View r210, nq7.a r211, C6843a r212) {
        long r100 = System.currentTimeMillis();
        int r101 = (int) ((r210.getWidth() * 0.1f) + 0.5f);
        int r102 = (int) ((r210.getHeight() * 0.1f) + 0.5f);
        if (r101 <= 0) goto L5;
        if (r102 <= 0) goto L5;
    L6:
        Bitmap r103 = nq7.a.f520138b;
        boolean r104 = false;
        int r105 = 1;
        Bitmap r106 = null;
        if (r103 != null) goto L9;
    L15:
        Bitmap r107 = null;
        boolean r110 = true;
    L16:
        if (r107 == null) goto L56;
    L21:
        if (r107 == null) goto L30;
        Canvas r108 = new Canvas(r107);
        r108.scale(0.1f, 0.1f);
        r210.computeScroll();
        r108.translate(-r210.getScrollX(), -r210.getScrollY());
        r210.draw(r108);
        if (r110 == false) goto L29;
        Bitmap r109 = nq7.a.f520138b;
        if (r109 == null) goto L29;
        if (r109.isRecycled() == true) goto L29;
        nq7.a.f520138b.recycle();
    L29:
        nq7.a.f520138b = r107;
    L30:
        if (r107 == null) goto L53;
        r107.getConfig();
        int r111 = r107.getWidth();
        int r112 = r107.getHeight();
        if (r111 <= 0) goto L54;
        if (r112 <= 0) goto L54;
        int r113 = r107.getPixel(0, 0);
        b r114 = f514895a;
        r114.f514900a = r113;
        int r115 = r107.getWidth();
        int r116 = r107.getHeight();
        if (r115 <= 0) goto L49;
        if (r116 <= 0) goto L49;
        int r117 = r114.f514900a;
        if (r117 != 0) goto L40;
        r117 = r107.getPixel(0, 0);
    L40:
        int[] r118 = new int[r115];
        Arrays.fill(r118, r117);
        int[] r119 = new int[r115];
        int r120 = 0;
    L41:
        if (r120 >= r116) goto L46;
        int r121 = r120;
        r107.getPixels(r119, 0, r115, 0, r121, r115, 1);
        if (Arrays.equals(r118, r119) == false) goto L47;
        r120 = r121 + 1;
    L47:
        if (r104 == false) goto L49;
        Integer.toHexString(r117);
        goto L49
    L46:
        r104 = true;
    L49:
        if (r104 == true) goto L52;
        r105 = 2;
    L52:
        r212.f514896a = r105;
    L54:
        r212.f514897b = System.currentTimeMillis() - r100;
        return;
    L53:
        r212.f514898c = 3;
        r212.f514899d = "bitmap is null.";
        r212.f514896a = 3;
        goto L54
    L56:
        Resources r122 = r210.getContext().getResources();     // Catch: OutOfMemoryError -> L19
        r106 = Bitmap.createBitmap(WindowDisplayMetricsOverride.apply(r122, r122.getDisplayMetrics()), r101, r102, nq7.a.f520137a);     // Catch: OutOfMemoryError -> L19
    L20:
        r107 = r106;
        goto L21
    L9:
        if (r103.isRecycled() == true) goto L15;
        if (nq7.a.f520138b.getWidth() != r101) goto L15;
        if (nq7.a.f520138b.getHeight() != r102) goto L15;
        r107 = nq7.a.f520138b;
        r110 = false;
    L5:
        r101 = r210.getWidth();
        r102 = r210.getHeight();
        goto L6
    }
}
