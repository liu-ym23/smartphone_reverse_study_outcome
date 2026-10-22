package org.apache.commons.compress.archivers.zip;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ZipEncodingHelper {
    static final ZipEncoding UTF8_ZIP_ENCODING = null;

    static {
        UTF8_ZIP_ENCODING = getZipEncoding("UTF8");
    }

    public static ZipEncoding getZipEncoding(String r100) {
        Charset r101 = Charset.defaultCharset();
        if (r100 == null) goto L6;
        r101 = Charset.forName(r100);     // Catch: UnsupportedCharsetException -> L7
    L6:
        return new NioZipEncoding(r101, isUTF8(r101.name()));
    }

    public static boolean isUTF8(String r100) {
        if (r100 != null) goto L5;
        r100 = Charset.defaultCharset().name();
    L5:
        if (StandardCharsets.UTF_8.name().equalsIgnoreCase(r100) == false) goto L7;
        return true;
    L7:
        Iterator<String> r101 = StandardCharsets.UTF_8.aliases().iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        if (r101.next().equalsIgnoreCase(r100) == false) goto L9;
        return true;
    L13:
        return false;
    }
}
