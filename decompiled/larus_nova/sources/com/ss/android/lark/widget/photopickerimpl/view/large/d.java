package com.ss.android.lark.widget.photopickerimpl.view.large;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements LargeShowVPagerAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPager f447866a;

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.LargeShowVPagerAdapter.a
    public final int getCurrentItem() {
        return this.f447866a.getCurrentItem();
    }

    public d(ViewPager r100) {
        this.f447866a = r100;
    }

    @Override // com.ss.android.lark.widget.photopickerimpl.view.large.LargeShowVPagerAdapter.a
    public final void a(int r100) {
        this.f447866a.setCurrentItem(r100, false);
    }
}
