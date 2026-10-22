package com.bytedance.ee.bear.wikiv2.home2;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k {
    public final WikiHomeFragment2 a;
    public final View b;
    public final com.bytedance.ee.bear.list.homepage.title.b c;
    public final SmartRefreshLayout d;
    public final CollapsingToolbarLayout e;
    public final AppBarLayout f;
    public final BaseRecyclerView g;
    public final cqa.e h;
    public final CircleRefreshHeader i;
    public final NoNetworkView j;
    public final FrameLayout k;
    public int l;
    public b m;

    public static final class a {
    }

    public interface b {
        void onLoadMore();

        void onRefresh();
    }

    static {
    }

    public k(WikiHomeFragment2 r5) {
        Intrinsics.checkNotNullParameter(r5, "fragment");
        this.a = r5;
        View r0 = r5.getView();
        this.b = r0;
        wc5.g r1 = r5.getParentFragment();
        wc5.g r6 = r5.getActivity();
        FrameLayout r2 = null;
        if (r1 != null) goto L5;
    L7:
        if (r6 != null) goto L9;
    L11:
        com.bytedance.ee.bear.list.homepage.title.b r7 = null;
    L12:
        this.c = r7;
        if (r0 == null) goto L15;
        SmartRefreshLayout r8 = (SmartRefreshLayout) r0.findViewById(2131378171);
    L17:
        if ((r8 instanceof SmartRefreshLayout) == true) goto L20;
        r8 = null;
    L20:
        this.d = r8;
        if (r0 == null) goto L23;
        CollapsingToolbarLayout r3 = (CollapsingToolbarLayout) r0.findViewById(2131378079);
    L25:
        if ((r3 instanceof CollapsingToolbarLayout) == true) goto L28;
        r3 = null;
    L28:
        this.e = r3;
        if (r0 == null) goto L31;
        AppBarLayout r4 = (AppBarLayout) r0.findViewById(2131378183);
    L33:
        if ((r4 instanceof AppBarLayout) == true) goto L36;
        r4 = null;
    L36:
        this.f = r4;
        if (r0 == null) goto L39;
        BaseRecyclerView r9 = (BaseRecyclerView) r0.findViewById(2131378168);
    L41:
        if ((r9 instanceof BaseRecyclerView) == true) goto L44;
        r9 = null;
    L44:
        this.g = r9;
        if (r8 == null) goto L47;
        cqa.e r10 = r8.getRefreshHeader();
    L48:
        this.h = r10;
        if (r0 == null) goto L51;
        CircleRefreshHeader r11 = (CircleRefreshHeader) r0.findViewById(2131378060);
    L53:
        if ((r11 instanceof CircleRefreshHeader) == true) goto L56;
        r11 = null;
    L56:
        this.i = r11;
        if (r0 == null) goto L59;
        NoNetworkView r12 = (NoNetworkView) r0.findViewById(2131380933);
    L61:
        if ((r12 instanceof NoNetworkView) == true) goto L64;
        r12 = null;
    L64:
        this.j = r12;
        if (r0 == null) goto L67;
        FrameLayout r13 = (FrameLayout) r0.findViewById(2131378163);
    L69:
        if ((r13 instanceof FrameLayout) == false) goto L71;
        r2 = r13;
    L71:
        this.k = r2;
        return;
    L67:
        r13 = null;
        goto L69
    L59:
        r12 = null;
        goto L61
    L51:
        r11 = null;
        goto L53
    L47:
        r10 = null;
        goto L48
    L39:
        r9 = null;
        goto L41
    L31:
        r4 = null;
        goto L33
    L23:
        r3 = null;
        goto L25
    L15:
        r8 = null;
        goto L17
    L9:
        if ((r6 instanceof wc5.g) == false) goto L11;
        r7 = r6.getTitleBar();
        goto L12
    L5:
        if ((r1 instanceof wc5.g) == false) goto L7;
        r7 = r1.getTitleBar();
        goto L12
    }

    public final void a(boolean r4) {
        SmartRefreshLayout r0 = this.d;
        if (r0 == null) goto L5;
        r0.h(true);
    L5:
        SmartRefreshLayout r1 = this.d;
        if (r1 == null) goto L8;
        r1.D(false);
    L8:
        SmartRefreshLayout r2 = this.d;
        if (r2 == null) goto L11;
        r2.g(r4);
    L11:
        SmartRefreshLayout r3 = this.d;
        if (r3 == null) goto L15;
        r3.b(0, !r4);
        return;
    }
}
