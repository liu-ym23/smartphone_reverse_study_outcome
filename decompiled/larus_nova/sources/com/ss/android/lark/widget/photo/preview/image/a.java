package com.ss.android.lark.widget.photo.preview.image;

import com.ss.android.lark.vfs.VFSFile;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class a<T> implements Comparator {
    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((VFSFile) r100).lastModified()), Long.valueOf(((VFSFile) r101).lastModified()));
    }
}
