package com.bytedance.bdp.appbase.base.log;

import com.bytedance.bdp.bdpbase.service.IBdpService;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpAppLogService extends IBdpService {
    void E(Object... r100);

    void Y1(Throwable r100);

    void d(String r100, Object... r101);

    void e(String r100, Object... r101);

    void i(String r100, Object... r101);

    boolean isLocalTest();

    void o(Object... r100);

    void w(String r100, Object... r101);
}
