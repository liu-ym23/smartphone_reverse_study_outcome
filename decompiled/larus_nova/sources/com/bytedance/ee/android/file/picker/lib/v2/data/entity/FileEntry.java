package com.bytedance.ee.android.file.picker.lib.v2.data.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0006\u0010%\u001a\u00020&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00062"}, d2 = {"Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/FileEntry;", "Landroid/os/Parcelable;", "name", "", "uri", "Landroid/net/Uri;", "path", "size", "", "iconLoaderType", "extraInfo", "category", "key", "Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "<init>", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;)V", "getName", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "getPath", "getSize", "()J", "getIconLoaderType", "getExtraInfo", "getCategory", "getKey", "()Lcom/bytedance/ee/android/file/picker/lib/v2/data/entity/Key;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "file-picker-lib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileEntry implements Parcelable {
    public static final Parcelable.Creator<FileEntry> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f206013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f206014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f206015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f206016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f206017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f206018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f206019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Key f206020h;

    public static final class a implements Parcelable.Creator<FileEntry> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FileEntry createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new FileEntry(r110.readString(), (Uri) r110.readParcelable(FileEntry.class.getClassLoader()), r110.readString(), r110.readLong(), r110.readString(), r110.readString(), r110.readString(), (Key) r110.readParcelable(FileEntry.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final FileEntry[] newArray(int r100) {
            return new FileEntry[r100];
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
        if ((r100 instanceof FileEntry) == true) goto L8;
        return false;
    L8:
        FileEntry r101 = (FileEntry) r100;
        if (Intrinsics.areEqual(this.f206013a, r101.f206013a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f206014b, r101.f206014b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f206015c, r101.f206015c) == true) goto L18;
        return false;
    L18:
        if (this.f206016d == r101.f206016d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f206017e, r101.f206017e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f206018f, r101.f206018f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f206019g, r101.f206019g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f206020h, r101.f206020h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f206013a.hashCode() * 31) + this.f206014b.hashCode()) * 31) + this.f206015c.hashCode()) * 31;
        long r101 = this.f206016d;
        return ((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f206017e.hashCode()) * 31) + this.f206018f.hashCode()) * 31) + this.f206019g.hashCode()) * 31) + this.f206020h.hashCode();
    }

    public final String toString() {
        return "FileEntry(name=" + this.f206013a + ", uri=" + this.f206014b + ", path=" + this.f206015c + ", size=" + this.f206016d + ", iconLoaderType=" + this.f206017e + ", extraInfo=" + this.f206018f + ", category=" + this.f206019g + ", key=" + this.f206020h + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f206013a);
        r100.writeParcelable(this.f206014b, r101);
        r100.writeString(this.f206015c);
        r100.writeLong(this.f206016d);
        r100.writeString(this.f206017e);
        r100.writeString(this.f206018f);
        r100.writeString(this.f206019g);
        r100.writeParcelable(this.f206020h, r101);
    }

    public FileEntry(String r100, Uri r101, String r102, long r103, String r104, String r105, String r106, Key r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "path");
        Intrinsics.checkNotNullParameter(r104, "iconLoaderType");
        Intrinsics.checkNotNullParameter(r105, "extraInfo");
        Intrinsics.checkNotNullParameter(r106, "category");
        Intrinsics.checkNotNullParameter(r110, "key");
        this.f206013a = r100;
        this.f206014b = r101;
        this.f206015c = r102;
        this.f206016d = r103;
        this.f206017e = r104;
        this.f206018f = r105;
        this.f206019g = r106;
        this.f206020h = r110;
    }

    public /* synthetic */ FileEntry(String r110, Uri r111, String r112, long r113, String r114, String r115, String r210, int r211) {
        if ((r211 & 16) == 0) goto L5;
        String r100 = "extension";
    L7:
        if ((r211 & 32) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 128) == 0) goto L13;
        UriKey r102 = new UriKey(r111);
    L14:
        this(r110, r111, r112, r113, r100, r101, r210, r102);
        return;
    L13:
        r102 = null;
        goto L14
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
