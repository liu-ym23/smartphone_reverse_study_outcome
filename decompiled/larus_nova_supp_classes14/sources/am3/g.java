package am3;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public final a a;
    public f b;
    public long c;
    public long d;
    public int e;
    public int f;
    public int g;
    public long h;
    public int i;
    public boolean j;

    public static final class a {
        public final long a;
        public final long b;
        public final int c;
        public final int d;
        public final int e;
        public final long f;
        public final int g;

        public final int hashCode() {
            return Objects.hash(new Object[]{Long.valueOf(this.a), Long.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Long.valueOf(this.f), Integer.valueOf(this.g)});
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L11;
        L23:
            return false;
        L11:
            if (this.b != r9.b) goto L23;
            if (this.c != r9.c) goto L23;
            if (this.d != r9.d) goto L23;
            if (this.e != r9.e) goto L23;
            if (this.f != r9.f) goto L23;
            if (this.g != r9.g) goto L23;
            return true;
        }

        public a(long r1, long r3, int r5, int r6, int r7, long r8, int r10) {
            this.a = r1;
            this.b = r3;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r10;
        }
    }

    public final long b() throws IOException {
        if (this.f != 2) goto L7;
        long r0 = this.d;
        long r2 = r0 - this.c;
        this.f = 6;
        this.c = r0;
        this.d = this.h;
        this.h = -1;
        return r2;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.f);
    }

    public final long c() throws IOException {
        if (this.f != 2) goto L11;
        int r0 = this.e + 1;
        this.e = r0;
        if (r0 > 65) goto L9;
        long r1 = this.h;
        this.h = -1;
        this.f = 6;
        return r1;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final int e() throws IOException {
        this.c++;
        byte r0 = this.b.readByte();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r0 & 127;
        this.c++;
        byte r2 = this.b.readByte();
        if (r2 < 0) goto L9;
        int r3 = r2 << 7;
    L26:
        return r1 | r3;
    L9:
        r1 = r1 | ((r2 & 127) << 7);
        this.c++;
        byte r4 = this.b.readByte();
        if (r4 < 0) goto L12;
        r3 = r4 << 14;
        goto L26
    L12:
        r1 = r1 | ((r4 & 127) << 14);
        this.c++;
        byte r5 = this.b.readByte();
        if (r5 < 0) goto L15;
        r3 = r5 << 21;
        goto L26
    L15:
        int r6 = r1 | ((r5 & 127) << 21);
        this.c++;
        byte r7 = this.b.readByte();
        int r8 = r6 | (r7 << 28);
        if (r7 >= 0) goto L29;
        int r9 = 0;
    L19:
        if (r9 >= 5) goto L25;
        this.c++;
        if (this.b.readByte() >= 0) goto L22;
        r9 = r9 + 1;
        goto L19
    L22:
        return r8;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L29:
        return r8;
    }

    public final int f() throws IOException {
        int r0 = this.f;
        if (r0 != 7) goto L7;
        this.f = 2;
        return this.g;
    L7:
        if (r0 != 6) goto L55;
    L9:
        if (this.c >= this.d) goto L52;
        if (this.b.d() == false) goto L63;
        int r1 = e();
        if (r1 == 0) goto L51;
        int r2 = r1 >> 3;
        this.g = r2;
        int r3 = r1 & 7;
        if (r3 == 0) goto L48;
        if (r3 == 1) goto L46;
        if (r3 == 2) goto L32;
        if (r3 != 3) goto L22;
        m(r2);
        goto L9
    L22:
        if (r3 == 4) goto L30;
        if (r3 != 5) goto L28;
        this.i = 5;
        this.f = 5;
        return r2;
    L28:
        throw new ProtocolException("Unexpected field encoding: " + r3);
    L30:
        throw new ProtocolException("Unexpected end group");
    L32:
        this.i = 2;
        this.f = 2;
        int r4 = e();
        if (r4 < 0) goto L45;
        if (this.h != (-1)) goto L43;
        long r5 = this.d;
        this.h = r5;
        long r6 = this.c + ((long) r4);
        this.d = r6;
        if (r6 > r5) goto L41;
        return this.g;
    L41:
        throw new EOFException();
    L43:
        throw new IllegalStateException();
    L45:
        throw new ProtocolException("Negative length: " + r4);
    L46:
        this.i = 1;
        this.f = 1;
        return r2;
    L48:
        this.i = 0;
        this.f = 0;
        return r2;
    L51:
        throw new ProtocolException("Unexpected tag 0");
    L63:
        return -1;
    L52:
        return -1;
    L55:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public final int g() throws IOException {
        int r0 = this.f;
        if (r0 != 5) goto L5;
    L9:
        this.c += 4;
        int r1 = this.b.readIntLe();
        a(5);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.f);
    }

    public final long h() throws IOException {
        int r0 = this.f;
        if (r0 != 1) goto L5;
    L9:
        this.c += 8;
        long r2 = this.b.readLongLe();
        a(1);
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.f);
    }

    public final int i() throws IOException {
        int r0 = this.f;
        if (r0 != 0) goto L5;
    L9:
        int r1 = e();
        a(0);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f);
    }

    public final long j() throws IOException {
        int r0 = this.f;
        if (r0 != 0) goto L5;
    L9:
        long r1 = 0;
        int r3 = 0;
    L11:
        if (r3 >= 64) goto L18;
        this.c++;
        byte r4 = this.b.readByte();
        r1 = r1 | (((long) (r4 & 127)) << r3);
        if ((r4 & 128) == 0) goto L14;
        r3 = r3 + 7;
        goto L11
    L14:
        a(0);
        return r1;
    L18:
        throw new ProtocolException("WireInput encountered a malformed varint");
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.f);
    }

    public g() {
        this.c = 0;
        this.d = Long.MAX_VALUE;
        this.f = 2;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.a = null;
    }

    public g(g r12) {
        this.c = 0;
        this.d = Long.MAX_VALUE;
        this.f = 2;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.c = r12.c;
        this.d = r12.d;
        this.e = r12.e;
        this.f = r12.f;
        this.g = r12.g;
        this.h = r12.h;
        this.i = r12.i;
        this.j = true;
        this.b = r12.b.b();
        this.a = new a(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
    }

    public final void a(int r7) throws IOException {
        if (this.f != r7) goto L5;
        this.f = 6;
        return;
    L5:
        long r2 = this.c;
        long r4 = this.d;
        if (r2 > r4) goto L13;
        if (r2 != r4) goto L10;
        this.d = this.h;
        this.h = -1;
        this.f = 6;
        return;
    L10:
        this.f = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.d + " but was " + this.c);
    }

    public final void d(long r7) throws IOException {
        if (this.f != 6) goto L19;
        int r0 = this.e - 1;
        this.e = r0;
        if (r0 < 0) goto L17;
        if (this.h != (-1)) goto L17;
        if (this.c == this.d) goto L14;
        if (r0 == 0) goto L14;
        throw new IOException("Expected to end at " + this.d + " but was " + this.c);
    L14:
        this.d = r7;
        return;
    L17:
        throw new IllegalStateException("No corresponding call to beginMessage()");
    L19:
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public final void k(e r3) {
        l(r3, Long.MAX_VALUE);
    }

    public final void m(int r6) throws IOException {
    L3:
        if (this.c >= this.d) goto L34;
        if (this.b.d() == false) goto L34;
        int r0 = e();
        if (r0 == 0) goto L32;
        int r1 = r0 >> 3;
        int r2 = r0 & 7;
        if (r2 != 0) goto L11;
        this.f = 0;
        j();
        goto L3
    L11:
        if (r2 != 1) goto L13;
        this.f = 1;
        h();
        goto L3
    L13:
        if (r2 != 2) goto L15;
        long r3 = e();
        this.c += r3;
        this.b.skip(r3);
        goto L3
    L15:
        if (r2 != 3) goto L17;
        m(r1);
        goto L3
    L17:
        if (r2 == 4) goto L23;
        if (r2 != 5) goto L22;
        this.f = 5;
        g();
        goto L3
    L22:
        throw new ProtocolException("Unexpected field encoding: " + r2);
    L23:
        if (r1 != r6) goto L26;
        return;
    L26:
        throw new ProtocolException("Unexpected end group");
    L32:
        throw new ProtocolException("Unexpected tag 0");
    L34:
        throw new EOFException();
    }

    public final void l(e r3, long r4) {
        this.b = r3;
        this.c = 0;
        this.d = r4;
        this.e = 0;
        this.f = 2;
        this.g = -1;
        this.h = r4;
        this.i = -1;
    }
}
