package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00101\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u001c\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0011R\u0014\u0010\"\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u0014\u0010$\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\rR\u0014\u0010&\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u0016\u0010)\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R$\u00100\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleInviteMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/p0;", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBattleInviteMessage;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getChannelId", "()J", "channelId", "", "getInviteType", "()I", "inviteType", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "battleConfigSetting", "getDurationTime", "durationTime", "", "getClientAttachedInfoStr", "()Ljava/lang/String;", "clientAttachedInfoStr", "getInviteTitle", "inviteTitle", "getMultiPkMode", "multiPkMode", "getPrompts", "prompts", "getBattleId", "battleId", "getEventTrackingInfo", "eventTrackingInfo", "get_inviteUid", "()Ljava/lang/Long;", "_inviteUid", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/p0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBattleInviteMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.p0, ILinkMicBattleInviteMessage> implements ILinkMicBattleInviteMessage, com.bytedance.android.livesdk.link.model.bridge.p0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.p0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage, com.bytedance.android.livesdk.link.model.bridge.p0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.p0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage, com.bytedance.android.livesdk.link.model.bridge.p0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.p0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage, com.bytedance.android.livesdk.link.model.bridge.p0
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage, com.bytedance.android.livesdk.link.model.bridge.p0
    public Long get_inviteUid() {
        return this.$$delegate_0.get_inviteUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage, com.bytedance.android.livesdk.link.model.bridge.p0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public IBattleConfigSetting getBattleConfigSetting() {
        return (IBattleConfigSetting) get(14, ILinkMicBattleInviteMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public long getBattleId() {
        return ((Number) get(6, ILinkMicBattleInviteMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public long getChannelId() {
        return ((Number) get(3, ILinkMicBattleInviteMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public String getClientAttachedInfoStr() {
        return (String) get(17, ILinkMicBattleInviteMessage.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public long getDurationTime() {
        return ((Number) get(15, ILinkMicBattleInviteMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public String getEventTrackingInfo() {
        return (String) get(19, ILinkMicBattleInviteMessage.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public String getInviteTitle() {
        return (String) get(10, ILinkMicBattleInviteMessage.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public int getInviteType() {
        return ((Number) get(2, ILinkMicBattleInviteMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public int getMultiPkMode() {
        return ((Number) get(16, ILinkMicBattleInviteMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBattleInviteMessage
    public String getPrompts() {
        return (String) get(7, ILinkMicBattleInviteMessage.class, "");
    }

    public ILinkMicBattleInviteMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.p0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
