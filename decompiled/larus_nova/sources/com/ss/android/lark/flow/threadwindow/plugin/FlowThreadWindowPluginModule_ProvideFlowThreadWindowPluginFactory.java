package com.ss.android.lark.flow.threadwindow.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory implements Factory<PagePlugin> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory f424267a = null;

        static {
            f424267a = new FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory();
        }
    }

    public FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory() {
    }

    public static PagePlugin provideFlowThreadWindowPlugin() {
        int r100 = i.f424282a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(FlowThreadWindowPluginModule$provideFlowThreadWindowPlugin$1.INSTANCE));
    }

    @Override // javax.inject.Provider
    public PagePlugin get() {
        return provideFlowThreadWindowPlugin();
    }

    public static FlowThreadWindowPluginModule_ProvideFlowThreadWindowPluginFactory create() {
        return a.f424267a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
