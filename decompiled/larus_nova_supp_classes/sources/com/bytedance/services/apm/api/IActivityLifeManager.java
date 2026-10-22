package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import ff7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(c r1);

    void unregister(c r1);
}
