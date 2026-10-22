package com.bytedance.news.common.settings;

import com.bytedance.news.common.service.manager.IService;
import g37.d;
import g37.f;

/* JADX INFO: loaded from: classes.dex */
public interface SettingsConfigProvider extends IService {
    d getConfig();

    f getLazyConfig();
}
