package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.im.PrecisionMatch")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b(\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bI\u0010JR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\"\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007R\u001b\u0010'\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010&R\u001b\u0010*\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\u0007R\u001d\u0010-\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007R\u001b\u00100\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0015R\u001b\u00103\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\u0007R\u001b\u00106\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010&R\u001b\u00109\u001a\u00020\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0005\u001a\u0004\b8\u0010\u0015R\u001b\u0010<\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b:\u0010\u0005\u001a\u0004\b;\u0010\u0007R\u001b\u0010?\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u0005\u001a\u0004\b>\u0010\u0007R\u001b\u0010B\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\u0005\u001a\u0004\bA\u0010\u0007R\u001b\u0010E\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0005\u001a\u0004\bD\u0010\u0007R!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0005\u001a\u0004\bG\u0010\r¨\u0006K"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatchFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/d2;", "", "sponsorId$delegate", "Ljava/lang/Object;", "getSponsorId", "()Ljava/lang/String;", "sponsorId", "", "Lcom/bytedance/android/livesdk/link/model/IBattlePrecisionMatcherFlexImpl;", "matcherList$delegate", "getMatcherList", "()Ljava/util/List;", "matcherList", "matchReason$delegate", "getMatchReason", "matchReason", "", "waitSeconds$delegate", "getWaitSeconds", "()J", "waitSeconds", "precisionMatchId$delegate", "getPrecisionMatchId", "precisionMatchId", "activityName$delegate", "getActivityName", "activityName", "recommendReason$delegate", "getRecommendReason", "recommendReason", "signExtra$delegate", "getSignExtra", "signExtra", "", "source$delegate", "getSource", "()I", "source", "notDisturbText$delegate", "getNotDisturbText", "notDisturbText", "activityId$delegate", "getActivityId", "activityId", "duration$delegate", "getDuration", "duration", "battleAttachedInfo$delegate", "getBattleAttachedInfo", "battleAttachedInfo", "playMode$delegate", "getPlayMode", "playMode", "defaultRespondType$delegate", "getDefaultRespondType", "defaultRespondType", "toastContent$delegate", "getToastContent", "toastContent", "title$delegate", "getTitle", "title", "subTitle$delegate", "getSubTitle", "subTitle", "battleRule$delegate", "getBattleRule", "battleRule", "autoAcceptAnchorIdList$delegate", "getAutoAcceptAnchorIdList", "autoAcceptAnchorIdList", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattlePrecisionMatchFlexImpl extends FlexModelBase<d2> implements d2, vh7.h {

    @SerializedName("activity_id")
    protected String _$$activityId;

    @SerializedName("activity_name")
    protected String _$$activityName;

    @SerializedName("auto_accept_anchor_id_list")
    protected List<String> _$$autoAcceptAnchorIdList;

    @SerializedName("battle_attached_info")
    protected String _$$battleAttachedInfo;

    @SerializedName("cur_battle_rule")
    protected String _$$battleRule;

    @SerializedName("default_respond_type")
    protected long _$$defaultRespondType;

    @SerializedName("duration")
    protected long _$$duration;

    @SerializedName("match_reason")
    protected String _$$matchReason;

    @SerializedName("matchers")
    protected List<IBattlePrecisionMatcherFlexImpl> _$$matcherList;

    @SerializedName("not_disturb_text")
    protected String _$$notDisturbText;

    @SerializedName("play_mode")
    protected int _$$playMode;

    @SerializedName("precision_match_id")
    protected long _$$precisionMatchId;

    @SerializedName("recommend_reason")
    protected String _$$recommendReason;

    @SerializedName("sign_extra")
    protected String _$$signExtra;

    @SerializedName("source")
    protected int _$$source;

    @SerializedName("sponsor_open_id")
    protected String _$$sponsorId;

    @SerializedName("sub_title")
    protected String _$$subTitle;

    @SerializedName("title")
    protected String _$$title;

    @SerializedName("toast_content")
    protected String _$$toastContent;

    @SerializedName("wait_seconds")
    protected long _$$waitSeconds;

    public IBattlePrecisionMatchFlexImpl() {
        super(d2.class);
        this._$$matcherList = $defaultValue_matcherList$();
        this._$$matchReason = "";
        this._$$activityName = "";
        this._$$recommendReason = "";
        this._$$signExtra = "";
        this._$$notDisturbText = "";
        this._$$battleAttachedInfo = "";
        this._$$toastContent = "";
        this._$$title = "";
        this._$$subTitle = "";
        this._$$battleRule = "";
        this._$$autoAcceptAnchorIdList = $defaultValue_autoAcceptAnchorIdList$();
    }

    public final List<String> $defaultValue_autoAcceptAnchorIdList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<IBattlePrecisionMatcherFlexImpl> $defaultValue_matcherList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getActivityId() {
        return this._$$activityId;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getActivityName() {
        return this._$$activityName;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final List<String> getAutoAcceptAnchorIdList() {
        return this._$$autoAcceptAnchorIdList;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getBattleAttachedInfo() {
        return this._$$battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getBattleRule() {
        return this._$$battleRule;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final long getDefaultRespondType() {
        return this._$$defaultRespondType;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final long getDuration() {
        return this._$$duration;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getMatchReason() {
        return this._$$matchReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final List<IBattlePrecisionMatcherFlexImpl> getMatcherList() {
        return this._$$matcherList;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getNotDisturbText() {
        return this._$$notDisturbText;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final int getPlayMode() {
        return this._$$playMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final long getPrecisionMatchId() {
        return this._$$precisionMatchId;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getRecommendReason() {
        return this._$$recommendReason;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getSignExtra() {
        return this._$$signExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final int getSource() {
        return this._$$source;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getSponsorId() {
        return this._$$sponsorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getTitle() {
        return this._$$title;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final String getToastContent() {
        return this._$$toastContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.d2
    public final long getWaitSeconds() {
        return this._$$waitSeconds;
    }

    public IBattlePrecisionMatchFlexImpl(am3.g r6) {
        super(d2.class);
        this._$$matcherList = new ArrayList();
        this._$$autoAcceptAnchorIdList = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L35;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 12) goto L8;
        this._$$duration = r6.j();
        goto L3
    L8:
        if (r2 != 13) goto L10;
        this._$$battleAttachedInfo = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 5000) goto L11;
        this._$$sponsorId = am3.h.c(r6);
        goto L3
    L11:
        switch(r2) {
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            default: goto L12;
        };
    L22:
        this._$$notDisturbText = am3.h.c(r6);
        goto L3
    L23:
        this._$$source = r6.i();
        goto L3
    L24:
        this._$$signExtra = am3.h.c(r6);
        goto L3
    L25:
        this._$$recommendReason = am3.h.c(r6);
        goto L3
    L26:
        this._$$activityName = am3.h.c(r6);
        goto L3
    L27:
        this._$$precisionMatchId = r6.j();
        goto L3
    L28:
        this._$$waitSeconds = r6.j();
        goto L3
    L29:
        this._$$matchReason = am3.h.c(r6);
        goto L3
    L30:
        List r4 = this._$$matcherList;
        Object r5 = new IBattlePrecisionMatcherFlexImpl(r6);
    L31:
        r4.add(r5);
        goto L3
    L12:
        switch(r2) {
            case 15: goto L21;
            case 16: goto L20;
            case 17: goto L19;
            case 18: goto L18;
            case 19: goto L17;
            case 20: goto L16;
            case 21: goto L15;
            case 22: goto L14;
            default: goto L13;
        };
    L14:
        r4 = this._$$autoAcceptAnchorIdList;
        r5 = am3.h.c(r6);
        goto L31
    L15:
        this._$$battleRule = am3.h.c(r6);
        goto L3
    L16:
        this._$$subTitle = am3.h.c(r6);
        goto L3
    L17:
        this._$$title = am3.h.c(r6);
        goto L3
    L18:
        this._$$toastContent = am3.h.c(r6);
        goto L3
    L19:
        this._$$defaultRespondType = r6.j();
        goto L3
    L20:
        this._$$playMode = r6.i();
        goto L3
    L21:
        this._$$activityId = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L35:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$matcherList.isEmpty() == false) goto L39;
        this._$$matcherList = $defaultValue_matcherList$();
    L39:
        if (this._$$matchReason != null) goto L42;
        this._$$matchReason = "";
    L42:
        if (this._$$activityName != null) goto L45;
        this._$$activityName = "";
    L45:
        if (this._$$recommendReason != null) goto L48;
        this._$$recommendReason = "";
    L48:
        if (this._$$signExtra != null) goto L51;
        this._$$signExtra = "";
    L51:
        if (this._$$notDisturbText != null) goto L54;
        this._$$notDisturbText = "";
    L54:
        if (this._$$battleAttachedInfo != null) goto L57;
        this._$$battleAttachedInfo = "";
    L57:
        if (this._$$toastContent != null) goto L60;
        this._$$toastContent = "";
    L60:
        if (this._$$title != null) goto L63;
        this._$$title = "";
    L63:
        if (this._$$subTitle != null) goto L66;
        this._$$subTitle = "";
    L66:
        if (this._$$battleRule != null) goto L69;
        this._$$battleRule = "";
    L69:
        if (this._$$autoAcceptAnchorIdList.isEmpty() == false) goto L119;
        this._$$autoAcceptAnchorIdList = $defaultValue_autoAcceptAnchorIdList$();
        return;
    }
}
