package com.bytedance.ee.bear.bitable.homepage.chart;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bitable.homepage.chart.entity.ChartEntity;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.homepage.chart.datasource.e f212586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f212587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChartConfig.a f212588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f212589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f212590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f212591f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f212592g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayoutManager f212593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RecyclerView.Adapter<?> f212594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k f212595j;

    public static final class a {
    }

    static {
    }

    public final void d() {
        if (this.f212595j != null) goto L5;
    L11:
        boolean r100 = false;
    L12:
        if (r100 == false) goto L15;
        return;
    L15:
        throw new IllegalStateException("You must attach correct RecyclerView first");
    L5:
        if (this.f212592g == null) goto L11;
        if (this.f212594i == null) goto L11;
        if (this.f212593h == null) goto L11;
        r100 = true;
        goto L12
    }

    public static final void a(i r100) {
        r100.d();
        RecyclerView.Adapter<?> r101 = r100.f212594i;
        RecyclerView r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L6:
        if (r101.getItemCount() <= 0) goto L14;
        RecyclerView r103 = r100.f212592g;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L12:
        r102.post(new j(r100));
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public i(com.bytedance.ee.bear.bitable.homepage.chart.datasource.e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fetcher");
        this.f212586a = r100;
        this.f212587b = r101;
        ChartConfig r102 = (ChartConfig) SettingManager.getInstance().get(ChartConfig.class);
        if (r102 != null) goto L5;
        r102 = new ChartConfig();
    L5:
        this.f212588c = r102.e();
        this.f212590e = new LinkedHashSet();
        this.f212591f = new LinkedHashSet();
    }

    public final void b(CommonRecyclerView r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "chartEntityProvider");
        this.f212592g = r100;
        this.f212595j = r101;
        if (r100.getTag(R.id.bitable_homepage_tag_fetcher_helper) == null) goto L12;
        LarkAppContext.Companion.getClass();
        if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L11;
        if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L11;
        tt5.a.e("ChartDataFetcherHelper", "already attached a fetcher helper", new RuntimeException("already attached a fetcher helper"), false);
        return;
    L11:
        throw new RuntimeException("already attached a fetcher helper");
    L12:
        RecyclerView.Adapter<?> r102 = r100.getAdapter();
        if (r102 != null) goto L22;
        LarkAppContext.Companion.getClass();
        if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L21;
        if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L21;
        tt5.a.e("ChartDataFetcherHelper", "recyclerView must have an adapter", new RuntimeException("recyclerView must have an adapter"), false);
        return;
    L21:
        throw new RuntimeException("recyclerView must have an adapter");
    L22:
        this.f212594i = r102;
        RecyclerView.LayoutManager r103 = r100.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == true) goto L32;
        LarkAppContext.Companion.getClass();
        if (DevEnvUtil.isDebugMode(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L31;
        if (DevEnvUtil.isDevelopPackage(LarkAppContext.access$getInstance$cp().getContext()) == true) goto L31;
        tt5.a.e("ChartDataFetcherHelper", "recyclerView must use LinearLayoutManager", new RuntimeException("recyclerView must use LinearLayoutManager"), false);
        return;
    L31:
        throw new RuntimeException("recyclerView must use LinearLayoutManager");
    L32:
        this.f212593h = (LinearLayoutManager) r103;
        r100.setTag(R.id.bitable_homepage_tag_fetcher_helper, this);
        d();
        RecyclerView r104 = this.f212592g;
        RecyclerView.Adapter<?> r105 = null;
        if (r104 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r104 = null;
    L35:
        r104.addOnScrollListener(new ChartDataFetcherHelper$observeRecyclerViewScrolled$1(this));
        d();
        RecyclerView.Adapter<?> r106 = this.f212594i;
        if (r106 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L39:
        r105.registerAdapterDataObserver(new ChartDataFetcherHelper$observeDataSetChanged$1(this));
        return;
    L38:
        r105 = r106;
        goto L39
    }

    public static void c(i r100, int r101, int r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L9;
        LinearLayoutManager r105 = r100.f212593h;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r105 = null;
    L7:
        r101 = r105.findFirstVisibleItemPosition();
    L9:
        if ((r104 & 2) == 0) goto L15;
        LinearLayoutManager r106 = r100.f212593h;
        if (r106 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
        r106 = null;
    L13:
        r102 = r106.findLastVisibleItemPosition();
    L15:
        if ((r104 & 4) == 0) goto L17;
        r103 = false;
    L17:
        r100.d();
        if (r100.f212589d == true) goto L90;
        r100.f212589d = true;
        IntRange r107 = new IntRange(r101 - r100.f212588c.b(), r102 + r100.f212588c.b());
        ArrayList r108 = new ArrayList();
        Iterator<Integer> r109 = r107.iterator();
    L22:
        if (r109.hasNext() == false) goto L34;
        Integer r110 = r109.next();
        int r111 = r110.intValue();
        if (r111 < 0) goto L31;
        RecyclerView.Adapter<?> r112 = r100.f212594i;
        if (r112 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r112 = null;
    L29:
        if (r111 >= r112.getItemCount()) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L22;
        r108.add(r110);
    L31:
        r113 = false;
        goto L32
    L34:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r108.iterator();
    L36:
        if (r115.hasNext() == false) goto L46;
        int r116 = ((Number) r115.next()).intValue();
        k r117 = r100.f212595j;
        if (r117 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("entityProvider");
        r117 = null;
    L40:
        ChartEntity r118 = r117.x2(r116);
        if (r118 == null) goto L43;
        String r119 = r118.getChartToken();
    L44:
        if (r119 == null) goto L36;
        r114.add(r119);
        goto L36
    L43:
        r119 = null;
        goto L44
    L46:
        ArrayList r120 = new ArrayList();
        Iterator r121 = r114.iterator();
    L48:
        if (r121.hasNext() == false) goto L53;
        Object r122 = r121.next();
        if ((!StringsKt.isBlank((String) r122)) == false) goto L48;
        r120.add(r122);
        goto L48
    L53:
        if ((!r120.isEmpty()) == false) goto L66;
        r100.f212591f.clear();
        Iterator r123 = r120.iterator();
    L56:
        if (r123.hasNext() == false) goto L62;
        String r124 = (String) r123.next();
        if (r103 == true) goto L61;
        if (r100.f212590e.contains(r124) == true) goto L56;
    L61:
        r100.f212591f.add(r124);
        goto L56
    L62:
        r100.f212590e.clear();
        r100.f212590e.addAll(r120);
        Iterator<T> r125 = r100.f212591f.iterator();
    L64:
        if (r125.hasNext() == false) goto L66;
        r100.f212586a.d((String) r125.next(), false, r100.f212587b);
    L66:
        r100.f212589d = false;
        return;
    }
}
