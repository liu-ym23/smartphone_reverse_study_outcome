package com.bytedance.android.shopping.orderlist.list.cache;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.google.gson.annotations.SerializedName;
import gg3.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R\u001a\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/cache/SingleOrderListCache;", "Ljava/io/Serializable;", "", "isValid", "isExpired", "Lcom/bytedance/android/shopping/orderlist/list/cache/OrderListCacheKey;", "component1", "", "component2", "Lgg3/c;", "component3", "cacheKey", "time", "response", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Lcom/bytedance/android/shopping/orderlist/list/cache/OrderListCacheKey;", "getCacheKey", "()Lcom/bytedance/android/shopping/orderlist/list/cache/OrderListCacheKey;", "J", "getTime", "()J", "Lgg3/c;", "getResponse", "()Lgg3/c;", "<init>", "(Lcom/bytedance/android/shopping/orderlist/list/cache/OrderListCacheKey;JLgg3/c;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleOrderListCache implements Serializable {

    @SerializedName("cache_key")
    private final OrderListCacheKey cacheKey;

    @SerializedName("response")
    private final c response;

    @SerializedName("time")
    private final long time;

    public static /* synthetic */ SingleOrderListCache copy$default(SingleOrderListCache r0, OrderListCacheKey r1, long r2, c r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.cacheKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.time;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.response;
    L12:
        return r0.copy(r1, r2, r4);
    }

    public final OrderListCacheKey component1() {
        return this.cacheKey;
    }

    public final long component2() {
        return this.time;
    }

    public final c component3() {
        return this.response;
    }

    public final SingleOrderListCache copy(OrderListCacheKey r2, long r3, c r5) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        return new SingleOrderListCache(r2, r3, r5);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof SingleOrderListCache) == false) goto L12;
        SingleOrderListCache r7 = (SingleOrderListCache) r6;
        if (Intrinsics.areEqual(this.cacheKey, r7.cacheKey) == true) goto L8;
        return false;
    L8:
        if (this.time == r7.time) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.response, r7.response) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        OrderListCacheKey r0 = this.cacheKey;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.time;
        int r4 = ((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        c r5 = this.response;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SingleOrderListCache(cacheKey=" + this.cacheKey + ", time=" + this.time + ", response=" + this.response + ")";
    }

    public final boolean isValid() {
        c r0 = this.response;
        if (r0 == null) goto L7;
        e r1 = r0.i();
        if (r1 == null) goto L7;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r2 = r1.g();
    L8:
        if (r2 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean isExpired() {
        if ((System.currentTimeMillis() - this.time) < ECSettingKeys.H().getCacheDuration()) goto L5;
        return true;
    L5:
        return false;
    }

    public final OrderListCacheKey getCacheKey() {
        return this.cacheKey;
    }

    public final c getResponse() {
        return this.response;
    }

    public final long getTime() {
        return this.time;
    }

    public SingleOrderListCache(OrderListCacheKey r2, long r3, c r5) {
        Intrinsics.checkNotNullParameter(r2, "cacheKey");
        this.cacheKey = r2;
        this.time = r3;
        this.response = r5;
    }
}
