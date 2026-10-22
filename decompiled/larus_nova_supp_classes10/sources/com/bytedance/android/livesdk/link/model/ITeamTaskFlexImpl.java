package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.TeamTask")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR)\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ITeamTaskFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/ITeamTask;", "", "triggerUid$delegate", "Ljava/lang/Object;", "getTriggerUid", "()Ljava/lang/String;", "triggerUid", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskConfigFlexImpl;", "teamTaskConfig$delegate", "getTeamTaskConfig", "()Lcom/bytedance/android/livesdk/link/model/ITeamTaskConfigFlexImpl;", "teamTaskConfig", "", "Lcom/bytedance/android/livesdk/link/model/ITeamTaskInfoFlexImpl;", "teamTaskInfoMap$delegate", "getTeamTaskInfoMap", "()Ljava/util/Map;", "teamTaskInfoMap", "battleId$delegate", "getBattleId", "battleId", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ITeamTaskFlexImpl extends FlexModelBase<ITeamTask> implements ITeamTask, vh7.h {

    @SerializedName("battle_id")
    protected String _$$battleId;

    @SerializedName("config")
    protected ITeamTaskConfigFlexImpl _$$teamTaskConfig;

    @SerializedName(LocationMonitorConst.INFO)
    protected Map<String, ITeamTaskInfoFlexImpl> _$$teamTaskInfoMap;

    @SerializedName("trigger_open_id")
    protected String _$$triggerUid;

    public ITeamTaskFlexImpl() {
        super(ITeamTask.class);
        this._$$battleId = "";
    }

    public ITeamTaskFlexImpl(am3.g r11) {
        super(ITeamTask.class);
        this._$$teamTaskInfoMap = new HashMap();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L33;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        if (r2 != 1) goto L8;
        this._$$teamTaskConfig = new ITeamTaskConfigFlexImpl(r11);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        long r7 = r11.c();
        String r3 = null;
        ITeamTaskInfoFlexImpl r6 = null;
    L17:
        int r9 = r11.f();
        if (r9 == (-1)) goto L24;
        if (r9 != 1) goto L20;
        r3 = am3.h.c(r11);
        goto L17
    L20:
        if (r9 != 2) goto L21;
        r6 = new ITeamTaskInfoFlexImpl(r11);
        goto L17
    L21:
        am3.h.e(r11);
        goto L17
    L24:
        r11.d(r7);
        Map<String, ITeamTaskInfoFlexImpl> r4 = this._$$teamTaskInfoMap;
        if (r3 == null) goto L31;
        if (r6 == null) goto L29;
        r4.put(r3, r6);
        goto L3
    L29:
        throw new IllegalStateException("Value must not be null");
    L31:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r2 != 3) goto L12;
        this._$$battleId = am3.h.c(r11);
        goto L3
    L12:
        if (r2 != 5001) goto L13;
        this._$$triggerUid = am3.h.c(r11);
        goto L3
    L13:
        am3.h.d(r5, r11);
        goto L3
    L33:
        r11.d(r0);
        setThreadSafe(true);
        if (this._$$battleId != null) goto L63;
        this._$$battleId = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITeamTask
    public /* bridge */ /* synthetic */ q9 getTeamTaskConfig() {
        return getTeamTaskConfig();
    }

    @Override // com.bytedance.android.livesdk.link.model.ITeamTask
    public final String getBattleId() {
        return this._$$battleId;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITeamTask
    public final Map<String, ITeamTaskInfoFlexImpl> getTeamTaskInfoMap() {
        return this._$$teamTaskInfoMap;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITeamTask
    public final String getTriggerUid() {
        return this._$$triggerUid;
    }

    @Override // com.bytedance.android.livesdk.link.model.ITeamTask
    public final ITeamTaskConfigFlexImpl getTeamTaskConfig() {
        return this._$$teamTaskConfig;
    }
}
