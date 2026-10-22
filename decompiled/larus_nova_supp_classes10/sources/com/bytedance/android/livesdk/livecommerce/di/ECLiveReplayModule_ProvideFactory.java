package com.bytedance.android.livesdk.livecommerce.di;

import dagger.internal.Factory;
import fl2.a;
import hh2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLiveReplayModule_ProvideFactory implements Factory<a> {
    private final c module;

    public a get() {
        return provideInstance(null);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m671get() {
        return get();
    }

    public ECLiveReplayModule_ProvideFactory(c r1) {
    }

    public static ECLiveReplayModule_ProvideFactory create(c r1) {
        return new ECLiveReplayModule_ProvideFactory(r1);
    }

    public static a provideInstance(c r0) {
        return proxyProvide(r0);
    }

    public static a proxyProvide(c r0) {
        throw null;
    }
}
