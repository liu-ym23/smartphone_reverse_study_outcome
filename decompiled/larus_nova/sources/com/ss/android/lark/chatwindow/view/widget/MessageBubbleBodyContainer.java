package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J0\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/MessageBubbleBodyContainer;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isRtl", "", "()Z", "setRtl", "(Z)V", "checkLayoutParams", "p", "Landroid/view/ViewGroup$LayoutParams;", "generateDefaultLayoutParams", "generateLayoutParams", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageBubbleBodyContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f417135a;

    public MessageBubbleBodyContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MessageBubbleBodyContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if (r100 != null) goto L6;
        return generateDefaultLayoutParams();
    L6:
        return new ViewGroup.MarginLayoutParams(r100.width, r100.height);
    }

    public final void setRtl(boolean r100) {
        this.f417135a = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getChildCount() != 5) goto L10;
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r111);
        if (r101 != Integer.MIN_VALUE) goto L7;
        setMeasuredDimension(r100, r102);
        return;
    L7:
        View r103 = getChildAt(2);
        measureChildWithMargins(r103, r110, 0, r111, 0);
        View r104 = getChildAt(1);
        measureChildWithMargins(r104, r110, 0, r111, 0);
        int r105 = Math.max(r103.getMeasuredWidth(), r104.getMeasuredWidth());
        View r112 = getChildAt(0);
        measureChildWithMargins(r112, r110, r105, r111, 0);
        int r113 = r105 + r112.getMeasuredWidth();
        int r106 = Math.max(r104.getMeasuredHeight() + r103.getMeasuredHeight(), r112.getMeasuredHeight());
        getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(r112.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r112.getMeasuredHeight(), 1073741824));
        measureChildWithMargins(getChildAt(4), r110, r105, r111, 0);
        setMeasuredDimension(Math.max(r113, r100), r106);
        return;
    L10:
        throw new IllegalStateException("There are must 5 child.");
    }

    public MessageBubbleBodyContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ MessageBubbleBodyContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        if (this.f417135a == false) goto L5;
        r105.layout(getMeasuredWidth() - r105.getMeasuredWidth(), 0, getMeasuredWidth(), r105.getMeasuredHeight());
    L6:
        View r106 = getChildAt(1);
        if (r106.getVisibility() != 8) goto L9;
    L12:
        View r107 = getChildAt(2);
        if (this.f417135a == false) goto L15;
        r107.layout((getMeasuredWidth() - r105.getMeasuredWidth()) - r107.getMeasuredWidth(), 0, getMeasuredWidth() - r105.getMeasuredWidth(), r107.getMeasuredHeight());
    L16:
        View r108 = getChildAt(3);
        if (this.f417135a == false) goto L19;
        r108.layout(getMeasuredWidth() - r108.getMeasuredWidth(), 0, getMeasuredWidth(), r108.getMeasuredHeight());
    L20:
        View r109 = getChildAt(4);
        r109.layout(r105.getLeft(), r105.getTop(), r105.getLeft() + r109.getMeasuredWidth(), r105.getTop() + r109.getMeasuredHeight());
        return;
    L19:
        r108.layout(0, 0, r108.getMeasuredWidth(), r108.getMeasuredHeight());
        goto L20
    L15:
        r107.layout(r105.getMeasuredWidth(), 0, r105.getMeasuredWidth() + r107.getMeasuredWidth(), r107.getMeasuredHeight());
        goto L16
    L9:
        if (this.f417135a == false) goto L11;
        r106.layout((getMeasuredWidth() - r105.getMeasuredWidth()) - r106.getMeasuredWidth(), getMeasuredHeight() - r106.getMeasuredHeight(), getMeasuredWidth() - r105.getMeasuredWidth(), getMeasuredHeight());
        goto L12
    L11:
        r106.layout(r105.getMeasuredWidth(), getMeasuredHeight() - r106.getMeasuredHeight(), r105.getMeasuredWidth() + r106.getMeasuredWidth(), getMeasuredHeight());
        goto L12
    L5:
        r105.layout(0, 0, r105.getMeasuredWidth(), r105.getMeasuredHeight());
        goto L6
    }
}
