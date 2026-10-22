package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.slice.ECStoreHeaderInfoSliceConfig;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ShopFrameworkType;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final /* synthetic */ int r = 0;
    public ECAbnormalShopBasicInfo a;
    public e b;
    public d c;
    public uj3.b d;
    public g e;
    public c f;
    public i g;
    public p h;
    public j i;
    public ECShopBrandHeaderStyleDto j;
    public Map<String, String> k;
    public ECShopBrandModuleInfo l;
    public Map<String, String> m;
    public ECShopHeadInfoBlock n;
    public com.bytedance.android.shopping.store.home.slice.d o;
    public im.v p;
    public boolean q;

    public static final class a {
        public static n a(ECShopHeadInfoBlock r21, ECStoreParam r22) {
            Intrinsics.checkNotNullParameter(r21, "response");
            n r2 = new n();
            Blcok r0 = r21.getBlock();
            if (r0 == null) goto L69;
            List<Module> r1 = r0.getModuleList();
            if (r1 == null) goto L69;
            Iterator r4 = r1.iterator();
            ECShopBrandHeaderStyleDto r5 = null;
            ECShopBrandModuleInfo r6 = null;
            ECShopBasicInfoModuleDTO r7 = null;
            Map<String, String> r8 = null;
            ECShopAccountInfoModuleDTO r9 = null;
            sj3.b r10 = null;
            ECShopConfigInfoModuleDTO r11 = null;
            ECShopMediaInfoModuleDTO r12 = null;
            ECShopLiveTabHomeInfoModuleDTO r13 = null;
            ECShopShareInfoModuleDTO r14 = null;
            ECAbnormalShopBasicInfo r15 = null;
            c r16 = null;
            p r17 = null;
        L8:
            if (r4.hasNext() == false) goto L68;
            Module r3 = (Module) r4.next();
            Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L64
            String r19 = r3.getName();     // Catch: Throwable -> L64
            Iterator r20 = r4;
            if (Intrinsics.areEqual(r19, ECShopModuleType.ABNORMAL_SHOP_BASIC_INFO.getType()) == false) goto L16;
            r15 = (ECAbnormalShopBasicInfo) new Gson().fromJson(r3.getData(), ECAbnormalShopBasicInfo.class);     // Catch: Throwable -> L62
        L60:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L62
        L67:
            r4 = r20;
            goto L8
        L16:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPBASICINFO.getType()) == false) goto L19;
            r7 = (ECShopBasicInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopBasicInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L19:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPACCOUNTINFO.getType()) == false) goto L22;
            r9 = (ECShopAccountInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopAccountInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L22:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPLISTINFO.getType()) == false) goto L25;
            r10 = (sj3.b) new Gson().fromJson(r3.getData(), sj3.b.class);     // Catch: Throwable -> L62
            goto L60
        L25:
            if (Intrinsics.areEqual(r19, ECShopModuleType.HOMECONFIGINFO.getType()) == false) goto L28;
            r11 = (ECShopConfigInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopConfigInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L28:
            if (Intrinsics.areEqual(r19, ECShopModuleType.ABNORMAL_SHOP_HOME_CONFIG_INFO.getType()) == false) goto L31;
            r16 = (c) new Gson().fromJson(r3.getData(), c.class);     // Catch: Throwable -> L62
            goto L60
        L31:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPMEDIAINFO.getType()) == false) goto L40;
            if (r22 == null) goto L34;
            ECFoldScene r23 = r22.getSplitParent();     // Catch: Throwable -> L62
        L36:
            if (r23 != ECFoldScene.VIDEO) goto L38;
            r2.p = ((ECShopMediaInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopMediaInfoModuleDTO.class)).getLiveInfo();     // Catch: Throwable -> L62
            goto L60
        L38:
            r12 = (ECShopMediaInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopMediaInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L34:
            r23 = null;
            goto L36
        L40:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPHEADERSTYLE.getType()) == false) goto L43;
            r17 = (p) new Gson().fromJson(r3.getData(), p.class);     // Catch: Throwable -> L62
            goto L60
        L43:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOP_LIVE_TAB_INFO.getType()) == false) goto L46;
            r13 = (ECShopLiveTabHomeInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopLiveTabHomeInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L46:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOP_SHARE_INFO.getType()) == false) goto L49;
            r14 = (ECShopShareInfoModuleDTO) new Gson().fromJson(r3.getData(), ECShopShareInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L49:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPINFOLYNX.getType()) == true) goto L60;
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOPLOGEXTRA.getType()) == false) goto L55;
            int r24 = w0.a;     // Catch: Throwable -> L62
            r8 = w0.a(r3.getData());     // Catch: Throwable -> L62
            goto L60
        L55:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOP_BRAND_MODULE_INFO.getType()) == false) goto L58;
            r6 = (ECShopBrandModuleInfo) new Gson().fromJson(r3.getData(), ECShopBrandModuleInfo.class);     // Catch: Throwable -> L62
            goto L60
        L58:
            if (Intrinsics.areEqual(r19, ECShopModuleType.SHOP_BRAND_HEADER_STYLE.getType()) == false) goto L60;
            r5 = (ECShopBrandHeaderStyleDto) new Gson().fromJson(r3.getData(), ECShopBrandHeaderStyleDto.class);     // Catch: Throwable -> L62
        L62:
            th = th;
        L66:
            Result.Companion r25 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L64:
            th = th;
            r20 = r4;
            goto L66
        L68:
            c r26 = r16;
            p r27 = r17;
        L70:
            r2.n = r21;
            if (r7 == null) goto L80;
            int r110 = e.s;
            Intrinsics.checkNotNullParameter(r7, "dto");
            e r28 = new e();
            r28.a = r7.getShopId();
            r28.b = r7.getShopName();
            r28.c = r7.getShopLogo();
            r7.getBrandTag();
            AuthorReputationVO.a r29 = AuthorReputationVO.Companion;
            AuthorReputationDTO r111 = r7.getReputationDTO();
            r29.getClass();
            if (r111 != null) goto L75;
            AuthorReputationVO r30 = null;
        L76:
            r28.d = r30;
            r28.e = r7.getShowSales();
            r28.f = r7.getShopValueInfo();
            r28.g = r7.getShopValueInfoWhite();
            r28.h = r7.getShopDisplayName();
            r28.i = r7.getTagList();
            r7.getShopLogoIcon();
            r28.j = r7.getShopXZGInfo();
            r28.k = r7.getShopType();
            r28.l = r7.getHeaderStyleConfig();
            r28.m = r7.getShopTypeDescription();
            List<ECShopSellingPointDTO> r31 = r7.getShopSellingPoint();
            if (r31 != null) goto L79;
            r31 = CollectionsKt.emptyList();
        L79:
            Intrinsics.checkNotNullParameter(r31, "<set-?>");
            r28.n = r31;
            r28.o = r7.getTagV2List();
            r28.p = r7.getTopTagList();
            r28.q = r7.getWelfareCorpLabelDTO();
            r28.r = r7.getShopTags();
        L81:
            r2.b = r28;
            if (r9 == null) goto L84;
            int r32 = d.k;
            Intrinsics.checkNotNullParameter(r9, "dto");
            d r33 = new d();
            r33.a = r9.getAuthorId();
            r33.b = r9.getSecAuthorId();
            r33.c = r9.getFollowStatus();
            r33.d = r9.getHideFollowBtn();
            r33.e = r9.getShowInfoColumn();
            r9.getFollowIconType();
            r33.f = r9.getFollowGiftConfig();
            r33.g = r9.getEntranceInformation();
            r33.h = r9.getFansInfo();
            r33.i = r9.getAuthorAvatar();
            r33.j = r9.getAuthorNickName();
            r9.getFollowTaskText();
        L85:
            r2.c = r33;
            if (r10 == null) goto L88;
            uj3.b r34 = new uj3.b();
            r34.a = r10.getType();
            r34.c = r10.a();
            r34.b = r10.b();
        L89:
            r2.d = r34;
            if (r11 == null) goto L105;
            int r35 = g.r;
            Intrinsics.checkNotNullParameter(r11, "dto");
            g r36 = new g();
            r36.a = r11.getProductCount();
            r36.b = r11.getStoreDetailUrl();
            r36.c = r11.getHideStoreDetailEntry();
            r36.d = r11.getCartEntryConfig();
            r36.e = r11.getDisplaySearch();
            r36.f = r11.getSearchHint();
            r36.g = r11.getOrderUrl();
            r36.h = r11.getCustomServiceEntryInfo();
            ServiceEntryInfo r37 = r11.getCustomServiceEntryInfo();
            if (r37 == null) goto L94;
            ECUrlModel r38 = r37.getIcon();
        L95:
            if (r38 != null) goto L103;
            ServiceEntryInfo r39 = r11.getCustomServiceEntryInfo();
            if (r39 == null) goto L99;
            String r40 = r39.getSchema();
        L100:
            if (r40 != null) goto L103;
            ServiceEntryInfo r41 = new ServiceEntryInfo();
            r41.setSchema(r11.getCustomServiceEntry());
            Unit r42 = Unit.INSTANCE;
            r36.h = r41;
        L104:
            r36.i = r11.getTopSearchInfo();
            r36.j = r11.getHideLiveInfo();
            r36.k = r11.getLiveStyle();
            r36.l = Boolean.valueOf(r11.getDisplayShopWindowEntry());
            r36.m = r11.getShopWindowUrl();
            r36.n = r11.getShopWindowProductCount();
            r36.o = r11.getRedpacketEntrance();
            r36.p = r11.getRedirectSchema();
            r36.q = r11.getMoreEntryInfo();
        L106:
            r2.e = r36;
            if (r12 == null) goto L120;
            int r43 = i.d;
            Intrinsics.checkNotNullParameter(r12, "dto");
            i r44 = new i();
            im.v r45 = r12.getLiveInfo();
            if (r45 == null) goto L111;
            StoreV3LiveRoomVO.Companion.getClass();
            StoreV3LiveRoomVO r46 = StoreV3LiveRoomVO.a.a(r45);
        L112:
            r44.a = r46;
            ShopHeaderVideoVO.a r47 = ShopHeaderVideoVO.Companion;
            List<ShopHeaderVideoInfo> r48 = r12.getVideoInfos();
            r47.getClass();
            ShopHeaderVideoVO r49 = new ShopHeaderVideoVO();
            if (r48 == null) goto L118;
            List<ShopHeaderVideoInfo> r50 = r48;
            ArrayList r51 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r50, 10));
            Iterator<T> r52 = r50.iterator();
        L116:
            if (r52.hasNext() == false) goto L119;
            ShopHeaderVideoInfo r53 = (ShopHeaderVideoInfo) r52.next();
            ShopHeaderVideoInfoVO.Companion.getClass();
            Intrinsics.checkNotNullParameter(r53, "dto");
            ShopHeaderVideoInfoVO r112 = new ShopHeaderVideoInfoVO();
            r112.setAwemedata(r53.getAwemeMoule());
            r51.add(r112);
        L119:
            r49.setFeedData(r51);
            r44.b = r49;
            r44.c = r12.getShowType();
        L121:
            r2.g = r44;
            if (r13 == null) goto L127;
            int r54 = h.c;
            Intrinsics.checkNotNullParameter(r13, "dto");
            h r55 = new h();
            r13.getShopDisplayName();
            r13.getShopDisplayName();
            r13.getShopLogo();
            r55.a = r13.getTagList();
            r13.getTagV2List();
            r13.getShopXZGInfo();
            List<ECShopSellingPointDTO> r56 = r13.getShopSellingPoint();
            if (r56 != null) goto L126;
            r56 = CollectionsKt.emptyList();
        L126:
            Intrinsics.checkNotNullParameter(r56, "<set-?>");
            r55.b = r56;
            r13.getHeaderStyleConfig();
        L127:
            if (r14 == null) goto L129;
            int r57 = j.g;
            Intrinsics.checkNotNullParameter(r14, "dto");
            j r58 = new j();
            r58.a = r14.getIcon();
            r58.b = r14.getBubbleText();
            r58.c = r14.getBubbleDismissTime();
            r58.d = r14.getBubbleMaxShowTimes();
            r14.getShareQrCodeStyle();
            r58.e = r14.getAnimationStyle();
        L130:
            r2.i = r58;
            r2.a = r15;
            r2.f = r26;
            r2.h = r27;
            r2.k = r8;
            LinkedHashMap r59 = new LinkedHashMap();
            Type r60 = new o().getType();
            ECShopHeadInfoBlock r61 = r2.n;
            boolean r62 = true;
            if (r61 == null) goto L156;
            Blcok r63 = r61.getBlock();
            if (r63 == null) goto L156;
            List<Module> r64 = r63.getModuleList();
            if (r64 == null) goto L156;
            Iterator<T> r65 = r64.iterator();
        L138:
            if (r65.hasNext() == false) goto L156;
            Module r66 = (Module) r65.next();
            Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L154
            int r68 = t0.a;     // Catch: Throwable -> L154
            Map r69 = (Map) t0.a.a.fromJson(r66.getData(), r60);     // Catch: Throwable -> L154
            Map<String, String> r113 = r66.getModuleExtra();     // Catch: Throwable -> L154
            if (r113 != null) goto L143;
            r113 = MapsKt.emptyMap();     // Catch: Throwable -> L154
        L143:
            Map r70 = MapsKt.mapOf(new Pair[]{TuplesKt.to("data", r69), TuplesKt.to("module_extra", r113)});     // Catch: Throwable -> L154
            String r71 = r66.getName();     // Catch: Throwable -> L154
            if (r71 != null) goto L147;
            r71 = "";
        L147:
            if (r71.length() <= 0) goto L149;
            boolean r114 = true;
        L150:
            if (r114 == false) goto L152;
            r59.put(r71, r70);     // Catch: Throwable -> L154
        L152:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L154
            goto L138
        L149:
            r114 = false;
        L154:
            th = move-exception;
            Result.Companion r72 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L156:
            com.bytedance.android.shopping.store.home.slice.d r73 = new com.bytedance.android.shopping.store.home.slice.d();
            Intrinsics.checkNotNullParameter(r59, "<set-?>");
            r73.b = r59;
            ECStoreHeaderInfoSliceConfig.a r74 = ECStoreHeaderInfoSliceConfig.Companion;
            ECShopHeadInfoBlock r75 = r2.n;
            if (r75 == null) goto L159;
            Map<String, String> r76 = r75.getExtra();
        L160:
            r74.getClass();
            if (r76 == null) goto L173;
            String r77 = r76.get("slice_configs");
            if (r77 == null) goto L173;
            Type r78 = new com.bytedance.android.shopping.store.home.slice.e().getType();
            Map<String, ECStoreHeaderInfoSliceConfig> r79 = MapsKt.emptyMap();
            Result.Companion r80 = Result.Companion;     // Catch: Throwable -> L171
            int r81 = t0.a;     // Catch: Throwable -> L171
            Map<String, ECStoreHeaderInfoSliceConfig> r82 = (Map) t0.a.b.fromJson(r77, r78);     // Catch: Throwable -> L171
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L169
        L174:
            r73.a = r82;
            r2.o = r73;
            r2.j = r5;
            r2.m = r21.getExtra();
            ECShopBrandModuleInfo r83 = r6;
            r2.l = r83;
            com.bytedance.android.shopping.store.home.slice.d r84 = r2.o;
            if (r84 == null) goto L179;
            Map<String, ? extends Object> r85 = r84.b;
            if (r85 == null) goto L179;
            Object r86 = r85.get(ECShopModuleType.SHOP_NORMAL_HEADER_INFO.getType());
        L181:
            if ((r86 instanceof Map) == true) goto L183;
            r86 = null;
        L183:
            Map r87 = (Map) r86;
            if (r87 == null) goto L186;
            Object r88 = r87.get("data");
        L188:
            if ((r88 instanceof Map) == true) goto L190;
            Object r89 = null;
        L191:
            Map r90 = (Map) r89;
            if (r90 == null) goto L198;
            Object r91 = r90.get("is_anchored");
            if (r91 == null) goto L198;
            Integer r92 = ECHybridExtensionsKt.i(r91);
            if (r92 == null) goto L198;
            int r93 = r92.intValue();
        L199:
            if (r93 >= 1) goto L209;
            if (r83 == null) goto L208;
            List<ECShopBrandHeaderModule> r94 = r83.getModuleList();
            if (r94 == null) goto L208;
            ECShopBrandHeaderModule r95 = (ECShopBrandHeaderModule) CollectionsKt.firstOrNull(r94);
            if (r95 == null) goto L208;
            if (r95.isAnchored() == true) goto L209;
        L208:
            r62 = false;
        L209:
            r2.q = r62;
            return r2;
        L198:
            r93 = 0;
            goto L199
        L190:
            r89 = r88;
            goto L191
        L186:
            r88 = null;
        L179:
            r86 = null;
        L169:
            th = th;
            r79 = r82;
        L172:
            Result.Companion r96 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            r82 = r79;
        L171:
            th = th;
        L173:
            r82 = MapsKt.emptyMap();
            goto L174
        L159:
            r76 = null;
            goto L160
        L129:
            r58 = null;
            goto L130
        L118:
            r51 = null;
            goto L119
        L111:
            r46 = null;
            goto L112
        L120:
            r44 = null;
            goto L121
        L99:
            r40 = null;
        L103:
            r36.h = r11.getCustomServiceEntryInfo();
            goto L104
        L94:
            r38 = null;
            goto L95
        L105:
            r36 = null;
            goto L106
        L88:
            r34 = null;
            goto L89
        L84:
            r33 = null;
            goto L85
        L75:
            r30 = new AuthorReputationVO();
            r30.setScore(r111.getScore());
            r30.setSales(r111.getSales());
            r30.setScoreNormalText(r111.getScoreNormalText());
            goto L76
        L80:
            r8 = r8;
            r28 = null;
        L69:
            r26 = null;
            r27 = null;
            r5 = null;
            r6 = null;
            r7 = null;
            r8 = null;
            r9 = null;
            r10 = null;
            r11 = null;
            r12 = null;
            r13 = null;
            r14 = null;
            r15 = null;
            goto L70
        }
    }

    static {
    }

    public n() {
    }

    public final int a() {
        Map<String, String> r0 = this.m;
        if (r0 == null) goto L10;
        String r1 = r0.get("framework_type");
        if (r1 == null) goto L10;
        Integer r2 = StringsKt.toIntOrNull(r1);
        if (r2 == null) goto L10;
        return r2.intValue();
    L10:
        return ShopFrameworkType.NORMAL.getType();
    }

    public final boolean b() {
        ECShopBrandModuleInfo r0 = this.l;
        Object r2 = null;
        if (r0 == null) goto L16;
        List<ECShopBrandHeaderModule> r1 = r0.getModuleList();
        if (r1 == null) goto L16;
        Iterator<T> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if (((ECShopBrandHeaderModule) r4).getModuleType() != 1) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L8;
        r2 = r4;
        goto L15
    L12:
        r5 = false;
    L15:
        r2 = (ECShopBrandHeaderModule) r2;
    L16:
        if (r2 == null) goto L24;
        return true;
    L24:
        return false;
    }

    public final boolean c() {
        ECAbnormalShopBasicInfo r0 = this.a;
        if (r0 == null) goto L7;
        ShopExtraStatus r1 = r0.getExtraStatus();
        if (r1 == null) goto L7;
        Integer r2 = r1.getExtraStatusType();
    L8:
        int r3 = ShopExtraStatusType.NON_OPERATE_STATUS.getType();
        if (r2 != null) goto L12;
    L14:
        return false;
    L12:
        if (r2.intValue() != r3) goto L14;
        return true;
    L7:
        r2 = null;
        goto L8
    }

    public final boolean d() {
        Map<String, String> r0 = this.m;
        if (r0 == null) goto L5;
        String r1 = r0.get("brand_shop");
    L7:
        if (Intrinsics.areEqual(r1, CommentScene.COMMENTSCENE_NO_AWEME) == true) goto L9;
    L11:
        return false;
    L9:
        if (c() == true) goto L11;
        return true;
    L5:
        r1 = null;
        goto L7
    }
}
