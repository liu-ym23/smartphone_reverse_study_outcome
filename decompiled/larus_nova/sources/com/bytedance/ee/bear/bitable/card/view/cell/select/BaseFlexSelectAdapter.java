package com.bytedance.ee.bear.bitable.card.view.cell.select;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u001c2\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u000202H\u0014J\u001a\u00103\u001a\u00020\u00182\u0006\u00101\u001a\u0002022\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u00104\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00065"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexLimitLineAdapter;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/IFlexSelectAdapter;", "layoutResId", "", "<init>", "(I)V", "fullWidth", "", "getFullWidth", "()Z", "setFullWidth", "(Z)V", "useNewLayout", "getUseNewLayout", "setUseNewLayout", "mOptionOnClickListener", "Lcom/bytedance/ee/bear/widgets/SafeClickListener;", "getMOptionOnClickListener", "()Lcom/bytedance/ee/bear/widgets/SafeClickListener;", "setMOptionOnClickListener", "(Lcom/bytedance/ee/bear/widgets/SafeClickListener;)V", "setOptionOnClickListener", "", "listener", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "checker", "Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;", "getChecker", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;", "setChecker", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;)V", "maxVisibleLine", "", "getMaxVisibleLine", "()F", "setMaxVisibleLine", "(F)V", "getMeasureText", "", MapController.ITEM_LAYER_TAG, "convert", "helper", "applySelectItemLayoutStyle", "selectItem", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/SelectTextView;", "applySelectItemBorderColor", "isMeasureWidthExactly", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseFlexSelectAdapter extends BaseFlexLimitLineAdapter<com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f208035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f208036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.widgets.t f208037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public hp4.v f208038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f208039i;

    public void D2(SelectTextView r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r101) {
        Intrinsics.checkNotNullParameter(r100, "selectItem");
    }

    public void E2(SelectTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "selectItem");
    }

    public RecyclerView.Adapter<BaseViewHolder> G2() {
        return this;
    }

    public void J2() {
        this.f208039i = 7.5f;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public float A2() {
        return this.f208039i;
    }

    public hp4.v H2() {
        return this.f208038h;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean M1() {
        return this.f208036f;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter, com.bytedance.ee.bear.bitable.common.widgets.flex.b
    public final boolean R() {
        return this.f208035e;
    }

    public BaseFlexSelectAdapter(int r100) {
        super(r100);
        this.f208035e = true;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.select.BaseFlexLimitLineAdapter
    public final String B2(com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r100) {
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r101 = r100;
        if (r101 == null) goto L6;
        String r102 = r101.f207142b;
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public void I2(hp4.v r100) {
        this.f208038h = r100;
    }

    public void F2(BaseViewHolder r100, com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a r101) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        SelectTextView r102 = (SelectTextView) r100.getView(R.id.selected_item);
        Intrinsics.checkNotNull(r102);
        E2(r102);
        r102.setIPermissionCopyChecker(H2());
        r102.setData(r101);
        D2(r102, r101);
        com.bytedance.ee.bear.widgets.t r103 = this.f208037g;
        if (r103 == null) goto L6;
        r102.setOnClickListener(r103);
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, Object r101) {
        F2(r100, (com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a) r101);
    }
}
