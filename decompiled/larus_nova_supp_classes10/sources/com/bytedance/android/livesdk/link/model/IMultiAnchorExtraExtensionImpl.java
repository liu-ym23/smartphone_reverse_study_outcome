package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMultiAnchorExtraExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "Lcom/bytedance/android/livesdk/link/model/x6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getMatchType", "()J", "matchType", "", "", "getRoleLinkMicMap", "()Ljava/util/Map;", "roleLinkMicMap", "", "getInviteRole", "()I", "inviteRole", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/n1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiAnchorExtraExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.n1, x6> implements x6, com.bytedance.android.livesdk.link.model.bridge.n1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.n1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.x6, com.bytedance.android.livesdk.link.model.bridge.n1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.n1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.x6, com.bytedance.android.livesdk.link.model.bridge.n1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.n1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.x6, com.bytedance.android.livesdk.link.model.bridge.n1
    public int getInviteRole() {
        return this.$$delegate_0.getInviteRole();
    }

    @Override // com.bytedance.android.livesdk.link.model.x6
    public Map<Long, String> getRoleLinkMicMap() {
        return (Map) get(3, x6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.x6
    public long getMatchType() {
        return ((Number) get(2, x6.class, 0L)).longValue();
    }

    public IMultiAnchorExtraExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.n1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
