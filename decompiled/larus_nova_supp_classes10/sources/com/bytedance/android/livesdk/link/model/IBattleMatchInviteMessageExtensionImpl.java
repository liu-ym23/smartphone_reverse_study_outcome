package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010\"\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0011R\u0014\u0010$\u001a\u00020\u001b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u001dR\u0014\u0010&\u001a\u00020\u001b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010\u001dR$\u0010-\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMatchInviteMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/s;", "Lcom/bytedance/android/livesdk/link/model/s1;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra;", "getBattleExtra", "()Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra;", "battleExtra", "", "getFromRoomId", "()J", "fromRoomId", "getToRoomId", "toRoomId", "", "getMatchType", "()I", "matchType", "getInviteType", "inviteType", "", "getClientInfo", "()Ljava/lang/String;", "clientInfo", "getBattleAttachedInfo", "battleAttachedInfo", "getWaitSec", "waitSec", "get_fromUid", "_fromUid", "get_toUid", "_toUid", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/s;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleMatchInviteMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.s, s1> implements s1, com.bytedance.android.livesdk.link.model.bridge.s {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.s $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.s1, com.bytedance.android.livesdk.link.model.bridge.s
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.s>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s1, com.bytedance.android.livesdk.link.model.bridge.s
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.s>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s1, com.bytedance.android.livesdk.link.model.bridge.s
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1, com.bytedance.android.livesdk.link.model.bridge.s
    public String get_fromUid() {
        return this.$$delegate_0.get_fromUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1, com.bytedance.android.livesdk.link.model.bridge.s
    public String get_toUid() {
        return this.$$delegate_0.get_toUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1, com.bytedance.android.livesdk.link.model.bridge.s
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public String getBattleAttachedInfo() {
        return (String) get(11, s1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public IBattleLinkerInviteMessageExtra getBattleExtra() {
        return (IBattleLinkerInviteMessageExtra) get(10, s1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public String getClientInfo() {
        return (String) get(9, s1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public long getFromRoomId() {
        return ((Number) get(3, s1.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public int getInviteType() {
        return ((Number) get(6, s1.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public int getMatchType() {
        return ((Number) get(7, s1.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public long getToRoomId() {
        return ((Number) get(5, s1.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.s1
    public long getWaitSec() {
        return ((Number) get(8, s1.class, 0L)).longValue();
    }

    public IBattleMatchInviteMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.s r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
