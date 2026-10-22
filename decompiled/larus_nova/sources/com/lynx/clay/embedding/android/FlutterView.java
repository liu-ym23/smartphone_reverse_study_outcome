package com.lynx.clay.embedding.android;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.FlutterJNI;
import com.lynx.clay.embedding.engine.accessibility.ClayAccessibilityBridge;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttm.player.MediaPlayer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterView extends FrameLayout implements NestedScrollingChild2 {
    public static final /* synthetic */ int O = 0;
    public AccessibilityManager A;
    public com.lynx.clay.embedding.android.g B;
    public NestedScrollingChildHelper C;
    public final FlutterRenderer.ViewportMetrics D;
    public final d E;
    public boolean F;
    public boolean G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f380513J;
    public int K;
    public int L;
    public int M;
    public final e N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterSurfaceView f380514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterTextureView f380515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FlutterFunctorView f380516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlutterDelegateView f380517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FlutterImageView f380518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SurfaceSnapshotController f380519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s5a.c f380520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RenderMode f380521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<s5a.b> f380522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380523j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f380524k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f380525l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f380526m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final n5a.b f380527n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public n5a.i f380528o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DisplayMetrics f380529p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f380530q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FlutterEngine f380531r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Set<f> f380532s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public u5a.b f380533t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f380534u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f380535v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public com.lynx.clay.embedding.android.a f380536w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.lynx.clay.embedding.android.b f380537x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public GestureMediator f380538y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ClayAccessibilityBridge f380539z;

    public static final enum TransparencyMode extends Enum<TransparencyMode> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransparencyMode[] f380540a = null;
        public static final TransparencyMode opaque = null;
        public static final TransparencyMode transparent = null;

        static {
            TransparencyMode r100 = new TransparencyMode("opaque", 0);
            opaque = r100;
            TransparencyMode r101 = new TransparencyMode(ECPromotion.TRANSPARENT_BOTTON_ICON, 1);
            transparent = r101;
            f380540a = new TransparencyMode[]{r100, r101};
        }

        public static TransparencyMode[] values() {
            return (TransparencyMode[]) f380540a.clone();
        }

        public static TransparencyMode valueOf(String r100) {
            return (TransparencyMode) r27.a.a(TransparencyMode.class, r100);
        }

        public TransparencyMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ZeroSides extends Enum<ZeroSides> {
        public static final ZeroSides BOTH = null;
        public static final ZeroSides LEFT = null;
        public static final ZeroSides NONE = null;
        public static final ZeroSides RIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ZeroSides[] f380541a = null;

        static {
            ZeroSides r100 = new ZeroSides(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ZeroSides r101 = new ZeroSides("LEFT", 1);
            LEFT = r101;
            ZeroSides r102 = new ZeroSides("RIGHT", 2);
            RIGHT = r102;
            ZeroSides r103 = new ZeroSides("BOTH", 3);
            BOTH = r103;
            f380541a = new ZeroSides[]{r100, r101, r102, r103};
        }

        public static ZeroSides[] values() {
            return (ZeroSides[]) f380541a.clone();
        }

        public static ZeroSides valueOf(String r100) {
            return (ZeroSides) r27.a.a(ZeroSides.class, r100);
        }

        public ZeroSides(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterView f380542a;

        @Override // java.lang.Runnable
        public final void run() {
            FlutterView r100 = this.f380542a;     // Catch: Throwable -> L8
            if (r100.f380514a != null) goto L5;
            return;
        L5:
            if (r100.i() == false) goto L15;
            this.f380542a.j();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }

        public a(FlutterView r100) {
            this.f380542a = r100;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterView f380543a;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            FlutterView r100 = this.f380543a;
            int r101 = FlutterView.O;
            r100.l();
        }

        public b(FlutterView r100) {
            this.f380543a = r100;
        }
    }

    public class c {
        public c() {
        }
    }

    public class d implements s5a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterView f380544a;

        @Override // s5a.b
        public final void a() {
            FlutterView r100 = this.f380544a;
            r100.f380523j = false;
            Iterator<s5a.b> r101 = r100.f380522i.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            r101.next().a();
            goto L4
        }

        @Override // s5a.b
        public final void b() {
            FlutterView r100 = this.f380544a;
            r100.f380523j = true;
            Iterator r101 = ((HashSet) r100.f380522i).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((s5a.b) r101.next()).b();
            goto L4
        }

        public d(FlutterView r100) {
            this.f380544a = r100;
        }
    }

    public class e implements s5a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlutterView f380545a;

        public e(FlutterView r100) {
            this.f380545a = r100;
        }

        @Override // s5a.a
        public final void a(int r110, int r111) {
            FlutterView r100 = this.f380545a;
            int r101 = r100.M;
            if (r101 == r110) goto L5;
        L7:
            int r102 = r100.L;
            boolean r103 = r100.F;
            boolean r104 = r100.H;
            int r105 = r100.I;
            boolean r106 = true;
            if (r103 == true) goto L26;
            if (r104 == false) goto L14;
            if (r101 == (-1)) goto L13;
            if (r101 <= r105) goto L14;
        L13:
            int r107 = r105;
        L17:
            if (r104 == false) goto L21;
            if (r110 == (-1)) goto L24;
            if (r110 <= r105) goto L21;
        L24:
            if (r107 == r105) goto L26;
            boolean r108 = true;
        L27:
            if (r108 == true) goto L57;
            boolean r109 = r100.G;
            boolean r112 = r100.f380513J;
            int r113 = r100.K;
            if (r109 == true) goto L47;
            if (r112 == false) goto L35;
            if (r102 == (-1)) goto L34;
            if (r102 <= r113) goto L35;
        L34:
            int r114 = r113;
        L38:
            if (r112 == false) goto L42;
            if (r111 == (-1)) goto L45;
            if (r111 <= r113) goto L42;
        L45:
            if (r114 == r113) goto L47;
            boolean r115 = true;
        L48:
            if (r115 == true) goto L57;
            if (r101 != r110) goto L51;
        L52:
            if (r102 != r111) goto L54;
        L56:
            r106 = false;
            goto L57
        L54:
            if (r100.getMeasuredHeight() == r111) goto L56;
        L51:
            if (r100.getMeasuredWidth() != r110) goto L57;
        L42:
            if (r111 != (-1)) goto L44;
            r113 = 0;
            goto L45
        L44:
            r113 = r111;
        L35:
            if (r102 != (-1)) goto L37;
            r114 = 0;
            goto L38
        L37:
            r114 = r102;
        L47:
            r115 = false;
        L57:
            FlutterView r116 = this.f380545a;
            r116.M = r110;
            r116.L = r111;
            if (r106 == false) goto L61;
            r116.requestLayout();
            return;
        L61:
            return;
        L21:
            if (r110 != (-1)) goto L23;
            r105 = 0;
            goto L24
        L23:
            r105 = r110;
        L14:
            if (r101 != (-1)) goto L16;
            r107 = 0;
            goto L17
        L16:
            r107 = r101;
        L26:
            r108 = false;
            goto L27
        L5:
            if (r100.L != r111) goto L7;
        }
    }

    public interface f {
        void a();

        void b();
    }

    public interface g {
    }

    private AccessibilityManager getAccessibilityManager() {
        if (this.A != null) goto L14;
        Context r100 = getContext();
        if (r100 == null) goto L7;
        Context r101 = r100.getApplicationContext();
    L8:
        if (r101 == null) goto L10;
        r100 = r101;
    L10:
        if (r100 != null) goto L12;
        return null;
    L12:
        this.A = (AccessibilityManager) r100.getSystemService("accessibility");
        goto L14
    L7:
        r101 = null;
    L14:
        return this.A;
    }

    public final com.lynx.clay.embedding.android.a c() {
        if (this.f380536w != null) goto L6;
        this.f380536w = new com.lynx.clay.embedding.android.a(this, this.f380531r.f380695b, f());
    L6:
        return this.f380536w;
    }

    public final com.lynx.clay.embedding.android.b d() {
        if (this.f380537x != null) goto L6;
        this.f380537x = new com.lynx.clay.embedding.android.b(this.f380531r.f380695b, false);
    L6:
        return this.f380537x;
    }

    public final ClayAccessibilityBridge e() {
        if (this.f380539z != null) goto L11;
        com.lynx.clay.embedding.engine.accessibility.a r100 = this.f380531r.f380698e;
        this.f380539z = new ClayAccessibilityBridge();
        AccessibilityManager r101 = this.A;
        if (r101 == null) goto L9;
        com.lynx.clay.embedding.android.g r102 = this.B;
        if (r102 == null) goto L9;
        r101.removeAccessibilityStateChangeListener(r102);
    L9:
        this.B = null;
    L11:
        return this.f380539z;
    }

    public final u5a.b f() {
        FlutterEngine r100 = this.f380531r;
        if (r100 == null) goto L27;
        FlutterRenderer r101 = r100.f380695b;
        if (r101 == null) goto L25;
        if (this.f380533t != null) goto L9;
        this.f380533t = new u5a.b(this, r101);
    L9:
        FlutterEngine r102 = this.f380531r;
        if (r102 == null) goto L23;
        if (this.f380533t == null) goto L23;
        if (this.f380534u == false) goto L23;
        if (this.f380535v == true) goto L23;
        if (r102.f380699f == null) goto L23;
        this.f380535v = true;
    L23:
        return this.f380533t;
    L25:
        throw new IllegalStateException("Cannot initialize TextInputPlugin: flutterEngine renderer is null.");
    L27:
        throw new IllegalStateException("Cannot initialize TextInputPlugin: flutterEngine is null.");
    }

    public final void h() {
        ViewGroup.LayoutParams r100 = new FrameLayout.LayoutParams(-1, -1);
        FlutterSurfaceView r101 = this.f380514a;
        if (r101 != null) goto L5;
        View r102 = this.f380515b;
        if (r102 == null) goto L18;
        addView(r102, r100);
        String r103 = "TextureView";
    L26:
        if (c5a.a.f22523a.booleanValue() == false) goto L32;
        TextView r104 = new TextView(getContext());
        r104.setTextColor(-65536);
        if (c5a.a.f22524b.booleanValue() == false) goto L30;
        String r105 = " + Skity";
    L31:
        r104.setText(r103.concat(r105));
        addView(r104, new LinearLayout.LayoutParams(-2, -2));
        goto L32
    L30:
        r105 = " + Skia";
    L32:
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT < 26) goto L35;
        setImportantForAutofill(4);
    L35:
        this.D.fontScale = getResources().getConfiguration().fontScale;
        FlutterRenderer.ViewportMetrics r106 = this.D;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L38;
        boolean r107 = true;
    L39:
        r106.nightMode = r107;
        this.C = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        setWillNotDraw(false);
        return;
    L38:
        r107 = false;
        goto L39
    L18:
        View r108 = this.f380516c;
        if (r108 == null) goto L21;
        addView(r108, r100);
        r103 = "FunctorView";
        goto L26
    L21:
        View r109 = this.f380517d;
        if (r109 == null) goto L24;
        addView(r109, r100);
        r103 = "DelegateView";
        goto L26
    L24:
        addView(this.f380518e, r100);
        r103 = "ImageView";
        goto L26
    L5:
        if ((!r101.f380498a) == false) goto L11;
        SurfaceSnapshotController r110 = new SurfaceSnapshotController(this);
        this.f380519f = r110;
        FlutterSurfaceView r111 = this.f380514a;
        FlutterSurfaceView r112 = r110.f380592b;
        if (r112 == null) goto L10;
        if (r112 == r111) goto L10;
        r112.setSurfaceSnapshotDelegate(null);
        r110.c();
    L10:
        r110.f380592b = r111;
        r111.setSurfaceSnapshotDelegate(r110);
    L11:
        addView(this.f380514a, r100);
        SurfaceSnapshotController r113 = this.f380519f;
        if (r113 == null) goto L14;
        r113.d();
    L14:
        r103 = "SurfaceView";
        goto L26
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean hasNestedScrollingParent() {
        return this.C.hasNestedScrollingParent();
    }

    public final boolean i() {
        FlutterEngine r100 = this.f380531r;
        if (r100 == null) goto L9;
        s5a.c r101 = this.f380520g;
        if (r101 == null) goto L9;
        if (r100.f380695b != r101.getAttachedRenderer()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return this.C.isNestedScrollingEnabled();
    }

    public final void l() {
        SurfaceSnapshotController r100 = this.f380519f;
        int r101 = 0;
        if (r100 == null) goto L17;
        boolean r102 = isShown();
        if (r100.f380598h == r102) goto L31;
        r100.f380598h = r102;
        if (r100.f380592b == null) goto L32;
        if (r102 == true) goto L13;
        r100.m();
        return;
    L13:
        if (r100.j() == false) goto L15;
        r100.n();
        return;
    L15:
        r100.e();
        r100.f380592b.setVisibility(0);
        return;
    L32:
        return;
    L31:
        return;
    L17:
        if (this.f380514a == null) goto L29;
        boolean r103 = isShown();
        if (this.f380525l == r103) goto L30;
        this.f380525l = r103;
        FlutterSurfaceView r104 = this.f380514a;
        if (r103 == true) goto L24;
        r101 = 4;
    L24:
        r104.setVisibility(r101);
        return;
    L30:
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final void stopNestedScroll() {
        this.C.stopNestedScroll();
    }

    public final void b() {
        if (i() == true) goto L5;
        return;
    L5:
        removeCallbacks(this.f380524k);
        SurfaceSnapshotController r100 = this.f380519f;
        if (r100 == null) goto L8;
        r100.c();
    L8:
        Iterator r101 = ((HashSet) this.f380532s).iterator();
    L10:
        if (r101.hasNext() == false) goto L13;
        ((f) r101.next()).a();
        goto L10
    L13:
        if (this.f380535v == false) goto L15;
        this.f380531r.f380699f.getClass();
        this.f380535v = false;
    L15:
        PlatformViewsController r102 = this.f380531r.f380699f;
        int r103 = 0;
    L17:
        if (r103 >= r102.f380949g.size()) goto L19;
        e5a.a r104 = r102.f380949g.valueAt(r103);
        r102.f380945c.removeView(r104);
        r103 = r103 + 1;
        goto L17
    L19:
        r102.f380945c = null;
        r102.f380950h = false;
        this.f380534u = false;
        FlutterEngine r105 = this.f380531r;
        r105.f380699f.f380944b = null;
        com.lynx.clay.embedding.engine.a r106 = r105.f380697d;
        Iterator r107 = ((HashMap) r106.f380707a).keySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        Class r108 = (Class) r107.next();
        f5a.a r109 = (f5a.a) ((HashMap) r106.f380707a).get(r108);
        if (r109 == null) goto L21;
        r109.c();
        goto L21
    L25:
        ClayPluginContext r110 = this.f380531r.f380696c;
        if (r110.f380756a == null) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == true) goto L31;
        c5a.c.d(5, "ClayPluginContext", "already detached from flutter view");
    L32:
        AccessibilityManager r112 = this.A;
        if (r112 == null) goto L37;
        com.lynx.clay.embedding.android.g r113 = this.B;
        if (r113 == null) goto L37;
        r112.removeAccessibilityStateChangeListener(r113);
    L37:
        this.B = null;
        if (this.f380539z == null) goto L40;
        this.f380539z = null;
    L40:
        com.lynx.clay.embedding.android.a r114 = this.f380536w;
        if (r114 == null) goto L43;
        r114.f380629a.f380933a.setEventResponseHandler(null);
        r114.f380629a = null;
        com.lynx.clay.embedding.android.a.C4544a r115 = r114.f380632d;
        r115.f380634b = null;
        r115.f380635c = null;
        r114.f380632d = null;
        r114.f380630b.f548891b.f380933a.setInputMethodHandler(null);
        r114.f380630b = null;
        this.f380536w = null;
        this.f380533t = null;
    L46:
        FlutterRenderer r116 = this.f380531r.f380695b;
        this.f380523j = false;
        d r117 = this.E;
        r116.f380933a.removeIsDisplayingFlutterUiListener(r117);
        e r118 = this.N;
        r116.f380933a.removeRootContentSizeListener(r118);
        this.M = -1;
        this.L = -1;
        this.F = false;
        this.G = false;
        this.H = false;
        this.f380513J = false;
        this.I = 0;
        this.K = 0;
        r116.b(false);
        r116.f380933a.setClaySemanticsEnabled(false);
        this.f380520g.b();
        this.f380520g = null;
        this.f380518e = null;
        this.f380531r = null;
        this.f380538y = null;
        this.f380537x = null;
        this.f380533t = null;
        return;
    L43:
        u5a.b r119 = this.f380533t;
        if (r119 == null) goto L46;
        r119.f548891b.f380933a.setInputMethodHandler(null);
        this.f380533t = null;
        goto L46
    L31:
        r110.f380756a = null;
        goto L32
    L28:
        r111 = false;
        goto L29
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        if (i() == true) goto L5;
        return null;
    L5:
        if (this.f380539z != null) goto L14;
        AccessibilityManager r100 = getAccessibilityManager();
        if (r100 != null) goto L9;
    L11:
        boolean r101 = false;
    L12:
        if (r101 == true) goto L14;
        return null;
    L9:
        if (r100.isEnabled() == false) goto L11;
        r101 = true;
    L14:
        e().getClass();
        return null;
    }

    public com.lynx.clay.embedding.android.a getAndroidKeyProcessor() {
        if (i() == false) goto L6;
        return c();
    L6:
        return this.f380536w;
    }

    public com.lynx.clay.embedding.android.b getAndroidTouchProcessor() {
        if (i() == false) goto L6;
        return d();
    L6:
        return this.f380537x;
    }

    public final void j() {
        if (i() == true) goto L5;
        return;
    L5:
        DisplayMetrics r100 = this.f380529p;
        if (r100 != null) goto L9;
        Resources r101 = getResources();
        r100 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
    L9:
        FlutterRenderer.ViewportMetrics r102 = this.D;
        r102.screenWidth = r100.widthPixels;
        r102.screenHeight = r100.heightPixels;
        r102.devicePixelRatio = r100.density;
        r102.densityDpi = r100.densityDpi;
        FlutterRenderer r103 = this.f380531r.f380695b;
        r103.getClass();
        c5a.c.e();
        r103.f380933a.setViewportMetrics(r102);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f380526m);
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f380526m);
        l();
    }

    public FlutterEngine getAttachedFlutterEngine() {
        return this.f380531r;
    }

    public n5a.i getExternalPlatformViewContext() {
        return this.f380528o;
    }

    public n5a.i getInternalPlatformViewContext() {
        return this.f380527n;
    }

    public g getKeyboardEventStartCallback() {
        return this.f380530q;
    }

    public FlutterView(Context r100) {
        this(r100, null, new FlutterSurfaceView(r100));
    }

    public final void a(FlutterEngine r100) {
        if (i() == true) goto L5;
    L8:
        this.M = -1;
        this.L = -1;
        boolean r101 = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.f380513J = false;
        this.I = 0;
        this.K = 0;
        this.f380531r = r100;
        r100.f380701h = this.f380521h;
        FlutterRenderer r102 = r100.f380695b;
        this.f380523j = r102.f380936d;
        this.f380520g.a(r102);
        d r103 = this.E;
        r102.f380933a.addIsDisplayingFlutterUiListener(r103);
        if (r102.f380936d == false) goto L11;
        r103.b();
    L11:
        e r104 = this.N;
        r102.f380933a.addRootContentSizeListener(r104);
        if (this.f380539z != null) goto L24;
        AccessibilityManager r105 = getAccessibilityManager();
        if (r105 == null) goto L24;
        if (r105.isEnabled() == false) goto L21;
        e();
        goto L24
    L21:
        if (this.B != null) goto L24;
        com.lynx.clay.embedding.android.g r106 = new com.lynx.clay.embedding.android.g(this);
        this.B = r106;
        r105.addAccessibilityStateChangeListener(r106);
    L24:
        PlatformViewsController r107 = r100.f380699f;
        FlutterRenderer r108 = this.f380531r.f380695b;
        r107.getClass();
        r107.f380943a = new com.lynx.clay.embedding.android.b(r108, true);
        j();
        PlatformViewsController r109 = r100.f380699f;
        Context r110 = getContext();
        if (r109.f380944b != null) goto L63;
        r109.f380944b = r110;
        PlatformViewsController r111 = r100.f380699f;
        r111.f380945c = this;
        int r112 = 0;
    L28:
        if (r112 >= r111.f380949g.size()) goto L35;
        int r113 = r111.f380949g.keyAt(r112);
        e5a.a r114 = r111.f380949g.valueAt(r112);
        View r115 = r111.f380946d.get(r113);
        if (r115 != null) goto L32;
    L33:
        r111.f380945c.addView(r114);
    L34:
        r112 = r112 + 1;
        goto L28
    L32:
        if (r115.willNotDraw() == true) goto L34;
    L35:
        this.f380534u = true;
        u5a.b r116 = f();
        if (hasFocus() == true) goto L38;
    L42:
        com.lynx.clay.embedding.engine.a r117 = r100.f380697d;
        Iterator r118 = ((HashMap) r117.f380707a).keySet().iterator();
    L44:
        if (r118.hasNext() == false) goto L48;
        Class r119 = (Class) r118.next();
        f5a.a r120 = (f5a.a) ((HashMap) r117.f380707a).get(r119);
        if (r120 == null) goto L44;
        r120.b();
        goto L44
    L48:
        ClayPluginContext r121 = r100.f380696c;
        if (r121.f380756a == null) goto L51;
        r101 = true;
    L51:
        if (r101 == false) goto L53;
        c5a.c.d(5, "ClayPluginContext", "already attached to flutter view");
    L54:
        Iterator r122 = ((HashSet) this.f380532s).iterator();
    L56:
        if (r122.hasNext() == false) goto L59;
        ((f) r122.next()).b();
        goto L56
    L59:
        if (this.f380523j == false) goto L73;
        this.E.b();
        return;
    L73:
        return;
    L53:
        r121.f380756a = this;
        goto L54
    L38:
        if (getWindowToken() == null) goto L42;
        r116.getClass();
        InputMethodManager r123 = u5a.b.f548889h;
        if (r123 == null) goto L42;
        r123.restartInput(this);
        goto L42
    L63:
        throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    L5:
        if (r100 != this.f380531r) goto L7;
        return;
    L7:
        b();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100.getAction() != 0) goto L8;
        if (r100.getRepeatCount() != 0) goto L8;
        getKeyDispatcherState().startTracking(r100, this);
    L11:
        if (r100.getKeyCode() == 97) goto L35;
        if (r100.getKeyCode() == 96) goto L35;
        if (r100.getKeyCode() == 99) goto L35;
        if (r100.getKeyCode() == 100) goto L35;
        if (r100.getKeyCode() == 109) goto L35;
        if (r100.getKeyCode() == 108) goto L35;
        if (r100.getKeyCode() == 160) goto L35;
        if (i() == false) goto L30;
        if (c().a(r100) == false) goto L30;
        return true;
    L30:
        if (super.dispatchKeyEvent(r100) == true) goto L37;
        return false;
    L37:
        return true;
    L35:
        return super.dispatchKeyEvent(r100);
    L8:
        if (r100.getAction() != 1) goto L11;
        getKeyDispatcherState().handleUpEvent(r100);
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect r100) {
        return super.fitSystemWindows(r100);
    }

    public final int g(WindowInsets r100) {
        if (r100.getSystemWindowInsetBottom() >= (((double) getRootView().getHeight()) * 0.18d)) goto L7;
        return 0;
    L7:
        return r100.getSystemWindowInsetBottom();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return this.C.hasNestedScrollingParent(r100);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets r110) {
        WindowInsets r100 = super.onApplyWindowInsets(r110);
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 29) goto L5;
        Insets r102 = r110.getSystemGestureInsets();
        FlutterRenderer.ViewportMetrics r103 = this.D;
        r103.systemGestureInsetTop = r102.top;
        r103.systemGestureInsetRight = r102.right;
        r103.systemGestureInsetBottom = r102.bottom;
        r103.systemGestureInsetLeft = r102.left;
    L5:
        int r104 = 0;
        if ((getWindowSystemUiVisibility() & 4) != 0) goto L8;
        boolean r105 = true;
    L10:
        if ((getWindowSystemUiVisibility() & 2) != 0) goto L12;
        boolean r106 = true;
    L14:
        if (r101 < 30) goto L22;
        if (r106 == false) goto L17;
        r104 = 0 | WindowInsets.Type.navigationBars();
    L17:
        if (r105 == false) goto L19;
        r104 = r104 | WindowInsets.Type.statusBars();
    L19:
        Insets r107 = r110.getInsets(r104);
        FlutterRenderer.ViewportMetrics r108 = this.D;
        r108.viewPaddingTop = r107.top;
        r108.viewPaddingRight = r107.right;
        r108.viewPaddingBottom = r107.bottom;
        r108.viewPaddingLeft = r107.left;
        Insets r109 = r110.getInsets(WindowInsets.Type.ime());
        FlutterRenderer.ViewportMetrics r111 = this.D;
        r111.viewInsetTop = r109.top;
        r111.viewInsetRight = r109.right;
        r111.viewInsetBottom = r109.bottom;
        r111.viewInsetLeft = r109.left;
        Insets r112 = r110.getInsets(WindowInsets.Type.systemGestures());
        FlutterRenderer.ViewportMetrics r113 = this.D;
        r113.systemGestureInsetTop = r112.top;
        r113.systemGestureInsetRight = r112.right;
        r113.systemGestureInsetBottom = r112.bottom;
        r113.systemGestureInsetLeft = r112.left;
        DisplayCutout r114 = r110.getDisplayCutout();
        if (r114 == null) goto L64;
        Insets r115 = r114.getWaterfallInsets();
        FlutterRenderer.ViewportMetrics r116 = this.D;
        r116.viewPaddingTop = Math.max(Math.max(r116.viewPaddingTop, r115.top), r114.getSafeInsetTop());
        FlutterRenderer.ViewportMetrics r117 = this.D;
        r117.viewPaddingRight = Math.max(Math.max(r117.viewPaddingRight, r115.right), r114.getSafeInsetRight());
        FlutterRenderer.ViewportMetrics r118 = this.D;
        r118.viewPaddingBottom = Math.max(Math.max(r118.viewPaddingBottom, r115.bottom), r114.getSafeInsetBottom());
        FlutterRenderer.ViewportMetrics r119 = this.D;
        r119.viewPaddingLeft = Math.max(Math.max(r119.viewPaddingLeft, r115.left), r114.getSafeInsetLeft());
    L64:
        if (c5a.a.f22523a.booleanValue() == false) goto L66;
        FlutterRenderer.ViewportMetrics r120 = this.D;
        int r121 = r120.viewPaddingTop;
        int r122 = r120.viewPaddingLeft;
        int r123 = r120.viewPaddingRight;
        int r124 = r120.viewInsetBottom;
        int r125 = r120.viewInsetLeft;
        int r126 = r120.viewInsetRight;
        int r127 = r120.systemGestureInsetLeft;
        int r128 = r120.systemGestureInsetTop;
        int r129 = r120.systemGestureInsetRight;
        c5a.c.e();
    L66:
        j();
        return r100;
    L22:
        ZeroSides r130 = ZeroSides.NONE;
        if (r106 == true) goto L38;
        Context r131 = getContext();
        int r132 = r131.getResources().getConfiguration().orientation;
        int r133 = ((WindowManager) r131.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        if (r132 != 2) goto L38;
        if (r133 != 1) goto L30;
        ZeroSides r134 = ZeroSides.RIGHT;
    L28:
        r130 = r134;
        goto L38
    L30:
        if (r133 == 3) goto L32;
        if (r133 == 0) goto L37;
        if (r133 != 2) goto L38;
    L37:
        r134 = ZeroSides.BOTH;
        goto L28
    L32:
        if (r101 < 23) goto L34;
        r134 = ZeroSides.LEFT;
        goto L28
    L34:
        r134 = ZeroSides.RIGHT;
    L38:
        FlutterRenderer.ViewportMetrics r135 = this.D;
        if (r105 == false) goto L41;
        int r136 = r110.getSystemWindowInsetTop();
    L42:
        r135.viewPaddingTop = r136;
        FlutterRenderer.ViewportMetrics r137 = this.D;
        if (r130 != ZeroSides.RIGHT) goto L45;
    L48:
        int r138 = 0;
    L49:
        r137.viewPaddingRight = r138;
        FlutterRenderer.ViewportMetrics r139 = this.D;
        if (r106 == true) goto L52;
    L54:
        int r140 = 0;
    L55:
        r139.viewPaddingBottom = r140;
        FlutterRenderer.ViewportMetrics r141 = this.D;
        if (r130 != ZeroSides.LEFT) goto L58;
    L61:
        int r142 = 0;
    L62:
        r141.viewPaddingLeft = r142;
        FlutterRenderer.ViewportMetrics r143 = this.D;
        r143.viewInsetTop = 0;
        r143.viewInsetRight = 0;
        r143.viewInsetBottom = g(r110);
        this.D.viewInsetLeft = 0;
        goto L64
    L58:
        if (r130 == ZeroSides.BOTH) goto L61;
        r142 = r110.getSystemWindowInsetLeft();
        goto L62
    L52:
        if (g(r110) != 0) goto L54;
        r140 = r110.getSystemWindowInsetBottom();
        goto L55
    L45:
        if (r130 == ZeroSides.BOTH) goto L48;
        r138 = r110.getSystemWindowInsetRight();
        goto L49
    L41:
        r136 = 0;
        goto L42
    L12:
        r106 = false;
        goto L14
    L8:
        r105 = false;
        goto L10
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        float r101 = getResources().getConfiguration().fontScale;
        boolean r102 = true;
        boolean r103 = false;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r104 = true;
    L6:
        FlutterRenderer.ViewportMetrics r105 = this.D;
        if (r105.fontScale == r101) goto L10;
        r105.fontScale = r101;
        r103 = true;
    L10:
        if (r105.nightMode == r104) goto L12;
        r105.nightMode = r104;
    L13:
        if (r102 == false) goto L16;
        j();
        return;
    L16:
        return;
    L12:
        r102 = r103;
        goto L13
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        if (i() == false) goto L5;
        c();
        u5a.b r101 = f();
        if (r101.f548896g == true) goto L9;
        r101.f548894e = null;
        return null;
    L9:
        int r102 = r101.f548892c;
        int r103 = 4;
        if (r102 == 1) goto L21;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L19;
        if (r102 != 4) goto L15;
        int r104 = 33;
    L22:
        r100.inputType = r104;
        r100.imeOptions = 33554432;
        int r105 = r101.f548893d;
        if (r105 == 1) goto L33;
        if (r105 == 2) goto L32;
        if (r105 != 3) goto L27;
    L34:
        r100.imeOptions = 33554432 | r103;
        u5a.a r106 = new u5a.a(this, r101.f548891b, r101.f548895f);
        r101.f548894e = r106;
        return r106;
    L27:
        if (r105 == 4) goto L31;
        if (r105 == 5) goto L30;
        r103 = 0;
        goto L34
    L30:
        r103 = 6;
        goto L34
    L31:
        r103 = 5;
        goto L34
    L32:
        r103 = 3;
        goto L34
    L33:
        r103 = 2;
        goto L34
    L15:
        if (r101.f548893d != 0) goto L17;
        r104 = 131073;
        goto L22
    L17:
        r104 = 1;
        goto L22
    L19:
        r104 = 17;
        goto L22
    L20:
        r104 = 3;
        goto L22
    L21:
        r104 = 2;
        goto L22
    L5:
        return super.onCreateInputConnection(r100);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (r100.isHardwareAccelerated() == true) goto L17;
        FlutterEngine r101 = this.f380531r;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f380521h != RenderMode.sync) goto L10;
        return;
    L10:
        FlutterJNI r102 = r101.f380694a;
        if (r102 == null) goto L13;
        Bitmap r103 = r102.getBitmap();
    L14:
        if (r103 == null) goto L18;
        r100.drawBitmap(r103, 0.0f, 0.0f, null);
        return;
    L18:
        return;
    L13:
        r103 = null;
        goto L14
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r110) {
        boolean r100 = false;
        if (i() == false) goto L22;
        com.lynx.clay.embedding.android.b r101 = d();
        r101.getClass();
        boolean r102 = r110.isFromSource(2);
        if (r110.getActionMasked() != 7) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r102 == false) goto L19;
        if (r103 == false) goto L19;
        int r104 = com.lynx.clay.embedding.android.b.b(r110.getActionMasked());
        ByteBuffer r111 = ByteBuffer.allocateDirect((r110.getPointerCount() * 37) * 8);
        r111.order(ByteOrder.LITTLE_ENDIAN);
        r101.a(r110, r110.getActionIndex(), r104, 0, com.lynx.clay.embedding.android.b.f380636f, r111);
        if ((r111.position() % MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL) != 0) goto L18;
        FlutterRenderer r105 = r101.f380637a;
        int r106 = r111.position();
        r105.f380933a.dispatchPointerDataPacket(r111, r106);
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        r100 = true;
        goto L22
    L18:
        throw new AssertionError("Packet position is not on field boundary.");
    L19:
        r107 = false;
        goto L20
    L7:
        if (r110.getActionMasked() == 8) goto L10;
        r103 = false;
    L22:
        if (r100 == false) goto L25;
        return true;
    L25:
        return super.onGenericMotionEvent(r110);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent r100) {
        if (i() == true) goto L7;
        return super.onHoverEvent(r100);
    L7:
        if (this.f380539z != null) goto L17;
        AccessibilityManager r101 = getAccessibilityManager();
        if (r101 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L17;
        return super.onHoverEvent(r100);
    L11:
        if (r101.isEnabled() == false) goto L13;
        r102 = true;
    L17:
        e().getClass();
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r210) {
        if (i() == false) goto L5;
        requestUnbufferedDispatch(r210);
        if (this.f380538y != null) goto L9;
        this.f380538y = new GestureMediator(this, this.f380531r, d());
    L9:
        GestureMediator r100 = this.f380538y;
        r100.getClass();
        MotionEvent r101 = MotionEvent.obtain(r210);
        if (r210.getActionMasked() != 0) goto L12;
        r100.f380581n = 0;
        r100.f380582o = 0;
    L12:
        r101.setLocation(Math.round(r210.getX() + r100.f380581n), Math.round(r210.getY() + r100.f380582o));
        int r102 = r210.getAction();
        if (r102 != 0) goto L15;
        r100.f380579l = (int) r210.getX();
        r100.f380580m = (int) r210.getY();
        VelocityTracker r103 = r100.f380571d;
        if (r103 != null) goto L93;
        r100.f380571d = VelocityTracker.obtain();
    L94:
        r100.f380571d.addMovement(r210);
        r100.f380575h = 0;
        r100.f380576i = 0;
        ViewParent r104 = r100.f380568a.getParent();
    L95:
        if (r104 == null) goto L109;
        if ((r104 instanceof ScrollView) == false) goto L100;
        r100.f380575h |= 3;
    L108:
        r104 = r104.getParent();
        goto L95
    L100:
        if ((r104 instanceof HorizontalScrollView) == false) goto L103;
        r100.f380575h |= 12;
        goto L108
    L103:
        if ((r104 instanceof NestedScrollView) == false) goto L106;
        r100.f380575h |= 3;
        r100.f380576i |= 3;
        goto L108
    L106:
        if ((r104 instanceof ViewPager) == false) goto L108;
        r100.f380575h |= 12;
        goto L108
    L109:
        FlutterEngine r105 = r100.f380569b;
        int r110 = r100.f380575h;
        FlutterJNI r106 = r105.f380694a;
        if (r106 == null) goto L112;
        r106.setOuterScrollableDirection(r110);
    L112:
        boolean r107 = false;
    L113:
        VelocityTracker r111 = r100.f380571d;
        if (r111 == null) goto L117;
        r111.addMovement(r101);
    L117:
        if (r210.getAction() != 2) goto L123;
        GestureMediator.GestureMediateState r108 = r100.f380583p;
        if (r108 != GestureMediator.GestureMediateState.BLOCKING_MEDIATING) goto L121;
    L122:
        r107 = true;
        goto L123
    L121:
        if (r108 == GestureMediator.GestureMediateState.OUTER_WIN) goto L122;
    L123:
        if (r107 == true) goto L153;
        boolean r109 = r100.f380570c.d(r210, com.lynx.clay.embedding.android.b.f380636f);
        FlutterJNI r112 = r100.f380569b.f380694a;
        if (r112 == null) goto L127;
        int r113 = r112.getHitTestResponsiveResult();
    L128:
        r100.f380574g = r113 & 15;
        int r114 = (r113 >> 4) & 15;
        if ((r113 & 512) == 0) goto L131;
        boolean r115 = true;
    L133:
        if ((r113 & 2048) == 0) goto L135;
        boolean r116 = true;
    L136:
        if (r114 == 0) goto L138;
        boolean r117 = true;
    L139:
        r100.f380584q = r117;
        if (r115 == true) goto L145;
        if (r116 == true) goto L145;
        if (r117 == true) goto L145;
        boolean r118 = false;
    L146:
        r100.f380572e = r118;
        if (r114 != 5) goto L150;
        r100.f380577j = 12;
    L155:
        if (r210.getAction() != 1) goto L157;
    L188:
        r100.a(GestureMediator.GestureMediateState.IDLE);
    L189:
        return r109;
    L157:
        if (r210.getAction() == 3) goto L188;
        if (r100.f380572e == false) goto L162;
    L187:
        r100.a(GestureMediator.GestureMediateState.INNER_WIN);
        goto L189
    L162:
        if (r100.f380584q == true) goto L187;
        if (r210.getAction() != 0) goto L189;
        int r119 = r100.f380575h;
        if (r119 == 0) goto L186;
        int r120 = r100.f380574g;
        if (r120 == 0) goto L186;
        if ((r119 & 3) == 0) goto L180;
        if ((r119 & 12) == 0) goto L180;
        if ((r120 & 3) != 0) goto L177;
    L178:
        r100.a(GestureMediator.GestureMediateState.BLOCKING_MEDIATING);
        goto L189
    L177:
        if ((r120 & 12) == 0) goto L178;
    L180:
        if ((r120 & r119) != 0) goto L182;
        r100.a(GestureMediator.GestureMediateState.MEDIATING);
        goto L189
    L182:
        if ((r119 & (~r100.f380576i)) == 0) goto L184;
        r100.a(GestureMediator.GestureMediateState.BLOCKING_MEDIATING);
        goto L189
    L184:
        r100.a(GestureMediator.GestureMediateState.INNER_WIN);
    L186:
        r100.a(GestureMediator.GestureMediateState.IDLE);
        goto L189
    L150:
        if (r114 != 6) goto L152;
        r100.f380577j = 3;
        goto L155
    L152:
        r100.f380577j = 0;
    L145:
        r118 = true;
        goto L146
    L138:
        r117 = false;
        goto L139
    L135:
        r116 = false;
        goto L136
    L131:
        r115 = false;
        goto L133
    L127:
        r113 = 0;
        goto L128
    L153:
        r109 = true;
        goto L155
    L93:
        r103.clear();
        goto L94
    L15:
        if (r102 == 1) goto L77;
        if (r102 == 2) goto L23;
        if (r102 != 3) goto L112;
        VelocityTracker r121 = r100.f380571d;
        if (r121 == null) goto L22;
        r121.recycle();
        r100.f380571d = null;
    L22:
        r100.f380578k = 0;
        r100.f380568a.stopNestedScroll(0);
        goto L112
    L23:
        int r122 = (int) r210.getX();
        int r123 = (int) r210.getY();
        int r124 = r100.f380579l - r122;
        int r125 = r100.f380580m - r123;
        GestureMediator.GestureMediateState r126 = r100.f380583p;
        GestureMediator.GestureMediateState r127 = GestureMediator.GestureMediateState.BLOCKING_MEDIATING;
        if (r126 != r127) goto L51;
        if (Math.abs(r124) > r100.f380573f) goto L30;
        if (Math.abs(r125) <= r100.f380573f) goto L51;
    L30:
        if (Math.abs(r124) <= Math.abs(r125)) goto L32;
        int r128 = 12;
    L34:
        if ((r100.f380576i & r128) != 0) goto L36;
        if (r128 != 12) goto L43;
        if (r124 <= 0) goto L42;
        int r129 = 8;
    L47:
        if ((r129 & r100.f380574g) == 0) goto L49;
        r100.a(GestureMediator.GestureMediateState.INNER_WIN);
        goto L51
    L49:
        r100.a(GestureMediator.GestureMediateState.OUTER_WIN);
        goto L51
    L42:
        r129 = 4;
        goto L47
    L43:
        if (r125 <= 0) goto L45;
        r129 = 2;
        goto L47
    L45:
        r129 = 1;
        goto L47
    L36:
        if ((r128 & r100.f380574g) == 0) goto L38;
        r100.a(GestureMediator.GestureMediateState.INNER_WIN);
        goto L51
    L38:
        r100.a(GestureMediator.GestureMediateState.OUTER_WIN);
        goto L51
    L32:
        r128 = 3;
    L51:
        if (r100.f380583p == r127) goto L53;
        r100.f380579l = r122;
        r100.f380580m = r123;
    L53:
        int r130 = r100.f380577j;
        if (r130 == 0) goto L72;
        if (r130 != 12) goto L59;
        if (r124 <= 0) goto L58;
        int r131 = 8;
    L62:
        int r132 = r100.f380578k;
        if (r132 == 0) goto L67;
        if (r132 == r131) goto L72;
        r100.f380578k = 0;
        goto L72
    L67:
        if ((r100.f380575h & r131) == 0) goto L72;
        if ((r100.f380574g & r131) != 0) goto L72;
        r100.f380578k = r131;
        r100.f380568a.startNestedScroll(2, 0);
        goto L72
    L58:
        r131 = 4;
        goto L62
    L59:
        if (r125 <= 0) goto L61;
        r131 = 2;
        goto L62
    L61:
        r131 = 1;
    L72:
        if (r100.f380578k == 0) goto L112;
        int[] r133 = new int[2];
        if (r100.f380568a.dispatchNestedScroll(0, 0, r124, r125, r133, 0) == false) goto L76;
        int r134 = r100.f380579l;
        int r135 = r133[0];
        r100.f380579l = r134 - r135;
        int r136 = r100.f380580m;
        int r137 = r133[1];
        r100.f380580m = r136 - r137;
        r101.offsetLocation(r135, r137);
        r100.f380581n += r133[0];
        r100.f380582o += r133[1];
    L76:
        r107 = true;
        goto L113
    L77:
        r100.f380571d.computeCurrentVelocity(1000, 10000.0f);
        int r138 = (int) r100.f380571d.getYVelocity();
        if (r138 >= 0) goto L80;
        int r139 = 2;
    L82:
        if (r139 == r100.f380578k) goto L84;
    L86:
        VelocityTracker r140 = r100.f380571d;
        if (r140 == null) goto L89;
        r140.recycle();
        r100.f380571d = null;
    L89:
        r100.f380578k = 0;
        r100.f380568a.stopNestedScroll(0);
        goto L112
    L84:
        if (Math.abs(r138) <= 50) goto L86;
        r100.f380568a.dispatchNestedFling(0.0f, -r138, false);
        goto L86
    L80:
        r139 = 1;
        goto L82
    L5:
        return super.onTouchEvent(r210);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r100) {
        super.onWindowFocusChanged(r100);
        SurfaceSnapshotController r101 = this.f380519f;
        if (r101 == null) goto L16;
        if (r100 == true) goto L12;
        if (r101.j() == false) goto L8;
        return;
    L8:
        if (r101.g() == false) goto L10;
        r101.o(true);
        return;
    L10:
        r101.q();
        r101.o(false);
        return;
    L12:
        if (r101.j() == false) goto L14;
        r101.n();
        return;
    L14:
        r101.h();
        r101.q();
        return;
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        SurfaceSnapshotController r101 = this.f380519f;
        if (r101 == null) goto L8;
        if (r100 != 0) goto L6;
        r101.n();
        return;
    L6:
        r101.m();
        return;
    }

    public void setDefaultFocusRingEnabled(boolean r100) {
        FlutterEngine r101 = this.f380531r;
        if (r101 == null) goto L6;
        r101.f380695b.f380933a.setDefaultFocusRingEnabled(r100);
        return;
    }

    public void setExternalDisplayMetrics(DisplayMetrics r100) {
        this.f380529p = r100;
    }

    public void setExternalPlatformViewContext(n5a.i r100) {
        this.f380528o = r100;
    }

    public void setInternalPlatformViewLynxContext(Context r100) {
        n5a.b r101 = this.f380527n;
        if ((r101 instanceof n5a.b) == false) goto L6;
        r101.f518056b = r100;
        return;
    }

    public void setKeyEventListener(com.lynx.clay.embedding.android.a.c r100) {
        com.lynx.clay.embedding.android.a r101 = this.f380536w;
        if (r101 == null) goto L6;
        r101.f380632d.getClass();
        return;
    }

    public void setKeyboardEventStartCallback(g r100) {
        this.f380530q = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        this.C.setNestedScrollingEnabled(r100);
    }

    public void setPerformanceOverlayEnabled(boolean r100) {
        FlutterEngine r101 = this.f380531r;
        if (r101 == null) goto L6;
        r101.f380694a.setPerformanceOverlayEnabled(r100);
        return;
    }

    public void setResourceUrlInterceptor(j r100) {
        this.f380531r.f380694a.setResourceUrlInterceptor(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return this.C.startNestedScroll(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        this.C.stopNestedScroll(r100);
    }

    public FlutterView(Context r100, FlutterDelegateView r101) {
        super(r100, null);
        this.f380522i = new HashSet();
        this.f380524k = new a(this);
        this.f380525l = false;
        this.f380526m = new b(this);
        this.f380527n = new n5a.b(getContext());
        this.f380528o = null;
        this.f380529p = null;
        this.f380530q = null;
        this.f380532s = new HashSet();
        this.f380534u = false;
        this.f380535v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.f380517d = r101;
        this.f380520g = r101;
        this.f380521h = RenderMode.delegate;
        h();
    }

    public final void k(int r100, int r101) {
        Object r102 = com.lynx.clay.util.a.f380953a;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L21;
        Object r104 = this.f380520g;
        if ((r104 instanceof View) == true) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r105 = ((View) r104).getLayoutParams();
        if (r105 != null) goto L14;
        return;
    L14:
        if (r105.width == r100) goto L16;
    L18:
        r105.width = r100;
        r105.height = r101;
        return;
    L16:
        if (r105.height != r101) goto L18;
        return;
    L21:
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + ThreadMethodProxy.currentThread().getName());
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getMode(r111);
        int r112 = View.MeasureSpec.getSize(r111);
        int r101 = View.MeasureSpec.getMode(r110);
        int r113 = View.MeasureSpec.getSize(r110);
        int r102 = this.L;
        boolean r103 = false;
        if (r102 == (-1)) goto L5;
        boolean r104 = true;
    L6:
        int r105 = this.M;
        if (r105 == (-1)) goto L9;
        boolean r106 = true;
    L10:
        if (r104 == true) goto L13;
        r102 = 0;
    L13:
        if (r106 == true) goto L17;
        r105 = 0;
    L17:
        if (r101 != 1073741824) goto L19;
        boolean r107 = true;
    L20:
        this.F = r107;
        if (r100 != 1073741824) goto L23;
        boolean r114 = true;
    L24:
        this.G = r114;
        if (r101 != Integer.MIN_VALUE) goto L27;
        boolean r108 = true;
    L28:
        this.H = r108;
        if (r108 == false) goto L33;
        if (r106 == false) goto L32;
        if (r105 <= r113) goto L33;
    L32:
        boolean r109 = true;
    L34:
        this.I = r113;
        if (r100 != Integer.MIN_VALUE) goto L37;
        boolean r115 = true;
    L38:
        this.f380513J = r115;
        if (r115 == false) goto L43;
        if (r104 == false) goto L42;
        if (r102 <= r112) goto L43;
    L42:
        r103 = true;
    L43:
        this.K = r112;
        if (r114 == true) goto L48;
        if (r103 == true) goto L48;
        r112 = r102;
    L48:
        if (r107 == true) goto L52;
        if (r109 == true) goto L52;
        r113 = r105;
    L52:
        FlutterRenderer.ViewportMetrics r116 = this.D;
        r116.width = r113;
        r116.height = r112;
        if (r112 >= r102) goto L55;
        int r117 = r112 | 16777216;
    L56:
        if (r113 >= r105) goto L58;
        int r118 = 16777216 | r113;
    L59:
        k(r113, r112);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r118, 1073741824), View.MeasureSpec.makeMeasureSpec(r117, 1073741824));
        return;
    L58:
        r118 = r113;
        goto L59
    L55:
        r117 = r112;
        goto L56
    L37:
        r115 = false;
    L33:
        r109 = false;
        goto L34
    L27:
        r108 = false;
        goto L28
    L23:
        r114 = false;
        goto L24
    L19:
        r107 = false;
        goto L20
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return this.C.startNestedScroll(r100, r101);
    }

    public FlutterView(Context r100, FlutterFunctorView r101) {
        super(r100, null);
        this.f380522i = new HashSet();
        this.f380524k = new a(this);
        this.f380525l = false;
        this.f380526m = new b(this);
        this.f380527n = new n5a.b(getContext());
        this.f380528o = null;
        this.f380529p = null;
        this.f380530q = null;
        this.f380532s = new HashSet();
        this.f380534u = false;
        this.f380535v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.f380516c = r101;
        this.f380520g = r101;
        this.f380521h = RenderMode.sync;
        h();
    }

    public FlutterView(Context r100, FlutterTextureView r101) {
        super(r100, null);
        this.f380522i = new HashSet();
        this.f380524k = new a(this);
        this.f380525l = false;
        this.f380526m = new b(this);
        this.f380527n = new n5a.b(getContext());
        this.f380528o = null;
        this.f380529p = null;
        this.f380530q = null;
        this.f380532s = new HashSet();
        this.f380534u = false;
        this.f380535v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.f380515b = r101;
        this.f380520g = r101;
        this.f380521h = RenderMode.texture;
        h();
    }

    public FlutterView(Context r100, AttributeSet r101) {
        this(r100, r101, new FlutterSurfaceView(r100));
    }

    public FlutterView(Context r100, AttributeSet r101, FlutterSurfaceView r102) {
        super(r100, r101);
        this.f380522i = new HashSet();
        this.f380524k = new a(this);
        this.f380525l = false;
        this.f380526m = new b(this);
        this.f380527n = new n5a.b(getContext());
        this.f380528o = null;
        this.f380529p = null;
        this.f380530q = null;
        this.f380532s = new HashSet();
        this.f380534u = false;
        this.f380535v = false;
        this.D = new FlutterRenderer.ViewportMetrics();
        new c();
        this.E = new d(this);
        this.L = -1;
        this.M = -1;
        this.N = new e(this);
        this.f380514a = r102;
        this.f380520g = r102;
        this.f380521h = RenderMode.surface;
        h();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return this.C.dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return this.C.dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        FlutterRenderer.ViewportMetrics r104 = this.D;
        r104.width = r100;
        r104.height = r101;
        k(r100, r101);
        j();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return this.C.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return this.C.dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return this.C.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }
}
