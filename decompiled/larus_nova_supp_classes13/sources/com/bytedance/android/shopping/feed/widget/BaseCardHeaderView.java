package com.bytedance.android.shopping.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.response.anchorv3.ProductSpecInfoStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.dto.InnerFlowPageStyleDTO;
import com.bytedance.android.shopping.anchorv3.repository.dto.PageStyle;
import com.bytedance.android.shopping.feed.banner.VideoProductFeedBanner;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.event.k1;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.inflow.view.MainCardImageBannerAdapter;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.product.flow.banner.BannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jd3.w0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010Z\u001a\u00020Y\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010[\u0012\b\b\u0002\u0010]\u001a\u00020\u0002¢\u0006\u0004\b^\u0010_J\b\u0010\u0003\u001a\u00020\u0002H&R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010/\u001a\u00020,8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u00020\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010A\u001a\u0004\u0018\u00010:8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@Ro\u0010P\u001aO\u0012\u0013\u0012\u00110\u0014¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(G\u0012\u0015\u0012\u0013\u0018\u00010F¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(H\u0012\u0006\u0012\u0004\u0018\u00010I\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010T\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0016\u001a\u0004\bR\u0010\u0018\"\u0004\bS\u0010\u001aR$\u0010X\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010\u001e\u001a\u0004\bV\u0010 \"\u0004\bW\u0010\"¨\u0006`"}, d2 = {"Lcom/bytedance/android/shopping/feed/widget/BaseCardHeaderView;", "Landroid/widget/FrameLayout;", "", "getLayoutResId", "Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "a", "Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "getViewModel", "()Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;", "setViewModel", "(Lcom/bytedance/android/shopping/feed/viewmodel/ProductFeedViewModel;)V", "viewModel", "Lcom/bytedance/android/shopping/feed/banner/VideoProductFeedBanner;", "b", "Lcom/bytedance/android/shopping/feed/banner/VideoProductFeedBanner;", "getVideoProductFeedBanner", "()Lcom/bytedance/android/shopping/feed/banner/VideoProductFeedBanner;", "setVideoProductFeedBanner", "(Lcom/bytedance/android/shopping/feed/banner/VideoProductFeedBanner;)V", "videoProductFeedBanner", "Landroid/view/View;", "d", "Landroid/view/View;", "getTagInfoView", "()Landroid/view/View;", "setTagInfoView", "(Landroid/view/View;)V", "tagInfoView", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "e", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "getDvTagIconView", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "setDvTagIconView", "(Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;)V", "dvTagIconView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "getTvTagText", "()Landroid/widget/TextView;", "setTvTagText", "(Landroid/widget/TextView;)V", "tvTagText", "", "g", "Z", "isPicSliderEventRecorded", "()Z", "setPicSliderEventRecorded", "(Z)V", "h", "Landroid/widget/FrameLayout;", "getContainer", "()Landroid/widget/FrameLayout;", "setContainer", "(Landroid/widget/FrameLayout;)V", "container", "Lcom/bytedance/android/shopping/feed/widget/v;", "i", "Lcom/bytedance/android/shopping/feed/widget/v;", "getData", "()Lcom/bytedance/android/shopping/feed/widget/v;", "setData", "(Lcom/bytedance/android/shopping/feed/widget/v;)V", "data", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", FreqActions.ACTION_VIEW, "", "actionType", "clickArea", "", "j", "Lkotlin/jvm/functions/Function3;", "getDetailOnClickListener", "()Lkotlin/jvm/functions/Function3;", "setDetailOnClickListener", "(Lkotlin/jvm/functions/Function3;)V", "detailOnClickListener", "l", "getNewSameProductEntranceView", "setNewSameProductEntranceView", "newSameProductEntranceView", "m", "getSelectImageView", "setSelectImageView", "selectImageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseCardHeaderView extends FrameLayout {
    public ProductFeedViewModel a;
    public VideoProductFeedBanner b;
    public final ViewGroup c;
    public View d;
    public ECDraweeView e;
    public TextView f;
    public boolean g;
    public FrameLayout h;
    public v i;
    public Function3<? super View, ? super String, ? super String, Unit> j;
    public final com.bytedance.android.shopping.feed.banner.d k;
    public View l;
    public ECDraweeView m;

    public static final class a implements yg3.e {
        public final /* synthetic */ BaseCardHeaderView a;

        @Override // yg3.e
        public final void g() {
            Function3<View, String, String, Unit> r0 = this.a.getDetailOnClickListener();
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke(this.a, "draw", null);
            return;
        }

        public a(BaseCardHeaderView r1) {
            this.a = r1;
        }
    }

    public static final class b implements yg3.f {
        public final /* synthetic */ BaseCardHeaderView a;
        public final /* synthetic */ Context b;

        @Override // yg3.f
        public final void a(ECDraweeView r2) {
            this.a.setSelectImageView(r2);
        }

        public b(BaseCardHeaderView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // yg3.f
        public final void onPageSelected(int r9, boolean r10) {
            if (r9 <= 0) goto L71;
            FeedProductEventTracker r0 = FeedProductEventTracker.a;
            Context r1 = this.b;
            v r2 = this.a.getData();
            String r3 = null;
            if (r2 == null) goto L14;
            rd3.a r4 = r2.b;
            if (r4 == null) goto L14;
            Promotion r5 = r4.f();
            if (r5 == null) goto L14;
            PromotionProductStruct r6 = r5.getPromotionInfo();
            if (r6 == null) goto L14;
            PromotionProductBaseStruct r7 = r6.getBaseInfo();
            if (r7 == null) goto L14;
            String r8 = r7.getProductId();
        L15:
            if (r10 == false) goto L17;
            String r11 = "auto";
        L18:
            Integer r12 = Integer.valueOf(r9);
            v r13 = this.a.getData();
            String r14 = "guess_you_like_product";
            if (r13 == null) goto L25;
            rd3.a r15 = r13.b;
            if (r15 == null) goto L25;
            if (r15.e != true) goto L25;
            String r16 = "guess_you_like_product";
        L26:
            r0.getClass();
            k1 r17 = new k1();
            r17.a = r8;
            r17.b = r16;
            r17.c = r11;
            boolean r18 = false;
            if (r12 != null) goto L30;
        L32:
            int r19 = 0;
        L33:
            r17.d = r19;
            com.bytedance.android.shopping.feed.event.g.d(r17, r1);
            BaseCardHeaderView r20 = this.a;
            if (r20.g == true) goto L72;
            ProductFeedViewModel r21 = r20.getViewModel();
            if (r21 == null) goto L38;
            AnchorV3Param r22 = r21.m907getAnchorV3Param();
        L39:
            Integer r23 = Integer.valueOf(r9);
            Context r24 = this.b;
            ProductFeedViewModel r25 = this.a.getViewModel();
            if (r25 == null) goto L42;
            r18 = r25.isExpanded();
        L42:
            v r26 = this.a.getData();
            if (r26 == null) goto L49;
            rd3.a r27 = r26.b;
            if (r27 == null) goto L49;
            if (r27.e != true) goto L49;
        L50:
            v r28 = this.a.getData();
            if (r28 == null) goto L61;
            rd3.a r29 = r28.b;
            if (r29 == null) goto L61;
            Promotion r30 = r29.f();
            if (r30 == null) goto L61;
            PromotionProductStruct r31 = r30.getPromotionInfo();
            if (r31 == null) goto L61;
            PromotionProductBaseStruct r32 = r31.getBaseInfo();
            if (r32 == null) goto L61;
            String r33 = r32.getProductId();
        L62:
            List r34 = CollectionsKt.mutableListOf(new String[]{PdpOpenThirdParam.KEY_PRODUCT_ID});
            int r35 = com.bytedance.android.ec.core.anchorv3.a.a;
            int r36 = a63.a.a;
            int r37 = com.bytedance.android.ec.core.opt.ab.c.a;
            w0 r38 = new w0();
            r38.b = r23;
            if (r22 == null) goto L65;
            r3 = r22.getSearchId();
        L65:
            r38.c = r3;
            if (r18 == false) goto L68;
            String r39 = "full_screen";
        L69:
            r38.d = r39;
            r38.e = r14;
            r38.a = r33;
            com.bytedance.android.ec.core.anchorv3.b.a(r38, r24, r34);
            this.a.setPicSliderEventRecorded(true);
            return;
        L68:
            r39 = "half_screen";
        L61:
            r33 = null;
        L49:
            r14 = null;
            goto L50
        L38:
            r22 = null;
            goto L39
        L72:
            return;
        L30:
            if (r12.intValue() != 1) goto L32;
            r19 = 1;
        L25:
            r16 = null;
            goto L26
        L17:
            r11 = "nonauto";
        L14:
            r8 = null;
            goto L15
        }
    }

    public static final class c implements yg3.d {
        public final /* synthetic */ BaseCardHeaderView a;

        public c(BaseCardHeaderView r1) {
            this.a = r1;
        }

        @Override // yg3.d
        public final void a(int r3, View r4) {
            Intrinsics.checkNotNullParameter(r4, "v");
            v r5 = this.a.getData();
            if (r5 == null) goto L5;
            rd3.a r6 = r5.b;
        L6:
            if (r6 == null) goto L11;
            Function3<View, String, String, Unit> r7 = this.a.getDetailOnClickListener();
            if (r7 == null) goto L12;
            Unit r8 = (Unit) r7.invoke(this.a, "click", "pic");
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ BaseCardHeaderView a;

        public d(BaseCardHeaderView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.getNewSameProductEntranceView();     // Catch: Throwable -> L9
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L9
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r1 = null;
        L5:
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;     // Catch: Throwable -> L9
            if (r2 == null) goto L12;
            r2.bottomMargin = com.bytedance.android.shopping.extensions.b.b(36);     // Catch: Throwable -> L9
            r0.setLayoutParams(r2);     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ BaseCardHeaderView a;

        public static final class a implements ri.a {
            public a() {
            }
        }

        public e(BaseCardHeaderView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            this.a.c();
            Activity r5 = ECAppInfoService.e.getCurrentActivity();
            if (r5 == null) goto L6;
            com.bytedance.android.ec.sdk.helper.h.a.a(r5, this.a.getVideoProductFeedBanner().getCurImageUrl(), new a());
            return;
        }
    }

    public BaseCardHeaderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BaseCardHeaderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public void c() {
    }

    public abstract int getLayoutResId();

    public final FrameLayout getContainer() {
        return this.h;
    }

    public final v getData() {
        return this.i;
    }

    public final Function3<View, String, String, Unit> getDetailOnClickListener() {
        return this.j;
    }

    public final ECDraweeView getDvTagIconView() {
        return this.e;
    }

    public final View getNewSameProductEntranceView() {
        return this.l;
    }

    public final ECDraweeView getSelectImageView() {
        return this.m;
    }

    public final View getTagInfoView() {
        return this.d;
    }

    public final TextView getTvTagText() {
        return this.f;
    }

    public final VideoProductFeedBanner getVideoProductFeedBanner() {
        return this.b;
    }

    public final ProductFeedViewModel getViewModel() {
        return this.a;
    }

    public final void setContainer(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    public final void setData(v r1) {
        this.i = r1;
    }

    public final void setDetailOnClickListener(Function3<? super View, ? super String, ? super String, Unit> r1) {
        this.j = r1;
    }

    public final void setDvTagIconView(ECDraweeView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setNewSameProductEntranceView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void setPicSliderEventRecorded(boolean r1) {
        this.g = r1;
    }

    public final void setSelectImageView(ECDraweeView r1) {
        this.m = r1;
    }

    public final void setTagInfoView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setTvTagText(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setVideoProductFeedBanner(VideoProductFeedBanner r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setViewModel(ProductFeedViewModel r1) {
        this.a = r1;
    }

    public void a(v r8, Function3<? super View, ? super String, ? super String, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r9, "detailOnClickListener");
        this.i = r8;
        rd3.a r0 = r8.b;
        if (r0 == null) goto L5;
        ProductFeedViewModel r1 = r0.c;
    L6:
        this.a = r1;
        this.j = r9;
        VideoProductFeedBanner r10 = this.b;
        r10.setConfig(this.k);
        r10.setIndicatorNewStyleAB(r10.getConfig().a);
        List r11 = r8.a.b;
        ArrayList r2 = new ArrayList();
        r2.addAll(f63.b.a(r11));
        rd3.a r12 = r8.b;
        if (r12 != null) goto L9;
        List r13 = CollectionsKt.emptyList();
    L38:
        r2.addAll(r13);
        VideoProductFeedBanner r3 = this.b;
        ECUrlModel r4 = r8.a.h;
        int r14 = r13.size();
        rd3.a r15 = r8.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r2, "list");
        r3.i = r14;
        r3.q = r15;
        r3.h = r2;
        if (r2.isEmpty() == false) goto L41;
        r3.setVisibility(4);
    L43:
        if (r3.r == false) goto L50;
        RecyclerView.Adapter<BannerHolder> r5 = r3.b;
        if ((r5 instanceof MainCardImageBannerAdapter) == true) goto L47;
        r5 = null;
    L47:
        MainCardImageBannerAdapter r6 = (MainCardImageBannerAdapter) r5;
        if (r6 == null) goto L56;
        r6.a = r2;
        r6.c = r4;
        r6.e = null;
        r6.b = r15;
    L56:
        r3.a.scrollToPosition(0);
        r3.b.notifyDataSetChanged();
        r3.t = 0;
        r3.m = false;
        r3.o = false;
        r3.n = false;
        com.bytedance.android.shopping.feed.banner.c r16 = r3.z;
        r16.g = 0.0f;
        r16.a();
        r3.l.getClass();
        r3.d.setVisibility(8);
        if (r3.y == false) goto L59;
        r3.f.setVisibility(0);
        r3.e.setVisibility(8);
        r3.f.a(0, r2.size() - r14);
        return;
    L59:
        r3.e.setVisibility(0);
        r3.f.setVisibility(8);
        r3.e.c(0, r2.size());
        return;
    L50:
        RecyclerView.Adapter<BannerHolder> r17 = r3.b;
        if ((r17 instanceof BannerAdapter) == true) goto L53;
        r17 = null;
    L53:
        BannerAdapter r18 = (BannerAdapter) r17;
        if (r18 == null) goto L56;
        r18.a = r2;
        r18.b = r4;
        r18.d = null;
        goto L56
    L41:
        r3.setVisibility(0);
        goto L43
    L9:
        Promotion r19 = r12.f();
        if (r19 == null) goto L16;
        PromotionProductStruct r20 = r19.getPromotionInfo();
        if (r20 == null) goto L16;
        PromotionProductBaseStruct r21 = r20.getBaseInfo();
        if (r21 == null) goto L16;
        ProductSpecInfoStruct r22 = r21.getSpecInfo();
    L17:
        if (r22 == null) goto L21;
        List r7 = r22.getSpecList();
        if (r7 == null) goto L21;
        int r23 = r7.size();
    L23:
        if (r23 > 1) goto L25;
        r13 = CollectionsKt.emptyList();
        goto L38
    L25:
        ArrayList r24 = new ArrayList();
        if (r22 == null) goto L37;
        List r25 = r22.getSpecList();
        if (r25 == null) goto L37;
        Iterator r26 = r25.iterator();
    L31:
        if (r26.hasNext() == false) goto L37;
        List r27 = ((SpecDetail) r26.next()).getBigImgList();
        if (r27 == null) goto L31;
        ECUrlModel r28 = (ECUrlModel) CollectionsKt.getOrNull(r27, 0);
        if (r28 == null) goto L31;
        r24.add(r28);
    L37:
        r13 = r24;
    L21:
        r23 = 0;
    L16:
        r22 = null;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public void b(ProductFeedViewModel r1, rd3.a r2) {
        Intrinsics.checkNotNullParameter(r1, "viewModel");
        InnerFlowPageStyleDTO r3 = r1.getInnerFlowPageStyle();
        if (r3 == null) goto L7;
        PageStyle r4 = r3.getPageStyle();
        if (r4 == null) goto L7;
        Integer r5 = r4.getShowCount();
    L8:
        if (r5 != null) goto L11;
    L13:
        this.l.setOnClickListener(new e(this));
        return;
    L11:
        if (r5.intValue() != 1) goto L13;
        this.l.post(new d(this));
    L7:
        r5 = null;
        goto L8
    }

    public BaseCardHeaderView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.k = new com.bytedance.android.shopping.feed.banner.d();
        boolean r6 = ld3.d.e(ld3.d.b());
        if (ld3.b.a() == false) goto L5;
        Map r7 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r3).aU(getLayoutResId(), this, true);
    L6:
        SimpleDraweeView r8 = findViewById(2131380871);
        TextView r9 = (TextView) findViewById(2131380873);
        this.c = (ViewGroup) findViewById(2131380872);
        if (r6 == false) goto L9;
        FrameLayout r10 = (FrameLayout) findViewById(2131367774);
    L10:
        this.h = r10;
        r10.setVisibility(0);
        this.l = findViewById(2131383111);
        this.d = findViewById(2131383112);
        this.e = findViewById(2131383178);
        this.f = (TextView) findViewById(2131383181);
        AttributeSet r0 = null;
        int r1 = 6;
        VideoProductFeedBanner r11 = new VideoProductFeedBanner(r3, r0, r1, 0);
        r11.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        int r2 = ld3.e.a;
        int r12 = ld3.c.a;
        r11.setInterceptAngle(0);
        Unit r13 = Unit.INSTANCE;
        this.b = r11;
        r11.setBackgroundResource(2131109391);
        this.b.setOnOverScrollListener(new a(this));
        VideoProductFeedBanner r14 = this.b;
        b r15 = new b(this, r3);
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "onPageChangeListener");
        r14.p.add(r15);
        this.b.setOnItemClickListener(new c(this));
        this.h.addView(this.b);
        return;
    L9:
        r10 = (FrameLayout) findViewById(2131367728);
        goto L10
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r3).aU(getLayoutResId(), this, true);
        goto L6
    }

    public /* synthetic */ BaseCardHeaderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
