package com.bytedance.android.shopping.product.flow.banner;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import yg3.c;
import yg3.d;
import yg3.e;
import yg3.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u000202¢\u0006\u0004\b]\u0010^J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R.\u00101\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010E\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010<\u001a\u0004\bC\u0010>\"\u0004\bD\u0010@R\u0017\u0010H\u001a\u0002028\u0006¢\u0006\f\n\u0004\bF\u00104\u001a\u0004\bG\u00106R.\u0010P\u001a\u0004\u0018\u00010I2\b\u0010*\u001a\u0004\u0018\u00010I8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR.\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010*\u001a\u0004\u0018\u00010Q8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006_"}, d2 = {"Lcom/bytedance/android/shopping/product/flow/banner/BannerView;", "Landroid/widget/FrameLayout;", "Lyg3/c;", "IBannerIndicator", "", "setIndicator", "Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder;", "getVideoBannerHolder", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "getViewPager", "()Landroidx/recyclerview/widget/RecyclerView;", "viewPager", "Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "b", "Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "getAdapter", "()Lcom/bytedance/android/shopping/product/flow/banner/BannerAdapter;", "adapter", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "c", "Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "getSnapHelper", "()Lcom/bytedance/android/shopping/product/flow/banner/OverScrollPagerSnapHelper;", "snapHelper", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "images", "Landroidx/recyclerview/widget/OrientationHelper;", "e", "Landroidx/recyclerview/widget/OrientationHelper;", "getOrientationHelper", "()Landroidx/recyclerview/widget/OrientationHelper;", "orientationHelper", "Lyg3/e;", "value", "h", "Lyg3/e;", "getOnOverScrollListener", "()Lyg3/e;", "setOnOverScrollListener", "(Lyg3/e;)V", "onOverScrollListener", "", "i", "I", "getCurPagePos", "()I", "setCurPagePos", "(I)V", "curPagePos", "", "j", "Z", "getShouldJump", "()Z", "setShouldJump", "(Z)V", "shouldJump", "k", "getCanPullLeft", "setCanPullLeft", "canPullLeft", "l", "getThreshold", "threshold", "Lyg3/d;", "m", "Lyg3/d;", "getOnItemClickListener", "()Lyg3/d;", "setOnItemClickListener", "(Lyg3/d;)V", "onItemClickListener", "Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;", "onVolumeClickListener", "Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;", "getOnVolumeClickListener", "()Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;", "setOnVolumeClickListener", "(Lcom/bytedance/android/shopping/product/flow/banner/VideoBannerHolder$d;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerView extends FrameLayout {
    public final RecyclerView a;
    public final BannerAdapter b;
    public final OverScrollPagerSnapHelper c;
    public List<? extends ECUrlModel> d;
    public final OrientationHelper e;
    public final LinkedList<f> f;
    public c g;
    public e h;
    public int i;
    public boolean j;
    public boolean k;
    public final int l;
    public d m;

    public static final class a implements f {
        public final /* synthetic */ BannerView a;

        @Override // yg3.f
        public final void a(ECDraweeView r1) {
        }

        public a(BannerView r1) {
            this.a = r1;
        }

        @Override // yg3.f
        public final void onPageSelected(int r2, boolean r3) {
            BannerView r4 = this.a;
            c r0 = r4.g;
            if (r0 == null) goto L6;
            r0.a(r2, r4.getAdapter().getItemCount() - 1);
        L6:
            if (this.a.getAdapter().d == null) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == false) goto L14;
            if (r2 != 0) goto L12;
            this.a.b();
            return;
        L12:
            this.a.a();
            return;
        L14:
            return;
        L8:
            r5 = false;
            goto L9
        }
    }

    public BannerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BannerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final VideoBannerHolder.d getOnVolumeClickListener() {
        return null;
    }

    private final VideoBannerHolder getVideoBannerHolder() {
        if (this.b.d == null) goto L5;
        boolean r0 = true;
    L6:
        RecyclerView.ViewHolder r2 = null;
        if (r0 == false) goto L14;
        RecyclerView.ViewHolder r1 = this.a.findViewHolderForAdapterPosition(0);
        if ((r1 instanceof VideoBannerHolder) == false) goto L13;
        r2 = r1;
    L13:
        return (VideoBannerHolder) r2;
    L14:
        return null;
    L5:
        r0 = false;
        goto L6
    }

    public final void b() {
        if (this.i != 0) goto L10;
        VideoBannerHolder r0 = getVideoBannerHolder();
        if (r0 == null) goto L11;
        r0.b.setVisibility(8);
        ECVideoPlayer r1 = r0.a;
        if (r1 == null) goto L12;
        r1.k();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void a() {
        VideoBannerHolder r0 = getVideoBannerHolder();
        if (r0 == null) goto L8;
        ECVideoPlayer r1 = r0.a;
        if (r1 == null) goto L9;
        r1.j();
        return;
    L9:
        return;
    }

    public final BannerAdapter getAdapter() {
        return this.b;
    }

    public final boolean getCanPullLeft() {
        return this.k;
    }

    public final int getCurPagePos() {
        return this.i;
    }

    public final List<ECUrlModel> getImages() {
        return this.d;
    }

    public final d getOnItemClickListener() {
        return this.m;
    }

    public final e getOnOverScrollListener() {
        return this.h;
    }

    public final OrientationHelper getOrientationHelper() {
        return this.e;
    }

    public final boolean getShouldJump() {
        return this.j;
    }

    public final OverScrollPagerSnapHelper getSnapHelper() {
        return this.c;
    }

    public final int getThreshold() {
        return this.l;
    }

    public final RecyclerView getViewPager() {
        return this.a;
    }

    public final void setCanPullLeft(boolean r1) {
        this.k = r1;
    }

    public final void setCurPagePos(int r1) {
        this.i = r1;
    }

    public final void setImages(List<? extends ECUrlModel> r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setIndicator(c r2) {
        Intrinsics.checkNotNullParameter(r2, "IBannerIndicator");
        addView((View) r2);
        this.g = r2;
        if (r2 == 0) goto L6;
        r2.b(this);
        return;
    }

    public final void setOnItemClickListener(d r2) {
        this.b.c = r2;
        this.m = r2;
    }

    public final void setOnOverScrollListener(e r2) {
        this.c.a = r2;
        this.h = r2;
    }

    public final void setOnVolumeClickListener(VideoBannerHolder.d r1) {
        getVideoBannerHolder();
        this.b.getClass();
    }

    public final void setShouldJump(boolean r1) {
        this.j = r1;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r1);
    }

    public BannerView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        RecyclerView r8 = new RecyclerView(r5);
        this.a = r8;
        LinkedList<f> r9 = new LinkedList();
        this.f = r9;
        this.k = true;
        Resources r2 = Resources.getSystem();
        this.l = MathKt.roundToInt(TypedValue.applyDimension(1, 26, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        addView(r8, new FrameLayout.LayoutParams(-1, -1));
        BannerAdapter r0 = new BannerAdapter();
        this.b = r0;
        r8.setAdapter(r0);
        r8.setLayoutManager(new LinearLayoutManager(r5, 0, false));
        OverScrollPagerSnapHelper r10 = new OverScrollPagerSnapHelper();
        this.c = r10;
        r10.attachToRecyclerView(r8);
        this.e = OrientationHelper.createOrientationHelper(r8.getLayoutManager(), 0);
        r8.setNestedScrollingEnabled(false);
        r8.addOnScrollListener(new AnonymousClass1(this));
        a r11 = new a(this);
        Intrinsics.checkNotNullParameter(r11, "onPageChangeListener");
        r9.add(r11);
    }

    public /* synthetic */ BannerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
