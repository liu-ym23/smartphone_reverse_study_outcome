package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ProgressModel;
import com.larksuite.component.universe_design.progress.UDProgress;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/GridProgress;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/ProgressModel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "udProgress", "Lcom/larksuite/component/universe_design/progress/UDProgress;", "textView", "Landroid/widget/TextView;", "getContentView", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridProgress extends LinearLayout implements gv4.b<ProgressModel> {
    public final UDProgress a;
    public final TextView b;

    public GridProgress(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public GridProgress(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final TextView getContentView() {
        return this.b;
    }

    public GridProgress(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        setOrientation(0);
        setGravity(16);
        UDProgress r7 = new UDProgress(r4);
        r7.setIndicatorCornerRadius(com.bytedance.ee.util.ui.n.d(4));
        r7.setThickness(com.bytedance.ee.util.ui.n.d(8));
        r7.setTrackColor(r4.getResources().getColor(2131100549));
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -1);
        r0.weight = 1.0f;
        r7.setLayoutParams(r0);
        this.a = r7;
        addView(r7);
        TextView r8 = new TextView(r4);
        r8.setTextSize(14.0f);
        this.b = r8;
        r8.setGravity(5);
        r8.setTextColor(ContextCompat.getColor(r4, 2131106622));
        r8.setMaxLines(1);
        r8.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r9 = new LinearLayout.LayoutParams(com.bytedance.ee.util.ui.n.d(38), -1);
        r9.leftMargin = com.bytedance.ee.util.ui.n.d(8);
        r8.setLayoutParams(r9);
        addView(r8);
    }

    public /* synthetic */ GridProgress(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
