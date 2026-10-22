package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0014\u0010&\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\rR\u0016\u0010(\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\rR\u0016\u0010*\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\r¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorPermitDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/m;", "Lcom/bytedance/android/livesdk/link/model/v;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getLinkMicIdStr", "()Ljava/lang/String;", "linkMicIdStr", "", "getLinkMicId", "()J", "linkMicId", "getRtcExtInfo", "rtcExtInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "getChannelId", "channelId", "Lcom/bytedance/android/livesdk/link/model/m;", "getLayoutInfo", "()Lcom/bytedance/android/livesdk/link/model/m;", "layoutInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getApplyVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "applyVersionInfo", "getFromUid", "fromUid", "getToUid", "toUid", "getLynxData", "lynxData", "getEventTrackingInfo", "eventTrackingInfo", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/m;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAnchorPermitDataExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.m, v> implements v, com.bytedance.android.livesdk.link.model.bridge.m {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.m $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.v, com.bytedance.android.livesdk.link.model.bridge.m
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v, com.bytedance.android.livesdk.link.model.bridge.m
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public com.bytedance.android.livesdk.link.model.bridge.k2 getApplyVersionInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.k2) get(20, v.class, com.bytedance.android.livesdk.link.model.bridge.k2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public long getChannelId() {
        return ((Number) get(8, v.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public String getEventTrackingInfo() {
        return (String) get(22, v.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public String getFromUid() {
        return (String) get(5000, v.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public m getLayoutInfo() {
        return (m) get(19, v.class, m.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public long getLinkMicId() {
        return ((Number) get(2, v.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public String getLinkMicIdStr() {
        return (String) get(14, v.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public String getLynxData() {
        return (String) get(21, v.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public b7 getMultiChannelInfo() {
        return (b7) get(15, v.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public String getRtcExtInfo() {
        return (String) get(5, v.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v
    public String getToUid() {
        return (String) get(5001, v.class, "");
    }

    public IAnchorPermitDataExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.m r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
