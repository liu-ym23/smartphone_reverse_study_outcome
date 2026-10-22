package com.bytedance.sync.v2.process.flag;

import com.bytedance.sync.v2.protocal.BsyncPacket;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b<T> implements Comparator<T> {
    public b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(((BsyncPacket) r100).cursor.cursor, ((BsyncPacket) r101).cursor.cursor);
    }
}
