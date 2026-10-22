package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.RivalExtraInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b6\u00107R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\fR\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010!R\u001b\u0010'\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010&R\u001d\u0010,\u001a\u0004\u0018\u00010(8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0005\u001a\u0004\b*\u0010+R\u001b\u0010/\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0005\u001a\u0004\b.\u0010\u0007R\u001b\u00102\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0005\u001a\u0004\b1\u0010\u0007R\u001b\u00105\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0005\u001a\u0004\b4\u0010\f¨\u00068"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "", "text$delegate", "Ljava/lang/Object;", "getText", "()Ljava/lang/String;", "text", "", "text_type$delegate", "getText_type", "()I", "text_type", "label$delegate", "getLabel", "label", "anchorLayer$delegate", "getAnchorLayer", "anchorLayer", "Lcom/bytedance/android/livesdk/link/model/ILinkerInfoFlexImpl;", "linkerInfo$delegate", "getLinkerInfo", "()Lcom/bytedance/android/livesdk/link/model/ILinkerInfoFlexImpl;", "linkerInfo", "Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicUserSettingsFlexImpl;", "anchorLinkmicUserSettings$delegate", "getAnchorLinkmicUserSettings", "()Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicUserSettingsFlexImpl;", "anchorLinkmicUserSettings", "Lcom/bytedance/android/livesdk/link/model/IAnchorBattleUserSettingsFlexImpl;", "anchorBattleSetting$delegate", "getAnchorBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/IAnchorBattleUserSettingsFlexImpl;", "anchorBattleSetting", "", "videoShowScore$delegate", "getVideoShowScore", "()J", "videoShowScore", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo_IGameInfoFlexImpl;", "gameInfo$delegate", "getGameInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo_IGameInfoFlexImpl;", "gameInfo", "recommendInfo$delegate", "getRecommendInfo", "recommendInfo", "signExtra$delegate", "getSignExtra", "signExtra", "serverInviteType$delegate", "getServerInviteType", "serverInviteType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IRivalExtraInfoFlexImpl extends FlexModelBase<IRivalExtraInfo> implements IRivalExtraInfo, vh7.h {

    @SerializedName("battle_user_settings")
    protected IAnchorBattleUserSettingsFlexImpl _$$anchorBattleSetting;

    @SerializedName("anchor_layer")
    protected int _$$anchorLayer;

    @SerializedName("linkmic_user_settings")
    protected IAnchorLinkmicUserSettingsFlexImpl _$$anchorLinkmicUserSettings;

    @SerializedName("game_info")
    protected IRivalExtraInfo_IGameInfoFlexImpl _$$gameInfo;

    @SerializedName("label")
    protected String _$$label;

    @SerializedName("linker_info")
    protected ILinkerInfoFlexImpl _$$linkerInfo;

    @SerializedName("recommend_info")
    protected String _$$recommendInfo;

    @SerializedName("from_server_invite_type")
    protected int _$$serverInviteType;

    @SerializedName("sign_extra")
    protected String _$$signExtra;

    @SerializedName("text")
    protected String _$$text;

    @SerializedName("text_type")
    protected int _$$text_type;

    @SerializedName("video_show_score")
    protected long _$$videoShowScore;

    public IRivalExtraInfoFlexImpl() {
        super(IRivalExtraInfo.class);
        this._$$text = "";
        this._$$label = "";
        this._$$recommendInfo = "";
        this._$$signExtra = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public /* bridge */ /* synthetic */ h getAnchorBattleSetting() {
        return getAnchorBattleSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public /* bridge */ /* synthetic */ u getAnchorLinkmicUserSettings() {
        return getAnchorLinkmicUserSettings();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public /* bridge */ /* synthetic */ IRivalExtraInfo.b getGameInfo() {
        return getGameInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public /* bridge */ /* synthetic */ d6 getLinkerInfo() {
        return getLinkerInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final int getAnchorLayer() {
        return this._$$anchorLayer;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final String getLabel() {
        return this._$$label;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final String getRecommendInfo() {
        return this._$$recommendInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final int getServerInviteType() {
        return this._$$serverInviteType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final String getSignExtra() {
        return this._$$signExtra;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final String getText() {
        return this._$$text;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final int getText_type() {
        return this._$$text_type;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final long getVideoShowScore() {
        return this._$$videoShowScore;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final IAnchorBattleUserSettingsFlexImpl getAnchorBattleSetting() {
        return this._$$anchorBattleSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final IAnchorLinkmicUserSettingsFlexImpl getAnchorLinkmicUserSettings() {
        return this._$$anchorLinkmicUserSettings;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final IRivalExtraInfo_IGameInfoFlexImpl getGameInfo() {
        return this._$$gameInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IRivalExtraInfo
    public final ILinkerInfoFlexImpl getLinkerInfo() {
        return this._$$linkerInfo;
    }

    public IRivalExtraInfoFlexImpl(am3.g r5) {
        super(IRivalExtraInfo.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L20;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
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
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        this._$$serverInviteType = r5.i();
        goto L3
    L9:
        this._$$recommendInfo = am3.h.c(r5);
        goto L3
    L10:
        this._$$signExtra = am3.h.c(r5);
        goto L3
    L11:
        this._$$gameInfo = new IRivalExtraInfo_IGameInfoFlexImpl(r5);
        goto L3
    L12:
        this._$$videoShowScore = r5.j();
        goto L3
    L13:
        this._$$anchorBattleSetting = new IAnchorBattleUserSettingsFlexImpl(r5);
        goto L3
    L14:
        this._$$anchorLinkmicUserSettings = new IAnchorLinkmicUserSettingsFlexImpl(r5);
        goto L3
    L15:
        this._$$linkerInfo = new ILinkerInfoFlexImpl(r5);
        goto L3
    L16:
        this._$$anchorLayer = r5.i();
        goto L3
    L17:
        this._$$label = am3.h.c(r5);
        goto L3
    L18:
        this._$$text_type = r5.i();
        goto L3
    L19:
        this._$$text = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L20:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$text != null) goto L24;
        this._$$text = "";
    L24:
        if (this._$$label != null) goto L27;
        this._$$label = "";
    L27:
        if (this._$$recommendInfo != null) goto L30;
        this._$$recommendInfo = "";
    L30:
        if (this._$$signExtra != null) goto L61;
        this._$$signExtra = "";
        return;
    }
}
