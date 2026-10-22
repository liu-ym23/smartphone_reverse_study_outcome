package com.obric.oui.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e¢\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0010\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0013R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/Checkable;", "", "enabled", "", "setEnabled", "checked", "setChecked", "Lcom/obric/oui/checkbox/OCheckBox$a;", "listener", "setOnCheckedChangeListener", "Lcom/obric/oui/checkbox/OCheckBox$b;", "setOnCheckedStateChangedListener", "", "color", "setPrimaryColor", "light", "setAlwaysLight", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "value", "getCheckedState", "()I", "setCheckedState", "(I)V", "checkedState", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OCheckBoxLayout extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCheckBox f399396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OStateGradientDrawable f399397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f399398c;

    public OCheckBoxLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OCheckBoxLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    public final int getCheckedState() {
        return this.f399396a.getCheckedState();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f399396a.isChecked();
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.f399396a.performClick();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        this.f399396a.toggle();
    }

    public final OCheckBox getCheckBox() {
        return this.f399396a;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        int r101 = d.n(this, 32);
        this.f399398c = r101;
        this.f399397b.setCornerRadius(r101);
    }

    public final void setAlwaysLight(boolean r100) {
        this.f399396a.setAlwaysLight(r100);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        this.f399396a.setChecked(r100);
    }

    public final void setCheckedState(int r100) {
        this.f399396a.setCheckedState(r100);
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        this.f399396a.setEnabled(r100);
    }

    public final void setOnCheckedChangeListener(OCheckBox.a r100) {
        this.f399396a.setOnCheckedChangeListener(r100);
    }

    public final void setOnCheckedStateChangedListener(OCheckBox.b r100) {
        this.f399396a.setOnCheckedStateChangedListener(r100);
    }

    public final void setPrimaryColor(int r100) {
        this.f399396a.setPrimaryColor(r100);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.makeMeasureSpec(this.f399398c, 1073741824);
        super.onMeasure(r102, r102);
    }

    public OCheckBoxLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        OStateGradientDrawable r103 = new OStateGradientDrawable();
        this.f399397b = r103;
        this.f399398c = d.n(this, 32);
        if (r101 == null) goto L5;
        OCheckBox r104 = new OCheckBox(r100, r101, r102);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        r104.setLayoutParams(r105);
        this.f399396a = r104;
        addView(r104);
    L6:
        this.f399396a.setEnableExpandTouchRect(false);
        r103.setCornerRadius(this.f399398c);
        ColorStateList r106 = ContextCompat.getColorStateList(r100, R.color.o_checkbox_layout_bg_color);
        Intrinsics.checkNotNull(r106);
        r103.setSolidColors(r106);
        setBackground(r103);
        setClickable(true);
        return;
    L5:
        OCheckBox r107 = new OCheckBox(r100);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams(-2, -2);
        r108.gravity = 17;
        r107.setLayoutParams(r108);
        this.f399396a = r107;
        addView(r107);
        goto L6
    }

    public /* synthetic */ OCheckBoxLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
