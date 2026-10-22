package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.view.View;
import android.widget.TextView;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpTitleCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpTitleCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "titleView", "Landroid/widget/TextView;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTitleCell extends BaseSearchListCell<e1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f342672b;

    public KmpTitleCell() {
        this.f342671a = R.layout.item_search_title;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342671a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f342672b = (TextView) r100.findViewById(R.id.search_title_text);
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        e1 r103 = (e1) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        TextView r104 = this.f342672b;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r104 = null;
    L5:
        r104.setText(r103.f342692a.f243511i);
    }
}
