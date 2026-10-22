package com.bytedance.ee.bear.bitable.homepage.chart.datasource;

import androidx.lifecycle.LifecycleOwner;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes15.dex */
@UserScope
public final class UserScopeChartDataFetcher implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LifecycleOwner> f212460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f212461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f212462c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.e
    public final void a() {
        ((ChartDataFetcher) this.f212462c.getValue()).a();
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.e
    public final MutableSharedFlow b() {
        return ((ChartDataFetcher) this.f212462c.getValue()).f212457f;
    }

    @Inject
    public UserScopeChartDataFetcher() {
        this.f212460a = new ArrayList();
        this.f212461b = new g();
        this.f212462c = LazyKt.lazy(new UserScopeChartDataFetcher$innerChartDataFetcher$2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.e
    public final void c(final LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        int r101 = com.bytedance.ee.bear.bitable.homepage.chart.utils.d.f212638a;
        if (((ArrayList) this.f212460a).contains(r100) == true) goto L6;
        ((ArrayList) this.f212460a).add(r100);
        r100.getLifecycle().addObserver(new UserScopeChartDataFetcher$addDataObserver$1(this, r100));
        tt5.a.h("UserScopeChartDataFetcher", "addDataObserver, observer size is " + ((ArrayList) this.f212460a).size());
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.homepage.chart.datasource.e
    public final void d(String r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "chartToken");
        ((ChartDataFetcher) this.f212462c.getValue()).d(r100, r101, r102);
    }
}
