package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.data.y0;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.PageConfig;
import com.bytedance.android.shopping.anchorv4.dto.PendantContainer;
import com.bytedance.android.shopping.anchorv4.dto.QuestionnaireEntrance;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.helper.GlobalActionHandler;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements e {
    public q a;
    public final Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> b;
    public final PdpSliceLocalCacheHelper c;

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.d
    public final void a(PackResponseDTO r44) {
        Intrinsics.checkNotNullParameter(r44, "packDTO");
        boolean r3 = true;
        if (r44.hasMultipleChunks() == true) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if ((!r2) == false) goto L34;
        q r4 = new q(r44);
        int r5 = y0.a;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r6 = this.b;
        com.bytedance.android.shopping.anchorv4.vm.a r7 = r4.a();
        if (r7 != null) goto L13;
    L15:
        r3 = false;
    L16:
        r4.d = y0.a(r6, r44, r3, false);
        PackParsedDTO r8 = r44.getParsedDTO();
        if (r8 == null) goto L33;
        PageMeta r9 = r8.getPageMeta();
        if (r9 == null) goto L33;
        CommonMeta r10 = r9.getCommonMeta();
        if (r10 == null) goto L33;
        String r11 = r10.getEntranceInfo();
        if (r11 == null) goto L33;
        String r12 = a2.d(r11);
        if (r12 == null) goto L33;
        PackParsedDTO r1 = r44.getParsedDTO();
        if (r1 == null) goto L33;
        PageMeta r13 = r1.getPageMeta();
        if (r13 == null) goto L33;
        LinkedTreeMap r14 = r13.getTrackMeta();
        if (r14 == null) goto L33;
        r14.put("entrance_info", r12);
    L33:
        Unit r15 = Unit.INSTANCE;
        this.a = r4;
        return;
    L13:
        if (r7.a != true) goto L15;
    L34:
        PackParsedDTO r16 = r44.getParsedDTO();
        if (r16 == null) goto L41;
        List r17 = r16.getComponents();
        if (r17 == null) goto L41;
        if ((!r17.isEmpty()) != true) goto L41;
        boolean r18 = true;
    L42:
        PackParsedDTO r19 = null;
        if (r18 == false) goto L61;
        ArrayList r20 = new ArrayList();
        q r21 = this.a;
        if (r21 == null) goto L51;
        PackResponseDTO r22 = r21.o;
        if (r22 == null) goto L51;
        PackParsedDTO r23 = r22.getParsedDTO();
        if (r23 == null) goto L51;
        List r24 = r23.getComponents();
    L52:
        if (r24 != null) goto L54;
        r24 = CollectionsKt.emptyList();
    L54:
        r20.addAll(r24);
        PackParsedDTO r25 = r44.getParsedDTO();
        if (r25 == null) goto L57;
        List r26 = r25.getComponents();
    L58:
        if (r26 != null) goto L60;
        r26 = CollectionsKt.emptyList();
    L60:
        r20.addAll(r26);
        Unit r27 = Unit.INSTANCE;
        ArrayList r28 = r20;
    L62:
        PackParsedDTO r29 = r44.getParsedDTO();
        if (r29 == null) goto L65;
        AnchorV4HeadV2VO r30 = r29.getHeaderV2();
    L66:
        if (r30 == null) goto L98;
        q r31 = this.a;
        if (r31 == null) goto L98;
        PackResponseDTO r32 = r31.o;
        if (r32 == null) goto L98;
        PackParsedDTO r33 = r32.getParsedDTO();
        if (r33 == null) goto L98;
        AnchorV4HeadV2VO r34 = r33.getHeaderV2();
        if (r34 == null) goto L98;
        ArrayList r110 = new ArrayList();
        List<HeaderContentModel> r35 = r34.getCells();
        if (r35 != null) goto L78;
        r35 = CollectionsKt.emptyList();
    L78:
        r110.addAll(r35);
        PackParsedDTO r36 = r44.getParsedDTO();
        if (r36 == null) goto L83;
        AnchorV4HeadV2VO r37 = r36.getHeaderV2();
        if (r37 == null) goto L83;
        List<HeaderContentModel> r38 = r37.getCells();
    L84:
        if (r38 != null) goto L86;
        r38 = CollectionsKt.emptyList();
    L86:
        r110.addAll(r38);
        Unit r39 = Unit.INSTANCE;
        ArrayList r111 = new ArrayList();
        List<HeaderPendantModel> r40 = r34.getPendants();
        if (r40 != null) goto L89;
        r40 = CollectionsKt.emptyList();
    L89:
        r111.addAll(r40);
        PackParsedDTO r41 = r44.getParsedDTO();
        if (r41 == null) goto L94;
        AnchorV4HeadV2VO r42 = r41.getHeaderV2();
        if (r42 == null) goto L94;
        List<HeaderPendantModel> r43 = r42.getPendants();
    L95:
        if (r43 != null) goto L97;
        r43 = CollectionsKt.emptyList();
    L97:
        r111.addAll(r43);
        AnchorV4HeadV2VO r45 = AnchorV4HeadV2VO.copy$default(r34, 0, r111, r110, null, null, null, null, null, false, false, false, false, 0, null, null, null, null, null, 262137, null);
    L99:
        if (r18 == true) goto L101;
        if (r45 != null) goto L101;
    L126:
        PackParsedDTO r46 = r44.getParsedDTO();
        if (r46 == null) goto L129;
        e73.b r47 = r46.getActionStorage();
    L130:
        if (r47 == null) goto L152;
        LinkedHashMap r48 = new LinkedHashMap();
        q r49 = this.a;
        if (r49 == null) goto L140;
        PackResponseDTO r50 = r49.o;
        if (r50 == null) goto L140;
        PackParsedDTO r51 = r50.getParsedDTO();
        if (r51 == null) goto L140;
        e73.b r52 = r51.getActionStorage();
        if (r52 == null) goto L140;
        Map r53 = r52.a();
    L141:
        if (r53 != null) goto L143;
        r53 = MapsKt.emptyMap();
    L143:
        r48.putAll(r53);
        PackParsedDTO r54 = r44.getParsedDTO();
        if (r54 == null) goto L148;
        e73.b r55 = r54.getActionStorage();
        if (r55 == null) goto L148;
        Map r56 = r55.a();
    L149:
        if (r56 != null) goto L151;
        r56 = MapsKt.emptyMap();
    L151:
        r48.putAll(r56);
        Unit r57 = Unit.INSTANCE;
        e73.b r58 = new e73.b(r48);
    L153:
        PackParsedDTO r59 = r44.getParsedDTO();
        if (r59 == null) goto L158;
        PageMeta r60 = r59.getPageMeta();
        if (r60 == null) goto L158;
        CommonMeta r61 = r60.getCommonMeta();
    L159:
        if (r61 == null) goto L200;
        PackParsedDTO r62 = r44.getParsedDTO();
        if (r62 == null) goto L167;
        PageMeta r63 = r62.getPageMeta();
        if (r63 == null) goto L167;
        CommonMeta r64 = r63.getCommonMeta();
        if (r64 == null) goto L167;
        JsonObject r65 = r64.getPdpLynxData();
    L168:
        if (r65 == null) goto L180;
        q r66 = this.a;
        if (r66 == null) goto L180;
        PackResponseDTO r67 = r66.o;
        if (r67 == null) goto L180;
        PackParsedDTO r68 = r67.getParsedDTO();
        if (r68 == null) goto L180;
        PageMeta r69 = r68.getPageMeta();
        if (r69 == null) goto L180;
        CommonMeta r70 = r69.getCommonMeta();
        if (r70 == null) goto L180;
        r70.setPdpLynxData(r65);
    L180:
        PackParsedDTO r71 = r44.getParsedDTO();
        if (r71 == null) goto L187;
        PageMeta r72 = r71.getPageMeta();
        if (r72 == null) goto L187;
        CommonMeta r73 = r72.getCommonMeta();
        if (r73 == null) goto L187;
        String r74 = r73.getScreenShotParams();
    L188:
        if (r74 == null) goto L200;
        q r75 = this.a;
        if (r75 == null) goto L200;
        PackResponseDTO r76 = r75.o;
        if (r76 == null) goto L200;
        PackParsedDTO r77 = r76.getParsedDTO();
        if (r77 == null) goto L200;
        PageMeta r78 = r77.getPageMeta();
        if (r78 == null) goto L200;
        CommonMeta r79 = r78.getCommonMeta();
        if (r79 == null) goto L200;
        r79.setScreenShotParams(r74);
    L187:
        r74 = null;
    L167:
        r65 = null;
    L200:
        PackParsedDTO r80 = r44.getParsedDTO();
        if (r80 == null) goto L203;
        e73.e r81 = r80.getGlobal();
    L204:
        if (r81 == null) goto L239;
        q r82 = this.a;
        if (r82 == null) goto L212;
        PackResponseDTO r84 = r82.o;
        if (r84 == null) goto L212;
        PackParsedDTO r85 = r84.getParsedDTO();
        if (r85 == null) goto L212;
        e73.e r86 = r85.getGlobal();
    L213:
        PackParsedDTO r87 = r44.getParsedDTO();
        if (r87 == null) goto L216;
        e73.e r88 = r87.getGlobal();
    L217:
        if (r86 == null) goto L240;
        List r89 = r86.b();
        if (r89 != null) goto L223;
        if (r88 == null) goto L222;
        r89 = r88.b();
        goto L223
    L222:
        r89 = null;
    L223:
        Map r90 = r86.d();
        if (r90 != null) goto L228;
        if (r88 == null) goto L227;
        r90 = r88.d();
        goto L228
    L227:
        r90 = null;
    L228:
        String r112 = r86.a();
        if (r112 != null) goto L233;
        if (r88 == null) goto L232;
        r112 = r88.a();
        goto L233
    L232:
        r112 = null;
    L233:
        String r91 = r86.c();
        if (r91 != null) goto L238;
        if (r88 == null) goto L237;
        r91 = r88.c();
        goto L238
    L237:
        r91 = null;
    L238:
        r88 = new e73.e(r89, r112, r90, r91);
    L240:
        PackParsedDTO r92 = r44.getParsedDTO();
        q r94 = this.a;
        if (r94 == null) goto L326;
        PackResponseDTO r95 = r94.o;
        if (r95 == null) goto L327;
        PackParsedDTO r96 = r95.getParsedDTO();
        if (r96 == null) goto L323;
        if (r92 == null) goto L249;
        PageConfig r97 = r92.getPageConfig();
        if (r97 == null) goto L249;
    L250:
        PageConfig r210 = r97;
        List r98 = r28;
        if (r28 != null) goto L253;
        r98 = r96.getComponents();
    L253:
        List r99 = r98;
        if (r45 != null) goto L256;
        r45 = r96.getHeaderV2();
    L256:
        AnchorV4HeadV2VO r310 = r45;
        if (r58 != null) goto L259;
        r58 = r96.getActionStorage();
    L259:
        e73.b r113 = r58;
        if (r92 == null) goto L263;
        PendantContainer r100 = r92.getPendantContainer();
        if (r100 == null) goto L263;
    L264:
        PendantContainer r211 = r100;
        if (r92 == null) goto L268;
        GalleryVO r101 = r92.getGalleryVO();
        if (r101 == null) goto L268;
    L269:
        GalleryVO r212 = r101;
        if (r92 == null) goto L273;
        HeadMoreVideo r102 = r92.getMoreVideo();
        if (r102 == null) goto L273;
    L274:
        HeadMoreVideo r213 = r102;
        if (r92 == null) goto L278;
        e73.a r103 = r92.getActionGroup();
        if (r103 == null) goto L278;
    L279:
        e73.a r311 = r103;
        if (r92 == null) goto L283;
        ComponentDTO r104 = r92.getHalfStrandVO();
        if (r104 == null) goto L283;
    L284:
        ComponentDTO r312 = r104;
        if (r92 == null) goto L288;
        ComponentDTO r105 = r92.getSmallVideoVO();
        if (r105 == null) goto L288;
    L289:
        ComponentDTO r313 = r105;
        if (r92 == null) goto L293;
        ComponentDTO r106 = r92.getPlayBackFloatEntry();
        if (r106 == null) goto L293;
    L294:
        ComponentDTO r314 = r106;
        if (r92 == null) goto L298;
        ComponentDTO r107 = r92.getPendantInfo();
        if (r107 == null) goto L298;
    L299:
        ComponentDTO r315 = r107;
        if (r92 == null) goto L303;
        TopBannerVO r108 = r92.getTopBannerVO();
        if (r108 == null) goto L303;
    L304:
        TopBannerVO r214 = r108;
        if (r92 == null) goto L308;
        QuestionnaireEntrance r109 = r92.getQuestionnaireEntrance();
        if (r109 == null) goto L308;
    L309:
        QuestionnaireEntrance r215 = r109;
        if (r92 == null) goto L313;
        ComponentDTO r114 = r92.getShopFloatEntry();
        if (r114 == null) goto L313;
    L314:
        ComponentDTO r216 = r114;
        if (r92 == null) goto L318;
        ComponentDTO r115 = r92.getBackToTopEntry();
        if (r115 == null) goto L318;
    L319:
        ComponentDTO r217 = r115;
        if (r88 != null) goto L322;
        r88 = r96.getGlobal();
    L322:
        r19 = PackParsedDTO.copy$default(r96, r99, r113, null, null, null, null, null, null, null, null, null, null, r214, r212, r213, r216, r217, r210, r215, r211, null, null, r312, r313, null, null, r315, r314, r310, r311, r88, null, -2094002180, null);
    L318:
        r115 = r96.getBackToTopEntry();
    L313:
        r114 = r96.getShopFloatEntry();
    L308:
        r109 = r96.getQuestionnaireEntrance();
    L303:
        r108 = r96.getTopBannerVO();
    L298:
        r107 = r96.getPendantInfo();
    L293:
        r106 = r96.getPlayBackFloatEntry();
    L288:
        r105 = r96.getSmallVideoVO();
    L283:
        r104 = r96.getHalfStrandVO();
    L278:
        r103 = r96.getActionGroup();
    L273:
        r102 = r96.getMoreVideo();
    L268:
        r101 = r96.getGalleryVO();
    L263:
        r100 = r96.getPendantContainer();
    L249:
        r97 = r96.getPageConfig();
    L323:
        r95.setParsedDTO(r19);
        return;
    L327:
        return;
    L326:
        return;
    L216:
        r88 = null;
    L212:
        r86 = null;
        goto L213
    L239:
        r88 = null;
        goto L240
    L203:
        r81 = null;
    L158:
        r61 = null;
    L148:
        r56 = null;
    L140:
        r53 = null;
        goto L141
    L152:
        r58 = null;
        goto L153
    L129:
        r47 = null;
    L101:
        ArrayList r116 = new ArrayList();
        q r117 = this.a;
        if (r117 == null) goto L104;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r118 = r117.d;
    L105:
        if (r118 != null) goto L107;
        r118 = CollectionsKt.emptyList();
    L107:
        r116.addAll(r118);
        if (r18 == false) goto L118;
        int r119 = y0.a;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r120 = this.b;
        q r121 = this.a;
        if (r121 == null) goto L116;
        com.bytedance.android.shopping.anchorv4.vm.a r122 = r121.a();
        if (r122 == null) goto L116;
        if (r122.a != true) goto L116;
        boolean r123 = true;
    L117:
        r116.addAll(y0.a(r120, r44, r123, true));
    L116:
        r123 = false;
    L118:
        if (r45 != null) goto L120;
    L123:
        q r124 = this.a;
        if (r124 == null) goto L126;
        r124.d = r116;
        goto L126
    L120:
        if ((CollectionsKt.getOrNull(r116, 0) instanceof AnchorV4HeadV2VO) == false) goto L122;
        ListProtector.set(r116, 0, r45);
        goto L123
    L122:
        ListProtector.add(r116, 0, r45);
        goto L123
    L104:
        r118 = null;
    L94:
        r43 = null;
    L83:
        r38 = null;
    L98:
        r45 = null;
        goto L99
    L65:
        r30 = null;
        goto L66
    L57:
        r26 = null;
    L51:
        r24 = null;
        goto L52
    L61:
        r28 = null;
    L41:
        r18 = false;
        goto L42
    L5:
        if (r44.getValidChunkIndex() <= 0) goto L7;
        r2 = true;
        goto L9
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.e
    public final n b(n r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        return d(r3, true, false);
    }

    public h(Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r2, PdpSliceLocalCacheHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "voParseCache");
        Intrinsics.checkNotNullParameter(r3, "sliceLocalCacheHelper");
        this.b = r2;
        this.c = r3;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.e
    public final n c(n r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if (r3 <= 0) goto L6;
        return d(r2, false, true);
    L6:
        return d(r2, false, false);
    }

    public final n d(n r47, boolean r48, boolean r49) {
        com.bytedance.android.shopping.anchorv4.vm.a r3 = r47.y;
        if (r3 != null) goto L8;
        q r4 = this.a;
        if (r4 == null) goto L7;
        r3 = r4.a();
        goto L8
    L7:
        com.bytedance.android.shopping.anchorv4.vm.a r25 = null;
    L9:
        q r5 = this.a;
        if (r5 == null) goto L19;
        PackResponseDTO r6 = r5.o;
        if (r6 == null) goto L19;
        PackParsedDTO r7 = r6.getParsedDTO();
        if (r7 == null) goto L19;
        PageConfig r8 = r7.getPageConfig();
        if (r8 == null) goto L19;
        String r9 = r8.getBackgroundColor();
        if (r9 == null) goto L19;
    L20:
        String r26 = r9;
        List<ScrollNode> r10 = r47.x;
        if (r10 != null) goto L30;
        q r11 = this.a;
        if (r11 == null) goto L29;
        PackResponseDTO r12 = r11.o;
        if (r12 == null) goto L29;
        PackParsedDTO r13 = r12.getParsedDTO();
        if (r13 == null) goto L29;
        r10 = r13.getScrollNodes();
    L29:
        List<ScrollNode> r24 = null;
    L31:
        Map<String, SlcElement> r14 = r47.e;
        if (r14 != null) goto L41;
        q r15 = this.a;
        if (r15 == null) goto L40;
        PackResponseDTO r16 = r15.o;
        if (r16 == null) goto L40;
        PackParsedDTO r17 = r16.getParsedDTO();
        if (r17 == null) goto L40;
        r14 = r17.getTemplates();
    L40:
        Map<String, SlcElement> r18 = null;
    L42:
        TopRightControlsVO r19 = r47.l;
        if (r19 != null) goto L55;
        q r20 = this.a;
        if (r20 != null) goto L47;
        TopRightControlsVO r110 = null;
    L56:
        q r21 = this.a;
        if (r21 == null) goto L63;
        PackResponseDTO r22 = r21.o;
        if (r22 == null) goto L63;
        PromotionLogPbData r23 = r22.getLogPb();
        if (r23 == null) goto L63;
        String r27 = r23.getImprId();
    L64:
        q r28 = this.a;
        if (r28 == null) goto L71;
        PackResponseDTO r29 = r28.o;
        if (r29 == null) goto L71;
        PackParsedDTO r30 = r29.getParsedDTO();
        if (r30 == null) goto L71;
        Control r31 = r30.getControl();
    L72:
        q r32 = this.a;
        if (r32 == null) goto L79;
        PackResponseDTO r33 = r32.o;
        if (r33 == null) goto L79;
        PackParsedDTO r34 = r33.getParsedDTO();
        if (r34 == null) goto L79;
        PageMeta r111 = r34.getPageMeta();
    L80:
        int r35 = y0.a;
        q r36 = this.a;
        if (r36 == null) goto L83;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r37 = r36.d;
    L84:
        List r112 = y0.b(r49, r37, this.c);
        q r38 = this.a;
        if (r38 != null) goto L87;
        BottomButtonVO r113 = null;
    L95:
        q r39 = this.a;
        if (r39 == null) goto L102;
        PackResponseDTO r40 = r39.o;
        if (r40 == null) goto L102;
        PackParsedDTO r41 = r40.getParsedDTO();
        if (r41 == null) goto L102;
        BottomNavVO r310 = r41.getBottomNavVO();
    L103:
        q r42 = this.a;
        if (r42 == null) goto L110;
        PackResponseDTO r43 = r42.o;
        if (r43 == null) goto L110;
        PackParsedDTO r44 = r43.getParsedDTO();
        if (r44 == null) goto L110;
        AnchorV4HeadV2VO r210 = r44.getHeaderV2();
    L111:
        q r45 = this.a;
        if (r45 == null) goto L118;
        PackResponseDTO r46 = r45.o;
        if (r46 == null) goto L118;
        PackParsedDTO r50 = r46.getParsedDTO();
        if (r50 == null) goto L118;
        TopNavVO r311 = r50.getTopNavVO();
    L119:
        HalfStrandVO r51 = r47.m;
        if (r51 != null) goto L132;
        q r52 = this.a;
        if (r52 != null) goto L124;
        r51 = null;
        goto L132
    L124:
        if (r52.e != null) goto L130;
        HalfStrandVO.a r53 = HalfStrandVO.Companion;
        PackParsedDTO r114 = r52.o.getParsedDTO();
        if (r114 == null) goto L128;
        ComponentDTO r115 = r114.getHalfStrandVO();
    L129:
        r53.getClass();
        r52.e = HalfStrandVO.a.a(r115);
        goto L130
    L128:
        r115 = null;
    L130:
        r51 = r52.e;
    L132:
        if (r48 == false) goto L134;
        HalfStrandVO r116 = null;
    L135:
        SmallVideoWindowVO r54 = r47.p;
        if (r54 != null) goto L148;
        q r55 = this.a;
        if (r55 != null) goto L140;
        r54 = null;
        goto L148
    L140:
        if (r55.f != null) goto L146;
        SmallVideoWindowVO.a r56 = SmallVideoWindowVO.Companion;
        PackParsedDTO r117 = r55.o.getParsedDTO();
        if (r117 == null) goto L144;
        ComponentDTO r118 = r117.getSmallVideoVO();
    L145:
        r56.getClass();
        r55.f = SmallVideoWindowVO.a.a(r118);
        goto L146
    L144:
        r118 = null;
    L146:
        r54 = r55.f;
    L148:
        if (r48 == false) goto L150;
        SmallVideoWindowVO r119 = null;
    L151:
        ShopFloatEntryVO r57 = r47.q;
        if (r57 != null) goto L164;
        q r58 = this.a;
        if (r58 != null) goto L156;
        r57 = null;
        goto L164
    L156:
        if (r58.g != null) goto L162;
        ShopFloatEntryVO.a r59 = ShopFloatEntryVO.Companion;
        PackParsedDTO r120 = r58.o.getParsedDTO();
        if (r120 == null) goto L160;
        ComponentDTO r121 = r120.getShopFloatEntry();
    L161:
        r59.getClass();
        r58.g = ShopFloatEntryVO.a.a(r121);
        goto L162
    L160:
        r121 = null;
    L162:
        r57 = r58.g;
    L164:
        if (r48 == false) goto L166;
        ShopFloatEntryVO r122 = null;
    L167:
        BackToTopEntryVO r60 = r47.r;
        if (r60 != null) goto L180;
        q r61 = this.a;
        if (r61 != null) goto L172;
        r60 = null;
        goto L180
    L172:
        if (r61.h != null) goto L178;
        BackToTopEntryVO.a r62 = BackToTopEntryVO.Companion;
        PackParsedDTO r123 = r61.o.getParsedDTO();
        if (r123 == null) goto L176;
        ComponentDTO r124 = r123.getBackToTopEntry();
    L177:
        r62.getClass();
        r61.h = BackToTopEntryVO.a.a(r124);
        goto L178
    L176:
        r124 = null;
    L178:
        r60 = r61.h;
    L180:
        if (r48 == false) goto L182;
        BackToTopEntryVO r125 = null;
    L183:
        PlayBackEntryVO r63 = r47.s;
        if (r63 != null) goto L186;
    L190:
        q r64 = this.a;
        if (r64 != null) goto L193;
        r63 = null;
    L205:
        if (r48 == false) goto L207;
        PlayBackEntryVO r211 = null;
    L208:
        Map<String, PendantsComponentVO> r65 = r47.A;
        if (r65 != null) goto L221;
        q r66 = this.a;
        if (r66 != null) goto L213;
        r65 = null;
        goto L221
    L213:
        if (r66.j != null) goto L219;
        PendantsComponentVO.a r67 = PendantsComponentVO.Companion;
        PackParsedDTO r68 = r66.o.getParsedDTO();
        if (r68 == null) goto L217;
        ComponentDTO r69 = r68.getPendantInfo();
    L218:
        r67.getClass();
        r66.j = PendantsComponentVO.a.a(r69);
        goto L219
    L217:
        r69 = null;
    L219:
        r65 = r66.j;
    L221:
        if (r48 == false) goto L223;
        r65 = null;
    L223:
        Map<String, PendantsComponentVO> r212 = r65;
        e73.a r70 = r47.B;
        if (r70 != null) goto L232;
        q r71 = this.a;
        if (r71 != null) goto L228;
        r70 = null;
        goto L232
    L228:
        if (r71.k != null) goto L230;
        int r72 = GlobalActionHandler.e;
        r71.k = GlobalActionHandler.a.a(r71.o);
    L230:
        r70 = r71.k;
    L232:
        if (r48 == false) goto L234;
        e73.a r312 = null;
    L235:
        l73.c r73 = r47.n;
        if (r73 != null) goto L248;
        q r74 = this.a;
        if (r74 != null) goto L240;
        r73 = null;
        goto L248
    L240:
        if (r74.m != null) goto L246;
        int r75 = l73.c.e;
        PackParsedDTO r76 = r74.o.getParsedDTO();
        if (r76 == null) goto L244;
        QuestionnaireEntrance r77 = r76.getQuestionnaireEntrance();
    L245:
        r74.m = l73.c.a.a(r77);
        goto L246
    L244:
        r77 = null;
    L246:
        r73 = r74.m;
    L248:
        if (r48 == false) goto L250;
        l73.c r313 = null;
    L251:
        q r78 = this.a;
        if (r78 == null) goto L258;
        PackResponseDTO r79 = r78.o;
        if (r79 == null) goto L258;
        PackParsedDTO r80 = r79.getParsedDTO();
        if (r80 == null) goto L258;
        TopBannerVO r81 = r80.getTopBannerVO();
    L259:
        if (r48 == false) goto L261;
        TopBannerVO r314 = null;
    L262:
        q r82 = this.a;
        if (r82 != null) goto L265;
        JSONObject r84 = null;
    L277:
        if (r48 == false) goto L279;
        JSONObject r315 = null;
    L280:
        q r85 = this.a;
        if (r85 == null) goto L289;
        PackResponseDTO r86 = r85.o;
        if (r86 == null) goto L289;
        PackParsedDTO r87 = r86.getParsedDTO();
        if (r87 == null) goto L289;
        e73.e r88 = r87.getGlobal();
        if (r88 == null) goto L289;
        List r89 = r88.b();
    L290:
        if (r48 == false) goto L292;
        r89 = null;
    L292:
        List r316 = r89;
        q r90 = this.a;
        if (r90 == null) goto L301;
        PackResponseDTO r91 = r90.o;
        if (r91 == null) goto L301;
        PackParsedDTO r92 = r91.getParsedDTO();
        if (r92 == null) goto L301;
        e73.e r94 = r92.getGlobal();
        if (r94 == null) goto L301;
        Map r95 = r94.d();
    L302:
        if (r48 == false) goto L304;
        r95 = null;
    L304:
        Map r317 = r95;
        q r96 = this.a;
        if (r96 == null) goto L313;
        PackResponseDTO r97 = r96.o;
        if (r97 == null) goto L313;
        PackParsedDTO r98 = r97.getParsedDTO();
        if (r98 == null) goto L313;
        e73.e r99 = r98.getGlobal();
        if (r99 == null) goto L313;
        String r100 = r99.a();
    L314:
        if (r48 == false) goto L316;
        String r318 = null;
    L317:
        q r101 = this.a;
        if (r101 == null) goto L326;
        PackResponseDTO r102 = r101.o;
        if (r102 == null) goto L326;
        PackParsedDTO r103 = r102.getParsedDTO();
        if (r103 == null) goto L326;
        e73.e r104 = r103.getGlobal();
        if (r104 == null) goto L326;
        String r105 = r104.c();
    L327:
        if (r48 == false) goto L329;
        String r410 = null;
    L330:
        q r106 = this.a;
        if (r106 != null) goto L333;
        PendantContainerVO r107 = null;
    L341:
        if (r48 == false) goto L343;
        PendantContainerVO r411 = null;
    L344:
        q r108 = this.a;
        if (r108 == null) goto L351;
        PackResponseDTO r109 = r108.o;
        if (r109 == null) goto L351;
        PackParsedDTO r126 = r109.getParsedDTO();
        if (r126 == null) goto L351;
        GalleryVO r127 = r126.getGalleryVO();
    L352:
        y0.c(r127, r49, this.c);
        if (r48 == false) goto L355;
        GalleryVO r412 = null;
    L356:
        q r2 = this.a;
        if (r2 == null) goto L363;
        PackResponseDTO r128 = r2.o;
        if (r128 == null) goto L363;
        PackParsedDTO r129 = r128.getParsedDTO();
        if (r129 == null) goto L363;
        HeadMoreVideo r130 = r129.getMoreVideo();
    L364:
        if (r48 == false) goto L366;
        HeadMoreVideo r413 = null;
    L367:
        q r131 = this.a;
        if (r131 == null) goto L376;
        PackResponseDTO r132 = r131.o;
        if (r132 == null) goto L376;
        PackParsedDTO r133 = r132.getParsedDTO();
        if (r133 == null) goto L376;
        e73.b r134 = r133.getActionStorage();
        if (r134 == null) goto L376;
        Map r135 = r134.a();
    L377:
        if (r48 == false) goto L379;
        Map r136 = null;
    L381:
        return n.a(r47, r111, r31, r27, r112, r18, null, null, null, null, r113, r110, r116, r313, r411, r119, r122, r125, r211, r210, null, null, null, r24, r25, r26, r212, r312, r315, r316, r317, r311, r310, r314, r412, r318, r410, r413, r136, 7341024, 0);
    L379:
        r136 = r135;
    L376:
        r135 = null;
        goto L377
    L366:
        r413 = r130;
    L363:
        r130 = null;
        goto L364
    L355:
        r412 = r127;
    L351:
        r127 = null;
        goto L352
    L343:
        r411 = r107;
        goto L344
    L333:
        if (r106.n != null) goto L339;
        PendantContainerVO.Companion r137 = PendantContainerVO.Companion;
        PackParsedDTO r138 = r106.o.getParsedDTO();
        if (r138 == null) goto L337;
        PendantContainer r139 = r138.getPendantContainer();
    L338:
        r137.getClass();
        r106.n = PendantContainerVO.Companion.c(r139);
        goto L339
    L337:
        r139 = null;
    L339:
        r107 = r106.n;
        goto L341
    L329:
        r410 = r105;
    L326:
        r105 = null;
        goto L327
    L316:
        r318 = r100;
    L313:
        r100 = null;
    L301:
        r95 = null;
    L289:
        r89 = null;
        goto L290
    L279:
        r315 = r84;
        goto L280
    L265:
        if (r82.l != null) goto L275;
        PackParsedDTO r140 = r82.o.getParsedDTO();
        if (r140 == null) goto L273;
        PageMeta r141 = r140.getPageMeta();
        if (r141 == null) goto L273;
        CommonMeta r142 = r141.getCommonMeta();
        if (r142 == null) goto L273;
        JSONObject r143 = h73.a.d(r142);
    L274:
        r82.l = r143;
    L273:
        r143 = null;
    L275:
        r84 = r82.l;
        goto L277
    L261:
        r314 = r81;
    L258:
        r81 = null;
        goto L259
    L250:
        r313 = r73;
        goto L251
    L234:
        r312 = r70;
        goto L235
    L207:
        r211 = r63;
        goto L208
    L193:
        if (r64.i != null) goto L203;
        PlayBackEntryVO.a r144 = PlayBackEntryVO.Companion;
        PackParsedDTO r145 = r64.o.getParsedDTO();
        if (r145 == null) goto L197;
        ComponentDTO r146 = r145.getPlayBackFloatEntry();
    L198:
        PackParsedDTO r147 = r64.o.getParsedDTO();
        if (r147 == null) goto L201;
        AnchorV4HeadV2VO r148 = r147.getHeaderV2();
    L202:
        boolean r149 = r64.o.getFromCache();
        r144.getClass();
        r64.i = PlayBackEntryVO.a.b(r146, r148, r149);
        goto L203
    L201:
        r148 = null;
        goto L202
    L197:
        r146 = null;
    L203:
        r63 = r64.i;
        goto L205
    L186:
        if ((!r63.isFromCache()) == true) goto L189;
        r63 = null;
    L189:
        if (r63 != null) goto L205;
    L182:
        r125 = r60;
        goto L183
    L166:
        r122 = r57;
        goto L167
    L150:
        r119 = r54;
        goto L151
    L134:
        r116 = r51;
    L118:
        r311 = null;
    L110:
        r210 = null;
    L102:
        r310 = null;
        goto L103
    L87:
        if (r38.a != null) goto L93;
        BottomButtonVO.a r150 = BottomButtonVO.Companion;
        PackParsedDTO r151 = r38.o.getParsedDTO();
        if (r151 == null) goto L91;
        ComponentDTO r152 = r151.getBottomButton();
    L92:
        r150.getClass();
        r38.a = BottomButtonVO.a.a(r152);
        goto L93
    L91:
        r152 = null;
    L93:
        r113 = r38.a;
        goto L95
    L83:
        r37 = null;
    L79:
        r111 = null;
    L71:
        r31 = null;
    L63:
        r27 = null;
        goto L64
    L47:
        if (r20.b != null) goto L53;
        TopRightControlsVO.a r153 = TopRightControlsVO.Companion;
        PackParsedDTO r154 = r20.o.getParsedDTO();
        if (r154 == null) goto L51;
        ComponentDTO r155 = r154.getTopRightControls();
    L52:
        r153.getClass();
        r20.b = TopRightControlsVO.a.a(r155);
        goto L53
    L51:
        r155 = null;
    L53:
        r19 = r20.b;
    L55:
        r110 = r19;
    L41:
        r18 = r14;
    L30:
        r24 = r10;
    L19:
        r9 = r47.z;
    L8:
        r25 = r3;
        goto L9
    }
}
