package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class w<T> implements Comparator {
    public w() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((AIJob) r101).getCreateTime()), Long.valueOf(((AIJob) r100).getCreateTime()));
    }
}
