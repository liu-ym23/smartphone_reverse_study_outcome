package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class MimeTypeMapWrapper {
    private static final Map<String, String> sExtensionToMimeTypeMap = null;
    private static final MimeTypeMap sMimeTypeMap = null;
    private static final Map<String, String> sMimeTypeToExtensionMap = null;

    public MimeTypeMapWrapper() {
    }

    static {
        sMimeTypeMap = MimeTypeMap.getSingleton();
        sMimeTypeToExtensionMap = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
        sExtensionToMimeTypeMap = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");
    }

    public static String getExtensionFromMimeType(String r100) {
        String r101 = sMimeTypeToExtensionMap.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return sMimeTypeMap.getExtensionFromMimeType(r100);
    }

    public static String getMimeTypeFromExtension(String r100) {
        String r101 = sExtensionToMimeTypeMap.get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return sMimeTypeMap.getMimeTypeFromExtension(r100);
    }

    public static boolean hasExtension(String r100) {
        if (sExtensionToMimeTypeMap.containsKey(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (sMimeTypeMap.hasExtension(r100) == true) goto L8;
        return false;
    }

    public static boolean hasMimeType(String r100) {
        if (sMimeTypeToExtensionMap.containsKey(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (sMimeTypeMap.hasMimeType(r100) == true) goto L8;
        return false;
    }
}
