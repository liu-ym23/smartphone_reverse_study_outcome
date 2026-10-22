package com.ss.android.lark.videosend.tools;

import com.android.ttcjpaysdk.bdpay.counter.outer.fallback.view.OuterPayFallbackWrapper;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/videosend/tools/Scene;", "", "lowBitrate", "", PlayerResolution.SDKKEY.ORIGIN, OuterPayFallbackWrapper.FROM_SCENE_WEAK_NET, "low_device", "common", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLowBitrate", "()Ljava/lang/String;", "setLowBitrate", "(Ljava/lang/String;)V", "getOrigin", "setOrigin", "getWeak_net", "setWeak_net", "getLow_device", "setLow_device", "getCommon", "setCommon", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Scene {

    @SerializedName("common")
    private String common;

    @SerializedName("low_bitrate")
    private String lowBitrate;

    @SerializedName("low_device")
    private String low_device;

    @SerializedName(PlayerResolution.SDKKEY.ORIGIN)
    private String origin;

    @SerializedName(OuterPayFallbackWrapper.FROM_SCENE_WEAK_NET)
    private String weak_net;

    public Scene() {
        this(null, null, null, null, null, 31, null);
    }

    public final String getCommon() {
        return this.common;
    }

    public final String getLowBitrate() {
        return this.lowBitrate;
    }

    public final String getLow_device() {
        return this.low_device;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getWeak_net() {
        return this.weak_net;
    }

    public final void setCommon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.common = r100;
    }

    public final void setLowBitrate(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lowBitrate = r100;
    }

    public final void setLow_device(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.low_device = r100;
    }

    public final void setOrigin(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.origin = r100;
    }

    public final void setWeak_net(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.weak_net = r100;
    }

    public Scene(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "lowBitrate");
        Intrinsics.checkNotNullParameter(r101, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r102, OuterPayFallbackWrapper.FROM_SCENE_WEAK_NET);
        Intrinsics.checkNotNullParameter(r103, "low_device");
        Intrinsics.checkNotNullParameter(r104, "common");
        this.lowBitrate = r100;
        this.origin = r101;
        this.weak_net = r102;
        this.low_device = r103;
        this.common = r104;
    }

    public /* synthetic */ Scene(String r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "low_bitrate";
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = "high";
    L8:
        String r111 = r101;
        String r106 = "low";
        if ((r105 & 4) == 0) goto L11;
        String r107 = "low";
    L13:
        if ((r105 & 8) != 0) goto L17;
        r106 = r103;
    L17:
        if ((r105 & 16) == 0) goto L19;
        r104 = "middle";
    L19:
        String r108 = r104;
        this(r100, r111, r107, r106, r108);
        return;
    L11:
        r107 = r102;
        goto L13
    }
}
