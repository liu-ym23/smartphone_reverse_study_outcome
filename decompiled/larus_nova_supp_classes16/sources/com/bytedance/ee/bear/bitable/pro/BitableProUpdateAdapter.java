package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProUpdateAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "convert", "", "helper", "item", "updateTableItem", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailInfo;", "updateFieldItem", "Lcom/bytedance/ee/bear/bitable/pro/PermEffectFieldData$IEffectFormulaDetailFieldInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProUpdateAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public BitableProUpdateAdapter(List<? extends MultiItemEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super(r2);
        addItemType(1, 2131559186);
        addItemType(2, 2131559184);
    }

    public final void convert(BaseViewHolder r3, Object r4) {
        MultiItemEntity r5 = (MultiItemEntity) r4;
        Intrinsics.checkNotNullParameter(r3, "helper");
        int r0 = r3.getItemViewType();
        if (r0 != 1) goto L5;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.PermEffectFieldData.IEffectFormulaDetailInfo");
        r3.setText(2131388080, ((PermEffectFieldData.IEffectFormulaDetailInfo) r5).getName());
        return;
    L5:
        if (r0 != 2) goto L11;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.pro.PermEffectFieldData.IEffectFormulaDetailFieldInfo");
        PermEffectFieldData.IEffectFormulaDetailFieldInfo r6 = (PermEffectFieldData.IEffectFormulaDetailFieldInfo) r5;
        EFieldUIType.a r1 = EFieldUIType.Companion;
        String r2 = r6.getType();
        r1.getClass();
        r3.setImageResource(2131372377, EFieldUIType.a.a(r2).getIconRes());
        r3.setText(2131372379, r6.getName());
        return;
    }
}
