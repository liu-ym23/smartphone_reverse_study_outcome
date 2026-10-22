package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/videosend/tools/QualityItem;", "", "level", "", "bigSideMax", "", "smallSideMax", "fpsMax", "externalSetting", "remuxSetting", "Lcom/ss/android/lark/videosend/tools/RemuxSetting;", "<init>", "(Ljava/lang/String;IIILjava/lang/String;Lcom/ss/android/lark/videosend/tools/RemuxSetting;)V", "getLevel", "()Ljava/lang/String;", "setLevel", "(Ljava/lang/String;)V", "getBigSideMax", "()I", "setBigSideMax", "(I)V", "getSmallSideMax", "setSmallSideMax", "getFpsMax", "setFpsMax", "getExternalSetting", "setExternalSetting", "getRemuxSetting", "()Lcom/ss/android/lark/videosend/tools/RemuxSetting;", "setRemuxSetting", "(Lcom/ss/android/lark/videosend/tools/RemuxSetting;)V", "toString", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QualityItem {

    @SerializedName("big_side_max")
    private int bigSideMax;

    @SerializedName("external_setting")
    private String externalSetting;

    @SerializedName("fps_max")
    private int fpsMax;

    @SerializedName("level")
    private String level;

    @SerializedName("remux_setting")
    private RemuxSetting remuxSetting;

    @SerializedName("small_side_max")
    private int smallSideMax;

    public QualityItem() {
        this(null, 0, 0, 0, null, null, 63, null);
    }

    public String toString() {
        return "level=" + this.level + ",bigSideMax=" + this.bigSideMax + ",smallSideMax=" + this.smallSideMax + ",fpsMax=" + this.fpsMax + ",externalSetting=" + this.externalSetting + ",remuxSetting=" + this.remuxSetting;
    }

    public final int getBigSideMax() {
        return this.bigSideMax;
    }

    public final String getExternalSetting() {
        return this.externalSetting;
    }

    public final int getFpsMax() {
        return this.fpsMax;
    }

    public final String getLevel() {
        return this.level;
    }

    public final RemuxSetting getRemuxSetting() {
        return this.remuxSetting;
    }

    public final int getSmallSideMax() {
        return this.smallSideMax;
    }

    public final void setBigSideMax(int r100) {
        this.bigSideMax = r100;
    }

    public final void setExternalSetting(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.externalSetting = r100;
    }

    public final void setFpsMax(int r100) {
        this.fpsMax = r100;
    }

    public final void setLevel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.level = r100;
    }

    public final void setRemuxSetting(RemuxSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.remuxSetting = r100;
    }

    public final void setSmallSideMax(int r100) {
        this.smallSideMax = r100;
    }

    public QualityItem(String r100, int r101, int r102, int r103, String r104, RemuxSetting r105) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r104, "externalSetting");
        Intrinsics.checkNotNullParameter(r105, "remuxSetting");
        this.level = r100;
        this.bigSideMax = r101;
        this.smallSideMax = r102;
        this.fpsMax = r103;
        this.externalSetting = r104;
        this.remuxSetting = r105;
    }

    public /* synthetic */ QualityItem(String r110, int r111, int r112, int r113, String r114, RemuxSetting r115, int r116, DefaultConstructorMarker r210) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = "middle";
    L7:
        if ((r116 & 2) == 0) goto L9;
        int r101 = 960;
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r102 = 540;
    L15:
        if ((r116 & 8) == 0) goto L17;
        int r103 = 30;
    L19:
        if ((r116 & 16) == 0) goto L21;
        String r104 = "{\"compile\":{\"encode_mode\":\"hw\",\"hw\":{\"bitrate\":5284822,\"profile\":\"high\",\"hp_bitrate_ratio\":\"0.8\",\"sd_bitrate_ratio\":\"0.33\",\"h_fps_bitrate_ratio\":\"1.4\",\"gop\":30,\"transition_bitrate_ratio\":1.2},\"sw\":{\"crf\":17,\"preset\":0,\"profile\":\"high\",\"maxrate\":12233386,\"gop\":30,\"qpoffset\":0.0}},\"watermark_compile\":{\"encode_mode\":\"hw\",\"hw\":{\"bitrate\":9000000,\"profile\":\"unknown\",\"hp_bitrate_ratio\":\"0.8\",\"sd_bitrate_ratio\":\"0.9\",\"h_fps_bitrate_ratio\":\"1.4\",\"full_hd_bitrate_ratio\":1.33,\"gop\":120,\"transition_bitrate_ratio\":1.2},\"sw\":{\"crf\":17,\"preset\":0,\"profile\":\"unknown\",\"maxrate\":15000000,\"gop\":30,\"qpoffset\":0.0}},\"bytevc_remux_enable\":false,\"transition_keyframe_enable\":true}";
    L23:
        if ((r116 & 32) == 0) goto L25;
        RemuxSetting r105 = new RemuxSetting(0, 0, 0, 0, 15, null);
    L26:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
