package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import java.util.Comparator;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class h<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l f436503a;

    public h(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l r100) {
        this.f436503a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(Math.abs(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r100).getValue()).f435225d - ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a) this.f436503a).f434865a)), Long.valueOf(Math.abs(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h) ((IndexedValue) r101).getValue()).f435225d - ((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.l.a) this.f436503a).f434865a)));
    }
}
