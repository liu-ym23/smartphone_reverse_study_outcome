package com.bytedance.android.shopping.store.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.m0;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.floatlayout.StoreFloatLayout;
import com.bytedance.android.ec.store.setting.SettingKeys;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.bytedance.android.shopping.store.repository.dto.StoreV3FollowCommitDTO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ ECShopFollowBasePresenter a;

    public g(ECShopFollowBasePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r24) {
        StoreV3FollowCommitDTO r1 = (StoreV3FollowCommitDTO) r24;
        if (r1.getStatusCode() == 0) goto L5;
        ECShopFollowBasePresenter.q0(this.a);
        return;
    L5:
        ECStoreViewModel r2 = this.a.T();
        sj3.j r3 = r1.getShopFollowGiftDTO();
        final String r4 = null;
        if (r3 == null) goto L8;
        String r5 = r3.a();
    L9:
        r2.setFollowGiftData(r5);
        ECShopFollowBasePresenter r6 = this.a;
        StoreFollowGiftConfig r7 = r6.u;
        boolean r8 = false;
        if (r7 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        r6.A = r9;
        this.a.t0(true, null);
        int r10 = uj3.h.e;
        Intrinsics.checkNotNullParameter(r1, "dto");
        final uj3.h r11 = new uj3.h();
        r11.a = r1.getFollowSuccessMsg();
        r11.c = r1.getHybridComponentDTO();
        sj3.j r12 = r1.getShopFollowGiftDTO();
        if (r12 == null) goto L19;
        com.bytedance.android.ec.store.repository.dto.d r13 = r12.b();
    L20:
        r11.d = r13;
        sj3.j r14 = r1.getShopFollowGiftDTO();
        if (r14 == null) goto L23;
        int r15 = uj3.i.c;
        Intrinsics.checkNotNullParameter(r14, "dto");
        uj3.i r16 = new uj3.i();
        r16.a = r14.c();
        r16.b = r14.a();
    L24:
        r11.b = r16;
        if (this.a.T().getCurrentTabIsLive() == false) goto L53;
        ECShopFollowBasePresenter r17 = this.a;
        r17.getClass();
        uj3.i r18 = r11.b;
        if (r18 != null) goto L29;
        ECToast.showToast$default(ECToast.INSTANCE, r17.u().c(), ag4.a.d(2131896851), null, 4, null);
        return;
    L29:
        String r19 = r18.b;
        if (r19 != null) goto L32;
    L33:
        r8 = true;
    L34:
        if (r8 == false) goto L36;
        ECToast.showToast$default(ECToast.INSTANCE, r17.u().c(), ag4.a.d(2131896851), null, 4, null);
        return;
    L36:
        Integer r20 = ((sj3.a) u0.b(r19, sj3.a.class)).a();
        if (r20 != null) goto L40;
    L42:
        if (r20 != null) goto L45;
    L47:
        if (r20 != null) goto L50;
    L52:
        ECToast.showToast$default(ECToast.INSTANCE, r17.u().c(), ag4.a.d(2131896851), null, 4, null);
        return;
    L50:
        if (r20.intValue() != 3) goto L52;
    L51:
        ECToast.showToast$default(ECToast.INSTANCE, r17.u().c(), "关注成功，券已领好下单可用", null, 4, null);
        return;
    L45:
        if (r20.intValue() != 2) goto L47;
    L40:
        if (r20.intValue() != 1) goto L42;
        ECToast.showToast$default(ECToast.INSTANCE, r17.u().c(), "关注成功，券已领好全店可用", null, 4, null);
        return;
    L32:
        if (StringsKt.isBlank(r19) == false) goto L34;
    L53:
        ECShopFollowBasePresenter r21 = this.a;
        r21.getClass();
        if (r11.b != null) goto L170;
        com.bytedance.android.ec.store.repository.dto.d r22 = r11.c;
        if (r22 == null) goto L168;
        Integer r23 = Integer.valueOf(r22.a());
        if (r23 != null) goto L61;
    L79:
        if (r23 != null) goto L82;
    L89:
        final Context r25 = r21.u().c();
        final Fragment r110 = r21.h;
        com.bytedance.android.ec.store.repository.dto.d r26 = r11.c;
        if (r26 == null) goto L92;
        String r27 = r26.c();
    L93:
        final JSONObject r111 = z1.g(r27);
        com.bytedance.android.ec.store.repository.dto.d r28 = r11.c;
        if (r28 == null) goto L96;
        String r112 = r28.e();
    L97:
        final int r113 = r21.e0();
        final boolean r29 = r21.T().isMiddleTabFrameworkOrBrandShop();
        final String r114 = r112;
        StoreFloatLayout r115 = new ECShopFollowBasePresenter$openLynxFloatLayout$1(r11, r25, r110, r111, r114, r113, r29);
        com.bytedance.android.ec.store.repository.dto.d r30 = r11.c;
        if (r30 == null) goto L100;
        String r31 = r30.d();
    L101:
        Pair[] r32 = new Pair[2];
        com.bytedance.android.ec.store.repository.dto.d r33 = r11.c;
        if (r33 == null) goto L104;
        String r34 = r33.c();
    L105:
        r32[0] = TuplesKt.to("data", r34);
        Pair[] r35 = new Pair[24];
        String r36 = r21.T().getStoreParam().getStoreAccountParam().getUserId();
        String r116 = "";
        if (r36 != null) goto L108;
        r36 = "";
    L108:
        r35[0] = TuplesKt.to("kol_id", r36);
        String r37 = r21.T().getStoreParam().getStoreAccountParam().getSecUserId();
        if (r37 != null) goto L111;
        r37 = "";
    L111:
        r35[1] = TuplesKt.to("sec_kol_id", r37);
        r35[2] = TuplesKt.to("entrance_location", r21.T().getStoreParam().getEntranceLocation());
        r35[3] = TuplesKt.to("enter_from", r21.T().getStoreParam().getEntranceLocation());
        String r38 = r21.T().getStoreParam().getShareInfo().getShopName();
        if (r38 != null) goto L114;
        r38 = "";
    L114:
        r35[4] = TuplesKt.to("shop_name", r38);
        r35[5] = TuplesKt.to("is_preview", Boolean.valueOf(r21.T().getStoreParam().isPreview()));
        r35[6] = TuplesKt.to("brand_verified", 0);
        Integer r39 = r21.T().getStoreParam().getFollowStatus();
        if (r39 == null) goto L117;
        String r40 = String.valueOf(r39.intValue());
    L118:
        if (r40 != null) goto L120;
        r40 = "";
    L120:
        r35[7] = TuplesKt.to("follow_status", r40);
        if (r21.T().getStoreParam().isPreview() == false) goto L123;
        String r41 = CommentScene.COMMENTSCENE_NO_AWEME;
    L124:
        r35[8] = TuplesKt.to("is_enter_preview", r41);
        String r42 = r21.T().getStoreParam().getTempId();
        if (r42 != null) goto L127;
        r42 = "";
    L127:
        r35[9] = TuplesKt.to("temp_id", r42);
        String r43 = r21.T().getStoreParam().getSearchParams();
        if (r43 != null) goto L130;
        r43 = "";
    L130:
        r35[10] = TuplesKt.to("search_params", r43);
        String r44 = r21.T().getStoreParam().getStoreSourcePage();
        if (r44 != null) goto L133;
        r44 = "";
    L133:
        r35[11] = TuplesKt.to("store_source_page", r44);
        String r45 = r21.T().getStoreParam().getStoreSourceMethod();
        if (r45 != null) goto L136;
        r45 = "";
    L136:
        r35[12] = TuplesKt.to("store_source_method", r45);
        String r46 = r21.T().getStoreParam().getStoreGroupType();
        if (r46 != null) goto L139;
        r46 = "";
    L139:
        r35[13] = TuplesKt.to("store_group_type", r46);
        String r47 = (String) r21.T().getStoreParam().getPassThroughParam("pass_through_api");
        if (r47 != null) goto L142;
        r47 = "";
    L142:
        r35[14] = TuplesKt.to("pass_through_api", r47);
        String r48 = r21.T().getStoreParam().getShopId();
        if (r48 != null) goto L145;
        r48 = "";
    L145:
        r35[15] = TuplesKt.to("shop_id", r48);
        r35[16] = TuplesKt.to("sec_shop_id", r21.T().getStoreParam().getSecShopId());
        String r49 = r21.T().getStoreParam().getStoreAccountParam().getUserId();
        if (r49 != null) goto L148;
        r49 = "";
    L148:
        r35[17] = TuplesKt.to("author_id", r49);
        String r50 = r21.T().getStoreParam().getProductBasicRequestParam().getTmpId();
        if (r50 != null) goto L151;
        r50 = "";
    L151:
        r35[18] = TuplesKt.to("tmp_id", r50);
        String r51 = r21.T().getStoreParam().getStoreAccountParam().getSecUserId();
        if (r51 != null) goto L154;
        r51 = "";
    L154:
        r35[19] = TuplesKt.to("sec_author_id", r51);
        String r52 = r21.T().getStoreParam().getProductBasicRequestParam().getToken();
        if (r52 == null) goto L158;
        r116 = r52;
    L158:
        r35[20] = TuplesKt.to("token", r116);
        JSONObject r53 = z1.g(r21.T().getStoreParam().getPassthroughHybrid());
        if (r53 != null) goto L161;
        r53 = new JSONObject();
    L161:
        r35[21] = TuplesKt.to("pass_through_hybrid", r53);
        r35[22] = TuplesKt.to("store_type", "shop");
        JSONObject r54 = new JSONObject();
        if (r21.T().getStoreParam().isEcShare() == false) goto L165;
        r54.put("is_ec_shopping", 1);
        r54.put("share_content", r21.T().getStoreParam().getShareContent());
        r54.put("share_object", r21.T().getStoreParam().getShareObject());
    L165:
        if (Intrinsics.areEqual(r21.T().getStoreParam().getShareContent(), "shop") == false) goto L167;
        r54.put("entrance_location", r21.T().getStoreParam().getEntranceLocation());
    L167:
        r54.put("pre_product_id", r21.T().getStoreParam().getPreProductId());
        r54.put("pre_group_id", r21.T().getStoreParam().getPreGroupId());
        r54.put("pre_room_id", r21.T().getStoreParam().getPreRoomId());
        r35[23] = TuplesKt.to("log_extra", r54.toString());
        r32[1] = TuplesKt.to("metaInfo", MapsKt.mutableMapOf(r35));
        StoreFloatLayout.d(r115, r31, MapsKt.mapOf(r32));
    L184:
        if (r8 == false) goto L193;
        ECToast.showToast$default(ECToast.INSTANCE, r21.u().c(), ag4.a.d(2131896851), null, 4, null);
        return;
    L193:
        return;
    L123:
        r41 = "0";
        goto L124
    L117:
        r40 = null;
        goto L118
    L104:
        r34 = null;
        goto L105
    L100:
        r31 = null;
        goto L101
    L96:
        r112 = null;
        goto L97
    L92:
        r27 = null;
        goto L93
    L82:
        if (r23.intValue() != 2) goto L89;
        com.bytedance.android.ec.store.repository.dto.d r55 = r11.c;
        if (r55 == null) goto L86;
        r4 = r55.d();
    L86:
        UriProtector.parse(r4);
        int r56 = ECSdk.a;
        IECHostService r57 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r57 == null) goto L184;
        r57.getHunterPopupService();
        goto L184
    L61:
        if (r23.intValue() != 3) goto L79;
        com.bytedance.android.ec.store.repository.dto.d r58 = r11.c;
        if (r58 == null) goto L68;
        String r59 = r58.c();
        if (r59 == null) goto L68;
        String r60 = com.bytedance.android.shopping.extensions.k.u(r59).optString("display_msg");
        if (r60 == null) goto L68;
    L69:
        View r61 = LayoutInflater.from(r21.u().c()).inflate(2131560918, null);
        TextView r62 = (TextView) r61.findViewById(2131386281);
        if (r62 == null) goto L72;
        r62.setText(r60);
    L72:
        View r63 = r61.findViewById(2131386282);
        if (r63 == null) goto L75;
        r63.setOnClickListener(new m(r21, r60));
    L75:
        final Context r117 = r21.u().c();
        final Fragment r118 = r21.u().a;
        com.bytedance.android.ec.store.repository.dto.d r64 = r11.c;
        if (r64 == null) goto L78;
        r4 = r64.e();
    L78:
        final int r65 = r21.e0();
        StoreFloatLayout r66 = new ECShopFollowBasePresenter$openNativeFloatLayout$1(r117, r118, r4, r65);
        Intrinsics.checkNotNullParameter(r61, "view");
        r66.addView(r61);
        r21.T().doEventAction("shop_float_layer_show", new Pair[]{TuplesKt.to("container_type", "native"), TuplesKt.to("text", r60), TuplesKt.to("module_type", "mall_follow_shop_task")});
    L68:
        r60 = "关注成功";
        goto L69
    L168:
        r8 = true;
        goto L184
    L170:
        if (r11.d == null) goto L172;
        jm.a<com.bytedance.android.ec.store.repository.vo.i> r67 = r21.T().getMarketFloatVO();
        int r68 = com.bytedance.android.ec.store.repository.vo.i.a;
        com.bytedance.android.ec.store.repository.dto.d r69 = r11.d;
        Intrinsics.checkNotNull(r69);
        r67.setValue(com.bytedance.android.ec.store.repository.vo.i.a.a(r69));
        goto L184
    L172:
        m0 r70 = new m0(SettingKeys.getLYNX_SHOP_FOLLOW());
        r70.b("gift_data", r21.T().getFollowGiftData());
        ((ArrayList) r70.a).add(new com.bytedance.android.ec.core.utils.i("guide_mode", String.valueOf(0)));
        r70.b("coupon_title", r11.a);
        uj3.i r71 = r11.b;
        if (r71 == null) goto L177;
        Integer r72 = r71.a;
        if (r72 == null) goto L177;
        int r73 = r72.intValue();
    L178:
        ((ArrayList) r70.a).add(new com.bytedance.android.ec.core.utils.i("gift_type", String.valueOf(r73)));
        r70.b("author_id", r21.T().getStoreParam().getStoreAccountParam().getUserId());
        r70.b("entrance_location", r21.T().getStoreParam().getEnterFrom());
        r70.b("temp_id", r21.T().getStoreParam().getTempId());
        String r74 = r70.c();
        com.bytedance.android.ec.sdk.helper.p r75 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r76 = r21.u();
        Context r77 = l0.c(r76.c());
        if ((r77 instanceof FragmentActivity) == true) goto L181;
        r77 = null;
    L181:
        if (r77 != null) goto L183;
        r77 = r76.a();
    L183:
        r75.openSchema(r77, r74);
    L177:
        r73 = 0;
        goto L178
    L23:
        r16 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L12:
        if (a2.b(r7.getText()) == false) goto L15;
        r9 = false;
        goto L16
    L8:
        r5 = null;
        goto L9
    }
}
