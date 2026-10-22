package m8a;

import com.facebook.common.util.UriUtil;
import com.lynx.tasm.ui.image.ImageResizeMethod;

/* JADX INFO: loaded from: classes32.dex */
public final class f {
    public f() {
    }

    public static boolean a(g r100, ImageResizeMethod r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r101 != ImageResizeMethod.AUTO) goto L14;
        if (UriUtil.isLocalContentUri(r100.b()) == false) goto L10;
    L11:
        return true;
    L10:
        if (UriUtil.isLocalFileUri(r100.b()) == true) goto L11;
        return false;
    L14:
        if (r101 != ImageResizeMethod.RESIZE) goto L16;
        return true;
    L16:
        return false;
    }
}
