package com.bytedance.iesgurd.settings;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alipay.sdk.m.u.i;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.RequestExecutor;
import com.bytedance.geckox.policy.meta.MetaDataItemNew;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.settings.model.SettingsLocal;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.core.ReportNode;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.core.j;
import com.bytedance.iesgurd.core.k;
import com.bytedance.iesgurd.core.l;
import com.bytedance.iesgurd.core.n;
import com.bytedance.iesgurd.model.RequestBodySettings;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import com.bytedance.iesgurd.strategy.ColdStartManager;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ez5.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class GlobalSettingsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static GlobalConfigSettings f250833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f250834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.iesgurd.settings.b f250835c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static xy5.a f250836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f250837e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f250838f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static z86.b f250839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f250840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ReqType f250841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ReqType f250842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static SettingsExtra f250843k;

    public static final class a extends dz5.a<Object> {
        @Override // dz5.a
        public final int b() {
            return 0;
        }

        @Override // dz5.a
        public final void a() {
            GlobalConfigSettings r100 = GlobalSettingsManager.f250833a;
            GlobalSettingsManager.c(ReqType.POLLING, false);
        }

        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReqType f250844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f250845b;

        public b(ReqType r100, boolean r101) {
            this.f250844a = r100;
            this.f250845b = r101;
        }

        public final void a() {
            GlobalConfigSettings r100 = GlobalSettingsManager.f250833a;
            ReqType r101 = this.f250844a;
            boolean r102 = this.f250845b;
            GeckoLogger.INSTANCE.d$geckox_noasanRelease(ReportNode.SYNC_GLOBAL_SETTING, "settings start, retry: " + r102 + ", reqType: " + r101);
            GlobalSettingsManager.f250841i = r101;
            z86.b r103 = new z86.b();
            GlobalSettingsManager.f250839g = r103;
            r103.f570925e = r102;
            if (r101 != ReqType.NORMAL) goto L5;
            GlobalManager.f250632a.set(true);
        L5:
            boolean r104 = false;
            if (GlobalSettingsManager.f250837e.compareAndSet(false, true) == false) goto L114;
            Set<String> r105 = n.f250675a;
            AppSettingsManager r106 = AppSettingsManager.b.f245071a;
            AppSettingsManager.IGeckoAppSettings r107 = r106.b();
            if (r107 == null) goto L10;
            r106.f245062c = Boolean.valueOf(r107.isRegisterBySPI());
        L10:
            GeckoLogger.d("getRegisterBySPI: " + r106.f245062c);
            if (r106.f245062c.booleanValue() == false) goto L21;
            GeckoLogger.d("register by spi");
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L19
            Iterator r109 = ServiceLoader.load(IGeckoRegister.class, ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getContextClassLoader()).iterator();     // Catch: Throwable -> L19
        L15:
            if (r109.hasNext() == false) goto L17;
            ((CopyOnWriteArrayList) n.f250677c).add((IGeckoRegister) r109.next());     // Catch: Throwable -> L19
            goto L15
        L17:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L21:
            CopyOnWriteArrayList r111 = (CopyOnWriteArrayList) n.f250677c;
            if (r111.isEmpty() == true) goto L33;
            StringBuilder r112 = new StringBuilder();
            StringBuilder r113 = new StringBuilder();
            Iterator r114 = r111.iterator();
        L26:
            if (r114.hasNext() == false) goto L32;
            IGeckoRegister r115 = (IGeckoRegister) r114.next();
            String r116 = r115.getClass().getName();
            if (((CopyOnWriteArraySet) n.f250675a).contains(r116) == false) goto L30;
            r112.append(r116.concat(i.f25853b));
        L31:
            n.b(r115, false);
            goto L26
        L30:
            r113.append(r116.concat(i.f25853b));
            goto L31
        L32:
            int r117 = y86.a.f566911a;
            y86.a.a(EventSubType.RIGISTER_CLASS, r113.toString(), r112.toString());
        L33:
            GlobalSettingsManager.b();
        L114:
            GlobalSettingsManager.d(r101, r102);     // Catch: Throwable -> L36
        L50:
            if (r101 != ReqType.NORMAL) goto L55;
            Map<String, ConcurrentHashMap<String, MetaDataItemNew>> r118 = yy5.c.f569477a;
            Map<String, String> r119 = AppSettingsManager.b.f245071a.f245060a;
            if (r119 == null) goto L54;
            yy5.c.f569480d.b(new yy5.a(r119), 0, 0);
        L54:
            yy5.c.f569480d.b(new yy5.b(), 2000, 120000);
            int r120 = l.f250673a;
            new dz5.b("upload_online_stats").b(new k(), 0, 300000);
            ((Handler) GeckoExecutors.f250869b.getValue()).postDelayed(j.f250672a, 120000);
        L55:
            GlobalSettingsManager.f250838f.set(false);
            ReqType r121 = GlobalSettingsManager.f250842j;
            ReqType r122 = ReqType.REGISTER_LATE;
            if (r121 != r122) goto L58;
            GeckoLogger.d("sync global settings with REGISTER_LATE");
            GlobalSettingsManager.c(r122, false);
        L58:
            GlobalSettingsManager.f250842j = null;
            AtomicBoolean r123 = ColdStartManager.f250850a;
            com.bytedance.geckox.b r124 = com.bytedance.geckox.b.a.f245076a;
            if (com.bytedance.geckox.b.c() == true) goto L61;
            GeckoLogger.d("coldStart update failed, gecko disable");
        L85:
            GlobalConfigSettings r125 = GlobalSettingsManager.f250833a;
            if (r125 == null) goto L129;
            GlobalConfigSettings.ReqMeta r126 = r125.getReqMeta$geckox_noasanRelease();
            if (r126 == null) goto L130;
            AtomicBoolean r127 = com.bytedance.iesgurd.strategy.b.f250856a;
            int r128 = r126.getPollingInterval();
            GeckoLogger.d("loop update by settings: " + r128);
            if (com.bytedance.iesgurd.strategy.b.f250857b != r128) goto L92;
        L95:
            com.bytedance.geckox.b r129 = com.bytedance.geckox.b.a.f245076a;
            if (com.bytedance.geckox.b.c() == true) goto L98;
        L100:
            boolean r130 = false;
        L101:
            if (r130 == true) goto L103;
        L105:
            if (r104 == false) goto L109;
            AtomicBoolean r131 = com.bytedance.iesgurd.strategy.b.f250856a;
            if (r131.get() == true) goto L109;
            GeckoLogger.d("loop start: " + com.bytedance.iesgurd.strategy.b.f250857b);
            r131.set(true);
            long r132 = ((long) com.bytedance.iesgurd.strategy.b.f250857b) * 1000;
            dz5.c r133 = dz5.c.a.f470586a;
            r133.f470585a.b(new com.bytedance.iesgurd.strategy.b.a(), r132, r132);
            return;
        L109:
            if (r104 == false) goto L111;
            return;
        L111:
            if (com.bytedance.iesgurd.strategy.b.f250856a.get() == false) goto L133;
            com.bytedance.iesgurd.strategy.b.a();
            return;
        L133:
            return;
        L103:
            if (com.bytedance.iesgurd.strategy.b.f250858c == false) goto L105;
            r104 = true;
            goto L105
        L98:
            if (com.bytedance.iesgurd.strategy.b.f250857b <= 0) goto L100;
            r130 = true;
            goto L101
        L92:
            if (com.bytedance.iesgurd.strategy.b.f250856a.get() == false) goto L94;
            com.bytedance.iesgurd.strategy.b.a();
        L94:
            com.bytedance.iesgurd.strategy.b.f250857b = r128;
            goto L95
        L130:
            return;
        L129:
            return;
        L61:
            AtomicBoolean r134 = ColdStartManager.f250850a;
            if (r134.get() == true) goto L85;
            GeckoLogger.d("coldStart update");
            r134.set(true);
            if (AppSettingsManager.b.f245071a.a() == false) goto L84;
            GlobalManager.f250642k.a();
            GeckoGlobalConfig r135 = GlobalManager.f250638g;
            if (r135 != null) goto L70;
            Intrinsics.throwNpe();
        L70:
            String r136 = r135.getRootDir();
            Map<String, String> r137 = GlobalManager.f250635d;
            GlobalConfigSettings r138 = GlobalSettingsManager.f250833a;
            if (r138 == null) goto L84;
            GlobalConfigSettings.ReqMeta r139 = r138.getReqMeta$geckox_noasanRelease();
            if (r139 == null) goto L84;
            List<String> r140 = r139.getAks();
            if (r140 == null) goto L84;
            Iterator<T> r141 = r140.iterator();
        L78:
            if (r141.hasNext() == false) goto L84;
            String r142 = (String) r141.next();
            AtomicBoolean r143 = ColdStartManager.f250850a;
            if (ColdStartManager.a().contains(r142) == true) goto L78;
            ConcurrentHashMap r144 = (ConcurrentHashMap) r137;
            if (r144.containsKey(r142) == true) goto L78;
            r144.put(r142, r136);
            ((ArrayList) ColdStartManager.f250853d).add(r142);
        L84:
            RequestBodyUpdate r145 = new RequestBodyUpdate(ReqType.QUEUE);
            r145.initCustom();
            ColdStartManager.f250851b.set(true);
            new UpdateRequest(r145).f();
            ((Handler) GeckoExecutors.f250869b.getValue()).postDelayed(com.bytedance.iesgurd.strategy.a.f250855a, 900000);
        L36:
            th = move-exception;
            z86.b r146 = GlobalSettingsManager.f250839g;
            if (r146 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("statisticData");
        L40:
            r146.f570923c = th.getMessage();
            z86.b r147 = GlobalSettingsManager.f250839g;
            if (r147 != null) goto L43;
            Intrinsics.throwUninitializedPropertyAccessException("statisticData");
        L43:
            r147.a();
            GeckoLogger.d("sync global settings exception:" + th.getMessage());
            xy5.a r148 = GlobalSettingsManager.f250836d;
            if (r148 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("mExponentialBackoffRetry");
        L47:
            if (r148.f565409d.compareAndSet(false, true) == false) goto L50;
            r148.a();
            goto L50
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public GlobalSettingsManager() {
    }

    static {
        f250834b = "0";
        com.bytedance.iesgurd.settings.b r100 = new com.bytedance.iesgurd.settings.b();
        f250835c = r100;
        f250837e = new AtomicBoolean(false);
        f250838f = new AtomicBoolean(false);
        GlobalManager.f250642k.a();
        com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
        GeckoGlobalConfig r102 = com.bytedance.geckox.b.a();
        String r103 = g.a.f474886a.a(r100.f250848a, "gecko_settings_local", null);
        if (r103 != null) goto L44;
    L7:
        SettingsLocal r104 = null;
    L8:
        String r105 = r102.getEnv().name();
        String r106 = r102.getAppVersion();
        if (r104 == null) goto L11;
        String r107 = r104.getEnv();
        String r108 = r104.getAppVersion();
    L12:
        int r109 = com.bytedance.iesgurd.settings.b.f250847b;
        Context r110 = GlobalManager.f250642k.getContext();
        if (r110 == null) goto L19;
        String r111 = g.a.f474886a.a(r110, "gecko_settings_extra", null);
        if (r111 == null) goto L19;
        SettingsExtra r112 = (SettingsExtra) sy5.b.f543888b.f543890a.fromJson(r111, SettingsExtra.class);     // Catch: Throwable -> L18
    L20:
        f250843k = r112;
        com.bytedance.iesgurd.settings.b r113 = f250835c;
        SettingsLocal r114 = new SettingsLocal(r105, r106);
        r113.getClass();
        GeckoLogger.d("settings local cache stored: " + r114.getAppVersion());
        g r115 = g.a.f474886a;
        r115.c(r113.f250848a, "gecko_settings_local", GsonProtectorUtils.toJson(sy5.b.f543888b.f543890a, r114));
        if (r107 != null) goto L23;
    L42:
        f250836d = new xy5.a();
        return;
    L23:
        if (Intrinsics.areEqual(r105, r107) == false) goto L30;
        if (Intrinsics.areEqual(r106, r108) == false) goto L30;
        GlobalConfigSettings r116 = r113.a();
        f250833a = r116;
        if (r116 == null) goto L42;
        f250834b = r116.getVersion$geckox_noasanRelease();
    L30:
        if ((!Intrinsics.areEqual(r105, r107)) == false) goto L33;
        GeckoLogger.d("env changed, delete gecko cache, from " + r107 + " to " + r105);
        com.bytedance.iesgurd.core.a.a();
        f250833a = null;
        f250834b = "0";
        r113.getClass();
        GeckoLogger.d("settings cache deleted");
        r115.delete(r113.f250848a, "gecko_settings");
        goto L42
    L33:
        if ((!Intrinsics.areEqual(r106, r108)) == false) goto L42;
        GeckoLogger.d("app_version changed, from " + r108 + " to " + r106);
        GlobalConfigSettings r117 = r113.a();
        f250833a = r117;
        f250834b = "0";
        if (r117 == null) goto L42;
        if (r117.getResourceMeta() == null) goto L42;
        GlobalConfigSettings r118 = f250833a;
        if (r118 != null) goto L41;
        Intrinsics.throwNpe();
    L41:
        r118.getResourceMeta().setAccessKeys(MapsKt.emptyMap());
    L19:
        r112 = null;
        goto L20
    L11:
        r108 = null;
        r107 = null;
        goto L12
    L44:
        r104 = (SettingsLocal) sy5.b.f543888b.f543890a.fromJson(r103, SettingsLocal.class);     // Catch: Throwable -> L6
        goto L8
    }

    public static final /* synthetic */ z86.b a() {
        z86.b r100 = f250839g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L5:
        return r100;
    }

    public static void b() {
        GlobalConfigSettings r100 = f250833a;
        if (r100 != null) goto L5;
        return;
    L5:
        GlobalConfigSettings.SettingsConfig r101 = r100.getSettingsConfig$geckox_noasanRelease();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getPollingInterval() <= 0) goto L12;
        long r102 = r101.getPollingInterval() * ((long) 1000);
        dz5.c r103 = dz5.c.a.f470586a;
        a r104 = new a();
        r103.f470585a.b(r104, r102, r102);
        return;
    }

    public static void c(ReqType r100, boolean r101) {
        if (f250838f.compareAndSet(false, true) == false) goto L5;
        ((ThreadPoolExecutor) GeckoExecutors.f250868a.getValue()).execute(new b(r100, r101));
        return;
    L5:
        GeckoLogger.d("settings is syncing, return, next fetch type is " + r100);
        f250842j = r100;
    }

    public static void d(ReqType r100, boolean r110) throws Throwable {
        z86.b r101 = f250839g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L5:
        r101.f570926f = r100;
        z86.b r102 = f250839g;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L8:
        r102.f570929i = f250834b;
        String r103 = f250840h;
        if (r103 == null) goto L14;
        z86.b r104 = f250839g;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L13:
        r104.f570927g = r103;
    L14:
        RequestBodySettings r105 = new RequestBodySettings(r100, f250834b);
        if (r110 == false) goto L17;
        r105.getReqInfo().setRetry(true);
    L17:
        com.bytedance.geckox.b r106 = com.bytedance.geckox.b.a.f245076a;
        new RequestExecutor(r105, "https://" + com.bytedance.geckox.b.a().getHost() + "/gkx/api/settings/v3", true, f250840h, GlobalSettingsManager$syncRequestServer$2.INSTANCE).b();
    }
}
