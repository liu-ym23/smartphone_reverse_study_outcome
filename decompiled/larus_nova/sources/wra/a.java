package wra;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static String a(Context r100) {
        File r101 = r100.getFilesDir();
        if (r101 == null) goto L9;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getAbsolutePath(), "ALOG");
        if (r102.exists() == true) goto L8;
        r102.mkdir();
    L8:
        return r102.getAbsolutePath();
    L9:
        return null;
    }
}
