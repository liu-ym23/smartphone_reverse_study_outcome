package fv7;

import androidx.collection.SieveCacheKt;
import com.google.archivepatcher.applier.PatchFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;
import jv7.c;
import jv7.i;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f478964a = 0;

    public b() {
    }

    static {
        Logger.getLogger(b.class.getName());
    }

    public static final long b(InputStream r100) throws PatchFormatException, IOException {
        int r101 = 0;
        long r102 = 0;
    L4:
        if (r101 >= 64) goto L7;
        r102 = r102 | (((long) r100.read()) << r101);
        r101 = r101 + 8;
        goto L4
    L7:
        if (r102 == Long.MIN_VALUE) goto L13;
        if ((Long.MIN_VALUE & r102) != 0) goto L11;
        return r102;
    L11:
        return -(Long.MAX_VALUE & r102);
    L13:
        throw new PatchFormatException("read negative zero");
    }

    public static void a(jv7.b r210, OutputStream r211, InputStream r310) throws PatchFormatException, IOException {
        byte[] r100 = new byte[16];
        c.b(r310, r100, 16);     // Catch: IOException -> L81
        String r101 = new String(r100, 0, 16, "US-ASCII");
        if ("ENDSLEY/BSDIFF43".equals(r101) == false) goto L80;
        long r102 = r210.b();
        long r103 = SieveCacheKt.NodeLinkMask;
        if (r102 > SieveCacheKt.NodeLinkMask) goto L78;
        long r104 = b(r310);
        long r105 = 0;
        if (r104 < 0) goto L76;
        if (r104 > SieveCacheKt.NodeLinkMask) goto L76;
        byte[] r110 = new byte[49152];
        byte[] r111 = new byte[49152];
        long r112 = 0;
        long r113 = 0;
    L14:
        if (r112 >= r104) goto L74;
        byte[] r212 = r110;
        long r114 = b(r310);
        long r213 = r104;
        long r106 = b(r310);
        long r115 = b(r310);
        if (r114 < r105) goto L73;
        if (r114 > r103) goto L73;
        if (r106 < r105) goto L71;
        if (r106 > r103) goto L71;
        if (r115 < SieveCacheKt.NodeMetaAndPreviousMask) goto L69;
        if (r115 > r103) goto L69;
        r112 = (r112 + r114) + r106;
        if (r112 > r213) goto L67;
        long r214 = (r113 + r114) + r115;
        if (r214 > r102) goto L65;
        if (r214 < r105) goto L63;
        InputStream r107 = new i(r210, r113, Math.max(r210.b() - r113, r105)).c();
        if (r114 <= r105) goto L54;
        int r108 = (int) r114;
    L36:
        if (r108 <= 0) goto L54;
        int r116 = Math.min(r108, 49152);     // Catch: Throwable -> L43
        byte[] r109 = r212;
        c.b(r107, r109, r116);     // Catch: Throwable -> L43
        c.b(r310, r111, r116);     // Catch: Throwable -> L43
        int r117 = 0;
    L39:
        if (r117 >= r116) goto L41;
        r109[r117] = (byte) (r109[r117] + r111[r117]);     // Catch: Throwable -> L43
        r117 = r117 + 1;     // Catch: Throwable -> L43
        goto L39
    L41:
        r211.write(r109, 0, r116);     // Catch: Throwable -> L43
        r108 = r108 - r116;
        r212 = r109;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        if (r107 == null) goto L106;
        r107.close();     // Catch: Throwable -> L51
        throw th;
    L51:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L106:
        throw th;
    L54:
        byte[] r118 = r212;
        if (r107 == null) goto L57;
        r107.close();
    L57:
        if (r106 <= r105) goto L61;
        int r119 = (int) r106;
    L59:
        if (r119 <= 0) goto L61;
        int r120 = Math.min(49152, r119);
        c.b(r310, r118, r120);
        r211.write(r118, 0, r120);
        r119 = r119 - r120;
    L61:
        r110 = r118;
        r104 = r213;
        r113 = r214;
        r103 = SieveCacheKt.NodeLinkMask;
        r105 = 0;
        goto L14
    L63:
        throw new PatchFormatException("expectedFinalOldDataOffset is negative");
    L65:
        throw new PatchFormatException("expectedFinalOldDataOffset too large");
    L67:
        throw new PatchFormatException("expectedFinalNewDataBytesWritten too large");
    L69:
        throw new PatchFormatException("bad offsetToNextInput");
    L71:
        throw new PatchFormatException("bad copySegmentLength");
    L73:
        throw new PatchFormatException("bad diffSegmentLength");
    L74:
        return;
    L76:
        throw new PatchFormatException("bad newSize");
    L78:
        throw new PatchFormatException("bad oldSize");
    L80:
        throw new PatchFormatException(String.format("bad signature: found %s should've been %s", new Object[]{r101, "ENDSLEY/BSDIFF43"}));
    L81:
        e = move-exception;
        throw new PatchFormatException("truncated signature", e);
    }
}
