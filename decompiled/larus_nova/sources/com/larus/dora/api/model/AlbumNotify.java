package com.larus.dora.api.model;

import b49.a;
import com.baidu.platform.comapi.map.MapController;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/dora/api/model/AlbumNotify;", "Ljava/io/Serializable;", "notifyType", "", "media", "Lcom/larus/dora/api/model/MediaInfo;", "count", "Lcom/larus/dora/api/model/AlbumCount;", "<init>", "(Ljava/lang/Long;Lcom/larus/dora/api/model/MediaInfo;Lcom/larus/dora/api/model/AlbumCount;)V", "getNotifyType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMedia", "()Lcom/larus/dora/api/model/MediaInfo;", "getCount", "()Lcom/larus/dora/api/model/AlbumCount;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Lcom/larus/dora/api/model/MediaInfo;Lcom/larus/dora/api/model/AlbumCount;)Lcom/larus/dora/api/model/AlbumNotify;", "equals", "", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumNotify implements Serializable {

    @SerializedName("count")
    private final a count;

    @SerializedName(MapController.ITEM_LAYER_TAG)
    private final MediaInfo media;

    @SerializedName("notify_type")
    private final Long notifyType;

    public AlbumNotify() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AlbumNotify copy$default(AlbumNotify r100, Long r101, MediaInfo r102, a r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.notifyType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.media;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.count;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.notifyType;
    }

    public final MediaInfo component2() {
        return this.media;
    }

    public final a component3() {
        return this.count;
    }

    public final AlbumNotify copy(Long r100, MediaInfo r101, a r102) {
        return new AlbumNotify(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumNotify) == true) goto L8;
        return false;
    L8:
        AlbumNotify r101 = (AlbumNotify) r100;
        if (Intrinsics.areEqual(this.notifyType, r101.notifyType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.media, r101.media) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.count, r101.count) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Long r100 = this.notifyType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        MediaInfo r104 = this.media;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.count;
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
        return "AlbumNotify(notifyType=" + this.notifyType + ", media=" + this.media + ", count=" + this.count + ')';
    }

    public final a getCount() {
        return this.count;
    }

    public final MediaInfo getMedia() {
        return this.media;
    }

    public final Long getNotifyType() {
        return this.notifyType;
    }

    public AlbumNotify(Long r100, MediaInfo r101, a r102) {
        this.notifyType = r100;
        this.media = r101;
        this.count = r102;
    }

    public /* synthetic */ AlbumNotify(Long r100, MediaInfo r101, a r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
