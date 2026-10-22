package com.larus.profile.impl.info;

import com.google.android.material.tabs.TabLayout;
import com.larus.profile.impl.databinding.LarusPageTabProfileInfoBinding;

/* JADX INFO: loaded from: classes31.dex */
public final class w implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusPageTabProfileInfoBinding f366641a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public w(LarusPageTabProfileInfoBinding r100) {
        this.f366641a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f366641a.f366537p.setCurrentItem(r100.getPosition());
    }
}
