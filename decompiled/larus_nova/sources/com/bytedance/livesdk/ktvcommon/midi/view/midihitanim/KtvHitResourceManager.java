package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes20.dex */
public final class KtvHitResourceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f256091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f256092c;

    public KtvHitResourceManager() {
        this.f256090a = LazyKt.lazy(KtvHitResourceManager$normalDrawables$2.INSTANCE);
        this.f256091b = LazyKt.lazy(KtvHitResourceManager$perfectNormalDrawables$2.INSTANCE);
        this.f256092c = LazyKt.lazy(KtvHitResourceManager$perfectAdvancedDrawables$2.INSTANCE);
    }
}
