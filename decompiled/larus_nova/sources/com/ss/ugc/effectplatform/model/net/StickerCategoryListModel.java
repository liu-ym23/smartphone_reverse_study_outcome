package com.ss.ugc.effectplatform.model.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J>\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListModel;", "", "id", "", "name", "", "icon_url", "Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;", "use_recommend", "", "(Ljava/lang/Long;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;Ljava/lang/Boolean;)V", "getIcon_url", "()Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;", "setIcon_url", "(Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUse_recommend", "()Ljava/lang/Boolean;", "setUse_recommend", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/net/StickerUrlStruct;Ljava/lang/Boolean;)Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListModel;", "equals", "other", "hashCode", "", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class StickerCategoryListModel {
    private StickerUrlStruct icon_url;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f457432id;
    private String name;
    private Boolean use_recommend;

    public StickerCategoryListModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ StickerCategoryListModel copy$default(StickerCategoryListModel r100, Long r101, String r102, StickerUrlStruct r103, Boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f457432id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.name;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.icon_url;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.use_recommend;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.f457432id;
    }

    public final String component2() {
        return this.name;
    }

    public final StickerUrlStruct component3() {
        return this.icon_url;
    }

    public final Boolean component4() {
        return this.use_recommend;
    }

    public final StickerCategoryListModel copy(Long r100, String r101, StickerUrlStruct r102, Boolean r103) {
        return new StickerCategoryListModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StickerCategoryListModel) == false) goto L14;
        StickerCategoryListModel r101 = (StickerCategoryListModel) r100;
        if (Intrinsics.areEqual(this.f457432id, r101.f457432id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon_url, r101.icon_url) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.use_recommend, r101.use_recommend) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        Long r100 = this.f457432id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        StickerUrlStruct r107 = this.icon_url;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.use_recommend;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StickerCategoryListModel(id=" + this.f457432id + ", name=" + this.name + ", icon_url=" + this.icon_url + ", use_recommend=" + this.use_recommend + ")";
    }

    public final StickerUrlStruct getIcon_url() {
        return this.icon_url;
    }

    public final Long getId() {
        return this.f457432id;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getUse_recommend() {
        return this.use_recommend;
    }

    public final void setIcon_url(StickerUrlStruct r100) {
        this.icon_url = r100;
    }

    public final void setId(Long r100) {
        this.f457432id = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setUse_recommend(Boolean r100) {
        this.use_recommend = r100;
    }

    public StickerCategoryListModel(Long r100, String r101, StickerUrlStruct r102, Boolean r103) {
        this.f457432id = r100;
        this.name = r101;
        this.icon_url = r102;
        this.use_recommend = r103;
    }

    public /* synthetic */ StickerCategoryListModel(Long r100, String r101, StickerUrlStruct r102, Boolean r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
