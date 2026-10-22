package com.larus.avlink.gallery.storage;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class h<T> implements Comparator {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        GalleryStoragePolicyManager.f292721a.getClass();
        Long r102 = GalleryStoragePolicyManager.r((File) r100);
        long r103 = Long.MAX_VALUE;
        if (r102 == null) goto L5;
        long r104 = r102.longValue();
    L6:
        Long r105 = Long.valueOf(r104);
        Long r106 = GalleryStoragePolicyManager.r((File) r101);
        if (r106 == null) goto L10;
        r103 = r106.longValue();
    L10:
        return ComparisonsKt.compareValues(r105, Long.valueOf(r103));
    L5:
        r104 = Long.MAX_VALUE;
        goto L6
    }
}
