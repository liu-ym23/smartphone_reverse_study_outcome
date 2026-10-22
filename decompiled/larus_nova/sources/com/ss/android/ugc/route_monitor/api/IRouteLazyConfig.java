package com.ss.android.ugc.route_monitor.api;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
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
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0004H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0005H&J\b\u0010\u0019\u001a\u00020\u0002H&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001d\u001a\u00020\u001cH&¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/route_monitor/api/IRouteLazyConfig;", "", "", "isLazy", ExifInterface.GPS_DIRECTION_TRUE, "", "preloadTaskMatchList", "Ljhc/e;", "bizLaunchModeInfoGetterList", "Ljhc/f;", "bizLaunchModeInterceptorList", "Llhc/b;", "routeOutPageReportConfigList", "Ljhc/j;", "routeMonitorEventListenerList", "Ljhc/n;", "routeOutExtraInterceptListenerList", "Llhc/a;", "routeOutBackgroundComponentConfig", "Lcom/ss/android/ugc/route_monitor/impl/route_in/config/RouteInMonitorConfig;", "routeInMonitorConfig", "Lcom/ss/android/ugc/route_monitor/impl/biz_event/a;", "combineBizEventConfig", "Ljhc/l;", "startActivityInterceptorList", "isDebug", "Landroid/app/Application;", "getApplication", "Lihc/f;", "getIHostAbility", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public interface IRouteLazyConfig {
    List<e> bizLaunchModeInfoGetterList();

    List<f> bizLaunchModeInterceptorList();

    a combineBizEventConfig();

    Application getApplication();

    ihc.f getIHostAbility();

    boolean isDebug();

    boolean isLazy();

    <T> List<T> preloadTaskMatchList();

    RouteInMonitorConfig routeInMonitorConfig();

    List<j> routeMonitorEventListenerList();

    lhc.a routeOutBackgroundComponentConfig();

    List<n> routeOutExtraInterceptListenerList();

    List<b> routeOutPageReportConfigList();

    List<l> startActivityInterceptorList();
}
