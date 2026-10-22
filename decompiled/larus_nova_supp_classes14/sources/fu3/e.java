package fu3;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements Runnable {
    public final /* synthetic */ JSONObject a;

    @Override // java.lang.Runnable
    public final void run() {
        jt3.a.b("apm_frequency_monitor", this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public e(JSONObject r1) {
        this.a = r1;
    }
}
