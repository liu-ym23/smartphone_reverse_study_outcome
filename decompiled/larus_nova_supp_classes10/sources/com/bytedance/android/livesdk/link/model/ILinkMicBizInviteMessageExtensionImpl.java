package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010B\u001a\u00020\u0002¢\u0006\u0004\bC\u0010DJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R$\u0010.\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R$\u00101\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R$\u00104\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR(\u0010:\u001a\u0004\u0018\u0001052\b\u0010\f\u001a\u0004\u0018\u0001058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010A\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006E"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkMicBizInviteMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/w0;", "Lcom/bytedance/android/livesdk/link/model/ILinkMicBizInviteMessage;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getInviteType", "()I", "setInviteType", "(I)V", "inviteType", "getBizType", "()Ljava/lang/Integer;", "setBizType", "(Ljava/lang/Integer;)V", "bizType", "", "getInviteUid", "()J", "setInviteUid", "(J)V", "inviteUid", "", "getInviteName", "()Ljava/lang/String;", "setInviteName", "(Ljava/lang/String;)V", "inviteName", "Lcom/bytedance/android/livesdk/link/model/p;", "getInviteUser", "()Lcom/bytedance/android/livesdk/link/model/p;", "inviteUser", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "getTags", "()Ljava/util/List;", "tags", "getInviteTitle", "setInviteTitle", "inviteTitle", "getInviteSubTitle", "setInviteSubTitle", "inviteSubTitle", "getWaitSec", "setWaitSec", "waitSec", "Lcom/bytedance/android/livesdk/link/model/h5;", "getLinkMicBizExtra", "()Lcom/bytedance/android/livesdk/link/model/h5;", "setLinkMicBizExtra", "(Lcom/bytedance/android/livesdk/link/model/h5;)V", "linkMicBizExtra", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/w0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkMicBizInviteMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.w0, ILinkMicBizInviteMessage> implements ILinkMicBizInviteMessage, com.bytedance.android.livesdk.link.model.bridge.w0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.w0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage, com.bytedance.android.livesdk.link.model.bridge.w0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.w0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage, com.bytedance.android.livesdk.link.model.bridge.w0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.w0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public Integer getBizType() {
        return (Integer) get(2, ILinkMicBizInviteMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage, com.bytedance.android.livesdk.link.model.bridge.w0
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage, com.bytedance.android.livesdk.link.model.bridge.w0
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public String getInviteName() {
        return (String) get(7, ILinkMicBizInviteMessage.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public String getInviteSubTitle() {
        return (String) get(11, ILinkMicBizInviteMessage.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public String getInviteTitle() {
        return (String) get(10, ILinkMicBizInviteMessage.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public int getInviteType() {
        return ((Number) get(3, ILinkMicBizInviteMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public long getInviteUid() {
        return ((Number) get(6, ILinkMicBizInviteMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public p getInviteUser() {
        return (p) get(9, ILinkMicBizInviteMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public h5 getLinkMicBizExtra() {
        return (h5) get(15, ILinkMicBizInviteMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public List<IBattleRivalTag> getTags() {
        return (List) get(8, ILinkMicBizInviteMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public long getWaitSec() {
        return ((Number) get(12, ILinkMicBizInviteMessage.class, 0L)).longValue();
    }

    public ILinkMicBizInviteMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.w0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setBizType(Integer r4) {
        set(2, "biz_type", ILinkMicBizInviteMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setInviteName(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(7, "invite_name", ILinkMicBizInviteMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setInviteSubTitle(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(11, "invite_sub_title", ILinkMicBizInviteMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setInviteTitle(String r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(10, "invite_title", ILinkMicBizInviteMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setInviteType(int r4) {
        set(3, "invite_type", ILinkMicBizInviteMessage.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setInviteUid(long r3) {
        set(6, "invite_uid", ILinkMicBizInviteMessage.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setLinkMicBizExtra(h5 r4) {
        set(15, "link_mic_biz_extra", ILinkMicBizInviteMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.ILinkMicBizInviteMessage
    public void setWaitSec(long r3) {
        set(12, "wait_sec", ILinkMicBizInviteMessage.class, Long.valueOf(r3));
    }
}
