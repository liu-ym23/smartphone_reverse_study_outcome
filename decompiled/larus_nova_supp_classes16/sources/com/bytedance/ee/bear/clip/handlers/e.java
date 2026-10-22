package com.bytedance.ee.bear.clip.handlers;

import at5.j;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.larksuite.component.universe_design.toast.UDToast;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements UDToast.b {
    public final /* synthetic */ j a;

    public e(j r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.compose.foundation.toast.b r5) {
        Intrinsics.checkNotNullParameter(r5, "toast");
        r5.cancel();
        this.a.a(Status.SUCCESS, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operation", "click_retry")}));
    }
}
