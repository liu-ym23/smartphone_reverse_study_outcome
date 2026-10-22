package com.bytedance.awemeopen.servicesapi.thread;

import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface AoThreadService extends IBdpService {
    void F(Runnable r100, long r101);

    void c(Runnable r100);

    void executeIO(Runnable r100);

    void executeLogic(Runnable r100);

    void p1(Runnable r100);
}
