package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.meta;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<b> {
    void N(MmRecordingWindowMode r100);

    Object O(String r100, String r101, Continuation<? super Unit> r102);

    void Q0(long r100);

    void c(String r100, long r101);

    void e(MmCreateAudioResponse r100);

    void f(MmCreateAudioResponse r100);

    void k(MmRecordingUITab r100);
}
