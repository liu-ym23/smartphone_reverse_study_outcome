package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010o\u001a\u00020\u0002¢\u0006\u0004\bp\u0010qJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u00168V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010!\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R(\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(R(\u0010/\u001a\u0004\u0018\u00010*2\b\u0010\u0010\u001a\u0004\u0018\u00010*8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u00105\u001a\u0004\u0018\u0001002\b\u0010\u0010\u001a\u0004\u0018\u0001008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0016\u00109\u001a\u0004\u0018\u0001068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0016\u0010=\u001a\u0004\u0018\u00010:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R$\u0010@\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010\u0014R$\u0010C\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010\u0014R$\u0010F\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bD\u0010\u0012\"\u0004\bE\u0010\u0014R\u0016\u0010J\u001a\u0004\u0018\u00010G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR(\u0010P\u001a\u0004\u0018\u00010K2\b\u0010\u0010\u001a\u0004\u0018\u00010K8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010V\u001a\u0004\u0018\u00010Q2\b\u0010\u0010\u001a\u0004\u0018\u00010Q8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR(\u0010\\\u001a\u0004\u0018\u00010W2\b\u0010\u0010\u001a\u0004\u0018\u00010W8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R(\u0010b\u001a\u0004\u0018\u00010]2\b\u0010\u0010\u001a\u0004\u0018\u00010]8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR(\u0010e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bc\u0010\r\"\u0004\bd\u0010(R(\u0010h\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bf\u0010\r\"\u0004\bg\u0010(R(\u0010k\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bi\u0010\r\"\u0004\bj\u0010(R(\u0010n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010(¨\u0006r"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleConfigSettingExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/p;", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getFromAnchorID", "()Ljava/lang/String;", "fromAnchorID", "", "value", "getModType", "()I", "setModType", "(I)V", "modType", "Lcom/bytedance/android/livesdk/link/model/u2;", "getSelfData", "()Lcom/bytedance/android/livesdk/link/model/u2;", "setSelfData", "(Lcom/bytedance/android/livesdk/link/model/u2;)V", "selfData", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteData", "()Lcom/bytedance/android/livesdk/link/model/aa;", "setVoteData", "(Lcom/bytedance/android/livesdk/link/model/aa;)V", "voteData", "Lcom/bytedance/android/livesdk/link/model/v2;", "getSelfSettingRate", "()Lcom/bytedance/android/livesdk/link/model/v2;", "selfSettingRate", "getActivityId", "setActivityId", "(Ljava/lang/String;)V", "activityId", "Lcom/bytedance/android/livesdk/link/model/w2;", "getShellConfig", "()Lcom/bytedance/android/livesdk/link/model/w2;", "setShellConfig", "(Lcom/bytedance/android/livesdk/link/model/w2;)V", "shellConfig", "Lcom/bytedance/android/livesdk/link/model/h9;", "getSpecifyGiftConfig", "()Lcom/bytedance/android/livesdk/link/model/h9;", "setSpecifyGiftConfig", "(Lcom/bytedance/android/livesdk/link/model/h9;)V", "specifyGiftConfig", "Lcom/bytedance/android/livesdk/link/model/m3;", "getBreakthroughConfig", "()Lcom/bytedance/android/livesdk/link/model/m3;", "breakthroughConfig", "Lcom/bytedance/android/livesdk/link/model/k9;", "getSurvivalConfig", "()Lcom/bytedance/android/livesdk/link/model/k9;", "survivalConfig", "getPlayMode", "setPlayMode", "playMode", "getTeamMode", "setTeamMode", "teamMode", "getActivityMode", "setActivityMode", "activityMode", "Lcom/bytedance/android/livesdk/link/model/e9;", "getSeasonConfig", "()Lcom/bytedance/android/livesdk/link/model/e9;", "seasonConfig", "Lcom/bytedance/android/livesdk/link/model/d4;", "getCustomConfig", "()Lcom/bytedance/android/livesdk/link/model/d4;", "setCustomConfig", "(Lcom/bytedance/android/livesdk/link/model/d4;)V", "customConfig", "Lcom/bytedance/android/livesdk/link/model/v0;", "getCloudCollaborateConfig", "()Lcom/bytedance/android/livesdk/link/model/v0;", "setCloudCollaborateConfig", "(Lcom/bytedance/android/livesdk/link/model/v0;)V", "cloudCollaborateConfig", "Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;", "getAuxiliaryConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;", "setAuxiliaryConfig", "(Lcom/bytedance/android/livesdk/link/model/IBattleAuxiliaryConfig;)V", "auxiliaryConfig", "Lcom/bytedance/android/livesdk/link/model/ca;", "getInteractConfig", "()Lcom/bytedance/android/livesdk/link/model/ca;", "setInteractConfig", "(Lcom/bytedance/android/livesdk/link/model/ca;)V", "interactConfig", "getAudienceApplyBattleUserId", "setAudienceApplyBattleUserId", "audienceApplyBattleUserId", "getAudienceApplyBattleAnchorId", "setAudienceApplyBattleAnchorId", "audienceApplyBattleAnchorId", "getAudienceApplyBattleOpenId", "setAudienceApplyBattleOpenId", "audienceApplyBattleOpenId", "getAudienceApplyBattleAnchorOpenId", "setAudienceApplyBattleAnchorOpenId", "audienceApplyBattleAnchorOpenId", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/p;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleConfigSettingExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.p, IBattleConfigSetting> implements IBattleConfigSetting, com.bytedance.android.livesdk.link.model.bridge.p {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.p $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting, com.bytedance.android.livesdk.link.model.bridge.p
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.p>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting, com.bytedance.android.livesdk.link.model.bridge.p
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.p>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public m3 getBreakthroughConfig() {
        return (m3) get(7, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public u2 getSelfData() {
        return (u2) get(2, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public v2 getSelfSettingRate() {
        return (v2) get(4, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public w2 getShellConfig() {
        return (w2) get(6, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public aa getVoteData() {
        return (aa) get(3, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public String getActivityId() {
        return (String) get(16, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public int getActivityMode() {
        return ((Number) get(11, IBattleConfigSetting.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public String getAudienceApplyBattleAnchorId() {
        return (String) get(23, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public String getAudienceApplyBattleAnchorOpenId() {
        return (String) get(5002, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public String getAudienceApplyBattleOpenId() {
        return (String) get(5001, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public String getAudienceApplyBattleUserId() {
        return (String) get(22, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public IBattleAuxiliaryConfig getAuxiliaryConfig() {
        return (IBattleAuxiliaryConfig) get(17, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public v0 getCloudCollaborateConfig() {
        return (v0) get(18, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public d4 getCustomConfig() {
        return (d4) get(14, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public String getFromAnchorID() {
        return (String) get(5000, IBattleConfigSetting.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public ca getInteractConfig() {
        return (ca) get(20, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public int getModType() {
        return ((Number) get(1, IBattleConfigSetting.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public int getPlayMode() {
        return ((Number) get(9, IBattleConfigSetting.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public e9 getSeasonConfig() {
        return (e9) get(13, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public h9 getSpecifyGiftConfig() {
        return (h9) get(8, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public k9 getSurvivalConfig() {
        return (k9) get(12, IBattleConfigSetting.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public int getTeamMode() {
        return ((Number) get(10, IBattleConfigSetting.class, 0)).intValue();
    }

    public IBattleConfigSettingExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.p r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setActivityId(String r4) {
        set(16, "activity_id", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setActivityMode(int r4) {
        set(11, "activity_mode", IBattleConfigSetting.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setAudienceApplyBattleAnchorId(String r4) {
        set(23, "audience_apply_battle_anchor_id", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setAudienceApplyBattleAnchorOpenId(String r4) {
        set(5002, "audience_apply_battle_anchor_open_id", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setAudienceApplyBattleOpenId(String r4) {
        set(5001, "audience_apply_battle_open_id", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setAudienceApplyBattleUserId(String r4) {
        set(22, "audience_apply_battle_user_id", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setAuxiliaryConfig(IBattleAuxiliaryConfig r4) {
        set(17, "auxiliary_config", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setCloudCollaborateConfig(v0 r4) {
        set(18, "cloud_collaborate_config", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setCustomConfig(d4 r4) {
        set(14, "custom_config", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setInteractConfig(ca r4) {
        set(20, "interact_config", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setModType(int r4) {
        set(1, "mod_type", IBattleConfigSetting.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setPlayMode(int r4) {
        set(9, "play_mode", IBattleConfigSetting.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setSelfData(u2 r4) {
        set(2, "self_data", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setShellConfig(w2 r4) {
        set(6, "shell_config", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setSpecifyGiftConfig(h9 r4) {
        set(8, "specify_gift_config", IBattleConfigSetting.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setTeamMode(int r4) {
        set(10, "team_mode", IBattleConfigSetting.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IBattleConfigSetting
    public void setVoteData(aa r4) {
        set(3, "vote_data", IBattleConfigSetting.class, r4);
    }
}
