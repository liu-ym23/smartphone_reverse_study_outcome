package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/a0;", "", "", "serverTime", "J", "getServerTime", "()J", "endTime", "getEndTime", "Lcom/bytedance/android/ec/model/ECUrlModel;", "suffix", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getSuffix", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "track", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "getTrack", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("end_time")
    private final long endTime;

    @SerializedName("server_time")
    private final long serverTime;

    @SerializedName("suffix")
    private final ECUrlModel suffix;

    @SerializedName("track")
    private final b0 track;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a0) == false) goto L14;
        a0 r7 = (a0) r6;
        if (this.serverTime == r7.serverTime) goto L8;
        return false;
    L8:
        if (this.endTime == r7.endTime) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.suffix, r7.suffix) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.track, r7.track) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.serverTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.endTime;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        ECUrlModel r4 = this.suffix;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        b0 r8 = this.track;
        if (r8 == null) goto L10;
        r5 = r8.hashCode();
    L10:
        return r7 + r5;
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroOpenPriceCountDown(serverTime=" + this.serverTime + ", endTime=" + this.endTime + ", suffix=" + this.suffix + ", track=" + this.track + ")";
    }

    public a0() {
        this.serverTime = 0;
        this.endTime = 0;
        this.suffix = null;
        this.track = null;
    }
}
