package com.flow.performance.thermal;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermal;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermalMetric;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermalPayload;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.dora.device.api.IDoraDeviceInfo;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f274201b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static vw7.a f274202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f274203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Handler f274204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f274205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f274206g = null;

    /* JADX INFO: loaded from: classes23.dex */
    public static final class a implements tw7.a {
        public a() {
        }

        @Override // tw7.a
        public final void a(PowerThermalPayload r110) {
            Intrinsics.checkNotNullParameter(r110, "powerThermalPayload");
            d r100 = d.f274201b;
            List<PowerThermalMetric> r101 = r110.getPowerThermalMetrics();
            r100.getClass();
            JSONArray r102 = new JSONArray();
            String r103 = null;
            if (r101 == null) goto L17;
            Iterator<T> r104 = r101.iterator();
        L6:
            if (r104.hasNext() == false) goto L17;
            PowerThermalMetric r105 = (PowerThermalMetric) r104.next();
            if (r105 == null) goto L6;
            JSONObject r106 = new JSONObject();     // Catch: JSONException -> L15
            r106.put("diagInfo", r105.getDiagInfo());     // Catch: JSONException -> L15
            r106.put("happenTime", r105.getHappenTime());     // Catch: JSONException -> L15
            r106.put("pid", r105.getPid());     // Catch: JSONException -> L15
            PowerThermalMetric.PowerType r107 = r105.getPowerType();     // Catch: JSONException -> L15
            if (r107 == null) goto L12;
            String r108 = r107.toString();     // Catch: JSONException -> L15
        L13:
            r106.put("powerType", r108);     // Catch: JSONException -> L15
            r102.put(r106);     // Catch: JSONException -> L15
            goto L6
        L12:
            r108 = null;
        L15:
            e = move-exception;
            FLogger.f375446a.e("HonorThermalMonitor", "Error adding metric to JSON", e);
        L17:
            JSONObject r109 = new JSONObject();
            r109.put("data", r102);
            if (r101 == null) goto L50;
            Iterator<T> r111 = r101.iterator();     // Catch: JSONException -> L47
        L21:
            if (r111.hasNext() == false) goto L28;
            Object r112 = r111.next();     // Catch: JSONException -> L47
            if (((PowerThermalMetric) r112) == null) goto L25;
            boolean r113 = true;
        L26:
            if (r113 == false) goto L21;
        L29:
            PowerThermalMetric r114 = (PowerThermalMetric) r112;     // Catch: JSONException -> L47
            if (r114 == null) goto L50;
            PowerThermalMetric.PowerType r115 = r114.getPowerType();     // Catch: JSONException -> L47
            if (r115 == null) goto L34;
            String r116 = r115.toString();     // Catch: JSONException -> L47
        L35:
            r109.put("powerType", r116);     // Catch: JSONException -> L47
            r109.put("happenTime", r114.getHappenTime());     // Catch: JSONException -> L47
            IDoraDeviceInfo r117 = (IDoraDeviceInfo) ServiceManager.get().getService(IDoraDeviceInfo.class);     // Catch: JSONException -> L47
            if (r117 == null) goto L38;
            Integer r118 = Integer.valueOf(r117.getDoraState());     // Catch: JSONException -> L47
        L39:
            r109.put("isDoraConnect", r118);     // Catch: JSONException -> L47
            IDoraDeviceInfo r119 = (IDoraDeviceInfo) ServiceManager.get().getService(IDoraDeviceInfo.class);     // Catch: JSONException -> L47
            if (r119 == null) goto L42;
            Boolean r120 = Boolean.valueOf(r119.hasDoraDevice());     // Catch: JSONException -> L47
        L43:
            r109.put("hasDoraDevice", r120);     // Catch: JSONException -> L47
            r109.put("deviceId", IApplog.f287053a.getDeviceId());     // Catch: JSONException -> L47
            b r121 = (b) GsonProtectorUtils.fromJson(new Gson(), r114.getDiagInfo(), b.class);     // Catch: JSONException -> L47
            if (r121 == null) goto L50;
            r109.put("level", r121.a());     // Catch: JSONException -> L47
            r109.put("reason", r121.b());     // Catch: JSONException -> L47
            goto L50
        L42:
            r120 = null;
            goto L43
        L38:
            r118 = null;
            goto L39
        L34:
            r116 = null;
            goto L35
        L25:
            r113 = false;
            goto L26
        L28:
            r112 = null;
        L47:
            e = move-exception;
            FLogger.f375446a.e("HonorThermalMonitor", "Error adding metric to JSON", e);
        L50:
            if (r109.optInt("level") != 1) goto L54;
            FLogger.f375446a.d("HonorThermalMonitor", "Current thermal data is  level 1 : " + r109);
            return;
        L54:
            if (d.f274206g.size() <= 10) goto L57;
            FLogger.f375446a.d("HonorThermalMonitor", "Data too large ！！ ");
            return;
        L57:
            d r122 = d.f274201b;
            IDoraDeviceInfo r123 = (IDoraDeviceInfo) ServiceManager.get().getService(IDoraDeviceInfo.class);
            if (r123 == null) goto L62;
            Thread r124 = r123.m();
            if (r124 == null) goto L62;
            StackTraceElement[] r125 = r124.getStackTrace();
        L63:
            r122.getClass();
            if (r125 != null) goto L77;
        L69:
            if (r103 != null) goto L71;
            r103 = "";
        L71:
            r109.put("doraPlayThreadTrace", r103);
            d.f274206g.add(r109);
            if (AppHost.f326268a.isDebug() == false) goto L92;
            FLogger.f375446a.d("HonorThermalMonitor", "Current thermal data is : " + r109);
            return;
        L92:
            return;
        L77:
            r103 = ArraysKt.joinToString$default(r125, "\n", null, null, 0, null, new c(), 30, null);     // Catch: Exception -> L67
        L67:
            e = move-exception;
            r103 = "Format Thead trace error " + e.getMessage();
        L62:
            r125 = null;
            goto L63
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/flow/performance/thermal/HonorThermalMonitor$RealReason;", "", "reason", "", "version", "runningLogURI", "privateLogURI", "level", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getReason", "()Ljava/lang/String;", "getVersion", "getRunningLogURI", "getPrivateLogURI", "getLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/flow/performance/thermal/HonorThermalMonitor$RealReason;", "equals", "", "other", "hashCode", "toString", "performance_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("level")
        private final Integer level;

        @SerializedName("privateLogURI")
        private final String privateLogURI;

        @SerializedName("reason")
        private final String reason;

        @SerializedName("runningLogURI")
        private final String runningLogURI;

        @SerializedName("version")
        private final String version;

        public b() {
            this.reason = "";
            this.version = "";
            this.runningLogURI = "";
            this.privateLogURI = "";
            this.level = -1;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.runningLogURI, r101.runningLogURI) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.privateLogURI, r101.privateLogURI) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.level, r101.level) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r100 = this.reason;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.version;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.runningLogURI;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.privateLogURI;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.level;
            if (r113 == null) goto L23;
            r101 = r113.hashCode();
        L23:
            return r112 + r101;
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RealReason(reason=" + this.reason + ", version=" + this.version + ", runningLogURI=" + this.runningLogURI + ", privateLogURI=" + this.privateLogURI + ", level=" + this.level + ')';
        }

        public final Integer a() {
            return this.level;
        }

        public final String b() {
            return this.reason;
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        PowerThermal.b r100 = new PowerThermal.b();     // Catch: Throwable -> L13
        PowerThermal.Kind r101 = PowerThermal.Kind.POWER_EXCESSIVE_DRAIN;     // Catch: Throwable -> L13
        r100.f276662a.add(r101);     // Catch: Throwable -> L13
        PowerThermal r102 = new PowerThermal(r100);     // Catch: Throwable -> L13
        f274202c = vw7.a.a(AppHost.f326268a.getApplication());     // Catch: Throwable -> L13
        PthreadHandlerThreadV2 r103 = new PthreadHandlerThreadV2("DiagnosisKit");     // Catch: Throwable -> L13
        ThreadMethodProxy.start(r103);     // Catch: Throwable -> L13
        f274204e = new Handler(r103.getLooper());     // Catch: Throwable -> L13
        f274203d = new a();     // Catch: Throwable -> L13
        vw7.a r104 = f274202c;     // Catch: RuntimeException -> L8 Throwable -> L13
        if (r104 == null) goto L10;
        r104.b(r102, f274203d, f274204e);     // Catch: RuntimeException -> L8 Throwable -> L13
    L10:
        Logger.e("HonorThermalMonitor", "[HonorThermalMonitor]initThermalMonitor finish ");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        Logger.e("HonorThermalMonitor", "HonorThermalMonitor#subscribePowerThermal error ", e);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    static {
        f274201b = new d();
        f274206g = new CopyOnWriteArrayList();
    }

    public d() {
    }
}
