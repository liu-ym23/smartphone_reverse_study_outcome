package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Comparator;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class g<T> implements Comparator {
    public g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r100).getValue()).f435224c), Long.valueOf(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r101).getValue()).f435224c));
    }
}
