package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010$\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u0014\u0010&\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0019R$\u0010-\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleReserveReserveSettleMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/y;", "Lcom/bytedance/android/livesdk/link/model/l2;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getFromUserId", "()J", "fromUserId", "getFromRoomId", "fromRoomId", "getToUserId", "toUserId", "getToRoomId", "toRoomId", "getWaitSec", "waitSec", "", "getBattleAttachedInfo", "()Ljava/lang/String;", "battleAttachedInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getToRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "toRoom", "getTips", "tips", "getReserveId", "reserveId", "getFromOpenId", "fromOpenId", "getToOpenId", "toOpenId", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/y;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleReserveReserveSettleMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.y, l2> implements l2, com.bytedance.android.livesdk.link.model.bridge.y {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.y $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.l2, com.bytedance.android.livesdk.link.model.bridge.y
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.y>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.l2, com.bytedance.android.livesdk.link.model.bridge.y
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.y>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.l2, com.bytedance.android.livesdk.link.model.bridge.y
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.l2, com.bytedance.android.livesdk.link.model.bridge.y
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public String getBattleAttachedInfo() {
        return (String) get(7, l2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public String getFromOpenId() {
        return (String) get(5000, l2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public long getFromRoomId() {
        return ((Number) get(3, l2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public long getFromUserId() {
        return ((Number) get(2, l2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public String getReserveId() {
        return (String) get(8, l2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public String getTips() {
        return (String) get(10, l2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public String getToOpenId() {
        return (String) get(5001, l2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public IRoom getToRoom() {
        return (IRoom) get(9, l2.class, IRoom.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public long getToRoomId() {
        return ((Number) get(5, l2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public long getToUserId() {
        return ((Number) get(4, l2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.l2
    public long getWaitSec() {
        return ((Number) get(6, l2.class, 0L)).longValue();
    }

    public IBattleReserveReserveSettleMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.y r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
