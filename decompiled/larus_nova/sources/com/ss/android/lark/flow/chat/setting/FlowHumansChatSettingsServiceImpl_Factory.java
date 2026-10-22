package com.ss.android.lark.flow.chat.setting;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowHumansChatSettingsServiceImpl_Factory implements Factory<FlowHumansChatSettingsServiceImpl> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowHumansChatSettingsServiceImpl_Factory f423020a = null;

        static {
            f423020a = new FlowHumansChatSettingsServiceImpl_Factory();
        }
    }

    public FlowHumansChatSettingsServiceImpl_Factory() {
    }

    public static FlowHumansChatSettingsServiceImpl newInstance() {
        return new FlowHumansChatSettingsServiceImpl();
    }

    @Override // javax.inject.Provider
    public FlowHumansChatSettingsServiceImpl get() {
        return newInstance();
    }

    public static FlowHumansChatSettingsServiceImpl_Factory create() {
        return a.f423020a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
