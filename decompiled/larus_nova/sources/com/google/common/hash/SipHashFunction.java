package com.google.common.hash;

import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class SipHashFunction extends b implements Serializable {
    static final e SIP_HASH_24 = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f275584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f275585d;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final long f275586k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    private final long f275587k1;

    public static final class a extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f275588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f275589e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f275590f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f275591g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f275592h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f275593i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f275594j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f275595k;

        @Override // com.google.common.hash.d
        public final HashCode i() {
            long r100 = this.f275595k ^ (this.f275594j << 56);
            this.f275595k = r100;
            this.f275593i ^= r100;
            o(this.f275588d);
            this.f275590f = r100 ^ this.f275590f;
            this.f275592h ^= 255;
            o(this.f275589e);
            return HashCode.fromLong(((this.f275590f ^ this.f275591g) ^ this.f275592h) ^ this.f275593i);
        }

        @Override // com.google.common.hash.d
        public final void l(ByteBuffer r100) {
            this.f275594j += 8;
            long r101 = r100.getLong();
            this.f275593i ^= r101;
            o(this.f275588d);
            this.f275590f = r101 ^ this.f275590f;
        }

        @Override // com.google.common.hash.d
        public final void m(ByteBuffer r100) {
            this.f275594j += (long) r100.remaining();
            int r101 = 0;
        L4:
            if (r100.hasRemaining() == false) goto L6;
            this.f275595k ^= (((long) r100.get()) & 255) << r101;
            r101 = r101 + 8;
            goto L4
        }

        public final void o(int r100) {
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            long r102 = this.f275590f;
            long r103 = this.f275591g;
            this.f275590f = r102 + r103;
            this.f275592h += this.f275593i;
            this.f275591g = Long.rotateLeft(r103, 13);
            long r104 = Long.rotateLeft(this.f275593i, 16);
            long r105 = this.f275591g;
            long r106 = this.f275590f;
            this.f275591g = r105 ^ r106;
            this.f275593i = r104 ^ this.f275592h;
            long r107 = Long.rotateLeft(r106, 32);
            long r108 = this.f275592h;
            long r109 = this.f275591g;
            this.f275592h = r108 + r109;
            this.f275590f = r107 + this.f275593i;
            this.f275591g = Long.rotateLeft(r109, 17);
            long r110 = Long.rotateLeft(this.f275593i, 21);
            long r111 = this.f275591g;
            long r112 = this.f275592h;
            this.f275591g = r111 ^ r112;
            this.f275593i = r110 ^ this.f275590f;
            this.f275592h = Long.rotateLeft(r112, 32);
            r101 = r101 + 1;
            goto L3
        }

        public a(int r100, int r101, long r102, long r103) {
            super(8);
            this.f275594j = 0;
            this.f275595k = 0;
            this.f275588d = r100;
            this.f275589e = r101;
            this.f275590f = 8317987319222330741L ^ r102;
            this.f275591g = 7237128888997146477L ^ r103;
            this.f275592h = 7816392313619706465L ^ r102;
            this.f275593i = 8387220255154660723L ^ r103;
        }
    }

    public int bits() {
        return 64;
    }

    static {
        SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    }

    public int hashCode() {
        return (int) ((((long) ((SipHashFunction.class.hashCode() ^ this.f275584c) ^ this.f275585d)) ^ this.f275586k0) ^ this.f275587k1);
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this.f275584c, this.f275585d, this.f275586k0, this.f275587k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.f275584c + "" + this.f275585d + "(" + this.f275586k0 + ", " + this.f275587k1 + ")";
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof SipHashFunction) == false) goto L14;
        SipHashFunction r101 = (SipHashFunction) r100;
        if (this.f275584c == r101.f275584c) goto L7;
        return false;
    L7:
        if (this.f275585d == r101.f275585d) goto L9;
        return false;
    L9:
        if (this.f275586k0 == r101.f275586k0) goto L11;
        return false;
    L11:
        if (this.f275587k1 != r101.f275587k1) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public SipHashFunction(int r100, int r101, long r102, long r103) {
        boolean r104 = true;
        if (r100 <= 0) goto L5;
        boolean r105 = true;
    L6:
        m.d(r105, "The number of SipRound iterations (c=%s) during Compression must be positive.", r100);
        if (r101 > 0) goto L10;
        r104 = false;
    L10:
        m.d(r104, "The number of SipRound iterations (d=%s) during Finalization must be positive.", r101);
        this.f275584c = r100;
        this.f275585d = r101;
        this.f275586k0 = r102;
        this.f275587k1 = r103;
        return;
    L5:
        r105 = false;
        goto L6
    }
}
