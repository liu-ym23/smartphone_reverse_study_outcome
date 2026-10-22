package ac4;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;
import qb4.c0;
import qb4.n;
import qb4.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class f implements ac4.a {

    public class a implements qb4.f {
        public final /* synthetic */ ac4.c a;

        public a(ac4.c r1) {
            this.a = r1;
        }

        public final void onFail(int r2, JSONObject r3) {
            JSONObject r4 = new JSONObject();     // Catch: JSONException -> L4
            r4.put("result", r2);     // Catch: JSONException -> L4
            this.a.d(1, r4);     // Catch: JSONException -> L4
            return;
        }

        public final void onSuccess(int r1, JSONObject r2) {
            onFail(r1, r2);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ac4.c d;
        public final /* synthetic */ f e;

        public final void a() {
            BdTuringConfig r0 = qb4.b.c.a.a;
            if (r0 == null) goto L5;
            ec4.b r1 = r0.getHttpClient();
        L6:
            if (r1 == null) goto L8;
            String r2 = new String(r1.post(this.a, this.b, this.c.getBytes()), Charsets.UTF_8);
        L9:
            f.b(this.e, this.d, r2);
            return;
        L8:
            r2 = "";
            goto L9
        L5:
            r1 = null;
            goto L6
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

        public b(f r1, String r2, Map r3, String r4, ac4.c r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ ac4.c c;
        public final /* synthetic */ f d;

        @Override // java.lang.Runnable
        public final void run() {
            BdTuringConfig r0 = qb4.b.c.a.a;     // Catch: Throwable -> L11
            if (r0 == null) goto L5;
            ec4.b r1 = r0.getHttpClient();     // Catch: Throwable -> L11
        L6:
            if (r1 == null) goto L8;
            String r2 = new String(r1.get(this.a, this.b), Charsets.UTF_8);     // Catch: Throwable -> L11
        L9:
            f.b(this.d, this.c, r2);     // Catch: Throwable -> L11
            return;
        L8:
            r2 = "";
            goto L9
        L5:
            r1 = null;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }

        public c(f r1, String r2, Map r3, ac4.c r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public f() {
    }

    public void c() {
    }

    public void d() {
    }

    public void e(ac4.c r1) {
    }

    public void f(ac4.c r1) {
    }

    public void g(ac4.c r1) {
    }

    public void i() {
    }

    public void j(int r1, int r2, boolean r3) {
    }

    public void k(int r1, int r2, boolean r3) {
    }

    public void l(String r1, a r2) {
    }

    public void m(int r1, String r2, String r3, String r4, JSONObject r5) {
    }

    public void n(String r1) {
    }

    public void o(String r1, String r2) {
    }

    public void p() {
    }

    public void q(int r1, String r2) {
    }

    @Override // ac4.a
    public final void a(ac4.c r17) {
        String r1 = r17.a;     // Catch: Exception -> L110
        switch(r1.hashCode()) {
            case -1759249244: goto L67;
            case -1628743486: goto L64;
            case -1563440329: goto L61;
            case -1534238297: goto L58;
            case -1471628194: goto L55;
            case -1366167938: goto L52;
            case -1260067134: goto L49;
            case -1028963129: goto L46;
            case -985680828: goto L43;
            case -514719849: goto L40;
            case -440027648: goto L37;
            case 364408852: goto L34;
            case 385404715: goto L31;
            case 428780843: goto L28;
            case 491779646: goto L25;
            case 755725445: goto L22;
            case 1154510586: goto L19;
            case 1176627553: goto L16;
            case 1225487854: goto L13;
            case 1762692255: goto L10;
            case 1861543318: goto L7;
            default: goto L69;
        };     // Catch: Exception -> L110
    L69:
        byte r2 = -1;
    L71:
        switch(r2) {
            case 0: goto L108;
            case 1: goto L107;
            case 2: goto L106;
            case 3: goto L105;
            case 4: goto L104;
            case 5: goto L96;
            case 6: goto L95;
            case 7: goto L94;
            case 8: goto L93;
            case 9: goto L92;
            case 10: goto L91;
            case 11: goto L86;
            case 12: goto L81;
            case 13: goto L80;
            case 14: goto L79;
            case 15: goto L78;
            case 16: goto L77;
            case 17: goto L76;
            case 18: goto L74;
            case 19: goto L75;
            case 20: goto L73;
            default: goto L141;
        };
    L73:
        JSONObject r3 = new JSONObject(r17.b);     // Catch: Exception -> L110
        j(JSONObjectProtectorUtils.getInt(r3, "w"), JSONObjectProtectorUtils.getInt(r3, "h"), r3.optBoolean("fullScreen", false));     // Catch: Exception -> L110
        return;
    L74:
        d();     // Catch: Exception -> L110
    L75:
        n(r17.b);     // Catch: Exception -> L110
        return;
    L76:
        JSONObject r4 = new JSONObject(r17.b);     // Catch: Exception -> L110
        o(r4.optString("title", ""), r4.optString("url", ""));     // Catch: Exception -> L110
        return;
    L77:
        JSONObject r5 = new JSONObject(r17.b);     // Catch: Exception -> L110
        q(r5.optInt("result", -1), r5.optString("url", ""));     // Catch: Exception -> L110
        return;
    L78:
        f(r17);     // Catch: Exception -> L110
        return;
    L79:
        i();     // Catch: Exception -> L110
        return;
    L80:
        e(r17);     // Catch: Exception -> L110
        return;
    L81:
        long r0 = System.currentTimeMillis();     // Catch: Exception -> L110
        int r6 = q.a.a;     // Catch: Exception -> L110
        long r7 = r0 - 0;     // Catch: Exception -> L110
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L110
        r8.put("duration", r7);     // Catch: JSONException -> L84 Exception -> L110
        r8.put("key", "pre_create_load_success");     // Catch: JSONException -> L84 Exception -> L110
        EventReport.w("turing_verify_sdk", r8, null);     // Catch: Exception -> L110
        return;
    L84:
        e = move-exception;
        int r9 = n.a;     // Catch: Exception -> L110
        Intrinsics.checkNotNullParameter(e, "e");     // Catch: Exception -> L110
        e.printStackTrace();     // Catch: Exception -> L110
        return;
    L86:
        int r10 = q.a.a;     // Catch: Exception -> L110
        long r11 = System.currentTimeMillis() - 0;     // Catch: Exception -> L110
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L110
        r12.put("duration", r11);     // Catch: JSONException -> L89 Exception -> L110
        r12.put("key", "pre_create_success");     // Catch: JSONException -> L89 Exception -> L110
        EventReport.w("turing_verify_sdk", r12, null);     // Catch: Exception -> L110
        return;
    L89:
        e = move-exception;
        int r13 = n.a;     // Catch: Exception -> L110
        Intrinsics.checkNotNullParameter(e, "e");     // Catch: Exception -> L110
        e.printStackTrace();     // Catch: Exception -> L110
        return;
    L91:
        p();     // Catch: Exception -> L110
        return;
    L92:
        l(JSONObjectProtectorUtils.getString(new JSONObject(r17.b), "params"), new a(r17));     // Catch: Exception -> L110
        return;
    L93:
        g(r17);     // Catch: Exception -> L110
        return;
    L94:
        h(r17);     // Catch: Exception -> L110
        return;
    L95:
        JSONObject r14 = new JSONObject(r17.b);     // Catch: Exception -> L110
        EventReport.w(r14.optString("event"), r14, null);     // Catch: Exception -> L110
        return;
    L96:
        JSONObject r15 = new JSONObject(r17.b);     // Catch: Exception -> L110
        HashMap r16 = new HashMap();     // Catch: Exception -> L110
        Iterator<String> r18 = r15.keys();     // Catch: Exception -> L110
    L98:
        if (r18.hasNext() == false) goto L143;
        String r19 = r18.next();     // Catch: Exception -> L110
        Object r20 = r15.opt(r19);     // Catch: Exception -> L110
        if (r20 == null) goto L102;
        String r21 = r20.toString();     // Catch: Exception -> L110
    L103:
        r16.put(r19, r21);     // Catch: Exception -> L110
        goto L98
    L102:
        r21 = null;
        goto L103
    L143:
        return;
    L104:
        JSONObject r22 = new JSONObject(r17.b);     // Catch: Exception -> L110
        int r23 = r22.optInt("result");     // Catch: Exception -> L110
        r22.optString("mode");     // Catch: Exception -> L110
        r22.optString("type");     // Catch: Exception -> L110
        m(r23, r22.optString("token"), r22.optString("mobile"), r22.optString("decision"), r22.optJSONObject("query"));     // Catch: Exception -> L110
        return;
    L105:
        c();     // Catch: Exception -> L110
        return;
    L106:
        c0.a.a.c(2, r17);     // Catch: Exception -> L110
        return;
    L107:
        JSONObject r24 = new JSONObject(r17.b);     // Catch: Exception -> L110
        k(JSONObjectProtectorUtils.getInt(r24, "w"), JSONObjectProtectorUtils.getInt(r24, "h"), r24.optBoolean("fullScreen", false));     // Catch: Exception -> L110
        return;
    L108:
        JSONObject r25 = new JSONObject(r17.b);     // Catch: Exception -> L110
        j(JSONObjectProtectorUtils.getInt(r25, "w"), JSONObjectProtectorUtils.getInt(r25, "h"), r25.optBoolean("fullScreen", false));     // Catch: Exception -> L110
        return;
    L141:
        return;
    L7:
        if (r1.equals("bytedcert.web_result") == false) goto L69;
        r2 = 19;
        goto L71
    L10:
        if (r1.equals("bytedcert.close_web") == false) goto L69;
        r2 = 18;
        goto L71
    L13:
        if (r1.equals("bytedcert.open_new_web") == false) goto L69;
        r2 = 17;
        goto L71
    L16:
        if (r1.equals("bytedcert.network.request") == false) goto L69;
        r2 = 7;
        goto L71
    L19:
        if (r1.equals("bytedcert.readyView") == false) goto L69;
        r2 = 10;
        goto L71
    L22:
        if (r1.equals("bytedcert.h5_available") == false) goto L69;
        r2 = 14;
        goto L71
    L25:
        if (r1.equals("bytedcert.eventToNative") == false) goto L69;
        r2 = 6;
        goto L71
    L28:
        if (r1.equals("bytedcert.getSettings") == false) goto L69;
        r2 = 8;
        goto L71
    L31:
        if (r1.equals("bytedcert.confirm_dialog_size") == false) goto L69;
        r2 = 20;
        goto L71
    L34:
        if (r1.equals("bytedcert.verify_confirm_result") == false) goto L69;
        r2 = 16;
        goto L71
    L37:
        if (r1.equals("bytedcert.getSdkInfo") == false) goto L69;
        r2 = 13;
        goto L71
    L40:
        if (r1.equals("bytedcert.dialogSize") == false) goto L69;
        r2 = 0;
        goto L71
    L43:
        if (r1.equals("bytedcert.dialogSize_V2") == false) goto L69;
        r2 = 1;
        goto L71
    L46:
        if (r1.equals("bytedcert.preLoadVerifyFinish") == false) goto L69;
        r2 = 11;
        goto L71
    L49:
        if (r1.equals("bytedcert.getSensor") == false) goto L69;
        r2 = 15;
        goto L71
    L52:
        if (r1.equals("bytedcert.refreshVerifyViewFinish") == false) goto L69;
        r2 = 12;
        goto L71
    L55:
        if (r1.equals("bytedcert.pageEnd") == false) goto L69;
        r2 = 3;
        goto L71
    L58:
        if (r1.equals("bytedcert.verify") == false) goto L69;
        r2 = 9;
        goto L71
    L61:
        if (r1.equals("bytedcert.getTouch") == false) goto L69;
        r2 = 2;
        goto L71
    L64:
        if (r1.equals("bytedcert.h5_state_changed") == false) goto L69;
        r2 = 5;
        goto L71
    L67:
        if (r1.equals("bytedcert.verifyResult") == false) goto L69;
        r2 = 4;
    L110:
        e = move-exception;
        e.printStackTrace();
    }

    public final void h(ac4.c r10) {
        JSONObject r0 = new JSONObject(r10.b);     // Catch: JSONException -> L23
        String r1 = JSONObjectProtectorUtils.getString(r0, "url");     // Catch: JSONException -> L23
        String r2 = JSONObjectProtectorUtils.getString(r0, "method");     // Catch: JSONException -> L23
        JSONObject r3 = r0.optJSONObject("query");     // Catch: JSONException -> L23
        Object r4 = r0.opt("data");     // Catch: JSONException -> L23
        if (r3 == null) goto L13;
        StringBuilder r5 = new StringBuilder(r1);     // Catch: JSONException -> L23
        r5.append("?");     // Catch: JSONException -> L23
        Iterator<String> r6 = r3.keys();     // Catch: JSONException -> L23
    L6:
        if (r6.hasNext() == false) goto L12;
        String r7 = r6.next();     // Catch: JSONException -> L23
        if (r3.get(r7) == null) goto L10;
        String r8 = r3.get(r7).toString();     // Catch: JSONException -> L23
    L11:
        r5.append("&" + r7 + "=");     // Catch: JSONException -> L23
        r5.append(r8);     // Catch: JSONException -> L23
        goto L6
    L10:
        r8 = null;
        goto L11
    L12:
        r1 = r5.toString();     // Catch: JSONException -> L23
    L13:
        String r9 = r1;
        if (r4 != null) goto L17;
        String r11 = "";
    L16:
        String r12 = r11;
        int r13 = n.a;     // Catch: JSONException -> L23
        HashMap r14 = new HashMap();     // Catch: JSONException -> L23
        r14.put("Content-Type", "application/json; charset=utf-8");     // Catch: JSONException -> L23
        if (r2.equals("post") == false) goto L21;
        c0.a.a.a(new b(this, r9, r14, r12, r10));     // Catch: JSONException -> L23
        return;
    L21:
        c0.a.a.a(new c(this, r9, r14, r10));     // Catch: JSONException -> L23
        return;
    L17:
        r11 = r4.toString().replaceAll("\\\\/", "/");     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    }

    public static void b(f r2, ac4.c r3, String r4) {
        r2.getClass();
        int r5 = n.a;
        int r6 = !TextUtils.isEmpty(r4) ? 1 : 0;
        JSONObject r0 = new JSONObject();
        r0.put("content", r4);     // Catch: JSONException -> L5
        r0 = new JSONObject(r4);     // Catch: JSONException -> L5
    L7:
        r3.d(r6, r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        r6 = 0;
        goto L7
    }
}
