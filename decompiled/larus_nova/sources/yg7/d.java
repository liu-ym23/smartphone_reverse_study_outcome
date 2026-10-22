package yg7;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class d<T> implements Comparator<T> {
    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((File) r101).lastModified()), Long.valueOf(((File) r100).lastModified()));
    }
}
