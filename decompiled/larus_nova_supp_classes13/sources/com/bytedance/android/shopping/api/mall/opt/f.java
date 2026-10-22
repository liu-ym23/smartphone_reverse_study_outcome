package com.bytedance.android.shopping.api.mall.opt;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/opt/f;", "", "", "homepageCount", "Ljava/lang/Integer;", "getHomepageCount", "()Ljava/lang/Integer;", "homepagePreload", "c", "feedCount", "getFeedCount", "feedPreload", "b", "allowAutoLoadCount", "a", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("allow_auto_load_from_new_data")
    private final Integer allowAutoLoadCount;

    @SerializedName("feed_count")
    private final Integer feedCount;

    @SerializedName("feed_preload")
    private final Integer feedPreload;

    @SerializedName("homepage_count")
    private final Integer homepageCount;

    @SerializedName("homepage_preload")
    private final Integer homepagePreload;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L16;
        f r4 = (f) r3;
        if (Intrinsics.areEqual(this.homepageCount, r4.homepageCount) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.homepagePreload, r4.homepagePreload) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.feedCount, r4.feedCount) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedPreload, r4.feedPreload) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.allowAutoLoadCount, r4.allowAutoLoadCount) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.homepageCount;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.homepagePreload;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.feedCount;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.feedPreload;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.allowAutoLoadCount;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
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
        return "RequestCountAndPreloadCount(homepageCount=" + this.homepageCount + ", homepagePreload=" + this.homepagePreload + ", feedCount=" + this.feedCount + ", feedPreload=" + this.feedPreload + ", allowAutoLoadCount=" + this.allowAutoLoadCount + ")";
    }

    public f() {
        this.homepageCount = null;
        this.homepagePreload = null;
        this.feedCount = null;
        this.feedPreload = null;
        this.allowAutoLoadCount = null;
    }

    public final Integer a() {
        return this.allowAutoLoadCount;
    }

    public final Integer b() {
        return this.feedPreload;
    }

    public final Integer c() {
        return this.homepagePreload;
    }
}
