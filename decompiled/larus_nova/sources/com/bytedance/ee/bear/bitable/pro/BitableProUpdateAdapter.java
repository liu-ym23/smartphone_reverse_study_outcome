package com.bytedance.ee.bear.bitable.pro;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProUpdateAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "convert", "", "helper", MapController.ITEM_LAYER_TAG, "updateTableItem", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailInfo;", "updateFieldItem", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailFieldInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProUpdateAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public BitableProUpdateAdapter(List<? extends MultiItemEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(r100);
        addItemType(1, R.layout.bitable_update_pro_table_item);
        addItemType(2, R.layout.bitable_update_pro_field_item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Object r101) {
        MultiItemEntity r102 = (MultiItemEntity) r101;
        Intrinsics.checkNotNullParameter(r100, "helper");
        int r103 = r100.getItemViewType();
        if (r103 != 1) goto L5;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.PermEffectFieldData.IEffectFormulaDetailInfo");
        r100.setText(R.id.table_name, ((PermEffectFieldData.IEffectFormulaDetailInfo) r102).getName());
        return;
    L5:
        if (r103 != 2) goto L11;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.PermEffectFieldData.IEffectFormulaDetailFieldInfo");
        PermEffectFieldData.IEffectFormulaDetailFieldInfo r104 = (PermEffectFieldData.IEffectFormulaDetailFieldInfo) r102;
        EFieldUIType.a r105 = EFieldUIType.Companion;
        String r106 = r104.getType();
        r105.getClass();
        r100.setImageResource(R.id.field_icon, EFieldUIType.a.a(r106).getIconRes());
        r100.setText(R.id.field_name, r104.getName());
        return;
    }
}
