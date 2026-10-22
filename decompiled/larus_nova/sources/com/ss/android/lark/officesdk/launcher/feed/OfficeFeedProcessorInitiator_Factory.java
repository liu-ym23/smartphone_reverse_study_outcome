package com.ss.android.lark.officesdk.launcher.feed;

import com.ss.android.lark.framework.assembly.rust.InitImSdkTask;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeFeedProcessorInitiator_Factory implements Factory<c> {
    private final Provider<InitImSdkTask> initImSdkTaskProvider;
    private final Provider<eva.a> launchPerfDispatcherProvider;
    private final Provider<Set<a>> launchTaskInjectorsProvider;

    @Override // javax.inject.Provider
    public c get() {
        c r100 = newInstance(this.initImSdkTaskProvider.get(), this.launchPerfDispatcherProvider.get());
        r100.f433443b = this.launchTaskInjectorsProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static c newInstance(InitImSdkTask r100, eva.a r101) {
        return new c(r100, r101);
    }

    public OfficeFeedProcessorInitiator_Factory(Provider<InitImSdkTask> r100, Provider<eva.a> r101, Provider<Set<a>> r102) {
        this.initImSdkTaskProvider = r100;
        this.launchPerfDispatcherProvider = r101;
        this.launchTaskInjectorsProvider = r102;
    }

    public static OfficeFeedProcessorInitiator_Factory create(Provider<InitImSdkTask> r100, Provider<eva.a> r101, Provider<Set<a>> r102) {
        return new OfficeFeedProcessorInitiator_Factory(r100, r101, r102);
    }
}
