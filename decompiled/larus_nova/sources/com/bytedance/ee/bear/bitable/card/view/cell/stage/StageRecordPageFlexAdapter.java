package com.bytedance.ee.bear.bitable.card.view.cell.stage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.d;
import com.bytedance.ee.util.ui.n;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010%\u001a\u00020\u001aH\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/StageRecordPageFlexAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/stage/BaseStageFlexAdapter;", "<init>", "()V", "fullWidth", "", "getFullWidth", "()Z", "setFullWidth", "(Z)V", "useNewLayout", "getUseNewLayout", "setUseNewLayout", "itemViewEventProxy", "Landroid/view/View$OnClickListener;", "getItemViewEventProxy", "()Landroid/view/View$OnClickListener;", "setItemViewEventProxy", "(Landroid/view/View$OnClickListener;)V", "convert", "", "helper", "Lcom/chad/library/adapter/base/BaseViewHolder;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "textSizeDp", "", "getTextSizeDp", "()I", "itemHeightDp", "getItemHeightDp", "fixWidthDp", "getFixWidthDp", "getItemMargin", "isMeasureWidthExactly", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StageRecordPageFlexAdapter extends BaseStageFlexAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f208200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f208201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f208202g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final float A2() {
        return 7.5f;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int C2() {
        return 14;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final float m1() {
        return n.d(4);
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int y2() {
        return 44;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final int z2() {
        if (this.f208200e == false) goto L5;
        int r100 = 6;
    L7:
        return r100 + 32;
    L5:
        r100 = 0;
        goto L7
    }

    public StageRecordPageFlexAdapter() {
        super(R.layout.bitable_cell_stage_multi_item);
        this.f208200e = true;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean M1() {
        return this.f208201f;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean R() {
        return this.f208200e;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.stage.BaseStageFlexAdapter
    public final void F2(BaseViewHolder r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        super.F2(r100, r101);
        View.OnClickListener r102 = this.f208202g;
        if (r102 == null) goto L6;
        r102.onClick(r100.getView(R.id.cell_item));
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.stage.BaseStageFlexAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Object r101) {
        F2(r100, (d) r101);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final BaseViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        BaseViewHolder r102 = super.onCreateViewHolder(r100, r101);
        if (this.f208200e == false) goto L5;
        int r103 = UIHelper.dp2px(3.0f);
        ViewGroup.LayoutParams r104 = r102.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        r105.topMargin = r103;
        r105.bottomMargin = r103;
    L5:
        return r102;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return onCreateViewHolder(r100, r101);
    }
}
