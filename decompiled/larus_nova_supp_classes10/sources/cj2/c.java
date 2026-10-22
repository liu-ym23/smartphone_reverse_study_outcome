package cj2;

import android.text.TextUtils;
import com.bytedance.android.ec.core.utils.g;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.playback.LogExtraData;
import com.bytedance.android.ec.model.playback.PlaybackEventExtraData;
import com.bytedance.android.livesdk.livecommerce.playback.applog.ExplainPlayBackPDPEntryLogExtra;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import dj2.e;
import dj2.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final /* synthetic */ int d = 0;
    public final HashMap<String, String> a;
    public double b;
    public double c;

    public static final class a {
        public static c a(e r13) {
            Intrinsics.checkNotNullParameter(r13, "param");
            c r0 = new c();
            r0.b = g.a();
            f r1 = r13.a;
            if (r1 == null) goto L5;
            String r3 = String.valueOf(r1.a);
            String r2 = String.valueOf(r1.b);
        L6:
            LogExtraData r4 = r13.b;
            String r5 = null;
            if (r4 == null) goto L9;
            String r6 = r4.getSourcePage();
        L10:
            r0.a("source_page", r6, "");
            r0.a("commodity_id", r3, "");
            r0.a("product_id", r2, "");
            PlaybackEventExtraData r7 = r13.c;
            if (r7 == null) goto L13;
            String r8 = r7.getCommodityType();
        L14:
            r0.a("commodity_type", r8, "");
            PlaybackEventExtraData r9 = r13.c;
            if (r9 == null) goto L17;
            String r10 = r9.getFollowStatus();
        L18:
            r0.a("follow_status", String.valueOf(r10), BDLocationException.ERROR_TIMEOUT);
            LogExtraData r11 = r13.b;
            if (r11 == null) goto L21;
            String r12 = r11.getEComEntranceForm();
        L22:
            r0.a("enter_from_merge", r12, "");
            LogExtraData r14 = r13.b;
            if (r14 == null) goto L25;
            String r15 = r14.getEnterMethod();
        L26:
            r0.a("enter_method", r15, "");
            PlaybackEventExtraData r16 = r13.c;
            if (r16 == null) goto L29;
            String r17 = r16.getWithSku();
        L30:
            r0.a("with_sku", r17, "");
            PlaybackEventExtraData r18 = r13.c;
            if (r18 == null) goto L33;
            String r19 = r18.getUserId();
        L34:
            r0.a("author_id", r19, "");
            LogExtraData r20 = r13.b;
            if (r20 == null) goto L37;
            String r21 = r20.getRoomId();
        L38:
            r0.a("room_id", r21, "");
            if (EComABUtils.isOuterEntranceInfoReport() == true) goto L45;
            LogExtraData r22 = r13.b;
            if (r22 == null) goto L43;
            String r23 = r22.getEntranceInfo();
        L44:
            r0.a("entrance_info", r23, "");
            goto L45
        L43:
            r23 = null;
        L45:
            LogExtraData r24 = r13.b;
            if (r24 == null) goto L48;
            String r25 = r24.getFragmentId();
        L49:
            r0.a("fragment_id", r25, "");
            LogExtraData r26 = r13.b;
            if (r26 == null) goto L52;
            String r27 = r26.getEnterScene();
        L53:
            r0.a("enter_scene", r27, "");
            LogExtraData r28 = r13.b;
            if (r28 == null) goto L56;
            String r29 = r28.getEntranceInfo();
        L57:
            JSONObject r30 = z1.g(r29);
            LogExtraData r31 = r13.b;
            if (r31 == null) goto L70;
            String r32 = r31.getCarrierSource();
            if (r32 == null) goto L70;
            if (r32.length() <= 0) goto L64;
            boolean r33 = true;
        L65:
            if (r33 == true) goto L68;
            r32 = null;
        L68:
            if (r32 == null) goto L70;
            r0.a("carrier_source", r32, "");
        L75:
            LogExtraData r34 = r13.b;
            if (r34 == null) goto L78;
            String r35 = r34.getEnterScene();
        L80:
            if (Intrinsics.areEqual(r35, "search") == false) goto L82;
            r0.a("ecom_group_type", "product_card", "");
        L86:
            r0.a("source_method", "replay_popup_card", "");
            if (r30 == null) goto L95;
            String r110 = r30.optString("group_id");
            HashMap<String, String> r111 = r0.a;
            if (TextUtils.isEmpty(r110) == true) goto L95;
            if (TextUtils.equals("null", r110) == true) goto L95;
            if (r110 != null) goto L94;
            r110 = "";
        L94:
            r111.put("live_group_id", r110);
        L95:
            LogExtraData r112 = r13.b;
            if (r112 == null) goto L100;
            Intrinsics.checkNotNullParameter(r112, "$this$isFromProductDetail");
            if (Intrinsics.areEqual(r112.getSourcePage(), "product_detail") != true) goto L100;
            r0.a("page_name", "product_detail_replay", "");
        L100:
            LogExtraData r113 = r13.b;
            if (r113 == null) goto L103;
            String r114 = r113.getSearchParam();
        L104:
            r0.a("search_params", r114, "");
            ExplainPlayBackPDPEntryLogExtra r115 = r13.d;
            if (r115 == null) goto L107;
            r0.a("is_float", r115.isFloat(), "");
            r0.a("entrance_form", r115.getEntranceForm(), "");
        L107:
            PlaybackEventExtraData r116 = r13.c;
            if (r116 == null) goto L112;
            Integer r117 = r116.getModelType();
            if (r117 == null) goto L112;
            r5 = String.valueOf(r117.intValue());
        L112:
            HashMap<String, String> r118 = r0.a;
            if (TextUtils.isEmpty(r5) == true) goto L120;
            if (TextUtils.equals("null", r5) == true) goto L120;
            if (r5 != null) goto L118;
            r5 = "";
        L118:
            r118.put("model_type", r5);
        L120:
            if (ExplainPlaybackUtils.d() == false) goto L155;
            f r119 = r13.a;
            if (EComABUtils.isOuterEntranceInfoReport() == false) goto L129;
            if (r119 == null) goto L129;
            Map<String, String> r120 = r119.c;
            if (r120 == null) goto L129;
            r0.a("author_type", r120.get("author_type"), "");
            r0.a("video_id", r120.get("video_id"), "");
            r0.a("total_duration", r120.get("total_duration"), "");
            r0.a("video_quality", r120.get("video_quality"), "");
        L129:
            if (EComABUtils.isOuterEntranceInfoReport() == false) goto L184;
            if (r30 == null) goto L184;
            Iterator<String> r121 = r30.keys();
        L134:
            if (r121.hasNext() == false) goto L184;
            String r36 = r121.next();
            String r37 = r30.optString(r36);
            if (r36 == null) goto L154;
            int r38 = r36.hashCode();
            if (r38 != (-758956222)) goto L141;
            if (r36.equals("carrier_source") == false) goto L154;
        L141:
            if (r38 != (-316981042)) goto L143;
            if (r36.equals("live_group_id") == false) goto L154;
        L143:
            if (r38 != 186187293) goto L154;
            if (r36.equals("ecom_group_type") == true) goto L134;
        L154:
            r0.a(r36, r37, "");
        L184:
            return r0;
        L155:
            f r122 = r13.a;
            if (r122 == null) goto L171;
            Map<String, String> r123 = r122.c;
            if (r123 == null) goto L171;
            Iterator<Map.Entry<String, String>> r124 = r123.entrySet().iterator();
        L161:
            if (r124.hasNext() == false) goto L171;
            Map.Entry<String, String> r39 = r124.next();
            String r40 = r39.getKey();
            String r41 = r39.getValue();
            String r42 = r0.a.get(r40);
            if (r42 != null) goto L165;
        L168:
            boolean r43 = true;
        L169:
            if (r43 == false) goto L161;
            r0.a(r40, r41, "");
            goto L161
        L165:
            if (r42.length() == 0) goto L168;
            r43 = false;
        L171:
            if (r30 == null) goto L184;
            Iterator<String> r125 = r30.keys();
        L174:
            if (r125.hasNext() == false) goto L184;
            String r44 = r125.next();
            String r45 = r0.a.get(r44);
            if (r45 != null) goto L178;
        L181:
            boolean r46 = true;
        L182:
            if (r46 == false) goto L174;
            r0.a(r44, r30.optString(r44), "");
            goto L174
        L178:
            if (r45.length() == 0) goto L181;
            r46 = false;
            goto L182
        L103:
            r114 = null;
            goto L104
        L82:
            if (r30 == null) goto L84;
            String r47 = r30.optString("ecom_group_type");
        L85:
            r0.a("ecom_group_type", r47, "product_card");
            goto L86
        L84:
            r47 = null;
            goto L85
        L78:
            r35 = null;
            goto L80
        L64:
            r33 = false;
        L70:
            if (r30 == null) goto L73;
            String r48 = r30.optString("carrier_source");
            if (r48 == null) goto L73;
        L74:
            r0.a("carrier_source", r48, "");
        L73:
            r48 = "";
            goto L74
        L56:
            r29 = null;
            goto L57
        L52:
            r27 = null;
            goto L53
        L48:
            r25 = null;
            goto L49
        L37:
            r21 = null;
            goto L38
        L33:
            r19 = null;
            goto L34
        L29:
            r17 = null;
            goto L30
        L25:
            r15 = null;
            goto L26
        L21:
            r12 = null;
            goto L22
        L17:
            r10 = null;
            goto L18
        L13:
            r8 = null;
            goto L14
        L9:
            r6 = null;
            goto L10
        L5:
            r2 = "";
            r3 = r2;
            goto L6
        }
    }

    static {
    }

    public c() {
        this.a = new HashMap();
        this.b = -1.0d;
        this.c = -1.0d;
    }

    public final void a(String r3, String r4, String r5) {
        HashMap<String, String> r0 = this.a;
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L9:
        r4 = r5;
    L10:
        r0.put(r3, r4);
        return;
    L5:
        if (TextUtils.equals("null", r4) == true) goto L9;
        if (r4 != null) goto L10;
        r4 = "";
        goto L10
    }
}
