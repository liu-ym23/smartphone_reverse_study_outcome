package com.bytedance.scene.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.scene.Scene;
import com.bytedance.scene.group.UserVisibleHintGroupScene;

/* JADX INFO: loaded from: classes19.dex */
public abstract class ScenePageAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UserVisibleHintGroupScene f268826a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        if (r100.getId() == (-1)) goto L5;
        new StringBuilder("android:switcher:").append(r101);
        ViewPager r102 = (ViewPager) r100;
        throw null;
    L5:
        throw new IllegalArgumentException("ViewPager should have view id before use ScenePageAdapter");
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (((Scene) r101).f268586d != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        Scene r103 = (Scene) r102;
        throw null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void setPrimaryItem(ViewGroup r100, int r101, Object r102) {
        super.setPrimaryItem(r100, r101, r102);
        UserVisibleHintGroupScene r103 = (UserVisibleHintGroupScene) r102;
        UserVisibleHintGroupScene r104 = this.f268826a;
        if (r103 == r104) goto L10;
        if (r104 == null) goto L6;
        r104.A0(false);
    L6:
        if (r103 == null) goto L8;
        r103.A0(true);
    L8:
        this.f268826a = r103;
        return;
    }
}
