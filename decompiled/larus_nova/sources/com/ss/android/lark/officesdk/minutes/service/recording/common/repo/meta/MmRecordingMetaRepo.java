package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingMetaRepo extends MviRepository<b, a, c> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435027j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f435028k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Job f435029l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f435030m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final b a() {
        return new b(0);
    }

    public final a l() {
        return (a) this.f435030m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f435028k;
    }

    public MmRecordingMetaRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.f435027j = r100;
        this.f435028k = "MmRecordingMetaRepo";
        this.f435030m = LazyKt.lazy(new MmRecordingMetaRepo$opt$2(this));
    }
}
