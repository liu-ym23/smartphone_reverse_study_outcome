package w9c;

import com.ss.android.lark.pb.ug_reach.CdnImageElement;
import com.ss.android.lark.pb.ug_reach.ImageElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    static {
    }

    public static String a(ImageElement r100) {
        Intrinsics.checkNotNullParameter(r100, "image");
        CdnImageElement r101 = r100.mcdn_image;
        if (r101 != null) goto L5;
        return null;
    L5:
        String r102 = r101.murl;
        if (r102 != null) goto L9;
        return null;
    L9:
        if (r100.mtype == ImageElement.ImageType.ENCRYPTED_CDN_URL) goto L11;
    L13:
        return r102;
    L11:
        if (r101.msecrets != null) goto L13;
        return null;
    }
}
