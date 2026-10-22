package um7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;
import rm7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f550693a;

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r100 = b.a(this.f550693a);     // Catch: Throwable -> L4
        boolean r101 = r100.optBoolean("enable_apply_token", false);     // Catch: Throwable -> L4
        j.a.f538610a.a(r101, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(JSONObject r100) {
        this.f550693a = r100;
    }
}
