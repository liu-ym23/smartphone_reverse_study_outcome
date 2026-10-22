package com.larus.avlink.env.event;

import com.google.android.material.tabs.TabLayout;
import com.larus.avlink.impl.databinding.LarusActivityDoraMemoryDataBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraEnvObserveMemoryDataActivity f292296a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public o(DoraEnvObserveMemoryDataActivity r100) {
        this.f292296a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        if (r100 == null) goto L8;
        int r101 = r100.getPosition();
        LarusActivityDoraMemoryDataBinding r102 = this.f292296a.f292209g;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L6:
        r102.f293155d.setCurrentItem(r101, true);
        return;
    }
}
