package com.bytedance.common.network;

import com.bytedance.push.utils.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
public class StreamParser {
    public static void safeClose(Closeable r100) {
        safeClose(r100, null);
    }

    public static boolean testIsSSBinary(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.indexOf("application/octet-stream");
        if (r101 < 0) goto L8;
        r101 = r100.indexOf("ssmix=", r101 + 24);
    L8:
        if (r101 <= 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static void decodeSSBinary(byte[] r100, int r101) throws IOException {
        if (r100 == null) goto L8;
        if (r101 <= 0) goto L10;
        byte[] r102 = {-99, -114, ByteCompanionObject.MAX_VALUE, 90};
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L11;
        r100[r103] = (byte) (r100[r103] ^ r102[r103 % 4]);
        r103 = r103 + 1;
        goto L6
    L11:
        return;
    L10:
        return;
    }

    private static void safeClose(Closeable r100, String r101) {
        if (r100 == null) goto L13;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if (f.f267065a == false) goto L14;
        if (r101 == null) goto L15;
        f.b("NetworkUtils", r101 + " " + e);
        return;
    L15:
        return;
    L14:
        return;
    }

    public static byte[] readResponse(boolean r100, int r101, InputStream r110, int[] r111) throws IOException {
        if (r101 > 0) goto L6;
        r101 = 5242880;
    L6:
        if (r101 >= 1048576) goto L9;
        r101 = 1048576;
    L9:
        if (r110 != null) goto L11;
        return null;
    L11:
        if (r100 == true) goto L51;
    L13:
        byte[] r102 = new byte[8192];     // Catch: Throwable -> L48
        int r103 = 0;
    L52:
    L37:
        e = move-exception;
        if (r100 == false) goto L47;
        if (r103 <= 0) goto L47;
        f.b("NetworkUtils", "ungzip got exception " + e);     // Catch: Throwable -> L48
    L41:
        if (r103 <= 0) goto L45;
        r111[0] = r103;     // Catch: Throwable -> L48
        safeClose(r110);
        return r102;
    L45:
        safeClose(r110);
        return null;
    L47:
        throw e;     // Catch: Throwable -> L48
    L27:
        e = move-exception;
        String r104 = e.getMessage();     // Catch: Throwable -> L48
        if (r100 == false) goto L36;
        if (r103 <= 0) goto L36;
        if ("CRC mismatch".equals(r104) == false) goto L34;
    L35:
        f.b("NetworkUtils", "ungzip got exception " + e);     // Catch: Throwable -> L48
        goto L41
    L34:
        if ("Size mismatch".equals(r104) == true) goto L35;
    L36:
        throw e;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        safeClose(r110);
        throw th;
    L17:
        if ((r103 + 4096) <= r102.length) goto L19;
        byte[] r105 = new byte[r102.length * 2];     // Catch: IOException -> L27 EOFException -> L37 Throwable -> L48
        System.arraycopy(r102, 0, r105, 0, r103);     // Catch: IOException -> L27 EOFException -> L37 Throwable -> L48
        r102 = r105;
    L19:
        int r106 = r110.read(r102, r103, 4096);     // Catch: IOException -> L27 EOFException -> L37 Throwable -> L48
        if (r106 <= 0) goto L41;
        r103 = r103 + r106;     // Catch: IOException -> L27 EOFException -> L37 Throwable -> L48
        if (r101 <= 0) goto L52;
        if (r103 <= r101) goto L52;
        f.b("NetworkUtils", "entity length did exceed given maxLength");     // Catch: IOException -> L27 EOFException -> L37 Throwable -> L48
        safeClose(r110);
        return null;
    L51:
        r110 = new GZIPInputStream(r110);     // Catch: Throwable -> L48
        goto L13
    }

    public static byte[] response2buf(boolean r100, int r101, InputStream r102, int[] r103, RequestHandler r104) throws IOException {
        if (r102 != null) goto L19;
        return null;
    L19:
        byte[] r105 = readResponse(r100, r101, r102, r103);     // Catch: Exception -> L12
        if (r105 != null) goto L8;
    L11:
        return null;
    L8:
        if (r103[0] <= 0) goto L11;
        return r105;
    L12:
        e = move-exception;
        if (r104 != null) goto L17;
    L15:
        throw e;
    L17:
        r104.abort();     // Catch: Throwable -> L16
        goto L15
    }
}
