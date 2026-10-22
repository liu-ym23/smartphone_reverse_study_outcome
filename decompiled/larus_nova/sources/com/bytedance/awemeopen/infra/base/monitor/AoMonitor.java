package com.bytedance.awemeopen.infra.base.monitor;

import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class AoMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile o64.a f198648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile LinkedList<b> f198649b;

    public static final enum MonitorType extends Enum<MonitorType> {
        public static final MonitorType CommonLog = null;
        public static final MonitorType Duration = null;
        public static final MonitorType Event = null;
        public static final MonitorType StatusDuration = null;
        public static final MonitorType StatusRate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MonitorType[] f198650a = null;

        static {
            MonitorType r100 = new MonitorType("StatusDuration", 0);
            StatusDuration = r100;
            MonitorType r101 = new MonitorType("StatusRate", 1);
            StatusRate = r101;
            MonitorType r102 = new MonitorType("Duration", 2);
            Duration = r102;
            MonitorType r103 = new MonitorType("CommonLog", 3);
            CommonLog = r103;
            MonitorType r104 = new MonitorType("Event", 4);
            Event = r104;
            f198650a = new MonitorType[]{r100, r101, r102, r103, r104};
        }

        public static MonitorType[] values() {
            return (MonitorType[]) f198650a.clone();
        }

        public static MonitorType valueOf(String r100) {
            return (MonitorType) r27.a.a(MonitorType.class, r100);
        }

        public MonitorType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f198651a = null;

        static {
            int[] r100 = new int[MonitorType.values().length];
            f198651a = r100;
            r100[MonitorType.StatusDuration.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f198651a[MonitorType.StatusRate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f198651a[MonitorType.Duration.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f198651a[MonitorType.CommonLog.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f198651a[MonitorType.Event.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MonitorType f198652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f198653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f198654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final JSONObject f198655d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final JSONObject f198656e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f198657f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final JSONObject f198658g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final JSONObject f198659h;

        public b(MonitorType r100, String r101, int r102, JSONObject r103, JSONObject r104, String r105, JSONObject r106, JSONObject r107) {
            this.f198652a = r100;
            this.f198653b = r101;
            this.f198654c = r102;
            this.f198655d = r103;
            this.f198656e = r104;
            this.f198657f = r105;
            this.f198658g = r106;
            this.f198659h = r107;
            System.currentTimeMillis();
        }
    }

    static {
        f198649b = new LinkedList();
    }

    public static boolean b() {
        if (f198648a != null) goto L5;
    L7:
        return false;
    L5:
        if (f198649b != null) goto L7;
        return true;
    }

    public static void d() {
        if (b() == false) goto L7;
        o64.a r100 = f198648a;
        JSONObject r101 = c(null);
        SDKMonitor r102 = ((g64.a) r100).f480160a;
        if (r102 == null) goto L14;
        r102.monitorStatusRate("ao_special_error", 8, r101);
    L14:
        if (AoDebug.b() == false) goto L17;
        AoLogger.b("AoAppMonitor", new Object[]{"ao_special_error", 8, null});
        return;
    L17:
        return;
    L7:
        AoPool.f(new com.bytedance.awemeopen.infra.base.monitor.a());
        if (b() == false) goto L12;
        o64.a r103 = f198648a;
        JSONObject r104 = c(null);
        SDKMonitor r105 = ((g64.a) r103).f480160a;
        if (r105 == null) goto L14;
        r105.monitorStatusRate("ao_special_error", 8, r104);
        goto L14
    L12:
        AoPool.f(new c(MonitorType.StatusRate, "ao_special_error", 8, c(null), null, null));
        goto L14
    }

    public static JSONObject c(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        r101.put("extra", r100);     // Catch: Exception -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        AoLogger.b("AoAppMonitor", new Object[]{e.getMessage()});
        goto L7
    }

    public static void a(JSONObject r100, JSONObject r110, JSONObject r111) {
        if (b() == false) goto L7;
        o64.a r101 = f198648a;
        JSONObject r102 = c(r111);
        SDKMonitor r103 = ((g64.a) r101).f480160a;
        if (r103 == null) goto L14;
        r103.monitorEvent("ao_settings_write_failed", r100, r110, r102);
    L14:
        if (AoDebug.b() == false) goto L17;
        AoLogger.b("AoAppMonitor", new Object[]{"ao_settings_write_failed", r100, r110, r111});
        return;
    L17:
        return;
    L7:
        AoPool.f(new com.bytedance.awemeopen.infra.base.monitor.a());
        if (b() == false) goto L12;
        o64.a r104 = f198648a;
        JSONObject r105 = c(r111);
        SDKMonitor r106 = ((g64.a) r104).f480160a;
        if (r106 == null) goto L14;
        r106.monitorEvent("ao_settings_write_failed", r100, r110, r105);
        goto L14
    L12:
        AoPool.f(new c(MonitorType.Event, "ao_settings_write_failed", 0, c(r111), r100, r110));
        goto L14
    }
}
