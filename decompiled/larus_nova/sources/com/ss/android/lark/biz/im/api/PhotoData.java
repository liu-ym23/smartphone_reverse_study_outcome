package com.ss.android.lark.biz.im.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0005J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/biz/im/api/PhotoData;", "Landroid/os/Parcelable;", "url", "", "width", "", "height", "<init>", "(Ljava/lang/String;II)V", "getUrl", "()Ljava/lang/String;", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoData implements Parcelable {
    public static final Parcelable.Creator<PhotoData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f409889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f409890c;

    public static final class a implements Parcelable.Creator<PhotoData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new PhotoData(r100.readString(), r100.readInt(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoData[] newArray(int r100) {
            return new PhotoData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoData) == true) goto L8;
        return false;
    L8:
        PhotoData r101 = (PhotoData) r100;
        if (Intrinsics.areEqual(this.f409888a, r101.f409888a) == true) goto L12;
        return false;
    L12:
        if (this.f409889b == r101.f409889b) goto L15;
        return false;
    L15:
        if (this.f409890c == r101.f409890c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f409888a.hashCode() * 31) + this.f409889b) * 31) + this.f409890c;
    }

    public final String toString() {
        return "PhotoData(url=" + this.f409888a + ", width=" + this.f409889b + ", height=" + this.f409890c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f409888a);
        r100.writeInt(this.f409889b);
        r100.writeInt(this.f409890c);
    }

    public PhotoData(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f409888a = r100;
        this.f409889b = r101;
        this.f409890c = r102;
    }
}
