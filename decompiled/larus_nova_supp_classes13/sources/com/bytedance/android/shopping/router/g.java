package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements bf.c {
    public g() {
    }

    public final void a() {
    }

    public final String b() {
        return "goods/seeding/";
    }

    public final boolean c(Context r2, Uri r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        ECAnchorV3Helper r0 = ECAnchorV3Helper.a;
        ECAnchorV3Helper.i(r2, r3.toString(), r4);
        return true;
    }
}
