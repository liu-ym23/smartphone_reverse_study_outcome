package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.feed.ProductFeedStarter;
import com.bytedance.android.shopping.feed.utils.o;
import com.bytedance.android.shopping.orderlist.list.model.PageEnvironment;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements bf.c {
    public i() {
    }

    public final void a() {
    }

    public final String b() {
        return "product_inner_feed";
    }

    public final boolean c(Context r120, Uri r121, boolean r122) {
        Intrinsics.checkNotNullParameter(r120, "context");
        Intrinsics.checkNotNullParameter(r121, "uri");
        int r2 = o.a;
        String r3 = r121.toString();
        Intrinsics.checkNotNullParameter(r120, "context");
        Intrinsics.checkNotNullParameter(r3, "url");
        Uri r0 = UriProtector.parse(r3);
        String r4 = UriProtector.getQueryParameter(r0, PdpOpenThirdParam.KEY_PROMOTION_ID);
        if (r4 != null) goto L5;
        String r5 = "";
    L6:
        String r6 = UriProtector.getQueryParameter(r0, "video_id");
        if (r6 != null) goto L9;
        r6 = "";
    L9:
        String r7 = UriProtector.getQueryParameter(r0, "author_id");
        if (r7 != null) goto L12;
        String r34 = "";
    L13:
        String r8 = UriProtector.getQueryParameter(r0, "author_open_id");
        if (r8 != null) goto L16;
        String r44 = "";
    L17:
        String r9 = UriProtector.getQueryParameter(r0, "meta_params");
        if (r9 == null) goto L21;
        JSONObject r10 = z1.g(r9);
        if (r10 == null) goto L21;
    L22:
        JSONObject r12 = r10;
        String r11 = r12.optString("entrance_info");
        String r13 = null;
        if (r11 == null) goto L25;
        JSONObject r55 = z1.g(r11);
    L26:
        String r14 = UriProtector.getQueryParameter(r0, "request_additions");
        if (r14 == null) goto L29;
        JSONObject r15 = z1.g(r14);
    L30:
        String r16 = UriProtector.getQueryParameter(r0, "v3_events_additions");
        if (r16 == null) goto L33;
        JSONObject r17 = z1.g(r16);
    L34:
        String r18 = a2.d(UriProtector.getQueryParameter(r0, PdpOpenThirdParam.KEY_SOURCE_PAGE));
        if (r18 != null) goto L41;
        if (r15 == null) goto L38;
        r18 = r15.optString(SimilarProductParam.ENTER_FROM);
    L39:
        if (r18 != null) goto L41;
        String r57 = "";
    L42:
        if (r15 == null) goto L44;
        String r19 = r15.optString(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID);
    L45:
        if (r19 != null) goto L47;
        String r35 = "";
    L48:
        if (r17 == null) goto L50;
        Integer r36 = Integer.valueOf(r17.optInt(PdpOpenThirdParam.KEY_FOLLOW_STATUS, -1));
    L51:
        if (r17 == null) goto L53;
        String r20 = r17.optString("enter_method");
    L54:
        if (r20 != null) goto L56;
        String r58 = "";
    L57:
        if (r17 == null) goto L59;
        r13 = r17.optString("ecom_entrance_form");
    L59:
        if (r13 != null) goto L61;
        String r59 = "";
    L62:
        String r21 = UriProtector.getQueryParameter(r0, "cover_img");
        if (r21 != null) goto L65;
        String r32 = "";
    L66:
        boolean r56 = com.bytedance.android.shopping.extensions.k.n(UriProtector.getQueryParameter(r0, PageEnvironment.FULLSCREEN), false);
        String r22 = UriProtector.getQueryParameter(r0, "ad_type");
        if (r22 == null) goto L71;
        Integer r23 = StringsKt.toIntOrNull(r22);
        if (r23 == null) goto L71;
        int r33 = r23.intValue();
    L72:
        String r110 = UriProtector.getQueryParameter(r0, "promotion_ids");
        if (r110 == null) goto L76;
        List r24 = StringsKt.split$default(r110, new String[]{","}, false, 0, 6, null);
        if (r24 == null) goto L76;
    L77:
        List r37 = r24;
        String r25 = UriProtector.getQueryParameter(r0, "page_state_listener_id");
        if (r25 != null) goto L80;
        String r97 = "";
    L81:
        String r26 = UriProtector.getQueryParameter(r0, "page_state_listener_extra");
        if (r26 != null) goto L84;
        String r98 = "";
    L85:
        String r114 = UriProtector.getQueryParameter(r0, "source_btm_token");
        JSONObject r60 = r17;
        boolean r1 = false;
        JSONObject r117 = r15;
        ECProductInfo r116 = new ECProductInfo(r5, null, null, r37, 0, null, r32, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388534, null);
        ECAwemeItemInfo r27 = new ECAwemeItemInfo(r6, r34, r35, r36, false, String.valueOf(r33), true, 0, null, null, null, r44, false, false, null, null, null, null, null, false, 1046416, null);
        if (r55 == null) goto L89;
        String r28 = r55.toString();
        if (r28 == null) goto L89;
    L90:
        ECProductDetailPageShowStyle r29 = new ECProductDetailPageShowStyle(r56, false, 0, false, 14, null);
        if (r60 == null) goto L96;
        String r30 = r60.toString();
        if (r30 == null) goto L96;
        String r61 = r30;
    L97:
        ECLogExtraData r31 = new ECLogExtraData(r57, r58, r59, r61, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262128, null);
        ECUIParam r111 = new ECUIParam(null, false, false, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, r97, r98, null, null, null, null, null, false, false, false, null, 0.0f, 0, null, -1572865, 1, null);
        if (r6.length() <= 0) goto L100;
        r1 = true;
    L100:
        new ProductFeedStarter(r120, r116, r27, r12, r28, r114, null, r29, r31, r117, r111, r122, Boolean.valueOf(r1), null).h();
        return true;
    L96:
        r61 = "";
    L89:
        r28 = "";
        goto L90
    L84:
        r98 = r26;
        goto L85
    L80:
        r97 = r25;
    L76:
        r24 = CollectionsKt.listOf(r5);
    L71:
        r33 = 0;
        goto L72
    L65:
        r32 = r21;
        goto L66
    L61:
        r59 = r13;
        goto L62
    L56:
        r58 = r20;
        goto L57
    L53:
        r20 = null;
        goto L54
    L50:
        r36 = null;
        goto L51
    L47:
        r35 = r19;
        goto L48
    L44:
        r19 = null;
        goto L45
    L38:
        r18 = null;
    L41:
        r57 = r18;
        goto L42
    L33:
        r17 = null;
        goto L34
    L29:
        r15 = null;
        goto L30
    L25:
        r55 = null;
    L21:
        r10 = new JSONObject();
        goto L22
    L16:
        r44 = r8;
        goto L17
    L12:
        r34 = r7;
        goto L13
    L5:
        r5 = r4;
        goto L6
    }
}
