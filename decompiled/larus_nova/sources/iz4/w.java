package iz4;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bytedance.ee.bear.doc.screenshot.DocShotPresenter;
import com.bytedance.ee.bear.screenshot.FastPngEncoder;
import com.bytedance.ee.bear.thread.BearExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes16.dex */
public class w extends iz4.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f496679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f496680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f496681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f496682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BlockingQueue<b> f496683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Future<?> f496684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Future<?> f496685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile boolean f496686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f496687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f496688t;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f496689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w f496690b;

        public final void a() {
            this.f496690b.c();
            if (this.f496690b.f496686r == false) goto L6;
            tt5.a.d("ScreenshotV2", "onFailed has Release");
            return;
        L6:
            tt5.a.f("ScreenshotV2", this.f496689a, false);
            this.f496690b.e();
            hz4.a r100 = this.f496690b.f496633d;
            Throwable r101 = this.f496689a;
            if (r101 != null) goto L9;
            String r102 = "empty";
        L15:
            ((fz4.x) r100).a(r102, this.f496690b.f496681m);
            this.f496690b.f496681m = 0;
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
            this.f496690b = r100;
            this.f496689a = r101;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f496691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bitmap f496692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f496693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f496694d;

        public b() {
        }
    }

    public void c() {
    }

    public final void e() {
        this.f496686r = true;
        this.f496684p.cancel(true);
        this.f496685q.cancel(true);
    }

    public final void a() {
        if (this.f496687s == false) goto L5;
        return;
    L5:
        if (this.f496686r == true) goto L10;
        tt5.a.h("ScreenshotV2", "checkEncode mEncoding:" + this.f496687s);
        f();
        return;
    }

    public void d() {
        DocShotPresenter r100 = ((fz4.x) this.f496633d).f479384d;
        if (r100.f218090s == false) goto L6;
        DocShotPresenter.a(r100, false);
        return;
    }

    public final void f() {
        final boolean r100 = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("admin.watermark.filewatermark.remaining");
        tt5.a.h("ScreenshotV2", "startEncode(), isWatermarkRemainingEnable: " + r100);
        this.f496685q = BearExecutors.c().submit(new r(this, r100));
        BearExecutors.e().schedule(new s(this), 1, TimeUnit.SECONDS);
    }

    public final com.bytedance.ee.bear.p<Bitmap> h() throws InterruptedException {
        if (this.f496632c != null) goto L6;
        NullPointerException r100 = new NullPointerException("mView is null!");
        int r101 = com.bytedance.ee.bear.p.f236228b;
        return com.bytedance.ee.bear.p.a.a(r100);
    L6:
        Bitmap r102 = null;
        int r103 = 0;
    L8:
        if (r103 >= 8) goto L25;
        r102 = gz4.d.a(this.f496631b, this.f496632c, this.f496638i, this.f496636g);
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
        this.f496681m++;
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

    @Override // iz4.b
    public final void start() {
        if (this.f496632c != null) goto L5;
        return;
    L5:
        tt5.a.h("ScreenshotV2", "start()...");
        this.f496681m = 0;
        BearExecutors.f().execute(new q(this));
    }

    @Override // iz4.b
    public final void stop() {
        tt5.a.h("ScreenshotV2", "stop()...");
        c();
        e();
    }

    public final void g() {
        this.f496684p = BearExecutors.c().submit(new t(this));
        BearExecutors.e().schedule(new u(this), 1, TimeUnit.SECONDS);
    }

    public w(n r100) {
        super(r100);
        this.f496682n = 1.0f;
        this.f496683o = new ArrayBlockingQueue(5);
        this.f496686r = false;
        this.f496687s = false;
        this.f496688t = false;
        int r101 = this.f496637h;
        int r102 = this.f496638i;
        int r103 = r101 % r102;
        this.f496680l = r103;
        if (r103 == 0) goto L5;
        this.f496679k = (r101 / r102) + 1;
    L6:
        int r104 = this.f496632c.getResources().getDimensionPixelSize(R.dimen.doc_shot_padding);
        int r105 = this.f496636g;
        this.f496682n = (r105 - (r104 * 2)) / r105;
        return;
    L5:
        this.f496679k = r101 / r102;
        goto L6
    }

    public final void b(Throwable r100) {
        BearExecutors.f().execute(new a(this, r100));
    }
}
