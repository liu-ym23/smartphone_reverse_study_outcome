package com.obric.oui.searchbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OInputView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/obric/oui/searchbar/OSearchBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "enabled", "", "setEnabled", "", "text", "setText", "getText", "Landroid/text/TextUtils$TruncateAt;", "where", "setEllipsize", "getEllipsize", "searchActionText", "setSearchActionText", "Landroid/view/View$OnClickListener;", "click", "setSearchAction", "Landroid/view/View$OnFocusChangeListener;", "onFocusChangeListener", "setOnInputFocusChange", "Landroid/view/View;", "getPrefixView", "getPostfixView", "Lcom/obric/oui/forms/OInputView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "inputView", "Landroid/content/Context;", "originContext", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OSearchBar extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f402607e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OInputView f402608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f402609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrameLayout f402610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OButton f402611d;

    public final TextUtils.TruncateAt getEllipsize() {
        return this.f402608a.getEllipsize();
    }

    public final View getPostfixView() {
        FrameLayout r100 = this.f402610c;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getChildCount() > 0) goto L8;
        return null;
    L8:
        return r100.getChildAt(0);
    }

    public final View getPrefixView() {
        if (this.f402609b.getChildCount() > 0) goto L7;
        return null;
    L7:
        return this.f402609b.getChildAt(0);
    }

    public final String getText() {
        String r100 = this.f402608a.getText();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final OInputView getInputView() {
        return this.f402608a;
    }

    public OSearchBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "originContext");
        this(r100, null);
    }

    public final void setEllipsize(TextUtils.TruncateAt r100) {
        this.f402608a.setEllipsize(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        this.f402608a.setEnabled(r100);
        super.setEnabled(r100);
    }

    public final void setOnInputFocusChange(View.OnFocusChangeListener r100) {
        Intrinsics.checkNotNullParameter(r100, "onFocusChangeListener");
        this.f402608a.setOnFocusChangeListener(r100);
    }

    public final void setSearchAction(final View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "click");
        this.f402611d.setOnClickListener(new a(this, r100));
    }

    public final void setSearchActionText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "searchActionText");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        j.e(this.f402611d);
        return;
    L8:
        this.f402611d.setText(r100);
        j.f(this.f402611d);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f402608a.setText(r100);
    }

    public OSearchBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "originContext");
        super(r100, r101);
        ViewGroup.inflate(getContext(), R.layout.o_widget_search_bar, this);
        this.f402608a = (OInputView) findViewById(R.id.input_view);
        FrameLayout r102 = (FrameLayout) findViewById(R.id.o_input_left_view_container);
        this.f402609b = r102;
        this.f402611d = (OButton) findViewById(R.id.search_action);
        TypedArray r103 = getContext().getTheme().obtainStyledAttributes(r101, new int[]{android.R.attr.ellipsize, android.R.attr.layout_height, android.R.attr.text, android.R.attr.hint, R.attr.oui_search_actionText, R.attr.oui_search_postfixView, R.attr.oui_search_prefixView, R.attr.oui_widgetBgColor, R.attr.oui_widgetBgColorResting, R.attr.oui_widgetEnableMaterial, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialDisabled, R.attr.oui_widgetMaterialResting, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowResting, R.attr.oui_widgetTextColor, R.attr.oui_widgetTextColorHint}, 0, 0);
        getInputView().setHint(r103.getString(3));
        getInputView().setText(r103.getString(2));
        if (r103.hasValue(0) == false) goto L15;
        int r104 = r103.getInt(0, 0);
        if (r104 == 1) goto L13;
        if (r104 == 2) goto L12;
        if (r104 == 3) goto L11;
        if (r104 == 4) goto L10;
        TextUtils.TruncateAt r105 = null;
    L14:
        setEllipsize(r105);
        goto L15
    L10:
        r105 = TextUtils.TruncateAt.MARQUEE;
        goto L14
    L11:
        r105 = TextUtils.TruncateAt.END;
        goto L14
    L12:
        r105 = TextUtils.TruncateAt.MIDDLE;
        goto L14
    L13:
        r105 = TextUtils.TruncateAt.START;
    L15:
        final int r106 = r103.getResourceId(5, 0);
        if (r106 == 0) goto L18;
        getInputView().setActionView(new OSearchBar$1$1(this, r106));
    L18:
        if (r106 != 0) goto L22;
        int r107 = r103.getResourceId(6, R.layout.o_widget_search_bar_prefix);
        if (r107 == 0) goto L22;
        ViewGroup.inflate(getContext(), r107, r102);
        j.f(r102);
    L22:
        String r108 = r103.getString(4);
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        setSearchActionText(r108);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
