package com.ss.android.lark.chameleon.idependency;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleon/idependency/DependencyInject;", "", "()V", "initDependency", "", "iDependency", "Lcom/ss/android/lark/chameleon/idependency/IDependency;", "injectEnv", "env", "Lcom/ss/android/lark/chameleon/idependency/IEnv;", "injectLog", "log", "Lcom/ss/android/lark/chameleon/idependency/ILog;", "injectNetService", "netService", "Lcom/ss/android/lark/chameleon/idependency/INetService;", "injectSettings", "settings", "Lcom/ss/android/lark/chameleon/idependency/ISettings;", "injectStatisticService", "statistic", "Lcom/ss/android/lark/chameleon/idependency/IStatisticService;", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DependencyInject {
    public static final DependencyInject INSTANCE = null;

    static {
        INSTANCE = new DependencyInject();
    }

    private DependencyInject() {
    }

    private final void injectEnv(IEnv r100) {
        Env.INSTANCE.setIEnv(r100);
    }

    private final void injectLog(ILog r100) {
        Log.INSTANCE.setILog(r100);
    }

    private final void injectNetService(INetService r100) {
        NetService.INSTANCE.setNetService(r100);
    }

    private final void injectSettings(ISettings r100) {
        Settings.INSTANCE.setSSettings(r100);
    }

    private final void injectStatisticService(IStatisticService r100) {
        StatisticService.INSTANCE.setIStatisticService(r100);
    }

    public final void initDependency(IDependency r100) {
        Intrinsics.checkNotNullParameter(r100, "iDependency");
        IEnv r101 = r100.getEnvDependency();
        if (r101 == null) goto L5;
        INSTANCE.injectEnv(r101);
    L5:
        ILog r102 = r100.getLogDependency();
        if (r102 == null) goto L8;
        INSTANCE.injectLog(r102);
    L8:
        IStatisticService r103 = r100.getStatisticService();
        if (r103 == null) goto L11;
        INSTANCE.injectStatisticService(r103);
    L11:
        INetService r104 = r100.getNetSerivice();
        if (r104 == null) goto L14;
        INSTANCE.injectNetService(r104);
    L14:
        ISettings r105 = r100.getSettings();
        if (r105 == null) goto L18;
        INSTANCE.injectSettings(r105);
        return;
    }
}
