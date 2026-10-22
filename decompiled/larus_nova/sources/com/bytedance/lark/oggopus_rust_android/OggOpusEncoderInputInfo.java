package com.bytedance.lark.oggopus_rust_android;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/lark/oggopus_rust_android/OggOpusEncoderInputInfo;", "", "rate", "", "channels", "(JJ)V", "getChannels", "()J", "setChannels", "(J)V", "getRate", "setRate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "into", "Loggopus_rust/proto/OggOpusEncoderInputInfo;", "toString", "", "oggopus_rust_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OggOpusEncoderInputInfo {
    private long channels;
    private long rate;

    public static /* synthetic */ OggOpusEncoderInputInfo copy$default(OggOpusEncoderInputInfo r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.rate;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.channels;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.rate;
    }

    public final long component2() {
        return this.channels;
    }

    public final OggOpusEncoderInputInfo copy(long r100, long r101) {
        return new OggOpusEncoderInputInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OggOpusEncoderInputInfo) == true) goto L8;
        return false;
    L8:
        OggOpusEncoderInputInfo r101 = (OggOpusEncoderInputInfo) r100;
        if (this.rate == r101.rate) goto L12;
        return false;
    L12:
        if (this.channels == r101.channels) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.rate;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.channels;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "OggOpusEncoderInputInfo(rate=" + this.rate + ", channels=" + this.channels + ')';
    }

    public final oggopus_rust.proto.OggOpusEncoderInputInfo into() {
        return new oggopus_rust.proto.OggOpusEncoderInputInfo(Long.valueOf(this.rate), Long.valueOf(this.channels));
    }

    public final long getChannels() {
        return this.channels;
    }

    public final long getRate() {
        return this.rate;
    }

    public final void setChannels(long r100) {
        this.channels = r100;
    }

    public final void setRate(long r100) {
        this.rate = r100;
    }

    public OggOpusEncoderInputInfo(long r100, long r101) {
        this.rate = r100;
        this.channels = r101;
    }
}
