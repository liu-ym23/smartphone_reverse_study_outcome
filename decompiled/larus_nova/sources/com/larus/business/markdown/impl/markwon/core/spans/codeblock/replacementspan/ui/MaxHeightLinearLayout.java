package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/ui/MaxHeightLinearLayout;", "Landroid/widget/LinearLayout;", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "markdown-impl_release"}, k = 1, mv = {1, 7, 1})
public final class MaxHeightLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f320651a;

    public static final class a {
    }

    static {
    }

    public MaxHeightLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MaxHeightLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getMaxHeight() {
        return this.f320651a;
    }

    public final void setMaxHeight(int r100) {
        if (this.f320651a == r100) goto L6;
        this.f320651a = r100;
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        if (getMaxHeight() != (-1)) goto L5;
    L12:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (r102 == 1073741824) goto L12;
        if (getMaxHeight() != Integer.MAX_VALUE) goto L10;
        int r103 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    L11:
        super.onMeasure(r100, r103);
        return;
    L10:
        r103 = View.MeasureSpec.makeMeasureSpec(getMaxHeight(), Integer.MIN_VALUE);
        goto L11
    }

    public MaxHeightLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f320651a = Integer.MAX_VALUE;
    }

    public /* synthetic */ MaxHeightLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
