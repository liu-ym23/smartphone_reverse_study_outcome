package com.larus.slides.impl.select.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/larus/slides/impl/select/widget/GenerateImageViewPagerContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GenerateImageViewPagerContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager2 f369690a;

    public GenerateImageViewPagerContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GenerateImageViewPagerContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ViewPager2 getViewPager() {
        return this.f369690a;
    }

    public GenerateImageViewPagerContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewPager2 r103 = new ViewPager2(r100, r101, r102);
        this.f369690a = r103;
        r103.setPageTransformer(new MarginPageTransformer(c7.b(12)));
        addView(r103, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public /* synthetic */ GenerateImageViewPagerContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r110, int r111, int r112) {
        super.onSizeChanged(r100, r110, r111, r112);
        double r101 = r110;
        double r113 = RangesKt.coerceAtMost((r101 / 16.0d) * 9.0d, r100 - c7.b(32));
        int r114 = (int) (((((double) r100) - r113) * 0.5d) + 0.5d);
        int r102 = RangesKt.coerceAtLeast((int) (((r101 - RangesKt.coerceAtMost((r113 / 9.0d) * 16.0d, r101)) * 0.5d) + 0.5d), 0);
        View r115 = this.f369690a.getChildAt(0);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r116 = (RecyclerView) r115;
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r116.getClass().getSimpleName() + ",source:,start:" + r114 + ",top:" + r102 + ",end:" + r114 + ",bottom:" + r102);
        r116.setPaddingRelative(r114, r102, r114, r102);
        r116.setClipToPadding(false);
    }
}
