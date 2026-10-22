package com.bytedance.ee.bear.bitable.filter.model;

import android.text.TextUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0000H\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/SelectFieldCondition;", "Lcom/bytedance/ee/bear/bitable/filter/model/BaseCondition;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "copy", "equals", "", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectFieldCondition extends BaseCondition {
    private String value;

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition, com.bytedance.ee.bear.bitable.common.f
    public SelectFieldCondition copy() {
        SelectFieldCondition r100 = new SelectFieldCondition();
        r100.setConditionId(getConditionId());
        r100.setFieldId(getFieldId());
        r100.setFieldType(getFieldType());
        r100.value = this.value;
        r100.setOperator(getOperator());
        return r100;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition
    public int hashCode() {
        return super.hashCode();
    }

    public SelectFieldCondition() {
    }

    public final String getValue() {
        return this.value;
    }

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition, com.bytedance.ee.bear.bitable.common.f
    public /* bridge */ /* synthetic */ BaseCondition copy() {
        return copy();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition, com.bytedance.ee.bear.bitable.common.f
    public /* bridge */ /* synthetic */ Object copy() {
        return copy();
    }

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition
    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof SelectFieldCondition) == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(this.value, ((SelectFieldCondition) r100).value) == true) goto L11;
        return false;
    L11:
        return super.equals(r100);
    }

    public final void setValue(String r100) {
        this.value = r100;
    }
}
