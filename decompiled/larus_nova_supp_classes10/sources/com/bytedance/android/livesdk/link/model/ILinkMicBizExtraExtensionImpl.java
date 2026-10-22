package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizExtraExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/v0;", "Lcom/bytedance/android/livesdk/link/model/h5;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/link/model/j7;", "getOpenGameConfig", "()Lcom/bytedance/android/livesdk/link/model/j7;", "openGameConfig", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/v0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBizExtraExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.v0, h5> implements h5, com.bytedance.android.livesdk.link.model.bridge.v0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.v0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.h5, com.bytedance.android.livesdk.link.model.bridge.v0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.v0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.h5, com.bytedance.android.livesdk.link.model.bridge.v0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.v0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.h5, com.bytedance.android.livesdk.link.model.bridge.v0
    public j7 getOpenGameConfig() {
        return (j7) get(1, h5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.h5, com.bytedance.android.livesdk.link.model.bridge.v0
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.x1 getOpenGameConfig() {
        return getOpenGameConfig();
    }

    public ILinkMicBizExtraExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.v0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
