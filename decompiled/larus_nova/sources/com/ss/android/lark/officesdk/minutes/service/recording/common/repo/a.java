package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmRecordingQuotaCtaRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.speaker.MmRecordingSpeakerRepo;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    void g(String r100);

    MmRecordingSpeakerRepo h();

    MmRecordingQuotaCtaRepo i();

    Object j(b r100, Continuation<? super Unit> r101);

    String k();

    MmRecordingLanguageRepo l();

    void m(String r100);

    com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.a n();

    String o();
}
