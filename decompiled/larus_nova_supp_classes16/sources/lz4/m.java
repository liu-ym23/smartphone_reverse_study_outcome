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
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class m extends lz4.a implements Handler.Callback {
    public final PthreadHandlerThreadV2 l;
    public final Handler m;
    public int n;
    public int o;
    public Bitmap p;
    public float q;
    public Disposable r;

    public class a implements IAttachToBitmapCallback {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ m c;

        public final void onAttachSuccess(Bitmap r11) {
            MutableLiveData<Boolean> r0 = this.c.f;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getValue() != null) goto L7;
            return;
        L7:
            if (((Boolean) this.c.f.getValue()).booleanValue() == false) goto L33;
            m r1 = this.c;
            Bitmap r2 = r1.p;
            int r3 = this.a;
            int r4 = this.b;
            int r5 = r1.o;
            if (r2 == null) goto L24;
            if (r11 == null) goto L24;
            Canvas r6 = new Canvas(r2);     // Catch: Throwable -> L22
            Paint r7 = new Paint();     // Catch: Throwable -> L22
            int r8 = r11.getHeight() * r4;     // Catch: Throwable -> L22
            if (r4 != (r3 - 1)) goto L17;
            if (r5 <= 0) goto L17;
            Rect r9 = new Rect(0, r11.getHeight() - r5, r11.getWidth(), r11.getHeight());     // Catch: Throwable -> L22
            RectF r10 = new RectF(0.0f, r8, r11.getWidth(), r8 + r5);     // Catch: Throwable -> L22
        L18:
            r6.drawBitmap(r11, r9, r10, r7);     // Catch: Throwable -> L22
            if (r11.isRecycled() == true) goto L24;
            r11.recycle();     // Catch: Throwable -> L22
        L17:
            r9 = new Rect(0, 0, r11.getWidth(), r11.getHeight());     // Catch: Throwable -> L22
            r10 = new RectF(0.0f, r8, r11.getWidth(), r8 + r11.getHeight());     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            tt5.a.f("ScreenshotUtils", th, false);
        L24:
            final int r12 = this.b;
            final int r13 = this.a;
            if (r12 < (r13 - 1)) goto L27;
            this.c.m.obtainMessage(2, r13, r13).sendToTarget();
            return;
        L27:
            com.bytedance.ee.util.ui.j.f(new l(this, r12, r13));
            return;
        }

        public final void onAttachFailed(Bitmap r4, String r5) {
            this.c.b(new RuntimeException("addWatermark fail:" + r5));
        }

        public a(m r1, int r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public void d() {
    }

    public final void c() {
        if (this.o <= 0) goto L5;
        int r0 = this.n + 1;
    L6:
        this.q = ((this.g * 1.0f) - (this.a.getResources().getDimensionPixelSize(2131165757) * 2)) / this.g;
        Flowable.just(Integer.valueOf(r0)).observeOn(fo5.d.d()).map(new h(this)).subscribe(new i(), new j(this));
        return;
    L5:
        r0 = this.n;
        goto L6
    }

    public void e() {
        OfficeDocShotPresenter r0 = ((jz4.i) this.d).d;
        if (r0.a == false) goto L6;
        OfficeDocShotPresenter.a(r0, false);
        return;
    }

    @Override // lz4.b
    public final void start() {
        int r0 = this.h;
        int r1 = this.i;
        int r2 = r0 / r1;
        this.n = r2;
        this.o = r0 - (r2 * r1);
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        long r3 = ku5.c.d();
        long r4 = 50;
    L6:
        long r5 = (((this.g * this.h) * 2) / 1024) / 1024;
        tt5.a.h("Screenshot", "start() contentHeight = " + this.h + ", height = " + this.i + ", width = " + this.g + ", totalScrollCount = " + this.n + ", size = " + r5 + ", remindMemory = " + r3);
        if (r3 > 0) goto L9;
    L17:
        this.p = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.RGB_565);     // Catch: Throwable -> L14
        c();     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        tt5.a.f("Screenshot", th, false);
        b(th);
        return;
    L9:
        if (r5 < (r3 - r4)) goto L17;
        b(new Throwable("img too large, return failed, remind memory:" + r3));
        return;
    L5:
        r3 = ku5.c.f();
        r4 = 100;
        goto L6
    }

    @Override // lz4.b
    public final void stop() {
        tt5.a.h("Screenshot", "stop()...");
        d();
        Bitmap r0 = this.p;
        if (r0 != null) goto L5;
    L7:
        this.m.removeCallbacksAndMessages(null);
        this.l.quit();
        Disposable r1 = this.r;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isDisposed() == true) goto L14;
        this.r.dispose();
        return;
    L14:
        return;
    L5:
        if (r0.isRecycled() == true) goto L7;
        this.p.recycle();
        goto L7
    }

    public m(n r2) {
        super(r2);
        PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("snap-shot");
        this.l = r3;
        ThreadMethodProxy.start(r3);
        this.m = new Handler(r3.getLooper(), this);
    }

    public final void b(final Throwable r2) {
        com.bytedance.ee.util.ui.j.f(new c(this, r2));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        int r0 = r8.what;
        if (r0 != 1) goto L5;
        int r1 = r8.arg1;
        int r9 = r8.arg2;
        WebView r2 = this.c;
        if (r2 == null) goto L18;
        Bitmap r3 = jz4.p.a(this.b, r2, this.i, this.g);
        if (r3 != null) goto L20;
        b(new Throwable("drawing cache is null"));
        return false;
    L20:
        CCMWatermarkManager r4 = this.j;     // Catch: Exception -> L16
        boolean r5 = this.k;     // Catch: Exception -> L16
        WatermarkType r6 = WatermarkType.EXPORT;     // Catch: Exception -> L16
        a r7 = new a(this, r9, r1);     // Catch: Exception -> L16
        r4.getClass();     // Catch: Exception -> L16
        CCMWatermarkManager.a(r5, r3, r6, r7);     // Catch: Exception -> L16
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
        if (r0 != 2) goto L19;
        com.bytedance.ee.util.ui.j.f(new d(this));
        this.r = Flowable.just(Integer.valueOf(r8.arg1)).observeOn(fo5.d.a()).map(new e(this)).observeOn(fo5.d.d()).subscribe(new f(this), new g(this));
        goto L19
    }

    public final void a(final int r5, final int r6) {
        tt5.a.h("Screenshot", "captureCurrentPage()... index = " + r5 + ", count = " + r6);
        int r0 = (int) ((((float) (this.i * r5)) / this.c.getScale()) + 0.5f);
        JSONObject r1 = new JSONObject();
        r1.put("x", 0);
        r1.put("y", Integer.valueOf(r0));
        ap5.a.a(this.c, "window.scrollToXY", r1, new k(this, r5, r6));
    }
}
