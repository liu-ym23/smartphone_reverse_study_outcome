package com.ss.android.lark.chameleon.idependency;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/IDependency;", "", "getEnvDependency", "Lcom/ss/android/lark/chameleon/idependency/IEnv;", "getLogDependency", "Lcom/ss/android/lark/chameleon/idependency/ILog;", "getNetSerivice", "Lcom/ss/android/lark/chameleon/idependency/INetService;", "getSettings", "Lcom/ss/android/lark/chameleon/idependency/ISettings;", "getStatisticService", "Lcom/ss/android/lark/chameleon/idependency/IStatisticService;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IDependency {
    IEnv getEnvDependency();

    ILog getLogDependency();

    INetService getNetSerivice();

    ISettings getSettings();

    IStatisticService getStatisticService();
}
