package com.lynx.tasm.ui.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.utils.UIThreadUtils;
import com.optimize.statistics.FrescoTraceListener;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final Bitmap.Config f383942s0 = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final ConcurrentHashMap<String, FrescoImageView.d> f383943t0 = null;
    public final c A;
    public final Context B;
    public ReadableMap C;
    public boolean D;
    public LynxBaseUI E;
    public final Map<String, String> F;
    public final boolean G;
    public boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f383944J;
    public final boolean K;
    public final boolean L;
    public final g8a.a M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxContext f383945a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f383946a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f383947b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f383948b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f383949c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f383950c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f383951d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f383952d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f383953e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f383954e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f383955f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public String f383956f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f383957g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public String f383958g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f383959h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f383960h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f383961i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public GenericDraweeHierarchy f383962i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f383963j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f383964j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f383965k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final boolean f383966k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f383967l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f383968l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f383969m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public Rect f383970m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ShadowNode f383971n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f383972n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f383973o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final a f383974o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Bitmap.Config f383975p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public OptionalBool f383976p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f383977q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public OptionalBool f383978q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageResizeMethod f383979r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final ILynxImageService f383980r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public l8a.c f383981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f383982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f383983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f383984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f383985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public m8a.g f383986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public m8a.g f383987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f f383988z;

    public class a extends BaseAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f383989a;

        public a(h r100) {
            this.f383989a = r100;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationRepeat(AnimatedDrawable2 r100) {
            if (this.f383989a.S == true) goto L5;
            return;
        L5:
            if (r100.isRunning() == false) goto L9;
            h.a(this.f383989a, "currentloopcomplete");
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStart(AnimatedDrawable2 r100) {
            h r101 = this.f383989a;
            if (r101.R == false) goto L6;
            h.a(r101, "startplay");
            return;
        }

        @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
        public final void onAnimationStop(AnimatedDrawable2 r100) {
            if (this.f383989a.T == true) goto L5;
            return;
        L5:
            if (r100.isRunning() == false) goto L9;
            h.a(this.f383989a, "currentloopcomplete");
            h.a(this.f383989a, "finalloopcomplete");
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f383990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f383991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f383992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LynxContext f383993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f383994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ h f383995f;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f383996a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f383997b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f383998c;

            public final void a() {
                b r100 = this.f383998c;
                if (r100.f383992c == true) goto L5;
            L8:
                b r101 = this.f383998c;
                if (r101.f383994e == false) goto L11;
                h r102 = r101.f383995f;
                String r103 = this.f383997b;
                Bitmap.Config r104 = h.f383942s0;
                r102.t(r103);
            L11:
                f r105 = this.f383998c.f383995f.f383988z;
                if (r105 == null) goto L15;
                r105.a();
                return;
            L15:
                return;
            L5:
                if (TextUtils.equals(r100.f383990a, r100.f383995f.f383984v) == false) goto L7;
                this.f383998c.f383995f.w(this.f383996a);
                goto L8
            L7:
                LLog.w("Lynx-Image", "image redirect check failed curUrl = " + this.f383998c.f383995f.f383984v + " preUrl = " + this.f383998c.f383990a);
                goto L8
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

            public a(b r100, String r101, String r102) {
                this.f383998c = r100;
                this.f383996a = r101;
                this.f383997b = r102;
            }
        }

        public final void a() {
            String r100 = this.f383990a;
            String r101 = this.f383991b;
        L10:
            th = move-exception;
            LLog.e("Lynx-Image", "async redirect url failed, placeholder: " + this.f383991b + ", url:" + this.f383990a + ", msg:" + th.getMessage());
            r100 = this.f383990a;
            r101 = this.f383991b;
        L12:
            UIThreadUtils.runOnUiThread(new a(this, r100, r101));
            return;
        L4:
            if (this.f383992c == false) goto L7;
            r100 = this.f383995f.f(r100, this.f383993d);     // Catch: Throwable -> L10
        L7:
            if (this.f383994e == false) goto L12;
            r101 = this.f383995f.f(this.f383991b, this.f383993d);     // Catch: Throwable -> L10
            goto L12
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

        public b(h r100, String r101, String r102, boolean r103, LynxContext r104, boolean r105) {
            this.f383995f = r100;
            this.f383990a = r101;
            this.f383991b = r102;
            this.f383992c = r103;
            this.f383993d = r104;
            this.f383994e = r105;
        }
    }

    public interface c {
        void a();

        void b(List<Postprocessor> r100);

        ImageRequestBuilder c(Uri r100);

        void clear();

        void d();

        boolean e();

        void f(CloseableReference<?> r100);

        void g();

        void markDirty();
    }

    public static class d extends l8a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f383999a;

        @Override // l8a.a, com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
        public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
            ConcurrentHashMap<String, FrescoImageView.d> r102 = h.f383943t0;
            if (r102.containsKey(this.f383999a) == true) goto L6;
            r102.put(this.f383999a, new FrescoImageView.d(r100.getWidth(), r100.getHeight()));
        L6:
            return super.process(r100, r101);
        }

        public d(String r100, int r101, int r102, int r103, int r104, int r105, int r106, float[] r107, ScalingUtils.ScaleType r108, String r110, String r111, Bitmap.Config r112, boolean r113) {
            super(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113);
            this.f383999a = r100;
        }
    }

    static {
        f383942s0 = Bitmap.Config.ARGB_8888;
        f383943t0 = new ConcurrentHashMap();
        CloseableImage.class.getMethod("isHitBitmapMemoryCache", new Class[0]);     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        LLog.d("ImageDelegate", "Current Fresco version dose not support isHitBitmapMemoryCache");
    }

    public final void i() {
        LynxBaseUI r100 = this.E;
        if (r100 == null) goto L21;
        final int r101 = this.f383951d;
        if (r101 == 0) goto L22;
        final int r102 = this.f383953e;
        if (r102 == 0) goto L24;
        final boolean r103 = this.f383969m;
        final int r104 = r100.getWidth();
        final int r105 = this.E.getHeight();
        if (this.L == false) goto L13;
        this.E.getLynxContext().findShadowNodeAndRunTask(this.E.getSign(), new g(r103, r101, r102, r104, r105));
        return;
    L13:
        if (this.f383971n != null) goto L15;
        this.f383971n = this.E.getLynxContext().findShadowNodeBySign(this.E.getSign());
    L15:
        ShadowNode r106 = this.f383971n;
        if ((r106 instanceof AutoSizeImage) == true) goto L19;
        this.W = true;
        return;
    L19:
        ((AutoSizeImage) r106).D(r103, r101, r102, r104, r105);
        return;
    L24:
        return;
    L22:
        return;
    }

    public static void b(h r100) {
        r100.getClass();
        k r101 = new k(r100);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r101.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r101);
    }

    public final ImageRequestBuilder e(Uri r100) {
        Bitmap.Config r101 = this.f383975p;
        boolean r102 = this.V;
        ImageRequestBuilder r103 = ImageRequestBuilder.newBuilderWithSource(r100);
        m8a.e.b(r103, r101, r102);
        if (((HashMap) this.F).isEmpty() == true) goto L5;
        m8a.e.e(r103, this.F);
    L10:
        return r103;
    L5:
        LynxContext r104 = this.f383945a;
        if (r104 == null) goto L10;
        if (r104.getImageCustomParam() == null) goto L10;
        m8a.e.e(r103, this.f383945a.getImageCustomParam());
        goto L10
    }

    public final boolean m(String r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.equals(this.f383984v) == true) goto L6;
        return false;
    L6:
        if (r100.startsWith("http") == false) goto L14;
        int r101 = this.f383985w;
        this.f383985w = r101 - 1;
        if (r101 <= 0) goto L15;
        w(r100);
        this.A.markDirty();
        this.A.a();
        return true;
    L15:
        return false;
    L14:
        return false;
    }

    public final void p(int r100) {
        if (r100 != 0) goto L10;
        this.f383981s = null;
    L8:
        this.A.markDirty();
        return;
    L10:
        this.f383981s = new l8a.c(r100, this.f383945a);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        LLog.e("ImageDelegate", "setBlurRadius failed: " + th.getMessage());
        goto L8
    }

    public final void q(ReadableMap r100) {
        if (((HashMap) this.F).isEmpty() == true) goto L5;
        ((HashMap) this.F).clear();
    L5:
        if (r100 == null) goto L10;
        ReadableMapKeySetIterator r101 = r100.keySetIterator();
    L8:
        if (r101.hasNextKey() == false) goto L12;
        String r102 = r101.nextKey();
        Map<String, String> r103 = this.F;
        HashMap r104 = (HashMap) r103;
        r104.put(r102, r100.getString(r102, ""));
        goto L8
    L12:
        return;
    }

    public final void r(Map<String, EventsListener> r100) {
        this.R = false;
        this.S = false;
        this.T = false;
        if (r100.containsKey("startplay") == false) goto L6;
        this.R = true;
    L6:
        if (r100.containsKey("currentloopcomplete") == false) goto L9;
        this.S = true;
    L9:
        if (r100.containsKey("finalloopcomplete") == false) goto L12;
        this.T = true;
    L12:
        if (r100.containsKey("load") == false) goto L15;
        this.U = true;
        return;
    }

    public final void s(ReadableMap r110) {
        if (r110 == null) goto L16;
        String r100 = r110.getString("type");
        if ("preview".equalsIgnoreCase(r100) == false) goto L7;
        this.f383946a0 = true;
    L11:
        if (this.f383946a0 == false) goto L13;
    L14:
        this.f383950c0 = Math.round(com.lynx.tasm.utils.n.c(r110.getString("width"), this.f383945a.getUIBody().getFontSize(), this.E.getFontSize(), this.f383945a.getUIBody().getWidth(), this.f383945a.getUIBody().getHeight(), this.f383945a.getScreenMetrics()));
        this.f383952d0 = Math.round(com.lynx.tasm.utils.n.c(r110.getString("height"), this.f383945a.getUIBody().getFontSize(), this.E.getFontSize(), this.f383945a.getUIBody().getWidth(), this.f383945a.getUIBody().getHeight(), this.f383945a.getScreenMetrics()));
        this.f383954e0 = Math.round(com.lynx.tasm.utils.n.c(r110.getString("radius"), this.f383945a.getUIBody().getFontSize(), this.E.getFontSize(), this.f383945a.getUIBody().getWidth(), this.f383945a.getUIBody().getHeight(), this.f383945a.getScreenMetrics()));
        this.f383956f0 = r110.getString(faceverify.w.BLOB_ELEM_IMAGE_HASHCODE);
        this.f383958g0 = r110.getString("metaData");
        this.f383960h0 = r110.getInt("iterations", 1);
        return;
    L13:
        if (this.f383948b0 == true) goto L14;
        return;
    L7:
        if ("blur".equalsIgnoreCase(r100) == false) goto L9;
        this.f383948b0 = true;
        goto L11
    L9:
        this.f383946a0 = false;
        this.f383948b0 = false;
        goto L11
    }

    public final void t(String r100) {
        m8a.g r101 = this.f383987y;
        if (r101 != null) goto L5;
    L7:
        this.f383987y = null;
        if (r100 != null) goto L10;
    L14:
        this.A.markDirty();
        return;
    L10:
        if (r100.isEmpty() == true) goto L14;
        m8a.g r102 = new m8a.g(this.B, r100);
        this.f383987y = r102;
        if (Uri.EMPTY.equals(r102.b()) == false) goto L14;
        LLog.w("Lynx", "Warning: Image source \"" + r100 + "\" doesn't exist");
        goto L14
    L5:
        if (r101.f512532b.equals(r100) == false) goto L7;
    }

    public final void w(String r100) {
        m8a.g r101 = this.f383986x;
        if (r101 != null) goto L5;
    L7:
        this.f383986x = null;
        if (r100 != null) goto L10;
    L14:
        this.A.clear();
    L15:
        this.f383951d = 0;
        this.f383953e = 0;
        this.A.g();
        this.A.markDirty();
        return;
    L10:
        if (r100.isEmpty() == true) goto L14;
        m8a.g r102 = new m8a.g(this.B, r100);
        this.f383986x = r102;
        if (Uri.EMPTY.equals(r102.b()) == false) goto L15;
        LLog.w("Lynx", "Warning: Image source \"" + r100 + "\" doesn't exist");
        goto L15
    L5:
        if (r101.f512532b.equals(r100) == false) goto L7;
    }

    public h(Context r100, c r101) {
        boolean r102 = false;
        this.f383947b = 0;
        this.f383949c = 0;
        this.f383951d = 0;
        this.f383953e = 0;
        this.f383955f = false;
        this.f383957g = null;
        this.f383959h = null;
        this.f383961i = null;
        this.f383963j = null;
        this.f383965k = false;
        this.f383967l = false;
        this.f383969m = false;
        this.f383971n = null;
        this.f383975p = f383942s0;
        this.f383977q = 0;
        this.f383979r = ImageResizeMethod.RESIZE;
        this.f383982t = false;
        this.f383983u = false;
        this.f383988z = null;
        this.D = false;
        this.E = null;
        this.F = new HashMap();
        this.G = false;
        this.H = false;
        this.I = false;
        this.f383944J = false;
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = 0;
        this.O = false;
        this.Q = false;
        this.X = false;
        this.Y = false;
        this.Z = 0.0f;
        this.f383946a0 = false;
        this.f383948b0 = false;
        this.f383950c0 = 0;
        this.f383952d0 = 0;
        this.f383954e0 = 0;
        this.f383956f0 = null;
        this.f383958g0 = null;
        this.f383960h0 = 1;
        this.f383964j0 = false;
        this.f383966k0 = false;
        this.f383968l0 = false;
        this.f383972n0 = false;
        this.f383974o0 = new a(this);
        OptionalBool r103 = OptionalBool.UNDEFINED;
        this.f383976p0 = r103;
        this.f383978q0 = r103;
        this.B = r100;
        this.A = r101;
        LynxContext r104 = com.lynx.tasm.utils.a.a(r100);
        this.f383945a = r104;
        this.f383964j0 = true;
        this.f383980r0 = (ILynxImageService) i8a.n.c().a(ILynxImageService.class);
        if (r104 == null) goto L24;
        r104.getLynxImageConfig();
        if (this.f383955f == false) goto L7;
    L10:
        boolean r105 = true;
    L11:
        this.f383955f = r105;
        this.f383982t = r104.getEnableImageResourceHint();
        this.f383944J = r104.isEnableCheckLocalImage();
        this.G = r104.getEnableImageSmallDiskCache();
        this.I = LynxEnv.inst().enableImageEventReport();
        g8a.a r106 = r104.getMediaResourceFetcher();
        this.M = r106;
        if (r106 == null) goto L14;
        boolean r107 = true;
    L15:
        this.K = r107;
        if (LynxEnv.inst().enableImageAsyncRedirect() == false) goto L21;
        if (r107 == false) goto L19;
    L22:
        r102 = true;
    L23:
        this.X = r102;
        goto L24
    L19:
        if (r104.getAsyncImageInterceptor() != null) goto L22;
    L21:
        if (r104.isAsyncRedirect() == false) goto L23;
    L14:
        r107 = false;
        goto L15
    L7:
        if (r104.getEnableImageResourceHint() == true) goto L10;
        r105 = false;
    L24:
        this.f383966k0 = LynxEnv.inst().enableImageAsyncRedirectOnCreate();
        this.L = !LynxEnv.inst().enableImageAsyncLayout();
    }

    public static void a(h r100, String r101) {
        if (r100.f383945a == null) goto L8;
        LynxBaseUI r102 = r100.E;
        if (r102 == null) goto L9;
        m7a.a r103 = new m7a.a(r102.getSign(), r101);
        r100.f383945a.getEventEmitter().sendCustomEvent(r103);
        return;
    L9:
        return;
    }

    public final int c(int r100, int r101) {
        Bitmap.Config r102 = this.f383975p;
        if (r102 != null) goto L6;
        r102 = Bitmap.Config.ARGB_8888;
    L6:
        return u7a.g.a(r100, r101, r102);
    }

    public final String f(String r100, LynxContext r101) {
        if (this.K == true) goto L9;
        if (this.X == false) goto L16;
        return d7a.a.b(r101, r100, true);
    L16:
        return d7a.a.b(r101, r100, false);
    L9:
        if (TraceEvent.isTracingStarted() == false) goto L11;
        HashMap r102 = new HashMap();
        r102.put("url", r100);
        TraceEvent.beginSection("MediaFetcher.shouldRedirectImageUrl", r102);
    L11:
        String r103 = this.M.c(new LynxResourceRequest(r100, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage));
        if (TraceEvent.isTracingStarted() == false) goto L17;
        TraceEvent.endSection("MediaFetcher.shouldRedirectImageUrl");
        return r103;
    L17:
        return r103;
    }

    public final void u(String r110, String r111) {
        boolean r100 = false;
        if (r110 == null) goto L15;
        this.f383984v = r110;
        if (this.f383944J == false) goto L14;
        OptionalBool r101 = this.f383976p0;
        if (r101 != OptionalBool.FALSE) goto L10;
        w(r110);
        goto L15
    L10:
        if (r101 != OptionalBool.TRUE) goto L12;
    L13:
        this.f383985w = 1;
        goto L14
    L12:
        if (r101 == OptionalBool.UNDEFINED) goto L13;
    L14:
        boolean r102 = true;
    L16:
        if (r111 != null) goto L18;
    L23:
        boolean r112 = false;
    L24:
        if (r102 == true) goto L27;
        if (r112 == true) goto L27;
        return;
    L27:
        LynxContext r103 = com.lynx.tasm.utils.a.a(this.B);
        if (this.f383964j0 == false) goto L34;
        this.f383964j0 = false;
        if (this.f383966k0 == false) goto L34;
        if (UIThreadUtils.isOnUiThread() == true) goto L34;
    L35:
        if (r100 == false) goto L40;
        LynxContext r104 = this.f383945a;
        if (r104 == null) goto L39;
        LynxFeatureCounter.a(84, r104.getInstanceId());
    L39:
        LynxThreadPool.b().execute(new b(this, r110, r111, r102, r103, r112));
        return;
    L40:
        if (r102 == false) goto L42;
        w(f(r110, r103));
    L42:
        if (r112 == false) goto L46;
        t(f(r111, r103));
        return;
    L46:
        return;
    L34:
        r100 = this.X;
        goto L35
    L18:
        if (this.f383944J == true) goto L20;
    L22:
        r112 = true;
        goto L24
    L20:
        if (this.f383978q0 != OptionalBool.FALSE) goto L22;
        t(r111);
    L15:
        r102 = false;
        goto L16
    }

    public final void v(String r100, boolean r101) {
        if (r101 == false) goto L4;
        u(r100, null);
        return;
    L4:
        this.f383984v = r100;
        w(r100);
    }

    public final void x(int r110, int r111) {
        m8a.g r100 = this.f383986x;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f512532b != null) goto L7;
        return;
    L7:
        if (this.f383982t == true) goto L9;
        return;
    L9:
        if (this.B == null) goto L16;
        TraceEvent.beginSection("ImageDelegate.tryFetchImageFromLocalCache");
        long r101 = System.currentTimeMillis();
        String r102 = this.f383986x.f512532b;
        d7a.a.a(this.B, r102, r110, r111, new i(this, r102, r110, r111, r101));
        TraceEvent.endSection("ImageDelegate.tryFetchImageFromLocalCache");
        return;
    }

    public final boolean y(int r110, int r111) {
        m8a.g r100 = this.f383986x;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.f512532b != null) goto L7;
        return false;
    L7:
        if (this.f383982t == true) goto L9;
        return false;
    L9:
        if (this.f383945a == null) goto L17;
        TraceEvent.beginSection("ImageDelegate.tryFetchImageFromMediaFetcher");
        long r101 = System.currentTimeMillis();
        this.M.a(new LynxResourceRequest(this.f383986x.f512532b, LynxResourceRequest.LynxResourceType.LynxResourceTypeImage), new j(this, r110, r111, r101));
        TraceEvent.endSection("ImageDelegate.tryFetchImageFromMediaFetcher");
        return true;
    L17:
        return false;
    }

    public final JSONObject g(int r100, int r101, int r102, int r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L7
        r104.put("viewWidth", r100);     // Catch: JSONException -> L7
        r104.put("viewHeight", r101);     // Catch: JSONException -> L7
        r104.put("width", r102);     // Catch: JSONException -> L7
        r104.put("height", r103);     // Catch: JSONException -> L7
        Bitmap.Config r105 = this.f383975p;     // Catch: JSONException -> L7
        if (r105 != null) goto L5;
        r105 = f383942s0;     // Catch: JSONException -> L7
    L5:
        r104.put("config", r105);     // Catch: JSONException -> L7
        return r104;
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final void z(String r100, String r101, boolean r102, boolean r103) {
        if (this.f383944J == true) goto L5;
        return;
    L5:
        if (r102 == true) goto L8;
        if (r103 == true) goto L8;
        return;
    L8:
        if (this.K == true) goto L34;
        i8a.e r104 = (i8a.e) i8a.n.c().a(i8a.e.class);
        if (r104 != null) goto L14;
        LLog.e("ImageDelegate", "Unable to update redirect because ILynxResourceService cannot be obtained.");
        return;
    L14:
        if (r102 == false) goto L24;
        int r105 = r104.isLocalResource(r100);
        if (r105 != (-1)) goto L18;
        OptionalBool r106 = OptionalBool.UNDEFINED;
    L23:
        this.f383976p0 = r106;
        goto L24
    L18:
        if (r105 != 1) goto L20;
        r106 = OptionalBool.TRUE;
        goto L23
    L20:
        if (r105 != 0) goto L22;
        r106 = OptionalBool.FALSE;
        goto L23
    L22:
        r106 = OptionalBool.UNDEFINED;
    L24:
        if (r103 == false) goto L50;
        int r107 = r104.isLocalResource(r101);
        if (r107 != (-1)) goto L28;
        OptionalBool r108 = OptionalBool.UNDEFINED;
    L33:
        this.f383978q0 = r108;
        goto L50
    L28:
        if (r107 != 1) goto L30;
        r108 = OptionalBool.TRUE;
        goto L33
    L30:
        if (r107 != 0) goto L32;
        r108 = OptionalBool.FALSE;
        goto L33
    L32:
        r108 = OptionalBool.UNDEFINED;
    L50:
        if (r102 == false) goto L65;
        LynxContext r109 = this.f383945a;
        if (r109 != null) goto L54;
        return;
    L54:
        if (r109.isPrefetchImageOnCreate() == true) goto L56;
        return;
    L56:
        if (this.f383976p0 == OptionalBool.TRUE) goto L68;
        if (r100 != null) goto L59;
        return;
    L59:
        if (r100.startsWith("http") == true) goto L61;
        return;
    L61:
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L71;
        TraceEvent.beginSection("ImageDelegate.prefetchToDiskCache");
        Fresco.getImagePipeline().prefetchToDiskCache(ImageRequest.fromUri(r100), null);
        TraceEvent.endSection("ImageDelegate.prefetchToDiskCache");
        return;
    L71:
        return;
    L68:
        return;
    L65:
        return;
    L34:
        TraceEvent.beginSection("ImageDelegate.isLocalResource");
        if (r102 == false) goto L42;
        ILynxImageService r110 = this.f383980r0;
        if (r110 != null) goto L39;
    L41:
        this.f383976p0 = this.M.b(r100);
        goto L42
    L39:
        if (r110.canParseUrl(r100) == false) goto L41;
        this.f383976p0 = OptionalBool.FALSE;
    L42:
        if (r103 == false) goto L49;
        ILynxImageService r111 = this.f383980r0;
        if (r111 != null) goto L46;
    L48:
        this.f383978q0 = this.M.b(r101);
        goto L49
    L46:
        if (r111.canParseUrl(r101) == false) goto L48;
        this.f383978q0 = OptionalBool.FALSE;
    L49:
        TraceEvent.endSection("ImageDelegate.isLocalResource");
        goto L50
    }

    public final void j(final String r110, final boolean r111, final long r112, long r210, final int r211, final JSONObject r212) {
        boolean r100 = LynxEnv.inst().enableImageMemoryReport();
        final LynxContext r101 = com.lynx.tasm.utils.a.a(this.B);
        if (r100 == false) goto L17;
        LynxBaseUI r102 = this.E;
        if (r102 == null) goto L8;
        r102.getSign();
    L8:
        if (TextUtils.isEmpty(r110) == false) goto L11;
        return;
    L11:
        if (r112 > 0) goto L13;
        return;
    L13:
        if (r210 <= 0) goto L24;
        final long r103 = r210 - r112;
        final long r104 = System.currentTimeMillis();
        final long r105 = r104 - r112;
        LynxEventReporter.runOnReportThread(new u7a.c(r101, r110, r211, r104, r103, r105, r112, r111, r212));
        return;
    L24:
        return;
    L17:
        if (this.I == false) goto L22;
        u7a.f.b(r101, r110, r111, false, r112, r210, r211, r212);
        return;
    }

    public final void l(String r110, boolean r111, boolean r112, long r113, long r210, int r211, int r212) {
        LynxContext r100 = com.lynx.tasm.utils.a.a(this.B);
        if (this.I == false) goto L6;
        LynxThreadPool.b().execute(new u7a.d(r100, r113, r210, r111, r110, r212, r211, r112));
        return;
    }

    public final void o(int r100, int r101, int r102, int r103, long r104, long r110, int r111) {
        if (this.U == true) goto L5;
        return;
    L5:
        if (this.f383945a == null) goto L11;
        LynxBaseUI r105 = this.E;
        if (r105 == null) goto L12;
        m7a.a r106 = new m7a.a(r105.getSign(), "load");
        int r107 = c(r102, r103);
        r106.a("src", this.f383984v);
        r106.a("load_start", Long.valueOf(r104));
        r106.a("load_finish", Long.valueOf(r110));
        r106.a(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r110 - r104));
        r106.a("width", Integer.valueOf(r102));
        r106.a("height", Integer.valueOf(r103));
        r106.a(LynxMonitorService.KEY_MEMORY_COST, Integer.valueOf(r107));
        r106.a(PlayerResolution.SDKKEY.ORIGIN, Integer.valueOf(r111));
        r106.a("view_width", Integer.valueOf(r100));
        r106.a("view_height", Integer.valueOf(r101));
        this.f383945a.getEventEmitter().sendCustomEvent(r106);
        return;
    L12:
        return;
    }

    public final void h(int r210, int r211, ImageInfo r212, Animatable r213, long r214, boolean r215, int r216, l r217) {
        long r110 = System.currentTimeMillis();
        m8a.g r100 = this.f383986x;
        boolean r101 = false;
        if (r100 == null) goto L7;
        ConcurrentHashMap<String, FrescoImageView.d> r102 = f383943t0;
        if (r102.containsKey(r100.b().toString()) == false) goto L7;
        FrescoImageView.d r103 = r102.get(this.f383986x.b().toString());
        int r104 = r103.f383835a;
        int r105 = r103.f383836b;
    L9:
        int r111 = r105;
        int r112 = r104;
    L11:
        JSONObject r106 = g(r210, r211, r112, r111);
        if (r106 != null) goto L14;
    L22:
        if (r217 != null) goto L24;
        int r113 = r111;
    L40:
        int r114 = r112;
    L42:
        if ((r213 instanceof AnimatedDrawable2) == false) goto L55;
        AnimatedDrawable2 r107 = (AnimatedDrawable2) r213;
        if (this.T == false) goto L46;
    L51:
        r107.setAnimationListener(this.f383974o0);
    L52:
        r107.setAnimationBackend(new l8a.b(r107.getAnimationBackend(), this.N));
        if (this.O == true) goto L55;
        m8a.e.c(r107);
        goto L55
    L46:
        if (this.R == true) goto L51;
        if (this.S == true) goto L51;
        r107.setAnimationListener(null);
    L55:
        int r115 = c(r114, r113);
        this.f383977q = r115;
        j(this.f383984v, true, r214, r110, r115, r106);
        l(this.f383984v, true, false, r214, r110, 0, r115);
        k(this.f383984v, 0, false, r216, r214, r110, r215, r114, r113);
        return;
    L24:
        if (this.f383969m == true) goto L26;
    L30:
        if (r101 == false) goto L33;
        this.f383951d = r112;
        this.f383953e = r111;
        i();
    L33:
        if (this.Q == false) goto L35;
        o(r210, r211, r112, r111, r214, r110, r216);
        r113 = r111;
        goto L40
    L35:
        r106 = r106;
        int r218 = r111;
        if (this.P == false) goto L38;
        r110 = r110;
        r114 = r112;
        n(r210, r211, r112, r218, r214, r110, false, r216);
        r113 = r218;
        goto L42
    L38:
        r110 = r110;
        r113 = r218;
        r114 = r112;
        r217.onImageLoadSuccess(r114, r113);
        goto L42
    L26:
        if (this.f383951d != 0) goto L30;
        if (this.f383953e != 0) goto L30;
        r101 = true;
        goto L30
    L14:
        if (r213 == null) goto L17;
        if (r215 == false) goto L17;
        int r108 = 1;
    L57:
        r106.put("isFlattenAnim", r108);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    L17:
        r108 = 0;
    L7:
        if (r212 == null) goto L10;
        r104 = r212.getWidth();
        r105 = r212.getHeight();
        goto L9
    L10:
        r111 = 0;
        r112 = 0;
        goto L11
    }

    public final void n(int r210, int r211, int r212, int r213, long r214, long r215, boolean r216, int r217) {
        if (this.U == true) goto L5;
        return;
    L5:
        if (this.f383945a != null) goto L7;
        return;
    L7:
        if (this.E == null) goto L42;
        int r110 = c(r212, r213);
        long r111 = r215 - r214;
        if (this.f383986x == null) goto L21;
        String r100 = this.f383984v;
        if (r100 == null) goto L21;
        if (r100.startsWith("data") == false) goto L16;
        String r101 = TTVideoEngineInterface.PLAY_API_KEY_BASE64;
    L22:
        String r112 = r101;
        JSONObject r113 = g(r210, r211, r212, r213);
        JSONObject r102 = u7a.f.a(this.f383945a, this.f383984v, true, r216, r214, r111, r111, r215, r110, r113);
        if (r102 == null) goto L43;
        m7a.a r103 = new m7a.a(this.E.getSign(), "load");
        Iterator<String> r104 = r102.keys();
    L26:
        if (r104.hasNext() == false) goto L33;
        String r105 = r104.next();
        Object r106 = r102.get(r105);     // Catch: JSONException -> L30
    L32:
        r103.a(r105, r106);
    L30:
        e = move-exception;
        e.printStackTrace();
        r106 = null;
        goto L32
    L33:
        r103.a("resourceFrom", r112);
        r103.a("width", Integer.valueOf(r212));
        r103.a("height", Integer.valueOf(r213));
        r103.a(PlayerResolution.SDKKEY.ORIGIN, Integer.valueOf(r217));
        this.f383945a.getEventEmitter().sendCustomEvent(r103);
        return;
    L43:
        return;
    L16:
        if (this.f383984v.startsWith("http") == true) goto L18;
    L20:
        r101 = "local resource";
        goto L22
    L18:
        if (this.f383986x.f512532b.equals(this.f383984v) == false) goto L20;
        r101 = "cdn";
    L21:
        r101 = "";
        goto L22
    }

    public final l8a.d d(m8a.g r210, int r211, int r212, int r213, int r214, int r215, int r216, float[] r310, ScalingUtils.ScaleType r311) {
        Postprocessor r110 = null;
        if (r210 != null) goto L5;
        return null;
    L5:
        TraceEvent.beginSection("ImageDelegate.createImageRequest");
        ImageRequestBuilder r111 = this.A.c(r210.b());
        r111.setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.f383973o);
        if (this.f383955f == true) goto L33;
        if (this.Y == true) goto L33;
        if (this.f383972n0 == true) goto L33;
        if (this.f383970m0 != null) goto L33;
        if (m8a.f.a(r210, this.f383979r) == true) goto L16;
    L18:
        boolean r100 = false;
    L19:
        if (r100 == false) goto L30;
        int r101 = this.f383947b;
        int r102 = this.f383949c;
        if (r101 <= 0) goto L29;
        if (r102 <= 0) goto L29;
        if (Math.abs(r211 - r101) > 1) goto L29;
        if (Math.abs(r212 - r102) > 1) goto L29;
        ResizeOptions r103 = new ResizeOptions(r101, r102);
    L31:
        r111.setResizeOptions(r103);
    L29:
        r103 = new ResizeOptions(r211, r212);
        goto L31
    L30:
        r103 = null;
        goto L31
    L16:
        if (this.f383969m == true) goto L18;
        r100 = true;
    L33:
        if (this.G == false) goto L38;
        if (r111.getCacheChoice() != ImageRequest.CacheChoice.DEFAULT) goto L38;
        r111.setCacheChoice(ImageRequest.CacheChoice.SMALL);
    L38:
        if (this.H == false) goto L40;
        r111.setRequestPriority(Priority.HIGH);
    L40:
        boolean r104 = this.A.e();
        LinkedList r112 = new LinkedList();
        if (this.Y == false) goto L47;
        ILynxImageService r105 = this.f383980r0;
        if (r105 == null) goto L47;
        r112.add((Postprocessor) r105.getImageSRPostProcessor());
        float r106 = this.Z;
        if (r106 <= 0.0f) goto L47;
        this.f383980r0.setImageSRSize(r111, (int) (r211 * r106), (int) (r212 * r106));
    L47:
        if (r104 == false) goto L53;
        if (r211 <= 0) goto L53;
        if (r212 <= 0) goto L53;
        if (this.D == true) goto L53;
        LinkedList r107 = r112;
        r107.add(new d(r210.b().toString(), r211, r212, r213, r214, r215, r216, r310, r311, this.f383957g, this.f383959h, this.f383975p, this.f383965k));
    L54:
        LinkedList r108 = r107;
        l8a.c r109 = this.f383981s;
        if (r109 == null) goto L57;
        r108.add(r109);
    L57:
        this.A.b(r108);
        int r113 = r108.size();
        if (r113 == 0) goto L63;
        int r114 = 1;
        if (r113 == 1) goto L62;
        Postprocessor r115 = new m0(r108);
        char r116 = 0;
    L65:
        if (r115 == null) goto L77;
        m8a.g r117 = this.f383986x;
        if (r117 == null) goto L74;
        String r118 = r117.b().toString().toLowerCase();
        if (r118.endsWith(EffectConstants.GIF_FILE_SUFFIX) == true) goto L74;
        if (r118.endsWith(".apng") == true) goto L74;
        boolean r119 = true;
    L75:
        if (r119 == false) goto L77;
        ImageRequestBuilder r120 = r111;
        r120.setPostprocessor(r115);
    L79:
        if (TextUtils.isEmpty(this.f383961i) == false) goto L81;
    L87:
        boolean r121 = this.f383968l0;
        if (r121 == false) goto L106;
        Method r122 = m8a.e.f512526d;
        if (r122 != null) goto L144;
    L97:
        r120.setProgressiveRenderingEnabled(this.f383968l0);
        boolean r123 = this.f383968l0;
        Method r124 = m8a.e.f512527e;
        if (r124 == null) goto L106;
        Object[] r125 = new Object[r114];     // Catch: InvocationTargetException -> L101 IllegalAccessException -> L103
        r125[r116] = Boolean.valueOf(r123);     // Catch: InvocationTargetException -> L101 IllegalAccessException -> L103
        r124.invoke(r120, r125);     // Catch: InvocationTargetException -> L101 IllegalAccessException -> L103
    L103:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
    L101:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
        goto L106
    L144:
        Object[] r126 = new Object[r114];     // Catch: InvocationTargetException -> L93 IllegalAccessException -> L95
        r126[r116] = Boolean.valueOf(r121);     // Catch: InvocationTargetException -> L93 IllegalAccessException -> L95
        r122.invoke(r120, r126);     // Catch: InvocationTargetException -> L93 IllegalAccessException -> L95
    L95:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
    L93:
        e = move-exception;
        LLog.e(FrescoTraceListener.ALOGTAG, Log.getStackTraceString(e));
    L106:
        if (TextUtils.isEmpty(this.f383963j) == true) goto L111;
        ILynxImageService r127 = this.f383980r0;
        if (r127 == null) goto L111;
        r127.setImageCacheChoice(this.f383963j, r120);
    L111:
        if (this.f383967l == false) goto L122;
        if (this.f383980r0 == null) goto L122;
        Uri r128 = r210.b();
        String r129 = r128.getScheme();
        if (r129 == null) goto L122;
        if (r129.startsWith("http") == false) goto L122;
        String r130 = r128.getPath();
        if (TextUtils.isEmpty(r130) == true) goto L122;
        this.f383980r0.setCacheKeyUri(r120, UriProtector.parse(r130));
    L122:
        if (this.f383972n0 == false) goto L126;
        ILynxImageService r131 = this.f383980r0;
        if (r131 == null) goto L126;
        r131.setSampleSize(r120, r114);
    L126:
        Rect r132 = this.f383970m0;
        if (r132 == null) goto L131;
        ILynxImageService r133 = this.f383980r0;
        if (r133 == null) goto L131;
        r133.setImageDecodeRegion(r120, r132);
    L131:
        l8a.d r134 = new l8a.d(r120, this.C);
        if (TextUtils.isEmpty(this.f383956f0) == true) goto L140;
        boolean r135 = this.f383946a0;
        if (r135 == false) goto L136;
    L137:
        ILynxImageService r136 = this.f383980r0;
        if (r136 == null) goto L140;
        r136.setImagePlaceHolderHash(this.f383962i0, r134, r311, this.f383956f0, this.f383958g0, this.f383950c0, this.f383952d0, this.f383954e0, this.f383960h0, r135);
        goto L140
    L136:
        if (this.f383948b0 == true) goto L137;
    L140:
        TraceEvent.endSection("ImageDelegate.createImageRequest");
        return r134;
    L81:
        if ("high".equalsIgnoreCase(this.f383961i) == false) goto L84;
        r120.setRequestPriority(Priority.HIGH);
        goto L87
    L84:
        if ("low".equalsIgnoreCase(this.f383961i) == false) goto L86;
        r120.setRequestPriority(Priority.LOW);
        goto L87
    L86:
        r120.setRequestPriority(Priority.MEDIUM);
    L74:
        r119 = false;
    L77:
        r120 = r111;
        goto L79
    L62:
        r116 = 0;
        r110 = (Postprocessor) ListProtector.get(r108, 0);
    L64:
        r115 = r110;
        goto L65
    L63:
        r116 = 0;
        r114 = 1;
    L53:
        r107 = r112;
        goto L54
    }

    public final void k(String r110, int r111, boolean r112, int r113, long r210, long r211, boolean r212, int r213, int r214) {
        if (this.I == true) goto L5;
        return;
    L5:
        if (r110.startsWith("http") == false) goto L9;
        u7a.f.c(com.lynx.tasm.utils.a.a(this.B), r110, r111, r112, r113, r210, r211, r212, r213, r214, this.F);
        return;
    }
}
