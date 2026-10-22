package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010]\u001a\u00020\u0002¢\u0006\u0004\b^\u0010_J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010&\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R(\u0010)\u001a\u0004\u0018\u00010\u001e2\b\u0010\f\u001a\u0004\u0018\u00010\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R(\u0010,\u001a\u0004\u0018\u00010\u00182\b\u0010\f\u001a\u0004\u0018\u00010\u00188V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR(\u0010/\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R$\u00102\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R$\u00107\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R(\u0010:\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R(\u0010=\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0014\"\u0004\b<\u0010\u0016R(\u0010@\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010\u0014\"\u0004\b?\u0010\u0016R$\u0010C\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010R$\u0010I\u001a\u00020D2\u0006\u0010\f\u001a\u00020D8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR<\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120J2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120J8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010R\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bP\u00104\"\u0004\bQ\u00106R$\u0010U\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bS\u0010\u000e\"\u0004\bT\u0010\u0010R$\u0010\\\u001a\n\u0018\u00010Vj\u0004\u0018\u0001`W8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006`"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IProfitGameStatusMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/e2;", "Lcom/bytedance/android/livesdk/link/model/IProfitGameStatusMessage;", "Lvh7/e;", "R", "Ljava/lang/Class;", LocationMonitorConst.TYPE, "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getGameStatus", "()I", "setGameStatus", "(I)V", "gameStatus", "", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "roomId", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "setStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)V", "streamUrl", "", "getGameId", "()Ljava/lang/Long;", "setGameId", "(Ljava/lang/Long;)V", "gameId", "getAppId", "setAppId", "appId", "getLinkGameId", "setLinkGameId", "linkGameId", "getAndStreamUrl", "setAndStreamUrl", "andStreamUrl", "getGameExtra", "setGameExtra", "gameExtra", "getPushStreamType", "setPushStreamType", "pushStreamType", "getGameType", "()J", "setGameType", "(J)V", "gameType", "getInitParam", "setInitParam", "initParam", "getAnchorOpenId", "setAnchorOpenId", "anchorOpenId", "getLinkerExtra", "setLinkerExtra", "linkerExtra", "getBizEndReasonType", "setBizEndReasonType", "bizEndReasonType", "", "getServerRtcStream", "()Z", "setServerRtcStream", "(Z)V", "serverRtcStream", "", "getTrackInfo", "()Ljava/util/Map;", "setTrackInfo", "(Ljava/util/Map;)V", "trackInfo", "getChannelId", "setChannelId", "channelId", "getBizType", "setBizType", "bizType", "Lcom/bytedance/android/live/base/model/message/m0;", "Lcom/bytedance/android/live/base/model/message/ICommonMessageDataKt;", "getCommonData", "()Lcom/bytedance/android/live/base/model/message/m0;", "setCommonData", "(Lcom/bytedance/android/live/base/model/message/m0;)V", "commonData", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/bridge/e2;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IProfitGameStatusMessageExtensionImpl extends ModelExtensionBase<com.bytedance.android.livesdk.link.model.bridge.e2, IProfitGameStatusMessage> implements IProfitGameStatusMessage, com.bytedance.android.livesdk.link.model.bridge.e2 {
    private final /* synthetic */ com.bytedance.android.livesdk.link.model.bridge.e2 $$delegate_0;

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage, com.bytedance.android.livesdk.link.model.bridge.e2
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e2>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage, com.bytedance.android.livesdk.link.model.bridge.e2
    public <R extends vh7.e<com.bytedance.android.livesdk.link.model.bridge.e2>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TYPE);
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public String getAppId() {
        return (String) get(6, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage, com.bytedance.android.livesdk.link.model.bridge.e2
    public com.bytedance.android.live.base.model.message.m0 getCommonData() {
        return this.$$delegate_0.getCommonData();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public Long getGameId() {
        return (Long) get(5, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public Long getLinkGameId() {
        return (Long) get(7, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public String getRoomId() {
        return (String) get(3, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public IBaseStreamUrl getStreamUrl() {
        return (IBaseStreamUrl) get(4, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage, com.bytedance.android.livesdk.link.model.bridge.e2
    public void setCommonData(com.bytedance.android.live.base.model.message.m0 r2) {
        this.$$delegate_0.setCommonData(r2);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public String getAnchorOpenId() {
        return (String) get(15, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public IBaseStreamUrl getAndStreamUrl() {
        return (IBaseStreamUrl) get(9, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public int getBizEndReasonType() {
        return ((Number) get(16, IProfitGameStatusMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public int getBizType() {
        return ((Number) get(20, IProfitGameStatusMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public long getChannelId() {
        return ((Number) get(19, IProfitGameStatusMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public String getGameExtra() {
        return (String) get(10, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public int getGameStatus() {
        return ((Number) get(2, IProfitGameStatusMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public long getGameType() {
        return ((Number) get(13, IProfitGameStatusMessage.class, 0L)).longValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public String getInitParam() {
        return (String) get(14, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public String getLinkerExtra() {
        return (String) get(12, IProfitGameStatusMessage.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public int getPushStreamType() {
        return ((Number) get(11, IProfitGameStatusMessage.class, 0)).intValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public boolean getServerRtcStream() {
        return ((Boolean) get(17, IProfitGameStatusMessage.class, Boolean.FALSE)).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public Map<String, String> getTrackInfo() {
        return (Map) get(18, IProfitGameStatusMessage.class, com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b());
    }

    public IProfitGameStatusMessageExtensionImpl(com.bytedance.android.livesdk.link.model.bridge.e2 r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setAnchorOpenId(String r4) {
        set(15, "anchor_open_id", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setAndStreamUrl(IBaseStreamUrl r4) {
        set(9, "android_stream_url", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setAppId(String r4) {
        set(6, "app_id", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setBizEndReasonType(int r4) {
        set(16, "reason", IProfitGameStatusMessage.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setBizType(int r4) {
        set(20, "biz_type", IProfitGameStatusMessage.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setChannelId(long r3) {
        set(19, "channel_id", IProfitGameStatusMessage.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setGameExtra(String r4) {
        set(10, "game_extra", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setGameId(Long r4) {
        set(5, "game_id", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setGameStatus(int r4) {
        set(2, "status", IProfitGameStatusMessage.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setGameType(long r3) {
        set(13, "game_type", IProfitGameStatusMessage.class, Long.valueOf(r3));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setInitParam(String r4) {
        set(14, "init_param", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setLinkGameId(Long r4) {
        set(7, "link_game_id", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setLinkerExtra(String r4) {
        set(12, "linker_extra", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setPushStreamType(int r4) {
        set(11, "push_stream_type", IProfitGameStatusMessage.class, Integer.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setRoomId(String r4) {
        set(3, "room_id", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setServerRtcStream(boolean r4) {
        set(17, "server_rtc_stream", IProfitGameStatusMessage.class, Boolean.valueOf(r4));
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setStreamUrl(IBaseStreamUrl r4) {
        set(4, "stream_url", IProfitGameStatusMessage.class, r4);
    }

    @Override // com.bytedance.android.livesdk.link.model.IProfitGameStatusMessage
    public void setTrackInfo(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "value");
        set(18, "track_info", IProfitGameStatusMessage.class, r4);
    }
}
