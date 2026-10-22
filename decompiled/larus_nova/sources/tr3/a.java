package tr3;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f547290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f547291b;

    public a(int[] r100, f r101) {
        this.f547290a = r100;
        this.f547291b = r101;
    }

    public final void a(boolean r100, int r101, Exception r102, JSONObject r103) {
        JSONObject r104 = c.a(r100, r101, r102, r103);
        c.b(r104.toString());
        int[] r105 = this.f547290a;
        int r106 = r105[0] + 1;
        r105[0] = r106;
        if (r100 == false) goto L5;
    L7:
        f r107 = this.f547291b;
        if (r107 == null) goto L11;
        r107.a(r100, r104);
    L11:
        if (r100 == true) goto L13;
        ApmAgent.monitorStatusRate("apm_event_stats_alog_fail", r101, r104);
    L13:
        if (r102 == null) goto L16;
        k.b.f190610a.c(r102, "apm_event_stats_alog_fail");
        return;
    L16:
        return;
    L5:
        if (r106 >= 2) goto L7;
    }
}
