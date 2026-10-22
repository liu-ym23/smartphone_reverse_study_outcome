package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.data.StealDragonInfo.SettleInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo_SettleInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/IStealDragonInfo$c;", "", "cur_top_anchor_id$delegate", "Ljava/lang/Object;", "getCur_top_anchor_id", "()Ljava/lang/String;", "cur_top_anchor_id", "", "dragonLevel$delegate", "getDragonLevel", "()J", "dragonLevel", "cur_top_anchor_open_id$delegate", "getCur_top_anchor_open_id", "cur_top_anchor_open_id", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IStealDragonInfo_SettleInfoFlexImpl extends FlexModelBase<IStealDragonInfo.c> implements IStealDragonInfo.c, vh7.h {

    @SerializedName("cur_top_anchor_id")
    protected String _$$cur_top_anchor_id;

    @SerializedName("cur_top_anchor_open_id")
    protected String _$$cur_top_anchor_open_id;

    @SerializedName("dragon_level")
    protected long _$$dragonLevel;

    public IStealDragonInfo_SettleInfoFlexImpl() {
        super(IStealDragonInfo.c.class);
        this._$$cur_top_anchor_id = "";
        this._$$cur_top_anchor_open_id = "";
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.c
    public final String getCur_top_anchor_id() {
        return this._$$cur_top_anchor_id;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.c
    public final String getCur_top_anchor_open_id() {
        return this._$$cur_top_anchor_open_id;
    }

    @Override // com.bytedance.android.livesdk.link.model.IStealDragonInfo.c
    public final long getDragonLevel() {
        return this._$$dragonLevel;
    }

    public IStealDragonInfo_SettleInfoFlexImpl(am3.g r6) {
        super(IStealDragonInfo.c.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$dragonLevel = r6.j();
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$cur_top_anchor_id = am3.h.c(r6);
        goto L3
    L10:
        if (r2 != 5000) goto L11;
        this._$$cur_top_anchor_open_id = am3.h.c(r6);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$cur_top_anchor_id != null) goto L19;
        this._$$cur_top_anchor_id = "";
    L19:
        if (this._$$cur_top_anchor_open_id != null) goto L34;
        this._$$cur_top_anchor_open_id = "";
        return;
    }
}
