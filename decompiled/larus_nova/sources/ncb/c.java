package ncb;

import com.byted.cast.common.CommonOptionConstants;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f518686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f518687b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f518688c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f518689d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f518690e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f518691f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f518692g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f518693h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f518694i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f518695j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c f518696k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c f518697l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f518698m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f518699n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f518700o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final c f518701p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final c f518702q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final c f518703r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final c f518704s = null;

    static {
        OPMonitorLevel r100 = OPMonitorLevel.ERROR;
        new c(10000, r100, "root_view_null");
        new c(10001, r100, "child_params_list_empty");
        new c(10002, OPMonitorLevel.WARN, "child_params_null");
        new c(10003, OPMonitorLevel.TRACE, "img_key_empty");
        new c(10004, r100, "select_person_error");
        new c(10005, r100, "bind_data_error");
        new c(10014, r100, "messagecard_url_open_unsupport");
        OPMonitorLevel r101 = OPMonitorLevel.NORMAL;
        f518686a = new c(10028, r101, "messagecard_action_data_error");
        new c(10029, r101, "messagecard_action_url_error");
        new c(10040, r101, "messagecard_loading_success");
        new c(10050, r101, "messagecard_action_result");
        new c(10051, r101, "messagecard_action_service_fail");
        f518687b = new c(10070, r101, "messagecard_initdata_prepare");
        f518688c = new c(10071, r101, "messagecard_template_load_start");
        f518689d = new c(10072, r101, "messagecard_template_load_finish");
        f518690e = new c(10073, r101, "messagecard_page_render_finish");
        f518691f = new c(10074, r101, "messagecard_create_view_finish");
        new c(10075, r101, "messagecard_js_execute_success");
        new c(10076, r101, "messagecard_js_execute_error");
        f518692g = new c(10077, r101, "messagecard_lynx_error");
        f518693h = new c(10078, r101, "messagecard_render_start");
        f518694i = new c(10060, r101, "messagecard_request_success");
        new c(10061, r101, "messagecard_request_data_error");
        f518695j = new c(10062, r101, "messagecard_request_network_error");
        f518696k = new c(10063, r101, "messagecard_open_url_success");
        f518697l = new c(10064, r101, "lynx_messagecard_url_open_unsupport");
        new c(10065, r101, "lynx_messagecard_url_open_without_triggercode");
        new c(10066, r101, "messagecard_request_time_out");
        new c(10067, r101, "messagecard_card_json2pb_success");
        new c(10068, r101, "messagecard_card_json2pb_error");
        new c(10069, r101, "messagecard_send_preview_card_success");
        new c(CommonOptionConstants.OPTION_SET_APPLICATION, r101, "messagecard_send_preview_card_error");
        new c(10080, r101, "card_component_render");
        f518698m = new c(10081, r101, "card_client_message_success");
        f518699n = new c(10082, r101, "card_client_message_error");
        new c(10084, r101, "chart_render_finish");
        f518700o = new c(10085, r101, "card_external_js_load_start");
        f518701p = new c(10086, r101, "card_external_js_load_end");
        new c(10087, r101, "card_external_js_preload_start");
        new c(10088, r101, "card_external_js_preload_end");
        f518702q = new c(CommonOptionConstants.OPTION_ENABLE_BYTELINK_BROWSE, r101, "card_get_entity_success");
        f518703r = new c(10092, r101, "card_get_entity_fail");
        f518704s = new c(CommonOptionConstants.OPTION_SOURCE_INVITE_PORT, r101, "card_check_diff_result");
        new c(10096, r101, "card_render_with_action_sync_data");
        new c(10097, r101, "enter_chat_with_card");
    }

    public c(int r100, OPMonitorLevel r101, String r102) {
        super("client.open_platform.card", r100, r101, r102);
    }
}
