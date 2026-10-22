package com.ss.android.lark.audio.recorder;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f409100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f409101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f409102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f409103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f409104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f409105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f409106g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f409100a, r101.f409100a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409101b, r101.f409101b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409102c, r101.f409102c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409103d, r101.f409103d) == true) goto L21;
        return false;
    L21:
        if (this.f409104e == r101.f409104e) goto L24;
        return false;
    L24:
        if (this.f409105f == r101.f409105f) goto L27;
        return false;
    L27:
        if (this.f409106g == r101.f409106g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f409100a.hashCode() * 31) + this.f409101b.hashCode()) * 31) + this.f409102c.hashCode()) * 31;
        b r101 = this.f409103d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f409104e) * 31) + this.f409105f) * 31;
        long r104 = this.f409106g;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioFrameDataContext(buffer=" + this.f409100a + ", recordTask=" + this.f409101b + ", encoder=" + this.f409102c + ", audioRecordCompatStrategy=" + this.f409103d + ", duration=" + this.f409104e + ", readLength=" + this.f409105f + ", encodedLength=" + this.f409106g + ')';
    }

    public a(ByteBuffer r100, p r101, j r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        Intrinsics.checkNotNullParameter(r101, "recordTask");
        Intrinsics.checkNotNullParameter(r102, "encoder");
        this.f409100a = r100;
        this.f409101b = r101;
        this.f409102c = r102;
        this.f409103d = r103;
        this.f409104e = 0;
        this.f409105f = 0;
        this.f409106g = 0;
    }
}
