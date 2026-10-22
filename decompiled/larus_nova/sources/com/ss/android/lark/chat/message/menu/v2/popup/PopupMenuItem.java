package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.byted.cast.common.CastMonitor;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0014J0\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0014J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0016J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001fJ\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bJ\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\bH\u0016R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0017\u0010\u000e¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/popup/PopupMenuItem;", "Landroid/view/ViewGroup;", "Lcom/ss/android/lark/chat/message/menu/v2/popup/IPopupMenuItemView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView$delegate", "Lkotlin/Lazy;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView$delegate", "arrowView", "getArrowView", "arrowView$delegate", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "setIcon", "resId", "drawable", "Landroid/graphics/drawable/Drawable;", "setText", "text", "", "showArrow", "show", "setArrowTint", "color", "setIconTint", "setTextColor", "setBgColor", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PopupMenuItem extends ViewGroup implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f415816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f415817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f415818c;

    public PopupMenuItem(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PopupMenuItem(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final ImageView getArrowView() {
        return (ImageView) this.f415818c.getValue();
    }

    private final ImageView getIconView() {
        return (ImageView) this.f415816a.getValue();
    }

    private final TextView getTextView() {
        return (TextView) this.f415817b.getValue();
    }

    public final void a(boolean r100) {
        ImageView r101 = getArrowView();
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setArrowTint(int r100) {
        getArrowView().setImageTintList(ColorStateList.valueOf(r100));
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setBgColor(int r100) {
        setBackgroundResource(r100);
    }

    public void setIcon(Drawable r100) {
        if (r100 == null) goto L4;
        getIconView().setImageDrawable(r100);
        getIconView().setVisibility(0);
        return;
    L4:
        getIconView().setVisibility(8);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setIconTint(int r100) {
        getIconView().setImageTintList(ColorStateList.valueOf(r100));
    }

    public void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        getTextView().setText(r100);
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.popup.b
    public void setTextColor(int r100) {
        getTextView().setTextColor(r100);
    }

    public void setIcon(int r100) {
        getIconView().setImageResource(r100);
        getIconView().setVisibility(0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = UIUtils.dp2px(getContext(), 48.0f);
        int r105 = View.MeasureSpec.makeMeasureSpec(r104, Integer.MIN_VALUE);
        measureChild(getIconView(), r100, r105);
        measureChild(getArrowView(), r100, r105);
        int r106 = UIUtils.dp2px(getContext(), 16.0f);
        int r107 = UIUtils.dp2px(getContext(), 12.0f);
        int r108 = r106 * 2;
        if (getIconView().getVisibility() == 8) goto L6;
        r108 = r108 + (getIconView().getMeasuredWidth() + r107);
    L6:
        if (getArrowView().getVisibility() == 8) goto L9;
        r108 = r108 + (getArrowView().getMeasuredWidth() + r107);
    L9:
        if (r102 == Integer.MIN_VALUE) goto L12;
        if (r102 == 1073741824) goto L12;
        int r109 = Integer.MAX_VALUE;
    L13:
        getTextView().measure(View.MeasureSpec.makeMeasureSpec(r109, Integer.MIN_VALUE), r105);
        if (r102 == 1073741824) goto L17;
        r103 = r108 + getTextView().getMeasuredWidth();
    L17:
        setMeasuredDimension(r103, r104);
        return;
    L12:
        r109 = RangesKt.coerceAtLeast(r103 - r108, 0);
        goto L13
    }

    public PopupMenuItem(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415816a = LazyKt.lazy(new PopupMenuItem$iconView$2(r100));
        this.f415817b = LazyKt.lazy(new PopupMenuItem$textView$2(r100));
        this.f415818c = LazyKt.lazy(new PopupMenuItem$arrowView$2(r100));
        addView(getIconView());
        addView(getTextView());
        addView(getArrowView());
    }

    public /* synthetic */ PopupMenuItem(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r110) {
        int r111 = r110 - r102;
        int r104 = UIUtils.dp2px(getContext(), 16.0f);
        int r105 = UIUtils.dp2px(getContext(), 12.0f);
        if (getIconView().getVisibility() == 8) goto L5;
        int r106 = (r111 - getIconView().getMeasuredHeight()) / 2;
        getIconView().layout(r104, r106, getIconView().getMeasuredWidth() + r104, getIconView().getMeasuredHeight() + r106);
        int r107 = (getIconView().getMeasuredWidth() + r105) + r104;
    L7:
        if (getTextView().getVisibility() == 8) goto L10;
        int r108 = (r111 - getTextView().getMeasuredHeight()) / 2;
        getTextView().layout(r107, r108, getTextView().getMeasuredWidth() + r107, getTextView().getMeasuredHeight() + r108);
    L10:
        if (getArrowView().getVisibility() == 8) goto L13;
        int r109 = (r103 - r101) - r104;
        int r112 = r109 - getArrowView().getMeasuredWidth();
        int r113 = (r111 - getArrowView().getMeasuredHeight()) / 2;
        getArrowView().layout(r112, r113, r109, getArrowView().getMeasuredHeight() + r113);
        return;
    L13:
        return;
    L5:
        r107 = r104;
        goto L7
    }
}
