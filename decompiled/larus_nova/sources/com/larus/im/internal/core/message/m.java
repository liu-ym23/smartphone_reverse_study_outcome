package com.larus.im.internal.core.message;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class m<T> implements Comparator {
    public m() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((MessageEntity) r100).getLocalIndex()), Long.valueOf(((MessageEntity) r101).getLocalIndex()));
    }
}
