package com.facebook.drawee.backends.pipeline.info;

import com.larus.platform.model.upload.ResourceUploadError;

/* JADX INFO: loaded from: classes23.dex */
public class ImagePerfUtils {
    private ImagePerfUtils() {
    }

    public static String toString(int r100) {
        if (r100 != 0) goto L4;
        return "requested";
    L4:
        if (r100 != 1) goto L6;
        return "origin_available";
    L6:
        if (r100 != 2) goto L8;
        return "intermediate_available";
    L8:
        if (r100 != 3) goto L10;
        return "success";
    L10:
        if (r100 != 4) goto L12;
        return ResourceUploadError.CANCELED;
    L12:
        if (r100 == 5) goto L15;
        return "unknown";
    L15:
        return "error";
    }
}
