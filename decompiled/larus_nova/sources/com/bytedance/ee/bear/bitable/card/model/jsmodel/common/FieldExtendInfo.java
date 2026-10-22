package com.bytedance.ee.bear.bitable.card.model.jsmodel.common;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\nJ\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "extendInfo", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/EExtendInfo;", "originField", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendFieldBaseInfo;", "editable", "", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/EExtendInfo;Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendFieldBaseInfo;Z)V", "getExtendInfo", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/EExtendInfo;", "setExtendInfo", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/EExtendInfo;)V", "getOriginField", "()Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendFieldBaseInfo;", "setOriginField", "(Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendFieldBaseInfo;)V", "getEditable", "()Z", "setEditable", "(Z)V", "equals", "other", "", "hashCode", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FieldExtendInfo implements NonProguard {
    private boolean editable;
    private EExtendInfo extendInfo;
    private FieldExtendFieldBaseInfo originField;

    public FieldExtendInfo() {
    }

    public int hashCode() {
        EExtendInfo r100 = this.extendInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FieldExtendFieldBaseInfo r104 = this.originField;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        if (this.editable == false) goto L12;
        int r106 = 1231;
    L14:
        return r105 + r106;
    L12:
        r106 = 1237;
        goto L14
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final EExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public final FieldExtendFieldBaseInfo getOriginField() {
        return this.originField;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FieldExtendInfo) == true) goto L8;
        return false;
    L8:
        FieldExtendInfo r101 = (FieldExtendInfo) r100;
        if (Intrinsics.areEqual(this.extendInfo, r101.extendInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originField, r101.originField) == true) goto L15;
        return false;
    L15:
        if (this.editable == r101.editable) goto L17;
        return false;
    L17:
        return true;
    }

    public final void setEditable(boolean r100) {
        this.editable = r100;
    }

    public final void setExtendInfo(EExtendInfo r100) {
        this.extendInfo = r100;
    }

    public final void setOriginField(FieldExtendFieldBaseInfo r100) {
        this.originField = r100;
    }

    public FieldExtendInfo(EExtendInfo r100, FieldExtendFieldBaseInfo r101, boolean r102) {
        this.extendInfo = r100;
        this.originField = r101;
        this.editable = r102;
    }
}
