package com.google.common.hash;

import androidx.collection.ScatterMapKt;
import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import javax.annotation.CheckForNull;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_32HashFunction extends b implements Serializable {
    static final e GOOD_FAST_HASH_32 = null;
    static final e MURMUR3_32 = null;
    static final e MURMUR3_32_FIXED = null;
    private static final long serialVersionUID = 0;
    private final int seed;
    private final boolean supplementaryPlaneFix;

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f275579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f275580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f275581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f275582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f275583e;

        @Override // com.google.common.hash.f
        public final HashCode a() {
            m.o(!this.f275583e);
            this.f275583e = true;
            int r100 = this.f275579a ^ Murmur3_32HashFunction.access$000((int) this.f275580b);
            this.f275579a = r100;
            return Murmur3_32HashFunction.access$600(r100, this.f275582d);
        }

        public a(int r100) {
            this.f275579a = r100;
            this.f275582d = 0;
            this.f275583e = false;
        }

        @Override // com.google.common.hash.f
        public final f c(ByteBuffer r100) {
            ByteOrder r101 = r100.order();
            r100.order(ByteOrder.LITTLE_ENDIAN);
        L4:
            if (r100.remaining() < 4) goto L7;
            putInt(r100.getInt());
        L7:
            if (r100.hasRemaining() == false) goto L9;
            update(1, r100.get() & UByte.MAX_VALUE);
            goto L7
        L9:
            r100.order(r101);
            return this;
        }

        @Override // com.google.common.hash.c
        public final f h(char r100) {
            update(2, r100);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
        public final f putInt(int r100) {
            update(4, r100);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
        public final f putLong(long r100) {
            update(4, (int) r100);
            update(4, r100 >>> 32);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
        public final k putInt(int r100) {
            update(4, r100);
            return this;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f, com.google.common.hash.k
        public final /* bridge */ /* synthetic */ k putLong(long r100) {
            putLong(r100);
            return this;
        }

        private void update(int r100, long r101) {
            long r102 = this.f275580b;
            long r103 = r101 & BodyPartID.bodyIdMax;
            int r104 = this.f275581c;
            long r105 = (r103 << r104) | r102;
            this.f275580b = r105;
            int r106 = r104 + (r100 * 8);
            this.f275581c = r106;
            this.f275582d += r100;
            if (r106 < 32) goto L6;
            this.f275579a = Murmur3_32HashFunction.access$100(this.f275579a, Murmur3_32HashFunction.access$000((int) r105));
            this.f275580b >>>= 32;
            this.f275581c -= 32;
            return;
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f
        public final f d(CharSequence r110, Charset r111) {
            if (com.google.common.base.c.f274714a.equals(r111) == false) goto L34;
            int r100 = r110.length();
            int r101 = 0;
        L5:
            int r102 = r101 + 4;
            if (r102 > r100) goto L13;
            char r103 = r110.charAt(r101);
            char r104 = r110.charAt(r101 + 1);
            char r105 = r110.charAt(r101 + 2);
            char r106 = r110.charAt(r101 + 3);
            if (r103 >= 128) goto L13;
            if (r104 >= 128) goto L13;
            if (r105 >= 128) goto L13;
            if (r106 >= 128) goto L13;
            update(4, (((r104 << '\b') | r103) | (r105 << 16)) | (r106 << 24));
            r101 = r102;
        L13:
            if (r101 >= r100) goto L32;
            char r107 = r110.charAt(r101);
            if (r107 >= 128) goto L18;
            update(1, r107);
        L31:
            r101 = r101 + 1;
            goto L13
        L18:
            if (r107 >= 2048) goto L21;
            update(2, Murmur3_32HashFunction.access$300(r107));
            goto L31
        L21:
            if (r107 >= 55296) goto L23;
        L30:
            update(3, Murmur3_32HashFunction.access$400(r107));
            goto L31
        L23:
            if (r107 > 57343) goto L30;
            int r108 = Character.codePointAt(r110, r101);
            if (r108 == r107) goto L27;
            r101 = r101 + 1;
            update(4, Murmur3_32HashFunction.access$500(r108));
            goto L31
        L27:
            g(r110.subSequence(r101, r100).toString().getBytes(r111));
            return this;
        L32:
            return this;
        L34:
            return super.d(r110, r111);
        }

        @Override // com.google.common.hash.c, com.google.common.hash.k
        public final /* bridge */ /* synthetic */ f e(CharSequence r100, Charset r101) {
            return d(r100, r101);
        }

        @Override // com.google.common.hash.c, com.google.common.hash.f
        public final f b(byte[] r100, int r101, int r102) {
            m.n(r101, r101 + r102, r100.length);
            int r103 = 0;
        L3:
            int r104 = r103 + 4;
            if (r104 > r102) goto L6;
            update(4, Murmur3_32HashFunction.access$200(r100, r103 + r101));
            r103 = r104;
        L6:
            if (r103 >= r102) goto L8;
            update(1, r100[r101 + r103] & UByte.MAX_VALUE);
            r103 = r103 + 1;
            goto L6
        L8:
            return this;
        }
    }

    public static long a(int r100) {
        return (((((long) (r100 >>> 18)) | 240) | ((((long) ((r100 >>> 12) & 63)) | 128) << 8)) | ((((long) ((r100 >>> 6) & 63)) | 128) << 16)) | ((((long) (r100 & 63)) | 128) << 24);
    }

    public static long access$300(char r100) {
        return (((long) (r100 >>> 6)) | 192) | ((long) (((r100 & '?') | 128) << 8));
    }

    public static long access$400(char r100) {
        return ((((long) (r100 >>> '\f')) | 224) | ((long) ((((r100 >>> 6) & 63) | 128) << 8))) | ((long) (((r100 & '?') | 128) << 16));
    }

    public int bits() {
        return 32;
    }

    static {
        MURMUR3_32 = new Murmur3_32HashFunction(0, false);
        MURMUR3_32_FIXED = new Murmur3_32HashFunction(0, true);
        GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.f275566a, true);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + ")";
    }

    public static /* synthetic */ int access$000(int r100) {
        return e(r100);
    }

    public static /* synthetic */ long access$500(int r100) {
        return a(r100);
    }

    public static int e(int r100) {
        return Integer.rotateLeft(r100 * ScatterMapKt.MurmurHashC1, 15) * 461845907;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Murmur3_32HashFunction) == false) goto L10;
        Murmur3_32HashFunction r101 = (Murmur3_32HashFunction) r100;
        if (this.seed == r101.seed) goto L7;
        return false;
    L7:
        if (this.supplementaryPlaneFix != r101.supplementaryPlaneFix) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.google.common.hash.b
    public HashCode hashInt(int r100) {
        int r101 = e(r100);
        return b(d(this.seed, r101), 4);
    }

    @Override // com.google.common.hash.b
    public HashCode hashLong(long r100) {
        int r101 = (int) r100;
        int r102 = (int) (r100 >>> 32);
        int r103 = e(r101);
        return b(d(d(this.seed, r103), e(r102)), 8);
    }

    @Override // com.google.common.hash.b
    public HashCode hashUnencodedChars(CharSequence r100) {
        int r101 = this.seed;
        int r102 = 1;
    L4:
        if (r102 >= r100.length()) goto L7;
        r101 = d(r101, e(r100.charAt(r102 - 1) | (r100.charAt(r102) << 16)));
        r102 = r102 + 2;
        goto L4
    L7:
        if ((r100.length() & 1) != 1) goto L10;
        r101 = r101 ^ e(r100.charAt(r100.length() - 1));
    L10:
        return b(r101, r100.length() * 2);
    }

    public Murmur3_32HashFunction(int r100, boolean r101) {
        this.seed = r100;
        this.supplementaryPlaneFix = r101;
    }

    public static /* synthetic */ int access$100(int r100, int r101) {
        return d(r100, r101);
    }

    public static /* synthetic */ int access$200(byte[] r100, int r101) {
        return c(r100, r101);
    }

    public static /* synthetic */ HashCode access$600(int r100, int r101) {
        return b(r100, r101);
    }

    public static HashCode b(int r100, int r101) {
        int r102 = r100 ^ r101;
        int r103 = (r102 ^ (r102 >>> 16)) * (-2048144789);
        int r104 = (r103 ^ (r103 >>> 13)) * (-1028477387);
        return HashCode.fromInt(r104 ^ (r104 >>> 16));
    }

    public static int c(byte[] r100, int r101) {
        byte r102 = r100[r101 + 3];
        byte r103 = r100[r101 + 2];
        byte r104 = r100[r101 + 1];
        byte r105 = r100[r101];
        int r106 = ((r102 << 24) | ((r103 & UByte.MAX_VALUE) << 16)) | ((r104 & UByte.MAX_VALUE) << 8);
        return (r105 & UByte.MAX_VALUE) | r106;
    }

    public static int d(int r100, int r101) {
        return (Integer.rotateLeft(r100 ^ r101, 13) * 5) - 430675100;
    }

    @Override // com.google.common.hash.b
    public HashCode hashString(CharSequence r110, Charset r111) {
        if (com.google.common.base.c.f274714a.equals(r111) == false) goto L42;
        int r100 = r110.length();
        int r101 = this.seed;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L5:
        int r105 = r103 + 4;
        if (r105 > r100) goto L13;
        char r106 = r110.charAt(r103);
        char r107 = r110.charAt(r103 + 1);
        char r108 = r110.charAt(r103 + 2);
        char r112 = r110.charAt(r103 + 3);
        if (r106 >= 128) goto L13;
        if (r107 >= 128) goto L13;
        if (r108 >= 128) goto L13;
        if (r112 >= 128) goto L13;
        r101 = d(r101, e((((r107 << '\b') | r106) | (r108 << 16)) | (r112 << 24)));
        r104 = r104 + 4;
        r103 = r105;
    L13:
        long r109 = 0;
    L14:
        if (r103 >= r100) goto L40;
        char r113 = r110.charAt(r103);
        if (r113 >= 128) goto L19;
        r109 = r109 | (((long) r113) << r102);
        r102 = r102 + 8;
        r104 = r104 + 1;
    L36:
        if (r102 < 32) goto L38;
        r101 = d(r101, e((int) r109));
        r109 = r109 >>> 32;
        r102 = r102 - 32;
    L38:
        r103 = r103 + 1;
        goto L14
    L19:
        if (r113 >= 2048) goto L22;
        r109 = r109 | (((((long) (r113 >>> 6)) | 192) | ((long) (((r113 & '?') | 128) << 8))) << r102);
        r102 = r102 + 16;
        r104 = r104 + 2;
        goto L36
    L22:
        if (r113 >= 55296) goto L24;
    L34:
        r109 = r109 | ((((((long) (r113 >>> '\f')) | 224) | ((long) ((((r113 >>> 6) & 63) | 128) << 8))) | ((long) (((r113 & '?') | 128) << 16))) << r102);
        r102 = r102 + 24;
        r104 = r104 + 3;
        goto L36
    L24:
        if (r113 > 57343) goto L34;
        int r114 = Character.codePointAt(r110, r103);
        if (r114 == r113) goto L29;
        r103 = r103 + 1;
        r109 = r109 | (a(r114) << r102);
        if (this.supplementaryPlaneFix == false) goto L33;
        r102 = r102 + 32;
    L33:
        r104 = r104 + 4;
        goto L36
    L29:
        return hashBytes(r110.toString().getBytes(r111));
    L40:
        return b(e((int) r109) ^ r101, r104);
    L42:
        return hashBytes(r110.toString().getBytes(r111));
    }

    @Override // com.google.common.hash.b
    public HashCode hashBytes(byte[] r100, int r101, int r102) {
        m.n(r101, r101 + r102, r100.length);
        int r103 = this.seed;
        int r104 = 0;
        int r105 = 0;
    L3:
        int r106 = r105 + 4;
        if (r106 > r102) goto L6;
        r103 = d(r103, e(c(r100, r105 + r101)));
        r105 = r106;
        goto L3
    L6:
        int r107 = r105;
        int r108 = 0;
    L7:
        if (r107 >= r102) goto L10;
        r104 = r104 ^ ((r100[r101 + r107] & UByte.MAX_VALUE) << r108);
        r107 = r107 + 1;
        r108 = r108 + 8;
        goto L7
    L10:
        return b(e(r104) ^ r103, r102);
    }
}
