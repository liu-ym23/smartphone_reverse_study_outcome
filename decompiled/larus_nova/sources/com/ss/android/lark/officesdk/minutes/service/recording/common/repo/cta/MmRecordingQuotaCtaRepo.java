package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingQuotaCtaRepo extends MviRepository<c, a, d> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmRecordingSource f434904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f434905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f434906m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        if (f.c(this.f434904k) == true) goto L7;
        h.b r100 = h.b.f434922a;
        return new c(r100, r100, 4);
    L7:
        return new c(null, null, 7);
    }

    public final a l() {
        return (a) this.f434906m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f434905l;
    }

    public MmRecordingQuotaCtaRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, MmRecordingSource r101) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.f434903j = r100;
        this.f434904k = r101;
        this.f434905l = "MmRecordingQuotaCtaRepo_" + hashCode();
        this.f434906m = LazyKt.lazy(new MmRecordingQuotaCtaRepo$opt$2(this));
    }
}
