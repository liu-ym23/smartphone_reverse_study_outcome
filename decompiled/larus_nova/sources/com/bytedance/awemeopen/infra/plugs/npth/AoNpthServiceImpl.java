package com.bytedance.awemeopen.infra.plugs.npth;

import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.crash.Npth;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AoNpthServiceImpl implements AoNpthService {
    public AoNpthServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.npth.AoNpthService
    public final void f0() {
        Npth.registerSdk(313526, "3.7.3");     // Catch: Throwable -> L5
        return;
    }

    @Override // com.bytedance.awemeopen.servicesapi.npth.AoNpthService
    public final void addTags(Map<? extends String, ? extends String> r100) {
        Npth.addTags(r100);
    }
}
