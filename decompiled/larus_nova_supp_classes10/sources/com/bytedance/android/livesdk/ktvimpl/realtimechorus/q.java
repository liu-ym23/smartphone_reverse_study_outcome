package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/q;", "", "", "ntp", "J", "a", "()J", "setNtp", "(J)V", "pos", "b", "setPos", "isPaused", "c", "setPaused", "index", "getIndex", "setIndex", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class q {

    @SerializedName("index")
    private long index;

    @SerializedName("br_st")
    private long isPaused;

    @SerializedName("ntp")
    private long ntp;

    @SerializedName("pos")
    private long pos;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof q) == false) goto L14;
        q r7 = (q) r6;
        if (this.ntp == r7.ntp) goto L8;
        return false;
    L8:
        if (this.pos == r7.pos) goto L10;
        return false;
    L10:
        if (this.isPaused == r7.isPaused) goto L12;
        return false;
    L12:
        if (this.index == r7.index) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r0 = this.ntp;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.pos;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.isPaused;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.index;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "RealTimeChorusBgmSyncInfo(ntp=" + this.ntp + ", pos=" + this.pos + ", isPaused=" + this.isPaused + ", index=" + this.index + ")";
    }

    public q() {
        this(0, 0, 0, 0);
    }

    public final long a() {
        return this.ntp;
    }

    public final long b() {
        return this.pos;
    }

    public final long c() {
        return this.isPaused;
    }

    public q(long r1, long r3, long r5, long r7) {
        this.ntp = r1;
        this.pos = r3;
        this.isPaused = r5;
        this.index = r7;
    }
}
