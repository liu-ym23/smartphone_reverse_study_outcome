package com.facebook.common.media;

import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class MediaUtils {
    public static final Map<String, String> ADDITIONAL_ALLOWED_MIME_TYPES = null;

    public MediaUtils() {
    }

    static {
        ADDITIONAL_ALLOWED_MIME_TYPES = ImmutableMap.of("mkv", "video/x-matroska", "glb", "model/gltf-binary");
    }

    @Nullable
    private static String extractExtension(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 >= 0) goto L5;
        return null;
    L5:
        if (r101 != (r100.length() - 1)) goto L8;
        return null;
    L8:
        return r100.substring(r101 + 1);
    }

    @Nullable
    public static String extractMime(String r100) {
        String r101 = extractExtension(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        String r102 = r101.toLowerCase(Locale.US);
        String r103 = MimeTypeMapWrapper.getMimeTypeFromExtension(r102);
        if (r103 == null) goto L9;
        return r103;
    L9:
        return ADDITIONAL_ALLOWED_MIME_TYPES.get(r102);
    }

    public static boolean isNonNativeSupportedMimeType(String r100) {
        return ADDITIONAL_ALLOWED_MIME_TYPES.containsValue(r100);
    }

    public static boolean isPhoto(@Nullable String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.startsWith("image/") == false) goto L6;
        return true;
    }

    public static boolean isThreeD(@Nullable String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.equals("model/gltf-binary") == false) goto L6;
        return true;
    }

    public static boolean isVideo(@Nullable String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.startsWith("video/") == false) goto L6;
        return true;
    }
}
