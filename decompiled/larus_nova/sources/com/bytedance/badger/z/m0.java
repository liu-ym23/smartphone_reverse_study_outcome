package com.bytedance.badger.z;

import java.util.Comparator;
import java.util.zip.ZipEntry;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class m0 implements Comparator {
    public m0() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ComparisonsKt.compareValues(((ZipEntry) r100).getName(), ((ZipEntry) r101).getName());
    }
}
