package com.bytedance.android.livesdk.livecommerce.utils;

import androidx.lifecycle.LifecycleCoroutineScope;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f {
    public static void a(long r9, LifecycleCoroutineScope r11, Function0 r12) {
        Intrinsics.checkNotNullParameter(r11, "scope");
        BuildersKt.launch$default(r11, null, null, new CountDownCoroutinesKt$countDownCoroutines$5(null, r9, r12, null), 3, null);
    }
}
