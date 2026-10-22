package tw3;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.applog.g;
import com.bytedance.applog.log.n;
import com.bytedance.applog.params.extract.JsonUtils;
import com.bytedance.applog.params.extract.ParamsExtractDao;
import com.bytedance.applog.params.extract.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements tw3.b {
    public final g a;
    public boolean b;
    public final a c;

    public class a extends com.bytedance.applog.log.b<e> {
        public final /* synthetic */ c b;

        public a(c r1) {
            this.b = r1;
        }

        public final Object a(Object[] r2) {
            return new e(this.b.a.getContext());
        }
    }

    public class b extends fx3.c {
        public final /* synthetic */ c a;

        public final void a() {
            c r0 = this.a;
            if (r0.b == true) goto L34;
            String r1 = r0.a.getSessionId();
            if (TextUtils.isEmpty(r1) == true) goto L35;
            e r2 = (e) r0.c.b(new Object[0]);
            r2.getClass();
            Intrinsics.checkNotNullParameter(r1, "curSid");
            List<String> r5 = r2.a.c(r1);     // Catch: Exception -> L11
        L28:
            int r6 = r2.a.a(r1);     // Catch: Exception -> L15
        L26:
            Iterator<String> r7 = r5.iterator();     // Catch: Exception -> L22
        L19:
            if (r7.hasNext() == false) goto L24;
            String r8 = r7.next();     // Catch: Exception -> L22
            com.bytedance.applog.params.extract.b r9 = r2.b;     // Catch: Exception -> L22
            r9.getClass();     // Catch: Exception -> L22
            Intrinsics.checkNotNullParameter(r8, "cpId");     // Catch: Exception -> L22
            r9.a.remove(r8);     // Catch: Exception -> L22
        L24:
            n.w().h(e.c, "clearHistorySessionData currentSession=" + r1 + ", historyIdsSize: " + r5.size() + ", deleted=" + r6, new Object[0]);
            r0.b = true;
            return;
        L22:
            e = move-exception;
            n.w().c(e.c, "cache remove ids by session failed", new Object[]{e});
        L15:
            e = move-exception;
            n.w().c(e.c, "deleteBySession failed", new Object[]{e});
            r6 = 0;
        L11:
            e = move-exception;
            n.w().c(e.c, "listIdsBySession failed for session=" + r1, new Object[]{e});
            r5 = CollectionsKt.emptyList();
            goto L28
        L35:
            return;
        }

        public b(c r1) {
            this.a = r1;
        }

        public final String b(jx3.e r4, String r5) {
            if (r4.D == true) goto L5;
            return r5;
        L5:
            if (this.a.a.U0() == false) goto L14;
            JSONObject r1 = new JSONObject(r5);     // Catch: Throwable -> L8
            c.a(this.a, r1);     // Catch: Throwable -> L8
            r5 = r1.toString();     // Catch: Throwable -> L8
            n.w().j("ParamsExtract clearCommonParams(String) event:" + r4, new Object[0]);     // Catch: Throwable -> L8
            return r5;
        L8:
            th = move-exception;
            this.a.a.X().h("params_extract_clear_exception", th, true);
            return r5;
        L14:
            return r5;
        }

        public final JSONObject c(jx3.e r4, JSONObject r5) {
            if (r4.D == true) goto L5;
        L11:
            return r5;
        L5:
            if (this.a.a.U0() == false) goto L11;
            if (r5 == null) goto L11;
            c.a(this.a, r5);     // Catch: Throwable -> L9
            n.w().j("ParamsExtract clearCommonParams(JSONObject) event:" + r4, new Object[0]);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            this.a.a.X().h("params_extract_clear_exception", th, true);
            goto L11
        }

        public final JSONObject d(jx3.e r18, JSONObject r19) {
            if (this.a.a.U0() == true) goto L5;
        L69:
            return r19;
        L5:
            if (r19.has("__applog_cp_ids") == false) goto L69;
            e r6 = (e) this.a.c.b(new Object[0]);
            r6.getClass();
            Intrinsics.checkNotNullParameter(r19, "target");
            List r7 = JsonUtils.a(r19);
            if (r7.isEmpty() == true) goto L74;
            ArrayList r9 = new ArrayList(r7.size());
            ArrayList r0 = new ArrayList(r7.size());
            Iterator r10 = r7.iterator();
        L13:
            if (r10.hasNext() == false) goto L19;
            String r11 = (String) r10.next();
            com.bytedance.applog.params.extract.b r12 = r6.b;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r11, "cpId");
            ParamsExtractDao.a r13 = r12.a.get(r11);
            if (r13 != null) goto L16;
            r0.add(r11);
            goto L13
        L16:
            r9.add(r13.c);
            goto L13
        L19:
            if ((!r0.isEmpty()) == true) goto L70;
            Map<String, JSONObject> r1 = MapsKt.emptyMap();
        L25:
            Map<String, JSONObject> r14 = r1;
            if ((!r14.isEmpty()) == false) goto L31;
            Iterator<Map.Entry<String, JSONObject>> r2 = r14.entrySet().iterator();
        L29:
            if (r2.hasNext() == false) goto L31;
            Map.Entry<String, JSONObject> r15 = r2.next();
            r6.b.a(r15.getKey(), r15.getValue());
        L31:
            Iterator r8 = r9.iterator();
        L33:
            if (r8.hasNext() == false) goto L45;
            JSONObject r16 = (JSONObject) r8.next();
            Iterator r17 = JsonUtils.b(r16).iterator();
        L36:
            if (r17.hasNext() == false) goto L33;
            String r110 = (String) r17.next();
            if (Intrinsics.areEqual(r110, "__applog_cp_ids") == true) goto L36;
            if (r19.has(r110) == true) goto L36;
            r19.put(r110, r16.opt(r110));     // Catch: Exception -> L43
        L43:
            e = move-exception;
            n.w().c(e.c, "fillCommonParams put failed for key=" + r110, new Object[]{e});
            r8 = r8;
            goto L36
        L45:
            Iterator<Map.Entry<String, JSONObject>> r5 = r14.entrySet().iterator();
        L47:
            if (r5.hasNext() == false) goto L72;
            JSONObject r20 = r5.next().getValue();
            Iterator r21 = JsonUtils.b(r20).iterator();
        L50:
            if (r21.hasNext() == false) goto L47;
            String r111 = (String) r21.next();
            if (Intrinsics.areEqual(r111, "__applog_cp_ids") == true) goto L50;
            if (r19.has(r111) == true) goto L50;
            r19.put(r111, r20.opt(r111));     // Catch: Exception -> L57
        L57:
            e = move-exception;
            n.w().c(e.c, "fillCommonParams put failed for key=" + r111, new Object[]{e});
            r5 = r5;
            goto L50
        L72:
            r19.remove("__applog_cp_ids");     // Catch: Exception -> L61
        L63:
            if ((r9.size() + r14.size()) != r7.size()) goto L65;
        L64:
            boolean r112 = true;
        L66:
            n.w().j("ParamsExtract fillCommonParams event:" + r18 + " success: " + r112, new Object[0]);
            if (r112 == true) goto L69;
            this.a.a.X().h("params_extract_fill_failed", new Throwable(r18.B), true);
            goto L69
        L65:
            r112 = false;
            goto L66
        L70:
            r1 = r6.a.b(r0);     // Catch: Exception -> L22
        L22:
            e = move-exception;
            n.w().c(e.c, "fillCommonParams getByIds failed", new Object[]{e});
            r1 = MapsKt.emptyMap();
            goto L25
        L74:
            r19.remove("__applog_cp_ids");     // Catch: Exception -> L10
            goto L64
        }
    }

    public c(g r3, Looper r4) {
        new AtomicInteger(0);
        this.b = false;
        this.c = new a(this);
        new Handler(r4);
        this.a = r3;
        fx3.e r5 = r3.L1();
        b r6 = new b(this);
        ((CopyOnWriteArrayList) r5.a).add(r6);
    }

    public static void a(c r9, JSONObject r10) {
        if (r10 != null) goto L4;
        r9.getClass();
        return;
    L4:
        e r11 = (e) r9.c.b(new Object[0]);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r10, "target");
        List r1 = JsonUtils.a(r10);
        if (r1.isEmpty() == true) goto L85;
        ArrayList r2 = new ArrayList(r1.size());
        ArrayList r3 = new ArrayList(r1.size());
        JSONArray r4 = new JSONArray();
        if ((!r1.isEmpty()) == false) goto L17;
        Iterator r5 = r1.iterator();
    L11:
        if (r5.hasNext() == false) goto L17;
        String r6 = (String) r5.next();
        com.bytedance.applog.params.extract.b r7 = r11.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "cpId");
        ParamsExtractDao.a r8 = r7.a.get(r6);
        if (r8 != null) goto L14;
        r3.add(r6);
        goto L11
    L14:
        r2.add(r8.c);
        r4.put(r6);
    L17:
        if ((!r3.isEmpty()) == true) goto L64;
        Map<String, JSONObject> r0 = MapsKt.emptyMap();
    L24:
        if ((!r0.isEmpty()) == false) goto L29;
        Iterator<Map.Entry<String, JSONObject>> r12 = r0.entrySet().iterator();
    L27:
        if (r12.hasNext() == false) goto L29;
        Map.Entry<String, JSONObject> r13 = r12.next();
        String r14 = r13.getKey();
        r11.b.a(r14, r13.getValue());
        r4.put(r14);
    L29:
        Iterator r15 = r2.iterator();
    L31:
        if (r15.hasNext() == false) goto L40;
        Iterator r16 = JsonUtils.b((JSONObject) r15.next()).iterator();
    L34:
        if (r16.hasNext() == false) goto L31;
        String r17 = (String) r16.next();
        if (Intrinsics.areEqual(r17, "__applog_cp_ids") == true) goto L34;
        r10.remove(r17);     // Catch: Exception -> L39
        goto L34
    L40:
        Iterator<Map.Entry<String, JSONObject>> r18 = r0.entrySet().iterator();
    L42:
        if (r18.hasNext() == false) goto L62;
        Iterator r19 = JsonUtils.b(r18.next().getValue()).iterator();
    L45:
        if (r19.hasNext() == false) goto L42;
        String r20 = (String) r19.next();
        if (Intrinsics.areEqual(r20, "__applog_cp_ids") == true) goto L45;
        r10.remove(r20);     // Catch: Exception -> L50
        goto L45
    L62:
        if (r4.length() != 0) goto L54;
        r10.remove("__applog_cp_ids");     // Catch: Exception -> L56
    L61:
        return;
    L54:
        r10.put("__applog_cp_ids", r4);     // Catch: Exception -> L56
    L86:
        return;
    L64:
        r0 = r11.a.b(r3);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        n.w().c(e.c, "clearCommonParams getByIds failed", new Object[]{e});
        r0 = MapsKt.emptyMap();
        goto L24
    }
}
