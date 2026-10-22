package xg4;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements FilenameFilter {
    public k() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        String[] r102 = r101.split("-");
        if (r102.length == 2) goto L8;
    L6:
        return false;
    L8:
        CastLongProtector.parseLong(r102[0]);     // Catch: Throwable -> L7
        CastIntegerProtector.parseInt(r102[1]);     // Catch: Throwable -> L7
        return true;
    }
}
