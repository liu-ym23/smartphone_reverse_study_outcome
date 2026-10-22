package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class Murmur3_128HashFunction extends b implements Serializable {
    static final e GOOD_FAST_HASH_128 = null;
    static final e MURMUR3_128 = null;
    private static final long serialVersionUID = 0;
    private final int seed;

    public static final class a extends d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f275576d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f275577e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f275578f;

        @Override // com.google.common.hash.d
        public final HashCode i() {
            long r100 = this.f275576d;
            long r101 = this.f275578f;
            long r102 = r100 ^ r101;
            long r103 = r101 ^ this.f275577e;
            long r104 = r102 + r103;
            long r105 = r103 + r104;
            long r106 = (r104 ^ (r104 >>> 33)) * (-49064778989728563L);
            long r107 = (r106 ^ (r106 >>> 33)) * (-4265267296055464877L);
            long r108 = (r105 ^ (r105 >>> 33)) * (-49064778989728563L);
            long r109 = (r108 ^ (r108 >>> 33)) * (-4265267296055464877L);
            long r110 = r109 ^ (r109 >>> 33);
            long r111 = (r107 ^ (r107 >>> 33)) + r110;
            this.f275576d = r111;
            this.f275577e = r110 + r111;
            return HashCode.fromBytesNoCopy(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.f275576d).putLong(this.f275577e).array());
        }

        public a(int r100) {
            super(16);
            long r101 = r100;
            this.f275576d = r101;
            this.f275577e = r101;
            this.f275578f = 0;
        }

        @Override // com.google.common.hash.d
        public final void l(ByteBuffer r110) {
            long r100 = r110.getLong();
            long r101 = r110.getLong();
            long r102 = (Long.rotateLeft(r100 * (-8663945395140668459L), 31) * 5545529020109919103L) ^ this.f275576d;
            this.f275576d = r102;
            long r103 = Long.rotateLeft(r102, 27);
            long r104 = this.f275577e;
            this.f275576d = ((r103 + r104) * 5) + 1390208809;
            long r105 = (Long.rotateLeft(r101 * 5545529020109919103L, 33) * (-8663945395140668459L)) ^ r104;
            this.f275577e = r105;
            this.f275577e = ((Long.rotateLeft(r105, 31) + this.f275576d) * 5) + 944331445;
            this.f275578f += 16;
        }

        @Override // com.google.common.hash.d
        public final void m(ByteBuffer r110) {
            this.f275578f += r110.remaining();
            long r100 = 0;
            switch(r110.remaining()) {
                case 1: goto L32;
                case 2: goto L30;
                case 3: goto L28;
                case 4: goto L26;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L19;
                case 9: goto L17;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L11;
                case 13: goto L9;
                case 14: goto L7;
                case 15: goto L6;
                default: goto L5;
            };
        L6:
            long r101 = (((long) (r110.get(14) & UByte.MAX_VALUE)) << 48) ^ 0;
        L8:
            long r102 = r101 ^ (((long) (r110.get(13) & UByte.MAX_VALUE)) << 40);
        L10:
            long r103 = r102 ^ (((long) (r110.get(12) & UByte.MAX_VALUE)) << 32);
        L12:
            long r104 = r103 ^ (((long) (r110.get(11) & UByte.MAX_VALUE)) << 24);
        L14:
            long r105 = r104 ^ (((long) (r110.get(10) & UByte.MAX_VALUE)) << 16);
        L16:
            long r106 = r105 ^ (((long) (r110.get(9) & UByte.MAX_VALUE)) << 8);
        L18:
            long r107 = r106 ^ ((long) (r110.get(8) & UByte.MAX_VALUE));
        L20:
            long r108 = r110.getLong() ^ 0;
            r100 = r107;
        L34:
            this.f275576d ^= Long.rotateLeft(r108 * (-8663945395140668459L), 31) * 5545529020109919103L;
            this.f275577e ^= Long.rotateLeft(r100 * 5545529020109919103L, 33) * (-8663945395140668459L);
            return;
        L7:
            r101 = 0;
            goto L8
        L9:
            r102 = 0;
            goto L10
        L11:
            r103 = 0;
            goto L12
        L13:
            r104 = 0;
            goto L14
        L15:
            r105 = 0;
            goto L16
        L17:
            r106 = 0;
            goto L18
        L19:
            r107 = 0;
            goto L20
        L21:
            long r109 = (((long) (r110.get(6) & UByte.MAX_VALUE)) << 48) ^ 0;
        L23:
            long r111 = r109 ^ (((long) (r110.get(5) & UByte.MAX_VALUE)) << 40);
        L25:
            long r112 = r111 ^ (((long) (r110.get(4) & UByte.MAX_VALUE)) << 32);
        L27:
            long r113 = r112 ^ (((long) (r110.get(3) & UByte.MAX_VALUE)) << 24);
        L29:
            long r114 = r113 ^ (((long) (r110.get(2) & UByte.MAX_VALUE)) << 16);
        L31:
            long r115 = r114 ^ (((long) (r110.get(1) & UByte.MAX_VALUE)) << 8);
        L33:
            r108 = ((long) (r110.get(0) & UByte.MAX_VALUE)) ^ r115;
            goto L34
        L22:
            r109 = 0;
            goto L23
        L24:
            r111 = 0;
            goto L25
        L26:
            r112 = 0;
            goto L27
        L28:
            r113 = 0;
            goto L29
        L30:
            r114 = 0;
            goto L31
        L32:
            r115 = 0;
            goto L33
        L5:
            throw new AssertionError("Should never get here.");
        }
    }

    public int bits() {
        return 128;
    }

    static {
        MURMUR3_128 = new Murmur3_128HashFunction(0);
        GOOD_FAST_HASH_128 = new Murmur3_128HashFunction(Hashing.f275566a);
    }

    public int hashCode() {
        return Murmur3_128HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        return new a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.seed + ")";
    }

    public Murmur3_128HashFunction(int r100) {
        this.seed = r100;
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Murmur3_128HashFunction) == true) goto L5;
        return false;
    L5:
        if (this.seed != ((Murmur3_128HashFunction) r100).seed) goto L9;
        return true;
    L9:
        return false;
    }
}
