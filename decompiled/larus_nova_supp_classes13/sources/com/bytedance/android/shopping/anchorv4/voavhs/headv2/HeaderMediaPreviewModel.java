package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderMediaPreviewModel;", "Ljava/io/Serializable;", "previewIndex", "", "urlModel", "Lcom/bytedance/android/ec/model/ECUrlModel;", "sliceKey", "", "(ILcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;)V", "getPreviewIndex", "()I", "getSliceKey", "()Ljava/lang/String;", "getUrlModel", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderMediaPreviewModel implements Serializable {

    @SerializedName("preview_index")
    private final int previewIndex;

    @SerializedName("slice_key")
    private final String sliceKey;

    @SerializedName("url_model")
    private final ECUrlModel urlModel;

    public HeaderMediaPreviewModel() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ HeaderMediaPreviewModel copy$default(HeaderMediaPreviewModel r0, int r1, ECUrlModel r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.previewIndex;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.urlModel;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.sliceKey;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.previewIndex;
    }

    public final ECUrlModel component2() {
        return this.urlModel;
    }

    public final String component3() {
        return this.sliceKey;
    }

    public final HeaderMediaPreviewModel copy(int r2, ECUrlModel r3, String r4) {
        return new HeaderMediaPreviewModel(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HeaderMediaPreviewModel) == false) goto L12;
        HeaderMediaPreviewModel r4 = (HeaderMediaPreviewModel) r3;
        if (this.previewIndex == r4.previewIndex) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlModel, r4.urlModel) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sliceKey, r4.sliceKey) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r0 = this.previewIndex * 31;
        ECUrlModel r1 = this.urlModel;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.sliceKey;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public String toString() {
        return "HeaderMediaPreviewModel(previewIndex=" + this.previewIndex + ", urlModel=" + this.urlModel + ", sliceKey=" + this.sliceKey + ")";
    }

    public final int getPreviewIndex() {
        return this.previewIndex;
    }

    public final String getSliceKey() {
        return this.sliceKey;
    }

    public final ECUrlModel getUrlModel() {
        return this.urlModel;
    }

    public HeaderMediaPreviewModel(int r1, ECUrlModel r2, String r3) {
        this.previewIndex = r1;
        this.urlModel = r2;
        this.sliceKey = r3;
    }

    public /* synthetic */ HeaderMediaPreviewModel(int r2, ECUrlModel r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
