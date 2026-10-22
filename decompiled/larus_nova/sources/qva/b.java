package qva;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f534926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f534927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f534928c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f534929d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f534930e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f534931f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f534932g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f534933h = null;

    static {
        OPMonitorLevel r100 = OPMonitorLevel.ERROR;
        f534926a = new b(10000, r100, "uri_is Null");
        f534927b = new b(10001, r100, "short_link_request_timeout");
        f534928c = new b(10002, r100, "short_link_request_fail");
        f534929d = new b(10003, r100, "version_not_support");
        f534930e = new b(10004, r100, "path_not_support");
        f534931f = new b(10005, r100, "handler_can_not_open");
        f534932g = new b(10006, r100, "no_handler");
        f534933h = new b(10010, OPMonitorLevel.WARN, "check_with_config_return_false");
    }

    public b(int r100, OPMonitorLevel r101, String r102) {
        super("client.open_platform.applink", r100, r101, r102);
    }
}
