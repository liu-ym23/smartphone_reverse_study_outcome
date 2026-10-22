package ncb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f518705a = null;

    static {
        f518705a = new d(OPMonitorLevel.NORMAL);
    }

    public d(OPMonitorLevel r100) {
        super("client.open_platform.infra.storage", 10000, r100, "sp_creation_failed_monitor");
    }
}
