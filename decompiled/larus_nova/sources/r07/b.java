package r07;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Callable<n07.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f535484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f535485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f535486c;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public n07.d call2() throws Exception {
        String r100 = this.f535484a;
        if (n07.b.f516586c != null) goto L5;
        n07.b.f516586c = new n07.c();
    L5:
        o07.c r101 = new o07.c(n07.b.f516586c.f516588a);
        r101.f521636c = "POST";
        HashMap r102 = new HashMap();
        r101.f521634a = r102;
        r102.put("Content-Type", "application/json");
        String r103 = this.f535485b;
        JSONObject r104 = new JSONObject();
        r104.put("ts", System.currentTimeMillis());     // Catch: Exception -> L11
        r104.put("url", r100);     // Catch: Exception -> L11
        r104.put("sign", "");     // Catch: Exception -> L11
        if (TextUtils.isEmpty(r103) == false) goto L9;
        r103 = "common";
    L9:
        r104.put("scene", r103);     // Catch: Exception -> L11
    L12:
        r101.f521637d = r104.toString();
        r101.f521638e = 5000;
        long r105 = SystemClock.uptimeMillis();
        boolean r106 = true;
        o07.d r107 = n07.b.a().a(r101, true);
        n07.d r108 = null;
        if (r107 != null) goto L15;
    L28:
        f r109 = this.f535486c;
        r109.getClass();
        c r110 = r109.f535502f.get(q07.b.b(r100));
        if (r110 == null) goto L33;
        if (r108 != null) goto L32;
        r110.a(r107.f521639a, -1, "error", null, null);
        goto L33
    L32:
        r110.a(r107.f521639a, r108.f516589a, r108.f516591c, r108.f516593e, r108.f516598j);
    L33:
        long r111 = SystemClock.uptimeMillis() - r105;
        String r112 = "";
        if (r108 != null) goto L36;
    L55:
        Objects.toString(r107);
    L56:
        String r113 = q07.b.a(r107, "X-Tt-Trace-Id", OkHttpEventListener.X_TT_TRACE_ID);
        HashMap r114 = new HashMap();
        r114.put("scc_passed_time", r111 + "");
        if (r112 != null) goto L59;
        r112 = "";
    L59:
        r114.put("scc_logid", r112);
        if (r113 != null) goto L62;
        r113 = "";
    L62:
        r114.put("scc_trace_id", r113);
        n07.b.b("scc_cloudservice_result", r114);
        return r108;
    L36:
        if (r108.f516589a == (-1)) goto L55;
        r112 = r108.f516593e;
        if ("allow".equals(r108.f516591c) == false) goto L41;
    L44:
        if (r106 == false) goto L56;
        a r115 = a.C7413a.f535483a;
        r115.getClass();
        if (TextUtils.isEmpty(r100) == true) goto L56;
        monitor-enter(r115);
        r115.f535482a.put(r100, Boolean.TRUE);     // Catch: Throwable -> L52
        monitor-exit(r115);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L41:
        if ("white".equals(r108.f516591c) == true) goto L44;
        r106 = false;
        goto L44
    L15:
        if (r107.f521640b == null) goto L28;
        n07.d r116 = new n07.d(new JSONObject(new String(r107.f521640b)));     // Catch: Exception -> L24
        r116.f516592d = "scc_res";     // Catch: Exception -> L22
        String r117 = q07.b.a(r107, Constants.Keys.KEY_X_TT_LOGID, NetResponse.HEADER_KEY_LOG_ID);     // Catch: Exception -> L22
        if (r117 != null) goto L20;
        r117 = "";
    L20:
        r116.f516593e = r117;     // Catch: Exception -> L22
    L27:
        r108 = r116;
    L22:
        Exception e100 = e;
    L26:
        e100.toString();
    L24:
        e = move-exception;
        r116 = null;
        e100 = e;
        goto L26
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ n07.d call() throws Exception {
        return call2();
    }

    public b(String r100, String r101, f r102) {
        this.f535484a = r100;
        this.f535485b = r101;
        this.f535486c = r102;
    }
}
