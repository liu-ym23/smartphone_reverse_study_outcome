package com.bytedance.ee.bear.bitable.statistic;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public interface n {
    void b(Boolean r100);

    Map<String, Serializable> c(boolean r100);

    String getTraceId();

    BitableTraceType getType();

    String h();
}
