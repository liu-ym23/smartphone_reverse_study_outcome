package com.larus.bmhome.auth.feature_config.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "Landroid/os/Parcelable;", "enabled", "", "defaultValue", "<init>", "(ZZ)V", "getEnabled", "()Z", "getDefaultValue", "setDefaultValue", "(Z)V", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureDetail implements Parcelable {
    public static final Parcelable.Creator<FeatureDetail> CREATOR = null;

    @SerializedName(ComposerHelper.COMPOSER_DEFAULT_VALUE)
    private boolean defaultValue;

    @SerializedName("enabled")
    private final boolean enabled;

    public static final class a implements Parcelable.Creator<FeatureDetail> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureDetail createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r100.readInt() == 0) goto L10;
            r101 = true;
        L10:
            return new FeatureDetail(r102, r101);
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureDetail[] newArray(int r100) {
            return new FeatureDetail[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeatureDetail() {
        boolean r100 = false;
        this(r100, 3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureDetail) == true) goto L8;
        return false;
    L8:
        FeatureDetail r101 = (FeatureDetail) r100;
        if (this.enabled == r101.enabled) goto L12;
        return false;
    L12:
        if (this.defaultValue == r101.defaultValue) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.defaultValue == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeatureDetail(enabled=" + this.enabled + ", defaultValue=" + this.defaultValue + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.enabled ? 1 : 0);
        r100.writeInt(this.defaultValue ? 1 : 0);
    }

    public final boolean a() {
        return this.defaultValue;
    }

    public final boolean b() {
        return this.enabled;
    }

    public /* synthetic */ FeatureDetail(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        boolean r102 = true;
    L7:
        if ((r101 & 2) == 0) goto L9;
        r100 = false;
    L9:
        this(r102, r100);
        return;
    L5:
        r102 = false;
        goto L7
    }

    public FeatureDetail(boolean r100, boolean r101) {
        this.enabled = r100;
        this.defaultValue = r101;
    }
}
