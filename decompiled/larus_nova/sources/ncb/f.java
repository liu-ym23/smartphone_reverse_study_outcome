package ncb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f518706a = 0;

    static {
        new f(OPMonitorLevel.NORMAL);
    }

    public f(OPMonitorLevel r100) {
        super("client.security_compliance.universal", 10000, r100, "scs_universal_log");
    }
}
