package com.bytedance.locallife.poi.media.ui.indicator;

import com.bytedance.locallife.poi.media.ui.indicator.base.AbsPagerIndicatorAdapter;
import com.bytedance.locallife.poi.media.ui.indicator.base.PageSwipeDirection;
import com.bytedance.locallife.poi.media.ui.indicator.base.b;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PoiRecyclerPagerIndicator f262886d;

    public a(PoiRecyclerPagerIndicator r100) {
        this.f262886d = r100;
    }

    @Override // com.bytedance.locallife.poi.media.ui.indicator.base.b
    public final void a(int r100) {
        if (r100 != 0) goto L11;
        PoiRecyclerPagerIndicator r101 = this.f262886d;
        int r102 = PoiRecyclerPagerIndicator.f262855r;
        if (r101.getIndicatorCenterAlign() == false) goto L12;
        com.bytedance.locallife.poi.media.ui.indicator.base.a r103 = this.f262886d.getMPager();
        if (r103 == null) goto L8;
        int r104 = r103.getCurrentItem();
    L9:
        this.f262886d.f(r104);
        return;
    L8:
        r104 = 0;
        goto L9
    L12:
        return;
    }

    @Override // com.bytedance.locallife.poi.media.ui.indicator.base.b
    public final void c(int r100, int r101, float r102, int r110) {
        boolean r103 = true;
        float r104 = this.f262886d.getIndicatorSize() + ((this.f262886d.getIndicatorSelectedSize() - this.f262886d.getIndicatorSize()) * (1 - r102));
        float r105 = this.f262886d.getIndicatorSize() + ((this.f262886d.getIndicatorSelectedSize() - this.f262886d.getIndicatorSize()) * r102);
        PoiRecyclerPagerIndicator r106 = this.f262886d;
        int r107 = PoiRecyclerPagerIndicator.f262855r;
        AbsPagerIndicatorAdapter r108 = r106.getMAdapter();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.locallife.poi.media.ui.indicator.PoiRecyclerIndicatorAdapter");
        PoiRecyclerIndicatorAdapter r109 = (PoiRecyclerIndicatorAdapter) r108;
        if (r100 >= 0) goto L5;
    L7:
        boolean r111 = false;
    L8:
        if (r111 == false) goto L10;
        r109.f262893f = r100;
        r109.f262894g = r104;
    L10:
        if (r101 >= 0) goto L12;
    L14:
        r103 = false;
    L15:
        if (r103 == false) goto L17;
        r109.f262895h = r101;
        r109.f262896i = r105;
    L17:
        r109.notifyDataSetChanged();
        if (r110 != PageSwipeDirection.PAGE_SWIPE_DIRECTION_IDLE.getDirection()) goto L20;
        return;
    L20:
        int r112 = (int) Math.ceil((this.f262886d.getIndicatorSelectedSize() - this.f262886d.getIndicatorSpacing()) * (r102 - r110));
        int r113 = r112 - this.f262921c;
        if (this.f262886d.getIndicatorOrientation() != 0) goto L23;
        this.f262886d.getMRecyclerView().scrollBy(r113, 0);
    L24:
        this.f262921c = r112;
        return;
    L23:
        this.f262886d.getMRecyclerView().scrollBy(0, r113);
        goto L24
    L12:
        if (r101 >= ((ArrayList) r109.f262892e).size()) goto L14;
    L5:
        if (r100 >= ((ArrayList) r109.f262892e).size()) goto L7;
        r111 = true;
        goto L8
    }
}
