package com.bytedance.locallife.poi.media.ui.indicator.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.amap.api.col.s.ce;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.locallife.poi.media.ui.indicator.LinearItemDecoration;
import com.bytedance.locallife.poi.media.ui.indicator.PoiPagerIndicator;
import com.bytedance.locallife.poi.media.ui.indicator.PoiRecyclerIndicatorAdapter;
import com.bytedance.locallife.poi.media.ui.indicator.ViewPager2Attacher$getPager$1;
import com.bytedance.locallife.poi.media.ui.indicator.ViewPager2Attacher$registerPagerDataObserver$1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001/\b&\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010m\u001a\u00020l\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n\u0012\b\b\u0002\u0010p\u001a\u00020\u0006¢\u0006\u0004\bq\u0010rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR*\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R*\u0010\"\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R*\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR*\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\t\u001a\u0004\b(\u0010\u000b\"\u0004\b)\u0010\rR*\u0010.\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\"\u00108\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\"\u0010@\u001a\u0002098\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010D\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bA\u0010\t\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\rR$\u0010K\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010S\u001a\u00020L8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010[\u001a\u00020T8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010c\u001a\u00020\\8\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR$\u0010k\u001a\u0004\u0018\u00010d8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006s"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsRecyclerPagerIndicator;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/locallife/poi/media/ui/indicator/base/a;", "pager", "", "setPager", "", "value", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getIndicatorColor", "()I", "setIndicatorColor", "(I)V", "indicatorColor", "b", "getIndicatorSelectedColor", "setIndicatorSelectedColor", "indicatorSelectedColor", "", "c", FaceService.girlLabel, "getIndicatorSize", "()F", "setIndicatorSize", "(F)V", "indicatorSize", "d", "getIndicatorSelectedSize", "setIndicatorSelectedSize", "indicatorSelectedSize", "e", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "indicatorCornerRadius", "f", "getIndicatorVisibleCount", "setIndicatorVisibleCount", "indicatorVisibleCount", ce.f26391f, "getIndicatorEdgeAlphaCount", "setIndicatorEdgeAlphaCount", "indicatorEdgeAlphaCount", "h", "getIndicatorEdgeAlpha", "setIndicatorEdgeAlpha", "indicatorEdgeAlpha", "com/bytedance/locallife/poi/media/ui/indicator/base/AbsRecyclerPagerIndicator$mSmoothScroller$2$1", RXScreenCaptureService.KEY_INDEX, "Lkotlin/Lazy;", "getMSmoothScroller", "()Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsRecyclerPagerIndicator$mSmoothScroller$2$1;", "mSmoothScroller", ce.f26395j, "getIndicatorSpacing", "setIndicatorSpacing", "indicatorSpacing", "", ce.f26396k, "Z", "getIndicatorCenterAlign", "()Z", "setIndicatorCenterAlign", "(Z)V", "indicatorCenterAlign", "l", "getIndicatorOrientation", "setIndicatorOrientation", "indicatorOrientation", "m", "Lcom/bytedance/locallife/poi/media/ui/indicator/base/a;", "getMPager", "()Lcom/bytedance/locallife/poi/media/ui/indicator/base/a;", "setMPager", "(Lcom/bytedance/locallife/poi/media/ui/indicator/base/a;)V", "mPager", "Landroidx/recyclerview/widget/RecyclerView;", OfficeSDKRequestTag.KEY_NEW_USER, "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerView", "Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsPagerIndicatorAdapter;", "o", "Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsPagerIndicatorAdapter;", "getMAdapter", "()Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsPagerIndicatorAdapter;", "setMAdapter", "(Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsPagerIndicatorAdapter;)V", "mAdapter", "Landroidx/recyclerview/widget/LinearLayoutManager;", "p", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getMLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setMLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "mLayoutManager", "Lcom/bytedance/locallife/poi/media/ui/indicator/LinearItemDecoration;", "q", "Lcom/bytedance/locallife/poi/media/ui/indicator/LinearItemDecoration;", "getMDecoration", "()Lcom/bytedance/locallife/poi/media/ui/indicator/LinearItemDecoration;", "setMDecoration", "(Lcom/bytedance/locallife/poi/media/ui/indicator/LinearItemDecoration;)V", "mDecoration", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsRecyclerPagerIndicator extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f262897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f262898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f262899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f262900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f262901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f262902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f262903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f262904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f262905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f262906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f262907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f262908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.locallife.poi.media.ui.indicator.base.a f262909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f262910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AbsPagerIndicatorAdapter f262911o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayoutManager f262912p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearItemDecoration f262913q;

    public static final class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f262914a = null;

        static {
            f262914a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsRecyclerPagerIndicator f262915a;

        public c(AbsRecyclerPagerIndicator r100) {
            this.f262915a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f262915a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsRecyclerPagerIndicator f262916a;

        public d(AbsRecyclerPagerIndicator r100) {
            this.f262916a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f262916a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsRecyclerPagerIndicator f262917a;

        public e(AbsRecyclerPagerIndicator r100) {
            this.f262917a = r100;
        }

        public final void a() {
            AbsRecyclerPagerIndicator r100 = this.f262917a;
            com.bytedance.locallife.poi.media.ui.indicator.base.a r101 = r100.f262909m;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.getItemCount();
        L7:
            if (r103 == r100.getMAdapter().getItemCount()) goto L36;
            ArrayList r104 = new ArrayList();
            int r105 = 0;
        L10:
            if (r105 >= r103) goto L12;
            r104.add(new PoiPagerIndicator(r100.f262897a, r100.f262898b, r100.f262899c, r100.f262900d, r100.f262901e, r100.f262906j));
            r105 = r105 + 1;
            goto L10
        L12:
            AbsPagerIndicatorAdapter r106 = r100.getMAdapter();
            r106.getClass();
            Intrinsics.checkNotNullParameter(r104, "indicators");
            ((ArrayList) r106.f262892e).clear();
            ((ArrayList) r106.f262892e).addAll(r104);
            r106.notifyDataSetChanged();
            if (r100.f262907k == false) goto L32;
            float r107 = Math.max(r100.f262902f, 3) - 1;
            float r108 = ((r100.f262899c * r107) + r100.f262900d) + (r107 * r100.f262906j);
            ViewGroup.LayoutParams r109 = r100.getLayoutParams();
            if (r109 == null) goto L21;
            if (r100.f262908l != 0) goto L19;
            r109.width = (int) r108;
        L24:
            r100.setLayoutParams(r109);
            LinearItemDecoration r110 = r100.f262913q;
            if (r110 == null) goto L27;
            r100.getMRecyclerView().removeItemDecoration(r110);
        L27:
            RecyclerView r111 = r100.getMRecyclerView();
            float r112 = 2;
            LinearItemDecoration r113 = new LinearItemDecoration((int) r100.f262906j, MathKt.roundToInt((r108 - r100.f262900d) / r112), MathKt.roundToInt((r108 - r100.f262900d) / r112), 24);
            r100.f262913q = r113;
            r111.addItemDecoration(r113);
            com.bytedance.locallife.poi.media.ui.indicator.base.a r114 = r100.f262909m;
            if (r114 == null) goto L30;
            int r115 = r114.getCurrentItem();
        L31:
            r100.f(r115);
            goto L36
        L30:
            r115 = 0;
            goto L31
        L19:
            r109.height = (int) r108;
            goto L24
        L21:
            if (r100.f262908l != 0) goto L23;
            r109 = new ViewGroup.LayoutParams((int) r108, -2);
            goto L24
        L23:
            r109 = new ViewGroup.LayoutParams(-2, (int) r108);
            goto L24
        L32:
            LinearItemDecoration r116 = r100.f262913q;
            if (r116 == null) goto L35;
            r100.getMRecyclerView().removeItemDecoration(r116);
        L35:
            RecyclerView r117 = r100.getMRecyclerView();
            LinearItemDecoration r118 = new LinearItemDecoration((int) r100.f262906j, 0, 0, 30);
            r100.f262913q = r118;
            r117.addItemDecoration(r118);
        L36:
            AbsRecyclerPagerIndicator r119 = this.f262917a;
            com.bytedance.locallife.poi.media.ui.indicator.base.a r120 = r119.f262909m;
            if (r120 == null) goto L39;
            r120.b();
        L39:
            com.bytedance.locallife.poi.media.ui.indicator.a r121 = r119.b();
            com.bytedance.locallife.poi.media.ui.indicator.base.a r122 = r119.f262909m;
            if (r122 == null) goto L42;
            r122.c(r121);
        L42:
            com.bytedance.locallife.poi.media.ui.indicator.base.a r123 = r119.f262909m;
            if (r123 == null) goto L45;
            int r124 = r123.getCurrentItem();
        L46:
            r121.b(r124, 0.0f);
            com.bytedance.locallife.poi.media.ui.indicator.base.a r125 = r119.f262909m;
            if (r125 == null) goto L49;
            r125.getCurrentItem();
        L49:
            com.bytedance.locallife.poi.media.ui.indicator.base.a r126 = r119.f262909m;
            if (r126 == null) goto L52;
            r102 = r126.a();
        L52:
            r121.a(r102);
            return;
        L45:
            r124 = 0;
            goto L46
        L5:
            r103 = 0;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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

    public AbsRecyclerPagerIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AbsRecyclerPagerIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract com.bytedance.locallife.poi.media.ui.indicator.a b();

    public abstract PoiRecyclerIndicatorAdapter c();

    private final AbsRecyclerPagerIndicator$mSmoothScroller$2.AnonymousClass1 getMSmoothScroller() {
        return (AbsRecyclerPagerIndicator$mSmoothScroller$2.AnonymousClass1) this.f262905i.getValue();
    }

    public final boolean d() {
        if (this.f262911o == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void e() {
        if (this.f262909m != null) goto L5;
        return;
    L5:
        post(new e(this));
    }

    public final AbsPagerIndicatorAdapter getMAdapter() {
        AbsPagerIndicatorAdapter r100 = this.f262911o;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        return null;
    }

    public final LinearLayoutManager getMLayoutManager() {
        LinearLayoutManager r100 = this.f262912p;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
        return null;
    }

    public final RecyclerView getMRecyclerView() {
        RecyclerView r100 = this.f262910n;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new c(this));
    }

    public final boolean getIndicatorCenterAlign() {
        return this.f262907k;
    }

    public final int getIndicatorColor() {
        return this.f262897a;
    }

    public final float getIndicatorCornerRadius() {
        return this.f262901e;
    }

    public final float getIndicatorEdgeAlpha() {
        return this.f262904h;
    }

    public final int getIndicatorEdgeAlphaCount() {
        return this.f262903g;
    }

    public final int getIndicatorOrientation() {
        return this.f262908l;
    }

    public final int getIndicatorSelectedColor() {
        return this.f262898b;
    }

    public final float getIndicatorSelectedSize() {
        return this.f262900d;
    }

    public final float getIndicatorSize() {
        return this.f262899c;
    }

    public final float getIndicatorSpacing() {
        return this.f262906j;
    }

    public final int getIndicatorVisibleCount() {
        return this.f262902f;
    }

    public final LinearItemDecoration getMDecoration() {
        return this.f262913q;
    }

    public final com.bytedance.locallife.poi.media.ui.indicator.base.a getMPager() {
        return this.f262909m;
    }

    public final void a(final ViewPager2 r100) {
        Intrinsics.checkNotNullParameter(r100, "pager");
        Intrinsics.checkNotNullParameter(this, "indicator");
        Intrinsics.checkNotNullParameter(r100, "pager");
        final RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 == null) goto L7;
        final Function0<Unit> r102 = new AbsAttacher$attach$1(this);
        Intrinsics.checkNotNullParameter(r100, "pager");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "onChanged");
        r101.registerAdapterDataObserver(new ViewPager2Attacher$registerPagerDataObserver$1(r102));
        Intrinsics.checkNotNullParameter(r100, "pager");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        setPager(new ViewPager2Attacher$getPager$1(r100, r101));
        e();
        return;
    L7:
        throw new IllegalStateException("You must set an adapter to Pager before attach");
    }

    public final void f(int r100) {
        getMSmoothScroller().setTargetPosition(r100);
        getMLayoutManager().startSmoothScroll(getMSmoothScroller());
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        super.onRestoreInstanceState(r100);
        post(new d(this));
    }

    public final void setIndicatorCenterAlign(boolean r100) {
        this.f262907k = r100;
    }

    public final void setIndicatorColor(int r100) {
        this.f262897a = r100;
        if (d() == false) goto L17;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        if (((ArrayList) r101.f262892e).isEmpty() == false) goto L8;
        return;
    L8:
        if (((PoiPagerIndicator) CollectionsKt.first(r101.f262892e)).getIndicatorColor() == r100) goto L19;
        Iterator r102 = ((ArrayList) r101.f262892e).iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((PoiPagerIndicator) r102.next()).setIndicatorColor(r100);
        goto L12
    L14:
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_color");
        return;
    L19:
        return;
    }

    public final void setIndicatorCornerRadius(float r100) {
        this.f262901e = r100;
        if (d() == false) goto L20;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        if (((ArrayList) r101.f262892e).isEmpty() == false) goto L8;
        return;
    L8:
        if (((PoiPagerIndicator) CollectionsKt.first(r101.f262892e)).getIndicatorRadius() != r100) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L22;
        Iterator r103 = ((ArrayList) r101.f262892e).iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        ((PoiPagerIndicator) r103.next()).setIndicatorRadius(r100);
        goto L15
    L17:
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_radius");
        return;
    L22:
        return;
    L10:
        r102 = false;
        goto L11
    }

    public final void setIndicatorEdgeAlpha(float r100) {
        if (r100 >= 0.0f) goto L5;
    L6:
        r100 = 0.25f;
    L7:
        this.f262904h = r100;
        if (d() == false) goto L11;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        r101.f262891d = r100;
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_edge_alpha");
        return;
    L11:
        return;
    L5:
        if (r100 <= 1.0f) goto L7;
        goto L6
    }

    public final void setIndicatorEdgeAlphaCount(int r100) {
        this.f262903g = r100;
        if (d() == false) goto L6;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        r101.f262890c = r100;
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_edge_alpha_count");
        return;
    }

    public final void setIndicatorOrientation(int r100) {
        this.f262908l = r100;
    }

    public final void setIndicatorSelectedColor(int r100) {
        this.f262898b = r100;
        if (d() == false) goto L17;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        if (((ArrayList) r101.f262892e).isEmpty() == false) goto L8;
        return;
    L8:
        if (((PoiPagerIndicator) CollectionsKt.first(r101.f262892e)).getIndicatorSelectedColor() == r100) goto L19;
        Iterator r102 = ((ArrayList) r101.f262892e).iterator();
    L12:
        if (r102.hasNext() == false) goto L14;
        ((PoiPagerIndicator) r102.next()).setIndicatorSelectedColor(r100);
        goto L12
    L14:
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_selected_color");
        return;
    L19:
        return;
    }

    public final void setIndicatorSelectedSize(float r100) {
        this.f262900d = r100;
        if (d() == false) goto L20;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        if (((ArrayList) r101.f262892e).isEmpty() == false) goto L8;
        return;
    L8:
        if (((PoiPagerIndicator) CollectionsKt.first(r101.f262892e)).getIndicatorSelectedSize() != r100) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L22;
        Iterator r103 = ((ArrayList) r101.f262892e).iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        ((PoiPagerIndicator) r103.next()).setIndicatorSelectedSize(r100);
        goto L15
    L17:
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_size");
        return;
    L22:
        return;
    L10:
        r102 = false;
        goto L11
    }

    public final void setIndicatorSize(float r100) {
        this.f262899c = r100;
        if (d() == false) goto L20;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        if (((ArrayList) r101.f262892e).isEmpty() == false) goto L8;
        return;
    L8:
        if (((PoiPagerIndicator) CollectionsKt.first(r101.f262892e)).getIndicatorSize() != r100) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L22;
        Iterator r103 = ((ArrayList) r101.f262892e).iterator();
    L15:
        if (r103.hasNext() == false) goto L17;
        ((PoiPagerIndicator) r103.next()).setIndicatorSize(r100);
        goto L15
    L17:
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_size");
        return;
    L22:
        return;
    L10:
        r102 = false;
        goto L11
    }

    public final void setIndicatorSpacing(float r100) {
        this.f262906j = r100;
    }

    public final void setIndicatorVisibleCount(int r100) {
        this.f262902f = r100;
        if (d() == false) goto L6;
        AbsPagerIndicatorAdapter r101 = getMAdapter();
        r101.f262889b = r100;
        r101.notifyItemRangeChanged(0, ((ArrayList) r101.f262892e).size(), "pay_loads_indicator_visible_count");
        return;
    }

    public final void setMAdapter(AbsPagerIndicatorAdapter r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f262911o = r100;
    }

    public final void setMDecoration(LinearItemDecoration r100) {
        this.f262913q = r100;
    }

    public final void setMLayoutManager(LinearLayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f262912p = r100;
    }

    public final void setMPager(com.bytedance.locallife.poi.media.ui.indicator.base.a r100) {
        this.f262909m = r100;
    }

    public final void setMRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f262910n = r100;
    }

    public final void setPager(com.bytedance.locallife.poi.media.ui.indicator.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pager");
        this.f262909m = r100;
    }

    public AbsRecyclerPagerIndicator(final Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        this.f262897a = -1;
        this.f262898b = -1;
        this.f262899c = UIUtils.dip2Px(r100, 5.0f);
        this.f262900d = UIUtils.dip2Px(r100, 16.0f);
        this.f262902f = Integer.MAX_VALUE;
        int r101 = 1;
        this.f262903g = 1;
        this.f262904h = 0.25f;
        this.f262905i = LazyKt.lazy(new AbsRecyclerPagerIndicator$mSmoothScroller$2(r100));
        this.f262906j = UIUtils.dip2Px(r100, 3.0f);
        this.f262907k = true;
        this.f262908l = 1;
        if (r110 == null) goto L6;
        TypedArray r112 = r100.obtainStyledAttributes(r110, new int[]{R.attr.poiIndicatorCenterAlign, R.attr.poiIndicatorColor, R.attr.poiIndicatorCornerRadius, R.attr.poiIndicatorEdgeAlpha, R.attr.poiIndicatorEdgeAlphaCount, R.attr.poiIndicatorOrientation, R.attr.poiIndicatorSelectedColor, R.attr.poiIndicatorSelectedSize, R.attr.poiIndicatorSize, R.attr.poiIndicatorSpacing, R.attr.poiIndicatorVisibleCount});
        setIndicatorColor(r112.getColor(1, -1));
        setIndicatorSelectedColor(r112.getColor(6, -1));
        setIndicatorSize(r112.getDimension(8, UIUtils.dip2Px(r100, 5.0f)));
        setIndicatorSelectedSize(r112.getDimension(7, UIUtils.dip2Px(r100, 16.0f)));
        setIndicatorCornerRadius(r112.getDimension(2, 0.0f));
        this.f262906j = r112.getDimension(9, UIUtils.dip2Px(r100, 3.0f));
        this.f262908l = r112.getInt(5, 1);
        setIndicatorVisibleCount(r112.getInt(10, Integer.MAX_VALUE));
        setIndicatorEdgeAlphaCount(r112.getInt(4, 1));
        setIndicatorEdgeAlpha(r112.getFloat(3, 0.25f));
        this.f262907k = r112.getBoolean(0, true);
        r112.recycle();
    L6:
        if (this.f262908l != 0) goto L8;
        r101 = 0;
    L8:
        setMLayoutManager(new LinearLayoutManager(r100, r101, false));
        RecyclerView r113 = new RecyclerView(r100);
        r113.setOnTouchListener(a.f262914a);
        r113.setClipToPadding(false);
        r113.setLayoutManager(getMLayoutManager());
        PoiRecyclerIndicatorAdapter r102 = c();
        setMAdapter(r102);
        r113.setAdapter(r102);
        setMRecyclerView(r113);
        RecyclerView r103 = getMRecyclerView();
        FrameLayout.LayoutParams r114 = new FrameLayout.LayoutParams(-1, -1);
        r114.gravity = 17;
        Unit r115 = Unit.INSTANCE;
        addView(r103, r114);
    }

    public /* synthetic */ AbsRecyclerPagerIndicator(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
