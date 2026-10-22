package com.larus.video.impl.douyin;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J=\u0010\u0014\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/video/impl/douyin/RecommendVideos;", "Ljava/io/Serializable;", "ext", "", "", "itemIds", "", "hasMore", "", "<init>", "(Ljava/util/Map;Ljava/util/List;Z)V", "getExt", "()Ljava/util/Map;", "getItemIds", "()Ljava/util/List;", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecommendVideos implements Serializable {

    @SerializedName("ext")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> ext;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("item_ids")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> itemIds;

    public RecommendVideos() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendVideos copy$default(RecommendVideos r100, Map r101, List r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.ext;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.itemIds;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.hasMore;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Map<String, String> component1() {
        return this.ext;
    }

    public final List<String> component2() {
        return this.itemIds;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final RecommendVideos copy(Map<String, String> r100, List<String> r101, boolean r102) {
        return new RecommendVideos(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendVideos) == true) goto L8;
        return false;
    L8:
        RecommendVideos r101 = (RecommendVideos) r100;
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.itemIds, r101.itemIds) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r101.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Map<String, String> r100 = this.ext;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.itemIds;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        if (this.hasMore == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RecommendVideos(ext=" + this.ext + ", itemIds=" + this.itemIds + ", hasMore=" + this.hasMore + ')';
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<String> getItemIds() {
        return this.itemIds;
    }

    public RecommendVideos(Map<String, String> r100, List<String> r101, boolean r102) {
        this.ext = r100;
        this.itemIds = r101;
        this.hasMore = r102;
    }

    public /* synthetic */ RecommendVideos(Map r100, List r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
