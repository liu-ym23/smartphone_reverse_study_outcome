package com.larus.platform.model.audio;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lq9.l0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/audio/TTSConfigData;", "", "zipConfig", "Lcom/larus/platform/model/audio/ZipConfigData;", "connectPoolStrategy", "Lcom/larus/platform/model/audio/AudioStrategy;", "<init>", "(Lcom/larus/platform/model/audio/ZipConfigData;Lcom/larus/platform/model/audio/AudioStrategy;)V", "getZipConfig", "()Lcom/larus/platform/model/audio/ZipConfigData;", "getConnectPoolStrategy", "()Lcom/larus/platform/model/audio/AudioStrategy;", "setConnectPoolStrategy", "(Lcom/larus/platform/model/audio/AudioStrategy;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TTSConfigData {

    @SerializedName("network_strategy")
    private AudioStrategy connectPoolStrategy;

    @SerializedName("zip_config")
    private final l0 zipConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public TTSConfigData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TTSConfigData copy$default(TTSConfigData r100, l0 r101, AudioStrategy r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.zipConfig;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.connectPoolStrategy;
    L9:
        return r100.copy(r101, r102);
    }

    public final l0 component1() {
        return this.zipConfig;
    }

    public final AudioStrategy component2() {
        return this.connectPoolStrategy;
    }

    public final TTSConfigData copy(l0 r100, AudioStrategy r101) {
        return new TTSConfigData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TTSConfigData) == true) goto L8;
        return false;
    L8:
        TTSConfigData r101 = (TTSConfigData) r100;
        if (Intrinsics.areEqual(this.zipConfig, r101.zipConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.connectPoolStrategy, r101.connectPoolStrategy) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        l0 r100 = this.zipConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AudioStrategy r104 = this.connectPoolStrategy;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "TTSConfigData(zipConfig=" + this.zipConfig + ", connectPoolStrategy=" + this.connectPoolStrategy + ')';
    }

    public final AudioStrategy getConnectPoolStrategy() {
        return this.connectPoolStrategy;
    }

    public final l0 getZipConfig() {
        return this.zipConfig;
    }

    public final void setConnectPoolStrategy(AudioStrategy r100) {
        this.connectPoolStrategy = r100;
    }

    public TTSConfigData(l0 r100, AudioStrategy r101) {
        this.zipConfig = r100;
        this.connectPoolStrategy = r101;
    }

    public /* synthetic */ TTSConfigData(l0 r100, AudioStrategy r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new AudioStrategy(null, 1, null);
    L8:
        this(r100, r101);
    }
}
