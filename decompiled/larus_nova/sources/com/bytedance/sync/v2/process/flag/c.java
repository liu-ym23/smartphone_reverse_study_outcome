package com.bytedance.sync.v2.process.flag;

import com.bytedance.sync.v2.protocal.BsyncTopic;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class c<T> implements Comparator<T> {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((BsyncTopic) r100).ref_cursor, ((BsyncTopic) r101).ref_cursor);
    }
}
