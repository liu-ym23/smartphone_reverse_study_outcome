package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.RtlViewPager;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(R?\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRT\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018Ri\u0010#\u001aI\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006*"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/shopping/card/AwemeFeedProductCard;", "Landroid/widget/RelativeLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lkotlin/Function1;", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/DetailPromotion;", "Lkotlin/ParameterName;", "name", "data", "", "d", "Lkotlin/jvm/functions/Function1;", "getOnClickCloseListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickCloseListener", "(Lkotlin/jvm/functions/Function1;)V", "onClickCloseListener", "Lkotlin/Function2;", "", "displayRank", "e", "Lkotlin/jvm/functions/Function2;", "getOnClickGoodDetailListener", "()Lkotlin/jvm/functions/Function2;", "setOnClickGoodDetailListener", "(Lkotlin/jvm/functions/Function2;)V", "onClickGoodDetailListener", "Lkotlin/Function3;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "f", "Lkotlin/jvm/functions/Function3;", "getOnPageSelectedListener", "()Lkotlin/jvm/functions/Function3;", "setOnPageSelectedListener", "(Lkotlin/jvm/functions/Function3;)V", "onPageSelectedListener", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AwemeFeedProductCard extends RelativeLayout implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f196344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f196345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RtlViewPager f196346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super DetailPromotion, Unit> f196347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super DetailPromotion, ? super Integer, Unit> f196348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super Context, ? super DetailPromotion, ? super Integer, Unit> f196349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<DetailPromotion> f196350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f196351h;

    public static final class a {
    }

    static {
    }

    public AwemeFeedProductCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AwemeFeedProductCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (getChildCount() == 0) goto L5;
        removeAllViews();
    L5:
        setVisibility(8);
    }

    public final Function1<DetailPromotion, Unit> getOnClickCloseListener() {
        return this.f196347d;
    }

    public final Function2<DetailPromotion, Integer, Unit> getOnClickGoodDetailListener() {
        return this.f196348e;
    }

    public final Function3<Context, DetailPromotion, Integer, Unit> getOnPageSelectedListener() {
        return this.f196349f;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        this.f196351h = Integer.valueOf(r100);
        AoLogger.b("AwemeFeedProductCard", new Object[]{"currentPos = " + this.f196351h});
        List<DetailPromotion> r101 = this.f196350g;
        if (r101 == null) goto L10;
        DetailPromotion r102 = (DetailPromotion) CollectionsKt.getOrNull(r101, r100);
        if (r102 == null) goto L11;
        Function3<? super Context, ? super DetailPromotion, ? super Integer, Unit> r103 = this.f196349f;
        if (r103 == null) goto L12;
        r103.invoke(getContext(), r102, Integer.valueOf(r100 + 1));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setOnClickCloseListener(Function1<? super DetailPromotion, Unit> r100) {
        this.f196347d = r100;
    }

    public final void setOnClickGoodDetailListener(Function2<? super DetailPromotion, ? super Integer, Unit> r100) {
        this.f196348e = r100;
    }

    public final void setOnPageSelectedListener(Function3<? super Context, ? super DetailPromotion, ? super Integer, Unit> r100) {
        this.f196349f = r100;
    }

    public AwemeFeedProductCard(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
    }

    public /* synthetic */ AwemeFeedProductCard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
