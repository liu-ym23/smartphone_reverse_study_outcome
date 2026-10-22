package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/larus/bmhome/auth/MinorInfoData;", "Landroid/os/Parcelable;", "isMinorMode", "", "popupConfig", "Lcom/larus/bmhome/auth/PopupConfig;", "minorConfig", "Lcom/larus/bmhome/auth/MinorConfig;", "<init>", "(Ljava/lang/Boolean;Lcom/larus/bmhome/auth/PopupConfig;Lcom/larus/bmhome/auth/MinorConfig;)V", "()Ljava/lang/Boolean;", "setMinorMode", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPopupConfig", "()Lcom/larus/bmhome/auth/PopupConfig;", "setPopupConfig", "(Lcom/larus/bmhome/auth/PopupConfig;)V", "getMinorConfig", "()Lcom/larus/bmhome/auth/MinorConfig;", "setMinorConfig", "(Lcom/larus/bmhome/auth/MinorConfig;)V", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Lcom/larus/bmhome/auth/PopupConfig;Lcom/larus/bmhome/auth/MinorConfig;)Lcom/larus/bmhome/auth/MinorInfoData;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinorInfoData implements Parcelable {
    public static final Parcelable.Creator<MinorInfoData> CREATOR = null;

    @SerializedName("is_minor_mode")
    private Boolean isMinorMode;

    @SerializedName("minor_config")
    private MinorConfig minorConfig;

    @SerializedName("popup_config")
    private PopupConfig popupConfig;

    public static final class a implements Parcelable.Creator<MinorInfoData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MinorInfoData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            MinorConfig r101 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r102 = null;
        L11:
            if (r100.readInt() != 0) goto L13;
            PopupConfig r103 = null;
        L14:
            PopupConfig r104 = r103;
            if (r100.readInt() == 0) goto L19;
            r101 = MinorConfig.CREATOR.createFromParcel(r100);
        L19:
            return new MinorInfoData(r102, r104, r101);
        L13:
            r103 = PopupConfig.CREATOR.createFromParcel(r100);
            goto L14
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r105 = true;
        L9:
            r102 = Boolean.valueOf(r105);
            goto L11
        L8:
            r105 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MinorInfoData[] newArray(int r100) {
            return new MinorInfoData[r100];
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
        if ((r100 instanceof MinorInfoData) == true) goto L8;
        return false;
    L8:
        MinorInfoData r101 = (MinorInfoData) r100;
        if (Intrinsics.areEqual(this.isMinorMode, r101.isMinorMode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.popupConfig, r101.popupConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.minorConfig, r101.minorConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.isMinorMode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        PopupConfig r104 = this.popupConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        MinorConfig r107 = this.minorConfig;
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

    public final String toString() {
        return "MinorInfoData(isMinorMode=" + this.isMinorMode + ", popupConfig=" + this.popupConfig + ", minorConfig=" + this.minorConfig + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.isMinorMode;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        PopupConfig r103 = this.popupConfig;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        MinorConfig r104 = this.minorConfig;
        if (r104 != null) goto L13;
        r100.writeInt(0);
        return;
    L13:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public MinorInfoData() {
        Boolean r100 = Boolean.FALSE;
        this(r100, new PopupConfig(1, 0), new MinorConfig(r100, r100, r100, r100));
    }

    public final PopupConfig a() {
        return this.popupConfig;
    }

    public final Boolean b() {
        return this.isMinorMode;
    }

    public MinorInfoData(Boolean r100, PopupConfig r101, MinorConfig r102) {
        this.isMinorMode = r100;
        this.popupConfig = r101;
        this.minorConfig = r102;
    }
}
