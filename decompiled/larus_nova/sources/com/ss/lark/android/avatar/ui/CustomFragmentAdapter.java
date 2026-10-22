package com.ss.lark.android.avatar.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class CustomFragmentAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Fragment> f456746a;

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return ((ArrayList) this.f456746a).size();
    }

    public CustomFragmentAdapter(FragmentManager r100) {
        super(r100);
        this.f456746a = new ArrayList();
    }

    public final void f(Fragment r100) {
        if (((ArrayList) this.f456746a).contains(r100) == true) goto L6;
        ((ArrayList) this.f456746a).add(r100);
        return;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public final Fragment getItem(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < ((ArrayList) this.f456746a).size()) goto L7;
        return null;
    L7:
        return (Fragment) ListProtector.get(this.f456746a, r100);
    }
}
