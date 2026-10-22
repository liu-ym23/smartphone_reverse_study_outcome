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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\u0010\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetRotationParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "angle", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)V", "getAngle", "()Ljava/lang/Integer;", "setAngle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSetRotationParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoSetRotationParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoSetRotationParams> CREATOR = null;
    private Integer angle;
    private PhotoEntity photo;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhotoSetRotationParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSetRotationParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            PhotoEntity r102 = (PhotoEntity) r100.readParcelable(PhotoSetRotationParams.class.getClassLoader());
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L6:
            PhotoSetRotationParams r104 = new PhotoSetRotationParams(r102, r103);
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L7:
            if (r107 > r105) goto L9;
            r107 = r107 + 1;
        L9:
            if (r107 > r101) goto L11;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L9
        L11:
            return r104;
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSetRotationParams[] newArray(int r100) {
            return new PhotoSetRotationParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetRotationParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetRotationParams copy$default(PhotoSetRotationParams r100, PhotoEntity r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.photo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.angle;
    L9:
        return r100.copy(r101, r102);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final Integer component2() {
        return this.angle;
    }

    public final PhotoSetRotationParams copy(PhotoEntity r100, Integer r101) {
        return new PhotoSetRotationParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoSetRotationParams) == true) goto L8;
        return false;
    L8:
        PhotoSetRotationParams r101 = (PhotoSetRotationParams) r100;
        if (Intrinsics.areEqual(this.photo, r101.photo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.angle, r101.angle) == true) goto L14;
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
        Integer r104 = this.angle;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetRotationParams(photo=" + this.photo + ", angle=" + this.angle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.photo, r101);
        Integer r102 = this.angle;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
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

    public final Integer getAngle() {
        return this.angle;
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhotoSetRotationParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r101 = this.photo;
        if (r101 != null) goto L8;
        r101 = ((PhotoSetRotationParams) r100).photo;
    L8:
        Integer r102 = this.angle;
        if (r102 != null) goto L12;
        r102 = ((PhotoSetRotationParams) r100).angle;
    L12:
        return new PhotoSetRotationParams(r101, r102);
    }

    public final void setAngle(Integer r100) {
        this.angle = r100;
    }

    public final void setPhoto(PhotoEntity r100) {
        this.photo = r100;
    }

    public PhotoSetRotationParams(PhotoEntity r100, Integer r101) {
        this.photo = r100;
        this.angle = r101;
    }

    public /* synthetic */ PhotoSetRotationParams(PhotoEntity r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
