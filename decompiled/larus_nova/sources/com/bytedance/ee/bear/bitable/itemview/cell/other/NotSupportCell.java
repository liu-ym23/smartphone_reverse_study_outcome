package com.bytedance.ee.bear.bitable.itemview.cell.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.databinding.BitableCellUnknownItemBinding;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/other/NotSupportCell;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCellUnknownItemBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableCellUnknownItemBinding;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotSupportCell extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableCellUnknownItemBinding f213949a;

    public final BitableCellUnknownItemBinding getBinding() {
        return this.f213949a;
    }

    public NotSupportCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public NotSupportCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.bitable_cell_unknown_item, this, false);
        addView(r102);
        TextView r103 = (TextView) ViewBindings.findChildViewById(r102, R.id.unknown_content);
        if (r103 == null) goto L7;
        this.f213949a = new BitableCellUnknownItemBinding((LinearLayout) r102, r103);
        r103.setBackground(null);
        r103.setTextSize(14.0f);
        r103.setPadding(0, n.d(2), 0, n.d(2));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(R.id.unknown_content)));
    }
}
