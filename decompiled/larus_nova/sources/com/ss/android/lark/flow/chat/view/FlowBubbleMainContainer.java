package com.ss.android.lark.flow.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014J0\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/flow/chat/view/FlowBubbleMainContainer;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isRtl", "()Z", "setRtl", "(Z)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowBubbleMainContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f423146a;

    public FlowBubbleMainContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowBubbleMainContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setRtl(boolean r100) {
        this.f423146a = r100;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChildCount() == 2) goto L5;
        return;
    L5:
        boolean r102 = false;
        View r103 = getChildAt(0);
        View r104 = getChildAt(1);
        int r105 = View.MeasureSpec.getSize(r100);
        if (r103.getLayoutParams().width == (-1)) goto L9;
        r100 = View.MeasureSpec.makeMeasureSpec(r105, Integer.MIN_VALUE);
    L9:
        measureChild(r103, r100, r101);
        Intrinsics.checkNotNull(r104);
        if (r104.getVisibility() != 0) goto L12;
        r102 = true;
    L12:
        if (r102 == false) goto L14;
        measureChild(r104, View.MeasureSpec.makeMeasureSpec(r103.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r103.getMeasuredHeight(), 1073741824));
    L14:
        setMeasuredDimension(r105, r103.getMeasuredHeight());
    }

    public FlowBubbleMainContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ FlowBubbleMainContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getChildCount() == 2) goto L5;
        return;
    L5:
        View r105 = getChildAt(0);
        boolean r106 = true;
        View r107 = getChildAt(1);
        if (this.f423146a == false) goto L8;
        int r108 = getMeasuredWidth() - r105.getMeasuredWidth();
    L9:
        r105.layout(r108, 0, r105.getMeasuredWidth() + r108, r105.getMeasuredHeight());
        Intrinsics.checkNotNull(r107);
        if (r107.getVisibility() == 0) goto L13;
        r106 = false;
    L13:
        if (r106 == false) goto L16;
        r107.layout(r108, 0, r107.getMeasuredWidth() + r108, r107.getMeasuredHeight());
        return;
    L16:
        return;
    L8:
        r108 = 0;
        goto L9
    }
}
