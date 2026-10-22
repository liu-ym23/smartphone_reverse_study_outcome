package com.larus.platform.model.album;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003JS\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0006\u0010&\u001a\u00020\u0005J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001d¨\u00061"}, d2 = {"Lcom/larus/platform/model/album/AlbumSelectItem;", "Landroid/os/Parcelable;", "uri", "Landroid/net/Uri;", "width", "", "height", "duration", "", "size", SubInfo.KEY_FORMAT, "", "isOriginalImageChecked", "", "<init>", "(Landroid/net/Uri;IIJJLjava/lang/String;Z)V", "getUri", "()Landroid/net/Uri;", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getDuration", "()J", "getSize", "getFormat", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumSelectItem implements Parcelable {
    public static final Parcelable.Creator<AlbumSelectItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f365506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f365507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f365508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f365509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f365510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f365512g;

    public static final class a implements Parcelable.Creator<AlbumSelectItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumSelectItem createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Uri r100 = (Uri) r110.readParcelable(AlbumSelectItem.class.getClassLoader());
            int r101 = r110.readInt();
            int r102 = r110.readInt();
            long r103 = r110.readLong();
            long r104 = r110.readLong();
            String r105 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r111 = true;
        L7:
            return new AlbumSelectItem(r100, r101, r102, r103, r104, r105, r111);
        L5:
            r111 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AlbumSelectItem[] newArray(int r100) {
            return new AlbumSelectItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AlbumSelectItem() {
        this(null, 0, 0, 0, 0, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AlbumSelectItem) == true) goto L8;
        return false;
    L8:
        AlbumSelectItem r101 = (AlbumSelectItem) r100;
        if (Intrinsics.areEqual(this.f365506a, r101.f365506a) == true) goto L12;
        return false;
    L12:
        if (this.f365507b == r101.f365507b) goto L15;
        return false;
    L15:
        if (this.f365508c == r101.f365508c) goto L18;
        return false;
    L18:
        if (this.f365509d == r101.f365509d) goto L21;
        return false;
    L21:
        if (this.f365510e == r101.f365510e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365511f, r101.f365511f) == true) goto L27;
        return false;
    L27:
        if (this.f365512g == r101.f365512g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        Uri r100 = this.f365506a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f365507b) * 31) + this.f365508c) * 31;
        long r104 = this.f365509d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f365510e;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        String r108 = this.f365511f;
        if (r108 == null) goto L10;
        r101 = r108.hashCode();
    L10:
        int r109 = (r107 + r101) * 31;
        if (this.f365512g == false) goto L13;
        int r110 = 1231;
    L15:
        return r109 + r110;
    L13:
        r110 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AlbumSelectItem(uri=" + this.f365506a + ", width=" + this.f365507b + ", height=" + this.f365508c + ", duration=" + this.f365509d + ", size=" + this.f365510e + ", format=" + this.f365511f + ", isOriginalImageChecked=" + this.f365512g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeParcelable(this.f365506a, r101);
        r100.writeInt(this.f365507b);
        r100.writeInt(this.f365508c);
        r100.writeLong(this.f365509d);
        r100.writeLong(this.f365510e);
        r100.writeString(this.f365511f);
        r100.writeInt(this.f365512g ? 1 : 0);
    }

    public static AlbumSelectItem a(AlbumSelectItem r110, boolean r111) {
        Uri r100 = r110.f365506a;
        int r101 = r110.f365507b;
        int r102 = r110.f365508c;
        long r103 = r110.f365509d;
        long r104 = r110.f365510e;
        String r105 = r110.f365511f;
        r110.getClass();
        return new AlbumSelectItem(r100, r101, r102, r103, r104, r105, r111);
    }

    public /* synthetic */ AlbumSelectItem(Uri r110, int r111, int r112, long r113, long r114, String r210, int r211) {
        String r100 = null;
        if ((r211 & 1) == 0) goto L5;
        Uri r101 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r211 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r115 = 0;
    L23:
        if ((r211 & 32) != 0) goto L26;
        r100 = r210;
    L26:
        this(r101, r102, r103, r104, r115, r100, false);
        return;
    L21:
        r115 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public AlbumSelectItem(Uri r100, int r101, int r102, long r103, long r104, String r105, boolean r106) {
        this.f365506a = r100;
        this.f365507b = r101;
        this.f365508c = r102;
        this.f365509d = r103;
        this.f365510e = r104;
        this.f365511f = r105;
        this.f365512g = r106;
    }
}
