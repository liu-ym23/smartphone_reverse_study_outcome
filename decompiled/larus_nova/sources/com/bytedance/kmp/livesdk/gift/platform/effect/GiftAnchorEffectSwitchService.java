package com.bytedance.kmp.livesdk.gift.platform.effect;

import com.bytedance.android.scope.o;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class GiftAnchorEffectSwitchService implements d, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f252343a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public GiftAnchorEffectSwitchService() {
        this.f252343a = LazyKt.lazy(GiftAnchorEffectSwitchService$innerGiftEffectRepo$2.INSTANCE);
    }
}
