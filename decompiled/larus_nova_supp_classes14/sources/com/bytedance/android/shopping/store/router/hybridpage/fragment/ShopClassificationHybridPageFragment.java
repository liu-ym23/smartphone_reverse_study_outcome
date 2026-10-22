package com.bytedance.android.shopping.store.router.hybridpage.fragment;

import android.os.Bundle;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateParam;
import com.bytedance.android.shopping.store.aggregate.classification.CategoryInfo;
import com.bytedance.android.shopping.store.aggregate.classification.c;
import com.bytedance.android.shopping.store.router.hybridpage.setting.HybridPageConfigSetting;
import com.bytedance.android.shopping.store.router.hybridpage.slice.SliceProductCardData;
import com.bytedance.android.shopping.store.router.hybridpage.viewmodel.HybridPageViewModel;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONTokener;
import vj3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/fragment/ShopClassificationHybridPageFragment;", "Lcom/bytedance/android/shopping/store/router/hybridpage/fragment/HybridPageFragment;", "<init>", "()V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopClassificationHybridPageFragment extends HybridPageFragment {
    public static final /* synthetic */ int h = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.fragment.HybridPageFragment
    public final b S90() {
        return (b) HybridPageConfigSetting.b.getValue();
    }

    public ShopClassificationHybridPageFragment() {
    }

    @Override // com.bytedance.android.shopping.store.router.hybridpage.fragment.HybridPageFragment
    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        Bundle r14 = getArguments();
        if (r14 == null) goto L5;
        Serializable r15 = r14.getSerializable("store_param");
    L7:
        if ((r15 instanceof ShopAggregateParam) == true) goto L9;
        r15 = null;
    L9:
        ShopAggregateParam r16 = (ShopAggregateParam) r15;
        if (r16 != null) goto L12;
        return;
    L12:
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r16, "storeParam");
        String r1 = r16.getEntranceInfo();
        String r2 = "";
        String r3 = r1;
        if (r1 != null) goto L15;
        r3 = "";
    L15:
        boolean r4 = false;
        if (r3.length() != 0) goto L18;
        boolean r5 = true;
    L19:
        String r6 = r3;
        if (r5 == true) goto L44;
        boolean r7 = StringsKt.startsWith$default(StringsKt.trimStart(r3).toString(), "{", false, 2, null);
        r6 = r3;
        if (r7 == true) goto L44;
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L37
        Object r9 = new JSONTokener(r3).nextValue();     // Catch: Throwable -> L37
        if ((r9 instanceof String) == true) goto L27;
        r9 = null;
    L27:
        String r10 = (String) r9;     // Catch: Throwable -> L37
        if (r10 != null) goto L30;
    L34:
        String r11 = r3;
    L35:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L37
    L39:
        Object r17 = r3;
        if (Result.isFailure-impl(r12) == true) goto L43;
        r17 = r12;
    L43:
        r6 = (String) r17;
        goto L44
    L30:
        if (StringsKt.startsWith$default(StringsKt.trimStart(r10).toString(), "{", false, 2, null) == false) goto L32;
        r11 = r10;
    L33:
        if (r11 != null) goto L35;
    L32:
        r11 = null;
    L37:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L44:
        String r19 = r16.getStoreAccountParam().getUserId();
        if (r19 != null) goto L47;
        r19 = "";
    L47:
        String r20 = r16.getStoreAccountParam().getSecUserId();
        if (r20 != null) goto L50;
        r20 = "";
    L50:
        String r21 = r16.getShopId();
        if (r21 != null) goto L53;
        r21 = "";
    L53:
        ECShopSearchParam r22 = new ECShopSearchParam(r19, r20, r21, r16.getSecShopId());
        r22.getStoreAccountParam().copyFrom(r16.getStoreAccountParam());
        r22.setEnterMethod(r16.getEnterMethod());
        r22.setEnterFrom(r16.getEnterFrom());
        r22.setEntranceLocation(r16.getEntranceLocation());
        r22.setSearchParams(r16.getSearchParams());
        String r23 = r16.getRoomId();
        if (r23 != null) goto L56;
        r23 = "";
    L56:
        r22.setRoomId(r23);
        String r24 = r16.getAnchorId();
        if (r24 != null) goto L59;
        r24 = "";
    L59:
        r22.setAnchorId(r24);
        r22.setTabNameSecond(r16.getTabNameSecond());
        r22.setTabLabel(r16.getTabLabel());
        r22.setTabName(r16.getTabName());
        r22.setTempId(r16.getTempId());
        r22.setFollowStatus(r16.getFollowStatus());
        r22.setStoreSourcePage(r16.getStoreSourcePage());
        r22.setStoreSourceMethod(r16.getStoreSourceMethod());
        r22.setStoreGroupType(r16.getStoreGroupType());
        r22.setEcShare(r16.isEcShare());
        r22.setShareContent(r16.getShareContent());
        r22.setShareObject(r16.getShareObject());
        r22.getProductBasicRequestParam().copyFrom(r16.getProductBasicRequestParam());
        r22.setSourceBtmToken(r16.getSourceBtmToken());
        r22.setEntranceInfo(r6);
        r22.setPageName(r16.getPageName());
        String r25 = (String) r16.getPassThroughParam("pass_through_api");
        if (r25 != null) goto L62;
        r25 = "";
    L62:
        r22.putPassThroughParam("pass_through_api", r25);
        Map<String, Object> r26 = r22.getUriParams();
        Pair[] r27 = new Pair[30];
        String r110 = r16.getShopId();
        if (r110 != null) goto L65;
        r110 = "";
    L65:
        r27[0] = TuplesKt.to("shop_id", r110);
        r27[1] = TuplesKt.to("sec_shop_id", r16.getSecShopId());
        String r111 = r16.getStoreAccountParam().getUserId();
        if (r111 != null) goto L68;
        r111 = "";
    L68:
        r27[2] = TuplesKt.to("uid", r111);
        String r28 = r16.getStoreAccountParam().getSecUserId();
        if (r28 != null) goto L71;
        r28 = "";
    L71:
        r27[3] = TuplesKt.to("sec_uid", r28);
        String r29 = r16.getPageType();
        if (r29 != null) goto L74;
        r29 = "";
    L74:
        r27[4] = TuplesKt.to("page_type", r29);
        String r30 = r16.getCategoryId();
        if (r30 != null) goto L77;
        r30 = "";
    L77:
        r27[5] = TuplesKt.to("category_id", r30);
        r27[6] = TuplesKt.to("tab_label", r16.getTabLabel());
        String r31 = r16.getTabName();
        if (r31 != null) goto L80;
        r31 = "";
    L80:
        r27[7] = TuplesKt.to("tab_name", r31);
        String r32 = r16.getTabNameSecond();
        if (r32 != null) goto L83;
        r32 = "";
    L83:
        r27[8] = TuplesKt.to("tab_name_second", r32);
        String r33 = r16.getClassificationTabType();
        if (r33 != null) goto L86;
        r33 = "";
    L86:
        r27[9] = TuplesKt.to("tab_type", r33);
        String r34 = r16.getPageVersion();
        if (r34 != null) goto L89;
        r34 = "";
    L89:
        r27[10] = TuplesKt.to("page_version", r34);
        String r35 = r16.getSearchParams();
        if (r35 != null) goto L92;
        r35 = "";
    L92:
        r27[11] = TuplesKt.to("search_params", r35);
        String r36 = r16.getEnterFrom();
        if (r36 != null) goto L95;
        r36 = "";
    L95:
        r27[12] = TuplesKt.to("enter_from", r36);
        String r37 = r16.getEnterMethod();
        if (r37 != null) goto L98;
        r37 = "";
    L98:
        r27[13] = TuplesKt.to("enter_method", r37);
        String r38 = r16.getEntranceLocation();
        if (r38 != null) goto L101;
        r38 = "";
    L101:
        r27[14] = TuplesKt.to("entrance_location", r38);
        String r39 = r16.getStoreSourcePage();
        if (r39 != null) goto L104;
        r39 = "";
    L104:
        r27[15] = TuplesKt.to("store_source_page", r39);
        String r40 = r16.getStoreSourceMethod();
        if (r40 != null) goto L107;
        r40 = "";
    L107:
        r27[16] = TuplesKt.to("store_source_method", r40);
        String r41 = r16.getStoreGroupType();
        if (r41 != null) goto L110;
        r41 = "";
    L110:
        r27[17] = TuplesKt.to("store_group_type", r41);
        String r42 = (String) r16.getPassThroughParam("pass_through_api");
        if (r42 != null) goto L113;
        r42 = "";
    L113:
        r27[18] = TuplesKt.to("pass_through_api", r42);
        r27[19] = TuplesKt.to("entrance_info", r6);
        String r43 = r16.getRoomId();
        if (r43 != null) goto L116;
        r43 = "";
    L116:
        r27[20] = TuplesKt.to("room_id", r43);
        String r44 = r16.getAnchorId();
        if (r44 != null) goto L119;
        r44 = "";
    L119:
        r27[21] = TuplesKt.to("anchor_id", r44);
        String r45 = r16.getTempId();
        if (r45 != null) goto L122;
        r45 = "";
    L122:
        r27[22] = TuplesKt.to("temp_id", r45);
        Integer r46 = r16.getFollowStatus();
        if (r46 == null) goto L126;
        String r47 = String.valueOf(r46.intValue());
        if (r47 == null) goto L126;
    L127:
        r27[23] = TuplesKt.to("follow_status", r47);
        String r48 = r16.getProductBasicRequestParam().getCustomIds();
        if (r48 != null) goto L130;
        r48 = "";
    L130:
        r27[24] = TuplesKt.to("custom_ids", r48);
        Integer r49 = r16.getProductBasicRequestParam().getCustomIdType();
        if (r49 == null) goto L134;
        String r50 = String.valueOf(r49.intValue());
        if (r50 == null) goto L134;
    L135:
        r27[25] = TuplesKt.to("custom_id_type", r50);
        String r51 = r16.getProductBasicRequestParam().getMaterialId();
        if (r51 != null) goto L138;
        r51 = "";
    L138:
        r27[26] = TuplesKt.to("material_id", r51);
        String r52 = r16.getPageParams();
        if (r52 != null) goto L141;
        r52 = "";
    L141:
        r27[27] = TuplesKt.to("page_params", r52);
        r27[28] = TuplesKt.to("query", "");
        c.a.getClass();
        CategoryInfo r53 = r16.getCategoryInfo();
        if (r53 != null) goto L144;
    L153:
        String r112 = r16.getStoreUIParam().getMaterialTitle();
        if (r112 == null) goto L157;
    L156:
        r2 = r112;
    L157:
        r27[29] = TuplesKt.to("material_title", r2);
        r26.putAll(MapsKt.mutableMapOf(r27));
        HybridPageViewModel r113 = T90();
        SliceProductCardData.Companion.getClass();
        r113.setSliceProductCardData(SliceProductCardData.a.a(r22));
        T90().setSearchParam(r22);
        T90().setRouterQuery(T90().buildRouterQuery());
        T90().initEventParams();
        dm.a.a("ShopClassificationHybridPageFragment").i("onCreate, pageCardUrl=" + T90().getPageCardUrl() + ", configJsonUrl=" + T90().getConfigJsonUrl() + ", routerQuery=" + T90().getRouterQuery());
        final String r54 = T90().getConfigJsonUrl();
        if (r54 != null) goto L160;
    L161:
        r4 = true;
    L162:
        if (r4 == false) goto L164;
        dm.a.a("ShopClassificationHybridPageFragment").b("parseConfigJsonData skipped: configJsonUrl is null", null);
        return;
    L164:
        ECLiveHybridUtil.a r114 = ECLiveHybridUtil.a;
        ECLiveHybridUtil.g(r54, new ShopClassificationHybridPageFragment$parseConfigJsonData$1(this, r54));
        return;
    L160:
        if (r54.length() != 0) goto L162;
    L144:
        if (r53.canClassificationPageShowFilterTab() != true) goto L153;
        CategoryInfo r115 = r16.getCategoryInfo();
        if (r115 == null) goto L150;
        Map<String, String> r116 = r115.getMainCategoryItem();
        if (r116 == null) goto L150;
        r112 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r116, "category_name", null);
    L151:
        if (r112 != null) goto L156;
    L150:
        r112 = null;
    L134:
        r50 = "";
    L126:
        r47 = "";
        goto L127
    L18:
        r5 = false;
        goto L19
    L5:
        r15 = null;
        goto L7
    }
}
