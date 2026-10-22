package com.ss.android.ugc.route_monitor.api;

import android.app.Application;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.route_monitor.impl.biz_event.a;
import com.ss.android.ugc.route_monitor.impl.route_in.config.RouteInMonitorConfig;
import java.util.List;
import jhc.e;
import jhc.f;
import jhc.j;
import jhc.l;
import jhc.n;
import kotlin.Metadata;
import lhc.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/route_monitor/api/RouteLazyConfigProxy;", "Lcom/ss/android/ugc/route_monitor/api/IRouteLazyConfig;", "<init>", "()V", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class RouteLazyConfigProxy implements IRouteLazyConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RouteLazyConfigProxy f454387b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IRouteLazyConfig f454388a;

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<e> bizLaunchModeInfoGetterList() {
        return this.f454388a.bizLaunchModeInfoGetterList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<f> bizLaunchModeInterceptorList() {
        return this.f454388a.bizLaunchModeInterceptorList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final a combineBizEventConfig() {
        return this.f454388a.combineBizEventConfig();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final Application getApplication() {
        return this.f454388a.getApplication();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final ihc.f getIHostAbility() {
        return this.f454388a.getIHostAbility();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final boolean isDebug() {
        return this.f454388a.isDebug();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final boolean isLazy() {
        return this.f454388a.isLazy();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final <T> List<T> preloadTaskMatchList() {
        return this.f454388a.preloadTaskMatchList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final RouteInMonitorConfig routeInMonitorConfig() {
        return this.f454388a.routeInMonitorConfig();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<j> routeMonitorEventListenerList() {
        return this.f454388a.routeMonitorEventListenerList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final lhc.a routeOutBackgroundComponentConfig() {
        this.f454388a.routeOutBackgroundComponentConfig();
        return null;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<n> routeOutExtraInterceptListenerList() {
        return this.f454388a.routeOutExtraInterceptListenerList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<b> routeOutPageReportConfigList() {
        return this.f454388a.routeOutPageReportConfigList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<l> startActivityInterceptorList() {
        return this.f454388a.startActivityInterceptorList();
    }

    static {
        f454387b = new RouteLazyConfigProxy();
    }

    private RouteLazyConfigProxy() {
        this.f454388a = (IRouteLazyConfig) ServiceManager.get().getService(IRouteLazyConfig.class);
    }
}
