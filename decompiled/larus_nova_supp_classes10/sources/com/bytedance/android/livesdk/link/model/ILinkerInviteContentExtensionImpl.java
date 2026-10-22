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
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010i\u001a\u00020\u0002¢\u0006\u0004\bj\u0010kJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0014\u0010&\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010.\u001a\u0004\u0018\u00010+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010%R\u0014\u00102\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010%R\u0016\u00104\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001bR\u001c\u00109\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\rR\u0014\u0010=\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\u001fR\u0014\u0010A\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010C\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010%R\u0014\u0010E\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010%R\u0014\u0010I\u001a\u00020F8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR(\u0010P\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010J8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\rR\u0016\u0010T\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010%R\u0014\u0010V\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010@R\u0016\u0010X\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010%R\u0016\u0010Z\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010%R\u0014\u0010\\\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b[\u0010%R\u0014\u0010^\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b]\u0010%R\u0014\u0010`\u001a\u00020>8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b_\u0010@R(\u0010d\u001a\u0016\u0012\u0004\u0012\u00020a\u0018\u000105j\n\u0012\u0004\u0012\u00020a\u0018\u0001`b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bc\u00108R(\u0010f\u001a\u0016\u0012\u0004\u0012\u00020a\u0018\u000105j\n\u0012\u0004\u0012\u00020a\u0018\u0001`b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\be\u00108R\u0014\u0010h\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bg\u0010\u001f¨\u0006l"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkerInviteContentExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/g1;", "Lcom/bytedance/android/livesdk/link/model/e6;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getFromRoomId", "()J", "fromRoomId", "getToRoomId", "toRoomId", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "Lcom/bytedance/android/livesdk/link/model/j5;", "getFromLinkMicInfo", "()Lcom/bytedance/android/livesdk/link/model/j5;", "fromLinkMicInfo", "Lcom/bytedance/android/livesdk/link/model/p;", "getAppliedUser", "()Lcom/bytedance/android/livesdk/link/model/p;", "appliedUser", "", "getSupportMultiInvite", "()Z", "supportMultiInvite", "getCurInviteNum", "curInviteNum", "", "getToLinkMicIdStr", "()Ljava/lang/String;", "toLinkMicIdStr", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "getToRtcExtInfo", "toRtcExtInfo", "getClientAttachedInfoStr", "clientAttachedInfoStr", "getInviteUser", "inviteUser", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "getTags", "()Ljava/util/List;", "tags", "getWaitSec", "waitSec", "getSupportMultiPkTeamMode", "supportMultiPkTeamMode", "", "getMultiPkMode", "()I", "multiPkMode", "getInviteRejectTemporaryText", "inviteRejectTemporaryText", "getGameAppId", "gameAppId", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getInviterVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "inviterVersionInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "value", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "setPreRtcInfo", "(Lcom/bytedance/android/livesdk/link/model/bridge/b2;)V", "preRtcInfo", "getToJoinChannelId", "toJoinChannelId", "getBattleAttachedInfoStr", "battleAttachedInfoStr", "getBizType", "bizType", "getPeerDesc", "peerDesc", "getEventTrackingInfo", "eventTrackingInfo", "get_fromUid", "_fromUid", "get_secFromUid", "_secFromUid", "getInviteSource", "inviteSource", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getInviteeFollowUsers", "inviteeFollowUsers", "getInviterUsers", "inviterUsers", "getInviterWithAudience", "inviterWithAudience", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/g1;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkerInviteContentExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.g1, e6> implements e6, com.bytedance.android.livesdk.link.model.bridge.g1 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.g1 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g1>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.g1>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public int getInviteSource() {
        return this.$$delegate_0.getInviteSource();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getInviteeFollowUsers() {
        return this.$$delegate_0.getInviteeFollowUsers();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public List<com.bytedance.android.livesdk.link.model.bridge.k> getInviterUsers() {
        return this.$$delegate_0.getInviterUsers();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public boolean getInviterWithAudience() {
        return this.$$delegate_0.getInviterWithAudience();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public String get_fromUid() {
        return this.$$delegate_0.get_fromUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6, com.bytedance.android.livesdk.link.model.bridge.g1
    public String get_secFromUid() {
        return this.$$delegate_0.get_secFromUid();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public p getAppliedUser() {
        return (p) get(25, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getBattleAttachedInfoStr() {
        return (String) get(38, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public int getBizType() {
        return ((Number) get(39, e6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getClientAttachedInfoStr() {
        return (String) get(32, e6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public long getCurInviteNum() {
        return ((Number) get(28, e6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getEventTrackingInfo() {
        return (String) get(42, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public j5 getFromLinkMicInfo() {
        return (j5) get(11, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public long getFromRoomId() {
        return ((Number) get(2, e6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getGameAppId() {
        return (String) get(37, e6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getInviteRejectTemporaryText() {
        return (String) get(18, e6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public p getInviteUser() {
        return (p) get(31, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public com.bytedance.android.livesdk.link.model.bridge.k2 getInviterVersionInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.k2) get(33, e6.class, com.bytedance.android.livesdk.link.model.bridge.k2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public b7 getMultiChannelInfo() {
        return (b7) get(17, e6.class, b7.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(13, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public int getMultiPkMode() {
        return ((Number) get(14, e6.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(12, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getPeerDesc() {
        return (String) get(45, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(26, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public boolean getSupportMultiInvite() {
        return ((Boolean) get(27, e6.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public boolean getSupportMultiPkTeamMode() {
        return ((Boolean) get(15, e6.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public List<IBattleRivalTag> getTags() {
        return (List) get(30, e6.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public long getToJoinChannelId() {
        return ((Number) get(34, e6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getToLinkMicIdStr() {
        return (String) get(7, e6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public long getToRoomId() {
        return ((Number) get(24, e6.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public String getToRtcExtInfo() {
        return (String) get(3, e6.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public long getWaitSec() {
        return ((Number) get(29, e6.class, 0L)).longValue();
    }

    public ILinkerInviteContentExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.g1 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.e6
    public void setPreRtcInfo(com.bytedance.android.livesdk.link.model.bridge.b2 r4) {
        set(26, "pre_rtc_info", e6.class, r4);
    }
}
