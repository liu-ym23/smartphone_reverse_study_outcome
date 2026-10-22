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
@ProtoMessage("webcast.api.battle.BattleStatsResult.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b?\u0010@R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R'\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\"R#\u0010'\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\"R\u001b\u0010,\u001a\u00020(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010+R\u001d\u00101\u001a\u0004\u0018\u00010-8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u0010\u0007R\u001d\u00109\u001a\u0004\u0018\u0001058VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0005\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0005\u001a\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleStatsResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/e3;", "", "guestId$delegate", "Ljava/lang/Object;", "getGuestId", "()Ljava/lang/String;", "guestId", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "battleUserInfoMap$delegate", "getBattleUserInfoMap", "()Ljava/util/Map;", "battleUserInfoMap", "", "channelId$delegate", "getChannelId", "()J", "channelId", "Lcom/bytedance/android/livesdk/link/model/IChannelInfoFlexImpl;", "channelInfo$delegate", "getChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/IChannelInfoFlexImpl;", "channelInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleDataSettingFlexImpl;", "battleSetting$delegate", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleDataSettingFlexImpl;", "battleSetting", "", "Lcom/bytedance/android/livesdk/link/model/IBattleDataScoreFlexImpl;", "battleScorePairList$delegate", "getBattleScorePairList", "()Ljava/util/List;", "battleScorePairList", "Lcom/bytedance/android/livesdk/link/model/IMvpListInfoFlexImpl;", "mvpListInfoList$delegate", "getMvpListInfoList", "mvpListInfoList", "", "skinType$delegate", "getSkinType", "()I", "skinType", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "teamTask$delegate", "getTeamTask", "()Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "teamTask", "teamTaskJson$delegate", "getTeamTaskJson", "teamTaskJson", "Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "skinConfig$delegate", "getSkinConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "skinConfig", "Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "breakthroughInfo$delegate", "getBreakthroughInfo", "()Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "breakthroughInfo", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleStatsResultFlexImpl extends FlexModelBase<e3> implements e3, vh7.h {

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

    @SerializedName("rival_anchor_open_id")
    protected String _$$guestId;

    @SerializedName("battle_armies")
    protected List<IMvpListInfoFlexImpl> _$$mvpListInfoList;

    @SerializedName("skin_config")
    protected IBattleSkinConfigFlexImpl _$$skinConfig;

    @SerializedName("skin_type")
    protected int _$$skinType;

    @SerializedName("team_task")
    protected ITeamTaskFlexImpl _$$teamTask;

    @SerializedName("team_task_json")
    protected String _$$teamTaskJson;

    public IBattleStatsResultFlexImpl() {
        super(e3.class);
        this._$$battleUserInfoMap = $defaultValue_battleUserInfoMap$();
        this._$$battleScorePairList = $defaultValue_battleScorePairList$();
        this._$$teamTaskJson = "";
    }

    public final List<IBattleDataScoreFlexImpl> $defaultValue_battleScorePairList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final Map<String, IBattleUserInfoFlexImpl> $defaultValue_battleUserInfoMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public /* bridge */ /* synthetic */ c1 getBattleSetting() {
        return getBattleSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public /* bridge */ /* synthetic */ n3 getBreakthroughInfo() {
        return getBreakthroughInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public /* bridge */ /* synthetic */ s3 getChannelInfo() {
        return getChannelInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public /* bridge */ /* synthetic */ x2 getSkinConfig() {
        return getSkinConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public /* bridge */ /* synthetic */ ITeamTask getTeamTask() {
        return getTeamTask();
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final List<IBattleDataScoreFlexImpl> getBattleScorePairList() {
        return this._$$battleScorePairList;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final Map<String, IBattleUserInfoFlexImpl> getBattleUserInfoMap() {
        return this._$$battleUserInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final long getChannelId() {
        return this._$$channelId;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final String getGuestId() {
        return this._$$guestId;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final List<IMvpListInfoFlexImpl> getMvpListInfoList() {
        return this._$$mvpListInfoList;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final int getSkinType() {
        return this._$$skinType;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final String getTeamTaskJson() {
        return this._$$teamTaskJson;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final IBattleDataSettingFlexImpl getBattleSetting() {
        return this._$$battleSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final IBreakthroughInfoFlexImpl getBreakthroughInfo() {
        return this._$$breakthroughInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final IChannelInfoFlexImpl getChannelInfo() {
        return this._$$channelInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final IBattleSkinConfigFlexImpl getSkinConfig() {
        return this._$$skinConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.e3
    public final ITeamTaskFlexImpl getTeamTask() {
        return this._$$teamTask;
    }

    public IBattleStatsResultFlexImpl(am3.g r11) {
        super(e3.class);
        this._$$battleUserInfoMap = new HashMap();
        this._$$battleScorePairList = new ArrayList();
        this._$$mvpListInfoList = new ArrayList();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L58;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 2) goto L8;
        this._$$channelId = r11.j();
        goto L3
    L8:
        if (r2 != 11) goto L10;
        this._$$skinType = r11.i();
        goto L3
    L10:
        if (r2 != 13) goto L12;
        this._$$teamTask = new ITeamTaskFlexImpl(r11);
        goto L3
    L12:
        if (r2 != 15) goto L14;
        this._$$teamTaskJson = am3.h.c(r11);
        goto L3
    L14:
        if (r2 != 4) goto L16;
        this._$$battleSetting = new IBattleDataSettingFlexImpl(r11);
        goto L3
    L16:
        if (r2 == 5) goto L51;
        if (r2 != 6) goto L20;
        this._$$channelInfo = new IChannelInfoFlexImpl(r11);
        goto L3
    L20:
        if (r2 != 7) goto L22;
        List r3 = this._$$battleScorePairList;
        vh7.h r4 = new IBattleDataScoreFlexImpl(r11);
    L52:
        r3.add(r4);
        goto L3
    L22:
        if (r2 != 20) goto L24;
        this._$$skinConfig = new IBattleSkinConfigFlexImpl(r11);
        goto L3
    L24:
        if (r2 != 21) goto L26;
        this._$$breakthroughInfo = new IBreakthroughInfoFlexImpl(r11);
        goto L3
    L26:
        if (r2 != 5001) goto L28;
        this._$$guestId = am3.h.c(r11);
        goto L3
    L28:
        if (r2 != 5002) goto L29;
        long r7 = r11.c();
        String r6 = null;
        IBattleUserInfoFlexImpl r8 = null;
    L31:
        int r9 = r11.f();
        if (r9 == (-1)) goto L38;
        if (r9 != 1) goto L34;
        r6 = am3.h.c(r11);
        goto L31
    L34:
        if (r9 != 2) goto L35;
        r8 = new IBattleUserInfoFlexImpl(r11);
        goto L31
    L35:
        am3.h.e(r11);
        goto L31
    L38:
        r11.d(r7);
        Map<String, IBattleUserInfoFlexImpl> r10 = this._$$battleUserInfoMap;
        if (r6 == null) goto L45;
        if (r8 == null) goto L43;
        r10.put(r6, r8);
        goto L3
    L43:
        throw new IllegalStateException("Value must not be null");
    L45:
        throw new IllegalStateException("Key must not be null");
    L29:
        am3.h.d(r5, r11);
        goto L3
    L51:
        r3 = this._$$mvpListInfoList;
        r4 = new IMvpListInfoFlexImpl(r11);
        goto L52
    L58:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$battleUserInfoMap != null) goto L62;
        this._$$battleUserInfoMap = $defaultValue_battleUserInfoMap$();
    L62:
        if (this._$$battleScorePairList.isEmpty() == false) goto L65;
        this._$$battleScorePairList = $defaultValue_battleScorePairList$();
    L65:
        if (this._$$teamTaskJson != null) goto L116;
        this._$$teamTaskJson = "";
        return;
    }
}
