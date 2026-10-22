package com.ss.android.lark.flow.chat.page.flow.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatPluginModule_ProvideFlowChatPluginFactory implements Factory<PagePlugin> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowChatPluginModule_ProvideFlowChatPluginFactory f422737a = null;

        static {
            f422737a = new FlowChatPluginModule_ProvideFlowChatPluginFactory();
        }
    }

    public FlowChatPluginModule_ProvideFlowChatPluginFactory() {
    }

    public static PagePlugin provideFlowChatPlugin() {
        int r100 = d.f422775a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(FlowChatPluginModule$provideFlowChatPlugin$1.INSTANCE));
    }

    @Override // javax.inject.Provider
    public PagePlugin get() {
        return provideFlowChatPlugin();
    }

    public static FlowChatPluginModule_ProvideFlowChatPluginFactory create() {
        return a.f422737a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
