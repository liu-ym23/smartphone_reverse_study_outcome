package com.larus.utils;

import android.text.TextUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ApkUtil {

    public static final class a<A, B> {
        public final A a;
        public final B b;

        public final int hashCode() {
            A r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r2 + 31) * 31;
            B r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (a.class == r5.getClass()) goto L11;
            return false;
        L11:
            a r6 = (a) r5;
            A r2 = this.a;
            if (r2 != null) goto L17;
            if (r6.a == null) goto L19;
            return false;
        L19:
            B r3 = this.b;
            if (r3 != null) goto L25;
            if (r6.b == null) goto L27;
            return false;
        L27:
            return true;
        L25:
            if (r3.equals(r6.b) == true) goto L27;
            return false;
        L17:
            if (r2.equals(r6.a) == true) goto L19;
            return false;
        }

        public a(A r1, B r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static a<ByteBuffer, Long> a(FileChannel r13) throws IOException, SignatureNotFoundException {
        long r0 = r13.size();
        if (r0 < 22) goto L41;
        long r1 = r0 - 22;
        long r2 = Math.min(r1, 65535);
        int r5 = 0;
    L5:
        long r6 = r5;
        if (r6 > r2) goto L39;
        long r7 = r1 - r6;
        ByteBuffer r9 = ByteBuffer.allocate(4);
        r13.position(r7);
        r13.read(r9);
        ByteOrder r10 = ByteOrder.LITTLE_ENDIAN;
        r9.order(r10);
        if (r9.getInt(0) != 101010256) goto L37;
        ByteBuffer r11 = ByteBuffer.allocate(2);
        r13.position(r7 + 20);
        r13.read(r11);
        r11.order(r10);
        short r8 = r11.getShort(0);
        if (r8 != r5) goto L37;
        ByteBuffer r3 = ByteBuffer.allocate(4);
        r3.order(r10);
        r13.position((r13.size() - ((long) r8)) - 6);
        r13.read(r3);
        long r4 = r3.getInt(0);
        if (r4 < 32) goto L36;
        r13.position(r4 - 24);
        ByteBuffer r12 = ByteBuffer.allocate(24);
        r13.read(r12);
        r12.order(r10);
        if (r12.getLong(8) != 2334950737559900225L) goto L34;
        if (r12.getLong(16) != 3617552046287187010L) goto L34;
        long r14 = r12.getLong(0);
        if (r14 < r12.capacity()) goto L32;
        if (r14 > 2147483639) goto L32;
        int r15 = (int) (8 + r14);
        long r16 = r4 - ((long) r15);
        if (r16 < 0) goto L30;
        r13.position(r16);
        ByteBuffer r17 = ByteBuffer.allocate(r15);
        r13.read(r17);
        r17.order(r10);
        long r18 = r17.getLong(0);
        if (r18 != r14) goto L28;
        return new a(r17, Long.valueOf(r16));
    L28:
        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + r18 + " vs " + r14);
    L30:
        throw new SignatureNotFoundException("APK Signing Block offset out of range: " + r16);
    L32:
        throw new SignatureNotFoundException("APK Signing Block size out of range: " + r14);
    L34:
        throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
    L36:
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + r4);
    L37:
        r5 = r5 + 1;
        goto L5
    L39:
        throw new IOException("ZIP End of Central Directory (EOCD) record not found");
    L41:
        throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
    }

    public static String b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L34;
        return null;
    L34:
        RandomAccessFile r0 = new RandomAccessFile(r6, "r");     // Catch: Throwable -> L13
        Map<Integer, ByteBuffer> r7 = c(a(r0.getChannel()).a);     // Catch: Throwable -> L11
        if (r7.containsKey(1903654775) == false) goto L26;
        ByteBuffer r8 = (ByteBuffer) ((LinkedHashMap) r7).get(1903654775);     // Catch: Throwable -> L11
        byte[] r2 = r8.array();     // Catch: Throwable -> L11
        int r4 = r8.arrayOffset();     // Catch: Throwable -> L11
        String r3 = new String(Arrays.copyOfRange(r2, r8.position() + r4, r4 + r8.limit()));     // Catch: Throwable -> L11
        r0.close();     // Catch: Throwable -> L23
    L10:
        return r3;
    L26:
        r0.close();     // Catch: Throwable -> L24
    L18:
        return null;
    L11:
        th = th;
    L28:
        th.printStackTrace();     // Catch: Throwable -> L19
        if (r0 == null) goto L18;
    L19:
        th = move-exception;
        if (r0 != null) goto L36;
    L22:
        throw th;
    L36:
        r0.close();     // Catch: Throwable -> L25
    L13:
        th = th;
        r0 = null;
        goto L28
    }

    public static Map<Integer, ByteBuffer> c(ByteBuffer r10) throws SignatureNotFoundException {
        if (r10.order() != ByteOrder.LITTLE_ENDIAN) goto L51;
        int r0 = r10.capacity() - 24;
        if (r0 < 8) goto L49;
        int r2 = r10.capacity();
        if (r0 > r10.capacity()) goto L47;
        int r3 = r10.limit();
        int r4 = r10.position();
        int r5 = 0;
        r10.position(0);     // Catch: Throwable -> L43
        r10.limit(r0);     // Catch: Throwable -> L43
        r10.position(8);     // Catch: Throwable -> L43
        ByteBuffer r1 = r10.slice();     // Catch: Throwable -> L43
        r1.order(r10.order());     // Catch: Throwable -> L43
        r10.position(0);
        r10.limit(r3);
        r10.position(r4);
        LinkedHashMap r11 = new LinkedHashMap();
    L12:
        if (r1.hasRemaining() == false) goto L42;
        r5 = r5 + 1;
        if (r1.remaining() < 8) goto L41;
        long r6 = r1.getLong();
        if (r6 < 4) goto L39;
        if (r6 > 2147483647L) goto L39;
        int r7 = (int) r6;
        int r8 = r1.position() + r7;
        if (r7 > r1.remaining()) goto L37;
        Integer r9 = Integer.valueOf(r1.getInt());
        int r12 = r7 - 4;
        if (r12 < 0) goto L35;
        int r13 = r1.limit();
        int r14 = r1.position();
        int r15 = r12 + r14;
        if (r15 < r14) goto L33;
        if (r15 > r13) goto L33;
        r1.limit(r15);
        ByteBuffer r16 = r1.slice();     // Catch: Throwable -> L29
        r16.order(r1.order());     // Catch: Throwable -> L29
        r1.position(r15);     // Catch: Throwable -> L29
        r1.limit(r13);
        r11.put(r9, r16);
        r1.position(r8);
    L29:
        th = move-exception;
        r1.limit(r13);
        throw th;
    L33:
        throw new BufferUnderflowException();
    L35:
        throw new IllegalArgumentException("size: " + r12);
    L37:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r5 + " size out of range: " + r7 + ", available: " + r1.remaining());
    L39:
        throw new SignatureNotFoundException("APK Signing Block entry #" + r5 + " size out of range: " + r6);
    L41:
        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + r5);
    L42:
        return r11;
    L43:
        th = move-exception;
        r10.position(0);
        r10.limit(r3);
        r10.position(r4);
        throw th;
    L47:
        throw new IllegalArgumentException("end > capacity: " + r0 + " > " + r2);
    L49:
        throw new IllegalArgumentException("end < start: " + r0 + " < 8");
    L51:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }
}
