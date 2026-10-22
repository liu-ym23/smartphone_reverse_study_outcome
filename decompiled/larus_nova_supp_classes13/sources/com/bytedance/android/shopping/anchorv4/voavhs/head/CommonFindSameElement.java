package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0013JL\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "Ljava/io/Serializable;", "schema", "", "requestParams", "", "", "defaultImage", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "type", "", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;)V", "getDefaultImage", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getRequestParams", "()Ljava/util/Map;", "getSchema", "()Ljava/lang/String;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "equals", "", "other", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonFindSameElement implements Serializable {

    @SerializedName("default_image")
    private final ImageModel defaultImage;

    @SerializedName("request_params")
    private final Map<String, Object> requestParams;
    private final String schema;

    @SerializedName("type")
    private final Integer type;

    public CommonFindSameElement() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CommonFindSameElement copy$default(CommonFindSameElement r0, String r1, Map r2, ImageModel r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.schema;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.requestParams;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.defaultImage;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.type;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.schema;
    }

    public final Map<String, Object> component2() {
        return this.requestParams;
    }

    public final ImageModel component3() {
        return this.defaultImage;
    }

    public final Integer component4() {
        return this.type;
    }

    public final CommonFindSameElement copy(String r2, Map<String, ? extends Object> r3, ImageModel r4, Integer r5) {
        return new CommonFindSameElement(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommonFindSameElement) == false) goto L14;
        CommonFindSameElement r4 = (CommonFindSameElement) r3;
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.requestParams, r4.requestParams) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultImage, r4.defaultImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r4.type) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.schema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, Object> r4 = this.requestParams;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ImageModel r7 = this.defaultImage;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.type;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CommonFindSameElement(schema=" + this.schema + ", requestParams=" + this.requestParams + ", defaultImage=" + this.defaultImage + ", type=" + this.type + ")";
    }

    public final ImageModel getDefaultImage() {
        return this.defaultImage;
    }

    public final Map<String, Object> getRequestParams() {
        return this.requestParams;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final Integer getType() {
        return this.type;
    }

    public CommonFindSameElement(String r1, Map<String, ? extends Object> r2, ImageModel r3, Integer r4) {
        this.schema = r1;
        this.requestParams = r2;
        this.defaultImage = r3;
        this.type = r4;
    }

    public /* synthetic */ CommonFindSameElement(String r2, Map r3, ImageModel r4, Integer r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
