package jd3;

import android.text.TextUtils;
import com.bytedance.android.shopping.anchorv3.AnchorV3Starter;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECLubanData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v extends c {
    public Integer a;
    public String b;
    public AnchorV3Starter c;

    public static final class a {
    }

    static {
    }

    public final void buildParams() {
        Integer r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = String.valueOf(r0.intValue());
    L6:
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        com.bytedance.android.ec.core.event.a.b.a.a r3 = com.bytedance.android.ec.core.event.a.b.a.a;
        appendParam("statusCode", r2, r3);
        appendParam("statusMsg", this.b, r3);
        appendParam("shop_id", null, r3);
        AnchorV3Starter r4 = this.c;
        if (r4 == null) goto L11;
        ECLogExtraData r5 = r4.A;
        if (r5 == null) goto L11;
        String r6 = r5.getEnterFrom();
    L12:
        appendParam(PdpOpenThirdParam.KEY_SOURCE_PAGE, r6, r3);
        appendParam(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail", r3);
        AnchorV3Starter r7 = this.c;
        if (r7 == null) goto L17;
        ECLogExtraData r8 = r7.A;
        if (r8 == null) goto L17;
        String r9 = r8.getEnterFrom();
    L18:
        String r10 = "live";
        boolean r11 = TextUtils.equals(r9, "live");
        AnchorV3Starter r12 = this.c;
        if (r12 == null) goto L27;
        JSONObject r13 = r12.s;
        if (r13 == null) goto L27;
        String r14 = r13.optString("live_room_id");
        if (r14 == null) goto L27;
        if (com.bytedance.android.shopping.extensions.k.c(r14) != true) goto L27;
        boolean r15 = true;
    L28:
        if (r11 == true) goto L32;
        if (r15 == true) goto L32;
        boolean r16 = false;
    L33:
        if (r16 == true) goto L36;
        r10 = "video";
    L36:
        appendParam("ecom_group_type", r10, r3);
        AnchorV3Starter r17 = this.c;
        if (r17 == null) goto L41;
        ECAwemeItemInfo r18 = r17.r;
        if (r18 == null) goto L41;
        String r19 = r18.getItemId();
    L42:
        appendParam("group_id", r19, r3);
        AnchorV3Starter r20 = this.c;
        if (r20 == null) goto L47;
        ECAwemeItemInfo r21 = r20.r;
        if (r21 == null) goto L47;
        String r22 = r21.getUserId();
    L48:
        appendParam("author_id", r22, r3);
        AnchorV3Starter r23 = this.c;
        if (r23 == null) goto L53;
        ECProductInfo r24 = r23.q;
        if (r24 == null) goto L53;
        String r25 = r24.getProductId();
    L54:
        appendParam(PdpOpenThirdParam.KEY_PRODUCT_ID, r25, r3);
        AnchorV3Starter r26 = this.c;
        if (r26 == null) goto L61;
        ECAwemeItemInfo r27 = r26.r;
        if (r27 == null) goto L61;
        Integer r28 = r27.getFollowStatus();
        if (r28 == null) goto L61;
        String r29 = String.valueOf(r28.intValue());
    L62:
        appendParam(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r29, r3);
        AnchorV3Starter r30 = this.c;
        if (r30 == null) goto L65;
        String r31 = r30.E;
    L66:
        appendParam("room_id", r31, r3);
        AnchorV3Starter r32 = this.c;
        if (r32 == null) goto L73;
        ECProductDetailPageShowStyle r33 = r32.y;
        if (r33 == null) goto L73;
        if (r33.getFullMode() != true) goto L73;
        String r34 = "full_screen";
    L74:
        appendParam("page_type", r34, r3);
        AnchorV3Starter r35 = this.c;
        if (r35 == null) goto L81;
        ECLubanData r36 = r35.z;
        if (r36 == null) goto L81;
        if (r36.isLuban() != true) goto L81;
        String r37 = String.valueOf(1);
    L82:
        appendParam("is_ad", r37, r3);
        AnchorV3Starter r38 = this.c;
        if (r38 == null) goto L89;
        ECLogExtraData r39 = r38.A;
        if (r39 == null) goto L89;
        String r40 = r39.getV3EventsAdditions();
        if (r40 == null) goto L89;
        JSONObject r41 = com.bytedance.android.shopping.extensions.k.w(r40);
    L90:
        a(r41);
        AnchorV3Starter r42 = this.c;
        if (r42 == null) goto L95;
        ECLogExtraData r43 = r42.A;
        if (r43 == null) goto L95;
        String r44 = r43.getEComEntranceForm();
    L96:
        appendParam("ecom_entrance_form", r44, r3);
        AnchorV3Starter r45 = this.c;
        if (r45 == null) goto L99;
        r1 = r45.E;
    L99:
        appendParam("room_id", r1, r3);
        return;
    L95:
        r44 = null;
    L89:
        r41 = null;
    L81:
        r37 = String.valueOf(0);
    L73:
        r34 = "half_screen";
        goto L74
    L65:
        r31 = null;
    L61:
        r29 = null;
    L53:
        r25 = null;
    L47:
        r22 = null;
    L41:
        r19 = null;
    L32:
        r16 = true;
    L27:
        r15 = false;
    L17:
        r9 = null;
    L11:
        r6 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public v() {
    }
}
