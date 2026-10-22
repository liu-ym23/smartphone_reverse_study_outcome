package xg4;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.dumper.MemoryInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class w extends CrashSummary {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f563732g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f563733h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f563734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f563736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x f563737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f563738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s.a f563739f;

    static {
        f563732g = CrashType.ANR + ".summary";
        f563733h = PatternProtector.compile("^start_time=(\\d+)\\nstart_up_time=(\\d+)\\ncrash_time=(\\d+)\\nprocess_name=(.*)\\npid=(\\d+)\\nby_signal=(true|false)\\n(?:trigger=(\\d+)\\n?)?");
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final String loadStackTrace() {
        JSONObject r100 = new JSONObject();
        x.c r101 = this.f563737d.f563742c;
        if (r101 == null) goto L9;
        StringBuilder r102 = new StringBuilder();
        Iterator<String> r103 = r101.f563762j.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.append(r103.next());
        r102.append('\n');
        goto L6
    L8:
        String r104 = r102.toString();
    L10:
        this.f563736c = r104;
        if (TextUtils.isEmpty(r104) == false) goto L14;
        this.f563736c = com.bytedance.crash.util.g.f(new PolarisFileWrapper(this.mDirectory, "main_stack.txt"));
    L14:
        if (TextUtils.isEmpty(this.f563736c) == false) goto L24;
        this.f563736c = "at InvalidStack.NoStackAvailable(Invalid.java:1).\n";
    L24:
        r100.put("mainStackFromTrace", this.f563736c);     // Catch: JSONException -> L23
        if (this.f563736c != "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L19;
        boolean r105 = true;
    L20:
        r100.put("invalid", r105);     // Catch: JSONException -> L23
        r100.put("is_new_stack", 10);     // Catch: JSONException -> L23
        goto L22
    L19:
        r105 = false;
    L22:
        return r100.toString();
    L9:
        r104 = null;
        goto L10
    }

    public static w c(File r110) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110, f563732g);
        String r111 = com.bytedance.crash.util.g.f(r100);
        if (TextUtils.isEmpty(r111) == false) goto L16;
    L14:
        return null;
    L16:
        Matcher r112 = f563733h.matcher(r111);     // Catch: Throwable -> L12
        if (r112.find() == false) goto L14;
        long r101 = CastLongProtector.parseLong(r112.group(1));     // Catch: Throwable -> L12
        long r102 = CastLongProtector.parseLong(r112.group(2));     // Catch: Throwable -> L12
        long r103 = CastLongProtector.parseLong(r112.group(3));     // Catch: Throwable -> L12
        String r113 = r112.group(4);     // Catch: Throwable -> L12
        int r114 = CastIntegerProtector.parseInt(r112.group(5));     // Catch: Throwable -> L12
        boolean r115 = Boolean.parseBoolean(r112.group(6));     // Catch: Throwable -> L12
        if (r112.group(7) == null) goto L9;
        int r116 = CastIntegerProtector.parseInt(r112.group(7));     // Catch: Throwable -> L12
    L10:
        return new w(r100.getParentFile(), r101, r102, r103, r113, r114, r116, r115);
    L9:
        r116 = 9999;
    L12:
        th = move-exception;
        ch4.c.b("NPTH_ANR_ERROR_LOAD", th);
        goto L14
    }

    public final void a(JSONObject r100) {
        String r101 = r100.optString("data");
        int r102 = 0;
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
        return;
    L10:
        String r104 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(this.mDirectory, "main_stack.txt"));
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return;
    L13:
        String[] r105 = r104.split("\n");
        JSONArray r106 = new JSONArray();
        int r107 = r105.length;
    L14:
        if (r102 >= r107) goto L16;
        r106.put(r105[r102]);
        r102 = r102 + 1;
        goto L14
    L16:
        eh4.c.a(r100, "main_stack_2nd", r106);
        return;
    L5:
        if (r101.startsWith("{\"mainStackFromTrace\":\"\\\"main\\\"") == false) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final void appendSpecialFilter(JSONObject r210) {
        JSONObject r100 = com.bytedance.crash.util.j.e(r210, "filters");
        if (this.f563734a == false) goto L5;
        Object r101 = "true";
    L6:
        com.bytedance.crash.util.j.h(r100, "by_signal", r101);
        com.bytedance.crash.util.j.h(r100, "anr_trigger", Integer.valueOf(this.f563735b));
        x r102 = this.f563737d;
        if (r102.f563740a.isEmpty() == true) goto L9;
        com.bytedance.crash.util.j.h(r100, "anr_replace_mainstack", "OnlyJavaStack");
    L9:
        x.c r103 = r102.f563742c;
        if (r103 == null) goto L12;
        boolean r104 = r103.f563761i;
        int r105 = r103.f563758f;
    L13:
        long[] r110 = {0, 0, 0};
        Iterator<x.c> r111 = r102.f563740a.iterator();
        String r112 = "unknown";
        String r113 = "unknown";
        String r114 = r113;
        int r115 = 0;
    L15:
        if (r111.hasNext() == false) goto L35;
        x.c r106 = r111.next();
        Iterator<x.c> r211 = r111;
        if ("RenderThread".equals(r106.f563753a) == false) goto L19;
        com.bytedance.crash.util.j.h(r100, "anr_renderthread_nice", Integer.valueOf(r106.f563758f));
    L24:
        r104 = r104 | r106.f563761i;
        int r116 = r105;
        long r107 = r106.f563755c;
        if (r107 <= r110[0]) goto L27;
        r110[0] = r107;
        r112 = r106.f563753a;
    L27:
        String r212 = r112;
        long r117 = r106.f563756d;
        if (r117 <= r110[1]) goto L30;
        r110[1] = r117;
        r113 = r106.f563753a;
    L30:
        long r108 = r107 + r117;
        if (r108 <= r110[2]) goto L33;
        r110[2] = r108;
        r114 = r106.f563753a;
    L33:
        r111 = r211;
        r105 = r116;
        r112 = r212;
        goto L15
    L19:
        int r109 = r106.f563758f;
        if (r109 >= r105) goto L24;
        if (r109 > (-16)) goto L24;
        r115 = r115 + 1;
        goto L24
    L35:
        if (r102.f563742c == null) goto L37;
        boolean r118 = true;
    L38:
        com.bytedance.crash.util.j.h(r100, "anr_trace_has_mainstack", Boolean.valueOf(r118));
        com.bytedance.crash.util.j.h(r100, "anr_trace_cost_time", r102.f563745f.f563749c);
        com.bytedance.crash.util.j.h(r100, "anr_trace_crash", Boolean.valueOf(r102.f563745f.f563748b));
        if (r102.f563745f.f563747a == true) goto L41;
    L45:
        boolean r119 = false;
    L46:
        com.bytedance.crash.util.j.h(r100, "anr_trace_done", Boolean.valueOf(r119));
        com.bytedance.crash.util.j.h(r100, "anr_trace_thread_count", com.bytedance.crash.dumper.l.a(r102.f563740a.size() + 1));
        x.c r120 = r102.f563742c;
        if (r120 == null) goto L49;
        com.bytedance.crash.util.j.h(r100, "anr_thread_state", r120.f563754b);
        com.bytedance.crash.util.j.h(r100, "anr_locked_by_native", Boolean.valueOf(r102.f563742c.c()));
        com.bytedance.crash.util.j.h(r100, "anr_locked_by_java", Boolean.valueOf(r102.f563742c.b()));
    L49:
        com.bytedance.crash.util.j.h(r100, "max_utm_thread", r112);
        com.bytedance.crash.util.j.h(r100, "max_stm_thread", r113);
        com.bytedance.crash.util.j.h(r100, "max_utm_stm_thread", r114);
        com.bytedance.crash.util.j.h(r100, "anr_backup_native_stack", Boolean.valueOf(r104));
        com.bytedance.crash.util.j.h(r100, "anr_subthread_count_nice<=-16", Integer.valueOf(r115));
        com.bytedance.crash.util.j.h(r100, "npth_is_wait_for_gc", Boolean.valueOf(r102.a()));
        eh4.b.b(r100, r210);
        PolarisFileWrapper r121 = r102.f563746g;
        if (r121 != null) goto L52;
    L59:
        com.bytedance.crash.util.j.h(r100, "anr_dump_async", "false");
    L60:
        j r122 = this.f563738e;
        if (r122 != null) goto L382;
        Object r213 = "false";
    L121:
        s.a r123 = this.f563739f;
        if (r123 == null) goto L212;
        PolarisFileWrapper r124 = new PolarisFileWrapper(r123.f563730a + "/anr_profiler.txt");
        if (r124.exists() == false) goto L212;
        BufferedReader r125 = new BufferedReader(new PolarisFileReaderWrapper(r124));     // Catch: Throwable -> L210
        String r126 = null;
        String r127 = null;
    L128:
        String r128 = r127;
        boolean r129 = false;
    L129:
        String r130 = r126;
    L363:
        String r131 = r125.readLine();     // Catch: Throwable -> L341
        if (r131 == null) goto L211;
        String[] r132 = r131.split(">");     // Catch: Throwable -> L341
        if (r132.length != 2) goto L134;
        String r133 = r132[0].trim();     // Catch: Throwable -> L341
        switch(r133.hashCode()) {
            case -1771995437: goto L177;
            case -1427608066: goto L174;
            case -1276471214: goto L171;
            case -1209385580: goto L168;
            case -892691330: goto L165;
            case -523188726: goto L162;
            case -315273688: goto L159;
            case 1317675854: goto L156;
            case 1367485235: goto L153;
            case 2060837732: goto L150;
            case 2064264317: goto L147;
            case 2066285238: goto L144;
            case 2072399136: goto L141;
            default: goto L179;
        };     // Catch: Throwable -> L340
    L179:
        byte r134 = -1;
    L180:
        switch(r134) {
            case 0: goto L200;
            case 1: goto L199;
            case 2: goto L198;
            case 3: goto L197;
            case 4: goto L196;
            case 5: goto L195;
            case 6: goto L194;
            case 7: goto L188;
            case 8: goto L186;
            case 9: goto L185;
            case 10: goto L184;
            case 11: goto L183;
            case 12: goto L182;
            default: goto L363;
        };     // Catch: Throwable -> L340
    L182:
        r126 = r130;
        r127 = r128;
        goto L128
    L183:
        r129 = true;
        goto L363
    L184:
        s.a.i(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L185:
        char r135 = 1;
    L187:
        s.a.g(r100, r132[r135]);     // Catch: Throwable -> L340
        goto L363
    L186:
        r135 = 1;
        com.bytedance.crash.util.j.h(r100, "npth_profiler_anr_reason", r132[1].trim());     // Catch: Throwable -> L340
        goto L187
    L188:
        Matcher r136 = PatternProtector.compile("^ JavaLock (.*)$").matcher(r132[1]);     // Catch: Throwable -> L340
        if (r136.find() == false) goto L363;
        if (r136.groupCount() != 1) goto L363;
        com.bytedance.crash.util.j.h(r100, "npth_profiler_java_lock_owner", r136.group(1));     // Catch: Throwable -> L340
        goto L363
    L194:
        s.a.e(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L195:
        s.a.f(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L196:
        s.a.a(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L197:
        s.a.b(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L198:
        s.a.d(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L199:
        s.a.c(r100, r132[1]);     // Catch: Throwable -> L340
        goto L363
    L200:
        String r137 = r132[1];     // Catch: Throwable -> L340
        int r138 = r137.indexOf(40);     // Catch: Throwable -> L340 Exception -> L204
        int r139 = r137.lastIndexOf(41);     // Catch: Throwable -> L340 Exception -> L204
        int r140 = r137.indexOf(RemoteMessageConst.TO);     // Catch: Throwable -> L340 Exception -> L204
        Pair r141 = new Pair(r137.substring(r138 + 12, r140 - 5), r137.substring(r140 + 14, r139 - 4));     // Catch: Throwable -> L340 Exception -> L204
    L206:
        if (r141 == null) goto L363;
        r126 = (String) r141.second;     // Catch: Throwable -> L340
        r128 = (String) r141.first;     // Catch: Throwable -> L339
    L204:
        e = move-exception;
        ch4.c.b("getANRTime", e);     // Catch: Throwable -> L340
        r141 = null;
        goto L206
    L141:
        if (r133.equals("CPU_SCHED") == false) goto L179;
        r134 = 2;
        goto L180
    L144:
        if (r133.equals("CPU_LOADS") == false) goto L179;
        r134 = 1;
        goto L180
    L147:
        if (r133.equals("CPU_JIFFS") == false) goto L179;
        r134 = 3;
        goto L180
    L150:
        if (r133.equals("CPU_FREQS") == false) goto L179;
        r134 = 4;
        goto L180
    L153:
        if (r133.equals("JVM_STATE") == false) goto L179;
        r134 = 7;
        goto L180
    L156:
        if (r133.equals("GC_STATE") == false) goto L179;
        r134 = 6;
        goto L180
    L159:
        if (r133.equals("SCHED_STREAM") == false) goto L179;
        r134 = 11;
        goto L180
    L162:
        if (r133.equals("PROC_MEMORY") == false) goto L179;
        r134 = 9;
        goto L180
    L165:
        if (r133.equals("MEMORY_STREAM") == false) goto L179;
        r134 = 12;
        goto L180
    L168:
        if (r133.equals("DURATION") == false) goto L179;
        r134 = 0;
        goto L180
    L171:
        if (r133.equals("PAGE_FAULT") == false) goto L179;
        r134 = 5;
        goto L180
    L174:
        if (r133.equals("ANR_REASON") == false) goto L179;
        r134 = 8;
        goto L180
    L177:
        if (r133.equals("SYS_MEMORY") == false) goto L179;
        r134 = 10;
        goto L180
    L134:
        if (r129 == false) goto L363;
        r123.h(r100, r131, r128, r130);     // Catch: Throwable -> L341
    L211:
        com.bytedance.crash.util.g.a(r125);
    L210:
        r125 = null;
    L212:
        JSONArray r142 = r210.optJSONArray("history_message");
        if (r142 != null) goto L215;
    L217:
        com.bytedance.crash.util.j.h(r100, "has_history_message", r213);
    L218:
        JSONArray r143 = r210.optJSONArray("pending_messages");
        if (r143 != null) goto L221;
    L225:
        JSONObject r144 = r210.optJSONObject("history_details");
        long r145 = 0;
        if (r144 == null) goto L239;
        com.bytedance.crash.util.j.h(r100, "npth_message_longest_msg", r144.optString("longestMsg"));
        com.bytedance.crash.util.j.h(r100, "npth_message_longest_msg_type", r144.optString("longestMsgType"));
        long r146 = r210.optLong("main_thread_cpu_tick") * ((long) r210.optInt("jiffy"));
        long r147 = r144.optLong("longestMsgStartCpuTime");
        long r214 = r144.optLong("longestMsgEndCpuTime");
        if (r146 != 0) goto L230;
    L237:
        boolean r148 = false;
    L238:
        com.bytedance.crash.util.j.h(r100, "npth_message_trace_is_evil", String.valueOf(r148));
        com.bytedance.crash.util.j.h(r100, "npth_message_has_block_stack", String.valueOf(!"".equals(r144.optString("longestMsgBlockStack"))));
        goto L239
    L230:
        if (r147 == 0) goto L237;
        long r215 = (r214 / 10) * 10;
        if (r146 < ((r147 / 10) * 10)) goto L237;
        if (r146 >= r215) goto L237;
        r148 = true;
    L239:
        File r149 = this.mDirectory;
        String r150 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r149, "anr_config.txt"));
        if (r150 == null) goto L373;
        JSONObject r151 = new JSONObject(r150);     // Catch: Throwable -> L243
    L244:
        if (r151 == null) goto L373;
        int r152 = r151.optInt("oom_adj", -1);     // Catch: Throwable -> L342
        if (r152 < 200) goto L249;
    L251:
        boolean r153 = false;
    L252:
        if (r152 < 0) goto L348;
        r100.put("is_background_v1", String.valueOf(r153));     // Catch: Throwable -> L342
        goto L348
    L249:
        if (new PolarisFileWrapper(r149, "background_v2").exists() == false) goto L251;
        r153 = true;
    L348:
    L263:
        e = move-exception;
        com.bytedance.crash.util.p.d(e);
    L265:
        com.bytedance.crash.util.j.d(r100, r151);
        goto L373
    L255:
        if (r151.has("init_sub_launch_time") == false) goto L265;
        long r154 = JSONObjectProtectorUtils.getLong(r151, "init_sub_launch_time") / 1000;     // Catch: Exception -> L263
        if (r154 <= 0) goto L260;
        r100.put("npth_init_sub_launch_range", r154 + Constants.WAVE_SEPARATOR + (r154 + 1));     // Catch: Exception -> L263
    L261:
        r151.remove("init_sub_launch_time");     // Catch: Exception -> L263
        goto L265
    L260:
        r100.put("npth_init_sub_launch_range", "<1");     // Catch: Exception -> L263
    L243:
        r151 = null;
    L373:
        this.mDirectory.listFiles(new com.bytedance.crash.dumper.h(r100));     // Catch: Throwable -> L269
    L271:
        File r155 = this.mDirectory;
        com.bytedance.crash.dumper.m r156 = com.bytedance.crash.dumper.m.f203179j;
        long r157 = r210.optLong("crash_time");     // Catch: Throwable -> L346
        PolarisFileWrapper r158 = new PolarisFileWrapper(r155, "process_state.txt");     // Catch: Throwable -> L346
        if (r158.exists() == false) goto L359;
        SimpleDateFormat r159 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // Catch: Throwable -> L346
        StringBuilder r160 = new StringBuilder();     // Catch: Throwable -> L346
        BufferedReader r161 = new BufferedReader(new PolarisFileReaderWrapper(r158));     // Catch: Throwable -> L305 Exception -> L309
        long r216 = SieveCacheKt.NodeLinkMask;
        String r162 = null;
    L372:
        String r163 = r161.readLine();     // Catch: Throwable -> L300 Exception -> L302
        if (r163 == null) goto L295;
        String[] r164 = r163.split(",");     // Catch: Exception -> L292 Throwable -> L300
        String r217 = r162;
        long r165 = Long.parseLong(r164[0]);     // Catch: Exception -> L343 Throwable -> L300
        long r218 = r165 - r157;
        if (r218 > r145) goto L286;
    L288:
        r163 = r217;
    L361:
        r160.append(r159.format(new Date(r165)));     // Catch: Exception -> L291 Throwable -> L300
        r160.append(":");     // Catch: Exception -> L291 Throwable -> L300
        r160.append(r164[1]);     // Catch: Exception -> L291 Throwable -> L300
        r160.append("\n");     // Catch: Exception -> L291 Throwable -> L300
        r162 = r163;
        r145 = 0;
    L291:
        String r166 = r163;
    L294:
        String r219 = r166;
    L310:
        com.bytedance.crash.util.g.a(r161);     // Catch: Throwable -> L346
        String r167 = r219;
    L312:
        if (TextUtils.isEmpty(r167) == true) goto L359;
        int r168 = CastIntegerProtector.parseInt(r167.split(",")[1]);     // Catch: Throwable -> L346
        int r169 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L346
        if (r169 != 29) goto L320;
        if (r168 > 7) goto L327;
    L328:
        boolean r170 = false;
    L329:
        r100.put("is_background_v2", String.valueOf(r170));     // Catch: Throwable -> L346
        r100.put("process_state", String.valueOf(r168));     // Catch: Throwable -> L346
    L327:
        r170 = true;
        goto L329
    L320:
        if (r169 != 28) goto L324;
        if (r168 <= 5) goto L328;
    L324:
        if (r169 < 23) goto L328;
        if (r168 <= 6) goto L328;
    L286:
        if (r218 >= r216) goto L288;
        r216 = r218;
    L293:
        r166 = r217;
    L292:
        r217 = r162;
        goto L293
    L295:
        String r220 = r162;
        com.bytedance.crash.util.h.h(new PolarisFileWrapper(r155, "process_state_format.txt"), r160.toString(), false);     // Catch: Throwable -> L300 Exception -> L344
        com.bytedance.crash.util.g.a(r161);     // Catch: Throwable -> L346
        r167 = r220;
        goto L312
    L304:
        r219 = r220;
    L300:
        th = th;
        BufferedReader r171 = r161;
    L307:
        com.bytedance.crash.util.g.a(r171);     // Catch: Throwable -> L346
        throw th;     // Catch: Throwable -> L346
    L302:
        r220 = r162;
        goto L304
    L309:
        r161 = null;
        r219 = null;
    L305:
        th = th;
        r171 = null;
    L359:
        String r172 = r210.optString("exit_reason");     // Catch: Throwable -> L347
        if (TextUtils.isEmpty(r172) == true) goto L334;
        r100.put("exit_reason", r172);     // Catch: Throwable -> L347
    L334:
        String r173 = r210.optString("anr_reason_from_exit");     // Catch: Throwable -> L347
        if (TextUtils.isEmpty(r173) == true) goto L337;
        r100.put("anr_reason_from_exit", r173);     // Catch: Throwable -> L347
    L337:
        com.bytedance.crash.util.j.h(r100, "malloc_type", NativeBridge.v());
        return;
    L269:
        th = move-exception;
        ch4.c.a("pushEvilFile", th);
        goto L271
    L221:
        if (r143.length() <= 0) goto L225;
        JSONObject r174 = r143.optJSONObject(0);
        if (r174 == null) goto L225;
        com.bytedance.crash.util.j.h(r100, "npth_message_anr_with_barrier_new", String.valueOf(r174.optString(PickerReporterConstants.KEY.TARGET).isEmpty()));
        goto L225
    L215:
        if (r142.length() <= 0) goto L217;
        com.bytedance.crash.util.j.h(r100, "has_history_message", "true");
        goto L218
    L382:
        r100.put("anr_tag", r122.f563671g);     // Catch: Throwable -> L117
        r100.put("anr_reason", r122.f563670f);     // Catch: Throwable -> L117
        r100.put("is_current_process", r122.f563666b);     // Catch: Throwable -> L117
        r100.put("input_timeout_type", r122.e());     // Catch: Throwable -> L117
        if (TextUtils.isEmpty(r122.f563665a) == false) goto L66;
    L68:
        r100.put("has_anrinfo", "false");     // Catch: Throwable -> L117
    L69:
        j.a r175 = r122.f563675k;     // Catch: Throwable -> L117
        if (r175 != null) goto L72;
    L74:
        boolean r176 = false;
    L75:
        r100.put("anr_has_ago", String.valueOf(r176));     // Catch: Throwable -> L117
        if (r122.f563675k == null) goto L78;
        boolean r177 = true;
    L79:
        r100.put("success_end_anrinfo", String.valueOf(r177));     // Catch: Throwable -> L117
        r100.put("anr_cpu_load_1", j.a(r122.f563674j[0]));     // Catch: Throwable -> L117
        r100.put("anr_cpu_load_5", j.a(r122.f563674j[1]));     // Catch: Throwable -> L117
        r100.put("anr_cpu_load_15", j.a(r122.f563674j[2]));     // Catch: Throwable -> L117
        j.a r178 = r122.f563675k;     // Catch: Throwable -> L117
        r213 = "false";
        if (r178 == null) goto L100;
        r100.put("anr_cpu_total", j.a((float) r178.f563687j));     // Catch: Throwable -> L88
        r100.put("anr_cpu_user", j.a((float) r122.f563675k.f563688k));     // Catch: Throwable -> L88
        r100.put("anr_cpu_kernel", j.a((float) r122.f563675k.f563689l));     // Catch: Throwable -> L88
        r100.put("anr_cpu_iowait", j.a((float) r122.f563675k.f563690m));     // Catch: Throwable -> L88
        Iterator<j.c> r179 = r122.f563675k.f563693p.iterator();     // Catch: Throwable -> L88
    L84:
        if (r179.hasNext() == false) goto L90;
        j.c r180 = r179.next();     // Catch: Throwable -> L88
        if (r180.f563709g != r122.f563668d) goto L84;
    L91:
        if (r180 == null) goto L93;
        r100.put("anr_app_cpu_total", j.a((float) r180.f563704b));     // Catch: Throwable -> L88
        r100.put("anr_app_cpu_user", j.a((float) r180.f563705c));     // Catch: Throwable -> L88
        r100.put("anr_app_cpu_kernel", j.a((float) r180.f563706d));     // Catch: Throwable -> L88
        r100.put("anr_faults_minor", j.c(r180.f563707e));     // Catch: Throwable -> L88
        r100.put("anr_faults_major", j.c(r180.f563708f));     // Catch: Throwable -> L88
    L93:
        j.a r181 = r122.f563675k;     // Catch: Throwable -> L88
        if (r181.f563693p.size() == 0) goto L96;
        j.c r182 = (j.c) ListProtector.get(r181.f563693p, 0);     // Catch: Throwable -> L88
    L97:
        if (r182 == null) goto L121;
        r100.put("anr_top_cpu_process", r182.f563703a);     // Catch: Throwable -> L88
        goto L121
    L96:
        r182 = null;
        goto L97
    L90:
        r180 = null;
        goto L91
    L100:
        if (r122.f563676l == null) goto L121;
        r100.put("anr_cpu_total", j.a((float) r178.f563687j));     // Catch: Throwable -> L88
        r100.put("anr_cpu_user", j.a((float) r122.f563675k.f563688k));     // Catch: Throwable -> L88
        r100.put("anr_cpu_kernel", j.a((float) r122.f563675k.f563689l));     // Catch: Throwable -> L88
        r100.put("anr_cpu_iowait", j.a((float) r122.f563675k.f563690m));     // Catch: Throwable -> L88
        Iterator<j.c> r183 = r122.f563676l.f563693p.iterator();     // Catch: Throwable -> L88
    L103:
        if (r183.hasNext() == false) goto L107;
        j.c r184 = r183.next();     // Catch: Throwable -> L88
        if (r184.f563709g != r122.f563668d) goto L103;
    L108:
        if (r184 == null) goto L110;
        r100.put("anr_app_cpu_total", j.a((float) r184.f563704b));     // Catch: Throwable -> L88
        r100.put("anr_app_cpu_user", j.a((float) r184.f563705c));     // Catch: Throwable -> L88
        r100.put("anr_app_cpu_kernel", j.a((float) r184.f563706d));     // Catch: Throwable -> L88
        r100.put("anr_faults_minor", j.c(r184.f563707e));     // Catch: Throwable -> L88
        r100.put("anr_faults_major", j.c(r184.f563708f));     // Catch: Throwable -> L88
    L110:
        j.a r185 = r122.f563675k;     // Catch: Throwable -> L88
        if (r185.f563693p.size() == 0) goto L113;
        j.c r186 = (j.c) ListProtector.get(r185.f563693p, 0);     // Catch: Throwable -> L88
    L114:
        if (r186 == null) goto L121;
        r100.put("anr_top_cpu_process", r186.f563703a);     // Catch: Throwable -> L88
        goto L121
    L113:
        r186 = null;
        goto L114
    L107:
        r184 = null;
    L88:
        th = th;
    L119:
        com.bytedance.crash.util.p.d(th);
        goto L121
    L78:
        r177 = false;
        goto L79
    L72:
        if (r175.f563685h == false) goto L74;
        r176 = true;
        goto L75
    L66:
        if (r122.f563665a.equals("silent anr no anr info") == true) goto L68;
        r100.put("has_anrinfo", "true");     // Catch: Throwable -> L117
    L117:
        th = th;
        r213 = "false";
        goto L119
    L52:
        if (r121.exists() == false) goto L59;
        if (r102.f563746g.length() <= 1024) goto L57;
        com.bytedance.crash.util.j.h(r100, "anr_dump_async", "success");
    L58:
        r102.f563746g.delete();
        goto L60
    L57:
        com.bytedance.crash.util.j.h(r100, "anr_dump_async", "fail");
        goto L58
    L41:
        if (r102.f563742c == null) goto L45;
        if (r102.f563740a.isEmpty() == true) goto L45;
        r119 = true;
        goto L46
    L37:
        r118 = false;
        goto L38
    L12:
        r105 = -10;
        r104 = false;
        goto L13
    L5:
        r101 = "false";
        goto L6
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final void assemblySpecialCrashBody(eh4.a r100, Header r101) {
        boolean r102 = true;
        r100.a("is_anr", 1);     // Catch: Throwable -> L5
        this.f563737d.b(r100.f472653a);     // Catch: Throwable -> L5
        j r103 = new j(this.mDirectory);     // Catch: Throwable -> L5
        this.f563738e = r103;     // Catch: Throwable -> L5
        r103.h(r100.f472653a);     // Catch: Throwable -> L5
        ih4.b.b(r100.f472653a);     // Catch: Throwable -> L5
        com.bytedance.crash.dumper.k.i(r100.f472653a);     // Catch: Throwable -> L5
        this.f563739f = new s.a(this.mDirectory, r100.f472653a, this.f563737d, this.f563738e);     // Catch: Throwable -> L5
        s.a.j(r100.f472653a, this.mDirectory);     // Catch: Throwable -> L5
        a(r100.f472653a);     // Catch: Throwable -> L5
        ai4.a.a(r100.f472653a);     // Catch: Throwable -> L5
    L8:
        if ((!TextUtils.isEmpty(this.f563738e.f563665a)) == true) goto L10;
    L24:
        com.bytedance.crash.util.j.h(r101.f203195a, "aid", 2010);
        return;
    L10:
        if (this.f563736c == "at InvalidStack.NoStackAvailable(Invalid.java:1).\n") goto L24;
        if (Build.VERSION.SDK_INT >= 30) goto L15;
    L17:
        r102 = false;
    L18:
        if (r102 == false) goto L28;
        String r104 = r100.f472653a.optString("exit_reason");
        if (TextUtils.isEmpty(r104) == false) goto L22;
        return;
    L22:
        if (r104.contains("6") == true) goto L30;
        com.bytedance.crash.util.j.h(r101.f203195a, "aid", 2010);
        return;
    L30:
        return;
    L28:
        return;
    L15:
        if (com.bytedance.crash.k.f203234d == false) goto L17;
    L5:
        th = move-exception;
        ch4.c.c(th);
        goto L8
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final boolean upload(com.bytedance.crash.monitor.a r100, JSONObject r101) {
        boolean r102 = super.upload(r100, r101);
        if (com.bytedance.crash.k.f203231a == true) goto L6;
        if (r102 == true) goto L6;
        com.bytedance.crash.util.g.e(this.mDirectory);
    L6:
        return r102;
    }

    @Override // com.bytedance.crash.crash.CrashSummary
    public final void loadCrashInfo(JSONObject r100, JSONObject r101, File r102) {
        MemoryInfo.b(r100, r102);
        ih4.c.d(r100, r102);
        if (r102 == null) goto L5;
        mh4.d.f(r100, r102.getParentFile());
    L5:
        String r103 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r102, "sdk_info.json"));
        if (r103 != null) goto L22;
    L11:
        com.bytedance.crash.dumper.k.h(r100, r102);
        bi4.a.g(r100, r102);
        Scraps.pushTo(r100, r102);
        String r104 = com.bytedance.crash.util.g.f(new PolarisFileWrapper(r102, "custom.json"));
        if (r104 != null) goto L24;
    L14:
        com.bytedance.crash.monitor.a r105 = com.bytedance.crash.monitor.j.f203315a;
        if (r105 == null) goto L27;
        yh4.a r106 = r105.f203300l;
        if (r106 == null) goto L26;
        ((com.bytedance.crash.dumper.j) r106).d(r100, r101, r102);
        return;
    L26:
        return;
    L27:
        return;
    L24:
        com.bytedance.crash.util.j.d(r100, new JSONObject(r104));     // Catch: Throwable -> L21
        goto L14
    L22:
        com.bytedance.crash.util.j.d(r100, new JSONObject(r103));     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        com.bytedance.crash.util.p.d(e);
        goto L11
    }

    public static void b(File r100, long r101, boolean r110, int r111) {
        String r102 = r100 + HTTP.URL_DEFAULT + f563732g;
        dh4.a r103 = new dh4.b(r102);     // Catch: Throwable -> L5
    L6:
        String r104 = com.bytedance.crash.util.b.c();
        long r105 = com.bytedance.crash.i.b();
        long r106 = com.bytedance.crash.i.a().f203226f;
        int r107 = Process.myPid();
        r103.d("start_time=");
        r103.c(r105);
        r103.a('\n');
        r103.d("start_up_time=");
        r103.c(r106);
        r103.a('\n');
        r103.d("crash_time=");
        r103.c(r101);
        r103.a('\n');
        r103.d("process_name=");
        if (r104 == null) goto L9;
        r103.d(r104);
    L9:
        r103.a('\n');
        r103.d("pid=");
        r103.b(r107);
        r103.a('\n');
        r103.d("by_signal=");
        if (r110 == false) goto L12;
        r103.e(dh4.i.f468606b);
    L13:
        r103.a('\n');
        r103.d("trigger=");
        r103.b(r111);
        r103.a('\n');
        r103.f();
        return;
    L12:
        r103.e(dh4.i.f468607c);
    L5:
        r103 = new dh4.c(r102);
        goto L6
    }

    public w(File r110, long r111, long r112, long r210, String r211, int r212, int r213, boolean r214) {
        super(r110, CrashType.ANR, r111, r112, r210, r211, PullConfiguration.PROCESS_NAME_MAIN, r212, r212);
        this.f563734a = r214;
        this.f563735b = r213;
        this.f563737d = new x(r110, r212);
        this.mStackTrace = loadStackTrace();
    }
}
