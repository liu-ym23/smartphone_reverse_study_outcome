package com.larus.home.impl.main.tab.component;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.home.impl.view.tab.AbsTabView;
import com.larus.home.impl.view.tab.TabMode;

/* JADX INFO: loaded from: classes29.dex */
public interface c extends t1a.a {

    public static final class a {
        public static /* synthetic */ boolean a(c r100, MainTabFragment.MainTab r101, MainTabFragment.MainTab r102, boolean r103, Bundle r104, int r105) {
            if ((r105 & 4) == 0) goto L6;
            r103 = false;
        L6:
            if ((r105 & 8) == 0) goto L9;
            r104 = null;
        L9:
            return r100.XY(r101, r102, r103, r104);
        }
    }

    AbsTabView OO(int r100);

    void QI(TabMode r100);

    boolean XY(MainTabFragment.MainTab r100, MainTabFragment.MainTab r101, boolean r102, Bundle r103);

    String Y8();

    void g30();

    void sH();

    BottomNavigationView z8();
}
