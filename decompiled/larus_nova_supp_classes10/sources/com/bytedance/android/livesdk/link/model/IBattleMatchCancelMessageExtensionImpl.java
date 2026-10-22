package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R$\u0010\u001b\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u00168\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0016\u0010!\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u0011R\u0014\u0010#\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\r¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleMatchCancelMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/r;", "Lcom/bytedance/android/livesdk/link/model/r1;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getCancelType", "()J", "cancelType", "", "getToast", "()Ljava/lang/String;", "toast", "getClientInfo", "clientInfo", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "getFromOpenUserId", "fromOpenUserId", "getFromUserId", "fromUserId", "getToOpenUserId", "toOpenUserId", "getToUserId", "toUserId", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/r;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IBattleMatchCancelMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.r, r1> implements r1, com.bytedance.android.livesdk.link.model.bridge.r {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.r $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.r>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.r>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r1
    public String getClientInfo() {
        return (String) get(6, r1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public String getFromOpenUserId() {
        return this.$$delegate_0.getFromOpenUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public long getFromUserId() {
        return this.$$delegate_0.getFromUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public String getToOpenUserId() {
        return this.$$delegate_0.getToOpenUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public long getToUserId() {
        return this.$$delegate_0.getToUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.r1
    public String getToast() {
        return (String) get(5, r1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.r1, com.bytedance.android.livesdk.link.model.bridge.r
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.r1
    public long getCancelType() {
        return ((Number) get(4, r1.class, 0L)).longValue();
    }

    public IBattleMatchCancelMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.r r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
