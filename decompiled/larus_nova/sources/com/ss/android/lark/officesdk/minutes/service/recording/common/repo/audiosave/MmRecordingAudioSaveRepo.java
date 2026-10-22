package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingAudioSaveRepo extends MviRepository {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f434873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmRecordingSource f434874k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f434875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f434876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f434877n;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final Object a() {
        return new f(0);
    }

    public final b m() {
        return (b) this.f434877n.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.f434875l;
    }

    public static final void l(MmRecordingAudioSaveRepo r100) {
        if (r100.f434874k != MmRecordingSource.FEISHU_HARDWARE_D1204) goto L6;
        r100.f434873j.I().e();
        return;
    }

    public MmRecordingAudioSaveRepo(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, MmRecordingSource r101) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        this.f434873j = r100;
        this.f434874k = r101;
        this.f434875l = "MmRecordingAudioSaveRepo";
        this.f434877n = LazyKt.lazy(new MmRecordingAudioSaveRepo$opt$2(this));
    }
}
