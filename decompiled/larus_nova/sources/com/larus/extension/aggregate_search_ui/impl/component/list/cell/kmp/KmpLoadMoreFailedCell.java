package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.payload.LoadMoreFailedPayload;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpLoadMoreFailedCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpLoadMoreFailedCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/flow/search/kmp/api/model/payload/LoadMoreFailedPayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpLoadMoreFailedCell extends BaseSearchListCell<h0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoadMoreFailedPayload f342643b;

    public KmpLoadMoreFailedCell() {
        this.f342642a = R.layout.item_search_load_more_failed;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342642a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        r100.setOnClickListener(new g0(this));
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        h0 r103 = (h0) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        LoadMoreFailedPayload r104 = r103.f342699a;
        this.f342643b = r104;
        if (TextUtils.isEmpty(r104.f243410k) == true) goto L8;
        TextView r105 = (TextView) r100.findViewById(R.id.load_more_failed_text);
        if (r105 == null) goto L9;
        r105.setText(r103.f342699a.f243410k);
        return;
    L9:
        return;
    }
}
