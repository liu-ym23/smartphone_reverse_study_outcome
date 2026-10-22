package com.bytedance.bdp.appbase.base.monitor;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventHelper;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpAppMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile fb4.a f200603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f200604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f200605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile LinkedList<b> f200606d;

    public static final enum MonitorType extends Enum<MonitorType> {
        public static final MonitorType CommonLog = null;
        public static final MonitorType Duration = null;
        public static final MonitorType Event = null;
        public static final MonitorType StatusDuration = null;
        public static final MonitorType StatusRate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MonitorType[] f200607a = null;

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
            f200607a = new MonitorType[]{r100, r101, r102, r103, r104};
        }

        public static MonitorType[] values() {
            return (MonitorType[]) f200607a.clone();
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
        public static final /* synthetic */ int[] f200608a = null;

        static {
            int[] r100 = new int[MonitorType.values().length];
            f200608a = r100;
            r100[MonitorType.StatusDuration.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f200608a[MonitorType.StatusRate.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f200608a[MonitorType.Duration.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f200608a[MonitorType.CommonLog.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f200608a[MonitorType.Event.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MonitorType f200609a;

        public b(MonitorType r100, String r101, int r102, JSONObject r103, JSONObject r104, String r105, JSONObject r106, JSONObject r107) {
            this.f200609a = r100;
            System.currentTimeMillis();
        }
    }

    static {
        f200606d = new LinkedList();
    }

    public static boolean b() {
        if (f200603a != null) goto L5;
    L7:
        return false;
    L5:
        if (f200606d != null) goto L7;
        return true;
    }

    public static void c(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("name", "LockObject");     // Catch: JSONException -> L8
        r102.put(LocationMonitorConst.ERR_MSG, r100);     // Catch: JSONException -> L8
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r102.put("extra_info", r101);     // Catch: JSONException -> L8
        e(null, AVMDLDataLoader.KeyIsIgnorePlayInfo, r102);     // Catch: JSONException -> L8
        return;
    }

    public static JSONObject d(SchemaInfo r100, JSONObject r101) {
        JSONObject r102 = new JSONObject();
        BdpInfoService r103 = (BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class);     // Catch: Exception -> L8
        r102.put("aid", f200604b);     // Catch: Exception -> L8
        r102.put("huv", f200605c);     // Catch: Exception -> L8
        String r104 = r103.getHostInfo().getPluginVersion();     // Catch: Exception -> L8
        if (TextUtils.isEmpty(r104) == true) goto L6;
        r102.put(BdpAppEventConstant.PARAMS_TMA_PLUGIN_VERSION, r104);     // Catch: Exception -> L8
    L6:
        BdpAppEventHelper.d(r100, r101);     // Catch: Exception -> L8
        r102.put("extra", r101);     // Catch: Exception -> L8
    L12:
        return r102;
    L8:
        e = move-exception;
        if (q94.a.f532096b == false) goto L12;
        g94.b.a("BdpAppMonitor", new Object[]{e.getMessage()});
        goto L12
    }

    public static void e(SchemaInfo r100, int r101, JSONObject r110) {
        if (b() == false) goto L5;
        fb4.a r102 = f200603a;
        d(r100, r110);
        r102.getClass();
    L10:
        if (q94.a.b() == true) goto L12;
        return;
    L12:
        if (q94.a.f532096b == false) goto L16;
        g94.b.a("BdpAppMonitor", new Object[]{"mp_special_error", Integer.valueOf(r101), r110});
        return;
    L16:
        return;
    L5:
        BdpPool.runOnAsyncIfMain(new com.bytedance.bdp.appbase.base.monitor.a());
        if (b() == false) goto L8;
        fb4.a r103 = f200603a;
        d(r100, r110);
        r103.getClass();
        goto L10
    L8:
        BdpPool.runOnAsyncIfMain(new c(MonitorType.StatusRate, "mp_special_error", r101, d(r100, r110), null, null));
        goto L10
    }

    public static void a(String r100, JSONObject r110, JSONObject r111, JSONObject r112) {
        if (b() == false) goto L5;
        fb4.a r101 = f200603a;
        d(null, r112);
        r101.getClass();
    L10:
        if (q94.a.b() == true) goto L12;
        return;
    L12:
        if (q94.a.f532096b == false) goto L16;
        g94.b.a("BdpAppMonitor", new Object[]{r100, r110, r111, r112});
        return;
    L16:
        return;
    L5:
        BdpPool.runOnAsyncIfMain(new com.bytedance.bdp.appbase.base.monitor.a());
        if (b() == false) goto L8;
        fb4.a r102 = f200603a;
        d(null, r112);
        r102.getClass();
        goto L10
    L8:
        BdpPool.runOnAsyncIfMain(new c(MonitorType.Event, r100, 0, d(null, r112), r110, r111));
        goto L10
    }
}
