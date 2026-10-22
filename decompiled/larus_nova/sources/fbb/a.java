package fbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes35.dex */
public final class a {
    public static boolean a(File r100) {
        if (r100.isDirectory() == false) goto L18;
        String[] r101 = r100.list();
        if (r101 != null) goto L8;
        return true;
    L8:
        int r102 = 0;
    L10:
        if (r102 >= r101.length) goto L16;
        if (a(new PolarisFileWrapper(r100, r101[r102])) == false) goto L13;
        r102 = r102 + 1;
        goto L10
    L13:
        return false;
    L16:
        return r100.delete();
    L18:
        return r100.delete();
    }
}
