package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J`\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateCommonTag;", "Ljava/io/Serializable;", "contentType", "", "imageUrl", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "text", "", "uiParams", "Lcom/bytedance/locallife/model/poi/resp/TagUiParams;", "clickEvent", "Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;", "cellModeSplitType", "picModeSplitType", "(ILcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/TagUiParams;Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCellModeSplitType", "()Ljava/lang/Integer;", "setCellModeSplitType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getClickEvent", "()Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;", "getContentType", "()I", "getImageUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getPicModeSplitType", "setPicModeSplitType", "getText", "()Ljava/lang/String;", "getUiParams", "()Lcom/bytedance/locallife/model/poi/resp/TagUiParams;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ILcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Lcom/bytedance/locallife/model/poi/resp/TagUiParams;Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/locallife/model/poi/resp/RateCommonTag;", "equals", "", "other", "", "hashCode", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RateCommonTag implements Serializable {
    private Integer cellModeSplitType;

    @SerializedName("click_event")
    private final TagClickEvent clickEvent;

    @SerializedName("content_type")
    private final int contentType;

    @SerializedName("image_url")
    private final PoiImageUrlModel imageUrl;
    private Integer picModeSplitType;

    @SerializedName("text")
    private final String text;

    @SerializedName("ui_params")
    private final TagUiParams uiParams;

    public RateCommonTag() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ RateCommonTag copy$default(RateCommonTag r100, int r101, PoiImageUrlModel r102, String r103, TagUiParams r104, TagClickEvent r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.contentType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.imageUrl;
    L8:
        PoiImageUrlModel r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.text;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.uiParams;
    L14:
        TagUiParams r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.clickEvent;
    L17:
        TagClickEvent r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.cellModeSplitType;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.picModeSplitType;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.contentType;
    }

    public final PoiImageUrlModel component2() {
        return this.imageUrl;
    }

    public final String component3() {
        return this.text;
    }

    public final TagUiParams component4() {
        return this.uiParams;
    }

    public final TagClickEvent component5() {
        return this.clickEvent;
    }

    public final Integer component6() {
        return this.cellModeSplitType;
    }

    public final Integer component7() {
        return this.picModeSplitType;
    }

    public final RateCommonTag copy(int r110, PoiImageUrlModel r111, String r112, TagUiParams r113, TagClickEvent r114, Integer r115, Integer r116) {
        return new RateCommonTag(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RateCommonTag) == true) goto L8;
        return false;
    L8:
        RateCommonTag r101 = (RateCommonTag) r100;
        if (this.contentType == r101.contentType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uiParams, r101.uiParams) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.clickEvent, r101.clickEvent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.cellModeSplitType, r101.cellModeSplitType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.picModeSplitType, r101.picModeSplitType) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.contentType * 31;
        PoiImageUrlModel r101 = this.imageUrl;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.text;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        TagUiParams r108 = this.uiParams;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        TagClickEvent r111 = this.clickEvent;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.cellModeSplitType;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.picModeSplitType;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "RateCommonTag(contentType=" + this.contentType + ", imageUrl=" + this.imageUrl + ", text=" + this.text + ", uiParams=" + this.uiParams + ", clickEvent=" + this.clickEvent + ", cellModeSplitType=" + this.cellModeSplitType + ", picModeSplitType=" + this.picModeSplitType + ')';
    }

    public final Integer getCellModeSplitType() {
        return this.cellModeSplitType;
    }

    public final TagClickEvent getClickEvent() {
        return this.clickEvent;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final PoiImageUrlModel getImageUrl() {
        return this.imageUrl;
    }

    public final Integer getPicModeSplitType() {
        return this.picModeSplitType;
    }

    public final String getText() {
        return this.text;
    }

    public final TagUiParams getUiParams() {
        return this.uiParams;
    }

    public final void setCellModeSplitType(Integer r100) {
        this.cellModeSplitType = r100;
    }

    public final void setPicModeSplitType(Integer r100) {
        this.picModeSplitType = r100;
    }

    public RateCommonTag(int r100, PoiImageUrlModel r101, String r102, TagUiParams r103, TagClickEvent r104, Integer r105, Integer r106) {
        this.contentType = r100;
        this.imageUrl = r101;
        this.text = r102;
        this.uiParams = r103;
        this.clickEvent = r104;
        this.cellModeSplitType = r105;
        this.picModeSplitType = r106;
    }

    public /* synthetic */ RateCommonTag(int r100, PoiImageUrlModel r101, String r102, TagUiParams r103, TagClickEvent r110, Integer r111, Integer r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        Integer r104 = null;
        if ((r113 & 2) == 0) goto L8;
        PoiImageUrlModel r115 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        r102 = "";
    L12:
        String r105 = r102;
        if ((r113 & 8) == 0) goto L15;
        TagUiParams r106 = null;
    L17:
        if ((r113 & 16) == 0) goto L19;
        TagClickEvent r107 = null;
    L21:
        if ((r113 & 32) == 0) goto L23;
        Integer r108 = null;
    L25:
        if ((r113 & 64) != 0) goto L28;
        r104 = r112;
    L28:
        this(r100, r115, r105, r106, r107, r108, r104);
        return;
    L23:
        r108 = r111;
        goto L25
    L19:
        r107 = r110;
        goto L21
    L15:
        r106 = r103;
        goto L17
    L8:
        r115 = r101;
        goto L10
    }
}
