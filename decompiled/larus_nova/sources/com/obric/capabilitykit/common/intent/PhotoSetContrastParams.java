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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\u0010\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0#H\u0016J\t\u0010$\u001a\u00020\tHÖ\u0001J\b\u0010%\u001a\u00020\u001fH\u0016J\u0012\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010!H\u0016J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\tHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoSetContrastParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "valueType", "", "value", "", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;Ljava/lang/Integer;)V", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhoto", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "(Lcom/obric/capabilitykit/entity/app/PhotoEntity;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/PhotoSetContrastParams;", "describeContents", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoSetContrastParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoSetContrastParams> CREATOR = null;
    private PhotoEntity photo;
    private Integer value;
    private String valueType;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<PhotoSetContrastParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSetContrastParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            PhotoEntity r102 = (PhotoEntity) r100.readParcelable(PhotoSetContrastParams.class.getClassLoader());
            String r103 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            Integer r104 = null;
        L6:
            PhotoSetContrastParams r105 = new PhotoSetContrastParams(r102, r103, r104);
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L7:
            if (r108 > r106) goto L9;
            r108 = r108 + 1;
        L9:
            if (r108 > r101) goto L11;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L9
        L11:
            return r105;
        L5:
            r104 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final PhotoSetContrastParams[] newArray(int r100) {
            return new PhotoSetContrastParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public PhotoSetContrastParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PhotoSetContrastParams copy$default(PhotoSetContrastParams r100, PhotoEntity r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.photo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.valueType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.value;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final String component2() {
        return this.valueType;
    }

    public final Integer component3() {
        return this.value;
    }

    public final PhotoSetContrastParams copy(PhotoEntity r100, String r101, Integer r102) {
        return new PhotoSetContrastParams(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PhotoSetContrastParams) == true) goto L8;
        return false;
    L8:
        PhotoSetContrastParams r101 = (PhotoSetContrastParams) r100;
        if (Intrinsics.areEqual(this.photo, r101.photo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.valueType, r101.valueType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L17;
        return false;
    L17:
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
        String r104 = this.valueType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.value;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetContrastParams(photo=" + this.photo + ", valueType=" + this.valueType + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeParcelable(this.photo, r101);
        r100.writeString(this.valueType);
        Integer r102 = this.value;
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

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof PhotoSetContrastParams) == true) goto L5;
        return this;
    L5:
        PhotoEntity r101 = this.photo;
        if (r101 != null) goto L8;
        r101 = ((PhotoSetContrastParams) r100).photo;
    L8:
        String r102 = this.valueType;
        if (r102 != null) goto L11;
        r102 = ((PhotoSetContrastParams) r100).valueType;
    L11:
        Integer r103 = this.value;
        if (r103 != null) goto L15;
        r103 = ((PhotoSetContrastParams) r100).value;
    L15:
        return new PhotoSetContrastParams(r101, r102, r103);
    }

    public final void setPhoto(PhotoEntity r100) {
        this.photo = r100;
    }

    public final void setValue(Integer r100) {
        this.value = r100;
    }

    public final void setValueType(String r100) {
        this.valueType = r100;
    }

    public PhotoSetContrastParams(PhotoEntity r100, String r101, Integer r102) {
        this.photo = r100;
        this.valueType = r101;
        this.value = r102;
    }

    public /* synthetic */ PhotoSetContrastParams(PhotoEntity r100, String r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
