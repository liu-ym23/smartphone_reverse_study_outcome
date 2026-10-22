package com.bytedance.cloudplay.xplay2.api;

import com.tencent.qqmusic.third.api.contract.Keys;
import faceverify.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0014\u0010\u001a\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u0014X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\nR\u0014\u0010)\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\n¨\u0006+"}, d2 = {"Lcom/bytedance/cloudplay/xplay2/api/LaunchInfo;", "", "()V", w.META_COLL_KEY_AUTH_INFO, "Lcom/bytedance/cloudplay/xplay2/api/AuthInfo;", "getAuthInfo", "()Lcom/bytedance/cloudplay/xplay2/api/AuthInfo;", "businessParams", "", "getBusinessParams", "()Ljava/lang/String;", "core", "getCore", "customMsgUserDataChannel", "", "getCustomMsgUserDataChannel", "()Z", "enableLocation", "getEnableLocation", "gameOrientation", "", "getGameOrientation", "()I", "initLogId", "getInitLogId", "isArchiveGame", "machineType", "getMachineType", Keys.API_PARAM_KEY_PLATFORM_TYPE, "getPlatformType", "players", "", "Lcom/bytedance/cloudplay/xplay2/api/PlayerInfo;", "getPlayers", "()Ljava/util/List;", "podInfo", "Lcom/bytedance/cloudplay/xplay2/api/PodInfo;", "getPodInfo", "()Lcom/bytedance/cloudplay/xplay2/api/PodInfo;", "roomId", "getRoomId", "rtcUserId", "getRtcUserId", "xplay2-api_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LaunchInfo {
    private final AuthInfo authInfo;
    private final String businessParams;
    private final String core;
    private final boolean customMsgUserDataChannel;
    private final boolean enableLocation;
    private final int gameOrientation;
    private final String initLogId;
    private final boolean isArchiveGame;
    private final int machineType;
    private final int platformType;
    private final List<PlayerInfo> players;
    private final PodInfo podInfo;
    private final String roomId;
    private final String rtcUserId;

    public LaunchInfo() {
        this.initLogId = "";
        this.core = "";
        this.roomId = "";
        this.businessParams = "";
        this.rtcUserId = "";
        this.platformType = 1;
        this.players = new ArrayList();
    }

    public final AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    public final String getBusinessParams() {
        return this.businessParams;
    }

    public final String getCore() {
        return this.core;
    }

    public final boolean getCustomMsgUserDataChannel() {
        return this.customMsgUserDataChannel;
    }

    public final boolean getEnableLocation() {
        return this.enableLocation;
    }

    public final int getGameOrientation() {
        return this.gameOrientation;
    }

    public final String getInitLogId() {
        return this.initLogId;
    }

    public final int getMachineType() {
        return this.machineType;
    }

    public final int getPlatformType() {
        return this.platformType;
    }

    public final List<PlayerInfo> getPlayers() {
        return this.players;
    }

    public final PodInfo getPodInfo() {
        return this.podInfo;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getRtcUserId() {
        return this.rtcUserId;
    }

    public final boolean isArchiveGame() {
        return this.isArchiveGame;
    }
}
