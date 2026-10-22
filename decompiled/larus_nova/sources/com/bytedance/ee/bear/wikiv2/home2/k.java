package com.bytedance.ee.bear.wikiv2.home2;

import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.KeyEventDispatcher;
import com.bytedance.ee.bear.facade.common.widget.NoNetworkView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.CircleRefreshHeader;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.larus.nova.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WikiHomeFragment2 f240841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f240842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.ee.bear.list.homepage.title.b f240843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartRefreshLayout f240844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CollapsingToolbarLayout f240845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppBarLayout f240846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BaseRecyclerView f240847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final cqa.e f240848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CircleRefreshHeader f240849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NoNetworkView f240850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f240851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f240852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f240853m;

    public static final class a {
    }

    public interface b {
        void onLoadMore();

        void onRefresh();
    }

    static {
    }

    public k(WikiHomeFragment2 r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f240841a = r100;
        View r101 = r100.getView();
        this.f240842b = r101;
        ActivityResultCaller r102 = r100.getParentFragment();
        KeyEventDispatcher.Component r103 = r100.getActivity();
        FrameLayout r104 = null;
        if (r102 != null) goto L5;
    L7:
        if (r103 != null) goto L9;
    L11:
        com.bytedance.ee.bear.list.homepage.title.b r105 = null;
    L12:
        this.f240843c = r105;
        if (r101 == null) goto L15;
        SmartRefreshLayout r106 = (SmartRefreshLayout) r101.findViewById(R.id.list_refresh_layout);
    L17:
        if ((r106 instanceof SmartRefreshLayout) == true) goto L20;
        r106 = null;
    L20:
        this.f240844d = r106;
        if (r101 == null) goto L23;
        CollapsingToolbarLayout r107 = (CollapsingToolbarLayout) r101.findViewById(R.id.list_collapsing_layout);
    L25:
        if ((r107 instanceof CollapsingToolbarLayout) == true) goto L28;
        r107 = null;
    L28:
        this.f240845e = r107;
        if (r101 == null) goto L31;
        AppBarLayout r108 = (AppBarLayout) r101.findViewById(R.id.list_sub_menu_layout);
    L33:
        if ((r108 instanceof AppBarLayout) == true) goto L36;
        r108 = null;
    L36:
        this.f240846f = r108;
        if (r101 == null) goto L39;
        BaseRecyclerView r109 = (BaseRecyclerView) r101.findViewById(R.id.list_recycler_view);
    L41:
        if ((r109 instanceof BaseRecyclerView) == true) goto L44;
        r109 = null;
    L44:
        this.f240847g = r109;
        if (r106 == null) goto L47;
        cqa.e r110 = r106.getRefreshHeader();
    L48:
        this.f240848h = r110;
        if (r101 == null) goto L51;
        CircleRefreshHeader r111 = (CircleRefreshHeader) r101.findViewById(R.id.list_appbar_refresh_header);
    L53:
        if ((r111 instanceof CircleRefreshHeader) == true) goto L56;
        r111 = null;
    L56:
        this.f240849i = r111;
        if (r101 == null) goto L59;
        NoNetworkView r112 = (NoNetworkView) r101.findViewById(R.id.no_net_container);
    L61:
        if ((r112 instanceof NoNetworkView) == true) goto L64;
        r112 = null;
    L64:
        this.f240850j = r112;
        if (r101 == null) goto L67;
        FrameLayout r113 = (FrameLayout) r101.findViewById(R.id.list_notification_container);
    L69:
        if ((r113 instanceof FrameLayout) == false) goto L71;
        r104 = r113;
    L71:
        this.f240851k = r104;
        return;
    L67:
        r113 = null;
        goto L69
    L59:
        r112 = null;
        goto L61
    L51:
        r111 = null;
        goto L53
    L47:
        r110 = null;
        goto L48
    L39:
        r109 = null;
        goto L41
    L31:
        r108 = null;
        goto L33
    L23:
        r107 = null;
        goto L25
    L15:
        r106 = null;
        goto L17
    L9:
        if ((r103 instanceof wc5.g) == false) goto L11;
        r105 = ((wc5.g) r103).getTitleBar();
        goto L12
    L5:
        if ((r102 instanceof wc5.g) == false) goto L7;
        r105 = ((wc5.g) r102).getTitleBar();
        goto L12
    }

    public final void a(boolean r100) {
        SmartRefreshLayout r101 = this.f240844d;
        if (r101 == null) goto L5;
        r101.h(true);
    L5:
        SmartRefreshLayout r102 = this.f240844d;
        if (r102 == null) goto L8;
        r102.D(false);
    L8:
        SmartRefreshLayout r103 = this.f240844d;
        if (r103 == null) goto L11;
        r103.g(r100);
    L11:
        SmartRefreshLayout r104 = this.f240844d;
        if (r104 == null) goto L15;
        r104.b(0, !r100);
        return;
    }
}
