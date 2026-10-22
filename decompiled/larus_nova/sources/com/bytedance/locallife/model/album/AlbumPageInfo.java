package com.bytedance.locallife.model.album;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0006HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!¨\u00061"}, d2 = {"Lcom/bytedance/locallife/model/album/AlbumPageInfo;", "Ljava/io/Serializable;", "tabName", "", "tabId", "tabCount", "", "photoData", "", "Lcom/bytedance/locallife/model/album/PhotoData;", "photoDataForLynx", "hasMore", "", "nextOffset", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNextOffset", "()Ljava/lang/Integer;", "setNextOffset", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPhotoData", "()Ljava/util/List;", "setPhotoData", "(Ljava/util/List;)V", "getPhotoDataForLynx", "setPhotoDataForLynx", "getTabCount", "getTabId", "()Ljava/lang/String;", "getTabName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/bytedance/locallife/model/album/AlbumPageInfo;", "equals", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AlbumPageInfo implements Serializable {

    @SerializedName("has_more")
    private Boolean hasMore;

    @SerializedName("next_page")
    private Integer nextOffset;

    @SerializedName("photo_info")
    private List<PhotoData> photoData;

    @SerializedName("photo_info_string")
    private List<String> photoDataForLynx;

    @SerializedName(a.KEY_TOTAL_COUNT)
    private final Integer tabCount;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName(a.KEY_TAB_NAME)
    private final String tabName;

    public AlbumPageInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumPageInfo copy$default(AlbumPageInfo r100, String r101, String r102, Integer r103, List r104, List r110, Boolean r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.tabName;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.tabId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.tabCount;
    L11:
        Integer r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.photoData;
    L14:
        List r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.photoDataForLynx;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.hasMore;
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.nextOffset;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.tabName;
    }

    public final String component2() {
        return this.tabId;
    }

    public final Integer component3() {
        return this.tabCount;
    }

    public final List<PhotoData> component4() {
        return this.photoData;
    }

    public final List<String> component5() {
        return this.photoDataForLynx;
    }

    public final Boolean component6() {
        return this.hasMore;
    }

    public final Integer component7() {
        return this.nextOffset;
    }

    public final AlbumPageInfo copy(String r110, String r111, Integer r112, List<PhotoData> r113, List<String> r114, Boolean r115, Integer r116) {
        return new AlbumPageInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumPageInfo) == true) goto L8;
        return false;
    L8:
        AlbumPageInfo r101 = (AlbumPageInfo) r100;
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.tabCount, r101.tabCount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.photoData, r101.photoData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.photoDataForLynx, r101.photoDataForLynx) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.nextOffset, r101.nextOffset) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.tabName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.tabCount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<PhotoData> r110 = this.photoData;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.photoDataForLynx;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.hasMore;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.nextOffset;
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

    public String toString() {
        return "AlbumPageInfo(tabName=" + this.tabName + ", tabId=" + this.tabId + ", tabCount=" + this.tabCount + ", photoData=" + this.photoData + ", photoDataForLynx=" + this.photoDataForLynx + ", hasMore=" + this.hasMore + ", nextOffset=" + this.nextOffset + ')';
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final Integer getNextOffset() {
        return this.nextOffset;
    }

    public final List<PhotoData> getPhotoData() {
        return this.photoData;
    }

    public final List<String> getPhotoDataForLynx() {
        return this.photoDataForLynx;
    }

    public final Integer getTabCount() {
        return this.tabCount;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final void setHasMore(Boolean r100) {
        this.hasMore = r100;
    }

    public final void setNextOffset(Integer r100) {
        this.nextOffset = r100;
    }

    public final void setPhotoData(List<PhotoData> r100) {
        this.photoData = r100;
    }

    public final void setPhotoDataForLynx(List<String> r100) {
        this.photoDataForLynx = r100;
    }

    public AlbumPageInfo(String r100, String r101, Integer r102, List<PhotoData> r103, List<String> r104, Boolean r105, Integer r106) {
        this.tabName = r100;
        this.tabId = r101;
        this.tabCount = r102;
        this.photoData = r103;
        this.photoDataForLynx = r104;
        this.hasMore = r105;
        this.nextOffset = r106;
    }

    public /* synthetic */ AlbumPageInfo(String r100, String r101, Integer r102, List r103, List r110, Boolean r111, Integer r112, int r113, DefaultConstructorMarker r114) {
        String r104 = "";
        if ((r113 & 1) == 0) goto L5;
        String r115 = "";
    L7:
        if ((r113 & 2) != 0) goto L11;
        r104 = r101;
    L11:
        if ((r113 & 4) == 0) goto L13;
        r102 = 100;
    L13:
        Integer r105 = r102;
        if ((r113 & 8) == 0) goto L16;
        List r106 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        List r107 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        r111 = Boolean.TRUE;
    L24:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L27;
        r112 = 1;
    L27:
        this(r115, r104, r105, r106, r107, r108, r112);
        return;
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L5:
        r115 = r100;
        goto L7
    }
}
