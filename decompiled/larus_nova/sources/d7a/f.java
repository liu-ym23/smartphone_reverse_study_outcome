package d7a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.hybrid.xelement.ecomimage.ECLynxImage;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.m;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.n;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import u7a.i;
import u7a.j;

/* JADX INFO: loaded from: classes32.dex */
public class f implements Drawable.Callback {
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public v7a.f G;
    public final Map<String, String> G1;
    public v7a.f H;
    public boolean H0;
    public boolean H1;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f467308J;
    public float K;
    public float L;
    public boolean L0;
    public final boolean L1;
    public float[] M;
    public float M1;
    public RectF N;
    public int O;
    public int P;
    public int P0;
    public boolean P1;
    public long Q;
    public Rect Q1;
    public ShadowNode R;
    public boolean S;
    public long S1;
    public LynxBaseUI T;
    public long T1;
    public m U;
    public View V;
    public int V0;
    public final e V1;
    public final boolean W;
    public final i X;
    public final boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f467309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LynxContext f467310b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public OptionalBool f467311b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final b f467312b2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d7a.c f467313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f467314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f467315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f467316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f467317g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public OptionalBool f467318g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public final c f467319g2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f467320h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public ColorFilter f467321h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f467322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public j f467323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public j f467324k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f467325k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public v7a.f f467326k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f467327l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f467328m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u7a.m.b f467329n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f467330o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f467331p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f467332p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public BackgroundDrawable.RoundRectPath f467333p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f467334q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Bitmap.Config f467335r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f467336s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f467337t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f467338u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f467339v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f467340v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f467341w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f467342x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f467343x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f467344y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f467345y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f467346z;

    public class a implements v7a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f467347a;

        @Override // v7a.e
        public final void onRequestSubmit(v7a.f r100) {
        }

        public a(f r100) {
            this.f467347a = r100;
        }

        @Override // v7a.e
        public final void onImageMonitorInfo(JSONObject r100) {
            f r101 = this.f467347a;
            if (r101.H1 == false) goto L30;
            LynxBaseUI r102 = r101.T;
            if (r102 == null) goto L7;
            int r103 = r102.getSign();
        L9:
            if (r101.f467310b == null) goto L31;
            if (r103 >= 0) goto L12;
            return;
        L12:
            if (r101.H1 == false) goto L33;
            if (r100 == null) goto L34;
            m7a.a r104 = new m7a.a(r103, "load");
            Iterator<String> r105 = r100.keys();
        L16:
            if (r105.hasNext() == false) goto L23;
            String r106 = r105.next();
            Object r107 = r100.get(r106);     // Catch: JSONException -> L20
        L22:
            r104.a(r106, r107);
        L20:
            e = move-exception;
            LLog.e("LynxImageManager", e.getMessage());
            r107 = null;
            goto L22
        L23:
            r104.a("src", r101.f467314d);
            r104.a("width", Integer.valueOf(r101.O));
            r104.a("height", Integer.valueOf(r101.P));
            r104.a("view_width", Integer.valueOf(r101.B));
            r104.a("view_height", Integer.valueOf(r101.C));
            r104.a(LynxMonitorService.KEY_MEMORY_COST_FROM, Long.valueOf(r101.Q));
            r104.a("load_start", Long.valueOf(r101.S1));
            r104.a("load_finish", Long.valueOf(r101.T1));
            r104.a(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r101.T1 - r101.S1));
            r101.f467310b.getEventEmitter().sendCustomEvent(r104);
            return;
        L34:
            return;
        L33:
            return;
        L31:
            return;
        L7:
            r103 = r101.V0;
            goto L9
        }

        @Override // v7a.e
        public final void onFailure(int r210, Throwable r211) {
            LLog.e("LynxImageManager", "onFailed src:" + this.f467347a.f467314d + ",with reason:" + r211.getMessage());
            int r100 = u7a.b.b(r210);
            String r101 = r211.getMessage();
            if (TextUtils.isEmpty(r101) == false) goto L9;
            r101 = Log.getStackTraceString(r211);
            if (r101 == null) goto L9;
            if (r101.length() <= 200) goto L9;
            r101 = r101.substring(0, 200);
        L9:
            LynxError r102 = new LynxError(r100, "Android LynxImageManager loading image failed", "", "error");
            r102.setRootCause(r101);
            this.f467347a.j(r102, r100, r210);
            f r103 = this.f467347a;
            r103.getClass();
            long r104 = System.currentTimeMillis();
            r103.T1 = r104;
            String r105 = r103.f467314d;
            long r106 = r103.S1;
            boolean r110 = false;
            if (r103.L1 == false) goto L12;
            u7a.f.b(r103.f467310b, r105, false, false, r106, r104, 0, null);
        L12:
            String r111 = r103.f467314d;
            long r107 = r103.S1;
            long r108 = r103.T1;
            int r109 = 0;
            if (r103.L1 == false) goto L15;
            LynxThreadPool.b().execute(new u7a.d(r103.f467310b, r107, r108, r110, r111, r109, r210, false));
        L15:
            r103.q(r103.f467314d, r210, false, -1, r103.S1, r103.T1, r103.T instanceof LynxFlattenUI, 0, 0);
        }

        @Override // v7a.e
        public final void onSuccess(u7a.a r310, v7a.f r311, v7a.d r312) {
            String r100 = r311.f553504a;
            v7a.f r101 = this.f467347a.G;
            if (r101 == null) goto L5;
            String r102 = r101.f553504a;
        L7:
            if (TextUtils.equals(r100, r102) == true) goto L9;
            return;
        L9:
            boolean r103 = false;
            if (r310 != null) goto L12;
        L22:
            f r104 = this.f467347a;
            if (r104.f467317g == false) goto L27;
            r104.p(r104.f467326k1);
            f r105 = this.f467347a;
            r105.o(r105.f467323j);
            f r106 = this.f467347a;
            r106.f467326k1 = null;
            j r107 = r106.f467323j;
            if (r107 == null) goto L27;
            r107.b();
            this.f467347a.f467323j = null;
        L27:
            this.f467347a.f467323j = new j(r310, this.f467347a.f467329n);
            if (TextUtils.isEmpty(this.f467347a.f467327l) == true) goto L30;
            f r108 = this.f467347a;
            j r109 = r108.f467323j;
            String r110 = r108.f467327l;
            String r111 = r108.f467328m;
            r109.f549121h = r110;
            r109.f549122i = r111;
        L30:
            f r112 = this.f467347a;
            int r113 = r312.f553500a;
            r112.O = r113;
            int r114 = r312.f553501b;
            r112.P = r114;
            if (r113 <= 0) goto L40;
            if (r114 <= 0) goto L40;
            Bitmap.Config r115 = r112.f467335r;     // Catch: UnsupportedOperationException -> L39
            if (r115 != null) goto L37;
            r115 = Bitmap.Config.ARGB_8888;     // Catch: UnsupportedOperationException -> L39
        L37:
            long r116 = u7a.g.a(r113, r114, r115);     // Catch: UnsupportedOperationException -> L39
        L41:
            r112.Q = r116;
            com.lynx.tasm.group.d r117 = this.f467347a.f467310b.getRuntimeCacheManager();
            if (r117 == null) goto L44;
            int r118 = this.f467347a.O;
            r117.c();
        L44:
            this.f467347a.h();
            f r119 = this.f467347a;
            ColorFilter r120 = r119.f467321h1;
            if (r120 == null) goto L47;
            r119.f467323j.setColorFilter(r120);
        L47:
            f r121 = this.f467347a;
            r121.b(r121.f467323j);
            f r122 = this.f467347a;
            if (r122.f467337t <= 0) goto L50;
            r122.f467338u = SystemClock.uptimeMillis();
        L51:
            f r123 = this.f467347a;
            r123.k(r123.O, r123.P);
            f r124 = this.f467347a;
            r124.getClass();
            r124.T1 = System.currentTimeMillis();
            boolean r125 = r312.f553502c;
            JSONObject r126 = new JSONObject();     // Catch: JSONException -> L63
            r126.put("viewWidth", r124.B);     // Catch: JSONException -> L63
            r126.put("viewHeight", r124.C);     // Catch: JSONException -> L63
            r126.put("width", r124.O);     // Catch: JSONException -> L63
            r126.put("height", r124.P);     // Catch: JSONException -> L63
            Bitmap.Config r127 = r124.f467335r;     // Catch: JSONException -> L63
            if (r127 != null) goto L55;
            r127 = Bitmap.Config.ARGB_8888;     // Catch: JSONException -> L63
        L55:
            r126.put("config", r127);     // Catch: JSONException -> L63
            if (r125 == true) goto L58;
        L60:
            int r128 = 0;
        L61:
            r126.put("isFlattenAnim", r128);     // Catch: JSONException -> L63
            JSONObject r129 = r126;
        L65:
            int r130 = (int) r124.Q;
            if (r312.f553503d != 5) goto L68;
            r103 = true;
        L68:
            String r131 = r124.f467314d;
            boolean r210 = true;
            long r132 = r124.S1;
            long r133 = r124.T1;
            if (r124.L1 == false) goto L71;
            u7a.f.b(r124.f467310b, r131, true, r103, r132, r133, r130, r129);
        L71:
            String r134 = r124.f467314d;
            long r135 = r124.S1;
            long r136 = r124.T1;
            int r211 = 0;
            if (r124.L1 == false) goto L74;
            LynxThreadPool.b().execute(new u7a.d(r124.f467310b, r135, r136, r210, r134, r130, r211, r103));
        L74:
            r124.q(r124.f467314d, 0, r103, r312.f553503d, r124.S1, r124.T1, r124.T instanceof LynxFlattenUI, r124.O, r124.P);
            this.f467347a.f();
            return;
        L58:
            if ((r124.T instanceof LynxFlattenUI) == false) goto L60;
            r128 = 1;
        L63:
            e = move-exception;
            LLog.e("LynxImageManager", "getSizeInfo error: " + e.getMessage());
            r129 = null;
            goto L65
        L50:
            r122.f467338u = -1;
        L39:
            LLog.w("LynxImageManager", "Unsupported bitmap config when reporting image memory usage: " + r112.f467335r);
        L40:
            r116 = 0;
            goto L41
        L12:
            if (this.f467347a.f467340v1 == false) goto L18;
            if (r310.f549071d == false) goto L16;
            r310.f549077j.setFilterBitmap(false);
            goto L18
        L16:
            r310.f549070c.setFilterBitmap(false);
        L18:
            if (r312.f553502c == false) goto L22;
            f r137 = this.f467347a;
            if (r310.f549071d == true) goto L22;
            r310.f549070c.setCallback(r137);
            goto L22
        L5:
            r102 = null;
            goto L7
        }
    }

    public class b implements v7a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f467348a;

        @Override // v7a.e
        public final void onFailure(int r100, Throwable r101) {
        }

        @Override // v7a.e
        public final void onImageMonitorInfo(JSONObject r100) {
        }

        @Override // v7a.e
        public final void onRequestSubmit(v7a.f r100) {
        }

        public b(f r100) {
            this.f467348a = r100;
        }

        @Override // v7a.e
        public final void onSuccess(u7a.a r100, v7a.f r101, v7a.d r102) {
            String r103 = r101.f553504a;
            v7a.f r104 = this.f467348a.H;
            if (r104 == null) goto L5;
            String r105 = r104.f553504a;
        L7:
            if (TextUtils.equals(r103, r105) == true) goto L9;
            return;
        L9:
            f r106 = this.f467348a;
            r106.f467324k = new j(r100, this.f467348a.f467329n);
            f r107 = this.f467348a;
            r107.b(r107.f467324k);
            this.f467348a.f();
            return;
        L5:
            r105 = null;
            goto L7
        }
    }

    public class c implements v7a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f467349a;

        public c(f r100) {
            this.f467349a = r100;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f467350a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f467350a.f();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(f r100) {
            this.f467350a = r100;
        }
    }

    public static class e implements v7a.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v7a.e f467351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<Runnable> f467352b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e f467353a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f467353a.b();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(e r100) {
                this.f467353a = r100;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v7a.f f467354a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f467355b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f467355b.f467351a.onRequestSubmit(this.f467354a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public b(e r100, v7a.f r101) {
                this.f467355b = r100;
                this.f467354a = r101;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u7a.a f467356a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v7a.f f467357b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ v7a.d f467358c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e f467359d;

            @Override // java.lang.Runnable
            public final void run() {
                this.f467359d.f467351a.onSuccess(this.f467356a, this.f467357b, this.f467358c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(e r100, u7a.a r101, v7a.f r102, v7a.d r103) {
                this.f467359d = r100;
                this.f467356a = r101;
                this.f467357b = r102;
                this.f467358c = r103;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f467360a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Throwable f467361b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ e f467362c;

            @Override // java.lang.Runnable
            public final void run() {
                this.f467362c.f467351a.onFailure(this.f467360a, this.f467361b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public d(e r100, int r101, Throwable r102) {
                this.f467362c = r100;
                this.f467360a = r101;
                this.f467361b = r102;
            }
        }

        /* JADX INFO: renamed from: d7a.f$e$e, reason: collision with other inner class name */
        public class RunnableC5643e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ JSONObject f467363a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e f467364b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f467364b.f467351a.onImageMonitorInfo(this.f467363a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC5643e(e r100, JSONObject r101) {
                this.f467364b = r100;
                this.f467363a = r101;
            }
        }

        public final synchronized void b() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (this.f467352b.isEmpty() == false) goto L7;
            monitor-exit(this);
            return;
        L7:
            Iterator<Runnable> r100 = this.f467352b.iterator();     // Catch: Throwable -> L14
        L9:
            if (r100.hasNext() == false) goto L11;
            r100.next().run();     // Catch: Throwable -> L14
            goto L9
        L11:
            this.f467352b.clear();     // Catch: Throwable -> L14
            monitor-exit(this);
        }

        public e(a r100) {
            this.f467352b = new ArrayList();
            this.f467351a = r100;
        }

        public final synchronized void a(Runnable r100) {
            monitor-enter(this);
            this.f467352b.add(r100);     // Catch: Throwable -> L6
            UIThreadUtils.runOnUiThreadImmediately(new a(this));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onImageMonitorInfo(JSONObject r100) {
            monitor-enter(this);
            a(new RunnableC5643e(this, r100));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onRequestSubmit(v7a.f r100) {
            monitor-enter(this);
            a(new b(this, r100));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onFailure(int r100, Throwable r101) {
            monitor-enter(this);
            a(new d(this, r100, r101));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // v7a.e
        public final synchronized void onSuccess(u7a.a r100, v7a.f r101, v7a.d r102) {
            monitor-enter(this);
            a(new c(this, r100, r101, r102));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public final void B() {
        if (this.f467316f == false) goto L6;
        return;
    L6:
        if (this.Y == true) goto L8;
        return;
    L8:
        boolean r100 = g(2);
        boolean r101 = g(4);
        boolean r102 = false;
        final LynxResourceRequest r103 = null;
        if (r100 == false) goto L20;
        d7a.c r104 = this.f467313c;
        String r105 = this.f467314d;
        if (r104.f467301b == true) goto L13;
        boolean r106 = r104.f467300a.canParseUrl(r105);
    L14:
        if (r106 == false) goto L16;
        this.f467311b1 = OptionalBool.FALSE;
    L18:
        if (this.f467311b1 == OptionalBool.FALSE) goto L20;
        final LynxResourceRequest r107 = new LynxResourceRequest(this.f467314d, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage);
    L21:
        if (r101 == false) goto L32;
        d7a.c r108 = this.f467313c;
        String r109 = this.f467315e;
        if (r108.f467301b == true) goto L25;
        r102 = r108.f467300a.canParseUrl(r109);
    L25:
        if (r102 == false) goto L27;
        this.f467318g1 = OptionalBool.FALSE;
    L29:
        if (this.f467318g1 == OptionalBool.FALSE) goto L32;
        r103 = new LynxResourceRequest(this.f467315e, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage);
        goto L32
    L27:
        this.f467318g1 = this.X.b(this.f467315e);
    L32:
        if (ThreadMethodProxy.currentThread() == ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L34;
    L43:
        if (r107 == null) goto L45;
        this.f467314d = this.X.c(r107);
    L45:
        if (r103 == null) goto L50;
        this.f467315e = this.X.c(r103);
        return;
    L50:
        return;
    L34:
        if (this.W == false) goto L43;
        if (r107 != null) goto L38;
        if (r103 != null) goto L38;
        return;
    L38:
        if (r107 == null) goto L40;
        this.f467309a &= -3;
    L40:
        if (r103 == null) goto L42;
        this.f467309a &= -5;
    L42:
        LynxThreadPool.b().execute(new d7a.d(this, r103, r107));
        return;
    L16:
        this.f467311b1 = this.X.b(this.f467314d);
        goto L18
    L13:
        r106 = false;
    L20:
        r107 = null;
        goto L21
    }

    public final void d() {
        p(this.G);
        p(this.H);
        o(this.f467323j);
        o(this.f467324k);
        this.G = null;
        this.H = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        j r100 = this.f467323j;
        if (r100 == null) goto L5;
        r100.b();
        this.f467323j = null;
    L5:
        j r101 = this.f467324k;
        if (r101 == null) goto L9;
        r101.b();
        this.f467324k = null;
        return;
    }

    public final Boolean e() {
        if (this.f467323j == null) goto L5;
    L8:
        boolean r100 = true;
    L10:
        return Boolean.valueOf(r100);
    L5:
        if (this.f467324k != null) goto L8;
        r100 = false;
        goto L10
    }

    public void f() {
        LynxBaseUI r100 = this.T;
        if (r100 == null) goto L5;
        r100.invalidateMeaningfulPaintingArea();
    L5:
        m r101 = this.U;
        if (r101 == null) goto L11;
        KeyEvent.Callback r102 = r101.f382809b;
        if ((r102 instanceof com.lynx.tasm.behavior.ui.e.a) == false) goto L11;
        ((com.lynx.tasm.behavior.ui.e.a) r102).invalidateMeaningfulPaintingArea();
    L11:
        if (UIThreadUtils.isOnUiThread() == true) goto L13;
        return;
    L13:
        LynxBaseUI r103 = this.T;
        if (r103 == null) goto L16;
        r103.invalidate();
    L16:
        m r104 = this.U;
        if (r104 == null) goto L22;
        View r105 = r104.f382809b;
        if (r105 == null) goto L22;
        r105.invalidate();
    L22:
        View r106 = this.V;
        if (r106 == null) goto L26;
        r106.invalidate();
        return;
    }

    public final void h() {
        if (this.O != 0) goto L5;
        return;
    L5:
        if (this.P != 0) goto L7;
        return;
    L7:
        if (this.f467331p == false) goto L22;
        LynxBaseUI r100 = this.T;
        if (r100 != null) goto L12;
        return;
    L12:
        if (this.R != null) goto L14;
        this.R = r100.getLynxContext().findShadowNodeBySign(this.T.getSign());
    L14:
        ShadowNode r101 = this.R;
        if ((r101 instanceof AutoSizeImage) == true) goto L18;
        this.S = true;
        return;
    L18:
        ((AutoSizeImage) r101).D(this.f467331p, this.O, this.P, this.T.getWidth(), this.T.getHeight());
        return;
    }

    public final void z() {
        if (g(2048) == false) goto L14;
        if (this.F == true) goto L11;
        if (this.f467331p == true) goto L11;
        if (this.f467320h == false) goto L14;
    L11:
        if (this.G == null) goto L14;
        this.f467309a &= -2049;
    L14:
        if (g(16) == false) goto L19;
        if (this.f467323j == null) goto L19;
        this.f467323j = new j(this.f467323j.f549119f, this.f467329n);
    L19:
        if (g(8) == false) goto L24;
        j r100 = this.f467323j;
        if (r100 == null) goto L24;
        String r101 = this.f467327l;
        String r102 = this.f467328m;
        r100.f549121h = r101;
        r100.f549122i = r102;
    L24:
        if (g(128) == false) goto L28;
        j r103 = this.f467323j;
        if (r103 == null) goto L28;
        r103.setColorFilter(this.f467321h1);
    L28:
        boolean r104 = true;
        if (g(4) == false) goto L59;
        p(this.H);
        o(this.f467324k);
        j r105 = this.f467324k;
        if (r105 == null) goto L33;
        r105.b();
        this.f467324k = null;
    L33:
        this.H = null;
        if (TraceEvent.isTracingStarted() == false) goto L36;
        TraceEvent.beginSection("LynxImageManager.updatePlaceholderSource");
    L36:
        int r106 = this.B;
        if (r106 <= 0) goto L41;
        int r107 = this.C;
        if (r107 <= 0) goto L41;
    L45:
        boolean r108 = true;
    L47:
        if (r108 == true) goto L49;
    L57:
        TraceEvent.endSection("LynxImageManager.updatePlaceholderSource");
        goto L59
    L49:
        if (this.f467323j != null) goto L57;
        v7a.f r109 = c(r106, r107, this.f467315e);
        if (r109 == null) goto L57;
        this.H = r109;
        d7a.c r110 = this.f467313c;
        b r111 = this.f467312b2;
        LynxContext r112 = this.f467310b;
        r110.getClass();
        TraceEvent.beginSection("LynxImageServiceProxy.fetchImage");
        if (r110.f467301b == true) goto L56;
        r110.f467300a.fetchImage(r109, r111, null, r112);
        TraceEvent.endSection("LynxImageServiceProxy.fetchImage");
        goto L57
    L56:
        throw null;
    L41:
        r106 = this.D;
        if (r106 <= 0) goto L46;
        r107 = this.E;
        if (r107 > 0) goto L45;
    L46:
        r106 = 0;
        r107 = 0;
        r108 = false;
    L59:
        if (g(2) == true) goto L67;
        if (g(32) == true) goto L67;
        if (g(2048) == true) goto L67;
        if (g(PlaybackStateCompat.ACTION_PLAY_FROM_URI) == true) goto L67;
    L94:
        if (g(512) == false) goto L96;
    L99:
        b(this.f467323j);
        b(this.f467324k);
        float[] r113 = this.M;
        if (r113 != null) goto L102;
    L108:
        if (this.S == false) goto L112;
        this.S = false;
        if (this.f467331p == false) goto L112;
        h();
    L112:
        this.f467309a = 0;
        return;
    L102:
        if (r113.length <= 0) goto L108;
        if (this.f467333p1 != null) goto L106;
        this.f467333p1 = new BackgroundDrawable.RoundRectPath();
    L106:
        this.f467333p1.d(new Rect(this.f467342x, this.f467344y, this.B - this.f467346z, this.C - this.A), this.M, this.N, 1.0f, false);
        goto L108
    L96:
        if (g(1024) == true) goto L99;
        if (g(4096) == false) goto L108;
    L67:
        if (this.f467317g == true) goto L72;
        p(this.G);
        o(this.f467323j);
        j r114 = this.f467323j;
        if (r114 == null) goto L71;
        r114.b();
        this.f467323j = null;
    L71:
        this.G = null;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
    L74:
        if (TraceEvent.isTracingStarted() == false) goto L76;
        TraceEvent.beginSection("LynxImageManager.updateImageSource");
    L76:
        int r115 = this.B;
        if (r115 <= 0) goto L81;
        int r116 = this.C;
        if (r116 <= 0) goto L81;
    L90:
        if (r104 == false) goto L92;
        LynxThreadPool.g(new g(this, r115, r116));
    L92:
        TraceEvent.endSection("LynxImageManager.updateImageSource");
    L81:
        r115 = this.D;
        if (r115 <= 0) goto L87;
        r116 = this.E;
        if (r116 > 0) goto L90;
    L87:
        if (this.f467331p == true) goto L89;
        r115 = 0;
        r116 = 0;
        r104 = false;
        goto L90
    L89:
        r115 = 0;
        r116 = 0;
        goto L90
    L72:
        this.f467326k1 = this.G;
        goto L74
    }

    public final void m() {
        z();
        f();
    }

    public f(LynxContext r100) {
        this.f467309a = 0;
        this.f467329n = u7a.m.b.f549123a;
        boolean r101 = false;
        this.f467334q = 0;
        this.f467336s = true;
        this.f467337t = 0;
        this.f467338u = -1;
        this.f467341w = true;
        this.N = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.R = null;
        this.V = null;
        this.Y = false;
        this.P0 = -1;
        this.V0 = -1;
        OptionalBool r102 = OptionalBool.UNDEFINED;
        this.f467311b1 = r102;
        this.f467318g1 = r102;
        this.f467321h1 = null;
        this.f467326k1 = null;
        this.f467340v1 = false;
        this.f467343x1 = false;
        this.f467345y1 = false;
        this.G1 = new HashMap();
        this.H1 = false;
        this.L1 = false;
        this.M1 = 0.0f;
        this.P1 = false;
        this.S1 = 0;
        this.T1 = 0;
        this.V1 = new e(new a(this));
        this.f467312b2 = new b(this);
        this.f467319g2 = new c(this);
        this.f467310b = r100;
        r100.getImageFetcher();
        this.f467313c = new d7a.c();
        this.X = new i(r100);
        if (r100.getMediaResourceFetcher() == null) goto L5;
    L6:
        r101 = true;
    L7:
        this.W = r101;
        this.Y = r100.isEnableCheckLocalImage();
        r100.getLynxImageConfig();
        this.L1 = LynxEnv.inst().enableImageEventReport();
        return;
    L5:
        if (r100.getAsyncImageInterceptor() == null) goto L7;
        goto L6
    }

    public final void A(ReadableMap r110) {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        TraceEvent.beginSection("LynxImageManager.updatePropertiesInterval");
    L5:
        ReadableMapKeySetIterator r100 = r110.keySetIterator();
    L7:
        if (r100.hasNextKey() == false) goto L220;
        String r101 = r100.nextKey();
        r101.getClass();
        int r102 = 0;
        switch(r101.hashCode()) {
            case -1937917490: goto L132;
            case -1900756664: goto L128;
            case -1492006372: goto L124;
            case -1338903714: goto L120;
            case -1138223116: goto L116;
            case -1059824547: goto L112;
            case -629825370: goto L108;
            case -320982203: goto L104;
            case -256430480: goto L100;
            case 114148: goto L96;
            case 3357091: goto L92;
            case 108305470: goto L88;
            case 207594941: goto L84;
            case 259555579: goto L80;
            case 305374695: goto L76;
            case 313009824: goto L72;
            case 516005201: goto L68;
            case 598246771: goto L64;
            case 660415178: goto L60;
            case 681292984: goto L56;
            case 893413739: goto L52;
            case 1145216977: goto L48;
            case 1198809474: goto L44;
            case 1282944765: goto L40;
            case 1439562083: goto L36;
            case 1515751784: goto L32;
            case 1615092063: goto L28;
            case 1739487650: goto L24;
            case 1856274660: goto L20;
            case 1860054545: goto L16;
            case 1998893929: goto L12;
            default: goto L135;
        };
    L135:
        byte r103 = -1;
    L137:
        switch(r103) {
            case 0: goto L217;
            case 1: goto L213;
            case 2: goto L211;
            case 3: goto L210;
            case 4: goto L198;
            case 5: goto L197;
            case 6: goto L192;
            case 7: goto L191;
            case 8: goto L190;
            case 9: goto L189;
            case 10: goto L188;
            case 11: goto L185;
            case 12: goto L184;
            case 13: goto L183;
            case 14: goto L180;
            case 15: goto L179;
            case 16: goto L176;
            case 17: goto L173;
            case 18: goto L172;
            case 19: goto L169;
            case 20: goto L166;
            case 21: goto L164;
            case 22: goto L163;
            case 23: goto L162;
            case 24: goto L161;
            case 25: goto L158;
            case 26: goto L155;
            case 27: goto L154;
            case 28: goto L146;
            case 29: goto L140;
            case 30: goto L139;
            default: goto L7;
        };
    L139:
        this.f467322i = r110.getBoolean(r101, false);
        goto L7
    L140:
        String r104 = r110.getString(r101);
        if (TextUtils.equals(r104, this.f467339v) == true) goto L7;
        this.f467339v = r104;
        if (ColorUtils.a(r104) == false) goto L145;
        this.f467321h1 = new PorterDuffColorFilter(ColorUtils.b(this.f467339v), PorterDuff.Mode.SRC_IN);
    L145:
        this.f467309a |= 128;
        goto L7
    L146:
        ReadableMap r105 = r110.getMap(r101);
        if (((HashMap) this.G1).isEmpty() == true) goto L149;
        ((HashMap) this.G1).clear();
    L149:
        if (r105 == null) goto L7;
        ReadableMapKeySetIterator r106 = r105.keySetIterator();
    L152:
        if (r106.hasNextKey() == false) goto L7;
        String r107 = r106.nextKey();
        ((HashMap) this.G1).put(r107, r105.getString(r107, ""));
        goto L152
    L154:
        this.f467317g = r110.getBoolean(r101, false);
        goto L7
    L155:
        boolean r108 = r110.getBoolean(r101, false);
        if (r108 == this.f467331p) goto L7;
        this.f467331p = r108;
        this.f467309a |= 64;
        goto L7
    L158:
        String r109 = r110.getString(r101);
        if (TextUtils.equals(r109, this.f467327l) == true) goto L7;
        this.f467327l = r109;
        this.f467309a |= 8;
        goto L7
    L161:
        this.f467336s = r110.getBoolean(r101, true);
        goto L7
    L162:
        this.P1 = r110.getBoolean(r101, false);
        goto L7
    L163:
        r110.getBoolean(r101, false);
        goto L7
    L164:
        this.f467343x1 = r110.getBoolean(r101, false);
        goto L7
    L166:
        if ("fadeIn".equals(r110.getString(r101)) == true) goto L167;
        this.f467337t = 0;
        goto L7
    L167:
        this.f467337t = 300;
        goto L7
    L169:
        String r111 = r110.getString(r101);
        if (TextUtils.equals(r111, this.f467330o) == true) goto L7;
        this.f467330o = r111;
        this.f467309a |= 32;
        goto L7
    L172:
        this.f467345y1 = r110.getBoolean(r101, false);
        goto L7
    L173:
        String r112 = r110.getString(r101);
        if (TextUtils.equals(r112, this.f467315e) == true) goto L7;
        this.f467315e = r112;
        this.f467309a |= 4;
        goto L7
    L176:
        String r113 = r110.getString(r101);
        if (TextUtils.equals(r113, this.f467327l) == true) goto L7;
        this.f467327l = r113;
        this.f467309a |= 8;
        goto L7
    L179:
        u7a.g.b(r110.getDynamic(r101));
        goto L7
    L180:
        Rect r114 = u7a.g.c(r110.getMap(r101));
        if (Objects.equals(r114, this.Q1) == true) goto L7;
        this.Q1 = r114;
        this.f467309a |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
        goto L7
    L183:
        this.M1 = (float) r110.getDouble(r101, AudioStats.AUDIO_AMPLITUDE_NONE);
        goto L7
    L184:
        this.E = (int) n.b(r110.getString(r101), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.f467310b.getScreenMetrics());
        goto L7
    L185:
        boolean r115 = r110.getBoolean(r101, false);
        if (this.f467341w == r115) goto L7;
        this.f467341w = r115;
        this.f467309a |= 256;
        goto L7
    L188:
        u(r110.getString(r101));
        goto L7
    L189:
        v(r110.getString(r101));
        goto L7
    L190:
        this.D = (int) n.b(r110.getString(r101), 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.f467310b.getScreenMetrics());
        goto L7
    L191:
        this.F = r110.getBoolean(r101, false);
        goto L7
    L192:
        int r116 = r110.getInt(r101, 0);
        if (r116 <= 0) goto L196;
        r102 = r116;
    L196:
        this.f467334q = r102;
        goto L7
    L197:
        this.H1 = r110.getBoolean(r101, false);
        goto L7
    L198:
        String r117 = r110.getString(r101);
        if (r117 == null) goto L209;
        if (r117.equalsIgnoreCase("") == true) goto L209;
        if (r117.equalsIgnoreCase("RGB_565") == true) goto L205;
        if (r117.equalsIgnoreCase("ARGB_8888") == false) goto L7;
        this.f467335r = Bitmap.Config.ARGB_8888;
        goto L7
    L205:
        this.f467335r = Bitmap.Config.RGB_565;
    L209:
        this.f467335r = null;
        goto L7
    L210:
        this.f467316f = r110.getBoolean(r101, false);
        goto L7
    L211:
        this.f467320h = r110.getBoolean(r101, false);
        goto L7
    L213:
        if (r110.getBoolean(r101) == false) goto L215;
        float r118 = 1.0f;
    L216:
        this.M1 = r118;
        goto L7
    L215:
        r118 = 0.0f;
        goto L216
    L217:
        String r119 = r110.getString(r101);
        if (TextUtils.equals(r119, this.f467328m) == true) goto L7;
        this.f467328m = r119;
        this.f467309a |= 8;
        goto L7
    L12:
        if (r101.equals("enable-custom-gif-decoder") == false) goto L135;
        r103 = 30;
        goto L137
    L16:
        if (r101.equals("tint-color") == false) goto L135;
        r103 = 29;
        goto L137
    L20:
        if (r101.equals("additional-custom-info") == false) goto L135;
        r103 = 28;
        goto L137
    L24:
        if (r101.equals(ECLynxImage.DEFER_SRC_INVALIDATION) == false) goto L135;
        r103 = 27;
        goto L137
    L28:
        if (r101.equals("auto-size") == false) goto L135;
        r103 = 26;
        goto L137
    L32:
        if (r101.equals("capInsets") == false) goto L135;
        r103 = 25;
        goto L137
    L36:
        if (r101.equals("autoplay") == false) goto L135;
        r103 = 24;
        goto L137
    L40:
        if (r101.equals("android-cache-key-path-only") == false) goto L135;
        r103 = 23;
        goto L137
    L44:
        if (r101.equals("disable-default-placeholder") == false) goto L135;
        r103 = 22;
        goto L137
    L48:
        if (r101.equals("android-enable-smooth-animation") == false) goto L135;
        r103 = 21;
        goto L137
    L52:
        if (r101.equals("image-transition-style") == false) goto L135;
        r103 = 20;
        goto L137
    L56:
        if (r101.equals("blur-radius") == false) goto L135;
        r103 = 19;
        goto L137
    L60:
        if (r101.equals("progressive-rendering") == false) goto L135;
        r103 = 18;
        goto L137
    L64:
        if (r101.equals(GXTemplateKey.GAIAX_PLACEHOLDER) == false) goto L135;
        r103 = 17;
        goto L137
    L68:
        if (r101.equals("cap-insets") == false) goto L135;
        r103 = 16;
        goto L137
    L72:
        if (r101.equals("local-cache") == false) goto L135;
        r103 = 15;
        goto L137
    L76:
        if (r101.equals("region-to-decode") == false) goto L135;
        r103 = 14;
        goto L137
    L80:
        if (r101.equals("super-resolution-scale") == false) goto L135;
        r103 = HTTP.CR;
        goto L137
    L84:
        if (r101.equals("prefetch-height") == false) goto L135;
        r103 = 12;
        goto L137
    L88:
        if (r101.equals("async-request") == false) goto L135;
        r103 = 11;
        goto L137
    L92:
        if (r101.equals("mode") == false) goto L135;
        r103 = 10;
        goto L137
    L96:
        if (r101.equals("src") == false) goto L135;
        r103 = 9;
        goto L137
    L100:
        if (r101.equals("prefetch-width") == false) goto L135;
        r103 = 8;
        goto L137
    L104:
        if (r101.equals("disable-default-resize") == false) goto L135;
        r103 = 7;
        goto L137
    L108:
        if (r101.equals("loop-count") == false) goto L135;
        r103 = 6;
        goto L137
    L112:
        if (r101.equals("enable-report-info") == false) goto L135;
        r103 = 5;
        goto L137
    L116:
        if (r101.equals("image-config") == false) goto L135;
        r103 = 4;
        goto L137
    L120:
        if (r101.equals("skip-redirection") == false) goto L135;
        r103 = 3;
        goto L137
    L124:
        if (r101.equals("enable-resource-hint") == false) goto L135;
        r103 = 2;
        goto L137
    L128:
        if (r101.equals("enable-super-resolution") == false) goto L135;
        r103 = 1;
        goto L137
    L132:
        if (r101.equals("cap-insets-scale") == false) goto L135;
        r103 = 0;
        goto L137
    L220:
        B();
        TraceEvent.endSection("LynxImageManager.updatePropertiesInterval");
    }

    public final void b(j r100) {
        Rect r101 = new Rect(0, 0, this.B, this.C);
        r101.left = (int) ((r101.left + this.I) + this.f467342x);
        r101.top = (int) ((r101.top + this.K) + this.f467344y);
        r101.right = (int) ((r101.right - this.f467308J) - this.f467346z);
        r101.bottom = (int) ((r101.bottom - this.L) - this.A);
        if (r100 == null) goto L6;
        r100.setBounds(r101);
        return;
    }

    public final boolean g(long r100) {
        if ((r100 & this.f467309a) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void i(Canvas r100) {
        this.V1.b();
        r100.save();
        BackgroundDrawable.RoundRectPath r101 = this.f467333p1;
        if (r101 == null) goto L7;
        Path r102 = r101.f383113c;
        if (r102 == null) goto L7;
        r100.clipPath(r102);
    L7:
        j r103 = this.f467324k;
        if (r103 == null) goto L10;
        r103.draw(r100);
    L10:
        j r104 = this.f467323j;
        if (r104 != null) goto L14;
    L23:
        r100.restore();
        return;
    L14:
        if (this.f467338u >= 0) goto L16;
    L22:
        r104.draw(r100);
        goto L23
    L16:
        if (this.f467337t <= 0) goto L22;
        long r105 = SystemClock.uptimeMillis() - this.f467338u;
        long r106 = this.f467337t;
        if (r105 < r106) goto L21;
        this.f467338u = -1;
        this.f467323j.setAlpha(255);
        this.f467323j.draw(r100);
        goto L23
    L21:
        this.f467323j.setAlpha((int) ((r105 * 255) / r106));
        this.f467323j.draw(r100);
        this.f467323j.setAlpha(255);
        f();
        goto L23
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        UIThreadUtils.runOnUiThreadImmediately(new d(this));
    }

    public final void n(Callback r100) {
        j r101 = this.f467323j;
        if (r101 == null) goto L14;
        d7a.c r102 = this.f467313c;
        u7a.a r103 = r101.f549119f;
        if (r103 == null) goto L7;
        Drawable r104 = r103.f549070c;
    L9:
        if (r102.f467301b == true) goto L11;
        boolean r105 = r102.f467300a.pauseAnimation(r104);
    L12:
        if (r105 == false) goto L14;
        r100.invoke(new Object[]{0, "Animation paused."});
        return;
    L11:
        r105 = false;
        goto L12
    L7:
        r104 = null;
    L14:
        r100.invoke(new Object[]{4, "Not support pause yet"});
    }

    public final void o(j r100) {
        if (r100 == null) goto L7;
        d7a.c r101 = this.f467313c;
        Drawable r102 = r100.getCurrent();
        if (r101.f467301b == true) goto L8;
        r101.f467300a.releaseAnimDrawable(r102);
        return;
    L8:
        return;
    }

    public final void p(v7a.f r100) {
        if (r100 == null) goto L8;
        d7a.c r101 = this.f467313c;
        if (r101.f467301b == true) goto L7;
        r101.f467300a.releaseImage(r100);
        return;
    L7:
        throw null;
    }

    public final void r(Callback r100) {
        j r101 = this.f467323j;
        if (r101 == null) goto L14;
        d7a.c r102 = this.f467313c;
        u7a.a r103 = r101.f549119f;
        if (r103 == null) goto L7;
        Drawable r104 = r103.f549070c;
    L9:
        if (r102.f467301b == true) goto L11;
        boolean r105 = r102.f467300a.resumeAnimation(r104);
    L12:
        if (r105 == false) goto L14;
        r100.invoke(new Object[]{0, "Animation resumed."});
        return;
    L11:
        r105 = false;
        goto L12
    L7:
        r104 = null;
    L14:
        r100.invoke(new Object[]{4, "Not support resume yet"});
    }

    public final void s(RectF r100) {
        this.N = r100;
        float r101 = r100.top;
        float r102 = r100.bottom;
        float r103 = r100.left;
        float r104 = r100.right;
        if (this.K == r101) goto L6;
        this.K = r101;
        this.f467309a |= 1024;
    L6:
        if (this.I == r103) goto L9;
        this.I = r103;
        this.f467309a |= 1024;
    L9:
        if (this.f467308J == r104) goto L12;
        this.f467308J = r104;
        this.f467309a |= 1024;
    L12:
        if (this.L == r102) goto L15;
        this.L = r102;
        this.f467309a |= 1024;
        return;
    }

    public final void t(Map<String, EventsListener> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.Z = false;
        this.f467325k0 = false;
        this.f467332p0 = false;
        this.H0 = false;
        this.L0 = false;
        if (r100.containsKey("startplay") == false) goto L8;
        this.Z = true;
    L8:
        if (r100.containsKey("currentloopcomplete") == false) goto L11;
        this.f467325k0 = true;
    L11:
        if (r100.containsKey("finalloopcomplete") == false) goto L14;
        this.f467332p0 = true;
    L14:
        if (r100.containsKey("load") == false) goto L17;
        this.H0 = true;
    L17:
        if (r100.containsKey("error") == false) goto L20;
        this.L0 = true;
        return;
    }

    public final void u(String r100) {
        if ("aspectFit".equals(r100) == false) goto L6;
        u7a.m.b r101 = u7a.m.b.f549124b;
    L13:
        if (Objects.equals(r101, this.f467329n) == true) goto L16;
        this.f467329n = r101;
        this.f467309a |= 16;
        return;
    L16:
        return;
    L6:
        if ("aspectFill".equals(r100) == false) goto L9;
        r101 = u7a.m.b.f549126d;
        goto L13
    L9:
        if ("center".equals(r100) == false) goto L11;
        r101 = u7a.m.b.f549125c;
        goto L13
    L11:
        r101 = u7a.m.b.f549123a;
        goto L13
    }

    public final void v(String r100) {
        if (TextUtils.equals(r100, this.f467314d) == true) goto L6;
        this.f467314d = r100;
        this.f467309a |= 2;
        return;
    }

    public final void w(Callback r100) {
        j r101 = this.f467323j;
        if (r101 == null) goto L14;
        d7a.c r102 = this.f467313c;
        u7a.a r103 = r101.f549119f;
        if (r103 == null) goto L7;
        Drawable r104 = r103.f549070c;
    L9:
        if (r102.f467301b == true) goto L11;
        boolean r105 = r102.f467300a.startAnimation(r104);
    L12:
        if (r105 == false) goto L14;
        r100.invoke(new Object[]{0, "Animation started."});
        return;
    L11:
        r105 = false;
        goto L12
    L7:
        r104 = null;
    L14:
        r100.invoke(new Object[]{4, "Not support start yet"});
    }

    public final void x(Callback r100) {
        j r101 = this.f467323j;
        if (r101 == null) goto L14;
        d7a.c r102 = this.f467313c;
        u7a.a r103 = r101.f549119f;
        if (r103 == null) goto L7;
        Drawable r104 = r103.f549070c;
    L9:
        if (r102.f467301b == true) goto L11;
        boolean r105 = r102.f467300a.stopAnimation(r104);
    L12:
        if (r105 == false) goto L14;
        r100.invoke(new Object[]{0, "Animation stopped."});
        return;
    L11:
        r105 = false;
        goto L12
    L7:
        r104 = null;
    L14:
        r100.invoke(new Object[]{4, "Not support stop yet"});
    }

    public final void y(x6a.j r100) {
        if (r100 != null) goto L4;
    L15:
        this.f467333p1 = null;
        return;
    L4:
        if (r100.f562751c == false) goto L15;
        BackgroundDrawable.RoundRectPath r101 = new BackgroundDrawable.RoundRectPath();
        this.f467333p1 = r101;
        Rect r102 = r100.a();
        float[] r103 = r100.f562750b;
        if (r101.f383111a != null) goto L9;
        r101.f383111a = new RectF();
    L9:
        RectF r104 = r101.f383111a;
        r104.left = r102.left;
        r104.top = r102.top;
        r104.right = r102.right;
        r104.bottom = r102.bottom;
        r101.f383112b = r103;
        r101.f383114d = BackgroundDrawable.RoundRectPath.a(r103);
        Path r105 = r101.f383113c;
        if (r105 != null) goto L12;
        r101.f383113c = new Path();
    L13:
        r101.f383113c.addRoundRect(r101.f383111a, r101.f383112b, Path.Direction.CW);
        return;
    L12:
        r105.reset();
        goto L13
    }

    public static void a(f r100, String r101) {
        LynxBaseUI r102 = r100.T;
        if (r102 == null) goto L5;
        int r103 = r102.getSign();
    L7:
        if (r100.f467310b == null) goto L11;
        if (r103 < 0) goto L12;
        m7a.a r104 = new m7a.a(r103, r101);
        r100.f467310b.getEventEmitter().sendCustomEvent(r104);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r103 = r100.V0;
        goto L7
    }

    public void k(int r100, int r101) {
        int r102 = this.P0;
        if (r102 < 0) goto L8;
        boolean r103 = true;
        if ((r102 & 1) != 0) goto L9;
        r103 = false;
    L9:
        if (r103 == false) goto L21;
        LynxBaseUI r104 = this.T;
        if (r104 == null) goto L13;
        int r105 = r104.getSign();
    L15:
        if (this.f467310b == null) goto L22;
        if (r105 >= 0) goto L18;
        return;
    L18:
        if (this.H1 == true) goto L24;
        m7a.a r106 = new m7a.a(r105, "load");
        r106.a("height", Integer.valueOf(r101));
        r106.a("width", Integer.valueOf(r100));
        this.f467310b.getEventEmitter().sendCustomEvent(r106);
        return;
    L24:
        return;
    L22:
        return;
    L13:
        r105 = this.V0;
        goto L15
    L21:
        return;
    L8:
        r103 = this.H0;
        goto L9
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        UIThreadUtils.removeCallbacks(r101, r100);
    }

    public final v7a.f c(int r100, int r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L6;
        return null;
    L6:
        v7a.g r101 = new v7a.g();
        r101.f553526a = r111;
        r101.f553527b = r100;
        r101.f553528c = r110;
        r101.f553529d = this.f467334q;
        r101.f553539n = this.f467310b.getFrescoCallerContext();
        r101.f553536k = this.f467336s;
        if (this.F == false) goto L9;
    L11:
        boolean r102 = false;
    L12:
        r101.f553537l = r102;
        r101.f553535j = this.f467341w;
        r101.f553531f = this.f467322i;
        r101.f553538m = this.f467320h;
        r101.f553542q = this.f467343x1;
        r101.f553543r = this.f467345y1;
        r101.f553544s = this.H1;
        r101.f553545t = this.P1;
        float r103 = this.M1;
        if (r103 <= 0.0f) goto L16;
        r101.f553546u = r103;
    L16:
        if (((HashMap) this.G1).isEmpty() == true) goto L19;
        r101.f553532g = this.G1;
    L21:
        Bitmap.Config r104 = this.f467335r;
        if (r104 == null) goto L25;
        r101.f553530e = r104;
    L25:
        if (this.f467310b.getEnableImageSmallDiskCache() == false) goto L28;
        r101.f553533h = 1;
    L28:
        if (TextUtils.isEmpty(this.f467330o) == true) goto L32;
        float r105 = n.b(this.f467330o, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, this.f467310b.getScreenMetrics());
        if (r105 <= 0.0f) goto L32;
        v7a.c r112 = new v7a.c((int) r105);
        ArrayList r106 = new ArrayList();
        r106.add(r112);
        r101.f553534i = r106;
    L32:
        Rect r107 = this.Q1;
        if (r107 == null) goto L36;
        r101.f553547v = r107;
    L36:
        return new v7a.f(r101);
    L19:
        if (this.f467310b.getImageCustomParam() == null) goto L21;
        r101.f553532g = this.f467310b.getImageCustomParam();
        goto L21
    L9:
        if (this.f467331p == true) goto L11;
        r102 = true;
        goto L12
    }

    public void j(LynxError r100, int r101, int r102) {
        LynxBaseUI r103 = this.T;
        if (r103 == null) goto L5;
        int r104 = r103.getSign();
    L7:
        if (this.f467310b == null) goto L26;
        if (r104 < 0) goto L28;
        LynxBaseUI r105 = this.T;
        if (r105 == null) goto L13;
        r100.addCustomInfo("node_index", Integer.toString(r105.getNodeIndex()));
    L13:
        int r106 = this.P0;
        if (r106 >= 0) goto L16;
        boolean r107 = this.L0;
    L20:
        if (r107 == false) goto L23;
        m7a.a r108 = new m7a.a(r104, "error");
        r108.a("errMsg", r100.getSummaryMessage() + ": " + r100.getRootCause());
        r108.a("lynx_categorized_code", Integer.valueOf(r101));
        r108.a("error_code", Integer.valueOf(r102));
        this.f467310b.getEventEmitter().sendCustomEvent(r108);
    L23:
        if (this.T == null) goto L27;
        r100.addCustomInfo(LynxError.LYNX_ERROR_KEY_IMAGE_CATEGORIZED_CODE, String.valueOf(r101));
        this.f467310b.reportResourceError(this.f467314d, "image", r100);
        return;
    L27:
        return;
    L16:
        if ((r106 & 2) == 0) goto L18;
        r107 = true;
        goto L20
    L18:
        r107 = false;
        goto L20
    L28:
        return;
    L26:
        return;
    L5:
        r104 = this.V0;
        goto L7
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        UIThreadUtils.runOnUiThreadAtTime(r101, r100, r102);
    }

    public final void l(int r100, int r101, int r110, int r111, int r112, int r113) {
        if (r100 > 0) goto L5;
        if (r101 > 0) goto L5;
        return;
    L5:
        int r102 = this.B;
        if (r100 == r102) goto L8;
    L9:
        if (r100 <= r102) goto L11;
    L12:
        this.f467309a |= 2048;
    L13:
        this.B = r100;
        this.C = r101;
        this.f467309a |= 512;
    L15:
        if (this.f467344y == r112) goto L17;
    L22:
        this.f467344y = r112;
        this.f467346z = r111;
        this.f467342x = r110;
        this.A = r113;
        this.f467309a |= 512;
        return;
    L17:
        if (this.f467346z != r111) goto L22;
        if (this.A != r113) goto L22;
        if (this.f467342x != r110) goto L22;
        return;
    L11:
        if (r101 <= this.C) goto L13;
    L8:
        if (r101 == this.C) goto L15;
        goto L9
    }

    public final void q(String r110, int r111, boolean r112, int r113, long r114, long r210, boolean r211, int r212, int r213) {
        if (this.L1 == false) goto L9;
        if (r110 != null) goto L6;
        return;
    L6:
        if (r110.startsWith("http") == false) goto L11;
        u7a.f.c(this.f467310b, r110, r111, r112, r113, r114, r210, r211, r212, r213, this.G1);
        return;
    L11:
        return;
    }
}
