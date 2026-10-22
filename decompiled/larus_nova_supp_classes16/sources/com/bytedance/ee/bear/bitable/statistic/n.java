package com.bytedance.ee.bear.bitable.statistic;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface n {
    void b(Boolean r1);

    Map<String, Serializable> c(boolean r1);

    String getTraceId();

    BitableTraceType getType();

    String h();
}
