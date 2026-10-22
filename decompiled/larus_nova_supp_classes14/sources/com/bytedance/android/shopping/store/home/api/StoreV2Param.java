package com.bytedance.android.shopping.store.home.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/home/api/StoreV2Param;", "Lcom/bytedance/android/shopping/store/home/api/StoreBaseParam;", "authorId", "", "secAuthorId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthorId", "()Ljava/lang/String;", "getSecAuthorId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreV2Param extends StoreBaseParam {
    private final String authorId;
    private final String secAuthorId;

    public static /* synthetic */ StoreV2Param copy$default(StoreV2Param r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.authorId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.secAuthorId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.authorId;
    }

    public final String component2() {
        return this.secAuthorId;
    }

    public final StoreV2Param copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "authorId");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        return new StoreV2Param(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof StoreV2Param) == false) goto L10;
        StoreV2Param r4 = (StoreV2Param) r3;
        if (Intrinsics.areEqual(this.authorId, r4.authorId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secAuthorId, r4.secAuthorId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.authorId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.secAuthorId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "StoreV2Param(authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ")";
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public StoreV2Param(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "authorId");
        Intrinsics.checkNotNullParameter(r3, "secAuthorId");
        this.authorId = r2;
        this.secAuthorId = r3;
    }
}
