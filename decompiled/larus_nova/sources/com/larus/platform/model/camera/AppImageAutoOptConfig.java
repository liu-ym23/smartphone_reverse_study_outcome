package com.larus.platform.model.camera;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/camera/AppImageAutoOptConfig;", "", "isPreHeatEnabled", "", "preHeatTargetCount", "", "preHeatThreshold", "<init>", "(ZII)V", "()Z", "getPreHeatTargetCount", "()I", "getPreHeatThreshold", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppImageAutoOptConfig {

    @SerializedName("image_upload_preheat_enabled")
    private final boolean isPreHeatEnabled;

    @SerializedName("image_upload_preheat_target_count")
    private final int preHeatTargetCount;

    @SerializedName("image_upload_preheat_threshold")
    private final int preHeatThreshold;

    public AppImageAutoOptConfig() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ AppImageAutoOptConfig copy$default(AppImageAutoOptConfig r100, boolean r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isPreHeatEnabled;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.preHeatTargetCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.preHeatThreshold;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.isPreHeatEnabled;
    }

    public final int component2() {
        return this.preHeatTargetCount;
    }

    public final int component3() {
        return this.preHeatThreshold;
    }

    public final AppImageAutoOptConfig copy(boolean r100, int r101, int r102) {
        return new AppImageAutoOptConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppImageAutoOptConfig) == true) goto L8;
        return false;
    L8:
        AppImageAutoOptConfig r101 = (AppImageAutoOptConfig) r100;
        if (this.isPreHeatEnabled == r101.isPreHeatEnabled) goto L12;
        return false;
    L12:
        if (this.preHeatTargetCount == r101.preHeatTargetCount) goto L15;
        return false;
    L15:
        if (this.preHeatThreshold == r101.preHeatThreshold) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.isPreHeatEnabled == false) goto L5;
        int r100 = 1231;
    L7:
        return (((r100 * 31) + this.preHeatTargetCount) * 31) + this.preHeatThreshold;
    L5:
        r100 = 1237;
        goto L7
    }

    public String toString() {
        return "AppImageAutoOptConfig(isPreHeatEnabled=" + this.isPreHeatEnabled + ", preHeatTargetCount=" + this.preHeatTargetCount + ", preHeatThreshold=" + this.preHeatThreshold + ')';
    }

    public final int getPreHeatTargetCount() {
        return this.preHeatTargetCount;
    }

    public final int getPreHeatThreshold() {
        return this.preHeatThreshold;
    }

    public final boolean isPreHeatEnabled() {
        return this.isPreHeatEnabled;
    }

    public AppImageAutoOptConfig(boolean r100, int r101, int r102) {
        this.isPreHeatEnabled = r100;
        this.preHeatTargetCount = r101;
        this.preHeatThreshold = r102;
    }

    public /* synthetic */ AppImageAutoOptConfig(boolean r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 10;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 4;
    L11:
        this(r100, r101, r102);
    }
}
