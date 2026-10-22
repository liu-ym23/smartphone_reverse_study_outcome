package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JD\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyLiveWindowStruct;", "", "roomId", "", "jumpUrl", "", "playWhenHalfDialogClose", "", "showScene", "windowTopPercent", "", "(JLjava/lang/String;IILjava/lang/Float;)V", "getJumpUrl", "()Ljava/lang/String;", "getPlayWhenHalfDialogClose", "()I", "getRoomId", "()J", "getShowScene", "getWindowTopPercent", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "component5", "copy", "(JLjava/lang/String;IILjava/lang/Float;)Lcom/bytedance/locallife/groupon/struct/NearbyLiveWindowStruct;", "equals", "", "other", "hashCode", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class NearbyLiveWindowStruct {

    @SerializedName("schema")
    private final String jumpUrl;

    @SerializedName("stay_when_half_close")
    private final int playWhenHalfDialogClose;

    @SerializedName("room_id")
    private final long roomId;

    @SerializedName("show_scene")
    private final int showScene;

    @SerializedName("window_top_percent")
    private final Float windowTopPercent;

    public NearbyLiveWindowStruct() {
        this(0, null, 0, 0, null, 31, null);
    }

    public static /* synthetic */ NearbyLiveWindowStruct copy$default(NearbyLiveWindowStruct r100, long r101, String r110, int r111, int r112, Float r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.roomId;
    L5:
        long r102 = r101;
        if ((r114 & 2) == 0) goto L8;
        r110 = r100.jumpUrl;
    L8:
        String r103 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = r100.playWhenHalfDialogClose;
    L11:
        int r104 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = r100.showScene;
    L14:
        int r105 = r112;
        if ((r114 & 16) == 0) goto L18;
        r113 = r100.windowTopPercent;
    L18:
        return r100.copy(r102, r103, r104, r105, r113);
    }

    public final long component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.jumpUrl;
    }

    public final int component3() {
        return this.playWhenHalfDialogClose;
    }

    public final int component4() {
        return this.showScene;
    }

    public final Float component5() {
        return this.windowTopPercent;
    }

    public final NearbyLiveWindowStruct copy(long r100, String r110, int r111, int r112, Float r113) {
        return new NearbyLiveWindowStruct(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyLiveWindowStruct) == true) goto L8;
        return false;
    L8:
        NearbyLiveWindowStruct r101 = (NearbyLiveWindowStruct) r100;
        if (this.roomId == r101.roomId) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L15;
        return false;
    L15:
        if (this.playWhenHalfDialogClose == r101.playWhenHalfDialogClose) goto L18;
        return false;
    L18:
        if (this.showScene == r101.showScene) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.windowTopPercent, r101.windowTopPercent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.jumpUrl;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (((((r101 + r104) * 31) + this.playWhenHalfDialogClose) * 31) + this.showScene) * 31;
        Float r106 = this.windowTopPercent;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        return r105 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbyLiveWindowStruct(roomId=" + this.roomId + ", jumpUrl=" + this.jumpUrl + ", playWhenHalfDialogClose=" + this.playWhenHalfDialogClose + ", showScene=" + this.showScene + ", windowTopPercent=" + this.windowTopPercent + ')';
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final int getPlayWhenHalfDialogClose() {
        return this.playWhenHalfDialogClose;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final int getShowScene() {
        return this.showScene;
    }

    public final Float getWindowTopPercent() {
        return this.windowTopPercent;
    }

    public NearbyLiveWindowStruct(long r100, String r101, int r102, int r103, Float r104) {
        this.roomId = r100;
        this.jumpUrl = r101;
        this.playWhenHalfDialogClose = r102;
        this.showScene = r103;
        this.windowTopPercent = r104;
    }

    public /* synthetic */ NearbyLiveWindowStruct(long r100, String r110, int r111, int r112, Float r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        long r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        String r102 = null;
    L10:
        if ((r114 & 4) == 0) goto L12;
        int r103 = 0;
    L14:
        if ((r114 & 8) == 0) goto L16;
        int r104 = 0;
    L18:
        if ((r114 & 16) == 0) goto L20;
        Float r105 = null;
    L21:
        this(r101, r102, r103, r104, r105);
        return;
    L20:
        r105 = r113;
        goto L21
    L16:
        r104 = r112;
        goto L18
    L12:
        r103 = r111;
        goto L14
    L8:
        r102 = r110;
        goto L10
    }
}
