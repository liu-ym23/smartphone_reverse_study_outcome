package com.ss.android.ugc.aweme.shortvideo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/ExtraEffectFrameItem;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "path", "", "width", "", "height", DBDefinition.MIME_TYPE, "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getMimeType", "setMimeType", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class ExtraEffectFrameItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<ExtraEffectFrameItem> CREATOR = null;

    @SerializedName("height")
    private int height;

    @SerializedName("mime_type")
    private int mimeType;

    @SerializedName("path")
    private String path;

    @SerializedName("width")
    private int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<ExtraEffectFrameItem> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final ExtraEffectFrameItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new ExtraEffectFrameItem(r100.readString(), r100.readInt(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final ExtraEffectFrameItem[] newArray(int r100) {
            return new ExtraEffectFrameItem[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ExtraEffectFrameItem() {
        this(null, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ExtraEffectFrameItem copy$default(ExtraEffectFrameItem r100, String r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.path;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.width;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.mimeType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.path;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.mimeType;
    }

    public final ExtraEffectFrameItem copy(String r100, int r101, int r102, int r103) {
        return new ExtraEffectFrameItem(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ExtraEffectFrameItem) == false) goto L14;
        ExtraEffectFrameItem r101 = (ExtraEffectFrameItem) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
        return false;
    L8:
        if (this.width == r101.width) goto L10;
        return false;
    L10:
        if (this.height == r101.height) goto L12;
        return false;
    L12:
        if (this.mimeType == r101.mimeType) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.path;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + this.width) * 31) + this.height) * 31) + this.mimeType;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "ExtraEffectFrameItem(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", mimeType=" + this.mimeType + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.path);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.mimeType);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMimeType() {
        return this.mimeType;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setMimeType(int r100) {
        this.mimeType = r100;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public ExtraEffectFrameItem(String r100, int r101, int r102, int r103) {
        this.path = r100;
        this.width = r101;
        this.height = r102;
        this.mimeType = r103;
    }

    public /* synthetic */ ExtraEffectFrameItem(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
