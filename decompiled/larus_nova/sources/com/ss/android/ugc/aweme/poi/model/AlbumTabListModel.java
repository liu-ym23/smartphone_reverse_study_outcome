package com.ss.android.ugc.aweme.poi.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/model/AlbumTabListModel;", "Ljava/io/Serializable;", "tabName", "", "tabType", "", "itemIdList", "tabStyleMode", "tabPageSymbol", "contentSchema", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getContentSchema", "()Ljava/lang/String;", "getItemIdList", "getTabName", "setTabName", "(Ljava/lang/String;)V", "getTabPageSymbol", "getTabStyleMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTabType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/ugc/aweme/poi/model/AlbumTabListModel;", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AlbumTabListModel implements Serializable {

    @SerializedName("content_schema")
    private final String contentSchema;

    @SerializedName("item_id_list")
    private final String itemIdList;

    @SerializedName(a.KEY_TAB_NAME)
    private String tabName;

    @SerializedName("tab_page_symbol")
    private final String tabPageSymbol;

    @SerializedName("tab_style_mode")
    private final Integer tabStyleMode;

    @SerializedName("tab_type")
    private final Integer tabType;

    public AlbumTabListModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ AlbumTabListModel copy$default(AlbumTabListModel r100, String r101, Integer r102, String r103, Integer r104, String r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.tabName;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.tabType;
    L8:
        Integer r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.itemIdList;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.tabStyleMode;
    L14:
        Integer r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.tabPageSymbol;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.contentSchema;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.tabName;
    }

    public final Integer component2() {
        return this.tabType;
    }

    public final String component3() {
        return this.itemIdList;
    }

    public final Integer component4() {
        return this.tabStyleMode;
    }

    public final String component5() {
        return this.tabPageSymbol;
    }

    public final String component6() {
        return this.contentSchema;
    }

    public final AlbumTabListModel copy(String r100, Integer r110, String r111, Integer r112, String r113, String r114) {
        return new AlbumTabListModel(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumTabListModel) == true) goto L8;
        return false;
    L8:
        AlbumTabListModel r101 = (AlbumTabListModel) r100;
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabType, r101.tabType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.itemIdList, r101.itemIdList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabStyleMode, r101.tabStyleMode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabPageSymbol, r101.tabPageSymbol) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.contentSchema, r101.contentSchema) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.tabName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.tabType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.itemIdList;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.tabStyleMode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.tabPageSymbol;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.contentSchema;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
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
        return "AlbumTabListModel(tabName=" + this.tabName + ", tabType=" + this.tabType + ", itemIdList=" + this.itemIdList + ", tabStyleMode=" + this.tabStyleMode + ", tabPageSymbol=" + this.tabPageSymbol + ", contentSchema=" + this.contentSchema + ')';
    }

    public final String getContentSchema() {
        return this.contentSchema;
    }

    public final String getItemIdList() {
        return this.itemIdList;
    }

    public final String getTabName() {
        return this.tabName;
    }

    public final String getTabPageSymbol() {
        return this.tabPageSymbol;
    }

    public final Integer getTabStyleMode() {
        return this.tabStyleMode;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final void setTabName(String r100) {
        this.tabName = r100;
    }

    public AlbumTabListModel(String r100, Integer r101, String r102, Integer r103, String r104, String r105) {
        this.tabName = r100;
        this.tabType = r101;
        this.itemIdList = r102;
        this.tabStyleMode = r103;
        this.tabPageSymbol = r104;
        this.contentSchema = r105;
    }

    public /* synthetic */ AlbumTabListModel(String r100, Integer r101, String r102, Integer r103, String r104, String r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L6;
        r100 = "相册";
    L6:
        if ((r111 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        Integer r113 = r101;
        if ((r111 & 4) == 0) goto L11;
        r102 = null;
    L11:
        String r105 = r102;
        if ((r111 & 8) == 0) goto L14;
        r103 = Integer.valueOf(VIDEO_TAB_STYLE.DRAK.getValue());
    L14:
        Integer r106 = r103;
        if ((r111 & 16) == 0) goto L17;
        r104 = "photo";
    L17:
        String r107 = r104;
        if ((r111 & 32) == 0) goto L20;
        r110 = "";
    L20:
        String r108 = r100;
        this(r108, r113, r105, r106, r107, r110);
    }
}
