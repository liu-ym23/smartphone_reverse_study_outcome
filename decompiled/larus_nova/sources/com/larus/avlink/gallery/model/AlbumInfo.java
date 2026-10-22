package com.larus.avlink.gallery.model;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.api.model.MediaInfo;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ:\u0010\u0013\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/larus/avlink/gallery/model/AlbumInfo;", "Ljava/io/Serializable;", "list", "", "Lcom/larus/dora/api/model/MediaInfo;", "pictureCount", "", "videoCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getList", "()Ljava/util/List;", "getPictureCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVideoCount", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/larus/avlink/gallery/model/AlbumInfo;", "equals", "", "other", "", "hashCode", "toString", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumInfo implements Serializable {
    public static final int $stable = 8;

    @SerializedName("list")
    private final List<MediaInfo> list;

    @SerializedName("picture_count")
    private final Integer pictureCount;

    @SerializedName("video_count")
    private final Integer videoCount;

    public AlbumInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumInfo copy$default(AlbumInfo r100, List r101, Integer r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.list;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.pictureCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.videoCount;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<MediaInfo> component1() {
        return this.list;
    }

    public final Integer component2() {
        return this.pictureCount;
    }

    public final Integer component3() {
        return this.videoCount;
    }

    public final AlbumInfo copy(List<MediaInfo> r100, Integer r101, Integer r102) {
        return new AlbumInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumInfo) == true) goto L8;
        return false;
    L8:
        AlbumInfo r101 = (AlbumInfo) r100;
        if (Intrinsics.areEqual(this.list, r101.list) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pictureCount, r101.pictureCount) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.videoCount, r101.videoCount) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<MediaInfo> r100 = this.list;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.pictureCount;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.videoCount;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AlbumInfo(list=" + this.list + ", pictureCount=" + this.pictureCount + ", videoCount=" + this.videoCount + ')';
    }

    public final List<MediaInfo> getList() {
        return this.list;
    }

    public final Integer getPictureCount() {
        return this.pictureCount;
    }

    public final Integer getVideoCount() {
        return this.videoCount;
    }

    public AlbumInfo(List<MediaInfo> r100, Integer r101, Integer r102) {
        this.list = r100;
        this.pictureCount = r101;
        this.videoCount = r102;
    }

    public /* synthetic */ AlbumInfo(List r100, Integer r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
