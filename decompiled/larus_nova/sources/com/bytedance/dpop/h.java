package com.bytedance.dpop;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/dpop/h;", "", "", "expiresIn", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "dpopsdk_release"}, k = 1, mv = {1, 7, 1})
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f204791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f204792b;

    @SerializedName("expires_in")
    private final Long expiresIn;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f204791a, r101.f204791a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expiresIn, r101.expiresIn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f204792b, r101.f204792b) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f204791a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.expiresIn;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f204792b;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DPoPTicketResponseData(ticket=" + this.f204791a + ", expiresIn=" + this.expiresIn + ", alg=" + this.f204792b + ')';
    }

    public h() {
        this.f204791a = null;
        this.expiresIn = null;
        this.f204792b = null;
    }

    public final Long a() {
        return this.expiresIn;
    }
}
