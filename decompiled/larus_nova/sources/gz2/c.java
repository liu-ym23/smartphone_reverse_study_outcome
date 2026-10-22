package gz2;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.HybridSettingInitConfig;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.apm.ApmAgent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f483375a = null;

    static {
        f483375a = a().getMethod("onEventV3", new Class[]{String.class, JSONObject.class});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.ss.android.common.lib.AppLogNewUtils");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.ss.android.common.lib.AppLogNewUtils");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.ss.android.common.lib.AppLogNewUtils");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.ss.android.common.lib.AppLogNewUtils");
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter("custom", "eventName");
        Intrinsics.checkNotNullParameter(r100, "bid");
        if (TextUtils.isEmpty("custom") == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.monitorV2.util.d.d(r100) == true) goto L8;
        return;
    L8:
        JSONObject r101 = new JSONObject();
        l.q(r101, ReportCardMonitorPlugin.EVENT_NAME, "custom");
        l.q(r101, "bid", r100);
        f("hybridmonitor_report_all", r101);
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, new JSONObject("{\"extra\":{\"client_category\":{\"bid\":\"" + r100 + "\",\"event_type\":\"custom\"},\"client_extra\":{\"event_name\":\"hybridmonitor_report_all\"},\"ev_type\":\"custom\"}}"));
    }

    public static void c(com.bytedance.android.monitorV2.event.a r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Intrinsics.checkNotNullParameter(r111, "bid");
        if (Switches.teaReport.isEnabled() == true) goto L6;
        return;
    L6:
        if (r110.f163008h != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual("jsbPv", r110.f163001a) == false) goto L32;
        JSONObject r100 = r110.f163006f.toJsonObject();
        String r101 = l.l(r100, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE);
        if (Intrinsics.areEqual(r101, "lynx") == false) goto L14;
        String r102 = r100.optString("lynx_version", null);
    L17:
        jz2.a r103 = r110.f163008h;
        if (r103 == null) goto L20;
        JSONObject r104 = r103.toJsonObject();
    L21:
        fz2.b r105 = r110.f163019m;
        if (r105 == null) goto L24;
        JSONObject r106 = r105.toJsonObject();
    L25:
        HybridSettingInitConfig r107 = com.bytedance.android.monitorV2.g.e().d().getInitConfig();
        if (r107 == null) goto L28;
        String r108 = r107.f163089a;
    L29:
        String r109 = l.m(r100, "url", "");
        String r112 = l.m(r104, "container_name", "other");
        String r113 = l.m(r104, "schema", null);
        String r114 = l.m(r104, "container_version", null);
        JSONObject r115 = l.c(null, r106);
        l.e(r115, "url", r109);
        l.e(r115, "engine_version", r102);
        l.e(r115, "engine_type", r101);
        l.e(r115, "schema", r113);
        l.e(r115, "container_version", r114);
        l.e(r115, "container_name", r112);
        l.e(r115, "bid", r111);
        l.e(r115, "origin_appid", r108);
        f("bd_hybrid_monitor_jsb_pv", r115);
        r110.f();
        return;
    L28:
        r108 = "";
        goto L29
    L24:
        r106 = null;
        goto L25
    L20:
        r104 = null;
        goto L21
    L14:
        if (Intrinsics.areEqual(r101, "web") == false) goto L16;
        r102 = r100.optString("web_version", null);
        goto L17
    L16:
        r102 = null;
        goto L17
    }

    public static void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "bid");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (com.bytedance.android.monitorV2.util.d.d(r101) == true) goto L8;
        return;
    L8:
        JSONObject r102 = new JSONObject();
        l.q(r102, ReportCardMonitorPlugin.EVENT_NAME, r100);
        l.q(r102, "bid", r101);
        f("hybridmonitor_report_sample", r102);
    }

    public static void f(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Method r102 = f483375a;
        if (r102 != null) goto L10;
        return;
    L10:
        r102.invoke(null, new Object[]{r100, r101});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    public static void d(com.bytedance.android.monitorV2.event.a r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "bid");
        if (Switches.teaReport.isEnabled() == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("navigationStart", r100.f163001a) == false) goto L44;
        JSONObject r103 = new JSONObject();
        NativeCommon r104 = r100.f163006f;
        if (r104 != null) goto L10;
        return;
    L10:
        if (r100.f163008h == null) goto L46;
        JSONObject r105 = r104.toJsonObject();
        if (r105 == null) goto L27;
        l.q(r103, "url", l.l(r105, "url"));
        String r106 = l.l(r105, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE);
        l.q(r103, "engine_type", r106);
        if (Intrinsics.areEqual("lynx", r106) == false) goto L18;
        String r107 = r105.optString("lynx_version", null);
    L21:
        if (r107 == null) goto L23;
        l.q(r103, "engine_version", r107);
    L23:
        String r108 = r105.optString("native_page", null);
        if (r108 == null) goto L26;
        l.q(r103, "native_page", r108);
    L26:
        l.q(r103, "sdk_version", l.l(r105, "sdk_version"));
        goto L27
    L18:
        if (Intrinsics.areEqual("web", r106) == false) goto L20;
        r107 = r105.optString("web_version", null);
        goto L21
    L20:
        r107 = null;
    L27:
        jz2.a r109 = r100.f163008h;
        if (r109 == null) goto L30;
        JSONObject r110 = r109.toJsonObject();
    L31:
        if (r110 == null) goto L38;
        String r111 = r110.optString("schema", null);
        if (r111 == null) goto L35;
        l.q(r103, "schema", r111);
    L35:
        l.q(r103, "container_name", r110.optString("container_name", "other"));
        String r112 = r110.optString("container_version", null);
        if (r112 == null) goto L38;
        l.q(r103, "container_version", r112);
    L38:
        l.q(r103, "bid", r101);
        l.n(r103, "is_hybrid_sample", r102 ? 1 : 0);
        HybridSettingInitConfig r113 = com.bytedance.android.monitorV2.g.e().d().getInitConfig();
        if (r113 == null) goto L41;
        String r114 = r113.f163089a;
    L42:
        l.q(r103, "origin_appid", r114);
        f("bd_hybrid_monitor_pv", r103);
        return;
    L41:
        r114 = "";
        goto L42
    L30:
        r110 = null;
        goto L31
    L46:
        return;
    }
}
