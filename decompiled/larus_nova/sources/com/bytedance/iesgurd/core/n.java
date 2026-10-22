package com.bytedance.iesgurd.core;

import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f250675a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, ConcurrentHashMap<String, String>> f250676b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<IGeckoRegister> f250677c = null;

    static {
        f250675a = new CopyOnWriteArraySet();
        f250676b = new ConcurrentHashMap();
        f250677c = new CopyOnWriteArrayList();
    }

    public static void a(String r100, Map r101) {
        if (r101 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        return;
    L10:
        GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.GECKO_REGISTER_CUSTOM_PARAMS, "register custom params: " + r100 + ", " + r101);
        Map<String, ConcurrentHashMap<String, String>> r103 = f250676b;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.get(r100) != null) goto L22;
        monitor-enter(r103);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (((ConcurrentHashMap) r103).get(r100) != null) goto L16;
        ((ConcurrentHashMap) r103).put(r100, new ConcurrentHashMap());     // Catch: Throwable -> L19
    L16:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r103);
    L22:
        Object r106 = r104.get(r100);
        if (r106 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        Iterator r108 = r101.entrySet().iterator();
    L27:
        if (r108.hasNext() == false) goto L31;
        Map.Entry r109 = (Map.Entry) r108.next();
        Object r110 = ((OptionCheckUpdateParams.CustomValue) r109.getValue()).getValue();
        if (r110 == null) goto L27;
        r107.put(r109.getKey(), r110.toString());
        goto L27
    L31:
        return;
    L4:
        if (r101.isEmpty() == true) goto L7;
        r102 = false;
        goto L8
    }

    public static void b(IGeckoRegister r100, boolean r101) {
        com.bytedance.geckox.b r102 = com.bytedance.geckox.b.a.f245076a;
        GeckoGlobalConfig r103 = com.bytedance.geckox.b.a();
        GeckoGlobalConfig.ENVType r104 = r103.getEnv();
        String r105 = r100.getClass().getName();
        GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.GECKO_REGISTER_BY_IREGISTER, "register gecko by IGeckoRegister, env: " + r104 + ", class: " + r105);
        GeckoRegister r106 = (GeckoRegister) r100.getClass().getAnnotation(GeckoRegister.class);
        if (r106 != null) goto L6;
        GeckoLogger.w("GeckoRegister is invalid, class is ".concat(r105));
        return;
    L6:
        CopyOnWriteArraySet r107 = (CopyOnWriteArraySet) f250675a;
        if (r107.contains(r105) == false) goto L10;
        GeckoLogger.w("GeckoRegister already register, class is ".concat(r105));
        return;
    L10:
        r107.add(r105);
        String r108 = r106.testAccessKey();
        String r109 = r106.boeAccessKey();
        String r110 = r106.prodAccessKey();
        if (r104 == null) goto L23;
        int r111 = m.f250674a[r104.ordinal()];
        if (r111 == 1) goto L23;
        if (r111 != 2) goto L18;
        r108 = r110;
        goto L23
    L18:
        if (r111 != 3) goto L23;
        r108 = r109;
    L23:
        if (r108.length() != 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L29;
        GeckoLogger.w("GeckoRegister access key is empty, class is ".concat(r105));
        return;
    L29:
        Map<String, OptionCheckUpdateParams.CustomValue> r113 = r100.registerCustomParams();
        a(r108, r113);
        String r114 = r100.registerRootDir(r103.getContext());
        if (r114 != null) goto L32;
    L35:
        boolean r115 = true;
    L36:
        if (r115 == false) goto L38;
        GeckoLogger.w("GeckoRegister root dir is empty, class is ".concat(r105));
    L39:
        if (r101 == true) goto L41;
        return;
    L41:
        if (GlobalManager.f250632a.get() == false) goto L53;
        ConcurrentHashMap r116 = (ConcurrentHashMap) ((ConcurrentHashMap) f250676b).get(r108);
        if (r116 == null) goto L46;
        String r117 = (String) r116.get("business_version");
    L48:
        if ((!Intrinsics.areEqual(r117, GlobalManager.f250637f.getAppVersion())) == false) goto L50;
        GlobalConfigSettings r118 = GlobalSettingsManager.f250833a;
        ReqType r119 = ReqType.REGISTER_LATE;
        GlobalSettingsManager.f250840h = null;
        GlobalSettingsManager.c(r119, false);
    L50:
        ColdStartManager.f250854e.b(r108, r113);
        return;
    L46:
        r117 = null;
        goto L48
    L53:
        return;
    L38:
        com.bytedance.geckox.b.d(r108, r114);
        goto L39
    L32:
        if (r114.length() == 0) goto L35;
        r115 = false;
        goto L36
    L25:
        r112 = false;
        goto L26
    }
}
