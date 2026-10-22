package com.bytedance.ee.bear.bitable.card.model.stmodel.field;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/AutoNumberRuleField;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "value", "", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "equals", "", "other", "", "hashCode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AutoNumberRuleField implements NonProguard {
    private Integer type;
    private String value;

    public AutoNumberRuleField() {
    }

    public int hashCode() {
        return super.hashCode();
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AutoNumberRuleField) == true) goto L5;
        return false;
    L5:
        AutoNumberRuleField r101 = (AutoNumberRuleField) r100;
        if (this.type == r101.type) goto L9;
        return false;
    L9:
        if (TextUtils.equals(this.value, r101.value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final void setType(Integer r100) {
        this.type = r100;
    }

    public final void setValue(String r100) {
        this.value = r100;
    }
}
