package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/SecurityIntercept;", "", "jsbName", "", "limitParamKey", "limitParamValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJsbName", "()Ljava/lang/String;", "getLimitParamKey", "getLimitParamValue", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SecurityIntercept {
    private final String jsbName;
    private final String limitParamKey;
    private final String limitParamValue;

    public static /* synthetic */ SecurityIntercept copy$default(SecurityIntercept r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.jsbName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.limitParamKey;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.limitParamValue;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.jsbName;
    }

    public final String component2() {
        return this.limitParamKey;
    }

    public final String component3() {
        return this.limitParamValue;
    }

    public final SecurityIntercept copy(String r2, String r3, String r4) {
        return new SecurityIntercept(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SecurityIntercept) == false) goto L12;
        SecurityIntercept r4 = (SecurityIntercept) r3;
        if (Intrinsics.areEqual(this.jsbName, r4.jsbName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.limitParamKey, r4.limitParamKey) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.limitParamValue, r4.limitParamValue) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.jsbName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.limitParamKey;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.limitParamValue;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SecurityIntercept(jsbName=" + this.jsbName + ", limitParamKey=" + this.limitParamKey + ", limitParamValue=" + this.limitParamValue + ")";
    }

    public final String getJsbName() {
        return this.jsbName;
    }

    public final String getLimitParamKey() {
        return this.limitParamKey;
    }

    public final String getLimitParamValue() {
        return this.limitParamValue;
    }

    public SecurityIntercept(String r1, String r2, String r3) {
        this.jsbName = r1;
        this.limitParamKey = r2;
        this.limitParamValue = r3;
    }
}
