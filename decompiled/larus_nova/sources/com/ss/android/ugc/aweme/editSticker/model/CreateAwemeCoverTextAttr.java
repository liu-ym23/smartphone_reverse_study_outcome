package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/CreateAwemeCoverTextAttr;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "coverTextId", "", "coverTextFont", "covertTextColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverTextFont", "()Ljava/lang/String;", "getCoverTextId", "getCovertTextColor", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CreateAwemeCoverTextAttr implements Parcelable, Serializable {
    public static final Parcelable.Creator<CreateAwemeCoverTextAttr> CREATOR = null;

    @SerializedName("cover_text_font")
    private final String coverTextFont;

    @SerializedName("cover_text_id")
    private final String coverTextId;

    @SerializedName("cover_text_color")
    private final String covertTextColor;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<CreateAwemeCoverTextAttr> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final CreateAwemeCoverTextAttr createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new CreateAwemeCoverTextAttr(r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final CreateAwemeCoverTextAttr[] newArray(int r100) {
            return new CreateAwemeCoverTextAttr[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ CreateAwemeCoverTextAttr copy$default(CreateAwemeCoverTextAttr r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.coverTextId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.coverTextFont;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.covertTextColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.coverTextId;
    }

    public final String component2() {
        return this.coverTextFont;
    }

    public final String component3() {
        return this.covertTextColor;
    }

    public final CreateAwemeCoverTextAttr copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "coverTextId");
        Intrinsics.checkNotNullParameter(r101, "coverTextFont");
        Intrinsics.checkNotNullParameter(r102, "covertTextColor");
        return new CreateAwemeCoverTextAttr(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CreateAwemeCoverTextAttr) == false) goto L12;
        CreateAwemeCoverTextAttr r101 = (CreateAwemeCoverTextAttr) r100;
        if (Intrinsics.areEqual(this.coverTextId, r101.coverTextId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.coverTextFont, r101.coverTextFont) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.covertTextColor, r101.covertTextColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.coverTextId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.coverTextFont;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.covertTextColor;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "CreateAwemeCoverTextAttr(coverTextId=" + this.coverTextId + ", coverTextFont=" + this.coverTextFont + ", covertTextColor=" + this.covertTextColor + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.coverTextId);
        r100.writeString(this.coverTextFont);
        r100.writeString(this.covertTextColor);
    }

    public final String getCoverTextFont() {
        return this.coverTextFont;
    }

    public final String getCoverTextId() {
        return this.coverTextId;
    }

    public final String getCovertTextColor() {
        return this.covertTextColor;
    }

    public CreateAwemeCoverTextAttr(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "coverTextId");
        Intrinsics.checkNotNullParameter(r101, "coverTextFont");
        Intrinsics.checkNotNullParameter(r102, "covertTextColor");
        this.coverTextId = r100;
        this.coverTextFont = r101;
        this.covertTextColor = r102;
    }
}
