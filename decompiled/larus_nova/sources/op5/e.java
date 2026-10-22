package op5;

import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerticalViewPager f524723a;

    public e(VerticalViewPager r100) {
        this.f524723a = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int r100) {
        super.onPageScrollStateChanged(r100);
        if (r100 != 0) goto L5;
        VerticalViewPager r101 = this.f524723a;
        r101.f240422a = r101.getScrollX();
    L5:
        this.f524723a.f240423b = r100;
    }
}
