package com.larus.call_plugins_doubao_common;

import com.larus.audio.call.mgr.MajorState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public interface k extends com.larus.audio.call.arch.e {
    long B2();

    void O0();

    void c1(boolean r100, Function1<? super Boolean, Unit> r101);

    boolean isPlaying();

    void m1(Function1<? super MajorState, Boolean> r100);

    void o0();
}
