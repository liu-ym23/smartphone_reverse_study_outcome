package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMultiAnchorLinkmicRtcLiveCoreDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/q1;", "Lcom/bytedance/android/livesdk/link/model/y6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "Lcom/bytedance/android/livesdk/link/model/p;", "getAnchorUserList", "()Ljava/util/List;", "anchorUserList", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "liveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "rtcInfo", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/q1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiAnchorLinkmicRtcLiveCoreDataExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.q1, y6> implements y6, com.bytedance.android.livesdk.link.model.bridge.q1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.q1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.y6, com.bytedance.android.livesdk.link.model.bridge.q1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.q1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.y6, com.bytedance.android.livesdk.link.model.bridge.q1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.q1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.y6
    public List<p> getAnchorUserList() {
        return (List) get(3, y6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.y6, com.bytedance.android.livesdk.link.model.bridge.q1
    public com.bytedance.android.livesdk.link.model.bridge.u1 getLiveCoreInfo() {
        return this.$$delegate_0.getLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.y6, com.bytedance.android.livesdk.link.model.bridge.q1
    public com.bytedance.android.livesdk.link.model.bridge.v1 getRtcInfo() {
        return this.$$delegate_0.getRtcInfo();
    }

    public IMultiAnchorLinkmicRtcLiveCoreDataExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.q1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
