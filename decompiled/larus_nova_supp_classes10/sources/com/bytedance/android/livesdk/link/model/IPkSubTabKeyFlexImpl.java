package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.battle.PKSubTabKey")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011R\u001b\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IPkSubTabKeyFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IPkSubTabKey;", "", "flexActivityId$delegate", "Ljava/lang/Object;", "getFlexActivityId", "()J", "flexActivityId", "", "activityId$delegate", "getActivityId", "()Ljava/lang/String;", "activityId", "", "groupRivalsType$delegate", "getGroupRivalsType", "()I", "groupRivalsType", "type$delegate", "getType", LocationMonitorConst.TYPE, "inviteType$delegate", "getInviteType", "inviteType", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IPkSubTabKeyFlexImpl extends FlexModelBase<IPkSubTabKey> implements IPkSubTabKey, vh7.h {

    @SerializedName("activity_id")
    protected String _$$activityId;

    @SerializedName("flex_activity_id")
    protected long _$$flexActivityId;

    @SerializedName("group_rivals_type")
    protected int _$$groupRivalsType;

    @SerializedName("invite_type")
    protected int _$$inviteType;

    @SerializedName(LocationMonitorConst.TYPE)
    protected int _$$type;

    public IPkSubTabKeyFlexImpl() {
        super(IPkSubTabKey.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IPkSubTabKey
    public final String getActivityId() {
        return this._$$activityId;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPkSubTabKey
    public final long getFlexActivityId() {
        return this._$$flexActivityId;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPkSubTabKey
    public final int getGroupRivalsType() {
        return this._$$groupRivalsType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPkSubTabKey
    public final int getInviteType() {
        return this._$$inviteType;
    }

    @Override // com.bytedance.android.livesdk.link.model.IPkSubTabKey
    public final int getType() {
        return this._$$type;
    }

    public IPkSubTabKeyFlexImpl(am3.g r6) {
        super(IPkSubTabKey.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L21;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$type = r6.i();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$groupRivalsType = r6.i();
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this._$$flexActivityId = r6.j();
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this._$$inviteType = r6.i();
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this._$$activityId = am3.h.c(r6);
        goto L3
    L15:
        am3.h.d(r3, r6);
        goto L3
    L21:
        r6.d(r0);
        setThreadSafe(true);
    }
}
