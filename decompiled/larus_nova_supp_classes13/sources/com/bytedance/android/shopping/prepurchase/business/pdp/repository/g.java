package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ecom.arch.slice.action.IAction;
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
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottom;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryPendants;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.helper.GlobalActionHandler;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements e {
    public static final a i = null;
    public PackResponseDTO a;
    public PackResponseDTO b;
    public TopRightControlsVO c;
    public com.bytedance.android.shopping.anchorv4.vm.a d;
    public List<com.bytedance.android.ecom.arch.slice.adapter.b> e;
    public BottomButtonVO f;
    public final Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> g;
    public final PdpSliceLocalCacheHelper h;

    public static final class a {
        public a() {
        }

        public static void b(List r4, PdpSliceLocalCacheHelper r5) {
            if (r4 == null) goto L18;
            Iterator r6 = r4.iterator();
        L5:
            if (r6.hasNext() == false) goto L24;
            com.bytedance.android.ecom.arch.slice.g r0 = (com.bytedance.android.ecom.arch.slice.g) r6.next();
            String r1 = r0.getSliceId();
            if (r1 != null) goto L9;
            r1 = "";
        L9:
            r5.getClass();
            if (r1.length() != 0) goto L12;
            boolean r2 = true;
        L13:
            if (r2 == false) goto L15;
            Map r3 = null;
        L16:
            if (r3 == null) goto L5;
            com.bytedance.android.ecom.arch.slice.g.a.a(r0, r3, false, 4);
            goto L5
        L15:
            r3 = (Map) ((LinkedHashMap) r5.a).get(r1);
            goto L16
        L12:
            r2 = false;
            goto L13
        L24:
            return;
        }

        public static List a(Map r5, PackResponseDTO r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r5, "voParseCache");
            Intrinsics.checkNotNullParameter(r6, "packDTO");
            ArrayList r0 = new ArrayList();
            PackParsedDTO r1 = r6.getParsedDTO();
            if (r1 == null) goto L7;
            AnchorV4HeadV2VO r2 = r1.getHeaderV2();
            if (r2 == null) goto L7;
            r0.add(r2);
        L7:
            PackParsedDTO r8 = r6.getParsedDTO();
            if (r8 == null) goto L107;
            List r9 = r8.getComponents();
            if (r9 == null) goto L107;
            List r10 = CollectionsKt.filterNotNull(r9);
            if (r10 == null) goto L107;
            Iterator r11 = r10.iterator();
        L15:
            if (r11.hasNext() == false) goto L107;
            ComponentDTO r3 = (com.bytedance.android.ecom.arch.slice.g) r11.next();
            if ((r3 instanceof ComponentDTO) == true) goto L18;
            r0.add(r3);
            goto L15
        L18:
            ComponentDTO r4 = r3;
            String r12 = r4.getComponentId();
            ComponentIDs r13 = ComponentIDs.HEAD_SLIDES;
            if (Intrinsics.areEqual(r12, r13.getId()) == true) goto L20;
            if (Intrinsics.areEqual(r12, ComponentIDs.RECEIVING_NOTICE.getId()) == true) goto L25;
            if (Intrinsics.areEqual(r12, ComponentIDs.BASE_INFO.getId()) == true) goto L30;
            if (Intrinsics.areEqual(r12, ComponentIDs.LOGISTICS_AND_COUPON.getId()) == true) goto L35;
            if (Intrinsics.areEqual(r12, ComponentIDs.CAR_ADDRESS.getId()) == true) goto L40;
            if (Intrinsics.areEqual(r12, ComponentIDs.COMMENTS.getId()) == true) goto L45;
            if (Intrinsics.areEqual(r12, ComponentIDs.SHOP_AND_STORE.getId()) == true) goto L50;
            if (Intrinsics.areEqual(r12, ComponentIDs.AUCTION_FLOW.getId()) == true) goto L55;
            if (Intrinsics.areEqual(r12, ComponentIDs.OFFER_RECORDS.getId()) == true) goto L60;
            if (Intrinsics.areEqual(r12, ComponentIDs.SHOP_COUPONS.getId()) == true) goto L65;
            if (Intrinsics.areEqual(r12, ComponentIDs.EP_COURSES.getId()) == true) goto L68;
            if (Intrinsics.areEqual(r12, ComponentIDs.EP_REGISTER.getId()) == true) goto L71;
            if (Intrinsics.areEqual(r12, ComponentIDs.EP_TEACHER.getId()) == true) goto L74;
            if (Intrinsics.areEqual(r12, ComponentIDs.SHOP_CONFIGURED_GOODS.getId()) == true) goto L77;
            if (Intrinsics.areEqual(r12, ComponentIDs.DELETED_PRODUCT_TIP.getId()) == true) goto L80;
            if (Intrinsics.areEqual(r12, ComponentIDs.KOL_EVALUATION.getId()) == true) goto L85;
            if (Intrinsics.areEqual(r12, ComponentIDs.COMBINE.getId()) == true) goto L90;
            UI r14 = r4.getUi();
            String r15 = null;
            if (r14 == null) goto L96;
            String r16 = r14.getContainerType();
        L98:
            if (Intrinsics.areEqual(r16, "lynx") == false) goto L100;
            int r17 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.h;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C0016a.a(r4));
        L100:
            UI r18 = r4.getUi();
            if (r18 == null) goto L104;
            r15 = r18.getContainerType();
        L104:
            if (Intrinsics.areEqual(r15, "lynx-air") == false) goto L15;
            int r19 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a.g;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a.C0017a.a(r4));
            goto L15
        L96:
            r16 = null;
            goto L98
        L90:
            int r20 = com.bytedance.android.shopping.anchorv4.voavhs.detailhead.a.d;
            com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r21 = com.bytedance.android.shopping.anchorv4.voavhs.detailhead.a.C0007a.a(r4);
            if (r21 == null) goto L15;
            r0.add(r21);
            goto L15
        L85:
            int r22 = com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.b.e;
            com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.b r23 = com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.b.a.a(r4);
            if (r23 == null) goto L15;
            r0.add(r23);
            goto L15
        L80:
            int r24 = c83.a.d;
            c83.a r25 = c83.a.C0004a.a(r4);
            if (r25 == null) goto L15;
            r0.add(r25);
            goto L15
        L77:
            int r26 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.h;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C0016a.a(r4));
            goto L15
        L74:
            int r27 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.h;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C0016a.a(r4));
            goto L15
        L71:
            int r28 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.h;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C0016a.a(r4));
            goto L15
        L68:
            int r29 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.h;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C0016a.a(r4));
            goto L15
        L65:
            int r30 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.h;
            r0.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C0016a.a(r4));
            goto L15
        L60:
            int r31 = l83.a.e;
            l83.a r32 = l83.a.C0214a.a(r4);
            if (r32 == null) goto L15;
            r0.add(r32);
            goto L15
        L55:
            int r33 = m83.a.e;
            m83.a r34 = m83.a.C0217a.a(r4);
            if (r34 == null) goto L15;
            r0.add(r34);
            goto L15
        L50:
            int r35 = com.bytedance.android.shopping.anchorv4.voavhs.shop.b.f;
            com.bytedance.android.shopping.anchorv4.voavhs.shop.b r36 = com.bytedance.android.shopping.anchorv4.voavhs.shop.b.a.a(r4);
            if (r36 == null) goto L15;
            r0.add(r36);
            goto L15
        L45:
            int r37 = com.bytedance.android.shopping.anchorv4.voavhs.comment.e.e;
            com.bytedance.android.shopping.anchorv4.voavhs.comment.e r38 = com.bytedance.android.shopping.anchorv4.voavhs.comment.e.a.b(r4);
            if (r38 == null) goto L15;
            r0.add(r38);
            goto L15
        L40:
            int r39 = com.bytedance.android.shopping.anchorv4.voavhs.car.b.f;
            com.bytedance.android.shopping.anchorv4.voavhs.car.b r40 = com.bytedance.android.shopping.anchorv4.voavhs.car.b.a.a(r4);
            if (r40 == null) goto L15;
            r0.add(r40);
            goto L15
        L35:
            int r41 = com.bytedance.android.shopping.anchorv4.voavhs.logistics.a.e;
            com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r42 = com.bytedance.android.shopping.anchorv4.voavhs.logistics.a.C0015a.a(r4);
            if (r42 == null) goto L15;
            r0.add(r42);
            goto L15
        L30:
            int r43 = com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c.f;
            com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c r44 = com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c.a.a(r4, r7);
            if (r44 == null) goto L15;
            r0.add(r44);
            goto L15
        L25:
            int r45 = com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c.f;
            com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c r46 = com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c.a.a(r4);
            if (r46 == null) goto L15;
            r0.add(r46);
            goto L15
        L20:
            AnchorV4HeadVO.Companion.getClass();
            AnchorV4HeadVO r47 = AnchorV4HeadVO.a.a(r4);
            if (r47 == null) goto L15;
            r5.put(r13.getId(), r47);
            r0.add(r47);
        L107:
            return r0;
        }
    }

    static {
        i = new a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.d
    public final void a(PackResponseDTO r6) {
        Intrinsics.checkNotNullParameter(r6, "dTO");
        Boolean r1 = null;
        if (r6.isFirstChunk() == false) goto L5;
    L22:
        this.a = r6;
        PackParsedDTO r7 = r6.getParsedDTO();
        if (r7 == null) goto L27;
        PageConfig r8 = r7.getPageConfig();
        if (r8 == null) goto L27;
        Boolean r9 = Boolean.valueOf(r8.getCollapseDetail());
    L28:
        boolean r10 = com.bytedance.android.shopping.extensions.k.i(r9);
        PackResponseDTO r2 = this.a;
        if (r2 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L31:
        PackParsedDTO r3 = r2.getParsedDTO();
        if (r3 == null) goto L36;
        PageConfig r4 = r3.getPageConfig();
        if (r4 == null) goto L36;
        List r5 = r4.getCollapseIgnoreList();
    L37:
        this.d = new com.bytedance.android.shopping.anchorv4.vm.a(r10, r5);
        BottomButtonVO.a r0 = BottomButtonVO.Companion;
        PackResponseDTO r11 = this.a;
        if (r11 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L40:
        PackParsedDTO r12 = r11.getParsedDTO();
        if (r12 == null) goto L43;
        ComponentDTO r13 = r12.getBottomButton();
    L44:
        r0.getClass();
        this.f = BottomButtonVO.a.a(r13);
        a r14 = i;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r15 = this.g;
        PackResponseDTO r16 = this.a;
        if (r16 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L47:
        r14.getClass();
        this.e = a.a(r15, r16, r10);
        TopRightControlsVO.a r17 = TopRightControlsVO.Companion;
        PackResponseDTO r18 = this.a;
        if (r18 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L50:
        PackParsedDTO r19 = r18.getParsedDTO();
        if (r19 == null) goto L53;
        r1 = r19.getTopRightControls();
    L53:
        r17.getClass();
        this.c = TopRightControlsVO.a.a(r1);
        return;
    L43:
        r13 = null;
    L36:
        r5 = null;
    L27:
        r9 = null;
        goto L28
    L5:
        if (r6.hasMultipleChunks() == false) goto L22;
        this.b = r6;
        PackParsedDTO r20 = r6.getParsedDTO();
        if (r20 == null) goto L12;
        PageConfig r21 = r20.getPageConfig();
        if (r21 == null) goto L12;
        r1 = Boolean.valueOf(r21.getCollapseDetail());
    L12:
        boolean r22 = com.bytedance.android.shopping.extensions.k.i(r1);
        a r23 = i;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r24 = this.g;
        r23.getClass();
        List r25 = a.a(r24, r6, r22);
        if (this.e == null) goto L15;
        boolean r26 = true;
    L16:
        if (r26 == true) goto L18;
        ECExceptionMonitor.e(new IllegalStateException("pdp componentList is null"));
    L18:
        ArrayList r27 = new ArrayList();
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r28 = this.e;
        if (r28 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L21:
        r27.addAll(r28);
        r27.addAll(r25);
        Unit r29 = Unit.INSTANCE;
        this.e = r27;
        return;
    L15:
        r26 = false;
        goto L16
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.e
    public final n b(n r45) {
        Intrinsics.checkNotNullParameter(r45, "data");
        PackResponseDTO r2 = this.a;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L5:
        PromotionLogPbData r3 = r2.getLogPb();
        if (r3 == null) goto L8;
        String r5 = r3.getImprId();
    L9:
        PackResponseDTO r4 = this.a;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L12:
        PackParsedDTO r6 = r4.getParsedDTO();
        if (r6 == null) goto L15;
        Control r7 = r6.getControl();
    L16:
        PackResponseDTO r8 = this.a;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L19:
        PackParsedDTO r9 = r8.getParsedDTO();
        if (r9 == null) goto L22;
        PageMeta r10 = r9.getPageMeta();
    L23:
        com.bytedance.android.shopping.anchorv4.vm.a r15 = this.d;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("collapseInfo");
    L26:
        PackResponseDTO r11 = this.a;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L29:
        PackParsedDTO r12 = r11.getParsedDTO();
        if (r12 == null) goto L35;
        PageConfig r13 = r12.getPageConfig();
        if (r13 == null) goto L35;
        String r14 = r13.getBackgroundColor();
        if (r14 == null) goto L35;
    L36:
        String r26 = r14;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r16 = this.e;
        if (r16 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L39:
        BottomButtonVO r17 = this.f;
        PackResponseDTO r18 = this.a;
        if (r18 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L42:
        PackParsedDTO r19 = r18.getParsedDTO();
        if (r19 == null) goto L45;
        List r24 = r19.getScrollNodes();
    L46:
        PackResponseDTO r110 = this.a;
        if (r110 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L49:
        PackParsedDTO r111 = r110.getParsedDTO();
        if (r111 == null) goto L52;
        Map r25 = r111.getTemplates();
    L53:
        TopRightControlsVO r112 = this.c;
        PackResponseDTO r20 = this.a;
        if (r20 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L56:
        PackParsedDTO r21 = r20.getParsedDTO();
        if (r21 == null) goto L59;
        TopNavVO r32 = r21.getTopNavVO();
    L60:
        PackResponseDTO r22 = this.a;
        if (r22 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L63:
        PackParsedDTO r23 = r22.getParsedDTO();
        if (r23 == null) goto L66;
        BottomNavVO r34 = r23.getBottomNavVO();
    L67:
        PackResponseDTO r27 = this.a;
        if (r27 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L70:
        PackParsedDTO r28 = r27.getParsedDTO();
        if (r28 == null) goto L73;
        AnchorV4HeadV2VO r42 = r28.getHeaderV2();
    L74:
        PackResponseDTO r29 = this.a;
        if (r29 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L77:
        PackParsedDTO r30 = r29.getParsedDTO();
        if (r30 == null) goto L80;
        TopBannerVO r43 = r30.getTopBannerVO();
    L82:
        return n.a(r45, r10, r7, r5, r16, r25, null, null, null, null, r17, r112, null, null, null, null, null, null, null, r42, null, null, null, r24, r15, r26, null, null, null, null, null, r32, r34, r43, null, null, null, null, null, 2088236000, 124);
    L80:
        r43 = null;
        goto L82
    L73:
        r42 = null;
        goto L74
    L66:
        r34 = null;
        goto L67
    L59:
        r32 = null;
        goto L60
    L52:
        r25 = null;
        goto L53
    L45:
        r24 = null;
    L35:
        r14 = r45.z;
        goto L36
    L22:
        r10 = null;
        goto L23
    L15:
        r7 = null;
        goto L16
    L8:
        r5 = null;
        goto L9
    }

    public final n d(n r46) {
        PackResponseDTO r1 = this.a;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L5:
        PromotionLogPbData r2 = r1.getLogPb();
        if (r2 == null) goto L8;
        String r7 = r2.getImprId();
    L9:
        PackResponseDTO r3 = this.a;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L12:
        PackParsedDTO r4 = r3.getParsedDTO();
        if (r4 == null) goto L15;
        Control r6 = r4.getControl();
    L16:
        PackResponseDTO r5 = this.a;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L19:
        PackParsedDTO r8 = r5.getParsedDTO();
        if (r8 == null) goto L22;
        PageMeta r9 = r8.getPageMeta();
    L23:
        com.bytedance.android.shopping.anchorv4.vm.a r10 = this.d;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("collapseInfo");
    L26:
        PackResponseDTO r11 = this.a;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L29:
        PackParsedDTO r12 = r11.getParsedDTO();
        if (r12 == null) goto L37;
        PageConfig r13 = r12.getPageConfig();
        if (r13 == null) goto L37;
        String r14 = r13.getBackgroundColor();
        if (r14 == null) goto L37;
        String r29 = r14;
    L38:
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r15 = this.e;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L41:
        BottomButtonVO r16 = this.f;
        PackResponseDTO r17 = this.a;
        if (r17 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L44:
        PackParsedDTO r18 = r17.getParsedDTO();
        if (r18 == null) goto L47;
        List r27 = r18.getScrollNodes();
    L48:
        PackResponseDTO r19 = this.a;
        if (r19 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L51:
        PackParsedDTO r20 = r19.getParsedDTO();
        if (r20 == null) goto L54;
        Map r21 = r20.getTemplates();
    L55:
        TopRightControlsVO r110 = this.c;
        HalfStrandVO.a r111 = HalfStrandVO.Companion;
        PackResponseDTO r112 = this.a;
        if (r112 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L58:
        PackParsedDTO r113 = r112.getParsedDTO();
        if (r113 == null) goto L61;
        ComponentDTO r114 = r113.getHalfStrandVO();
    L62:
        r111.getClass();
        HalfStrandVO r115 = HalfStrandVO.a.a(r114);
        SmallVideoWindowVO.a r116 = SmallVideoWindowVO.Companion;
        PackResponseDTO r117 = this.a;
        if (r117 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L65:
        PackParsedDTO r118 = r117.getParsedDTO();
        if (r118 == null) goto L68;
        ComponentDTO r119 = r118.getSmallVideoVO();
    L69:
        r116.getClass();
        SmallVideoWindowVO r120 = SmallVideoWindowVO.a.a(r119);
        ShopFloatEntryVO.a r121 = ShopFloatEntryVO.Companion;
        PackResponseDTO r122 = this.a;
        if (r122 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L72:
        PackParsedDTO r123 = r122.getParsedDTO();
        if (r123 == null) goto L75;
        ComponentDTO r124 = r123.getShopFloatEntry();
    L76:
        r121.getClass();
        ShopFloatEntryVO r22 = ShopFloatEntryVO.a.a(r124);
        BackToTopEntryVO.a r125 = BackToTopEntryVO.Companion;
        PackResponseDTO r126 = this.a;
        if (r126 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L79:
        PackParsedDTO r127 = r126.getParsedDTO();
        if (r127 == null) goto L82;
        ComponentDTO r128 = r127.getBackToTopEntry();
    L83:
        r125.getClass();
        BackToTopEntryVO r23 = BackToTopEntryVO.a.a(r128);
        PlayBackEntryVO.a r129 = PlayBackEntryVO.Companion;
        PackResponseDTO r130 = this.a;
        if (r130 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L86:
        PackParsedDTO r131 = r130.getParsedDTO();
        if (r131 == null) goto L89;
        ComponentDTO r132 = r131.getPlayBackFloatEntry();
    L90:
        PackResponseDTO r133 = this.a;
        if (r133 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L93:
        PackParsedDTO r134 = r133.getParsedDTO();
        if (r134 == null) goto L96;
        AnchorV4HeadV2VO r135 = r134.getHeaderV2();
    L97:
        PackResponseDTO r24 = this.a;
        if (r24 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L100:
        boolean r25 = r24.getFromCache();
        r129.getClass();
        PlayBackEntryVO r26 = PlayBackEntryVO.a.b(r132, r135, r25);
        PendantsComponentVO.a r28 = PendantsComponentVO.Companion;
        PackResponseDTO r136 = this.a;
        if (r136 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L103:
        PackParsedDTO r137 = r136.getParsedDTO();
        if (r137 == null) goto L106;
        ComponentDTO r138 = r137.getPendantInfo();
    L107:
        r28.getClass();
        Map r30 = PendantsComponentVO.a.a(r138);
        int r31 = GlobalActionHandler.e;
        PackResponseDTO r32 = this.a;
        if (r32 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L110:
        e73.a r33 = GlobalActionHandler.a.a(r32);
        PackResponseDTO r34 = this.a;
        if (r34 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L113:
        PackParsedDTO r35 = r34.getParsedDTO();
        if (r35 == null) goto L120;
        PageMeta r36 = r35.getPageMeta();
        if (r36 == null) goto L120;
        CommonMeta r37 = r36.getCommonMeta();
        if (r37 == null) goto L120;
        JSONObject r38 = h73.a.d(r37);
    L121:
        PackResponseDTO r39 = this.a;
        if (r39 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L124:
        PackParsedDTO r40 = r39.getParsedDTO();
        if (r40 == null) goto L129;
        e73.e r41 = r40.getGlobal();
        if (r41 == null) goto L129;
        List r310 = r41.b();
    L130:
        PackResponseDTO r42 = this.a;
        if (r42 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L133:
        PackParsedDTO r43 = r42.getParsedDTO();
        if (r43 == null) goto L138;
        e73.e r44 = r43.getGlobal();
        if (r44 == null) goto L138;
        Map r311 = r44.d();
    L139:
        PackResponseDTO r45 = this.a;
        if (r45 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L142:
        PackParsedDTO r47 = r45.getParsedDTO();
        if (r47 == null) goto L147;
        e73.e r48 = r47.getGlobal();
        if (r48 == null) goto L147;
        String r312 = r48.a();
    L148:
        PackResponseDTO r49 = this.a;
        if (r49 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L151:
        PackParsedDTO r50 = r49.getParsedDTO();
        if (r50 == null) goto L156;
        e73.e r51 = r50.getGlobal();
        if (r51 == null) goto L156;
        String r410 = r51.c();
    L157:
        PackResponseDTO r52 = this.a;
        if (r52 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L160:
        PackParsedDTO r53 = r52.getParsedDTO();
        if (r53 == null) goto L163;
        TopNavVO r313 = r53.getTopNavVO();
    L164:
        PackResponseDTO r54 = this.a;
        if (r54 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L167:
        PackParsedDTO r55 = r54.getParsedDTO();
        if (r55 == null) goto L170;
        BottomNavVO r314 = r55.getBottomNavVO();
    L171:
        PackResponseDTO r56 = this.a;
        if (r56 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L174:
        PackParsedDTO r57 = r56.getParsedDTO();
        if (r57 == null) goto L177;
        AnchorV4HeadV2VO r210 = r57.getHeaderV2();
    L178:
        PackResponseDTO r58 = this.a;
        if (r58 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L181:
        PackParsedDTO r59 = r58.getParsedDTO();
        if (r59 == null) goto L184;
        TopBannerVO r315 = r59.getTopBannerVO();
    L185:
        PackResponseDTO r60 = this.a;
        if (r60 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L188:
        PackParsedDTO r61 = r60.getParsedDTO();
        if (r61 == null) goto L191;
        GalleryVO r316 = r61.getGalleryVO();
    L192:
        int r62 = l73.c.e;
        PackResponseDTO r63 = this.a;
        if (r63 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L195:
        PackParsedDTO r64 = r63.getParsedDTO();
        if (r64 == null) goto L198;
        QuestionnaireEntrance r65 = r64.getQuestionnaireEntrance();
    L199:
        l73.c r66 = l73.c.a.a(r65);
        PackResponseDTO r139 = this.a;
        if (r139 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L202:
        PackParsedDTO r67 = r139.getParsedDTO();
        if (r67 == null) goto L207;
        e73.b r68 = r67.getActionStorage();
        if (r68 == null) goto L207;
        Map r411 = r68.a();
    L209:
        return n.a(r46, r9, r6, r7, r15, r21, null, null, null, null, r16, r110, r115, r66, null, r120, r22, r23, r26, r210, null, null, null, r27, r10, r29, r30, r33, r38, r310, r311, r313, r314, r315, r316, r312, r410, null, r411, 7357408, 32);
    L207:
        r411 = null;
        goto L209
    L198:
        r65 = null;
        goto L199
    L191:
        r316 = null;
        goto L192
    L184:
        r315 = null;
        goto L185
    L177:
        r210 = null;
        goto L178
    L170:
        r314 = null;
        goto L171
    L163:
        r313 = null;
    L156:
        r410 = null;
    L147:
        r312 = null;
    L138:
        r311 = null;
    L129:
        r310 = null;
    L120:
        r38 = null;
        goto L121
    L106:
        r138 = null;
        goto L107
    L96:
        r135 = null;
        goto L97
    L89:
        r132 = null;
        goto L90
    L82:
        r128 = null;
        goto L83
    L75:
        r124 = null;
        goto L76
    L68:
        r119 = null;
        goto L69
    L61:
        r114 = null;
        goto L62
    L54:
        r21 = null;
        goto L55
    L47:
        r27 = null;
    L37:
        r29 = r46.z;
        goto L38
    L22:
        r9 = null;
        goto L23
    L15:
        r6 = null;
        goto L16
    L8:
        r7 = null;
        goto L9
    }

    public g(Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r2, PdpSliceLocalCacheHelper r3) {
        Intrinsics.checkNotNullParameter(r2, "voParseCache");
        Intrinsics.checkNotNullParameter(r3, "sliceLocalCacheHelper");
        this.g = r2;
        this.h = r3;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.e
    public final n c(n r48, int r49) {
        Intrinsics.checkNotNullParameter(r48, "data");
        PackResponseDTO r2 = this.a;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L6:
        if (r2.hasMultipleChunks() == false) goto L11;
        PackResponseDTO r3 = this.b;
        if (r3 == null) goto L229;
        return e(r48, r3);
    L229:
        return d(r48);
    L11:
        if (r49 <= 0) goto L215;
        PackResponseDTO r4 = this.a;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L15:
        PromotionLogPbData r5 = r4.getLogPb();
        if (r5 == null) goto L18;
        String r6 = r5.getImprId();
    L19:
        PackResponseDTO r7 = this.a;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L22:
        PackParsedDTO r8 = r7.getParsedDTO();
        if (r8 == null) goto L25;
        Control r9 = r8.getControl();
    L26:
        PackResponseDTO r10 = this.a;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L29:
        PackParsedDTO r11 = r10.getParsedDTO();
        if (r11 == null) goto L32;
        PageMeta r12 = r11.getPageMeta();
    L33:
        PackResponseDTO r13 = this.a;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L36:
        PackParsedDTO r14 = r13.getParsedDTO();
        if (r14 == null) goto L42;
        PageConfig r15 = r14.getPageConfig();
        if (r15 == null) goto L42;
        String r16 = r15.getBackgroundColor();
        if (r16 == null) goto L42;
    L43:
        String r26 = r16;
        a r17 = i;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r18 = this.g;
        PackResponseDTO r19 = this.a;
        if (r19 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L46:
        com.bytedance.android.shopping.anchorv4.vm.a r110 = this.d;
        if (r110 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("collapseInfo");
    L50:
        if (r110.a != true) goto L52;
        boolean r111 = true;
    L53:
        r17.getClass();
        List r20 = a.a(r18, r19, r111);
        PdpSliceLocalCacheHelper r21 = this.h;
        Intrinsics.checkNotNullParameter(r21, "cacheHelper");
        ArrayList r112 = new ArrayList();
        Iterator r22 = ((ArrayList) r20).iterator();
    L55:
        if (r22.hasNext() == false) goto L65;
        com.bytedance.android.ecom.arch.slice.p r113 = (com.bytedance.android.ecom.arch.slice.adapter.b) r22.next();
        if ((r113 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L58;
        if ((r113 instanceof VOIdentifier) == false) goto L55;
        r112.add(r113);
        goto L55
    L58:
        com.bytedance.android.ecom.arch.slice.p r114 = (com.bytedance.android.ecom.arch.slice.g) r113;
        i.getClass();
        if ((r114 instanceof com.bytedance.android.ecom.arch.slice.p) == false) goto L61;
        a.b(r114.a(), r21);
    L61:
        r112.add(r114);
        goto L55
    L65:
        int r115 = y0.a;
        Map<String, SlcElement> r116 = r48.e;
        PackResponseDTO r23 = this.a;
        if (r23 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L68:
        PackParsedDTO r24 = r23.getParsedDTO();
        if (r24 == null) goto L71;
        Map r25 = r24.getTemplates();
    L72:
        Map r117 = y0.e(r116, r25);
        BottomButtonVO.a r27 = BottomButtonVO.Companion;
        PackResponseDTO r118 = this.a;
        if (r118 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L75:
        PackParsedDTO r119 = r118.getParsedDTO();
        if (r119 == null) goto L78;
        ComponentDTO r120 = r119.getBottomButton();
    L79:
        r27.getClass();
        BottomButtonVO r121 = BottomButtonVO.a.a(r120);
        PackResponseDTO r28 = this.a;
        if (r28 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L82:
        PackParsedDTO r29 = r28.getParsedDTO();
        if (r29 == null) goto L89;
        PageMeta r30 = r29.getPageMeta();
        if (r30 == null) goto L89;
        CommonMeta r31 = r30.getCommonMeta();
        if (r31 == null) goto L89;
        JSONObject r210 = h73.a.d(r31);
    L90:
        PackResponseDTO r32 = this.a;
        if (r32 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L93:
        PackParsedDTO r33 = r32.getParsedDTO();
        if (r33 == null) goto L98;
        e73.e r34 = r33.getGlobal();
        if (r34 == null) goto L98;
        List r35 = r34.b();
    L99:
        PackResponseDTO r36 = this.a;
        if (r36 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L102:
        PackParsedDTO r37 = r36.getParsedDTO();
        if (r37 == null) goto L107;
        e73.e r38 = r37.getGlobal();
        if (r38 == null) goto L107;
        Map r39 = r38.d();
    L108:
        PackResponseDTO r40 = this.a;
        if (r40 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L111:
        PackParsedDTO r41 = r40.getParsedDTO();
        if (r41 == null) goto L116;
        e73.e r42 = r41.getGlobal();
        if (r42 == null) goto L116;
        String r310 = r42.a();
    L117:
        PackResponseDTO r43 = this.a;
        if (r43 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L120:
        PackParsedDTO r44 = r43.getParsedDTO();
        if (r44 == null) goto L125;
        e73.e r45 = r44.getGlobal();
        if (r45 == null) goto L125;
        String r311 = r45.c();
    L126:
        PackResponseDTO r46 = this.a;
        if (r46 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L129:
        PackParsedDTO r47 = r46.getParsedDTO();
        if (r47 == null) goto L132;
        BottomNavVO r312 = r47.getBottomNavVO();
    L133:
        PackResponseDTO r50 = this.a;
        if (r50 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L136:
        PackParsedDTO r51 = r50.getParsedDTO();
        if (r51 == null) goto L139;
        TopBannerVO r313 = r51.getTopBannerVO();
    L140:
        PendantContainerVO.Companion r52 = PendantContainerVO.Companion;
        PackResponseDTO r122 = this.a;
        if (r122 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L143:
        PackParsedDTO r123 = r122.getParsedDTO();
        if (r123 == null) goto L146;
        PendantContainer r124 = r123.getPendantContainer();
    L147:
        r52.getClass();
        PendantContainerVO r410 = PendantContainerVO.Companion.c(r124);
        a r53 = i;
        PackResponseDTO r125 = this.a;
        if (r125 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L150:
        PackParsedDTO r126 = r125.getParsedDTO();
        if (r126 == null) goto L153;
        GalleryVO r411 = r126.getGalleryVO();
    L154:
        PdpSliceLocalCacheHelper r127 = this.h;
        r53.getClass();
        Intrinsics.checkNotNullParameter(r127, "cacheHelper");
        if (r411 == null) goto L165;
        GalleryPendants r54 = r411.getPendants();
        if (r54 == null) goto L159;
        List r55 = r54.getSlices();
    L160:
        a.b(r55, r127);
        GalleryBottom r56 = r411.getBottom();
        if (r56 == null) goto L163;
        List r57 = r56.getSlices();
    L164:
        a.b(r57, r127);
        goto L165
    L163:
        r57 = null;
        goto L164
    L159:
        r55 = null;
    L165:
        PackResponseDTO r58 = this.a;
        if (r58 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L168:
        PackParsedDTO r59 = r58.getParsedDTO();
        if (r59 == null) goto L171;
        HeadMoreVideo r412 = r59.getMoreVideo();
    L172:
        PackResponseDTO r60 = this.a;
        if (r60 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L175:
        PackParsedDTO r61 = r60.getParsedDTO();
        if (r61 == null) goto L178;
        AnchorV4HeadV2VO r413 = r61.getHeaderV2();
    L179:
        Map<String, IAction> r62 = r48.M;
        if (r62 != null) goto L182;
    L185:
        boolean r63 = true;
    L186:
        if (r63 == false) goto L196;
        PackResponseDTO r64 = this.a;
        if (r64 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L190:
        PackParsedDTO r65 = r64.getParsedDTO();
        if (r65 == null) goto L195;
        e73.b r66 = r65.getActionStorage();
        if (r66 == null) goto L195;
        Map r414 = r66.a();
    L230:
        return n.a(r48, r12, r9, r6, r112, r117, null, null, null, null, r121, null, null, null, r410, null, null, null, null, r413, null, null, null, null, null, r26, null, null, r210, r35, r39, null, r312, r313, r411, r310, r311, r412, r414, -1913144352, 0);
    L195:
        r414 = null;
        goto L230
    L196:
        LinkedHashMap r67 = new LinkedHashMap();
        r67.putAll(r48.M);
        PackResponseDTO r68 = this.a;
        if (r68 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L199:
        PackParsedDTO r69 = r68.getParsedDTO();
        if (r69 == null) goto L204;
        e73.b r70 = r69.getActionStorage();
        if (r70 == null) goto L204;
        Map r71 = r70.a();
    L205:
        if (r71 != null) goto L207;
    L210:
        boolean r128 = true;
    L211:
        if (r128 == true) goto L213;
        Intrinsics.checkNotNull(r71);
        r67.putAll(r71);
    L213:
        Unit r72 = Unit.INSTANCE;
        r414 = r67;
        goto L230
    L207:
        if (r71.isEmpty() == true) goto L210;
        r128 = false;
    L204:
        r71 = null;
        goto L205
    L182:
        if (r62.isEmpty() == true) goto L185;
        r63 = false;
        goto L186
    L178:
        r413 = null;
        goto L179
    L171:
        r412 = null;
        goto L172
    L153:
        r411 = null;
        goto L154
    L146:
        r124 = null;
        goto L147
    L139:
        r313 = null;
        goto L140
    L132:
        r312 = null;
    L125:
        r311 = null;
    L116:
        r310 = null;
    L107:
        r39 = null;
    L98:
        r35 = null;
    L89:
        r210 = null;
        goto L90
    L78:
        r120 = null;
        goto L79
    L71:
        r25 = null;
        goto L72
    L52:
        r111 = false;
    L42:
        r16 = r48.z;
        goto L43
    L32:
        r12 = null;
        goto L33
    L25:
        r9 = null;
        goto L26
    L18:
        r6 = null;
        goto L19
    L215:
        n r1 = d(r48);
        PackResponseDTO r73 = this.a;
        if (r73 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L219:
        return e(r1, r73);
    }

    public final n e(n r43, PackResponseDTO r44) {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r4 = this.e;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L5:
        Map r12 = null;
        if (r44 == null) goto L12;
        PackParsedDTO r13 = r44.getParsedDTO();
        if (r13 == null) goto L12;
        e73.e r14 = r13.getGlobal();
        if (r14 == null) goto L12;
        String r35 = r14.a();
    L14:
        if (r44 == null) goto L21;
        PackParsedDTO r15 = r44.getParsedDTO();
        if (r15 == null) goto L21;
        e73.e r16 = r15.getGlobal();
        if (r16 == null) goto L21;
        String r17 = r16.c();
        if (r17 == null) goto L21;
    L22:
        String r36 = r17;
        PendantContainerVO.Companion r18 = PendantContainerVO.Companion;
        if (r44 == null) goto L27;
        PackParsedDTO r19 = r44.getParsedDTO();
        if (r19 == null) goto L27;
        PendantContainer r110 = r19.getPendantContainer();
    L28:
        r18.getClass();
        PendantContainerVO r111 = PendantContainerVO.Companion.c(r110);
        if (r44 == null) goto L33;
        PackParsedDTO r112 = r44.getParsedDTO();
        if (r112 == null) goto L33;
        GalleryVO r34 = r112.getGalleryVO();
    L34:
        if (r44 == null) goto L38;
        PackParsedDTO r113 = r44.getParsedDTO();
        if (r113 == null) goto L38;
        HeadMoreVideo r37 = r113.getMoreVideo();
    L39:
        if (r44 == null) goto L48;
        PackParsedDTO r114 = r44.getParsedDTO();
        if (r114 == null) goto L48;
        PageMeta r115 = r114.getPageMeta();
        if (r115 == null) goto L48;
        CommonMeta r116 = r115.getCommonMeta();
        if (r116 == null) goto L48;
        JSONObject r117 = h73.a.d(r116);
        if (r117 == null) goto L48;
    L49:
        JSONObject r38 = r117;
        if (r43.M != null) goto L58;
        if (r44 == null) goto L69;
        PackParsedDTO r118 = r44.getParsedDTO();
        if (r118 == null) goto L69;
        e73.b r119 = r118.getActionStorage();
        if (r119 == null) goto L69;
        r12 = r119.a();
    L69:
        return n.a(r43, null, null, null, r4, null, null, null, null, null, null, null, null, null, r111, null, null, null, null, null, null, null, null, null, null, null, null, null, r38, null, null, null, null, null, r34, r35, r36, r37, r12, -268451849, 3);
    L58:
        r12 = new LinkedHashMap();
        r12.putAll(r43.M);
        if (r44 == null) goto L67;
        PackParsedDTO r120 = r44.getParsedDTO();
        if (r120 == null) goto L67;
        e73.b r121 = r120.getActionStorage();
        if (r121 == null) goto L67;
        Map r122 = r121.a();
        if (r122 == null) goto L67;
        r12.putAll(r122);
    L67:
        Unit r123 = Unit.INSTANCE;
    L48:
        r117 = r43.C;
    L38:
        r37 = null;
    L33:
        r34 = null;
    L27:
        r110 = null;
    L21:
        r17 = r43.K;
    L12:
        r35 = null;
        goto L14
    }
}
