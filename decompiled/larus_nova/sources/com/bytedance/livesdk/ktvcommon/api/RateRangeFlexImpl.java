package com.bytedance.livesdk.ktvcommon.api;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@ProtoMessage("webcast.api.ktv.GetMidiConfigResponse.RateRange")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\f\u0010\rR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/api/RateRangeFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/livesdk/ktvcommon/api/j;", "", "mCeiling$delegate", "Ljava/lang/Object;", "getMCeiling", "()Ljava/lang/Long;", "mCeiling", "mFloor$delegate", "getMFloor", "mFloor", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RateRangeFlexImpl extends FlexModelBase<j> implements j, vh7.h {

    @SerializedName("ceiling")
    protected Long _$$mCeiling;

    @SerializedName("floor")
    protected Long _$$mFloor;

    public RateRangeFlexImpl() {
        super(j.class);
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.j
    public final Long getMCeiling() {
        return this._$$mCeiling;
    }

    @Override // com.bytedance.livesdk.ktvcommon.api.j
    public final Long getMFloor() {
        return this._$$mFloor;
    }

    public RateRangeFlexImpl(am3.g r100) {
        super(j.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$mCeiling = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$mFloor = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
