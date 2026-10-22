package wra;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static String a(Context r2) {
        File r3 = r2.getFilesDir();
        if (r3 == null) goto L9;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3.getAbsolutePath(), "ALOG");
        if (r0.exists() == true) goto L8;
        r0.mkdir();
    L8:
        return r0.getAbsolutePath();
    L9:
        return null;
    }
}
