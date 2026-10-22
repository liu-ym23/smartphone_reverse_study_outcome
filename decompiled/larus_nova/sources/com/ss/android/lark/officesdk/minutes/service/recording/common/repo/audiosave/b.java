package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http.MmCreateAudioResponse;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public interface b extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<f> {
    Object A(Continuation<? super Unit> r100);

    void C0();

    void D0();

    Object E0(c r100, boolean r101, Continuation<? super e> r102);

    void e(MmCreateAudioResponse r100);

    void f(MmCreateAudioResponse r100);

    void l();
}
