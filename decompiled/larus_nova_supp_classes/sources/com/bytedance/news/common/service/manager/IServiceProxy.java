package com.bytedance.news.common.service.manager;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface IServiceProxy<T> {
    void collectService(Map<String, String> r1);

    T newInstance();
}
