package com.obric.oui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/panel/OBasePanelDialog;", "Lcom/obric/oui/panel/BottomSheetDialog;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OBasePanelDialog extends BottomSheetDialog {
    public Integer A;
    public Function0<Boolean> B;
    public boolean C;
    public ConstraintLayout D;
    public RadiusLayout E;
    public RadiusLayout F;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402049j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f402050k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f402051l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f402052m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f402053n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f402054o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.obric.oui.panel.header.d f402055p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f402056q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Function1<? super MotionEvent, Boolean> f402057r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f402058s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f402059t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View.OnClickListener f402060u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f402061v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f402062w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f402063x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f402064y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f402065z;

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Function0<Boolean> r100 = this.B;
        boolean r101 = false;
        if (r100 != null) goto L6;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        super.onBackPressed();
        return;
    L6:
        if (r100.invoke().booleanValue() != true) goto L8;
        r101 = true;
        goto L8
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        if (this.f402058s == false) goto L8;
        FrameLayout r100 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r100 == null) goto L8;
        r100.setMinimumHeight(0);
    L8:
        if (this.C == true) goto L10;
        float r101 = 0.0f;
    L14:
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setCornerRadii(new float[]{r101, r101, r101, r101, 0.0f, 0.0f, 0.0f, 0.0f});
        if (this.f402056q == false) goto L21;
        if (this.f402050k == false) goto L19;
        int r103 = R.color.BGPanelTone;
    L24:
        r102.setColor(ContextCompat.getColor(getContext(), r103));
        if (this.f402038c != null) goto L27;
        I0();
    L27:
        FrameLayout r104 = this.f402038c;
        if (r104 == null) goto L32;
        r104.setBackground(r102);
    L32:
        if (this.f402051l == false) goto L40;
        Integer r105 = this.f402064y;
        if (r105 == null) goto L36;
        Intrinsics.checkNotNull(r105);
        int r106 = r105.intValue();
    L37:
        FrameLayout r107 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r107 == null) goto L40;
        r107.getLayoutParams().height = r106;
        goto L40
    L36:
        r106 = (int) (((double) pla.d.i(getContext())) * 0.9d);
    L40:
        boolean r108 = this.f402065z;
        FrameLayout r109 = (FrameLayout) findViewById(R.id.container);
        if (r109 == null) goto L44;
        r109.setFitsSystemWindows(r108);
    L44:
        J0().f401999b = this.f402051l;
        if (this.f402060u == null) goto L50;
        View r110 = findViewById(R.id.touch_outside);
        if (r110 == null) goto L50;
        r110.setOnClickListener(this.f402060u);
    L50:
        J0().F = this.f402061v;
        return;
    L19:
        r103 = R.color.BGPanelTint;
        goto L24
    L21:
        if (this.f402050k == false) goto L23;
        r103 = R.color.ConstBGPanelReverse;
        goto L24
    L23:
        r103 = R.color.ConstTextInverse;
        goto L24
    L10:
        if (this.f402038c != null) goto L12;
        I0();
    L12:
        r101 = pla.d.q(this.f402038c, 20);
        goto L14
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Function1<? super MotionEvent, Boolean> r101 = this.f402057r;
        if (r101 == null) goto L10;
        if (r101.invoke(r100).booleanValue() == false) goto L10;
        return true;
    L10:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        boolean r101 = true;
        J0().f402009l = true;
        J0().E = this.f402065z;
        J0().G = !this.f402062w;
        if (this.f402051l == false) goto L26;
        this.f402042g = true;
        BottomSheetBehavior<FrameLayout> r102 = J0();
        Integer r103 = this.f402063x;
        if (r103 == null) goto L7;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.intValue();
    L25:
        r102.setPeekHeight(r104);
        return;
    L7:
        Resources r105 = getContext().getResources();
        if (r105 != null) goto L10;
        Integer r106 = null;
    L11:
        if (r106 != null) goto L13;
    L20:
        r101 = false;
    L21:
        if (r101 == false) goto L23;
        double r107 = pla.d.i(getContext());
        double r108 = 0.65d;
    L24:
        r104 = (int) (r107 * r108);
        goto L25
    L23:
        r107 = pla.d.i(getContext());
        r108 = 0.6d;
        goto L24
    L13:
        if (r106.intValue() <= 0) goto L20;
        Resources r109 = getContext().getResources();
        if (r109 != null) goto L17;
        boolean r110 = false;
    L18:
        if (r110 == false) goto L20;
    L17:
        r110 = r109.getBoolean(r106.intValue());
        goto L18
    L10:
        r106 = Integer.valueOf(r105.getIdentifier("config_showNavigationBar", "bool", "android"));
        goto L11
    L26:
        BottomSheetBehavior<FrameLayout> r111 = J0();
        com.obric.oui.panel.header.d r112 = this.f402055p;
        if ((r112 instanceof com.obric.oui.panel.header.c) == true) goto L37;
        if (r112 != null) goto L31;
    L33:
        boolean r113 = false;
    L34:
        if (r113 == true) goto L37;
        r101 = false;
        goto L37
    L31:
        if (r112.f402128e != true) goto L33;
        r113 = true;
    L37:
        r111.f402010m = r101;
        if (this.f402049j <= 0) goto L46;
        BottomSheetBehavior<FrameLayout> r114 = J0();
        int r115 = this.f402049j;
        r114.f402000c = r115;
        if (this.f402059t == false) goto L47;
        FrameLayout r116 = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (r116 == null) goto L48;
        r116.getLayoutParams().height = r115;
        return;
    L48:
        return;
    L47:
        return;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(L0(0, r100, null));
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(int r100) {
        super.setContentView(L0(r100, null, null));
    }

    public OBasePanelDialog(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f402049j = -1;
        this.f402053n = true;
        this.f402065z = true;
        this.C = true;
    }

    @Override // com.obric.oui.panel.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void setContentView(View r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.setContentView(L0(0, r100, r101));
    }

    public final ConstraintLayout L0(int r100, View r101, ViewGroup.LayoutParams r102) {
        if (this.D != null) goto L5;
    L8:
        ConstraintLayout r103 = (ConstraintLayout) View.inflate(getContext(), R.layout.o_basic_panel, null);
        this.D = r103;
        if (r103 != null) goto L11;
        RadiusLayout r104 = null;
    L12:
        this.E = r104;
        ConstraintLayout r105 = this.D;
        if (r105 != null) goto L15;
        RadiusLayout r106 = null;
    L16:
        this.F = r106;
    L18:
        if (r100 == 0) goto L21;
        if (r101 != null) goto L21;
        r101 = getLayoutInflater().inflate(r100, this.F, false);
    L21:
        RadiusLayout r107 = this.F;
        if (r107 == null) goto L25;
        r107.removeAllViews();
    L25:
        if (r102 != null) goto L30;
        RadiusLayout r108 = this.F;
        if (r108 == null) goto L35;
        r108.addView(r101);
    L35:
        if (this.f402055p != null) goto L38;
        this.f402055p = new com.obric.oui.panel.header.b(getContext());
    L38:
        if (this.C == true) goto L40;
        float r109 = 0.0f;
    L44:
        RadiusLayout r110 = this.E;
        if (r110 == null) goto L49;
        r110.b(r109, r109, 0.0f, 0.0f);
    L49:
        if (this.f402052m == false) goto L54;
        RadiusLayout r111 = this.F;
        if (r111 == null) goto L54;
        r111.b(r109, r109, 0.0f, 0.0f);
    L54:
        com.obric.oui.panel.header.d r112 = this.f402055p;
        if (r112 == null) goto L59;
        View r113 = r112.b();
        if (r113 == null) goto L59;
        ViewParent r114 = r113.getParent();
    L62:
        if ((r114 instanceof ViewGroup) == false) goto L81;
        com.obric.oui.panel.header.d r115 = this.f402055p;
        if (r115 == null) goto L68;
        View r116 = r115.b();
        if (r116 == null) goto L68;
        ViewParent r117 = r116.getParent();
    L71:
        if ((r117 instanceof ViewGroup) == false) goto L73;
        ViewGroup r118 = (ViewGroup) r117;
    L74:
        if (r118 == null) goto L81;
        com.obric.oui.panel.header.d r119 = this.f402055p;
        if (r119 != null) goto L79;
        View r120 = null;
    L80:
        r118.removeView(r120);
        goto L81
    L79:
        r120 = r119.b();
        goto L80
    L73:
        r118 = null;
    L68:
        r117 = null;
    L81:
        RadiusLayout r121 = this.E;
        if (r121 == null) goto L98;
        com.obric.oui.panel.header.d r122 = this.f402055p;
        if (r122 != null) goto L87;
        View r123 = null;
    L88:
        Intrinsics.checkNotNullParameter(r121, "<this>");
        if (r123 != null) goto L91;
        ViewParent r124 = null;
    L92:
        if (r124 != null) goto L94;
    L96:
        r121.addView(r123);
        goto L98
    L94:
        if ((r123.getParent() instanceof ViewGroup) == false) goto L96;
        j.g(r123);
        goto L96
    L91:
        r124 = r123.getParent();
        goto L92
    L87:
        r123 = r122.b();
    L98:
        if (this.f402052m == false) goto L110;
        if (this.F == null) goto L110;
        ConstraintSet r125 = new ConstraintSet();
        r125.clone(this.D);
        RadiusLayout r126 = this.F;
        Intrinsics.checkNotNull(r126);
        r125.clear(r126.getId(), 3);
        RadiusLayout r127 = this.F;
        Intrinsics.checkNotNull(r127);
        r125.connect(r127.getId(), 3, 0, 3);
        r125.applyTo(this.D);
        RadiusLayout r128 = this.E;
        if (r128 == null) goto L105;
        r128.setBackground(null);
    L105:
        RadiusLayout r129 = this.E;
        if (r129 == null) goto L110;
        r129.bringToFront();
    L110:
        if (this.f402053n == true) goto L116;
        Window r130 = getWindow();
        if (r130 == null) goto L116;
        r130.setDimAmount(0.0f);
    L116:
        if (this.f402054o == false) goto L137;
        Integer r131 = this.A;
        if (r131 == null) goto L120;
        int r132 = r131.intValue();
        Window r133 = getWindow();
        if (r133 == null) goto L137;
        r133.setNavigationBarColor(r132);
        goto L137
    L120:
        if (this.f402056q == false) goto L126;
        if (this.f402050k == false) goto L124;
        int r134 = R.color.BGPanelTone;
    L129:
        Window r135 = getWindow();
        if (r135 == null) goto L137;
        r135.setNavigationBarColor(ContextCompat.getColor(getContext(), r134));
        goto L137
    L124:
        r134 = R.color.BGPanelTint;
        goto L129
    L126:
        if (this.f402050k == false) goto L128;
        r134 = R.color.ConstBGPanelReverse;
        goto L129
    L128:
        r134 = R.color.ConstTextInverse;
    L137:
        ConstraintLayout r136 = this.D;
        Intrinsics.checkNotNull(r136);
        return r136;
    L59:
        r114 = null;
        goto L62
    L40:
        if (this.f402038c != null) goto L42;
        I0();
    L42:
        r109 = pla.d.q(this.f402038c, 20);
        goto L44
    L30:
        RadiusLayout r137 = this.F;
        if (r137 == null) goto L35;
        r137.addView(r101, r102);
        goto L35
    L15:
        r106 = (RadiusLayout) r105.findViewById(R.id.content_container);
        goto L16
    L11:
        r104 = (RadiusLayout) r103.findViewById(R.id.header_container);
        goto L12
    L5:
        if (this.E == null) goto L8;
        if (this.F != null) goto L18;
        goto L8
    }
}
