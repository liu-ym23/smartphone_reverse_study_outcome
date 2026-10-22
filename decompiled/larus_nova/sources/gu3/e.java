package gu3;

import com.bytedance.monitor.collector.AbsMonitor;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.bytedance.apm.config.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.apm.config.e f482769a;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f482770a;

        public a(e r100) {
            this.f482770a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r100) {
            e r101 = this.f482770a;
            r101.getClass();
            if (r100 != null) goto L85;
            return;
        L85:
            JSONObject r102 = r100.optJSONObject("performance_modules").optJSONObject("smooth");     // Catch: Throwable -> L8
        L9:
            if (r102 == null) goto L100;
            r101.f482769a = new com.bytedance.apm.config.e();
            int r103 = 0;
            if (r102.optInt("enable_stack_sampling", 0) != 1) goto L14;
            boolean r104 = true;
        L15:
            r101.f482769a.f190471a = r104;
            if (r102.optInt("enable_trace", 0) != 1) goto L18;
            boolean r105 = true;
        L19:
            r101.f482769a.f190472b = r105;
            r101.f482769a.f190473c = r102.optLong("atrace_tag", 0);
            if (r102.optInt("block_dump_stack_enable", 1) != 1) goto L22;
            boolean r106 = true;
        L23:
            r101.f482769a.f190474d = r106;
            if (r102.optInt("enable_gfx_monitor", 0) != 1) goto L26;
            boolean r107 = true;
        L27:
            r101.f482769a.f190475e = r107;
            r101.f482769a.f190476f = r102.optInt("block_monitor_mode", 1001);
            if (r102.optInt("serious_block_enable_upload", 1) != 1) goto L30;
            boolean r108 = true;
        L31:
            r101.f482769a.f190477g = r108;
            r101.f482769a.f190478h = r102.optLong("serious_block_threshold", 4000);
            if (r102.optInt("slow_method_enable_upload", 1) != 1) goto L34;
            boolean r109 = true;
        L35:
            r101.f482769a.f190479i = r109;
            if (r102.optInt("drop_enable_upload", 1) != 1) goto L38;
            boolean r110 = true;
        L39:
            r101.f482769a.f190480j = r110;
            if (r102.optInt("enable_upload", 0) != 1) goto L42;
            boolean r111 = true;
        L43:
            r101.f482769a.f190481k = r111;
            r101.f482769a.f190482l = r102.optLong("block_threshold", 2500);
            r101.f482769a.f190483m = r102.optLong("drop_threshold", 1000);
            if (r102.optInt("block_enable_upload", 0) != 1) goto L46;
            boolean r112 = true;
        L47:
            r101.f482769a.f190484n = r112;
            r101.f482769a.f190485o = r102.optBoolean("drop_slow_method_switch", true);
            r102.optJSONObject("scene_enable_upload");
            r101.f482769a.getClass();
            com.bytedance.apm.g r113 = com.bytedance.apm.g.a.f190558a;
            com.bytedance.apm.config.e r114 = r101.f482769a;
            r113.getClass();
            if (r114 == null) goto L101;
            com.bytedance.apm.block.f.a().getClass();
            com.bytedance.monitor.collector.c.e().f265646d = true;
            com.bytedance.apm.block.f r115 = com.bytedance.apm.block.f.a();
            int r116 = r114.f190476f;
            r115.getClass();
            if (r116 != 11) goto L53;
            r103 = 2;
        L58:
            r115.f190345a = r103;
            com.bytedance.monitor.collector.c r117 = com.bytedance.monitor.collector.c.e();
            int r118 = r115.f190345a;
            if (r117.f265646d == false) goto L68;
            Iterator r119 = ((CopyOnWriteArrayList) r117.f265643a).iterator();
        L62:
            if (r119.hasNext() == false) goto L68;
            AbsMonitor r120 = (AbsMonitor) r119.next();
            if (r120 == null) goto L62;
            b27.b r121 = new b27.b(r120, r118);
            f27.e r122 = new f27.e("refreshConfig", AsyncTaskType.LIGHT_WEIGHT, r121);
            f27.d r123 = r120.f265562d;
            if (r123 == null) goto L62;
            r123.h(r122);
        L68:
            List<com.bytedance.apm.h> r124 = com.bytedance.apm.i.f190559a;
            monitor-enter(com.bytedance.apm.i.class);
            Iterator r125 = ((ArrayList) com.bytedance.apm.i.f190559a).iterator();     // Catch: Throwable -> L80
        L72:
            if (r125.hasNext() == false) goto L77;
            com.bytedance.apm.h r126 = (com.bytedance.apm.h) r125.next();     // Catch: Throwable -> L80
            if (r126 == null) goto L72;
            r126.a(r114);     // Catch: Throwable -> L80
            goto L72
        L77:
            monitor-exit(com.bytedance.apm.i.class);
            com.bytedance.apm.block.e.a(r114.f190485o, r114.f190483m);
            return;
        L80:
            th = move-exception;
            throw th;
        L53:
            if (r116 == 101) goto L56;
            if (r116 == 1001) goto L58;
            r103 = 1;
            goto L58
        L56:
            r103 = 3;
            goto L58
        L101:
            return;
        L46:
            r112 = false;
            goto L47
        L42:
            r111 = false;
            goto L43
        L38:
            r110 = false;
            goto L39
        L34:
            r109 = false;
            goto L35
        L30:
            r108 = false;
            goto L31
        L26:
            r107 = false;
            goto L27
        L22:
            r106 = false;
            goto L23
        L18:
            r105 = false;
            goto L19
        L14:
            r104 = false;
            goto L15
        L100:
            return;
        L8:
            r102 = null;
            goto L9
        }
    }

    public e() {
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }
}
