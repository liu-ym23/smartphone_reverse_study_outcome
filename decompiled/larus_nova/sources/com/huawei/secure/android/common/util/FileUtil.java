package com.huawei.secure.android.common.util;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;

/* JADX INFO: loaded from: classes23.dex */
public class FileUtil {
    public FileUtil() {
    }

    private static String a(String r100) {
        if (r100.isEmpty() == true) goto L10;
        int r101 = r100.lastIndexOf(".");
        if (r101 == (-1)) goto L12;
        int r102 = r101 + 1;
        if (r102 != r100.length()) goto L9;
        return "";
    L9:
        return r100.substring(r102).toLowerCase(Locale.ENGLISH);
    L12:
        return "";
    L10:
        return "";
    }

    public static boolean filePathIsValid(String r100) throws UnsupportedEncodingException {
        if (r100 != null) goto L5;
    L22:
        return true;
    L5:
        if (r100.equals("") == true) goto L22;
        if (r100.contains(GXTemplateKey.GAIAX_PE) == false) goto L10;
        r100 = r100.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
    L10:
        String r101 = URLDecoder.decode(r100, XML.CHARSET_UTF8);
        if (r101.contains(DownloadConstants.VULNERABILITY_PATH) == false) goto L13;
        return false;
    L13:
        if (r101.contains("./") == false) goto L15;
        return false;
    L15:
        if (r101.contains(".\\.\\") == false) goto L17;
        return false;
    L17:
        if (r101.contains("%00") == true) goto L25;
        return true;
    L25:
        return false;
    }

    public static boolean filePathIsValidNew(String r100) throws IOException {
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.equals("") == true) goto L9;
        String r101 = new PolarisFileWrapper(r100.trim()).getName();
        return filePathIsValid(r100.substring(0, r100.lastIndexOf(r101)), r101);
    }

    public static boolean checkFileExtValid(String r100, String[] r101) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L16;
        if (r101 == null) goto L16;
        String r102 = a(r100);
        int r103 = 0;
    L10:
        if (r103 >= r101.length) goto L16;
        if (r102.equalsIgnoreCase(r101[r103]) == true) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return true;
    }

    public static boolean filePathIsValid(String r100, String r101) throws IllegalArgumentException, IOException {
        if (r100 != null) goto L5;
    L31:
        return false;
    L5:
        if (r100.equals("") == true) goto L31;
        if (r101 == null) goto L31;
        if (r101.equals("") == true) goto L31;
        String r102 = URLDecoder.decode(r101, XML.CHARSET_UTF8);     // Catch: IllegalArgumentException -> L32
        String r103 = URLDecoder.decode(r100, XML.CHARSET_UTF8);     // Catch: IllegalArgumentException -> L32
        if (r103.contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L31;
        if (r103.contains("./") == true) goto L31;
        if (r103.contains(".\\.\\") == true) goto L31;
        if (r103.contains("%00") == true) goto L31;
        if (r102.contains(DownloadConstants.VULNERABILITY_PATH) == true) goto L31;
        if (r102.contains("./") == true) goto L31;
        if (r102.contains(".\\.\\") == true) goto L31;
        if (r102.contains("%00") == true) goto L31;
        return new PolarisFileWrapper(r103, r102).getCanonicalPath().startsWith(new PolarisFileWrapper(r103).getCanonicalPath());
    }
}
