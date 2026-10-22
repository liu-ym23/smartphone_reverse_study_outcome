package gt5;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class g extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ft5.a f482537a;

    public static final class a {
    }

    static {
    }

    @Override // gt5.c
    public final Map<String, Object> a() {
        ft5.a r100 = this.f482537a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCommonParams();
    }

    @Override // gt5.c, com.ss.android.lark.opmonitor.service.OPMonitor
    public final void flush() {
        super.flush();
    }

    public g(String r100, OPMonitorCode r101, ft5.a r102) {
        fyb.e r103 = new fyb.e();
        r103.f479343a = new dyb.a(new gt5.a(r102), b.f482510a);
        super(r103, r100, r101);
        this.f482537a = r102;
    }
}
