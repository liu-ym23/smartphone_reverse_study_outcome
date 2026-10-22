package fu3;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class b$e implements Runnable {
    public final /* synthetic */ JSONObject a;

    @Override // java.lang.Runnable
    public final void run() {
        jt3.a.b("apm_frequency_exception_monitor", this.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b$e(JSONObject r1) {
        this.a = r1;
    }
}
