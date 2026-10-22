package com.bytedance.kmp.ec.yata.store.core;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements com.bytedance.kmp.ec.yata.store.redux.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final YataStoreData f251741a;

    @Override // com.bytedance.kmp.ec.yata.store.redux.a
    public String getType() {
        return "handle_dispatch_action";
    }

    @Override // com.bytedance.kmp.ec.yata.store.redux.a
    public final YataStoreData getData() {
        return this.f251741a;
    }

    public g(YataStoreData r100) {
        this.f251741a = r100;
    }
}
