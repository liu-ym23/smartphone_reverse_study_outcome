package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.AudienceApplyBattleTeamTaskInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y;", "", "teamTaskStatus$delegate", "Ljava/lang/Object;", "getTeamTaskStatus", "()I", "teamTaskStatus", "Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl;", "deliveryTeamTaskInfo$delegate", "getDeliveryTeamTaskInfo", "()Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl;", "deliveryTeamTaskInfo", "Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl;", "battleOpenTeamTaskInfo$delegate", "getBattleOpenTeamTaskInfo", "()Lcom/bytedance/android/livesdk/link/model/IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl;", "battleOpenTeamTaskInfo", "", "uiResource$delegate", "getUiResource", "()Ljava/lang/String;", "uiResource", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IAudienceApplyBattleTeamTaskInfoFlexImpl extends FlexModelBase<y> implements y, vh7.h {

    @SerializedName("battle_open_team_task_info")
    protected IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl _$$battleOpenTeamTaskInfo;

    @SerializedName("delivery_team_task_info")
    protected IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl _$$deliveryTeamTaskInfo;

    @SerializedName("team_task_status")
    protected int _$$teamTaskStatus;

    @SerializedName("ui_resource")
    protected String _$$uiResource;

    public IAudienceApplyBattleTeamTaskInfoFlexImpl() {
        super(y.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.y
    public /* bridge */ /* synthetic */ y.a getBattleOpenTeamTaskInfo() {
        return getBattleOpenTeamTaskInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.y
    public /* bridge */ /* synthetic */ y.c getDeliveryTeamTaskInfo() {
        return getDeliveryTeamTaskInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.y
    public final int getTeamTaskStatus() {
        return this._$$teamTaskStatus;
    }

    @Override // com.bytedance.android.livesdk.link.model.y
    public final String getUiResource() {
        return this._$$uiResource;
    }

    @Override // com.bytedance.android.livesdk.link.model.y
    public final IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl getBattleOpenTeamTaskInfo() {
        return this._$$battleOpenTeamTaskInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.y
    public final IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl getDeliveryTeamTaskInfo() {
        return this._$$deliveryTeamTaskInfo;
    }

    public IAudienceApplyBattleTeamTaskInfoFlexImpl(am3.g r6) {
        super(y.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L18;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this._$$teamTaskStatus = r6.i();
        goto L3
    L8:
        if (r2 != 3) goto L10;
        this._$$deliveryTeamTaskInfo = new IAudienceApplyBattleTeamTaskInfo_DeliveryTeamTaskInfoFlexImpl(r6);
        goto L3
    L10:
        if (r2 != 4) goto L12;
        this._$$battleOpenTeamTaskInfo = new IAudienceApplyBattleTeamTaskInfo_BattleOpenTeamTaskInfoFlexImpl(r6);
        goto L3
    L12:
        if (r2 != 5) goto L13;
        this._$$uiResource = am3.h.c(r6);
        goto L3
    L13:
        am3.h.d(r3, r6);
        goto L3
    L18:
        r6.d(r0);
        setThreadSafe(true);
    }
}
