package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.view.View;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.payload.ChatSectionPayload;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpChatSectionCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpChatSectionCellState;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/kmp/KmpSearchListCallbacksAware;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "callbacks", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/kmp/KmpSearchListCallbacks;", "titleView", "Landroid/widget/TextView;", "boundPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/ChatSectionPayload;", "attachCallbacks", "", "onViewCreated", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpChatSectionCell extends BaseSearchListCell<d> implements g99.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g99.a f342613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f342614c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ChatSectionPayload f342615d;

    public KmpChatSectionCell() {
        this.f342612a = R.layout.item_search_chat_section;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342612a;
    }

    @Override // g99.b
    public final void a(g99.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callbacks");
        this.f342613b = r100;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f342614c = (TextView) r100.findViewById(R.id.section_name_text);
        r100.setOnClickListener(new c(this));
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        d r103 = (d) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f342615d = r103.f342688a;
        TextView r104 = this.f342614c;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
        r104 = null;
    L5:
        r104.setText(r103.f342688a.f243340l);
    }
}
