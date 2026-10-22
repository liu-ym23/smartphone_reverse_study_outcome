package com.larus.business.multitask_management.impl.view;

import com.larus.multitask_management.api.customize.ITaskUIFactory;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class x<T> implements Comparator {
    public x() {
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((ITaskUIFactory) r101).getPriority()), Integer.valueOf(((ITaskUIFactory) r100).getPriority()));
    }
}
