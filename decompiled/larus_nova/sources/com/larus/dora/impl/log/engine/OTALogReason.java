package com.larus.dora.impl.log.engine;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/log/engine/OTALogReason;", "", "message", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "NOT_SATISFY_TO_RESUME", "BUDS_NOT_READY", "LOW_BATTERY", "BUSY", "DOWNLOAD_OTA_FILE_FAILED", "OTA_OTHER", "EAR_BUDS_NOT_READY", "FILE_NOT_FOUND", "AUTOMATIC_SWITCH_CLOSE", "NO_REMAINING_TIMES", "RECEIVED_OTA_PACKAGE", "ERROR_MESSAGE_MSG", "BES_CONNECT_ERROR_OTA_STATUS", "TASK_CANCELED", "D_BUDS_PROTOCOL_DISCONNECT", "EVENT_BUDS_VUI_ERROR", "COPY_SN", "CLOUD_ORDER_LOG", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OTALogReason extends Enum<OTALogReason> {
    public static final OTALogReason AUTOMATIC_SWITCH_CLOSE = null;
    public static final OTALogReason BES_CONNECT_ERROR_OTA_STATUS = null;
    public static final OTALogReason BUDS_NOT_READY = null;
    public static final OTALogReason BUSY = null;
    public static final OTALogReason CLOUD_ORDER_LOG = null;
    public static final OTALogReason COPY_SN = null;
    public static final OTALogReason DOWNLOAD_OTA_FILE_FAILED = null;
    public static final OTALogReason D_BUDS_PROTOCOL_DISCONNECT = null;
    public static final OTALogReason EAR_BUDS_NOT_READY = null;
    public static final OTALogReason ERROR_MESSAGE_MSG = null;
    public static final OTALogReason EVENT_BUDS_VUI_ERROR = null;
    public static final OTALogReason FILE_NOT_FOUND = null;
    public static final OTALogReason LOW_BATTERY = null;
    public static final OTALogReason NOT_SATISFY_TO_RESUME = null;
    public static final OTALogReason NO_REMAINING_TIMES = null;
    public static final OTALogReason OTA_OTHER = null;
    public static final OTALogReason RECEIVED_OTA_PACKAGE = null;
    public static final OTALogReason TASK_CANCELED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OTALogReason[] f336094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336095b = null;
    private final String message;

    public static EnumEntries<OTALogReason> getEntries() {
        return f336095b;
    }

    static {
        OTALogReason r100 = new OTALogReason("NOT_SATISFY_TO_RESUME", 0, "not_satisfy_to_resume_data_transfer");
        NOT_SATISFY_TO_RESUME = r100;
        OTALogReason r101 = new OTALogReason("BUDS_NOT_READY", 1, "ota_buds_not_ready");
        BUDS_NOT_READY = r101;
        OTALogReason r102 = new OTALogReason("LOW_BATTERY", 2, "ota_low_battery");
        LOW_BATTERY = r102;
        OTALogReason r103 = new OTALogReason("BUSY", 3, "ota_busy");
        BUSY = r103;
        OTALogReason r104 = new OTALogReason("DOWNLOAD_OTA_FILE_FAILED", 4, "ota_download_package_failure");
        DOWNLOAD_OTA_FILE_FAILED = r104;
        OTALogReason r105 = new OTALogReason("OTA_OTHER", 5, "ota_other");
        OTA_OTHER = r105;
        OTALogReason r110 = new OTALogReason("EAR_BUDS_NOT_READY", 6, "ota_ear_buds_not_ready");
        EAR_BUDS_NOT_READY = r110;
        OTALogReason r111 = new OTALogReason("FILE_NOT_FOUND", 7, "ota_file_not_found");
        FILE_NOT_FOUND = r111;
        OTALogReason r112 = new OTALogReason("AUTOMATIC_SWITCH_CLOSE", 8, "ota_automatic_switch_close");
        AUTOMATIC_SWITCH_CLOSE = r112;
        OTALogReason r113 = new OTALogReason("NO_REMAINING_TIMES", 9, "ota_no_remaining_times");
        NO_REMAINING_TIMES = r113;
        OTALogReason r114 = new OTALogReason("RECEIVED_OTA_PACKAGE", 10, "ota_received_ota_package");
        RECEIVED_OTA_PACKAGE = r114;
        OTALogReason r106 = new OTALogReason("ERROR_MESSAGE_MSG", 11, "ota_bes_error_message_msg");
        ERROR_MESSAGE_MSG = r106;
        OTALogReason r107 = new OTALogReason("BES_CONNECT_ERROR_OTA_STATUS", 12, "ota_bes_connect_error");
        BES_CONNECT_ERROR_OTA_STATUS = r107;
        OTALogReason r108 = new OTALogReason("TASK_CANCELED", 13, "ota_status_cancel");
        TASK_CANCELED = r108;
        OTALogReason r109 = new OTALogReason("D_BUDS_PROTOCOL_DISCONNECT", 14, "event_buds_vui_error");
        D_BUDS_PROTOCOL_DISCONNECT = r109;
        OTALogReason r115 = new OTALogReason("EVENT_BUDS_VUI_ERROR", 15, "event_buds_vui_error");
        EVENT_BUDS_VUI_ERROR = r115;
        OTALogReason r116 = new OTALogReason("COPY_SN", 16, "copy_sn");
        COPY_SN = r116;
        OTALogReason r117 = new OTALogReason("CLOUD_ORDER_LOG", 17, "cloud_order_log");
        CLOUD_ORDER_LOG = r117;
        OTALogReason[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117};
        f336094a = r118;
        f336095b = EnumEntriesKt.enumEntries(r118);
    }

    public static OTALogReason[] values() {
        return (OTALogReason[]) f336094a.clone();
    }

    public final String getMessage() {
        return this.message;
    }

    public static OTALogReason valueOf(String r100) {
        return (OTALogReason) a.a(OTALogReason.class, r100);
    }

    public OTALogReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.message = r102;
    }
}
