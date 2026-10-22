package bm3;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public com.bytedance.android.tools.superkv.c a;
    public long b;
    public long c;
    public int d;
    public int e;
    public int f;
    public long g;

    public final long b() throws IOException {
        if (this.e != 2) goto L7;
        long r0 = this.c;
        long r2 = r0 - this.b;
        this.e = 6;
        this.b = r0;
        this.c = this.g;
        this.g = -1;
        return r2;
    L7:
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.e);
    }

    public final void c() throws IOException {
        if (this.e != 2) goto L11;
        int r0 = this.d + 1;
        this.d = r0;
        if (r0 > 65) goto L9;
        this.g = -1;
        this.e = 6;
        return;
    L9:
        throw new IOException("Wire recursion limit exceeded");
    L11:
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final int d() throws IOException {
        this.b++;
        byte r0 = this.a.a();
        if (r0 < 0) goto L5;
        return r0;
    L5:
        int r1 = r0 & 127;
        this.b++;
        byte r2 = this.a.a();
        if (r2 < 0) goto L9;
        int r3 = r2 << 7;
    L26:
        return r1 | r3;
    L9:
        r1 = r1 | ((r2 & 127) << 7);
        this.b++;
        byte r4 = this.a.a();
        if (r4 < 0) goto L12;
        r3 = r4 << 14;
        goto L26
    L12:
        r1 = r1 | ((r4 & 127) << 14);
        this.b++;
        byte r5 = this.a.a();
        if (r5 < 0) goto L15;
        r3 = r5 << 21;
        goto L26
    L15:
        int r6 = r1 | ((r5 & 127) << 21);
        this.b++;
        byte r7 = this.a.a();
        int r8 = r6 | (r7 << 28);
        if (r7 >= 0) goto L29;
        int r9 = 0;
    L19:
        if (r9 >= 5) goto L25;
        this.b++;
        if (this.a.a() >= 0) goto L22;
        r9 = r9 + 1;
        goto L19
    L22:
        return r8;
    L25:
        throw new ProtocolException("Malformed VARINT");
    L29:
        return r8;
    }

    public final int e() throws IOException {
        int r0 = this.e;
        if (r0 != 7) goto L7;
        this.e = 2;
        return this.f;
    L7:
        if (r0 != 6) goto L57;
    L9:
        if (this.b >= this.c) goto L54;
        com.bytedance.android.tools.superkv.c r1 = this.a;
        if ((r1.b - r1.a.position()) > 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L65;
        int r3 = d();
        if (r3 == 0) goto L53;
        int r4 = r3 >> 3;
        this.f = r4;
        int r5 = r3 & 7;
        if (r5 == 0) goto L50;
        if (r5 == 1) goto L48;
        if (r5 == 2) goto L34;
        if (r5 != 3) goto L24;
        k(r4);
        goto L9
    L24:
        if (r5 == 4) goto L32;
        if (r5 != 5) goto L30;
        this.e = 5;
        return r4;
    L30:
        throw new ProtocolException("Unexpected field encoding: " + r5);
    L32:
        throw new ProtocolException("Unexpected end group");
    L34:
        this.e = 2;
        int r6 = d();
        if (r6 < 0) goto L47;
        if (this.g != (-1)) goto L45;
        long r7 = this.c;
        this.g = r7;
        long r8 = this.b + ((long) r6);
        this.c = r8;
        if (r8 > r7) goto L43;
        return this.f;
    L43:
        throw new EOFException();
    L45:
        throw new IllegalStateException();
    L47:
        throw new ProtocolException("Negative length: " + r6);
    L48:
        this.e = 1;
        return r4;
    L50:
        this.e = 0;
        return r4;
    L53:
        throw new ProtocolException("Unexpected tag 0");
    L65:
        return -1;
    L13:
        r2 = false;
        goto L14
    L54:
        return -1;
    L57:
        throw new IllegalStateException("Unexpected call to nextTag()");
    }

    public final int f() throws IOException {
        int r0 = this.e;
        if (r0 == 5) goto L8;
        if (r0 == 2) goto L8;
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.e);
    L8:
        this.b += 4;
        com.bytedance.android.tools.superkv.c r1 = this.a;
        r1.a.get(r1.c, 0, 4);
        byte[] r2 = r1.c;
        int r3 = (r2[3] & 255) | (((r2[2] & 255) << 8) | (((r2[0] & 255) << 24) | ((r2[1] & 255) << 16)));
        a(5);
        return r3;
    }

    public final long g() throws IOException {
        int r0 = this.e;
        if (r0 == 1) goto L8;
        if (r0 == 2) goto L8;
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.e);
    L8:
        this.b += 8;
        com.bytedance.android.tools.superkv.c r1 = this.a;
        r1.a.get(r1.c, 0, 8);
        byte[] r2 = r1.c;
        long r3 = ((long) (r2[7] & 255)) | (((((((((long) (r2[0] & 255)) << 56) | (((long) (r2[1] & 255)) << 48)) | (((long) (r2[2] & 255)) << 40)) | (((long) (r2[3] & 255)) << 32)) | ((long) ((r2[4] & 255) << 24))) | ((long) ((r2[5] & 255) << 16))) | ((long) ((r2[6] & 255) << 8)));
        a(1);
        return r3;
    }

    public final int i() throws IOException {
        int r0 = this.e;
        if (r0 != 0) goto L5;
    L9:
        int r1 = d();
        a(0);
        return r1;
    L5:
        if (r0 == 2) goto L9;
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    public final long j() throws IOException {
        int r0 = this.e;
        if (r0 != 0) goto L5;
    L9:
        long r1 = 0;
        int r3 = 0;
    L11:
        if (r3 >= 64) goto L18;
        this.b++;
        byte r4 = this.a.a();
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
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.e);
    }

    public c() {
        this.b = 0;
        this.c = Long.MAX_VALUE;
        this.e = 2;
        this.f = -1;
        this.g = -1;
    }

    public final String h() throws IOException {
        long r0 = b();
        com.bytedance.android.tools.superkv.c r2 = this.a;
        r2.getClass();
        if (r0 > 1024) goto L5;
        r2.a.get(r2.c, 0, (int) r0);
        byte[] r3 = r2.c;
    L7:
        return new String(r3, 0, (int) r0, com.bytedance.android.tools.superkv.c.d);
    L5:
        byte[] r4 = new byte[(int) r0];
        r2.a.get(r4);
        r3 = r4;
        goto L7
    }

    public c(com.bytedance.android.tools.superkv.c r3) {
        this.b = 0;
        this.c = Long.MAX_VALUE;
        this.e = 2;
        this.f = -1;
        this.g = -1;
        this.a = r3;
    }

    public final void a(int r7) throws IOException {
        if (this.e != r7) goto L5;
        this.e = 6;
        return;
    L5:
        long r2 = this.b;
        long r4 = this.c;
        if (r2 > r4) goto L13;
        if (r2 != r4) goto L10;
        this.c = this.g;
        this.g = -1;
        this.e = 6;
        return;
    L10:
        this.e = 7;
        return;
    L13:
        throw new IOException("Expected to end at " + this.c + " but was " + this.b);
    }

    public final void k(int r6) throws IOException {
    L3:
        if (this.b >= this.c) goto L36;
        com.bytedance.android.tools.superkv.c r0 = this.a;
        if ((r0.b - r0.a.position()) > 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L36;
        int r2 = d();
        if (r2 == 0) goto L34;
        int r3 = r2 >> 3;
        int r4 = r2 & 7;
        if (r4 != 0) goto L13;
        this.e = 0;
        j();
        goto L3
    L13:
        if (r4 != 1) goto L15;
        this.e = 1;
        g();
        goto L3
    L15:
        if (r4 != 2) goto L17;
        long r5 = d();
        this.b += r5;
        ByteBuffer r7 = this.a.a;
        r7.position((int) (((long) r7.position()) + r5));
        goto L3
    L17:
        if (r4 != 3) goto L19;
        k(r3);
        goto L3
    L19:
        if (r4 == 4) goto L25;
        if (r4 != 5) goto L24;
        this.e = 5;
        f();
        goto L3
    L24:
        throw new ProtocolException("Unexpected field encoding: " + r4);
    L25:
        if (r3 != r6) goto L28;
        return;
    L28:
        throw new ProtocolException("Unexpected end group");
    L34:
        throw new ProtocolException("Unexpected tag 0");
    L7:
        r1 = false;
    L36:
        throw new EOFException();
    }
}
