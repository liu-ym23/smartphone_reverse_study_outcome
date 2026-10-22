package com.obric.oui.paneltitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alipay.sdk.m.x.d;
import com.larus.nova.R;
import com.obric.oui.text.OTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/oui/paneltitlebar/OPanelTitleBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "type", "", "setType", "", "title", d.f25925o, "info", "setInfo", "Landroid/view/View;", "view", "setActionView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPanelTitleBar extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f402129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f402130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f402131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f402132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f402133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f402134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OTextView f402135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OTextView f402136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f402137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f402138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f402139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f402140l;

    public static final class a {
    }

    static {
    }

    public OPanelTitleBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPanelTitleBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5(int r100) {
        if (r100 == 0) goto L8;
        int r101 = R.layout.o_panel_title_bar_regular;
        if (r100 == 1) goto L7;
        setPadding(pla.d.n(this, 12), pla.d.n(this, 12), pla.d.n(this, 12), pla.d.n(this, 12));
    L9:
        removeAllViews();
        View r102 = LayoutInflater.from(getContext()).inflate(r101, this, true);
        this.f402135g = (OTextView) r102.findViewById(R.id.panel_title);
        this.f402136h = (OTextView) r102.findViewById(R.id.panel_info);
        this.f402137i = (ImageView) r102.findViewById(R.id.panel_expand_icon);
        this.f402138j = (ImageView) r102.findViewById(R.id.panel_info_icon);
        this.f402139k = (FrameLayout) r102.findViewById(R.id.panel_action_container);
        return;
    L7:
        setPadding(pla.d.n(this, 12), pla.d.n(this, 12), pla.d.n(this, 12), pla.d.n(this, 12));
        goto L9
    L8:
        setPadding(pla.d.n(this, 12), pla.d.n(this, 14), pla.d.n(this, 12), pla.d.n(this, 8));
        r101 = R.layout.o_panel_title_bar_display;
        goto L9
    }

    public final void setActionView(View r100) {
        this.f402140l = r100;
        FrameLayout r101 = this.f402139k;
        if (r101 == null) goto L6;
        r101.removeAllViews();
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        FrameLayout r102 = this.f402139k;
        if (r102 == null) goto L13;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 21;
        Unit r104 = Unit.INSTANCE;
        r102.addView(r100, r103);
        return;
    }

    public final void setInfo(String r100) {
        this.f402134f = r100;
        OTextView r101 = this.f402136h;
        if (r101 == null) goto L7;
        r101.setText(r100);
        return;
    }

    public final void setTitle(String r100) {
        this.f402133e = r100;
        OTextView r101 = this.f402135g;
        if (r101 == null) goto L7;
        r101.setText(r100);
        return;
    }

    public final void setType(int r100) {
        if (r100 == 0) goto L6;
        if (r100 == 1) goto L6;
        return;
    L6:
        if (r100 == this.f402129a) goto L25;
        this.f402129a = r100;
        R5(r100);
        setTitle(this.f402133e);
        setInfo(this.f402134f);
        boolean r101 = this.f402130b;
        this.f402130b = r101;
        OTextView r102 = this.f402136h;
        if (r102 == null) goto L12;
        j.h(r102, r101);
    L12:
        boolean r103 = this.f402132d;
        this.f402132d = r103;
        ImageView r104 = this.f402137i;
        if (r104 == null) goto L16;
        j.h(r104, r103);
    L16:
        boolean r105 = this.f402131c;
        this.f402131c = r105;
        ImageView r106 = this.f402138j;
        if (r106 == null) goto L20;
        j.h(r106, r105);
    L20:
        View r107 = this.f402140l;
        if (r107 == null) goto L26;
        setActionView(r107);
        return;
    L26:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OPanelTitleBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        boolean r103 = true;
        this.f402129a = 1;
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_panel_info, R.attr.oui_panel_show_expand_icon, R.attr.oui_panel_show_info, R.attr.oui_panel_show_info_icon, R.attr.oui_panel_title, R.attr.oui_panel_type}, r102, 0);
        this.f402129a = r104.getInt(5, 1);
        this.f402130b = r104.getBoolean(2, true);
        this.f402131c = r104.getBoolean(3, false);
        this.f402132d = r104.getBoolean(1, false);
        this.f402133e = r104.getString(4);
        this.f402134f = r104.getString(0);
        r104.recycle();
        R5(this.f402129a);
        setTitle(this.f402133e);
        setInfo(this.f402134f);
        if (this.f402130b == false) goto L13;
        String r105 = this.f402134f;
        if (r105 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L13;
    L14:
        this.f402130b = r103;
        OTextView r107 = this.f402136h;
        if (r107 == null) goto L18;
        j.h(r107, r103);
    L18:
        boolean r108 = this.f402132d;
        this.f402132d = r108;
        ImageView r109 = this.f402137i;
        if (r109 == null) goto L22;
        j.h(r109, r108);
    L22:
        boolean r110 = this.f402131c;
        this.f402131c = r110;
        ImageView r111 = this.f402138j;
        if (r111 == null) goto L27;
        j.h(r111, r110);
        return;
    L27:
        return;
    L7:
        if (r105.length() == 0) goto L10;
        r106 = false;
    L13:
        r103 = false;
        goto L14
    }

    public /* synthetic */ OPanelTitleBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
