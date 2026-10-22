package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/o;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "songId", "J", "getSongId", "()J", "hot", "b", "", "hotLevel", "I", "c", "()I", "userId", "getUserId", "getUserId$annotations", "()V", "hotStatus", "d", "level2Threshold", "getLevel2Threshold", "level3Threshold", "getLevel3Threshold", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class o extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    @SerializedName("hot")
    private final long hot;

    @SerializedName("hot_level")
    private final int hotLevel;

    @SerializedName("hot_status")
    private final int hotStatus;

    @SerializedName("level2_threshold")
    private final long level2Threshold;

    @SerializedName("level3_threshold")
    private final long level3Threshold;

    @SerializedName("song_id")
    private final long songId;

    @SerializedName("user_id")
    private final long userId;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof o) == false) goto L20;
        o r7 = (o) r6;
        if (this.songId == r7.songId) goto L8;
        return false;
    L8:
        if (this.hot == r7.hot) goto L10;
        return false;
    L10:
        if (this.hotLevel == r7.hotLevel) goto L12;
        return false;
    L12:
        if (this.userId == r7.userId) goto L14;
        return false;
    L14:
        if (this.hotStatus == r7.hotStatus) goto L16;
        return false;
    L16:
        if (this.level2Threshold == r7.level2Threshold) goto L18;
        return false;
    L18:
        if (this.level3Threshold == r7.level3Threshold) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r0 = this.songId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.hot;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.hotLevel) * 31;
        long r4 = this.userId;
        int r5 = (((r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.hotStatus) * 31;
        long r6 = this.level2Threshold;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.level3Threshold;
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    }

    public final String toString() {
        return "KtvSingHotSeiModel(songId=" + this.songId + ", hot=" + this.hot + ", hotLevel=" + this.hotLevel + ", userId=" + this.userId + ", hotStatus=" + this.hotStatus + ", level2Threshold=" + this.level2Threshold + ", level3Threshold=" + this.level3Threshold + ")";
    }

    public o() {
        this.songId = 0;
        this.hot = -1;
        this.hotLevel = 0;
        this.userId = 0;
        this.hotStatus = 0;
        this.level2Threshold = 0;
        this.level3Threshold = 0;
    }

    public final long b() {
        return this.hot;
    }

    public final int c() {
        return this.hotLevel;
    }

    public final int d() {
        return this.hotStatus;
    }
}
