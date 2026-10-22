package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetFilterParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "filter", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;)V", "getFilter", "()Ljava/lang/String;", "setFilter", "(Ljava/lang/String;)V", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoSetFilterParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoSetFilterParams> CREATOR = null;
    private String filter;
    private PhotoEntity photo;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhotoSetFilterParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSetFilterParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            PhotoSetFilterParams r102 = new PhotoSetFilterParams((PhotoEntity) r100.readParcelable(PhotoSetFilterParams.class.getClassLoader()), r100.readString());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSetFilterParams[] newArray(int r100) {
            return new PhotoSetFilterParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetFilterParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetFilterParams copy$default(PhotoSetFilterParams r100, PhotoEntity r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.photo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.filter;
    L9:
        return r100.copy(r101, r102);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final String component2() {
        return this.filter;
    }

    public final PhotoSetFilterParams copy(PhotoEntity r100, String r101) {
        return new PhotoSetFilterParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoSetFilterParams) == true) goto L8;
        return false;
    L8:
        PhotoSetFilterParams r101 = (PhotoSetFilterParams) r100;
        if (Intrinsics.areEqual(this.photo, r101.photo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filter, r101.filter) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        PhotoEntity r100 = this.photo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.filter;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetFilterParams(photo=" + this.photo + ", filter=" + this.filter + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.photo, r101);
        r100.writeString(this.filter);
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.photo);
    }

    public boolean isParamsCompleted() {
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getFilter() {
        return this.filter;
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhotoSetFilterParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r101 = this.photo;
        if (r101 != null) goto L8;
        r101 = ((PhotoSetFilterParams) r100).photo;
    L8:
        String r102 = this.filter;
        if (r102 != null) goto L12;
        r102 = ((PhotoSetFilterParams) r100).filter;
    L12:
        return new PhotoSetFilterParams(r101, r102);
    }

    public final void setFilter(String r100) {
        this.filter = r100;
    }

    public final void setPhoto(PhotoEntity r100) {
        this.photo = r100;
    }

    public PhotoSetFilterParams(PhotoEntity r100, String r101) {
        this.photo = r100;
        this.filter = r101;
    }

    public /* synthetic */ PhotoSetFilterParams(PhotoEntity r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
