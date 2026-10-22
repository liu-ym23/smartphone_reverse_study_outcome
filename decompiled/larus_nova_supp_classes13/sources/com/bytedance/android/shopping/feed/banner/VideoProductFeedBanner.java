package com.bytedance.android.shopping.feed.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SpecDetail;
import com.bytedance.android.shopping.feed.utils.f0;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import com.bytedance.android.shopping.feed.widget.InflowSkuWidget;
import com.bytedance.android.shopping.inflow.view.InFlowNumberBannerIndicatorView;
import com.bytedance.android.shopping.inflow.view.MainCardImageBannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerAdapter;
import com.bytedance.android.shopping.product.flow.banner.BannerHolder;
import com.bytedance.android.shopping.product.flow.banner.OverScrollPagerSnapHelper;
import com.bytedance.android.shopping.product.flow.indicator.DefaultBannerIndicatorView;
import com.bytedance.android.shopping.product.flow.indicator.MediaBannerIndicatorView;
import com.bytedance.android.shopping.widget.banner.BannerRecyclerView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.e;
import yg3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B.\b\u0007\u0012\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001\u0012\f\b\u0002\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008d\u0001\u0012\t\b\u0002\u0010\u008f\u0001\u001a\u00020\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010)\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R*\u0010>\u001a\n\u0012\u0004\u0012\u000207\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0017\u0010L\u001a\u00020G8\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\"\u0010T\u001a\u00020M8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\\\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010W\u001a\u0004\b^\u0010Y\"\u0004\b_\u0010[R\"\u0010b\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\ba\u0010W\u001a\u0004\bb\u0010Y\"\u0004\bc\u0010[R.\u0010l\u001a\u0004\u0018\u00010d2\b\u0010e\u001a\u0004\u0018\u00010d8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010s\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010w\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010W\u001a\u0004\bu\u0010Y\"\u0004\bv\u0010[R\"\u0010{\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010W\u001a\u0004\by\u0010Y\"\u0004\bz\u0010[R\u0017\u0010~\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b|\u0010n\u001a\u0004\b}\u0010pR5\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010e\u001a\u0004\u0018\u00010\u007f8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R&\u0010\u008a\u0001\u001a\u00020U8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010W\u001a\u0005\b\u0088\u0001\u0010Y\"\u0005\b\u0089\u0001\u0010[¨\u0006\u0092\u0001"}, d2 = {"Lcom/bytedance/android/shopping/feed/banner/VideoProductFeedBanner;", "Landroid/widget/FrameLayout;", "", "angle", "", "setInterceptAngle", "", "getCurImageUrl", "getFirstImgUrl", "Landroid/view/View;", "getCenterView", "Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "a", "Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "getViewPager", "()Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "viewPager", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/product/flow/banner/BannerHolder;", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "c", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "getSnapHelper", "()Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "snapHelper", "Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "d", "Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "getMediaIndicator", "()Lcom/bytedance/android/shopping/product/flow/indicator/MediaBannerIndicatorView;", "mediaIndicator", "Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "e", "Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "getImageIndicator", "()Lcom/bytedance/android/shopping/product/flow/indicator/DefaultBannerIndicatorView;", "imageIndicator", "Lcom/bytedance/android/shopping/inflow/view/InFlowNumberBannerIndicatorView;", "f", "Lcom/bytedance/android/shopping/inflow/view/InFlowNumberBannerIndicatorView;", "getNumberIndicator", "()Lcom/bytedance/android/shopping/inflow/view/InFlowNumberBannerIndicatorView;", "numberIndicator", "Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "g", "Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "getProgressBar", "()Lcom/bytedance/android/shopping/feed/banner/ImageSlideListProgressBar;", "progressBar", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "h", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "images", "Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "j", "Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "getSkuWidget", "()Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;", "setSkuWidget", "(Lcom/bytedance/android/shopping/feed/widget/InflowSkuWidget;)V", "skuWidget", "Landroidx/recyclerview/widget/OrientationHelper;", "k", "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper", "Lcom/bytedance/android/shopping/feed/banner/d;", "l", "Lcom/bytedance/android/shopping/feed/banner/d;", "getConfig", "()Lcom/bytedance/android/shopping/feed/banner/d;", "setConfig", "(Lcom/bytedance/android/shopping/feed/banner/d;)V", "config", "", "m", "Z", "getStopByDrag", "()Z", "setStopByDrag", "(Z)V", "stopByDrag", "n", "getCancelProgressTask", "setCancelProgressTask", "cancelProgressTask", "o", "isAutoSlide", "setAutoSlide", "Lyg3/e;", "value", "s", "Lyg3/e;", "getOnOverScrollListener", "()Lyg3/e;", "setOnOverScrollListener", "(Lyg3/e;)V", "onOverScrollListener", "t", "I", "getCurPagePos", "()I", "setCurPagePos", "(I)V", "curPagePos", "u", "getShouldJump", "setShouldJump", "shouldJump", "v", "getCanPullLeft", "setCanPullLeft", "canPullLeft", "w", "getThreshold", "threshold", "Lyg3/d;", "x", "Lyg3/d;", "getOnItemClickListener", "()Lyg3/d;", "setOnItemClickListener", "(Lyg3/d;)V", "onItemClickListener", "y", "getIndicatorNewStyleAB", "setIndicatorNewStyleAB", "indicatorNewStyleAB", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoProductFeedBanner extends FrameLayout {
    public final BannerRecyclerView a;
    public final RecyclerView.Adapter<BannerHolder> b;
    public final OverScrollPagerSnapHelper c;
    public final MediaBannerIndicatorView d;
    public final DefaultBannerIndicatorView e;
    public final InFlowNumberBannerIndicatorView f;
    public final ImageSlideListProgressBar g;
    public List<? extends ECUrlModel> h;
    public int i;
    public InflowSkuWidget j;
    public final OrientationHelper k;
    public com.bytedance.android.shopping.feed.banner.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final LinkedList<f> p;
    public rd3.a q;
    public final boolean r;
    public e s;
    public int t;
    public boolean u;
    public boolean v;
    public final int w;
    public yg3.d x;
    public boolean y;
    public final com.bytedance.android.shopping.feed.banner.c z;

    public static final class a implements com.bytedance.android.shopping.feed.banner.b {
        public final /* synthetic */ VideoProductFeedBanner a;

        @Override // com.bytedance.android.shopping.feed.banner.b
        public final void b() {
            VideoProductFeedBanner r0 = this.a;
            if (r0.o == false) goto L5;
            r0.o = false;
        L5:
            r0.l.getClass();
        }

        public a(VideoProductFeedBanner r1) {
            this.a = r1;
        }
    }

    public static final class b implements f {
        public final /* synthetic */ VideoProductFeedBanner a;

        @Override // yg3.f
        public final void a(ECDraweeView r1) {
        }

        public b(VideoProductFeedBanner r1) {
            this.a = r1;
        }

        @Override // yg3.f
        public final void onPageSelected(int r3, boolean r4) {
            if (r3 <= 0) goto L9;
            rd3.a r0 = this.a.q;
            if (r0 == null) goto L9;
            ProductFeedViewModel r1 = r0.c;
            if (r1 == null) goto L9;
            r1.setSlideHeadImage(true);
        L9:
            this.a.setCurPagePos(r3);
            rd3.a r2 = this.a.q;
            if (r2 != null) goto L12;
        L13:
            if (r2 == null) goto L17;
            ProductFeedViewModel r5 = r2.c;
            if (r5 == null) goto L17;
            r5.setHeadImagePos(r3);
        L17:
            this.a.getConfig().getClass();
            int r6 = 0;
            if (this.a.getIndicatorNewStyleAB() == false) goto L36;
            List<ECUrlModel> r7 = this.a.getImages();
            if (r7 == null) goto L22;
            r6 = r7.size() - this.a.i;
        L22:
            if (r3 < r6) goto L33;
            int r8 = r3 - r6;
            this.a.getNumberIndicator().a(r8, this.a.i);
            InflowSkuWidget r9 = this.a.getSkuWidget();
            if (r9 == null) goto L41;
            if (r8 < 0) goto L42;
            List<SpecDetail> r10 = r9.f.a;
            if (r10 == null) goto L31;
            SpecDetail r11 = (SpecDetail) CollectionsKt.getOrNull(r10, r8);
            if (r11 == null) goto L31;
            Long r12 = Long.valueOf(r11.getSpecDetailId());
        L32:
            r9.a(String.valueOf(r12));
            return;
        L31:
            r12 = null;
            goto L32
        L42:
            return;
        L41:
            return;
        L33:
            this.a.getNumberIndicator().a(r3, r6);
            InflowSkuWidget r13 = this.a.getSkuWidget();
            if (r13 == null) goto L44;
            r13.a("");
            return;
        L44:
            return;
        L36:
            DefaultBannerIndicatorView r14 = this.a.getImageIndicator();
            List<ECUrlModel> r15 = this.a.getImages();
            if (r15 == null) goto L39;
            r6 = r15.size();
        L39:
            r14.c(r3, r6);
            return;
        L12:
            if (r2.e == true) goto L17;
            goto L13
        }
    }

    public static final class c {
    }

    public static final class d implements com.bytedance.android.shopping.feed.banner.c.a {
        public final /* synthetic */ VideoProductFeedBanner a;

        @Override // com.bytedance.android.shopping.feed.banner.c.a
        public final void a() {
            this.a.getConfig().getClass();
        }

        public d(VideoProductFeedBanner r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.feed.banner.c.a
        public final void b(float r4, float r5) {
            VideoProductFeedBanner r6 = this.a;
            r6.getCurPagePos();
            r6.l.getClass();
            if (r4 != 100.0f) goto L21;
            VideoProductFeedBanner r7 = this.a;
            if (r7.o == true) goto L7;
            r7.o = true;
        L7:
            List<? extends ECUrlModel> r8 = r7.h;
            if (r8 == null) goto L10;
            int r9 = r8.size();
        L11:
            int r2 = r7.t + 1;
            if (r2 > (r9 - 1)) goto L14;
            r7.a.smoothScrollToPosition(r2);
        L15:
            List<ECUrlModel> r10 = this.a.getImages();
            if (r10 != null) goto L18;
            return;
        L18:
            if (this.a.getCurPagePos() == (r10.size() - 1)) goto L23;
            VideoProductFeedBanner r11 = this.a;
            r11.setCurPagePos(r11.getCurPagePos() + 1);
            return;
        L23:
            return;
        L14:
            com.bytedance.android.shopping.feed.banner.c r12 = r7.z;
            r12.e = false;
            r12.f = false;
            r12.g = 0.0f;
            r12.a();
            r7.n = true;
            goto L15
        L10:
            r9 = 0;
            goto L11
        }
    }

    static {
    }

    public VideoProductFeedBanner(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoProductFeedBanner(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View getCenterView() {
        return f0.a(this.a, this.k, null);
    }

    public final String getCurImageUrl() {
        String r1 = null;
        if (this.r == false) goto L10;
        RecyclerView.Adapter<BannerHolder> r0 = this.b;
        if ((r0 instanceof MainCardImageBannerAdapter) == true) goto L7;
        r0 = null;
    L7:
        MainCardImageBannerAdapter r2 = (MainCardImageBannerAdapter) r0;
        if (r2 == null) goto L16;
        List<? extends ECUrlModel> r3 = r2.a;
    L17:
        if (r3 == null) goto L22;
        ECUrlModel r4 = (ECUrlModel) CollectionsKt.getOrNull(r3, this.t);
        if (r4 == null) goto L22;
        r1 = r4.getFirstUrl();
    L22:
        return String.valueOf(r1);
    L16:
        r3 = null;
        goto L17
    L10:
        RecyclerView.Adapter<BannerHolder> r5 = this.b;
        if ((r5 instanceof BannerAdapter) == true) goto L13;
        r5 = null;
    L13:
        BannerAdapter r6 = (BannerAdapter) r5;
        if (r6 == null) goto L16;
        r3 = r6.a;
        goto L17
    }

    public final String getFirstImgUrl() {
        String r1 = null;
        if (this.r == false) goto L10;
        RecyclerView.Adapter<BannerHolder> r0 = this.b;
        if ((r0 instanceof MainCardImageBannerAdapter) == true) goto L7;
        r0 = null;
    L7:
        MainCardImageBannerAdapter r2 = (MainCardImageBannerAdapter) r0;
        if (r2 == null) goto L16;
        List<? extends ECUrlModel> r3 = r2.a;
    L17:
        if (r3 == null) goto L22;
        ECUrlModel r4 = (ECUrlModel) CollectionsKt.getOrNull(r3, 0);
        if (r4 == null) goto L22;
        r1 = r4.getFirstUrl();
    L22:
        return String.valueOf(r1);
    L16:
        r3 = null;
        goto L17
    L10:
        RecyclerView.Adapter<BannerHolder> r5 = this.b;
        if ((r5 instanceof BannerAdapter) == true) goto L13;
        r5 = null;
    L13:
        BannerAdapter r6 = (BannerAdapter) r5;
        if (r6 == null) goto L16;
        r3 = r6.a;
        goto L17
    }

    public final RecyclerView.Adapter<BannerHolder> getAdapter() {
        return this.b;
    }

    public final boolean getCanPullLeft() {
        return this.v;
    }

    public final boolean getCancelProgressTask() {
        return this.n;
    }

    public final com.bytedance.android.shopping.feed.banner.d getConfig() {
        return this.l;
    }

    public final int getCurPagePos() {
        return this.t;
    }

    public final DefaultBannerIndicatorView getImageIndicator() {
        return this.e;
    }

    public final List<ECUrlModel> getImages() {
        return this.h;
    }

    public final boolean getIndicatorNewStyleAB() {
        return this.y;
    }

    public final MediaBannerIndicatorView getMediaIndicator() {
        return this.d;
    }

    public final InFlowNumberBannerIndicatorView getNumberIndicator() {
        return this.f;
    }

    public final yg3.d getOnItemClickListener() {
        return this.x;
    }

    public final e getOnOverScrollListener() {
        return this.s;
    }

    public final OrientationHelper getOrientationHelper() {
        return this.k;
    }

    public final ImageSlideListProgressBar getProgressBar() {
        return this.g;
    }

    public final boolean getShouldJump() {
        return this.u;
    }

    public final InflowSkuWidget getSkuWidget() {
        return this.j;
    }

    public final OverScrollPagerSnapHelper getSnapHelper() {
        return this.c;
    }

    public final boolean getStopByDrag() {
        return this.m;
    }

    public final int getThreshold() {
        return this.w;
    }

    public final BannerRecyclerView getViewPager() {
        return this.a;
    }

    public final void setAutoSlide(boolean r1) {
        this.o = r1;
    }

    public final void setCanPullLeft(boolean r1) {
        this.v = r1;
    }

    public final void setCancelProgressTask(boolean r1) {
        this.n = r1;
    }

    public final void setConfig(com.bytedance.android.shopping.feed.banner.d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    public final void setCurPagePos(int r1) {
        this.t = r1;
    }

    public final void setImages(List<? extends ECUrlModel> r1) {
        this.h = r1;
    }

    public final void setIndicatorNewStyleAB(boolean r1) {
        this.y = r1;
    }

    public final void setInterceptAngle(int r2) {
        this.a.setInterceptAngle(r2);
    }

    public final void setOnItemClickListener(yg3.d r4) {
        RecyclerView.Adapter<BannerHolder> r1 = null;
        if (this.r == false) goto L11;
        RecyclerView.Adapter<BannerHolder> r0 = this.b;
        if ((r0 instanceof MainCardImageBannerAdapter) == false) goto L8;
        r1 = r0;
    L8:
        MainCardImageBannerAdapter r2 = (MainCardImageBannerAdapter) r1;
        if (r2 == null) goto L18;
        r2.d = r4;
    L18:
        this.x = r4;
        return;
    L11:
        RecyclerView.Adapter<BannerHolder> r3 = this.b;
        if ((r3 instanceof BannerAdapter) == false) goto L15;
        r1 = r3;
    L15:
        BannerAdapter r5 = (BannerAdapter) r1;
        if (r5 == null) goto L18;
        r5.c = r4;
        goto L18
    }

    public final void setOnOverScrollListener(e r2) {
        this.c.a = r2;
        this.s = r2;
    }

    public final void setShouldJump(boolean r1) {
        this.u = r1;
    }

    public final void setSkuWidget(InflowSkuWidget r1) {
        this.j = r1;
    }

    public final void setStopByDrag(boolean r1) {
        this.m = r1;
    }

    public VideoProductFeedBanner(Context r11, AttributeSet r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        super(r11, r12, r13);
        this.l = new com.bytedance.android.shopping.feed.banner.d();
        LinkedList<f> r14 = new LinkedList();
        this.p = r14;
        boolean r15 = ld3.d.e(ld3.d.b());
        this.r = r15;
        this.v = true;
        Resources r2 = Resources.getSystem();
        this.w = MathKt.roundToInt(TypedValue.applyDimension(1, 26, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        d r1 = new d(this);
        com.bytedance.android.shopping.feed.banner.c r3 = new com.bytedance.android.shopping.feed.banner.c();
        r3.d = r1;
        Unit r4 = Unit.INSTANCE;
        this.z = r3;
        if (ld3.b.a() == false) goto L5;
        Map r5 = ShoppingAsyncCacheInflater.d;
        ShoppingAsyncCacheInflater.a.a(r11).aU(2131560587, this, true);
    L6:
        BannerRecyclerView r6 = findViewById(2131392567);
        this.a = r6;
        this.d = (MediaBannerIndicatorView) findViewById(2131379788);
        DefaultBannerIndicatorView r7 = (DefaultBannerIndicatorView) findViewById(2131381801);
        this.e = r7;
        InFlowNumberBannerIndicatorView r8 = (InFlowNumberBannerIndicatorView) findViewById(2131381076);
        this.f = r8;
        if (ld3.d.e(ld3.d.b()) == false) goto L21;
        ViewGroup.LayoutParams r9 = r7.getLayoutParams();
        ViewGroup.LayoutParams r10 = null;
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == true) goto L11;
        r9 = null;
    L11:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r9;
        if (r16 == null) goto L14;
        Resources r17 = Resources.getSystem();
        r16.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r17, r17.getDisplayMetrics())));
        r7.setLayoutParams(r16);
    L14:
        ViewGroup.LayoutParams r18 = r8.getLayoutParams();
        if ((r18 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r10 = r18;
    L18:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r10;
        if (r19 == null) goto L21;
        Resources r20 = Resources.getSystem();
        r19.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics())));
        r8.setLayoutParams(r19);
    L21:
        this.g = (ImageSlideListProgressBar) findViewById(2131392573);
        if (r15 == false) goto L24;
        RecyclerView.Adapter<BannerHolder> r110 = new MainCardImageBannerAdapter();
    L25:
        this.b = r110;
        r6.setAdapter(r110);
        SlowScrollLinearLayoutManager r111 = new SlowScrollLinearLayoutManager(r11);
        r111.a *= 2.5f;
        r6.setLayoutManager(r111);
        OverScrollPagerSnapHelper r112 = new OverScrollPagerSnapHelper();
        this.c = r112;
        r112.attachToRecyclerView(r6);
        this.k = OrientationHelper.createOrientationHelper(r6.getLayoutManager(), 0);
        r6.setNestedScrollingEnabled(false);
        r6.addOnScrollListener(new VideoProductFeedBanner$$special$$inlined$apply$lambda$1(this));
        r6.setScrollByDragListener(new a(this));
        b r113 = new b(this);
        Intrinsics.checkNotNullParameter(r113, "onPageChangeListener");
        r14.add(r113);
        return;
    L24:
        r110 = new BannerAdapter();
        goto L25
    L5:
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r11).aU(2131560587, this, true);
        goto L6
    }

    public /* synthetic */ VideoProductFeedBanner(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
