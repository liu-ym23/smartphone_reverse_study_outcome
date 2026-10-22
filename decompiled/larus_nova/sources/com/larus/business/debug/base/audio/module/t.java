package com.larus.business.debug.base.audio.module;

import java.io.File;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class t<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f320025a;

    public t(s r100) {
        this.f320025a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        s r102 = this.f320025a;
        Long r103 = Long.valueOf(s.a(r102, (File) r100));
        s r104 = this.f320025a;
        return ComparisonsKt.compareValues(r103, Long.valueOf(s.a(r104, (File) r101)));
    }
}
