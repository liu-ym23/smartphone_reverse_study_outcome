package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.MmRecordingSubtitleRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingSpeakerRepo extends MviRepository<f, a, Object> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<MmRecordingSubtitleRepo> f435057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f435058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f435059m;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final f a() {
        return new f(0);
    }

    public final a l() {
        return (a) this.f435059m.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f435058l;
    }

    public MmRecordingSpeakerRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, Function0<MmRecordingSubtitleRepo> r101) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        Intrinsics.checkNotNullParameter(r101, "subtitleProvider");
        this.f435056j = r100;
        this.f435057k = r101;
        this.f435058l = "MmRecordingSpeakerRepo";
        this.f435059m = LazyKt.lazy(new MmRecordingSpeakerRepo$opt$2(this));
    }
}
