package com.bytedance.android.shopping.api.image;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/api/image/z;", "", "", "domainUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "", "interval", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("domain_url")
    private final String domainUrl;

    @SerializedName("interval")
    private final Long interval;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof z) == false) goto L10;
        z r4 = (z) r3;
        if (Intrinsics.areEqual(this.domainUrl, r4.domainUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.interval, r4.interval) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r0 = this.domainUrl;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.interval;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageDomainConfig(domainUrl=" + this.domainUrl + ", interval=" + this.interval + ")";
    }

    public z() {
        this.domainUrl = null;
        this.interval = null;
    }

    public final String a() {
        return this.domainUrl;
    }

    public final Long b() {
        return this.interval;
    }
}
