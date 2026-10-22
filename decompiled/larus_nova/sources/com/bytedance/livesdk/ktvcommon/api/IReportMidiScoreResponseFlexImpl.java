package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@ProtoMessage("webcast.api.ktv.ReportMidiScoreResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b/\u00100R/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00198V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR/\u0010&\u001a\u0004\u0018\u00010 2\b\u0010\u0004\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010*\u001a\u0004\u0018\u00010 2\b\u0010\u0004\u001a\u0004\u0018\u00010 8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R/\u0010.\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018¨\u00061"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/IReportMidiScoreResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/livesdk/ktvcommon/api/b;", "", "<set-?>", "rank$delegate", "Ljava/lang/Object;", "getRank", "()Ljava/lang/Long;", "setRank", "(Ljava/lang/Long;)V", "rank", "Lcom/bytedance/livesdk/ktvcommon/api/c;", "userInfo$delegate", "getUserInfo", "()Lcom/bytedance/livesdk/ktvcommon/api/c;", "setUserInfo", "(Lcom/bytedance/livesdk/ktvcommon/api/c;)V", "userInfo", "", "isHighScoreSinging$delegate", "isHighScoreSinging", "()Ljava/lang/Boolean;", "setHighScoreSinging", "(Ljava/lang/Boolean;)V", "", "highScoreSongThreshold$delegate", "getHighScoreSongThreshold", "()Ljava/lang/Double;", "setHighScoreSongThreshold", "(Ljava/lang/Double;)V", "highScoreSongThreshold", "", "highScoreFeedbackText$delegate", "getHighScoreFeedbackText", "()Ljava/lang/String;", "setHighScoreFeedbackText", "(Ljava/lang/String;)V", "highScoreFeedbackText", "componentNotHighScoreEndingText$delegate", "getComponentNotHighScoreEndingText", "setComponentNotHighScoreEndingText", "componentNotHighScoreEndingText", "ifSingForEnoughTime$delegate", "getIfSingForEnoughTime", "setIfSingForEnoughTime", "ifSingForEnoughTime", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IReportMidiScoreResponseFlexImpl extends FlexModelBase<b> implements b, vh7.h {

    @SerializedName("component_not_high_score_ending_text")
    protected String _$$componentNotHighScoreEndingText;

    @SerializedName("high_score_feedback_text")
    protected String _$$highScoreFeedbackText;

    @SerializedName("high_score_song_threshold")
    protected Double _$$highScoreSongThreshold;

    @SerializedName("if_sing_for_enough_time")
    protected Boolean _$$ifSingForEnoughTime;

    @SerializedName("is_high_score_singing")
    protected Boolean _$$isHighScoreSinging;

    @SerializedName("rank_percent")
    protected Long _$$rank;

    @SerializedName("SingerUserInfo")
    protected c _$$userInfo;

    public IReportMidiScoreResponseFlexImpl() {
        super(b.class);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final String getComponentNotHighScoreEndingText() {
        return this._$$componentNotHighScoreEndingText;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final String getHighScoreFeedbackText() {
        return this._$$highScoreFeedbackText;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final Double getHighScoreSongThreshold() {
        return this._$$highScoreSongThreshold;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final Boolean getIfSingForEnoughTime() {
        return this._$$ifSingForEnoughTime;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final Long getRank() {
        return this._$$rank;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final c getUserInfo() {
        return this._$$userInfo;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final Boolean isHighScoreSinging() {
        return this._$$isHighScoreSinging;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [com.bytedance.livesdk.ktvcommon.api.c, java.lang.Object] */
    public IReportMidiScoreResponseFlexImpl(am3.g r100) {
        super(b.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L27;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$rank = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._$$userInfo = vh7.f.a(r100, c.class);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._$$isHighScoreSinging = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$highScoreSongThreshold = Double.valueOf(Double.longBitsToDouble(r100.h()));
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this._$$highScoreFeedbackText = am3.h.c(r100);
        goto L3
    L16:
        if (r102 != 8) goto L18;
        this._$$componentNotHighScoreEndingText = am3.h.c(r100);
        goto L3
    L18:
        if (r102 != 9) goto L19;
        this._$$ifSingForEnoughTime = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L19:
        am3.h.d(r103, r100);
        goto L3
    L27:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setComponentNotHighScoreEndingText(String r100) {
        this._$$componentNotHighScoreEndingText = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setHighScoreFeedbackText(String r100) {
        this._$$highScoreFeedbackText = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setHighScoreSinging(Boolean r100) {
        this._$$isHighScoreSinging = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setHighScoreSongThreshold(Double r100) {
        this._$$highScoreSongThreshold = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setIfSingForEnoughTime(Boolean r100) {
        this._$$ifSingForEnoughTime = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setRank(Long r100) {
        this._$$rank = r100;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.b
    public final void setUserInfo(c r100) {
        this._$$userInfo = r100;
    }
}
