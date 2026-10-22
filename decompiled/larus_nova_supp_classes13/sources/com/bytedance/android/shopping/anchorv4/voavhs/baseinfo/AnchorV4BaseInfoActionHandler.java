package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.p0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.CollectMeta;
import com.bytedance.android.shopping.anchorv4.bottom.LikeMeta;
import com.bytedance.android.shopping.anchorv4.bottom.SkuComponentComponent;
import com.bytedance.android.shopping.anchorv4.bottom.SkuMeta;
import com.bytedance.android.shopping.anchorv4.bottom.e0;
import com.bytedance.android.shopping.anchorv4.bottom.f0;
import com.bytedance.android.shopping.anchorv4.bottom.g0;
import com.bytedance.android.shopping.anchorv4.bottom.j0;
import com.bytedance.android.shopping.anchorv4.bottom.k0;
import com.bytedance.android.shopping.anchorv4.bottom.x;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.SupermarketType;
import com.bytedance.android.shopping.anchorv4.nav.ShareComponent;
import com.bytedance.android.shopping.anchorv4.nav.ShareMeta;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.tracker.AnchorV4TrackerImpl;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.TagsScrollBoxComponentView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.utils.i0;
import com.google.gson.internal.LinkedTreeMap;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AnchorV4BaseInfoActionHandler implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a, nl.d {
    public final Lazy a;
    public TagsScrollBoxComponentView b;
    public final AnchorV4VM c;
    public final Context d;
    public final AnchorV4BaseInfoMeta e;
    public final FragmentManager f;
    public final com.bytedance.android.ec.core.async.b g;

    public final Context getContext() {
        return this.d;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r3) {
        if (r3 == null) goto L5;
        String r4 = r3.getId();
    L7:
        if (Intrinsics.areEqual(r4, "base_info_view_preselected_sku_panel") == false) goto L19;
        AnchorV4BaseInfoMeta r5 = this.e;
        if (r5 == null) goto L15;
        AnchorV4BaseInfoBusinessMeta r6 = r5.getBusinessMeta();
        if (r6 == null) goto L15;
        SkuMeta r7 = r6.getSkuMeta();
        if (r7 == null) goto L15;
        SkuMeta r8 = r7.fillCommonMeta(this.c.commonMeta());
    L16:
        if (r8 != null) goto L18;
        return null;
    L18:
        return new AnchorV4BaseInfoActionHandler$getPreAction$1(this);
    L15:
        r8 = null;
        goto L16
    L19:
        return null;
    L5:
        r4 = null;
        goto L7
    }

    public final void b(String r20, Map r21) {
        Intrinsics.checkNotNullParameter(r20, "enterPageType");
        int r2 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r3 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r3 == null) goto L5;
        r3.c = MapsKt.mapOf(new Pair[]{TuplesKt.to(PdpOpenThirdParam.KEY_CARRIER_TYPE, "full_screen_card"), TuplesKt.to("click_to_areacode", r20)});
        AnchorV4TrackerImpl.b(r3, "click_product", false, null, true, null, 22);
    L5:
        int r1 = com.bytedance.android.shopping.anchorv3.utils.r.a;
        AnchorV4VM r4 = this.c;
        Intrinsics.checkNotNullParameter(r4, "mViewModel");
        com.bytedance.android.shopping.anchorv3.utils.r.b("click_buy_right_now_btn", r4, new HashMap());
        int r5 = com.bytedance.android.shopping.anchorv3.utils.a.a;
        CommonMeta r6 = this.c.commonMeta();
        if (r6 != null) goto L8;
    L10:
        boolean r11 = false;
    L11:
        CommonMeta r7 = this.c.commonMeta();
        if (r7 == null) goto L14;
        ECAdLogExtra r12 = r7.getAdLogExtra();
    L15:
        long r13 = this.c.getDuration();
        CommonMeta r8 = this.c.commonMeta();
        if (r8 == null) goto L18;
        String r15 = r8.getPromotionId();
    L19:
        CommonMeta r9 = this.c.commonMeta();
        if (r9 != null) goto L22;
    L24:
        boolean r16 = false;
    L25:
        CommonMeta r10 = this.c.commonMeta();
        if (r10 == null) goto L28;
        Long r17 = Long.valueOf(r10.getPromotionSource());
    L29:
        CommonMeta r14 = this.c.commonMeta();
        if (r14 == null) goto L32;
        Long r18 = r14.getProductMinPrice();
    L33:
        com.bytedance.android.shopping.anchorv3.utils.a.a(r11, r12, r13, r15, r16, r17, r18);
        this.c.pageStatus().k = true;
        return;
    L32:
        r18 = null;
        goto L33
    L28:
        r17 = null;
        goto L29
    L22:
        if (r9.getFromLive() != true) goto L24;
        r16 = true;
        goto L25
    L18:
        r15 = null;
        goto L19
    L14:
        r12 = null;
        goto L15
    L8:
        if (r6.isLuban() != true) goto L10;
        r11 = true;
        goto L11
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r14, Object r15) {
        Long r16 = null;
        if (r14 == null) goto L5;
        String r17 = r14.getId();
    L6:
        if (r17 == null) goto L54;
        int r0 = r17.hashCode();
        if (r0 == 147470825) goto L26;
        if (r0 == 283054029) goto L21;
        if (r0 == 327212440) goto L16;
        return;
    L16:
        if (r17.equals("base_info_view_action_collect") == false) goto L46;
        int r18 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r6 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r6 == null) goto L47;
        r6.c = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_location", "middle")});
        AnchorV4TrackerImpl.b(r6, "show_wish_button", false, null, false, null, 28);
        return;
    L47:
        return;
    L46:
        return;
    L21:
        if (r17.equals("base_info_view_action_share") == false) goto L49;
        int r19 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r7 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r7 == null) goto L50;
        r7.c = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("button_location", "middle")});
        AnchorV4TrackerImpl.b(r7, "ecom_share_button_show", false, "middle", false, null, 24);
        return;
    L50:
        return;
    L49:
        return;
    L26:
        if (r17.equals("base_info_view_action_like") == false) goto L52;
        int r110 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r8 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r8 == null) goto L53;
        Pair[] r111 = new Pair[3];
        r111[0] = TuplesKt.to("button_location", "middle");
        AnchorV4BaseInfoMeta r1 = this.e;
        if (r1 == null) goto L36;
        AnchorV4BaseInfoBusinessMeta r2 = r1.getBusinessMeta();
        if (r2 == null) goto L36;
        LikeMeta r3 = r2.getLike();
        if (r3 == null) goto L36;
        Long r4 = Long.valueOf(r3.getCostPrice());
    L37:
        r111[1] = TuplesKt.to("cost_price", r4);
        AnchorV4BaseInfoMeta r5 = this.e;
        if (r5 == null) goto L44;
        AnchorV4BaseInfoBusinessMeta r9 = r5.getBusinessMeta();
        if (r9 == null) goto L44;
        LikeMeta r10 = r9.getLike();
        if (r10 == null) goto L44;
        r16 = Long.valueOf(r10.getRealPrice());
    L44:
        r111[2] = TuplesKt.to("real_price", r16);
        r8.c = MapsKt.hashMapOf(r111);
        AnchorV4TrackerImpl.b(r8, "show_like_button", false, null, false, null, 28);
        return;
    L36:
        r4 = null;
        goto L37
    L53:
        return;
    L52:
        return;
    L54:
        return;
    L5:
        r17 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r38, Action r39, Object r40) {
        Intrinsics.checkNotNullParameter(r38, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r39, "action");
        AnchorV4BaseInfoMeta r1 = this.e;
        int r4 = 0;
        LikeMeta r6 = "";
        LikeMeta r9 = null;
        if (r1 == null) goto L73;
        AnchorV4BaseInfoBusinessMeta r2 = r1.getBusinessMeta();
        if (r2 == null) goto L73;
        List<AnchorV4BannerMeta> r3 = r2.getBannerMetaList();
        if (r3 == null) goto L73;
        Iterator<T> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L14;
        Object r10 = r5.next();
        if (Intrinsics.areEqual(String.valueOf(((AnchorV4BannerMeta) r10).getBannerType()), r39.getId()) == false) goto L10;
    L15:
        AnchorV4BannerMeta r11 = (AnchorV4BannerMeta) r10;
        if (r11 == null) goto L73;
        Context r7 = this.d;
        String r8 = r11.getBannerUrl();
        JSONObject r12 = new JSONObject();
        boolean r13 = this.c.pageStatus().h;
        com.bytedance.android.shopping.anchorv4.containers.b.b(r7, r8, r12, false);
        Integer r14 = r11.getBannerType();
        if (r14 != null) goto L21;
    L23:
        if (r14 != null) goto L26;
    L28:
        if (r14 != null) goto L31;
    L50:
        if (r14 != null) goto L53;
    L57:
        if (r14 != null) goto L60;
    L64:
        if (r14 != null) goto L67;
    L69:
        int r15 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r16 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r16 == null) goto L362;
        AnchorV4TrackerImpl.b(r16, "label_explanation_click", false, null, false, null, 30);
        return;
    L362:
        return;
    L67:
        if (r14.intValue() != 4) goto L69;
        return;
    L60:
        if (r14.intValue() != 19) goto L64;
        int r17 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r18 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r18 == null) goto L360;
        AnchorV4TrackerImpl.b(r18, "click_activity_entrance", false, null, false, null, 30);
        return;
    L360:
        return;
    L53:
        if (r14.intValue() != 2) goto L57;
        int r19 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r20 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r20 == null) goto L358;
        AnchorV4TrackerImpl.b(r20, "base_verified_click", false, null, false, null, 30);
        return;
    L358:
        return;
    L31:
        if (r14.intValue() != 132) goto L50;
    L32:
        CommonMeta r21 = this.c.commonMeta();
        if (r21 == null) goto L35;
        r9 = Integer.valueOf(r21.getSupermarketType());
    L35:
        int r22 = SupermarketType.TYPE_POP.getType();
        if (r9 != null) goto L39;
    L41:
        int r23 = SupermarketType.TYPE_RETAIL.getType();
        if (r9 != null) goto L45;
    L47:
        int r24 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r25 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r25 == null) goto L356;
        r25.c = MapsKt.mapOf(TuplesKt.to("brand_name", r6));
        AnchorV4TrackerImpl.b(r25, "brand_name_click", false, null, false, null, 30);
        return;
    L356:
        return;
    L45:
        if (r9.intValue() != r23) goto L47;
        r6 = com.bytedance.android.shopping.extensions.j.c(2131896411);
        goto L47
    L39:
        if (r9.intValue() != r22) goto L41;
        r6 = com.bytedance.android.shopping.extensions.j.c(2131896410);
        goto L47
    L26:
        if (r14.intValue() != 131) goto L28;
    L21:
        if (r14.intValue() != 1) goto L23;
    L14:
        r10 = null;
    L73:
        String r26 = r39.getId();
        if (r26 != null) goto L77;
        return;
    L77:
        switch(r26.hashCode()) {
            case -1832062687: goto L326;
            case -1420697885: goto L298;
            case -1269463478: goto L259;
            case -75456708: goto L222;
            case 147470825: goto L193;
            case 283054029: goto L179;
            case 327212440: goto L158;
            case 572555819: goto L132;
            case 933684484: goto L120;
            case 941880784: goto L114;
            case 1440860570: goto L98;
            case 2077892220: goto L80;
            default: goto L405;
        };
    L405:
        return;
    L80:
        if (r26.equals("base_info_window_click") == false) goto L368;
        int r27 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r110 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r110 == null) goto L88;
        JSONObject r28 = z1.g(r39.getMeta());
        if (r28 == null) goto L86;
        Map r29 = z1.j(r28);
    L87:
        r110.c = r29;
        AnchorV4TrackerImpl.b(r110, "click_store_entrance", false, null, false, null, 30);
        goto L88
    L86:
        r29 = null;
    L88:
        com.bytedance.android.ec.sdk.helper.p r30 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r31 = this.d;
        AnchorV4BaseInfoMeta r32 = this.e;
        if (r32 == null) goto L93;
        AnchorV4BaseInfoBusinessMeta r33 = r32.getBusinessMeta();
        if (r33 == null) goto L93;
        r9 = r33.getWindowUrl();
    L93:
        if (r9 == null) goto L96;
        r6 = r9;
    L96:
        r30.openSchema(r31, r6);
        return;
    L368:
        return;
    L98:
        if (r26.equals("base_info_view_sku_pic_click") == false) goto L370;
        String r34 = r39.getRefId();
        if (r34 == null) goto L110;
        CommonMeta r35 = this.c.commonMeta();
        if (r35 == null) goto L109;
        List r36 = r35.getSkuSpecInfo();
        if (r36 == null) goto L109;
        int r37 = r36.size();
        SkuRestoreState r41 = this.c.skuStore();
        if (r41 == null) goto L108;
        AnchorV4VM r42 = this.c;
        r41.getSelectSkuKeys()[0] = r34;
        Unit r43 = Unit.INSTANCE;
        AnchorV4VM.justUpdateSkuStoreArray$default(r42, r41, false, 2, null);
        goto L109
    L108:
        AnchorV4VM r44 = this.c;
        SkuRestoreState r45 = new SkuRestoreState(r37);
        r45.getSelectSkuKeys()[0] = r34;
        Unit r46 = Unit.INSTANCE;
        AnchorV4VM.justUpdateSkuStoreArray$default(r44, r45, false, 2, null);
    L109:
        this.c.notifyRefreshDetailInfo(new SkuProductDetailInfo(null, new ProductPriceInfo(null, null, new PromotionDiscountPrice(null, null, null, null, 15, null), null, null, 24, null), null, null, true, null, false, 108, null));
    L110:
        int r47 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r48 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r48 == null) goto L371;
        AnchorV4TrackerImpl.b(r48, "click_product_sku_picture", false, null, false, null, 30);
        return;
    L371:
        return;
    L370:
        return;
    L114:
        if (r26.equals("activity_group_event_id") == false) goto L373;
        Context r49 = this.d;
        lh3.a r50 = (lh3.a) this.a.getValue();
        if (r50 == null) goto L118;
        r9 = r50.a();
    L118:
        JSONObject r51 = new JSONObject();
        boolean r52 = this.c.pageStatus().h;
        com.bytedance.android.shopping.anchorv4.containers.b.b(r49, r9, r51, false);
        return;
    L373:
        return;
    L120:
        if (r26.equals("base_info_view_main_pic_click") == true) goto L122;
        return;
    L122:
        if (r39.getRefId() == null) goto L376;
        CommonMeta r53 = this.c.commonMeta();
        if (r53 == null) goto L377;
        List r54 = r53.getSkuSpecInfo();
        if (r54 == null) goto L378;
        r54.size();
        SkuRestoreState r55 = this.c.skuStore();
        if (r55 == null) goto L130;
        r55.setElementToNull(0);
    L130:
        this.c.notifyRefreshDetailInfo(new SkuProductDetailInfo(null, new ProductPriceInfo(null, null, new PromotionDiscountPrice(null, null, null, null, 15, null), null, null, 24, null), null, null, true, null, false, 108, null));
        return;
    L378:
        return;
    L377:
        return;
    L376:
        return;
    L132:
        if (r26.equals("base_info_view_tax_event_id") == false) goto L380;
        int r56 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r111 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r111 == null) goto L136;
        AnchorV4TrackerImpl.b(r111, "tax_information_click", false, null, false, null, 30);
    L136:
        JSONObject r57 = new JSONObject();
        AnchorV4BaseInfoMeta r58 = this.e;
        if (r58 == null) goto L144;
        AnchorV4BaseInfoBusinessMeta r59 = r58.getBusinessMeta();
        if (r59 == null) goto L144;
        String r60 = r59.getAboardInfo();
        if (r60 == null) goto L144;
        JSONObject r61 = z1.g(r60);
        if (r61 == null) goto L144;
    L145:
        AnchorV4BaseInfoMeta r62 = this.e;
        if (r62 == null) goto L152;
        AnchorV4BaseInfoBusinessMeta r63 = r62.getBusinessMeta();
        if (r63 == null) goto L152;
        String r64 = r63.getTaxDesc();
        if (r64 == null) goto L152;
        JSONObject r65 = z1.g(r64);
    L153:
        r61.put("tax_describe", r65);
        r57.put("crossborder_data", r61);
        int r66 = com.bytedance.android.shopping.anchorv4.containers.b.a;
        r57.put("log_data", com.bytedance.android.shopping.anchorv4.containers.b.a(this.c.commonMeta(), this.c.trackMeta()));
        Context r67 = this.d;
        lh3.a r68 = (lh3.a) this.a.getValue();
        if (r68 == null) goto L156;
        r9 = r68.c();
    L156:
        boolean r69 = this.c.pageStatus().h;
        com.bytedance.android.shopping.anchorv4.containers.b.b(r67, r9, r57, false);
        return;
    L152:
        r65 = null;
    L144:
        r61 = new JSONObject();
        goto L145
    L380:
        return;
    L158:
        if (r26.equals("base_info_view_action_collect") == false) goto L382;
        AnchorV4BaseInfoMeta r70 = this.e;
        if (r70 == null) goto L177;
        AnchorV4BaseInfoBusinessMeta r71 = r70.getBusinessMeta();
        if (r71 == null) goto L364;
        CollectMeta r72 = r71.getCollect();
        if (r72 == null) goto L365;
        Set r73 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.c r74 = ECProcessMonitor.c("ec_product_detail", "collect");
        int r75 = i0.a;
        LikeMeta r76 = i0.a(this.c);
        if (r76 == null) goto L170;
        r6 = r76;
    L170:
        r74.f(MapsKt.mapOf(TuplesKt.to("product_type", r6)));
        CommonMeta r77 = this.c.commonMeta();
        x r112 = new x(this.c.pageStatus().c, this.c.pageStatus().h, "middle", this.c.compositeDisposable(), r40);
        CollectMeta r113 = r72.fillCommonMeta(r77);
        if (r113 == null) goto L406;
        AnchorV4VM r114 = this.c;
        TagsScrollBoxComponentView r78 = this.b;
        if (r78 == null) goto L176;
        r9 = r78.getContext();
    L176:
        new com.bytedance.android.shopping.anchorv4.bottom.r(r114, r9, this.b, null, null, r113, r112).a();
        return;
    L406:
        return;
    L365:
        return;
    L364:
        return;
    L177:
        return;
    L382:
        return;
    L179:
        if (r26.equals("base_info_view_action_share") == false) goto L384;
        AnchorV4BaseInfoMeta r79 = this.e;
        if (r79 == null) goto L191;
        AnchorV4BaseInfoBusinessMeta r80 = r79.getBusinessMeta();
        if (r80 == null) goto L366;
        ShareMeta r81 = r80.getShare();
        if (r81 == null) goto L367;
        ShareMeta r82 = r81.fillCommonMeta(this.c.commonMeta());
        if (r82 == null) goto L407;
        new ShareComponent(this.c, r38, r82, "middle", null, 48).a();
        return;
    L407:
        return;
    L367:
        return;
    L366:
        return;
    L191:
        return;
    L384:
        return;
    L193:
        if (r26.equals("base_info_view_action_like") == false) goto L386;
        AnchorV4BaseInfoMeta r84 = this.e;
        if (r84 == null) goto L199;
        AnchorV4BaseInfoBusinessMeta r85 = r84.getBusinessMeta();
        if (r85 == null) goto L199;
        r9 = r85.getLike();
    L199:
        CommonMeta r86 = this.c.commonMeta();
        x r87 = new x(this.c.pageStatus().c, this.c.pageStatus().h, "middle", this.c.compositeDisposable(), r40);
        if (r9 == null) goto L387;
        LikeMeta r88 = r9.fillLikeMeta(r86);
        if (r88 == null) goto L408;
        e0 r89 = new e0(this.c, this.b, r88, r87);
        String r90 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c25937.d72922", Boolean.FALSE).withView(r89.b).build());
        int r91 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r115 = com.bytedance.android.shopping.anchorv4.tracker.a.b(r89.a);
        if (r115 == null) goto L207;
        r115.c = MapsKt.mapOf(new Pair[]{TuplesKt.to("btm_id", r90), TuplesKt.to("button_location", r89.d.c), TuplesKt.to("is_click", Integer.valueOf(!r89.c.isLike() ? 1 : 0)), TuplesKt.to("stay_duration", Long.valueOf((SystemClock.uptimeMillis() - r89.d.a) / ((long) 1000))), TuplesKt.to("cost_price", Long.valueOf(r89.c.getCostPrice())), TuplesKt.to("real_price", Long.valueOf(r89.c.getRealPrice()))});
        AnchorV4TrackerImpl.b(r115, "click_like_button", false, null, false, null, 30);
    L207:
        CompositeDisposable r92 = r89.d.d;
        AnchorV3Api.a r94 = AnchorV3Api.a;
        String r95 = r89.c.getProductId();
        if (r95 != null) goto L210;
        String r116 = "";
    L212:
        if (r89.c.isLike() == false) goto L214;
        int r117 = 2;
    L215:
        String r118 = r89.c.getCommissionInfo();
        r94.getClass();
        Intrinsics.checkNotNullParameter(r116, "productId");
        AnchorV3Api r96 = AnchorV3Api.a.a;
        if (r96 == null) goto L219;
        Observable r97 = r96.shopLikeList(r116, 1, r117, 1, r118);
        if (r97 == null) goto L219;
    L220:
        r92.add(r97.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f0(r89), new g0(r89)));
        return;
    L219:
        r97 = Observable.error(new Throwable());
        goto L220
    L214:
        r117 = 1;
        goto L215
    L210:
        r116 = r95;
        goto L212
    L408:
        return;
    L387:
        return;
    L386:
        return;
    L222:
        if (r26.equals("base_info_view_rank_event_id") == false) goto L389;
        AnchorV4BaseInfoMeta r98 = this.e;
        if (r98 == null) goto L228;
        AnchorV4BaseInfoBusinessMeta r99 = r98.getBusinessMeta();
        if (r99 == null) goto L228;
        String r100 = r99.getRankUrl();
    L229:
        int r101 = p0.a;
        if (r100 != null) goto L232;
        r100 = "";
    L232:
        String r102 = p0.d(r100, SimilarProductParam.ENTER_FROM, "product_detail");
        CommonMeta r103 = this.c.commonMeta();
        if (r103 == null) goto L235;
        String r104 = r103.getEntranceInfo();
    L346:
        JSONObject r105 = new JSONObject(r104);     // Catch: Exception -> L243
        if (r102 != null) goto L239;
        r102 = "";
    L239:
        String r106 = p0.d(r102, "previous_page", r105.optString("carrier_source", ""));
        if (r106 != null) goto L242;
        r106 = "";
    L242:
        r102 = p0.d(r106, "search_params", r105.optString("search_params", ""));
    L244:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.d, r102);
        String r107 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b8094.c25937.d18117", Boolean.TRUE).withView(r38).build());
        int r108 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r119 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r119 == null) goto L390;
        Map r109 = MapsKt.mapOf(TuplesKt.to("btm_id", r107));
        AnchorV4BaseInfoMeta r120 = this.e;
        if (r120 == null) goto L251;
        LinkedTreeMap<String, Object> r121 = r120.getTrackMeta();
        if (r121 == null) goto L251;
        r9 = MapsKt.toMap(r121);
    L251:
        Intrinsics.checkNotNullParameter(r109, "$this$appendExtraParams");
        LinkedHashMap r122 = new LinkedHashMap();
        r122.putAll(r109);
        if (r9 == null) goto L257;
        Iterator r123 = r9.entrySet().iterator();
    L255:
        if (r123.hasNext() == false) goto L257;
        Map.Entry r124 = (Map.Entry) r123.next();
        r122.put((String) r124.getKey(), String.valueOf(r124.getValue()));
    L257:
        r119.c = r122;
        AnchorV4TrackerImpl.b(r119, "product_ranking_entrance_click", false, null, false, null, 30);
        return;
    L390:
        return;
    L235:
        r104 = null;
    L228:
        r100 = null;
        goto L229
    L389:
        return;
    L259:
        if (r26.equals("base_info_view_preselected_sku_panel") == false) goto L392;
        AnchorV4BaseInfoMeta r125 = this.e;
        if (r125 == null) goto L393;
        AnchorV4BaseInfoBusinessMeta r126 = r125.getBusinessMeta();
        if (r126 == null) goto L394;
        SkuMeta r127 = r126.getSkuMeta();
        if (r127 == null) goto L395;
        SkuMeta r128 = r127.fillCommonMeta(this.c.commonMeta());
        if (r128 == null) goto L409;
        FragmentManager r129 = this.f;
        if (r129 == null) goto L296;
        if (this.c.pageStatus().h == false) goto L274;
        String r130 = "full_screen";
    L275:
        String r210 = r130;
        String r131 = this.c.shareParams().b;
        long r132 = this.c.pageStatus().c;
        AnchorV4Param r133 = this.c.getAnchorV4Param();
        if (r133 == null) goto L280;
        V4NativeParams r134 = r133.getNativeParams();
        if (r134 == null) goto L280;
        Boolean r135 = Boolean.valueOf(r134.isFromFeedProductGuessULike());
    L281:
        boolean r211 = com.bytedance.android.shopping.extensions.k.i(r135);
        CommonMeta r136 = this.c.commonMeta();
        if (r136 == null) goto L284;
        String r137 = r136.getGroupId();
    L285:
        j0 r138 = new j0(r129, r132, r131, r210, r211, a2.b(r137), false, null, null, false, null, null, null, null, null, 0, null, null, null, 523648);
        Activity r139 = d0.a.getActivity(r38);
        LinkedTreeMap r140 = this.c.trackMeta();
        if (r140 == null) goto L294;
        new SkuComponentComponent(r139, r138, new k0(r140, 2), r128, this.c, null, null, null).b(r38, true);
        int r141 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r142 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r142 == null) goto L396;
        AnchorV4BaseInfoMeta r143 = this.e;
        if (r143 == null) goto L292;
        r9 = r143.getTrackMeta();
    L292:
        r142.c = r9;
        AnchorV4TrackerImpl.b(r142, "product_detail_campaign_preselect_click", false, null, false, null, 30);
        return;
    L396:
        return;
    L294:
        throw new IllegalStateException("Required value was null.".toString());
    L284:
        r137 = null;
    L280:
        r135 = null;
        goto L281
    L274:
        r130 = "half_screen";
        goto L275
    L296:
        throw new IllegalStateException("Required value was null.".toString());
    L409:
        return;
    L395:
        return;
    L394:
        return;
    L393:
        return;
    L392:
        return;
    L298:
        if (r26.equals("base_info_view_sku_open") == false) goto L398;
        JSONObject r144 = z1.g(r39.getMeta());
        if (r144 == null) goto L399;
        Integer r145 = Integer.valueOf(r144.optInt("scene_type"));
        Integer r146 = Integer.valueOf(r144.optInt("action_type"));
        String r147 = r144.optString("sku_from");
        Boolean r148 = Boolean.valueOf(r144.optBoolean("scroll_to_installment"));
        Integer r149 = Integer.valueOf(r144.optInt("term_count"));
        Boolean r150 = Boolean.valueOf(r144.optBoolean("is_groupbuying"));
        Boolean r151 = Boolean.valueOf(r144.optBoolean("is_custombuying"));
        JSONArray r152 = r144.optJSONArray("default_spec_ids");
        if (r152 == null) goto L317;
        ArrayList r153 = new ArrayList();
        int r154 = r152.length();
    L304:
        if (r4 >= r154) goto L316;
        if (r152.get(r4) != null) goto L309;
        r153.add(r9);
    L309:
        if ((r152.get(r4) instanceof String) == false) goto L315;
        Object r155 = r152.get(r4);
        if (r155 == null) goto L314;
        r153.add((String) r155);
        goto L315
    L314:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L315:
        r4 = r4 + 1;
        r9 = null;
        goto L304
    L316:
        ArrayList r156 = r153;
    L318:
        this.c.showSku(new fi3.n(r145, r146, new fi3.m(r147, r150, r151, r148, r149, r156, 960), 8));
        int r157 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r158 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r158 == null) goto L400;
        JSONObject r159 = r144.optJSONObject("track_meta");
        if (r159 == null) goto L323;
        Map r160 = z1.j(r159);
    L324:
        r158.c = r160;
        AnchorV4TrackerImpl.b(r158, "click_product_activity", false, null, false, null, 30);
        return;
    L323:
        r160 = null;
        goto L324
    L400:
        return;
    L317:
        r156 = null;
        goto L318
    L399:
        return;
    L398:
        return;
    L326:
        if (r26.equals("base_info_view_open_global") == false) goto L402;
        Context r161 = this.d;
        Object r162 = r40;
        if ((r162 instanceof TextWithOneIconElement) == true) goto L330;
        r162 = null;
    L330:
        TextWithOneIconElement r163 = (TextWithOneIconElement) r162;
        if (r163 == null) goto L335;
        Link r164 = r163.getLink();
        if (r164 == null) goto L335;
        String r165 = r164.getLinkUrl();
    L336:
        if (r165 != null) goto L338;
        String r166 = "";
    L339:
        ECLiveHybridUtil.k(r161, r166, false, false, false, null, 252);
        int r167 = com.bytedance.android.shopping.anchorv4.tracker.a.a;
        AnchorV4TrackerImpl r168 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r168 == null) goto L342;
        AnchorV4TrackerImpl.b(r168, "product_detail_label_click", false, null, false, null, 30);
    L342:
        AnchorV4TrackerImpl r169 = com.bytedance.android.shopping.anchorv4.tracker.a.b(this.c);
        if (r169 == null) goto L403;
        AnchorV4TrackerImpl.b(r169, "global_product_introduction_click", false, null, false, null, 30);
        return;
    L403:
        return;
    L338:
        r166 = r165;
    L335:
        r165 = null;
        goto L336
    }

    public AnchorV4BaseInfoActionHandler(AnchorV4VM r2, FragmentActivity r3, AnchorV4BaseInfoMeta r4, FragmentManager r5, com.bytedance.android.ec.core.async.b r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModel");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "disposableScope");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = LazyKt.lazy(AnchorV4BaseInfoActionHandler$hybridConfig$2.INSTANCE);
    }
}
