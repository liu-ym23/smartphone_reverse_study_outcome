package com.bytedance.bdp.serviceapi.defaults.monitor;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface BdpEnsureService extends IBdpService {
    void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102);
}
