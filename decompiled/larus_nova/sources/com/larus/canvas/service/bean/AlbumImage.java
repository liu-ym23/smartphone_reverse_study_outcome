package com.larus.canvas.service.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/canvas/service/bean/AlbumImage;", "Lcom/larus/canvas/service/bean/IImageInfo;", "uri", "Landroid/net/Uri;", "needReview", "", "isAiCreation", "<init>", "(Landroid/net/Uri;ZZ)V", "getUri", "()Landroid/net/Uri;", "getNeedReview", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumImage implements IImageInfo {
    public static final Parcelable.Creator<AlbumImage> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f323803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f323804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f323805c;

    public static final class a implements Parcelable.Creator<AlbumImage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumImage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Uri r101 = (Uri) r100.readParcelable(AlbumImage.class.getClassLoader());
            boolean r102 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            if (r100.readInt() == 0) goto L10;
            r102 = true;
        L10:
            return new AlbumImage(r101, r103, r102);
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumImage[] newArray(int r100) {
            return new AlbumImage[r100];
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
        if ((r100 instanceof AlbumImage) == true) goto L8;
        return false;
    L8:
        AlbumImage r101 = (AlbumImage) r100;
        if (Intrinsics.areEqual(this.f323803a, r101.f323803a) == true) goto L12;
        return false;
    L12:
        if (this.f323804b == r101.f323804b) goto L15;
        return false;
    L15:
        if (this.f323805c == r101.f323805c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f323803a.hashCode() * 31;
        int r101 = 1231;
        if (this.f323804b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f323805c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "AlbumImage(uri=" + this.f323803a + ", needReview=" + this.f323804b + ", isAiCreation=" + this.f323805c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f323803a, r101);
        r100.writeInt(this.f323804b ? 1 : 0);
        r100.writeInt(this.f323805c ? 1 : 0);
    }

    public /* synthetic */ AlbumImage(Uri r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 4) == 0) goto L9;
        r101 = false;
    L9:
        this(r100, r103, r101);
        return;
    L5:
        r103 = false;
        goto L7
    }

    public AlbumImage(Uri r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        this.f323803a = r100;
        this.f323804b = r101;
        this.f323805c = r102;
    }
}
