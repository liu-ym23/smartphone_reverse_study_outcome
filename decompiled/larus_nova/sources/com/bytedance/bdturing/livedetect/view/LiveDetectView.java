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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes14.dex */
public class LiveDetectView extends FrameLayout implements TextureView.SurfaceTextureListener, wb4.a, LiveDetectMaskView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AutoFixTextureView f201966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f201967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f201968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f201969d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f201970e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f201971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveDetectMaskView f201972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DetectDebugView f201973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f201974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveDetectMaskView.b f201975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<com.bytedance.bdturing.livedetect.pty.a> f201976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONArray f201977l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f201978m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f201979n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f201980o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public vb4.b f201981p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f201982q;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDetectView f201983a;

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f201983a.f201971f;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LiveDetectView r100, int r101) {
            this.f201983a = r100;
        }
    }

    public class b extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f201984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveDetectView f201985b;

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            c r100 = this.f201985b.f201971f;
            if (r100 == null) goto L6;
            s r101 = (s) r100;
            TuringLiveDetectActivity r102 = r101.f554046a;
            int r103 = TuringLiveDetectActivity.f201828y;
            r102.P1();
            long r104 = System.currentTimeMillis();
            TuringLiveDetectActivity r105 = r101.f554046a;
            EventReport.b(false, r104 - r105.f201844s, "timeOut", r105.f201847v);
            TuringLiveDetectActivity.F1(r101.f554046a, null);
            return;
        }

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
            if (((int) (r100 / 1000)) != (((int) (this.f201984a * 0.4f)) / 1000)) goto L10;
            LiveDetectMaskView r101 = this.f201985b.f201972g;
            int r102 = r101.f201954n;
            Paint r103 = r101.f201943c;
            if (r103 != null) goto L7;
            return;
        L7:
            if (r103.getColor() == r102) goto L12;
            r101.f201943c.setColor(r102);
            r101.postInvalidate();
            return;
        L12:
            return;
        }

        public b(LiveDetectView r100, long r101, long r102) {
            this.f201985b = r100;
            this.f201984a = r102;
            super(r101, 1000);
        }
    }

    public interface c {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    public final void f() {
        b r100 = this.f201974i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        i();
        this.f201971f = null;
        i r101 = this.f201967b;
        if (r101 == null) goto L11;
        r101.g();
        r101.f558957a = null;
        r101.f558959c = null;
        wb4.b r102 = r101.f558967k;
        if (r102 == null) goto L10;
        r102.c();
        r101.f558967k = null;
    L10:
        r101.f558968l = null;
        e.b().a();
        this.f201967b = null;
    L11:
        Handler r103 = this.f201968c;
        if (r103 == null) goto L14;
        r103.removeCallbacksAndMessages(null);
        this.f201968c = null;
    L14:
        g();
        TuringPTYManager r104 = TuringPTYManager.b();
        r104.f201913e.set(false);
        r104.f201914f.set(false);
        r104.f201911c = null;
    }

    public final void g() {
        List<com.bytedance.bdturing.livedetect.pty.a> r100 = this.f201976k;     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L14;
        EventReport.B(this.f201976k, this.f201979n, this.f201980o, LiveDetectService.getInstance().getRequest());     // Catch: Exception -> L8
        this.f201976k = null;     // Catch: Exception -> L8
        this.f201980o = null;     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    public final void i() {
        if (this.f201969d.get() == 2) goto L5;
        return;
    L5:
        this.f201969d.set(3);
        ValueAnimator r100 = this.f201972g.f201950j;
        if (r100 == null) goto L8;
        r100.cancel();
    L8:
        b r101 = this.f201974i;
        if (r101 == null) goto L11;
        r101.cancel();
    L11:
        d(this.f201969d.get());
        this.f201967b.g();
        g();
        JSONArray r102 = this.f201977l;     // Catch: Exception -> L18
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.length() <= 0) goto L24;
        EventReport.p(30003, this.f201977l.toString(), LiveDetectService.getInstance().getRequest());     // Catch: Exception -> L18
        this.f201977l = null;     // Catch: Exception -> L18
        return;
    L24:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public final void h() {
        AtomicBoolean r100 = TuringPTYManager.b().f201912d;
        if (r100 == null) goto L5;
        boolean r101 = r100.get();
    L6:
        this.f201979n = r101;
        if (this.f201969d.get() != 2) goto L10;
        return;
    L10:
        if (this.f201966a.isAvailable() == true) goto L13;
        this.f201969d.set(1);
        return;
    L13:
        b r102 = this.f201974i;
        if (r102 == null) goto L16;
        r102.start();
    L16:
        this.f201972g.a();
        LiveDetectMaskView r103 = this.f201972g;
        int r104 = r103.f201953m;
        Paint r105 = r103.f201943c;
        if (r105 != null) goto L19;
    L21:
        this.f201969d.set(2);
        d(this.f201969d.get());
        this.f201976k = new ArrayList();
        this.f201967b.f();
        return;
    L19:
        if (r105.getColor() == r104) goto L21;
        r103.f201943c.setColor(r104);
        r103.postInvalidate();
        goto L21
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public LiveDetectView(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.bdturing.livedetect.view.LiveDetectMaskView.b
    public final void a(Rect r100) {
        LiveDetectMaskView.b r101 = this.f201975j;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public final void d(int r100) {
        if (this.f201971f != null) goto L5;
        return;
    L5:
        int r101 = 2;
        if (r100 != 2) goto L8;
        r101 = 1;
    L11:
        this.f201968c.post(new a(this, r101));
        return;
    L8:
        if (r100 == 3) goto L11;
        r101 = 0;
        goto L11
    }

    public void setBoxStateListener(LiveDetectMaskView.b r100) {
        this.f201975j = r100;
    }

    public void setDebugInfoCallBack(vb4.b r100) {
        this.f201981p = r100;
    }

    public void setDetectResult(boolean r100) {
        LiveDetectMaskView r101 = this.f201972g;
        if (r100 == false) goto L5;
        int r102 = 3;
    L7:
        if (r101.f201958r == r102) goto L11;
        r101.f201958r = r102;
        r101.postInvalidate();
        return;
    L11:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    public void setDetectStateCallBack(c r100) {
        this.f201971f = r100;
    }

    public void setDetectTimeOut(long r110) {
        if (r110 > 0) goto L5;
        return;
    L5:
        this.f201974i = new b(this, r110, r110);
    }

    public LiveDetectView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void e(final ImageDataWrapper r110, final JSONObject r111) {
        ArrayList<Float> r100 = null;
        if (LiveDetectService.getInstance().useByteNN() == false) goto L42;
        long r101 = System.currentTimeMillis();
        if (r110.bitmap.getWidth() == 480) goto L7;
    L8:
        Bitmap r102 = r110.bitmap;
        r110.bitmap = ImageUtil.scaleBitmapCropCenter(r102, 480, 640);
        if (r102.isRecycled() == true) goto L11;
        r102.recycle();
    L11:
        byte[] r103 = ImageUtil.convertBitmapToRgbBytes(r110.bitmap);
        LiveDetectMaskView r104 = this.f201972g;
        if (r104 == null) goto L14;
        ArrayList<Float> r105 = r104.getBoxRectInfo();
    L15:
        if (r105 != null) goto L17;
        return;
    L17:
        if (r105.size() != 4) goto L67;
        boolean r112 = false;
        String r106 = TuringLive.getInstance().detectImg(r103, new float[]{((Float) ListProtector.get(r105, 0)).floatValue(), ((Float) ListProtector.get(r105, 1)).floatValue(), ((Float) ListProtector.get(r105, 2)).floatValue(), ((Float) ListProtector.get(r105, 3)).floatValue()});
        if (TextUtils.isEmpty(r106) == true) goto L68;
        com.bytedance.bdturing.livedetect.pty.a r107 = new com.bytedance.bdturing.livedetect.pty.a();
        r107.f201921d = r111.optLong("convert_camera_data_time_use");
        JSONObject r108 = new JSONObject(r106);     // Catch: Exception -> L39
        this.f201980o = r108;     // Catch: Exception -> L39
        com.bytedance.bdturing.livedetect.pty.c r109 = com.bytedance.bdturing.livedetect.pty.b.a(r108, r105);     // Catch: Exception -> L39
        long r113 = System.currentTimeMillis();     // Catch: Exception -> L39
        this.f201980o.put("ts", r113);     // Catch: Exception -> L39
        r109.f201926d = r110;     // Catch: Exception -> L39
        r107.f201919b = r113;     // Catch: Exception -> L39
        r107.f201918a = r109.f201927e;     // Catch: Exception -> L39
        r107.f201920c = System.currentTimeMillis() - r101;     // Catch: Exception -> L39
        r107.f201922e = r109.f201928f;     // Catch: Exception -> L39
        if (this.f201971f == null) goto L28;
        Handler r114 = this.f201968c;     // Catch: Exception -> L39
        if (r114 == null) goto L28;
        r114.post(new com.bytedance.bdturing.livedetect.view.c(this, r109));     // Catch: Exception -> L39
    L28:
        BdTuringConfig r115 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L39
        if (r115 == null) goto L31;
        r112 = r115.isLiveDebugMode();     // Catch: Exception -> L39
    L31:
        if (r112 == false) goto L33;
        hc4.d.b(r111, "pty_time_use", Long.valueOf(System.currentTimeMillis() - r101));     // Catch: Exception -> L39
        hc4.d.b(r111, "status", Integer.valueOf(r109.f201927e));     // Catch: Exception -> L39
        hc4.d.b(r111, "debugInfo", r109.f201928f);     // Catch: Exception -> L39
        this.f201968c.post(new com.bytedance.bdturing.livedetect.view.a(this, r109));     // Catch: Exception -> L39
        c(true, null, null, r111);     // Catch: Exception -> L39
    L33:
        List<com.bytedance.bdturing.livedetect.pty.a> r116 = this.f201976k;     // Catch: Exception -> L39
        if (r116 != null) goto L36;
        return;
    L36:
        if (((ArrayList) r116).size() >= 200) goto L63;
        ((ArrayList) this.f201976k).add(r107);     // Catch: Exception -> L39
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
        r105 = null;
        goto L15
    L7:
        if (r110.bitmap.getHeight() == 640) goto L11;
    L42:
        if (this.f201969d.get() != 2) goto L70;
        final CountDownLatch r117 = new CountDownLatch(1);
        LiveDetectMaskView r118 = this.f201972g;
        if (r118 == null) goto L47;
        r100 = r118.getBoxRectInfo();
    L47:
        final ArrayList<Float> r119 = r100;
        final long r120 = System.currentTimeMillis();
        Bitmap r121 = r110.bitmap;
        final com.bytedance.bdturing.livedetect.pty.a r122 = new com.bytedance.bdturing.livedetect.pty.a();
        r122.f201921d = r111.optLong("convert_camera_data_time_use");
        TuringPTYManager.b().c(r121, r119, new AnonymousClass2(this, r119, r110, r122, r120, r111, r117));
        r117.await();     // Catch: Exception -> L54
        List<com.bytedance.bdturing.livedetect.pty.a> r123 = this.f201976k;     // Catch: Exception -> L54
        if (r123 != null) goto L51;
        return;
    L51:
        if (((ArrayList) r123).size() >= 200) goto L66;
        ((ArrayList) this.f201976k).add(r122);     // Catch: Exception -> L54
        return;
    L66:
        return;
    L54:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        if (r102 <= 720) goto L5;
        r102 = 720;
    L5:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((r102 * 1.0f) / this.f201970e), 1073741824));
    }

    public LiveDetectView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        boolean r103 = false;
        this.f201969d = new AtomicInteger(0);
        this.f201971f = null;
        this.f201976k = new ArrayList();
        this.f201981p = null;
        this.f201982q = 0;
        LayoutInflater.from(r100).inflate(R.layout.turing_live_detect_view_layout, this, true);
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.width_height_ratio});
        this.f201970e = r104.getFloat(0, 0.0f);
        r104.recycle();
        this.f201966a = (AutoFixTextureView) findViewById(R.id.turing_live_detect_view);
        i r105 = new i((Activity) getContext(), this.f201966a);
        this.f201967b = r105;
        r105.f558968l = this;
        this.f201966a.setSurfaceTextureListener(this);
        this.f201968c = new Handler();
        this.f201972g = (LiveDetectMaskView) findViewById(R.id.turing_ldv_mask);
        this.f201973h = (DetectDebugView) findViewById(R.id.turing_ldv_debug_info);
        this.f201972g.setBoxStateListener(this);
        LiveDetectMaskView r106 = this.f201972g;
        BdTuringConfig r107 = qb4.b.c.f532315a.f532302a;
        if (r107 == null) goto L5;
        r103 = r107.isLiveDebugMode();
    L5:
        r106.setDebugMode(r103);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        if (1 != this.f201969d.get()) goto L6;
        h();
        return;
    }

    public final void c(boolean r100, PTYError r110, PTYTaskData r111, JSONObject r112) {
        int r101 = -1;
        if (r112 == null) goto L5;
        r101 = r112.optInt("status", -1);
    L5:
        if (r101 != 0) goto L7;
    L9:
        this.f201982q = System.currentTimeMillis();
        Handler r102 = this.f201968c;
        if (r102 == null) goto L13;
        r102.post(new d(this, r100, r110, r111, r112));
        return;
    L13:
        return;
    L7:
        if ((System.currentTimeMillis() - this.f201982q) >= 100) goto L9;
    }

    public static void b(LiveDetectView r100, boolean r101, PTYError r102, PTYTaskData r103, PTYPackageInfo r104) {
        r100.getClass();
        if (r101 == false) goto L45;
        if (r102 != null) goto L45;
        return;
    L45:
        JSONArray r105 = r100.f201977l;     // Catch: Exception -> L42
        if (r105 != null) goto L9;
    L11:
        String r106 = "";
        if (r102 == null) goto L14;
        String r107 = r102.toString();     // Catch: Exception -> L42
    L15:
        String r108 = r100.f201978m;     // Catch: Exception -> L42
        if (r108 != null) goto L18;
    L20:
        r100.f201978m = r107;     // Catch: Exception -> L42
        if (r100.f201977l != null) goto L23;
        r100.f201977l = new JSONArray();     // Catch: Exception -> L42
    L23:
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L42
        r109.put("success", r101);     // Catch: Exception -> L42
        if (r107.length() <= 1024) goto L26;
        r107 = r107.substring(0, 1024);     // Catch: Exception -> L42
    L26:
        r109.put("ptyError", r107);     // Catch: Exception -> L42
        if (r103 != null) goto L29;
    L33:
        String r110 = "";
    L34:
        r109.put("outputData", r110);     // Catch: Exception -> L42
        if (r104 == null) goto L40;
        String r111 = r104.toString();     // Catch: Exception -> L42
        if (r111.length() <= 1024) goto L39;
        r111 = r111.substring(0, 1024);     // Catch: Exception -> L42
    L39:
        r106 = r111;
    L40:
        r109.put("ptyPackageInfo", r106);     // Catch: Exception -> L42
        r100.f201977l.put(r109);     // Catch: Exception -> L42
        return;
    L29:
        if (r103.getParams() == null) goto L33;
        r110 = r103.getParams().toString();     // Catch: Exception -> L42
        if (r110.length() <= 1024) goto L34;
        r110 = r110.substring(0, 1024);     // Catch: Exception -> L42
        goto L34
    L18:
        if (r108.equals(r107) == false) goto L20;
        return;
    L14:
        r107 = "";
        goto L15
    L9:
        if (r105.length() <= 30) goto L11;
        return;
    L42:
        e = move-exception;
        e.printStackTrace();
    }
}
