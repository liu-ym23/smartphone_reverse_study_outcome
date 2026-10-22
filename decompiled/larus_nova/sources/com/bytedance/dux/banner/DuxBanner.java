package com.bytedance.dux.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.widget.RadiusLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002_`B'\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020\u0011¢\u0006\u0004\b]\u0010^J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010-R$\u00103\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R*\u0010<\u001a\u0002042\u0006\u00105\u001a\u0002048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010B\u001a\u00020=2\u0006\u00105\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010D\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0011\u0010K\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bJ\u00102R\u0011\u0010M\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bL\u00102R\u0011\u0010O\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bN\u00102R\u001a\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00110P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u0017R\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020=0P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010R¨\u0006a"}, d2 = {"Lcom/bytedance/dux/banner/DuxBanner;", "Lcom/bytedance/dux/widget/RadiusLayout;", "Lol4/a;", "Lol4/b;", "listener", "", "setBannerItemClickListener", "", "Lcom/bytedance/dux/banner/b;", "dataSet", "setData", "Lcom/bytedance/dux/banner/BannerStyle;", "style", "setBannerStyle", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "setOnPageChangeListener", "", "getCurrentRealPos", "", ce.f26391f, "J", "getDelayAfterUserTouch", "()J", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "Landroidx/viewpager2/widget/ViewPager2;", "h", "Lkotlin/Lazy;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "<set-?>", RXScreenCaptureService.KEY_INDEX, "getLastUserTouchTime", "lastUserTouchTime", "Lcom/bytedance/dux/banner/BannerAdapter;", ce.f26396k, "getAdapter", "()Lcom/bytedance/dux/banner/BannerAdapter;", "adapter", "Landroidx/viewpager2/widget/CompositePageTransformer;", "q", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer", "r", "I", "getStartPosition", "()I", "startPosition", "", "value", "t", FaceService.girlLabel, "getProportion", "()F", "setProportion", "(F)V", "proportion", "", "f", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isInfiniteSwitchEnabled", "Lcom/bytedance/dux/banner/e;", "triptychGirdHelper", "Lcom/bytedance/dux/banner/e;", "getTriptychGirdHelper", "()Lcom/bytedance/dux/banner/e;", "setTriptychGirdHelper", "(Lcom/bytedance/dux/banner/e;)V", "getRealCount", "realCount", "getCurrentItem", "currentItem", "getItemCount", "itemCount", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "getAutoSwitchIntervalMs", "autoSwitchIntervalMs", "getHavingFocus", "havingFocus", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BannerOnPageChangeCallback", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxBanner extends RadiusLayout implements ol4.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f204858u = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f204859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f204860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f204861i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ol4.b f204862j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f204863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f204864l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f204865m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f204866n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final MutableLiveData<Integer> f204867o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MutableLiveData<Boolean> f204868p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f204869q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f204870r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BannerStyle f204871s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f204872t;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/dux/banner/DuxBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "dux_release"}, k = 1, mv = {1, 7, 1})
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 0) goto L5;
            throw null;
        L5:
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r100) {
            int r101 = pl4.a.f529758a;
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r100, float r101, int r102) {
            int r103 = pl4.a.f529758a;
            throw null;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204875a = null;

        static {
            int[] r100 = new int[BannerStyle.values().length];
            r100[BannerStyle.TRIPTYCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[BannerStyle.FILL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[BannerStyle.INDENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f204875a = r100;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxBanner f204876a;

        public c(DuxBanner r100) {
            this.f204876a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DuxBanner r100 = this.f204876a;     // Catch: Throwable -> L4
            int r101 = DuxBanner.f204858u;     // Catch: Throwable -> L4
            r100.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public DuxBanner(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DuxBanner(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // ol4.a
    public final void b(BannerViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
    }

    public final e getTriptychGirdHelper() {
        return null;
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "onPageChangeListener");
    }

    public final void setTriptychGirdHelper(e r100) {
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.f204863k.getValue();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.f204869q.getValue();
    }

    public final void e() {
        if (this.f204866n == true) goto L5;
    L13:
        em4.e.a("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.f204859g <= 0) goto L13;
        if (this.f204865m == false) goto L11;
        em4.e.a("检查换页：正在拖动，不换页");
        return;
    L11:
        em4.e.a("剥离window，不换页");
    }

    public final int getCurrentRealPos() {
        int r100 = pl4.a.f529758a;
        boolean r101 = f();
        int r102 = getCurrentItem();
        int r103 = getRealCount();
        if (r101 == false) goto L10;
        if (r103 > 0) goto L9;
        r103 = 1;
    L9:
        return r102 % r103;
    L10:
        return r102;
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.f204860h.getValue();
    }

    public final boolean f() {
        return getAdapter().f204849g;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final int getRealCount() {
        return getAdapter().f204848f.size();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // ol4.a
    public final void a() {
        e();
    }

    public long getAutoSwitchIntervalMs() {
        return this.f204859g;
    }

    public final long getDelayAfterUserTouch() {
        return this.f204859g;
    }

    public LiveData<Boolean> getHavingFocus() {
        return this.f204868p;
    }

    public final long getLastUserTouchTime() {
        return this.f204861i;
    }

    public final float getProportion() {
        return this.f204872t;
    }

    @Override // ol4.a
    public LiveData<Integer> getSelectedPosition() {
        return this.f204867o;
    }

    public final int getStartPosition() {
        return this.f204870r;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        boolean r102 = true;
        if (r101 != 0) goto L6;
        this.f204865m = true;
    L15:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 != 1) goto L9;
    L12:
        if (r102 == false) goto L15;
        this.f204865m = false;
        this.f204861i = SystemClock.uptimeMillis();
        e();
        goto L15
    L9:
        if (r101 == 3) goto L12;
        r102 = false;
        goto L12
    }

    public final void setBannerItemClickListener(ol4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f204862j = r100;
    }

    public final void setBannerStyle(BannerStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f204871s = r100;
    }

    public final void setData(List<? extends com.bytedance.dux.banner.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        BannerAdapter r101 = getAdapter();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f204848f = r100;
        r101.notifyDataSetChanged();
        int r102 = 1;
        if (r100.size() != 1) goto L9;
        Handler r103 = getHandler();
        if (r103 == null) goto L7;
        r103.removeCallbacks(this.f204864l);
    L7:
        this.f204866n = false;
        setInfiniteSwitchEnabled(false);
    L9:
        if (f() == false) goto L11;
        r102 = getRealCount() * 100;
    L15:
        this.f204870r = r102;
        g(r102, false);
        getViewPager2().requestTransform();
        return;
    L11:
        BannerStyle r104 = this.f204871s;
        if (b.f204875a[r104.ordinal()] == 1) goto L15;
        r102 = 0;
        goto L15
    }

    public final void setDelayAfterUserTouch(long r100) {
        this.f204859g = r100;
    }

    public final void setInfiniteSwitchEnabled(boolean r100) {
        getAdapter().f204849g = r100;
        getAdapter().notifyDataSetChanged();
    }

    public final void setProportion(float r100) {
        if (r100 >= 0) goto L5;
        this.f204872t = 0.0f;
        return;
    L5:
        this.f204872t = r100;
        invalidate();
    }

    public final void g(int r100, boolean r101) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        getViewPager2().getScrollState();
        return;
    L10:
        getViewPager2().setCurrentItem(r100, r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.getMessage();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f204872t <= 0) goto L6;
        Map<PadAdaptScene, Boolean> r102 = DuxConfig.f204897a;
        int r103 = View.MeasureSpec.getSize(r100);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r103, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r103 / this.f204872t), 1073741824));
        return;
    L6:
        super.onMeasure(r100, r101);
    }

    public DuxBanner(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f204859g = 5000;
        this.f204860h = LazyKt.lazy(new DuxBanner$viewPager2$2(r100));
        this.f204861i = -1;
        this.f204863k = LazyKt.lazy(new DuxBanner$adapter$2(this));
        this.f204864l = new c(this);
        this.f204867o = new MutableLiveData(0);
        this.f204868p = new MutableLiveData(Boolean.TRUE);
        this.f204869q = LazyKt.lazy(DuxBanner$compositePageTransformer$2.INSTANCE);
        BannerStyle r103 = BannerStyle.FILL;
        this.f204871s = r103;
        if (r101 == null) goto L13;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.banner_autoSwitchInterval, R.attr.banner_enableAutoSwitch, R.attr.banner_enableInfiniteSwitch, R.attr.banner_is_pad_grid_adapt_enable, R.attr.banner_proportion, R.attr.banner_style});
        int r105 = r104.getInt(5, 0);
        if (r105 == 0) goto L11;
        if (r105 == 1) goto L10;
        if (r105 != 2) goto L11;
        r103 = BannerStyle.TRIPTYCH;
        goto L11
    L10:
        r103 = BannerStyle.INDENT;
    L11:
        this.f204871s = r103;
        r104.getBoolean(3, false);
        setProportion(r104.getFloat(4, 0.0f));
        this.f204866n = r104.getBoolean(1, false);
        this.f204859g = r104.getInt(0, (int) 5000);
        setInfiniteSwitchEnabled(r104.getBoolean(2, true));
        r104.recycle();
        return;
    }

    public /* synthetic */ DuxBanner(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
