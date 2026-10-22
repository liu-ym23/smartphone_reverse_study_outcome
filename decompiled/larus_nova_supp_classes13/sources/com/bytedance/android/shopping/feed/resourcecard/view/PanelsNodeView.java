package com.bytedance.android.shopping.feed.resourcecard.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.CategoryInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.repository.api.InnerGuessULikeApi;
import com.bytedance.android.shopping.feed.resourcecard.frequency.MallDivertShowJudge;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002!\"B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelsNodeView;", "Landroid/widget/FrameLayout;", "", "getProductBtm", "getBtmIdForProduct", "Lyd3/p;", "resourceCard", "", "setBackGroundMargin", "Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelsNodeView$c;", "q", "Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelsNodeView$c;", "getOnPanelClickListener", "()Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelsNodeView$c;", "setOnPanelClickListener", "(Lcom/bytedance/android/shopping/feed/resourcecard/view/PanelsNodeView$c;)V", "onPanelClickListener", "", "value", "r", "Ljava/lang/Integer;", "getPanelLayoutMode", "()Ljava/lang/Integer;", "setPanelLayoutMode", "(Ljava/lang/Integer;)V", "panelLayoutMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PanelsNodeView extends FrameLayout {
    public static final /* synthetic */ int s = 0;
    public yd3.m a;
    public PanelViewWrapper b;
    public PanelViewWrapper c;
    public PanelViewWrapper d;
    public PanelViewWrapper e;
    public rd3.a f;
    public final ViewGroup g;
    public final View h;
    public final TextView i;
    public final ECDraweeView j;
    public Disposable k;
    public final View l;
    public final View m;
    public final ImageView n;
    public boolean o;
    public Function0<Unit> p;
    public c q;
    public Integer r;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ PanelsNodeView a;

        public a(PanelsNodeView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            rd3.a r1 = this.a.f;
            if (r1 == null) goto L5;
            FeedProductEventTracker.m(FeedProductEventTracker.a, r1, "change", null, null, null, null, null, 124);
        L5:
            PanelsNodeView r11 = this.a;
            Disposable r0 = r11.k;
            if (r0 != null) goto L8;
        L9:
            InnerGuessULikeApi.a.getClass();
            InnerGuessULikeApi r2 = InnerGuessULikeApi.a.b;
            if (r2 == null) goto L47;
            rd3.a r3 = r11.f;
            int r4 = 0;
            if (r3 == null) goto L22;
            yd3.p r5 = r3.i();
            if (r5 == null) goto L22;
            yd3.p.b r6 = r5.g();
            if (r6 == null) goto L22;
            String r7 = r6.d();
            if (r7 == null) goto L22;
            Integer r8 = StringsKt.toIntOrNull(r7);
            if (r8 == null) goto L22;
            int r9 = r8.intValue();
        L23:
            rd3.a r12 = r11.f;
            if (r12 == null) goto L38;
            ProductFeedViewModel r13 = r12.c;
            if (r13 == null) goto L38;
            AnchorV3Param r14 = r13.m907getAnchorV3Param();
            if (r14 == null) goto L38;
            PromotionProductStruct r15 = r14.getCurrentPromotion();
            if (r15 == null) goto L38;
            PromotionProductExtraStruct r16 = r15.getExtraInfo();
            if (r16 == null) goto L38;
            CategoryInfo r17 = r16.getCategoryInfo();
            if (r17 == null) goto L38;
            Integer r18 = r17.getFirstCid();
            if (r18 == null) goto L38;
            r4 = r18.intValue();
        L38:
            Observable<rd3.k> r19 = r2.fetchNewerChannelCardFeed("1", r9, r4);
            if (r19 == null) goto L48;
            Observable r20 = r19.subscribeOn(Schedulers.io());
            if (r20 == null) goto L49;
            Observable r21 = r20.observeOn(AndroidSchedulers.mainThread());
            if (r21 == null) goto L50;
            r21.subscribe(new com.bytedance.android.shopping.feed.resourcecard.view.h(r11));
            return;
        L50:
            return;
        L49:
            return;
        L48:
            return;
        L22:
            r9 = 0;
            goto L23
        L47:
            return;
        L8:
            if (r0.isDisposed() == true) goto L9;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(PanelViewWrapper r1, int r2);
    }

    public static final class d implements c {
        public final /* synthetic */ PanelsNodeView a;
        public final /* synthetic */ Context b;

        public d(PanelsNodeView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.shopping.feed.resourcecard.view.PanelsNodeView.c
        public final void a(PanelViewWrapper r20, int r21) {
            yd3.m r4 = this.a.a;
            Promotion r5 = null;
            if (r4 == null) goto L7;
            List<Promotion> r6 = r4.h();
            if (r6 == null) goto L7;
            Promotion r9 = (Promotion) CollectionsKt.getOrNull(r6, r21);
        L8:
            boolean r7 = true;
            if (r9 == null) goto L54;
            String r8 = r9.getLink();
            if (r8 == null) goto L54;
            rd3.a r10 = this.a.f;
            if (r10 == null) goto L17;
            yd3.p r11 = r10.i();
            if (r11 == null) goto L17;
            Integer r12 = Integer.valueOf(r11.getType());
        L18:
            if (r12 != null) goto L21;
        L23:
            if (r12 == null) goto L38;
            if (r12.intValue() != 6) goto L38;
            Uri r13 = UriProtector.parse(Uri.decode(r8));     // Catch: Exception -> L36
            JSONObject r14 = z1.f(UriProtector.getQueryParameter(r13, "meta_params"));     // Catch: Exception -> L36
            Object r15 = r14.get("entrance_info");     // Catch: Exception -> L36
            if ((r15 instanceof String) == true) goto L30;
            r15 = null;
        L30:
            String r16 = (String) r15;     // Catch: Exception -> L36
            if (r16 == null) goto L33;
            JSONObject r17 = z1.f(r16);     // Catch: Exception -> L36
            r17.put("carrier_source", "ecom_new_channel");     // Catch: Exception -> L36
            r17.put("display_rank", "3");     // Catch: Exception -> L36
            r17.put("click_area", "pic");     // Catch: Exception -> L36
            r17.put("recommend_info", r9.getRecommendInfo());     // Catch: Exception -> L36
            r17.put("ecom_scene_id", "1002,1064");     // Catch: Exception -> L36
        L34:
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, l0.c(r13, "meta_params", r14.put("entrance_info", r17.toString()).toString()).toString());     // Catch: Exception -> L36
            goto L54
        L33:
            r17 = null;
        L36:
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r8);
        L38:
            if (r12 != null) goto L41;
        L43:
            if (r12 != null) goto L46;
        L48:
            if (r12 != null) goto L51;
        L53:
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, r8);
            goto L54
        L51:
            if (r12.intValue() != 12) goto L53;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, md3.a.a(r8, BtmSDK.INSTANCE.createJumpSourceBtmToken("c870003.d993139", PageFinder.via(r20), new BcmParams().put("bst_group_type", "product"))));
            goto L54
        L46:
            if (r12.intValue() != 9) goto L48;
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, md3.a.a(r8, BtmSDK.INSTANCE.createJumpSourceBtmToken("c2695.d3104", PageFinder.via(r20), new BcmParams().put("bst_group_type", "product"))));
            goto L54
        L41:
            if (r12.intValue() != 7) goto L43;
            MallDivertShowJudge.h.getClass();
            MallDivertShowJudge.a.a().b();
            com.bytedance.android.ec.sdk.helper.p.a.openSchema(this.b, md3.a.a(r8, BtmSDK.INSTANCE.createJumpSourceBtmToken("c2695.d3104", PageFinder.via(r20), new BcmParams().put("bst_group_type", "product"))));
            goto L54
        L21:
            if (r12.intValue() != 1) goto L23;
            String r2 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c87897.d116400", PageFinder.via(r20), null, 4, null);
            com.bytedance.android.ec.sdk.helper.p r3 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r18 = this.b;
            int r19 = md3.a.a;
            int r22 = com.bytedance.android.shopping.feed.utils.b.a;
            r3.openSchema(r18, md3.a.a(com.bytedance.android.shopping.feed.utils.b.b(r8, this.a.f), r2));
        L17:
            r12 = null;
        L54:
            PanelsNodeView r23 = this.a;
            rd3.a r110 = r23.f;
            if (r110 == null) goto L80;
            FeedProductEventTracker r111 = FeedProductEventTracker.a;
            if (r23.o == true) goto L70;
            yd3.m r24 = r23.a;
            if (r24 == null) goto L70;
            List<Promotion> r25 = r24.h();
            if (r25 == null) goto L70;
            Promotion r26 = (Promotion) CollectionsKt.getOrNull(r25, r21);
            if (r26 == null) goto L70;
            PromotionProductStruct r27 = r26.getPromotionInfo();
            if (r27 == null) goto L70;
            PromotionProductBaseStruct r28 = r27.getBaseInfo();
            if (r28 == null) goto L70;
            String r112 = r28.getProductId();
        L71:
            PanelsNodeView r29 = this.a;
            if (r29.o == true) goto L79;
            yd3.m r30 = r29.a;
            if (r30 == null) goto L79;
            List<Promotion> r31 = r30.h();
            if (r31 == null) goto L79;
            r5 = (Promotion) CollectionsKt.getOrNull(r31, r21);
        L79:
            FeedProductEventTracker.m(r111, r110, "pic", r112, r5, null, null, PanelsNodeView.a(this.a), 48);
        L70:
            r112 = null;
        L80:
            rd3.a r1 = this.a.f;
            if (r1 == null) goto L106;
            yd3.p r32 = r1.i();
            if (r32 != null) goto L85;
        L86:
            com.bytedance.android.btm.api.model.d r33 = new com.bytedance.android.btm.api.model.d();
            String r34 = PanelsNodeView.b(this.a);
            String r35 = "";
            if (r34 != null) goto L89;
            r34 = "";
        L89:
            r33.a = r34;
            r33.b = PageFinder.via(this.a);
            int r36 = com.bytedance.android.shopping.feed.event.o.a;
            PanelsNodeView r37 = this.a;
            rd3.a r38 = r37.f;
            Intrinsics.checkNotNullParameter(r37, FreqActions.ACTION_VIEW);
            Intrinsics.checkNotNullParameter(r33, "btmModel");
            if (r38 == null) goto L106;
            if (ld3.f.b() == false) goto L105;
            String r39 = r33.a;
            if (r39 == null) goto L98;
            r35 = r39;
        L98:
            com.bytedance.android.shopping.feed.event.n r40 = new com.bytedance.android.shopping.feed.event.n(r9, r37, r38);
            if (r35.length() == 0) goto L102;
            r7 = false;
        L102:
            if (r7 == false) goto L104;
            ExtKt.b("BstItemCreate", "btm is empty!");
        L104:
            com.bytedance.android.bst.api.d r41 = new com.bytedance.android.bst.api.d(r37);
            r41.a = r35;
            r41.b = "click_product";
            r41.c = r9;
            r41.d = "like_shopping";
            r41.e = -1;
            r41.f = r40;
            com.bytedance.android.bst.api.f.b.getClass();
            com.bytedance.android.bst.api.f.c(r41);
            goto L106
        L105:
            String r113 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r33.a, Boolean.FALSE).withPageFinder(r33.b).build());
            FeedProductEventTracker r42 = FeedProductEventTracker.a;
            Context r43 = r37.getContext();
            ProductFeedViewModel r44 = r38.c;
            r42.getClass();
            FeedProductEventTracker.j(r43, r44, r38, r9, r113, null);
            goto L106
        L85:
            if (r32.getType() != 1) goto L86;
        L106:
            Function0<Unit> r45 = this.a.p;
            if (r45 == null) goto L112;
            Unit r46 = (Unit) r45.invoke();
            return;
        L112:
            return;
        L7:
            r9 = null;
            goto L8
        }
    }

    public static final class e extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ PanelsNodeView g;

        public e(PanelsNodeView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            this.g.getOnPanelClickListener().a(this.g.b, 0);
        }
    }

    public static final class f extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ PanelsNodeView g;

        public f(PanelsNodeView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            this.g.getOnPanelClickListener().a(this.g.c, 1);
        }
    }

    public static final class g extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ PanelsNodeView g;

        public g(PanelsNodeView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            this.g.getOnPanelClickListener().a(this.g.d, 2);
        }
    }

    public static final class h extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ PanelsNodeView g;

        public h(PanelsNodeView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            this.g.getOnPanelClickListener().a(this.g.e, 3);
        }
    }

    static {
    }

    public PanelsNodeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PanelsNodeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getProductBtm() {
        rd3.a r0 = this.f;
        if (r0 == null) goto L7;
        yd3.p r1 = r0.i();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.getType());
    L8:
        if (r2 != null) goto L11;
    L13:
        if (r2 != null) goto L16;
    L18:
        if (r2 != null) goto L21;
    L23:
        if (r2 != null) goto L26;
    L29:
        return null;
    L26:
        if (r2.intValue() != 12) goto L29;
        return "a1.b7365.c870003.d993139";
    L21:
        if (r2.intValue() != 9) goto L23;
    L22:
        return "a1.b7365.c2695.d3104";
    L16:
        if (r2.intValue() != 7) goto L18;
    L11:
        if (r2.intValue() != 1) goto L13;
        return "a1.b7365.c87897.d116400";
    L7:
        r2 = null;
        goto L8
    }

    public final void d() {
        Disposable r0 = this.k;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.n.clearAnimation();
        this.n.setImageResource(2131233532);
    }

    private final String getBtmIdForProduct() {
        String r0 = getProductBtm();
        if (r0 != null) goto L7;
        return null;
    L7:
        return BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r0, Boolean.FALSE).withView(this).build());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    public final c getOnPanelClickListener() {
        return this.q;
    }

    public final Integer getPanelLayoutMode() {
        return this.r;
    }

    public static final /* synthetic */ String a(PanelsNodeView r0) {
        return r0.getBtmIdForProduct();
    }

    public static final /* synthetic */ String b(PanelsNodeView r0) {
        return r0.getProductBtm();
    }

    private final void setBackGroundMargin(yd3.p r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        yd3.m r0 = r9.l();
        Integer r1 = null;
        if (r0 == null) goto L7;
        ECUrlModel r2 = r0.c();
    L9:
        if (r2 != null) goto L11;
        this.g.setPadding(com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
    L21:
        rd3.a r10 = this.f;
        if (r10 == null) goto L28;
        yd3.p r11 = r10.i();
        if (r11 == null) goto L28;
        yd3.f r12 = r11.h();
        if (r12 == null) goto L28;
        r1 = Integer.valueOf(r12.b());
    L28:
        if (r1 != null) goto L31;
    L32:
        if (r1 != null) goto L35;
        return;
    L35:
        if (r1.intValue() != 7) goto L38;
    L36:
        wg.a.f(this.g, 0, com.bytedance.android.shopping.extensions.b.b(11), 0, 0);
        return;
    L38:
        return;
    L31:
        if (r1.intValue() == 6) goto L36;
    L11:
        if (r9.getType() != 6) goto L13;
        this.g.setPadding(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(16.5d)), 0, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(16.5d)), com.bytedance.android.shopping.extensions.b.b(8));
        goto L21
    L13:
        ECDraweeView r13 = this.j;
        ViewGroup.LayoutParams r4 = r13.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
        r4 = null;
    L16:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L19;
        r5.setMargins(com.bytedance.android.shopping.extensions.b.b(Double.valueOf(1.8d)), 0, com.bytedance.android.shopping.extensions.b.b(Double.valueOf(1.8d)), 0);
        r13.setLayoutParams(r5);
    L19:
        this.g.setPadding(com.bytedance.android.shopping.extensions.b.b(10), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(10), com.bytedance.android.shopping.extensions.b.b(8));
        goto L21
    L7:
        r2 = null;
        goto L9
    }

    public final void setOnPanelClickListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void setPanelLayoutMode(Integer r6) {
        if (Intrinsics.areEqual(r6, this.r) == false) goto L5;
        return;
    L5:
        this.g.removeAllViews();
        if (r6 != null) goto L9;
    L11:
        if (r6 != null) goto L14;
    L16:
        if (r6 != null) goto L19;
    L21:
        if (r6 != null) goto L24;
    L26:
        if (r6 != null) goto L29;
    L31:
        int r2 = 2131560798;
    L33:
        if (ld3.b.a() == false) goto L35;
        Map r3 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(getContext()).aU(r2, this.g, true);
    L36:
        this.b = (PanelViewWrapper) findViewById(2131381902);
        this.c = (PanelViewWrapper) findViewById(2131381903);
        this.d = (PanelViewWrapper) findViewById(2131381904);
        this.e = (PanelViewWrapper) findViewById(2131381905);
        RoundedFrameLayout r1 = this.b;
        if (r1 == null) goto L39;
        r1.setOnClickListener(new e(this));
    L39:
        RoundedFrameLayout r4 = this.c;
        if (r4 == null) goto L42;
        r4.setOnClickListener(new f(this));
    L42:
        if (r6 != null) goto L45;
    L49:
        RoundedFrameLayout r0 = this.d;
        if (r0 == null) goto L52;
        r0.setVisibility(0);
    L52:
        RoundedFrameLayout r5 = this.d;
        if (r5 == null) goto L55;
        r5.setOnClickListener(new g(this));
    L55:
        RoundedFrameLayout r7 = this.e;
        if (r7 == null) goto L58;
        r7.setOnClickListener(new h(this));
    L58:
        this.r = r6;
        return;
    L45:
        if (r6.intValue() != 3) goto L49;
        RoundedFrameLayout r8 = this.d;
        if (r8 == null) goto L52;
        r8.setVisibility(8);
        goto L52
    L35:
        View.inflate(getContext(), r2, this.g);
        goto L36
    L29:
        if (r6.intValue() != 3) goto L31;
    L30:
        r2 = 2131560795;
        goto L33
    L24:
        if (r6.intValue() != 4) goto L26;
    L19:
        if (r6.intValue() != 1) goto L21;
        r2 = 2131560796;
        goto L33
    L14:
        if (r6.intValue() != 2) goto L16;
        r2 = 2131560797;
        goto L33
    L9:
        if (r6.intValue() != 0) goto L11;
        goto L11
    }

    public final void c(rd3.a r7, Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "anchorInflowFeedItem");
        this.p = r8;
        this.f = r7;
        yd3.p r9 = r7.i();
        yd3.b r0 = null;
        if (r9 == null) goto L5;
        yd3.m r10 = r9.l();
    L6:
        this.a = r10;
        ECDraweeView r1 = this.j;
        if (r10 == null) goto L9;
        ECUrlModel r11 = r10.c();
    L10:
        y.a(r1, r11);
        TextView r12 = this.i;
        yd3.m r2 = this.a;
        if (r2 == null) goto L15;
        yd3.c r3 = r2.e();
        if (r3 == null) goto L15;
        String r4 = r3.a();
    L16:
        r12.setText(r4);
        yd3.m r13 = this.a;
        if (r13 == null) goto L19;
        Integer r14 = r13.f();
    L20:
        setPanelLayoutMode(r14);
        PanelViewWrapper r15 = this.b;
        if (r15 == null) goto L23;
        r15.y(r7, 0);
    L23:
        PanelViewWrapper r16 = this.c;
        boolean r5 = true;
        if (r16 == null) goto L26;
        r16.y(r7, 1);
    L26:
        PanelViewWrapper r17 = this.d;
        if (r17 == null) goto L29;
        r17.y(r7, 2);
    L29:
        PanelViewWrapper r18 = this.e;
        if (r18 == null) goto L32;
        r18.y(r7, 3);
    L32:
        yd3.p r19 = r7.i();
        if (r19 == null) goto L37;
        yd3.m r20 = r19.l();
        if (r20 == null) goto L37;
        Integer r21 = Integer.valueOf(r20.b());
    L38:
        yd3.p r6 = r7.i();
        if (r6 != null) goto L41;
    L68:
        this.m.setVisibility(8);
        this.l.setVisibility(8);
    L69:
        setBackGroundMargin(r7.i());
        rd3.a r22 = this.f;
        if (r22 == null) goto L85;
        yd3.p r23 = r22.i();
        if (r23 != null) goto L74;
        return;
    L74:
        if (r23.getType() != 12) goto L87;
        rd3.a r24 = this.f;
        if (r24 == null) goto L80;
        yd3.p r25 = r24.i();
        if (r25 == null) goto L80;
        r0 = r25.d();
    L80:
        if (r0 != null) goto L82;
        setBackgroundResource(2131233413);
    L83:
        this.j.setVisibility(8);
        return;
    L82:
        setBackgroundResource(2131233412);
        goto L83
    L87:
        return;
    L85:
        return;
    L41:
        if (r6.getType() != 6) goto L68;
        if (r21 != null) goto L45;
    L46:
        if (r21 != null) goto L49;
    L50:
        if (r21 != null) goto L53;
    L54:
        if (r21 != null) goto L57;
    L60:
        if (r5 == false) goto L68;
        this.m.setVisibility(0);
        this.l.setVisibility(0);
        TextView r26 = this.i;
        yd3.m r27 = this.a;
        if (r27 == null) goto L66;
        yd3.c r28 = r27.e();
        if (r28 == null) goto L66;
        String r29 = r28.a();
    L67:
        r26.setText(r29);
    L66:
        r29 = null;
        goto L67
    L57:
        if (r21.intValue() != 5) goto L60;
    L59:
        r5 = false;
        goto L60
    L53:
        if (r21.intValue() == 4) goto L59;
    L49:
        if (r21.intValue() == 7) goto L59;
    L45:
        if (r21.intValue() == 6) goto L59;
    L37:
        r21 = null;
        goto L38
    L19:
        r14 = null;
    L15:
        r4 = null;
        goto L16
    L9:
        r11 = null;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    public PanelsNodeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.q = new d(this, r2);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560635, this, true);
        this.g = (ViewGroup) findViewById(2131381906);
        View r5 = findViewById(2131381912);
        this.h = r5;
        this.n = (ImageView) findViewById(2131381915);
        this.j = findViewById(2131381908);
        this.l = findViewById(2131381909);
        View r6 = findViewById(2131381913);
        this.m = r6;
        int r7 = ECSdk.a;
        s83.g r8 = (s83.g) ECSdk.a(s83.g.class);
        if (r8 == null) goto L8;
        if (r6 == null) goto L7;
        r8.k0((ViewGroup) r6);
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L8:
        r5.setOnClickListener(new a(this));
        this.i = (TextView) findViewById(2131381910);
    }

    public /* synthetic */ PanelsNodeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
