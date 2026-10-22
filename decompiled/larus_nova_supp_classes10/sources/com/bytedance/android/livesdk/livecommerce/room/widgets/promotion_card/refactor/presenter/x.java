package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.RemoteGroupHeadImageView;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.InfoSubTitleView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.drawee.generic.RoundingParams;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x extends p {
    public static final /* synthetic */ int j = 0;
    public z g;
    public String h;
    public final boolean i;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ x a;

        public b(x r1) {
            this.a = r1;
        }

        public final void onChanged(Object r28) {
            ECUIPromotion r1 = (ECUIPromotion) r28;
            if (r1 != null) goto L5;
        L245:
            x r0 = this.a;
            r0.h = null;
            z r3 = r0.g;
            if (r3 == null) goto L248;
            r3.a();
        L248:
            r0.g = null;
            return;
        L5:
            if (r1.isAuction() == true) goto L245;
            x r4 = this.a;
            ExplainCardViewModel r5 = r4.e;
            if (r5 == null) goto L9;
            com.bytedance.android.livesdk.livecommerce.largemode.b r6 = r5.getLargeModeAdapter();
        L10:
            r4.w().g(0);
            Query r7 = r4.w().b(2131391199);
            Query r15 = r4.w().b(2131391197);
            r15.g(8);
            ((InfoSubTitleView) r15.f()).setShowDeleteLine(false);
            int r8 = th.a.a(r4.u().c(), 2131101581);
            View r9 = r15.b;
            if ((r9 instanceof TextView) == false) goto L13;
            ((TextView) r9).setTextColor(r8);
        L13:
            Query r13 = r4.w().b(2131377604);
            Query r10 = r4.w().b(2131377606);
            Query r11 = r4.w().b(2131377607);
            if (r6 == null) goto L19;
            ComponentLargeModeConfig r12 = r6.b("ExplainCard", "ExplainCard.SellPoint");
            if (r12 == null) goto L19;
            int r16 = LargeModeConfigHelper.a;
            LargeModeConfigHelper.a(r12, r10.b(2131391319).f());
        L19:
            if (r6 == null) goto L23;
            ComponentLargeModeConfig r14 = r6.b("ExplainCard", "ExplainCard.SellPoint");
            if (r14 == null) goto L23;
            int r17 = LargeModeConfigHelper.a;
            LargeModeConfigHelper.a(r14, r10.b(2131391320).f());
        L23:
            if (r6 == null) goto L27;
            ComponentLargeModeConfig r2 = r6.b("ExplainCard", "ExplainCard.SellPoint");
            if (r2 == null) goto L27;
            int r18 = LargeModeConfigHelper.a;
            LargeModeConfigHelper.a(r2, r11.b(2131391319).f());
        L27:
            if (r6 == null) goto L31;
            ComponentLargeModeConfig r19 = r6.b("ExplainCard", "ExplainCard.SellPoint");
            if (r19 == null) goto L31;
            int r20 = LargeModeConfigHelper.a;
            LargeModeConfigHelper.a(r19, r11.b(2131391320).f());
        L31:
            TextView r21 = (TextView) r7.f();
            String r110 = r1.title;
            Map r22 = r1.getRitTag();
            if (r22 == null) goto L46;
            List r23 = (List) r22.get("live_info_under_title");
            if (r23 == null) goto L46;
            ECRitTag r24 = (ECRitTag) CollectionsKt.firstOrNull(r23);
            if (r24 == null) goto L46;
            String r25 = r24.getFirstText();
            if (r25 == null) goto L46;
            if ((!StringsKt.isBlank(r25)) == true) goto L43;
            r25 = null;
        L43:
            if (r25 == null) goto L46;
            r15.g(0);
            r15.e(r25);
        L46:
            if (r15.d() == true) goto L57;
            String r26 = r1.flashIcon;
            if (r26 == null) goto L57;
            if (r26.length() <= 0) goto L52;
            boolean r27 = true;
        L53:
            if (r27 != true) goto L57;
            String r29 = "ExplainCard";
            if (r1.stockNum <= 0) goto L58;
            r15.g(0);
            String r210 = r110;
            r15.e(th.a.h(r4.u().c(), 2131896838, new Object[]{Long.valueOf(r1.stockNum)}));
        L108:
            Query r111 = r15;
        L109:
            if (r6 == null) goto L113;
            ComponentLargeModeConfig r30 = r6.b(r29, "ExplainCard.Title");
            if (r30 == null) goto L113;
            int r31 = LargeModeConfigHelper.a;
            LargeModeConfigHelper.a(r30, r7.f());
        L113:
            Map r32 = r1.getRitTag();
            if (r32 == null) goto L137;
            List r33 = (List) r32.get("live_room_product_title_before");
            if (r33 == null) goto L137;
            ECRitTag r34 = (ECRitTag) CollectionsKt.firstOrNull(r33);
            if (r34 == null) goto L137;
            ECUrlModel r35 = r34.getTextIcon();
            if (r35 == null) goto L137;
            r7.g(0);
            if (r4.i == false) goto L124;
            String r112 = r210;
            r21.setText(r112);
        L127:
            r1.isShowPopCardProductTag = true;
            Map r36 = r1.getRitTag();
            if (r36 == null) goto L136;
            List r37 = (List) r36.get("live_room_product_title_before");
            if (r37 == null) goto L136;
            ECRitTag r38 = (ECRitTag) CollectionsKt.firstOrNull(r37);
            if (r38 == null) goto L136;
            RitTagTrack r39 = r38.getTagTrack();
            if (r39 == null) goto L136;
            r39.setVisibile(true);
        L136:
            boolean r113 = true;
        L139:
            if (r1.reservationInfo == null) goto L142;
            r111.g(0);
            ((InfoSubTitleView) r111.f()).setText(r1.priceHeader + ' ' + th.a.g(r4.u().c(), 2131896680) + com.bytedance.android.livesdk.livecommerce.utils.k.g(r1.reserveMinPrice));
        L142:
            if (r4.i == false) goto L144;
            r111.c();
        L144:
            Map r40 = r1.getRitTag();
            if (r40 == null) goto L151;
            List r41 = (List) r40.get("live_room_pop_biz_under");
            if (r41 == null) goto L151;
            if ((!r41.isEmpty()) == false) goto L151;
        L153:
            if (r111.d() == true) goto L187;
            if (r41 == null) goto L187;
            if (r4.i == true) goto L187;
            r111.c();
            r13.g(0);
            if (r4.g != null) goto L160;
        L163:
            long r114 = r1.carouselTime;
            ArrayList r42 = new ArrayList();
            Iterator<T> r43 = r41.iterator();
            Integer r44 = null;
        L165:
            if (r43.hasNext() == false) goto L179;
            ECRitTag r45 = (ECRitTag) r43.next();
            Iterator<T> r115 = r43;
            int r46 = r45.getType();
            String r211 = r112;
            if (r44 != null) goto L170;
        L171:
            r42.add(CollectionsKt.mutableListOf(new ECRitTag[]{r45}));
            r44 = Integer.valueOf(r45.getType());
        L172:
            r43 = r115;
            r112 = r211;
            goto L165
        L170:
            if (r46 != r44.intValue()) goto L171;
            Object r47 = CollectionsKt.lastOrNull(r42);
            if (TypeIntrinsics.isMutableList(r47) == true) goto L176;
            r47 = null;
        L176:
            List r48 = (List) r47;
            if (r48 == null) goto L172;
            r48.add(r45);
            goto L172
        L179:
            String r212 = r112;
            r10.g(0);
            r11.c();
            if (r42.size() > 1) goto L182;
        L184:
            ECUIPromotion r116 = r1;
            Query r117 = r13;
            Query r213 = r111;
            String r49 = r212;
            int r118 = 8;
            if (r42.size() <= 0) goto L191;
            r4.E(r10, (List) ListProtector.get(r42, 0));
        L191:
            if (r49 != null) goto L193;
        L196:
            boolean r119 = true;
        L197:
            if (r119 == false) goto L199;
            r21.setVisibility(r118);
        L210:
            if (r117.d() == false) goto L212;
            ECUIPromotion r50 = r116;
            boolean r51 = true;
            r50.isShowPopCardRightSimulateTag = true;
        L214:
            if (r21.getVisibility() != r118) goto L216;
            boolean r120 = true;
        L218:
            if (r120 == true) goto L220;
        L234:
            View r52 = r4.w().f();
            ViewGroup.LayoutParams r53 = r52.getLayoutParams();
            if (r53 == null) goto L240;
            if (r120 == true) goto L238;
            int r54 = UtilityKotlinExtentionsKt.d(36);
        L239:
            r53.height = r54;
            Unit r55 = Unit.INSTANCE;
        L241:
            r52.setLayoutParams(r53);
            if (r120 == false) goto L244;
            r52.setPadding(0, UtilityKotlinExtentionsKt.d(4), 0, UtilityKotlinExtentionsKt.d(4));
        L244:
            this.a.h = r50.getPromotionId();
            return;
        L238:
            r54 = -2;
            goto L239
        L240:
            r53 = null;
            goto L241
        L220:
            if (r213.f().getVisibility() != r118) goto L222;
            boolean r56 = true;
        L223:
            if (r56 == false) goto L234;
            if (r117.f().getVisibility() == r118) goto L228;
            r51 = false;
        L228:
            if (r51 == false) goto L234;
            View r57 = r4.w().f();
            ViewGroup.LayoutParams r58 = r57.getLayoutParams();
            if (r58 == null) goto L232;
            r58.height = UtilityKotlinExtentionsKt.d(4);
            Unit r59 = Unit.INSTANCE;
            ViewGroup.LayoutParams r60 = r58;
        L233:
            r57.setLayoutParams(r60);
            goto L244
        L232:
            r60 = null;
            goto L233
        L222:
            r56 = false;
            goto L223
        L216:
            r120 = false;
            goto L218
        L212:
            r50 = r116;
            r51 = true;
            goto L214
        L199:
            if (r113 == true) goto L202;
            r21.setLineSpacing(0.0f, 1.15f);
            r21.setText(r49);
        L202:
            if (r117.d() == false) goto L204;
        L207:
            int r121 = 1;
        L208:
            r21.setMaxLines(r121);
            goto L210
        L204:
            if (r213.d() == true) goto L207;
            r121 = 2;
            goto L208
        L193:
            if (r49.length() == 0) goto L196;
            r119 = false;
            goto L197
        L182:
            if (r114 <= 0) goto L184;
            r116 = r1;
            r117 = r13;
            r213 = r111;
            r49 = r212;
            r118 = 8;
            z r61 = new z(r4, r10, r11, r42, r42, r114, r114);
            r4.g = r61;
            r61.j();
            goto L191
        L160:
            if ((!Intrinsics.areEqual(r4.h, r1.getPromotionId())) == true) goto L163;
            r116 = r1;
            r49 = r112;
            r117 = r13;
            r213 = r111;
            r118 = 8;
        L187:
            r116 = r1;
            r49 = r112;
            r117 = r13;
            r213 = r111;
            r118 = 8;
            r117.c();
            z r62 = r4.g;
            if (r62 == null) goto L190;
            r62.a();
        L190:
            r4.g = null;
        L151:
            r41 = null;
            goto L153
        L124:
            r112 = r210;
            Disposable r63 = mh2.q.b(CollectionsKt.listOf(r35), r112, r35.getHeight(), r21, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.o, 64);
            if (r63 == null) goto L127;
            bk2.c.a(r63, r4);
        L137:
            r112 = r210;
            r113 = false;
        L58:
            r210 = r110;
            if (r15.d() == true) goto L108;
            ECUICampaign r64 = r1.campaign;
            if (r64 == null) goto L108;
            if (r64.isGroup().booleanValue() == false) goto L72;
            if (r1.isPriceDeduce() == true) goto L72;
            r15.g(0);
            if (r64.groupData.getJoined() >= 30) goto L69;
            String r65 = th.a.h(r4.u().c(), 2131896622, new Object[]{Integer.valueOf(r64.groupData.getGroupSize())});
        L70:
            r15.e(r65);
            goto L108
        L69:
            r65 = th.a.h(r4.u().c(), 2131896623, new Object[]{Integer.valueOf(r64.groupData.getGroupSize())});
        L72:
            if (r64.isSecKill().booleanValue() == false) goto L89;
            boolean r122 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a;
            if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a(r64.startTime, r64.endTime) == false) goto L88;
            String r66 = r64.marketPrice;
            if (r66 != null) goto L78;
            r66 = r1.marketPrice;
        L78:
            if (r66 == null) goto L80;
            float r123 = CastFloatProtector.parseFloat(r66);
        L82:
            if (r123 <= 0) goto L84;
            String r124 = th.a.g(r4.u().c(), 2131896680) + r66;
        L85:
            r111 = r15;
            if (r124 == null) goto L109;
            r111.g(0);
            InfoSubTitleView r125 = (InfoSubTitleView) r111.f();
            r125.setTextColor(th.a.a(r4.u().c(), 2131101621));
            r125.setText(r124);
            r125.setShowDeleteLine(true);
            r1.setRealPrice(r66);
            goto L109
        L84:
            r124 = null;
            goto L85
        L80:
            r123 = 0.0f;
            goto L82
        L88:
            r111 = r15;
        L91:
            if (r64.isPreSale().booleanValue() == false) goto L109;
            r111.g(0);
            InfoSubTitleView r126 = (InfoSubTitleView) r111.f();
            ECPreSaleData r127 = r64.preSaleData;
            if (r127 == null) goto L106;
            String r128 = r127.getDiscountDesc();
            if (r128 == null) goto L106;
            if (r128.length() <= 0) goto L99;
            boolean r129 = true;
        L101:
            if (r129 != true) goto L106;
            ECPreSaleData r67 = r64.preSaleData;
            if (r67 == null) goto L105;
            String r68 = r67.getDiscountDesc();
        L107:
            r126.setText(r68);
            goto L109
        L105:
            r68 = null;
            goto L107
        L99:
            r129 = false;
        L106:
            r68 = th.a.g(r4.u().c(), 2131896678) + ' ' + th.a.g(r4.u().c(), 2131896680) + r1.price;
            goto L107
        L89:
            r111 = r15;
            goto L91
        L52:
            r27 = false;
        L57:
            r29 = "ExplainCard";
            goto L58
        L9:
            r6 = null;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void C() {
        clearDisposable();
        z r0 = this.g;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.g = null;
    }

    public x(boolean r1) {
        this.i = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r3) {
        Intrinsics.checkNotNullParameter(r3, "model");
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L8;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 == null) goto L9;
        r1.b(r3.getLifecycleOwner(), new b(this));
        return;
    L9:
        return;
    }

    public final void E(Query r20, List<ECRitTag> r21) {
        Query r1 = r20.b(2131392582);
        r1.g(8);
        Query r3 = r20.b(2131391319);
        r3.g(8);
        Query r4 = r20.b(2131391320);
        r4.g(8);
        Query r0 = r20.b(2131377605);
        r0.g(8);
        if (r21.size() != 1) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        List<ECRitTag> r5 = r21;
    L9:
        if (r5 == null) goto L13;
        ECRitTag r6 = (ECRitTag) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L13;
        ECUrlModel r7 = r6.getTextIcon();
    L14:
        ECRitTag r8 = (ECRitTag) CollectionsKt.firstOrNull(r21);
        if (r8 == null) goto L19;
        List r9 = r8.getText();
        if (r9 == null) goto L19;
        String r10 = (String) CollectionsKt.firstOrNull(r9);
    L20:
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        int r11 = com.bytedance.android.ec.core.utils.s.a;
        ECRitTag r12 = (ECRitTag) CollectionsKt.firstOrNull(r21);
        if (r12 == null) goto L27;
        ECUIConfig r13 = r12.getUiConfig();
        if (r13 == null) goto L27;
        String r14 = r13.getTextColor();
    L28:
        Integer r15 = com.bytedance.android.ec.core.utils.s.b(r14);
        if (r21.size() <= 1) goto L31;
        boolean r16 = true;
    L32:
        if (r16 == false) goto L34;
        List<ECRitTag> r17 = r21;
    L35:
        if (r17 == null) goto L41;
        ECRitTag r18 = (ECRitTag) ListProtector.get(r17, 1);
        if (r18 == null) goto L41;
        List r19 = r18.getText();
        if (r19 == null) goto L41;
        String r110 = (String) CollectionsKt.firstOrNull(r19);
    L43:
        if (r21.size() <= 1) goto L45;
        boolean r111 = true;
    L46:
        if (r111 == false) goto L48;
        List<ECRitTag> r112 = r21;
    L49:
        if (r112 == null) goto L55;
        ECRitTag r113 = (ECRitTag) ListProtector.get(r112, 1);
        if (r113 == null) goto L55;
        ECUIConfig r114 = r113.getUiConfig();
        if (r114 == null) goto L55;
        String r115 = r114.getTextColor();
    L56:
        Integer r116 = com.bytedance.android.ec.core.utils.s.b(r115);
        ECRitTag r117 = (ECRitTag) CollectionsKt.firstOrNull(r21);
        if (r21.size() <= 1) goto L59;
        boolean r118 = true;
    L60:
        if (r118 == false) goto L62;
        List<ECRitTag> r119 = r21;
    L63:
        if (r119 == null) goto L65;
        ECRitTag r120 = (ECRitTag) ListProtector.get(r119, 1);
    L66:
        if (r7 == null) goto L106;
        List r121 = r7.getUrlList();
        if (r121 == null) goto L106;
        if ((!r121.isEmpty()) != true) goto L106;
        Integer r122 = Integer.valueOf(r7.getWidth());
        if (r122.intValue() <= 0) goto L74;
        boolean r123 = true;
    L75:
        if (r123 == true) goto L79;
        r122 = null;
    L79:
        if (r122 != null) goto L82;
        r122 = 12;
    L82:
        int r124 = UtilityKotlinExtentionsKt.d(r122);
        Integer r125 = Integer.valueOf(r7.getWidth());
        if (r125.intValue() <= 0) goto L85;
        boolean r126 = true;
    L86:
        if (r126 == true) goto L89;
        r125 = null;
    L89:
        if (r125 == null) goto L91;
        int r127 = UtilityKotlinExtentionsKt.d(r125);
    L92:
        r0.g(0);
        ViewGroup r22 = (ViewGroup) r0.f();
        r22.removeAllViewsInLayout();
        List r23 = r7.getUrlList();
        if (r23 == null) goto L106;
        Iterator r24 = r23.iterator();
    L96:
        if (r24.hasNext() == false) goto L106;
        String r25 = (String) r24.next();
        if (r22.getChildCount() < 2) goto L100;
        r24 = r24;
    L105:
        r24 = r24;
        goto L96
    L100:
        if (r22.getChildCount() != 0) goto L102;
        ECNetImageView r26 = new ECNetImageView(u().c());
        r26.setLayoutParams(new LinearLayout.LayoutParams(r124, r127));
        r26.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r26.setImageURI(r25);
        Unit r27 = Unit.INSTANCE;
    L103:
        r22.addView(r26);
        goto L105
    L102:
        r26 = new RemoteGroupHeadImageView(u().c());
        LinearLayout.LayoutParams r28 = new LinearLayout.LayoutParams(r124, r127);
        r28.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(-2.5f));
        Unit r29 = Unit.INSTANCE;
        r26.setLayoutParams(r28);
        r26.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r26.setImageURI(r25);
        r26.setTopOffsetPercent(0.16666667f);
        r26.setRightOffsetPercent(0.375f);
        goto L103
    L91:
        r127 = UtilityKotlinExtentionsKt.d(12);
        goto L92
    L85:
        r126 = false;
        goto L86
    L74:
        r123 = false;
    L106:
        if (r117 == null) goto L110;
        RitTagTrack r30 = r117.getTagTrack();
        if (r30 == null) goto L110;
        r30.setVisibile(true);
    L110:
        r3.g(0);
        r3.e(r10);
        if (r15 == null) goto L115;
        r15.intValue();
        int r31 = r15.intValue();
        View r32 = r3.b;
        if ((r32 instanceof TextView) == false) goto L115;
        ((TextView) r32).setTextColor(r31);
    L115:
        if (r110 == null) goto L148;
        r1.g(0);
        int r33 = com.bytedance.android.ec.core.utils.s.a;
        if (r21.size() <= 1) goto L119;
        boolean r128 = true;
    L120:
        if (r128 == false) goto L122;
        List<ECRitTag> r34 = r21;
    L123:
        if (r34 == null) goto L129;
        ECRitTag r35 = (ECRitTag) ListProtector.get(r34, 1);
        if (r35 == null) goto L129;
        ECUIConfig r36 = r35.getUiConfig();
        if (r36 == null) goto L129;
        String r37 = r36.getTextSplitorColor();
    L130:
        Integer r38 = com.bytedance.android.ec.core.utils.s.b(r37);
        if (r38 == null) goto L135;
        r38.intValue();
        int r39 = r38.intValue();
        View r40 = r1.b;
        if (r40 == null) goto L135;
        r40.setBackgroundColor(r39);
    L135:
        r4.g(0);
        r4.e(r110);
        if (r116 == null) goto L140;
        r116.intValue();
        int r41 = r116.intValue();
        View r42 = r4.b;
        if ((r42 instanceof TextView) == false) goto L140;
        ((TextView) r42).setTextColor(r41);
    L140:
        if (r120 == null) goto L149;
        RitTagTrack r43 = r120.getTagTrack();
        if (r43 == null) goto L150;
        r43.setVisibile(true);
        return;
    L150:
        return;
    L149:
        return;
    L129:
        r37 = null;
        goto L130
    L122:
        r34 = null;
        goto L123
    L119:
        r128 = false;
        goto L120
    L148:
        return;
    L65:
        r120 = null;
        goto L66
    L62:
        r119 = null;
        goto L63
    L59:
        r118 = false;
    L55:
        r115 = null;
        goto L56
    L48:
        r112 = null;
        goto L49
    L45:
        r111 = false;
    L41:
        r110 = null;
        goto L43
    L34:
        r17 = null;
        goto L35
    L31:
        r16 = false;
    L27:
        r14 = null;
    L19:
        r10 = null;
    L13:
        r7 = null;
        goto L14
    L8:
        r5 = null;
        goto L9
    L5:
        r2 = false;
        goto L6
    }
}
