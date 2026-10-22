package com.bytedance.ee.bear.drive.common.mvpframeworks.app.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        throw null;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public final Fragment getItem(int r100) {
        return (Fragment) ListProtector.get(null, r100);
    }
}
