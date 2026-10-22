package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.BattleContributorsRankListV2")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleContributorsRankListV2FlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/y0;", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "teamTask$delegate", "Ljava/lang/Object;", "getTeamTask", "()Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "teamTask", "Lcom/bytedance/android/livesdk/link/model/IBattleDataSettingFlexImpl;", "battleSetting$delegate", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleDataSettingFlexImpl;", "battleSetting", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IBattleContributorsRankListV2FlexImpl extends FlexModelBase<y0> implements y0, vh7.h {

    @SerializedName("battle_settings")
    protected IBattleDataSettingFlexImpl _$$battleSetting;

    @SerializedName("team_task")
    protected ITeamTaskFlexImpl _$$teamTask;

    public IBattleContributorsRankListV2FlexImpl() {
        super(y0.class);
    }

    public IBattleContributorsRankListV2FlexImpl(am3.g r6) {
        super(y0.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L12;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 2) goto L8;
        this._$$teamTask = new ITeamTaskFlexImpl(r6);
        goto L3
    L8:
        if (r2 != 3) goto L9;
        this._$$battleSetting = new IBattleDataSettingFlexImpl(r6);
        goto L3
    L9:
        am3.h.d(r3, r6);
        goto L3
    L12:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.y0
    public /* bridge */ /* synthetic */ c1 getBattleSetting() {
        return getBattleSetting();
    }

    @Override // com.bytedance.android.livesdk.link.model.y0
    public /* bridge */ /* synthetic */ ITeamTask getTeamTask() {
        return getTeamTask();
    }

    @Override // com.bytedance.android.livesdk.link.model.y0
    public final IBattleDataSettingFlexImpl getBattleSetting() {
        return this._$$battleSetting;
    }

    @Override // com.bytedance.android.livesdk.link.model.y0
    public final ITeamTaskFlexImpl getTeamTask() {
        return this._$$teamTask;
    }
}
