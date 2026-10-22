package si3;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.aggregate.ShopAggregatePageFragment;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static void a(Context r44, Uri r45, boolean r46) {
        Intrinsics.checkNotNullParameter(r44, "context");
        Intrinsics.checkNotNullParameter(r45, "uri");
        String r3 = UriProtector.getQueryParameter(r45, "material_id");
        if (r3 == null) goto L8;
        String r4 = StringsKt.replace$default(r3, "_is_custom", "", false, 4, null);
        if (r4 == null) goto L8;
        String r9 = r4;
    L9:
        ShopAggregatePageFragment.a r5 = ShopAggregatePageFragment.h;
        String r6 = UriProtector.getQueryParameter(r45, "uid");
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        String r7 = UriProtector.getQueryParameter(r45, "sec_uid");
        if (r7 != null) goto L15;
        r7 = "";
    L15:
        String r8 = UriProtector.getQueryParameter(r45, "shop_id");
        if (r8 != null) goto L18;
        r8 = "";
    L18:
        String r10 = UriProtector.getQueryParameter(r45, "sec_shop_id");
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        String r11 = UriProtector.getQueryParameter(r45, "enter_from");
        String r12 = "open_url";
        if (r11 != null) goto L24;
        r11 = "open_url";
    L24:
        String r13 = UriProtector.getQueryParameter(r45, "enter_from");
        if (r13 != null) goto L27;
        r13 = "click_open_url";
    L27:
        String r14 = UriProtector.getQueryParameter(r45, "enter_method");
        if (r14 == null) goto L31;
        r12 = r14;
    L31:
        String r15 = UriProtector.getQueryParameter(r45, "material_title");
        if (r15 != null) goto L34;
        r15 = "";
    L34:
        String r16 = UriProtector.getQueryParameter(r45, "token");
        if (r16 != null) goto L37;
        r16 = "";
    L37:
        boolean r17 = Intrinsics.areEqual(UriProtector.getQueryParameter(r45, "show_add_cart"), CommentScene.COMMENTSCENE_NO_AWEME);
        String r18 = UriProtector.getQueryParameter(r45, "temp_id");
        if (r18 != null) goto L40;
        r18 = "";
        String r19 = r18;
    L41:
        String r0 = UriProtector.getQueryParameter(r45, "follow_status");
        if (r0 != null) goto L44;
        String r110 = r19;
    L45:
        String r1 = UriProtector.getQueryParameter(r45, "custom_ids");
        if (r1 != null) goto L48;
        String r111 = r19;
    L49:
        String r2 = UriProtector.getQueryParameter(r45, "custom_id_type");
        if (r2 != null) goto L52;
        String r112 = r19;
    L53:
        String r20 = UriProtector.getQueryParameter(r45, "store_source_page");
        if (r20 != null) goto L56;
        String r21 = r19;
    L57:
        String r22 = UriProtector.getQueryParameter(r45, "store_source_method");
        if (r22 != null) goto L60;
        String r23 = r19;
    L61:
        String r24 = UriProtector.getQueryParameter(r45, "store_group_type");
        if (r24 != null) goto L64;
        String r25 = r19;
    L65:
        String r26 = UriProtector.getQueryParameter(r45, "pass_through_api");
        if (r26 != null) goto L68;
        String r27 = r19;
    L69:
        String r28 = UriProtector.getQueryParameter(r45, "log_extra");
        if (r28 != null) goto L72;
        String r29 = r19;
    L73:
        String r30 = UriProtector.getQueryParameter(r45, "tab_name_second");
        if (r30 != null) goto L76;
        String r210 = r19;
    L77:
        String r31 = UriProtector.getQueryParameter(r45, "tab_name");
        if (r31 != null) goto L80;
        String r211 = r19;
    L81:
        String r32 = UriProtector.getQueryParameter(r45, "room_id");
        if (r32 != null) goto L84;
        String r212 = r19;
    L85:
        String r33 = UriProtector.getQueryParameter(r45, "anchor_id");
        if (r33 != null) goto L88;
        String r213 = r19;
    L89:
        String r34 = UriProtector.getQueryParameter(r45, "page_type");
        if (r34 != null) goto L92;
        String r214 = r19;
    L93:
        String r35 = UriProtector.getQueryParameter(r45, "meta_info");
        if (r35 != null) goto L96;
        String r36 = r19;
    L97:
        String r37 = UriProtector.getQueryParameter(r45, "tmp_id");
        if (r37 != null) goto L100;
        String r38 = r19;
    L101:
        String r39 = UriProtector.getQueryParameter(r45, "tab_label");
        if (r39 != null) goto L104;
        String r310 = r19;
    L105:
        String r40 = UriProtector.getQueryParameter(r45, "category_id");
        if (r40 != null) goto L108;
        String r311 = r19;
    L109:
        String r41 = UriProtector.getQueryParameter(r45, "tab_type");
        if (r41 != null) goto L112;
        String r312 = r19;
    L113:
        String r42 = UriProtector.getQueryParameter(r45, "page_version");
        if (r42 != null) goto L116;
        String r313 = r19;
    L117:
        String r43 = UriProtector.getQueryParameter(r45, "pre_group_id");
        if (r43 != null) goto L120;
        String r314 = r19;
    L121:
        String r47 = UriProtector.getQueryParameter(r45, "pre_product_id");
        if (r47 != null) goto L124;
        String r315 = r19;
    L125:
        String r48 = UriProtector.getQueryParameter(r45, "pre_room_id");
        if (r48 != null) goto L128;
        String r316 = r19;
    L129:
        String r49 = UriProtector.getQueryParameter(r45, "search_params");
        if (r49 != null) goto L132;
        String r317 = r19;
    L133:
        String r50 = UriProtector.getQueryParameter(r45, "entrance_info");
        if (r50 != null) goto L136;
        String r410 = r19;
    L137:
        String r51 = UriProtector.getQueryParameter(r45, "tag_data");
        if (r51 != null) goto L140;
        String r411 = r19;
    L141:
        int r412 = k.r(UriProtector.getQueryParameter(r45, "selected_index"), 0);
        String r52 = UriProtector.getQueryParameter(r45, "category_info");
        if (r52 != null) goto L144;
        String r413 = r19;
    L145:
        r5.getClass();
        ShopAggregatePageFragment.a.a(r44, r45, r6, r7, r8, r10, r11, r13, r12, r9, r15, r16, r17, r18, r110, r111, r112, r46, r21, r23, r25, r27, r29, r210, r211, r212, r213, r214, r38, r36, r310, r311, r312, r313, r315, r314, r316, r317, r411, r412, r413, r410);
        return;
    L144:
        r413 = r52;
        goto L145
    L140:
        r411 = r51;
        goto L141
    L136:
        r410 = r50;
        goto L137
    L132:
        r317 = r49;
        goto L133
    L128:
        r316 = r48;
        goto L129
    L124:
        r315 = r47;
        goto L125
    L120:
        r314 = r43;
        goto L121
    L116:
        r313 = r42;
        goto L117
    L112:
        r312 = r41;
        goto L113
    L108:
        r311 = r40;
        goto L109
    L104:
        r310 = r39;
        goto L105
    L100:
        r38 = r37;
        goto L101
    L96:
        r36 = r35;
        goto L97
    L92:
        r214 = r34;
        goto L93
    L88:
        r213 = r33;
        goto L89
    L84:
        r212 = r32;
        goto L85
    L80:
        r211 = r31;
        goto L81
    L76:
        r210 = r30;
        goto L77
    L72:
        r29 = r28;
        goto L73
    L68:
        r27 = r26;
        goto L69
    L64:
        r25 = r24;
        goto L65
    L60:
        r23 = r22;
        goto L61
    L56:
        r21 = r20;
        goto L57
    L52:
        r112 = r2;
        goto L53
    L48:
        r111 = r1;
        goto L49
    L44:
        r110 = r0;
        goto L45
    L40:
        r19 = "";
    L8:
        r9 = "";
        goto L9
    }
}
