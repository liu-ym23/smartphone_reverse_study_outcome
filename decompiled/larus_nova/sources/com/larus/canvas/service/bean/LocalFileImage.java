package com.larus.canvas.service.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JF\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0006J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/larus/canvas/service/bean/LocalFileImage;", "Lcom/larus/canvas/service/bean/IImageInfo;", "localFilePath", "", "uri", "width", "", "height", "needReview", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "getLocalFilePath", "()Ljava/lang/String;", "getUri", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getNeedReview", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Z)Lcom/larus/canvas/service/bean/LocalFileImage;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalFileImage implements IImageInfo {
    public static final Parcelable.Creator<LocalFileImage> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f323817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f323818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f323819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f323820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f323821e;

    public static final class a implements Parcelable.Creator<LocalFileImage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LocalFileImage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r104 = null;
        L11:
            if (r100.readInt() == 0) goto L13;
            boolean r105 = true;
        L15:
            return new LocalFileImage(r101, r102, r103, r104, r105);
        L13:
            r105 = false;
            goto L15
        L9:
            r104 = Integer.valueOf(r100.readInt());
            goto L11
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LocalFileImage[] newArray(int r100) {
            return new LocalFileImage[r100];
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
        if ((r100 instanceof LocalFileImage) == true) goto L8;
        return false;
    L8:
        LocalFileImage r101 = (LocalFileImage) r100;
        if (Intrinsics.areEqual(this.f323817a, r101.f323817a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323818b, r101.f323818b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323819c, r101.f323819c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f323820d, r101.f323820d) == true) goto L21;
        return false;
    L21:
        if (this.f323821e == r101.f323821e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f323817a.hashCode() * 31;
        String r101 = this.f323818b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f323819c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f323820d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (r107 + r102) * 31;
        if (this.f323821e == false) goto L17;
        int r110 = 1231;
    L19:
        return r109 + r110;
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalFileImage(localFilePath=" + this.f323817a + ", uri=" + this.f323818b + ", width=" + this.f323819c + ", height=" + this.f323820d + ", needReview=" + this.f323821e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f323817a);
        r100.writeString(this.f323818b);
        Integer r102 = this.f323819c;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.f323820d;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeInt(this.f323821e ? 1 : 0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
        goto L6
    }

    public LocalFileImage(String r100, String r101, Integer r102, Integer r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "localFilePath");
        this.f323817a = r100;
        this.f323818b = r101;
        this.f323819c = r102;
        this.f323820d = r103;
        this.f323821e = r104;
    }
}
