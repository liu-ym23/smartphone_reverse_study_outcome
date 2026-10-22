package com.ss.android.lark.conditional.access.plugin;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class GetUnifiedGrantTokenCallHandler_Factory implements Factory<a> {
    private final Provider<l> rustClientProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.rustClientProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public GetUnifiedGrantTokenCallHandler_Factory(Provider<l> r100) {
        this.rustClientProvider = r100;
    }

    public static GetUnifiedGrantTokenCallHandler_Factory create(Provider<l> r100) {
        return new GetUnifiedGrantTokenCallHandler_Factory(r100);
    }

    public static a newInstance(l r100) {
        return new a(r100);
    }
}
