package com.volcengine.zeus.oat;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileInputStreamWrapper f462726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f462727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b[] f462728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c[] f462729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, c> f462730e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f462731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f462732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f462733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final short f462734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final short f462735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final short f462736f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final short f462737g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final short f462738h;

        public a(FileChannel r100) throws IOException {
            byte[] r101 = new byte[16];
            this.f462731a = r101;
            r100.position(0);
            r100.read(ByteBuffer.wrap(r101));
            if (r101[0] != 127) goto L43;
            if (r101[1] != 69) goto L43;
            if (r101[2] != 76) goto L43;
            if (r101[3] != 70) goto L43;
            byte r102 = r101[4];
            String r103 = "bad elf class: " + r101[4];
            if (r102 < 1) goto L41;
            if (r102 > 2) goto L41;
            byte r104 = r101[5];
            String r105 = "bad elf data encoding: " + r101[5];
            if (r104 < 1) goto L39;
            if (r104 > 2) goto L39;
            if (r101[4] != 1) goto L19;
            int r106 = 36;
        L20:
            ByteBuffer r107 = ByteBuffer.allocate(r106);
            if (r101[5] != 1) goto L23;
            ByteOrder r108 = ByteOrder.LITTLE_ENDIAN;
        L24:
            r107.order(r108);
            h.a(r100, r107, "failed to read rest part of ehdr.");
            r107.getShort();
            r107.getShort();
            int r109 = r107.getInt();
            String r110 = "bad elf version: " + r109;
            if (r109 < 1) goto L37;
            if (r109 > 1) goto L37;
            byte r111 = r101[4];
            if (r111 == 1) goto L33;
            if (r111 != 2) goto L32;
            r107.getLong();
            this.f462732b = r107.getLong();
            this.f462733c = r107.getLong();
        L34:
            r107.getInt();
            r107.getShort();
            this.f462734d = r107.getShort();
            this.f462735e = r107.getShort();
            this.f462736f = r107.getShort();
            this.f462737g = r107.getShort();
            this.f462738h = r107.getShort();
            return;
        L32:
            throw new IOException("Unexpected elf class: " + r101[4]);
        L33:
            r107.getInt();
            this.f462732b = r107.getInt();
            this.f462733c = r107.getInt();
        L37:
            throw new IOException(r110);
        L23:
            r108 = ByteOrder.BIG_ENDIAN;
            goto L24
        L19:
            r106 = 48;
        L39:
            throw new IOException(r105);
        L41:
            throw new IOException(r103);
        L43:
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[]{Byte.valueOf(r101[0]), Byte.valueOf(r101[1]), Byte.valueOf(r101[2]), Byte.valueOf(r101[3])}));
        }
    }

    public static class b {
        public b(ByteBuffer r100, int r101) throws IOException {
            if (r101 != 1) goto L5;
            r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            return;
        L5:
            if (r101 != 2) goto L8;
            r100.getInt();
            r100.getInt();
            r100.getLong();
            r100.getLong();
            r100.getLong();
            r100.getLong();
            r100.getLong();
            r100.getLong();
            return;
        L8:
            throw new IOException("Unexpected elf class: " + r101);
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f462739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f462740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f462741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f462742d;

        public c(ByteBuffer r100, int r101) throws IOException {
            if (r101 != 1) goto L5;
            this.f462739a = r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            this.f462740b = r100.getInt();
            this.f462741c = r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
            r100.getInt();
        L10:
            this.f462742d = null;
            return;
        L5:
            if (r101 != 2) goto L8;
            this.f462739a = r100.getInt();
            r100.getInt();
            r100.getLong();
            r100.getLong();
            this.f462740b = r100.getLong();
            this.f462741c = r100.getLong();
            r100.getInt();
            r100.getInt();
            r100.getLong();
            r100.getLong();
            goto L10
        L8:
            throw new IOException("Unexpected elf class: " + r101);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f462726a.close();
        ((HashMap) this.f462730e).clear();
        this.f462728c = null;
        this.f462729d = null;
    }

    public h(PolarisFileWrapper r110) throws IOException {
        this.f462727b = null;
        this.f462728c = null;
        this.f462729d = null;
        this.f462730e = new HashMap();
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper(r110);
        this.f462726a = r100;
        FileChannel r111 = r100.getChannel();
        a r101 = new a(r111);
        this.f462727b = r101;
        ByteBuffer r102 = ByteBuffer.allocate(128);
        r102.limit(r101.f462734d);
        if (r101.f462731a[5] != 1) goto L5;
        ByteOrder r103 = ByteOrder.LITTLE_ENDIAN;
    L6:
        r102.order(r103);
        r111.position(r101.f462732b);
        this.f462728c = new b[r101.f462735e];
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r105 >= this.f462728c.length) goto L10;
        a(r111, r102, "failed to read phdr.");
        this.f462728c[r105] = new b(r102, this.f462727b.f462731a[4]);
        r105 = r105 + 1;
        goto L8
    L10:
        r111.position(this.f462727b.f462733c);
        r102.limit(this.f462727b.f462736f);
        this.f462729d = new c[this.f462727b.f462737g];
        int r106 = 0;
    L11:
        c[] r107 = this.f462729d;
        if (r106 >= r107.length) goto L14;
        a(r111, r102, "failed to read shdr.");
        this.f462729d[r106] = new c(r102, this.f462727b.f462731a[4]);
        r106 = r106 + 1;
        goto L11
    L14:
        short r112 = this.f462727b.f462738h;
        if (r112 <= 0) goto L25;
        c r113 = r107[r112];
        ByteBuffer r108 = ByteBuffer.allocate((int) r113.f462741c);
        this.f462726a.getChannel().position(r113.f462740b);
        a(this.f462726a.getChannel(), r108, "failed to read section: " + r113.f462742d);
        c[] r114 = this.f462729d;
        int r109 = r114.length;
    L17:
        if (r104 >= r109) goto L31;
        c r115 = r114[r104];
        r108.position(r115.f462739a);
        byte[] r116 = r108.array();
        int r117 = r108.position();
    L20:
        if (r108.hasRemaining() == false) goto L24;
        if (r116[r108.position()] == 0) goto L24;
        r108.position(r108.position() + 1);
    L24:
        r108.position(r108.position() + 1);
        String r118 = new String(r116, r117, (r108.position() - r117) - 1, Charset.forName("ASCII"));
        r115.f462742d = r118;
        ((HashMap) this.f462730e).put(r118, r115);
        r104 = r104 + 1;
        goto L17
    L31:
        return;
    L25:
        return;
    L5:
        r103 = ByteOrder.BIG_ENDIAN;
        goto L6
    }

    public static void a(FileChannel r100, ByteBuffer r101, String r102) throws IOException {
        r101.rewind();
        int r103 = r100.read(r101);
        if (r103 != r101.limit()) goto L7;
        r101.flip();
        return;
    L7:
        throw new IOException(r102 + " Rest bytes insufficient, expect to read " + r101.limit() + " bytes but only " + r103 + " bytes were read.");
    }
}
