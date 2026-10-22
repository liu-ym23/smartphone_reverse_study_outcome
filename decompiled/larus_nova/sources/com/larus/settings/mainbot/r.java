package com.larus.settings.mainbot;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001BÏ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0013\u0010>\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nHÆ\u0003JÑ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nHÆ\u0001J\u0013\u0010@\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u000bHÖ\u0001J\t\u0010C\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0016\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!¨\u0006D"}, d2 = {"Lcom/larus/settings/mainbot/TaskModeConfig;", "", "deepThinkingUseFloating", "", "enableThreadDetailThinkingGroup", "mockSkillEnable", "officeTaskModeSettingsEntryEnable", "agentsMdSettingsEntryEnable", "workExperienceSettingsEntryEnable", "taskModeItemIds", "", "", "remoteControlEnable", "moaModeMenuNoDeviceEnableGuide", "remoteControlRequiredCommands", "remoteControlRefreshThrottle", "remoteControlPcVersionMinRequired", "", "pcDownloadUrl", "threadPreambleStyleEnable", "enableVmTaskModeFilter", "enableFileCardDirectOpen", "deviceTagIconAppIds", "<init>", "(ZZZZZZLjava/util/List;ZZLjava/util/List;ILjava/lang/String;Ljava/lang/String;ZZZLjava/util/List;)V", "getDeepThinkingUseFloating", "()Z", "getEnableThreadDetailThinkingGroup", "getMockSkillEnable", "getOfficeTaskModeSettingsEntryEnable", "getAgentsMdSettingsEntryEnable", "getWorkExperienceSettingsEntryEnable", "getTaskModeItemIds", "()Ljava/util/List;", "getRemoteControlEnable", "getMoaModeMenuNoDeviceEnableGuide", "getRemoteControlRequiredCommands", "getRemoteControlRefreshThrottle", "()I", "getRemoteControlPcVersionMinRequired", "()Ljava/lang/String;", "getPcDownloadUrl", "getThreadPreambleStyleEnable", "getEnableVmTaskModeFilter", "getEnableFileCardDirectOpen", "getDeviceTagIconAppIds", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class r {

    @SerializedName("agents_md_settings_entry_enable")
    private final boolean agentsMdSettingsEntryEnable;

    @SerializedName("deep_thinking_use_floating")
    private final boolean deepThinkingUseFloating;

    @SerializedName("device_tag_icon_app_ids")
    private final List<String> deviceTagIconAppIds;

    @SerializedName("enable_file_card_direct_open")
    private final boolean enableFileCardDirectOpen;

    @SerializedName("enable_thread_detail_thinking_group")
    private final boolean enableThreadDetailThinkingGroup;

    @SerializedName("enable_vm_task_mode_filter")
    private final boolean enableVmTaskModeFilter;

    @SerializedName("moa_mode_menu_no_device_enable_guide")
    private final boolean moaModeMenuNoDeviceEnableGuide;

    @SerializedName("mock_skill_enable")
    private final boolean mockSkillEnable;

    @SerializedName("office_task_mode_settings_entry_enable")
    private final boolean officeTaskModeSettingsEntryEnable;

    @SerializedName("pc_download_url")
    private final String pcDownloadUrl;

    @SerializedName("remote_control_enable")
    private final boolean remoteControlEnable;

    @SerializedName("remote_control_pc_version_min_required")
    private final String remoteControlPcVersionMinRequired;

    @SerializedName("remote_control_refresh_throttle")
    private final int remoteControlRefreshThrottle;

    @SerializedName("remote_control_required_commands")
    private final List<Integer> remoteControlRequiredCommands;

    @SerializedName("task_mode_item_ids")
    private final List<Integer> taskModeItemIds;

    @SerializedName("thread_preamble_style_enable")
    private final boolean threadPreambleStyleEnable;

    @SerializedName("work_experience_settings_entry_enable")
    private final boolean workExperienceSettingsEntryEnable;

    public r() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.deepThinkingUseFloating == r101.deepThinkingUseFloating) goto L12;
        return false;
    L12:
        if (this.enableThreadDetailThinkingGroup == r101.enableThreadDetailThinkingGroup) goto L15;
        return false;
    L15:
        if (this.mockSkillEnable == r101.mockSkillEnable) goto L18;
        return false;
    L18:
        if (this.officeTaskModeSettingsEntryEnable == r101.officeTaskModeSettingsEntryEnable) goto L21;
        return false;
    L21:
        if (this.agentsMdSettingsEntryEnable == r101.agentsMdSettingsEntryEnable) goto L24;
        return false;
    L24:
        if (this.workExperienceSettingsEntryEnable == r101.workExperienceSettingsEntryEnable) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.taskModeItemIds, r101.taskModeItemIds) == true) goto L30;
        return false;
    L30:
        if (this.remoteControlEnable == r101.remoteControlEnable) goto L33;
        return false;
    L33:
        if (this.moaModeMenuNoDeviceEnableGuide == r101.moaModeMenuNoDeviceEnableGuide) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.remoteControlRequiredCommands, r101.remoteControlRequiredCommands) == true) goto L39;
        return false;
    L39:
        if (this.remoteControlRefreshThrottle == r101.remoteControlRefreshThrottle) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.remoteControlPcVersionMinRequired, r101.remoteControlPcVersionMinRequired) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.pcDownloadUrl, r101.pcDownloadUrl) == true) goto L48;
        return false;
    L48:
        if (this.threadPreambleStyleEnable == r101.threadPreambleStyleEnable) goto L51;
        return false;
    L51:
        if (this.enableVmTaskModeFilter == r101.enableVmTaskModeFilter) goto L54;
        return false;
    L54:
        if (this.enableFileCardDirectOpen == r101.enableFileCardDirectOpen) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.deviceTagIconAppIds, r101.deviceTagIconAppIds) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.deepThinkingUseFloating == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableThreadDetailThinkingGroup == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.mockSkillEnable == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.officeTaskModeSettingsEntryEnable == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.agentsMdSettingsEntryEnable == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.workExperienceSettingsEntryEnable == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        List<Integer> r113 = this.taskModeItemIds;
        int r114 = 0;
        if (r113 != null) goto L29;
        int r115 = 0;
    L30:
        int r116 = (r112 + r115) * 31;
        if (this.remoteControlEnable == false) goto L33;
        int r117 = 1231;
    L34:
        int r118 = (r116 + r117) * 31;
        if (this.moaModeMenuNoDeviceEnableGuide == false) goto L37;
        int r119 = 1231;
    L38:
        int r120 = (r118 + r119) * 31;
        List<Integer> r121 = this.remoteControlRequiredCommands;
        if (r121 != null) goto L41;
        int r122 = 0;
    L42:
        int r123 = (((r120 + r122) * 31) + this.remoteControlRefreshThrottle) * 31;
        String r124 = this.remoteControlPcVersionMinRequired;
        if (r124 != null) goto L45;
        int r125 = 0;
    L46:
        int r126 = (r123 + r125) * 31;
        String r127 = this.pcDownloadUrl;
        if (r127 != null) goto L49;
        int r128 = 0;
    L50:
        int r129 = (r126 + r128) * 31;
        if (this.threadPreambleStyleEnable == false) goto L53;
        int r130 = 1231;
    L54:
        int r131 = (r129 + r130) * 31;
        if (this.enableVmTaskModeFilter == false) goto L57;
        int r132 = 1231;
    L58:
        int r133 = (r131 + r132) * 31;
        if (this.enableFileCardDirectOpen == true) goto L62;
        r100 = 1237;
    L62:
        int r134 = (r133 + r100) * 31;
        List<String> r135 = this.deviceTagIconAppIds;
        if (r135 == null) goto L67;
        r114 = r135.hashCode();
    L67:
        return r134 + r114;
    L57:
        r132 = 1237;
        goto L58
    L53:
        r130 = 1237;
        goto L54
    L49:
        r128 = r127.hashCode();
        goto L50
    L45:
        r125 = r124.hashCode();
        goto L46
    L41:
        r122 = r121.hashCode();
        goto L42
    L37:
        r119 = 1237;
        goto L38
    L33:
        r117 = 1237;
        goto L34
    L29:
        r115 = r113.hashCode();
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskModeConfig(deepThinkingUseFloating=" + this.deepThinkingUseFloating + ", enableThreadDetailThinkingGroup=" + this.enableThreadDetailThinkingGroup + ", mockSkillEnable=" + this.mockSkillEnable + ", officeTaskModeSettingsEntryEnable=" + this.officeTaskModeSettingsEntryEnable + ", agentsMdSettingsEntryEnable=" + this.agentsMdSettingsEntryEnable + ", workExperienceSettingsEntryEnable=" + this.workExperienceSettingsEntryEnable + ", taskModeItemIds=" + this.taskModeItemIds + ", remoteControlEnable=" + this.remoteControlEnable + ", moaModeMenuNoDeviceEnableGuide=" + this.moaModeMenuNoDeviceEnableGuide + ", remoteControlRequiredCommands=" + this.remoteControlRequiredCommands + ", remoteControlRefreshThrottle=" + this.remoteControlRefreshThrottle + ", remoteControlPcVersionMinRequired=" + this.remoteControlPcVersionMinRequired + ", pcDownloadUrl=" + this.pcDownloadUrl + ", threadPreambleStyleEnable=" + this.threadPreambleStyleEnable + ", enableVmTaskModeFilter=" + this.enableVmTaskModeFilter + ", enableFileCardDirectOpen=" + this.enableFileCardDirectOpen + ", deviceTagIconAppIds=" + this.deviceTagIconAppIds + ')';
    }

    public final boolean a() {
        return this.agentsMdSettingsEntryEnable;
    }

    public final List<String> b() {
        return this.deviceTagIconAppIds;
    }

    public final boolean c() {
        return this.enableFileCardDirectOpen;
    }

    public final boolean d() {
        return this.moaModeMenuNoDeviceEnableGuide;
    }

    public final boolean e() {
        return this.mockSkillEnable;
    }

    public final boolean f() {
        return this.officeTaskModeSettingsEntryEnable;
    }

    public final String g() {
        return this.pcDownloadUrl;
    }

    public final boolean h() {
        return this.remoteControlEnable;
    }

    public final String i() {
        return this.remoteControlPcVersionMinRequired;
    }

    public final int j() {
        return this.remoteControlRefreshThrottle;
    }

    public final boolean k() {
        return this.threadPreambleStyleEnable;
    }

    public final boolean l() {
        return this.workExperienceSettingsEntryEnable;
    }

    public r(Object r100) {
        this.deepThinkingUseFloating = true;
        this.enableThreadDetailThinkingGroup = true;
        this.mockSkillEnable = true;
        this.officeTaskModeSettingsEntryEnable = true;
        this.agentsMdSettingsEntryEnable = true;
        this.workExperienceSettingsEntryEnable = false;
        this.taskModeItemIds = null;
        this.remoteControlEnable = false;
        this.moaModeMenuNoDeviceEnableGuide = false;
        this.remoteControlRequiredCommands = null;
        this.remoteControlRefreshThrottle = 10;
        this.remoteControlPcVersionMinRequired = "2.24";
        this.pcDownloadUrl = null;
        this.threadPreambleStyleEnable = true;
        this.enableVmTaskModeFilter = false;
        this.enableFileCardDirectOpen = true;
        this.deviceTagIconAppIds = null;
    }
}
