package hj4;

import com.bytedance.dataplatform.w;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f485425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Integer f485426b;

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("params_for_special", "abtest_ab_sdk");     // Catch: JSONException -> L5
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
        r101.put(this.f485425a, this.f485426b);     // Catch: JSONException -> L5
        r100.put("client_layer_info", r101);     // Catch: JSONException -> L5
    L7:
        w.a(new a(r100));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
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

    public c(String r100, Integer r101) {
        this.f485425a = r100;
        this.f485426b = r101;
    }
}
