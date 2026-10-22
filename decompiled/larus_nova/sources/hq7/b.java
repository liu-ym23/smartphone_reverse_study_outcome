package hq7;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements FilenameFilter {
    public b() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        CastLongProtector.parseLong(r101);     // Catch: NumberFormatException -> L5
        return true;
    L5:
        return false;
    }
}
