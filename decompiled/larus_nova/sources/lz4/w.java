package lz4;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.screenshot.plugin.OfficeDocShotPresenter;
import com.bytedance.ee.bear.screenshot.FastPngEncoder;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class w extends lz4.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f511416l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f511417m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f511418n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f511419o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final BlockingQueue<b> f511420p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Future<?> f511421q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Future<?> f511422r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f511423s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f511424t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f511425u;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f511426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f511427b;

        public final void a() {
            this.f511427b.c();
            if (this.f511427b.f511423s == false) goto L6;
            tt5.a.d("ScreenshotV2", "onFailed has Release");
            return;
        L6:
            tt5.a.f("ScreenshotV2", this.f511426a, false);
            this.f511427b.e();
            kz4.a r100 = this.f511427b.f511368d;
            Throwable r101 = this.f511426a;
            if (r101 != null) goto L9;
            String r102 = "empty";
        L15:
            ((jz4.i) r100).a(r102, this.f511427b.f511418n);
            this.f511427b.f511418n = 0;
            return;
        L9:
            String r103 = r101.getMessage();
            if (TextUtils.isEmpty(r103) == false) goto L14;
            r103 = r101.toString() + " ";
            StackTraceElement[] r104 = r101.getStackTrace();
            if (r104.length <= 0) goto L14;
            r102 = r103 + r104[0];
        L14:
            r102 = r103;
            goto L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(w r100, Throwable r101) {
            this.f511427b = r100;
            this.f511426a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f511428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f511429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f511430c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f511431d;

        public b() {
        }
    }

    public void c() {
    }

    public final void e() {
        this.f511423s = true;
        this.f511421q.cancel(true);
        this.f511422r.cancel(true);
    }

    public final void a() {
        if (this.f511424t == false) goto L5;
        return;
    L5:
        if (this.f511423s == true) goto L10;
        tt5.a.h("ScreenshotV2", "checkEncode mEncoding:" + this.f511424t);
        f();
        return;
    }

    public void d() {
        OfficeDocShotPresenter r100 = ((jz4.i) this.f511368d).f501194d;
        if (r100.f218119a == false) goto L6;
        OfficeDocShotPresenter.a(r100, false);
        return;
    }

    public final void f() {
        final boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("admin.watermark.filewatermark.remaining");
        tt5.a.h("ScreenshotV2", "startEncode(), isWatermarkRemainingEnable: " + r100);
        this.f511422r = BearExecutors.c().submit(new r(this, r100));
        BearExecutors.e().schedule(new s(this), 1, TimeUnit.SECONDS);
    }

    public final com.bytedance.ee.bear.p<Bitmap> h() throws InterruptedException {
        if (this.f511367c != null) goto L6;
        NullPointerException r100 = new NullPointerException("mView is null!");
        int r101 = com.bytedance.ee.bear.p.f236228b;
        return com.bytedance.ee.bear.p.a.a(r100);
    L6:
        Bitmap r102 = null;
        int r103 = 0;
    L8:
        if (r103 >= 8) goto L25;
        r102 = jz4.p.a(this.f511366b, this.f511367c, this.f511373i, this.f511371g);
        if (r102 != null) goto L12;
    L15:
        StringBuilder r104 = new StringBuilder("tryGetBitmap bitmap: ");
        if (r102 == null) goto L18;
        boolean r105 = true;
    L19:
        r104.append(r105);
        tt5.a.h("ScreenshotV2", r104.toString());
        if (r102 == null) goto L24;
        if (r103 >= 7) goto L24;
        r102.recycle();
    L24:
        this.f511418n++;
        r103 = r103 + 1;
        goto L8
    L18:
        r105 = false;
        goto L19
    L12:
        if (FastPngEncoder.b(r102) == true) goto L15;
        return new com.bytedance.ee.bear.p(r102);
    L25:
        if (r102 != null) goto L28;
        tt5.a.d("ScreenshotV2", "tryGetBitmap failed: try count: 8, bitmap is null!");
        Throwable r106 = new Throwable("bitmap is null");
        int r107 = com.bytedance.ee.bear.p.f236228b;
        return com.bytedance.ee.bear.p.a.a(r106);
    L28:
        tt5.a.h("ScreenshotV2", "isBitmapAnyLineBlackOrWhite fail: true");
        return new com.bytedance.ee.bear.p(r102);
    }

    @Override // lz4.b
    public final void start() {
        if (this.f511367c != null) goto L5;
        return;
    L5:
        tt5.a.h("ScreenshotV2", "start()...");
        this.f511418n = 0;
        BearExecutors.f().execute(new q(this));
    }

    @Override // lz4.b
    public final void stop() {
        tt5.a.h("ScreenshotV2", "stop()...");
        c();
        e();
    }

    public final void g() {
        this.f511421q = BearExecutors.c().submit(new t(this));
        BearExecutors.e().schedule(new u(this), 1, TimeUnit.SECONDS);
    }

    public w(n r100) {
        super(r100);
        this.f511419o = 1.0f;
        this.f511420p = new ArrayBlockingQueue(5);
        this.f511423s = false;
        this.f511424t = false;
        this.f511425u = false;
        int r101 = this.f511372h;
        int r102 = this.f511373i;
        int r103 = r101 % r102;
        this.f511417m = r103;
        if (r103 == 0) goto L5;
        this.f511416l = (r101 / r102) + 1;
    L6:
        int r104 = this.f511367c.getResources().getDimensionPixelSize(R.dimen.dc_doc_shot_padding);
        int r105 = this.f511371g;
        this.f511419o = (r105 - (r104 * 2)) / r105;
        return;
    L5:
        this.f511416l = r101 / r102;
        goto L6
    }

    public final void b(Throwable r100) {
        BearExecutors.f().execute(new a(this, r100));
    }
}
