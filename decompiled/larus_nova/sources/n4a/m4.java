package n4a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes32.dex */
public class m4 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Charset f517528n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f517529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f517530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f517531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f517532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f517533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f517534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f517535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f517536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f517537i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f517538j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f517539k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CharsetEncoder f517540l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ByteBuffer f517541m;

    static {
        f517528n = Charset.forName("UTF-8");
    }

    public m4(ByteBuffer r100) {
        this.f517531c = 1;
        this.f517532d = null;
        this.f517533e = 0;
        this.f517534f = false;
        this.f517535g = false;
        this.f517537i = new int[16];
        this.f517538j = 0;
        this.f517539k = 0;
        this.f517540l = f517528n.newEncoder();
        j(r100);
    }

    public final void e(int r100, byte r101) {
        if (r101 == 0) goto L5;
        c(r101);
        s(r100);
        return;
    }

    public final void i(int r100, short r101) {
        if (r101 == 0) goto L5;
        n(r101);
        s(r100);
        return;
    }

    public final void j(ByteBuffer r100) {
        this.f517529a = r100;
        r100.clear();
        this.f517529a.order(ByteOrder.LITTLE_ENDIAN);
        this.f517531c = 1;
        this.f517530b = this.f517529a.capacity();
        this.f517533e = 0;
        this.f517534f = false;
        this.f517535g = false;
        this.f517536h = 0;
        this.f517538j = 0;
        this.f517539k = 0;
    }

    public final void m(int r100, int r101) {
        if (r101 == 0) goto L5;
        d(r101);
        s(r100);
        return;
    }

    public final void o(int r100) {
        p(this.f517531c, 4);
        d(r100);
        this.f517529a.position(this.f517530b);
        this.f517535g = true;
    }

    public final int r() {
        return this.f517529a.capacity() - this.f517530b;
    }

    public final void s(int r100) {
        this.f517532d[r100] = r();
    }

    public final int a() {
        if (this.f517534f == false) goto L7;
        this.f517534f = false;
        int r100 = this.f517539k;
        ByteBuffer r101 = this.f517529a;
        int r102 = this.f517530b - 4;
        this.f517530b = r102;
        r101.putInt(r102, r100);
        return r();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public final int k() {
        if (this.f517532d == null) goto L36;
        if (this.f517534f == false) goto L36;
        p(4, 0);
        ByteBuffer r100 = this.f517529a;
        int r101 = this.f517530b - 4;
        this.f517530b = r101;
        r100.putInt(r101, 0);
        int r102 = r();
        int r103 = this.f517533e;
    L7:
        r103 = r103 - 1;
        if (r103 < 0) goto L14;
        int r104 = this.f517532d[r103];
        if (r104 == 0) goto L12;
        int r105 = r102 - r104;
    L13:
        n((short) r105);
        goto L7
    L12:
        r105 = 0;
        goto L13
    L14:
        n((short) (r102 - this.f517536h));
        n((short) ((this.f517533e + 2) * 2));
        int r106 = 0;
    L16:
        if (r106 >= this.f517538j) goto L26;
        int r107 = this.f517529a.capacity() - this.f517537i[r106];
        int r108 = this.f517530b;
        short r109 = this.f517529a.getShort(r107);
        if (r109 != this.f517529a.getShort(r108)) goto L25;
        int r110 = 2;
    L20:
        if (r110 >= r109) goto L24;
        if (this.f517529a.getShort(r107 + r110) != this.f517529a.getShort(r108 + r110)) goto L25;
        r110 = r110 + 2;
        goto L20
    L24:
        int r111 = this.f517537i[r106];
    L27:
        if (r111 == 0) goto L29;
        int r112 = this.f517529a.capacity() - r102;
        this.f517530b = r112;
        this.f517529a.putInt(r112, r111 - r102);
    L33:
        this.f517534f = false;
        return r102;
    L29:
        int r113 = this.f517538j;
        int[] r114 = this.f517537i;
        if (r113 != r114.length) goto L32;
        this.f517537i = Arrays.copyOf(r114, r113 * 2);
    L32:
        int[] r115 = this.f517537i;
        int r116 = this.f517538j;
        this.f517538j = r116 + 1;
        r115[r116] = r();
        ByteBuffer r117 = this.f517529a;
        r117.putInt(r117.capacity() - r102, r() - r102);
    L25:
        r106 = r106 + 1;
        goto L16
    L26:
        r111 = 0;
    L36:
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    public final byte[] q() {
        int r100 = this.f517530b;
        int r101 = this.f517529a.capacity() - this.f517530b;
        if (this.f517535g == false) goto L7;
        byte[] r102 = new byte[r101];
        this.f517529a.position(r100);
        this.f517529a.get(r102);
        return r102;
    L7:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public m4() {
        this.f517531c = 1;
        this.f517532d = null;
        this.f517533e = 0;
        this.f517534f = false;
        this.f517535g = false;
        this.f517537i = new int[16];
        this.f517538j = 0;
        this.f517539k = 0;
        this.f517540l = f517528n.newEncoder();
        this.f517530b = 1024;
        ByteBuffer r100 = ByteBuffer.allocate(1024);
        r100.order(ByteOrder.LITTLE_ENDIAN);
        this.f517529a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int b(CharSequence r100) {
        String r101 = (String) r100;
        int r102 = (int) (r101.length() * this.f517540l.maxBytesPerChar());
        ByteBuffer r103 = this.f517541m;
        if (r103 != null) goto L5;
    L6:
        this.f517541m = ByteBuffer.allocate(Math.max(128, r102));
    L7:
        this.f517541m.clear();
        if ((r101 instanceof CharBuffer) == false) goto L10;
        CharBuffer r104 = (CharBuffer) r101;
    L11:
        CoderResult r105 = this.f517540l.encode(r104, this.f517541m, true);
        if (r105.isError() == true) goto L20;
    L18:
        this.f517541m.flip();
        ByteBuffer r106 = this.f517541m;
        int r107 = r106.remaining();
        c((byte) 0);
        g(1, r107, 1);
        ByteBuffer r108 = this.f517529a;
        int r109 = this.f517530b - r107;
        this.f517530b = r109;
        r108.position(r109);
        this.f517529a.put(r106);
        return a();
    L20:
        r105.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new Error(e);
    L10:
        r104 = CharBuffer.wrap(r101);
        goto L11
    L5:
        if (r103.capacity() >= r102) goto L7;
        goto L6
    }

    public final void c(byte r100) {
        p(1, 0);
        ByteBuffer r101 = this.f517529a;
        int r102 = this.f517530b - 1;
        this.f517530b = r102;
        r101.put(r102, r100);
    }

    public final void d(int r100) {
        p(4, 0);
        int r101 = (r() - r100) + 4;
        ByteBuffer r102 = this.f517529a;
        int r103 = this.f517530b - 4;
        this.f517530b = r103;
        r102.putInt(r103, r101);
    }

    public final void l(int r100) {
        if (this.f517534f == true) goto L12;
        int[] r101 = this.f517532d;
        if (r101 != null) goto L7;
    L8:
        this.f517532d = new int[r100];
    L9:
        this.f517533e = r100;
        Arrays.fill(this.f517532d, 0, r100, 0);
        this.f517534f = true;
        this.f517536h = r();
        return;
    L7:
        if (r101.length >= r100) goto L9;
    L12:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    public final void n(short r100) {
        p(2, 0);
        ByteBuffer r101 = this.f517529a;
        int r102 = this.f517530b - 2;
        this.f517530b = r102;
        r101.putShort(r102, r100);
    }

    public final void f(int r100, int r101) {
        if (r101 == 0) goto L5;
        p(4, 0);
        ByteBuffer r102 = this.f517529a;
        int r103 = this.f517530b - 4;
        this.f517530b = r103;
        r102.putInt(r103, r101);
        s(r100);
        return;
    }

    public final void h(int r100, long r101) {
        if (r101 == 0) goto L6;
        p(8, 0);
        ByteBuffer r102 = this.f517529a;
        int r103 = this.f517530b - 8;
        this.f517530b = r103;
        r102.putLong(r103, r101);
        s(r100);
        return;
    }

    public final void p(int r100, int r101) {
        if (r100 <= this.f517531c) goto L5;
        this.f517531c = r100;
    L5:
        int r102 = ((~((this.f517529a.capacity() - this.f517530b) + r101)) + 1) & (r100 - 1);
    L7:
        if (this.f517530b >= ((r102 + r100) + r101)) goto L13;
        int r103 = this.f517529a.capacity();
        ByteBuffer r104 = this.f517529a;
        int r105 = r104.capacity();
        if (((-1073741824) & r105) != 0) goto L12;
        int r106 = r105 << 1;
        r104.position(0);
        ByteBuffer r107 = ByteBuffer.allocate(r106);
        r107.order(ByteOrder.LITTLE_ENDIAN);
        r107.position(r106 - r105);
        r107.put(r104);
        this.f517529a = r107;
        this.f517530b += r107.capacity() - r103;
        goto L7
    L12:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    L13:
        int r108 = 0;
    L14:
        if (r108 >= r102) goto L16;
        ByteBuffer r109 = this.f517529a;
        int r110 = this.f517530b - 1;
        this.f517530b = r110;
        r109.put(r110, (byte) 0);
        r108 = r108 + 1;
        goto L14
    }

    public final void g(int r100, int r101, int r102) {
        if (this.f517534f == true) goto L7;
        this.f517539k = r101;
        int r103 = r100 * r101;
        p(4, r103);
        p(r102, r103);
        this.f517534f = true;
        return;
    L7:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }
}
