package v77;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f553495a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f553496b = 0;

    @SerializedName("activity_state_update_timeout")
    public long activityStateUpdateTimeout;

    @SerializedName("add_top_padding_for_radius")
    public boolean addTopPaddingForRadius;

    @SerializedName("adjust_sys_dialog_background_color")
    public String adjustSysDialogBackgroundColor;

    @SerializedName("agree_button_is_in_vertical_bottom")
    public boolean agreeButtonIsInVerticalBottom;

    @SerializedName("agree_button_text")
    public Map<String, String> agreeButtonText;

    @SerializedName("agree_button_text_for_orientation")
    public Map<String, String> agreeButtonTextForOrientation;

    @SerializedName("color_os_dialog_style")
    public int colorOsDialogStyle;

    @SerializedName("detect_notification_status_interval")
    public long detectNotificationStatusInterval;

    @SerializedName("detect_notification_status_timeout")
    public long detectNotificationStatusTimeout;

    @SerializedName("dialog_ability_type")
    public String dialogAbilityType;

    @SerializedName("dim_amount")
    public float dimAmount;

    @SerializedName("disable_custom_dialog_after_sys_dialog_show_failed")
    public boolean disableCustomDialogAfterSysDialogShowFailed;

    @SerializedName("disable_custom_dialog_after_user_click_sys_reject")
    public boolean disableCustomDialogAfterUserClickSysReject;

    @SerializedName("disable_set_trusted_overlay")
    public boolean disableSetTrustedOverlay;

    @SerializedName("dismiss_after_outside_click")
    public boolean dismissAfterOutSideClick;

    @SerializedName("enable_agree_button_radius")
    public boolean enableAgreeButtonRadius;

    @SerializedName("expand_bottom_empty_area")
    public boolean expandBottomEmptyArea;

    @SerializedName("expand_top_empty_area")
    public boolean expandTopEmptyArea;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG)
    public String extraConfig;

    @SerializedName("is_valid_settings")
    public boolean isValidSettings;

    @SerializedName("kill_sys_dialog_depend_notification_opened")
    public boolean killSysDialogDependNotificationOpened;

    @SerializedName("rs_config")
    public p67.a mRiskConfig;

    @SerializedName("match_bottom_navigation_bar")
    public boolean matchBottomNavigationBar;

    @SerializedName("new_user_dialog_ability_config")
    public a newUserDialogAbilityConfig;

    @SerializedName("old_user_dialog_ability_config")
    public a oldUserDialogAbilityConfig;

    @SerializedName("reject_button_text")
    public Map<String, String> rejectButtonText;

    @SerializedName("reject_button_text_for_orientation")
    public Map<String, String> rejectButtonTextForOrientation;

    @SerializedName("set_trusted_overlay_times")
    public long setTrustedOverlayTimes;

    @SerializedName("support_dark_mode")
    public boolean supportDarkMode;

    @SerializedName("sys_dialog_enter_anim_duration")
    public long sysDialogEnterAnimDuration;

    @SerializedName("sys_dialog_exit_anim_duration")
    public long sysDialogExitAnimDuration;

    @SerializedName("tips_text")
    public String tipsText;

    @SerializedName("toast_dialog_interval")
    public int toastDialogInterval;

    @SerializedName("ts_dialog_max_show_time")
    public long toastDialogMaxShowTime;

    @SerializedName("toast_max_security_patch")
    public String toastMaxSecurityPatch;

    public static class a {

        @SerializedName("add_x_to_dialog")
        public boolean addXToDialog;

        @SerializedName("back_mode")
        public int backMode;

        @SerializedName("dialog_mode")
        public int dialogMode;

        public a() {
            List<Integer> r100 = d.f553495a;
            this.dialogMode = 2;
            this.backMode = d.f553496b;
        }
    }

    static {
        f553495a = Arrays.asList(new Integer[]{1, 16});
        f553496b = 1;
    }

    public d() {
        this.activityStateUpdateTimeout = 300;
        this.sysDialogEnterAnimDuration = 250;
        this.sysDialogExitAnimDuration = 250;
        this.toastDialogInterval = 30000;
        this.dismissAfterOutSideClick = false;
        this.toastDialogMaxShowTime = 12000;
        this.setTrustedOverlayTimes = 10;
        this.tipsText = "通知类型可前往App内通知设置页设置";
        this.disableCustomDialogAfterUserClickSysReject = true;
        this.disableCustomDialogAfterSysDialogShowFailed = true;
    }
}
