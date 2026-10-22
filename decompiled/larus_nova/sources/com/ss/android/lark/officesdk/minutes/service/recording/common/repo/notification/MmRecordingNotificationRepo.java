package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingNotificationRepo extends MviRepository<a, Object, b> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MmRecordingNotificationRepo$opt$1 f435044j;

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final a a() {
        return new a(false, false, false, false);
    }

    public MmRecordingNotificationRepo() {
        this.f435044j = new MmRecordingNotificationRepo$opt$1(this);
    }
}
