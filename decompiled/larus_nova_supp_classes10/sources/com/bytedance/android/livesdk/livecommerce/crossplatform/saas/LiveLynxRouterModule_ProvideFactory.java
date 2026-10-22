package com.bytedance.android.livesdk.livecommerce.crossplatform.saas;

import com.bytedance.android.livesdk.livecommerce.router.d;
import dagger.internal.Factory;
import gh2.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LiveLynxRouterModule_ProvideFactory implements Factory<d> {
    private final a module;

    public d get() {
        provideInstance(this.module);
        return null;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m669get() {
        get();
        return null;
    }

    public LiveLynxRouterModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static LiveLynxRouterModule_ProvideFactory create(a r1) {
        return new LiveLynxRouterModule_ProvideFactory(r1);
    }

    public static d provideInstance(a r0) {
        proxyProvide(r0);
        return null;
    }

    public static d proxyProvide(a r0) {
        r0.getClass();
        return null;
    }
}
