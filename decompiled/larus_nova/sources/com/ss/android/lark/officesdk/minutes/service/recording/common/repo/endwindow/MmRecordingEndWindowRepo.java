package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingEndWindowRepo extends MviRepository<c, a, Object> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingRepo f434933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f434935l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f434936m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final c a() {
        return new c(0);
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f434935l;
    }

    public MmRecordingEndWindowRepo(MmRecordingRepo r100, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r101) {
        Intrinsics.checkNotNullParameter(r100, "recordingRepo");
        Intrinsics.checkNotNullParameter(r101, "mmUccApi");
        this.f434933j = r100;
        this.f434934k = r101;
        this.f434935l = "RecordUX_D_EndWindowRepo";
        this.f434936m = LazyKt.lazy(new MmRecordingEndWindowRepo$opt$2(this));
    }
}
