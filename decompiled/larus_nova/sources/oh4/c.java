package oh4;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Comparator<File> {
    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(File r100, File r101) {
        long r102 = r100.lastModified() - r101.lastModified();
        if (r102 <= 0) goto L5;
        return 1;
    L5:
        if (r102 != 0) goto L7;
        return 0;
    L7:
        return -1;
    }
}
