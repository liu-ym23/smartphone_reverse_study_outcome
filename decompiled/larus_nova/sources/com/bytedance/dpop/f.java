package com.bytedance.dpop;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/dpop/f;", "", "", "expiresIn", "J", "getExpiresIn", "()J", "dpopsdk_release"}, k = 1, mv = {1, 7, 1})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f204785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f204786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f204787c;

    @SerializedName("expires_in")
    private final long expiresIn;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f204785a, r101.f204785a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f204786b, r101.f204786b) == true) goto L15;
        return false;
    L15:
        if (this.expiresIn == r101.expiresIn) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f204787c, r101.f204787c) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f204785a.hashCode() * 31) + this.f204786b.hashCode()) * 31;
        long r101 = this.expiresIn;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f204787c.hashCode();
    }

    public final String toString() {
        return "DPoPTicketData(ticket=" + this.f204785a + ", ticketSign=" + this.f204786b + ", expiresIn=" + this.expiresIn + ", alg=" + this.f204787c + ')';
    }

    public f(String r100, String r101, long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "ticket");
        Intrinsics.checkNotNullParameter(r101, "ticketSign");
        Intrinsics.checkNotNullParameter(r103, "alg");
        this.f204785a = r100;
        this.f204786b = r101;
        this.expiresIn = r102;
        this.f204787c = r103;
    }
}
