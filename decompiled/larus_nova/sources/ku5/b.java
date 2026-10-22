package ku5;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements FileFilter {
    public b() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r100) {
        return Pattern.matches("cpu[0-9]", r100.getName());
    }
}
