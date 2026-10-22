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
@ProtoMessage("webcast.data.AudienceApplyBattleTeamTaskInfo.DeliveryTeamTaskInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b)\u0010*R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\u000e\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u001a\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007R\u001b\u0010\u001d\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\"\u001a\u00020\u001e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0005\u001a\u0004\b$\u0010\u0007R\u001b\u0010(\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0005\u001a\u0004\b'\u0010\u0007¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y$c;", "", "anchorId$delegate", "Ljava/lang/Object;", "getAnchorId", "()Ljava/lang/String;", "anchorId", "roomId$delegate", "getRoomId", "roomId", "userId$delegate", "getUserId", "userId", "", "Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl;", "popupAnchorInfo$delegate", "getPopupAnchorInfo", "()Ljava/util/List;", "popupAnchorInfo", "popupTitle$delegate", "getPopupTitle", "popupTitle", "popupDesc$delegate", "getPopupDesc", "popupDesc", "popupSubDesc$delegate", "getPopupSubDesc", "popupSubDesc", "", "scoreGap$delegate", "getScoreGap", "()I", "scoreGap", "anchorOpenId$delegate", "getAnchorOpenId", "anchorOpenId", "userOpenId$delegate", "getUserOpenId", "userOpenId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl extends FlexModelBase<y.c> implements y.c, vh7.h {

    @SerializedName("anchor_id")
    protected String _$$anchorId;

    @SerializedName("anchor_open_id")
    protected String _$$anchorOpenId;

    @SerializedName("popup_anchor_info")
    protected List<IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl> _$$popupAnchorInfo;

    @SerializedName("popup_desc")
    protected String _$$popupDesc;

    @SerializedName("popup_sub_desc")
    protected String _$$popupSubDesc;

    @SerializedName("popup_title")
    protected String _$$popupTitle;

    @SerializedName("room_id")
    protected String _$$roomId;

    @SerializedName("score_gap")
    protected int _$$scoreGap;

    @SerializedName("user_id")
    protected String _$$userId;

    @SerializedName("user_open_id")
    protected String _$$userOpenId;

    public IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl() {
        super(y.c.class);
        this._$$anchorId = "";
        this._$$roomId = "";
        this._$$userId = "";
        this._$$popupAnchorInfo = $defaultValue_popupAnchorInfo$();
        this._$$popupTitle = "";
        this._$$popupDesc = "";
        this._$$popupSubDesc = "";
        this._$$anchorOpenId = "";
        this._$$userOpenId = "";
    }

    public final List<IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl> $defaultValue_popupAnchorInfo$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getAnchorId() {
        return this._$$anchorId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getAnchorOpenId() {
        return this._$$anchorOpenId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final List<IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl> getPopupAnchorInfo() {
        return this._$$popupAnchorInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getPopupDesc() {
        return this._$$popupDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getPopupSubDesc() {
        return this._$$popupSubDesc;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getPopupTitle() {
        return this._$$popupTitle;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getRoomId() {
        return this._$$roomId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final int getScoreGap() {
        return this._$$scoreGap;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getUserId() {
        return this._$$userId;
    }

    @Override // com.bytedance.android.livesdk.link.model.y.c
    public final String getUserOpenId() {
        return this._$$userOpenId;
    }

    public IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl(am3.g r6) {
        super(y.c.class);
        this._$$popupAnchorInfo = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 5000) goto L8;
        this._$$anchorOpenId = am3.h.c(r6);
        goto L3
    L8:
        if (r2 != 5001) goto L9;
        this._$$userOpenId = am3.h.c(r6);
        goto L3
    L9:
        switch(r2) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        this._$$scoreGap = r6.i();
        goto L3
    L12:
        this._$$popupSubDesc = am3.h.c(r6);
        goto L3
    L13:
        this._$$popupDesc = am3.h.c(r6);
        goto L3
    L14:
        this._$$popupTitle = am3.h.c(r6);
        goto L3
    L15:
        this._$$popupAnchorInfo.add(new IAudienceApplyBattleTeamTaskInfo_PopupAnchorInfoFlexImpl(r6));
        goto L3
    L16:
        this._$$userId = am3.h.c(r6);
        goto L3
    L17:
        this._$$roomId = am3.h.c(r6);
        goto L3
    L18:
        this._$$anchorId = am3.h.c(r6);
        goto L3
    L10:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$anchorId != null) goto L25;
        this._$$anchorId = "";
    L25:
        if (this._$$roomId != null) goto L28;
        this._$$roomId = "";
    L28:
        if (this._$$userId != null) goto L31;
        this._$$userId = "";
    L31:
        if (this._$$popupAnchorInfo.isEmpty() == false) goto L34;
        this._$$popupAnchorInfo = $defaultValue_popupAnchorInfo$();
    L34:
        if (this._$$popupTitle != null) goto L37;
        this._$$popupTitle = "";
    L37:
        if (this._$$popupDesc != null) goto L40;
        this._$$popupDesc = "";
    L40:
        if (this._$$popupSubDesc != null) goto L43;
        this._$$popupSubDesc = "";
    L43:
        if (this._$$anchorOpenId != null) goto L46;
        this._$$anchorOpenId = "";
    L46:
        if (this._$$userOpenId != null) goto L75;
        this._$$userOpenId = "";
        return;
    }
}
