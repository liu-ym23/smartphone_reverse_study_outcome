package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.view.View;
import com.bytedance.flow.search.kmp.api.model.SearchCursor;
import com.bytedance.flow.search.kmp.api.model.payload.AutoLoadMorePayload;
import com.bytedance.flow.search.kmp.api.store.SearchLoadingState;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpAutoLoadMoreCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpAutoLoadMoreCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpAutoLoadMoreCell extends BaseSearchListCell<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342611a;

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public KmpAutoLoadMoreCell() {
        this.f342611a = R.layout.item_search_auto_load_more;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342611a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        a r103 = (a) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        AutoLoadMorePayload r104 = r103.f342673a;
        SearchCursor r105 = r104.f243326k;
        aw5.c r106 = r104.f243289f;
        SearchCursor r107 = null;
        if (r106 == null) goto L5;
        SearchLoadingState r108 = r106.f16541a;
    L7:
        if (r108 != SearchLoadingState.LoadingMore) goto L10;
        return;
    L10:
        if (r104.f243325j == false) goto L20;
        if (r106 == null) goto L15;
        r107 = r106.f16548h;
    L15:
        if (Intrinsics.areEqual(r105, r107) == true) goto L21;
        AutoLoadMorePayload r109 = r103.f342673a;
        r109.a(new aw5.a.g(r109.f243324i, r105, false));
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r108 = null;
        goto L7
    }
}
