package ss3;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.apm.constant.FilterTypeStringDef;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements IConfigListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Boolean> f543338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f543339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f543340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f543341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f543342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f543343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile JSONObject f543344g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f543345a = null;

        static {
            f543345a = new d();
        }
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public final void onReady() {
    }

    public d() {
        this.f543338a = new ConcurrentHashMap();
        this.f543339b = new ConcurrentHashMap();
        HashMap r100 = new HashMap();
        this.f543343f = r100;
        LinkedList r101 = new LinkedList();
        this.f543340c = r101;
        r101.addAll(Arrays.asList(new String[]{Scraps.BATTERY, "smooth", "cpu", UploadTypeInf.DISK, "memory", "thread", "fd", UploadTypeInf.PAGE_LOAD, "page_load_trace", "start", "start_trace", "traffic", "ui"}));
        ArrayList r102 = new ArrayList();
        this.f543341d = r102;
        r102.add("enable_upload");
        r102.add("drop_enable_upload");
        r102.add("serious_block_enable_upload");
        r102.add("block_enable_upload");
        r102.add("slow_method_enable_upload");
        LinkedList r103 = new LinkedList();
        this.f543342e = r103;
        r103.add("enable_perf_data_collect");
        r100.put("enable_upload", "fps");
        r100.put("drop_enable_upload", FilterTypeStringDef.FPS_DROP);
        r100.put("block_enable_upload", "block_monitor");
        r100.put("slow_method_enable_upload", "drop_frame_stack");
        r100.put("serious_block_enable_upload", UploadTypeInf.SERIOUS_BLOCK_MONITOR);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerConfigListener(this);
    }

    @Override // com.bytedance.services.slardar.config.IConfigListener
    public final void onRefresh(JSONObject r100, boolean r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = r100.optJSONObject("performance_modules");
        if (r101 == null) goto L103;
        Iterator<String> r111 = this.f543340c.iterator();
    L9:
        if (r111.hasNext() == false) goto L78;
        String r102 = r111.next();
        JSONObject r103 = r101.optJSONObject(r102);
        if ("smooth".equals(r102) == true) goto L12;
        if ("memory".equals(r102) == false) goto L36;
        if (r103 == null) goto L36;
        Map<String, Boolean> r104 = this.f543339b;
        if (r103.optInt(UploadTypeInf.MEMORY_OBJ_MONITOR, 0) != 1) goto L33;
        boolean r105 = true;
    L34:
        ConcurrentHashMap r106 = (ConcurrentHashMap) r104;
        r106.put(UploadTypeInf.MEMORY_OBJ_MONITOR, Boolean.valueOf(r105));
        goto L36
    L33:
        r105 = false;
    L36:
        if (Scraps.BATTERY.equals(r102) == false) goto L49;
        if (r103 == null) goto L49;
        Map<String, Boolean> r107 = this.f543339b;
        if (r103.optInt("temperature_enable_upload", 0) != 1) goto L42;
        boolean r108 = true;
    L43:
        ConcurrentHashMap r109 = (ConcurrentHashMap) r107;
        r109.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, Boolean.valueOf(r108));
        Map<String, Boolean> r112 = this.f543339b;
        if (r103.optInt("exception_enable_upload", 0) != 1) goto L46;
        boolean r113 = true;
    L47:
        ConcurrentHashMap r114 = (ConcurrentHashMap) r112;
        r114.put(UploadTypeInf.BATTERY_EXCEPTION_TRACE, Boolean.valueOf(r113));
        goto L49
    L46:
        r113 = false;
        goto L47
    L42:
        r108 = false;
    L49:
        if ("cpu".equals(r102) == false) goto L58;
        if (r103 == null) goto L58;
        Map<String, Boolean> r115 = this.f543339b;
        if (r103.optInt(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, 0) != 1) goto L55;
        boolean r116 = true;
    L56:
        ConcurrentHashMap r117 = (ConcurrentHashMap) r115;
        r117.put(UploadTypeInf.CPU_EXCEPTION_TRACE, Boolean.valueOf(r116));
        goto L58
    L55:
        r116 = false;
    L58:
        if ("start_trace".equals(r102) == false) goto L73;
        if (r103 == null) goto L73;
        Iterator<String> r118 = this.f543342e.iterator();
    L63:
        if (r118.hasNext() == false) goto L73;
        String r119 = r118.next();
        Map<String, Boolean> r120 = this.f543339b;     // Catch: Exception -> L71
        if (r103.optInt(r119, 0) != 1) goto L68;
        boolean r121 = true;
    L69:
        ConcurrentHashMap r122 = (ConcurrentHashMap) r120;     // Catch: Exception -> L71
        r122.put(r119, Boolean.valueOf(r121));     // Catch: Exception -> L71
        goto L63
    L68:
        r121 = false;
    L71:
        e = move-exception;
        e.printStackTrace();
    L73:
        if (r103 == null) goto L77;
        if (r103.optInt("enable_upload", 0) != 1) goto L77;
        Map<String, Boolean> r123 = this.f543338a;
        ConcurrentHashMap r124 = (ConcurrentHashMap) r123;
        r124.put(r102, Boolean.TRUE);
    L77:
        Map<String, Boolean> r125 = this.f543338a;
        ConcurrentHashMap r126 = (ConcurrentHashMap) r125;
        r126.put(r102, Boolean.FALSE);
        goto L9
    L12:
        if (r103 == null) goto L9;
        Iterator r127 = ((ArrayList) this.f543341d).iterator();
    L16:
        if (r127.hasNext() == false) goto L9;
        String r128 = (String) r127.next();
        Map<String, Boolean> r129 = this.f543339b;     // Catch: Exception -> L24
        Object r130 = ((HashMap) this.f543343f).get(r128);     // Catch: Exception -> L24
        if (r103.optInt(r128, 0) != 1) goto L21;
        boolean r131 = true;
    L22:
        ConcurrentHashMap r132 = (ConcurrentHashMap) r129;     // Catch: Exception -> L24
        r132.put(r130, Boolean.valueOf(r131));     // Catch: Exception -> L24
        goto L16
    L21:
        r131 = false;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L16
    L78:
        this.f543344g = com.bytedance.apm.util.j.e(r101, "smooth", "scene_enable_upload");
        return;
    }
}
