package com.bytedance.android.window.shop.innerflow;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.utils.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements bf.c {
    public c() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/window/innerflow";
    }

    public final boolean c(final Context r3, final Uri r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        int r1 = ECWindowInnerFlowActivity.o;
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "schema");
        n.b(r3, r5, null, new ECWindowInnerFlowActivity$Companion$start$1(r4, r3), ECWindowInnerFlowActivity$Companion$start$2.INSTANCE);
        return true;
    }
}
