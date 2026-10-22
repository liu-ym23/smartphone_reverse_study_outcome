package com.bytedance.android.livesdk.log;

import com.bytedance.android.live.base.IService;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface ILoggerLifeManagerService extends h, IService {
    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ boolean addSendLogFilter(Object r1, com.bytedance.android.livesdk.log.filter.v r2);

    /* synthetic */ void afterExecuteLogFilter();

    /* synthetic */ void afterSendAppLog(String r1, Map<String, String> r2);

    /* synthetic */ void beforeExecuteLogFilter(Map<String, String> r1);

    /* synthetic */ void beforeSendAppLog(String r1, Map<String, String> r2);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getFakeTempMap();

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ Map<Class<?>, com.bytedance.android.livesdk.log.filter.o<?>> getMap();

    ILoggerLifeManagerService getNewInstance(String r1);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ Map<Object, com.bytedance.android.livesdk.log.filter.v> getSendLogFilter();

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ void initConfig();

    /* synthetic */ boolean needDropEventBySampling(String r1);

    /* synthetic */ String onChangeEventName(boolean r1, String r2);

    /* synthetic */ void onExecuteLogFilter(Map<String, String> r1, Map<String, String> r2, Object... r3);

    /* synthetic */ void onSendAppLog(String r1, Map<String, String> r2);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ <T> void register(Class<? extends T> r1, com.bytedance.android.livesdk.log.filter.o<? extends T> r2);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ com.bytedance.android.livesdk.log.filter.v removeSendLogFilter(Object r1);

    @Override // com.bytedance.android.livesdk.log.h
    /* synthetic */ <T> void unregister(Class<? extends T> r1);
}
