package com.bytedance.android.shopping.feed.resourcecard.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.adapter.ProductFeedAdapter;
import com.bytedance.android.shopping.feed.event.s0;
import com.bytedance.android.shopping.feed.event.y1;
import com.bytedance.android.shopping.feed.resourcecard.frequency.MallDivertShowJudge;
import com.bytedance.android.shopping.feed.resourcecard.frequency.ResourceCardFreqController;
import com.bytedance.android.shopping.feed.resourcecard.view.ResourceCardView;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.common.utility.Logger;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import rd3.g;
import rd3.o;
import yd3.b;
import yd3.d;
import yd3.f;
import yd3.m;
import yd3.p;
import yd3.t;
import yd3.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/viewholder/ResourceCardVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lcom/bytedance/android/shopping/feed/adapter/ProductFeedAdapter$b;", "Lrd3/a;", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResourceCardVH extends JediSimpleViewHolder<ProductFeedAdapter.b<rd3.a>> {
    public final Lazy l;
    public final List<rd3.a> m;
    public rd3.a n;
    public final Rect o;
    public final a p;
    public final ProductFeedAdapter q;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ResourceCardVH a;

        public a(ResourceCardVH r1) {
            this.a = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            MallDivertShowJudge.h.getClass();
            if (MallDivertShowJudge.a.a().a() == true) goto L5;
            return;
        L5:
            ResourceCardVH r0 = this.a;
            ((RecyclerView.ViewHolder) r0).itemView.getLocalVisibleRect(r0.o);
            Logger.d("zwb-inflow", "h:" + this.a.o.height() + ", w:" + this.a.o.width());
            if (this.a.o.height() <= (((RecyclerView.ViewHolder) this.a).itemView.getMeasuredHeight() / 2)) goto L15;
            MallDivertShowJudge r1 = MallDivertShowJudge.a.a();
            if (r1.a == 2) goto L11;
            return;
        L11:
            if (r1.a() == false) goto L17;
            r1.d = r1.e;
            long r2 = System.currentTimeMillis();
            r1.c = r2;
            sk.a.a.getClass();
            q.a.e("ec_last_hit_mall_time", r2);
            return;
        L17:
            return;
        }
    }

    public final ProductFeedViewModel c4() {
        return (ProductFeedViewModel) this.l.getValue();
    }

    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        rd3.a r1 = this.n;
        if (r1 == null) goto L16;
        p r2 = r1.i();
        if (r2 == null) goto L16;
        if (r2.getType() != 7) goto L16;
        MallDivertShowJudge.h.getClass();
        if (MallDivertShowJudge.a.a().a() == true) goto L11;
    L29:
        rd3.a r3 = this.n;
        if (r3 == null) goto L36;
        p r4 = r3.i();
        if (r4 == null) goto L36;
        if (r4.getType() != 9) goto L36;
        c4().updateFloatMallVisibility(false);
    L36:
        rd3.a r5 = this.n;
        if (r5 != null) goto L39;
        return;
    L39:
        if (((ArrayList) this.m).contains(r5) == true) goto L418;
        rd3.a r6 = this.n;
        if (r6 == null) goto L46;
        p r7 = r6.i();
        if (r7 == null) goto L46;
        if (r7.getType() != 6) goto L46;
    L58:
        rd3.a r8 = this.n;
        if (r8 == null) goto L104;
        p r9 = r8.i();
        if (r9 == null) goto L104;
        m r12 = r9.l();
        if (r12 == null) goto L66;
        List<Promotion> r13 = r12.h();
        if (r13 == null) goto L66;
    L70:
        if (r13 == null) goto L81;
        List<Promotion> r14 = r13;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r15 = r14.iterator();
    L73:
        if (r15.hasNext() == false) goto L82;
        PromotionProductStruct r16 = ((Promotion) r15.next()).getPromotionInfo();
        if (r16 == null) goto L79;
        PromotionProductBaseStruct r17 = r16.getBaseInfo();
        if (r17 == null) goto L79;
        String r18 = r17.getProductId();
    L80:
        r10.add(r18);
    L79:
        r18 = null;
    L82:
        StringBuilder r19 = new StringBuilder("{0:");
        if (r10 == null) goto L85;
        String r11 = (String) CollectionsKt.getOrNull(r10, 0);
    L86:
        r19.append(r11);
        r19.append(",1:");
        if (r10 == null) goto L89;
        String r20 = (String) CollectionsKt.getOrNull(r10, 1);
    L90:
        r19.append(r20);
        r19.append(",2:");
        if (r10 == null) goto L93;
        String r21 = (String) CollectionsKt.getOrNull(r10, 2);
    L94:
        r19.append(r21);
        r19.append('}');
        String r22 = r19.toString();
    L105:
        String r23 = r22;
    L107:
        BtmSDK r24 = BtmSDK.INSTANCE;
        BtmItemBuilder r25 = new BtmItemBuilder("a1.b7365.c87897.d66964", Boolean.FALSE);
        View r26 = ((RecyclerView.ViewHolder) this).itemView;
        if (r26 == null) goto L413;
        String r27 = r24.createBtmId(r25.withView((ResourceCardView) r26).build());
        rd3.a r28 = this.n;
        if (r28 == null) goto L115;
        p r29 = r28.i();
        if (r29 == null) goto L115;
        if (r29.getType() != 7) goto L115;
    L121:
        String r210 = "";
    L123:
        rd3.a r30 = this.n;
        if (r30 == null) goto L128;
        p r31 = r30.i();
        if (r31 == null) goto L128;
        b r32 = r31.d();
    L129:
        AnchorV3Param r110 = c4().m907getAnchorV3Param();
        if (r110 == null) goto L137;
        ECLogExtraData r111 = r110.getLogExtraData();
        if (r111 == null) goto L137;
        String r112 = r111.getEnterFrom();
        if (r112 == null) goto L137;
        String r113 = r112;
    L138:
        rd3.a r114 = this.n;
        if (r114 == null) goto L143;
        p r115 = r114.i();
        if (r115 == null) goto L143;
        Integer r116 = Integer.valueOf(r115.getType());
    L144:
        if (r116 != null) goto L147;
    L149:
        if (r116 != null) goto L152;
    L154:
        if (r116 != null) goto L157;
    L159:
        if (r116 != null) goto L162;
    L164:
        rd3.a r33 = this.n;
        if (r33 == null) goto L168;
        String r34 = r33.c();
    L167:
        String r117 = r34;
    L169:
        rd3.a r35 = this.n;
        if (r35 == null) goto L185;
        p r36 = r35.i();
        if (r36 == null) goto L185;
        if (r36.getType() != 9) goto L185;
        rd3.a r37 = this.n;
        if (r37 == null) goto L180;
        p r38 = r37.i();
        if (r38 == null) goto L180;
        m r39 = r38.l();
    L181:
        if (r39 == null) goto L183;
        String r40 = "is_product";
    L184:
        String r211 = r40;
    L186:
        rd3.a r41 = this.n;
        if (r41 == null) goto L192;
        String r42 = String.valueOf(r41.f);
        if (r42 == null) goto L192;
        String r118 = r42;
    L193:
        rd3.a r43 = this.n;
        if (r43 == null) goto L201;
        g r44 = r43.d();
        if (r44 == null) goto L201;
        String r45 = r44.a();
        if (r45 == null) goto L201;
        String r119 = r45;
    L202:
        rd3.a r46 = this.n;
        if (r46 == null) goto L205;
        String r120 = r46.d;
    L206:
        AnchorV3Param r47 = c4().m907getAnchorV3Param();
        if (r47 == null) goto L211;
        ECLogExtraData r48 = r47.getLogExtraData();
        if (r48 == null) goto L211;
        String r121 = r48.getEnterFrom();
    L212:
        rd3.a r49 = this.n;
        if (r49 == null) goto L219;
        ProductFeedViewModel r50 = r49.c;
        if (r50 == null) goto L219;
        AnchorV3Param r51 = r50.m907getAnchorV3Param();
        if (r51 == null) goto L219;
        String r212 = r51.getVideoId();
    L220:
        AnchorV3Param r52 = c4().m907getAnchorV3Param();
        if (r52 == null) goto L225;
        ECLogExtraData r53 = r52.getLogExtraData();
        if (r53 == null) goto L225;
        String r213 = r53.getEnterFrom();
    L226:
        rd3.a r54 = this.n;
        if (r54 == null) goto L233;
        p r55 = r54.i();
        if (r55 == null) goto L233;
        b r56 = r55.d();
        if (r56 == null) goto L233;
        Integer r57 = Integer.valueOf(r56.b());
    L235:
        if (r57 != null) goto L238;
    L240:
        if (r57 != null) goto L243;
    L245:
        if (r57 != null) goto L248;
    L250:
        if (r57 != null) goto L253;
    L255:
        String r214 = "";
    L256:
        if (r32 == null) goto L261;
        String r58 = r32.e();
        if (r58 == null) goto L261;
        String r215 = r58;
    L263:
        if (r32 == null) goto L267;
        Long r59 = r32.i();
        if (r59 == null) goto L267;
        String r216 = String.valueOf(r59.longValue() / 100.0f);
    L268:
        if (r32 == null) goto L273;
        String r60 = r32.d();
        if (r60 == null) goto L273;
        String r310 = r60;
    L274:
        rd3.a r61 = this.n;
        if (r61 == null) goto L290;
        p r62 = r61.i();
        if (r62 == null) goto L290;
        if (r62.getType() != 9) goto L290;
        rd3.a r63 = this.n;
        if (r63 == null) goto L289;
        p r64 = r63.i();
        if (r64 == null) goto L289;
        f r65 = r64.h();
        if (r65 == null) goto L289;
        t r66 = r65.d();
        if (r66 == null) goto L289;
        String r122 = r66.c();
    L291:
        String r217 = r122;
    L292:
        rd3.a r67 = this.n;
        if (r67 == null) goto L311;
        p r68 = r67.i();
        if (r68 == null) goto L311;
        if (r68.getType() != 9) goto L311;
        rd3.a r69 = this.n;
        if (r69 == null) goto L307;
        p r70 = r69.i();
        if (r70 == null) goto L307;
        f r71 = r70.h();
        if (r71 == null) goto L307;
        t r72 = r71.d();
        if (r72 == null) goto L307;
        String r73 = r72.c();
    L309:
        if (com.bytedance.android.shopping.anchorv3.a.b(r73) == false) goto L311;
        String r218 = "1";
    L312:
        rd3.a r74 = this.n;
        if (r74 == null) goto L325;
        p r75 = r74.i();
        if (r75 == null) goto L325;
        if (r75.getType() != 20) goto L325;
        rd3.a r76 = this.n;
        if (r76 == null) goto L325;
        p r77 = r76.i();
        if (r77 == null) goto L325;
        p.b r78 = r77.g();
        if (r78 == null) goto L325;
        String r311 = r78.c();
    L326:
        rd3.a r79 = this.n;
        if (r79 == null) goto L339;
        p r80 = r79.i();
        if (r80 == null) goto L339;
        if (r80.getType() != 20) goto L339;
        rd3.a r81 = this.n;
        if (r81 == null) goto L339;
        p r82 = r81.i();
        if (r82 == null) goto L339;
        p.b r84 = r82.g();
        if (r84 == null) goto L339;
        String r312 = r84.a();
    L340:
        y1 r85 = new y1(r113, r117, r118, r119, r120, "product_flow_page", r121, r212, r210, r213, r23, r211, r214, r215, r216, r218, r217, r310, r311, r312);
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r85.appendParam("btm_id", r27, com.bytedance.android.ec.core.event.a.b.a.a);
        rd3.a r86 = this.n;
        if (r86 == null) goto L382;
        p r87 = r86.i();
        if (r87 == null) goto L382;
        if (r87.getType() != 6) goto L382;
        rd3.a r88 = this.n;
        if (r88 == null) goto L351;
        p r89 = r88.i();
        if (r89 == null) goto L351;
        b r90 = r89.d();
    L352:
        if (r90 == null) goto L382;
        rd3.a r91 = this.n;
        if (r91 == null) goto L362;
        p r92 = r91.i();
        if (r92 == null) goto L362;
        b r94 = r92.d();
        if (r94 == null) goto L362;
        if (r94.b() != 4) goto L362;
        String r95 = "0";
    L363:
        r85.appendParam("inflow_coupon_type", r95);
        rd3.a r96 = this.n;
        if (r96 == null) goto L372;
        p r97 = r96.i();
        if (r97 == null) goto L372;
        b r98 = r97.d();
        if (r98 == null) goto L372;
        Long r99 = r98.i();
        if (r99 == null) goto L372;
        Float r100 = Float.valueOf(r99.longValue() / 100.0f);
    L373:
        r85.appendParam("coupon_value", String.valueOf(r100));
        rd3.a r101 = this.n;
        if (r101 == null) goto L380;
        p r102 = r101.i();
        if (r102 == null) goto L380;
        b r103 = r102.d();
        if (r103 == null) goto L380;
        String r104 = r103.e();
    L381:
        r85.appendParam("coupon_id", r104);
    L380:
        r104 = null;
    L372:
        r100 = null;
    L362:
        r95 = "1";
    L351:
        r90 = null;
    L382:
        r85.post(null, null);
        rd3.a r105 = this.n;
        if (r105 == null) goto L387;
        p r106 = r105.i();
        if (r106 == null) goto L387;
        Integer r107 = Integer.valueOf(r106.getType());
    L388:
        if (r107 != null) goto L391;
    L409:
        rd3.a r108 = this.n;
        if (r108 == null) goto L419;
        ((ArrayList) this.m).add(r108);
        return;
    L419:
        return;
    L391:
        if (r107.intValue() != 2) goto L409;
        pe3.a r109 = new pe3.a();
        r109.a = "product_flow_page";
        rd3.a r123 = this.n;
        if (r123 == null) goto L397;
        o r124 = r123.g();
        if (r124 == null) goto L397;
        String r125 = r124.a();
    L398:
        r109.k = r125;
        rd3.a r126 = this.n;
        if (r126 == null) goto L403;
        Promotion r127 = r126.f();
        if (r127 == null) goto L403;
        String r128 = r127.getId();
    L404:
        r109.l = r128;
        rd3.a r129 = this.n;
        if (r129 == null) goto L407;
        Integer r130 = Integer.valueOf(r129.f);
    L408:
        r109.c = String.valueOf(r130);
        r109.post(null, null);
        goto L409
    L407:
        r130 = null;
    L403:
        r128 = null;
    L397:
        r125 = null;
    L387:
        r107 = null;
    L339:
        r312 = null;
    L325:
        r311 = null;
    L307:
        r73 = null;
    L311:
        r218 = "0";
    L289:
        r217 = null;
    L290:
        r122 = "";
    L273:
        r310 = r11;
    L267:
        r216 = null;
    L261:
        r215 = "";
        goto L263
    L253:
        if (r57.intValue() != 7) goto L255;
    L254:
        r214 = "1";
        goto L256
    L248:
        if (r57.intValue() != 5) goto L250;
    L243:
        if (r57.intValue() != 6) goto L245;
    L244:
        r214 = "0";
        goto L256
    L238:
        if (r57.intValue() != 4) goto L240;
    L233:
        r57 = null;
    L225:
        r213 = null;
    L219:
        r212 = null;
    L211:
        r121 = null;
        goto L212
    L205:
        r120 = null;
    L201:
        r119 = "";
    L192:
        r118 = "";
        goto L193
    L183:
        r40 = "non_product";
    L180:
        r39 = null;
    L185:
        r211 = "";
        goto L186
    L168:
        r117 = "";
        goto L169
    L162:
        if (r116.intValue() != 12) goto L164;
        r34 = "ecom_growth";
        goto L167
    L157:
        if (r116.intValue() != 9) goto L159;
        r34 = "enter_mall";
        goto L167
    L152:
        if (r116.intValue() != 8) goto L154;
        r34 = "book_rank_card";
        goto L167
    L147:
        if (r116.intValue() != 11) goto L149;
        r34 = "window";
    L143:
        r116 = null;
    L137:
        r113 = "";
    L128:
        r32 = null;
    L115:
        rd3.a r131 = this.n;
        if (r131 == null) goto L122;
        p r132 = r131.i();
        if (r132 == null) goto L122;
        if (r132.getType() == 11) goto L121;
    L122:
        r210 = "guess_you_like_product";
        goto L123
    L413:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.resourcecard.view.ResourceCardView");
    L93:
        r21 = null;
        goto L94
    L89:
        r20 = null;
        goto L90
    L85:
        r11 = null;
        goto L86
    L81:
        r10 = null;
    L66:
        u r133 = r9.r();
        if (r133 == null) goto L69;
        r13 = r133.f();
        goto L70
    L69:
        r13 = null;
    L104:
        r22 = null;
    L46:
        rd3.a r134 = this.n;
        if (r134 == null) goto L52;
        p r135 = r134.i();
        if (r135 == null) goto L52;
        if (r135.getType() == 7) goto L58;
    L52:
        rd3.a r136 = this.n;
        if (r136 == null) goto L95;
        p r137 = r136.i();
        if (r137 == null) goto L95;
        if (r137.getType() == 11) goto L58;
    L95:
        rd3.a r138 = this.n;
        if (r138 == null) goto L106;
        p r139 = r138.i();
        if (r139 == null) goto L106;
        if (r139.getType() != 12) goto L106;
        rd3.a r140 = this.n;
        if (r140 == null) goto L104;
        r22 = s0.c(r140);
    L106:
        r23 = "";
        goto L107
    L418:
        return;
    L11:
        if (MallDivertShowJudge.a.a().a != 2) goto L13;
        boolean r141 = true;
    L14:
        if (r141 == false) goto L29;
        ((RecyclerView.ViewHolder) this).itemView.getViewTreeObserver().addOnGlobalLayoutListener(this.p);
        goto L29
    L13:
        r141 = false;
    L16:
        Lazy r142 = ResourceCardFreqController.a;
        rd3.a r143 = this.n;
        if (r143 == null) goto L23;
        p r144 = r143.i();
        if (r144 == null) goto L23;
        d r145 = r144.q();
        if (r145 == null) goto L23;
        Integer r146 = r145.b();
    L24:
        if (r146 == null) goto L29;
        r146.intValue();
        sk.a r147 = sk.a.a;
        int r148 = r146.intValue();
        r147.getClass();
        List r149 = sk.a.b(r148);
        if (r149.size() < ResourceCardFreqController.c()) goto L28;
        ListProtector.remove(r149, 0);
    L28:
        r149.add(String.valueOf(SystemClock.elapsedRealtime()));
        int r150 = r146.intValue();
        Intrinsics.checkNotNullParameter(r149, "record");
        q.a.b("resource_card_show_freq_" + r150, r149);
    L23:
        r146 = null;
        goto L24
    }

    public final void V3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.V3();
        rd3.a r0 = this.n;
        if (r0 == null) goto L9;
        p r1 = r0.i();
        if (r1 == null) goto L9;
        if (r1.getType() != 7) goto L9;
        ((RecyclerView.ViewHolder) this).itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
    L9:
        rd3.a r2 = this.n;
        if (r2 == null) goto L17;
        p r3 = r2.i();
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.getType() != 9) goto L19;
        c4().updateFloatMallVisibility(true);
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a4(Object r7) {
        ProductFeedAdapter.b r8 = (ProductFeedAdapter.b) r7;
        Intrinsics.checkNotNullParameter(r8, "item");
        rd3.a r0 = (rd3.a) r8.b;
        if (r0 == null) goto L7;
        p r1 = r0.i();
        if (r1 == null) goto L7;
        int r2 = r1.a();
    L9:
        if (r2 <= 0) goto L13;
        rd3.a r3 = (rd3.a) r8.b;
        if (r3 == null) goto L32;
        r3.f = getAdapterPosition();
    L32:
        rd3.a r9 = (rd3.a) r8.b;
        if ((!Intrinsics.areEqual(this.n, r9)) == false) goto L42;
        this.n = r9;
        rd3.a r10 = this.n;
        if (r10 == null) goto L42;
        View r4 = ((RecyclerView.ViewHolder) this).itemView;
        if (r4 == null) goto L40;
        ((ResourceCardView) r4).d(r10);
        goto L42
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.feed.resourcecard.view.ResourceCardView");
    L42:
        if (this.q.F == false) goto L79;
        rd3.a r11 = this.n;
        if (r11 == null) goto L77;
        ProductFeedViewModel r12 = r11.c;
        if (r12 == null) goto L77;
        AnchorV3Param r13 = r12.m907getAnchorV3Param();
        if (r13 == null) goto L77;
        i r5 = i.a;
        com.bytedance.android.ec.monitor.duration.d r6 = r5.get(r13.getFullPageMonitorName());
        if (r6 == null) goto L52;
        r6.a("guess_u_like_render_end");
    L52:
        rd3.a r14 = this.n;
        if (r14 == null) goto L58;
        p r15 = r14.i();
        if (r15 == null) goto L58;
        if (r15.getType() != 7) goto L58;
    L64:
        String r16 = "guide_mall";
    L66:
        com.bytedance.android.ec.monitor.duration.d r17 = r5.get(r13.getFullPageMonitorName());
        if (r17 == null) goto L70;
        r17.b("guess_u_like_type", r16);
    L70:
        if (this.q.E == true) goto L77;
        com.bytedance.android.ec.monitor.duration.d r18 = r5.get(r13.getFullPageMonitorName());
        if (r18 == null) goto L74;
        r18.a("render_end");
    L74:
        com.bytedance.android.ec.monitor.duration.d r19 = r5.get(r13.getFullPageMonitorName());
        if (r19 == null) goto L77;
        r19.report();
    L58:
        rd3.a r20 = this.n;
        if (r20 == null) goto L65;
        p r21 = r20.i();
        if (r21 == null) goto L65;
        if (r21.getType() == 9) goto L64;
    L65:
        r16 = "resource";
    L77:
        this.q.F = false;
        return;
    L79:
        return;
    L13:
        rd3.a r22 = (rd3.a) r8.b;
        if (r22 == null) goto L32;
        int r23 = getAdapterPosition();
        rd3.a r24 = (rd3.a) r8.b;
        if (r24 == null) goto L22;
        ProductFeedViewModel r25 = r24.c;
        if (r25 == null) goto L22;
        List<Object> r26 = r25.getHeaderList();
        if (r26 == null) goto L22;
        int r27 = r26.size();
    L23:
        int r28 = r23 - r27;
        rd3.a r29 = (rd3.a) r8.b;
        if (r29 == null) goto L30;
        ProductFeedViewModel r30 = r29.c;
        if (r30 == null) goto L30;
        List<Object> r31 = r30.getFirstLoadGuessULikeResourceCardList();
        if (r31 == null) goto L30;
        int r32 = r31.size();
    L31:
        r22.f = (r28 - r32) - c4().getSearchCardNumBefore(getAdapterPosition());
    L30:
        r32 = 0;
    L22:
        r27 = 1;
    L7:
        r2 = 0;
        goto L9
    }

    public ResourceCardVH(Context r5, ProductFeedAdapter r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "adapter");
        AttributeSet r3 = null;
        ResourceCardView r0 = new ResourceCardView(r5, r3, 6, 0);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Unit r7 = Unit.INSTANCE;
        super(r0);
        this.q = r6;
        final KClass r8 = Reflection.getOrCreateKotlinClass(ProductFeedViewModel.class);
        this.l = LazyKt.lazy(new ResourceCardVH$$special$$inlined$hostViewModel$1(this, r8, r8));
        this.m = new ArrayList();
        this.o = new Rect();
        this.p = new a(this);
    }
}
