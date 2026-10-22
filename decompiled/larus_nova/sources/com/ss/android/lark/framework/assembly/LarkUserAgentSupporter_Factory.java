package com.ss.android.lark.framework.assembly;

import android.content.Context;
import bjb.f;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes36.dex */
public final class LarkUserAgentSupporter_Factory implements Factory<f> {
    private final Provider<Context> contextProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.contextProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public LarkUserAgentSupporter_Factory(Provider<Context> r100) {
        this.contextProvider = r100;
    }

    public static LarkUserAgentSupporter_Factory create(Provider<Context> r100) {
        return new LarkUserAgentSupporter_Factory(r100);
    }

    public static f newInstance(Context r100) {
        return new f(r100);
    }
}
