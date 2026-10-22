package l17;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements FilenameFilter {
    public h() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        return false;
    L5:
        if (r101.startsWith("webviewbytedance_") == false) goto L7;
        return true;
    }
}
