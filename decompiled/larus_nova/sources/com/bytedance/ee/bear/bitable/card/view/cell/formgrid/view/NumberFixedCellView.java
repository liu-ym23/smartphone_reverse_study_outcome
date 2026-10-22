package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/NumberFixedCellView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "numberTextView", "Landroid/widget/TextView;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "(Ljava/lang/Integer;Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NumberFixedCellView extends FrameLayout implements b<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f207699a;

    public NumberFixedCellView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public NumberFixedCellView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public NumberFixedCellView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = new TextView(r100);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        r103.setLayoutParams(r104);
        r103.setTextSize(14.0f);
        r103.setTextColor(ContextCompat.getColor(r100, R.color.text_caption));
        this.f207699a = r103;
        addView(r103);
        View r105 = new View(r100);
        int r106 = ht4.a.f487118a;
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(ht4.a.f487129l, -1);
        r107.gravity = 5;
        r105.setLayoutParams(r107);
        r105.setBackgroundResource(R.color.line_divider_default);
        addView(r105);
    }

    public /* synthetic */ NumberFixedCellView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
