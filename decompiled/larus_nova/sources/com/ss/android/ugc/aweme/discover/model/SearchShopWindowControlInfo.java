package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR \u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/SearchShopWindowControlInfo;", "Ljava/io/Serializable;", "()V", "cardProtocolTypeInfo", "Lcom/ss/android/ugc/aweme/discover/model/CardProtocolTypeInfo;", "getCardProtocolTypeInfo", "()Lcom/ss/android/ugc/aweme/discover/model/CardProtocolTypeInfo;", "setCardProtocolTypeInfo", "(Lcom/ss/android/ugc/aweme/discover/model/CardProtocolTypeInfo;)V", "cardSlotType", "", "getCardSlotType", "()Ljava/lang/String;", "setCardSlotType", "(Ljava/lang/String;)V", "hasLynxLongPressAbility", "", "getHasLynxLongPressAbility", "()Z", "setHasLynxLongPressAbility", "(Z)V", "jumpDestination", "getJumpDestination", "setJumpDestination", "outPlayType", "getOutPlayType", "setOutPlayType", "replayVideoPlayStartTime", "getReplayVideoPlayStartTime", "setReplayVideoPlayStartTime", "shieldUserLine", "", "getShieldUserLine", "()Ljava/lang/Integer;", "setShieldUserLine", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchShopWindowControlInfo implements Serializable {

    @SerializedName("card_protocol_type")
    private CardProtocolTypeInfo cardProtocolTypeInfo;

    @SerializedName("slot_type")
    private String cardSlotType;

    @SerializedName("has_lynx_long_press_ability")
    private boolean hasLynxLongPressAbility;

    @SerializedName("jump_destination")
    private String jumpDestination;

    @SerializedName("out_play_type")
    private String outPlayType;

    @SerializedName("replay_video_start_time")
    private String replayVideoPlayStartTime;

    @SerializedName("shield_user_line")
    private Integer shieldUserLine;

    public SearchShopWindowControlInfo() {
        this.replayVideoPlayStartTime = "";
    }

    public final CardProtocolTypeInfo getCardProtocolTypeInfo() {
        return this.cardProtocolTypeInfo;
    }

    public final String getCardSlotType() {
        return this.cardSlotType;
    }

    public final boolean getHasLynxLongPressAbility() {
        return this.hasLynxLongPressAbility;
    }

    public final String getJumpDestination() {
        return this.jumpDestination;
    }

    public final String getOutPlayType() {
        return this.outPlayType;
    }

    public final String getReplayVideoPlayStartTime() {
        return this.replayVideoPlayStartTime;
    }

    public final Integer getShieldUserLine() {
        return this.shieldUserLine;
    }

    public final void setCardProtocolTypeInfo(CardProtocolTypeInfo r100) {
        this.cardProtocolTypeInfo = r100;
    }

    public final void setCardSlotType(String r100) {
        this.cardSlotType = r100;
    }

    public final void setHasLynxLongPressAbility(boolean r100) {
        this.hasLynxLongPressAbility = r100;
    }

    public final void setJumpDestination(String r100) {
        this.jumpDestination = r100;
    }

    public final void setOutPlayType(String r100) {
        this.outPlayType = r100;
    }

    public final void setReplayVideoPlayStartTime(String r100) {
        this.replayVideoPlayStartTime = r100;
    }

    public final void setShieldUserLine(Integer r100) {
        this.shieldUserLine = r100;
    }
}
