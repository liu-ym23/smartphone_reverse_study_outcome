package com.bytedance.android.livesdk.livecommerce.utils;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final void a(Animator r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(r2, "callback");
        r1.addListener(new b(r2));
    }
}
