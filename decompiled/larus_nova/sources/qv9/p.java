package qv9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\u000f¨\u0006)"}, d2 = {"Lcom/larus/settings/provider/perf/MemoryDegradationConfig;", "", "enable", "", "fixedIncrementMb", "", "safeBufferMb", "chunkSizeKb", "injectIntervalMs", "", "triggerDelayAfterFeedShowMs", "autoReleaseOnDisable", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFixedIncrementMb", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSafeBufferMb", "getChunkSizeKb", "getInjectIntervalMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTriggerDelayAfterFeedShowMs", "getAutoReleaseOnDisable", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;)Lcom/larus/settings/provider/perf/MemoryDegradationConfig;", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName("auto_release_on_disable")
    private final Boolean autoReleaseOnDisable;

    @SerializedName("chunk_size_kb")
    private final Integer chunkSizeKb;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("fixed_increment_mb")
    private final Integer fixedIncrementMb;

    @SerializedName("inject_interval_ms")
    private final Long injectIntervalMs;

    @SerializedName("safe_buffer_mb")
    private final Integer safeBufferMb;

    @SerializedName("trigger_delay_after_feed_show_ms")
    private final Long triggerDelayAfterFeedShowMs;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fixedIncrementMb, r101.fixedIncrementMb) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.safeBufferMb, r101.safeBufferMb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chunkSizeKb, r101.chunkSizeKb) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.injectIntervalMs, r101.injectIntervalMs) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.triggerDelayAfterFeedShowMs, r101.triggerDelayAfterFeedShowMs) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.autoReleaseOnDisable, r101.autoReleaseOnDisable) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.fixedIncrementMb;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.safeBufferMb;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.chunkSizeKb;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.injectIntervalMs;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.triggerDelayAfterFeedShowMs;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.autoReleaseOnDisable;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MemoryDegradationConfig(enable=" + this.enable + ", fixedIncrementMb=" + this.fixedIncrementMb + ", safeBufferMb=" + this.safeBufferMb + ", chunkSizeKb=" + this.chunkSizeKb + ", injectIntervalMs=" + this.injectIntervalMs + ", triggerDelayAfterFeedShowMs=" + this.triggerDelayAfterFeedShowMs + ", autoReleaseOnDisable=" + this.autoReleaseOnDisable + ')';
    }

    public final Boolean a() {
        return this.autoReleaseOnDisable;
    }

    public final Integer b() {
        return this.chunkSizeKb;
    }

    public final Boolean c() {
        return this.enable;
    }

    public final Integer d() {
        return this.fixedIncrementMb;
    }

    public final Long e() {
        return this.injectIntervalMs;
    }

    public final Integer f() {
        return this.safeBufferMb;
    }

    public final Long g() {
        return this.triggerDelayAfterFeedShowMs;
    }

    public p(int r100) {
        Boolean r101 = Boolean.FALSE;
        this.enable = r101;
        this.fixedIncrementMb = 0;
        this.safeBufferMb = 100;
        this.chunkSizeKb = 512;
        this.injectIntervalMs = 100L;
        this.triggerDelayAfterFeedShowMs = 3000L;
        this.autoReleaseOnDisable = r101;
    }
}
