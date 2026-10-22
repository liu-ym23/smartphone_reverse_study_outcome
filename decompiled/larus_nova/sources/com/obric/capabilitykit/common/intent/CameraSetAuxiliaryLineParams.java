package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CameraSetAuxiliaryLineParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "enable", "", "mode", "", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/CameraSetAuxiliaryLineParams;", "describeContents", "", "equals", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CameraSetAuxiliaryLineParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CameraSetAuxiliaryLineParams> CREATOR = null;
    private Boolean enable;
    private String mode;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CameraSetAuxiliaryLineParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetAuxiliaryLineParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r102 = 1;
            if (r100.readInt() != 0) goto L6;
            Boolean r103 = null;
        L10:
            CameraSetAuxiliaryLineParams r104 = new CameraSetAuxiliaryLineParams(r103, r100.readString());
            int r105 = Math.min(r101, 0);
            ClassLoader r106 = a.class.getClassLoader();
        L11:
            if (r102 > r105) goto L13;
            r102 = r102 + 1;
        L13:
            if (r102 > r101) goto L15;
            joa.a.d(r100, r106);
            r102 = r102 + 1;
            goto L13
        L15:
            return r104;
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r107 = true;
        L9:
            r103 = Boolean.valueOf(r107);
            goto L10
        L8:
            r107 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final CameraSetAuxiliaryLineParams[] newArray(int r100) {
            return new CameraSetAuxiliaryLineParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraSetAuxiliaryLineParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CameraSetAuxiliaryLineParams copy$default(CameraSetAuxiliaryLineParams r100, Boolean r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.mode;
    L9:
        return r100.copy(r101, r102);
    }

    public final Boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.mode;
    }

    public final CameraSetAuxiliaryLineParams copy(Boolean r100, String r101) {
        return new CameraSetAuxiliaryLineParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraSetAuxiliaryLineParams) == true) goto L8;
        return false;
    L8:
        CameraSetAuxiliaryLineParams r101 = (CameraSetAuxiliaryLineParams) r100;
        if (Intrinsics.areEqual(this.enable, r101.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Boolean r100 = this.enable;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.mode;
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
        return "CameraSetAuxiliaryLineParams(enable=" + this.enable + ", mode=" + this.mode + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        ?? r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Boolean r103 = this.enable;
        if (r103 != null) goto L5;
    L4:
        r100.writeInt(r102);
        r100.writeString(this.mode);
        return;
    L5:
        r100.writeInt(1);
        r102 = r103.booleanValue();
        goto L4
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final String getMode() {
        return this.mode;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof CameraSetAuxiliaryLineParams) == true) goto L5;
        return this;
    L5:
        Boolean r101 = this.enable;
        if (r101 != null) goto L8;
        r101 = ((CameraSetAuxiliaryLineParams) r100).enable;
    L8:
        String r102 = this.mode;
        if (r102 != null) goto L12;
        r102 = ((CameraSetAuxiliaryLineParams) r100).mode;
    L12:
        return new CameraSetAuxiliaryLineParams(r101, r102);
    }

    public final void setEnable(Boolean r100) {
        this.enable = r100;
    }

    public final void setMode(String r100) {
        this.mode = r100;
    }

    public CameraSetAuxiliaryLineParams(Boolean r100, String r101) {
        this.enable = r100;
        this.mode = r101;
    }

    public /* synthetic */ CameraSetAuxiliaryLineParams(Boolean r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
