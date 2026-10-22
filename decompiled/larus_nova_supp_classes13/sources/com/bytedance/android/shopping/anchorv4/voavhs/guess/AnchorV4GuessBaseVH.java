package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessBaseVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lj63/c;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorV4GuessBaseVH extends JediSimpleViewHolder<j63.c> implements com.bytedance.android.shopping.anchorv4.log.d {
    public j63.c l;
    public final a m;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d n;
    public final RecyclerView o;
    public final h p;

    public static final class a implements f {
        public final /* synthetic */ AnchorV4GuessBaseVH a;

        public a(AnchorV4GuessBaseVH r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void p(GULFeedbackDislikeReq r2) {
            Intrinsics.checkNotNullParameter(r2, "req");
            this.a.p.p(r2);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void v(j63.c r11, String r12) {
            Intrinsics.checkNotNullParameter(r12, "clickArea");
            h r1 = this.a.p;
            Pair[] r0 = new Pair[7];
            Integer r3 = null;
            if (r11 == null) goto L7;
            ItemCardLiveStruct r4 = r11.b();
            if (r4 == null) goto L7;
            String r5 = r4.getUid();
        L8:
            r0[0] = TuplesKt.to("anchor_id", r5);
            if (r11 == null) goto L13;
            ItemCardLiveStruct r6 = r11.b();
            if (r6 == null) goto L13;
            String r7 = r6.getRoomId();
        L14:
            r0[1] = TuplesKt.to("room_id", r7);
            if (r11 == null) goto L19;
            ItemCardProductStruct r8 = r11.d();
            if (r8 == null) goto L19;
            String r9 = r8.getProductId();
        L20:
            r0[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r9);
            if (r11 == null) goto L28;
            ItemCardLiveStruct r10 = r11.b();
            if (r10 == null) goto L28;
            Integer r13 = r10.getStatus();
            if (r13 == null) goto L28;
            String r14 = String.valueOf(r13.intValue());
            if (r14 == null) goto L28;
        L29:
            r0[3] = TuplesKt.to("live_status", r14);
            r0[4] = TuplesKt.to("click_area", r12);
            r0[5] = TuplesKt.to("enter_from_merge", "guessyoulike_product_detail");
            r0[6] = TuplesKt.to("enter_method", "native");
            Map r15 = MapsKt.mutableMapOf(r0);
            AnchorV4GuessBaseVH r2 = this.a;
            if (r11 == null) goto L32;
            AdInfoStruct r16 = r11.a();
        L33:
            if (r11 == null) goto L35;
            r3 = Integer.valueOf(r11.b);
        L35:
            r2.getClass();
            AnchorV4GuessBaseVH.d4(r16, r3, r15);
            Unit r17 = Unit.INSTANCE;
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r1, "anchor_card_click", r15, false, null, null, null, null, 252);
            return;
        L32:
            r16 = null;
        L28:
            r14 = "0";
        L19:
            r9 = null;
        L13:
            r7 = null;
        L7:
            r5 = null;
            goto L8
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void u(ItemCardRecommendReasonStruct r11, j63.c r12, Integer r13) {
            h r1 = this.a.p;
            Pair[] r0 = new Pair[4];
            r0[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail_guessyoulike");
            r0[1] = TuplesKt.to("display_rank", String.valueOf(r13));
            String r14 = null;
            if (r12 == null) goto L7;
            ItemCardProductStruct r15 = r12.d();
            if (r15 == null) goto L7;
            String r16 = r15.getProductId();
        L8:
            r0[2] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r16);
            if (r11 == null) goto L11;
            r14 = r11.getRankId();
        L11:
            r0[3] = TuplesKt.to("rank_id", r14);
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r1, "product_ranking_entrance_click", MapsKt.mapOf(r0), false, null, null, null, null, 252);
            return;
        L7:
            r16 = null;
            goto L8
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void q(String r15, String r16, PageFinder r17, boolean r18) {
            Intrinsics.checkNotNullParameter(r15, "event");
            Integer r1 = AnchorV4GuessBaseVH.c4(this.a).getType();
            String r6 = null;
            if (r1 != null) goto L6;
        L8:
            if (r1 != null) goto L11;
        L13:
            if (r1 != null) goto L16;
        L18:
            if (r1 != null) goto L21;
        L23:
            String r2 = null;
        L24:
            AnchorV4GuessBaseVH r8 = this.a;
            h r9 = r8.p;
            ItemCardProductStruct r10 = ((j63.c) r8.getItem()).d();
            if (r10 == null) goto L27;
            String r11 = r10.getProductId();
        L28:
            Pair[] r12 = new Pair[5];
            r12[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
            r12[1] = TuplesKt.to("outflow_order", Integer.valueOf(AnchorV4GuessBaseVH.c4(this.a).b));
            r12[2] = TuplesKt.to("ecom_type", r2);
            if (AnchorV4GuessBaseVH.c4(this.a).a() == null) goto L31;
            r6 = "effective_ad";
        L31:
            r12[3] = TuplesKt.to("is_other_channel", r6);
            r12[4] = TuplesKt.to("btm", r16);
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r9, r15, MapsKt.mapOf(r12), r18, null, r17, r11, null, 148);
            return;
        L27:
            r11 = null;
            goto L28
        L21:
            if (r1.intValue() != 4) goto L23;
            r2 = "video";
            goto L24
        L16:
            if (r1.intValue() != 3) goto L18;
            r2 = "activity";
            goto L24
        L11:
            if (r1.intValue() != 2) goto L13;
            r2 = "product";
            goto L24
        L6:
            if (r1.intValue() != 1) goto L8;
            r2 = "live";
            goto L24
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void s(String r11, String r12, String r13, String r14) {
            Intrinsics.checkNotNullParameter(r12, "enterMethod");
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(this.a.p, "show_ecom_similar", MapsKt.mapOf(new Pair[]{TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r13), TuplesKt.to("commodity_type", r14), TuplesKt.to("enter_method", r12), TuplesKt.to("ecom_type", r11)}), false, null, null, null, null, 252);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void t(String r11, String r12, String r13, String r14) {
            Intrinsics.checkNotNullParameter(r11, "ecomType");
            Intrinsics.checkNotNullParameter(r12, "enterMethod");
            h r1 = this.a.p;
            Pair[] r0 = new Pair[6];
            r0[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r14);
            r0[1] = TuplesKt.to("commodity_type", r13);
            r0[2] = TuplesKt.to("enter_method", r12);
            r0[3] = TuplesKt.to("ecom_type", r11);
            HashSet r15 = l63.a.a;
            if (l63.a.b(AnchorV4GuessBaseVH.c4(this.a).getType()) == false) goto L5;
            String r16 = "1";
        L6:
            r0[4] = TuplesKt.to("with_more", r16);
            r0[5] = TuplesKt.to("outflow_order", Integer.valueOf(AnchorV4GuessBaseVH.c4(this.a).b));
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r1, "show_ecom_dislike", MapsKt.mapOf(r0), false, null, null, null, null, 252);
            return;
        L5:
            r16 = "0";
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void r(String r17, String r18, String r19, String r20, String r21) {
            Intrinsics.checkNotNullParameter(r17, "ecomType");
            Intrinsics.checkNotNullParameter(r18, "enterMethod");
            int r3 = this.a.getAdapterPosition();
            RecyclerView.Adapter r4 = this.a.o.getAdapter();
            if (r4 == null) goto L5;
            int r5 = r4.getItemCount();
        L6:
            int r6 = ((r3 - r5) + this.a.p.C()) + 1;
            h r7 = this.a.p;
            Pair[] r8 = new Pair[7];
            r8[0] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r20);
            r8[1] = TuplesKt.to("commodity_type", r19);
            r8[2] = TuplesKt.to("enter_method", r18);
            r8[3] = TuplesKt.to("ecom_type", r17);
            HashSet r1 = l63.a.a;
            if (l63.a.b(AnchorV4GuessBaseVH.c4(this.a).getType()) == false) goto L9;
            String r2 = "1";
        L10:
            r8[4] = TuplesKt.to("with_more", r2);
            r8[5] = TuplesKt.to("outflow_order", Integer.valueOf(r6));
            r8[6] = TuplesKt.to("close_type", r21);
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r7, "close_ecom_dislike", MapsKt.mapOf(r8), false, null, null, null, null, 252);
            return;
        L9:
            r2 = "0";
            goto L10
        L5:
            r5 = 0;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void w(String r20, String r21, String r22, boolean r23, String r24, j63.c r25) {
            Intrinsics.checkNotNullParameter(r20, "confirmContent");
            Intrinsics.checkNotNullParameter(r21, "ecomType");
            Intrinsics.checkNotNullParameter(r22, "enterMethod");
            Intrinsics.checkNotNullParameter(r24, "clickArea");
            Intrinsics.checkNotNullParameter(r25, "item");
            int r5 = this.a.getAdapterPosition();
            RecyclerView.Adapter r7 = this.a.o.getAdapter();
            if (r7 == null) goto L5;
            int r8 = r7.getItemCount();
        L6:
            int r6 = ((r5 - r8) + this.a.p.C()) + 1;
            h r10 = this.a.p;
            Pair[] r9 = new Pair[11];
            r9[0] = TuplesKt.to("confirm_content", r20);
            r9[1] = TuplesKt.to("ecom_type", r21);
            r9[2] = TuplesKt.to("enter_method", r22);
            ItemCardProductStruct r1 = r25.d();
            String r2 = null;
            if (r1 == null) goto L9;
            String r3 = r1.getProductId();
        L10:
            r9[3] = TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r3);
            ItemCardProductStruct r4 = r25.d();
            if (r4 == null) goto L13;
            String r11 = r4.getCommodityType();
        L14:
            r9[4] = TuplesKt.to("commodity_type", r11);
            if (r23 == false) goto L17;
            String r12 = "1";
        L18:
            r9[5] = TuplesKt.to("with_more", r12);
            r9[6] = TuplesKt.to("click_area", r24);
            r9[7] = TuplesKt.to(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");
            String r13 = r25.getRequestId();
            String r14 = "";
            if (r13 != null) goto L21;
            r13 = "";
        L21:
            r9[8] = TuplesKt.to("request_id", r13);
            ItemCardProductStruct r15 = r25.d();
            if (r15 == null) goto L24;
            r2 = r15.getRecommendInfo();
        L24:
            if (r2 == null) goto L27;
            r14 = r2;
        L27:
            r9[9] = TuplesKt.to("recommend_info", r14);
            r9[10] = TuplesKt.to("outflow_order", Integer.valueOf(r6));
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r10, "click_ecom_dislike", MapsKt.mapOf(r9), false, null, null, null, null, 252);
            return;
        L17:
            r12 = "0";
            goto L18
        L13:
            r11 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r8 = 0;
            goto L6
        }
    }

    public final void onScan() {
    }

    public final void onVisible() {
    }

    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    public final void T3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.T3();
        CommonMeta r0 = this.p.a();
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(r0, "$this$addGulVHCount");
        r0.setGulVHCount(r0.getGulVHCount() + 1);
        return;
    }

    public final void V3() {
        super/*com.bytedance.jedi.ext.adapter.JediViewHolder*/.V3();
        CommonMeta r0 = this.p.a();
        if (r0 == null) goto L8;
        Intrinsics.checkNotNullParameter(r0, "$this$minusGulVHCount");
        r0.setGulVHCount(r0.getGulVHCount() - 1);
        if (r0.getGulVHCount() != 0) goto L9;
        r0.setHeadViewScrollToGUL(false);
        return;
    L9:
        return;
    }

    public View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public static final /* synthetic */ j63.c c4(AnchorV4GuessBaseVH r0) {
        return (j63.c) r0.getItem();
    }

    public /* bridge */ /* synthetic */ void a4(Object r1) {
        e4((j63.c) r1);
    }

    public void e4(j63.c r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.n.b(this, r2);
    }

    public static void d4(AdInfoStruct r5, Integer r6, Map r7) {
        Intrinsics.checkNotNullParameter(r7, "map");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        if (r5 == null) goto L6;
        String r3 = r5.getRawData();     // Catch: Throwable -> L28
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        Object r8 = r7.put("is_other_channel", "");     // Catch: Throwable -> L28
    L26:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L28
    L30:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L36;
        ECExceptionMonitor.e(r10);
        return;
    L36:
        return;
    L16:
        if (r5 == null) goto L18;
        String r11 = r5.getRawData();     // Catch: Throwable -> L28
    L19:
        JSONObject r12 = k.w(r11);     // Catch: Throwable -> L28
        if (r12 == null) goto L24;
        JSONObject r13 = r12.optJSONObject("raw_ad_data");     // Catch: Throwable -> L28
        if (r13 == null) goto L24;
        r7.put("creative_id", r13.optString("creative_id"));     // Catch: Throwable -> L28
        r7.put("is_other_channel", "effective_ad");     // Catch: Throwable -> L28
        r7.put("log_extra", r13.optString("log_extra"));     // Catch: Throwable -> L28
        r7.put("outflow_order", r6);     // Catch: Throwable -> L28
        r7.put(PdpOpenThirdParam.KEY_PAGE_NAME, "product_detail");     // Catch: Throwable -> L28
        r7.put("module_label", "guess_you_like_product");     // Catch: Throwable -> L28
    L25:
        r8 = r7;
    L24:
        r7 = null;
        goto L25
    L18:
        r11 = null;
        goto L19
    L9:
        if (r3.length() == 0) goto L12;
        r4 = false;
        goto L14
    L6:
        r3 = null;
    L28:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public /* bridge */ /* synthetic */ void b4(Object r1, int r2, List r3) {
        f4((j63.c) r1, r2, r3);
    }

    public void f4(j63.c r1, int r2, List<Object> r3) {
        Intrinsics.checkNotNullParameter(r1, "item");
        if ((!Intrinsics.areEqual(this.l, r1)) == false) goto L6;
        this.l = r1;
        e4(r1);
        return;
    }

    public AnchorV4GuessBaseVH(View r2, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r3, RecyclerView r4, h r5) {
        Intrinsics.checkNotNullParameter(r2, "theView");
        Intrinsics.checkNotNullParameter(r3, "logManager");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        Intrinsics.checkNotNullParameter(r5, "anchorV4VM");
        super(r2);
        this.n = r3;
        this.o = r4;
        this.p = r5;
        StaggeredGridDoubleColumnDecoration.a r6 = StaggeredGridDoubleColumnDecoration.g;
        View r7 = ((RecyclerView.ViewHolder) this).itemView;
        r6.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r7, true);
        this.m = new a(this);
    }
}
