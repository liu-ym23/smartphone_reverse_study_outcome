package r74;

import android.text.TextUtils;
import com.bytedance.bdinstall.dtrait.model.DTraitLogLevel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f536439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f536440b;

    public final void a() {
        g.b r100 = (g.b) ((ConcurrentHashMap) this.f536440b.f536448m).get("dtrait_pk1");
        if (r100 != null) goto L5;
    L27:
        this.f536440b.getClass();     // Catch: Exception -> L11
        m74.a.a("[dt] [factorLoader] bindDt# start wait bindDTrait.....");     // Catch: Exception -> L11
        this.f536440b.f536450o.await();     // Catch: Exception -> L11
        g.b r101 = (g.b) ((ConcurrentHashMap) this.f536440b.f536448m).get("dtrait_pk1");     // Catch: Exception -> L11
        m74.a.a("[dt] bindDt# thread has awake......");     // Catch: Exception -> L9
    L18:
        r100 = r101;
    L19:
        if (r100 != null) goto L21;
        return;
    L21:
        JSONObject r102 = new JSONObject();
        r102.putOpt("device_id", this.f536439a.optString("device_id"));     // Catch: Exception -> L24
        r102.putOpt("encrypted_dtrait", r100.f536455a);     // Catch: Exception -> L24
        x74.c.a(r102, this.f536440b.f540928e);     // Catch: Exception -> L24
        y74.a.c(DTraitLogLevel.DEBUG, "[device]", "bind_dtrait", "bindDt# success, request body: " + r102, null);     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        StringBuilder r103 = new StringBuilder("[dt] [factorLoader] bindDt# parse json error: ");
        this.f536440b.getClass();
        r103.append(e.getMessage());
        m74.a.b(r103.toString());
        return;
    L9:
        Exception e100 = e;
    L13:
        DTraitLogLevel r104 = DTraitLogLevel.ERROR;
        StringBuilder r105 = new StringBuilder("bindDt# error: encrypt drait has null? ");
        if (r101 != null) goto L16;
        boolean r106 = true;
    L17:
        r105.append(r106);
        y74.a.c(r104, "[device]", "bind_dtrait", r105.toString(), e100);
        goto L18
    L16:
        r106 = false;
    L11:
        e = move-exception;
        r101 = r100;
        e100 = e;
        goto L13
    L5:
        if (TextUtils.isEmpty(r100.f536455a) == false) goto L19;
        goto L19
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

    public f(g r100, JSONObject r101) {
        this.f536440b = r100;
        this.f536439a = r101;
    }
}
