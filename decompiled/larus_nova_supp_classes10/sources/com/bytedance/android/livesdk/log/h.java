package com.bytedance.android.livesdk.log;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface h {
    boolean addSendLogFilter(Object r1, com.bytedance.android.livesdk.log.filter.v r2);

    Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap();

    Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap();

    Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter();

    void initConfig();

    <T> void register(Class<? extends T> r1, com.bytedance.android.livesdk.log.filter.o<? extends T> r2);

    com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r1);

    <T> void unregister(Class<? extends T> r1);
}
