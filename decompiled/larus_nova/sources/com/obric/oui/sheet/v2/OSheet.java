package com.obric.oui.sheet.v2;

import android.R;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class OSheet extends Dialog implements OSheetBase {
    public boolean A;
    public final c B;
    public float C;
    public float D;
    public int E;
    public boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f402874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f402875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadiusLayout f402876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f402877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FrameLayout f402878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f402879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f402880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f402881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f402882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f402883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HeightMode f402884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f402885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f402886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f402887n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f402888o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f402889p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Size f402890q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f402891r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public fja.d f402892s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public xla.b f402893t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public xla.a f402894u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f402895v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f402896w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f402897x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f402898y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f402899z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$Header;", "", "CUSTOM", "PAGE", "ACTION", "MODAL", "ONLY_TITLE", "PAGE_WITH_CLOSE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum Header extends Enum<Header> {
        public static final Header ACTION = null;
        public static final Header CUSTOM = null;
        public static final Header MODAL = null;
        public static final Header ONLY_TITLE = null;
        public static final Header PAGE = null;
        public static final Header PAGE_WITH_CLOSE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Header[] f402900a = null;

        public static Header valueOf(String r100) {
            return (Header) r27.a.a(Header.class, r100);
        }

        public static Header[] values() {
            return (Header[]) f402900a.clone();
        }

        static {
            Header r100 = new Header("CUSTOM", 0);
            CUSTOM = r100;
            Header r101 = new Header("PAGE", 1);
            PAGE = r101;
            Header r102 = new Header("ACTION", 2);
            ACTION = r102;
            Header r103 = new Header("MODAL", 3);
            MODAL = r103;
            Header r104 = new Header("ONLY_TITLE", 4);
            ONLY_TITLE = r104;
            Header r105 = new Header("PAGE_WITH_CLOSE", 5);
            PAGE_WITH_CLOSE = r105;
            f402900a = new Header[]{r100, r101, r102, r103, r104, r105};
        }

        public Header(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheet$HeightMode;", "", "FULL_HEIGHT", "WRAP_HEIGHT", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum HeightMode extends Enum<HeightMode> {
        public static final HeightMode FULL_HEIGHT = null;
        public static final HeightMode WRAP_HEIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HeightMode[] f402901a = null;

        public static HeightMode valueOf(String r100) {
            return (HeightMode) r27.a.a(HeightMode.class, r100);
        }

        public static HeightMode[] values() {
            return (HeightMode[]) f402901a.clone();
        }

        static {
            HeightMode r100 = new HeightMode("FULL_HEIGHT", 0);
            FULL_HEIGHT = r100;
            HeightMode r101 = new HeightMode("WRAP_HEIGHT", 1);
            WRAP_HEIGHT = r101;
            f402901a = new HeightMode[]{r100, r101};
        }

        public HeightMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void g() {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final int getUserWindowWidth() {
        return 0;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void l() {
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void s() {
        OSheetBase.DefaultImpls.a(this, true);
        RadiusLayout r100 = getRootContainer();
        View r101 = getDimView();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        OMaterialHelper.t(r100, r101);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setAutoAddBodyPaddingTopWhenOverlay(boolean r100) {
        throw null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setMCancelable(boolean r100) {
        throw null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final FrameLayout getBodyContainer() {
        FrameLayout r100 = this.f402879f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("bodyContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final View getDimView() {
        View r100 = this.f402875b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("dimView");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final FrameLayout getFooterContainer() {
        FrameLayout r100 = this.f402878e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("footerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final FrameLayout getHeaderContainer() {
        FrameLayout r100 = this.f402877d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("headerContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final RadiusLayout getRootContainer() {
        RadiusLayout r100 = this.f402876c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final ViewGroup getScaffoldContainer() {
        ViewGroup r100 = this.f402874a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldContainer");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final i getScaffoldController() {
        i r100 = this.f402883j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scaffoldController");
        return null;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean h() {
        return !this.f402886m;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean i() {
        if (this.f402881h == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f402880g == true) goto L7;
        return true;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void k() {
        xla.b r100 = this.f402893t;
        if (r100 == null) goto L7;
        r100.onShowAnimEnd(this);
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void o() {
        xla.b r100 = this.f402893t;
        if (r100 == null) goto L7;
        r100.onShowAnimStart(this);
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.f402899z == false) goto L5;
        OSheetBase.DefaultImpls.t(this);
        getScaffoldController().b(this.f402890q);
    L10:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L89;
        DialogLancet.handleBlockedDialogShow(this);
    L14:
        Intrinsics.checkNotNullParameter(this, "this");
        final i r100 = getScaffoldController();
        r100.f402971c.setOnApplyWindowInsetsListener(new h(r100));
        Window r101 = getWindow();
        if (r101 == null) goto L86;
        r101.setSoftInputMode(48);
        r101.setBackgroundDrawableResource(R.color.transparent);
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 29) goto L20;
        r101.setNavigationBarContrastEnforced(false);
    L20:
        r101.clearFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
        r101.addFlags(Integer.MIN_VALUE);
        r101.setNavigationBarColor(0);
        if (r102 < 30) goto L24;
        r101.setDecorFitsSystemWindows(false);
        r101.setNavigationBarDividerColor(0);
    L24:
        if ((48 & getContext().getResources().getConfiguration().uiMode) == 32) goto L26;
        boolean r103 = true;
    L28:
        if (r102 < 30) goto L45;
        WindowInsetsController r104 = r101.getInsetsController();
        if (r104 == null) goto L36;
        if (r103 == false) goto L34;
        int r105 = 8;
    L35:
        r104.setSystemBarsAppearance(r105, 8);
        goto L36
    L34:
        r105 = 0;
    L36:
        WindowInsetsController r106 = r101.getInsetsController();
        if (r106 == null) goto L50;
        if (r103 == false) goto L42;
        int r107 = 16;
    L43:
        r106.setSystemBarsAppearance(r107, 16);
        goto L50
    L42:
        r107 = 0;
    L50:
        if (this.f402880g == false) goto L52;
        r101.clearFlags(2);
    L53:
        float r108 = f.a(r101.getContext());
        WindowManager.LayoutParams r109 = r101.getAttributes();
        if (this.f402884k != HeightMode.FULL_HEIGHT) goto L56;
    L59:
        boolean r110 = true;
    L60:
        this.f402887n = r110;
        boolean r111 = !this.f402886m;
        if (r111 == false) goto L63;
    L66:
        pla.j.e(getDimView());
    L68:
        if (this.f402899z == true) goto L71;
        r109.dimAmount = 0.0f;
        getDimView().setAlpha(0.0f);
    L71:
        if (i() == true) goto L73;
    L74:
        if (r111 == false) goto L76;
        r109.dimAmount = r108;
    L78:
        if (this.f402887n == false) goto L80;
        int r112 = -1;
    L81:
        r101.setLayout(-1, r112);
        if (this.f402887n == false) goto L84;
        r109.setFitInsetsSides(0);
    L85:
        r109.layoutInDisplayCutoutMode = 3;
        r109.gravity = 80;
        r109.windowAnimations = 0;
        r101.setAttributes(r109);
        goto L86
    L84:
        r109.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        goto L85
    L80:
        r112 = -2;
        goto L81
    L76:
        r109.dimAmount = 0.0f;
        getDimView().setAlpha(r108);
        goto L78
    L73:
        if (this.f402882i == true) goto L78;
    L63:
        if (this.f402880g == true) goto L66;
        pla.j.f(getDimView());
        goto L68
    L56:
        if (this.f402886m == true) goto L59;
        r110 = false;
        goto L60
    L52:
        r101.addFlags(2);
        goto L53
    L45:
        if (r102 < 23) goto L50;
        if (r103 == false) goto L48;
        u(r101).setSystemUiVisibility(u(r101).getSystemUiVisibility() | 8192);
        goto L50
    L48:
        u(r101).setSystemUiVisibility(u(r101).getSystemUiVisibility() & (-8193));
        goto L50
    L26:
        r103 = false;
    L86:
        this.f402899z = true;
        return;
    L89:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L88
    L13:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L14
    L5:
        if (this.f402888o == false) goto L7;
        getDimView().setOnClickListener(new com.obric.oui.sheet.v2.a(this));
        goto L10
    L7:
        getDimView().setOnClickListener(null);
        goto L10
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final Window d() {
        return getWindow();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Intrinsics.checkNotNullParameter(this, "this");
        getScaffoldController().f402971c.setOnApplyWindowInsetsListener(null);
        j(0.0f);
        this.F = false;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void e() {
        if (isShowing() == false) goto L9;
        t(this);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final Context getSheetContext() {
        return getContext();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == true) goto L6;
        getSheetContext().registerComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(true);
    L6:
        OSheetBase.DefaultImpls.b(this);
        getRootContainer().post(new b(this));
    }

    @Override // android.app.Dialog
    public final void onStop() {
        Intrinsics.checkNotNullParameter(this, "this");
        if (getConfigurationCallbackRegistered() == false) goto L6;
        getSheetContext().unregisterComponentCallbacks(getConfigurationCallback());
        setConfigurationCallbackRegistered(false);
    L6:
        super.onStop();
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean r() {
        return OSheetBase.DefaultImpls.f(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void a() {
        OSheetBase.DefaultImpls.h(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void b() {
        OSheetBase.DefaultImpls.e(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void f() {
        OSheetBase.DefaultImpls.t(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean getAutoAddBodyPaddingTopWhenOverlay() {
        return this.f402897x;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final int getBgColor() {
        return this.E;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final int getBodyContentPaddingBottom() {
        return this.f402896w;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final int getBodyContentPaddingTop() {
        return this.f402895v;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final ComponentCallbacks getConfigurationCallback() {
        return this.B;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean getConfigurationCallbackRegistered() {
        return this.A;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean getEnableMaterial() {
        return this.f402898y;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final Size getFullWindowSize() {
        return this.f402890q;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final HeightMode getHeightStyle() {
        return this.f402884k;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean getIgnoreInsetBottom() {
        return this.f402891r;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final float getRootTransMoveStartX() {
        return this.C;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final float getRootTransMoveStartY() {
        return this.D;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final fja.d getRunningAnim() {
        return this.f402892s;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean getShowing() {
        return this.f402899z;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final int getUserWindowHeight() {
        return this.f402889p;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void m() {
        OSheetBase.DefaultImpls.b(this);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final boolean q() {
        return this.f402885l;
    }

    public static void t(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static View u(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final <T extends View> T c(int r100) {
        return (T) findViewById(r100);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void j(float r100) {
        OSheetBase.DefaultImpls.i(this, r100);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (r100 == null) goto L5;
        return;
    L5:
        if (this.f402882i == false) goto L9;
        getRootContainer().setAlpha(0.0f);
        return;
    }

    @Override // com.obric.oui.sheet.v2.k
    public final void p(float r100) {
        OSheetBase.DefaultImpls.c(this, r100);
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setBgColor(int r100) {
        this.E = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setBodyContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402879f = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setBodyContentPaddingBottom(int r100) {
        this.f402896w = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setBodyContentPaddingTop(int r100) {
        this.f402895v = r100;
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean r100) {
        super.setCanceledOnTouchOutside(r100);
        this.f402888o = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setConfigurationCallbackRegistered(boolean r100) {
        this.A = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setFooterContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402878e = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setFullWindowSize(Size r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402890q = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setHeaderContainer(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402877d = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setHeightStyle(HeightMode r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402884k = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setRootContainer(RadiusLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402876c = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setRootTransMoveStartX(float r100) {
        this.C = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setRootTransMoveStartY(float r100) {
        this.D = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setRunningAnim(fja.d r100) {
        this.f402892s = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setScaffoldContainer(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402874a = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setScaffoldController(i r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402883j = r100;
    }

    @Override // com.obric.oui.sheet.v2.OSheetBase
    public final void setupDimView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        View r101 = new View(r100);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f402875b = r101;
        if ((getRootContainer().getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r102 = getRootContainer().getParent();
        if (r102 == null) goto L8;
        ((ViewGroup) r102).addView(getDimView(), 0, new ViewGroup.LayoutParams(-1, -1));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.obric.oui.sheet.v2.k
    public final void n(float r100, float r101, boolean r102) {
        OSheetBase.DefaultImpls.g(this, r100, r101, r102);
    }

    public OSheet(Context r100, int r101, boolean r102, int r103) {
        boolean r104 = false;
        if ((r103 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 8) == 0) goto L9;
        r102 = false;
    L9:
        if ((r103 & 16) == 0) goto L11;
        boolean r105 = true;
    L12:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f402881h = true;
        this.f402882i = true;
        this.f402884k = HeightMode.WRAP_HEIGHT;
        this.f402885l = r102;
        this.f402886m = true;
        this.f402888o = true;
        this.f402889p = r101;
        this.f402890q = new Size(0, 0);
        this.f402897x = true;
        this.B = new c(this);
        this.E = -1;
        if (r105 == false) goto L20;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (OMaterialHelper.j(r100) == true) goto L17;
    L19:
        this.f402898y = r104;
        goto L20
    L17:
        if (OMaterialHelper.l() == false) goto L19;
        r104 = true;
    L20:
        Window r106 = getWindow();
        if (r106 == null) goto L24;
        r106.requestFeature(1);
    L24:
        Intrinsics.checkNotNullParameter(this, "this");
        if (q() == false) goto L27;
        int r107 = com.larus.nova.R.layout.o_sheet_container_overlay;
    L28:
        setContentView(r107);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OSheetBase.DefaultImpls.s(this, r100);
        s();
        return;
    L27:
        r107 = com.larus.nova.R.layout.o_sheet_container;
        goto L28
    L11:
        r105 = false;
        goto L12
    }
}
