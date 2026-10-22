package com.larus.im.internal.core.conversation;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J3\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/im/internal/core/conversation/FtsSearchResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "data", "", "newCursor", "", "hasMore", "", "<init>", "(Ljava/util/List;JZ)V", "getData", "()Ljava/util/List;", "getNewCursor", "()J", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FtsSearchResult<T> {
    private final List<T> data;
    private final boolean hasMore;
    private final long newCursor;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FtsSearchResult copy$default(FtsSearchResult r100, List r101, long r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.newCursor;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<T> component1() {
        return this.data;
    }

    public final long component2() {
        return this.newCursor;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final FtsSearchResult<T> copy(List<? extends T> r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new FtsSearchResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FtsSearchResult) == true) goto L8;
        return false;
    L8:
        FtsSearchResult r101 = (FtsSearchResult) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L12;
        return false;
    L12:
        if (this.newCursor == r101.newCursor) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.data.hashCode() * 31;
        long r101 = this.newCursor;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.hasMore == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public String toString() {
        return "FtsSearchResult(data=" + this.data + ", newCursor=" + this.newCursor + ", hasMore=" + this.hasMore + ')';
    }

    public final List<T> getData() {
        return this.data;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final long getNewCursor() {
        return this.newCursor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FtsSearchResult(List<? extends T> r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.newCursor = r101;
        this.hasMore = r102;
    }
}
