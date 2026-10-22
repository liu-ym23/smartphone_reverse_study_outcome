package hgc;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.ttapkdiffpatch.applier.DiffType;
import com.ss.android.ttapkdiffpatch.applier.decoder.TTPatchParseException;
import ggc.d;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jgc.c;
import jgc.e;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static DiffType c(String r100) {
        if ("ad".equalsIgnoreCase(r100) == false) goto L6;
        return DiffType.ApkDiffPatch;
    L6:
        if (PlayerResolution.SDKKEY.HD.equalsIgnoreCase(r100) == false) goto L9;
        return DiffType.HDiffPatch;
    L9:
        if ("ap".equalsIgnoreCase(r100) == true) goto L15;
        return null;
    L15:
        return DiffType.ArchivePatcher;
    }

    public static d d(String r210) throws TTPatchParseException {
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper(r210);     // Catch: FileNotFoundException -> L62
        Charset r101 = Charset.forName("US-ASCII");
        jgc.a r102 = new jgc.a(r100);     // Catch: Throwable -> L44 IOException -> L46 UnsupportedEncodingException -> L48
        DataInputStream r103 = new DataInputStream(r102);     // Catch: Throwable -> L44 IOException -> L46 UnsupportedEncodingException -> L48
        byte[] r104 = "APKD".getBytes("ASCII");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        byte[] r105 = new byte[r104.length];     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        r103.readFully(r105);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        if (Arrays.equals(r104, r105) == false) goto L39;
        int r110 = r103.readInt();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        int r111 = r103.readInt();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        List<Integer> r106 = ggc.a.f481225a;     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        if (((ArrayList) r106).contains(Integer.valueOf(r110)) == false) goto L37;
        long r107 = r103.readInt();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        b(r107, "Extended Info length < 0");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        int r112 = (int) r107;     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        if (r112 > 209715200) goto L35;
        if (r112 <= 0) goto L13;
        r103.readFully(new byte[r112]);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L13:
        byte[] r108 = new byte[4];     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        r103.readFully(r108);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        String r109 = new String(r108, r101).trim();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        DiffType r113 = c(r109);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        if (r113 == null) goto L33;
        long r114 = r103.readInt();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        b(r114, "oldApkMd5 length must not be negative");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        int r115 = (int) r114;
        if (r115 <= 0) goto L21;
        byte[] r116 = new byte[r115];     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        r103.readFully(r116);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        String r117 = new String(r116, r101);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L22:
        long r118 = r103.readInt();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        b(r118, "newApkMd5 length must not be negative");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        int r119 = (int) r118;     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        if (r119 <= 0) goto L25;
        byte[] r120 = new byte[r119];     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        r103.readFully(r120);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        String r121 = new String(r120, r101);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L26:
        long r122 = r103.readLong();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        long r123 = r103.readLong();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        long r124 = r102.f499058b;     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        if (r123 <= r124) goto L29;
        long r125 = r123 - r124;     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        a(r125, r103.skip(r125), "cannot skip to diff data count ");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L29:
        a(r122, r103.skip(r122), "skip diff data error ");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        long r211 = r103.readLong();     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        d r126 = new d(r110, r111, r112, r113, r117, r121, r122, new d.a(r210, r124, r122, r211), r211);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
        e.a(r103);
        return r126;
    L25:
        r121 = "";
        goto L26
    L21:
        r117 = "";
        goto L22
    L33:
        throw new TTPatchParseException(1010, "diffType is null or invalid :" + r109);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L35:
        throw new TTPatchParseException(1011, "extended info length > 200MB!");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L37:
        throw new TTPatchParseException(1002, "support " + r106.toString() + " but receive " + r110);     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L39:
        throw new TTPatchParseException(1001, "Bad identifier, not a TTPatch File");     // Catch: Throwable -> L19 IOException -> L40 UnsupportedEncodingException -> L42
    L42:
        e = e;
    L57:
        throw new TTPatchParseException(1006, e);     // Catch: Throwable -> L44
    L40:
        e = e;
    L51:
        if (c.a(e) == false) goto L55;
        throw new TTPatchParseException(1012, e);     // Catch: Throwable -> L44
    L55:
        throw new TTPatchParseException(1007, e);     // Catch: Throwable -> L44
    L19:
        th = th;
    L59:
        if (r103 == null) goto L61;
        e.a(r103);
    L61:
        throw th;
    L44:
        th = th;
        r103 = null;
    L48:
        e = e;
    L46:
        e = e;
    L62:
        e = move-exception;
        throw new TTPatchParseException(1005, e);
    }

    public static void b(long r100, String r101) throws TTPatchParseException {
        if (r100 < 0) goto L6;
        return;
    L6:
        throw new TTPatchParseException(1008, "Bad value for " + r101 + ": " + r100);
    }

    public static void a(long r100, long r101, String r102) throws TTPatchParseException {
        if (r100 != r101) goto L6;
        return;
    L6:
        throw new TTPatchParseException(1003, r102 + " except: " + r100 + " actual: " + r101);
    }
}
