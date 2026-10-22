package com.ss.android.ugc.aweme.shortvideo.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/FrameItemCropInfo;", "Ljava/io/Serializable;", "leftTop", "Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;", "leftBottom", "rightTop", "rightBottom", "(Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;)V", "getLeftBottom", "()Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;", "setLeftBottom", "(Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;)V", "getLeftTop", "setLeftTop", "getRightBottom", "setRightBottom", "getRightTop", "setRightTop", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class FrameItemCropInfo implements Serializable {

    @SerializedName("bottomLeft")
    private CorpPointF leftBottom;

    @SerializedName("topLeft")
    private CorpPointF leftTop;

    @SerializedName("bottomRight")
    private CorpPointF rightBottom;

    @SerializedName("topRight")
    private CorpPointF rightTop;

    public FrameItemCropInfo() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FrameItemCropInfo copy$default(FrameItemCropInfo r100, CorpPointF r101, CorpPointF r102, CorpPointF r103, CorpPointF r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.leftTop;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.leftBottom;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.rightTop;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.rightBottom;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final CorpPointF component1() {
        return this.leftTop;
    }

    public final CorpPointF component2() {
        return this.leftBottom;
    }

    public final CorpPointF component3() {
        return this.rightTop;
    }

    public final CorpPointF component4() {
        return this.rightBottom;
    }

    public final FrameItemCropInfo copy(CorpPointF r100, CorpPointF r101, CorpPointF r102, CorpPointF r103) {
        Intrinsics.checkNotNullParameter(r100, "leftTop");
        Intrinsics.checkNotNullParameter(r101, "leftBottom");
        Intrinsics.checkNotNullParameter(r102, "rightTop");
        Intrinsics.checkNotNullParameter(r103, "rightBottom");
        return new FrameItemCropInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FrameItemCropInfo) == false) goto L14;
        FrameItemCropInfo r101 = (FrameItemCropInfo) r100;
        if (Intrinsics.areEqual(this.leftTop, r101.leftTop) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftBottom, r101.leftBottom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.rightTop, r101.rightTop) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rightBottom, r101.rightBottom) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        CorpPointF r100 = this.leftTop;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CorpPointF r104 = this.leftBottom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        CorpPointF r107 = this.rightTop;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        CorpPointF r110 = this.rightBottom;
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
        return "FrameItemCropInfo(leftTop=" + this.leftTop + ", leftBottom=" + this.leftBottom + ", rightTop=" + this.rightTop + ", rightBottom=" + this.rightBottom + ")";
    }

    public final CorpPointF getLeftBottom() {
        return this.leftBottom;
    }

    public final CorpPointF getLeftTop() {
        return this.leftTop;
    }

    public final CorpPointF getRightBottom() {
        return this.rightBottom;
    }

    public final CorpPointF getRightTop() {
        return this.rightTop;
    }

    public final void setLeftBottom(CorpPointF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.leftBottom = r100;
    }

    public final void setLeftTop(CorpPointF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.leftTop = r100;
    }

    public final void setRightBottom(CorpPointF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rightBottom = r100;
    }

    public final void setRightTop(CorpPointF r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rightTop = r100;
    }

    public FrameItemCropInfo(CorpPointF r100, CorpPointF r101, CorpPointF r102, CorpPointF r103) {
        Intrinsics.checkNotNullParameter(r100, "leftTop");
        Intrinsics.checkNotNullParameter(r101, "leftBottom");
        Intrinsics.checkNotNullParameter(r102, "rightTop");
        Intrinsics.checkNotNullParameter(r103, "rightBottom");
        this.leftTop = r100;
        this.leftBottom = r101;
        this.rightTop = r102;
        this.rightBottom = r103;
    }

    public /* synthetic */ FrameItemCropInfo(CorpPointF r100, CorpPointF r101, CorpPointF r102, CorpPointF r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new CorpPointF(0.0f, 0.0f);
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new CorpPointF(0.0f, 1.0f);
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new CorpPointF(1.0f, 0.0f);
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new CorpPointF(1.0f, 1.0f);
    L14:
        this(r100, r101, r102, r103);
    }
}
