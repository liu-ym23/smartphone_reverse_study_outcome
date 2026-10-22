package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class InitMinutesRecordingTask_Factory implements Factory<InitMinutesRecordingTask> {
    private final Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> componentContextProvider;

    public static InitMinutesRecordingTask newInstance() {
        return new InitMinutesRecordingTask();
    }

    @Override // javax.inject.Provider
    public InitMinutesRecordingTask get() {
        InitMinutesRecordingTask r100 = newInstance();
        r100.f433586a = this.componentContextProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public InitMinutesRecordingTask_Factory(Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r100) {
        this.componentContextProvider = r100;
    }

    public static InitMinutesRecordingTask_Factory create(Provider<com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a> r100) {
        return new InitMinutesRecordingTask_Factory(r100);
    }
}
