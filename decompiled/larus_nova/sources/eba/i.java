package eba;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Process;
import android.os.SystemClock;
import android.view.Display;
import android.view.SurfaceControl;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningPresentationState;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.runtime.manager.ActivationSource;
import com.obric.assistant.activation.presentation.ui.ObricListeningVisualView;
import com.obric.assistant.common.utils.a0;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class i {
    public static final /* synthetic */ int F = 0;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public final c E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f471928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f471929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f471930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function4<SurfaceControl, Integer, Integer, Integer, Unit> f471931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<Integer, Long, Unit> f471932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Integer, Unit> f471933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f471934g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final KeyguardManager f471935h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WindowManager f471936i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f471937j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Display f471938k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WindowManager.LayoutParams f471939l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WindowInsets f471940m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public jba.f f471941n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public k f471942o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f471943p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public FrameLayout f471944q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ObricListeningVisualView f471945r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f471946s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f471947t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ObricListeningViewState f471948u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public hba.g f471949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g f471950w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SurfaceControl f471951x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f471952y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f471953z;

    public static final class a {
    }

    static {
    }

    public final void a() {
        SurfaceControl r100 = this.f471951x;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = this.f471952y;
        i(false, "child_surface_destroyed");
        this.f471951x = null;
        this.A = -1;
        this.B = -1;
        hba.e.f484506a.getClass();
        if (hba.e.e(r100) == false) goto L8;
        FLogger.f375446a.i("ObricListeningChildWindow", "destroy: side=child stage=surface generation=" + r101);
    L8:
        this.f471933f.invoke(Integer.valueOf(r101));
    }

    public static void c(WindowManager.LayoutParams r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Method r102 = WindowManager.LayoutParams.class.getDeclaredMethod("setTrustedOverlay", new Class[0]);     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(r102.invoke(r100, new Object[0]));     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        FLogger.f375446a.e("ObricListeningChildWindow", "trusted_overlay_reflection_failed: side=child stage=window error=" + ExceptionsKt.stackTraceToString(r104));
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void b(boolean r110) {
        b r100 = this.f471943p;
        if (r100 != null) goto L6;
        this.C = r110;
        return;
    L6:
        int r101 = this.f471946s;
        this.C = r110;
        r100.removeCallbacks(this.E);
        this.D = false;
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("detach: side=child stage=window type=");
        r103.append(r101);
        r103.append(" display=");
        r103.append(this.f471947t);
        r103.append(" preserveLinkFence=");
        r103.append(r110);
        r103.append(" spec=");
        k r104 = this.f471942o;
        if (r104 == null) goto L9;
        jba.e r105 = r104.f471955a;
    L10:
        r103.append(r105);
        r102.i("ObricListeningChildWindow", r103.toString());
        ObricListeningVisualView r106 = this.f471945r;
        if (r106 == null) goto L13;
        r106.e(ObricListeningViewState.f385269d);
    L13:
        hba.g r107 = this.f471949v;
        if (r107 == null) goto L16;
        r107.close();
    L16:
        this.f471949v = null;
        g r108 = this.f471950w;
        if (r108 == null) goto L24;
        ViewTreeObserver r109 = r100.getViewTreeObserver();
        if (r109.isAlive() == true) goto L22;
        r109 = null;
    L22:
        if (r109 == null) goto L24;
        r109.removeOnPreDrawListener(r108);
    L24:
        this.f471950w = null;
        a();
        r100.setOnApplyWindowInsetsListener(null);
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L31
        WindowManager r112 = this.f471936i;     // Catch: Throwable -> L31
        if (r112 == null) goto L28;
        r112.removeViewImmediate(r100);     // Catch: Throwable -> L31
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L29:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L31
    L34:
        if (Result.m9456isSuccessimpl(r114) == false) goto L36;
        Unit r115 = (Unit) r114;
        FLogger.f375446a.i("ObricListeningChildWindow", "detach_success: side=child stage=window type=" + r101 + " display=" + this.f471947t);
    L36:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r114);
        if (r116 == null) goto L39;
        FLogger.f375446a.w("ObricListeningChildWindow", "remove_failed: side=child stage=window type=" + r101 + " error=" + r116.getClass().getSimpleName() + ':' + r116.getMessage());
    L39:
        this.f471943p = null;
        this.f471944q = null;
        this.f471945r = null;
        this.f471946s = 0;
        this.f471947t = -1;
        this.f471937j = null;
        this.f471938k = null;
        this.f471939l = null;
        this.f471940m = null;
        this.f471941n = null;
        this.f471942o = null;
        if (r110 == true) goto L42;
        this.f471948u = ObricListeningViewState.f385269d;
    L42:
        this.f471936i = null;
        return;
    L28:
        r113 = null;
    L31:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L9:
        r105 = null;
        goto L10
    }

    public final void e(String r110) {
        if (this.f471943p != null) goto L5;
        return;
    L5:
        FrameLayout r100 = this.f471944q;
        if (r100 != null) goto L8;
        return;
    L8:
        Context r101 = this.f471937j;
        if (r101 != null) goto L11;
        return;
    L11:
        Display r102 = this.f471938k;
        if (r102 != null) goto L14;
        return;
    L14:
        WindowManager r103 = this.f471936i;
        if (r103 != null) goto L18;
        return;
    L18:
        if (this.f471939l != null) goto L20;
        return;
    L20:
        l r104 = l.f471958a;
        WindowInsets r105 = this.f471940m;
        jba.f r106 = this.f471941n;
        r104.getClass();
        k r107 = l.c(r101, r102, r103, r105, r106);
        k r108 = this.f471942o;
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if ((r109 instanceof FrameLayout.LayoutParams) == false) goto L23;
        FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r109;
    L24:
        FrameLayout.LayoutParams r112 = h(r101, r107);
        boolean r113 = true;
        if (r111 != null) goto L27;
    L41:
        boolean r114 = false;
    L42:
        boolean r115 = !r114;
        boolean r116 = !r115;
        if (r115 == true) goto L62;
    L56:
        l.f471958a.getClass();
        l.a(r100, r107);
        this.f471941n = r107.f471957c.f471965g;
        this.f471942o = r107;
        if (r115 == false) goto L59;
    L60:
        FLogger.f375446a.i("ObricListeningChildWindow", "layout_update: side=child stage=window reason=" + r110 + " changed=" + r115 + " applied=" + r116 + " inputs={" + r107.f471957c.a() + "} result={spec=" + r107.f471955a + " radii=" + r107.f471956b + '}');
        return;
    L59:
        if (Intrinsics.areEqual(r108, r107) == false) goto L60;
        return;
    L62:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L46
        r100.setLayoutParams(r112);     // Catch: Throwable -> L46
        r100.requestLayout();     // Catch: Throwable -> L46
        Object r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L49:
        if (Result.m9456isSuccessimpl(r118) == false) goto L51;
        Unit r119 = (Unit) r118;
    L52:
        Throwable r120 = Result.m9452exceptionOrNullimpl(r118);
        if (r120 == null) goto L55;
        FLogger.f375446a.w("ObricListeningChildWindow", "content_layout_update_failed: side=child stage=window reason=" + r110 + " error=" + r120.getClass().getSimpleName() + ':' + r120.getMessage());
    L55:
        r116 = r113;
        goto L56
    L51:
        r113 = r116;
    L46:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L27:
        if (r111.width != r112.width) goto L41;
        if (r111.height != r112.height) goto L41;
        if (r111.gravity != r112.gravity) goto L41;
        if (r111.leftMargin != r112.leftMargin) goto L41;
        if (r111.topMargin != r112.topMargin) goto L41;
        if (r111.rightMargin != r112.rightMargin) goto L41;
        if (r111.bottomMargin != r112.bottomMargin) goto L41;
        r114 = true;
        goto L42
    L23:
        r111 = null;
        goto L24
    }

    public final void f(Integer r100) {
        if (r100 == null) goto L6;
        int r101 = this.f471952y;
        if (r100.intValue() == r101) goto L6;
        return;
    L6:
        i(false, "main_surface_released");
        this.A = -1;
        this.B = -1;
        this.C = false;
        b r102 = this.f471943p;
        if (r102 == null) goto L10;
        r102.invalidate();
        return;
    }

    public static FrameLayout.LayoutParams h(Context r100, k r101) {
        jba.e r102 = r101.f471955a;
        if (r102.f498056f == false) goto L5;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(r102.f498051a, r102.f498052b, r102.f498053c);
        r103.rightMargin = r102.f498054d;
        r103.topMargin = r102.f498055e;
        return r103;
    L5:
        int r104 = ObricListeningVisualView.f385560i;
        return new FrameLayout.LayoutParams(-1, ObricListeningVisualView.a.a(r100), 81);
    }

    public final void i(boolean r110, String r111) {
        b r100 = this.f471943p;
        if (r100 != null) goto L5;
        return;
    L5:
        WindowManager r101 = this.f471936i;
        if (r101 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r102 = this.f471939l;
        if (r102 != null) goto L11;
        return;
    L11:
        int r103 = r102.flags;
        if ((r103 & 16) == 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 != r110) goto L17;
        return;
    L17:
        if (r110 == false) goto L19;
        int r105 = r103 | 16;
    L20:
        r102.flags = r105;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L23
        r101.updateViewLayout(r100, r102);     // Catch: Throwable -> L23
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        if (Result.m9456isSuccessimpl(r107) == false) goto L28;
        Unit r108 = (Unit) r107;
        FLogger.f375446a.i("ObricListeningChildWindow", "touch_passthrough_changed: side=child stage=window enabled=" + r110 + " reason=" + r111 + " generation=" + this.f471952y);
    L28:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r107);
        if (r109 == null) goto L34;
        r102.flags = r103;
        FLogger.f375446a.w("ObricListeningChildWindow", "touch_passthrough_update_failed: side=child stage=window enabled=" + r110 + " reason=" + r111 + " generation=" + this.f471952y + " error=" + r109.getClass().getSimpleName() + ':' + r109.getMessage());
        return;
    L34:
        return;
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L19:
        r105 = r103 & (-17);
        goto L20
    L14:
        r104 = false;
        goto L15
    }

    public final boolean g(ObricListeningPresentationState r310, ActivationSource r311, long r312) {
        Intrinsics.checkNotNullParameter(r310, "state");
        Intrinsics.checkNotNullParameter(r311, "source");
        if (r310.b() == true) goto L5;
    L78:
        b(false);
        return true;
    L5:
        if (r310.f385265c != 1) goto L78;
        if (this.f471935h.isKeyguardLocked() == false) goto L10;
        int r100 = 2009;
    L12:
        if (this.f471943p != null) goto L14;
    L20:
        ObricListeningViewState r101 = r310.f385267e;
        this.f471948u = r101;
        b r102 = this.f471943p;
        if (r102 != null) goto L23;
        boolean r110 = true;
    L25:
        if (r102 != null) goto L66;
        com.obric.assistant.common.utils.i.a r111 = com.obric.assistant.common.utils.i.a("ObricListeningChildWindow_attach");
        long r210 = SystemClock.uptimeMillis();     // Catch: Throwable -> L62
        sda.b r103 = sda.b.f541476a;     // Catch: Throwable -> L62
        int r112 = Process.myTid();     // Catch: Throwable -> L62
        r103.getClass();     // Catch: Throwable -> L62
        sda.b.a("child_activation_ui", r112);     // Catch: Throwable -> L62
    L32:
        th = move-exception;
        FLogger.f375446a.e("ObricListeningChildWindow", "turn_screen_on_failed: side=child stage=window", th);     // Catch: Throwable -> L62
    L80:
        DisplayManager r104 = (DisplayManager) this.f471934g.getSystemService(DisplayManager.class);     // Catch: RuntimeException -> L56 Throwable -> L62
        if (r104 == null) goto L37;
        Display r105 = r104.getDisplay(0);     // Catch: RuntimeException -> L56 Throwable -> L62
    L38:
        if (r105 != null) goto L42;
        FLogger.f375446a.e("ObricListeningChildWindow", "attach_failed: side=child stage=window type=" + r100 + " error=display_unavailable");     // Catch: RuntimeException -> L56 Throwable -> L62
        if (r111 == null) goto L66;
        r111.a();
        goto L66
    L42:
        Context r113 = this.f471934g.createDisplayContext(r105).createWindowContext(r100, null);     // Catch: RuntimeException -> L56 Throwable -> L62
        Object r114 = r113.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: RuntimeException -> L56 Throwable -> L62
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type android.view.WindowManager");     // Catch: RuntimeException -> L56 Throwable -> L62
        WindowManager r115 = (WindowManager) r114;     // Catch: RuntimeException -> L56 Throwable -> L62
        final b r116 = new b(r113);     // Catch: RuntimeException -> L56 Throwable -> L62
        r116.f471916a = new d(this, r116);     // Catch: RuntimeException -> L56 Throwable -> L62
        ObricListeningVisualView r106 = new ObricListeningVisualView(r113, true);     // Catch: RuntimeException -> L54 Throwable -> L62
        FrameLayout r117 = new FrameLayout(r113);     // Catch: RuntimeException -> L54 Throwable -> L62
        r106.e(r101);     // Catch: RuntimeException -> L54 Throwable -> L62
        r117.addView(r106, new FrameLayout.LayoutParams(-1, ObricListeningVisualView.a.a(r113), 81));     // Catch: RuntimeException -> L54 Throwable -> L62
        l.f471958a.getClass();     // Catch: RuntimeException -> L54 Throwable -> L62
        k r107 = l.c(r113, r105, r115, null, null);     // Catch: RuntimeException -> L54 Throwable -> L62
        r117.setLayoutParams(h(r113, r107));     // Catch: RuntimeException -> L54 Throwable -> L62
        r116.addView(r117);     // Catch: RuntimeException -> L54 Throwable -> L62
        String r211 = "attach_failed: side=child stage=window type=";
        WindowManager.LayoutParams r108 = new WindowManager.LayoutParams(-1, -1, r100, 16777480, -3);     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.gravity = 119;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.x = 0;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.y = 0;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.alpha = 1.0f;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.dimAmount = 0.0f;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.windowAnimations = 0;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.softInputMode = 48;     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.setTitle("ObricListeningChildWindow");     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.packageName = this.f471934g.getPackageName();     // Catch: RuntimeException -> L52 Throwable -> L62
        r108.setFitInsetsTypes(0);     // Catch: RuntimeException -> L52 Throwable -> L62
        c(r108);     // Catch: RuntimeException -> L52 Throwable -> L62
        l.a(r117, r107);     // Catch: RuntimeException -> L52 Throwable -> L62
        r116.setOnApplyWindowInsetsListener(new e(this, r116));     // Catch: RuntimeException -> L52 Throwable -> L62
        FLogger r118 = FLogger.f375446a;     // Catch: RuntimeException -> L52 Throwable -> L62
        r118.i("ObricListeningChildWindow", "attach_prepare: side=child stage=window mode=" + r101.f385270a + " visible=" + r101.b() + " type=" + r100 + " inputs={" + r107.f471957c.a() + "} result={spec=" + r107.f471955a + " radii=" + r107.f471956b + '}');     // Catch: RuntimeException -> L52 Throwable -> L62
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r116, r108);     // Catch: RuntimeException -> L52 Throwable -> L62
        r115.addView(r116, r108);     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471936i = r115;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471937j = r113;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471938k = r105;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471939l = r108;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471942o = r107;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471943p = r116;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471944q = r117;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471945r = r106;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471946s = r100;     // Catch: RuntimeException -> L52 Throwable -> L62
        this.f471947t = r105.getDisplayId();     // Catch: RuntimeException -> L52 Throwable -> L62
        r118.i("ObricListeningChildWindow", "attach_success: side=child stage=window type=" + r100 + " display=" + this.f471947t + " attrs={width=" + r108.width + " height=" + r108.height + " gravity=" + r108.gravity + " x=" + r108.x + " y=" + r108.y + "} content={spec=" + r107.f471955a + '}');     // Catch: RuntimeException -> L52 Throwable -> L62
        this.D = false;     // Catch: RuntimeException -> L52 Throwable -> L62
        r116.postDelayed(this.E, this.f471928a);     // Catch: RuntimeException -> L52 Throwable -> L62
        StringBuilder r109 = new StringBuilder("initial_main_update_timeout_scheduled: side=child stage=window timeoutMs=");     // Catch: RuntimeException -> L52 Throwable -> L62
        r109.append(this.f471928a);     // Catch: RuntimeException -> L52 Throwable -> L62
        r109.append(" type=");     // Catch: RuntimeException -> L52 Throwable -> L62
        r109.append(r100);     // Catch: RuntimeException -> L52 Throwable -> L62
        r109.append(" display=");     // Catch: RuntimeException -> L52 Throwable -> L62
        r109.append(this.f471947t);     // Catch: RuntimeException -> L52 Throwable -> L62
        r118.i("ObricListeningChildWindow", r109.toString());     // Catch: RuntimeException -> L52 Throwable -> L62
        int r119 = r100;
        String r120 = "ObricListeningChildWindow";
        d(r116, r311, r210, r312);     // Catch: RuntimeException -> L50 Throwable -> L62
        r116.requestApplyInsets();     // Catch: RuntimeException -> L50 Throwable -> L62
    L59:
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L62
        if (r111 == null) goto L68;
        r111.a();
    L68:
        if (this.f471943p != null) goto L72;
        FLogger.f375446a.w(r120, "render_failed: side=child stage=window mode=" + r310.f385267e.f385270a + " targetType=" + r119);
        return false;
    L72:
        if (r110 == true) goto L90;
        ObricListeningVisualView r122 = this.f471945r;
        if (r122 == null) goto L91;
        r122.e(r310.f385267e);
        return true;
    L91:
        return true;
    L90:
        return true;
    L50:
        e = e;
    L58:
        FLogger.f375446a.e(r120, r211 + r119 + " error=" + e.getClass().getSimpleName() + ':' + e.getMessage());     // Catch: Throwable -> L62
    L52:
        e = e;
        r119 = r100;
        r120 = "ObricListeningChildWindow";
    L54:
        e = e;
        r119 = r100;
        r120 = "ObricListeningChildWindow";
        r211 = "attach_failed: side=child stage=window type=";
        goto L58
    L37:
        r105 = null;
    L56:
        e = e;
        r119 = r100;
        r120 = "ObricListeningChildWindow";
        r211 = "attach_failed: side=child stage=window type=";
        goto L58
    L29:
        if (a0.a() == true) goto L80;
        FLogger.f375446a.i("ObricListeningChildWindow", "turn_screen_on: side=child stage=window");     // Catch: Throwable -> L32
        a0.b();     // Catch: Throwable -> L32
    L62:
        th = move-exception;
        if (r111 == null) goto L65;
        r111.a();
    L65:
        throw th;
    L66:
        r119 = r100;
        r120 = "ObricListeningChildWindow";
        goto L68
    L23:
        r110 = false;
        goto L25
    L14:
        if (r100 == this.f471946s) goto L20;
        if (this.A != this.f471952y) goto L18;
        boolean r123 = true;
    L19:
        b(r123);
        goto L20
    L18:
        r123 = false;
        goto L19
    L10:
        r100 = 2038;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.view.ViewTreeObserver$OnPreDrawListener, eba.g] */
    public final void d(b r100, final ActivationSource r110, final long r111, final long r112) {
        ?? r101 = new g(this, r111, r110, r112);
        this.f471950w = r101;
        r100.getViewTreeObserver().addOnPreDrawListener(r101);
        hba.e r113 = hba.e.f484506a;
        j r114 = new j(this);
        r113.getClass();
        this.f471949v = hba.e.f(r100, r114);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [eba.c] */
    public i(Context r100, long r101, Function0 r102, Function4 r103, Function2 r104, Function1 r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "onTimeoutReached");
        Intrinsics.checkNotNullParameter(r103, "onSurfaceAvailable");
        Intrinsics.checkNotNullParameter(r104, "onFirstDrawReady");
        Intrinsics.checkNotNullParameter(r105, "onSurfaceDestroyed");
        this.f471928a = r101;
        this.f471929b = 10000;
        this.f471930c = r102;
        this.f471931d = r103;
        this.f471932e = r104;
        this.f471933f = r105;
        Context r106 = r100.getApplicationContext();
        this.f471934g = r106;
        Object r107 = r106.getSystemService("keyguard");
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.app.KeyguardManager");
        this.f471935h = (KeyguardManager) r107;
        this.f471947t = -1;
        this.f471948u = ObricListeningViewState.f385269d;
        this.f471953z = -1;
        this.A = -1;
        this.B = -1;
        this.E = new c(this);
    }
}
