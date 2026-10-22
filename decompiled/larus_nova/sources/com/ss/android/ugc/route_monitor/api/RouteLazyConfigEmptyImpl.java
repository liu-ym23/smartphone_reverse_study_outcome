package com.ss.android.ugc.route_monitor.api;

import android.app.Application;
import com.ss.android.ugc.route_monitor.impl.route_in.config.RouteInMonitorConfig;
import java.util.ArrayList;
import java.util.List;
import jhc.e;
import jhc.f;
import jhc.j;
import jhc.l;
import jhc.n;
import kotlin.Metadata;
import lhc.a;
import lhc.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/route_monitor/api/RouteLazyConfigEmptyImpl;", "Lcom/ss/android/ugc/route_monitor/api/IRouteLazyConfig;", "<init>", "()V", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final class RouteLazyConfigEmptyImpl implements IRouteLazyConfig {
    public RouteLazyConfigEmptyImpl() {
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final Application getApplication() {
        return null;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final boolean isDebug() {
        return false;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final boolean isLazy() {
        return false;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final RouteInMonitorConfig routeInMonitorConfig() {
        return null;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final a routeOutBackgroundComponentConfig() {
        return null;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<l> startActivityInterceptorList() {
        return null;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<e> bizLaunchModeInfoGetterList() {
        return new ArrayList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<f> bizLaunchModeInterceptorList() {
        return new ArrayList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final <T> List<T> preloadTaskMatchList() {
        return new ArrayList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<j> routeMonitorEventListenerList() {
        return new ArrayList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<n> routeOutExtraInterceptListenerList() {
        return new ArrayList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final List<b> routeOutPageReportConfigList() {
        return new ArrayList();
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final com.ss.android.ugc.route_monitor.impl.biz_event.a combineBizEventConfig() {
        return com.ss.android.ugc.route_monitor.impl.biz_event.b.f454421f;
    }

    @Override // com.ss.android.ugc.route_monitor.api.IRouteLazyConfig
    public final ihc.f getIHostAbility() {
        return com.ss.android.ugc.route_monitor.impl.e.f454422b;
    }
}
