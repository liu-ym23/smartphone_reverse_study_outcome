package com.bytedance.bdp.serviceapi.defaults.thread;

import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpThreadService extends IBdpService {
    boolean X();

    void c(Runnable r100);

    void executeCPU(Runnable r100);

    void executeIO(Runnable r100);

    int u2();

    boolean x0();
}
