package com.bytedance.ee.bear.widgets.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\nH\u0014J0\u0010/\u001a\u00020+2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001a\u0010$\u001a\u00020%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/widgets/panel/PanelTitleBarContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "leftIconIV", "Landroidx/appcompat/widget/AppCompatImageView;", "getLeftIconIV", "()Landroidx/appcompat/widget/AppCompatImageView;", "setLeftIconIV", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "rightIconIV", "getRightIconIV", "setRightIconIV", "leftTV", "Landroid/widget/TextView;", "getLeftTV", "()Landroid/widget/TextView;", "setLeftTV", "(Landroid/widget/TextView;)V", "rightTV", "getRightTV", "setRightTV", "titleTV", "getTitleTV", "setTitleTV", "subTitleTV", "getSubTitleTV", "setSubTitleTV", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "setTitleContainer", "(Landroid/widget/LinearLayout;)V", "initView", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "base-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelTitleBarContainer extends RelativeLayout {
    public AppCompatImageView a;
    public AppCompatImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public LinearLayout g;

    public final AppCompatImageView getLeftIconIV() {
        AppCompatImageView r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leftIconIV");
        return null;
    }

    public final TextView getLeftTV() {
        TextView r0 = this.c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("leftTV");
        return null;
    }

    public final AppCompatImageView getRightIconIV() {
        AppCompatImageView r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rightIconIV");
        return null;
    }

    public final TextView getRightTV() {
        TextView r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("rightTV");
        return null;
    }

    public final TextView getSubTitleTV() {
        TextView r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("subTitleTV");
        return null;
    }

    public final LinearLayout getTitleContainer() {
        LinearLayout r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
        return null;
    }

    public final TextView getTitleTV() {
        TextView r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("titleTV");
        return null;
    }

    public PanelTitleBarContainer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a(r2);
    }

    public final void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        LayoutInflater.from(r2).inflate(2131559867, this);
        setLeftIconIV((AppCompatImageView) findViewById(2131377699));
        setRightIconIV((AppCompatImageView) findViewById(2131384513));
        setLeftTV((TextView) findViewById(2131377709));
        setRightTV((TextView) findViewById(2131384526));
        setTitleTV((TextView) findViewById(2131388789));
        setSubTitleTV((TextView) findViewById(2131387520));
        setTitleContainer((LinearLayout) findViewById(2131388777));
    }

    public final void setLeftIconIV(AppCompatImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setLeftTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void setRightIconIV(AppCompatImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setRightTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setSubTitleTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setTitleContainer(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setTitleTV(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public PanelTitleBarContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a(r2);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r14, int r15) {
        super.onMeasure(r14, r15);
        int r1 = 0;
        if (getLeftIconIV().getVisibility() != 0) goto L5;
        int r0 = getLeftIconIV().getMeasuredWidth();
    L7:
        if (getRightIconIV().getVisibility() != 0) goto L9;
        int r2 = getRightIconIV().getMeasuredWidth();
    L11:
        if (getLeftTV().getVisibility() != 0) goto L13;
        int r3 = getLeftTV().getMeasuredWidth();
    L15:
        if (getRightTV().getVisibility() != 0) goto L17;
        r1 = getRightTV().getMeasuredWidth();
    L17:
        int r4 = Math.max(Math.max(Math.max(r0, r2), r3), r1);
        if (r4 <= 0) goto L23;
        int r16 = View.MeasureSpec.getSize(r14) - (r4 * 2);
        measureChildWithMargins(getTitleTV(), View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), 0, r15, 0);
        if (getSubTitleTV().getVisibility() != 0) goto L24;
        measureChildWithMargins(getSubTitleTV(), View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), 0, r15, 0);
        return;
    L24:
        return;
    L23:
        return;
    L13:
        r3 = 0;
        goto L15
    L9:
        r2 = 0;
        goto L11
    L5:
        r0 = 0;
        goto L7
    }

    public PanelTitleBarContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a(r2);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (getSubTitleTV().getVisibility() != 0) goto L5;
        int r6 = Math.max(getTitleTV().getMeasuredWidth(), getSubTitleTV().getMeasuredWidth());
    L6:
        int r7 = (getMeasuredWidth() - r6) / 2;
        int r8 = (getMeasuredHeight() - getTitleContainer().getMeasuredHeight()) / 2;
        tt5.a.h("PanelTitleBarContainer", "titleMaxWidth: " + r6 + ", left: " + r7 + ", top: " + r8);
        getTitleContainer().layout(r7, r8, r6 + r7, getTitleContainer().getMeasuredHeight() + r8);
        return;
    L5:
        r6 = getTitleTV().getMeasuredWidth();
        goto L6
    }
}
