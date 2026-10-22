package v98;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m {
    static {
    }

    public static double a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "filePaths");
        Intrinsics.checkNotNullParameter(r100, "filePaths");
        Iterator r101 = r100.iterator();
        long r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L15;
        String r103 = (String) r101.next();
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);     // Catch: Exception -> L12
        if (r104.exists() == false) goto L4;
        if (r104.isFile() == false) goto L4;
        r102 = r102 + r104.length();
    L12:
        e = move-exception;
        FLogger.f375446a.w("FilePathsSizeCalculator", "Error getting size for " + r103 + ": " + e.getMessage());
        goto L4
    L15:
        return r102 / 1048576.0d;
    }
}
