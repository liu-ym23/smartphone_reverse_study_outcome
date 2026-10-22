package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/x;", "", "", "wantListenCount", "J", "a", "()J", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class x {

    @SerializedName("want_listen_count")
    private final long wantListenCount;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof x) == true) goto L6;
        return false;
    L6:
        if (this.wantListenCount == ((x) r5).wantListenCount) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r0 = this.wantListenCount;
        return (int) (r0 ^ (r0 >>> 32));
    }

    public final String toString() {
        return "WantListenInfo(wantListenCount=" + this.wantListenCount + ")";
    }

    public x() {
        this.wantListenCount = 0;
    }

    public final long a() {
        return this.wantListenCount;
    }
}
