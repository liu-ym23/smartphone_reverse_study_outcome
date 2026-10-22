package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IListUserContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/k1;", "Lcom/bytedance/android/livesdk/link/model/v6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/livesdk/link/model/bridge/l1;", "getLinkMicAudienceContent", "()Lcom/bytedance/android/livesdk/link/model/bridge/l1;", "setLinkMicAudienceContent", "(Lcom/bytedance/android/livesdk/link/model/bridge/l1;)V", "linkMicAudienceContent", "Lcom/bytedance/android/livesdk/link/model/bridge/m1;", "getLinkMicContent", "()Lcom/bytedance/android/livesdk/link/model/bridge/m1;", "setLinkMicContent", "(Lcom/bytedance/android/livesdk/link/model/bridge/m1;)V", "linkMicContent", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/k1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IListUserContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.k1, v6> implements v6, com.bytedance.android.livesdk.link.model.bridge.k1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.k1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.v6, com.bytedance.android.livesdk.link.model.bridge.k1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.k1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v6, com.bytedance.android.livesdk.link.model.bridge.k1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.k1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v6, com.bytedance.android.livesdk.link.model.bridge.k1
    public com.bytedance.android.livesdk.link.model.bridge.l1 getLinkMicAudienceContent() {
        return this.$$delegate_0.getLinkMicAudienceContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.v6, com.bytedance.android.livesdk.link.model.bridge.k1
    public com.bytedance.android.livesdk.link.model.bridge.m1 getLinkMicContent() {
        return this.$$delegate_0.getLinkMicContent();
    }

    @Override // com.bytedance.android.livesdk.link.model.v6, com.bytedance.android.livesdk.link.model.bridge.k1
    public void setLinkMicAudienceContent(com.bytedance.android.livesdk.link.model.bridge.l1 r2) {
        this.$$delegate_0.setLinkMicAudienceContent(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v6, com.bytedance.android.livesdk.link.model.bridge.k1
    public void setLinkMicContent(com.bytedance.android.livesdk.link.model.bridge.m1 r2) {
        this.$$delegate_0.setLinkMicContent(r2);
    }

    public IListUserContentExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.k1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
