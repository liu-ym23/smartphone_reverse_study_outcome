package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAIAssistantSilenceStatusMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/c;", "Lcom/bytedance/android/livesdk/link/model/d;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "", "getAIUserId", "()Ljava/lang/String;", "AIUserId", "getChannelId", "channelId", "", "getSilenceStatus", "()Ljava/lang/Integer;", "silenceStatus", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/c;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAIAssistantSilenceStatusMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.c, d> implements d, com.bytedance.android.livesdk.link.model.bridge.c {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.c $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.d, com.bytedance.android.livesdk.link.model.bridge.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.c>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.d, com.bytedance.android.livesdk.link.model.bridge.c
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.c>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.d, com.bytedance.android.livesdk.link.model.bridge.c
    public String getAIUserId() {
        return this.$$delegate_0.getAIUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.d, com.bytedance.android.livesdk.link.model.bridge.c
    public String getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // com.bytedance.android.livesdk.link.model.d
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return (com.bytedance.android.live.base.model.message.m0) get(1, d.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.d, com.bytedance.android.livesdk.link.model.bridge.c
    public Integer getSilenceStatus() {
        return this.$$delegate_0.getSilenceStatus();
    }

    public IAIAssistantSilenceStatusMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.c r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.d
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r4) {
        set(1, "common", d.class, r4);
    }
}
