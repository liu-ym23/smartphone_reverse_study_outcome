package com.bytedance.ee.bear.drive.view.preview.pdf;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.pdf.PdfRenderer;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final Bitmap.Config j = null;
    public volatile PdfRenderer a;
    public int b;
    public final DriveFilePath c;
    public volatile boolean d;
    public volatile boolean e;
    public int f;
    public int g;
    public volatile boolean h;
    public final a95.a i;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.pdf.a$a, reason: collision with other inner class name */
    public static class C0181a {
        public final Bitmap a;
        public final int b;
        public final int c;
        public final Throwable d;
        public int e;

        public final boolean a() {
            if (this.d == null) goto L5;
        L7:
            return false;
        L5:
            if (this.a == null) goto L7;
            return true;
        }

        public C0181a(Throwable r1) {
            this.d = r1;
        }

        public C0181a(Bitmap r1, int r2, int r3) {
            this.a = r1;
            this.b = r3;
            this.c = r2;
        }
    }

    public final void b() {
        this.d = true;
        if (this.e == false) goto L7;
        tt5.a.h("PdfRender", "PdfRenderer close but isOpeningPage, watting openPage done to manual close");
        return;
    L7:
        if (this.a != null) goto L21;
        return;
    L21:
        this.a.close();     // Catch: Throwable -> L11
        tt5.a.h("PdfRender", "PdfRenderer close success");     // Catch: Throwable -> L11
    L14:
        this.a = null;
        return;
    L11:
        th = move-exception;
        tt5.a.f("PdfRender", th, false);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.a = null;
        throw th;
    }

    static {
        j = Bitmap.Config.ARGB_8888;
    }

    public final void d(int r4) {
        int r0 = n.v();
        int r1 = n.t();
        if (r4 != 1) goto L5;
        this.f = Math.min(r0, r1);
        this.g = Math.max(r0, r1);
    L6:
        tt5.a.h("PdfRender", "initScreenParams() called with: orientation = [" + r4 + "] w=" + this.f + " h=" + this.g);
        return;
    L5:
        int r2 = Math.max(r0, r1);
        this.f = r2;
        this.g = (r2 * r2) / Math.min(r0, r1);
        goto L6
    }

    public final int[] a(PdfRenderer.Page r7, boolean r8) {
        tt5.a.b("PdfRender", "calculateWH, isPresentationMode: " + r8 + ", screenWidth: " + this.f + ", screenHeight: " + this.g);
        if (r8 == true) goto L5;
        double r2 = (((double) this.f) * 1.0d) / ((double) r7.getWidth());
        int r9 = (int) (((double) r7.getWidth()) * r2);
        int r10 = (int) (((double) r7.getHeight()) * r2);
    L7:
        return new int[]{r9, r10};
    L5:
        double r0 = Math.min((((double) this.f) * 1.0d) / ((double) r7.getWidth()), (((double) this.g) * 1.0d) / ((double) r7.getHeight()));
        r9 = (int) (((double) r7.getWidth()) * r0);
        r10 = (int) (((double) r7.getHeight()) * r0);
        goto L7
    }

    public a(DriveFilePath r1, int r2, a95.a r3) {
        this.c = r1;
        this.i = r3;
        d(r2);
    }

    public final synchronized C0181a c(int r9, boolean r10, LruBitmapPool r11) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (this.a != null) goto L9;
        C0181a r12 = new C0181a(new Exception("mPdfRenderer is null, maybe closed or load failed."));     // Catch: Throwable -> L44
        monitor-exit(this);
        return r12;
    L9:
        tt5.a.h("PdfRender", "getPage=" + r9);     // Catch: Throwable -> L44
        this.e = true;     // Catch: Throwable -> L44
        PdfRenderer.Page r2 = this.a.openPage(r9);     // Catch: Throwable -> L32
        int[] r13 = a(r2, r10);     // Catch: Throwable -> L25
        int r3 = r13[0];     // Catch: Throwable -> L25
        int r14 = r13[1];     // Catch: Throwable -> L25
        Bitmap.Config r4 = j;     // Catch: Throwable -> L25
        if (r11 == null) goto L15;
        Bitmap r16 = r11.get(r3, r14, r4);     // Catch: Throwable -> L25
    L16:
        if (r16 != null) goto L18;
        r16 = Bitmap.createBitmap(r3, r14, r4);     // Catch: Throwable -> L25
        tt5.a.b("PdfRender", "get bitmap from pool failure. create new one. bitmapSize: " + (r16.getHeight() * r16.getRowBytes()));     // Catch: Throwable -> L25
    L18:
        r16.eraseColor(Color.parseColor(CustomHeaderConfig.COLOR_LIGHT));     // Catch: Throwable -> L25
        r2.render(r16, null, null, 1);     // Catch: Throwable -> L25
        this.h = true;     // Catch: Throwable -> L25
        C0181a r0 = new C0181a(r16, r3, r14);     // Catch: Throwable -> L25
        r0.e = r9;     // Catch: Throwable -> L25
        r2.close();     // Catch: Throwable -> L32
        this.e = false;     // Catch: Throwable -> L44
        if (this.d == false) goto L23;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L44
        b();     // Catch: Throwable -> L44
        this.d = false;     // Catch: Throwable -> L44
    L23:
        monitor-exit(this);
        return r0;
    L15:
        r16 = null;
    L25:
        th = move-exception;
        if (r2 != null) goto L50;
    L31:
        throw th;     // Catch: Throwable -> L32
    L50:
        r2.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        tt5.a.f("PdfRender", th, false);     // Catch: Throwable -> L39
        C0181a r17 = new C0181a(th);     // Catch: Throwable -> L39
        this.e = false;     // Catch: Throwable -> L44
        if (this.d == false) goto L38;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L44
        b();     // Catch: Throwable -> L44
        this.d = false;     // Catch: Throwable -> L44
    L38:
        return r17;
    L39:
        th = move-exception;
        this.e = false;     // Catch: Throwable -> L44
        if (this.d == false) goto L43;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L44
        b();     // Catch: Throwable -> L44
        this.d = false;     // Catch: Throwable -> L44
    L43:
        throw th;     // Catch: Throwable -> L44
    }
}
