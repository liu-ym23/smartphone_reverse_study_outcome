package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleScore")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0019\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bF\u0010GR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR+\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0018R+\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u0018R\u001b\u0010 \u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0011R\u001b\u0010#\u001a\u00020\r8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0011R\u001d\u0010(\u001a\u0004\u0018\u00010$8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010\fR\u001b\u0010.\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\fR\u001b\u00103\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u00102R\u001b\u00106\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\fR\u001b\u00109\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0007R\u001b\u0010<\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0005\u001a\u0004\b;\u00102R\u001b\u0010?\u001a\u00020/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u00102R\u001b\u0010A\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0005\u001a\u0004\bA\u0010\fR\u001d\u0010E\u001a\u0004\u0018\u00010/8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bB\u0010\u0005\u001a\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleDataScoreFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/a1;", "", "userId$delegate", "Ljava/lang/Object;", "getUserId", "()Ljava/lang/String;", "userId", "", "isHugeRewardPk$delegate", "isHugeRewardPk", "()Z", "", "<set-?>", "score$delegate", "getScore", "()I", "setScore", "(I)V", "score", "scoreText$delegate", "getScoreText", "setScoreText", "(Ljava/lang/String;)V", "scoreText", "scoreRelativeText$delegate", "getScoreRelativeText", "setScoreRelativeText", "scoreRelativeText", "bonus$delegate", "getBonus", "bonus", "rank$delegate", "getRank", "rank", "Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeFlexImpl;", "grade$delegate", "getGrade", "()Lcom/bytedance/android/livesdk/link/model/IBattleStarActivityGradeFlexImpl;", "grade", "scoreRelative$delegate", "getScoreRelative", "scoreRelative", "roomLikeTrigger$delegate", "getRoomLikeTrigger", "roomLikeTrigger", "", "battleRank$delegate", "getBattleRank", "()J", "battleRank", "newScoreOpen$delegate", "getNewScoreOpen", "newScoreOpen", "multiPkTeamScoreText$delegate", "getMultiPkTeamScoreText", "multiPkTeamScoreText", "multiPkTeamScore$delegate", "getMultiPkTeamScore", "multiPkTeamScore", "multiPkTeamRank$delegate", "getMultiPkTeamRank", "multiPkTeamRank", "isMultiPkTeamRelativeText$delegate", "isMultiPkTeamRelativeText", "scoreVersion$delegate", "getScoreVersion", "()Ljava/lang/Long;", "scoreVersion", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleDataScoreFlexImpl extends FlexModelBase<a1> implements a1, vh7.h {

    @SerializedName("battle_rank")
    protected long _$$battleRank;

    @SerializedName("rank_bonus_score")
    protected int _$$bonus;

    @SerializedName("grade")
    protected IBattleStarActivityGradeFlexImpl _$$grade;

    @SerializedName("is_large_pk_score")
    protected boolean _$$isHugeRewardPk;

    @SerializedName("is_multi_pk_relative_text")
    protected boolean _$$isMultiPkTeamRelativeText;

    @SerializedName("multi_pk_team_rank")
    protected long _$$multiPkTeamRank;

    @SerializedName("multi_pk_team_score")
    protected long _$$multiPkTeamScore;

    @SerializedName("multi_pk_team_score_text")
    protected String _$$multiPkTeamScoreText;

    @SerializedName("new_score_open")
    protected boolean _$$newScoreOpen;

    @SerializedName("weekly_rank")
    protected int _$$rank;

    @SerializedName("room_like_trigger")
    protected boolean _$$roomLikeTrigger;

    @SerializedName("score")
    protected int _$$score;

    @SerializedName("score_relative")
    protected boolean _$$scoreRelative;

    @SerializedName("score_relative_text")
    protected String _$$scoreRelativeText;

    @SerializedName("score_blur_text")
    protected String _$$scoreText;

    @SerializedName("score_version")
    protected Long _$$scoreVersion;

    @SerializedName("open_id")
    protected String _$$userId;

    public IBattleDataScoreFlexImpl() {
        super(a1.class);
        this._$$userId = "";
        this._$$isHugeRewardPk = false;
        this._$$scoreText = "";
        this._$$scoreRelativeText = "";
        this._$$scoreRelative = false;
        this._$$roomLikeTrigger = false;
        this._$$newScoreOpen = false;
        this._$$multiPkTeamScoreText = "";
        this._$$isMultiPkTeamRelativeText = false;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public /* bridge */ /* synthetic */ y2 getGrade() {
        return getGrade();
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final long getBattleRank() {
        return this._$$battleRank;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final int getBonus() {
        return this._$$bonus;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final long getMultiPkTeamRank() {
        return this._$$multiPkTeamRank;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final long getMultiPkTeamScore() {
        return this._$$multiPkTeamScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final String getMultiPkTeamScoreText() {
        return this._$$multiPkTeamScoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final boolean getNewScoreOpen() {
        return this._$$newScoreOpen;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final int getRank() {
        return this._$$rank;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final boolean getRoomLikeTrigger() {
        return this._$$roomLikeTrigger;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final int getScore() {
        return this._$$score;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final boolean getScoreRelative() {
        return this._$$scoreRelative;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final String getScoreRelativeText() {
        return this._$$scoreRelativeText;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final String getScoreText() {
        return this._$$scoreText;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final Long getScoreVersion() {
        return this._$$scoreVersion;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final String getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final boolean isHugeRewardPk() {
        return this._$$isHugeRewardPk;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1, af2.b
    public final boolean isMultiPkTeamRelativeText() {
        return this._$$isMultiPkTeamRelativeText;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final IBattleStarActivityGradeFlexImpl getGrade() {
        return this._$$grade;
    }

    public IBattleDataScoreFlexImpl(am3.g r8) {
        super(a1.class);
        setThreadSafe(false);
        long r1 = r8.c();
        int r3 = 0;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L34;
        am3.g.a r5 = decodeExtensionFields(r4, r8);
        if (r4 != 1) goto L8;
        this._$$score = r8.i();
        r3 = r3 | 2;
        goto L3
    L8:
        if (r4 != 24) goto L10;
        this._$$scoreVersion = Long.valueOf(r8.j());
        goto L3
    L10:
        if (r4 != 5000) goto L12;
        this._$$userId = am3.h.c(r8);
        goto L3
    L12:
        if (r4 != 3) goto L14;
        this._$$bonus = r8.i();
        r3 = r3 | 4;
        goto L3
    L14:
        if (r4 != 4) goto L15;
        this._$$rank = r8.i();
        r3 = r3 | 8;
        goto L3
    L15:
        switch(r4) {
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L23;
            case 16: goto L22;
            case 17: goto L21;
            case 18: goto L20;
            case 19: goto L19;
            case 20: goto L18;
            case 21: goto L17;
            default: goto L16;
        };
    L17:
        this._$$isMultiPkTeamRelativeText = am3.h.a(r8);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
        goto L3
    L18:
        this._$$multiPkTeamRank = r8.j();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
        goto L3
    L19:
        this._$$multiPkTeamScore = r8.j();
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
        goto L3
    L20:
        this._$$multiPkTeamScoreText = am3.h.c(r8);
        goto L3
    L21:
        this._$$newScoreOpen = am3.h.a(r8);
        r3 = r3 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        goto L3
    L22:
        this._$$battleRank = r8.j();
        r3 = r3 | 64;
        goto L3
    L23:
        this._$$scoreText = am3.h.c(r8);
        goto L3
    L24:
        this._$$roomLikeTrigger = am3.h.a(r8);
        r3 = r3 | 32;
        goto L3
    L25:
        this._$$isHugeRewardPk = am3.h.a(r8);
        r3 = r3 | 1;
        goto L3
    L26:
        this._$$scoreRelativeText = am3.h.c(r8);
        goto L3
    L27:
        this._$$scoreRelative = am3.h.a(r8);
        r3 = r3 | 16;
        goto L3
    L28:
        this._$$grade = new IBattleStarActivityGradeFlexImpl(r8);
        goto L3
    L16:
        am3.h.d(r5, r8);
        goto L3
    L34:
        r8.d(r1);
        setThreadSafe(true);
        if (this._$$userId != null) goto L38;
        this._$$userId = "";
    L38:
        if ((r3 & 1) != 0) goto L41;
        this._$$isHugeRewardPk = false;
    L41:
        if (this._$$scoreText != null) goto L44;
        this._$$scoreText = "";
    L44:
        if (this._$$scoreRelativeText != null) goto L47;
        this._$$scoreRelativeText = "";
    L47:
        if ((r3 & 16) != 0) goto L50;
        this._$$scoreRelative = false;
    L50:
        if ((r3 & 32) != 0) goto L53;
        this._$$roomLikeTrigger = false;
    L53:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L56;
        this._$$newScoreOpen = false;
    L56:
        if (this._$$multiPkTeamScoreText != null) goto L59;
        this._$$multiPkTeamScoreText = "";
    L59:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L105;
        this._$$isMultiPkTeamRelativeText = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final void setScore(int r1) {
        this._$$score = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final void setScoreRelativeText(String r1) {
        this._$$scoreRelativeText = r1;
    }

    @Override // com.bytedance.android.livesdk.link.model.a1
    public final void setScoreText(String r1) {
        this._$$scoreText = r1;
    }
}
