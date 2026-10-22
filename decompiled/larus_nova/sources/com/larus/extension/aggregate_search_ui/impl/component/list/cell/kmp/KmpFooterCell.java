package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.flow.search.kmp.api.model.payload.FooterPayload;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpFooterCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpFooterCellState;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/kmp/KmpSearchListCallbacksAware;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", "textView", "Landroid/widget/TextView;", "iconView", "Landroid/widget/ImageView;", "callbacks", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/kmp/KmpSearchListCallbacks;", "boundPayload", "Lcom/bytedance/flow/search/kmp/api/model/payload/FooterPayload;", "attachCallbacks", "", "onViewCreated", "view", "Landroid/view/View;", "onBindView", "state", "position", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpFooterCell extends BaseSearchListCell<o> implements g99.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f342623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f342624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g99.a f342625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public FooterPayload f342626e;

    public KmpFooterCell() {
        this.f342622a = R.layout.item_search_footer;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342622a;
    }

    @Override // g99.b
    public final void a(g99.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callbacks");
        this.f342625d = r100;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f342623b = (TextView) r100.findViewById(R.id.footer_text);
        this.f342624c = (ImageView) r100.findViewById(R.id.footer_icon);
        r100.setOnClickListener(new n(this));
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r102) {
        o r103 = (o) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r103, "state");
        this.f342626e = r103.f342712a;
        TextView r104 = this.f342623b;
        ImageView r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r104 = null;
    L5:
        r104.setText(r103.f342712a.f243394i);
        if (r103.f342712a.f243395j == 0) goto L13;
        ImageView r106 = this.f342624c;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L11:
        r105.setImageResource(r103.f342712a.f243395j);
        return;
    L10:
        r105 = r106;
        goto L11
    }
}
