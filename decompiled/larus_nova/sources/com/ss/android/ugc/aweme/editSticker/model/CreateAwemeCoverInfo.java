package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "isCoverText", "", "isCoverPositioned", "coverTextAttr", "Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverTextAttr;", "(IILcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverTextAttr;)V", "getCoverTextAttr", "()Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverTextAttr;", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CreateAwemeCoverInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<CreateAwemeCoverInfo> CREATOR = null;

    @SerializedName("cover_text_attr")
    private final CreateAwemeCoverTextAttr coverTextAttr;

    @SerializedName("is_cover_positioned")
    private final int isCoverPositioned;

    @SerializedName("is_cover_text")
    private final int isCoverText;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<CreateAwemeCoverInfo> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreateAwemeCoverInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new CreateAwemeCoverInfo(r100.readInt(), r100.readInt(), CreateAwemeCoverTextAttr.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public final CreateAwemeCoverInfo[] newArray(int r100) {
            return new CreateAwemeCoverInfo[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ CreateAwemeCoverInfo copy$default(CreateAwemeCoverInfo r100, int r101, int r102, CreateAwemeCoverTextAttr r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.isCoverText;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.isCoverPositioned;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.coverTextAttr;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.isCoverText;
    }

    public final int component2() {
        return this.isCoverPositioned;
    }

    public final CreateAwemeCoverTextAttr component3() {
        return this.coverTextAttr;
    }

    public final CreateAwemeCoverInfo copy(int r100, int r101, CreateAwemeCoverTextAttr r102) {
        Intrinsics.checkNotNullParameter(r102, "coverTextAttr");
        return new CreateAwemeCoverInfo(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CreateAwemeCoverInfo) == false) goto L12;
        CreateAwemeCoverInfo r101 = (CreateAwemeCoverInfo) r100;
        if (this.isCoverText == r101.isCoverText) goto L8;
        return false;
    L8:
        if (this.isCoverPositioned == r101.isCoverPositioned) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.coverTextAttr, r101.coverTextAttr) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = ((this.isCoverText * 31) + this.isCoverPositioned) * 31;
        CreateAwemeCoverTextAttr r101 = this.coverTextAttr;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "CreateAwemeCoverInfo(isCoverText=" + this.isCoverText + ", isCoverPositioned=" + this.isCoverPositioned + ", coverTextAttr=" + this.coverTextAttr + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.isCoverText);
        r100.writeInt(this.isCoverPositioned);
        this.coverTextAttr.writeToParcel(r100, 0);
    }

    public final CreateAwemeCoverTextAttr getCoverTextAttr() {
        return this.coverTextAttr;
    }

    public final int isCoverPositioned() {
        return this.isCoverPositioned;
    }

    public final int isCoverText() {
        return this.isCoverText;
    }

    public CreateAwemeCoverInfo(int r100, int r101, CreateAwemeCoverTextAttr r102) {
        Intrinsics.checkNotNullParameter(r102, "coverTextAttr");
        this.isCoverText = r100;
        this.isCoverPositioned = r101;
        this.coverTextAttr = r102;
    }
}
