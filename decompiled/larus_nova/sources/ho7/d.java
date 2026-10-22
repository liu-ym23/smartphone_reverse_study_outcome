package ho7;

import android.graphics.Bitmap;
import java.io.File;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static String a(Bitmap r100) {
        String r101 = "share_image_" + System.currentTimeMillis() + ".jpeg";
        String r102 = oo7.f.f();
        if (oo7.f.h(r100, r102, r101) == true) goto L5;
        return "";
    L5:
        return r102 + File.separator + r101;
    }

    public static boolean b(String r100) {
        return !oo7.g.a(r100);
    }
}
