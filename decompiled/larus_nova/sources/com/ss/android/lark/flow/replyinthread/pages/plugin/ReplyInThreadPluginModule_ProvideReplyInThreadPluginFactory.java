package com.ss.android.lark.flow.replyinthread.pages.plugin;

import com.ss.android.lark.chat.plugin.adapter.ChatPluginFactoryAdapter;
import com.ss.android.lark.scaffold.PagePlugin;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes36.dex */
public final class ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory implements Factory<PagePlugin> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory f424005a = null;

        static {
            f424005a = new ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory();
        }
    }

    public ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory() {
    }

    public static PagePlugin provideReplyInThreadPlugin() {
        int r100 = n.f424055a;
        return (PagePlugin) Preconditions.checkNotNullFromProvides(new ChatPluginFactoryAdapter(ReplyInThreadPluginModule$provideReplyInThreadPlugin$1.INSTANCE));
    }

    @Override // javax.inject.Provider
    public PagePlugin get() {
        return provideReplyInThreadPlugin();
    }

    public static ReplyInThreadPluginModule_ProvideReplyInThreadPluginFactory create() {
        return a.f424005a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
