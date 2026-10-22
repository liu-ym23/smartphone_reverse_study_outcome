package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IServiceProxy;
import com.larus.apm.impl.ILaunchTraceImpl;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ILaunchTrace__ServiceProxy implements IServiceProxy<ILaunchTrace> {
    public ILaunchTrace__ServiceProxy() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public ILaunchTrace newInstance() {
        return new ILaunchTraceImpl();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ ILaunchTrace newInstance() {
        return newInstance();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map<String, String> r100) {
        r100.put("com.bytedance.services.apm.api.ILaunchTrace", "com.larus.apm.impl.ILaunchTraceImpl");
    }
}
