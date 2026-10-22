package com.ss.android.lark.flow.chat.page.flow.configurator;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowMessageListConfigurator_Factory implements Factory<FlowMessageListConfigurator> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowMessageListConfigurator_Factory f422731a = null;

        static {
            f422731a = new FlowMessageListConfigurator_Factory();
        }
    }

    public FlowMessageListConfigurator_Factory() {
    }

    public static FlowMessageListConfigurator newInstance() {
        return new FlowMessageListConfigurator();
    }

    @Override // javax.inject.Provider
    public FlowMessageListConfigurator get() {
        return newInstance();
    }

    public static FlowMessageListConfigurator_Factory create() {
        return a.f422731a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
