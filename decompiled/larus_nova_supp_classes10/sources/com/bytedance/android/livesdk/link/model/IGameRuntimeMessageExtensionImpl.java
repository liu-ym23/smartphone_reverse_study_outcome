package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010 \u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010'\u001a\n\u0018\u00010!j\u0004\u0018\u0001`\"8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IGameRuntimeMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/h0;", "Lcom/bytedance/android/livesdk/link/model/IGameRuntimeMessage;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getRuntimeType", "()I", "setRuntimeType", "(I)V", "runtimeType", "", "getGameId", "()Ljava/lang/Long;", "setGameId", "(Ljava/lang/Long;)V", "gameId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appId", "getLinkGameId", "setLinkGameId", "linkGameId", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/h0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IGameRuntimeMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.h0, IGameRuntimeMessage> implements IGameRuntimeMessage, com.bytedance.android.livesdk.link.model.bridge.h0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.h0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage, com.bytedance.android.livesdk.link.model.bridge.h0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage, com.bytedance.android.livesdk.link.model.bridge.h0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.h0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public String getAppId() {
        return (String) get(6, IGameRuntimeMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage, com.bytedance.android.livesdk.link.model.bridge.h0
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public Long getGameId() {
        return (Long) get(5, IGameRuntimeMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public Long getLinkGameId() {
        return (Long) get(7, IGameRuntimeMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage, com.bytedance.android.livesdk.link.model.bridge.h0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public int getRuntimeType() {
        return ((Number) get(2, IGameRuntimeMessage.class, 0)).intValue();
    }

    public IGameRuntimeMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.h0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public void setAppId(String r4) {
        set(6, "app_id", IGameRuntimeMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public void setGameId(Long r4) {
        set(5, "game_id", IGameRuntimeMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public void setLinkGameId(Long r4) {
        set(7, "link_game_id", IGameRuntimeMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IGameRuntimeMessage
    public void setRuntimeType(int r4) {
        set(2, "runtime_type", IGameRuntimeMessage.class, Integer.valueOf(r4));
    }
}
