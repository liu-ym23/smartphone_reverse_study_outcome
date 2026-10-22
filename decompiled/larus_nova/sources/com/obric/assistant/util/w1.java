package com.obric.assistant.util;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class w1<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f393853a;

    public w1(u1 r100) {
        this.f393853a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f393853a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((ObricMentionHighlightHelper.b) r100).f393615a), Integer.valueOf(((ObricMentionHighlightHelper.b) r101).f393615a));
    }
}
