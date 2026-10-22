package qc1;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532434a = 0;

    static {
    }

    public static void a(String r100) {
        ALogger.i("LiveVEFileUtils", "safeDeleteFile " + r100);
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L15;
        ALogger.i("LiveVEFileUtils", "safeDeleteFile file not exist");
        return;
    L15:
        ALogger.i("LiveVEFileUtils", "safeDeleteFile result = " + r102.delete());
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
