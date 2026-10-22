package gt5;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c extends OPMonitor {

    public static final class a {
    }

    static {
    }

    public abstract Map<String, Object> a();

    @Override // com.ss.android.lark.opmonitor.service.OPMonitor
    public synchronized void flush() {
        monitor-enter(this);
        Map<String, Object> r100 = a();     // Catch: Throwable -> L13
        boolean r101 = false;
        if (r100 != null) goto L6;
    L8:
        if (r101 == false) goto L10;
        addMap(r100);     // Catch: Throwable -> L13
    L10:
        super.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if ((!r100.isEmpty()) != true) goto L8;
        r101 = true;
    L13:
        th = move-exception;
        throw th;
    }

    public c(fyb.e r100, String r101, OPMonitorCode r102) {
        super(r100, r101, r102);
    }
}
