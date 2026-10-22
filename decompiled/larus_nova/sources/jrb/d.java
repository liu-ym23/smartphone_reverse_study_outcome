package jrb;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f500162a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f500163b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f500164c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f500165d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f500166e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f500167f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f500168g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f500169h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f500170i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d f500171j = null;

    static {
        OPMonitorLevel r100 = OPMonitorLevel.ERROR;
        new d(10000, r100, "root_view_null");
        new d(10001, r100, "child_params_list_empty");
        f500162a = new d(10002, OPMonitorLevel.WARN, "child_params_null");
        f500163b = new d(10003, OPMonitorLevel.TRACE, "img_key_empty");
        f500164c = new d(10004, r100, "select_person_error");
        new d(10005, r100, "bind_data_error");
        f500165d = new d(10009, r100, "messagecard_trigger_code_fail");
        f500166e = new d(10013, r100, "messagecard_image_load_origin_error");
        f500167f = new d(10014, r100, "messagecard_url_open_unsupport");
        new d(10015, r100, "messagecard_url_open_without_triggercode_func");
        f500168g = new d(10016, r100, "messagecard_url_open_without_triggercode");
        new d(10017, r100, "messagecard_url_open_url_invalid");
        new d(10018, r100, "messagecard_url_open_url_limt_interval");
        f500169h = new d(10019, r100, "messagecard_request_not_allow");
        new d(10020, r100, "messagecard_request_in_last_process");
        f500170i = new d(10021, r100, "messagecard_request_response_fail");
        f500171j = new d(10022, OPMonitorLevel.NORMAL, "messagecard_request_response_success");
    }

    public d(int r100, OPMonitorLevel r101, String r102) {
        super("client.open_platform.card", r100, r101, r102);
    }
}
