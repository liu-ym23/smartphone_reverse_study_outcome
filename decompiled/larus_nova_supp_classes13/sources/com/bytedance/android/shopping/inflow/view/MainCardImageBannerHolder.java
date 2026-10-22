package com.bytedance.android.shopping.inflow.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.goodprice.enums.LocationType;
import com.bytedance.android.shopping.feed.view.GoodPriceStrip;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.widget.RemoteRoundImageView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yd3.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/inflow/view/MainCardImageBannerHolder;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "a", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MainCardImageBannerHolder extends BannerHolder {
    public static final /* synthetic */ int j = 0;
    public final ECDraweeView a;
    public final FrameLayout b;
    public final ECDraweeView c;
    public final FrameLayout d;
    public final View e;
    public final RemoteRoundImageView f;
    public final GoodPriceStrip g;
    public final FrameLayout h;
    public final ImageView i;

    public static final class a {
    }

    public static final class b implements GoodPriceStrip.a {
        public final /* synthetic */ MainCardImageBannerHolder a;
        public final /* synthetic */ rd3.a b;

        @Override // com.bytedance.android.shopping.feed.view.GoodPriceStrip.a
        public final void a(o r8) {
            Intrinsics.checkNotNullParameter(r8, "resourceBarData");
            BtmSDK r0 = BtmSDK.INSTANCE;
            FeedProductEventTracker r1 = FeedProductEventTracker.a;
            rd3.a r2 = this.b;
            r1.getClass();
            String r3 = FeedProductEventTracker.f(r2, "c12364.d943130");
            PageFinder r4 = PageFinder.via(((RecyclerView.ViewHolder) this.a).itemView);
            BcmParams r5 = new BcmParams();
            rd3.a r6 = this.b;
            if (r6 == null) goto L7;
            Map<String, String> r7 = r6.p;
            if (r7 == null) goto L7;
            String r9 = r7.get("request_id");
        L8:
            r5.put("video_guide_search", k.d(FeedProductEventTracker.g(r6, r9)));
            Unit r10 = Unit.INSTANCE;
            String r11 = r0.createJumpSourceBtmToken(r3, r4, r5);
            List<yd3.e> r12 = r8.a();
            if (r12 == null) goto L15;
            yd3.e r13 = (yd3.e) CollectionsKt.firstOrNull(r12);
            if (r13 == null) goto L15;
            String r14 = r13.c();
            if (r14 == null) goto L15;
            p.a.openSchema(((RecyclerView.ViewHolder) this.a).itemView.getContext(), md3.a.a(r14, r11));
        L15:
            MainCardImageBannerHolder.T3(this.a, this.b, r8, "inflow_low_price_entrance_click");
            return;
        L7:
            r9 = null;
            goto L8
        }

        public final void b(o r4) {
            Intrinsics.checkNotNullParameter(r4, "resourceBarData");
            MainCardImageBannerHolder.T3(this.a, this.b, r4, "inflow_low_price_entrance_show");
        }

        public b(MainCardImageBannerHolder r1, rd3.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public MainCardImageBannerHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131374931);
        this.b = (FrameLayout) r2.findViewById(2131375013);
        this.c = r2.findViewById(2131374962);
        this.d = (FrameLayout) r2.findViewById(2131374963);
        this.e = r2.findViewById(2131372752);
        this.f = r2.findViewById(2131363322);
        this.g = (GoodPriceStrip) r2.findViewById(2131373850);
        this.h = (FrameLayout) r2.findViewById(2131374252);
        this.i = (ImageView) r2.findViewById(2131374249);
    }

    public final void U3(rd3.a r5) {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r5 == null) goto L8;
        String r2 = r5.o;     // Catch: Throwable -> L11
        if (r2 == null) goto L8;
        o r3 = (o) new Gson().fromJson(r2, o.class);     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r4) == true) goto L17;
        r0 = r4;
    L17:
        o r6 = (o) r0;
        if (r6 == null) goto L20;
        this.g.a(r6, new b(this, r5));
        this.g.setVisibility(0);
        return;
    L20:
        this.g.setVisibility(8);
        return;
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public static final void T3(MainCardImageBannerHolder r8, rd3.a r9, o r10, String r11) {
        r8.getClass();
        String r12 = k.d(CollectionsKt.emptyList());
        List<yd3.e> r13 = r10.a();
        String r0 = null;
        if (r13 == null) goto L7;
        yd3.e r14 = (yd3.e) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L7;
        String r15 = r14.b();
    L8:
        if (r15 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L16;
        r12 = k.d(CollectionsKt.listOf(r15));
    L16:
        String r3 = r12;
        FeedProductEventTracker r16 = FeedProductEventTracker.a;
        String r4 = LocationType.INFLOW_MAIN_CARD_TAG.getType();
        if (r9 == null) goto L21;
        Map<String, String> r17 = r9.p;
        if (r17 == null) goto L21;
        String r6 = r17.get("sim_product_id");
    L22:
        if (r9 == null) goto L26;
        Map<String, String> r18 = r9.p;
        if (r18 == null) goto L26;
        r0 = r18.get("request_id");
    L26:
        r16.getClass();
        FeedProductEventTracker.w(r11, r9, r3, r4, "c12364.d943130", r6, r0);
        return;
    L21:
        r6 = null;
        goto L22
    L10:
        if (r15.length() == 0) goto L13;
        r1 = false;
    L7:
        r15 = null;
        goto L8
    }
}
