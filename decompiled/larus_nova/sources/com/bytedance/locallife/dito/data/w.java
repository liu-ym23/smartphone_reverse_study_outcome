package com.bytedance.locallife.dito.data;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/locallife/dito/data/w;", "", "", "recoveryUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "forceDowngrade", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("forceDowngrade")
    private final Boolean forceDowngrade;

    @SerializedName("recoveryUrl")
    private final String recoveryUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.recoveryUrl, r101.recoveryUrl) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.forceDowngrade, r101.forceDowngrade) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.recoveryUrl;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.forceDowngrade;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PageRecoveryConfig(recoveryUrl=" + this.recoveryUrl + ", forceDowngrade=" + this.forceDowngrade + ')';
    }

    public w() {
        this.recoveryUrl = null;
        this.forceDowngrade = null;
    }

    public final Boolean a() {
        return this.forceDowngrade;
    }

    public final String b() {
        return this.recoveryUrl;
    }
}
