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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tRD\u0010\u0014\u001a*\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bj\u0014\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IMultiChannelInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "Lcom/bytedance/android/livesdk/link/model/b7;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/RoomId;", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getChannelMap", "()Ljava/util/Map;", "setChannelMap", "(Ljava/util/Map;)V", "channelMap", "", "getUseMultiChannel", "()Z", "setUseMultiChannel", "(Z)V", "useMultiChannel", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/s1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMultiChannelInfoExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.s1, b7> implements b7, com.bytedance.android.livesdk.link.model.bridge.s1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.s1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.b7, com.bytedance.android.livesdk.link.model.bridge.s1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.s1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.b7, com.bytedance.android.livesdk.link.model.bridge.s1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.s1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.b7, com.bytedance.android.livesdk.link.model.bridge.s1
    public Map<Long, String> getChannelMap() {
        return this.$$delegate_0.getChannelMap();
    }

    @Override // com.bytedance.android.livesdk.link.model.b7, com.bytedance.android.livesdk.link.model.bridge.s1
    public boolean getUseMultiChannel() {
        return this.$$delegate_0.getUseMultiChannel();
    }

    @Override // com.bytedance.android.livesdk.link.model.b7, com.bytedance.android.livesdk.link.model.bridge.s1
    public void setChannelMap(Map<Long, String> r2) {
        this.$$delegate_0.setChannelMap(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.b7, com.bytedance.android.livesdk.link.model.bridge.s1
    public void setUseMultiChannel(boolean r2) {
        this.$$delegate_0.setUseMultiChannel(r2);
    }

    public IMultiChannelInfoExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.s1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
