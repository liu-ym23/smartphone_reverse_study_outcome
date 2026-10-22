package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/videosend/tools/VideoCompressNewConfig;", "", GearStrategyConsts.EV_QUALITY, "", "Lcom/ss/android/lark/videosend/tools/QualityItem;", "scene", "Lcom/ss/android/lark/videosend/tools/Scene;", "lowBitrateMax", "", "<init>", "([Lcom/ss/android/lark/videosend/tools/QualityItem;Lcom/ss/android/lark/videosend/tools/Scene;I)V", "getQuality", "()[Lcom/ss/android/lark/videosend/tools/QualityItem;", "setQuality", "([Lcom/ss/android/lark/videosend/tools/QualityItem;)V", "[Lcom/ss/android/lark/videosend/tools/QualityItem;", "getScene", "()Lcom/ss/android/lark/videosend/tools/Scene;", "setScene", "(Lcom/ss/android/lark/videosend/tools/Scene;)V", "getLowBitrateMax", "()I", "setLowBitrateMax", "(I)V", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoCompressNewConfig {

    @SerializedName("low_bitrate_max")
    private int lowBitrateMax;

    @SerializedName(GearStrategyConsts.EV_QUALITY)
    private QualityItem[] quality;

    @SerializedName("scene")
    private Scene scene;

    public VideoCompressNewConfig() {
        this(null, null, 0, 7, null);
    }

    public final int getLowBitrateMax() {
        return this.lowBitrateMax;
    }

    public final QualityItem[] getQuality() {
        return this.quality;
    }

    public final Scene getScene() {
        return this.scene;
    }

    public final void setLowBitrateMax(int r100) {
        this.lowBitrateMax = r100;
    }

    public final void setQuality(QualityItem[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.quality = r100;
    }

    public final void setScene(Scene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public VideoCompressNewConfig(QualityItem[] r100, Scene r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, GearStrategyConsts.EV_QUALITY);
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.quality = r100;
        this.scene = r101;
        this.lowBitrateMax = r102;
    }

    public /* synthetic */ VideoCompressNewConfig(QualityItem[] r210, Scene r211, int r212, int r213, DefaultConstructorMarker r214) {
        int r100 = 512;
        if ((r213 & 1) == 0) goto L5;
        QualityItem[] r101 = {new QualityItem("low_bitrate", 3840, 2160, 120, "{\"compile\":{\"encode_mode\":\"hw\",\"hw\":{\"bitrate\":524288,\"profile\":\"high\",\"hp_bitrate_ratio\":\"0.8\",\"sd_bitrate_ratio\":\"0.33\",\"h_fps_bitrate_ratio\":\"1.4\",\"gop\":-1,\"transition_bitrate_ratio\":1.2},\"sw\":{\"crf\":17,\"preset\":0,\"profile\":\"high\",\"maxrate\":12233386,\"gop\":-1,\"qpoffset\":0.0}},\"watermark_compile\":{\"encode_mode\":\"hw\",\"hw\":{\"bitrate\":9000000,\"profile\":\"unknown\",\"hp_bitrate_ratio\":\"0.8\",\"sd_bitrate_ratio\":\"0.9\",\"h_fps_bitrate_ratio\":\"1.4\",\"full_hd_bitrate_ratio\":1.33,\"gop\":120,\"transition_bitrate_ratio\":1.2},\"sw\":{\"crf\":17,\"preset\":0,\"profile\":\"unknown\",\"maxrate\":15000000,\"gop\":30,\"qpoffset\":0.0}},\"bytevc_remux_enable\":false,\"transition_keyframe_enable\":true}", new RemuxSetting(3840, 2160, 120, 512)), new QualityItem("high", 1280, 720, 30, null, new RemuxSetting(1280, 720, 60, 7168), 16, null), new QualityItem("middle", 0, 0, 0, null, null, 62, null), new QualityItem("low", 0, 0, 0, "{\"compile\":{\"encode_mode\":\"hw\",\"hw\":{\"bitrate\":5284822,\"profile\":\"high\",\"hp_bitrate_ratio\":\"0.8\",\"sd_bitrate_ratio\":\"0.33\",\"h_fps_bitrate_ratio\":\"1.4\",\"gop\":30,\"transition_bitrate_ratio\":1.2},\"sw\":{\"crf\":17,\"preset\":0,\"profile\":\"high\",\"maxrate\":12233386,\"gop\":30,\"qpoffset\":0.0}},\"watermark_compile\":{\"encode_mode\":\"hw\",\"hw\":{\"bitrate\":9000000,\"profile\":\"unknown\",\"hp_bitrate_ratio\":\"0.8\",\"sd_bitrate_ratio\":\"0.9\",\"h_fps_bitrate_ratio\":\"1.4\",\"full_hd_bitrate_ratio\":1.33,\"gop\":120,\"transition_bitrate_ratio\":1.2},\"sw\":{\"crf\":17,\"preset\":0,\"profile\":\"unknown\",\"maxrate\":15000000,\"gop\":30,\"qpoffset\":0.0}},\"bytevc_remux_enable\":false,\"transition_keyframe_enable\":true}", null, 46, null)};
    L7:
        if ((r213 & 2) == 0) goto L9;
        Scene r102 = new Scene(null, null, null, null, null, 31, null);
    L11:
        if ((r213 & 4) != 0) goto L14;
        r100 = r212;
    L14:
        this(r101, r102, r100);
        return;
    L9:
        r102 = r211;
        goto L11
    L5:
        r101 = r210;
        goto L7
    }
}
