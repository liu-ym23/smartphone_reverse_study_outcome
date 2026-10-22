package com.larus.bmhome.utils;

import com.larus.business.markdown.impl.markwon.MarkwonContent;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class r2<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkwonContent f315106a;

    public r2(MarkwonContent r100) {
        this.f315106a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.f315106a.f320556a.getSpanStart(r101)), Integer.valueOf(this.f315106a.f320556a.getSpanStart(r100)));
    }
}
