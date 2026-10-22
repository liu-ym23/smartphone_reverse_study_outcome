package com.bytedance.android.livesdk.livecommerce.playback;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import el2.j;
import zi2.a;
import zi2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainPlaybackModule_ProvideFactory implements Factory<j> {
    private final a module;

    public j get() {
        return provideInstance(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m881get() {
        return get();
    }

    public ExplainPlaybackModule_ProvideFactory(a r1) {
        this.module = r1;
    }

    public static ExplainPlaybackModule_ProvideFactory create(a r1) {
        return new ExplainPlaybackModule_ProvideFactory(r1);
    }

    public static j provideInstance(a r0) {
        return proxyProvide(r0);
    }

    public static j proxyProvide(a r1) {
        r1.getClass();
        return (j) Preconditions.checkNotNull(b.a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
