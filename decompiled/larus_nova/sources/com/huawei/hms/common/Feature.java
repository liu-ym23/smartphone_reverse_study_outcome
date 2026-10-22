package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public class Feature extends AbstractSafeParcelable {
    public static final int ARGS_NAME = 1;
    public static final int ARGS_SVC_VER = 2;
    public static final int ARGS_VER = 3;
    public static final Parcelable.Creator<Feature> CREATOR = null;
    private static final int SVC_VER = -1;
    private final long apiVersion;
    private final String name;
    private final int serviceVersion;

    public int hashCode() {
        return Objects.hashCode(new Object[]{getName(), Long.valueOf(getVersion())});
    }

    static {
        CREATOR = new FeatureCreator();
    }

    public long getVersion() {
        long r100 = this.apiVersion;
        if ((-1) == r100) goto L5;
        return r100;
    L5:
        return this.serviceVersion;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Feature) == true) goto L5;
        return false;
    L5:
        Feature r101 = (Feature) r100;
        if (this.name.equals(r101.getName()) == true) goto L9;
        return false;
    L9:
        if (getVersion() == r101.getVersion()) goto L11;
        return false;
    L11:
        return true;
    }

    public Feature(String r100, long r101) {
        this(r100, -1, r101);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r102 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeString(r100, 1, getName(), false);
        SafeParcelWriter.writeInt(r100, 2, this.serviceVersion);
        SafeParcelWriter.writeLong(r100, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(r100, r102);
    }

    public Feature(String r100, int r101, long r102) {
        this.name = r100;
        this.serviceVersion = r101;
        this.apiVersion = r102;
    }
}
