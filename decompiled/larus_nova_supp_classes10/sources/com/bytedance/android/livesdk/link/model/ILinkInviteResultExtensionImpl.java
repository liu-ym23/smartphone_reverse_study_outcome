package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010S\u001a\u00020\u0002¢\u0006\u0004\bT\u0010UJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0011R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0016\u00100\u001a\u0004\u0018\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010)R\u0014\u00106\u001a\u0002038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0016\u0010:\u001a\u0004\u0018\u0001078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0011R\u0014\u0010>\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010)R\u0014\u0010B\u001a\u00020?8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010D\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0011R\u0016\u0010F\u001a\u0004\u0018\u00010\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0011R\u001c\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010G8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0018\u0010M\u001a\u00060\u0015j\u0002`K8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bL\u0010\u0017R\u0014\u0010O\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bN\u0010\rR\u0018\u0010R\u001a\u00060\u0015j\u0002`P8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010\u0017¨\u0006V"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ILinkInviteResultExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/m0;", "Lcom/bytedance/android/livesdk/link/model/v4;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getSupportMultiInvite", "()Z", "supportMultiInvite", "", "getLinkMicIdStr", "()Ljava/lang/String;", "linkMicIdStr", "getRtcExtInfo", "rtcExtInfo", "", "getWaitSec", "()J", "waitSec", "Lcom/bytedance/android/livesdk/link/model/d7;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/d7;", "multiLiveCoreInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/b7;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/b7;", "multiChannelInfo", "getToast", "toast", "", "getPkCheckState", "()I", "pkCheckState", "getSwitchPlayMode", "switchPlayMode", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/aa;", "voteSetting", "getVendor", "vendor", "Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "getVersionInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/k2;", "versionInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "getPreRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/b2;", "preRtcInfo", "getBattleAttachedInfo", "battleAttachedInfo", "getBizType", "bizType", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getInviteeRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "inviteeRoom", "getLynxData", "lynxData", "getEventTrackingInfo", "eventTrackingInfo", "", "get_cannotPkAnchorIds", "()Ljava/util/List;", "_cannotPkAnchorIds", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/ChannelId;", "getChannelId", "channelId", "getInviteeWithAudience", "inviteeWithAudience", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getScene", "scene", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/m0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class ILinkInviteResultExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.m0, v4> implements v4, com.bytedance.android.livesdk.link.model.bridge.m0 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.m0 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.v4, com.bytedance.android.livesdk.link.model.bridge.m0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m0>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4, com.bytedance.android.livesdk.link.model.bridge.m0
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.m0>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4, com.bytedance.android.livesdk.link.model.bridge.m0
    public long getChannelId() {
        return this.$$delegate_0.getChannelId();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4, com.bytedance.android.livesdk.link.model.bridge.m0
    public boolean getInviteeWithAudience() {
        return this.$$delegate_0.getInviteeWithAudience();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4, com.bytedance.android.livesdk.link.model.bridge.m0
    public long getScene() {
        return this.$$delegate_0.getScene();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4, com.bytedance.android.livesdk.link.model.bridge.m0
    public List<String> get_cannotPkAnchorIds() {
        return this.$$delegate_0.get_cannotPkAnchorIds();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public String getBattleAttachedInfo() {
        return (String) get(27, v4.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public int getBizType() {
        return ((Number) get(29, v4.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public String getEventTrackingInfo() {
        return (String) get(31, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public IRoom getInviteeRoom() {
        return (IRoom) get(28, v4.class, IRoom.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public String getLinkMicIdStr() {
        return (String) get(10, v4.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public String getLynxData() {
        return (String) get(30, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public b7 getMultiChannelInfo() {
        return (b7) get(16, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public d7 getMultiLiveCoreInfo() {
        return (d7) get(14, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.v1) get(13, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public int getPkCheckState() {
        return ((Number) get(19, v4.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public com.bytedance.android.livesdk.link.model.bridge.b2 getPreRtcInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.b2) get(23, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public String getRtcExtInfo() {
        return (String) get(6, v4.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public boolean getSupportMultiInvite() {
        return ((Boolean) get(24, v4.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public int getSwitchPlayMode() {
        return ((Number) get(21, v4.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public String getToast() {
        return (String) get(17, v4.class, "");
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public int getVendor() {
        return ((Number) get(2, v4.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public com.bytedance.android.livesdk.link.model.bridge.k2 getVersionInfo() {
        return (com.bytedance.android.livesdk.link.model.bridge.k2) get(26, v4.class, com.bytedance.android.livesdk.link.model.bridge.k2.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public aa getVoteSetting() {
        return (aa) get(22, v4.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.v4
    public long getWaitSec() {
        return ((Number) get(25, v4.class, 0L)).longValue();
    }

    public ILinkInviteResultExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.m0 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
