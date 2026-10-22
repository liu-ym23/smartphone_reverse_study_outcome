package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class u<T> implements Comparator {
    public u() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((AIJob) r101).getCreateTime()), Long.valueOf(((AIJob) r100).getCreateTime()));
    }
}
