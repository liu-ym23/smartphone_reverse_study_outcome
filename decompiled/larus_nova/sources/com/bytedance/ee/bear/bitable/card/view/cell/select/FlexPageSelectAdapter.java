package com.bytedance.ee.bear.bitable.card.view.cell.select;

import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010!\u001a\u00020\u0010H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/FlexPageSelectAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "<init>", "()V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "checker", "Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;", "getChecker", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;", "setChecker", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;)V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "applySelectItemLayoutStyle", "", "selectItem", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "textSizeDp", "", "getTextSizeDp", "()I", "itemHeightDp", "getItemHeightDp", "fixWidthDp", "getFixWidthDp", "getItemMargin", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FlexPageSelectAdapter extends BaseFlexSelectAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public hp4.v f208051j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f208052k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int C2() {
        return 14;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final RecyclerView.Adapter<BaseViewHolder> G2() {
        return this;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return com.bytedance.ee.util.ui.n.d(4);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int y2() {
        return 22;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public int z2() {
        return 27;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final void J2() {
        this.f208052k = 7.5f;
    }

    public FlexPageSelectAdapter() {
        super(R.layout.bitable_page_multiselect_cell_item_v2);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter, com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final float A2() {
        return this.f208052k;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final hp4.v H2() {
        return this.f208051j;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final void E2(SelectTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "selectItem");
        r100.setPadding(com.bytedance.ee.util.ui.n.d(9), com.bytedance.ee.util.ui.n.d(2), com.bytedance.ee.util.ui.n.d(9), com.bytedance.ee.util.ui.n.d(2));
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter
    public final void I2(hp4.v r100) {
        this.f208051j = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexSelectAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Object r101) {
        F2(r100, (com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) r101);
    }
}
