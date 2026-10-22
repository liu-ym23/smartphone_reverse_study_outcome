package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class o5<T> implements Comparator {
    public o5() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((Message) r100).getLocalIndex()), Long.valueOf(((Message) r101).getLocalIndex()));
    }
}
