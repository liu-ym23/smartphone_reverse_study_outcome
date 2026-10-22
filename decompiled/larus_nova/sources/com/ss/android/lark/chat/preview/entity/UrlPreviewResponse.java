package com.ss.android.lark.chat.preview.entity;

import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/UrlPreviewResponse;", "Ljava/io/Serializable;", "netCostMs", "", "urlPreViewEntries", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntries;", "Lkotlin/collections/ArrayList;", "<init>", "(JLjava/util/ArrayList;)V", "getNetCostMs", "()J", "getUrlPreViewEntries", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewResponse implements Serializable {
    private final long netCostMs;
    private final ArrayList<UrlPreViewEntries> urlPreViewEntries;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewResponse copy$default(UrlPreviewResponse r100, long r101, ArrayList r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.netCostMs;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.urlPreViewEntries;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.netCostMs;
    }

    public final ArrayList<UrlPreViewEntries> component2() {
        return this.urlPreViewEntries;
    }

    public final UrlPreviewResponse copy(long r100, ArrayList<UrlPreViewEntries> r101) {
        Intrinsics.checkNotNullParameter(r101, "urlPreViewEntries");
        return new UrlPreviewResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlPreviewResponse) == true) goto L8;
        return false;
    L8:
        UrlPreviewResponse r101 = (UrlPreviewResponse) r100;
        if (this.netCostMs == r101.netCostMs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlPreViewEntries, r101.urlPreViewEntries) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        long r100 = this.netCostMs;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.urlPreViewEntries.hashCode();
    }

    public String toString() {
        return "UrlPreviewResponse(netCostMs=" + this.netCostMs + ", urlPreViewEntries=" + this.urlPreViewEntries + ')';
    }

    public final long getNetCostMs() {
        return this.netCostMs;
    }

    public final ArrayList<UrlPreViewEntries> getUrlPreViewEntries() {
        return this.urlPreViewEntries;
    }

    public UrlPreviewResponse(long r100, ArrayList<UrlPreViewEntries> r101) {
        Intrinsics.checkNotNullParameter(r101, "urlPreViewEntries");
        this.netCostMs = r100;
        this.urlPreViewEntries = r101;
    }
}
