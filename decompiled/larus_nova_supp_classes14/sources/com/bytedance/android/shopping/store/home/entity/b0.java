package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/b0;", "", "", "level", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "joinStatus", "Z", "a", "()Z", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName("join_status")
    private final boolean joinStatus;

    @SerializedName("level")
    private final Integer level;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b0) == false) goto L10;
        b0 r4 = (b0) r3;
        if (Intrinsics.areEqual(this.level, r4.level) == true) goto L8;
        return false;
    L8:
        if (this.joinStatus == r4.joinStatus) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        Integer r0 = this.level;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = r1 * 31;
        boolean r3 = this.joinStatus;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return r2 + r4;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "UserData(level=" + this.level + ", joinStatus=" + this.joinStatus + ")";
    }

    public b0() {
        this.level = null;
        this.joinStatus = false;
    }

    public final boolean a() {
        return this.joinStatus;
    }

    public final Integer b() {
        return this.level;
    }
}
