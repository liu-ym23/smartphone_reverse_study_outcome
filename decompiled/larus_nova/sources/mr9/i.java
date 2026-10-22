package mr9;

import com.larus.platform.model.upload.ResourceUploadError;

/* JADX INFO: loaded from: classes31.dex */
public final class i {
    public static final Integer a(String r100) {
        if (r100 == null) goto L30;
        switch(r100.hashCode()) {
            case -2080410610: goto L26;
            case -767751356: goto L22;
            case -348960385: goto L18;
            case -123173735: goto L14;
            case 341770610: goto L11;
            case 1001110960: goto L7;
            default: goto L30;
        };
    L7:
        if (r100.equals("no_network") == false) goto L30;
        return -4;
    L11:
        if (r100.equals(ResourceUploadError.AUTH_TOKEN) == false) goto L30;
        return -1;
    L14:
        if (r100.equals(ResourceUploadError.CANCELED) == false) goto L30;
        return -6;
    L18:
        if (r100.equals(ResourceUploadError.REGISTER_ERROR) == false) goto L30;
        return -5;
    L22:
        if (r100.equals(ResourceUploadError.UPLOAD_ERROR) == false) goto L30;
        return -3;
    L26:
        if (r100.equals(ResourceUploadError.VIDEO_TRANSCODE_ERROR) == false) goto L30;
        return -2;
    L30:
        return -100;
    }
}
