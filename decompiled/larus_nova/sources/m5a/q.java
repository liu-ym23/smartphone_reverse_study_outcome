package m5a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.FlutterOverlaySurface;
import com.lynx.clay.embedding.engine.plugins.externalview.ExternalViewPlugin;
import com.lynx.clay.embedding.engine.plugins.overlay.OverlayPlatformPluginAndroid;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class q extends FrameLayout {
    public int[] A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f512191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f512192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f512193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f512194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f512195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f512196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewTreeObserver f512197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f512198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f512199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f512200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f512201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f512202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f512203m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OverlayPlatformPluginAndroid f512204n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public d f512205o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FlutterOverlaySurface f512206p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f512207q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f512208r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f512209s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f512210t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final FlutterView f512211u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f512212v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f512213w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f512214x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ExternalViewPlugin f512215y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int[] f512216z;

    public class a implements ViewTreeObserver.OnDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f512217a;

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            q.c(this.f512217a);
        }

        public a(q r100) {
            this.f512217a = r100;
        }
    }

    private Matrix getTouchEventTransformMatrix() {
        int[] r100 = {0, 0};
        int[] r101 = getFlutterViewLocation();
        getLocationOnScreen(r100);
        int r102 = r100[0] - r101[0];
        int r103 = r100[1] - r101[1];
        if (r102 != 0) goto L7;
        if (r103 != 0) goto L7;
        return null;
    L7:
        Matrix r104 = new Matrix();
        r104.postTranslate(r102, r103);
        return r104;
    }

    private int[] getFlutterViewLocation() {
        FlutterView r100 = this.f512211u;
        if (r100 != null) goto L7;
        return new int[]{0, 0};
    L7:
        if (this.f512212v != null) goto L9;
        this.f512212v = new int[2];
    L9:
        r100.getLocationOnScreen(this.f512212v);
        return this.f512212v;
    }

    private View getOverlayContentView() {
        View r100 = this.f512207q;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.f512205o;
    }

    public final void d() {
        boolean r100 = !this.f512200j;
        d r101 = this.f512205o;
        if (r101 == null) goto L5;
        r101.setFocusable(r100);
        this.f512205o.setFocusableInTouchMode(r100);
    L5:
        View r102 = this.f512207q;
        if (r102 == null) goto L9;
        r102.setFocusable(r100);
        this.f512207q.setFocusableInTouchMode(r100);
        return;
    }

    public final void e() {
        this.f512196f.d();
        boolean r100 = this.f512192b;
        Window r101 = this.f512196f.getWindow();
        if (r101 == null) goto L19;
        int r102 = Build.VERSION.SDK_INT;
        if (r100 == false) goto L8;
        r101.addFlags(65792);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setStatusBarColor(0);
    L10:
        if (r102 >= 23) goto L12;
    L14:
        int r103 = a(r101).getSystemUiVisibility() | 1280;
    L15:
        if (r100 == false) goto L17;
        a(r101).setSystemUiVisibility(r103);
        goto L19
    L17:
        a(r101).setSystemUiVisibility(0);
        goto L19
    L12:
        if (this.f512194d.equals("lite") == false) goto L14;
        r103 = a(r101).getSystemUiVisibility() | 9472;
        goto L15
    L8:
        r101.clearFlags(256);
        r101.clearFlags(65536);
        r101.clearFlags(Integer.MIN_VALUE);
    L19:
        if (Build.VERSION.SDK_INT < 28) goto L28;
        Window r104 = this.f512196f.getWindow();
        if (r104 == null) goto L28;
        WindowManager.LayoutParams r105 = r104.getAttributes();
        if (this.f512193c == false) goto L28;
        r105.layoutInDisplayCutoutMode = 1;
        r104.setAttributes(r105);
    L28:
        if (this.f512201k == false) goto L36;
        Window r106 = this.f512196f.getWindow();
        if (r106 != null) goto L32;
        return;
    L32:
        if (a(r106) == null) goto L38;
        int r107 = a(r106).getSystemUiVisibility() | 5894;
        a(r106).setSystemUiVisibility(r107);
        return;
    L38:
        return;
    }

    public final void f() {
        ExternalViewPlugin r100 = this.f512215y;
        if (r100 != null) goto L5;
        return;
    L5:
        d r101 = r100.f380826b;
        if (r101 == null) goto L17;
        d r102 = this.f512205o;
        if (r102 == r101) goto L19;
        if (r102 == null) goto L13;
        if (r102 == r101) goto L13;
        j();
    L13:
        r101.setExternalViewPlugin(this.f512215y);
        this.f512215y.f380826b = r101;
        this.f512205o = r101;
        r101.setLifecycleListener(new p(this));
        this.f512205o.setClickable(true);
        this.f512205o.setSurfaceTextureReadyListener(new k(this));
        this.f512205o.setSurfaceTextureUpdatedListener(new l(this));
        d();
        addView(r101, new ViewGroup.LayoutParams(-1, -1));
        if (this.f512196f.isShowing() == false) goto L18;
        m();
        return;
    L18:
        return;
    L19:
        return;
    }

    public final void g() {
        if (this.f512199i == false) goto L5;
        return;
    L5:
        this.f512199i = true;
        h r100 = h.f512176e;
        String r101 = this.f512195e;
        if (r101 == null) goto L14;
        int r102 = 0;
    L9:
        if (r102 >= ((ArrayList) r100.f512179c).size()) goto L15;
        if (((h.a) ListProtector.get(r100.f512179c, r102)).f512181a.equals(r101) == true) goto L12;
        r102 = r102 + 1;
        goto L9
    L12:
        ListProtector.remove(r100.f512179c, r102);
        r100.c();
        r100.b();
    L15:
        h();
        j();
        if (this.f512203m == false) goto L18;
        i(true);
        return;
    L18:
        i(false);
        return;
    L14:
        r100.getClass();
        goto L15
    }

    public final void h() {
        ViewTreeObserver r100 = this.f512197g;
        if (r100 != null) goto L5;
    L12:
        this.f512197g = null;
        this.f512198h = null;
        return;
    L5:
        if (this.f512198h == null) goto L12;
        if (r100.isAlive() == false) goto L10;
        this.f512197g.removeOnDrawListener(this.f512198h);
    L10:
        this.f512197g = null;
        this.f512198h = null;
    }

    public final void j() {
        if (this.f512205o != null) goto L5;
        return;
    L5:
        h();
        this.f512205o.setSurfaceTextureReadyListener(null);
        this.f512205o.setSurfaceTextureUpdatedListener(null);
        ViewParent r100 = this.f512205o.getParent();
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r100).removeView(this.f512205o);
    L8:
        this.f512205o = null;
    }

    public final void o() {
        FlutterOverlaySurface r100 = this.f512206p;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f512208r == false) goto L10;
        n(r100, this.f512209s, this.f512210t);
        return;
    }

    public final void l() {
        k(this);
        Window r100 = this.f512196f.getWindow();
        if (r100 == null) goto L7;
        View r101 = a(r100);
        k(r101);
        if (r101 == null) goto L7;
        k(r101.findViewById(R.id.content));
    L7:
        ViewParent r102 = getParent();
    L9:
        if ((r102 instanceof ViewGroup) == false) goto L11;
        k((View) r102);
        r102 = r102.getParent();
        goto L9
    }

    public final void m() {
        View r100 = getOverlayContentView();
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f512198h != null) goto L23;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 != null) goto L10;
    L17:
        this.f512197g = null;
        this.f512198h = null;
        return;
    L10:
        if (r101.isAlive() == false) goto L17;
        this.f512197g = r101;
        a r102 = new a(this);
        this.f512198h = r102;
        r101.addOnDrawListener(r102);     // Catch: IllegalStateException -> L15
        return;
    L15:
        this.f512197g = null;
        this.f512198h = null;
        return;
    }

    public int getViewId() {
        return this.f512213w;
    }

    public String getViewTag() {
        return this.f512214x;
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void b(g r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void c(q r100) {
        if (r100.f512204n == null) goto L20;
        int[] r101 = {0, 0};
        r100.getLocationOnScreen(r101);
        int[] r102 = r100.getFlutterViewLocation();
        int[] r103 = r100.f512216z;
        if (r103 != null) goto L8;
    L18:
        r100.f512216z = r101;
        r100.A = new int[]{r102[0], r102[1]};
        OverlayPlatformPluginAndroid.nativeUpdateRootPosOffset(r100.f512204n.f380841e, r101[0] - r102[0], r101[1] - r102[1]);
        return;
    L8:
        if (r101[0] != r103[0]) goto L18;
        if (r101[1] != r103[1]) goto L18;
        int[] r104 = r100.A;
        if (r104 == null) goto L18;
        if (r102[0] != r104[0]) goto L18;
        if (r102[1] != r104[1]) goto L18;
        return;
    }

    public static void k(View r100) {
        if ((r100 instanceof ViewGroup) == false) goto L6;
        ViewGroup r101 = (ViewGroup) r100;
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        return;
    }

    private void setDialogType(int r100) {
        if (this.f512196f.getWindow() == null) goto L6;
        this.f512196f.getWindow().setType(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        FlutterView r101 = this.f512211u;
        if (r101 == null) goto L30;
        if (r101.getAndroidTouchProcessor() == null) goto L30;
        int r102 = r100.getActionMasked();
        if (r102 != 0) goto L10;
        this.f512202l = false;
    L10:
        Matrix r103 = getTouchEventTransformMatrix();
        if (r103 != null) goto L13;
        boolean r104 = this.f512211u.getAndroidTouchProcessor().d(r100, com.lynx.clay.embedding.android.b.f380636f);
    L15:
        if (r102 != 0) goto L18;
        if (r104 == false) goto L18;
        this.f512202l = true;
    L18:
        if (r104 == false) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r102 != 1) goto L26;
    L27:
        this.f512202l = false;
    L28:
        return r105;
    L26:
        if (r102 != 3) goto L28;
    L20:
        if (this.f512202l == true) goto L23;
        r105 = false;
        goto L24
    L13:
        r104 = this.f512211u.getAndroidTouchProcessor().d(r100, r103);
    L30:
        return super.dispatchTouchEvent(r100);
    }

    public final void i(boolean r100) {
        if (this.f512207q == null) goto L8;
        h();
        ViewParent r101 = this.f512207q.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r101).removeView(this.f512207q);
    L7:
        this.f512207q = null;
    L8:
        if (r100 == false) goto L11;
        this.f512206p = null;
        this.f512208r = false;
        return;
    }

    public void setAndroidSetSoftInputMode(String r100) {
        Window r101 = this.f512196f.getWindow();
        if (r101 != null) goto L6;
        return;
    L6:
        if ("unspecified".equals(r100) == false) goto L9;
        int r102 = 0;
    L17:
        r101.setSoftInputMode(r102);
        return;
    L9:
        if ("nothing".equals(r100) == false) goto L12;
        r102 = 48;
        goto L17
    L12:
        if ("pan".equals(r100) == false) goto L15;
        r102 = 32;
        goto L17
    L15:
        if ("resize".equals(r100) == false) goto L19;
        r102 = 16;
        goto L17
    }

    public void setCutOutMode(boolean r100) {
        this.f512193c = r100;
        e();
    }

    public void setFullScreen(boolean r100) {
        if (r100 == false) goto L5;
        this.f512201k = true;
        e();
        return;
    }

    public void setIgnoreFocus(boolean r100) {
        this.f512200j = r100;
        d();
        Window r101 = this.f512196f.getWindow();
        if (r100 == false) goto L8;
        this.f512196f.f512172b = false;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.clearFlags(131072);
        r101.setFlags(8, 8);
        return;
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        r101.clearFlags(8);
    }

    public void setLevel(int r100) {
        int r101 = 2;
        if (r100 == 1) goto L13;
        if (r100 != 2) goto L6;
        r101 = 1005;
        goto L13
    L6:
        if (r100 != 3) goto L8;
        r101 = 1002;
        goto L13
    L8:
        if (r100 == 4) goto L10;
        r100 = 1;
        goto L13
    L10:
        r101 = 1000;
    L13:
        setDialogType(r101);
        this.f512196f.f512173c = r100;
        h r102 = h.f512176e;
        String r103 = this.f512195e;
        if (r103 != null) goto L16;
        r102.getClass();
        return;
    L16:
        int r104 = 0;
    L18:
        if (r104 >= ((ArrayList) r102.f512179c).size()) goto L27;
        h.a r105 = (h.a) ListProtector.get(r102.f512179c, r104);
        if (r105.f512181a.equals(r103) == true) goto L21;
        r104 = r104 + 1;
        goto L18
    L21:
        ListProtector.remove(r102.f512179c, r104);
        r102.a(r105);
        r102.c();
        r102.b();
        return;
    }

    public void setNativeEventPass(boolean r100) {
        Window r101 = this.f512196f.getWindow();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 == false) goto L8;
        r101.addFlags(16);
        return;
    L8:
        r101.clearFlags(16);
    }

    public void setOverlayPlatformPluginAndroid(OverlayPlatformPluginAndroid r100) {
        this.f512204n = r100;
    }

    public void setStatusBarTranslucent(boolean r100) {
        this.f512192b = r100;
        e();
    }

    public void setStatusBarTranslucentStyle(String r100) {
        if (r100 != null) goto L5;
        r100 = "dark";
    L5:
        this.f512194d = r100;
        e();
    }

    public void setVisible(boolean r100) {
        if (this.f512191a != r100) goto L5;
        return;
    L5:
        this.f512191a = r100;
        if (r100 == false) goto L41;
        f();
        Activity r101 = t5a.b.getActivity(getContext());
        this.f512216z = null;
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isFinishing() == true) goto L58;
        h r102 = h.f512176e;
        String r103 = this.f512195e;
        byte r104 = 0;
        if (r103 == null) goto L19;
        Iterator r105 = ((ArrayList) r102.f512179c).iterator();
    L15:
        if (r105.hasNext() == false) goto L20;
        if (((h.a) r105.next()).f512181a.equals(r103) == false) goto L15;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L59;
        h r107 = h.f512176e;     // Catch: RuntimeException -> L39
        g r108 = this.f512196f;     // Catch: RuntimeException -> L39
        r107.getClass();     // Catch: RuntimeException -> L39
        StringBuilder r109 = new StringBuilder("default_overlay_id_");     // Catch: RuntimeException -> L39
        int r110 = r107.f512180d;     // Catch: RuntimeException -> L39
        r107.f512180d = r110 + 1;     // Catch: RuntimeException -> L39
        r109.append(r110);     // Catch: RuntimeException -> L39
        String r111 = r109.toString();     // Catch: RuntimeException -> L39
        r107.a(new h.a(r111, r108));     // Catch: RuntimeException -> L39
        r107.c();     // Catch: RuntimeException -> L39
        this.f512195e = r111;     // Catch: RuntimeException -> L39
        this.f512199i = false;     // Catch: RuntimeException -> L39
        this.f512196f.setOnDismissListener(new i(this));     // Catch: RuntimeException -> L39
        this.f512196f.getClass();     // Catch: RuntimeException -> L39
        if (r101.isFinishing() == false) goto L26;
        r104 = -1;
    L28:
        if (r104 < 0) goto L36;
        g r112 = this.f512196f;     // Catch: RuntimeException -> L39
        if (DialogLancet.shouldBlockDialogShow(r112) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r112);     // Catch: RuntimeException -> L39
    L35:
        e();     // Catch: RuntimeException -> L39
        h.f512176e.c();     // Catch: RuntimeException -> L39
        l();     // Catch: RuntimeException -> L39
        o();     // Catch: RuntimeException -> L39
    L37:
        m();     // Catch: RuntimeException -> L39
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L47
    L34:
        DialogLancet.beforeDialogShow(r112);     // Catch: RuntimeException -> L39
        r112.show();     // Catch: RuntimeException -> L39
        DialogLancet.afterDialogShow(r112);     // Catch: RuntimeException -> L39
        goto L35
    L36:
        g();     // Catch: RuntimeException -> L39
        goto L37
    L26:
        if (r101.isDestroyed() == false) goto L28;
        r104 = -2;
    L39:
        g();
        return;
    L59:
        return;
    L20:
        r106 = false;
        goto L21
    L19:
        r102.getClass();
        goto L20
    L58:
        return;
    L41:
        if (this.f512196f.isShowing() == true) goto L50;
        g();
        return;
    L50:
        b(this.f512196f);     // Catch: RuntimeException -> L44
        return;
    L44:
        g();
    }

    public final int p(int r100, boolean r101) {
        if (r100 <= 0) goto L4;
        return r100;
    L4:
        if (r101 == false) goto L6;
        int r102 = getWidth();
    L7:
        Window r103 = this.f512196f.getWindow();
        if (r103 != null) goto L10;
        View r104 = null;
    L11:
        if (r102 > 0) goto L16;
        if (r104 == null) goto L16;
        if (r101 == false) goto L15;
        r102 = r104.getWidth();
        goto L16
    L15:
        r102 = r104.getHeight();
    L16:
        if (r102 > 0) goto L23;
        View r105 = getRootView();
        if (r105 != null) goto L20;
        r102 = 0;
        goto L23
    L20:
        if (r101 == false) goto L22;
        r102 = r105.getWidth();
        goto L23
    L22:
        r102 = r105.getHeight();
    L23:
        if (r102 > 0) goto L29;
        Resources r106 = getResources();
        DisplayMetrics r107 = WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics());
        if (r101 == false) goto L27;
        int r108 = r107.widthPixels;
    L28:
        r102 = r108;
        goto L29
    L27:
        r108 = r107.heightPixels;
    L29:
        if (r102 > 0) goto L31;
        return r100;
    L31:
        return r102;
    L10:
        r104 = a(r103);
        goto L11
    L6:
        r102 = getHeight();
        goto L7
    }

    public final void n(FlutterOverlaySurface r100, int r101, int r102) {
        boolean r103 = true;
        int r104 = p(r101, true);
        int r105 = p(r102, false);
        View r106 = null;
        if (r100 != null) goto L5;
        View r107 = null;
    L6:
        if (r107 != null) goto L9;
    L20:
        if (r106 == null) goto L46;
        if (r104 <= 0) goto L47;
        if (r105 <= 0) goto L48;
        this.f512208r = true;
        this.f512209s = r101;
        this.f512210t = r102;
        l();
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
        boolean r109 = r108 instanceof FrameLayout.LayoutParams;
        if (r109 == false) goto L27;
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r108;
    L28:
        if (r109 == true) goto L30;
    L39:
        if (r103 == false) goto L41;
        r110.width = r104;
        r110.height = r105;
        r110.leftMargin = 0;
        r110.topMargin = 0;
        r106.setLayoutParams(r110);
    L41:
        r106.setTranslationX(0.0f);
        r106.setTranslationY(0.0f);
        r106.setVisibility(0);
        r106.bringToFront();
        r106.requestLayout();
        r106.invalidate();
        if (this.f512200j == true) goto L44;
        this.f512196f.b(r106);
    L44:
        m();
        return;
    L30:
        if (r110.width != r104) goto L39;
        if (r110.height != r105) goto L39;
        if (r110.leftMargin != 0) goto L39;
        if (r110.topMargin != 0) goto L39;
        r103 = false;
        goto L39
    L27:
        r110 = new FrameLayout.LayoutParams(r104, r105);
        goto L28
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L9:
        if (this.f512206p == r100) goto L11;
    L12:
        i(true);
        this.f512206p = r100;
        this.f512207q = r107;
    L13:
        ViewParent r111 = r107.getParent();
        if (r111 != this) goto L16;
    L19:
        r106 = r107;
        goto L20
    L16:
        if ((r111 instanceof ViewGroup) == false) goto L18;
        ((ViewGroup) r111).removeView(r107);
    L18:
        addView(r107, new FrameLayout.LayoutParams(-1, -1));
        goto L19
    L11:
        if (this.f512207q == r107) goto L13;
    L5:
        r107 = r100.a();
        goto L6
    }

    public q(Context r100, int r101, String r102, FlutterView r103, ExternalViewPlugin r104) {
        super(r100);
        this.f512191a = false;
        this.f512192b = true;
        this.f512193c = false;
        this.f512194d = "dark";
        this.f512199i = true;
        this.f512200j = false;
        this.f512201k = false;
        this.f512202l = false;
        this.f512203m = false;
        this.f512208r = false;
        this.f512209s = 0;
        this.f512210t = 0;
        this.f512212v = null;
        this.f512216z = null;
        this.A = null;
        this.f512214x = r102;
        this.f512213w = r101;
        this.f512211u = r103;
        this.f512215y = r104;
        Activity r105 = t5a.b.getActivity(getContext());
        if (r105 == null) goto L12;
        g r106 = new g(r105, this, r103);
        this.f512196f = r106;
        r106.getWindow().clearFlags(2);
        r106.getWindow().setDimAmount(0.0f);
        h r107 = h.f512176e;
        Context r108 = getContext();
        WeakReference<Context> r109 = r107.f512177a;
        if (r109 != null) goto L7;
    L8:
        r107.f512177a = new WeakReference(r108.getApplicationContext());
    L9:
        r106.setContentView(this, new ViewGroup.LayoutParams(-1, -1));
        l();
        r106.setOnKeyListener(new j(this));
        e();
        f();
        return;
    L7:
        if (r109.get() != null) goto L9;
    L12:
        throw new RuntimeException("Failed to create OverlayViewNG, which needs an activity context!");
    }
}
