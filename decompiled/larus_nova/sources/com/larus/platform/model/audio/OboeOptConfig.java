package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/platform/model/audio/OboeOptConfig;", "", "enableRecord", "", "enablePlay", "recordPerFramesPerCallback", "", "playPerFramesPerCallback", "enableLowLatency", "<init>", "(ZZIIZ)V", "getEnableRecord", "()Z", "getEnablePlay", "getRecordPerFramesPerCallback", "()I", "getPlayPerFramesPerCallback", "getEnableLowLatency", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OboeOptConfig {

    @SerializedName("enable_low_Latency")
    private final boolean enableLowLatency;

    @SerializedName("enable_play")
    private final boolean enablePlay;

    @SerializedName("enable_record")
    private final boolean enableRecord;

    @SerializedName("play_num_per_callback")
    private final int playPerFramesPerCallback;

    @SerializedName("record_num_per_callback")
    private final int recordPerFramesPerCallback;

    public OboeOptConfig() {
        this(false, false, 0, 0, false, 31, null);
    }

    public static /* synthetic */ OboeOptConfig copy$default(OboeOptConfig r100, boolean r101, boolean r102, int r103, int r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableRecord;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enablePlay;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.recordPerFramesPerCallback;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.playPerFramesPerCallback;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableLowLatency;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableRecord;
    }

    public final boolean component2() {
        return this.enablePlay;
    }

    public final int component3() {
        return this.recordPerFramesPerCallback;
    }

    public final int component4() {
        return this.playPerFramesPerCallback;
    }

    public final boolean component5() {
        return this.enableLowLatency;
    }

    public final OboeOptConfig copy(boolean r100, boolean r101, int r110, int r111, boolean r112) {
        return new OboeOptConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OboeOptConfig) == true) goto L8;
        return false;
    L8:
        OboeOptConfig r101 = (OboeOptConfig) r100;
        if (this.enableRecord == r101.enableRecord) goto L12;
        return false;
    L12:
        if (this.enablePlay == r101.enablePlay) goto L15;
        return false;
    L15:
        if (this.recordPerFramesPerCallback == r101.recordPerFramesPerCallback) goto L18;
        return false;
    L18:
        if (this.playPerFramesPerCallback == r101.playPerFramesPerCallback) goto L21;
        return false;
    L21:
        if (this.enableLowLatency == r101.enableLowLatency) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableRecord == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enablePlay == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (((((r102 + r103) * 31) + this.recordPerFramesPerCallback) * 31) + this.playPerFramesPerCallback) * 31;
        if (this.enableLowLatency == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "OboeOptConfig(enableRecord=" + this.enableRecord + ", enablePlay=" + this.enablePlay + ", recordPerFramesPerCallback=" + this.recordPerFramesPerCallback + ", playPerFramesPerCallback=" + this.playPerFramesPerCallback + ", enableLowLatency=" + this.enableLowLatency + ')';
    }

    public final boolean getEnableLowLatency() {
        return this.enableLowLatency;
    }

    public final boolean getEnablePlay() {
        return this.enablePlay;
    }

    public final boolean getEnableRecord() {
        return this.enableRecord;
    }

    public final int getPlayPerFramesPerCallback() {
        return this.playPerFramesPerCallback;
    }

    public final int getRecordPerFramesPerCallback() {
        return this.recordPerFramesPerCallback;
    }

    public OboeOptConfig(boolean r100, boolean r101, int r102, int r103, boolean r104) {
        this.enableRecord = r100;
        this.enablePlay = r101;
        this.recordPerFramesPerCallback = r102;
        this.playPerFramesPerCallback = r103;
        this.enableLowLatency = r104;
    }

    public /* synthetic */ OboeOptConfig(boolean r100, boolean r101, int r102, int r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = false;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r110 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r110 & 16) == 0) goto L21;
        boolean r113 = false;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
