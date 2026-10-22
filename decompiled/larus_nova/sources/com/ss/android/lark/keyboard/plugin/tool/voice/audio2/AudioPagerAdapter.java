package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class AudioPagerAdapter extends PagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f429883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f429884b;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View r100, Object r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.f429883a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final CharSequence getPageTitle(int r100) {
        return (CharSequence) ListProtector.get(this.f429884b, r100);
    }

    public AudioPagerAdapter(List r100, List r101) {
        this.f429883a = r100;
        this.f429884b = r101;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup r100, int r101) {
        View r102 = (View) ListProtector.get(this.f429883a, r101);
        r100.addView(r102);
        return r102;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup r100, int r101, Object r102) {
        r100.removeView((View) r102);
    }
}
