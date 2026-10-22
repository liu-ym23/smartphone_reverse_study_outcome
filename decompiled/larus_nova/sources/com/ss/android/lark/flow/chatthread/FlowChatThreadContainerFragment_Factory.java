package com.ss.android.lark.flow.chatthread;

import com.ss.android.lark.flow.chatthread.page.FlowChatThreadFragment;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatThreadContainerFragment_Factory implements Factory<FlowChatThreadContainerFragment> {
    private final Provider<FlowChatThreadFragment> mFragmentProvider;

    public static FlowChatThreadContainerFragment newInstance() {
        return new FlowChatThreadContainerFragment();
    }

    @Override // javax.inject.Provider
    public FlowChatThreadContainerFragment get() {
        FlowChatThreadContainerFragment r100 = newInstance();
        r100.f423160f = this.mFragmentProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowChatThreadContainerFragment_Factory(Provider<FlowChatThreadFragment> r100) {
        this.mFragmentProvider = r100;
    }

    public static FlowChatThreadContainerFragment_Factory create(Provider<FlowChatThreadFragment> r100) {
        return new FlowChatThreadContainerFragment_Factory(r100);
    }
}
