package com.larksuite.component.ui.tag;

import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class c<T> implements Comparator {
    public c() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(((UDTagsDrawable.d) ((Pair) r100).getSecond()).f285340a), Integer.valueOf(((UDTagsDrawable.d) ((Pair) r101).getSecond()).f285340a));
    }
}
