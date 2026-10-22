package com.bytedance.ee.bear.bitable.itemview.cell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0014R\u001c\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\n \n*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n \n*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/AdaptiveRowLayout;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "textView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getTextView", "()Landroid/widget/TextView;", "fieldContentContainer", "getFieldContentContainer", "()Landroid/widget/LinearLayout;", "fieldIconContainer", "getFieldIconContainer", "isFlowAligned", "", "setFieldIconFlowAligned", "", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdaptiveRowLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f213770a;

    private final LinearLayout getFieldContentContainer() {
        return (LinearLayout) findViewById(R.id.field_content_container);
    }

    private final LinearLayout getFieldIconContainer() {
        return (LinearLayout) findViewById(R.id.field_icon_container);
    }

    private final TextView getTextView() {
        return (TextView) findViewById(R.id.field_name);
    }

    public AdaptiveRowLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setFieldIconFlowAligned(boolean r100) {
        this.f213770a = r100;
    }

    public AdaptiveRowLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getMode(r100);
        if (r103 != Integer.MIN_VALUE) goto L5;
    L7:
        ViewGroup.LayoutParams r104 = getTextView().getLayoutParams();
        if ((r104 instanceof LinearLayout.LayoutParams) == false) goto L10;
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
    L12:
        if (this.f213770a == false) goto L19;
        if (r105 == null) goto L15;
        r105.weight = 0.0f;
    L15:
        getFieldContentContainer().setOrientation(0);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
        if (getMeasuredWidth() > r102) goto L18;
        return;
    L18:
        getFieldContentContainer().setOrientation(1);
        super.onMeasure(r100, r101);
    L23:
        if (getMeasuredWidth() > r102) goto L25;
        return;
    L25:
        getTextView().setSingleLine(false);
        int r106 = n.d(60);
        int r107 = getFieldIconContainer().getChildCount() - 1;
    L27:
        if ((-1) >= r107) goto L42;
        if (r107 == 0) goto L35;
        if (r107 == 1) goto L35;
        getFieldIconContainer().getChildAt(r107).setVisibility(8);
        super.onMeasure(r100, r101);
        if (getTextView().getMeasuredWidth() >= r106) goto L34;
        getTextView().setMinWidth(r106);
        super.onMeasure(r100, r101);
    L34:
        if (getMeasuredWidth() > r102) goto L35;
        return;
    L35:
        r107 = r107 - 1;
        goto L27
    L42:
        return;
    L19:
        if (r105 == null) goto L21;
        r105.weight = 1.0f;
    L21:
        getFieldContentContainer().setOrientation(0);
        super.onMeasure(r100, r101);
        goto L23
    L10:
        r105 = null;
        goto L12
    L5:
        if (r103 == 1073741824) goto L7;
        r102 = Integer.MAX_VALUE;
        goto L7
    }
}
