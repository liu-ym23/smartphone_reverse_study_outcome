package com.bytedance.lark.oggopus_rust_android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/lark/oggopus_rust_android/OggOpusCodecError;", "Lcom/bytedance/lark/oggopus_rust_android/UnhandledException;", "code", "", "message", "", "(JLjava/lang/String;)V", "getCode", "()J", "setCode", "(J)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "into", "Loggopus_rust/proto/OggOpusCodecError;", "toString", "oggopus_rust_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OggOpusCodecError extends UnhandledException {
    private long code;
    private String message;

    public static /* synthetic */ OggOpusCodecError copy$default(OggOpusCodecError r100, long r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final OggOpusCodecError copy(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        return new OggOpusCodecError(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OggOpusCodecError) == true) goto L8;
        return false;
    L8:
        OggOpusCodecError r101 = (OggOpusCodecError) r100;
        if (this.code == r101.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.code;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.message.hashCode();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "OggOpusCodecError(code=" + this.code + ", message=" + this.message + ')';
    }

    public final oggopus_rust.proto.OggOpusCodecError into() {
        return new oggopus_rust.proto.OggOpusCodecError(Long.valueOf(this.code), getMessage());
    }

    public final long getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final void setCode(long r100) {
        this.code = r100;
    }

    public void setMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }

    public OggOpusCodecError(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r101);
        this.code = r100;
        this.message = r101;
    }
}
