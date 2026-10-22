package com.bytedance.awemeopen.bizmodels.feed.poi;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006¨\u0006*"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/poi/r;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "Lt14/a;", "cover", "Lt14/a;", "getCover", "()Lt14/a;", "description", "getDescription", "setDescription", "classCode", "getClassCode", "setClassCode", "cityCode", "getCityCode", "setCityCode", "", "locationIndex", "J", "getLocationIndex", "()J", "setLocationIndex", "(J)V", "schema", "getSchema", "setSchema", "subClass", "getSubClass", "setSubClass", "backendTypeCode", "getBackendTypeCode", "cityName", "getCityName", "backendTypeName", "getBackendTypeName", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class r {

    @SerializedName("backend_type_code")
    private final String backendTypeCode;

    @SerializedName("backend_type_name")
    private final String backendTypeName;

    @SerializedName("city_code")
    private String cityCode;

    @SerializedName("city_name")
    private final String cityName;

    @SerializedName("class_code")
    private String classCode;

    @SerializedName("cover")
    private final t14.a cover;

    @SerializedName("description")
    private String description;

    @SerializedName("location_index")
    private long locationIndex;

    @SerializedName("schema")
    private String schema;

    @SerializedName("sec_class_name")
    private String subClass;

    @SerializedName("title")
    private String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.description, r101.description) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.classCode, r101.classCode) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cityCode, r101.cityCode) == true) goto L24;
        return false;
    L24:
        if (this.locationIndex == r101.locationIndex) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.subClass, r101.subClass) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.backendTypeCode, r101.backendTypeCode) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.cityName, r101.cityName) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.backendTypeName, r101.backendTypeName) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        t14.a r104 = this.cover;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.description;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.classCode;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cityCode;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = this.locationIndex;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        String r118 = this.schema;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.subClass;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.backendTypeCode;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.cityName;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.backendTypeName;
        if (r130 == null) goto L43;
        r101 = r130.hashCode();
    L43:
        return r129 + r101;
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
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
        return "PoiRankCardStruct(title=" + this.title + ", cover=" + this.cover + ", description=" + this.description + ", classCode=" + this.classCode + ", cityCode=" + this.cityCode + ", locationIndex=" + this.locationIndex + ", schema=" + this.schema + ", subClass=" + this.subClass + ", backendTypeCode=" + this.backendTypeCode + ", cityName=" + this.cityName + ", backendTypeName=" + this.backendTypeName + ')';
    }
}
