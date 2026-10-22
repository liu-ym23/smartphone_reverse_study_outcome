package gu3;

import androidx.camera.video.AudioStats;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ut3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ut3.a f482762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ut3.c f482763b;

    public class a implements hu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f482764a;

        public a(b r100) {
            this.f482764a = r100;
        }

        @Override // hu3.b
        public final void a(JSONObject r110) {
            b r100 = this.f482764a;
            r100.getClass();
            if (r110 != null) goto L127;
            return;
        L127:
            JSONObject r111 = r110.optJSONObject("performance_modules").optJSONObject("cpu");     // Catch: Throwable -> L8
        L10:
            if (r111 == null) goto L84;
            r100.f482762a = new ut3.a();
            if (r111.optInt("enable_upload", 0) != 1) goto L14;
            boolean r101 = true;
        L15:
            r100.f482762a.f551629a = r101;
            if (r111.optInt("enable_collect_all_process", 0) != 1) goto L18;
            boolean r102 = true;
        L19:
            r100.f482762a.f551630b = r102;
            long r103 = r111.optLong("front_collect_interval", 0);
            if (r103 <= 0) goto L22;
            r100.f482762a.f551631c = r103;
        L22:
            long r104 = r111.optLong("back_collect_interval", 0);
            if (r104 <= 0) goto L25;
            r100.f482762a.f551632d = r104;
        L25:
            long r105 = r111.optLong("monitor_interval", 0);
            if (r105 <= 0) goto L28;
            r100.f482762a.f551633e = r105;
        L28:
            long r106 = r111.optLong("front_thread_collect_interval", 0);
            if (r106 <= 0) goto L31;
            r100.f482762a.f551634f = r106;
        L31:
            long r107 = r111.optLong("back_thread_collect_interval", 0);
            if (r107 <= 0) goto L34;
            r100.f482762a.f551635g = r107;
        L34:
            r100.f482763b = new ut3.c();
            if (r111.optInt("exception_switch", 0) != 1) goto L37;
            boolean r108 = true;
        L38:
            r100.f482763b.f551636a = r108;
            double r109 = r111.optDouble("exception_process_back_max_speed", AudioStats.AUDIO_AMPLITUDE_NONE);
            if (r109 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L41;
            r100.f482763b.f551638c = r109;
        L41:
            double r112 = r111.optDouble("exception_process_fore_max_speed", AudioStats.AUDIO_AMPLITUDE_NONE);
            if (r112 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L45;
            r100.f482763b.f551639d = r112;
        L45:
            if (r111.optInt("main_thread_collect_enabled", 0) != 1) goto L47;
            boolean r113 = true;
        L48:
            r100.f482763b.f551637b = r113;
            if (r111.optInt("exception_collect_all_process", 0) != 1) goto L51;
            boolean r114 = true;
        L52:
            r100.f482763b.f551642g = r114;
            if (r111.optInt("exception_thread_stack_enabled", 1) != 1) goto L55;
            boolean r115 = true;
        L56:
            r100.f482763b.f551645j = r115;
            double r116 = r111.optDouble("exception_thread_max_usage", AudioStats.AUDIO_AMPLITUDE_NONE);
            if (r116 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L59;
            r100.f482763b.f551640e = r116;
        L59:
            JSONObject r117 = r111.optJSONObject("exception_thread_max_usage_map");
            HashMap r118 = new HashMap();
            if (r117 == null) goto L67;
            Iterator<String> r119 = r117.keys();
        L63:
            if (r119.hasNext() == false) goto L67;
            String r120 = r119.next();
            double r121 = r117.optDouble(r120, AudioStats.AUDIO_AMPLITUDE_NONE);
            if (r121 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L63;
            r118.put(r120, Double.valueOf(r121));
        L67:
            r100.f482763b.f551641f = r118;
            r100.f482763b.f551646k = r111.optInt("process_detect_interval", 30);
            r100.f482763b.f551647l = r111.optInt("thread_detect_interval", 30);
            JSONObject r122 = r111.optJSONObject("exception_fore_max_speed_scene");
            HashMap r123 = new HashMap();
            if (r122 == null) goto L75;
            Iterator<String> r124 = r122.keys();
        L71:
            if (r124.hasNext() == false) goto L75;
            String r125 = r124.next();
            double r126 = r122.optDouble(r125, AudioStats.AUDIO_AMPLITUDE_NONE);
            if (r126 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L71;
            r123.put(r125, Double.valueOf(r126));
        L75:
            r100.f482763b.f551644i = r123;
            JSONObject r127 = r111.optJSONObject("exception_back_max_speed_scene");
            HashMap r128 = new HashMap();
            if (r127 == null) goto L83;
            Iterator<String> r129 = r127.keys();
        L79:
            if (r129.hasNext() == false) goto L83;
            String r130 = r129.next();
            double r131 = r127.optDouble(r130, AudioStats.AUDIO_AMPLITUDE_NONE);
            if (r131 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L79;
            r128.put(r130, Double.valueOf(r131));
        L83:
            r100.f482763b.f551643h = r128;
            r100.f482763b.f551648m = r111.optBoolean("exception_native_thread_enabled", false);
            goto L84
        L55:
            r115 = false;
            goto L56
        L51:
            r114 = false;
            goto L52
        L47:
            r113 = false;
            goto L48
        L37:
            r108 = false;
            goto L38
        L18:
            r102 = false;
            goto L19
        L14:
            r101 = false;
        L84:
            av3.b.a("APM-CPU", r100.f482762a + " " + r100.f482763b);
            tt3.c r132 = tt3.c.a.f547550a;
            ut3.a r133 = r100.f482762a;
            r132.getClass();
            if (r133 == null) goto L120;
            Map<String, tt3.f.a> r134 = tt3.f.f547552a;
            monitor-enter(tt3.f.class);
            tt3.f.f547554c = true;     // Catch: Throwable -> L122
            List<com.bytedance.apm6.cpu.collect.c> r135 = tt3.f.f547553b;     // Catch: Throwable -> L122
            if (r135.isEmpty() == true) goto L96;
            Iterator<com.bytedance.apm6.cpu.collect.c> r136 = r135.iterator();     // Catch: Throwable -> L122
        L93:
            if (r136.hasNext() == false) goto L95;
            nu3.b.a(r136.next());     // Catch: Throwable -> L122
            goto L93
        L95:
            ((LinkedList) tt3.f.f547553b).clear();     // Catch: Throwable -> L122
        L96:
            monitor-exit(tt3.f.class);
            r133.toString();
            if (com.bytedance.apm.d.k() == true) goto L103;
            if (r133.f551630b == false) goto L120;
        L103:
            if (r133.f551629a == false) goto L120;
            com.bytedance.apm6.cpu.collect.b r137 = r132.f547545b;
            if (r137.f190780b.compareAndSet(false, true) == false) goto L116;
            r137.f190786h = r133;
            if (r137.f190781c != null) goto L111;
            r137.f190781c = new tt3.d(r137);
        L111:
            if (r137.f190781c == null) goto L125;
            cv3.b.a(AsyncTaskManagerType.CPU).c(r137.f190781c);
        L125:
            ((bq7.a) r137.f190787i).c();     // Catch: Throwable -> L115
        L116:
            com.bytedance.apm6.cpu.collect.a r138 = r132.f547546c;
            if (r138.f190772a.compareAndSet(false, true) == false) goto L120;
            r138.f190775d = new HashMap();
            r138.f190776e = new HashMap();
            r138.f190777f = new HashMap();
            r138.f190773b = r133;
        L122:
            th = move-exception;
            throw th;
        L120:
            vt3.c.a.f557200a.a(r100.f482763b);
            return;
        L8:
            r111 = null;
            goto L10
        }
    }

    public b() {
        hu3.a.a().b();
        hu3.a.a().c(new a(this));
    }
}
