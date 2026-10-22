package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<b> {
    Object G(Continuation<? super Unit> r100);

    void J0();

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    i1<b> b();

    Object c0(String r100, c r101, Continuation<? super g> r102);

    Object f0(String r100, c r101, Continuation<? super g> r102);

    void i(byte[] r100);

    Object j0(String r100, c r101, Continuation<? super g> r102);

    Object n(String r100, c r101, c r102, Continuation<? super g> r103);

    @Override // fvb.a
    void onDestroy();

    Object p0(boolean r100, Continuation<? super Unit> r101);

    boolean s0();

    Object z0(boolean r100, Continuation<? super f> r101);
}
