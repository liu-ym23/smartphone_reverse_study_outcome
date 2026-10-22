package com.ss.android.lark.flow.feed.component.tag;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020\u00112\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/tag/FlowTagView;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "iconView", "Landroidx/appcompat/widget/AppCompatImageView;", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "hasIcon", "setTagBackgroundColor", "color", "setIcon", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "str", "", "setTextSize", "textSize", "", "setTextColor", "setTextStyle", "style", "Companion", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTagView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GradientDrawable f423342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f423343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatTextView f423344c;

    public static final class a {
    }

    static {
    }

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
        if (this.f423343b.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f423343b.getDrawable() == null) goto L10;
        return true;
    L5:
        r100 = false;
        goto L6
    }

    public final void setIcon(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f423343b.setImageDrawable(r100);
        this.f423343b.setVisibility(0);
        requestLayout();
        invalidate();
    }

    public final void setTagBackgroundColor(int r100) {
        this.f423342a.setColor(r100);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        this.f423344c.setText(r100);
        requestLayout();
        invalidate();
    }

    public final void setTextColor(int r100) {
        this.f423344c.setTextColor(r100);
    }

    public final void setTextSize(float r100) {
        this.f423344c.setTextSize(2, r100);
        requestLayout();
        invalidate();
    }

    public final void setTextStyle(int r100) {
        this.f423344c.setTypeface(null, r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (a() == false) goto L5;
        int r102 = View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(12.0f), 1073741824);
        int r103 = View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(12.0f), 1073741824);
        this.f423343b.measure(r102, r103);
    L5:
        int r104 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r105 = View.MeasureSpec.makeMeasureSpec(UIHelper.dp2px(22.0f), Integer.MIN_VALUE);
        this.f423344c.measure(r104, r105);
        if (a() == false) goto L8;
        int r106 = (this.f423343b.getMeasuredWidth() + UIHelper.dp2px(2.0f)) + this.f423344c.getMeasuredWidth();
    L9:
        int r107 = r106 + (UIHelper.dp2px(6.0f) * 2);
        int r108 = UIHelper.dp2px(22.0f);
        setMeasuredDimension(ViewGroup.resolveSize(r107, r100), ViewGroup.resolveSize(r108, r101));
        return;
    L8:
        r106 = this.f423344c.getMeasuredWidth();
        goto L9
    }

    public FlowTagView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        r103.setCornerRadius(UIHelper.dp2px(6.0f));
        this.f423342a = r103;
        AppCompatImageView r104 = new AppCompatImageView(r100);
        this.f423343b = r104;
        AppCompatTextView r105 = new AppCompatTextView(r100);
        this.f423344c = r105;
        setBackground(r103);
        ViewGroup.LayoutParams r106 = new ViewGroup.LayoutParams(UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f));
        r104.setVisibility(8);
        addView(r104, r106);
        addView(r105, new ViewGroup.LayoutParams(-2, UIHelper.dp2px(12.0f)));
    }

    public /* synthetic */ FlowTagView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = r104 - r102;
        int r106 = UIHelper.dp2px(6.0f);
        if (a() == false) goto L5;
        int r107 = (r105 - this.f423343b.getMeasuredHeight()) / 2;
        int r108 = this.f423343b.getMeasuredHeight() + r107;
        int r109 = this.f423343b.getMeasuredWidth() + r106;
        this.f423343b.layout(r106, r107, r109, r108);
        int r110 = (r105 - this.f423344c.getMeasuredHeight()) / 2;
        int r111 = this.f423344c.getMeasuredHeight() + r110;
        int r112 = (r106 + this.f423343b.getMeasuredWidth()) + UIHelper.dp2px(2.0f);
        int r113 = this.f423344c.getMeasuredWidth() + r112;
        this.f423344c.layout(r112, r110, r113, r111);
        return;
    L5:
        int r114 = (r105 - this.f423344c.getMeasuredHeight()) / 2;
        int r115 = this.f423344c.getMeasuredHeight() + r114;
        int r116 = this.f423344c.getMeasuredWidth() + r106;
        this.f423344c.layout(r106, r114, r116, r115);
    }
}
