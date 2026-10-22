package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ,\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoShowPhotoParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "targets", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "index", "", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)V", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTargets", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setTargets", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoShowPhotoParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoShowPhotoParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoShowPhotoParams> CREATOR = null;
    private Integer index;
    private PhotoEntity[] targets;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhotoShowPhotoParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoShowPhotoParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Integer r102 = null;
            if (r100.readInt() != 0) goto L5;
            PhotoEntity[] r103 = null;
        L9:
            if (r100.readInt() == 0) goto L12;
            r102 = Integer.valueOf(r100.readInt());
        L12:
            PhotoShowPhotoParams r104 = new PhotoShowPhotoParams(r103, r102);
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
            int r107 = 1;
        L13:
            if (r107 > r105) goto L15;
            r107 = r107 + 1;
        L15:
            if (r107 > r101) goto L17;
            joa.a.d(r100, r106);
            r107 = r107 + 1;
            goto L15
        L17:
            return r104;
        L5:
            int r108 = r100.readInt();
            r103 = new PhotoEntity[r108];
            int r109 = 0;
        L6:
            if (r109 == r108) goto L9;
            r103[r109] = (PhotoEntity) r100.readParcelable(PhotoShowPhotoParams.class.getClassLoader());
            r109 = r109 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoShowPhotoParams[] newArray(int r100) {
            return new PhotoShowPhotoParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoShowPhotoParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoShowPhotoParams copy$default(PhotoShowPhotoParams r100, PhotoEntity[] r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.targets;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.index;
    L9:
        return r100.copy(r101, r102);
    }

    public final PhotoEntity[] component1() {
        return this.targets;
    }

    public final Integer component2() {
        return this.index;
    }

    public final PhotoShowPhotoParams copy(PhotoEntity[] r100, Integer r101) {
        return new PhotoShowPhotoParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoShowPhotoParams) == true) goto L8;
        return false;
    L8:
        PhotoShowPhotoParams r101 = (PhotoShowPhotoParams) r100;
        if (Intrinsics.areEqual(this.targets, r101.targets) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        PhotoEntity[] r100 = this.targets;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.index;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = Arrays.hashCode(r100);
        goto L6
    }

    public String toString() {
        return "PhotoShowPhotoParams(targets=" + Arrays.toString(this.targets) + ", index=" + this.index + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        PhotoEntity[] r102 = this.targets;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L8:
        Integer r103 = this.index;
        if (r103 != null) goto L11;
        r100.writeInt(0);
        return;
    L11:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L5:
        r100.writeInt(1);
        int r104 = r102.length;
        r100.writeInt(r104);
        int r105 = 0;
    L6:
        if (r105 == r104) goto L8;
        r100.writeParcelable(r102[r105], r101);
        r105 = r105 + 1;
        goto L6
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.targets);
    }

    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final PhotoEntity[] getTargets() {
        return this.targets;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhotoShowPhotoParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity[] r101 = this.targets;
        if (r101 != null) goto L8;
        r101 = ((PhotoShowPhotoParams) r100).targets;
    L8:
        Integer r102 = this.index;
        if (r102 != null) goto L12;
        r102 = ((PhotoShowPhotoParams) r100).index;
    L12:
        return new PhotoShowPhotoParams(r101, r102);
    }

    public final void setIndex(Integer r100) {
        this.index = r100;
    }

    public final void setTargets(PhotoEntity[] r100) {
        this.targets = r100;
    }

    public PhotoShowPhotoParams(PhotoEntity[] r100, Integer r101) {
        this.targets = r100;
        this.index = r101;
    }

    public /* synthetic */ PhotoShowPhotoParams(PhotoEntity[] r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
