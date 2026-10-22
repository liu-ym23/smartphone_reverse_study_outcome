package com.bytedance.ee.bear.wikiv2.wikitreev2.main;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.bear.wikiv2.searchv2.WikiSearchPickerView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l {
    public final FragmentActivity a;
    public final WikiCoverCoordinatorLayout b;
    public final AppBarLayout c;
    public final Toolbar d;
    public final SpaceCoverView e;
    public final BaseTitleBar f;
    public final WikiSearchPickerView g;
    public final ViewConfiguration h;
    public int i;
    public int j;
    public final PointF k;

    public final void a() {
        if (this.c == null) goto L15;
        Toolbar r0 = this.d;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.getAlpha() <= 0.5f) goto L9;
        b(true);
        return;
    L9:
        SpaceInfo.SpaceCover r1 = this.e.l;
        if (r1 == null) goto L12;
        boolean r2 = r1.is_graph_dark;
    L13:
        b(!r2);
        return;
    L12:
        r2 = false;
        goto L13
    }

    public final void b(boolean r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        int r0 = this.a.getResources().getColor(2131103546, this.a.getTheme());
        bp5.c.e(this.a, null, r0, r4);
        return;
    }

    public l(FragmentActivity r2, View r3) {
        this.k = new PointF();
        this.a = r2;
        this.b = (WikiCoverCoordinatorLayout) r3.findViewById(2131393224);
        this.c = r3.findViewById(2131393217);
        this.d = r3.findViewById(2131393230);
        this.f = (BaseTitleBar) r3.findViewById(2131393228);
        this.e = (SpaceCoverView) r3.findViewById(2131393225);
        this.g = (WikiSearchPickerView) r3.findViewById(2131393253);
        this.h = ViewConfiguration.get(r2);
    }
}
