package com.larus.audio.call.mgr;

import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes24.dex */
public interface f extends com.larus.audio.call.arch.e {

    public interface a {
        void Q(MajorState r100, MajorState r101);
    }

    MajorState A0();

    void F2(DownStateReducer r100, ReducerPosition r101);

    void M0(a r100);

    void V(a r100);

    boolean a1(MajorState r100, String r101);

    void error(int r100, String r101);

    void n2(StateTriggerEvent r100);

    MajorState s1();

    void t();

    void t1(u68.c r100);

    i1<AVKitDuplexState> y();

    void z();
}
