package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/audio/CloseAudioConnectionAppBackgroundConfig;", "", "isEnabled", "", "deviceManufacturerBlockList", "", "", "<init>", "(ZLjava/util/List;)V", "()Z", "getDeviceManufacturerBlockList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseAudioConnectionAppBackgroundConfig {

    @SerializedName("device_manufacturer_block_list")
    private final List<String> deviceManufacturerBlockList;

    @SerializedName("enabled")
    private final boolean isEnabled;

    /* JADX WARN: Multi-variable type inference failed */
    public CloseAudioConnectionAppBackgroundConfig() {
        boolean r100 = false;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CloseAudioConnectionAppBackgroundConfig copy$default(CloseAudioConnectionAppBackgroundConfig r100, boolean r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isEnabled;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.deviceManufacturerBlockList;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    public final List<String> component2() {
        return this.deviceManufacturerBlockList;
    }

    public final CloseAudioConnectionAppBackgroundConfig copy(boolean r100, List<String> r101) {
        return new CloseAudioConnectionAppBackgroundConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CloseAudioConnectionAppBackgroundConfig) == true) goto L8;
        return false;
    L8:
        CloseAudioConnectionAppBackgroundConfig r101 = (CloseAudioConnectionAppBackgroundConfig) r100;
        if (this.isEnabled == r101.isEnabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceManufacturerBlockList, r101.deviceManufacturerBlockList) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.isEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        List<String> r102 = this.deviceManufacturerBlockList;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "CloseAudioConnectionAppBackgroundConfig(isEnabled=" + this.isEnabled + ", deviceManufacturerBlockList=" + this.deviceManufacturerBlockList + ')';
    }

    public final List<String> getDeviceManufacturerBlockList() {
        return this.deviceManufacturerBlockList;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public CloseAudioConnectionAppBackgroundConfig(boolean r100, List<String> r101) {
        this.isEnabled = r100;
        this.deviceManufacturerBlockList = r101;
    }

    public /* synthetic */ CloseAudioConnectionAppBackgroundConfig(boolean r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
