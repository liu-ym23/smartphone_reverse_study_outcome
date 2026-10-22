package com.bytedance.awemeopen.infra.plugs.npth;

import com.bytedance.awemeopen.servicesapi.monitor.AoEnsureService;
import com.bytedance.crash.d;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AoEnsureServiceImpl implements AoEnsureService {
    public AoEnsureServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.monitor.AoEnsureService
    public final void ensureNotReachHere(Throwable r100, String r101, Map<String, String> r102) {
        d.e(r100, r101, r102);
    }
}
