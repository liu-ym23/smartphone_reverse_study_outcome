package kq9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0005J\u0006\u0010\u0018\u001a\u00020\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/album/CreationNoWatermarkConfig;", "", "enable", "", "messagePrefetchCount", "", "galleryNeighborPrefetchCount", "negativeCacheTtlMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getEnable", "()Ljava/lang/String;", "getMessagePrefetchCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGalleryNeighborPrefetchCount", "getNegativeCacheTtlMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isEnabled", "", "safeMessagePrefetchCount", "safeGalleryNeighborPrefetchCount", "safeNegativeCacheTtlMs", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("enable")
    private final String enable;

    @SerializedName("gallery_neighbor_prefetch_count")
    private final Integer galleryNeighborPrefetchCount;

    @SerializedName("message_prefetch_count")
    private final Integer messagePrefetchCount;

    @SerializedName("negative_cache_ttl_ms")
    private final Long negativeCacheTtlMs;

    public i() {
        this(0);
    }

    public final boolean a() {
        return Intrinsics.areEqual(this.enable, "1");
    }

    public final int b() {
        Integer r100 = this.galleryNeighborPrefetchCount;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        return RangesKt.coerceIn(r101, 0, 10);
    L5:
        r101 = 3;
        goto L7
    }

    public final int c() {
        Integer r100 = this.messagePrefetchCount;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        return RangesKt.coerceIn(r101, 0, 30);
    L5:
        r101 = 10;
        goto L7
    }

    public i(int r100) {
        this.enable = "0";
        this.messagePrefetchCount = 10;
        this.galleryNeighborPrefetchCount = 3;
        this.negativeCacheTtlMs = 1000L;
    }
}
