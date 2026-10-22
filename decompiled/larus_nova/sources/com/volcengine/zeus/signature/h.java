package com.volcengine.zeus.signature;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public abstract class h {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f462899a;

        public a(byte[] r100) {
            this.f462899a = r100;
        }
    }

    public static class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f462900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteBuffer f462901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MessageDigest f462902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f462903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f462904e;

        public final void a() throws DigestException {
            if (this.f462900a != 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Buffer is not empty: " + this.f462900a);
        }

        @Override // com.volcengine.zeus.signature.j
        public final void consume(ByteBuffer r100) throws DigestException {
            r100.position();
            int r101 = r100.remaining();
        L3:
            if (r101 <= 0) goto L7;
            int r102 = Math.min(r101, 4096 - this.f462900a);
            r100.limit(r100.position() + r102);
            this.f462902c.update(r100);
            r101 = r101 - r102;
            int r103 = this.f462900a + r102;
            this.f462900a = r103;
            if (r103 != 4096) goto L3;
            MessageDigest r104 = this.f462902c;
            byte[] r105 = this.f462903d;
            r104.digest(r105, 0, r105.length);
            this.f462901b.put(this.f462903d);
            this.f462902c.update(this.f462904e);
            this.f462900a = 0;
            goto L3
        }

        public b(byte[] r100, ByteBuffer r101) throws NoSuchAlgorithmException {
            this.f462903d = new byte[32];
            this.f462904e = r100;
            this.f462901b = r101.slice();
            MessageDigest r102 = MessageDigest.getInstance("SHA-256");
            this.f462902c = r102;
            r102.update(r100);
            this.f462900a = 0;
        }
    }

    public static int[] a(long r100) {
        ArrayList r101 = new ArrayList();
    L3:
        r100 = (((r100 + 4096) - 1) / 4096) * 32;
        r101.add(Long.valueOf((((r100 + 4096) - 1) / 4096) * 4096));
        if (r100 > 4096) goto L3;
        int[] r102 = new int[r101.size() + 1];
        int r103 = 0;
        r102[0] = 0;
    L7:
        if (r103 >= r101.size()) goto L13;
        int r104 = r103 + 1;
        int r105 = r102[r103];
        long r106 = ((Long) ListProtector.get(r101, (r101.size() - r103) - 1)).longValue();
        int r107 = (int) r106;
        if (r107 != r106) goto L12;
        r102[r104] = r105 + r107;
        r103 = r104;
        goto L7
    L12:
        throw new ArithmeticException("integer overflow");
    L13:
        return r102;
    }

    public static void b(b r100, k r101, int r110) throws IOException, DigestException {
        long r102 = r101.size();
        long r103 = 0;
    L4:
        if (r102 <= 0) goto L6;
        int r104 = (int) Math.min(r102, r110);
        r101.a(r100, r103, r104);
        long r105 = r104;
        r103 = r103 + r105;
        r102 = r102 - r105;
        goto L4
    }

    public static a c(RandomAccessFile r310, m r311, f r312) throws IOException, SecurityException, NoSuchAlgorithmException, DigestException {
        int[] r100 = a(r310.length() - (r311.f462912c - r311.f462911b));
        int r101 = r100[r100.length - 1];
        int r102 = r101 + 4096;
        ByteBuffer r103 = ByteBuffer.allocate(r102);
        ByteOrder r104 = ByteOrder.LITTLE_ENDIAN;
        r103.order(r104);
        ByteBuffer r105 = d(r103, 0, r101);
        int r106 = r101 + 64;
        ByteBuffer r107 = d(r103, r101, r106);
        ByteBuffer r108 = d(r103, r106, r102);
        byte[] r110 = new byte[32];
        ByteBuffer r111 = ByteBuffer.wrap(r110);
        r111.order(r104);
        long r112 = r311.f462911b;
        if ((r112 % 4096) != 0) goto L42;
        long r109 = r311.f462912c - r112;
        if ((r109 % 4096) != 0) goto L40;
        int[] r113 = a(r310.length() - r109);
        byte[] r114 = new byte[8];
        if (r105 == null) goto L29;
        b r115 = new b(r114, d(r105, r113[r113.length - 2], r113[r113.length - 1]));
        b(r115, new l(r310.getFD(), 0, r311.f462911b), 1048576);
        long r116 = r311.f462913d + 16;
        FileDescriptor r210 = r310.getFD();
        long r117 = r311.f462912c;
        b(r115, new l(r210, r117, r116 - r117), 1048576);
        ByteBuffer r118 = ByteBuffer.allocate(4).order(r104);
        long r119 = r311.f462911b;
        int r120 = (int) r119;
        if (r120 != r119) goto L26;
        r118.putInt(r120);
        r118.flip();
        r115.consume(r118);
        long r313 = r116 + 4;
        b(r115, new l(r310.getFD(), r313, r310.length() - r313), 1048576);
        int r121 = (int) (r310.length() % 4096);
        if (r121 == 0) goto L13;
        r115.consume(ByteBuffer.allocate(4096 - r121));
    L13:
        r115.a();
        int r122 = r115.f462901b.position() % 4096;
        if (r122 == 0) goto L17;
        r115.f462901b.put(ByteBuffer.allocate(4096 - r122));
    L17:
        int r123 = r113.length - 3;
    L18:
        if (r123 < 0) goto L24;
        int r124 = r123 + 1;
        ByteBuffer r125 = d(r105, r113[r124], r113[r123 + 2]);
        ByteBuffer r126 = d(r105, r113[r123], r113[r124]);
        i r127 = new i(r125);
        b r128 = new b(r114, r126);
        b(r128, r127, 4096);
        r128.a();
        int r129 = r128.f462901b.position() % 4096;
        if (r129 == 0) goto L23;
        r128.f462901b.put(ByteBuffer.allocate(4096 - r129));
    L23:
        r123 = r123 - 1;
        goto L18
    L24:
        byte[] r130 = new byte[32];
        b r131 = new b(r114, ByteBuffer.wrap(r130));
        r131.consume(d(r105, 0, 4096));
        r131.a();
        r111.put(r130);
        r111.flip();
        goto L29
    L26:
        throw new ArithmeticException("integer overflow");
    L29:
        if (r107 == 0) goto L31;
        r107.order(ByteOrder.LITTLE_ENDIAN);
        long r132 = r310.length();
        r107.put("TrueBrew".getBytes());
        r107.put((byte) 1);
        r107.put((byte) 0);
        r107.put((byte) 12);
        r107.put((byte) 7);
        r107.putShort(1);
        r107.putShort(1);
        r107.putInt(0);
        r107.putInt(0);
        r107.putLong(r132);
        r107.put((byte) 2);
        r107.put((byte) 0);
        r107.put(r114);
        r107.position(r107.position() + 22);
        r107.flip();
    L31:
        if (r108 == null) goto L37;
        r108.order(ByteOrder.LITTLE_ENDIAN);
        long r133 = r311.f462911b;
        long r134 = r311.f462913d;
        r108.putInt(24);
        r108.putShort(1);
        r108.position(r108.position() + 2);
        r108.putLong(r133);
        r108.putLong(r109);
        r108.putInt(20);
        r108.putShort(2);
        r108.position(r108.position() + 2);
        r108.putLong(r134 + 16);
        int r135 = (int) r133;
        if (r135 != r133) goto L36;
        r108.putInt(r135);
        r108.position(r108.position() + 4);
        r108.flip();
        goto L37
    L36:
        throw new ArithmeticException("integer overflow");
    L37:
        r103.position(r106 + r108.limit());
        r103.putInt((r108.limit() + 64) + 4);
        r103.flip();
        return new a(r110);
    L40:
        throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (r311.f462912c - r311.f462911b));
    L42:
        throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + r311.f462911b);
    }

    public static ByteBuffer d(ByteBuffer r100, int r101, int r102) {
        ByteBuffer r103 = r100.duplicate();
        r103.position(0);
        r103.limit(r102);
        r103.position(r101);
        return r103.slice();
    }
}
