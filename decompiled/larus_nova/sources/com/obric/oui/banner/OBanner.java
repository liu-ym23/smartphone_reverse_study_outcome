package com.obric.oui.banner;

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
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002VWB'\b\u0007\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010Q\u0012\b\b\u0002\u0010S\u001a\u00020\u0011¢\u0006\u0004\bT\u0010UJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010$\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b#\u0010\u0017R\u001b\u0010)\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001d\u001a\u0004\b,\u0010-R$\u00103\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R*\u0010<\u001a\u0002042\u0006\u00105\u001a\u0002048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010B\u001a\u00020=2\u0006\u00105\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0011\u0010D\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bC\u00102R\u0011\u0010F\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bE\u00102R\u0011\u0010H\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\bG\u00102R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00110I8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010N\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017¨\u0006X"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lkla/a;", "Lkla/b;", "listener", "", "setBannerItemClickListener", "", "Lcom/obric/oui/banner/b;", "dataSet", "setData", "Lcom/obric/oui/banner/BannerStyle;", "style", "setBannerStyle", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "setOnPageChangeListener", "", "getCurrentRealPos", "", "m", "J", "getDelayAfterUserTouch", "()J", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "Landroidx/viewpager2/widget/ViewPager2;", OfficeSDKRequestTag.KEY_NEW_USER, "Lkotlin/Lazy;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "<set-?>", "o", "getLastUserTouchTime", "lastUserTouchTime", "Lcom/obric/oui/banner/BannerAdapter;", "q", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter", "Landroidx/viewpager2/widget/CompositePageTransformer;", "w", "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer", "x", "I", "getStartPosition", "()I", "startPosition", "", "value", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, FaceService.girlLabel, "getProportion", "()F", "setProportion", "(F)V", "proportion", "", "f", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isInfiniteSwitchEnabled", "getRealCount", "realCount", "getCurrentItem", "currentItem", "getItemCount", "itemCount", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "getAutoSwitchIntervalMs", "autoSwitchIntervalMs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "BannerOnPageChangeCallback", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBanner extends RadiusLayout implements kla.a {
    public static final /* synthetic */ int A = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f398835m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f398836n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f398837o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public kla.b f398838p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f398839q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final f f398840r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f398841s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f398842t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f398843u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MutableLiveData<Integer> f398844v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f398845w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f398846x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BannerStyle f398847y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f398848z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
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
            int r101 = lla.a.f509806a;
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r100, float r101, int r102) {
            int r103 = lla.a.f509806a;
            throw null;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f398851a = null;

        static {
            int[] r100 = new int[BannerStyle.values().length];
            r100[BannerStyle.TRIPTYCH.ordinal()] = 1;
            r100[BannerStyle.FILL.ordinal()] = 2;
            r100[BannerStyle.INDENT.ordinal()] = 3;
            f398851a = r100;
        }
    }

    static {
    }

    public OBanner(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OBanner(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // kla.a
    public final void a() {
        this.f398842t = true;
        e();
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "onPageChangeListener");
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.f398839q.getValue();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.f398845w.getValue();
    }

    public final void e() {
        if (this.f398843u == true) goto L5;
    L27:
        pla.c.a("检查换页：开关 false，不换页");
        return;
    L5:
        if (this.f398835m <= 0) goto L27;
        if (this.f398841s == false) goto L12;
        pla.c.a("检查换页：正在拖动，不换页");
        return;
    L12:
        if (isAttachedToWindow() == true) goto L15;
        pla.c.a("剥离window，不换页");
        return;
    L15:
        long r100 = SystemClock.uptimeMillis() - this.f398837o;
        if (r100 >= this.f398835m) goto L23;
        pla.c.a("检查换页: 刚松手" + r100 + " ms，delay换页");
        Handler r101 = getHandler();
        if (r101 == null) goto L29;
        r101.postDelayed(this.f398840r, this.f398835m - r100);
        return;
    L29:
        return;
    L23:
        if (this.f398842t == false) goto L25;
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
        return;
    L25:
        pla.c.a("检查换页：不是业务触发的，不换页");
    }

    public final int getCurrentRealPos() {
        int r100 = lla.a.f509806a;
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
        return (ViewPager2) this.f398836n.getValue();
    }

    public final boolean f() {
        return getAdapter().f398827g;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final int getRealCount() {
        return getAdapter().f398826f.size();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    public long getAutoSwitchIntervalMs() {
        return this.f398835m;
    }

    public final long getDelayAfterUserTouch() {
        return this.f398835m;
    }

    public final long getLastUserTouchTime() {
        return this.f398837o;
    }

    public final float getProportion() {
        return this.f398848z;
    }

    @Override // kla.a
    public LiveData<Integer> getSelectedPosition() {
        return this.f398844v;
    }

    public final int getStartPosition() {
        return this.f398846x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L4;
        Integer r101 = null;
    L5:
        boolean r102 = true;
        if (r101 == null) goto L12;
        if (r101.intValue() != 0) goto L12;
        this.f398841s = true;
    L26:
        return super.dispatchTouchEvent(r100);
    L12:
        if (r101 != null) goto L15;
    L17:
        if (r101 != null) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == false) goto L26;
        this.f398841s = false;
        this.f398837o = SystemClock.uptimeMillis();
        e();
        goto L26
    L20:
        if (r101.intValue() != 3) goto L22;
    L15:
        if (r101.intValue() != 1) goto L17;
    L4:
        r101 = Integer.valueOf(r100.getAction());
        goto L5
    }

    public final void setBannerItemClickListener(kla.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f398838p = r100;
    }

    public final void setBannerStyle(BannerStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "style");
        this.f398847y = r100;
    }

    public final void setData(List<? extends com.obric.oui.banner.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dataSet");
        BannerAdapter r101 = getAdapter();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "value");
        r101.f398826f = r100;
        r101.notifyDataSetChanged();
        int r102 = 1;
        if (r100.size() != 1) goto L10;
        Handler r103 = getHandler();
        if (r103 == null) goto L8;
        r103.removeCallbacks(this.f398840r);
    L8:
        this.f398843u = false;
        setInfiniteSwitchEnabled(false);
    L10:
        if (f() == false) goto L12;
        r102 = getRealCount() * 100;
    L16:
        this.f398846x = r102;
        g(r102, false);
        getViewPager2().requestTransform();
        return;
    L12:
        BannerStyle r104 = this.f398847y;
        if (b.f398851a[r104.ordinal()] == 1) goto L16;
        r102 = 0;
        goto L16
    }

    public final void setDelayAfterUserTouch(long r100) {
        this.f398835m = r100;
    }

    public final void setInfiniteSwitchEnabled(boolean r100) {
        getAdapter().f398827g = r100;
        getAdapter().notifyDataSetChanged();
    }

    public final void setProportion(float r100) {
        if (r100 >= 0.0f) goto L5;
        this.f398848z = 0.0f;
        return;
    L5:
        this.f398848z = r100;
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
        Intrinsics.stringPlus("setCurrentItem error, msg: ", e.getMessage());
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (this.f398848z > 0.0f) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r102 = View.MeasureSpec.getSize(r100);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r102, 1073741824), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r102 / this.f398848z), 1073741824));
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [com.obric.oui.banner.f] */
    public OBanner(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f398835m = 5000;
        this.f398836n = LazyKt.lazy(new OBanner$viewPager2$2(r100));
        this.f398837o = -1;
        this.f398839q = LazyKt.lazy(new OBanner$adapter$2(this));
        this.f398840r = new f(this);
        this.f398844v = new MutableLiveData(0);
        this.f398845w = LazyKt.lazy(OBanner$compositePageTransformer$2.INSTANCE);
        BannerStyle r103 = BannerStyle.FILL;
        this.f398847y = r103;
        if (r101 == null) goto L13;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_banner_autoSwitchInterval, R.attr.oui_banner_enableAutoSwitch, R.attr.oui_banner_enableInfiniteSwitch, R.attr.oui_banner_is_pad_grid_adapt_enable, R.attr.oui_banner_proportion, R.attr.oui_banner_style});
        int r105 = r104.getInt(5, 0);
        if (r105 == 0) goto L11;
        if (r105 == 1) goto L10;
        if (r105 != 2) goto L11;
        r103 = BannerStyle.TRIPTYCH;
        goto L11
    L10:
        r103 = BannerStyle.INDENT;
    L11:
        this.f398847y = r103;
        r104.getBoolean(3, false);
        setProportion(r104.getFloat(4, 0.0f));
        this.f398843u = r104.getBoolean(1, false);
        this.f398835m = r104.getInt(0, 5000);
        setInfiniteSwitchEnabled(r104.getBoolean(2, true));
        r104.recycle();
        return;
    }

    public /* synthetic */ OBanner(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
