package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001d\u001a\u00020\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0014\u0010!\u001a\u00020\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0014\u0010%\u001a\u00020\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b$\u0010 ¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IAnchorLinkmicBackstageInviteMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/l;", "Lcom/bytedance/android/livesdk/link/model/s;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/android/live/base/model/message/m0;", "value", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "", "getBizType", "()I", "bizType", "getInviteSource", "inviteSource", "getInviteType", "inviteType", "getMatchType", "matchType", "getScene", "scene", "", "getToRevInviteeFollowedUserIds", "()Ljava/lang/String;", "toRevInviteeFollowedUserIds", "getToRevUid", "toRevUid", "getToRoomId", "toRoomId", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/l;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IAnchorLinkmicBackstageInviteMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.l, s> implements s, com.bytedance.android.livesdk.link.model.bridge.l {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.l $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.l>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.l>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public int getBizType() {
        return this.$$delegate_0.getBizType();
    }

    @Override // com.bytedance.android.livesdk.link.model.s
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return (com.bytedance.android.live.base.model.message.m0) get(1, s.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public int getInviteSource() {
        return this.$$delegate_0.getInviteSource();
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public int getInviteType() {
        return this.$$delegate_0.getInviteType();
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public int getMatchType() {
        return this.$$delegate_0.getMatchType();
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public int getScene() {
        return this.$$delegate_0.getScene();
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public String getToRevInviteeFollowedUserIds() {
        return this.$$delegate_0.getToRevInviteeFollowedUserIds();
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public String getToRevUid() {
        return this.$$delegate_0.getToRevUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.s, com.bytedance.android.livesdk.link.model.bridge.l
    public String getToRoomId() {
        return this.$$delegate_0.getToRoomId();
    }

    public IAnchorLinkmicBackstageInviteMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.l r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.s
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r4) {
        set(1, "common", s.class, r4);
    }
}
