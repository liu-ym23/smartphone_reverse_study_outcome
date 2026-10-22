package com.bytedance.ee.bear.bitable.homepage.chart.datasource;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes15.dex */
public final class UserScopeChartDataFetcher_Factory implements Factory<UserScopeChartDataFetcher> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UserScopeChartDataFetcher_Factory f212465a = null;

        static {
            f212465a = new UserScopeChartDataFetcher_Factory();
        }
    }

    public UserScopeChartDataFetcher_Factory() {
    }

    public static UserScopeChartDataFetcher newInstance() {
        return new UserScopeChartDataFetcher();
    }

    @Override // javax.inject.Provider
    public UserScopeChartDataFetcher get() {
        return newInstance();
    }

    public static UserScopeChartDataFetcher_Factory create() {
        return a.f212465a;
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }
}
