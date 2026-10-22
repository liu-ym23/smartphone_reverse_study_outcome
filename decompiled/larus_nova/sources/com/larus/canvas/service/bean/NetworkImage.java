package com.larus.canvas.service.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JR\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/larus/canvas/service/bean/NetworkImage;", "Lcom/larus/canvas/service/bean/IImageInfo;", "uri", "", "url", "width", "", "height", "localFilePath", "needReview", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Z)V", "getUri", "()Ljava/lang/String;", "getUrl", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getLocalFilePath", "getNeedReview", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/larus/canvas/service/bean/NetworkImage;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NetworkImage implements IImageInfo {
    public static final Parcelable.Creator<NetworkImage> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f323822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f323823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f323824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f323825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f323826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f323827f;

    public static final class a implements Parcelable.Creator<NetworkImage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final NetworkImage createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            if (r100.readInt() != 0) goto L9;
            Integer r104 = null;
        L10:
            String r105 = r100.readString();
            if (r100.readInt() == 0) goto L13;
            boolean r106 = true;
        L15:
            return new NetworkImage(r101, r102, r103, r104, r105, r106);
        L13:
            r106 = false;
            goto L15
        L9:
            r104 = Integer.valueOf(r100.readInt());
            goto L10
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final NetworkImage[] newArray(int r100) {
            return new NetworkImage[r100];
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
        if ((r100 instanceof NetworkImage) == true) goto L8;
        return false;
    L8:
        NetworkImage r101 = (NetworkImage) r100;
        if (Intrinsics.areEqual(this.f323822a, r101.f323822a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f323823b, r101.f323823b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f323824c, r101.f323824c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f323825d, r101.f323825d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f323826e, r101.f323826e) == true) goto L24;
        return false;
    L24:
        if (this.f323827f == r101.f323827f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f323822a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f323823b.hashCode()) * 31;
        Integer r104 = this.f323824c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f323825d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f323826e;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        int r111 = (r109 + r101) * 31;
        if (this.f323827f == false) goto L21;
        int r112 = 1231;
    L23:
        return r111 + r112;
    L21:
        r112 = 1237;
        goto L23
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NetworkImage(uri=" + this.f323822a + ", url=" + this.f323823b + ", width=" + this.f323824c + ", height=" + this.f323825d + ", localFilePath=" + this.f323826e + ", needReview=" + this.f323827f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f323822a);
        r100.writeString(this.f323823b);
        Integer r102 = this.f323824c;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Integer r103 = this.f323825d;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.f323826e);
        r100.writeInt(this.f323827f ? 1 : 0);
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

    public NetworkImage(String r100, String r101, Integer r102, Integer r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f323822a = r100;
        this.f323823b = r101;
        this.f323824c = r102;
        this.f323825d = r103;
        this.f323826e = r104;
        this.f323827f = r105;
    }
}
