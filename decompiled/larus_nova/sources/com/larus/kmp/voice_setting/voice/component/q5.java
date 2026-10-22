package com.larus.kmp.voice_setting.voice.component;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes30.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f352483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f352484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f352485c;

    public final com.larus.kmp.voice_setting.platform.n0 a() {
        return (com.larus.kmp.voice_setting.platform.n0) this.f352484b.getValue();
    }

    public q5(LifecycleOwner r100) {
        this.f352483a = r100;
        this.f352484b = LazyKt.lazy(new o5(this));
        this.f352485c = LazyKt.lazy(new p5(this));
    }
}
