package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/ObricAppIntentScreenshotCacheConfig;", "", "maxSize", "", "ttlMs", "", "enableAppendScreenshotNoise", "", "<init>", "(IJZ)V", "getMaxSize", "()I", "getTtlMs", "()J", "getEnableAppendScreenshotNoise", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAppIntentScreenshotCacheConfig {

    @SerializedName("enable_append_screenshot_noise")
    private final boolean enableAppendScreenshotNoise;

    @SerializedName(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE)
    private final int maxSize;

    @SerializedName("ttl_ms")
    private final long ttlMs;

    public ObricAppIntentScreenshotCacheConfig() {
        this(0, 0, false, 7, null);
    }

    public static /* synthetic */ ObricAppIntentScreenshotCacheConfig copy$default(ObricAppIntentScreenshotCacheConfig r100, int r101, long r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.maxSize;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.ttlMs;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.enableAppendScreenshotNoise;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.maxSize;
    }

    public final long component2() {
        return this.ttlMs;
    }

    public final boolean component3() {
        return this.enableAppendScreenshotNoise;
    }

    public final ObricAppIntentScreenshotCacheConfig copy(int r100, long r101, boolean r102) {
        return new ObricAppIntentScreenshotCacheConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricAppIntentScreenshotCacheConfig) == true) goto L8;
        return false;
    L8:
        ObricAppIntentScreenshotCacheConfig r101 = (ObricAppIntentScreenshotCacheConfig) r100;
        if (this.maxSize == r101.maxSize) goto L12;
        return false;
    L12:
        if (this.ttlMs == r101.ttlMs) goto L15;
        return false;
    L15:
        if (this.enableAppendScreenshotNoise == r101.enableAppendScreenshotNoise) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.maxSize * 31;
        long r101 = this.ttlMs;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.enableAppendScreenshotNoise == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public String toString() {
        return "ObricAppIntentScreenshotCacheConfig(maxSize=" + this.maxSize + ", ttlMs=" + this.ttlMs + ", enableAppendScreenshotNoise=" + this.enableAppendScreenshotNoise + ')';
    }

    public final boolean getEnableAppendScreenshotNoise() {
        return this.enableAppendScreenshotNoise;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final long getTtlMs() {
        return this.ttlMs;
    }

    public ObricAppIntentScreenshotCacheConfig(int r100, long r101, boolean r102) {
        this.maxSize = r100;
        this.ttlMs = r101;
        this.enableAppendScreenshotNoise = r102;
    }

    public /* synthetic */ ObricAppIntentScreenshotCacheConfig(int r100, long r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 2;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 600000;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
