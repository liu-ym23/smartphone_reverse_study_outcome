package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010-\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R(\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\u0010\f\u001a\u0004\u0018\u00010\u001a8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010%\u001a\u0004\u0018\u00010 2\b\u0010\f\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizReplyMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/x0;", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBizReplyMessage;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getInviteType", "()I", "setInviteType", "(I)V", "inviteType", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "bizType", "getRepCode", "setRepCode", "repCode", "Lcom/bytedance/android/livesdk/link/model/h5;", "getLinkMicBizExtra", "()Lcom/bytedance/android/livesdk/link/model/h5;", "setLinkMicBizExtra", "(Lcom/bytedance/android/livesdk/link/model/h5;)V", "linkMicBizExtra", "", "getRejectPrompts", "()Ljava/lang/String;", "setRejectPrompts", "(Ljava/lang/String;)V", "rejectPrompts", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/x0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBizReplyMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.x0, ILinkMicBizReplyMessage> implements ILinkMicBizReplyMessage, com.bytedance.android.livesdk.link.model.bridge.x0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.x0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage, com.bytedance.android.livesdk.link.model.bridge.x0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.x0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage, com.bytedance.android.livesdk.link.model.bridge.x0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.x0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public Integer getBizType() {
        return (Integer) get(2, ILinkMicBizReplyMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage, com.bytedance.android.livesdk.link.model.bridge.x0
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public h5 getLinkMicBizExtra() {
        return (h5) get(5, ILinkMicBizReplyMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public String getRejectPrompts() {
        return (String) get(6, ILinkMicBizReplyMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public Integer getRepCode() {
        return (Integer) get(4, ILinkMicBizReplyMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage, com.bytedance.android.livesdk.link.model.bridge.x0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public int getInviteType() {
        return ((Number) get(3, ILinkMicBizReplyMessage.class, 0)).intValue();
    }

    public ILinkMicBizReplyMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.x0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public void setBizType(Integer r4) {
        set(2, "biz_type", ILinkMicBizReplyMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public void setInviteType(int r4) {
        set(3, "invite_type", ILinkMicBizReplyMessage.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public void setLinkMicBizExtra(h5 r4) {
        set(5, "battle_config_setting", ILinkMicBizReplyMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public void setRejectPrompts(String r4) {
        set(6, "reject_prompts", ILinkMicBizReplyMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizReplyMessage
    public void setRepCode(Integer r4) {
        set(4, "rep_code", ILinkMicBizReplyMessage.class, r4);
    }
}
