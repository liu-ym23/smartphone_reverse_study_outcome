package com.bytedance.ee.bear.bitable.common.model.field;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.filter.model.EFilterConjunction;
import com.bytedance.ee.bear.bitable.filter.model.SelectFieldCondition;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/OptionsRule;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "targetTable", "", "getTargetTable", "()Ljava/lang/String;", "setTargetTable", "(Ljava/lang/String;)V", "targetField", "getTargetField", "setTargetField", "conditions", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/filter/model/SelectFieldCondition;", "Lkotlin/collections/ArrayList;", "getConditions", "()Ljava/util/ArrayList;", "setConditions", "(Ljava/util/ArrayList;)V", "conjunction", "getConjunction", "setConjunction", "equals", "", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OptionsRule implements NonProguard {
    private ArrayList<SelectFieldCondition> conditions;
    private String conjunction;
    private String targetField;
    private String targetTable;

    public final String getConjunction() {
        String r100 = this.conjunction;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return EFilterConjunction.And.getValue();
    }

    public OptionsRule() {
        this.conditions = new ArrayList();
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final ArrayList<SelectFieldCondition> getConditions() {
        return this.conditions;
    }

    public final String getTargetField() {
        return this.targetField;
    }

    public final String getTargetTable() {
        return this.targetTable;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        OptionsRule r101 = (OptionsRule) r100;
        if (TextUtils.equals(this.targetTable, r101.targetTable) == true) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.targetField, r101.targetField) == true) goto L12;
        return false;
    L12:
        if (TextUtils.equals(getConjunction(), r101.getConjunction()) == true) goto L15;
        return false;
    L15:
        if (this.conditions.equals(r101.conditions) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setConditions(ArrayList<SelectFieldCondition> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.conditions = r100;
    }

    public final void setConjunction(String r100) {
        this.conjunction = r100;
    }

    public final void setTargetField(String r100) {
        this.targetField = r100;
    }

    public final void setTargetTable(String r100) {
        this.targetTable = r100;
    }
}
