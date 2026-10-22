package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.monitor.l;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.shopping.anchorv3.ECAnchorV3Helper;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECAnchorV3Router implements bf.c {
    public ECAnchorV3Router() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_goods_detail";
    }

    public final void d(Uri r11) {
        String r1 = a2.d(UriProtector.getQueryParameter(r11, PdpOpenThirdParam.KEY_SOURCE_PAGE));
        String r3 = null;
        boolean r4 = false;
        if (Intrinsics.areEqual(r1, "live") == true) goto L12;
        JSONObject r2 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(r11, "meta_params"));
        if (r2 == null) goto L7;
        String r5 = r2.optString("live_room_id");
    L9:
        if (com.bytedance.android.shopping.extensions.k.c(r5) == true) goto L12;
        boolean r6 = false;
    L13:
        List r0 = CollectionsKt.mutableListOf(new l.a[]{new l.a(PdpOpenThirdParam.KEY_PROMOTION_ID, "presence"), new l.a(PdpOpenThirdParam.KEY_SOURCE_PAGE, "presence")});
        if (r6 == false) goto L16;
        r0.add(new l.a("kol_id", "presence"));
    L16:
        int r7 = l.a;
        l.a(r11.toString(), r1, "product_detail", r0);
        JSONObject r8 = com.bytedance.android.shopping.extensions.k.w(UriProtector.getQueryParameter(r11, "request_additions"));
        if (r8 == null) goto L19;
        r3 = r8.optString(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID);
    L19:
        if (r6 == false) goto L27;
        if (r3 != null) goto L22;
    L23:
        r4 = true;
    L24:
        if (r4 == false) goto L28;
        int r9 = com.bytedance.android.ec.core.monitor.d.a;
        com.bytedance.android.ec.core.monitor.d.c(null, "product_detail", r11.toString(), PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, "presence", "request_additions里的sec_author_id为空", 1);
        return;
    L28:
        return;
    L22:
        if (r3.length() != 0) goto L24;
    L27:
        return;
    L7:
        r5 = null;
    L12:
        r6 = true;
        goto L13
    }

    public final boolean c(Context r3, final Uri r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "uri");
        ECAnchorV3Helper r0 = ECAnchorV3Helper.a;
        ECAnchorV3Helper.k(r3, r4.toString(), r5, false);
        if (PdpPerfOpt.c() == false) goto L5;
        b2.b(new ECAnchorV3Router$open$1(this, r4));
        return true;
    L5:
        d(r4);
        return true;
    }
}
