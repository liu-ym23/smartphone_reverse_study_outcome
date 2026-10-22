package com.bytedance.locallife.live.anchor;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/locallife/live/anchor/j;", "", "", "animationKey", "Ljava/lang/String;", "getAnimationKey", "()Ljava/lang/String;", "", "clickExpiredTimeStamp", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "e", "(J)V", "skipExpiredTimeStamp", "b", "f", "", "totalPlayedTimes", "I", "d", "()I", "h", "(I)V", "tempTotalPlayedTimes", "c", ce.f26391f, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("animation_key")
    private final String animationKey;

    @SerializedName("click_expired_time_stamp")
    private long clickExpiredTimeStamp;

    @SerializedName("skip_expired_time_stamp")
    private long skipExpiredTimeStamp;

    @SerializedName("temp_total_played_times")
    private int tempTotalPlayedTimes;

    @SerializedName("total_played_times")
    private int totalPlayedTimes;

    public j() {
        this(null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.animationKey, r101.animationKey) == true) goto L12;
        return false;
    L12:
        if (this.clickExpiredTimeStamp == r101.clickExpiredTimeStamp) goto L15;
        return false;
    L15:
        if (this.skipExpiredTimeStamp == r101.skipExpiredTimeStamp) goto L18;
        return false;
    L18:
        if (this.totalPlayedTimes == r101.totalPlayedTimes) goto L21;
        return false;
    L21:
        if (this.tempTotalPlayedTimes == r101.tempTotalPlayedTimes) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.animationKey;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.clickExpiredTimeStamp;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.skipExpiredTimeStamp;
        return ((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.totalPlayedTimes) * 31) + this.tempTotalPlayedTimes;
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalAtmosphereInfo(animationKey=" + this.animationKey + ", clickExpiredTimeStamp=" + this.clickExpiredTimeStamp + ", skipExpiredTimeStamp=" + this.skipExpiredTimeStamp + ", totalPlayedTimes=" + this.totalPlayedTimes + ", tempTotalPlayedTimes=" + this.tempTotalPlayedTimes + ')';
    }

    public final long a() {
        return this.clickExpiredTimeStamp;
    }

    public final long b() {
        return this.skipExpiredTimeStamp;
    }

    public final int c() {
        return this.tempTotalPlayedTimes;
    }

    public final int d() {
        return this.totalPlayedTimes;
    }

    public final void e(long r100) {
        this.clickExpiredTimeStamp = r100;
    }

    public final void f(long r100) {
        this.skipExpiredTimeStamp = r100;
    }

    public final void g(int r100) {
        this.tempTotalPlayedTimes = r100;
    }

    public final void h(int r100) {
        this.totalPlayedTimes = r100;
    }

    public j(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this.animationKey = r100;
        this.clickExpiredTimeStamp = 0;
        this.skipExpiredTimeStamp = 0;
        this.totalPlayedTimes = 0;
        this.tempTotalPlayedTimes = 0;
    }
}
