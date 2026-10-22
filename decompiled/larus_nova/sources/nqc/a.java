package nqc;

import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f520154a = "";

    public static ByteBuffer b(PolarisFileWrapper r100) throws Exception {
        RandomAccessFile r101 = null;
        Pair<ByteBuffer, Long> r102 = null;
        RandomAccessFile r103 = new RandomAccessFile(r100, "r");     // Catch: Throwable -> L28
        boolean r104 = false;
        if (r103.length() < 22) goto L11;
        r102 = b.b(r103, 0);     // Catch: Throwable -> L26
        if (r102 != null) goto L11;
        r102 = b.b(r103, 65535);     // Catch: Throwable -> L26
    L11:
        if (r102 == null) goto L25;
        ByteBuffer r105 = (ByteBuffer) r102.first;     // Catch: Throwable -> L26
        long r106 = ((Long) r102.second).longValue();     // Catch: Throwable -> L26
        long r107 = r106 - 20;     // Catch: Throwable -> L26
        if (r107 < 0) goto L18;
        r103.seek(r107);     // Catch: Throwable -> L26
        if (r103.readInt() != 1347094023) goto L18;
        r104 = true;
    L18:
        if (r104 == true) goto L23;
        ByteBuffer r108 = (ByteBuffer) a(r103, c(r105, r106)).first;     // Catch: Throwable -> L26
        r103.close();
        return r108;
    L23:
        throw new Exception("ZIP64 APK not supported");     // Catch: Throwable -> L26
    L25:
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");     // Catch: Throwable -> L26
    L26:
        th = th;
        r101 = r103;
    L29:
        if (r101 == null) goto L31;
        r101.close();
    L31:
        throw th;
    L28:
        th = th;
        goto L29
    }

    public static boolean d(ByteBuffer r110) throws Exception {
        if (r110.order() != ByteOrder.LITTLE_ENDIAN) goto L45;
        int r100 = r110.capacity() - 24;
        if (r100 < 8) goto L43;
        int r101 = r110.capacity();
        if (r100 > r110.capacity()) goto L41;
        int r102 = r110.limit();
        int r103 = r110.position();
        r110.position(0);     // Catch: Throwable -> L37
        r110.limit(r100);     // Catch: Throwable -> L37
        r110.position(8);     // Catch: Throwable -> L37
        ByteBuffer r104 = r110.slice();     // Catch: Throwable -> L37
        r104.order(r110.order());     // Catch: Throwable -> L37
        r110.position(0);
        r110.limit(r102);
        r110.position(r103);
        int r111 = 0;
    L12:
        if (r104.hasRemaining() == false) goto L36;
        r111 = r111 + 1;
        if (r104.remaining() < 8) goto L35;
        long r105 = r104.getLong();
        if (r105 < 4) goto L33;
        if (r105 > SieveCacheKt.NodeLinkMask) goto L33;
        int r106 = (int) r105;
        int r107 = r104.position() + r106;
        if (r106 > r104.remaining()) goto L31;
        int r108 = r104.getInt();
        if (r108 == (-262969152)) goto L23;
        if (r108 == 1896449818) goto L27;
        r104.position(r107);
        goto L12
    L27:
        f520154a = "V2";
        return true;
    L23:
        f520154a = "V3";
        return true;
    L31:
        throw new Exception("APK Signing Block entry #" + r111 + " size out of range: " + r106 + ", available: " + r104.remaining());
    L33:
        throw new Exception("APK Signing Block entry #" + r111 + " size out of range: " + r105);
    L35:
        throw new Exception("Insufficient data to read size of APK Signing Block entry #" + r111);
    L36:
        return false;
    L37:
        th = move-exception;
        r110.position(0);
        r110.limit(r102);
        r110.position(r103);
        throw th;
    L41:
        throw new IllegalArgumentException("end > capacity: " + r100 + " > " + r101);
    L43:
        throw new IllegalArgumentException("end < start: " + r100 + " < 8");
    L45:
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile r100, long r101) throws Exception {
        if (r101 < 32) goto L27;
        ByteBuffer r102 = ByteBuffer.allocate(24);
        ByteOrder r103 = ByteOrder.LITTLE_ENDIAN;
        r102.order(r103);
        r100.seek(r101 - ((long) r102.capacity()));
        r100.readFully(r102.array(), r102.arrayOffset(), r102.capacity());
        if (r102.getLong(8) != 2334950737559900225L) goto L25;
        if (r102.getLong(16) != 3617552046287187010L) goto L25;
        long r104 = r102.getLong(0);
        if (r104 < r102.capacity()) goto L23;
        if (r104 > 2147483639) goto L23;
        int r105 = (int) (8 + r104);
        long r106 = r101 - ((long) r105);
        if (r106 < 0) goto L21;
        ByteBuffer r107 = ByteBuffer.allocate(r105);
        r107.order(r103);
        r100.seek(r106);
        r100.readFully(r107.array(), r107.arrayOffset(), r107.capacity());
        long r108 = r107.getLong(0);
        if (r108 != r104) goto L19;
        return Pair.create(r107, Long.valueOf(r106));
    L19:
        throw new Exception("APK Signing Block sizes in header and footer do not match: " + r108 + " vs " + r104);
    L21:
        throw new Exception("APK Signing Block offset out of range: " + r106);
    L23:
        throw new Exception("APK Signing Block size out of range: " + r104);
    L25:
        throw new Exception("No APK Signing Block before ZIP Central Directory");
    L27:
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: " + r101);
    }

    public static long c(ByteBuffer r100, long r101) throws Exception {
        b.a(r100);
        long r102 = ((long) r100.getInt(r100.position() + 16)) & BodyPartID.bodyIdMax;
        if (r102 > r101) goto L10;
        b.a(r100);
        if (((BodyPartID.bodyIdMax & ((long) r100.getInt(r100.position() + 12))) + r102) != r101) goto L8;
        return r102;
    L8:
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    L10:
        throw new Exception("ZIP Central Directory offset out of range: " + r102 + ". ZIP End of Central Directory offset: " + r101);
    }
}
