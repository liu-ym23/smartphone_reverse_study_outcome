package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleStatsMeta")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bT\u0010UR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R)\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u001aR#\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u0004\u0018\u00010\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010%R#\u0010*\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010 R)\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\rR\u001b\u00103\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u00102R\u001d\u00108\u001a\u0004\u0018\u0001048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0005\u001a\u0004\b6\u00107R\u001d\u0010=\u001a\u0004\u0018\u0001098VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0005\u001a\u0004\b;\u0010<R\u001d\u0010B\u001a\u0004\u0018\u00010>8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u0005\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010C8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\u0005\u001a\u0004\bE\u0010FR\u001b\u0010J\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u0005\u001a\u0004\bI\u0010\u0007R\u001b\u0010M\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bK\u0010\u0005\u001a\u0004\bL\u0010\u0007R\u001b\u0010P\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bN\u0010\u0005\u001a\u0004\bO\u0010\u0007R\u001b\u0010S\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0005\u001a\u0004\bR\u0010\u0007¨\u0006V"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleStatsMetaFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/c3;", "", "loserId$delegate", "Ljava/lang/Object;", "getLoserId", "()Ljava/lang/String;", "loserId", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "battleUserInfoMap$delegate", "getBattleUserInfoMap", "()Ljava/util/Map;", "battleUserInfoMap", "", "channelId$delegate", "getChannelId", "()J", "channelId", "battleId$delegate", "getBattleId", "battleId", "Lcom/bytedance/android/livesdk/link/model/IBattleDataSettingFlexImpl;", "battleSetting$delegate", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleDataSettingFlexImpl;", "battleSetting", "", "Lcom/bytedance/android/livesdk/link/model/IMvpListInfoFlexImpl;", "mvpListInfoList$delegate", "getMvpListInfoList", "()Ljava/util/List;", "mvpListInfoList", "Lcom/bytedance/android/livesdk/link/model/IChannelInfoFlexImpl;", "channelInfo$delegate", "getChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/IChannelInfoFlexImpl;", "channelInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleDataScoreFlexImpl;", "battleScorePairList$delegate", "getBattleScorePairList", "battleScorePairList", "Lcom/bytedance/android/livesdk/link/model/IMultiTeamInfoFlexImpl;", "multiPkTeam$delegate", "getMultiPkTeam", "multiPkTeam", "", "skinType$delegate", "getSkinType", "()I", "skinType", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "teamTask$delegate", "getTeamTask", "()Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "teamTask", "Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "skinConfig$delegate", "getSkinConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "skinConfig", "Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "breakthroughInfo$delegate", "getBreakthroughInfo", "()Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "breakthroughInfo", "Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoFlexImpl;", "survivalInfo$delegate", "getSurvivalInfo", "()Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoFlexImpl;", "survivalInfo", "teamTaskJson$delegate", "getTeamTaskJson", "teamTaskJson", "battleEffectInfo$delegate", "getBattleEffectInfo", "battleEffectInfo", "metaLynxData$delegate", "getMetaLynxData", "metaLynxData", "eventTrackingInfo$delegate", "getEventTrackingInfo", "eventTrackingInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleStatsMetaFlexImpl extends FlexModelBase<c3> implements c3, vh7.h {

    @SerializedName("battle_effect_info")
    protected String _$$battleEffectInfo;

    @SerializedName("battle_id")
    protected long _$$battleId;

    @SerializedName("battle_scores")
    protected List<IBattleDataScoreFlexImpl> _$$battleScorePairList;

    @SerializedName("battle_settings")
    protected IBattleDataSettingFlexImpl _$$battleSetting;

    @SerializedName("open_user_infos")
    protected Map<String, IBattleUserInfoFlexImpl> _$$battleUserInfoMap;

    @SerializedName("breakthrough_info")
    protected IBreakthroughInfoFlexImpl _$$breakthroughInfo;

    @SerializedName("channel_id")
    protected long _$$channelId;

    @SerializedName("channel_info")
    protected IChannelInfoFlexImpl _$$channelInfo;

    @SerializedName("event_tracking_info")
    protected String _$$eventTrackingInfo;

    @SerializedName("loser_open_id")
    protected String _$$loserId;

    @SerializedName("lynx_data")
    protected String _$$metaLynxData;

    @SerializedName("multi_pk_team")
    protected Map<Long, IMultiTeamInfoFlexImpl> _$$multiPkTeam;

    @SerializedName("battle_armies")
    protected List<IMvpListInfoFlexImpl> _$$mvpListInfoList;

    @SerializedName("skin_config")
    protected IBattleSkinConfigFlexImpl _$$skinConfig;

    @SerializedName("skin_type")
    protected int _$$skinType;

    @SerializedName("survival_info")
    protected ISurvivalInfoFlexImpl _$$survivalInfo;

    @SerializedName("team_task")
    protected ITeamTaskFlexImpl _$$teamTask;

    @SerializedName("team_task_json")
    protected String _$$teamTaskJson;

    public IBattleStatsMetaFlexImpl() {
        super(c3.class);
        this._$$loserId = "";
        this._$$teamTaskJson = "";
        this._$$battleEffectInfo = "";
        this._$$metaLynxData = "";
        this._$$eventTrackingInfo = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public /* bridge */ /* synthetic */ c1 getBattleSetting() {
        return getBattleSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public /* bridge */ /* synthetic */ n3 getBreakthroughInfo() {
        return getBreakthroughInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public /* bridge */ /* synthetic */ s3 getChannelInfo() {
        return getChannelInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public /* bridge */ /* synthetic */ x2 getSkinConfig() {
        return getSkinConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public /* bridge */ /* synthetic */ l9 getSurvivalInfo() {
        return getSurvivalInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public /* bridge */ /* synthetic */ ITeamTask getTeamTask() {
        return getTeamTask();
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final String getBattleEffectInfo() {
        return this._$$battleEffectInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final long getBattleId() {
        return this._$$battleId;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final List<IBattleDataScoreFlexImpl> getBattleScorePairList() {
        return this._$$battleScorePairList;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final Map<String, IBattleUserInfoFlexImpl> getBattleUserInfoMap() {
        return this._$$battleUserInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final long getChannelId() {
        return this._$$channelId;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final String getEventTrackingInfo() {
        return this._$$eventTrackingInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final String getLoserId() {
        return this._$$loserId;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final String getMetaLynxData() {
        return this._$$metaLynxData;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final Map<Long, IMultiTeamInfoFlexImpl> getMultiPkTeam() {
        return this._$$multiPkTeam;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final List<IMvpListInfoFlexImpl> getMvpListInfoList() {
        return this._$$mvpListInfoList;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final int getSkinType() {
        return this._$$skinType;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final String getTeamTaskJson() {
        return this._$$teamTaskJson;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final IBattleDataSettingFlexImpl getBattleSetting() {
        return this._$$battleSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final IBreakthroughInfoFlexImpl getBreakthroughInfo() {
        return this._$$breakthroughInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final IChannelInfoFlexImpl getChannelInfo() {
        return this._$$channelInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final IBattleSkinConfigFlexImpl getSkinConfig() {
        return this._$$skinConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final ISurvivalInfoFlexImpl getSurvivalInfo() {
        return this._$$survivalInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.c3
    public final ITeamTaskFlexImpl getTeamTask() {
        return this._$$teamTask;
    }

    public IBattleStatsMetaFlexImpl(am3.g r18) {
        super(c3.class);
        this._$$battleUserInfoMap = new HashMap();
        this._$$mvpListInfoList = new ArrayList();
        this._$$battleScorePairList = new ArrayList();
        this._$$multiPkTeam = new HashMap();
        setThreadSafe(false);
        long r2 = r18.c();
    L3:
        int r4 = r18.f();
        if (r4 == (-1)) goto L75;
        am3.g.a r7 = decodeExtensionFields(r4, r18);
        if (r4 != 1) goto L8;
        this._$$channelId = r18.j();
        goto L3
    L8:
        if (r4 != 2) goto L10;
        this._$$battleId = r18.j();
        goto L3
    L10:
        if (r4 != 4) goto L12;
        this._$$battleSetting = new IBattleDataSettingFlexImpl(r18);
        goto L3
    L12:
        if (r4 == 5) goto L70;
        if (r4 != 6) goto L16;
        this._$$channelInfo = new IChannelInfoFlexImpl(r18);
        goto L3
    L16:
        if (r4 != 7) goto L17;
        List r5 = this._$$battleScorePairList;
        vh7.h r6 = new IBattleDataScoreFlexImpl(r18);
    L71:
        r5.add(r6);
        goto L3
    L17:
        Object r12 = null;
        if (r4 == 11) goto L52;
        if (r4 != 5000) goto L22;
        this._$$loserId = am3.h.c(r18);
        goto L3
    L22:
        if (r4 != 5001) goto L23;
        long r13 = r18.c();
        Object r8 = null;
    L36:
        int r9 = r18.f();
        if (r9 == (-1)) goto L43;
        if (r9 != 1) goto L39;
        r12 = am3.h.c(r18);
        goto L36
    L39:
        if (r9 != 2) goto L40;
        r8 = new IBattleUserInfoFlexImpl(r18);
        goto L36
    L40:
        am3.h.e(r18);
        goto L36
    L43:
        r18.d(r13);
        Map r10 = this._$$battleUserInfoMap;
        if (r12 == null) goto L50;
        if (r8 == null) goto L48;
    L63:
        r10.put(r12, r8);
        goto L3
    L48:
        throw new IllegalStateException("Value must not be null");
    L50:
        throw new IllegalStateException("Key must not be null");
    L23:
        switch(r4) {
            case 14: goto L34;
            case 15: goto L33;
            case 16: goto L32;
            case 17: goto L31;
            case 18: goto L30;
            default: goto L24;
        };
    L30:
        this._$$breakthroughInfo = new IBreakthroughInfoFlexImpl(r18);
        goto L3
    L31:
        this._$$skinConfig = new IBattleSkinConfigFlexImpl(r18);
        goto L3
    L32:
        this._$$teamTaskJson = am3.h.c(r18);
        goto L3
    L33:
        this._$$teamTask = new ITeamTaskFlexImpl(r18);
        goto L3
    L34:
        this._$$skinType = r18.i();
        goto L3
    L24:
        switch(r4) {
            case 20: goto L29;
            case 21: goto L28;
            case 22: goto L27;
            case 23: goto L26;
            default: goto L25;
        };
    L26:
        this._$$metaLynxData = am3.h.c(r18);
        goto L3
    L27:
        this._$$eventTrackingInfo = am3.h.c(r18);
        goto L3
    L28:
        this._$$battleEffectInfo = am3.h.c(r18);
        goto L3
    L29:
        this._$$survivalInfo = new ISurvivalInfoFlexImpl(r18);
        goto L3
    L25:
        am3.h.d(r7, r18);
        goto L3
    L52:
        long r14 = r18.c();
        r8 = null;
    L53:
        int r11 = r18.f();
        if (r11 == (-1)) goto L60;
        if (r11 != 1) goto L56;
        r12 = Long.valueOf(r18.j());
        goto L53
    L56:
        if (r11 != 2) goto L57;
        r8 = new IMultiTeamInfoFlexImpl(r18);
        goto L53
    L57:
        am3.h.e(r18);
        goto L53
    L60:
        r18.d(r14);
        r10 = this._$$multiPkTeam;
        if (r12 == null) goto L67;
        if (r8 != null) goto L63;
        throw new IllegalStateException("Value must not be null");
    L67:
        throw new IllegalStateException("Key must not be null");
    L70:
        r5 = this._$$mvpListInfoList;
        r6 = new IMvpListInfoFlexImpl(r18);
        goto L71
    L75:
        r18.d(r2);
        setThreadSafe(true);
        if (this._$$loserId != null) goto L79;
        this._$$loserId = "";
    L79:
        if (this._$$teamTaskJson != null) goto L82;
        this._$$teamTaskJson = "";
    L82:
        if (this._$$battleEffectInfo != null) goto L85;
        this._$$battleEffectInfo = "";
    L85:
        if (this._$$metaLynxData != null) goto L88;
        this._$$metaLynxData = "";
    L88:
        if (this._$$eventTrackingInfo != null) goto L159;
        this._$$eventTrackingInfo = "";
        return;
    }
}
