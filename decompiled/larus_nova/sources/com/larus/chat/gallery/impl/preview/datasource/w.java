package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class w<T> implements Comparator {
    public w() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Integer r102 = ((CreationTask) r100).index;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
    L6:
        Integer r105 = Integer.valueOf(r104);
        Integer r106 = ((CreationTask) r101).index;
        if (r106 == null) goto L10;
        r103 = r106.intValue();
    L10:
        return ComparisonsKt.compareValues(r105, Integer.valueOf(r103));
    L5:
        r104 = 0;
        goto L6
    }
}
