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
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f241567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WikiCoverCoordinatorLayout f241568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppBarLayout f241569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Toolbar f241570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpaceCoverView f241571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BaseTitleBar f241572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WikiSearchPickerView f241573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewConfiguration f241574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f241575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f241576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final PointF f241577k;

    public final void a() {
        if (this.f241569c == null) goto L15;
        Toolbar r100 = this.f241570d;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getAlpha() <= 0.5f) goto L9;
        b(true);
        return;
    L9:
        SpaceInfo.SpaceCover r101 = this.f241571e.f241465l;
        if (r101 == null) goto L12;
        boolean r102 = r101.is_graph_dark;
    L13:
        b(!r102);
        return;
    L12:
        r102 = false;
        goto L13
    }

    public final void b(boolean r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        int r101 = this.f241567a.getResources().getColor(R.color.lkui_transparent, this.f241567a.getTheme());
        bp5.c.e(this.f241567a, null, r101, r100);
        return;
    }

    public l(FragmentActivity r100, View r101) {
        this.f241577k = new PointF();
        this.f241567a = r100;
        this.f241568b = (WikiCoverCoordinatorLayout) r101.findViewById(R.id.wiki_coordinator_layout);
        this.f241569c = (AppBarLayout) r101.findViewById(R.id.wiki_appbar_layout);
        this.f241570d = (Toolbar) r101.findViewById(R.id.wiki_header_toolbar);
        this.f241572f = (BaseTitleBar) r101.findViewById(R.id.wiki_fixed_title_bar);
        this.f241571e = (SpaceCoverView) r101.findViewById(R.id.wiki_cover_view);
        this.f241573g = (WikiSearchPickerView) r101.findViewById(R.id.wiki_search_view);
        this.f241574h = ViewConfiguration.get(r100);
    }
}
