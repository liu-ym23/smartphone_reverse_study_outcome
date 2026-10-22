package com.bytedance.dux.panel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.panel.pad.Location;
import com.bytedance.dux.panel.pad.PadBottomSheetBehavior;
import com.bytedance.dux.widget.PanelFrameLayout;
import com.bytedance.dux.widget.RadiusLayout;
import com.bytedance.dux.window.controller.DuxBreakPointController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.g;
import em4.m;
import em4.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/panel/DuxBasePanelDialog;", "Lcom/bytedance/dux/panel/BottomSheetDialog;", "dux_release"}, k = 1, mv = {1, 7, 1})
public class DuxBasePanelDialog extends BottomSheetDialog {
    public static final /* synthetic */ int K = 0;
    public Integer A;
    public boolean B;
    public Integer C;
    public Integer D;
    public Function0<Boolean> E;
    public boolean F;
    public ConstraintLayout G;
    public RadiusLayout H;
    public RadiusLayout I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public Function0<Boolean> f205303J;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f205304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f205305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f205306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f205307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f205308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f205309o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.dux.panel.header.d f205310p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f205311q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super MotionEvent, Boolean> f205312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f205313s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f205314t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View.OnClickListener f205315u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f205316v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f205317w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Location f205318x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f205319y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Integer f205320z;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f205321a = null;

        static {
            int[] r100 = new int[DuxBasicPanel$PadCompatConfig$CloseIconStyle.values().length];
            r100[DuxBasicPanel$PadCompatConfig$CloseIconStyle.BLACK_WITH_BG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L22:
            r100[DuxBasicPanel$PadCompatConfig$CloseIconStyle.WHITE_WITH_BG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[DuxBasicPanel$PadCompatConfig$CloseIconStyle.BLACK_NO_BG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[DuxBasicPanel$PadCompatConfig$CloseIconStyle.AUTO_SWITCH_DAY_NIGHT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            int[] r101 = new int[Location.values().length];
            r101[Location.CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L32:
            r101[Location.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L24:
            r101[Location.CORNER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f205321a = r101;
        }
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog
    public final void M0() {
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog, android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        Function0<Boolean> r100 = this.f205303J;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        super.cancel();
        return;
    L5:
        if (r100.invoke().booleanValue() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Function0<Boolean> r100 = this.E;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        super.onBackPressed();
        return;
    L5:
        if (r100.invoke().booleanValue() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.f205313s == false) goto L8;
        FrameLayout r100 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r100 == null) goto L8;
        r100.setMinimumHeight(0);
    L8:
        if (this.F == false) goto L10;
        Resources r101 = Resources.getSystem();
        float r102 = TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    L11:
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        r103.setCornerRadii(new float[]{r102, r102, r102, r102, 0.0f, 0.0f, 0.0f, 0.0f});
        if (this.f205311q == false) goto L18;
        if (this.f205305k == false) goto L16;
        int r104 = R.color.BGPanelTone;
    L21:
        r103.setColor(ContextCompat.getColor(getContext(), r104));
        FrameLayout r105 = L0();
        if (r105 == null) goto L26;
        r105.setBackground(r103);
    L26:
        if (this.f205306l == false) goto L34;
        Integer r106 = this.A;
        if (r106 == null) goto L30;
        Intrinsics.checkNotNull(r106);
        int r107 = r106.intValue();
    L31:
        FrameLayout r108 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r108 == null) goto L34;
        r108.getLayoutParams().height = r107;
        goto L34
    L30:
        r107 = (int) (((double) g.d(getContext())) * 0.9d);
    L34:
        boolean r109 = this.B;
        FrameLayout r110 = (FrameLayout) findViewById(R.id.container);
        if (r110 == null) goto L38;
        r110.setFitsSystemWindows(r109);
    L38:
        J0().f205253b = this.f205306l;
        if (this.f205315u == null) goto L48;
        View r111 = findViewById(R.id.touch_outside);
        this.f205319y = r111;
        if (r111 == null) goto L43;
        r111.setOnClickListener(this.f205315u);
    L43:
        Integer r112 = this.D;
        if (r112 == null) goto L48;
        int r113 = r112.intValue();
        View r114 = this.f205319y;
        if (r114 == null) goto L48;
        r114.setBackgroundColor(r113);
    L48:
        J0().H = this.f205316v;
        return;
    L16:
        r104 = R.color.BGPanelTint;
        goto L21
    L18:
        if (this.f205305k == false) goto L20;
        r104 = R.color.ConstBGPanelReverse;
        goto L21
    L20:
        r104 = R.color.ConstTextInverse;
        goto L21
    L10:
        r102 = 0.0f;
        goto L11
    }

    public final void N0(hm4.d r110) {
        Map<PadAdaptScene, Boolean> r100 = DuxConfig.f204897a;
        if (DuxConfig.a(PadAdaptScene.PANEL) == true) goto L5;
        return;
    L5:
        FrameLayout r101 = L0();
        if (r101 == null) goto L9;
        r101.setMinimumHeight(0);
    L9:
        FrameLayout r102 = L0();
        PadBottomSheetBehavior r103 = null;
        if (r102 == null) goto L16;
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        if (r104 == null) goto L15;
        CoordinatorLayout.LayoutParams r105 = (CoordinatorLayout.LayoutParams) r104;
        PadBottomSheetBehavior r106 = new PadBottomSheetBehavior(getContext(), null);
        r106.N = false;
        r105.setBehavior(r106);
        r102.setLayoutParams(r105);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L16:
        FrameLayout r107 = L0();
        if ((r107 instanceof PanelFrameLayout) == false) goto L19;
        PanelFrameLayout r108 = (PanelFrameLayout) r107;
    L20:
        if (r108 == null) goto L23;
        r108.setAdaptFoldBlackEnable(false);
    L23:
        hm4.b r109 = r110.f485934b;
        jm4.a.f499636a.getClass();
        if (Intrinsics.areEqual(r109, jm4.a.C6460a.f499638b) == false) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L32;
        boolean r113 = true;
    L34:
        if (r113 == false) goto L52;
        FrameLayout r114 = L0();
        if (r114 == null) goto L48;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L47;
        CoordinatorLayout.LayoutParams r116 = (CoordinatorLayout.LayoutParams) r115;
        ((ViewGroup.MarginLayoutParams) r116).width = im4.a.b(r110);
        CoordinatorLayout.Behavior r117 = r116.getBehavior();
        if ((r117 instanceof PadBottomSheetBehavior) == false) goto L42;
        r103 = (PadBottomSheetBehavior) r117;
    L42:
        if (r103 == null) goto L45;
        Location r118 = Location.BOTTOM;
        Intrinsics.checkNotNullParameter(r118, "<set-?>");
        r103.M = r118;
    L45:
        r116.gravity = 1;
        r116.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r116).bottomMargin = 0;
        r114.setLayoutParams(r116);
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L48:
        FrameLayout r119 = L0();
        if (r119 == null) goto L110;
        Resources r120 = Resources.getSystem();
        float r121 = TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(r119, "<this>");
        r119.setOutlineProvider(new m(r119, true, true, false, false, r121));
        r119.setClipToOutline(true);
        return;
    L110:
        return;
    L52:
        if (Intrinsics.areEqual(r109, hm4.b.f485921f) == false) goto L54;
        boolean r122 = true;
    L55:
        if (r122 == false) goto L57;
        boolean r123 = true;
    L58:
        if (r123 == false) goto L60;
        boolean r124 = true;
    L62:
        if (r124 == false) goto L86;
        FrameLayout r125 = L0();
        if (r125 == null) goto L83;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
        if (r126 == null) goto L82;
        CoordinatorLayout.LayoutParams r127 = (CoordinatorLayout.LayoutParams) r126;
        ((ViewGroup.MarginLayoutParams) r127).width = im4.a.b(r110);
        CoordinatorLayout.Behavior r128 = r127.getBehavior();
        if ((r128 instanceof PadBottomSheetBehavior) == false) goto L70;
        r103 = (PadBottomSheetBehavior) r128;
    L70:
        if (r103 == null) goto L73;
        Location r129 = this.f205318x;
        Intrinsics.checkNotNullParameter(r129, "<set-?>");
        r103.M = r129;
    L73:
        int r130 = a.f205321a[this.f205318x.ordinal()];
        if (r130 == 1) goto L79;
        if (r130 == 2) goto L79;
        if (r130 != 3) goto L80;
        r127.gravity = GravityCompat.END;
        r127.setMarginEnd(44);
        ((ViewGroup.MarginLayoutParams) r127).bottomMargin = 44;
    L80:
        r125.setLayoutParams(r127);
    L79:
        r127.gravity = 1;
        r127.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r127).bottomMargin = 0;
        goto L80
    L82:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L83:
        FrameLayout r131 = L0();
        if (r131 == null) goto L112;
        Resources r132 = Resources.getSystem();
        float r133 = TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r132, r132.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(r131, "<this>");
        r131.setOutlineProvider(new m(r131, true, true, true, true, r133));
        r131.setClipToOutline(true);
        return;
    L112:
        return;
    L86:
        FrameLayout r134 = L0();
        if (r134 == null) goto L106;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L105;
        CoordinatorLayout.LayoutParams r136 = (CoordinatorLayout.LayoutParams) r135;
        ((ViewGroup.MarginLayoutParams) r136).width = im4.a.b(r110);
        CoordinatorLayout.Behavior r137 = r136.getBehavior();
        if ((r137 instanceof PadBottomSheetBehavior) == false) goto L93;
        r103 = (PadBottomSheetBehavior) r137;
    L93:
        if (r103 == null) goto L96;
        Location r138 = this.f205318x;
        Intrinsics.checkNotNullParameter(r138, "<set-?>");
        r103.M = r138;
    L96:
        int r139 = a.f205321a[this.f205318x.ordinal()];
        if (r139 == 1) goto L102;
        if (r139 == 2) goto L102;
        if (r139 != 3) goto L103;
        r136.gravity = GravityCompat.END;
        r136.setMarginEnd(44);
        ((ViewGroup.MarginLayoutParams) r136).bottomMargin = 44;
    L103:
        r134.setLayoutParams(r136);
    L102:
        r136.gravity = 1;
        r136.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r136).bottomMargin = 0;
        goto L103
    L105:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    L106:
        FrameLayout r140 = L0();
        if (r140 == null) goto L114;
        Resources r141 = Resources.getSystem();
        float r142 = TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r141, r141.getDisplayMetrics()));
        Intrinsics.checkNotNullParameter(r140, "<this>");
        r140.setOutlineProvider(new m(r140, true, true, true, true, r142));
        r140.setClipToOutline(true);
        return;
    L114:
        return;
    L60:
        r124 = Intrinsics.areEqual(r109, hm4.b.f485924i);
        goto L62
    L57:
        r123 = Intrinsics.areEqual(r109, hm4.b.f485923h);
        goto L58
    L54:
        r122 = Intrinsics.areEqual(r109, hm4.b.f485922g);
        goto L55
    L32:
        r113 = Intrinsics.areEqual(r109, hm4.b.f485920e);
        goto L34
    L29:
        r112 = Intrinsics.areEqual(r109, hm4.b.f485919d);
        goto L30
    L26:
        r111 = Intrinsics.areEqual(r109, hm4.b.f485918c);
        goto L27
    L19:
        r108 = null;
        goto L20
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Function1<? super MotionEvent, Boolean> r101 = this.f205312r;
        if (r101 == null) goto L9;
        if (r101.invoke(r100).booleanValue() == false) goto L9;
        return true;
    L9:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        boolean r101 = true;
        J0().f205263l = true;
        J0().G = this.B;
        J0().I = !this.f205317w;
        if (this.f205306l == false) goto L26;
        this.f205296g = true;
        BottomSheetBehavior<FrameLayout> r102 = J0();
        Integer r103 = this.f205320z;
        if (r103 == null) goto L7;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.intValue();
    L25:
        r102.setPeekHeight(r104);
        return;
    L7:
        Resources r105 = getContext().getResources();
        if (r105 == null) goto L10;
        Integer r106 = Integer.valueOf(r105.getIdentifier("config_showNavigationBar", "bool", "android"));
    L11:
        if (r106 != null) goto L13;
    L20:
        r101 = false;
    L21:
        if (r101 == false) goto L23;
        double r107 = g.d(getContext());
        double r108 = 0.65d;
    L24:
        r104 = (int) (r107 * r108);
        goto L25
    L23:
        r107 = g.d(getContext());
        r108 = 0.6d;
        goto L24
    L13:
        if (r106.intValue() <= 0) goto L20;
        Resources r109 = getContext().getResources();
        if (r109 == null) goto L17;
        boolean r110 = r109.getBoolean(r106.intValue());
    L18:
        if (r110 == false) goto L20;
    L17:
        r110 = false;
        goto L18
    L10:
        r106 = null;
        goto L11
    L26:
        BottomSheetBehavior<FrameLayout> r111 = J0();
        com.bytedance.dux.panel.header.d r112 = this.f205310p;
        if ((r112 instanceof com.bytedance.dux.panel.header.c) == true) goto L36;
        if (r112 != null) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == true) goto L36;
        r101 = false;
        goto L36
    L30:
        if (r112.f205393e != true) goto L32;
        r113 = true;
    L36:
        r111.f205264m = r101;
        if (this.f205304j <= 0) goto L45;
        BottomSheetBehavior<FrameLayout> r114 = J0();
        int r115 = this.f205304j;
        r114.f205254c = r115;
        if (this.f205314t == false) goto L46;
        FrameLayout r116 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r116 == null) goto L47;
        r116.getLayoutParams().height = r115;
        return;
    L47:
        return;
    L46:
        return;
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(O0(0, r100, null));
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(O0(r100, null, null));
    }

    public DuxBasePanelDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f205304j = -1;
        this.f205308n = true;
        this.f205318x = Location.CENTER;
        this.B = true;
        this.F = true;
    }

    @Override // com.bytedance.dux.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(O0(0, r100, r101));
    }

    public final ConstraintLayout O0(int r100, View r101, ViewGroup.LayoutParams r102) {
        if (this.G != null) goto L5;
    L8:
        ConstraintLayout r103 = (ConstraintLayout) View.inflate(getContext(), R.layout.dux_basic_panel, null);
        this.G = r103;
        if (r103 == null) goto L11;
        RadiusLayout r104 = (RadiusLayout) r103.findViewById(R.id.header_container);
    L12:
        this.H = r104;
        ConstraintLayout r105 = this.G;
        if (r105 == null) goto L15;
        RadiusLayout r106 = (RadiusLayout) r105.findViewById(R.id.content_container);
    L16:
        this.I = r106;
    L18:
        if (r100 == 0) goto L21;
        if (r101 != null) goto L21;
        r101 = getLayoutInflater().inflate(r100, this.I, false);
    L21:
        RadiusLayout r107 = this.I;
        if (r107 == null) goto L24;
        r107.removeAllViews();
    L24:
        if (r102 != null) goto L28;
        RadiusLayout r108 = this.I;
        if (r108 == null) goto L32;
        r108.addView(r101);
    L32:
        if (this.f205310p != null) goto L34;
        this.f205310p = new com.bytedance.dux.panel.header.b(getContext());
    L34:
        int r109 = im4.a.f490534a;
        Activity r110 = em4.a.getActivity(getContext());
        DuxBreakPointController r111 = gm4.a.f481672a;
        hm4.c r112 = new hm4.c(r110);
        r112.f485932b = 1;
        hm4.b r113 = gm4.a.e(r112);
        hm4.c r114 = new hm4.c(r110);
        r114.f485932b = 2;
        N0(new hm4.d(r113, gm4.a.e(r114), gm4.a.c(null)));
        hm4.c r115 = new hm4.c(this.f205291b);
        r115.f485932b = 1;
        gm4.a.b(r115, new b(this));
        if (this.F == false) goto L37;
        Resources r116 = Resources.getSystem();
        float r117 = TypedValue.applyDimension(1, 20, WindowDisplayMetricsOverride.apply(r116, r116.getDisplayMetrics()));
    L38:
        RadiusLayout r118 = this.H;
        if (r118 == null) goto L42;
        r118.d(r117, r117, 0.0f, 0.0f);
    L42:
        if (this.f205307m == false) goto L46;
        RadiusLayout r119 = this.I;
        if (r119 == null) goto L46;
        r119.d(r117, r117, 0.0f, 0.0f);
    L46:
        com.bytedance.dux.panel.header.d r120 = this.f205310p;
        if (r120 == null) goto L51;
        View r121 = r120.c();
        if (r121 == null) goto L51;
        ViewParent r122 = r121.getParent();
    L53:
        if ((r122 instanceof ViewGroup) == false) goto L70;
        com.bytedance.dux.panel.header.d r123 = this.f205310p;
        if (r123 == null) goto L59;
        View r124 = r123.c();
        if (r124 == null) goto L59;
        ViewParent r125 = r124.getParent();
    L61:
        if ((r125 instanceof ViewGroup) == false) goto L63;
        ViewGroup r126 = (ViewGroup) r125;
    L64:
        if (r126 == null) goto L70;
        com.bytedance.dux.panel.header.d r127 = this.f205310p;
        if (r127 == null) goto L68;
        View r128 = r127.c();
    L69:
        r126.removeView(r128);
        goto L70
    L68:
        r128 = null;
        goto L69
    L63:
        r126 = null;
    L59:
        r125 = null;
    L70:
        RadiusLayout r129 = this.H;
        if (r129 == null) goto L86;
        com.bytedance.dux.panel.header.d r130 = this.f205310p;
        if (r130 == null) goto L75;
        View r131 = r130.c();
    L76:
        Intrinsics.checkNotNullParameter(r129, "<this>");
        if (r131 == null) goto L79;
        ViewParent r132 = r131.getParent();
    L80:
        if (r132 != null) goto L82;
    L84:
        r129.addView(r131);
        goto L86
    L82:
        if ((r131.getParent() instanceof ViewGroup) == false) goto L84;
        n.g(r131);
        goto L84
    L79:
        r132 = null;
        goto L80
    L75:
        r131 = null;
    L86:
        if (this.f205307m == false) goto L97;
        if (this.I == null) goto L97;
        ConstraintSet r133 = new ConstraintSet();
        r133.clone(this.G);
        RadiusLayout r134 = this.I;
        Intrinsics.checkNotNull(r134);
        r133.clear(r134.getId(), 3);
        RadiusLayout r135 = this.I;
        Intrinsics.checkNotNull(r135);
        r133.connect(r135.getId(), 3, 0, 3);
        r133.applyTo(this.G);
        RadiusLayout r136 = this.H;
        if (r136 == null) goto L93;
        r136.setBackground(null);
    L93:
        RadiusLayout r137 = this.H;
        if (r137 == null) goto L97;
        r137.bringToFront();
    L97:
        if (this.f205308n == true) goto L102;
        Window r138 = getWindow();
        if (r138 == null) goto L102;
        r138.setDimAmount(0.0f);
    L102:
        if (this.f205309o == false) goto L123;
        Integer r139 = this.C;
        if (r139 == null) goto L110;
        int r140 = r139.intValue();
        Window r141 = getWindow();
        if (r141 == null) goto L123;
        r141.setNavigationBarColor(r140);
        goto L123
    L110:
        if (this.f205311q == false) goto L116;
        if (this.f205305k == false) goto L114;
        int r142 = R.color.BGPanelTone;
    L119:
        Window r143 = getWindow();
        if (r143 == null) goto L123;
        r143.setNavigationBarColor(ContextCompat.getColor(getContext(), r142));
        goto L123
    L114:
        r142 = R.color.BGPanelTint;
        goto L119
    L116:
        if (this.f205305k == false) goto L118;
        r142 = R.color.ConstBGPanelReverse;
        goto L119
    L118:
        r142 = R.color.ConstTextInverse;
    L123:
        ConstraintLayout r144 = this.G;
        Intrinsics.checkNotNull(r144);
        return r144;
    L51:
        r122 = null;
        goto L53
    L37:
        r117 = 0.0f;
        goto L38
    L28:
        RadiusLayout r145 = this.I;
        if (r145 == null) goto L32;
        r145.addView(r101, r102);
        goto L32
    L15:
        r106 = null;
        goto L16
    L11:
        r104 = null;
        goto L12
    L5:
        if (this.H == null) goto L8;
        if (this.I != null) goto L18;
        goto L8
    }
}
