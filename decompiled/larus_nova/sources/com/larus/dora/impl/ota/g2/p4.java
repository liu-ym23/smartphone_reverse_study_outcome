package com.larus.dora.impl.ota.g2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public interface p4 {

    /* JADX INFO: loaded from: classes27.dex */
    public interface a {
        FailureReason a();

        void b(boolean r100, FailureReason r101);

        void c(int r100);
    }

    Unit a(e r100, String r101, long r102, FailureReason r103);

    Object b(e r100, String r101, long r102, OtaMode r103, com.larus.dora.impl.ota.g2.a r104, Continuation r105);

    boolean c(e r100, String r101);

    void d(e r100, String r101, long r102, e5 r103, String r104, AndroidG2OtaRuntime.d r105);

    Object e(e r100, String r101, OtaMode r102);
}
