package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv4.launcher.PdpLauncher;
import com.bytedance.android.shopping.utils.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements bf.c {
    public h() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_goods_pdp";
    }

    public final boolean c(Context r21, Uri r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "uri");
        new PdpLauncher(r21).c(r22, new p83.h(r23, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 16777214));     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        int r1 = z.a;
        z.c("ECPdpSchemaRouter.open err=" + th.getMessage(), null, 6);
        throw th;
    }
}
