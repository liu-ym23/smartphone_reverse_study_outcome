package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements jh.a {
    public final et3.c a;

    public final void a() {
        this.a.d();
    }

    public final void stop() {
        this.a.f();
    }

    public e(Function1 r5) {
        Intrinsics.checkNotNullParameter("ec_store_fps_preview", "sceneName");
        Intrinsics.checkNotNullParameter(r5, "callback");
        et3.c r0 = new et3.c("ec_store_fps_preview", true, null);
        r0.c(new d(r5));
        Unit r6 = Unit.INSTANCE;
        this.a = r0;
    }
}
