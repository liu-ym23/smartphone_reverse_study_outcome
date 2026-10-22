package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0018HÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "album", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getAlbum", "()Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "setAlbum", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;)V", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhotos", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoRemovePhotosFromAlbumParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> CREATOR = null;
    private AlbumEntity album;
    private PhotoEntity[] photos;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoRemovePhotosFromAlbumParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AlbumEntity r102 = (AlbumEntity) r100.readParcelable(PhotoRemovePhotosFromAlbumParams.class.getClassLoader());
            if (r100.readInt() != 0) goto L5;
            PhotoEntity[] r103 = null;
        L9:
            PhotoRemovePhotosFromAlbumParams r104 = new PhotoRemovePhotosFromAlbumParams(r102, r103);
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L10:
            if (r107 > r105) goto L12;
            r107 = r107 + 1;
        L12:
            if (r107 > r101) goto L14;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L12
        L14:
            return r104;
        L5:
            int r108 = r100.readInt();
            PhotoEntity[] r109 = new PhotoEntity[r108];
            int r110 = 0;
        L6:
            if (r110 == r108) goto L8;
            r109[r110] = (PhotoEntity) r100.readParcelable(PhotoRemovePhotosFromAlbumParams.class.getClassLoader());
            r110 = r110 + 1;
            goto L6
        L8:
            r103 = r109;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoRemovePhotosFromAlbumParams[] newArray(int r100) {
            return new PhotoRemovePhotosFromAlbumParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoRemovePhotosFromAlbumParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoRemovePhotosFromAlbumParams copy$default(PhotoRemovePhotosFromAlbumParams r100, AlbumEntity r101, PhotoEntity[] r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.album;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.photos;
    L9:
        return r100.copy(r101, r102);
    }

    public final AlbumEntity component1() {
        return this.album;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final PhotoRemovePhotosFromAlbumParams copy(AlbumEntity r100, PhotoEntity[] r101) {
        return new PhotoRemovePhotosFromAlbumParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L8;
        return false;
    L8:
        PhotoRemovePhotosFromAlbumParams r101 = (PhotoRemovePhotosFromAlbumParams) r100;
        if (Intrinsics.areEqual(this.album, r101.album) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(new Object[]{this.album, this.photos});
    }

    public int hashCode() {
        AlbumEntity r100 = this.album;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PhotoEntity[] r104 = this.photos;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoRemovePhotosFromAlbumParams(album=" + this.album + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.album, r101);
        PhotoEntity[] r103 = this.photos;
        if (r103 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        int r104 = r103.length;
        r100.writeInt(r104);
    L6:
        if (r102 == r104) goto L10;
        r100.writeParcelable(r103[r102], r101);
        r102 = r102 + 1;
        goto L6
    }

    public boolean isParamsCompleted() {
        if (this.album == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final AlbumEntity getAlbum() {
        return this.album;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L5;
        return this;
    L5:
        AlbumEntity r101 = this.album;
        if (r101 != null) goto L8;
        r101 = ((PhotoRemovePhotosFromAlbumParams) r100).album;
    L8:
        PhotoEntity[] r102 = this.photos;
        if (r102 != null) goto L12;
        r102 = ((PhotoRemovePhotosFromAlbumParams) r100).photos;
    L12:
        return new PhotoRemovePhotosFromAlbumParams(r101, r102);
    }

    public final void setAlbum(AlbumEntity r100) {
        this.album = r100;
    }

    public final void setPhotos(PhotoEntity[] r100) {
        this.photos = r100;
    }

    public PhotoRemovePhotosFromAlbumParams(AlbumEntity r100, PhotoEntity[] r101) {
        this.album = r100;
        this.photos = r101;
    }

    public /* synthetic */ PhotoRemovePhotosFromAlbumParams(AlbumEntity r100, PhotoEntity[] r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
