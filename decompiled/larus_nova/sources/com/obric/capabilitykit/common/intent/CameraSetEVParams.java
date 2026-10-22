package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetEVParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "ev", "", "valueType", "", "(Ljava/lang/Double;Ljava/lang/String;)V", "getEv", "()Ljava/lang/Double;", "setEv", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getValueType", "()Ljava/lang/String;", "setValueType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/CameraSetEVParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CameraSetEVParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CameraSetEVParams> CREATOR = null;

    /* JADX INFO: renamed from: ev, reason: collision with root package name */
    private Double f396190ev;
    private String valueType;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CameraSetEVParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetEVParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Double r102 = null;
        L6:
            CameraSetEVParams r103 = new CameraSetEVParams(r102, r100.readString());
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
            r102 = Double.valueOf(r100.readDouble());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetEVParams[] newArray(int r100) {
            return new CameraSetEVParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetEVParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetEVParams copy$default(CameraSetEVParams r100, Double r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f396190ev;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.valueType;
    L9:
        return r100.copy(r101, r102);
    }

    public final Double component1() {
        return this.f396190ev;
    }

    public final String component2() {
        return this.valueType;
    }

    public final CameraSetEVParams copy(Double r100, String r101) {
        return new CameraSetEVParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraSetEVParams) == true) goto L8;
        return false;
    L8:
        CameraSetEVParams r101 = (CameraSetEVParams) r100;
        if (Intrinsics.areEqual(this.f396190ev, r101.f396190ev) == true) goto L12;
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
        Double r100 = this.f396190ev;
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
        return "CameraSetEVParams(ev=" + this.f396190ev + ", valueType=" + this.valueType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Double r102 = this.f396190ev;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.valueType);
        return;
    L5:
        r100.writeInt(1);
        r100.writeDouble(r102.doubleValue());
        goto L6
    }

    public final Double getEv() {
        return this.f396190ev;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof CameraSetEVParams) == true) goto L5;
        return this;
    L5:
        Double r101 = this.f396190ev;
        if (r101 != null) goto L8;
        r101 = ((CameraSetEVParams) r100).f396190ev;
    L8:
        String r102 = this.valueType;
        if (r102 != null) goto L12;
        r102 = ((CameraSetEVParams) r100).valueType;
    L12:
        return new CameraSetEVParams(r101, r102);
    }

    public final void setEv(Double r100) {
        this.f396190ev = r100;
    }

    public final void setValueType(String r100) {
        this.valueType = r100;
    }

    public CameraSetEVParams(Double r100, String r101) {
        this.f396190ev = r100;
        this.valueType = r101;
    }

    public /* synthetic */ CameraSetEVParams(Double r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
