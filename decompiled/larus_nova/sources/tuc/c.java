package tuc;

import androidx.viewpager.widget.ViewPager;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: loaded from: classes42.dex */
public final class c implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MagicIndicator f547662a;

    public c(MagicIndicator r100) {
        this.f547662a = r100;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        uuc.a r101 = this.f547662a.f518940a;
        if (r101 == null) goto L6;
        r101.onPageScrollStateChanged(r100);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        this.f547662a.b(r100);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
        this.f547662a.a(r100, r101, r102);
    }
}
