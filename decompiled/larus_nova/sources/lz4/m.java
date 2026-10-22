package lz4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.webkit.WebView;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.doc.screenshot.plugin.OfficeDocShotPresenter;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.larus.nova.R;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes16.dex */
public class m extends lz4.a implements Handler.Callback {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f511390l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f511391m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f511392n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f511393o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap f511394p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f511395q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f511396r;

    public class a implements IAttachToBitmapCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f511397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f511398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f511399c;

        @Override // com.ss.android.lark.watermark.core.IAttachToBitmapCallback
        public final void onAttachSuccess(Bitmap r110) {
            MutableLiveData<Boolean> r100 = this.f511399c.f511370f;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.getValue() != null) goto L7;
            return;
        L7:
            if (this.f511399c.f511370f.getValue().booleanValue() == false) goto L33;
            m r101 = this.f511399c;
            Bitmap r102 = r101.f511394p;
            int r103 = this.f511397a;
            int r104 = this.f511398b;
            int r105 = r101.f511393o;
            if (r102 == null) goto L24;
            if (r110 == null) goto L24;
            Canvas r106 = new Canvas(r102);     // Catch: Throwable -> L22
            Paint r107 = new Paint();     // Catch: Throwable -> L22
            int r108 = r110.getHeight() * r104;     // Catch: Throwable -> L22
            if (r104 != (r103 - 1)) goto L17;
            if (r105 <= 0) goto L17;
            Rect r109 = new Rect(0, r110.getHeight() - r105, r110.getWidth(), r110.getHeight());     // Catch: Throwable -> L22
            RectF r111 = new RectF(0.0f, r108, r110.getWidth(), r108 + r105);     // Catch: Throwable -> L22
        L18:
            r106.drawBitmap(r110, r109, r111, r107);     // Catch: Throwable -> L22
            if (r110.isRecycled() == true) goto L24;
            r110.recycle();     // Catch: Throwable -> L22
        L17:
            r109 = new Rect(0, 0, r110.getWidth(), r110.getHeight());     // Catch: Throwable -> L22
            r111 = new RectF(0.0f, r108, r110.getWidth(), r108 + r110.getHeight());     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            tt5.a.f("ScreenshotUtils", th, false);
        L24:
            final int r112 = this.f511398b;
            final int r113 = this.f511397a;
            if (r112 < (r113 - 1)) goto L27;
            this.f511399c.f511391m.obtainMessage(2, r113, r113).sendToTarget();
            return;
        L27:
            com.bytedance.ee.util.ui.j.f(new l(this, r112, r113));
            return;
        }

        @Override // com.ss.android.lark.watermark.core.IAttachToBitmapCallback
        public final void onAttachFailed(Bitmap r100, String r101) {
            this.f511399c.b(new RuntimeException("addWatermark fail:" + r101));
        }

        public a(m r100, int r101, int r102) {
            this.f511399c = r100;
            this.f511397a = r101;
            this.f511398b = r102;
        }
    }

    public void d() {
    }

    public final void c() {
        if (this.f511393o <= 0) goto L5;
        int r100 = this.f511392n + 1;
    L6:
        this.f511395q = ((this.f511371g * 1.0f) - (this.f511365a.getResources().getDimensionPixelSize(R.dimen.dc_doc_shot_padding) * 2)) / this.f511371g;
        Flowable.just(Integer.valueOf(r100)).observeOn(fo5.d.d()).map(new h(this)).subscribe(new i(), new j(this));
        return;
    L5:
        r100 = this.f511392n;
        goto L6
    }

    public void e() {
        OfficeDocShotPresenter r100 = ((jz4.i) this.f511368d).f501194d;
        if (r100.f218119a == false) goto L6;
        OfficeDocShotPresenter.a(r100, false);
        return;
    }

    @Override // lz4.b
    public final void start() {
        int r100 = this.f511372h;
        int r101 = this.f511373i;
        int r102 = r100 / r101;
        this.f511392n = r102;
        this.f511393o = r100 - (r102 * r101);
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        long r103 = ku5.c.d();
        long r104 = 50;
    L6:
        long r105 = (((this.f511371g * this.f511372h) * 2) / 1024) / 1024;
        tt5.a.h("Screenshot", "start() contentHeight = " + this.f511372h + ", height = " + this.f511373i + ", width = " + this.f511371g + ", totalScrollCount = " + this.f511392n + ", size = " + r105 + ", remindMemory = " + r103);
        if (r103 > 0) goto L9;
    L17:
        this.f511394p = Bitmap.createBitmap(this.f511371g, this.f511372h, Bitmap.Config.RGB_565);     // Catch: Throwable -> L14
        c();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        tt5.a.f("Screenshot", th, false);
        b(th);
        return;
    L9:
        if (r105 < (r103 - r104)) goto L17;
        b(new Throwable("img too large, return failed, remind memory:" + r103));
        return;
    L5:
        r103 = ku5.c.f();
        r104 = 100;
        goto L6
    }

    @Override // lz4.b
    public final void stop() {
        tt5.a.h("Screenshot", "stop()...");
        d();
        Bitmap r100 = this.f511394p;
        if (r100 != null) goto L5;
    L7:
        this.f511391m.removeCallbacksAndMessages(null);
        this.f511390l.quit();
        Disposable r101 = this.f511396r;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isDisposed() == true) goto L14;
        this.f511396r.dispose();
        return;
    L14:
        return;
    L5:
        if (r100.isRecycled() == true) goto L7;
        this.f511394p.recycle();
        goto L7
    }

    public m(n r100) {
        super(r100);
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("snap-shot");
        this.f511390l = r101;
        ThreadMethodProxy.start(r101);
        this.f511391m = new Handler(r101.getLooper(), this);
    }

    public final void b(final Throwable r100) {
        com.bytedance.ee.util.ui.j.f(new c(this, r100));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        int r101 = r100.what;
        if (r101 != 1) goto L5;
        int r102 = r100.arg1;
        int r103 = r100.arg2;
        WebView r104 = this.f511367c;
        if (r104 == null) goto L18;
        Bitmap r105 = jz4.p.a(this.f511366b, r104, this.f511373i, this.f511371g);
        if (r105 != null) goto L20;
        b(new Throwable("drawing cache is null"));
        return false;
    L20:
        CCMWatermarkManager r106 = this.f511374j;     // Catch: Exception -> L16
        boolean r107 = this.f511375k;     // Catch: Exception -> L16
        WatermarkType r108 = WatermarkType.EXPORT;     // Catch: Exception -> L16
        a r109 = new a(this, r103, r102);     // Catch: Exception -> L16
        r106.getClass();     // Catch: Exception -> L16
        CCMWatermarkManager.a(r107, r105, r108, r109);     // Catch: Exception -> L16
    L19:
        return false;
    L16:
        e = move-exception;
        tt5.a.d("Screenshot", "addDocWatermarkBlockingWithCallback failed: " + e);
        b(new RuntimeException("addWatermark exception fail: " + e.getMessage()));
        goto L19
    L18:
        b(new IllegalStateException("web view null"));
        goto L19
    L5:
        if (r101 != 2) goto L19;
        com.bytedance.ee.util.ui.j.f(new d(this));
        this.f511396r = Flowable.just(Integer.valueOf(r100.arg1)).observeOn(fo5.d.a()).map(new e(this)).observeOn(fo5.d.d()).subscribe(new f(this), new g(this));
        goto L19
    }

    public final void a(final int r100, final int r101) {
        tt5.a.h("Screenshot", "captureCurrentPage()... index = " + r100 + ", count = " + r101);
        int r102 = (int) ((((float) (this.f511373i * r100)) / this.f511367c.getScale()) + 0.5f);
        JSONObject r103 = new JSONObject();
        r103.put2("x", 0);
        r103.put2("y", Integer.valueOf(r102));
        ap5.a.a(this.f511367c, "window.scrollToXY", r103, new k(this, r100, r101));
    }
}
