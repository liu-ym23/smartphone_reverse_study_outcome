package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Comparator;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class l<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Comparator f436506a;

    public l(i r100) {
        this.f436506a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        int r102 = this.f436506a.compare(r100, r101);
        if (r102 == 0) goto L6;
        return r102;
    L6:
        return ComparisonsKt.compareValues(Integer.valueOf(((IndexedValue) r100).getIndex()), Integer.valueOf(((IndexedValue) r101).getIndex()));
    }
}
