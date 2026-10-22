package q25;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineDocsPriority;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.monitor.callback.CpuCallbackManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements f {
    public final s25.a a;
    public final s25.e b;
    public final r25.e c;
    public i d;
    public final JSONObject e;
    public f f;
    public final Map<String, Integer> g;

    public final void d() {
        r25.e r0 = this.c;
        r0.getClass();
        ThreadMethodProxy.start(new PthreadThreadV2(new r25.e.b(r0), "Docs_Preload"));
        this.c.h = this;
        i r1 = this.d;
        if (r1 == null) goto L5;
        ThreadMethodProxy.start(new PthreadThreadV2(new i.b(r1), "Html_Cache_Preload"));
        this.d.j = this;
    L5:
        s25.a r2 = this.a;
        r2.getClass();
        tt5.a.h("DBPreloadManager", "register cpu callback，preload_cpu_limit：" + r2.a.getDocx_ssr_preload_cpu_limit());
        CpuCallbackManager r3 = CpuCallbackManager.a();
        s25.b r4 = new s25.b(r2);
        if (((CopyOnWriteArrayList) r3.a).contains(r4) == true) goto L8;
        ((CopyOnWriteArrayList) r3.a).add(r4);
    L8:
        s25.e r5 = this.b;
        r5.getClass();
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_DOC_FEEDS, new s25.f(r5));
    }

    public a(r25.e r4) {
        this.a = new s25.a();
        this.b = new s25.e();
        this.e = new JSONObject();
        this.g = new ConcurrentHashMap();
        this.c = r4;
        this.d = new i();
        String r5 = (String) com.bytedance.ee.bear.appsetting.c.a.a.d("docs_preload_priority", "{}");
        tt5.a.h("ClientVarHtmlCache", "priorityConfig: " + r5);
        this.e = new JSONObject(r5);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("ClientVarHtmlCache", "parse priority config failed", e, false);
    }

    @Override // q25.f
    public final void a(OfflineDoc r3) {
        if (this.f != null) goto L5;
        return;
    L5:
        if (r3.getReqId() == null) goto L11;
        Map<String, Integer> r0 = this.g;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(r3.getReqId()) == false) goto L12;
        this.f.a(r3);
        Map<String, Integer> r2 = this.g;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r2;
        r4.remove(r3.getReqId());
        return;
    L12:
        return;
    }

    @Override // q25.f
    public final void c(OfflineDoc r5) {
        if (this.f != null) goto L5;
        return;
    L5:
        if (r5.getReqId() == null) goto L13;
        Map<String, Integer> r0 = this.g;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(r5.getReqId()) == false) goto L14;
        Map<String, Integer> r2 = this.g;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        int r4 = ((Integer) r3.get(r5.getReqId())).intValue();
        Map<String, Integer> r6 = this.g;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        r7.put(r5.getReqId(), Integer.valueOf(Math.abs(r4)));
        if (r4 >= 0) goto L15;
        this.f.c(r5);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void e(List<OfflineDoc> r7) {
        Iterator<OfflineDoc> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L28;
        OfflineDoc r0 = r8.next();
        if (r0 == null) goto L37;
        if (TextUtils.isEmpty(r0.getUrl()) == false) goto L29;
    L15:
        r0.setPreloadManagerEnqueueTime(System.currentTimeMillis());
        if (t25.d.a() == false) goto L4;
        if (DocsOpenSource.db_preload.name().equals(r0.getFrom_source()) == false) goto L20;
        OfflineDocsPriority r1 = OfflineDocsPriority.Low_Priority;
    L27:
        r0.setPreload_priority(r1.ordinal());
        goto L4
    L20:
        String r2 = sbb.e.f(r0.getType());
        JSONObject r3 = this.e.optJSONObject(r2);
        if (r3 == null) goto L26;
        String r4 = r3.optString(r0.getFrom_source());
        if (TextUtils.isEmpty(r4) == true) goto L25;
        tt5.a.h("ClientVarHtmlCache", "current type is " + r2 + ", from " + r0.getFrom_source() + ", use priority " + r4);
    L25:
        r1 = OfflineDocsPriority.parsePriority(r4);
        goto L27
    L26:
        r1 = OfflineDocsPriority.Middle_Priority;
        goto L27
    L29:
        r0.setEdition_id(UriProtector.getQueryParameter(UriProtector.parse(r0.getUrl()), "edition_id"));     // Catch: Exception -> L13
    L13:
        e = move-exception;
        tt5.a.e("ClientVarHtmlCache", "setEditionId ", e, false);
        goto L15
    L37:
        return;
    }

    @Override // q25.f
    public final void b(OfflineDoc r3, int r4) {
        if (this.f != null) goto L5;
        return;
    L5:
        if (r3.getReqId() == null) goto L14;
        Map<String, Integer> r0 = this.g;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(r3.getReqId()) == false) goto L15;
        Map<String, Integer> r2 = this.g;
        ConcurrentHashMap r5 = (ConcurrentHashMap) r2;
        int r6 = ((Integer) r5.get(r3.getReqId())).intValue();
        if (r6 > 1) goto L11;
        this.f.b(r3, r4);
        ((ConcurrentHashMap) this.g).remove(r3);
        return;
    L11:
        Map<String, Integer> r7 = this.g;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        r8.put(r3.getReqId(), Integer.valueOf(r6 - 1));
        return;
    L15:
        return;
    }
}
