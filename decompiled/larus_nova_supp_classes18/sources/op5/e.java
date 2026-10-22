package op5;

import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ VerticalViewPager a;

    public e(VerticalViewPager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.viewpager.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int r3) {
        super.onPageScrollStateChanged(r3);
        if (r3 != 0) goto L5;
        VerticalViewPager r0 = this.a;
        r0.a = r0.getScrollX();
    L5:
        this.a.b = r3;
    }
}
