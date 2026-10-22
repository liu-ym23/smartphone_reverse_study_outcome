package com.larus.photopicker.impl.ui;

import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class z2<T> implements Comparator {
    public z2() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Boolean.valueOf(Intrinsics.areEqual(((IFolderItem) r100).getId(), "creativex:DEFAULT_ENTIRE_FOLDER")), Boolean.valueOf(Intrinsics.areEqual(((IFolderItem) r101).getId(), "creativex:DEFAULT_ENTIRE_FOLDER")));
    }
}
