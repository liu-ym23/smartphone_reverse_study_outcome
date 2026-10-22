package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpItemDividerCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpItemDividerCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpItemDividerCell extends BaseSearchListCell<e0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342641a;

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public KmpItemDividerCell() {
        this.f342641a = R.layout.item_search_item_divider;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342641a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        e0 r103 = (e0) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        float r104 = r103.f342690a.f243400i;
        Resources r105 = r100.getResources();
        r100.setPadding((int) TypedValue.applyDimension(1, r104, WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics())), r100.getPaddingTop(), r100.getPaddingEnd(), r100.getPaddingBottom());
    }
}
