package et3;

import com.bytedance.apm.constant.FilterTypeStringDef;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.k;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ es3.e.a c;
    public final /* synthetic */ h d;

    public final void a() {
    L50:
        e = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L67;
        e.printStackTrace();
        return;
    L67:
        return;
    L4:
        if (k.b(this.a) == false) goto L6;
        return;
    L6:
        float r2 = i.a;     // Catch: Exception -> L50
        int r3 = i.b;     // Catch: Exception -> L50
        int r4 = r3 - 1;     // Catch: Exception -> L50
        int r5 = (r4 + 0) + 1;     // Catch: Exception -> L50
        int[] r7 = new int[r5];     // Catch: Exception -> L50
        int[] r6 = new int[r5];     // Catch: Exception -> L50
        Iterator r8 = this.a.iterator();     // Catch: Exception -> L50
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r8.hasNext() == false) goto L16;
        Integer r13 = (Integer) r8.next();     // Catch: Exception -> L50
        int r14 = r13.intValue() / ((int) (r2 * 100.0f));     // Catch: Exception -> L50
        if (r14 <= 0) goto L12;
        r10 = r10 + r14;     // Catch: Exception -> L50
    L12:
        int[] r17 = r7;
        if (r13.intValue() < 833.0d) goto L15;
        r11 = r11 + (r13.intValue() / 100);     // Catch: Exception -> L50
    L15:
        int r15 = Math.max(Math.min(r14, r4), r9);     // Catch: Exception -> L50
        r17[r15] = r17[r15] + 1;     // Catch: Exception -> L50
        r6[r15] = (int) (((double) r6[r15]) + (((double) r13.intValue()) / 100.0d));     // Catch: Exception -> L50
        r12 = r12 + (r13.intValue() / 100);     // Catch: Exception -> L50
        r7 = r17;
        r10 = r10;
        r9 = 0;
        goto L8
    L16:
        int[] r18 = r7;
        int r16 = ((this.a.size() * 100) * r3) / (this.a.size() + r10);     // Catch: Exception -> L50
        this.b.put("report_list_size", Integer.toString(this.a.size()));     // Catch: Exception -> L50
        h r19 = this.d;     // Catch: Exception -> L50
        Map r20 = this.b;     // Catch: Exception -> L50
        float r21 = (float) (((double) r16) / 100.0d);     // Catch: Exception -> L50
        c$d r22 = r19.d;     // Catch: Exception -> L50
        if (r22 == null) goto L19;
        r22.fpsCallBack(r21);     // Catch: Exception -> L50
    L19:
        b r23 = b.C0120b.a;     // Catch: Exception -> L50
        String r24 = r19.a;     // Catch: Exception -> L50
        r23.getClass();     // Catch: Exception -> L50
        bt3.b.d.a.e(new a(r23, r24, r20, r21));     // Catch: Exception -> L50
        int r25 = (int) ((this.a.size() + r10) * r2);     // Catch: Exception -> L50
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L50
        int r27 = 0;
    L20:
        if (r27 > r4) goto L25;
        if (r18[r27] <= 0) goto L24;
        r26.put(String.valueOf(r27), r18[r27]);     // Catch: Exception -> L50
        int r28 = r18[r27];     // Catch: Exception -> L50
    L24:
        r27 = r27 + 1;     // Catch: Exception -> L50
        goto L20
    L25:
        JSONObject r29 = new JSONObject();     // Catch: Exception -> L50
        int r30 = 0;
    L26:
        if (r30 > r4) goto L32;
        if (r6[r30] <= 0.1d) goto L30;
        r29.put(String.valueOf(r30), r6[r30]);     // Catch: Exception -> L50
    L30:
        r30 = r30 + 1;     // Catch: Exception -> L50
        goto L26
    L32:
        if (this.d.e == null) goto L35;
        this.d.e.dropFrame(j.a(r26));     // Catch: Exception -> L50
    L35:
        if (this.d.f == null) goto L37;
        c$b r31 = this.d.f;     // Catch: Exception -> L50
        es3.e.a r32 = this.c;     // Catch: Exception -> L50
        r31.blockTimeCallBack(r32.b, r32.a);     // Catch: Exception -> L50
    L37:
        this.d.getClass();     // Catch: Exception -> L50
        JSONObject r33 = new JSONObject();     // Catch: Exception -> L50
        r33.put("scene", this.d.a);     // Catch: Exception -> L50
        JSONObject r34 = new JSONObject();     // Catch: Exception -> L50
        r34.put("total_scroll_time", r12);     // Catch: Exception -> L50
        r34.put("dur", r25);     // Catch: Exception -> L50
        r34.put("hitch_dur_dic", r29);     // Catch: Exception -> L50
        r34.put("hitch_dur", r11);     // Catch: Exception -> L50
        StringBuilder r35 = new StringBuilder();     // Catch: Exception -> L50
        this.d.getClass();     // Catch: Exception -> L50
        r35.append(0.0f);     // Catch: Exception -> L50
        r35.append(",");     // Catch: Exception -> L50
        this.d.getClass();     // Catch: Exception -> L50
        r35.append(0.0f);     // Catch: Exception -> L50
        r34.put("velocity", r35.toString());     // Catch: Exception -> L50
        StringBuilder r36 = new StringBuilder();     // Catch: Exception -> L50
        this.d.getClass();     // Catch: Exception -> L50
        r36.append(0.0f);     // Catch: Exception -> L50
        r36.append(",");     // Catch: Exception -> L50
        this.d.getClass();     // Catch: Exception -> L50
        r36.append(0.0f);     // Catch: Exception -> L50
        r34.put("distance", r36.toString());     // Catch: Exception -> L50
        r34.put("frame_count", this.a.size());     // Catch: Exception -> L50
        r34.put("drop_count", r10);     // Catch: Exception -> L50
        JSONObject r0 = this.d.j;     // Catch: Exception -> L50
        if (r0 == null) goto L40;
        r34.put("extra", r0);     // Catch: Exception -> L50
    L40:
        r34.put("drop_time_rate", 1.0f - ((this.a.size() * 1.0f) / ((int) (r12 / r2))));     // Catch: Exception -> L50
        js3.e r1 = new js3.e(FilterTypeStringDef.FPS_DROP, this.d.a, r26, r33, r34);     // Catch: Exception -> L50
        JSONObject r37 = ou3.a.a().c(true);     // Catch: Exception -> L50
        r1.f = r37;     // Catch: Exception -> L50
        r37.put("refresh_rate", r3);     // Catch: Exception -> L50
        Map r38 = this.b;     // Catch: Exception -> L50
        if (r38 != null) goto L43;
    L48:
        is3.a.h().b(r1);     // Catch: Exception -> L50
        return;
    L43:
        if (r38.isEmpty() == true) goto L48;
        Iterator r39 = this.b.entrySet().iterator();     // Catch: Exception -> L50
    L46:
        if (r39.hasNext() == false) goto L48;
        Map.Entry r40 = (Map.Entry) r39.next();     // Catch: Exception -> L50
        r1.f.put((String) r40.getKey(), r40.getValue());     // Catch: Exception -> L50
        goto L46
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

    public g(h r1, List r2, Map r3, es3.e.a r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
