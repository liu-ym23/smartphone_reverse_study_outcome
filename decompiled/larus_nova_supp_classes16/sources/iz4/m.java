package iz4;

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
import com.bytedance.ee.bear.doc.screenshot.DocShotPresenter;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class m extends iz4.a implements Handler.Callback {
    public final PthreadHandlerThreadV2 k;
    public final Handler l;
    public int m;
    public int n;
    public Bitmap o;
    public float p;
    public Disposable q;

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
            Bitmap r2 = r1.o;
            int r3 = this.a;
            int r4 = this.b;
            int r5 = r1.n;
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
            this.c.l.obtainMessage(2, r13, r13).sendToTarget();
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
        if (this.n <= 0) goto L5;
        int r0 = this.m + 1;
    L6:
        this.p = ((this.g * 1.0f) - (this.a.getResources().getDimensionPixelSize(2131165834) * 2)) / this.g;
        Flowable.just(Integer.valueOf(r0)).observeOn(fo5.d.d()).map(new c(this)).subscribe(new d(), new e(this));
        return;
    L5:
        r0 = this.m;
        goto L6
    }

    public void e() {
        DocShotPresenter r0 = ((fz4.x) this.d).d;
        if (r0.s == false) goto L6;
        DocShotPresenter.a(r0, false);
        return;
    }

    @Override // iz4.b
    public final void start() {
        int r0 = this.h;
        int r1 = this.i;
        int r2 = r0 / r1;
        this.m = r2;
        this.n = r0 - (r2 * r1);
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        long r3 = ku5.c.d();
        long r4 = 50;
    L6:
        long r5 = (((this.g * this.h) * 2) / 1024) / 1024;
        tt5.a.h("Screenshot", "start() contentHeight = " + this.h + ", height = " + this.i + ", width = " + this.g + ", totalScrollCount = " + this.m + ", size = " + r5 + ", remindMemory = " + r3);
        if (r3 > 0) goto L9;
    L17:
        this.o = Bitmap.createBitmap(this.g, this.h, Bitmap.Config.RGB_565);     // Catch: Throwable -> L14
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

    @Override // iz4.b
    public final void stop() {
        tt5.a.h("Screenshot", "stop()...");
        d();
        Bitmap r0 = this.o;
        if (r0 != null) goto L5;
    L7:
        this.l.removeCallbacksAndMessages(null);
        this.k.quit();
        Disposable r1 = this.q;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isDisposed() == true) goto L14;
        this.q.dispose();
        return;
    L14:
        return;
    L5:
        if (r0.isRecycled() == true) goto L7;
        this.o.recycle();
        goto L7
    }

    public m(n r2) {
        super(r2);
        PthreadHandlerThreadV2 r3 = new PthreadHandlerThreadV2("snap-shot");
        this.k = r3;
        ThreadMethodProxy.start(r3);
        this.l = new Handler(r3.getLooper(), this);
    }

    public final void b(final Throwable r2) {
        com.bytedance.ee.util.ui.j.f(new f(this, r2));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        int r0 = r8.what;
        if (r0 != 1) goto L5;
        int r1 = r8.arg1;
        int r9 = r8.arg2;
        WebView r2 = this.c;
        if (r2 == null) goto L18;
        Bitmap r3 = gz4.d.a(this.b, r2, this.i, this.g);
        if (r3 != null) goto L20;
        b(new Throwable("drawing cache is null"));
        return false;
    L20:
        boolean r4 = wo5.c.a("admin.security.watermark.file.switch");     // Catch: Exception -> L16
        CCMWatermarkManager r5 = this.j;     // Catch: Exception -> L16
        WatermarkType r6 = WatermarkType.EXPORT;     // Catch: Exception -> L16
        a r7 = new a(this, r9, r1);     // Catch: Exception -> L16
        r5.getClass();     // Catch: Exception -> L16
        CCMWatermarkManager.a(r4, r3, r6, r7);     // Catch: Exception -> L16
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
        com.bytedance.ee.util.ui.j.f(new g(this));
        this.q = Flowable.just(Integer.valueOf(r8.arg1)).observeOn(fo5.d.a()).map(new h(this)).observeOn(fo5.d.d()).subscribe(new i(this), new j(this));
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
