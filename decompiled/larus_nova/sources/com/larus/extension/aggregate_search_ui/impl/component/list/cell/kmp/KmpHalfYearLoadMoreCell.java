package com.larus.extension.aggregate_search_ui.impl.component.list.cell.kmp;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.flow.search.kmp.api.model.payload.LoadMoreHalfYearPayload;
import com.larus.extension.aggregate_search_ui.api.BaseSearchListCell;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpHalfYearLoadMoreCell;", "Lcom/larus/extension/aggregate_search_ui/api/BaseSearchListCell;", "Lcom/larus/extension/aggregate_search_ui/impl/component/list/cell/kmp/KmpHalfYearLoadMoreCellState;", "<init>", "()V", "layoutId", "", "getLayoutId", "()I", WsConstants.KEY_PAYLOAD, "Lcom/bytedance/flow/search/kmp/api/model/payload/LoadMoreHalfYearPayload;", "loadMoreText", "Landroid/widget/TextView;", "onViewCreated", "", "view", "Landroid/view/View;", "onBindView", "state", "position", "bindLoadMoreText", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpHalfYearLoadMoreCell extends BaseSearchListCell<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f342627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoadMoreHalfYearPayload f342628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f342629c;

    public KmpHalfYearLoadMoreCell() {
        this.f342627a = R.layout.item_search_half_year_load_more;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell
    public final int getLayoutId() {
        return this.f342627a;
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f342629c = (TextView) r100.findViewById(R.id.half_year_load_more_text);
        r100.setOnClickListener(new q(this));
    }

    @Override // com.larus.extension.aggregate_search_ui.api.BaseSearchListCell, com.larus.list.arch.IFlowListCell
    public final void onBindView(View r100, ei9.f r101, int r110) {
        r r102 = (r) r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r102, "state");
        this.f342628b = r102.f342717a;
        Context r103 = r100.getContext();
        String r104 = r103.getString(R.string.larus_globalSearch_searchPage_desc_retryEarlierMessages_placeholder);
        String r105 = StringsKt.replace$default(r103.getString(R.string.larus_globalSearch_searchPage_messageTab_desc_viewEarlierMessages), "%s", r104, false, 4, null);
        TypedArray r106 = r103.obtainStyledAttributes(new int[]{R.attr.larus_primary_50});
        int r107 = r106.getColor(0, 0);
        r106.recycle();
        SpannableString r108 = new SpannableString(r105);
        int r111 = StringsKt.indexOf$default(r105, r104, 0, false, 6, null);
        if (r111 < 0) goto L5;
        r108.setSpan(new ForegroundColorSpan(r107), r111, r104.length() + r111, 33);
    L5:
        TextView r109 = this.f342629c;
        if (r109 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadMoreText");
        r109 = null;
    L8:
        r109.setText(r108);
    }
}
