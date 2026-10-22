package com.ss.android.lark.flow.chat;

import com.ss.android.lark.chatwindow.launcher.c;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatModule_Factory implements Factory<FlowChatModule> {
    private final Provider<c> chatLauncherV2Provider;
    private final Provider<uza.a> officeSDKSharePanelProvider;

    @Override // javax.inject.Provider
    public FlowChatModule get() {
        FlowChatModule r100 = newInstance(this.chatLauncherV2Provider.get());
        r100.f422024b = this.officeSDKSharePanelProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static FlowChatModule newInstance(c r100) {
        return new FlowChatModule(r100);
    }

    public FlowChatModule_Factory(Provider<c> r100, Provider<uza.a> r101) {
        this.chatLauncherV2Provider = r100;
        this.officeSDKSharePanelProvider = r101;
    }

    public static FlowChatModule_Factory create(Provider<c> r100, Provider<uza.a> r101) {
        return new FlowChatModule_Factory(r100, r101);
    }
}
