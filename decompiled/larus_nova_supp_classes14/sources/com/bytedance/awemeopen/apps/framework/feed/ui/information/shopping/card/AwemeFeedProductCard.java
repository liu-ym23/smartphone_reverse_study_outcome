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
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(R?\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eRT\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018Ri\u0010#\u001aI\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006*"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/information/shopping/card/AwemeFeedProductCard;", "Landroid/widget/RelativeLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lkotlin/Function1;", "Lcom/bytedance/awemeopen/bizmodels/feed/shopping/card/DetailPromotion;", "Lkotlin/ParameterName;", "name", "data", "", "d", "Lkotlin/jvm/functions/Function1;", "getOnClickCloseListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickCloseListener", "(Lkotlin/jvm/functions/Function1;)V", "onClickCloseListener", "Lkotlin/Function2;", "", "displayRank", "e", "Lkotlin/jvm/functions/Function2;", "getOnClickGoodDetailListener", "()Lkotlin/jvm/functions/Function2;", "setOnClickGoodDetailListener", "(Lkotlin/jvm/functions/Function2;)V", "onClickGoodDetailListener", "Lkotlin/Function3;", "Landroid/content/Context;", "context", "f", "Lkotlin/jvm/functions/Function3;", "getOnPageSelectedListener", "()Lkotlin/jvm/functions/Function3;", "setOnPageSelectedListener", "(Lkotlin/jvm/functions/Function3;)V", "onPageSelectedListener", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AwemeFeedProductCard extends RelativeLayout implements ViewPager.OnPageChangeListener {
    public View a;
    public LinearLayout b;
    public RtlViewPager c;
    public Function1<? super DetailPromotion, Unit> d;
    public Function2<? super DetailPromotion, ? super Integer, Unit> e;
    public Function3<? super Context, ? super DetailPromotion, ? super Integer, Unit> f;
    public List<DetailPromotion> g;
    public Integer h;

    public static final class a {
    }

    static {
    }

    public AwemeFeedProductCard(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AwemeFeedProductCard(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onPageScrollStateChanged(int r1) {
    }

    public final void onPageScrolled(int r1, float r2, int r3) {
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
        return this.d;
    }

    public final Function2<DetailPromotion, Integer, Unit> getOnClickGoodDetailListener() {
        return this.e;
    }

    public final Function3<Context, DetailPromotion, Integer, Unit> getOnPageSelectedListener() {
        return this.f;
    }

    public final void onPageSelected(int r5) {
        this.h = Integer.valueOf(r5);
        AoLogger.b("AwemeFeedProductCard", new Object[]{"currentPos = " + this.h});
        List<DetailPromotion> r1 = this.g;
        if (r1 == null) goto L10;
        DetailPromotion r2 = (DetailPromotion) CollectionsKt.getOrNull(r1, r5);
        if (r2 == null) goto L11;
        Function3<? super Context, ? super DetailPromotion, ? super Integer, Unit> r3 = this.f;
        if (r3 == null) goto L12;
        r3.invoke(getContext(), r2, Integer.valueOf(r5 + 1));
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setOnClickCloseListener(Function1<? super DetailPromotion, Unit> r1) {
        this.d = r1;
    }

    public final void setOnClickGoodDetailListener(Function2<? super DetailPromotion, ? super Integer, Unit> r1) {
        this.e = r1;
    }

    public final void setOnPageSelectedListener(Function3<? super Context, ? super DetailPromotion, ? super Integer, Unit> r1) {
        this.f = r1;
    }

    public AwemeFeedProductCard(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
    }

    public /* synthetic */ AwemeFeedProductCard(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
