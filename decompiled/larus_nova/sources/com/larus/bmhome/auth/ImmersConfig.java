package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006'"}, d2 = {"Lcom/larus/bmhome/auth/ImmersConfig;", "Landroid/os/Parcelable;", "direction", "", "enable", "", "enableGuide", "enablerDirectly", "<init>", "(Ljava/lang/String;ZZZ)V", "getDirection", "()Ljava/lang/String;", "setDirection", "(Ljava/lang/String;)V", "getEnable", "()Z", "setEnable", "(Z)V", "getEnableGuide", "setEnableGuide", "getEnablerDirectly", "setEnablerDirectly", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImmersConfig implements Parcelable {
    public static final Parcelable.Creator<ImmersConfig> CREATOR = null;

    @SerializedName("slide_direction")
    private String direction;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_user_guide")
    private boolean enableGuide;

    @SerializedName("enable_directly")
    private boolean enablerDirectly;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<ImmersConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImmersConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            boolean r102 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r104 = true;
        L11:
            if (r100.readInt() == 0) goto L14;
            r102 = true;
        L14:
            return new ImmersConfig(r101, r103, r104, r102);
        L9:
            r104 = false;
            goto L11
        L5:
            r103 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ImmersConfig[] newArray(int r100) {
            return new ImmersConfig[r100];
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
        if ((r100 instanceof ImmersConfig) == true) goto L8;
        return false;
    L8:
        ImmersConfig r101 = (ImmersConfig) r100;
        if (Intrinsics.areEqual(this.direction, r101.direction) == true) goto L12;
        return false;
    L12:
        if (this.enable == r101.enable) goto L15;
        return false;
    L15:
        if (this.enableGuide == r101.enableGuide) goto L18;
        return false;
    L18:
        if (this.enablerDirectly == r101.enablerDirectly) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.direction;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.enable == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.enableGuide == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.enablerDirectly == true) goto L19;
        r103 = 1237;
    L19:
        return r107 + r103;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImmersConfig(direction=" + this.direction + ", enable=" + this.enable + ", enableGuide=" + this.enableGuide + ", enablerDirectly=" + this.enablerDirectly + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.direction);
        r100.writeInt(this.enable ? 1 : 0);
        r100.writeInt(this.enableGuide ? 1 : 0);
        r100.writeInt(this.enablerDirectly ? 1 : 0);
    }

    public ImmersConfig() {
        this("", false, false, false);
    }

    public final String a() {
        return this.direction;
    }

    public final boolean b() {
        return this.enableGuide;
    }

    public final boolean c() {
        return this.enablerDirectly;
    }

    public ImmersConfig(String r100, boolean r101, boolean r102, boolean r103) {
        this.direction = r100;
        this.enable = r101;
        this.enableGuide = r102;
        this.enablerDirectly = r103;
    }
}
