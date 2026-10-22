package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002}~R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000f\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u00108&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u001e8&X§\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0007\u001a\u0004\b\u001f\u0010 R$\u0010'\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\u0007\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010(8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\u0007\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010/8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\u0007\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010:\u001a\u0004\u0018\u0001068&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0007\u001a\u0004\b7\u00108R\u001c\u0010?\u001a\u0004\u0018\u00010;8&X§\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0007\u001a\u0004\b<\u0010=R\"\u0010C\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bB\u0010\u0007\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\rR\"\u0010G\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bF\u0010\u0007\u001a\u0004\bD\u0010\u000b\"\u0004\bE\u0010\rR\"\u0010K\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bJ\u0010\u0007\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010\rR\u001c\u0010P\u001a\u0004\u0018\u00010L8&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0007\u001a\u0004\bM\u0010NR$\u0010W\u001a\u0004\u0018\u00010Q8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bV\u0010\u0007\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010^\u001a\u0004\u0018\u00010X8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b]\u0010\u0007\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010e\u001a\u0004\u0018\u00010_8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bd\u0010\u0007\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010l\u001a\u0004\u0018\u00010f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bk\u0010\u0007\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010p\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bo\u0010\u0007\u001a\u0004\bm\u0010\u0005\"\u0004\bn\u0010%R$\u0010t\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bs\u0010\u0007\u001a\u0004\bq\u0010\u0005\"\u0004\br\u0010%R$\u0010x\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\bw\u0010\u0007\u001a\u0004\bu\u0010\u0005\"\u0004\bv\u0010%R$\u0010|\u001a\u0004\u0018\u00010\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b{\u0010\u0007\u001a\u0004\by\u0010\u0005\"\u0004\bz\u0010%¨\u0006\u007f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "Lvh7/e;", "Lcom/bytedance/android/livesdk/link/model/bridge/p;", "", "getFromAnchorID", "()Ljava/lang/String;", "getFromAnchorID$annotations", "()V", "fromAnchorID", "", "getModType", "()I", "setModType", "(I)V", "getModType$annotations", "modType", "Lcom/bytedance/android/livesdk/link/model/u2;", "getSelfData", "()Lcom/bytedance/android/livesdk/link/model/u2;", "setSelfData", "(Lcom/bytedance/android/livesdk/link/model/u2;)V", "getSelfData$annotations", "selfData", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteData", "()Lcom/bytedance/android/livesdk/link/model/aa;", "setVoteData", "(Lcom/bytedance/android/livesdk/link/model/aa;)V", "getVoteData$annotations", "voteData", "Lcom/bytedance/android/livesdk/link/model/v2;", "getSelfSettingRate", "()Lcom/bytedance/android/livesdk/link/model/v2;", "getSelfSettingRate$annotations", "selfSettingRate", "getActivityId", "setActivityId", "(Ljava/lang/String;)V", "getActivityId$annotations", "activityId", "Lcom/bytedance/android/livesdk/link/model/w2;", "getShellConfig", "()Lcom/bytedance/android/livesdk/link/model/w2;", "setShellConfig", "(Lcom/bytedance/android/livesdk/link/model/w2;)V", "getShellConfig$annotations", "shellConfig", "Lcom/bytedance/android/livesdk/link/model/h9;", "getSpecifyGiftConfig", "()Lcom/bytedance/android/livesdk/link/model/h9;", "setSpecifyGiftConfig", "(Lcom/bytedance/android/livesdk/link/model/h9;)V", "getSpecifyGiftConfig$annotations", "specifyGiftConfig", "Lcom/bytedance/android/livesdk/link/model/m3;", "getBreakthroughConfig", "()Lcom/bytedance/android/livesdk/link/model/m3;", "getBreakthroughConfig$annotations", "breakthroughConfig", "Lcom/bytedance/android/livesdk/link/model/k9;", "getSurvivalConfig", "()Lcom/bytedance/android/livesdk/link/model/k9;", "getSurvivalConfig$annotations", "survivalConfig", "getPlayMode", "setPlayMode", "getPlayMode$annotations", "playMode", "getTeamMode", "setTeamMode", "getTeamMode$annotations", "teamMode", "getActivityMode", "setActivityMode", "getActivityMode$annotations", "activityMode", "Lcom/bytedance/android/livesdk/link/model/e9;", "getSeasonConfig", "()Lcom/bytedance/android/livesdk/link/model/e9;", "getSeasonConfig$annotations", "seasonConfig", "Lcom/bytedance/android/livesdk/link/model/d4;", "getCustomConfig", "()Lcom/bytedance/android/livesdk/link/model/d4;", "setCustomConfig", "(Lcom/bytedance/android/livesdk/link/model/d4;)V", "getCustomConfig$annotations", "customConfig", "Lcom/bytedance/android/livesdk/link/model/v0;", "getCloudCollaborateConfig", "()Lcom/bytedance/android/livesdk/link/model/v0;", "setCloudCollaborateConfig", "(Lcom/bytedance/android/livesdk/link/model/v0;)V", "getCloudCollaborateConfig$annotations", "cloudCollaborateConfig", "Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;", "getAuxiliaryConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;", "setAuxiliaryConfig", "(Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;)V", "getAuxiliaryConfig$annotations", "auxiliaryConfig", "Lcom/bytedance/android/livesdk/link/model/ca;", "getInteractConfig", "()Lcom/bytedance/android/livesdk/link/model/ca;", "setInteractConfig", "(Lcom/bytedance/android/livesdk/link/model/ca;)V", "getInteractConfig$annotations", "interactConfig", "getAudienceApplyBattleUserId", "setAudienceApplyBattleUserId", "getAudienceApplyBattleUserId$annotations", "audienceApplyBattleUserId", "getAudienceApplyBattleAnchorId", "setAudienceApplyBattleAnchorId", "getAudienceApplyBattleAnchorId$annotations", "audienceApplyBattleAnchorId", "getAudienceApplyBattleOpenId", "setAudienceApplyBattleOpenId", "getAudienceApplyBattleOpenId$annotations", "audienceApplyBattleOpenId", "getAudienceApplyBattleAnchorOpenId", "setAudienceApplyBattleAnchorOpenId", "getAudienceApplyBattleAnchorOpenId$annotations", "audienceApplyBattleAnchorOpenId", "BattleActivityMode", "BattleCloudCollaboratePanelType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleConfigSetting extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.p>, com.bytedance.android.livesdk.link.model.bridge.p {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting$BattleActivityMode;", "", "ActivityMode_Empty", "ActivityMode_Flex", "ActivityMode_Season", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleActivityMode extends Enum<BattleActivityMode> {
        public static final BattleActivityMode ActivityMode_Empty = null;
        public static final BattleActivityMode ActivityMode_Flex = null;
        public static final BattleActivityMode ActivityMode_Season = null;
        public static final /* synthetic */ BattleActivityMode[] a = null;

        static {
            BattleActivityMode r1 = new BattleActivityMode("ActivityMode_Empty", 0);
            ActivityMode_Empty = r1;
            BattleActivityMode r2 = new BattleActivityMode("ActivityMode_Flex", 1);
            ActivityMode_Flex = r2;
            BattleActivityMode r3 = new BattleActivityMode("ActivityMode_Season", 2);
            ActivityMode_Season = r3;
            a = new BattleActivityMode[]{r1, r2, r3};
        }

        public static BattleActivityMode valueOf(String r1) {
            return (BattleActivityMode) r27.a.a(BattleActivityMode.class, r1);
        }

        public static BattleActivityMode[] values() {
            return (BattleActivityMode[]) a.clone();
        }

        public BattleActivityMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting$BattleCloudCollaboratePanelType;", "", "BattleCloudCollaboratePanelType_Unknown", "BattleCloudCollaboratePanelType_ExpandScreen", "BattleCloudCollaboratePanelType_ThroneFight", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum BattleCloudCollaboratePanelType extends Enum<BattleCloudCollaboratePanelType> {
        public static final BattleCloudCollaboratePanelType BattleCloudCollaboratePanelType_ExpandScreen = null;
        public static final BattleCloudCollaboratePanelType BattleCloudCollaboratePanelType_ThroneFight = null;
        public static final BattleCloudCollaboratePanelType BattleCloudCollaboratePanelType_Unknown = null;
        public static final /* synthetic */ BattleCloudCollaboratePanelType[] a = null;

        static {
            BattleCloudCollaboratePanelType r1 = new BattleCloudCollaboratePanelType("BattleCloudCollaboratePanelType_Unknown", 0);
            BattleCloudCollaboratePanelType_Unknown = r1;
            BattleCloudCollaboratePanelType r2 = new BattleCloudCollaboratePanelType("BattleCloudCollaboratePanelType_ExpandScreen", 1);
            BattleCloudCollaboratePanelType_ExpandScreen = r2;
            BattleCloudCollaboratePanelType r3 = new BattleCloudCollaboratePanelType("BattleCloudCollaboratePanelType_ThroneFight", 2);
            BattleCloudCollaboratePanelType_ThroneFight = r3;
            a = new BattleCloudCollaboratePanelType[]{r1, r2, r3};
        }

        public static BattleCloudCollaboratePanelType valueOf(String r1) {
            return (BattleCloudCollaboratePanelType) r27.a.a(BattleCloudCollaboratePanelType.class, r1);
        }

        public static BattleCloudCollaboratePanelType[] values() {
            return (BattleCloudCollaboratePanelType[]) a.clone();
        }

        public BattleCloudCollaboratePanelType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.p
    /* synthetic */ vh7.e castTo(Class r1);

    @Override // com.bytedance.android.livesdk.link.model.bridge.p
    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "activity_id")
    String getActivityId();

    @FieldName(name = "activity_mode")
    int getActivityMode();

    @FieldName(name = "audience_apply_battle_anchor_id")
    String getAudienceApplyBattleAnchorId();

    @FieldName(name = "audience_apply_battle_anchor_open_id")
    String getAudienceApplyBattleAnchorOpenId();

    @FieldName(name = "audience_apply_battle_open_id")
    String getAudienceApplyBattleOpenId();

    @FieldName(name = "audience_apply_battle_user_id")
    String getAudienceApplyBattleUserId();

    @FieldName(name = "auxiliary_config")
    IBattleAuxiliaryConfig getAuxiliaryConfig();

    @FieldName(name = "breakthrough_config")
    m3 getBreakthroughConfig();

    @FieldName(name = "cloud_collaborate_config")
    v0 getCloudCollaborateConfig();

    @FieldName(name = "custom_config")
    d4 getCustomConfig();

    /* synthetic */ Object getFlexInstance();

    @FieldName(name = "from_anchor_open_id")
    String getFromAnchorID();

    @FieldName(name = "interact_config")
    ca getInteractConfig();

    @FieldName(name = "mod_type")
    int getModType();

    @FieldName(name = "play_mode")
    int getPlayMode();

    @FieldName(name = "season_config")
    e9 getSeasonConfig();

    @FieldName(name = "self_data")
    u2 getSelfData();

    @FieldName(name = "self_setting_rate")
    v2 getSelfSettingRate();

    @FieldName(name = "shell_config")
    w2 getShellConfig();

    @FieldName(name = "specify_gift_config")
    h9 getSpecifyGiftConfig();

    @FieldName(name = "survival_config")
    k9 getSurvivalConfig();

    @FieldName(name = "team_mode")
    int getTeamMode();

    @FieldName(name = "vote_data")
    aa getVoteData();

    @FieldName(name = "activity_id#setter")
    void setActivityId(String r1);

    @FieldName(name = "activity_mode#setter")
    void setActivityMode(int r1);

    @FieldName(name = "audience_apply_battle_anchor_id#setter")
    void setAudienceApplyBattleAnchorId(String r1);

    @FieldName(name = "audience_apply_battle_anchor_open_id#setter")
    void setAudienceApplyBattleAnchorOpenId(String r1);

    @FieldName(name = "audience_apply_battle_open_id#setter")
    void setAudienceApplyBattleOpenId(String r1);

    @FieldName(name = "audience_apply_battle_user_id#setter")
    void setAudienceApplyBattleUserId(String r1);

    @FieldName(name = "auxiliary_config#setter")
    void setAuxiliaryConfig(IBattleAuxiliaryConfig r1);

    @FieldName(name = "cloud_collaborate_config#setter")
    void setCloudCollaborateConfig(v0 r1);

    @FieldName(name = "custom_config#setter")
    void setCustomConfig(d4 r1);

    @FieldName(name = "interact_config#setter")
    void setInteractConfig(ca r1);

    @FieldName(name = "mod_type#setter")
    void setModType(int r1);

    @FieldName(name = "play_mode#setter")
    void setPlayMode(int r1);

    @FieldName(name = "self_data#setter")
    void setSelfData(u2 r1);

    @FieldName(name = "shell_config#setter")
    void setShellConfig(w2 r1);

    @FieldName(name = "specify_gift_config#setter")
    void setSpecifyGiftConfig(h9 r1);

    @FieldName(name = "team_mode#setter")
    void setTeamMode(int r1);

    @FieldName(name = "vote_data#setter")
    void setVoteData(aa r1);
}
