package com.larus.bmhome.debug;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class m0<T> implements Comparator {
    public m0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r101).getCreateTime()), Long.valueOf(((Message) r100).getCreateTime()));
    }
}
