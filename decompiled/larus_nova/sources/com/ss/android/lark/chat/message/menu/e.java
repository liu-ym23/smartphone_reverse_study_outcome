package com.ss.android.lark.chat.message.menu;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes35.dex */
public final class e<T> implements Comparator {
    public e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((IntRange) r100).getFirst()), Integer.valueOf(((IntRange) r101).getFirst()));
    }
}
