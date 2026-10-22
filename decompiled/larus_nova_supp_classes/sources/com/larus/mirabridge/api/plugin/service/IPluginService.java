package com.larus.mirabridge.api.plugin.service;

import al9.a;
import android.util.EventsUtils;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.bean.PluginLoadResult;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002)*J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u001c\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004H&J\u001c\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004H&J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\fH&J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\fH&J(\u0010\u001b\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0000\u0010\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u000eH&J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H&J(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020$0#\"\u0004\b\u0000\u0010\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0004H&J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010(\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0016R&\u0010\u0002\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006+"}, d2 = {"Lcom/larus/mirabridge/api/plugin/service/IPluginService;", XmlPullParser.NO_NAMESPACE, "pluginMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/larus/mirabridge/api/bean/PluginInfo;", "getPluginMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "activatePluginMap", "getActivatePluginMap", "getPluginPageNameSet", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "isSPIAvailable", XmlPullParser.NO_NAMESPACE, "T", "pluginService", "deactivateSPIService", XmlPullParser.NO_NAMESPACE, "startPluginListActivity", "activity", "Landroid/app/Activity;", "loadLibrary", "Lcom/larus/mirabridge/api/plugin/IPluginLoadTask;", "soName", "deletePluginFile", "pluginPackageName", "getPlugin", "clz", "silent", "loadPluginNew", "pluginLoadBuilder", "Lcom/larus/mirabridge/api/bean/PluginLoadBuilder$PluginLoadConfig;", "bindPluginNew", "bindService", "Lkotlin/Pair;", "Lcom/larus/mirabridge/api/bean/PluginLoadResult;", "preloadLibrary", "isPluginReady", "isPlugin", "unInstallPlugin", "PluginName", "PluginService", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IPluginService {
    void a(PluginLoadBuilder.c r1);

    Set<String> b();

    <T> Pair<Boolean, PluginLoadResult> bindService(Class<T> r1);

    <T> boolean c(Class<T> r1);

    ConcurrentHashMap<Class<?>, a<?>> d();
}
