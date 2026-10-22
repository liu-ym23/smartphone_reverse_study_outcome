package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends AnimationBackendDelegate<AnimationBackend> {
    public final int a;

    public final int getLoopCount() {
        return this.a;
    }

    public c(AnimationBackend r2) {
        Intrinsics.checkNotNullParameter(r2, "animationBackend");
        super(r2);
        this.a = 1;
    }
}
