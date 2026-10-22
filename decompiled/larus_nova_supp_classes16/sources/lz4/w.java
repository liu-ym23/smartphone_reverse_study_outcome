package lz4;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.screenshot.plugin.OfficeDocShotPresenter;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.screenshot.FastPngEncoder;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class w extends lz4.a {
    public final int l;
    public final int m;
    public int n;
    public final float o;
    public final BlockingQueue<b> p;
    public Future<?> q;
    public Future<?> r;
    public volatile boolean s;
    public volatile boolean t;
    public volatile boolean u;

    public class a implements Runnable {
        public final /* synthetic */ Throwable a;
        public final /* synthetic */ w b;

        public final void a() {
            this.b.c();
            if (this.b.s == false) goto L6;
            tt5.a.d("ScreenshotV2", "onFailed has Release");
            return;
        L6:
            tt5.a.f("ScreenshotV2", this.a, false);
            this.b.e();
            kz4.a r0 = this.b.d;
            Throwable r1 = this.a;
            if (r1 != null) goto L9;
            String r2 = CustomHeaderConfig.TitleConfig.TitleIcon.EMPTY;
        L15:
            ((jz4.i) r0).a(r2, this.b.n);
            this.b.n = 0;
            return;
        L9:
            String r3 = r1.getMessage();
            if (TextUtils.isEmpty(r3) == false) goto L14;
            r3 = r1.toString() + " ";
            StackTraceElement[] r4 = r1.getStackTrace();
            if (r4.length <= 0) goto L14;
            r2 = r3 + r4[0];
        L14:
            r2 = r3;
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

        public a(w r1, Throwable r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class b {
        public boolean a;
        public Bitmap b;
        public int c;
        public int d;

        public b() {
        }
    }

    public void c() {
    }

    public final void e() {
        this.s = true;
        this.q.cancel(true);
        this.r.cancel(true);
    }

    public final void a() {
        if (this.t == false) goto L5;
        return;
    L5:
        if (this.s == true) goto L10;
        tt5.a.h("ScreenshotV2", "checkEncode mEncoding:" + this.t);
        f();
        return;
    }

    public void d() {
        OfficeDocShotPresenter r0 = ((jz4.i) this.d).d;
        if (r0.a == false) goto L6;
        OfficeDocShotPresenter.a(r0, false);
        return;
    }

    public final void f() {
        final boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("admin.watermark.filewatermark.remaining");
        tt5.a.h("ScreenshotV2", "startEncode(), isWatermarkRemainingEnable: " + r0);
        this.r = BearExecutors.c().submit(new r(this, r0));
        BearExecutors.e().schedule(new s(this), 1, TimeUnit.SECONDS);
    }

    public final com.bytedance.ee.bear.p<Bitmap> h() throws InterruptedException {
        if (this.c != null) goto L6;
        NullPointerException r0 = new NullPointerException("mView is null!");
        int r1 = com.bytedance.ee.bear.p.b;
        return com.bytedance.ee.bear.p.a.a(r0);
    L6:
        Bitmap r2 = null;
        int r3 = 0;
    L8:
        if (r3 >= 8) goto L25;
        r2 = jz4.p.a(this.b, this.c, this.i, this.g);
        if (r2 != null) goto L12;
    L15:
        StringBuilder r4 = new StringBuilder("tryGetBitmap bitmap: ");
        if (r2 == null) goto L18;
        boolean r6 = true;
    L19:
        r4.append(r6);
        tt5.a.h("ScreenshotV2", r4.toString());
        if (r2 == null) goto L24;
        if (r3 >= 7) goto L24;
        r2.recycle();
    L24:
        this.n++;
        r3 = r3 + 1;
        goto L8
    L18:
        r6 = false;
        goto L19
    L12:
        if (FastPngEncoder.b(r2) == true) goto L15;
        return new com.bytedance.ee.bear.p(r2);
    L25:
        if (r2 != null) goto L28;
        tt5.a.d("ScreenshotV2", "tryGetBitmap failed: try count: 8, bitmap is null!");
        Throwable r5 = new Throwable("bitmap is null");
        int r7 = com.bytedance.ee.bear.p.b;
        return com.bytedance.ee.bear.p.a.a(r5);
    L28:
        tt5.a.h("ScreenshotV2", "isBitmapAnyLineBlackOrWhite fail: true");
        return new com.bytedance.ee.bear.p(r2);
    }

    @Override // lz4.b
    public final void start() {
        if (this.c != null) goto L5;
        return;
    L5:
        tt5.a.h("ScreenshotV2", "start()...");
        this.n = 0;
        BearExecutors.f().execute(new q(this));
    }

    @Override // lz4.b
    public final void stop() {
        tt5.a.h("ScreenshotV2", "stop()...");
        c();
        e();
    }

    public final void g() {
        this.q = BearExecutors.c().submit(new t(this));
        BearExecutors.e().schedule(new u(this), 1, TimeUnit.SECONDS);
    }

    public w(n r3) {
        super(r3);
        this.o = 1.0f;
        this.p = new ArrayBlockingQueue(5);
        this.s = false;
        this.t = false;
        this.u = false;
        int r4 = this.h;
        int r0 = this.i;
        int r1 = r4 % r0;
        this.m = r1;
        if (r1 == 0) goto L5;
        this.l = (r4 / r0) + 1;
    L6:
        int r5 = this.c.getResources().getDimensionPixelSize(2131165757);
        int r2 = this.g;
        this.o = (r2 - (r5 * 2)) / r2;
        return;
    L5:
        this.l = r4 / r0;
        goto L6
    }

    public final void b(Throwable r3) {
        BearExecutors.f().execute(new a(this, r3));
    }
}
