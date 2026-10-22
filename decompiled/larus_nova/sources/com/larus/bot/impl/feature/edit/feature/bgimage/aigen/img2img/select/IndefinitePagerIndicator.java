package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.gaiax.model.GXScroll;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0003\\]^B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\u0018\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J\u0010\u0010/\u001a\u00020)2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u00100\u001a\u00020)2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u00101\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u00102\u001a\u00020)2\u0006\u00103\u001a\u00020\bJ\u000e\u00104\u001a\u00020)2\u0006\u00103\u001a\u00020\bJ\u000e\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020\bJ\u000e\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020\bJ\u000e\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020\bJ\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u001dJ\u000e\u0010<\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010=\u001a\u00020)2\b\b\u0001\u0010>\u001a\u00020\bJ\u0010\u0010?\u001a\u00020)2\b\b\u0001\u0010@\u001a\u00020\bJ&\u0010A\u001a\u00020\"2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020\u001d2\b\b\u0001\u0010E\u001a\u00020\bH\u0002J\u001c\u0010F\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0G2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\bH\u0002J\b\u0010K\u001a\u00020\bH\u0002J\b\u0010L\u001a\u00020\bH\u0002J\u0010\u0010M\u001a\u00020'2\u0006\u0010H\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020\"2\u0006\u0010H\u001a\u00020'H\u0002J\b\u0010O\u001a\u00020\bH\u0002J\u0010\u0010P\u001a\u00020\b2\u0006\u0010Q\u001a\u00020'H\u0002J\b\u0010R\u001a\u00020)H\u0002J\b\u0010S\u001a\u00020\bH\u0002J\b\u0010T\u001a\u00020\u001dH\u0002J\u0010\u0010U\u001a\u00020\b2\u0006\u0010J\u001a\u00020\bH\u0002J \u0010V\u001a\u00020)2\u0006\u0010J\u001a\u00020\b2\u0006\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\bH\u0016J\u0010\u0010Y\u001a\u00020)2\u0006\u0010J\u001a\u00020\bH\u0016J\u0010\u0010Z\u001a\u00020)2\u0006\u0010[\u001a\u00020\bH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0012R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0018\u00010\u0014R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator;", "Landroid/view/View;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "viewPager2", "Landroidx/viewpager2/widget/ViewPager2;", "internalRecyclerScrollListener", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "internalPageChangeCallback", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalPageChangeCallback;", "interpolator", "Landroid/view/animation/DecelerateInterpolator;", "dotCount", "fadingDotCount", "selectedDotRadiusPx", "dotRadiusPx", "dotSeparationDistancePx", "supportRtl", "", "verticalSupport", "dotColor", "selectedDotColor", "selectedDotPaint", "Landroid/graphics/Paint;", "dotPaint", "selectedItemPosition", "intermediateSelectedItemPosition", "offsetPercent", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "attachToRecyclerView", "attachToViewPager", "attachToViewPager2", "setDotCount", "count", "setFadingDotCount", "setSelectedDotRadius", "radius", "setDotRadius", "setDotSeparationDistance", "distance", "setRTLSupport", "supportRTL", "setVerticalSupport", "setDotColor", "newDotColor", "setSelectedDotColor", "newSelectedDotColor", "getDefaultPaintConfig", "defaultStyle", "Landroid/graphics/Paint$Style;", "isAntiAliasDefault", "defaultColor", "getXYPositionsByCoordinate", "Lkotlin/Pair;", "coordinate", "getDotCoordinate", "position", "getDotYCoordinate", "getDistanceBetweenTheCenterOfTwoDots", "getRadius", "getPaint", "getCalculatedWidth", "dpToPx", "dp", "removeAllSources", "getItemCount", "isRtl", "getRTLPosition", "onPageScrolled", "positionOffset", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", "state", "Companion", "InternalRecyclerScrollListener", "InternalPageChangeCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IndefinitePagerIndicator extends View implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f318774r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2 f318775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InternalPageChangeCallback f318776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DecelerateInterpolator f318777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f318778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f318779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f318780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f318781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f318782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f318783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f318784j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f318785k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f318786l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Paint f318787m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f318788n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f318789o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f318790p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f318791q;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "<init>", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator;)V", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InternalPageChangeCallback extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IndefinitePagerIndicator f318792a;

        public InternalPageChangeCallback(IndefinitePagerIndicator r100) {
            this.f318792a = r100;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r100) {
            this.f318792a.onPageSelected(r100);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r100, float r101, int r102) {
            this.f318792a.onPageScrolled(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator$InternalRecyclerScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/IndefinitePagerIndicator;)V", "previousMostVisibleChild", "Landroid/view/View;", GXScroll.TYPE_ON_SCROLLED, "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "getMostVisibleChild", "calculatePercentVisible", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "setIntermediateSelectedItemPosition", "mostVisibleChild", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InternalRecyclerScrollListener extends RecyclerView.OnScrollListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            int r103 = IndefinitePagerIndicator.f318774r;
            throw null;
        }
    }

    public static final class a {
    }

    static {
    }

    public IndefinitePagerIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IndefinitePagerIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    private final int getCalculatedWidth() {
        return (((this.f318778d + (this.f318779e * 2)) - 1) * getDistanceBetweenTheCenterOfTwoDots()) + (this.f318781g * 2);
    }

    private final int getDistanceBetweenTheCenterOfTwoDots() {
        return (this.f318781g * 2) + this.f318782h;
    }

    private final int getItemCount() {
        ViewPager2 r100 = this.f318775a;
        if (r100 == null) goto L9;
        if (r100 == null) goto L10;
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 != null) goto L8;
        return 0;
    L8:
        return r101.getItemCount();
    L10:
        return 0;
    L9:
        return 0;
    }

    private final int getDotYCoordinate() {
        return this.f318780f;
    }

    public final int a(float r100) {
        Resources r101 = getResources();
        return (int) (r100 * (WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).densityDpi / 160));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        IntRange r100 = RangesKt.until(0, getItemCount());
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<Integer> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(Float.valueOf(((((IntIterator) r102).nextInt() - this.f318790p) * getDistanceBetweenTheCenterOfTwoDots()) + (getDistanceBetweenTheCenterOfTwoDots() * this.f318791q)));
        goto L4
    L6:
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L26;
        float r104 = ((Number) r103.next()).floatValue();
        if (this.f318784j == false) goto L12;
        float r105 = getDotYCoordinate();
        float r106 = (getHeight() / 2) + r104;
    L13:
        Pair r107 = new Pair(Float.valueOf(r105), Float.valueOf(r106));
        float r108 = ((Number) r107.component1()).floatValue();
        float r109 = ((Number) r107.component2()).floatValue();
        float r111 = Math.abs(r104);
        float r112 = (this.f318778d / 2) * getDistanceBetweenTheCenterOfTwoDots();
        if (r111 >= (getDistanceBetweenTheCenterOfTwoDots() / 2)) goto L17;
        int r113 = this.f318780f;
    L19:
        float r114 = r113;
    L22:
        if (Math.abs(r104) >= (getDistanceBetweenTheCenterOfTwoDots() / 2)) goto L24;
        Paint r115 = this.f318787m;
    L25:
        r110.drawCircle(r108, r109, r114, r115);
        goto L8
    L24:
        r115 = this.f318788n;
        goto L25
    L17:
        if (r111 > r112) goto L20;
        r113 = this.f318781g;
        goto L19
    L20:
        r114 = this.f318777c.getInterpolation(1 - ((r111 - r112) / ((getCalculatedWidth() / 2.01f) - r112))) * this.f318781g;
        goto L22
    L12:
        r105 = (getWidth() / 2) + r104;
        r106 = getDotYCoordinate();
        goto L13
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        this.f318790p = this.f318789o;
        if (this.f318783i == false) goto L10;
        boolean r101 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L8;
        r101 = false;
    L8:
        if (r101 == false) goto L10;
        r100 = (getItemCount() - r100) - 1;
    L10:
        this.f318789o = r100;
        invalidate();
    }

    public final void setDotColor(int r100) {
        this.f318785k = r100;
        this.f318788n.setColor(r100);
        invalidate();
    }

    public final void setDotCount(int r100) {
        this.f318778d = r100;
        invalidate();
    }

    public final void setDotRadius(int r100) {
        this.f318781g = a(r100);
        invalidate();
    }

    public final void setDotSeparationDistance(int r100) {
        this.f318782h = a(r100);
        invalidate();
    }

    public final void setFadingDotCount(int r100) {
        this.f318779e = r100;
        invalidate();
    }

    public final void setRTLSupport(boolean r100) {
        this.f318783i = r100;
        invalidate();
    }

    public final void setSelectedDotColor(int r100) {
        this.f318786l = r100;
        this.f318787m.setColor(r100);
        invalidate();
    }

    public final void setSelectedDotRadius(int r100) {
        this.f318780f = a(r100);
        invalidate();
    }

    public final void setVerticalSupport(boolean r100) {
        this.f318784j = r100;
        invalidate();
    }

    public static Paint b(IndefinitePagerIndicator r100, int r101) {
        Paint.Style r102 = Paint.Style.FILL;
        r100.getClass();
        Paint r103 = new Paint();
        r103.setStyle(r102);
        r103.setAntiAlias(true);
        r103.setColor(r101);
        return r103;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f318780f * 2;
        if (this.f318784j == false) goto L5;
        setMeasuredDimension(r102, getCalculatedWidth());
        return;
    L5:
        setMeasuredDimension(getCalculatedWidth(), r102);
    }

    public IndefinitePagerIndicator(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f318777c = new DecelerateInterpolator();
        this.f318778d = 5;
        this.f318779e = 1;
        this.f318780f = a(5.5f);
        this.f318781g = a(4.0f);
        this.f318782h = a(10.0f);
        this.f318785k = ContextCompat.getColor(r100, R.color.larus_default_dot_color);
        this.f318786l = ContextCompat.getColor(r100, R.color.larus_default_selected_dot_color);
        if (r101 == null) goto L5;
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.larus_dotColor, R.attr.larus_dotCount, R.attr.larus_dotRadius, R.attr.larus_dotSeparation, R.attr.larus_fadingDotCount, R.attr.larus_selectedDotColor, R.attr.larus_selectedDotRadius, R.attr.larus_supportRTL, R.attr.larus_verticalSupport}, 0, 0);
        this.f318778d = r103.getInteger(1, 5);
        this.f318779e = r103.getInt(4, 1);
        this.f318781g = r103.getDimensionPixelSize(2, this.f318781g);
        this.f318780f = r103.getDimensionPixelSize(6, this.f318780f);
        this.f318785k = r103.getColor(0, this.f318785k);
        this.f318786l = r103.getColor(5, this.f318786l);
        this.f318782h = r103.getDimensionPixelSize(3, this.f318782h);
        this.f318783i = r103.getBoolean(7, false);
        this.f318784j = r103.getBoolean(8, false);
        r103.recycle();
    L5:
        this.f318787m = b(this, this.f318786l);
        this.f318788n = b(this, this.f318785k);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        if (this.f318783i == true) goto L5;
    L10:
        this.f318789o = r100;
        this.f318790p = r100;
        this.f318791q = r101 * (-1);
    L11:
        invalidate();
        return;
    L5:
        if (ViewCompat.getLayoutDirection(this) != 1) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        int r104 = (getItemCount() - r100) - 1;
        this.f318789o = r104;
        this.f318790p = r104;
        this.f318791q = r101 * 1;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    public /* synthetic */ IndefinitePagerIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
