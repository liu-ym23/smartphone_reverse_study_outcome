package vb4;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import com.bytedance.bdturing.livedetect.pty.TuringPTYManager;
import ec4.c;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g {
    public static volatile g a;

    public class a implements c {
        public final /* synthetic */ String a;
        public final /* synthetic */ jc4.m b;
        public final /* synthetic */ b c;
        public final /* synthetic */ qb4.f d;
        public final /* synthetic */ g e;

        /* JADX INFO: renamed from: vb4.g$a$a, reason: collision with other inner class name */
        public class C0178a implements qb4.f {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public final void onFail(int r3, JSONObject r4) {
                this.c.d.onFail(r3, r4);
                EventReport.t(false, this.a, "verify_fail", this.c.b);
            }

            public final void onSuccess(int r11, JSONObject r12) {
                if (r12 == null) goto L4;
                JSONObject r0 = r12.optJSONObject("notify_data");
            L5:
                if (r0 != null) goto L7;
            L11:
                EventReport.t(true, this.a, "", this.c.b);
                this.c.d.onSuccess(r11, r12);
                return;
            L7:
                if (TextUtils.isEmpty(r0.optString("subtype")) == true) goto L11;
                a r1 = this.c;
                g r2 = r1.e;
                jc4.m r6 = r1.b;
                String r5 = this.a;
                String r3 = this.b;
                qb4.f r4 = r1.d;
                r2.getClass();
                String r7 = e.c() + "live_dispatch_notify";
                HashMap r8 = new HashMap();
                r8.put("detail", r3);
                HashMap r9 = new HashMap();
                r9.put("Content-Type", "application/json; charset=utf-8");
                new ec4.j(r7, r8, hc4.d.a(r0), r9).c(new i(r4, r5, r6, r11, r12));
                return;
            L4:
                r0 = null;
                goto L5
            }

            public C0178a(a r1, String r2, String r3) {
                this.c = r1;
                this.a = r2;
                this.b = r3;
            }
        }

        @Override // ec4.c
        public final void a(xb4.a r10) {
            JSONObject r0 = r10.b;
            if (r0 == null) goto L5;
            String r1 = r0.optString("decision");
        L7:
            if (TextUtils.isEmpty(r1) == false) goto L22;
            String r11 = "live verify dispatch fail:decision_is_null," + r10;
            hc4.d.b(new JSONObject(), "errorMessage", r11);
            EventReport.s(false, this.a, "", r11, this.b);
            qb4.b.b r12 = this.c;
            if (r12 == null) goto L24;
            r12.a();
            return;
        L24:
            return;
        L22:
            String r13 = new JSONObject(r1).optString("detail");     // Catch: Exception -> L14
        L16:
            qb4.b r2 = qb4.b.c.a;
            BdTuringConfig r4 = r2.a;
            if (r4 == null) goto L19;
            Activity r5 = r4.getTopActivity();
        L20:
            jc4.m r6 = new jc4.m(r1);
            EventReport.s(true, this.a, r6.g(), "", this.b);
            r2.j(r5, r6, new C0178a(this, r6.g(), r13), false);
            return;
        L19:
            r5 = null;
        L14:
            e = move-exception;
            e.printStackTrace();
            r13 = "";
            goto L16
        L5:
            r1 = "";
            goto L7
        }

        @Override // ec4.c
        public final void onError(Throwable r5) {
            String r6 = "live verify dispatch fail net_work_error:" + r5;
            hc4.d.b(new JSONObject(), "errorMessage", r6);
            EventReport.s(false, this.a, "", r6, this.b);
            qb4.b.b r7 = this.c;
            if (r7 == null) goto L6;
            r7.a();
            return;
        }

        public a(g r1, String r2, jc4.m r3, b r4, qb4.f r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public interface b {
    }

    public g() {
    }

    public final void a(jc4.a r3, qb4.f r4, qb4.b.b r5) {
        if (LiveDetectService.getInstance().byteNNDispatchEnable() == true) goto L6;
        r5.a();
        return;
    L6:
        Pair r0 = LiveDetectService.getInstance().liveDetectState();
        if (((Boolean) r0.first).booleanValue() == false) goto L10;
        r5.a();
        return;
    L10:
        jc4.m r6 = (jc4.m) r3;
        c(r6, r4, r5, (String) r0.second);
    }

    public final void b(jc4.a r10, qb4.f r11, qb4.b.b r12) {
        boolean r0 = TuringPTYManager.b().f();
        if (r0 == true) goto L5;
        StringBuilder r1 = new StringBuilder();
        r1.append("PTY init not finish:pkg_load=" + TuringPTYManager.b().g.get() + ":mInitSate=" + TuringPTYManager.b().a + ":PTY Env_Available=" + TuringPTYManager.b().e() + ":appFirstLaunch=" + e.d() + ":ptyHostEnable=" + e.b);
        String r2 = r1.toString();
    L6:
        Pair r3 = new Pair(Boolean.valueOf(!r0), r2);
        String r8 = (String) r3.second;
        boolean r4 = ((Boolean) r3.first).booleanValue();
        String r5 = (String) r3.second;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L9
        r6.put("key", "live_available_check");     // Catch: Exception -> L9
        r6.put("custom", r5);     // Catch: Exception -> L9
        r6.put("result", !r4 ? 1 : 0);     // Catch: Exception -> L9
        EventReport.w("turing_verify_sdk", r6, r10);     // Catch: Exception -> L9
    L12:
        if (((Boolean) r3.first).booleanValue() == true) goto L16;
        r12.a();
        return;
    L16:
        if (TuringPTYManager.b().e() == true) goto L18;
    L20:
        c((jc4.m) r10, r11, r12, r8);
        return;
    L18:
        if (TuringPTYManager.b().g.get() == true) goto L20;
        TuringPTYManager.b().g("live_fall_back_strategy", new f(this, r10, r11, r12, r8));
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        r2 = "";
        goto L6
    }

    public final void c(jc4.m r12, qb4.f r13, b r14, String r15) {
        BdTuringConfig r0 = qb4.b.c.a.a;     // Catch: Exception -> L8
        if (r0 == null) goto L5;
        Context r1 = r0.getApplicationContext();     // Catch: Exception -> L8
    L6:
        TuringPTYManager.b().d(r1, new h(), "live_fall_back_strategy");     // Catch: Exception -> L8
        String r2 = r12.o.n;     // Catch: Exception -> L8
        String r3 = e.c() + "live_dispatch";     // Catch: Exception -> L8
        HashMap r4 = new HashMap();     // Catch: Exception -> L8
        r4.put("detail", r2);     // Catch: Exception -> L8
        HashMap r5 = new HashMap();     // Catch: Exception -> L8
        r5.put("Content-Type", "application/json; charset=utf-8");     // Catch: Exception -> L8
        new ec4.j(r3, r4, null, r5).c(new a(this, r15, r12, r14, r13));     // Catch: Exception -> L8
        return;
    L5:
        r1 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        String r16 = "live verify dispatch fail exception:" + e;
        JSONObject r6 = new JSONObject();
        hc4.d.b(r6, "errorMessage", r16);
        EventReport.s(false, r15, "", r16, r12);
        r13.onFail(1, r6);
    }
}
