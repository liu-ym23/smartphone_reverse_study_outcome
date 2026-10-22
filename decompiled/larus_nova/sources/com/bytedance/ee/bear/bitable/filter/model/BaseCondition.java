package com.bytedance.ee.bear.bitable.filter.model;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.f;
import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/BaseCondition;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "Lcom/bytedance/ee/bear/bitable/common/CopyAble;", "<init>", "()V", "fieldId", "", "getFieldId", "()Ljava/lang/String;", "setFieldId", "(Ljava/lang/String;)V", "fieldType", "", "getFieldType", "()I", "setFieldType", "(I)V", OnekeyLoginConstants.CU_KEY_OPERATOR, "getOperator", "setOperator", "conditionId", "getConditionId", "setConditionId", "copy", "equals", "", "other", "", "hashCode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseCondition implements NonProguardWithoutSerializable, f {
    private String conditionId;
    private String fieldId;
    private int fieldType;
    private String operator;

    public BaseCondition() {
    }

    @Override // com.bytedance.ee.bear.bitable.common.f
    public BaseCondition copy() {
        BaseCondition r100 = new BaseCondition();
        r100.conditionId = this.conditionId;
        r100.fieldId = this.fieldId;
        r100.fieldType = this.fieldType;
        r100.operator = this.operator;
        return r100;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final String getConditionId() {
        return this.conditionId;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final int getFieldType() {
        return this.fieldType;
    }

    public final String getOperator() {
        return this.operator;
    }

    @Override // com.bytedance.ee.bear.bitable.common.f
    public /* bridge */ /* synthetic */ Object copy() {
        return copy();
    }

    public boolean equals(Object r100) {
        Class<?> r101 = getClass();
        if (r100 == null) goto L5;
        Class<?> r102 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(r101, r102) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.filter.model.BaseCondition");
        BaseCondition r103 = (BaseCondition) r100;
        if (TextUtils.equals(this.conditionId, r103.conditionId) == true) goto L13;
        return false;
    L13:
        if (TextUtils.equals(this.fieldId, r103.fieldId) == true) goto L16;
        return false;
    L16:
        if (this.fieldType == r103.fieldType) goto L19;
        return false;
    L19:
        if (TextUtils.equals(this.operator, r103.operator) == true) goto L21;
        return false;
    L21:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public final void setConditionId(String r100) {
        this.conditionId = r100;
    }

    public final void setFieldId(String r100) {
        this.fieldId = r100;
    }

    public final void setFieldType(int r100) {
        this.fieldType = r100;
    }

    public final void setOperator(String r100) {
        this.operator = r100;
    }
}
