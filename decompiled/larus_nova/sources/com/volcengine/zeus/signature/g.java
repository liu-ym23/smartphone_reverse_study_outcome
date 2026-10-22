package com.volcengine.zeus.signature;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.collection.SieveCacheKt;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.bytedance.crypto.utils.CryptoConst;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, SparseArray<m>> f462897a = null;

    public static class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageDigest[] f462898a;

        public a(MessageDigest[] r100) {
            this.f462898a = r100;
        }

        @Override // com.volcengine.zeus.signature.j
        public final void consume(ByteBuffer r100) {
            ByteBuffer r101 = r100.slice();
            MessageDigest[] r102 = this.f462898a;
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L5;
            MessageDigest r105 = r102[r104];
            r101.position(0);
            r105.update(r101);
            r104 = r104 + 1;
            goto L3
        }
    }

    static {
        f462897a = new HashMap();
    }

    public static String e(int r100) {
        if (r100 != 1) goto L5;
        return "SHA-256";
    L5:
        if (r100 != 2) goto L7;
        return "SHA-512";
    L7:
        if (r100 != 3) goto L10;
        return "SHA-256";
    L10:
        throw new IllegalArgumentException("Unknown content digest algorthm: " + r100);
    }

    public static int f(int r100) {
        if (r100 != 1) goto L5;
        return 32;
    L5:
        if (r100 != 2) goto L7;
        return 64;
    L7:
        if (r100 != 3) goto L10;
        return 32;
    L10:
        throw new IllegalArgumentException("Unknown content digest algorthm: " + r100);
    }

    public static ByteBuffer g(ByteBuffer r100) throws IOException {
        if (r100.remaining() < 4) goto L15;
        int r101 = r100.getInt();
        if (r101 < 0) goto L13;
        if (r101 > r100.remaining()) goto L11;
        return d(r100, r101);
    L11:
        throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + r101 + ", remaining: " + r100.remaining());
    L13:
        throw new IllegalArgumentException("Negative length");
    L15:
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + r100.remaining());
    }

    public static int h(int r100) {
        if (r100 != 513) goto L5;
        return 1;
    L5:
        if (r100 != 514) goto L7;
        return 2;
    L7:
        if (r100 != 769) goto L9;
        return 1;
    L9:
        if (r100 != 1057) goto L11;
        return 3;
    L11:
        if (r100 != 1059) goto L13;
        return 3;
    L13:
        if (r100 == 1061) goto L24;
        switch(r100) {
            case 257: goto L27;
            case 258: goto L25;
            case 259: goto L27;
            case 260: goto L25;
            default: goto L16;
        };
    L25:
        return 2;
    L27:
        return 1;
    L16:
        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(r100 & (-1)));
    L24:
        return 3;
    }

    public static String i(int r100) {
        if (r100 != 513) goto L5;
        return CryptoConst.ALGORITHM_EC;
    L5:
        if (r100 != 514) goto L7;
        return CryptoConst.ALGORITHM_EC;
    L7:
        if (r100 != 769) goto L9;
        return "DSA";
    L9:
        if (r100 != 1057) goto L11;
        return com.alipay.sdk.m.n.d.f25615a;
    L11:
        if (r100 != 1059) goto L13;
        return CryptoConst.ALGORITHM_EC;
    L13:
        if (r100 == 1061) goto L24;
        switch(r100) {
            case 257: goto L23;
            case 258: goto L23;
            case 259: goto L23;
            case 260: goto L23;
            default: goto L16;
        };
    L23:
        return com.alipay.sdk.m.n.d.f25615a;
    L16:
        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(r100 & (-1)));
    L24:
        return "DSA";
    }

    public static Pair<String, ? extends AlgorithmParameterSpec> j(int r100) {
        if (r100 == 513) goto L30;
        if (r100 == 514) goto L28;
        if (r100 == 769) goto L26;
        if (r100 == 1057) goto L24;
        if (r100 == 1059) goto L30;
        if (r100 == 1061) goto L26;
        switch(r100) {
            case 257: goto L22;
            case 258: goto L20;
            case 259: goto L24;
            case 260: goto L18;
            default: goto L16;
        };
    L16:
        throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(r100 & (-1)));
    L18:
        return Pair.create("SHA512withRSA", null);
    L20:
        return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
    L22:
        return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
    L24:
        return Pair.create(RSAUtil.SIGNATURE_ALGORITHM, null);
    L26:
        return Pair.create("SHA256withDSA", null);
    L28:
        return Pair.create("SHA512withECDSA", null);
    L30:
        return Pair.create("SHA256withECDSA", null);
    }

    public static byte[] l(ByteBuffer r100) throws IOException {
        int r101 = r100.getInt();
        if (r101 < 0) goto L11;
        if (r101 > r100.remaining()) goto L9;
        byte[] r102 = new byte[r101];
        r100.get(r102);
        return r102;
    L9:
        throw new IOException("Underflow while reading length-prefixed value. Length: " + r101 + ", available: " + r100.remaining());
    L11:
        throw new IOException("Negative length");
    }

    public static int a(int r100, int r101) {
        int r102 = h(r100);
        int r103 = h(r101);
        if (r102 == 1) goto L21;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L13;
        if (r103 == 1) goto L20;
        if (r103 == 2) goto L29;
        if (r103 != 3) goto L11;
    L27:
        return 0;
    L11:
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + r103);
    L29:
        return -1;
    L20:
        return 1;
    L13:
        throw new IllegalArgumentException("Unknown digestAlgorithm1: " + r102);
    L14:
        if (r103 == 1) goto L20;
        if (r103 == 2) goto L27;
        if (r103 == 3) goto L20;
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + r103);
    L21:
        if (r103 == 1) goto L27;
        if (r103 == 2) goto L31;
        if (r103 != 3) goto L26;
        return -1;
    L26:
        throw new IllegalArgumentException("Unknown digestAlgorithm2: " + r103);
    L31:
        return -1;
    }

    public static byte[][] b(int[] r210, k[] r211) throws DigestException {
        k[] r100 = r211;
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
        long r104 = 0;
        int r105 = 0;
    L4:
        if (r105 >= r101) goto L7;
        r104 = r104 + (((r100[r105].size() + 1048576) - 1) / 1048576);
        r105 = r105 + 1;
        goto L4
    L7:
        if (r104 >= 2097151) goto L54;
        int r106 = (int) r104;
        byte[][] r107 = new byte[r210.length][];
        int r108 = 0;
    L10:
        if (r108 >= r210.length) goto L12;
        byte[] r109 = new byte[(f(r210[r108]) * r106) + 5];
        r109[0] = 90;
        m(r106, r109);
        r107[r108] = r109;
        r108 = r108 + 1;
        goto L10
    L12:
        byte[] r110 = new byte[5];
        r110[0] = -91;
        int r111 = r210.length;
        MessageDigest[] r112 = new MessageDigest[r111];
        int r113 = 0;
    L13:
        String r114 = " digest not supported";
        if (r113 >= r210.length) goto L21;
        String r115 = e(r210[r113]);
        r112[r113] = MessageDigest.getInstance(r115);     // Catch: NoSuchAlgorithmException -> L18
        r113 = r113 + 1;
    L18:
        e = move-exception;
        throw new RuntimeException(r115.concat(" digest not supported"), e);
    L21:
        a r116 = new a(r112);
        int r117 = r100.length;
        int r118 = 0;
        int r119 = 0;
    L22:
        if (r118 >= r117) goto L43;
        k r120 = r100[r118];
        int r212 = r117;
        int r213 = r119;
        long r121 = r120.size();
        String r122 = r114;
        long r123 = r102;
    L25:
        if (r121 <= r102) goto L42;
        int r124 = r103;
        byte[][] r125 = r107;
        int r126 = (int) Math.min(r121, 1048576);
        m(r126, r110);
        int r127 = 0;
    L27:
        if (r127 >= r111) goto L59;
        r112[r127].update(r110);
        r127 = r127 + 1;
        goto L27
    L59:
        r120.a(r116, r123, r126);     // Catch: IOException -> L39
        int r128 = 0;
    L32:
        if (r128 >= r210.length) goto L38;
        int r129 = r210[r128];
        byte[] r130 = r125[r128];
        int r131 = f(r129);
        MessageDigest r132 = r112[r128];
        byte[] r214 = r110;
        int r133 = r213;
        int r215 = r111;
        int r134 = r132.digest(r130, (r133 * r131) + 5, r131);
        if (r134 != r131) goto L37;
        r128 = r128 + 1;
        r213 = r133;
        r110 = r214;
        r111 = r215;
        goto L32
    L37:
        throw new RuntimeException("Unexpected output size of " + r132.getAlgorithm() + " digest: " + r134);
    L38:
        long r135 = r126;
        r123 = r123 + r135;
        r121 = r121 - r135;
        r213 = r213 + 1;
        r107 = r125;
        r103 = r124;
        r110 = r110;
        r102 = 0;
    L39:
        e = move-exception;
        throw new DigestException("Failed to digest chunk #" + r213 + " of section #" + r124, e);
    L42:
        r103 = r103 + 1;
        r118 = r118 + 1;
        r100 = r211;
        r114 = r122;
        r117 = r212;
        r102 = 0;
        r119 = r213;
        r110 = r110;
        goto L22
    L43:
        byte[][] r136 = r107;
        String r137 = r114;
        byte[][] r138 = new byte[r210.length][];
        int r139 = 0;
    L45:
        if (r139 >= r210.length) goto L52;
        int r140 = r210[r139];
        byte[] r141 = r136[r139];
        String r142 = e(r140);
        r138[r139] = MessageDigest.getInstance(r142).digest(r141);
        r139 = r139 + 1;
    L49:
        e = move-exception;
        throw new RuntimeException(r142.concat(r137), e);
    L52:
        return r138;
    L54:
        throw new DigestException("Too many chunks: " + r104);
    }

    public static ByteBuffer d(ByteBuffer r100, int r101) throws BufferUnderflowException {
        if (r101 < 0) goto L16;
        int r102 = r100.limit();
        int r103 = r100.position();
        int r104 = r101 + r103;
        if (r104 < r103) goto L14;
        if (r104 > r102) goto L14;
        r100.limit(r104);
        ByteBuffer r105 = r100.slice();     // Catch: Throwable -> L10
        r105.order(r100.order());     // Catch: Throwable -> L10
        r100.position(r104);     // Catch: Throwable -> L10
        r100.limit(r102);
        return r105;
    L10:
        th = move-exception;
        r100.limit(r102);
        throw th;
    L14:
        throw new BufferUnderflowException();
    L16:
        throw new IllegalArgumentException("size: " + r101);
    }

    public static void m(int r100, byte[] r101) {
        r101[1] = (byte) (r100 & 255);
        r101[2] = (byte) ((r100 >>> 8) & 255);
        r101[3] = (byte) ((r100 >>> 16) & 255);
        r101[4] = (byte) ((r100 >>> 24) & 255);
    }

    public static void c(String r210, RandomAccessFile r211, int... r212) throws SignatureNotFoundException, IOException {
        f462897a.put(r210, new SparseArray());
        int r100 = 0;
        if (r211.length() >= 22) goto L5;
        Pair<ByteBuffer, Long> r101 = null;
    L9:
        if (r101 == null) goto L95;
        ByteBuffer r102 = (ByteBuffer) r101.first;
        long r103 = ((Long) r101.second).longValue();
        long r104 = r103 - 20;
        if (r104 < 0) goto L16;
        r211.seek(r104);
        if (r211.readInt() != 1347094023) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == true) goto L93;
        n.a(r102);
        long r110 = ((long) r102.getInt(r102.position() + 16)) & BodyPartID.bodyIdMax;
        if (r110 > r103) goto L91;
        n.a(r102);
        if (((((long) r102.getInt(r102.position() + 12)) & BodyPartID.bodyIdMax) + r110) != r103) goto L89;
        if (r110 < 32) goto L87;
        ByteBuffer r111 = ByteBuffer.allocate(24);
        ByteOrder r112 = ByteOrder.LITTLE_ENDIAN;
        r111.order(r112);
        r211.seek(r110 - ((long) r111.capacity()));
        r211.readFully(r111.array(), r111.arrayOffset(), r111.capacity());
        int r106 = 8;
        if (r111.getLong(8) == 2334950737559900225L) goto L27;
    L44:
        Pair r113 = null;
    L45:
        if (r113 != null) goto L47;
        return;
    L47:
        ByteBuffer r107 = (ByteBuffer) r113.first;
        long r108 = ((Long) r113.second).longValue();
        if (r107.order() != r112) goto L85;
        int r109 = r107.capacity() - 24;
        if (r109 < 8) goto L83;
        int r114 = r107.capacity();
        if (r109 > r107.capacity()) goto L81;
        int r115 = r107.limit();
        int r116 = r107.position();
        r107.position(0);     // Catch: Throwable -> L77
        r107.limit(r109);     // Catch: Throwable -> L77
        r107.position(8);     // Catch: Throwable -> L77
        ByteBuffer r117 = r107.slice();     // Catch: Throwable -> L77
        r117.order(r107.order());     // Catch: Throwable -> L77
        r107.position(0);
        r107.limit(r115);
        r107.position(r116);
        HashSet r118 = new HashSet();
        int r119 = r212.length;
    L56:
        if (r100 >= r119) goto L59;
        r118.add(Integer.valueOf(r212[r100]));
        r100 = r100 + 1;
    L59:
        if (r117.hasRemaining() == false) goto L107;
        if (r117.remaining() < r106) goto L62;
        long r120 = r117.getLong();
        if (r120 < 4) goto L76;
        if (r120 > SieveCacheKt.NodeLinkMask) goto L106;
        int r121 = (int) r120;
        int r122 = r117.position() + r121;
        if (r121 > r117.remaining()) goto L70;
        int r123 = r117.getInt();
        if (r118.contains(Integer.valueOf(r123)) == false) goto L74;
        long r213 = r110;
        f462897a.get(r210).put(r123, new m(d(r117, r121 - 4), r108, r213, r103, r102));
    L75:
        r117.position(r122);
        r110 = r213;
        r106 = 8;
        goto L59
    L74:
        r213 = r110;
        goto L75
    L70:
        return;
    L106:
        return;
    L76:
        return;
    L62:
        return;
    L107:
        return;
    L77:
        th = move-exception;
        r107.position(0);
        r107.limit(r115);
        r107.position(r116);
        throw th;
    L81:
        throw new IllegalArgumentException("end > capacity: " + r109 + " > " + r114);
    L83:
        throw new IllegalArgumentException("end < start: " + r109 + " < 8");
    L85:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    L27:
        if (r111.getLong(16) != 3617552046287187010L) goto L44;
        long r124 = r111.getLong(0);
        if (r124 < r111.capacity()) goto L43;
        if (r124 > 2147483639) goto L43;
        int r125 = (int) (8 + r124);
        long r126 = r110 - ((long) r125);
        if (r126 < 0) goto L41;
        ByteBuffer r127 = ByteBuffer.allocate(r125);
        r127.order(r112);
        r211.seek(r126);
        r211.readFully(r127.array(), r127.arrayOffset(), r127.capacity());
        long r128 = r127.getLong(0);
        if (r128 != r124) goto L39;
        r113 = Pair.create(r127, Long.valueOf(r126));
        goto L45
    L39:
        throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + r128 + " vs " + r124);
    L41:
        throw new SignatureNotFoundException("APK Signing Block offset out of range: " + r126);
    L43:
        throw new SignatureNotFoundException("APK Signing Block size out of range: " + r124);
    L87:
        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + r110);
    L89:
        throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
    L91:
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + r110 + ". ZIP End of Central Directory offset: " + r103);
    L93:
        throw new SignatureNotFoundException("ZIP64 APK not supported");
    L16:
        r105 = false;
        goto L17
    L95:
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    L5:
        r101 = n.b(r211, 0);
        if (r101 != null) goto L9;
        r101 = n.b(r211, 65535);
        goto L9
    }

    public static byte[] k(byte[] r100, long r101, m r110) throws SecurityException {
        if (r100.length != 40) goto L11;
        ByteBuffer r102 = ByteBuffer.wrap(r100).order(ByteOrder.LITTLE_ENDIAN);
        r102.position(32);
        if (r102.getLong() != (r101 - (r110.f462912c - r110.f462911b))) goto L9;
        return Arrays.copyOfRange(r100, 0, 32);
    L9:
        throw new SecurityException("APK content size did not verify");
    L11:
        throw new SecurityException("Verity digest size is wrong: " + r100.length);
    }

    public static void n(Map<Integer, byte[]> r100, RandomAccessFile r101, m r102) throws SecurityException {
        ArrayMap r103 = (ArrayMap) r100;
        if (r103.isEmpty() == true) goto L38;
        ArrayMap r104 = new ArrayMap();
        boolean r105 = true;
        if (r103.containsKey(1) == false) goto L8;
        r104.put(1, r103.get(1));
    L8:
        if (r103.containsKey(2) == false) goto L10;
        r104.put(2, r103.get(2));
    L10:
        boolean r106 = false;
        if (r104.isEmpty() == true) goto L18;
        o(r104, r101.getFD(), r102);     // Catch: IOException -> L14
        r105 = false;
    L14:
        e = move-exception;
        throw new SecurityException("Cannot get FD", e);
    L18:
        if (r103.containsKey(3) == false) goto L32;
        byte[] r107 = (byte[]) r103.get(3);
    L29:
        e = move-exception;
        throw new SecurityException("Error during verification", e);
    L21:
        if (Arrays.equals(k(r107, r101.length(), r102), h.c(r101, r102, new f()).f462899a) == false) goto L24;
    L33:
        if (r106 == true) goto L36;
        return;
    L36:
        throw new SecurityException("No known digest exists for integrity check");
    L24:
        throw new SecurityException("APK verity digest of contents did not verify");     // Catch: NoSuchAlgorithmException -> L25 IOException -> L27 Throwable -> L29
    L32:
        r106 = r105;
        goto L33
    L38:
        throw new SecurityException("No digests provided");
    }

    public static void o(Map<Integer, byte[]> r110, FileDescriptor r111, m r112) throws SecurityException {
        l r100 = new l(r111, 0, r112.f462911b);
        long r101 = r112.f462912c;
        l r102 = new l(r111, r101, r112.f462913d - r101);
        ByteBuffer r113 = r112.f462914e.duplicate();
        r113.order(ByteOrder.LITTLE_ENDIAN);
        long r103 = r112.f462911b;
        n.a(r113);
        int r114 = r113.position() + 16;
        if (r103 < 0) goto L23;
        if (r103 > BodyPartID.bodyIdMax) goto L23;
        r113.putInt(r113.position() + r114, (int) r103);
        i r115 = new i(r113);
        ArrayMap r116 = (ArrayMap) r110;
        int r117 = r116.size();
        int[] r104 = new int[r117];
        Iterator r105 = r116.keySet().iterator();
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r105.hasNext() == false) goto L24;
        r104[r107] = ((Integer) r105.next()).intValue();
        r107 = r107 + 1;
        goto L8
    L24:
        byte[][] r118 = b(r104, new k[]{r100, r102, r115});     // Catch: DigestException -> L19
    L12:
        if (r106 >= r117) goto L18;
        int r108 = r104[r106];
        if (MessageDigest.isEqual((byte[]) r116.get(Integer.valueOf(r108)), r118[r106]) == false) goto L17;
        r106 = r106 + 1;
        goto L12
    L17:
        throw new SecurityException(e(r108).concat(" digest of contents did not verify"));
    L18:
        return;
    L19:
        e = move-exception;
        throw new SecurityException("Failed to compute digest(s) of contents", e);
    L23:
        throw new IllegalArgumentException("uint32 value of out range: " + r103);
    }
}
