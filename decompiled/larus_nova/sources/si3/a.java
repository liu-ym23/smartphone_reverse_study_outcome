package si3;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.ShopAggregatePageFragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static void a(Context r410, Uri r411, boolean r412) {
        Intrinsics.checkNotNullParameter(r410, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r411, "uri");
        String r100 = UriProtector.getQueryParameter(r411, "material_id");
        if (r100 == null) goto L8;
        String r101 = StringsKt.replace$default(r100, "_is_custom", "", false, 4, null);
        if (r101 == null) goto L8;
        String r102 = r101;
    L9:
        ShopAggregatePageFragment.a r103 = ShopAggregatePageFragment.f183350h;
        String r104 = UriProtector.getQueryParameter(r411, "uid");
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        String r105 = UriProtector.getQueryParameter(r411, "sec_uid");
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        String r106 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_SHOP_ID);
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        String r107 = UriProtector.getQueryParameter(r411, "sec_shop_id");
        if (r107 != null) goto L21;
        r107 = "";
    L21:
        String r110 = UriProtector.getQueryParameter(r411, "enter_from");
        String r111 = "open_url";
        if (r110 != null) goto L24;
        r110 = "open_url";
    L24:
        String r108 = UriProtector.getQueryParameter(r411, "enter_from");
        if (r108 != null) goto L27;
        r108 = "click_open_url";
    L27:
        String r112 = UriProtector.getQueryParameter(r411, "enter_method");
        if (r112 == null) goto L31;
        r111 = r112;
    L31:
        String r113 = UriProtector.getQueryParameter(r411, "material_title");
        if (r113 != null) goto L34;
        r113 = "";
    L34:
        String r114 = UriProtector.getQueryParameter(r411, "token");
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        boolean r115 = Intrinsics.areEqual(UriProtector.getQueryParameter(r411, "show_add_cart"), "1");
        String r116 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_TEMP_ID);
        if (r116 != null) goto L40;
        r116 = "";
        String r117 = r116;
    L41:
        String r109 = UriProtector.getQueryParameter(r411, "follow_status");
        if (r109 != null) goto L44;
        String r118 = r117;
    L45:
        String r119 = UriProtector.getQueryParameter(r411, "custom_ids");
        if (r119 != null) goto L48;
        String r120 = r117;
    L49:
        String r121 = UriProtector.getQueryParameter(r411, "custom_id_type");
        if (r121 != null) goto L52;
        String r122 = r117;
    L53:
        String r123 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE);
        if (r123 != null) goto L56;
        String r210 = r117;
    L57:
        String r124 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD);
        if (r124 != null) goto L60;
        String r211 = r117;
    L61:
        String r125 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE);
        if (r125 != null) goto L64;
        String r212 = r117;
    L65:
        String r126 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_PASS_THROUGH_API);
        if (r126 != null) goto L68;
        String r213 = r117;
    L69:
        String r127 = UriProtector.getQueryParameter(r411, "log_extra");
        if (r127 != null) goto L72;
        String r214 = r117;
    L73:
        String r128 = UriProtector.getQueryParameter(r411, "tab_name_second");
        if (r128 != null) goto L76;
        String r215 = r117;
    L77:
        String r129 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
        if (r129 != null) goto L80;
        String r216 = r117;
    L81:
        String r130 = UriProtector.getQueryParameter(r411, "room_id");
        if (r130 != null) goto L84;
        String r217 = r117;
    L85:
        String r131 = UriProtector.getQueryParameter(r411, "anchor_id");
        if (r131 != null) goto L88;
        String r218 = r117;
    L89:
        String r132 = UriProtector.getQueryParameter(r411, "page_type");
        if (r132 != null) goto L92;
        String r219 = r117;
    L93:
        String r133 = UriProtector.getQueryParameter(r411, "meta_info");
        if (r133 != null) goto L96;
        String r310 = r117;
    L97:
        String r134 = UriProtector.getQueryParameter(r411, "tmp_id");
        if (r134 != null) goto L100;
        String r311 = r117;
    L101:
        String r135 = UriProtector.getQueryParameter(r411, "tab_label");
        if (r135 != null) goto L104;
        String r312 = r117;
    L105:
        String r136 = UriProtector.getQueryParameter(r411, "category_id");
        if (r136 != null) goto L108;
        String r313 = r117;
    L109:
        String r137 = UriProtector.getQueryParameter(r411, "tab_type");
        if (r137 != null) goto L112;
        String r314 = r117;
    L113:
        String r138 = UriProtector.getQueryParameter(r411, "page_version");
        if (r138 != null) goto L116;
        String r315 = r117;
    L117:
        String r139 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID);
        if (r139 != null) goto L120;
        String r316 = r117;
    L121:
        String r140 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID);
        if (r140 != null) goto L124;
        String r317 = r117;
    L125:
        String r141 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID);
        if (r141 != null) goto L128;
        String r318 = r117;
    L129:
        String r142 = UriProtector.getQueryParameter(r411, "search_params");
        if (r142 != null) goto L132;
        String r319 = r117;
    L133:
        String r143 = UriProtector.getQueryParameter(r411, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        if (r143 != null) goto L136;
        String r413 = r117;
    L137:
        String r144 = UriProtector.getQueryParameter(r411, "tag_data");
        if (r144 != null) goto L140;
        String r414 = r117;
    L141:
        int r415 = k.r(UriProtector.getQueryParameter(r411, "selected_index"), 0);
        String r145 = UriProtector.getQueryParameter(r411, "category_info");
        if (r145 != null) goto L144;
        String r416 = r117;
    L145:
        r103.getClass();
        ShopAggregatePageFragment.a.a(r410, r411, r104, r105, r106, r107, r110, r108, r111, r102, r113, r114, r115, r116, r118, r120, r122, r412, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r311, r310, r312, r313, r314, r315, r317, r316, r318, r319, r414, r415, r416, r413);
        return;
    L144:
        r416 = r145;
        goto L145
    L140:
        r414 = r144;
        goto L141
    L136:
        r413 = r143;
        goto L137
    L132:
        r319 = r142;
        goto L133
    L128:
        r318 = r141;
        goto L129
    L124:
        r317 = r140;
        goto L125
    L120:
        r316 = r139;
        goto L121
    L116:
        r315 = r138;
        goto L117
    L112:
        r314 = r137;
        goto L113
    L108:
        r313 = r136;
        goto L109
    L104:
        r312 = r135;
        goto L105
    L100:
        r311 = r134;
        goto L101
    L96:
        r310 = r133;
        goto L97
    L92:
        r219 = r132;
        goto L93
    L88:
        r218 = r131;
        goto L89
    L84:
        r217 = r130;
        goto L85
    L80:
        r216 = r129;
        goto L81
    L76:
        r215 = r128;
        goto L77
    L72:
        r214 = r127;
        goto L73
    L68:
        r213 = r126;
        goto L69
    L64:
        r212 = r125;
        goto L65
    L60:
        r211 = r124;
        goto L61
    L56:
        r210 = r123;
        goto L57
    L52:
        r122 = r121;
        goto L53
    L48:
        r120 = r119;
        goto L49
    L44:
        r118 = r109;
        goto L45
    L40:
        r117 = "";
    L8:
        r102 = "";
        goto L9
    }
}
