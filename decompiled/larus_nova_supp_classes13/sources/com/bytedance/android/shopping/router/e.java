package com.bytedance.android.shopping.router;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.shopping.anchorv3.kolbuyershow.KolBuyerShowActivity;
import com.bytedance.android.shopping.anchorv3.kolbuyershow.KolBuyerShowParams;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements bf.c {
    public e() {
    }

    public final void a() {
    }

    public final String b() {
        return "ecom_kol_buyer_show_merge";
    }

    public final boolean c(Context r8, Uri r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "uri");
        int r0 = m63.c.a;
        Intrinsics.checkNotNullParameter(r9, "uri");
        String r11 = UriProtector.getQueryParameter(r9, "title_list");
        if (r11 != null) goto L5;
        String r2 = "";
    L6:
        String r12 = UriProtector.getQueryParameter(r9, SimilarProductParam.ENTER_FROM);
        if (r12 != null) goto L9;
        String r4 = "";
    L10:
        String r13 = UriProtector.getQueryParameter(r9, PdpOpenThirdParam.KEY_PRODUCT_ID);
        if (r13 != null) goto L13;
        String r3 = "";
    L14:
        String r14 = UriProtector.getQueryParameter(r9, "track_params");
        if (r14 != null) goto L17;
        String r5 = "";
    L18:
        String r15 = UriProtector.getQueryParameter(r9, SendClosePdpEventParam.KEY_LYNX_URL);
        if (r15 != null) goto L21;
        String r6 = "";
    L22:
        int r16 = KolBuyerShowActivity.q;
        KolBuyerShowParams r17 = new KolBuyerShowParams(r2, r3, r4, r5, r6);
        Intrinsics.checkNotNullParameter(r17, "param");
        if (r8 == null) goto L27;
        Intent r18 = new Intent(r8, KolBuyerShowActivity.class);
        r18.putExtra("param_key", r17);
        Unit r19 = Unit.INSTANCE;
        r8.startActivity(r18);
        return true;
    L27:
        return true;
    L21:
        r6 = r15;
        goto L22
    L17:
        r5 = r14;
        goto L18
    L13:
        r3 = r13;
        goto L14
    L9:
        r4 = r12;
        goto L10
    L5:
        r2 = r11;
        goto L6
    }
}
