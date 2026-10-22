package com.larus.bmhome.chat.markdown.imagegroup;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014Jh\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0007\u0010\u0014R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\t\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\"\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/markdown/imagegroup/ImageGroupData;", "", "imageShowType", "", "images", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "isPlaceholder", "", "isEmptySearch", "imageShowTypeVersion", "forbiddenPadding", "isTop", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getImageShowType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImages", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageShowTypeVersion", "getForbiddenPadding", "setTop", "(Ljava/lang/Boolean;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/markdown/imagegroup/ImageGroupData;", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("forbidden_padding")
    private final Boolean forbiddenPadding;

    @SerializedName("image_show_type")
    private final Integer imageShowType;

    @SerializedName("image_show_type_version")
    private final Integer imageShowTypeVersion;

    @SerializedName("images")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<SearchImageInfo> images;

    @SerializedName("is_empty_search")
    private final Boolean isEmptySearch;

    @SerializedName("is_placeholder")
    private final Boolean isPlaceholder;

    @SerializedName("is_top")
    private Boolean isTop;

    public a() {
        this(null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.imageShowType, r101.imageShowType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.isPlaceholder, r101.isPlaceholder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isEmptySearch, r101.isEmptySearch) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageShowTypeVersion, r101.imageShowTypeVersion) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.forbiddenPadding, r101.forbiddenPadding) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isTop, r101.isTop) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.imageShowType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<SearchImageInfo> r104 = this.images;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.isPlaceholder;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isEmptySearch;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.imageShowTypeVersion;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.forbiddenPadding;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isTop;
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
        return "ImageGroupData(imageShowType=" + this.imageShowType + ", images=" + this.images + ", isPlaceholder=" + this.isPlaceholder + ", isEmptySearch=" + this.isEmptySearch + ", imageShowTypeVersion=" + this.imageShowTypeVersion + ", forbiddenPadding=" + this.forbiddenPadding + ", isTop=" + this.isTop + ')';
    }

    public final Integer b() {
        return this.imageShowType;
    }

    public final List<SearchImageInfo> c() {
        return this.images;
    }

    public final Boolean d() {
        return this.isTop;
    }

    public static a a(a r100, List r101) {
        Integer r102 = r100.imageShowType;
        Boolean r103 = r100.isPlaceholder;
        Boolean r104 = r100.isEmptySearch;
        Integer r105 = r100.imageShowTypeVersion;
        Boolean r106 = r100.forbiddenPadding;
        Boolean r107 = r100.isTop;
        r100.getClass();
        return new a(r102, r101, r103, r104, r105, r106, r107);
    }

    public /* synthetic */ a(Integer r110, List r111, Integer r112, Boolean r113, int r114) {
        Boolean r100 = null;
        if ((r114 & 1) == 0) goto L5;
        Integer r101 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        List r102 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        Boolean r103 = Boolean.FALSE;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r104 = Boolean.FALSE;
    L19:
        if ((r114 & 16) == 0) goto L21;
        r112 = 0;
    L21:
        Integer r105 = r112;
        if ((r114 & 32) == 0) goto L24;
        r100 = Boolean.FALSE;
    L24:
        Boolean r106 = r100;
        if ((r114 & 64) == 0) goto L27;
        r113 = Boolean.FALSE;
    L27:
        this(r101, r102, r103, r104, r105, r106, r113);
        return;
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public a(Integer r100, List<SearchImageInfo> r101, Boolean r102, Boolean r103, Integer r104, Boolean r105, Boolean r106) {
        this.imageShowType = r100;
        this.images = r101;
        this.isPlaceholder = r102;
        this.isEmptySearch = r103;
        this.imageShowTypeVersion = r104;
        this.forbiddenPadding = r105;
        this.isTop = r106;
    }
}
