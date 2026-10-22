package ncb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f518680a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f518681b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f518682c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f518683d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f518684e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f518685f = null;

    static {
        OPMonitorLevel r100 = OPMonitorLevel.NORMAL;
        f518680a = new b(0, r100, "success");
        OPMonitorLevel r101 = OPMonitorLevel.ERROR;
        new b(-10000, r101, "internal_error");
        new b(-10001, r101, "param_invalid");
        f518681b = new b(-10002, r101, "fetch_block_entity_network_error");
        f518682c = new b(-10003, r101, "fetch_block_entity_biz_error");
        new b(10000, r100, "unmount_block");
        new b(10001, r100, "start_mount_block");
        new b(10002, r100, "start_block_entity");
        f518683d = new b(10003, r100, "start_fetch_block_entity");
        f518684e = new b(10004, r100, "fetch_block_entity_success");
        f518685f = new b(10005, r100, "block_entity_result");
    }

    public b(int r100, OPMonitorLevel r101, String r102) {
        super("client.open_platform.blockit.mount.entity", r100, r101, r102);
    }
}
