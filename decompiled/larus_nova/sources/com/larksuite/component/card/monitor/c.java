package com.larksuite.component.card.monitor;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends OPMonitorCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f283722a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f283723b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f283724c = null;

    static {
        f283722a = new c(10003, OPMonitorLevel.TRACE, "img_key_empty");
        OPMonitorLevel r100 = OPMonitorLevel.ERROR;
        f283723b = new c(10013, r100, "messagecard_image_load_origin_error");
        new c(10014, r100, "messagecard_url_open_unsupport");
        new c(10015, r100, "messagecard_url_open_without_triggercode_func");
        f283724c = new c(10016, r100, "messagecard_url_open_without_triggercode");
        new c(10017, r100, "messagecard_url_open_url_invalid");
        new c(10018, r100, "messagecard_url_open_url_limt_interval");
        new c(10019, r100, "messagecard_request_not_allow");
        new c(10020, r100, "messagecard_request_in_last_process");
        new c(10021, r100, "messagecard_request_response_fail");
        new c(10022, OPMonitorLevel.NORMAL, "messagecard_request_response_success");
    }

    public c(int r100, OPMonitorLevel r101, String r102) {
        super("client.open_platform.card", r100, r101, r102);
    }
}
