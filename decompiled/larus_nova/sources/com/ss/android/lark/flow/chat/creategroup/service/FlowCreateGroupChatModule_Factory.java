package com.ss.android.lark.flow.chat.creategroup.service;

import com.ss.android.lark.chatwindow.launcher.c;
import com.ss.android.lark.create.groupchat.impl.service.h;
import dagger.internal.Factory;
import dgb.a;
import hab.b;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowCreateGroupChatModule_Factory implements Factory<a> {
    private final Provider<b> chatDependencyProvider;
    private final Provider<c> chatLauncherV2Provider;
    private final Provider<h> createGroupServiceProvider;

    public static a newInstance() {
        return new a();
    }

    @Override // javax.inject.Provider
    public a get() {
        a r100 = newInstance();
        r100.f468548a = this.createGroupServiceProvider.get();
        r100.f468549b = this.chatLauncherV2Provider.get();
        r100.f468550c = this.chatDependencyProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowCreateGroupChatModule_Factory(Provider<h> r100, Provider<c> r101, Provider<b> r102) {
        this.createGroupServiceProvider = r100;
        this.chatLauncherV2Provider = r101;
        this.chatDependencyProvider = r102;
    }

    public static FlowCreateGroupChatModule_Factory create(Provider<h> r100, Provider<c> r101, Provider<b> r102) {
        return new FlowCreateGroupChatModule_Factory(r100, r101, r102);
    }
}
