package com.ss.android.lark.flow.common.component.tag;

import ahb.a;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J0\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\b\b\u0001\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u000bJ\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00132\b\b\u0001\u0010\u001f\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/flow/common/component/tag/FlowTagView;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tagStyle", "Lcom/ss/android/lark/flow/common/component/tag/FlowTagStyle;", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "hasIcon", "setTagBackgroundColor", "color", "setTagStyle", "style", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "str", "", "setTextSize", "textSize", "", "setTextColor", "setTextStyle", "flow-common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTagView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f423174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientDrawable f423175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f423176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f423177d;

    public FlowTagView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowTagView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final boolean a() {
        if (this.f423176c.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f423176c.getDrawable() == null) goto L10;
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f423176c.setImageDrawable(r100);
        this.f423176c.setVisibility(0);
        requestLayout();
        invalidate();
    }

    public final void setTagBackgroundColor(int r100) {
        this.f423175b.setColor(r100);
    }

    public final void setTagStyle(a r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f423174a = r100;
        this.f423177d.setTextSize(2, r100.f3702a);
        int r101 = UIUtils.dp2px(getContext(), r100.f3703b);
        setPaddingRelative(r101, getPaddingTop(), r101, getPaddingBottom());
        this.f423175b.setCornerRadius(UIUtils.dp2px(getContext(), r100.f3705d));
        requestLayout();
        invalidate();
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f423177d.setText(r100);
        requestLayout();
        invalidate();
    }

    public final void setTextColor(int r100) {
        this.f423177d.setTextColor(r100);
    }

    public final void setTextSize(float r100) {
        this.f423177d.setTextSize(2, r100);
        requestLayout();
        invalidate();
    }

    public final void setTextStyle(int r100) {
        this.f423177d.setTypeface(null, r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = UIUtils.dp2px(getContext(), this.f423174a.f3706e);
        int r103 = UIUtils.dp2px(getContext(), this.f423174a.f3704c);
        int r104 = UIUtils.dp2px(getContext(), this.f423174a.f3707f);
        if (a() == false) goto L5;
        int r105 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
        int r106 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
        this.f423176c.measure(r105, r106);
    L5:
        int r107 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r108 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtLeast((r103 - getPaddingTop()) - getPaddingBottom(), 0), Integer.MIN_VALUE);
        this.f423177d.measure(r107, r108);
        if (a() == false) goto L8;
        int r109 = (this.f423176c.getMeasuredWidth() + r104) + this.f423177d.getMeasuredWidth();
    L9:
        setMeasuredDimension(ViewGroup.resolveSize((getPaddingLeft() + r109) + getPaddingRight(), r100), ViewGroup.resolveSize(r103, r101));
        return;
    L8:
        r109 = this.f423177d.getMeasuredWidth();
        goto L9
    }

    public FlowTagView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f423174a = new a(0.0f, 0.0f, 0.0f, 0.0f, 63);
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        this.f423175b = r102;
        AppCompatImageView r111 = new AppCompatImageView(r100);
        this.f423176c = r111;
        AppCompatTextView r103 = new AppCompatTextView(r100);
        this.f423177d = r103;
        setBackground(r102);
        ViewGroup.LayoutParams r104 = new ViewGroup.LayoutParams(-2, -2);
        r111.setVisibility(8);
        addView(r111, r104);
        addView(r103, new ViewGroup.LayoutParams(-2, -2));
        setTagStyle(this.f423174a);
    }

    public /* synthetic */ FlowTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getPaddingLeft();
        int r106 = getPaddingTop() + ((((r104 - r102) - getPaddingTop()) - getPaddingBottom()) / 2);
        int r107 = UIUtils.dp2px(getContext(), this.f423174a.f3707f);
        if (a() == false) goto L5;
        int r108 = r106 - (this.f423176c.getMeasuredHeight() / 2);
        int r109 = this.f423176c.getMeasuredHeight() + r108;
        int r110 = this.f423176c.getMeasuredWidth() + r105;
        this.f423176c.layout(r105, r108, r110, r109);
        int r111 = r106 - (this.f423177d.getMeasuredHeight() / 2);
        int r112 = this.f423177d.getMeasuredHeight() + r111;
        int r113 = (r105 + this.f423176c.getMeasuredWidth()) + r107;
        int r114 = this.f423177d.getMeasuredWidth() + r113;
        this.f423177d.layout(r113, r111, r114, r112);
        return;
    L5:
        int r115 = r106 - (this.f423177d.getMeasuredHeight() / 2);
        int r116 = this.f423177d.getMeasuredHeight() + r115;
        int r117 = this.f423177d.getMeasuredWidth() + r105;
        this.f423177d.layout(r105, r115, r117, r116);
    }
}
