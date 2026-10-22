package com.bytedance.ee.bear.bitable.filter.model;

import com.bytedance.ee.bear.bitable.common.f;
import gs4.b;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "Lcom/bytedance/ee/bear/bitable/filter/model/BaseCondition;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "displayValue", "", "", "getDisplayValue", "()[Ljava/lang/String;", "setDisplayValue", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "copy", "equals", "", "other", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterCondition extends BaseCondition {
    private String[] displayValue;
    private Object value;

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition, com.bytedance.ee.bear.bitable.common.f
    public FilterCondition copy() {
        FilterCondition r100 = new FilterCondition();
        r100.setConditionId(getConditionId());
        r100.setFieldId(getFieldId());
        r100.setFieldType(getFieldType());
        r100.setOperator(getOperator());
        Object r101 = this.value;
        String[] r102 = null;
        if ((r101 instanceof f) == false) goto L5;
        f r103 = (f) r101;
    L6:
        if (r103 == null) goto L9;
        Object r104 = r103.copy();
        if (r104 == null) goto L9;
    L10:
        r100.value = r104;
        String[] r105 = this.displayValue;
        if (r105 == null) goto L13;
        r102 = (String[]) Arrays.copyOf(r105, r105.length);
    L13:
        r100.displayValue = r102;
        return r100;
    L9:
        r104 = this.value;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.filter.model.BaseCondition
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        Object r101 = this.value;
        int r102 = 0;
        if ((r101 instanceof Object[]) == false) goto L5;
        int r103 = ArraysKt.contentDeepHashCode((Object[]) r101);
    L8:
        int r104 = (r100 + r103) * 31;
        String[] r105 = this.displayValue;
        if ((r105 instanceof Object[]) == false) goto L11;
        r102 = ArraysKt.contentDeepHashCode(r105);
    L14:
        return r104 + r102;
    L11:
        if (r105 == null) goto L14;
        r102 = r105.hashCode();
        goto L14
    L5:
        if (r101 == null) goto L7;
        r103 = r101.hashCode();
        goto L8
    L7:
        r103 = 0;
        goto L8
    }

    public FilterCondition() {
    }

    public final String[] getDisplayValue() {
        return this.displayValue;
    }

    public final Object getValue() {
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
        if ((r100 instanceof FilterCondition) == false) goto L5;
        FilterCondition r101 = (FilterCondition) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        FilterCondition r102 = (FilterCondition) r100;
        if (b.a(this.value, r102.value) == true) goto L13;
        return false;
    L13:
        if (b.a(this.displayValue, r102.displayValue) == true) goto L16;
        return false;
    L16:
        return super.equals(r100);
    L5:
        r101 = null;
        goto L7
    }

    public final void setDisplayValue(String[] r100) {
        this.displayValue = r100;
    }

    public final void setValue(Object r100) {
        this.value = r100;
    }
}
