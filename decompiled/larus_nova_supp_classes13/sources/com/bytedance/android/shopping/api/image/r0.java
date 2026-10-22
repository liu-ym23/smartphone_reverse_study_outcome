package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/image/r0;", "", "", "enableDowngrade", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "optUrlCache", "e", "", "closeMaxTime", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "downgradeValue", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "checkCount", "a", "", "", "Lcom/bytedance/android/shopping/api/image/s0;", "versions", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("check_count")
    private final Integer checkCount;

    @SerializedName("close_max_time")
    private final Long closeMaxTime;

    @SerializedName("downgrade_value")
    private final Integer downgradeValue;

    @SerializedName("enable_downgrade")
    private final Boolean enableDowngrade;

    @SerializedName("opt_url_cache")
    private final Boolean optUrlCache;

    @SerializedName("versions")
    private final Map<String, s0> versions;

    public r0() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof r0) == false) goto L18;
        r0 r4 = (r0) r3;
        if (Intrinsics.areEqual(this.enableDowngrade, r4.enableDowngrade) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.optUrlCache, r4.optUrlCache) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.closeMaxTime, r4.closeMaxTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.downgradeValue, r4.downgradeValue) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.checkCount, r4.checkCount) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.versions, r4.versions) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Boolean r0 = this.enableDowngrade;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.optUrlCache;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.closeMaxTime;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.downgradeValue;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.checkCount;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Map<String, s0> r16 = this.versions;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "UrlModifyConfDowngradeConf(enableDowngrade=" + this.enableDowngrade + ", optUrlCache=" + this.optUrlCache + ", closeMaxTime=" + this.closeMaxTime + ", downgradeValue=" + this.downgradeValue + ", checkCount=" + this.checkCount + ", versions=" + this.versions + ")";
    }

    public final Integer a() {
        return this.checkCount;
    }

    public final Long b() {
        return this.closeMaxTime;
    }

    public final Integer c() {
        return this.downgradeValue;
    }

    public final Boolean d() {
        return this.enableDowngrade;
    }

    public final Boolean e() {
        return this.optUrlCache;
    }

    public final Map<String, s0> f() {
        return this.versions;
    }

    public r0(Object r1) {
        this.enableDowngrade = null;
        this.optUrlCache = null;
        this.closeMaxTime = null;
        this.downgradeValue = null;
        this.checkCount = null;
        this.versions = null;
    }
}
