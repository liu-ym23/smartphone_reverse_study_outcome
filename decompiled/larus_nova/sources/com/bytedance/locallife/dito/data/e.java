package com.bytedance.locallife.dito.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/dito/data/e;", "", "", "", "recoveryStatusCodeList", "Ljava/util/List;", "b", "()Ljava/util/List;", "recoveryErrorCodeList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("recovery_error_code_list")
    private final List<Integer> recoveryErrorCodeList;

    @SerializedName("recovery_status_code_list")
    private final List<Integer> recoveryStatusCodeList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.recoveryStatusCodeList, r101.recoveryStatusCodeList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recoveryErrorCodeList, r101.recoveryErrorCodeList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<Integer> r100 = this.recoveryStatusCodeList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Integer> r104 = this.recoveryErrorCodeList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoImmediateRecoveryConfig(recoveryStatusCodeList=" + this.recoveryStatusCodeList + ", recoveryErrorCodeList=" + this.recoveryErrorCodeList + ')';
    }

    public e() {
        this.recoveryStatusCodeList = null;
        this.recoveryErrorCodeList = null;
    }

    public final List<Integer> a() {
        return this.recoveryErrorCodeList;
    }

    public final List<Integer> b() {
        return this.recoveryStatusCodeList;
    }
}
