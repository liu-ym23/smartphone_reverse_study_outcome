package com.bytedance.ee.bear.drive.view.preview.pdf;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.pdf.PdfRenderer;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.util.ui.n;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Bitmap.Config f225121j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile PdfRenderer f225122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f225123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DriveFilePath f225124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f225125d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f225126e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f225127f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f225128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f225129h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a95.a f225130i;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.view.preview.pdf.a$a, reason: collision with other inner class name */
    public static class C3237a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f225131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f225132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f225133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Throwable f225134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f225135e;

        public final boolean a() {
            if (this.f225134d == null) goto L5;
        L7:
            return false;
        L5:
            if (this.f225131a == null) goto L7;
            return true;
        }

        public C3237a(Throwable r100) {
            this.f225134d = r100;
        }

        public C3237a(Bitmap r100, int r101, int r102) {
            this.f225131a = r100;
            this.f225132b = r102;
            this.f225133c = r101;
        }
    }

    public final void b() {
        this.f225125d = true;
        if (this.f225126e == false) goto L7;
        tt5.a.h("PdfRender", "PdfRenderer close but isOpeningPage, watting openPage done to manual close");
        return;
    L7:
        if (this.f225122a != null) goto L21;
        return;
    L21:
        this.f225122a.close();     // Catch: Throwable -> L11
        tt5.a.h("PdfRender", "PdfRenderer close success");     // Catch: Throwable -> L11
    L14:
        this.f225122a = null;
        return;
    L11:
        th = move-exception;
        tt5.a.f("PdfRender", th, false);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.f225122a = null;
        throw th;
    }

    static {
        f225121j = Bitmap.Config.ARGB_8888;
    }

    public final void d(int r100) {
        int r101 = n.v();
        int r102 = n.t();
        if (r100 != 1) goto L5;
        this.f225127f = Math.min(r101, r102);
        this.f225128g = Math.max(r101, r102);
    L6:
        tt5.a.h("PdfRender", "initScreenParams() called with: orientation = [" + r100 + "] w=" + this.f225127f + " h=" + this.f225128g);
        return;
    L5:
        int r103 = Math.max(r101, r102);
        this.f225127f = r103;
        this.f225128g = (r103 * r103) / Math.min(r101, r102);
        goto L6
    }

    public final int[] a(PdfRenderer.Page r100, boolean r101) {
        tt5.a.b("PdfRender", "calculateWH, isPresentationMode: " + r101 + ", screenWidth: " + this.f225127f + ", screenHeight: " + this.f225128g);
        if (r101 == true) goto L5;
        double r102 = (((double) this.f225127f) * 1.0d) / ((double) r100.getWidth());
        int r103 = (int) (((double) r100.getWidth()) * r102);
        int r104 = (int) (((double) r100.getHeight()) * r102);
    L7:
        return new int[]{r103, r104};
    L5:
        double r105 = Math.min((((double) this.f225127f) * 1.0d) / ((double) r100.getWidth()), (((double) this.f225128g) * 1.0d) / ((double) r100.getHeight()));
        r103 = (int) (((double) r100.getWidth()) * r105);
        r104 = (int) (((double) r100.getHeight()) * r105);
        goto L7
    }

    public a(DriveFilePath r100, int r101, a95.a r102) {
        this.f225124c = r100;
        this.f225130i = r102;
        d(r101);
    }

    public final synchronized C3237a c(int r100, boolean r110, LruBitmapPool r111) {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L5:
        if (this.f225122a != null) goto L9;
        C3237a r101 = new C3237a(new Exception("mPdfRenderer is null, maybe closed or load failed."));     // Catch: Throwable -> L44
        monitor-exit(this);
        return r101;
    L9:
        tt5.a.h("PdfRender", "getPage=" + r100);     // Catch: Throwable -> L44
        this.f225126e = true;     // Catch: Throwable -> L44
        PdfRenderer.Page r102 = this.f225122a.openPage(r100);     // Catch: Throwable -> L32
        int[] r112 = a(r102, r110);     // Catch: Throwable -> L25
        int r103 = r112[0];     // Catch: Throwable -> L25
        int r113 = r112[1];     // Catch: Throwable -> L25
        Bitmap.Config r104 = f225121j;     // Catch: Throwable -> L25
        if (r111 == null) goto L15;
        Bitmap r114 = r111.get(r103, r113, r104);     // Catch: Throwable -> L25
    L16:
        if (r114 != null) goto L18;
        r114 = Bitmap.createBitmap(r103, r113, r104);     // Catch: Throwable -> L25
        tt5.a.b("PdfRender", "get bitmap from pool failure. create new one. bitmapSize: " + (r114.getHeight() * r114.getRowBytes()));     // Catch: Throwable -> L25
    L18:
        r114.eraseColor(Color.parseColor(CustomHeaderConfig.COLOR_LIGHT));     // Catch: Throwable -> L25
        r102.render(r114, null, null, 1);     // Catch: Throwable -> L25
        this.f225129h = true;     // Catch: Throwable -> L25
        C3237a r105 = new C3237a(r114, r103, r113);     // Catch: Throwable -> L25
        r105.f225135e = r100;     // Catch: Throwable -> L25
        r102.close();     // Catch: Throwable -> L32
        this.f225126e = false;     // Catch: Throwable -> L44
        if (this.f225125d == false) goto L23;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L44
        b();     // Catch: Throwable -> L44
        this.f225125d = false;     // Catch: Throwable -> L44
    L23:
        monitor-exit(this);
        return r105;
    L15:
        r114 = null;
    L25:
        th = move-exception;
        if (r102 != null) goto L50;
    L31:
        throw th;     // Catch: Throwable -> L32
    L50:
        r102.close();     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        tt5.a.f("PdfRender", th, false);     // Catch: Throwable -> L39
        C3237a r115 = new C3237a(th);     // Catch: Throwable -> L39
        this.f225126e = false;     // Catch: Throwable -> L44
        if (this.f225125d == false) goto L38;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L44
        b();     // Catch: Throwable -> L44
        this.f225125d = false;     // Catch: Throwable -> L44
    L38:
        return r115;
    L39:
        th = move-exception;
        this.f225126e = false;     // Catch: Throwable -> L44
        if (this.f225125d == false) goto L43;
        tt5.a.h("PdfRender", "PdfRenderer getPage() openPage Done and isPenddingClosed, start close it");     // Catch: Throwable -> L44
        b();     // Catch: Throwable -> L44
        this.f225125d = false;     // Catch: Throwable -> L44
    L43:
        throw th;     // Catch: Throwable -> L44
    }
}
