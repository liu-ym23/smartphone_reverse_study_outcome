package jx6;

import com.amap.api.col.s.ce;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ljx6/r;", "", "Lcom/google/gson/JsonObject;", "commodityV2", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "Lcom/google/gson/JsonArray;", "headImageTabs", "Lcom/google/gson/JsonArray;", "b", "()Lcom/google/gson/JsonArray;", "images", "c", "itemGroupList", "d", "Ljx6/s;", "previewPayButton", "Ljx6/s;", ce.f26391f, "()Ljx6/s;", "", "previewOptGroup", "I", "getPreviewOptGroup", "()I", "previewPageLogParams", "e", "", "previewPageSchema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class r {

    @SerializedName("commodityV2")
    private final JsonObject commodityV2;

    @SerializedName("head_image_tabs")
    private final JsonArray headImageTabs;

    @SerializedName("images")
    private final JsonArray images;

    @SerializedName("itemGroupList")
    private final JsonArray itemGroupList;

    @SerializedName("previewOptGroup")
    private final int previewOptGroup;

    @SerializedName("previewPageLogParams")
    private final JsonObject previewPageLogParams;

    @SerializedName("previewPageSchema")
    private final String previewPageSchema;

    @SerializedName("previewPayButton")
    private final s previewPayButton;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.commodityV2, r101.commodityV2) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.headImageTabs, r101.headImageTabs) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemGroupList, r101.itemGroupList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.previewPayButton, r101.previewPayButton) == true) goto L24;
        return false;
    L24:
        if (this.previewOptGroup == r101.previewOptGroup) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.previewPageLogParams, r101.previewPageLogParams) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.previewPageSchema, r101.previewPageSchema) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        JsonObject r100 = this.commodityV2;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonArray r104 = this.headImageTabs;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JsonArray r107 = this.images;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JsonArray r110 = this.itemGroupList;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        s r113 = this.previewPayButton;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((r112 + r114) * 31) + this.previewOptGroup) * 31;
        JsonObject r116 = this.previewPageLogParams;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.previewPageSchema;
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
        return "PreviewImageDetailPageActionParams(commodityV2=" + this.commodityV2 + ", headImageTabs=" + this.headImageTabs + ", images=" + this.images + ", itemGroupList=" + this.itemGroupList + ", previewPayButton=" + this.previewPayButton + ", previewOptGroup=" + this.previewOptGroup + ", previewPageLogParams=" + this.previewPageLogParams + ", previewPageSchema=" + this.previewPageSchema + ')';
    }

    public r() {
        this.commodityV2 = null;
        this.headImageTabs = null;
        this.images = null;
        this.itemGroupList = null;
        this.previewPayButton = null;
        this.previewOptGroup = 0;
        this.previewPageLogParams = null;
        this.previewPageSchema = null;
    }

    public final JsonObject a() {
        return this.commodityV2;
    }

    public final JsonArray b() {
        return this.headImageTabs;
    }

    public final JsonArray c() {
        return this.images;
    }

    public final JsonArray d() {
        return this.itemGroupList;
    }

    public final JsonObject e() {
        return this.previewPageLogParams;
    }

    public final String f() {
        return this.previewPageSchema;
    }

    public final s g() {
        return this.previewPayButton;
    }
}
