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
@ProtoMessage("webcast.data.StealDragonInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b$\u0010%R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0005\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u0007R\u001b\u0010#\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0005\u001a\u0004\b\"\u0010\u0007¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo;", "", "battleId$delegate", "Ljava/lang/Object;", "getBattleId", "()Ljava/lang/String;", "battleId", "", "initDragonLevel$delegate", "getInitDragonLevel", "()J", "initDragonLevel", "", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_PeriodConfigFlexImpl;", "periodList$delegate", "getPeriodList", "()Ljava/util/List;", "periodList", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_StealInfoFlexImpl;", "stealInfo$delegate", "getStealInfo", "()Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_StealInfoFlexImpl;", "stealInfo", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_SettleInfoFlexImpl;", "settleInfo$delegate", "getSettleInfo", "()Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_SettleInfoFlexImpl;", "settleInfo", "uiResource$delegate", "getUiResource", "uiResource", "lynxData$delegate", "getLynxData", "lynxData", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IStealDragonInfoFlexImpl extends FlexModelBase<IStealDragonInfo> implements IStealDragonInfo, vh7.h {

    @SerializedName("battle_id")
    protected String _$$battleId;

    @SerializedName("init_dragon_level")
    protected long _$$initDragonLevel;

    @SerializedName("lynx_data")
    protected String _$$lynxData;

    @SerializedName("period_list")
    protected List<IStealDragonInfo_PeriodConfigFlexImpl> _$$periodList;

    @SerializedName("settle_info")
    protected IStealDragonInfo_SettleInfoFlexImpl _$$settleInfo;

    @SerializedName("steal_info")
    protected IStealDragonInfo_StealInfoFlexImpl _$$stealInfo;

    @SerializedName("ui_resource")
    protected String _$$uiResource;

    public IStealDragonInfoFlexImpl() {
        super(IStealDragonInfo.class);
        this._$$battleId = "";
        this._$$stealInfo = $defaultValue_stealInfo$();
        this._$$settleInfo = $defaultValue_settleInfo$();
        this._$$uiResource = "";
        this._$$lynxData = "";
    }

    public final IStealDragonInfo_SettleInfoFlexImpl $defaultValue_settleInfo$() {
        return (IStealDragonInfo_SettleInfoFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IStealDragonInfo_SettleInfoFlexImpl.class);
    }

    public final IStealDragonInfo_StealInfoFlexImpl $defaultValue_stealInfo$() {
        return (IStealDragonInfo_StealInfoFlexImpl) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(IStealDragonInfo_StealInfoFlexImpl.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public /* bridge */ /* synthetic */ IStealDragonInfo.c getSettleInfo() {
        return getSettleInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public /* bridge */ /* synthetic */ IStealDragonInfo.d getStealInfo() {
        return getStealInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final String getBattleId() {
        return this._$$battleId;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final long getInitDragonLevel() {
        return this._$$initDragonLevel;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final String getLynxData() {
        return this._$$lynxData;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final List<IStealDragonInfo_PeriodConfigFlexImpl> getPeriodList() {
        return this._$$periodList;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final String getUiResource() {
        return this._$$uiResource;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final IStealDragonInfo_SettleInfoFlexImpl getSettleInfo() {
        return this._$$settleInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo
    public final IStealDragonInfo_StealInfoFlexImpl getStealInfo() {
        return this._$$stealInfo;
    }

    public IStealDragonInfoFlexImpl(am3.g r5) {
        super(IStealDragonInfo.class);
        this._$$periodList = new ArrayList();
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$lynxData = am3.h.c(r5);
        goto L3
    L9:
        this._$$uiResource = am3.h.c(r5);
        goto L3
    L10:
        this._$$settleInfo = new IStealDragonInfo_SettleInfoFlexImpl(r5);
        goto L3
    L11:
        this._$$stealInfo = new IStealDragonInfo_StealInfoFlexImpl(r5);
        goto L3
    L12:
        this._$$periodList.add(new IStealDragonInfo_PeriodConfigFlexImpl(r5));
        goto L3
    L13:
        this._$$initDragonLevel = r5.j();
        goto L3
    L14:
        this._$$battleId = am3.h.c(r5);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
        if (this._$$battleId != null) goto L19;
        this._$$battleId = "";
    L19:
        if (this._$$stealInfo != null) goto L22;
        this._$$stealInfo = $defaultValue_stealInfo$();
    L22:
        if (this._$$settleInfo != null) goto L25;
        this._$$settleInfo = $defaultValue_settleInfo$();
    L25:
        if (this._$$uiResource != null) goto L28;
        this._$$uiResource = "";
    L28:
        if (this._$$lynxData != null) goto L49;
        this._$$lynxData = "";
        return;
    }
}
