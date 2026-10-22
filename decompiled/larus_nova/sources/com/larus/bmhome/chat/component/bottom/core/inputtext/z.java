package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.text.Editable;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class z<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Editable f299248a;

    public z(Editable r100) {
        this.f299248a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Integer.valueOf(this.f299248a.getSpanStart(r101)), Integer.valueOf(this.f299248a.getSpanStart(r100)));
    }
}
