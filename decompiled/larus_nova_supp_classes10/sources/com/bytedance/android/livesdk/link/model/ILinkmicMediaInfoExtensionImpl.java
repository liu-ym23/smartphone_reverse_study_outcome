package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001c\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkmicMediaInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "Lcom/bytedance/android/livesdk/link/model/s6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getRtcExtInfo", "()Ljava/lang/String;", "rtcExtInfo", "getLinkMicIdStr", "linkMicIdStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "getBizTag", "bizTag", "getLiveCoreExtInfo", "liveCoreExtInfo", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/j1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkmicMediaInfoExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.j1, s6> implements s6, com.bytedance.android.livesdk.link.model.bridge.j1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.j1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.j1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public String getBizTag() {
        return this.$$delegate_0.getBizTag();
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public String getLiveCoreExtInfo() {
        return this.$$delegate_0.getLiveCoreExtInfo();
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(5, s6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(4, s6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public String getLinkMicIdStr() {
        return (String) get(2, s6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public String getRtcExtInfo() {
        return (String) get(1, s6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.s6, com.bytedance.android.livesdk.link.model.bridge.j1
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo() {
        return getMultiLiveCoreInfo();
    }

    public ILinkmicMediaInfoExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.j1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
