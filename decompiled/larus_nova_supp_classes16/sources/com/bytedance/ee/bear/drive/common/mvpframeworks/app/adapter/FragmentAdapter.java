package com.bytedance.ee.bear.drive.common.mvpframeworks.app.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    public final int getCount() {
        throw null;
    }

    public final Fragment getItem(int r2) {
        return (Fragment) ListProtector.get(null, r2);
    }
}
