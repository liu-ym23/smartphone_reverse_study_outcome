package com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.DateModel;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/RecordCreatedTimeRule;", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRule;", "<init>", "()V", "type", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "getType", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/defaultvaluerule/DefaultValueRuleType;", "value", "", "getValue", "()Ljava/lang/Long;", "getValueWhenAddRecord", "", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/DateModel;", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldType;", "isEmptyRule", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordCreatedTimeRule implements DefaultValueRule {
    private final DefaultValueRuleType type;
    private final long value;

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public boolean isEmptyRule() {
        return false;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public Long getValue() {
        return Long.valueOf(this.value);
    }

    public RecordCreatedTimeRule() {
        this.type = DefaultValueRuleType.RECORD_CREATE_TIME;
        this.value = System.currentTimeMillis();
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public DefaultValueRuleType getType() {
        return this.type;
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public /* bridge */ /* synthetic */ Object getValue() {
        return getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public List<DateModel> getValueWhenAddRecord(EFieldType r100) {
        return CollectionsKt.listOf(new DateModel(getValue(), null));
    }

    @Override // com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule
    public /* bridge */ /* synthetic */ Object getValueWhenAddRecord(EFieldType r100) {
        return getValueWhenAddRecord(r100);
    }
}
