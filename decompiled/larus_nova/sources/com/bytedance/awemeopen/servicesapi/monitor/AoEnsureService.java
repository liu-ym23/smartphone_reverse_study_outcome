package com.bytedance.awemeopen.servicesapi.monitor;

import com.bytedance.bdp.bdpbase.service.IBdpService;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface AoEnsureService extends IBdpService {
    void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102);
}
