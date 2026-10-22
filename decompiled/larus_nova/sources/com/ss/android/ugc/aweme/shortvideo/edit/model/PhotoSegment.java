package com.ss.android.ugc.aweme.shortvideo.edit.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/edit/model/PhotoSegment;", "Landroid/os/Parcelable;", "path", "", "width", "", "height", "(Ljava/lang/String;II)V", "getHeight", "()I", "getPath", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class PhotoSegment implements Parcelable {
    public static final Parcelable.Creator<PhotoSegment> CREATOR = null;
    private final int height;
    private final String path;
    private final int width;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<PhotoSegment> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSegment createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new PhotoSegment(r100.readString(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSegment[] newArray(int r100) {
            return new PhotoSegment[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    public static /* synthetic */ PhotoSegment copy$default(PhotoSegment r100, String r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.path;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.width;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.height;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final PhotoSegment copy(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new PhotoSegment(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PhotoSegment) == false) goto L12;
        PhotoSegment r101 = (PhotoSegment) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
        return false;
    L8:
        if (this.width == r101.width) goto L10;
        return false;
    L10:
        if (this.height == r101.height) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.path;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.width) * 31) + this.height;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "PhotoSegment(path=" + this.path + ", width=" + this.width + ", height=" + this.height + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.path);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getPath() {
        return this.path;
    }

    public final int getWidth() {
        return this.width;
    }

    public PhotoSegment(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.path = r100;
        this.width = r101;
        this.height = r102;
    }
}
