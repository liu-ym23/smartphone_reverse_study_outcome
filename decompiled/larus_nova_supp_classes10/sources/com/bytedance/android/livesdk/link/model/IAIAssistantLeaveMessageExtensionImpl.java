package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001a8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u001c¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAIAssistantLeaveMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/b;", "Lcom/bytedance/android/livesdk/link/model/c;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "Lcom/bytedance/android/livesdk/link/model/bridge/d;", "getAIUser", "()Lcom/bytedance/android/livesdk/link/model/bridge/d;", "AIUser", "", "getAIUserType", "()Ljava/lang/Integer;", "AIUserType", "", "getChannelId", "()Ljava/lang/String;", "channelId", "getLeaveReason", "leaveReason", "getToast", "toast", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/b;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAIAssistantLeaveMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.b, c> implements c, com.bytedance.android.livesdk.link.model.bridge.b {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.b $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.b>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.b>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public com.bytedance.android.livesdk.link.model.bridge.d getAIUser() {
        return this.$$delegate_0.getAIUser();
    }

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public Integer getAIUserType() {
        return this.$$delegate_0.getAIUserType();
    }

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public String getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // com.bytedance.android.livesdk.link.model.c
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return (com.bytedance.android.live.base.model.message.m0) get(1, c.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public String getLeaveReason() {
        return this.$$delegate_0.getLeaveReason();
    }

    @Override // com.bytedance.android.livesdk.link.model.c, com.bytedance.android.livesdk.link.model.bridge.b
    public String getToast() {
        return this.$$delegate_0.getToast();
    }

    public IAIAssistantLeaveMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.b r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.c
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r4) {
        set(1, "common", c.class, r4);
    }
}
