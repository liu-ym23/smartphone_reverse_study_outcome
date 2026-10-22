package com.bytedance.android.shopping.orderlist.list.cache;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/cache/OrderListCacheKey;", "", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "userId", "bizIdentity", "tabId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "getBizIdentity", "getTabId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListCacheKey implements Serializable {

    @SerializedName("biz_identity")
    private final String bizIdentity;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName("user_id")
    private final String userId;

    public static /* synthetic */ OrderListCacheKey copy$default(OrderListCacheKey r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.userId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.bizIdentity;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.tabId;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.bizIdentity;
    }

    public final String component3() {
        return this.tabId;
    }

    public final OrderListCacheKey copy(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "bizIdentity");
        Intrinsics.checkNotNullParameter(r4, "tabId");
        return new OrderListCacheKey(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof OrderListCacheKey) == false) goto L12;
        OrderListCacheKey r4 = (OrderListCacheKey) r3;
        if (Intrinsics.areEqual(this.userId, r4.userId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizIdentity, r4.bizIdentity) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabId, r4.tabId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.userId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.bizIdentity;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.tabId;
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
        return "OrderListCacheKey(userId=" + this.userId + ", bizIdentity=" + this.bizIdentity + ", tabId=" + this.tabId + ")";
    }

    public final String getBizIdentity() {
        return this.bizIdentity;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public OrderListCacheKey(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "bizIdentity");
        Intrinsics.checkNotNullParameter(r4, "tabId");
        this.userId = r2;
        this.bizIdentity = r3;
        this.tabId = r4;
    }
}
