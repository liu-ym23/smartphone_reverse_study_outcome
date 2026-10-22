package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.payload.LoadFailedPayload;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpRetryCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpRetryCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "textView", "Landroid/widget/TextView;", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/flow/search/kmp/api/model/payload/LoadFailedPayload;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpRetryCell extends BaseSearchListCell<y0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f342662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LoadFailedPayload f342663c;

    public KmpRetryCell() {
        this.f342661a = R.layout.item_search_retry;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342661a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f342662b = (TextView) r100.findViewById(R.id.retry_text);
        r100.setOnClickListener(new x0(this));
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        y0 r103 = (y0) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        LoadFailedPayload r104 = r103.f342734a;
        this.f342663c = r104;
        if (TextUtils.isEmpty(r104.f243404i) == true) goto L9;
        TextView r105 = this.f342662b;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r105 = null;
    L7:
        r105.setText(r103.f342734a.f243404i);
        return;
    }
}
