package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/HighQualityTag;", "Ljava/io/Serializable;", "id", "", "imgUrl", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "(Ljava/lang/String;Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getImgUrl", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class HighQualityTag implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("high_quality_tag_id")
    private String f260854id;

    @SerializedName("image_url")
    private final PoiImageUrlModel imgUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public HighQualityTag() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HighQualityTag copy$default(HighQualityTag r100, String r101, PoiImageUrlModel r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f260854id;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.imgUrl;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.f260854id;
    }

    public final PoiImageUrlModel component2() {
        return this.imgUrl;
    }

    public final HighQualityTag copy(String r100, PoiImageUrlModel r101) {
        return new HighQualityTag(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof HighQualityTag) == true) goto L8;
        return false;
    L8:
        HighQualityTag r101 = (HighQualityTag) r100;
        if (Intrinsics.areEqual(this.f260854id, r101.f260854id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imgUrl, r101.imgUrl) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.f260854id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PoiImageUrlModel r104 = this.imgUrl;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "HighQualityTag(id=" + this.f260854id + ", imgUrl=" + this.imgUrl + ')';
    }

    public final String getId() {
        return this.f260854id;
    }

    public final PoiImageUrlModel getImgUrl() {
        return this.imgUrl;
    }

    public final void setId(String r100) {
        this.f260854id = r100;
    }

    public HighQualityTag(String r100, PoiImageUrlModel r101) {
        this.f260854id = r100;
        this.imgUrl = r101;
    }

    public /* synthetic */ HighQualityTag(String r100, PoiImageUrlModel r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
