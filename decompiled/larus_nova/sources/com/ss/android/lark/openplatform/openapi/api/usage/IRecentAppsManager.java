package com.ss.android.lark.openplatform.openapi.api.usage;

import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import java.util.List;

/* JADX INFO: loaded from: classes37.dex */
public interface IRecentAppsManager {
    void addDataChangeListener(DataChangeListener r100);

    void deleteRecentApp(String r100, RecentAppsManager.OnAppDeleteListener r101, IAppContext r102);

    List<AppLaunchInfo> getRecentAppList(RecentAppsManager.OnDataGetListener r100, IAppContext r101);

    boolean removeDataChangeListener(DataChangeListener r100);
}
