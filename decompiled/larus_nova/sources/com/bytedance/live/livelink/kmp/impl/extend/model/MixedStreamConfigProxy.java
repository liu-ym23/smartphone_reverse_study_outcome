package com.bytedance.live.livelink.kmp.impl.extend.model;

import bg2.e;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class MixedStreamConfigProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f255590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f255591b;

    public MixedStreamConfigProxy(Object r100) {
        this.f255590a = (e) r100;
        this.f255591b = LazyKt.lazy(new MixedStreamConfigProxy$spatialAudioConfig$2(this));
    }
}
