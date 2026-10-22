package xg4;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements FilenameFilter {
    public g() {
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File r100, String r101) {
        return r101.startsWith("ai_");
    }
}
