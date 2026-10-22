package u34;

import com.bytedance.ai.api.navi.AppletNaviType;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.awemeopen.infra.base.event.b;
import com.bytedance.awemeopen.infra.base.event.d;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f548581b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f548582a;

    /* JADX INFO: renamed from: u34.a$a, reason: collision with other inner class name */
    public static final class C7826a {
    }

    static {
    }

    public a() {
    }

    public static String a(String r100) {
        int r101 = r100.hashCode();
        if (r101 == 50) goto L17;
        if (r101 == 46819565) goto L14;
        if (r101 == 46819567) goto L10;
        return r100;
    L10:
        if (r100.equals("13012") == false) goto L25;
        return "poi_combo";
    L25:
        return r100;
    L14:
        if (r100.equals("13010") == false) goto L22;
        return "poi_product";
    L22:
        return r100;
    L17:
        if (r100.equals("2") == false) goto L26;
        return AppletNaviType.POI;
    L26:
        return r100;
    }

    public static String b(String r100) {
        return r100.concat("_video");
    }

    public final void e(String r100, String r101, String r102, String r103, String r104, String r105, d r106) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "enterFrom");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "authorOpenId");
        Intrinsics.checkNotNullParameter(r103, "groupId");
        Intrinsics.checkNotNullParameter(r104, "hostGroupId");
        Intrinsics.checkNotNullParameter(r105, "toUserId");
        b.C2872b r107 = b.a(r100);
        r107.d("enter_from", UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT);
        r107.d("enter_method", r101);
        r107.d("author_openid", r102);
        r107.d("group_id", r103);
        r107.d("host_group_id", r104);
        r107.d(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r105);
        r107.b(r106, this.f548582a).b();
    }

    public static void g(a r110, String r111, String r112, String r113, String r210, String r211, int r212, String r213, String r214, String r215, int r216, String r217, String r218, String r219, String r310, String r311, Integer r312, boolean r313, String r314, boolean r315, d r316, JSONObject r317, int r318) {
        if ((r318 & 524288) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r318 & 1048576) == 0) goto L9;
        Integer r114 = null;
    L11:
        if ((r318 & 33554432) == 0) goto L13;
        JSONObject r115 = null;
    L14:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "productName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r112, "requestId");
        Intrinsics.checkNotNullParameter(r113, "authorOpenId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter(r214, "imprId");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r215, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        JSONObject r319 = r115;
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r314, "recommendInfo");
        b.C2872b r101 = b.a(r111);
        r101.d("enter_from", r217);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r101.d("author_id", r113);
        r101.d("author_openid", r113);
        r101.d("request_id", r112);
        r101.d("follow_status", Integer.valueOf(r212));
        r101.d("product_id", r213);
        r101.d("log_extra", "");
        r101.d("cid", "");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r215);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, Integer.valueOf(r216));
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "video");
        r101.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "video_cart_tag");
        r101.d("page_name", r219);
        r101.d("source_page", r100);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r310);
        r101.d("aweme_type", r114);
        r101.d("group_id", r210);
        r101.d("host_group_id", r211);
        r101.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r313 ? 1 : 0));
        r101.d("is_card_sdk", Integer.valueOf(r315 ? 1 : 0));
        if (r218 != null) goto L17;
    L22:
        r101.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r314);
        r101.d("impr_id", r214);
        r101.f198612d = r319;
        r101.b(r316, r110.f548582a).b();
        return;
    L17:
        if ((!StringsKt.isBlank(r218)) == false) goto L19;
        String r102 = r218;
    L20:
        if (r102 == null) goto L22;
        r101.d("host_enter_from", r102);
        goto L22
    L19:
        r102 = null;
        goto L20
    L13:
        r115 = r317;
        goto L14
    L9:
        r114 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    public final void f(String r110, String r111, String r112, String r113, String r210, int r211, String r212, String r213, String r214, int r215, String r216, String r217, String r218, String r219, String r310, String r311, Integer r312, boolean r313, String r314, boolean r315, boolean r316, d r317, JSONObject r318) {
        Intrinsics.checkNotNullParameter(r110, "productName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r111, "requestId");
        Intrinsics.checkNotNullParameter(r112, "authorOpenId");
        Intrinsics.checkNotNullParameter(r113, "groupId");
        Intrinsics.checkNotNullParameter(r210, "hostGroupId");
        Intrinsics.checkNotNullParameter(r212, "productId");
        Intrinsics.checkNotNullParameter("", "logExtra");
        Intrinsics.checkNotNullParameter(r213, "imprId");
        Intrinsics.checkNotNullParameter("", "cid");
        Intrinsics.checkNotNullParameter(r214, "commodityId");
        Intrinsics.checkNotNullParameter("video", "ecomGroupType");
        Intrinsics.checkNotNullParameter("video_cart_tag", "ecomEntranceForm");
        Intrinsics.checkNotNullParameter(r314, "recommendInfo");
        b.C2872b r100 = b.a(r110);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r100.d("author_id", r112);
        r100.d("author_openid", r112);
        r100.d("request_id", r111);
        r100.d("follow_status", Integer.valueOf(r211));
        r100.d("product_id", r212);
        r100.d("log_extra", "");
        r100.d("cid", "");
        r100.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r214);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, Integer.valueOf(r215));
        r100.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "video");
        r100.d("enter_from", r216);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "video_cart_tag");
        r100.d("source_page", r218);
        r100.d("page_name", r310);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r311);
        r100.d("aweme_type", r312);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r219);
        r100.d("group_id", r113);
        r100.d("host_group_id", r210);
        r100.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r313 ? 1 : 0));
        r100.d("is_card_sdk", Integer.valueOf(r315 ? 1 : 0));
        r100.d("entrance_auto_opened", Boolean.valueOf(r316));
        if (r217 != null) goto L5;
    L10:
        r100.d(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r314);
        r100.d("impr_id", r213);
        r100.f198612d = r318;
        r100.b(r317, this.f548582a).b();
        return;
    L5:
        if ((!StringsKt.isBlank(r217)) == false) goto L7;
        String r101 = r217;
    L8:
        if (r101 == null) goto L10;
        r100.d("host_enter_from", r101);
        goto L10
    L7:
        r101 = null;
        goto L8
    }

    public static /* synthetic */ void d(a r210, String r211, String r212, String r310, String r311, String r312, int r313, String r314, String r315, String r316, String r317, String r318, String r319, d r410, boolean r411, boolean r412, String r413, int r414, Map r415, JSONObject r416, String r417, String r418, String r419, String r510, boolean r511) {
        r210.c(r211, r212, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, 0);
    }

    public final void c(String r110, String r111, String r112, String r210, String r211, int r212, String r213, String r214, String r215, String r216, String r217, String r218, d r219, boolean r310, boolean r311, String r312, int r313, Map r314, JSONObject r315, String r316, String r317, String r318, String r319, boolean r410, long r411) {
        Intrinsics.checkNotNullParameter(r110, "productName");
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.VALUE_TEMAI, "eventOriginFeature");
        Intrinsics.checkNotNullParameter(r111, "requestId");
        Intrinsics.checkNotNullParameter(r112, "authorId");
        Intrinsics.checkNotNullParameter(r210, "groupId");
        Intrinsics.checkNotNullParameter(r211, "hostGroupId");
        Intrinsics.checkNotNullParameter(r213, "anchorId");
        Intrinsics.checkNotNullParameter(r214, "logExtra");
        Intrinsics.checkNotNullParameter(r215, "feedType");
        Intrinsics.checkNotNullParameter(r216, "enterFrom");
        Intrinsics.checkNotNullParameter(r218, "pageName");
        Intrinsics.checkNotNullParameter(r312, "anchorType");
        Intrinsics.checkNotNullParameter(r316, "anchorIdReal");
        Intrinsics.checkNotNullParameter(r317, "anchorTypeReal");
        Intrinsics.checkNotNullParameter(r318, "enterFromReal");
        Intrinsics.checkNotNullParameter(r319, "enterMethodReal");
        b.C2872b r113 = b.a(r110);
        r113.d(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r113.d("author_openid", r112);
        r113.d("anchor_id", r213);
        r113.d("request_id", r111);
        r113.d("impr_id", r111);
        r113.d("follow_status", Integer.valueOf(r212));
        r113.d("log_extra", r214);
        r113.d("enter_from", r216);
        r113.d("enter_method", r319);
        r113.d("source_page", r216);
        r113.d("page_name", r218);
        r113.d("group_id", r210);
        r113.d("host_group_id", r211);
        r113.d(com.bytedance.android.ec.core.event.a.KEY_IS_FIRST, Integer.valueOf(r310 ? 1 : 0));
        r113.d("is_card_sdk", Integer.valueOf(r311 ? 1 : 0));
        r113.d("feed_type", r215);
        r113.d("poi_type", Integer.valueOf(r313));
        r113.d("override_anchor_info", Integer.valueOf(r410 ? 1 : 0));
        if (r411 <= 0) goto L5;
        r113.d("duration", Long.valueOf(r411));
    L5:
        String r100 = null;
        if (r314 != null) goto L8;
    L16:
        if (r217 != null) goto L18;
    L22:
        r113.d("anchor_id_real", r316);
        r113.d("anchor_type_real", r317);
        r113.d("enter_from_real", r318);
        r113.d("enter_method_real", r319);
        r113.d("anchor_type", a(r312));
        r113.d("anchor_name", a(r312));
        r113.f198612d = r315;
        r113.b(r219, this.f548582a).b();
        return;
    L18:
        if ((!StringsKt.isBlank(r217)) == false) goto L20;
        r100 = r217;
    L20:
        if (r100 == null) goto L22;
        r113.d("host_enter_from", r100);
        goto L22
    L8:
        if ((!r314.isEmpty()) == false) goto L10;
        Map r101 = r314;
    L11:
        if (r101 == null) goto L16;
        Iterator r102 = r101.entrySet().iterator();
    L14:
        if (r102.hasNext() == false) goto L16;
        Map.Entry r103 = (Map.Entry) r102.next();
        r113.d((String) r103.getKey(), r103.getValue());
        goto L14
    L10:
        r101 = null;
        goto L11
    }
}
