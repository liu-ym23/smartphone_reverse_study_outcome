package com.bytedance.badger;

import com.bytedance.news.common.service.manager.IServiceProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public class IBadger__ServiceProxy implements IServiceProxy {
    public IBadger__ServiceProxy() {
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public void collectService(Map r100) {
        r100.put("com.bytedance.badger.IBadger", "com.bytedance.badger.BadgerCore");
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public IBadger newInstance() {
        return new BadgerCore();
    }

    @Override // com.bytedance.news.common.service.manager.IServiceProxy
    public /* bridge */ /* synthetic */ Object newInstance() {
        return newInstance();
    }
}
