package com.bytedance.android.livesdk.livecommerce.network.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\b\n\u0002\b)\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0018\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R\u001a\u0010\u001b\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u001e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R\u001e\u0010$\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u0010:\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR \u0010=\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR \u0010@\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0006\"\u0004\bB\u0010\bR \u0010C\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010\bR\u001e\u0010F\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010\u0011R \u0010I\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\"\u0010L\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010Q\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001e\u0010R\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010W\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R\u001e\u0010Z\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011¨\u0006]"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/RedPacket;", "Ljava/io/Serializable;", "()V", "authorAvatarUrl", "", "getAuthorAvatarUrl", "()Ljava/lang/String;", "setAuthorAvatarUrl", "(Ljava/lang/String;)V", "authorName", "getAuthorName", "setAuthorName", "endApplyTime", "", "getEndApplyTime", "()J", "setEndApplyTime", "(J)V", "localEndApplyTime", "getLocalEndApplyTime", "setLocalEndApplyTime", "localScatterTime", "getLocalScatterTime", "setLocalScatterTime", "localServerNativeTimeOffset", "getLocalServerNativeTimeOffset", "setLocalServerNativeTimeOffset", "localStartApplyTime", "getLocalStartApplyTime", "setLocalStartApplyTime", "localStartApplyTimeForCountDown", "getLocalStartApplyTimeForCountDown", "setLocalStartApplyTimeForCountDown", "lynxScatterTime", "getLynxScatterTime", "setLynxScatterTime", "maxAmount", "getMaxAmount", "setMaxAmount", "pendantBackgroundUrl", "getPendantBackgroundUrl", "setPendantBackgroundUrl", "preHeatTime", "getPreHeatTime", "setPreHeatTime", "redPacketActivityId", "getRedPacketActivityId", "setRedPacketActivityId", "redPacketActivityName", "getRedPacketActivityName", "setRedPacketActivityName", "redPacketType", "", "getRedPacketType", "()Ljava/lang/Integer;", "setRedPacketType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "redpackAfterBackgroundUrl", "getRedpackAfterBackgroundUrl", "setRedpackAfterBackgroundUrl", "redpackAfterBeltUrl", "getRedpackAfterBeltUrl", "setRedpackAfterBeltUrl", "redpackFrontBackgroundUrl", "getRedpackFrontBackgroundUrl", "setRedpackFrontBackgroundUrl", "redpackLabel", "getRedpackLabel", "setRedpackLabel", "scatterTime", "getScatterTime", "setScatterTime", "schema", "getSchema", "setSchema", "serverTime", "getServerTime", "()Ljava/lang/Long;", "setServerTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "showType", "getShowType", "()I", "setShowType", "(I)V", "startApplyTime", "getStartApplyTime", "setStartApplyTime", "totalAmount", "getTotalAmount", "setTotalAmount", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RedPacket implements Serializable {

    @SerializedName("author_avatar_url")
    private String authorAvatarUrl;

    @SerializedName("author_name")
    private String authorName;

    @SerializedName("end_apply_time")
    private long endApplyTime;
    private long localEndApplyTime;
    private long localScatterTime;
    private long localServerNativeTimeOffset;
    private long localStartApplyTime;
    private long localStartApplyTimeForCountDown;
    private long lynxScatterTime;

    @SerializedName("max_amount")
    private long maxAmount;

    @SerializedName("pendant_background_url")
    private String pendantBackgroundUrl;

    @SerializedName("preheat_time")
    private long preHeatTime;

    @SerializedName("redpack_activity_id")
    private String redPacketActivityId;

    @SerializedName("redpack_activity_name")
    private String redPacketActivityName;

    @SerializedName("redpack_type")
    private Integer redPacketType;

    @SerializedName("redpack_after_background_url")
    private String redpackAfterBackgroundUrl;

    @SerializedName("redpack_after_belt_url")
    private String redpackAfterBeltUrl;

    @SerializedName("redpack_front_background_url")
    private String redpackFrontBackgroundUrl;

    @SerializedName("redpack_label")
    private String redpackLabel;

    @SerializedName("scatter_time")
    private long scatterTime;

    @SerializedName("schema")
    private String schema;

    @SerializedName("server_time")
    private Long serverTime;

    @SerializedName("show_type")
    private int showType;

    @SerializedName("start_apply_time")
    private long startApplyTime;

    @SerializedName("total_amount")
    private long totalAmount;

    public RedPacket() {
        this.localStartApplyTimeForCountDown = Long.MIN_VALUE;
    }

    public final String getAuthorAvatarUrl() {
        return this.authorAvatarUrl;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final long getEndApplyTime() {
        return this.endApplyTime;
    }

    public final long getLocalEndApplyTime() {
        return this.localEndApplyTime;
    }

    public final long getLocalScatterTime() {
        return this.localScatterTime;
    }

    public final long getLocalServerNativeTimeOffset() {
        return this.localServerNativeTimeOffset;
    }

    public final long getLocalStartApplyTime() {
        return this.localStartApplyTime;
    }

    public final long getLocalStartApplyTimeForCountDown() {
        return this.localStartApplyTimeForCountDown;
    }

    public final long getLynxScatterTime() {
        return this.lynxScatterTime;
    }

    public final long getMaxAmount() {
        return this.maxAmount;
    }

    public final String getPendantBackgroundUrl() {
        return this.pendantBackgroundUrl;
    }

    public final long getPreHeatTime() {
        return this.preHeatTime;
    }

    public final String getRedPacketActivityId() {
        return this.redPacketActivityId;
    }

    public final String getRedPacketActivityName() {
        return this.redPacketActivityName;
    }

    public final Integer getRedPacketType() {
        return this.redPacketType;
    }

    public final String getRedpackAfterBackgroundUrl() {
        return this.redpackAfterBackgroundUrl;
    }

    public final String getRedpackAfterBeltUrl() {
        return this.redpackAfterBeltUrl;
    }

    public final String getRedpackFrontBackgroundUrl() {
        return this.redpackFrontBackgroundUrl;
    }

    public final String getRedpackLabel() {
        return this.redpackLabel;
    }

    public final long getScatterTime() {
        return this.scatterTime;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final int getShowType() {
        return this.showType;
    }

    public final long getStartApplyTime() {
        return this.startApplyTime;
    }

    public final long getTotalAmount() {
        return this.totalAmount;
    }

    public final void setAuthorAvatarUrl(String r1) {
        this.authorAvatarUrl = r1;
    }

    public final void setAuthorName(String r1) {
        this.authorName = r1;
    }

    public final void setEndApplyTime(long r1) {
        this.endApplyTime = r1;
    }

    public final void setLocalEndApplyTime(long r1) {
        this.localEndApplyTime = r1;
    }

    public final void setLocalScatterTime(long r1) {
        this.localScatterTime = r1;
    }

    public final void setLocalServerNativeTimeOffset(long r1) {
        this.localServerNativeTimeOffset = r1;
    }

    public final void setLocalStartApplyTime(long r1) {
        this.localStartApplyTime = r1;
    }

    public final void setLocalStartApplyTimeForCountDown(long r1) {
        this.localStartApplyTimeForCountDown = r1;
    }

    public final void setLynxScatterTime(long r1) {
        this.lynxScatterTime = r1;
    }

    public final void setMaxAmount(long r1) {
        this.maxAmount = r1;
    }

    public final void setPendantBackgroundUrl(String r1) {
        this.pendantBackgroundUrl = r1;
    }

    public final void setPreHeatTime(long r1) {
        this.preHeatTime = r1;
    }

    public final void setRedPacketActivityId(String r1) {
        this.redPacketActivityId = r1;
    }

    public final void setRedPacketActivityName(String r1) {
        this.redPacketActivityName = r1;
    }

    public final void setRedPacketType(Integer r1) {
        this.redPacketType = r1;
    }

    public final void setRedpackAfterBackgroundUrl(String r1) {
        this.redpackAfterBackgroundUrl = r1;
    }

    public final void setRedpackAfterBeltUrl(String r1) {
        this.redpackAfterBeltUrl = r1;
    }

    public final void setRedpackFrontBackgroundUrl(String r1) {
        this.redpackFrontBackgroundUrl = r1;
    }

    public final void setRedpackLabel(String r1) {
        this.redpackLabel = r1;
    }

    public final void setScatterTime(long r1) {
        this.scatterTime = r1;
    }

    public final void setSchema(String r1) {
        this.schema = r1;
    }

    public final void setServerTime(Long r1) {
        this.serverTime = r1;
    }

    public final void setShowType(int r1) {
        this.showType = r1;
    }

    public final void setStartApplyTime(long r1) {
        this.startApplyTime = r1;
    }

    public final void setTotalAmount(long r1) {
        this.totalAmount = r1;
    }
}
