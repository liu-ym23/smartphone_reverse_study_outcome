package com.larus.bmhome.auth.feature_config.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\f¨\u0006 "}, d2 = {"Lcom/larus/bmhome/auth/feature_config/model/FeatureDetailWithSwitch;", "Landroid/os/Parcelable;", "enabled", "", "defaultValue", "switchValue", "<init>", "(ZZZ)V", "getEnabled", "()Z", "getDefaultValue", "setDefaultValue", "(Z)V", "getSwitchValue", "setSwitchValue", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureDetailWithSwitch implements Parcelable {
    public static final Parcelable.Creator<FeatureDetailWithSwitch> CREATOR = null;

    @SerializedName(ComposerHelper.COMPOSER_DEFAULT_VALUE)
    private boolean defaultValue;

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("switch_value")
    private boolean switchValue;

    public static final class a implements Parcelable.Creator<FeatureDetailWithSwitch> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureDetailWithSwitch createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r103 = true;
        L11:
            if (r100.readInt() == 0) goto L14;
            r101 = true;
        L14:
            return new FeatureDetailWithSwitch(r102, r103, r101);
        L9:
            r103 = false;
            goto L11
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureDetailWithSwitch[] newArray(int r100) {
            return new FeatureDetailWithSwitch[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureDetailWithSwitch() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureDetailWithSwitch) == true) goto L8;
        return false;
    L8:
        FeatureDetailWithSwitch r101 = (FeatureDetailWithSwitch) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (this.defaultValue == r101.defaultValue) goto L15;
        return false;
    L15:
        if (this.switchValue == r101.switchValue) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.defaultValue == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.switchValue == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeatureDetailWithSwitch(enabled=" + this.enabled + ", defaultValue=" + this.defaultValue + ", switchValue=" + this.switchValue + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enabled ? 1 : 0);
        r100.writeInt(this.defaultValue ? 1 : 0);
        r100.writeInt(this.switchValue ? 1 : 0);
    }

    public final boolean a() {
        return this.defaultValue;
    }

    public final boolean b() {
        return this.enabled;
    }

    public final boolean c() {
        return this.switchValue;
    }

    public /* synthetic */ FeatureDetailWithSwitch(int r100) {
        this(true, false, true);
    }

    public FeatureDetailWithSwitch(boolean r100, boolean r101, boolean r102) {
        this.enabled = r100;
        this.defaultValue = r101;
        this.switchValue = r102;
    }
}
