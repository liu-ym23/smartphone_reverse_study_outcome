package v77;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes21.dex */
public class g {

    @SerializedName("agree_button_text")
    public String agreeButtonText;

    @SerializedName("dialog_mode")
    public int dialogMode;

    @SerializedName("allow_downgrade_dialog")
    public boolean downgradeDialog;

    @SerializedName("expand_bottom_empty_area")
    public boolean expandBottomEmptyArea;

    @SerializedName("loop_detect_user_click_interval_in_mill")
    public long loopDetectUserClickIntervalInMill;

    @SerializedName("reject_button_text")
    public String rejectButtonText;

    @SerializedName("sys_dialog_enter_anim_duration")
    public long sysDialogEnterAnimDuration;

    @SerializedName("toast_duration")
    public long toastDuration;

    @SerializedName("use_new_window_flag")
    public boolean useNewWindowFlag;

    @SerializedName("user_click_detect_mode")
    public int userClickDetectMode;

    public g() {
        this.dialogMode = 1;
        this.agreeButtonText = "允许";
        this.rejectButtonText = "禁止";
        this.expandBottomEmptyArea = true;
        this.useNewWindowFlag = true;
        this.sysDialogEnterAnimDuration = 250;
        this.userClickDetectMode = 1;
        this.loopDetectUserClickIntervalInMill = 20;
        this.downgradeDialog = false;
        this.toastDuration = 15000;
    }
}
