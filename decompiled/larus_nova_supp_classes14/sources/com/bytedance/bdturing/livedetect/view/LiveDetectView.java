package com.bytedance.bdturing.livedetect.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.live.TuringLive;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.bdturing.livedetect.camera.ImageUtil;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import vb4.s;
import wb4.e;
import wb4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LiveDetectView extends FrameLayout implements TextureView.SurfaceTextureListener, wb4.a, LiveDetectMaskView.b {
    public AutoFixTextureView a;
    public i b;
    public Handler c;
    public final AtomicInteger d;
    public final float e;
    public c f;
    public LiveDetectMaskView g;
    public DetectDebugView h;
    public b i;
    public LiveDetectMaskView.b j;
    public List<com.bytedance.bdturing.livedetect.pty.a> k;
    public JSONArray l;
    public String m;
    public boolean n;
    public JSONObject o;
    public vb4.b p;
    public long q;

    public class a implements Runnable {
        public final /* synthetic */ LiveDetectView a;

        @Override // java.lang.Runnable
        public final void run() {
            c r0 = this.a.f;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LiveDetectView r1, int r2) {
            this.a = r1;
        }
    }

    public class b extends CountDownTimer {
        public final /* synthetic */ long a;
        public final /* synthetic */ LiveDetectView b;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r0 = this.b.f;
            if (r0 == null) goto L6;
            s r1 = (s) r0;
            TuringLiveDetectActivity r2 = r1.a;
            int r3 = TuringLiveDetectActivity.y;
            r2.P1();
            long r4 = System.currentTimeMillis();
            TuringLiveDetectActivity r5 = r1.a;
            EventReport.b(false, r4 - r5.s, "timeOut", r5.v);
            TuringLiveDetectActivity.F1(r1.a, null);
            return;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r3) {
            if (((int) (r3 / 1000)) != (((int) (this.a * 0.4f)) / ECDraweeView.SQUARE)) goto L10;
            LiveDetectMaskView r4 = this.b.g;
            int r5 = r4.n;
            Paint r0 = r4.c;
            if (r0 != null) goto L7;
            return;
        L7:
            if (r0.getColor() == r5) goto L12;
            r4.c.setColor(r5);
            r4.postInvalidate();
            return;
        L12:
            return;
        }

        public b(LiveDetectView r1, long r2, long r4) {
            this.b = r1;
            this.a = r4;
            super(r2, 1000);
        }
    }

    public interface c {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r1) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    public final void f() {
        b r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        i();
        this.f = null;
        i r1 = this.b;
        if (r1 == null) goto L11;
        r1.g();
        r1.a = null;
        r1.c = null;
        wb4.b r2 = r1.k;
        if (r2 == null) goto L10;
        r2.c();
        r1.k = null;
    L10:
        r1.l = null;
        e.b().a();
        this.b = null;
    L11:
        Handler r3 = this.c;
        if (r3 == null) goto L14;
        r3.removeCallbacksAndMessages(null);
        this.c = null;
    L14:
        g();
        TuringPTYManager r4 = TuringPTYManager.b();
        r4.e.set(false);
        r4.f.set(false);
        r4.c = null;
    }

    public final void g() {
        List<com.bytedance.bdturing.livedetect.pty.a> r0 = this.k;     // Catch: Exception -> L8
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() <= 0) goto L14;
        EventReport.B(this.k, this.n, this.o, LiveDetectService.getInstance().getRequest());     // Catch: Exception -> L8
        this.k = null;     // Catch: Exception -> L8
        this.o = null;     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public final void i() {
        if (this.d.get() == 2) goto L5;
        return;
    L5:
        this.d.set(3);
        ValueAnimator r0 = this.g.j;
        if (r0 == null) goto L8;
        r0.cancel();
    L8:
        b r1 = this.i;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        d(this.d.get());
        this.b.g();
        g();
        JSONArray r2 = this.l;     // Catch: Exception -> L18
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.length() <= 0) goto L24;
        EventReport.p(30003, this.l.toString(), LiveDetectService.getInstance().getRequest());     // Catch: Exception -> L18
        this.l = null;     // Catch: Exception -> L18
        return;
    L24:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public final void h() {
        AtomicBoolean r0 = TuringPTYManager.b().d;
        if (r0 == null) goto L5;
        boolean r1 = r0.get();
    L6:
        this.n = r1;
        if (this.d.get() != 2) goto L10;
        return;
    L10:
        if (this.a.isAvailable() == true) goto L13;
        this.d.set(1);
        return;
    L13:
        b r2 = this.i;
        if (r2 == null) goto L16;
        r2.start();
    L16:
        this.g.a();
        LiveDetectMaskView r3 = this.g;
        int r4 = r3.m;
        Paint r5 = r3.c;
        if (r5 != null) goto L19;
    L21:
        this.d.set(2);
        d(this.d.get());
        this.k = new ArrayList();
        this.b.f();
        return;
    L19:
        if (r5.getColor() == r4) goto L21;
        r3.c.setColor(r4);
        r3.postInvalidate();
        goto L21
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public LiveDetectView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.b
    public final void a(Rect r2) {
        LiveDetectMaskView.b r0 = this.j;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    public final void d(int r3) {
        if (this.f != null) goto L5;
        return;
    L5:
        int r0 = 2;
        if (r3 != 2) goto L8;
        r0 = 1;
    L11:
        this.c.post(new a(this, r0));
        return;
    L8:
        if (r3 == 3) goto L11;
        r0 = 0;
        goto L11
    }

    public void setBoxStateListener(LiveDetectMaskView.b r1) {
        this.j = r1;
    }

    public void setDebugInfoCallBack(vb4.b r1) {
        this.p = r1;
    }

    public void setDetectResult(boolean r3) {
        LiveDetectMaskView r0 = this.g;
        if (r3 == false) goto L5;
        int r4 = 3;
    L7:
        if (r0.r == r4) goto L11;
        r0.r = r4;
        r0.postInvalidate();
        return;
    L11:
        return;
    L5:
        r4 = 0;
        goto L7
    }

    public void setDetectStateCallBack(c r1) {
        this.f = r1;
    }

    public void setDetectTimeOut(long r10) {
        if (r10 > 0) goto L5;
        return;
    L5:
        this.i = new b(this, r10, r10);
    }

    public LiveDetectView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public final void e(final ImageDataWrapper r17, final JSONObject r18) {
        ArrayList<Float> r3 = null;
        if (LiveDetectService.getInstance().useByteNN() == false) goto L42;
        long r6 = System.currentTimeMillis();
        if (r17.bitmap.getWidth() == 480) goto L7;
    L8:
        Bitmap r1 = r17.bitmap;
        r17.bitmap = ImageUtil.scaleBitmapCropCenter(r1, 480, 640);
        if (r1.isRecycled() == true) goto L11;
        r1.recycle();
    L11:
        byte[] r2 = ImageUtil.convertBitmapToRgbBytes(r17.bitmap);
        LiveDetectMaskView r9 = this.g;
        if (r9 == null) goto L14;
        ArrayList<Float> r10 = r9.getBoxRectInfo();
    L15:
        if (r10 != null) goto L17;
        return;
    L17:
        if (r10.size() != 4) goto L67;
        boolean r13 = false;
        String r4 = TuringLive.getInstance().detectImg(r2, new float[]{((Float) ListProtector.get(r10, 0)).floatValue(), ((Float) ListProtector.get(r10, 1)).floatValue(), ((Float) ListProtector.get(r10, 2)).floatValue(), ((Float) ListProtector.get(r10, 3)).floatValue()});
        if (TextUtils.isEmpty(r4) == true) goto L68;
        com.bytedance.bdturing.livedetect.pty.a r5 = new com.bytedance.bdturing.livedetect.pty.a();
        r5.d = r18.optLong("convert_camera_data_time_use");
        JSONObject r7 = new JSONObject(r4);     // Catch: Exception -> L39
        this.o = r7;     // Catch: Exception -> L39
        com.bytedance.bdturing.livedetect.pty.c r8 = com.bytedance.bdturing.livedetect.pty.b.a(r7, r10);     // Catch: Exception -> L39
        long r14 = System.currentTimeMillis();     // Catch: Exception -> L39
        this.o.put("ts", r14);     // Catch: Exception -> L39
        r8.d = r17;     // Catch: Exception -> L39
        r5.b = r14;     // Catch: Exception -> L39
        r5.a = r8.e;     // Catch: Exception -> L39
        r5.c = System.currentTimeMillis() - r6;     // Catch: Exception -> L39
        r5.e = r8.f;     // Catch: Exception -> L39
        if (this.f == null) goto L28;
        Handler r0 = this.c;     // Catch: Exception -> L39
        if (r0 == null) goto L28;
        r0.post(new com.bytedance.bdturing.livedetect.view.c(this, r8));     // Catch: Exception -> L39
    L28:
        BdTuringConfig r11 = qb4.b.c.a.a;     // Catch: Exception -> L39
        if (r11 == null) goto L31;
        r13 = r11.isLiveDebugMode();     // Catch: Exception -> L39
    L31:
        if (r13 == false) goto L33;
        hc4.d.b(r18, "pty_time_use", Long.valueOf(System.currentTimeMillis() - r6));     // Catch: Exception -> L39
        hc4.d.b(r18, "status", Integer.valueOf(r8.e));     // Catch: Exception -> L39
        hc4.d.b(r18, "debugInfo", r8.f);     // Catch: Exception -> L39
        this.c.post(new com.bytedance.bdturing.livedetect.view.a(this, r8));     // Catch: Exception -> L39
        c(true, null, null, r18);     // Catch: Exception -> L39
    L33:
        List<com.bytedance.bdturing.livedetect.pty.a> r12 = this.k;     // Catch: Exception -> L39
        if (r12 != null) goto L36;
        return;
    L36:
        if (((ArrayList) r12).size() >= 200) goto L63;
        ((ArrayList) this.k).add(r5);     // Catch: Exception -> L39
        return;
    L63:
        return;
    L39:
        e = move-exception;
        e.printStackTrace();
        return;
    L68:
        return;
    L67:
        return;
    L14:
        r10 = null;
        goto L15
    L7:
        if (r17.bitmap.getHeight() == 640) goto L11;
    L42:
        if (this.d.get() != 2) goto L70;
        final CountDownLatch r15 = new CountDownLatch(1);
        LiveDetectMaskView r16 = this.g;
        if (r16 == null) goto L47;
        r3 = r16.getBoxRectInfo();
    L47:
        final ArrayList<Float> r19 = r3;
        final long r20 = System.currentTimeMillis();
        Bitmap r110 = r17.bitmap;
        final com.bytedance.bdturing.livedetect.pty.a r111 = new com.bytedance.bdturing.livedetect.pty.a();
        r111.d = r18.optLong("convert_camera_data_time_use");
        TuringPTYManager.b().c(r110, r19, new AnonymousClass2(this, r19, r17, r111, r20, r18, r15));
        r15.await();     // Catch: Exception -> L54
        List<com.bytedance.bdturing.livedetect.pty.a> r21 = this.k;     // Catch: Exception -> L54
        if (r21 != null) goto L51;
        return;
    L51:
        if (((ArrayList) r21).size() >= 200) goto L66;
        ((ArrayList) this.k).add(r111);     // Catch: Exception -> L54
        return;
    L66:
        return;
    L54:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        int r4 = View.MeasureSpec.getSize(r2);
        if (r4 <= 720) goto L5;
        r4 = 720;
    L5:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r4, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((r4 * 1.0f) / this.e), 1073741824));
    }

    public LiveDetectView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        boolean r0 = false;
        this.d = new AtomicInteger(0);
        this.f = null;
        this.k = new ArrayList();
        this.p = null;
        this.q = 0;
        LayoutInflater.from(r4).inflate(2131568063, this, true);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130975143});
        this.e = r7.getFloat(0, 0.0f);
        r7.recycle();
        this.a = (AutoFixTextureView) findViewById(2131389972);
        i r8 = new i((Activity) getContext(), this.a);
        this.b = r8;
        r8.l = this;
        this.a.setSurfaceTextureListener(this);
        this.c = new Handler();
        this.g = (LiveDetectMaskView) findViewById(2131389971);
        this.h = (DetectDebugView) findViewById(2131389970);
        this.g.setBoxStateListener(this);
        LiveDetectMaskView r9 = this.g;
        BdTuringConfig r10 = qb4.b.c.a.a;
        if (r10 == null) goto L5;
        r0 = r10.isLiveDebugMode();
    L5:
        r9.setDebugMode(r0);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
        if (1 != this.d.get()) goto L6;
        h();
        return;
    }

    public final void c(boolean r9, PTYError r10, PTYTaskData r11, JSONObject r12) {
        int r0 = -1;
        if (r12 == null) goto L5;
        r0 = r12.optInt("status", -1);
    L5:
        if (r0 != 0) goto L7;
    L9:
        this.q = System.currentTimeMillis();
        Handler r1 = this.c;
        if (r1 == null) goto L13;
        r1.post(new d(this, r9, r10, r11, r12));
        return;
    L13:
        return;
    L7:
        if ((System.currentTimeMillis() - this.q) >= 100) goto L9;
    }

    public static void b(LiveDetectView r4, boolean r5, PTYError r6, PTYTaskData r7, PTYPackageInfo r8) {
        r4.getClass();
        if (r5 == false) goto L45;
        if (r6 != null) goto L45;
        return;
    L45:
        JSONArray r0 = r4.l;     // Catch: Exception -> L42
        if (r0 != null) goto L9;
    L11:
        String r1 = "";
        if (r6 == null) goto L14;
        String r9 = r6.toString();     // Catch: Exception -> L42
    L15:
        String r2 = r4.m;     // Catch: Exception -> L42
        if (r2 != null) goto L18;
    L20:
        r4.m = r9;     // Catch: Exception -> L42
        if (r4.l != null) goto L23;
        r4.l = new JSONArray();     // Catch: Exception -> L42
    L23:
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L42
        r3.put("success", r5);     // Catch: Exception -> L42
        if (r9.length() <= 1024) goto L26;
        r9 = r9.substring(0, 1024);     // Catch: Exception -> L42
    L26:
        r3.put("ptyError", r9);     // Catch: Exception -> L42
        if (r7 != null) goto L29;
    L33:
        String r10 = "";
    L34:
        r3.put("outputData", r10);     // Catch: Exception -> L42
        if (r8 == null) goto L40;
        String r11 = r8.toString();     // Catch: Exception -> L42
        if (r11.length() <= 1024) goto L39;
        r11 = r11.substring(0, 1024);     // Catch: Exception -> L42
    L39:
        r1 = r11;
    L40:
        r3.put("ptyPackageInfo", r1);     // Catch: Exception -> L42
        r4.l.put(r3);     // Catch: Exception -> L42
        return;
    L29:
        if (r7.getParams() == null) goto L33;
        r10 = r7.getParams().toString();     // Catch: Exception -> L42
        if (r10.length() <= 1024) goto L34;
        r10 = r10.substring(0, 1024);     // Catch: Exception -> L42
        goto L34
    L18:
        if (r2.equals(r9) == false) goto L20;
        return;
    L14:
        r9 = "";
        goto L15
    L9:
        if (r0.length() <= 30) goto L11;
        return;
    L42:
        e = move-exception;
        e.printStackTrace();
    }
}
