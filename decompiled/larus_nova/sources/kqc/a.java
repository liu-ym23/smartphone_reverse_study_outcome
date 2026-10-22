package kqc;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f505664f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f505665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f505666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f505667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f505668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C6601a f505669e;

    /* JADX INFO: renamed from: kqc.a$a, reason: collision with other inner class name */
    public static class C6601a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final short f505670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f505671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f505672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f505673d;

        public C6601a(short r100, int r101, int r102, int r103) {
            this.f505670a = r100;
            this.f505671b = r101;
            this.f505672c = r103;
            this.f505673d = r103 + r102;
        }
    }

    static {
        f505664f = Logger.getLogger(a.class.getName());
    }

    public final C6601a b() throws IOException {
        i r100 = this.f505667c;
        g r101 = this.f505668d;
        int r102 = r101.getCount();
        short r103 = r100.readShort();     // Catch: EOFException -> L5
        C6601a r104 = new C6601a(r103, r100.readShort(), r100.readInt(), r102);
    L6:
        this.f505669e = r104;
        return r104;
    L5:
        r104 = new C6601a(-1, 0, 0, r101.getCount());
        goto L6
    }

    public final void d() throws IOException {
        a(514);
        this.f505667c.readUnsignedByte();
        this.f505667c.skipBytes(3);
        int r100 = this.f505667c.readInt();
        this.f505667c.skipBytes(r100 * 4);
    }

    public final void f() throws IOException {
        short r100 = this.f505667c.readShort();
        if (r100 != 8) goto L15;
        byte r101 = this.f505667c.readByte();
        if (r101 != 0) goto L13;
        byte r102 = this.f505667c.readByte();
        int r103 = m.a(this.f505667c);
        int r104 = this.f505667c.readInt();
        if (r102 != 1) goto L9;
        m.c(this.f505665a, r104, r103, this.f505666b);
    L9:
        if (r102 != 2) goto L16;
        m.c(this.f505665a, r104, r103, this.f505666b);
        return;
    L16:
        return;
    L13:
        throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{(byte) 0, Byte.valueOf(r101)}));
    L15:
        throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", new Object[]{(short) 8, Short.valueOf(r100)}));
    }

    public final void e() throws IOException {
        d();
        short r100 = b().f505670a;
    L4:
        if (r100 != 514) goto L7;
        d();
        r100 = b().f505670a;
    L7:
        if (r100 != 513) goto L65;
        a(513);
        this.f505667c.readUnsignedByte();
        this.f505667c.readByte();
        this.f505667c.skipBytes(2);
        int r101 = this.f505667c.readInt();
        int r102 = this.f505667c.readInt();
        int r103 = this.f505667c.readInt();
        int r104 = 28;
        if (r103 < 28) goto L64;
        this.f505667c.readShort();
        this.f505667c.readShort();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readUnsignedShort();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.skipBytes(1);
        this.f505667c.readShort();
        this.f505667c.readShort();
        this.f505667c.readShort();
        this.f505667c.skipBytes(2);
        if (r103 < 32) goto L14;
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.readShort();
        r104 = 32;
    L14:
        if (r103 < 36) goto L17;
        this.f505667c.readShort();
        this.f505667c.readShort();
        r104 = 36;
    L17:
        if (r103 < 48) goto L20;
        c(4).toCharArray();
        c(8).toCharArray();
        r104 = 48;
    L20:
        if (r103 < 52) goto L23;
        this.f505667c.readByte();
        this.f505667c.readByte();
        this.f505667c.skipBytes(2);
        r104 = 52;
    L23:
        if (r103 < 56) goto L25;
        this.f505667c.skipBytes(4);
        r104 = 56;
    L25:
        int r105 = r103 - 56;
        if (r105 <= 0) goto L31;
        byte[] r106 = new byte[r105];
        r104 = r104 + r105;
        this.f505667c.readFully(r106);
        BigInteger r107 = new BigInteger(1, r106);
        if (r107.equals(BigInteger.ZERO) == false) goto L30;
        f505664f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", new Object[]{56}));
        goto L31
    L30:
        f505664f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", new Object[]{56, Integer.valueOf(r103), r107}));
    L31:
        int r108 = r103 - r104;
        if (r108 <= 0) goto L34;
        this.f505667c.skipBytes(r108);
    L34:
        int r109 = (this.f505669e.f505672c + r102) - (r101 * 4);
        if (r109 == this.f505668d.getCount()) goto L37;
        f505664f.warning("Invalid data detected. Skipping: " + (r109 - this.f505668d.getCount()) + " byte(s)");
        this.f505667c.skipBytes(r109 - this.f505668d.getCount());
    L37:
        i r110 = this.f505667c;
        r110.getClass();
        int[] r111 = new int[r101];
        int r112 = 0;
    L38:
        if (r112 >= r101) goto L40;
        r111[r112] = r110.readInt();
        r112 = r112 + 1;
        goto L38
    L40:
        HashSet r113 = new HashSet();
        int r114 = 0;
    L41:
        if (r114 >= r101) goto L60;
        int r115 = r111[r114];
        if (r115 == (-1)) goto L58;
        if (r113.contains(Integer.valueOf(r115)) == true) goto L58;
        if (this.f505667c.readShort() < 0) goto L57;
        short r116 = this.f505667c.readShort();
        this.f505667c.readInt();
        if ((r116 & 1) != 0) goto L52;
        f();
    L55:
        r113.add(Integer.valueOf(r115));
        goto L58
    L52:
        m.c(this.f505665a, this.f505667c.readInt(), m.a(this.f505667c), this.f505666b);
        int r117 = this.f505667c.readInt();
        int r118 = 0;
    L53:
        if (r118 >= r117) goto L55;
        m.c(this.f505665a, this.f505667c.readInt(), m.a(this.f505667c), this.f505666b);
        f();
        r118 = r118 + 1;
        goto L53
    L57:
        throw new RuntimeException("Entry size is under 0 bytes.");
    L58:
        r114 = r114 + 1;
        goto L41
    L60:
        if (this.f505668d.getCount() >= this.f505669e.f505673d) goto L62;
        f505664f.warning("Unknown data detected. Skipping: " + (this.f505669e.f505673d - this.f505668d.getCount()) + " byte(s)");
        g r119 = this.f505668d;
        r119.skip((long) (this.f505669e.f505673d - r119.getCount()));
    L62:
        r100 = b().f505670a;
        goto L7
    L64:
        throw new RuntimeException("Config size < 28");
    }

    public final void a(int r100) {
        if (this.f505669e.f505670a != r100) goto L6;
        return;
    L6:
        throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", new Object[]{Integer.valueOf(r100), Short.valueOf(this.f505669e.f505670a)}));
    }

    public final String c(int r100) throws IOException {
        StringBuilder r101 = new StringBuilder(16);
    L3:
        int r102 = r100 - 1;
        if (r100 == 0) goto L9;
        short r103 = this.f505667c.readByte();
        if (r103 == 0) goto L9;
        r101.append((char) r103);
        r100 = r102;
    L9:
        this.f505667c.skipBytes(r102);
        return r101.toString();
    }

    public a(byte[] r100, d r101) {
        g r102 = new g(new ByteArrayInputStream(r100));
        this.f505668d = r102;
        this.f505667c = new i(new k(r102));
        this.f505665a = r100;
        this.f505666b = r101;
    }
}
