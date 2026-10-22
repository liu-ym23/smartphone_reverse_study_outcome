package com.ss.android.lark.framework.assembly.logger;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class InitLogTask_Factory implements Factory<InitLogTask> {
    private final Provider<Set<com.ss.android.lark.log.b>> logMufflersProvider;

    public static InitLogTask newInstance() {
        return new InitLogTask();
    }

    @Override // javax.inject.Provider
    public InitLogTask get() {
        InitLogTask r100 = newInstance();
        r100.f425657d = this.logMufflersProvider;
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitLogTask_Factory(Provider<Set<com.ss.android.lark.log.b>> r100) {
        this.logMufflersProvider = r100;
    }

    public static InitLogTask_Factory create(Provider<Set<com.ss.android.lark.log.b>> r100) {
        return new InitLogTask_Factory(r100);
    }
}
