package com.larus.mirabridge.impl;

import android.os.Looper;
import android.text.TextUtils;
import cl9.g;
import com.bytedance.mira.Mira;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.bean.PluginLoadResult;
import com.larus.mirabridge.api.plugin.service.IPluginInternalService;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import l27.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class LoadingManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f359324a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f359325b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f359326c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f359327d = null;

    public LoadingManager() {
    }

    static {
        f359324a = LazyKt.lazy(new a());
        f359325b = LazyKt.lazy(new b());
        f359326c = LazyKt.lazy(new c());
        f359327d = LazyKt.lazy(new d());
    }

    public static CoroutineScope d() {
        return (CoroutineScope) f359324a.getValue();
    }

    public static final void a(final PluginLoadBuilder.c r110) {
        if (r110.f359313h == (-1)) goto L7;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely wait framework ready " + r110.f359313h);
        IPluginInternalService r100 = (IPluginInternalService) f359326c.getValue();
        if (r100 == null) goto L7;
        r100.c(r110.f359313h);
    L7:
        g.f24138a.getClass();
        if (g.e() == true) goto L12;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely not inited");
        PluginLoadBuilder.b r111 = r110.f359311f;
        if (r111 == null) goto L98;
        r111.onFailed();
        return;
    L98:
        return;
    L12:
        Lazy r101 = f359327d;
        if (((Map) r101.getValue()).containsKey(r110.f359306a) == false) goto L32;
        List r102 = (List) ((Map) r101.getValue()).get(r110.f359306a);
        if (r102 != null) goto L18;
        r102 = CollectionsKt.emptyList();
    L18:
        if ((!r102.isEmpty()) == false) goto L32;
        Plugin r103 = Mira.getPlugin(r110.f359306a);
        if (r103 != null) goto L26;
        PluginLoadBuilder.b r104 = r110.f359311f;
        if (r104 == null) goto L24;
        r104.onFailed();
    L24:
        FLogger.f375446a.i("LoadingManager", "插件未安装，无法检查版本黑名单: " + r110.f359306a);
        return;
    L26:
        if (r102.contains(String.valueOf(r103.mVersionCode)) == false) goto L32;
        Mira.unInstallPlugin(r110.f359306a);
        PluginLoadBuilder.b r105 = r110.f359311f;
        if (r105 == null) goto L30;
        r105.onFailed();
    L30:
        FLogger.f375446a.i("LoadingManager", "插件版本在黑名单中,不能加载: " + r110.f359306a);
        return;
    L32:
        if (e.d().f507156i == true) goto L37;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely not request config");
        e r106 = e.d();
        if (r106.f507148a == null) goto L37;
        MiraLogger.d(e.f507145j, "syncFetchPlugins start");
        new l27.a(r106, 0).run();
    L37:
        if (Mira.isPluginInstalled(r110.f359306a) == false) goto L89;
        String r107 = r110.f359306a;
        e r108 = e.d();
        r108.getClass();
        Plugin r109 = Mira.getPlugin(r107);     // Catch: Exception -> L79
        if (r109 == null) goto L80;
        if (r109.mLifeCycle >= 8) goto L80;
        Long r112 = (Long) ((ConcurrentHashMap) r108.f507152e).get(r107);     // Catch: Exception -> L79
        if (r112 == null) goto L50;
        if ((System.currentTimeMillis() - r112.longValue()) < 5000) goto L80;
    L50:
        if (TextUtils.isEmpty(r107) == true) goto L55;
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L79
        JSONArray r114 = new JSONArray();     // Catch: Exception -> L79
        Plugin r115 = Mira.getPlugin(r107);     // Catch: Exception -> L79
        if (r115 == null) goto L55;
        r114.put(l27.c.b(r115, null));     // Catch: Exception -> L79
        r113.put(CloudControlInf.PLUGIN, r114);     // Catch: Exception -> L79
        r113.put("auto_request", false);     // Catch: Exception -> L79
        String r116 = r113.toString();     // Catch: Exception -> L79
    L56:
        byte[] r117 = r116.getBytes();     // Catch: Exception -> L79
        if (r117 == null) goto L80;
        String r118 = h27.a.f483619b.a(r117);     // Catch: Exception -> L79
        if (TextUtils.isEmpty(r118) == true) goto L80;
        JSONArray r119 = JSONObjectProtectorUtils.getJSONObject(new JSONObject(r118), "data").optJSONArray(CloudControlInf.PLUGIN);     // Catch: Exception -> L79
        ((ConcurrentHashMap) r108.f507152e).put(r107, Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L79
        if (r119.length() < 1) goto L80;
        l27.b r120 = l27.c.d(JSONArrayProtectorUtils.getJSONObject(r119, 0), false);     // Catch: Exception -> L79
        if (r120.f507135h == true) goto L80;
        if (r120.f507136i == true) goto L80;
        monitor-enter(r108);     // Catch: Exception -> L79
    L76:
        th = move-exception;
        throw th;     // Catch: Exception -> L79
        goto L80
    L72:
        if (e.i(r120, r108.f507151d, false) == true) goto L74;
        e.i(r120, r108.f507153f, true);     // Catch: Throwable -> L76
    L74:
        monitor-exit(r108);     // Catch: Throwable -> L76
        boolean r121 = true;
    L81:
        if (r121 == true) goto L89;
        if (r110.f359314i == false) goto L88;
        PluginLoadBuilder.b r122 = r110.f359311f;
        if (r122 == null) goto L102;
        r122.onSuccess();
        return;
    L102:
        return;
    L88:
        b(r110);
        return;
    L55:
        r116 = null;
    L80:
        r121 = false;
    L89:
        h27.c r123 = h27.c.a();
        ((CopyOnWriteArrayList) r123.f483623b).add(new LoadingManager$loadPluginInner$1(r110));
        BuildersKt.launch$default((CoroutineScope) f359325b.getValue(), null, null, new LoadingManager$loadPluginInner$2(r110, null), 3, null);
        if (r110.f359309d != PluginLoadBuilder.PluginLoadTime.IMMEDIATE) goto L92;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely downloadAndInstallImmediately " + r110);
        String r124 = r110.f359306a;
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, "downloadAndInstallImmediately " + r124);
        e.d().c(r124, 1);
        return;
    L92:
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely downloadAndInstall " + r110);
        e.d().c(r110.f359306a, 0);
    }

    public static void b(PluginLoadBuilder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginLoadConfig");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        BuildersKt.launch$default(d(), null, null, new LoadingManager$doAfterPluginDownloaded$1(r100, null), 3, null);
        return;
    L5:
        c(r100);
    }

    public static void c(PluginLoadBuilder.c r100) {
        g.f24138a.getClass();     // Catch: Throwable -> L62
        if (g.e() == true) goto L9;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely not inited");     // Catch: Throwable -> L62
        PluginLoadBuilder.b r101 = r100.f359311f;     // Catch: Throwable -> L62
        if (r101 == null) goto L68;
        r101.onFailed();     // Catch: Throwable -> L62
        return;
    L68:
        return;
    L9:
        Lazy r102 = f359327d;     // Catch: Throwable -> L62
        boolean r103 = true;
        if (((Map) r102.getValue()).containsKey(r100.f359306a) == false) goto L31;
        List r104 = (List) ((Map) r102.getValue()).get(r100.f359306a);     // Catch: Throwable -> L62
        if (r104 != null) goto L15;
        r104 = CollectionsKt.emptyList();     // Catch: Throwable -> L62
    L15:
        if ((!r104.isEmpty()) == false) goto L31;
        Plugin r105 = Mira.getPlugin(r100.f359306a);     // Catch: Throwable -> L62
        if (r105 != null) goto L24;
        PluginLoadBuilder.b r106 = r100.f359311f;     // Catch: Throwable -> L62
        if (r106 == null) goto L21;
        r106.onFailed();     // Catch: Throwable -> L62
    L21:
        FLogger.f375446a.i("LoadingManager", "插件未安装，无法检查版本黑名单: " + r100.f359306a);     // Catch: Throwable -> L62
        return;
    L24:
        if (r104.contains(String.valueOf(r105.mVersionCode)) == false) goto L31;
        Mira.unInstallPlugin(r100.f359306a);     // Catch: Throwable -> L62
        PluginLoadBuilder.b r107 = r100.f359311f;     // Catch: Throwable -> L62
        if (r107 == null) goto L28;
        r107.onFailed();     // Catch: Throwable -> L62
    L28:
        FLogger.f375446a.i("LoadingManager", "插件版本在黑名单中,不能加载: " + r100.f359306a);     // Catch: Throwable -> L62
        return;
    L31:
        if (Mira.isPluginLoaded(r100.f359306a) == true) goto L33;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely loadPlugin pending");     // Catch: Throwable -> L62
        boolean r108 = Mira.loadPlugin(r100.f359306a);     // Catch: Throwable -> L62
    L34:
        if (r108 == true) goto L39;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely loadPlugin failed");     // Catch: Throwable -> L62
        PluginLoadBuilder.b r109 = r100.f359311f;     // Catch: Throwable -> L62
        if (r109 == null) goto L69;
        r109.onFailed();     // Catch: Throwable -> L62
        return;
    L69:
        return;
    L39:
        IPluginService r110 = (IPluginService) ServiceManager.get().getService(IPluginService.class);     // Catch: Throwable -> L62
        if (r110 == null) goto L45;
        Class<?> r111 = r100.f359307b;     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L62
        if (r110.c(r111) != true) goto L45;
        boolean r112 = true;
    L46:
        if (r112 == true) goto L53;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely bindService not available");     // Catch: Throwable -> L62
        if (r110 == null) goto L52;
        Class<?> r113 = r100.f359307b;     // Catch: Throwable -> L62
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type java.lang.Class<*>");     // Catch: Throwable -> L62
        Pair<Boolean, PluginLoadResult> r114 = r110.bindService(r113);     // Catch: Throwable -> L62
        if (r114 == null) goto L52;
        r103 = r114.getFirst().booleanValue();     // Catch: Throwable -> L62
    L52:
        r103 = false;
    L53:
        if (r103 == true) goto L58;
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely bindService failed");     // Catch: Throwable -> L62
        PluginLoadBuilder.b r115 = r100.f359311f;     // Catch: Throwable -> L62
        if (r115 == null) goto L70;
        r115.onFailed();     // Catch: Throwable -> L62
        return;
    L70:
        return;
    L58:
        FLogger.f375446a.i("LoadingManager", "loadPluginSafely bindService success");     // Catch: Throwable -> L62
        PluginLoadBuilder.b r116 = r100.f359311f;     // Catch: Throwable -> L62
        if (r116 == null) goto L71;
        r116.onSuccess();     // Catch: Throwable -> L62
        return;
    L71:
        return;
    L45:
        r112 = false;
        goto L46
    L33:
        r108 = true;
    L62:
        th = move-exception;
        FLogger.f375446a.e("LoadingManager", "loadPluginSafely loadPlugin failed " + th);
        PluginLoadBuilder.b r117 = r100.f359311f;
        if (r117 == null) goto L72;
        r117.onFailed();
        return;
    }

    public static void e(PluginLoadBuilder.c r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginLoadConfig");
        BuildersKt.launch$default(d(), null, null, new LoadingManager$loadPlugin$1(r100, null), 3, null);
    }
}
