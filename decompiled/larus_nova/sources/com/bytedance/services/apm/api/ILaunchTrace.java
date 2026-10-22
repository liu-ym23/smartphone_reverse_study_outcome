package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface ILaunchTrace extends IService {
    void cancelTrace();

    void endSpan(String r100, String r101);

    void endTrace(int r100, String r101, long r102);

    void startSpan(String r100, String r101);

    void startTrace();
}
