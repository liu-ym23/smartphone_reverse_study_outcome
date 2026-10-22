package com.larus.home.impl.main.tab;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainTabFragment f345986a;

    public /* synthetic */ g(MainTabFragment r100) {
        this.f345986a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainTabFragment r100 = this.f345986a;
        String r101 = MainTabFragment.f345844J;
        FLogger.f375446a.d(MainTabFragment.f345844J, "attach lazy component at lazy runnable");
        if (r100.isDetached() == false) goto L5;
        return;
    L5:
        if (r100.isRemoving() == true) goto L13;
        r100.aa0();
        com.larus.home.impl.main.tab.component.b r102 = (com.larus.home.impl.main.tab.component.b) s1a.a.g(r100).getAbility(com.larus.home.impl.main.tab.component.b.class);
        if (r102 == null) goto L12;
        r102.v40();
        return;
    L12:
        return;
    }
}
