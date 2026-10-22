package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.RankSeasonInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010:R\"\u0010\u0004\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\r\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\f\u001a\u0004\b'\u0010$R\u001d\u0010+\u001a\u0004\u0018\u00010!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\f\u001a\u0004\b*\u0010$R\u001b\u00100\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010/R\u001b\u00103\u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b2\u0010$R\u001b\u00108\u001a\u0002048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\f\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalRankSeasonInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/s8;", "Lpy/k;", "bgImg", "Lpy/k;", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "", "isUnlockedRank$delegate", "Ljava/lang/Object;", "isUnlockedRank", "()Z", "enableTab$delegate", "getEnableTab", "enableTab", "Lcom/bytedance/android/livesdk/link/model/IRankInfoFlexImpl;", "rankInfo$delegate", "getRankInfo", "()Lcom/bytedance/android/livesdk/link/model/IRankInfoFlexImpl;", "rankInfo", "Lcom/bytedance/android/livesdk/link/model/IQualifyInfoFlexImpl;", "qualifyInfo$delegate", "getQualifyInfo", "()Lcom/bytedance/android/livesdk/link/model/IQualifyInfoFlexImpl;", "qualifyInfo", "Lcom/bytedance/android/livesdk/link/model/IScoreInfoFlexImpl;", "scoreInfo$delegate", "getScoreInfo", "()Lcom/bytedance/android/livesdk/link/model/IScoreInfoFlexImpl;", "scoreInfo", "", "ruleSchema$delegate", "getRuleSchema", "()Ljava/lang/String;", "ruleSchema", "rankSchema$delegate", "getRankSchema", "rankSchema", "unLockTxt$delegate", "getUnLockTxt", "unLockTxt", "", "seasonStatus$delegate", "getSeasonStatus", "()I", "seasonStatus", "buttonText$delegate", "getButtonText", "buttonText", "Lcom/bytedance/android/livesdk/link/model/IRankSeasonInfoButtonFlexImpl;", "button$delegate", "getButton", "()Lcom/bytedance/android/livesdk/link/model/IRankSeasonInfoButtonFlexImpl;", "button", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRivalRankSeasonInfoFlexImpl extends FlexModelBase<s8> implements s8, vh7.h {

    @SerializedName("button")
    protected IRankSeasonInfoButtonFlexImpl _$$button;

    @SerializedName("button_text")
    protected String _$$buttonText;

    @SerializedName("enable_season_tab")
    protected boolean _$$enableTab;

    @SerializedName("is_unlocked_rank")
    protected boolean _$$isUnlockedRank;

    @SerializedName("qualify_info")
    protected IQualifyInfoFlexImpl _$$qualifyInfo;

    @SerializedName("rank_info")
    protected IRankInfoFlexImpl _$$rankInfo;

    @SerializedName("detail_scheme")
    protected String _$$rankSchema;

    @SerializedName("rule_scheme")
    protected String _$$ruleSchema;

    @SerializedName("score_info")
    protected IScoreInfoFlexImpl _$$scoreInfo;

    @SerializedName("season_status")
    protected int _$$seasonStatus;

    @SerializedName("unlocked_content")
    protected String _$$unLockTxt;

    @SerializedName("bg_img")
    protected py.k bgImg;

    public IRivalRankSeasonInfoFlexImpl() {
        super(s8.class);
        this._$$isUnlockedRank = false;
        this._$$enableTab = false;
        this._$$ruleSchema = "";
        this._$$rankSchema = "";
        this._$$buttonText = "";
        this.bgImg = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
        this._$$button = $defaultValue_button$();
    }

    public final IRankSeasonInfoButtonFlexImpl $defaultValue_button$() {
        return (IRankSeasonInfoButtonFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IRankSeasonInfoButtonFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public /* bridge */ /* synthetic */ h8 getButton() {
        return getButton();
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public /* bridge */ /* synthetic */ f8 getQualifyInfo() {
        return getQualifyInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public /* bridge */ /* synthetic */ g8 getRankInfo() {
        return getRankInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public /* bridge */ /* synthetic */ d9 getScoreInfo() {
        return getScoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public py.k getBgImg() {
        return this.bgImg;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final String getButtonText() {
        return this._$$buttonText;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final boolean getEnableTab() {
        return this._$$enableTab;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final String getRankSchema() {
        return this._$$rankSchema;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final String getRuleSchema() {
        return this._$$ruleSchema;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final int getSeasonStatus() {
        return this._$$seasonStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final String getUnLockTxt() {
        return this._$$unLockTxt;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final boolean isUnlockedRank() {
        return this._$$isUnlockedRank;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final IRankSeasonInfoButtonFlexImpl getButton() {
        return this._$$button;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final IQualifyInfoFlexImpl getQualifyInfo() {
        return this._$$qualifyInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final IRankInfoFlexImpl getRankInfo() {
        return this._$$rankInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.s8
    public final IScoreInfoFlexImpl getScoreInfo() {
        return this._$$scoreInfo;
    }

    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object, py.k] */
    public IRivalRankSeasonInfoFlexImpl(am3.g r7) {
        super(s8.class);
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L20;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            case 11: goto L9;
            case 12: goto L7;
            case 13: goto L8;
            default: goto L7;
        };
    L8:
        this._$$button = new IRankSeasonInfoButtonFlexImpl(r7);
        goto L3
    L9:
        this._$$enableTab = am3.h.a(r7);
        r3 = r3 | 2;
        goto L3
    L10:
        this._$$unLockTxt = am3.h.c(r7);
        goto L3
    L11:
        this._$$rankSchema = am3.h.c(r7);
        goto L3
    L12:
        this.bgImg = vh7.f.a(r7, py.k.class);
        goto L3
    L13:
        this._$$buttonText = am3.h.c(r7);
        goto L3
    L14:
        this._$$scoreInfo = new IScoreInfoFlexImpl(r7);
        goto L3
    L15:
        this._$$seasonStatus = r7.i();
        r3 = r3 | 4;
        goto L3
    L16:
        this._$$ruleSchema = am3.h.c(r7);
        goto L3
    L17:
        this._$$qualifyInfo = new IQualifyInfoFlexImpl(r7);
        goto L3
    L18:
        this._$$rankInfo = new IRankInfoFlexImpl(r7);
        goto L3
    L19:
        this._$$isUnlockedRank = am3.h.a(r7);
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L20:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 1) != 0) goto L24;
        this._$$isUnlockedRank = false;
    L24:
        if ((r3 & 2) != 0) goto L27;
        this._$$enableTab = false;
    L27:
        if (this._$$ruleSchema != null) goto L30;
        this._$$ruleSchema = "";
    L30:
        if (this._$$rankSchema != null) goto L33;
        this._$$rankSchema = "";
    L33:
        if (this._$$buttonText != null) goto L36;
        this._$$buttonText = "";
    L36:
        if (this.bgImg != null) goto L39;
        this.bgImg = (py.k) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(py.k.class);
    L39:
        if (this._$$button != null) goto L70;
        this._$$button = $defaultValue_button$();
        return;
    }

    public void setBgImg(py.k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bgImg = r2;
    }
}
