package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/StageFieldDefaultValueRule;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRule;", "<init>", "()V", "type", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "getType", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageFieldDefaultValueRule implements DefaultValueRule {
    private final DefaultValueRuleType type;

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public final /* synthetic */ Object getValue() {
        return DefaultValueRule.CC.$default$getValue(this);
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public final /* synthetic */ Object getValueWhenAddRecord(EFieldType r100) {
        return DefaultValueRule.CC.$default$getValueWhenAddRecord(this, r100);
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public final /* synthetic */ boolean isEmptyRule() {
        return DefaultValueRule.CC.$default$isEmptyRule(this);
    }

    public StageFieldDefaultValueRule() {
        this.type = DefaultValueRuleType.STAGE_FIELD;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public DefaultValueRuleType getType() {
        return this.type;
    }
}
