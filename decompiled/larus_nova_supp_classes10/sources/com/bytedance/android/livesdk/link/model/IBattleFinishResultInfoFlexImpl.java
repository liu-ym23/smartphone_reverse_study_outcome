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
@ProtoMessage("webcast.im.LinkMicBattleFinish")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b:\u0010;R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010%\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u0004\u0018\u00010&8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0005\u001a\u0004\b(\u0010)R\u001d\u0010/\u001a\u0004\u0018\u00010+8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010.R)\u00105\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u000201\u0018\u0001008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0005\u001a\u0004\b3\u00104R)\u00109\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u000206\u0018\u0001008VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u00104¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleFinishResultInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/g1;", "Lcom/bytedance/android/livesdk/link/model/IBattleMessageSettingFlexImpl;", "battleSetting$delegate", "Ljava/lang/Object;", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleMessageSettingFlexImpl;", "battleSetting", "", "Lcom/bytedance/android/livesdk/link/model/IBattleDataScoreFlexImpl;", "battleScorePairList$delegate", "getBattleScorePairList", "()Ljava/util/List;", "battleScorePairList", "", "endReason$delegate", "getEndReason", "()I", "endReason", "Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "breakthroughInfo$delegate", "getBreakthroughInfo", "()Lcom/bytedance/android/livesdk/link/model/IBreakthroughInfoFlexImpl;", "breakthroughInfo", "Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "skinConfig$delegate", "getSkinConfig", "()Lcom/bytedance/android/livesdk/link/model/IBattleSkinConfigFlexImpl;", "skinConfig", "skinType$delegate", "getSkinType", "skinType", "", "eventTrackingInfo$delegate", "getEventTrackingInfo", "()Ljava/lang/String;", "eventTrackingInfo", "Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoFlexImpl;", "survivalInfo$delegate", "getSurvivalInfo", "()Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoFlexImpl;", "survivalInfo", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleFinishExtraFlexImpl;", "finishExtra$delegate", "getFinishExtra", "()Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleFinishExtraFlexImpl;", "finishExtra", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfoFlexImpl;", "battleUserInfoMap$delegate", "getBattleUserInfoMap", "()Ljava/util/Map;", "battleUserInfoMap", "Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeChangeFlexImpl;", "gradeChanges$delegate", "getGradeChanges", "gradeChanges", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleFinishResultInfoFlexImpl extends FlexModelBase<g1> implements g1, vh7.h {

    @SerializedName("battle_scores")
    protected List<IBattleDataScoreFlexImpl> _$$battleScorePairList;

    @SerializedName("battle_settings")
    protected IBattleMessageSettingFlexImpl _$$battleSetting;

    @SerializedName("open_user_infos")
    protected Map<String, IBattleUserInfoFlexImpl> _$$battleUserInfoMap;

    @SerializedName("breakthrough_info")
    protected IBreakthroughInfoFlexImpl _$$breakthroughInfo;

    @SerializedName("end_reason")
    protected int _$$endReason;

    @SerializedName("event_tracking_info")
    protected String _$$eventTrackingInfo;

    @SerializedName("extra")
    protected ILinkMicBattleFinishExtraFlexImpl _$$finishExtra;

    @SerializedName("open_grade_changes")
    protected Map<String, IBattleStarActivityGradeChangeFlexImpl> _$$gradeChanges;

    @SerializedName("skin_config")
    protected IBattleSkinConfigFlexImpl _$$skinConfig;

    @SerializedName("skin_type")
    protected int _$$skinType;

    @SerializedName("survival_info")
    protected ISurvivalInfoFlexImpl _$$survivalInfo;

    public IBattleFinishResultInfoFlexImpl() {
        super(g1.class);
        this._$$battleScorePairList = $defaultValue_battleScorePairList$();
        this._$$eventTrackingInfo = "";
    }

    public final List<IBattleDataScoreFlexImpl> $defaultValue_battleScorePairList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public /* bridge */ /* synthetic */ u1 getBattleSetting() {
        return getBattleSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public /* bridge */ /* synthetic */ n3 getBreakthroughInfo() {
        return getBreakthroughInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public /* bridge */ /* synthetic */ z4 getFinishExtra() {
        return getFinishExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public /* bridge */ /* synthetic */ x2 getSkinConfig() {
        return getSkinConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public /* bridge */ /* synthetic */ l9 getSurvivalInfo() {
        return getSurvivalInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final List<IBattleDataScoreFlexImpl> getBattleScorePairList() {
        return this._$$battleScorePairList;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final Map<String, IBattleUserInfoFlexImpl> getBattleUserInfoMap() {
        return this._$$battleUserInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final int getEndReason() {
        return this._$$endReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final String getEventTrackingInfo() {
        return this._$$eventTrackingInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final Map<String, IBattleStarActivityGradeChangeFlexImpl> getGradeChanges() {
        return this._$$gradeChanges;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final int getSkinType() {
        return this._$$skinType;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final IBattleMessageSettingFlexImpl getBattleSetting() {
        return this._$$battleSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final IBreakthroughInfoFlexImpl getBreakthroughInfo() {
        return this._$$breakthroughInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final ILinkMicBattleFinishExtraFlexImpl getFinishExtra() {
        return this._$$finishExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final IBattleSkinConfigFlexImpl getSkinConfig() {
        return this._$$skinConfig;
    }

    @Override // com.bytedance.android.livesdk.link.model.g1
    public final ISurvivalInfoFlexImpl getSurvivalInfo() {
        return this._$$survivalInfo;
    }

    public IBattleFinishResultInfoFlexImpl(am3.g r14) {
        super(g1.class);
        this._$$battleScorePairList = new ArrayList();
        this._$$battleUserInfoMap = new HashMap();
        this._$$gradeChanges = new HashMap();
        setThreadSafe(false);
        long r0 = r14.c();
    L3:
        int r2 = r14.f();
        if (r2 == (-1)) goto L60;
        am3.g.a r5 = decodeExtensionFields(r2, r14);
        if (r2 != 2) goto L8;
        this._$$battleSetting = new IBattleMessageSettingFlexImpl(r14);
        goto L3
    L8:
        if (r2 != 4) goto L10;
        this._$$battleScorePairList.add(new IBattleDataScoreFlexImpl(r14));
        goto L3
    L10:
        if (r2 != 8) goto L12;
        this._$$endReason = r14.i();
        goto L3
    L12:
        if (r2 != 20) goto L13;
        this._$$finishExtra = new ILinkMicBattleFinishExtraFlexImpl(r14);
        goto L3
    L13:
        String r10 = null;
        if (r2 == 5000) goto L40;
        if (r2 != 5001) goto L17;
        long r11 = r14.c();
        Object r3 = null;
    L25:
        int r6 = r14.f();
        if (r6 == (-1)) goto L32;
        if (r6 != 1) goto L28;
        r10 = am3.h.c(r14);
        goto L25
    L28:
        if (r6 != 2) goto L29;
        r3 = new IBattleStarActivityGradeChangeFlexImpl(r14);
        goto L25
    L29:
        am3.h.e(r14);
        goto L25
    L32:
        r14.d(r11);
        Map r4 = this._$$gradeChanges;
        if (r10 == null) goto L39;
        if (r3 == null) goto L37;
    L51:
        r4.put(r10, r3);
        goto L3
    L37:
        throw new IllegalStateException("Value must not be null");
    L39:
        throw new IllegalStateException("Key must not be null");
    L17:
        switch(r2) {
            case 14: goto L23;
            case 15: goto L22;
            case 16: goto L21;
            case 17: goto L20;
            case 18: goto L19;
            default: goto L18;
        };
    L19:
        this._$$eventTrackingInfo = am3.h.c(r14);
        goto L3
    L20:
        this._$$survivalInfo = new ISurvivalInfoFlexImpl(r14);
        goto L3
    L21:
        this._$$skinType = r14.i();
        goto L3
    L22:
        this._$$skinConfig = new IBattleSkinConfigFlexImpl(r14);
        goto L3
    L23:
        this._$$breakthroughInfo = new IBreakthroughInfoFlexImpl(r14);
        goto L3
    L18:
        am3.h.d(r5, r14);
        goto L3
    L40:
        long r12 = r14.c();
        r3 = null;
    L41:
        int r7 = r14.f();
        if (r7 == (-1)) goto L48;
        if (r7 != 1) goto L44;
        r10 = am3.h.c(r14);
        goto L41
    L44:
        if (r7 != 2) goto L45;
        r3 = new IBattleUserInfoFlexImpl(r14);
        goto L41
    L45:
        am3.h.e(r14);
        goto L41
    L48:
        r14.d(r12);
        r4 = this._$$battleUserInfoMap;
        if (r10 == null) goto L55;
        if (r3 != null) goto L51;
        throw new IllegalStateException("Value must not be null");
    L55:
        throw new IllegalStateException("Key must not be null");
    L60:
        r14.d(r0);
        setThreadSafe(true);
        if (this._$$battleScorePairList.isEmpty() == false) goto L64;
        this._$$battleScorePairList = $defaultValue_battleScorePairList$();
    L64:
        if (this._$$eventTrackingInfo != null) goto L119;
        this._$$eventTrackingInfo = "";
        return;
    }
}
