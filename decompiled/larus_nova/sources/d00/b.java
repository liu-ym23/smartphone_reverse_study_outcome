package d00;

import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f466164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f466165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f466166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ JSONObject f466167d;

    public b(e r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        this.f466164a = r100;
        this.f466165b = r101;
        this.f466166c = r102;
        this.f466167d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TraceMonitor.i(this.f466164a, this.f466165b, this.f466166c, this.f466167d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
