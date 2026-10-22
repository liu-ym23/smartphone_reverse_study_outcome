package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetWBParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "wb", "", "valueType", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "getWb", "()Ljava/lang/Integer;", "setWb", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/CameraSetWBParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CameraSetWBParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CameraSetWBParams> CREATOR = null;
    private String valueType;

    /* JADX INFO: renamed from: wb, reason: collision with root package name */
    private Integer f396191wb;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CameraSetWBParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetWBParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Integer r102 = null;
        L6:
            CameraSetWBParams r103 = new CameraSetWBParams(r102, r100.readString());
            int r104 = Math.min(r101, 0);
            ClassLoader r105 = a.class.getClassLoader();
            int r106 = 1;
        L7:
            if (r106 > r104) goto L9;
            r106 = r106 + 1;
        L9:
            if (r106 > r101) goto L11;
            joa.a.d(r100, r105);
            r106 = r106 + 1;
            goto L9
        L11:
            return r103;
        L5:
            r102 = Integer.valueOf(r100.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetWBParams[] newArray(int r100) {
            return new CameraSetWBParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetWBParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetWBParams copy$default(CameraSetWBParams r100, Integer r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f396191wb;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.valueType;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.f396191wb;
    }

    public final String component2() {
        return this.valueType;
    }

    public final CameraSetWBParams copy(Integer r100, String r101) {
        return new CameraSetWBParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraSetWBParams) == true) goto L8;
        return false;
    L8:
        CameraSetWBParams r101 = (CameraSetWBParams) r100;
        if (Intrinsics.areEqual(this.f396191wb, r101.f396191wb) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.valueType, r101.valueType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Integer r100 = this.f396191wb;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.valueType;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "CameraSetWBParams(wb=" + this.f396191wb + ", valueType=" + this.valueType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Integer r103 = this.f396191wb;
        if (r103 == null) goto L6;
        r100.writeInt(1);
        r102 = r103.intValue();
    L6:
        r100.writeInt(r102);
        r100.writeString(this.valueType);
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final Integer getWb() {
        return this.f396191wb;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof CameraSetWBParams) == true) goto L5;
        return this;
    L5:
        Integer r101 = this.f396191wb;
        if (r101 != null) goto L8;
        r101 = ((CameraSetWBParams) r100).f396191wb;
    L8:
        String r102 = this.valueType;
        if (r102 != null) goto L12;
        r102 = ((CameraSetWBParams) r100).valueType;
    L12:
        return new CameraSetWBParams(r101, r102);
    }

    public final void setValueType(String r100) {
        this.valueType = r100;
    }

    public final void setWb(Integer r100) {
        this.f396191wb = r100;
    }

    public CameraSetWBParams(Integer r100, String r101) {
        this.f396191wb = r100;
        this.valueType = r101;
    }

    public /* synthetic */ CameraSetWBParams(Integer r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
