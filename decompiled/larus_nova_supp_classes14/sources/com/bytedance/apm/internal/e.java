package com.bytedance.apm.internal;

import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.d;
import com.bytedance.apm.util.g;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tr3.a;
import tr3.b;
import tr3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ String d;
    public final /* synthetic */ IALogActiveUploadObserver e;
    public final /* synthetic */ tr3.f f;

    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Exception, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    public final void a() {
        String r0 = this.a;
        long r8 = this.b;
        long r10 = this.c;
        String r15 = this.d;
        IALogActiveUploadObserver r2 = this.e;
        tr3.f r14 = this.f;
        long r19 = System.currentTimeMillis();
        ApmAgent.monitorStatusRate("apm_event_stats_alog", 0, null);
        c.b("begin upload alog:" + r0 + " startTime:" + r8 + " endTime:" + r10 + " scene:" + r15);
        if (d.getContext() != null) goto L6;
        String r1 = "apm context is null";
        int r3 = 0;
    L14:
        String r6 = "apm_event_stats_alog_fail";
        String r4 = "info";
        ?? r5 = 0;
        r14 = r14;
        boolean r13 = true;
        String r7 = r1;
        int r9 = r3;
        boolean r11 = false;
    L125:
        JSONObject r12 = new JSONObject();
        r12.put(r4, r7);     // Catch: JSONException -> L128
    L130:
        JSONObject r16 = c.a(!r13, r9, r5, r12);
        if (r13 == false) goto L134;
        if (r14 == null) goto L134;
        r14.a(r11, r16);
    L134:
        if (r13 == false) goto L136;
        ApmAgent.monitorStatusRate(r6, r9, r16);
    L136:
        c.b("upload end. ".concat(r7));
        JSONObject r17 = new JSONObject();
        r17.put("time", System.currentTimeMillis() - r19);     // Catch: JSONException -> L139
    L141:
        ApmAgent.monitorEvent("apm_event_stats_alog_time", r5, r17, r5);
        return;
    L139:
        e = move-exception;
        e.printStackTrace();
    L128:
        e = move-exception;
        e.printStackTrace();
        goto L130
    L6:
        if (TextUtils.isEmpty(r0) == false) goto L12;
        if (TextUtils.isEmpty(d.w) == false) goto L10;
        r1 = "alog file dir is null";
        r3 = 1;
        goto L14
    L10:
        r0 = d.w;
    L12:
        if (new PolarisFileWrapper(r0).exists() == true) goto L15;
        r1 = "alog file dir do not exist";
        r3 = 2;
        goto L14
    L15:
        if (r2 == null) goto L17;
        r2.flushAlogDataToFile();
        c.b("flush alog data to file");
    L19:
        if (b.a == null) goto L123;
        c.b("begin get alog file");
        tr3.e r18 = b.a;
        d.getContext();
        r6 = "apm_event_stats_alog_fail";
        List r20 = r18.a(r0, r8, r10);
        c.b("end get alog file:" + r0);
        Object r21 = "null";
        if (k.b(r20) == true) goto L105;
        JSONObject r22 = d.g;
        if (r22 == null) goto L25;
        String r23 = r22.optString("aid");
        String r24 = r22.optString("device_id");
    L26:
        d.getContext();
        if (p.a().contains(":") == false) goto L29;
        d.getContext();
        String r25 = p.a();
    L31:
        if (TextUtils.isEmpty(r23) == false) goto L33;
    L41:
        boolean r26 = false;
    L42:
        if (r26 == true) goto L62;
        ApmAgent.monitorStatusRate(r6, 5, null);
        if (r14 == null) goto L59;
        JSONObject r27 = new JSONObject();
        JSONObject r28 = new JSONObject();     // Catch: Exception -> L55
        r28.put("aid", r23);     // Catch: Exception -> L55
        r28.put("did", r24);     // Catch: Exception -> L55
        r28.put("processName", r25);     // Catch: Exception -> L55
        if (r20 == null) goto L49;
        r21 = Integer.valueOf(((ArrayList) r20).size());     // Catch: Exception -> L55
    L49:
        r28.put("alogSize", r21);     // Catch: Exception -> L55
        r4 = "info";
        r27.put(r4, r28.toString());     // Catch: Exception -> L53
    L58:
        r14.a(false, c.a(false, 5, null, r27));
    L60:
        c.b("upload param missed");
        JSONObject r29 = null;
    L61:
        r11 = false;
    L124:
        r7 = "";
        r9 = -1;
        r13 = false;
        r5 = r29;
    L53:
        e = e;
    L57:
        e.printStackTrace();
    L55:
        e = e;
        r4 = "info";
        goto L57
    L59:
        r4 = "info";
        goto L60
    L62:
        r4 = "info";
        c.b("alog file begin zip");
        PolarisFileWrapper r30 = new PolarisFileWrapper((String) ListProtector.get(r20, 0));
        String r31 = r30.getParent();
        String r32 = r30.getName();
        if (TextUtils.isEmpty(r32) == false) goto L65;
        String r33 = "";
    L69:
        PolarisFileWrapper r34 = new PolarisFileWrapper(r31, r33);
        if (r34.exists() == false) goto L153;
        r34.delete();
    L153:
        g.b(r34.getAbsolutePath(), (String[]) ((ArrayList) r20).toArray(new String[0]));     // Catch: Exception -> L74
        String r35 = r34.getAbsolutePath();
    L80:
        c.b("alog file end zip");
        a r36 = new a(new int[]{0}, r14);
        if (TextUtils.isEmpty(r35) == false) goto L86;
        c.b("alog file upload origin file begin");
        JSONObject r37 = null;
        boolean r38 = ur3.a.a(r23, r24, r25, r20, r15, r22, r36);
        if (r38 == true) goto L85;
        r38 = ur3.a.a(r23, r24, r25, r20, r15, r22, r36);
    L85:
        c.b("alog file upload origin file end. success :" + r38);
    L102:
        if (r38 == false) goto L104;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_success", 0, r37);
    L104:
        r29 = r37;
        goto L61
    L86:
        r37 = null;
        ArrayList r39 = new ArrayList();     // Catch: Throwable -> L95
        r39.add(r35);     // Catch: Throwable -> L95
        c.b("alog file upload zip file begin");     // Catch: Throwable -> L95
        boolean r210 = ur3.a.a(r23, r24, r25, r39, r15, r22, r36);     // Catch: Throwable -> L95
        if (r210 == false) goto L149;
        boolean r40 = r210;
    L101:
        c.b("alog file upload zip file end. success:" + r40 + " zip file:" + r35);
        new PolarisFileWrapper(r35).delete();
        r38 = r40;
        goto L102
    L149:
        r40 = ur3.a.a(r23, r24, r25, r39, r15, r22, r36);     // Catch: Throwable -> L92
    L92:
        th = th;
        boolean r110 = r210;
    L98:
        if (d.j() == false) goto L100;
        th.printStackTrace();
    L100:
        r40 = r110;
    L95:
        th = th;
        r110 = false;
    L75:
        if (r34.exists() == false) goto L79;
        r34.delete();     // Catch: Exception -> L78
    L79:
        r35 = null;
        goto L80
    L65:
        int r111 = r32.lastIndexOf(".");
        if (r111 != (-1)) goto L68;
        r33 = r32.concat(".zip");
        goto L69
    L68:
        r33 = r32.substring(0, r111) + ".zip";
        goto L69
    L33:
        if (TextUtils.isEmpty(r24) == true) goto L41;
        if (TextUtils.isEmpty(r25) == true) goto L41;
        if (r20 == null) goto L41;
        if (((ArrayList) r20).size() == 0) goto L41;
        r26 = true;
        goto L42
    L29:
        r25 = "main";
        goto L31
    L25:
        r23 = null;
        r24 = null;
        goto L26
    L105:
        r29 = null;
        r6 = r6;
        r14 = r14;
        r4 = "info";
        r11 = false;
        JSONObject r112 = new JSONObject();
        r112.put(r4, "alog upload file failed,local file is null");     // Catch: Exception -> L117
        r112.put("e_dir", r0);     // Catch: Exception -> L117
        r112.put("e_start_time", r8);     // Catch: Exception -> L117
        r112.put("e_end_time", r10);     // Catch: Exception -> L117
        PolarisFileWrapper r41 = new PolarisFileWrapper(r0);     // Catch: Exception -> L117
        if (r41.exists() == true) goto L110;
    L115:
        r112.put("e_file", "null");     // Catch: Exception -> L117
        goto L118
    L110:
        if (r41.listFiles() == null) goto L115;
        StringBuilder r42 = new StringBuilder();     // Catch: Exception -> L117
        r42.append("[");     // Catch: Exception -> L117
        File[] r43 = r41.listFiles();     // Catch: Exception -> L117
        int r44 = r43.length;     // Catch: Exception -> L117
        int r113 = 0;
    L112:
        if (r113 >= r44) goto L114;
        r42.append(r43[r113].getName());     // Catch: Exception -> L117
        r42.append(",");     // Catch: Exception -> L117
        r113 = r113 + 1;     // Catch: Exception -> L117
        goto L112
    L114:
        r42.append("]");     // Catch: Exception -> L117
        r112.put("e_file", r42.toString());     // Catch: Exception -> L117
    L118:
        JSONObject r45 = c.a(false, 4, null, r112);
        ApmAgent.monitorStatusRate(r6, 4, r45);
        if (r14 != null) goto L144;
    L121:
        c.b("alog upload file failed,local file is null");     // Catch: Exception -> L143
        goto L124
    L144:
        r14.a(false, r45);     // Catch: Exception -> L143
        goto L121
    L123:
        r6 = "apm_event_stats_alog_fail";
        r4 = "info";
        r29 = null;
        r14 = r14;
        r11 = false;
        ApmAgent.monitorStatusRate(r6, 12, c.a(false, 12, null, null));
        goto L124
    L17:
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", 3, null);
        goto L19
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

    public e(String r1, long r2, long r4, String r6, IALogActiveUploadObserver r7, tr3.f r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
