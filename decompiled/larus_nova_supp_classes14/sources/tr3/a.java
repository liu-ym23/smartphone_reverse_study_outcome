package tr3;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ f b;

    public a(int[] r1, f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(boolean r4, int r5, Exception r6, JSONObject r7) {
        JSONObject r8 = c.a(r4, r5, r6, r7);
        c.b(r8.toString());
        int[] r0 = this.a;
        int r2 = r0[0] + 1;
        r0[0] = r2;
        if (r4 == false) goto L5;
    L7:
        f r1 = this.b;
        if (r1 == null) goto L11;
        r1.a(r4, r8);
    L11:
        if (r4 == true) goto L13;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", r5, r8);
    L13:
        if (r6 == null) goto L16;
        k.b.a.c(r6, "apm_event_stats_alog_fail");
        return;
    L16:
        return;
    L5:
        if (r2 >= 2) goto L7;
    }
}
