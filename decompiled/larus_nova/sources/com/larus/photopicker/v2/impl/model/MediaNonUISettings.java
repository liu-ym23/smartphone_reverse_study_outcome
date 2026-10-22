package com.larus.photopicker.v2.impl.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.model.album.CreationReferenceAlbumConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0005J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u000bHÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaNonUISettings;", "Landroid/os/Parcelable;", "enableSeparateMediaSelection", "", "maxSelectVideoCount", "", "creationReferenceConfig", "Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "maxVideoDuration", "", "clickFrom", "", "<init>", "(ZILcom/larus/platform/model/album/CreationReferenceAlbumConfig;JLjava/lang/String;)V", "getEnableSeparateMediaSelection", "()Z", "getMaxSelectVideoCount", "()I", "getCreationReferenceConfig", "()Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "getMaxVideoDuration", "()J", "getClickFrom", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaNonUISettings implements Parcelable {
    public static final Parcelable.Creator<MediaNonUISettings> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MediaNonUISettings f364536f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f364537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f364538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CreationReferenceAlbumConfig f364539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f364540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f364541e;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<MediaNonUISettings> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaNonUISettings createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new MediaNonUISettings(r101, r100.readInt(), (CreationReferenceAlbumConfig) r100.readSerializable(), r100.readLong(), r100.readString());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MediaNonUISettings[] newArray(int r100) {
            return new MediaNonUISettings[r100];
        }
    }

    public MediaNonUISettings() {
        long r100 = 0;
        this(r100, null, 31);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaNonUISettings) == true) goto L8;
        return false;
    L8:
        MediaNonUISettings r101 = (MediaNonUISettings) r100;
        if (this.f364537a == r101.f364537a) goto L12;
        return false;
    L12:
        if (this.f364538b == r101.f364538b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f364539c, r101.f364539c) == true) goto L18;
        return false;
    L18:
        if (this.f364540d == r101.f364540d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f364541e, r101.f364541e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.f364537a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f364538b) * 31;
        CreationReferenceAlbumConfig r102 = this.f364539c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        long r105 = this.f364540d;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.f364541e;
        if (r107 == null) goto L15;
        r103 = r107.hashCode();
    L15:
        return r106 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaNonUISettings(enableSeparateMediaSelection=" + this.f364537a + ", maxSelectVideoCount=" + this.f364538b + ", creationReferenceConfig=" + this.f364539c + ", maxVideoDuration=" + this.f364540d + ", clickFrom=" + this.f364541e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f364537a ? 1 : 0);
        r100.writeInt(this.f364538b);
        r100.writeSerializable(this.f364539c);
        r100.writeLong(this.f364540d);
        r100.writeString(this.f364541e);
    }

    static {
        CREATOR = new b();
        long r100 = 0;
        f364536f = new MediaNonUISettings(r100, null, 31);
    }

    public /* synthetic */ MediaNonUISettings(long r100, String r110, int r111) {
        if ((r111 & 2) == 0) goto L5;
        int r101 = -1;
    L7:
        if ((r111 & 8) == 0) goto L9;
        r100 = 0;
    L9:
        long r102 = r100;
        if ((r111 & 16) == 0) goto L12;
        r110 = null;
    L12:
        this(false, r101, null, r102, r110);
        return;
    L5:
        r101 = 0;
        goto L7
    }

    public MediaNonUISettings(boolean r100, int r101, CreationReferenceAlbumConfig r102, long r103, String r104) {
        this.f364537a = r100;
        this.f364538b = r101;
        this.f364539c = r102;
        this.f364540d = r103;
        this.f364541e = r104;
    }
}
