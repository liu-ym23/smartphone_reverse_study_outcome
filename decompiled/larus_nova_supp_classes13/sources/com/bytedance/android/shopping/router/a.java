package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv3.dualstream.AnchorV3DualStreamActivity;
import com.bytedance.android.shopping.anchorv3.dualstream.model.DualStreamParams;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements bf.c {
    public a() {
    }

    public final void a() {
    }

    public final String b() {
        return "ecom_buyer_show";
    }

    public final boolean c(Context r2, Uri r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        String r5 = UriProtector.getQueryParameter(r3, PdpOpenThirdParam.KEY_PRODUCT_ID);
        Intrinsics.checkNotNullParameter("", "default");
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        int r6 = AnchorV3DualStreamActivity.x;
        AnchorV3DualStreamActivity.a.a(r2, new DualStreamParams(r5));
        return true;
    }
}
