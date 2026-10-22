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
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00103\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010&R$\u00102\u001a\n\u0018\u00010,j\u0004\u0018\u0001`-8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/r0;", "Lcom/bytedance/android/livesdk/link/model/c5;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "", "Lcom/bytedance/android/livesdk/link/model/IBattleUserInfo;", "getBattleUserInfoMap", "()Ljava/util/Map;", "battleUserInfoMap", "Lcom/bytedance/android/livesdk/link/model/u1;", "getBattleSetting", "()Lcom/bytedance/android/livesdk/link/model/u1;", "battleSetting", "", "getSkinType", "()I", "skinType", "Lcom/bytedance/android/livesdk/link/model/x2;", "getSkinConfig", "()Lcom/bytedance/android/livesdk/link/model/x2;", "skinConfig", "", "getCanSwitchMulti", "()Z", "canSwitchMulti", "Lcom/bytedance/android/livesdk/link/model/t4;", "getLinkIconConfig", "()Lcom/bytedance/android/livesdk/link/model/t4;", "linkIconConfig", "getRequestSource", "()Ljava/lang/String;", "requestSource", "getEventTrackingInfo", "eventTrackingInfo", "getBattleAttachedInfo", "battleAttachedInfo", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/r0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBattleMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.r0, c5> implements c5, com.bytedance.android.livesdk.link.model.bridge.r0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.r0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.c5, com.bytedance.android.livesdk.link.model.bridge.r0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.r0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5, com.bytedance.android.livesdk.link.model.bridge.r0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.r0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public u1 getBattleSetting() {
        return (u1) get(2, c5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5, com.bytedance.android.livesdk.link.model.bridge.r0
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.c5, com.bytedance.android.livesdk.link.model.bridge.r0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public String getBattleAttachedInfo() {
        return (String) get(15, c5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public Map<String, IBattleUserInfo> getBattleUserInfoMap() {
        return (Map) get(5000, c5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public boolean getCanSwitchMulti() {
        return ((Boolean) get(10, c5.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public String getEventTrackingInfo() {
        return (String) get(14, c5.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public t4 getLinkIconConfig() {
        return (t4) get(12, c5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public String getRequestSource() {
        return (String) get(13, c5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public x2 getSkinConfig() {
        return (x2) get(11, c5.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.c5
    public int getSkinType() {
        return ((Number) get(5, c5.class, 0)).intValue();
    }

    public ILinkMicBattleMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
