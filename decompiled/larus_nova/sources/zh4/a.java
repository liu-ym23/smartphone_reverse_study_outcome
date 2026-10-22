package zh4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import zg4.i;

/* JADX INFO: loaded from: classes15.dex */
public final class a {
    public static boolean a(String r100, PolarisFileWrapper r101, Context r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101, "lib" + r100 + ".so.tmp");
        ApplicationInfo r104 = r102.getApplicationInfo();
        String r105 = b.a(r104.sourceDir, r100, r103);
        if (r105 == null) goto L11;
        String[] r106 = r104.splitSourceDirs;
        if (r106 == null) goto L13;
        int r107 = r106.length;
        int r108 = 0;
    L8:
        if (r108 >= r107) goto L13;
        r105 = b.a(r106[r108], r100, r103);
        if (r105 == null) goto L11;
        r108 = r108 + 1;
    L13:
        String r109 = r105;
    L14:
        if (r109 == null) goto L18;
        boolean r110 = i.f572087c;
        return false;
    L18:
        return r103.renameTo(new PolarisFileWrapper(r101, "lib" + r100 + ".so"));
    L11:
        r109 = null;
        goto L14
    }
}
