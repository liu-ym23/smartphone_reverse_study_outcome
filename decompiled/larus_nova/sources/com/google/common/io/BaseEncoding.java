package com.google.common.io;

import com.google.common.base.m;
import com.google.common.base.s;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class BaseEncoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f275606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f275607b = null;

    public static final class DecodingException extends IOException {
        public DecodingException(String r100) {
            super(r100);
        }

        public DecodingException(Throwable r100) {
            super(r100);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f275608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final char[] f275609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f275610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f275611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f275612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f275613f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final byte[] f275614g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean[] f275615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f275616i;

        public final int hashCode() {
            int r100 = Arrays.hashCode(this.f275609b);
            if (this.f275616i == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return this.f275608a;
        }

        public final int a(char r100) throws DecodingException {
            if (r100 > 127) goto L16;
            byte r101 = this.f275614g[r100];
            if (r101 == (-1)) goto L7;
            return r101;
        L7:
            if (r100 <= ' ') goto L13;
            if (r100 == 127) goto L13;
            throw new DecodingException("Unrecognized character: " + r100);
        L13:
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(r100));
        L16:
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(r100));
        }

        public final boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f275616i == r101.f275616i) goto L7;
            return false;
        L7:
            if (Arrays.equals(this.f275609b, r101.f275609b) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public a(String r100, char[] r110) {
            byte[] r101 = new byte[128];
            Arrays.fill(r101, (byte) -1);
            int r102 = 0;
        L4:
            if (r102 >= r110.length) goto L20;
            char r103 = r110[r102];
            if (r103 >= 128) goto L8;
            boolean r104 = true;
        L9:
            if (r104 == false) goto L19;
            if (r101[r103] != (-1)) goto L13;
            boolean r105 = true;
        L14:
            if (r105 == false) goto L17;
            r101[r103] = (byte) r102;
            r102 = r102 + 1;
            goto L4
        L17:
            throw new IllegalArgumentException(s.a("Duplicate character: %s", new Object[]{Character.valueOf(r103)}));
        L13:
            r105 = false;
            goto L14
        L19:
            throw new IllegalArgumentException(s.a("Non-ASCII character: %s", new Object[]{Character.valueOf(r103)}));
        L8:
            r104 = false;
            goto L9
        L20:
            this.f275608a = r100;
            this.f275609b = r110;
            int r106 = com.google.common.math.c.d(r110.length, RoundingMode.UNNECESSARY);     // Catch: ArithmeticException -> L28
            this.f275611d = r106;     // Catch: ArithmeticException -> L28
            int r107 = Integer.numberOfTrailingZeros(r106);
            int r108 = 1 << (3 - r107);
            this.f275612e = r108;
            this.f275613f = r106 >> r107;
            this.f275610c = r110.length - 1;
            this.f275614g = r101;
            boolean[] r109 = new boolean[r108];
            int r111 = 0;
        L24:
            if (r111 >= this.f275613f) goto L26;
            r109[com.google.common.math.c.c(r111 * 8, this.f275611d, RoundingMode.CEILING)] = true;
            r111 = r111 + 1;
            goto L24
        L26:
            this.f275615h = r109;
            this.f275616i = false;
            return;
        L28:
            e = move-exception;
            throw new IllegalArgumentException("Illegal alphabet length " + r110.length, e);
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final char[] f275617e;

        public b() {
            a r100 = new a("base16()", "0123456789ABCDEF".toCharArray());
            super(r100, null);
            this.f275617e = new char[512];
            int r101 = 0;
            if (r100.f275609b.length != 16) goto L5;
            boolean r102 = true;
        L6:
            m.b(r102);
        L8:
            if (r101 >= 256) goto L10;
            char[] r103 = this.f275617e;
            char[] r104 = r100.f275609b;
            r103[r101] = r104[r101 >>> 4];
            r103[r101 | 256] = r104[r101 & 15];
            r101 = r101 + 1;
            goto L8
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public final int b(byte[] r100, CharSequence r101) throws DecodingException {
            if ((r101.length() % 2) == 1) goto L10;
            int r102 = 0;
            int r103 = 0;
        L6:
            if (r102 >= r101.length()) goto L8;
            r100[r103] = (byte) ((this.f275618c.a(r101.charAt(r102)) << 4) | this.f275618c.a(r101.charAt(r102 + 1)));
            r102 = r102 + 2;
            r103 = r103 + 1;
            goto L6
        L8:
            return r103;
        L10:
            throw new DecodingException("Invalid input length " + r101.length());
        }
    }

    public static final class c extends d {
        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        public final int b(byte[] r100, CharSequence r101) throws DecodingException {
            CharSequence r102 = c(r101);
            a r103 = this.f275618c;
            if (r103.f275615h[r102.length() % r103.f275612e] == false) goto L16;
            int r104 = 0;
            int r105 = 0;
        L6:
            if (r104 >= r102.length()) goto L14;
            int r106 = r104 + 1;
            int r107 = r106 + 1;
            int r108 = (this.f275618c.a(r102.charAt(r104)) << 18) | (this.f275618c.a(r102.charAt(r106)) << 12);
            int r109 = r105 + 1;
            r100[r105] = (byte) (r108 >>> 16);
            if (r107 >= r102.length()) goto L13;
            int r110 = r107 + 1;
            int r111 = r108 | (this.f275618c.a(r102.charAt(r107)) << 6);
            r105 = r109 + 1;
            r100[r109] = (byte) ((r111 >>> 8) & 255);
            if (r110 >= r102.length()) goto L12;
            r107 = r110 + 1;
            r109 = r105 + 1;
            r100[r105] = (byte) ((r111 | this.f275618c.a(r102.charAt(r110))) & 255);
            goto L13
        L12:
            r104 = r110;
        L13:
            r105 = r109;
            r104 = r107;
            goto L6
        L14:
            return r105;
        L16:
            throw new DecodingException("Invalid input length " + r102.length());
        }

        public c(String r100, String r101, @CheckForNull Character r102) {
            a r103 = new a(r100, r101.toCharArray());
            super(r103, r102);
            if (r103.f275609b.length != 64) goto L5;
            boolean r104 = true;
        L6:
            m.b(r104);
            return;
        L5:
            r104 = false;
            goto L6
        }

        public final void e(Appendable r100, byte[] r101, int r102) throws IOException {
            int r103 = 0;
            int r104 = 0 + r102;
            m.n(0, r104, r101.length);
        L4:
            if (r102 < 3) goto L6;
            int r105 = r103 + 1;
            int r106 = r105 + 1;
            int r107 = ((r101[r103] & UByte.MAX_VALUE) << 16) | ((r101[r105] & UByte.MAX_VALUE) << 8);
            int r108 = r106 + 1;
            int r109 = r107 | (r101[r106] & UByte.MAX_VALUE);
            StringBuilder r110 = (StringBuilder) r100;
            r110.append(this.f275618c.f275609b[r109 >>> 18]);
            r110.append(this.f275618c.f275609b[(r109 >>> 12) & 63]);
            r110.append(this.f275618c.f275609b[(r109 >>> 6) & 63]);
            r110.append(this.f275618c.f275609b[r109 & 63]);
            r102 = r102 - 3;
            r103 = r108;
            goto L4
        L6:
            if (r103 >= r104) goto L10;
            d(r100, r101, r103, r104 - r103);
            return;
        }
    }

    public static class d extends BaseEncoding {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f275618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @CheckForNull
        public final Character f275619d;

        public final int hashCode() {
            return this.f275618c.hashCode() ^ Objects.hashCode(this.f275619d);
        }

        public final String toString() {
            StringBuilder r100 = new StringBuilder("BaseEncoding.");
            r100.append(this.f275618c);
            if ((8 % this.f275618c.f275611d) == 0) goto L9;
            if (this.f275619d != null) goto L7;
            r100.append(".omitPadding()");
            goto L9
        L7:
            r100.append(".withPadChar('");
            r100.append(this.f275619d);
            r100.append("')");
        L9:
            return r100.toString();
        }

        @Override // com.google.common.io.BaseEncoding
        public final CharSequence c(CharSequence r100) {
            r100.getClass();
            Character r101 = this.f275619d;
            if (r101 != null) goto L5;
            return r100;
        L5:
            char r102 = r101.charValue();
            int r103 = r100.length() - 1;
        L6:
            if (r103 < 0) goto L12;
            if (r100.charAt(r103) != r102) goto L12;
            r103 = r103 - 1;
        L12:
            return r100.subSequence(0, r103 + 1);
        }

        public final boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (this.f275618c.equals(r101.f275618c) == true) goto L7;
            return false;
        L7:
            if (Objects.equals(this.f275619d, r101.f275619d) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public d(a r100, @CheckForNull Character r101) {
            this.f275618c = r100;
            boolean r102 = true;
            if (r101 == null) goto L13;
            char r103 = r101.charValue();
            byte[] r104 = r100.f275614g;
            if (r103 < r104.length) goto L7;
        L9:
            boolean r105 = false;
        L10:
            if (r105 == false) goto L13;
            r102 = false;
            goto L13
        L7:
            if (r104[r103] == (-1)) goto L9;
            r105 = true;
        L13:
            m.h(r102, "Padding character %s was already in alphabet", r101);
            this.f275619d = r101;
        }

        @Override // com.google.common.io.BaseEncoding
        public int b(byte[] r110, CharSequence r111) throws DecodingException {
            CharSequence r112 = c(r111);
            a r100 = this.f275618c;
            if (r100.f275615h[r112.length() % r100.f275612e] == false) goto L20;
            int r101 = 0;
            int r102 = 0;
        L6:
            if (r101 >= r112.length()) goto L18;
            long r103 = 0;
            int r104 = 0;
            int r105 = 0;
        L8:
            a r106 = this.f275618c;
            if (r104 >= r106.f275612e) goto L14;
            r103 = r103 << r106.f275611d;
            if ((r101 + r104) >= r112.length()) goto L13;
            r103 = r103 | ((long) this.f275618c.a(r112.charAt(r105 + r101)));
            r105 = r105 + 1;
        L13:
            r104 = r104 + 1;
            goto L8
        L14:
            int r107 = r106.f275613f;
            int r108 = (r107 * 8) - (r105 * r106.f275611d);
            int r109 = (r107 - 1) * 8;
        L15:
            if (r109 < r108) goto L17;
            r110[r102] = (byte) ((r103 >>> r109) & 255);
            r109 = r109 - 8;
            r102 = r102 + 1;
            goto L15
        L17:
            r101 = r101 + this.f275618c.f275612e;
            goto L6
        L18:
            return r102;
        L20:
            throw new DecodingException("Invalid input length " + r112.length());
        }

        public d(String r100, String r101, @CheckForNull Character r102) {
            this(new a(r100, r101.toCharArray()), r102);
        }

        public final void d(Appendable r100, byte[] r101, int r110, int r111) throws IOException {
            m.n(r110, r110 + r111, r101.length);
            int r102 = 0;
            if (r111 > this.f275618c.f275613f) goto L5;
            boolean r103 = true;
        L6:
            m.b(r103);
            long r104 = 0;
            int r105 = 0;
        L8:
            if (r105 >= r111) goto L10;
            r104 = (r104 | ((long) (r101[r110 + r105] & UByte.MAX_VALUE))) << 8;
            r105 = r105 + 1;
            goto L8
        L10:
            int r106 = ((r111 + 1) * 8) - this.f275618c.f275611d;
        L12:
            if (r102 >= (r111 * 8)) goto L15;
            a r107 = this.f275618c;
            int r112 = ((int) (r104 >>> (r106 - r102))) & r107.f275610c;
            char r113 = r107.f275609b[r112];
            ((StringBuilder) r100).append(r113);
            r102 = r102 + this.f275618c.f275611d;
            goto L12
        L15:
            if (this.f275619d != null) goto L17;
            return;
        L17:
            if (r102 >= (this.f275618c.f275613f * 8)) goto L23;
            StringBuilder r114 = (StringBuilder) r100;
            r114.append(this.f275619d.charValue());
            r102 = r102 + this.f275618c.f275611d;
            goto L17
        L23:
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public BaseEncoding() {
    }

    public abstract int b(byte[] r100, CharSequence r101) throws DecodingException;

    public abstract CharSequence c(CharSequence r100);

    static {
        Character r100 = Character.valueOf(com.alipay.sdk.m.n.a.f25612h);
        f275606a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", r100);
        f275607b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", r100);
        new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", r100);
        new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", r100);
        new b();
    }

    public final byte[] a(CharSequence r100) {
        CharSequence r101 = c(r100);     // Catch: DecodingException -> L8
        int r102 = r101.length();     // Catch: DecodingException -> L8
        int r103 = (int) (((((long) ((d) this).f275618c.f275611d) * ((long) r102)) + 7) / 8);     // Catch: DecodingException -> L8
        byte[] r104 = new byte[r103];     // Catch: DecodingException -> L8
        int r105 = b(r104, r101);     // Catch: DecodingException -> L8
        if (r105 == r103) goto L13;
        byte[] r106 = new byte[r105];     // Catch: DecodingException -> L8
        System.arraycopy(r104, 0, r106, 0, r105);     // Catch: DecodingException -> L8
        return r106;
    L13:
        return r104;
    L8:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
