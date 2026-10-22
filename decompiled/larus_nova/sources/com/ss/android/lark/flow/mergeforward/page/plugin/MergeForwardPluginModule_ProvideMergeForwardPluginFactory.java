package com.ss.android.lark.flow.mergeforward.page.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class MergeForwardPluginModule_ProvideMergeForwardPluginFactory implements Factory<PagePlugin> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MergeForwardPluginModule_ProvideMergeForwardPluginFactory f423749a = null;

        static {
            f423749a = new MergeForwardPluginModule_ProvideMergeForwardPluginFactory();
        }
    }

    public MergeForwardPluginModule_ProvideMergeForwardPluginFactory() {
    }

    public static PagePlugin provideMergeForwardPlugin() {
        int r100 = b.f423750a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(MergeForwardPluginModule$provideMergeForwardPlugin$1.INSTANCE));
    }

    @Override // javax.inject.Provider
    public PagePlugin get() {
        return provideMergeForwardPlugin();
    }

    public static MergeForwardPluginModule_ProvideMergeForwardPluginFactory create() {
        return a.f423749a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
