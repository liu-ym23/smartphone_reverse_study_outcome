package com.bytedance.ies.argus.bean;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class h<T> implements Comparator<T> {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((AspectConfigItem.a) r100).b()), Integer.valueOf(((AspectConfigItem.a) r101).b()));
    }
}
