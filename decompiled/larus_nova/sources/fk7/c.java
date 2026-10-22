package fk7;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.ug.sdk.luckydog.api.ab.ABScheme;
import com.bytedance.ug.sdk.luckydog.api.ab.ABSchemeType;
import com.bytedance.ug.sdk.luckydog.api.ab.ABService;
import com.bytedance.ug.sdk.luckydog.api.ab.ABServiceEffectTime;
import com.bytedance.ug.sdk.luckydog.api.ab.ABServiceType;
import com.bytedance.ug.sdk.luckydog.api.log.e;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends d>, d> f477660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends d>, ArrayList<String>> f477661b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<? extends d>, String> f477662c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f477663d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Class<? extends d>, Set<b>> f477664e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f477665f = null;

    static {
        f477660a = new ConcurrentHashMap();
        HashMap r100 = new HashMap();
        f477661b = r100;
        f477662c = new HashMap();
        f477663d = new Object();
        f477664e = new HashMap();
        f477665f = new AtomicBoolean(false);
        ArrayList r101 = (ArrayList) r100.get(ILuckyDogSettingsService.class);
        if (r101 != null) goto L5;
        r101 = new ArrayList();
        r100.put(ILuckyDogSettingsService.class, r101);
    L5:
        r101.add("com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.LuckyDogCommonSettingServiceImpl");
        com.bytedance.ug.sdk.luckydog.api.log.d.a("ABServiceManager", "connect(), service =ILuckyDogSettingsService, implClass =com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.LuckyDogCommonSettingServiceImpl");
    }

    public static void d() {
        if (f477665f.getAndSet(true) == true) goto L39;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "registerService() is called");
        Iterator r100 = ((HashMap) f477661b).keySet().iterator();     // Catch: Throwable -> L22
    L6:
        if (r100.hasNext() == false) goto L40;
        Class r101 = (Class) r100.next();     // Catch: Throwable -> L22
        if (r101 == null) goto L6;
        ABService r102 = (ABService) r101.getAnnotation(ABService.class);     // Catch: Throwable -> L22
        if (r102 == null) goto L13;
        String r103 = ABServiceType.getServiceId(r102.serviceType());     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r103) == true) goto L16;
        if (r102.effectTime() != ABServiceEffectTime.RealTime) goto L20;
        ((HashMap) f477662c).put(r101, r103);     // Catch: Throwable -> L22
    L20:
        c(r101, r103);     // Catch: Throwable -> L22
        goto L6
    L16:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ABServiceManager", r101.getSimpleName() + " @ABService serviceId is empty");     // Catch: Throwable -> L22
        goto L6
    L13:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ABServiceManager", r101.getSimpleName() + " has not @ABService Annotation");     // Catch: Throwable -> L22
        goto L6
    L40:
        return;
    L22:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogLogger_", th.toString());
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static d b(Class<? extends d> r100) {
        if (f477665f.get() == true) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "get(), service is not registered");
        d();
    L5:
        d r101 = (d) ((ConcurrentHashMap) f477660a).get(r100);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "get(), service =" + r100.getSimpleName() + ", impl =" + r101);
        if (r101 != null) goto L12;
        String r102 = r100.getSimpleName();
        JSONObject r103 = new JSONObject();
        r103.put("service", r102);     // Catch: JSONException -> L10
        e.a("luckydog_ab_service_get_fail", r103, null);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return r101;
    }

    public static void c(Class<? extends d> r110, String r111) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "getSchemeId() called; serviceId = " + r111);
        a.C5920a.f477659a.getClass();
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceConfigManager", "getLatestConfig(), mLocalConfigStr = " + a.f477658a);
        Class r100 = null;
        JSONObject r101 = new JSONObject(a.f477658a);     // Catch: JSONException -> L5
    L8:
        if (r101 == null) goto L26;
        if (r111 == null) goto L26;
        JSONArray r102 = r101.optJSONArray("module_dimension");
        if (r102 != null) goto L13;
    L23:
        String r103 = null;
    L24:
        if (r103 != null) goto L28;
        r103 = r101.optString("global_dimension");
    L28:
        if (StringUtils.isEmpty(r103) == false) goto L30;
        r103 = "default";
    L30:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "injectService(), serviceId = " + r111 + "schemeId = " + r103);
        ArrayList r112 = (ArrayList) ((HashMap) f477661b).get(r110);
        if (r112 != null) goto L33;
    L57:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ABServiceManager", "injectService(), " + r110.getSimpleName() + "has no implementation class");
        return;
    L33:
        if (r112.isEmpty() == true) goto L57;
        Iterator r113 = r112.iterator();     // Catch: Throwable -> L53
    L37:
        if (r113.hasNext() == false) goto L50;
        String r104 = (String) r113.next();     // Catch: Throwable -> L53
        Class r105 = a(r104);     // Catch: Throwable -> L53
        ABScheme r106 = (ABScheme) r105.getAnnotation(ABScheme.class);     // Catch: Throwable -> L53
        if (r106 == null) goto L40;
        if (r106.schemeType() == ABSchemeType.getSchemeType(r103)) goto L48;
        if (r106.isDefault() == false) goto L37;
        if ("default".equals(r103) == true) goto L48;
        r100 = r105;
    L48:
        r100 = r105;
        goto L50
    L40:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ABServiceManager", "injectService(), " + r104 + " has not @ABScheme Annotation");     // Catch: Throwable -> L53
    L50:
        if (r100 == null) goto L55;
        e(r110, (d) r100.getConstructor(new Class[0]).newInstance(new Object[0]));     // Catch: Throwable -> L53
        return;
    L55:
        com.bytedance.ug.sdk.luckydog.api.log.d.b("ABServiceManager", "injectService(), " + r110.getSimpleName() + " inject failed!!!");
        return;
    L53:
        th = move-exception;
        th.printStackTrace();
        goto L55
    L13:
        if (r102.length() <= 0) goto L23;
        int r107 = 0;
    L16:
        if (r107 >= r102.length()) goto L23;
        JSONObject r108 = r102.optJSONObject(r107);
        if (r108 == null) goto L22;
        if (r111.equals(r108.optString("module_name")) == false) goto L22;
        r103 = r108.optString("ab_value");
    L22:
        r107 = r107 + 1;
    L26:
        r103 = null;
    L5:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L8
    }

    public static void e(Class<? extends d> r100, d r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "set(), service =" + r100.getSimpleName() + ", implClass =" + r101);
        ConcurrentHashMap r102 = (ConcurrentHashMap) f477660a;
        d r103 = (d) r102.get(r100);
        if (r101 != null) goto L7;
        r102.remove(r100);
    L8:
        if (r103 == r101) goto L24;
        Object r104 = f477663d;
        monitor-enter(r104);
        Set r105 = (Set) ((HashMap) f477664e).get(r100);     // Catch: Throwable -> L21
        if (r105 != null) goto L14;
    L19:
        monitor-exit(r104);     // Catch: Throwable -> L21
        return;
    L14:
        if (r105.isEmpty() == true) goto L19;
        Iterator r106 = r105.iterator();     // Catch: Throwable -> L21
    L17:
        if (r106.hasNext() == false) goto L19;
        b r107 = (b) r106.next();     // Catch: Throwable -> L21
        r107.a();     // Catch: Throwable -> L21
        com.bytedance.ug.sdk.luckydog.api.log.d.d("ABServiceManager", "notifyServiceChanged(), service =" + r100.getSimpleName() + ", implClass =" + r101 + ", listener =" + r107);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L24:
        return;
    L7:
        r102.put(r100, r101);
        goto L8
    }
}
