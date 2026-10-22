package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0016\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0019R\u0014\u0010/\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0019R$\u00106\u001a\n\u0018\u000100j\u0004\u0018\u0001`18\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleReserveInviteMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/w;", "Lcom/bytedance/android/livesdk/link/model/i2;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getFromUserId", "()J", "fromUserId", "getFromRoomId", "fromRoomId", "getToUserId", "toUserId", "getToRoomId", "toRoomId", "getWaitSec", "waitSec", "", "getClientAttachedInfo", "()Ljava/lang/String;", "clientAttachedInfo", "getReserveId", "reserveId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getInviteRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "inviteRoom", "getTips", "tips", "Lcom/bytedance/android/livesdk/link/model/j2;", "getOption", "()Lcom/bytedance/android/livesdk/link/model/j2;", "option", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "getTags", "()Ljava/util/List;", "tags", "getFromOpenId", "fromOpenId", "getToOpenId", "toOpenId", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/w;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleReserveInviteMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.w, i2> implements i2, com.bytedance.android.livesdk.link.model.bridge.w {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.w $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.i2, com.bytedance.android.livesdk.link.model.bridge.w
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.w>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i2, com.bytedance.android.livesdk.link.model.bridge.w
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.w>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i2, com.bytedance.android.livesdk.link.model.bridge.w
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.i2, com.bytedance.android.livesdk.link.model.bridge.w
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public String getClientAttachedInfo() {
        return (String) get(7, i2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public String getFromOpenId() {
        return (String) get(5000, i2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public long getFromRoomId() {
        return ((Number) get(3, i2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public long getFromUserId() {
        return ((Number) get(2, i2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public IRoom getInviteRoom() {
        return (IRoom) get(9, i2.class, IRoom.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public j2 getOption() {
        return (j2) get(11, i2.class, j2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public String getReserveId() {
        return (String) get(8, i2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public List<IBattleRivalTag> getTags() {
        return (List) get(12, i2.class, com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a());
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public String getTips() {
        return (String) get(10, i2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public String getToOpenId() {
        return (String) get(5001, i2.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public long getToRoomId() {
        return ((Number) get(5, i2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public long getToUserId() {
        return ((Number) get(4, i2.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.i2
    public long getWaitSec() {
        return ((Number) get(6, i2.class, 0L)).longValue();
    }

    public IBattleReserveInviteMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.w r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
