package com.bytedance.android.livesdk.livecommerce.livereplay;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import fl2.a;
import mi2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveReplayModule_ProvideFactory implements Factory<a> {
    private final c module;

    public a get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m838get() {
        return get();
    }

    public ECLiveReplayModule_ProvideFactory(c r1) {
        this.module = r1;
    }

    public static ECLiveReplayModule_ProvideFactory create(c r1) {
        return new ECLiveReplayModule_ProvideFactory(r1);
    }

    public static a provideInstance(c r0) {
        return proxyProvide(r0);
    }

    public static a proxyProvide(c r1) {
        r1.getClass();
        return (a) Preconditions.checkNotNull(new mi2.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
