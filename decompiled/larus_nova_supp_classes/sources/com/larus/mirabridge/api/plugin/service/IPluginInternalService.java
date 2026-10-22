package com.larus.mirabridge.api.plugin.service;

import android.app.Application;
import android.util.EventsUtils;
import kotlin.Metadata;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0013H'J\"\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0010H&¨\u0006\u001d"}, d2 = {"Lcom/larus/mirabridge/api/plugin/service/IPluginInternalService;", XmlPullParser.NO_NAMESPACE, "initMira", XmlPullParser.NO_NAMESPACE, "app", "Landroid/app/Application;", "fixWebView", "initMorpheus", "registerMiraInitCallback", "callback", "Lkotlin/Function0;", "unregisterMiraInitCallback", "ensureFrameworkReady", "timeout", XmlPullParser.NO_NAMESPACE, "isFrameworkInited", XmlPullParser.NO_NAMESPACE, "isNotPlugin", "packageName", XmlPullParser.NO_NAMESPACE, "getDefaultPluginLoadUIFactory", "Lcom/larus/mirabridge/api/plugin/abs/IPluginLoadUIFactory;", "afterReady", "plugin", "applyLoadStyle", "pluginPackageName", "task", "Lcom/larus/mirabridge/api/plugin/IPluginLoadTask;", "silent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IPluginInternalService {
    void a(String r1);

    void b(Application r1);

    void c(long r1);

    void d(Application r1);
}
