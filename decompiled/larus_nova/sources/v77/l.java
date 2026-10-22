package v77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class l {

    @SerializedName("app_request_interval")
    private long appRequestInterval;

    @SerializedName("auth_kill_event_interval")
    private long authKillEventInterval;

    @SerializedName("cancel_dialog_on_touch_out_side")
    private boolean cancelDialogOnTouchOutSide;

    @SerializedName("disable_dialog_back_btn")
    private boolean disableDialogBackBtn;

    @SerializedName("loop_detect_result_interval")
    private long loopDetectResultInterval;

    @SerializedName("loop_detect_result_timeout")
    private long loopDetectResultTimeout;

    @SerializedName("scenes_request_interval")
    private long scenesRequestInterval;

    @SerializedName("sys_dialog_show_timeout")
    private long sysDialogShowTimeout;

    public l() {
        this.scenesRequestInterval = 60000;
        this.appRequestInterval = 30000;
        this.loopDetectResultInterval = 500;
        this.loopDetectResultTimeout = 2000;
        this.authKillEventInterval = 3600000;
        this.sysDialogShowTimeout = 3000;
        this.cancelDialogOnTouchOutSide = false;
        this.disableDialogBackBtn = true;
    }
}
