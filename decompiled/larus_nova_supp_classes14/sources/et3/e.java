package et3;

import com.bytedance.apm.constant.FilterTypeStringDef;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.k;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ c b;

    public final void a() {
    L24:
        e = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L35;
        e.printStackTrace();
        return;
    L35:
        return;
    L4:
        if (k.b(this.a) == false) goto L6;
        return;
    L6:
        float r1 = i.a;     // Catch: Exception -> L24
        int r2 = i.b;     // Catch: Exception -> L24
        int r3 = r2 - 1;     // Catch: Exception -> L24
        int[] r4 = new int[(r3 + 0) + 1];     // Catch: Exception -> L24
        Iterator r6 = this.a.iterator();     // Catch: Exception -> L24
        int r7 = 0;
        int r8 = 0;
    L8:
        if (r6.hasNext() == false) goto L10;
        Integer r9 = (Integer) r6.next();     // Catch: Exception -> L24
        int r11 = (int) (100.0f * r1);     // Catch: Exception -> L24
        int r10 = Math.max(Math.min(((r9.intValue() + (r11 - 1)) / r11) - 1, r3), 0);     // Catch: Exception -> L24
        r4[r10] = r4[r10] + 1;     // Catch: Exception -> L24
        r8 = r8 + (r9.intValue() / 100);     // Catch: Exception -> L24
        goto L8
    L10:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L24
    L11:
        if (r7 > r3) goto L16;
        if (r4[r7] <= 0) goto L15;
        r12.put(String.valueOf(r7), r4[r7]);     // Catch: Exception -> L24
    L15:
        r7 = r7 + 1;     // Catch: Exception -> L24
        goto L11
    L16:
        c$c r5 = this.b.d;     // Catch: Exception -> L24
        if (r5 == null) goto L19;
        r5.dropFrame(j.a(r12));     // Catch: Exception -> L24
    L19:
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L24
        r13.put("scene", this.b.a);     // Catch: Exception -> L24
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L24
        r14.put("total_scroll_time", r8);     // Catch: Exception -> L24
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L24
        this.b.getClass();     // Catch: Exception -> L24
        r15.append(0.0f);     // Catch: Exception -> L24
        r15.append(",");     // Catch: Exception -> L24
        this.b.getClass();     // Catch: Exception -> L24
        r15.append(0.0f);     // Catch: Exception -> L24
        r14.put("velocity", r15.toString());     // Catch: Exception -> L24
        StringBuilder r16 = new StringBuilder();     // Catch: Exception -> L24
        this.b.getClass();     // Catch: Exception -> L24
        r16.append(0.0f);     // Catch: Exception -> L24
        r16.append(",");     // Catch: Exception -> L24
        this.b.getClass();     // Catch: Exception -> L24
        r16.append(0.0f);     // Catch: Exception -> L24
        r14.put("distance", r16.toString());     // Catch: Exception -> L24
        JSONObject r0 = this.b.j;     // Catch: Exception -> L24
        if (r0 == null) goto L22;
        r14.put("extra", r0);     // Catch: Exception -> L24
    L22:
        r14.put("drop_time_rate", 1.0f - ((this.a.size() * 1.0f) / ((int) (r8 / r1))));     // Catch: Exception -> L24
        js3.e r17 = new js3.e(FilterTypeStringDef.FPS_DROP, this.b.a, r12, r13, r14);     // Catch: Exception -> L24
        JSONObject r18 = ou3.a.a().c(true);     // Catch: Exception -> L24
        r17.f = r18;     // Catch: Exception -> L24
        r18.put("refresh_rate", r2);     // Catch: Exception -> L24
        is3.a.h().b(r17);     // Catch: Exception -> L24
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

    public e(c r1, List r2) {
        this.b = r1;
        this.a = r2;
    }
}
