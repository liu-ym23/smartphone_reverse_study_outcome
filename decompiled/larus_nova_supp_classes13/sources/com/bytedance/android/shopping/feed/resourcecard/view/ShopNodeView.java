package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductAuthorEntriesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductShopEntryStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.view.ShopTitleView;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import java.util.List;
import jd3.s0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/ShopNodeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopNodeView extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public yd3.r a;
    public final View b;
    public final ECDraweeView c;
    public final ECDraweeView d;
    public final TextView e;
    public final View f;
    public final View g;
    public final ShopTitleView h;
    public final View i;
    public rd3.a j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ShopNodeView a;

        public a(ShopNodeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ShopNodeView.a(this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ShopNodeView a;

        public b(ShopNodeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ShopNodeView.a(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ ShopNodeView a;

        public c(ShopNodeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ShopNodeView.a(this.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ShopNodeView a;

        public d(ShopNodeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            ShopNodeView.a(this.a);
        }
    }

    public static final class e {
    }

    static {
    }

    public ShopNodeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShopNodeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0 r0 = new s0();
        r0.b = "product_flow_page_store_card";
        rd3.a r1 = this.j;
        String r2 = "";
        if (r1 == null) goto L12;
        ProductFeedViewModel r3 = r1.c;
        if (r3 == null) goto L12;
        AnchorV3Param r4 = r3.m907getAnchorV3Param();
        if (r4 == null) goto L12;
        ECLogExtraData r5 = r4.getLogExtraData();
        if (r5 == null) goto L12;
        String r6 = r5.getEnterFrom();
        if (r6 == null) goto L12;
    L13:
        r0.d = r6;
        rd3.a r7 = this.j;
        if (r7 == null) goto L24;
        ProductFeedViewModel r8 = r7.c;
        if (r8 == null) goto L24;
        AnchorV3Param r9 = r8.m907getAnchorV3Param();
        if (r9 == null) goto L24;
        String r10 = r9.getEntranceInfo();
        if (r10 == null) goto L24;
        JSONObject r11 = com.bytedance.android.shopping.extensions.k.w(r10);
        if (r11 == null) goto L24;
        String r12 = r11.optString("source_method", "");
    L25:
        r0.e = r12;
        r0.f = "video";
        r0.a = "shop";
        rd3.a r13 = this.j;
        if (r13 == null) goto L45;
        yd3.p r14 = r13.i();
        if (r14 == null) goto L45;
        yd3.m r15 = r14.l();
        if (r15 == null) goto L45;
        List<Promotion> r16 = r15.h();
        if (r16 == null) goto L45;
        Promotion r17 = (Promotion) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L45;
        PromotionProductStruct r18 = r17.getPromotionInfo();
        if (r18 == null) goto L45;
        PromotionProductAuthorEntriesStruct r19 = r18.getEntryInfo();
        if (r19 == null) goto L45;
        PromotionProductShopEntryStruct r20 = r19.getShopEntry();
        if (r20 == null) goto L45;
        String r21 = r20.getShopAuthorId();
        if (r21 == null) goto L45;
        r2 = r21;
    L45:
        r0.c = r2;
        r0.post(null, null);
        return;
    L24:
        r12 = null;
    L12:
        r6 = "";
        goto L13
    }

    public static final void a(ShopNodeView r11) {
        r11.getClass();
        BtmSDK r0 = BtmSDK.INSTANCE;
        String r9 = r0.createBtmId(new BtmItemBuilder("a1.b7365.c87897.d66964", Boolean.FALSE).withView(r11).build());
        String r1 = BtmSDK.createJumpSourceBtmToken$default(r0, "c87897.d66964", PageFinder.via(r11), null, 4, null);
        rd3.a r3 = r11.j;
        if (r3 == null) goto L5;
        FeedProductEventTracker.m(FeedProductEventTracker.a, r3, "store_entrance", null, null, null, null, r9, 60);
    L5:
        jd3.g r2 = new jd3.g();
        r2.c = "product_flow_page_store_card";
        rd3.a r4 = r11.j;
        String r5 = "";
        if (r4 == null) goto L15;
        ProductFeedViewModel r6 = r4.c;
        if (r6 == null) goto L15;
        AnchorV3Param r7 = r6.m907getAnchorV3Param();
        if (r7 == null) goto L15;
        ECLogExtraData r8 = r7.getLogExtraData();
        if (r8 == null) goto L15;
        String r10 = r8.getEnterFrom();
        if (r10 == null) goto L15;
    L16:
        r2.e = r10;
        rd3.a r12 = r11.j;
        if (r12 == null) goto L27;
        ProductFeedViewModel r13 = r12.c;
        if (r13 == null) goto L27;
        AnchorV3Param r14 = r13.m907getAnchorV3Param();
        if (r14 == null) goto L27;
        String r15 = r14.getEntranceInfo();
        if (r15 == null) goto L27;
        JSONObject r16 = com.bytedance.android.shopping.extensions.k.w(r15);
        if (r16 == null) goto L27;
        String r17 = r16.optString("source_method", "");
    L28:
        r2.f = r17;
        r2.g = "video";
        r2.a = "shop";
        rd3.a r18 = r11.j;
        if (r18 == null) goto L48;
        yd3.p r19 = r18.i();
        if (r19 == null) goto L48;
        yd3.m r20 = r19.l();
        if (r20 == null) goto L48;
        List<Promotion> r21 = r20.h();
        if (r21 == null) goto L48;
        Promotion r22 = (Promotion) CollectionsKt.firstOrNull(r21);
        if (r22 == null) goto L48;
        PromotionProductStruct r23 = r22.getPromotionInfo();
        if (r23 == null) goto L48;
        PromotionProductAuthorEntriesStruct r24 = r23.getEntryInfo();
        if (r24 == null) goto L48;
        PromotionProductShopEntryStruct r25 = r24.getShopEntry();
        if (r25 == null) goto L48;
        String r26 = r25.getShopAuthorId();
        if (r26 == null) goto L48;
        r5 = r26;
    L48:
        r2.d = r5;
        r2.post(null, null);
        yd3.r r27 = r11.a;
        if (r27 == null) goto L54;
        String r28 = r27.d();
        if (r28 == null) goto L55;
        com.bytedance.android.ec.sdk.helper.p r29 = com.bytedance.android.ec.sdk.helper.p.a;
        Context r30 = r11.getContext();
        int r31 = md3.a.a;
        int r32 = com.bytedance.android.shopping.feed.utils.b.a;
        r29.openSchema(r30, md3.a.a(com.bytedance.android.shopping.feed.utils.b.b(r28, r11.j), r1));
        return;
    L55:
        return;
    L54:
        return;
    L27:
        r17 = null;
    L15:
        r10 = "";
        goto L16
    }

    public ShopNodeView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(2131560740, this, true);
        View r6 = findViewById(2131386270);
        this.b = r6;
        ECDraweeView r7 = findViewById(2131386272);
        this.c = r7;
        this.d = findViewById(2131378542);
        this.e = (TextView) findViewById(2131372016);
        this.g = findViewById(2131378296);
        this.f = findViewById(2131370771);
        ShopTitleView r8 = (ShopTitleView) findViewById(2131386283);
        this.h = r8;
        View r0 = findViewById(2131386269);
        this.i = r0;
        r0.setOnClickListener(new a(this));
        r8.setOnClickListener(new b(this));
        r6.setOnClickListener(new c(this));
        r7.setOnClickListener(new d(this));
    }

    public /* synthetic */ ShopNodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
