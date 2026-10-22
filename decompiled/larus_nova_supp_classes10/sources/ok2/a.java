package ok2;

import com.bytedance.android.livesdk.livecommerce.ability.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lok2/a;", "", "", "popcardCacheWaitTime", "J", "b", "()J", "setPopcardCacheWaitTime", "(J)V", "Lcom/bytedance/android/livesdk/livecommerce/ability/g;", "popcardCacheHitAction", "Lcom/bytedance/android/livesdk/livecommerce/ability/g;", "a", "()Lcom/bytedance/android/livesdk/livecommerce/ability/g;", "setPopcardCacheHitAction", "(Lcom/bytedance/android/livesdk/livecommerce/ability/g;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("pop_card_cache_hit_action")
    private g popcardCacheHitAction;

    @SerializedName("pop_card_cache_wait_time")
    private long popcardCacheWaitTime;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L10;
        a r7 = (a) r6;
        if (this.popcardCacheWaitTime == r7.popcardCacheWaitTime) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.popcardCacheHitAction, r7.popcardCacheHitAction) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r0 = this.popcardCacheWaitTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        g r2 = this.popcardCacheHitAction;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r1 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public final String toString() {
        return "PopCardAutoScheduleConfig(popcardCacheWaitTime=" + this.popcardCacheWaitTime + ", popcardCacheHitAction=" + this.popcardCacheHitAction + ")";
    }

    public a() {
        this.popcardCacheWaitTime = 0;
        this.popcardCacheHitAction = null;
    }

    public final g a() {
        return this.popcardCacheHitAction;
    }

    public final long b() {
        return this.popcardCacheWaitTime;
    }
}
