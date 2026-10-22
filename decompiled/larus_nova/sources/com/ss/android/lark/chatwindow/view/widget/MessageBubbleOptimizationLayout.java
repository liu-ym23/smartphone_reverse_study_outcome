package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J0\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0014¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chatwindow/view/widget/MessageBubbleOptimizationLayout;", "Lcom/ss/android/lark/chatwindow/view/widget/MeasureDetectLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "left", "top", "right", "bottom", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageBubbleOptimizationLayout extends MeasureDetectLinearLayout {
    public MessageBubbleOptimizationLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // com.ss.android.lark.chatwindow.view.widget.MeasureDetectLinearLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        if (getChildCount() != 4) goto L15;
        int r100 = View.MeasureSpec.getSize(r110);
        int r101 = View.MeasureSpec.getMode(r110);
        int r102 = View.MeasureSpec.getSize(r111);
        View.MeasureSpec.getMode(r111);
        if (r101 != Integer.MIN_VALUE) goto L7;
        setMeasuredDimension(r100, r102);
    L12:
        set_measureTimes(get_measureTimes() + 1);
        return;
    L7:
        measureChildWithMargins(getChildAt(2), r110, 0, r111, 0);
        View r103 = getChildAt(1);
        if (r103.getVisibility() == 8) goto L10;
        measureChildWithMargins(r103, r110, 0, r111, 0);
        int r104 = r103.getMeasuredWidth() + 0;
        int r105 = r103.getMeasuredHeight() + 0;
        int r106 = r104;
        int r112 = r105;
    L11:
        View r107 = getChildAt(0);
        measureChildWithMargins(r107, r110, r106, r111, r112);
        int r108 = r106 + r107.getMeasuredWidth();
        int r109 = Math.max(r112, r107.getMeasuredHeight());
        getChildAt(3).measure(View.MeasureSpec.makeMeasureSpec(r107.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r107.getMeasuredHeight(), 1073741824));
        setMeasuredDimension(Math.max(r108, r100), r109);
        goto L12
    L10:
        r106 = 0;
        r112 = 0;
        goto L11
    L15:
        throw new IllegalStateException("MessageBubbleOptimizationLinearLayout can hold at most 4 children");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        r105.layout(0, 0, r105.getMeasuredWidth(), r105.getMeasuredHeight());
        View r106 = getChildAt(1);
        if (r106.getVisibility() == 8) goto L5;
        r106.layout(r105.getMeasuredWidth(), getMeasuredHeight() - r106.getMeasuredHeight(), r105.getMeasuredWidth() + r106.getMeasuredWidth(), getMeasuredHeight());
    L5:
        View r107 = getChildAt(2);
        r107.layout(r105.getMeasuredWidth(), 0, r105.getMeasuredWidth() + r107.getMeasuredWidth(), r107.getMeasuredHeight());
        View r108 = getChildAt(3);
        r108.layout(0, 0, r108.getMeasuredWidth(), r108.getMeasuredHeight());
    }
}
