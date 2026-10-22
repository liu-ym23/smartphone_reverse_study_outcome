package hq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014JL\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/larus/platform/model/AudioStreamPlayerTechConfig;", "", "isV2StreamEnable", "", "maxQueueSize", "", "isDetailLogEnable", "chunkAutoRetryLimit", "chunkAutoRetryIntervalMs", "", "streamPlayerChunkOptEnable", "<init>", "(ZIZIJLjava/lang/Boolean;)V", "()Z", "getMaxQueueSize", "()I", "getChunkAutoRetryLimit", "getChunkAutoRetryIntervalMs", "()J", "getStreamPlayerChunkOptEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZIZIJLjava/lang/Boolean;)Lcom/larus/platform/model/AudioStreamPlayerTechConfig;", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class t {

    @SerializedName("chunk_auto_retry_interval_ms")
    private final long chunkAutoRetryIntervalMs;

    @SerializedName("chunk_auto_retry_limit")
    private final int chunkAutoRetryLimit;

    @SerializedName("is_detail_log_enable")
    private final boolean isDetailLogEnable;

    @SerializedName("is_v2_stream_enable")
    private final boolean isV2StreamEnable;

    @SerializedName("max_queue_size")
    private final int maxQueueSize;

    @SerializedName("stream_player_chunk_opt_enable")
    private final Boolean streamPlayerChunkOptEnable;

    public t() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (this.isV2StreamEnable == r101.isV2StreamEnable) goto L12;
        return false;
    L12:
        if (this.maxQueueSize == r101.maxQueueSize) goto L15;
        return false;
    L15:
        if (this.isDetailLogEnable == r101.isDetailLogEnable) goto L18;
        return false;
    L18:
        if (this.chunkAutoRetryLimit == r101.chunkAutoRetryLimit) goto L21;
        return false;
    L21:
        if (this.chunkAutoRetryIntervalMs == r101.chunkAutoRetryIntervalMs) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.streamPlayerChunkOptEnable, r101.streamPlayerChunkOptEnable) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.isV2StreamEnable == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.maxQueueSize) * 31;
        if (this.isDetailLogEnable == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.chunkAutoRetryLimit) * 31;
        long r104 = this.chunkAutoRetryIntervalMs;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        Boolean r106 = this.streamPlayerChunkOptEnable;
        if (r106 != null) goto L13;
        int r107 = 0;
    L15:
        return r105 + r107;
    L13:
        r107 = r106.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioStreamPlayerTechConfig(isV2StreamEnable=" + this.isV2StreamEnable + ", maxQueueSize=" + this.maxQueueSize + ", isDetailLogEnable=" + this.isDetailLogEnable + ", chunkAutoRetryLimit=" + this.chunkAutoRetryLimit + ", chunkAutoRetryIntervalMs=" + this.chunkAutoRetryIntervalMs + ", streamPlayerChunkOptEnable=" + this.streamPlayerChunkOptEnable + ')';
    }

    public final long a() {
        return this.chunkAutoRetryIntervalMs;
    }

    public final int b() {
        return this.chunkAutoRetryLimit;
    }

    public final int c() {
        return this.maxQueueSize;
    }

    public final Boolean d() {
        return this.streamPlayerChunkOptEnable;
    }

    public final boolean e() {
        return this.isDetailLogEnable;
    }

    public final boolean f() {
        return this.isV2StreamEnable;
    }

    public t(int r100) {
        Boolean r101 = Boolean.TRUE;
        this.isV2StreamEnable = true;
        this.maxQueueSize = 100;
        this.isDetailLogEnable = false;
        this.chunkAutoRetryLimit = 10;
        this.chunkAutoRetryIntervalMs = 5000;
        this.streamPlayerChunkOptEnable = r101;
    }
}
