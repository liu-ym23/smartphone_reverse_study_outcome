package com.suite.lark.emm.impl.clipboard.userscope.user;

import com.ss.android.lark.audit.userscope.auth.j;
import dagger.internal.Factory;
import doc.l;
import javax.inject.Provider;
import jdb.g;

/* JADX INFO: loaded from: classes40.dex */
public final class ClipboardManagerUserScope_Factory implements Factory<ClipboardManagerUserScope> {
    private final Provider<j> authorizationManagerProvider;
    private final Provider<com.ss.android.lark.storage.kv.storage.a> globalKVProvider;
    private final Provider<l> tipsHelperProvider;
    private final Provider<yzb.a> userApiProvider;
    private final Provider<g> userFGProvider;
    private final Provider<com.ss.android.lark.storage.kv.storage.a> userKVProvider;

    @Override // javax.inject.Provider
    public ClipboardManagerUserScope get() {
        return newInstance(this.globalKVProvider.get(), this.userKVProvider.get(), this.tipsHelperProvider.get(), this.userApiProvider.get(), this.authorizationManagerProvider.get(), this.userFGProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ClipboardManagerUserScope_Factory(Provider<com.ss.android.lark.storage.kv.storage.a> r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101, Provider<l> r102, Provider<yzb.a> r103, Provider<j> r104, Provider<g> r105) {
        this.globalKVProvider = r100;
        this.userKVProvider = r101;
        this.tipsHelperProvider = r102;
        this.userApiProvider = r103;
        this.authorizationManagerProvider = r104;
        this.userFGProvider = r105;
    }

    public static ClipboardManagerUserScope_Factory create(Provider<com.ss.android.lark.storage.kv.storage.a> r100, Provider<com.ss.android.lark.storage.kv.storage.a> r101, Provider<l> r110, Provider<yzb.a> r111, Provider<j> r112, Provider<g> r113) {
        return new ClipboardManagerUserScope_Factory(r100, r101, r110, r111, r112, r113);
    }

    public static ClipboardManagerUserScope newInstance(com.ss.android.lark.storage.kv.storage.a r100, com.ss.android.lark.storage.kv.storage.a r101, l r110, yzb.a r111, j r112, g r113) {
        return new ClipboardManagerUserScope(r100, r101, r110, r111, r112, r113);
    }
}
