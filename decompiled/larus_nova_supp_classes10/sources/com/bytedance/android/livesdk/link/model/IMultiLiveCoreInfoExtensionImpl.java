package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMultiLiveCoreInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "Lcom/bytedance/android/livesdk/link/model/d7;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getScene", "()I", "scene", "Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "getKtvLiveCoreInfo", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;", "setKtvLiveCoreInfo", "(Lcom/bytedance/android/livesdk/chatroom/model/interact/i0;)V", "ktvLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/p1;", "getMultiAnchorLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/p1;", "multiAnchorLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/i2;", "getSingingChallengeLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/i2;", "singingChallengeLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/l2;", "getVideoEqualRoomLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/l2;", "videoEqualRoomLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/m2;", "getVideoPositionLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/m2;", "videoPositionLiveCoreInfo", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/u1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiLiveCoreInfoExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.u1, d7> implements d7, com.bytedance.android.livesdk.link.model.bridge.u1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.u1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.u1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.u1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public com.bytedance.android.livesdk.chatroom.model.interact.i0 getKtvLiveCoreInfo() {
        return this.$$delegate_0.getKtvLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public com.bytedance.android.livesdk.link.model.bridge.p1 getMultiAnchorLiveCoreInfo() {
        return this.$$delegate_0.getMultiAnchorLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public com.bytedance.android.livesdk.link.model.bridge.i2 getSingingChallengeLiveCoreInfo() {
        return this.$$delegate_0.getSingingChallengeLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public com.bytedance.android.livesdk.link.model.bridge.l2 getVideoEqualRoomLiveCoreInfo() {
        return this.$$delegate_0.getVideoEqualRoomLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public com.bytedance.android.livesdk.link.model.bridge.m2 getVideoPositionLiveCoreInfo() {
        return this.$$delegate_0.getVideoPositionLiveCoreInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.d7, com.bytedance.android.livesdk.link.model.bridge.u1
    public void setKtvLiveCoreInfo(com.bytedance.android.livesdk.chatroom.model.interact.i0 r2) {
        this.$$delegate_0.setKtvLiveCoreInfo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.d7
    public int getScene() {
        return ((Number) get(1, d7.class, 0)).intValue();
    }

    public IMultiLiveCoreInfoExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.u1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
