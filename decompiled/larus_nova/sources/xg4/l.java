package xg4;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements FilenameFilter {
    public l() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (new PolarisFileWrapper(r100, r101).isDirectory() == true) goto L10;
        return false;
    L10:
        CastLongProtector.parseLong(r101);     // Catch: Throwable -> L9
        return true;
    L12:
        return false;
    }
}
