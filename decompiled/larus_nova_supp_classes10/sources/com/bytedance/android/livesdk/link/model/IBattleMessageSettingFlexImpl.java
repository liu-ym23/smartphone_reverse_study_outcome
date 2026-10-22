package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.BattleSettings")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bw\u0010xR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\fR\u001b\u0010\u001c\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\fR\u001b\u0010\u001f\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\"\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001b\u0010'\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007R\u001b\u0010-\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007R\u001d\u00102\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0005\u001a\u0004\b0\u00101R\u001d\u00105\u001a\u0004\u0018\u00010.8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u00101R+\u0010;\u001a\u00020\t2\u0006\u00106\u001a\u00020\t8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010:R\u001b\u0010>\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u0005\u001a\u0004\b=\u0010\fR\u001b\u0010A\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010&R\u001b\u0010F\u001a\u00020B8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010ER\u001b\u0010I\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\u0005\u001a\u0004\bH\u0010\fR\u001b\u0010L\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0005\u001a\u0004\bK\u0010\fR\u001b\u0010O\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0005\u001a\u0004\bN\u0010\u0007R\u001b\u0010R\u001a\u00020B8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\u0005\u001a\u0004\bQ\u0010ER\u001b\u0010U\u001a\u00020B8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u0005\u001a\u0004\bT\u0010ER\u001b\u0010X\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\u0005\u001a\u0004\bW\u0010\u0007R\u001b\u0010[\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0005\u001a\u0004\bZ\u0010&R\u001d\u0010`\u001a\u0004\u0018\u00010\\8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u0005\u001a\u0004\b^\u0010_R\u001b\u0010c\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u0005\u001a\u0004\bb\u0010&R\u001d\u0010h\u001a\u0004\u0018\u00010d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0005\u001a\u0004\bf\u0010gR\u001d\u0010k\u001a\u0004\u0018\u00010d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bi\u0010\u0005\u001a\u0004\bj\u0010gR#\u0010p\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010l8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u0005\u001a\u0004\bn\u0010oR\u001b\u0010s\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\u0005\u001a\u0004\br\u0010\fR\u001d\u0010v\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\u0005\u001a\u0004\bu\u0010\u0007¨\u0006y"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMessageSettingFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/u1;", "", "initiatorId$delegate", "Ljava/lang/Object;", "getInitiatorId", "()Ljava/lang/String;", "initiatorId", "", "channelId$delegate", "getChannelId", "()J", "channelId", "duration$delegate", "getDuration", "duration", "startTimeMs$delegate", "getStartTimeMs", "startTimeMs", "theme$delegate", "getTheme", "theme", "battleId$delegate", "getBattleId", "battleId", "matchType$delegate", "getMatchType", "matchType", "bannerUrl$delegate", "getBannerUrl", "bannerUrl", "battleConfig$delegate", "getBattleConfig", "battleConfig", "", "mode$delegate", "getMode", "()I", "mode", "notifySchemeUrl$delegate", "getNotifySchemeUrl", "notifySchemeUrl", "hotsoonNotifySchemeUrl$delegate", "getHotsoonNotifySchemeUrl", "hotsoonNotifySchemeUrl", "Lcom/bytedance/android/livesdk/link/model/IBattleTitleConfigFlexImpl;", "titleConfig$delegate", "getTitleConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleTitleConfigFlexImpl;", "titleConfig", "punishConfig$delegate", "getPunishConfig", "punishConfig", "<set-?>", "punishDuration$delegate", "getPunishDuration", "setPunishDuration", "(J)V", "punishDuration", "punishStartTimeMs$delegate", "getPunishStartTimeMs", "punishStartTimeMs", "optimizeVersion$delegate", "getOptimizeVersion", "optimizeVersion", "", "punishOptimizeOn$delegate", "getPunishOptimizeOn", "()Z", "punishOptimizeOn", "_bloodDisplayDuration$delegate", "get_bloodDisplayDuration", "_bloodDisplayDuration", "statusDisplayDuration$delegate", "getStatusDisplayDuration", "statusDisplayDuration", "disconnectToastContent$delegate", "getDisconnectToastContent", "disconnectToastContent", "needCloseLinkmic$delegate", "getNeedCloseLinkmic", "needCloseLinkmic", "displayLastResult$delegate", "getDisplayLastResult", "displayLastResult", "activityType$delegate", "getActivityType", "activityType", "inviteType$delegate", "getInviteType", "inviteType", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSettingExtensionImpl;", "battleConfigSetting$delegate", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSettingExtensionImpl;", "battleConfigSetting", "battleType$delegate", "getBattleType", "battleType", "Lcom/bytedance/android/livesdk/link/model/IBattleBarConfigFlexImpl;", "barConfig$delegate", "getBarConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleBarConfigFlexImpl;", "barConfig", "hotsoonBarConfig$delegate", "getHotsoonBarConfig", "hotsoonBarConfig", "", "playTags$delegate", "getPlayTags", "()Ljava/util/List;", "playTags", "stealTowerDuration$delegate", "getStealTowerDuration", "stealTowerDuration", "lynxData$delegate", "getLynxData", "lynxData", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleMessageSettingFlexImpl extends FlexModelBase<u1> implements u1, vh7.h {

    @SerializedName("blood_display_duration")
    protected long _$$_bloodDisplayDuration;

    @SerializedName("normal_activity_name")
    protected String _$$activityType;

    @SerializedName("banner_url")
    protected String _$$bannerUrl;

    @SerializedName("bar_config")
    protected IBattleBarConfigFlexImpl _$$barConfig;

    @SerializedName("config")
    protected String _$$battleConfig;

    @SerializedName("battle_config_setting")
    protected IBattleConfigSettingExtensionImpl _$$battleConfigSetting;

    @SerializedName("battle_id")
    protected long _$$battleId;

    @SerializedName("battle_type")
    protected int _$$battleType;

    @SerializedName("channel_id")
    protected long _$$channelId;

    @SerializedName("toast")
    protected String _$$disconnectToastContent;

    @SerializedName("display_last_result")
    protected boolean _$$displayLastResult;

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("hotsoon_bar_config")
    protected IBattleBarConfigFlexImpl _$$hotsoonBarConfig;

    @SerializedName("hotsoon_notify_scheme_url")
    protected String _$$hotsoonNotifySchemeUrl;

    @SerializedName("initiator_open_id")
    protected String _$$initiatorId;

    @SerializedName("invite_type")
    protected int _$$inviteType;

    @SerializedName("lynx_data")
    protected String _$$lynxData;

    @SerializedName("match_type")
    protected long _$$matchType;

    @SerializedName("mode")
    protected int _$$mode;

    @SerializedName("need_close_linkmic")
    protected boolean _$$needCloseLinkmic;

    @SerializedName("notify_scheme_url")
    protected String _$$notifySchemeUrl;

    @SerializedName("optimize_version")
    protected int _$$optimizeVersion;

    @SerializedName("play_tags")
    protected List<Integer> _$$playTags;

    @SerializedName("punish_config")
    protected IBattleTitleConfigFlexImpl _$$punishConfig;

    @SerializedName("punish_duration")
    protected long _$$punishDuration;

    @SerializedName("punish_optimize_on")
    protected boolean _$$punishOptimizeOn;

    @SerializedName("punish_start_time_ms")
    protected long _$$punishStartTimeMs;

    @SerializedName("start_time_ms")
    protected long _$$startTimeMs;

    @SerializedName("status_display_duration")
    protected long _$$statusDisplayDuration;

    @SerializedName("steal_tower_duration")
    protected long _$$stealTowerDuration;

    @SerializedName("theme")
    protected String _$$theme;

    @SerializedName("title_config")
    protected IBattleTitleConfigFlexImpl _$$titleConfig;

    public IBattleMessageSettingFlexImpl() {
        super(u1.class);
        this._$$theme = "";
        this._$$bannerUrl = "";
        this._$$battleConfig = "";
        this._$$notifySchemeUrl = "";
        this._$$hotsoonNotifySchemeUrl = "";
        this._$$punishOptimizeOn = false;
        this._$$disconnectToastContent = "";
        this._$$needCloseLinkmic = false;
        this._$$displayLastResult = false;
        this._$$activityType = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public /* bridge */ /* synthetic */ IBattleBarConfig getBarConfig() {
        return getBarConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public /* bridge */ /* synthetic */ IBattleConfigSetting getBattleConfigSetting() {
        return getBattleConfigSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public /* bridge */ /* synthetic */ IBattleBarConfig getHotsoonBarConfig() {
        return getHotsoonBarConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public /* bridge */ /* synthetic */ h3 getPunishConfig() {
        return getPunishConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public /* bridge */ /* synthetic */ h3 getTitleConfig() {
        return getTitleConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getActivityType() {
        return this._$$activityType;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getBannerUrl() {
        return this._$$bannerUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getBattleConfig() {
        return this._$$battleConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getBattleId() {
        return this._$$battleId;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final int getBattleType() {
        return this._$$battleType;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final long getChannelId() {
        return this._$$channelId;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getDisconnectToastContent() {
        return this._$$disconnectToastContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final boolean getDisplayLastResult() {
        return this._$$displayLastResult;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getHotsoonNotifySchemeUrl() {
        return this._$$hotsoonNotifySchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getInitiatorId() {
        return this._$$initiatorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final int getInviteType() {
        return this._$$inviteType;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final String getLynxData() {
        return this._$$lynxData;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getMatchType() {
        return this._$$matchType;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final int getMode() {
        return this._$$mode;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final boolean getNeedCloseLinkmic() {
        return this._$$needCloseLinkmic;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getNotifySchemeUrl() {
        return this._$$notifySchemeUrl;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final int getOptimizeVersion() {
        return this._$$optimizeVersion;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final List<Integer> getPlayTags() {
        return this._$$playTags;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getPunishDuration() {
        return this._$$punishDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final boolean getPunishOptimizeOn() {
        return this._$$punishOptimizeOn;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getPunishStartTimeMs() {
        return this._$$punishStartTimeMs;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getStartTimeMs() {
        return this._$$startTimeMs;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getStatusDisplayDuration() {
        return this._$$statusDisplayDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long getStealTowerDuration() {
        return this._$$stealTowerDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final String getTheme() {
        return this._$$theme;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final long get_bloodDisplayDuration() {
        return this._$$_bloodDisplayDuration;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final IBattleBarConfigFlexImpl getBarConfig() {
        return this._$$barConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final IBattleConfigSettingExtensionImpl getBattleConfigSetting() {
        return this._$$battleConfigSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1
    public final IBattleBarConfigFlexImpl getHotsoonBarConfig() {
        return this._$$hotsoonBarConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final IBattleTitleConfigFlexImpl getPunishConfig() {
        return this._$$punishConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final IBattleTitleConfigFlexImpl getTitleConfig() {
        return this._$$titleConfig;
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object, vh7.c] */
    public IBattleMessageSettingFlexImpl(am3.g r8) {
        super(u1.class);
        this._$$playTags = new ArrayList();
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L48;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 == 35) goto L46;
        if (r4 != 5000) goto L9;
        this._$$initiatorId = am3.h.c(r8);
        goto L3
    L9:
        switch(r4) {
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            default: goto L10;
        };
    L38:
        this._$$bannerUrl = am3.h.c(r8);
        goto L3
    L39:
        this._$$matchType = r8.j();
        r3 = r3 | 16;
        goto L3
    L40:
        this._$$channelId = r8.j();
        r3 = r3 | 1;
        goto L3
    L41:
        this._$$theme = am3.h.c(r8);
        goto L3
    L42:
        this._$$duration = r8.j();
        r3 = r3 | 2;
        goto L3
    L43:
        this._$$startTimeMs = r8.j();
        r3 = r3 | 4;
        goto L3
    L44:
        this._$$battleId = r8.j();
        r3 = r3 | 8;
        goto L3
    L10:
        switch(r4) {
            case 10: goto L37;
            case 11: goto L36;
            case 12: goto L35;
            case 13: goto L34;
            default: goto L11;
        };
    L34:
        this._$$hotsoonNotifySchemeUrl = am3.h.c(r8);
        goto L3
    L35:
        this._$$notifySchemeUrl = am3.h.c(r8);
        goto L3
    L36:
        this._$$battleConfig = am3.h.c(r8);
        goto L3
    L37:
        this._$$mode = r8.i();
        r3 = r3 | 32;
        goto L3
    L11:
        switch(r4) {
            case 17: goto L33;
            case 18: goto L32;
            case 19: goto L31;
            case 20: goto L30;
            case 21: goto L29;
            case 22: goto L28;
            case 23: goto L27;
            case 24: goto L26;
            case 25: goto L25;
            case 26: goto L24;
            case 27: goto L23;
            case 28: goto L22;
            case 29: goto L21;
            default: goto L12;
        };
    L21:
        this._$$inviteType = r8.i();
        r3 = r3 | 16384;
        goto L3
    L22:
        this._$$activityType = am3.h.c(r8);
        goto L3
    L23:
        this._$$displayLastResult = am3.h.a(r8);
        r3 = r3 | 8192;
        goto L3
    L24:
        this._$$needCloseLinkmic = am3.h.a(r8);
        r3 = r3 | 4096;
        goto L3
    L25:
        this._$$disconnectToastContent = am3.h.c(r8);
        goto L3
    L26:
        this._$$statusDisplayDuration = r8.j();
        r3 = r3 | 2048;
        goto L3
    L27:
        this._$$_bloodDisplayDuration = r8.j();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
        goto L3
    L28:
        this._$$punishOptimizeOn = am3.h.a(r8);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
        goto L3
    L29:
        this._$$optimizeVersion = r8.i();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
        goto L3
    L30:
        this._$$punishStartTimeMs = r8.j();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        goto L3
    L31:
        this._$$punishDuration = r8.j();
        r3 = r3 | 64;
        goto L3
    L32:
        this._$$punishConfig = new IBattleTitleConfigFlexImpl(r8);
        goto L3
    L33:
        this._$$titleConfig = new IBattleTitleConfigFlexImpl(r8);
        goto L3
    L12:
        switch(r4) {
            case 31: goto L20;
            case 32: goto L19;
            case 33: goto L18;
            default: goto L13;
        };
    L18:
        this._$$hotsoonBarConfig = new IBattleBarConfigFlexImpl(r8);
        goto L3
    L19:
        this._$$barConfig = new IBattleBarConfigFlexImpl(r8);
        goto L3
    L20:
        this._$$battleConfigSetting = (IBattleConfigSettingExtensionImpl) vh7.f.a(r8, com.bytedance.android.livesdk.link.model.bridge.p.class).castToOrNull(IBattleConfigSettingExtensionImpl.class);
        goto L3
    L13:
        switch(r4) {
            case 37: goto L17;
            case 38: goto L16;
            case 39: goto L15;
            default: goto L14;
        };
    L15:
        this._$$lynxData = am3.h.c(r8);
        goto L3
    L16:
        this._$$stealTowerDuration = r8.j();
        int r6 = 65536;
    L47:
        r3 = r3 | r6;
        goto L3
    L17:
        this._$$playTags.add(Integer.valueOf(r8.i()));
        goto L3
    L14:
        am3.h.d(r5, r8);
        goto L3
    L46:
        this._$$battleType = r8.i();
        r6 = 32768;
        goto L47
    L48:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$theme != null) goto L52;
        this._$$theme = "";
    L52:
        if (this._$$bannerUrl != null) goto L55;
        this._$$bannerUrl = "";
    L55:
        if (this._$$battleConfig != null) goto L58;
        this._$$battleConfig = "";
    L58:
        if (this._$$notifySchemeUrl != null) goto L61;
        this._$$notifySchemeUrl = "";
    L61:
        if (this._$$hotsoonNotifySchemeUrl != null) goto L64;
        this._$$hotsoonNotifySchemeUrl = "";
    L64:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L67;
        this._$$punishOptimizeOn = false;
    L67:
        if (this._$$disconnectToastContent != null) goto L70;
        this._$$disconnectToastContent = "";
    L70:
        if ((r3 & 4096) != 0) goto L73;
        this._$$needCloseLinkmic = false;
    L73:
        if ((r3 & 8192) != 0) goto L76;
        this._$$displayLastResult = false;
    L76:
        if (this._$$activityType != null) goto L151;
        this._$$activityType = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.u1, com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting
    public final void setPunishDuration(long r1) {
        this._$$punishDuration = r1;
    }
}
