package com.ss.android.lark.flow.chat.page.starter;

import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.internal.Factory;
import javax.inject.Provider;
import jdb.g;
import tgb.a;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatStarter_Factory implements Factory<a> {
    private final Provider<d> dataPreloaderProvider;
    private final Provider<g> fgServiceProvider;
    private final Provider<UserSession> userSessionProvider;

    @Override // javax.inject.Provider
    public a get() {
        a r100 = newInstance(this.fgServiceProvider.get(), this.dataPreloaderProvider.get());
        r100.f545917c = this.userSessionProvider.get();
        return r100;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public static a newInstance(g r100, d r101) {
        return new a(r100, r101);
    }

    public FlowChatStarter_Factory(Provider<g> r100, Provider<d> r101, Provider<UserSession> r102) {
        this.fgServiceProvider = r100;
        this.dataPreloaderProvider = r101;
        this.userSessionProvider = r102;
    }

    public static FlowChatStarter_Factory create(Provider<g> r100, Provider<d> r101, Provider<UserSession> r102) {
        return new FlowChatStarter_Factory(r100, r101, r102);
    }
}
