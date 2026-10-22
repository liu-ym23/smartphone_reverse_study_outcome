package com.bytedance.ee.bear.bitable.common.model.field;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/AllowedEditModes;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "<init>", "()V", "manual", "", "getManual", "()Ljava/lang/Boolean;", "setManual", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "scan", "getScan", "setScan", "equals", "other", "", "hashCode", "", "clone", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class AllowedEditModes implements NonProguard, Cloneable {
    private Boolean manual;
    private Boolean scan;

    public int hashCode() {
        Boolean r100 = this.manual;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.scan;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public AllowedEditModes() {
        this.manual = Boolean.TRUE;
        this.scan = Boolean.FALSE;
    }

    public AllowedEditModes clone() {
        Object r100 = super.clone();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes");
        return (AllowedEditModes) r100;
    }

    public final Boolean getManual() {
        return this.manual;
    }

    public final Boolean getScan() {
        return this.scan;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8310clone() {
        return clone();
    }

    public boolean equals(Object r100) {
        Class<?> r101 = getClass();
        if (r100 == null) goto L5;
        Class<?> r102 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(r101, r102) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes");
        AllowedEditModes r103 = (AllowedEditModes) r100;
        if (Intrinsics.areEqual(this.manual, r103.manual) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.scan, r103.scan) == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public final void setManual(Boolean r100) {
        this.manual = r100;
    }

    public final void setScan(Boolean r100) {
        this.scan = r100;
    }
}
