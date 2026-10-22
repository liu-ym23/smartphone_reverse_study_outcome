package ez5;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements FileFilter {
    public e() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return r100.isDirectory();
    }
}
