package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\u0017\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IOpenGameConfigExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/x1;", "Lcom/bytedance/android/livesdk/link/model/j7;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getGameAppId", "()Ljava/lang/String;", "gameAppId", "getGameExtra", "gameExtra", "getGameTitle", "gameTitle", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIconImage", "()Lpy/k;", "iconImage", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/x1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IOpenGameConfigExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.x1, j7> implements j7, com.bytedance.android.livesdk.link.model.bridge.x1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.x1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.j7, com.bytedance.android.livesdk.link.model.bridge.x1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.x1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.j7, com.bytedance.android.livesdk.link.model.bridge.x1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.x1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.j7, com.bytedance.android.livesdk.link.model.bridge.x1
    public String getGameAppId() {
        return this.$$delegate_0.getGameAppId();
    }

    @Override // com.bytedance.android.livesdk.link.model.j7, com.bytedance.android.livesdk.link.model.bridge.x1
    public String getGameExtra() {
        return this.$$delegate_0.getGameExtra();
    }

    @Override // com.bytedance.android.livesdk.link.model.j7, com.bytedance.android.livesdk.link.model.bridge.x1
    public String getGameTitle() {
        return this.$$delegate_0.getGameTitle();
    }

    @Override // com.bytedance.android.livesdk.link.model.j7, com.bytedance.android.livesdk.link.model.bridge.x1
    public py.k getIconImage() {
        return this.$$delegate_0.getIconImage();
    }

    public IOpenGameConfigExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.x1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
