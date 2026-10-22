package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("webcast.api.linkmic.MultiBattleFinishResponse.ResponseData")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMultiBattleFinishResponseFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/z6;", "Lcom/bytedance/android/livesdk/link/model/IBattleStatsMetaFlexImpl;", "battleStats$delegate", "Ljava/lang/Object;", "getBattleStats", "()Lcom/bytedance/android/livesdk/link/model/IBattleStatsMetaFlexImpl;", "battleStats", "<init>", "()V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IMultiBattleFinishResponseFlexImpl extends FlexModelBase<z6> implements z6, vh7.h {

    @SerializedName("battle_stats")
    protected IBattleStatsMetaFlexImpl _$$battleStats;

    public IMultiBattleFinishResponseFlexImpl() {
        super(z6.class);
    }

    public IMultiBattleFinishResponseFlexImpl(am3.g r6) {
        super(z6.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L9;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L7;
        this._$$battleStats = new IBattleStatsMetaFlexImpl(r6);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L9:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.link.model.z6
    public /* bridge */ /* synthetic */ c3 getBattleStats() {
        return getBattleStats();
    }

    @Override // com.bytedance.android.livesdk.link.model.z6
    public final IBattleStatsMetaFlexImpl getBattleStats() {
        return this._$$battleStats;
    }
}
