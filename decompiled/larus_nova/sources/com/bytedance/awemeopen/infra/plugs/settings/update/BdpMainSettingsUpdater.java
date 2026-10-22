package com.bytedance.awemeopen.infra.plugs.settings.update;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetRequest;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.infra.base.npth.AoExceptionReporter;
import com.bytedance.awemeopen.infra.base.npth.ErrorPriority;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.awemeopen.infra.plugs.settings.BdpAppSettingsServiceImpl;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsModel;
import com.bytedance.awemeopen.infra.plugs.settings.SettingsRequest;
import com.bytedance.awemeopen.infra.plugs.settings.dao.AoSettingsDao;
import com.bytedance.awemeopen.servicesapi.npth.AoNpthService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import q64.c;

/* JADX INFO: loaded from: classes46.dex */
public final class BdpMainSettingsUpdater {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f198890l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap<String, BdpMainSettingsUpdater> f198891m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f198892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f198894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer[] f198895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f198896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f198897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f198898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AoSettingsDao f198899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f198900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f198901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f198902k;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final BdpMainSettingsUpdater a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bdpAppId");
            HashMap<String, BdpMainSettingsUpdater> r101 = BdpMainSettingsUpdater.f198891m;
            BdpMainSettingsUpdater r102 = r101.get(r100);
            if (r102 != null) goto L16;
            Application r103 = y54.a.a();
            monitor-enter(this);
            BdpMainSettingsUpdater r104 = r101.get(r100);     // Catch: Throwable -> L12
            if (r104 != null) goto L9;
            r104 = new BdpMainSettingsUpdater(r103, r100);     // Catch: Throwable -> L12
            r101.put(r100, r104);     // Catch: Throwable -> L12
        L9:
            r102 = r104;
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(this);
        L12:
            th = move-exception;
            throw th;
        L16:
            return r102;
        }
    }

    static {
        f198890l = new a();
        f198891m = new HashMap();
    }

    public final ConcurrentHashMap<String, JSONObject> f() {
        return (ConcurrentHashMap) this.f198902k.getValue();
    }

    public BdpMainSettingsUpdater(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mBdpAppId");
        this.f198892a = r100;
        this.f198893b = r101;
        this.f198894c = "BdpSettingsUpdater_" + r101;
        this.f198895d = new Integer[]{0, 60, 60, 120, 240, 600};
        this.f198899h = new AoSettingsDao(r100, r101);
        this.f198900i = new AtomicInteger(0);
        this.f198901j = LazyKt.lazy(new BdpMainSettingsUpdater$mockSettingsSp$2(this));
        this.f198902k = LazyKt.lazy(new BdpMainSettingsUpdater$mMockSettings$2(this));
    }

    public static final long a(BdpMainSettingsUpdater r100, int r101) {
        if (r101 != 0) goto L4;
        r100.getClass();
        long r102 = System.currentTimeMillis();
        long r103 = 3600000;
    L6:
        return r102 + r103;
    L4:
        int r104 = Math.min(r101, r100.f198895d.length - 1);
        long r105 = System.currentTimeMillis();
        long r106 = ((long) r100.f198895d[r104].intValue()) * 1000;
        r102 = r105;
        r103 = r106;
        goto L6
    }

    public static final void e(BdpMainSettingsUpdater r100, String r101) {
        if (r101 == null) goto L4;
        ((SharedPreferences) r100.f198901j.getValue()).edit().putString(r101, null).apply();
        return;
    L4:
        ((SharedPreferences) r100.f198901j.getValue()).edit().clear().apply();
    }

    public static final SettingsModel b(BdpMainSettingsUpdater r100, SettingsModel r101, Map r102) {
        r100.getClass();
        if (r102.isEmpty() == true) goto L12;
        JSONObject r103 = new JSONObject(r101.getSettings().toString());
        Iterator r104 = r102.entrySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), r105.getValue());
        goto L7
    L10:
        return new SettingsModel(r101.getLastUpdateTime(), r103);
    L12:
        return r101;
    }

    public static final void c(BdpMainSettingsUpdater r100, String r101, SettingsModel r102) {
        AoLogger.g(r100.f198894c, new Object[]{"notifySettingsChange ".concat(r101)});
        Intent r103 = new Intent("com.bytedance.openaweme.settings.update");
        r103.setPackage(r100.f198892a.getPackageName());
        r103.putExtra("openaweme_app_id", r100.f198893b);
        r103.putExtra("result", r101);
        if (r102 == null) goto L7;
        JSONObject r104 = r102.toJson();
        if (r104 == null) goto L7;
        String r105 = r104.toString();
    L8:
        r103.putExtra("data", r105);
        r100.f198892a.sendBroadcast(r103);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        AoLogger.c(r100.f198894c, new Object[]{"sendBroadcast", e});
        return;
    L7:
        r105 = null;
        goto L8
    }

    public static final SettingsModel d(final BdpMainSettingsUpdater r310, Context r311, Map r312, final String r313) {
        r310.getClass();
        long r100 = System.currentTimeMillis();
        BdpAppSettingsServiceImpl r101 = BdpAppSettingsServiceImpl.f198875a;
        SettingsRequest r102 = new SettingsRequest.Builder().setQueryParams(r312).setAppId(AoEnv.d()).setAppName(AoEnv.a().getHostAppName()).setVersionCode(String.valueOf(AoEnv.a().getHostVersionCode())).setDevicePlatform("android").setDeviceType(Build.MODEL).setDeviceBrand(Build.BRAND).setDeviceId(AoEnv.c()).setOsVersion(Build.VERSION.RELEASE).setOsApi(Build.VERSION.SDK_INT).setChannel(AoEnv.b()).setInstallId(AoEnv.a().getInstallId()).setUpdateVersionCode(String.valueOf(AoEnv.e())).setAoVersionString(AoEnv.g()).setAoVersionCode(String.valueOf(37300)).setVersionName(AoEnv.f()).build();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r311, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "request");
        String r103 = BdpAppSettingsServiceImpl.f198876b;
        AoLogger.g(r103, new Object[]{"Start request settings: " + r102});
        String r104 = r102.buildUrl();
        AoFromSource r105 = AoFromSource.settings;
        Intrinsics.checkNotNullParameter(r104, "httpUrl");
        Intrinsics.checkNotNullParameter(r105, "fromSource");
        ArrayList r106 = new ArrayList();
        AoRequestType.a r107 = AoRequestType.Companion;
        HashMap r108 = new HashMap();
        AoRequestType r109 = AoRequestType.HOST;
        Intrinsics.checkNotNullParameter(r109, "libType");
        Intrinsics.checkNotNullParameter("GET", e.f25671s);
        AoNetRequest r110 = new AoNetRequest(r104, "GET", r105, false, true, false, false, true, new c(r106), true, r109, null, 60000, 60000, 60000, true, null, false, r108);
        Function0<String> r111 = AoNet.f198669a;
        AoNetResponse r112 = AoNet.d(r110).execute();
        final com.bytedance.awemeopen.infra.plugs.settings.a r113 = new com.bytedance.awemeopen.infra.plugs.settings.a();
        r113.f198878a = r112.getCode();
        r113.f198879b = r112.getMessage();
        String r114 = r112.stringBody();     // Catch: Exception -> L10
        AoLogger.g(r103, new Object[]{"Settings are: " + r114});     // Catch: Exception -> L8
        JSONObject r115 = new JSONObject(r114);     // Catch: Exception -> L8
        boolean r116 = TextUtils.equals("success", JSONObjectProtectorUtils.getString(r115, "err_tips"));     // Catch: Exception -> L8
        r113.f198880c = r116;     // Catch: Exception -> L8
        if (r116 == false) goto L13;
        r113.f198881d = JSONObjectProtectorUtils.getJSONObject(r115, "data");     // Catch: Exception -> L8
    L13:
        final long r117 = System.currentTimeMillis() - r100;
        AoPool.a(new BdpMainSettingsUpdater$reportEventAboutSettingsRequestResult$1(r113, r310, r117, r313));
        if (r113.f198878a == 200) goto L17;
        return null;
    L17:
        if (r113.f198881d != null) goto L19;
        new JSONObject();
    L19:
        long r118 = System.currentTimeMillis();
        if (r113.f198881d != null) goto L22;
        new JSONObject();
    L22:
        JSONObject r119 = r113.f198881d;
        if (r119 != null) goto L26;
        r119 = new JSONObject();
    L26:
        return new SettingsModel(r118, r119);
    L8:
        e = e;
    L12:
        AoLogger.c(BdpAppSettingsServiceImpl.f198876b, new Object[]{"parse_json_error", e});
        AoNpthService r120 = AoExceptionReporter.f198706a;
        AoExceptionReporter.a(ErrorPriority.f198711p1, "settings", "parse_json_error", "code" + r113.f198878a + ",msg" + r113.f198879b + ",rawResponse:" + StringsKt.take(r114, 200), e);
    L10:
        e = e;
        r114 = "";
        goto L12
    }
}
