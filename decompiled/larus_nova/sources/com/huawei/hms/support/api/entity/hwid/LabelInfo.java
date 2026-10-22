package com.huawei.hms.support.api.entity.hwid;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes23.dex */
public class LabelInfo implements Parcelable {
    public static final Parcelable.Creator<LabelInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277737b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public LabelInfo() {
        this.f277736a = -1;
        this.f277737b = "";
    }

    public String getLabelName() {
        return this.f277737b;
    }

    public int getLabelType() {
        return this.f277736a;
    }

    public LabelInfo(Parcel r100) {
        this.f277736a = r100.readInt();
        this.f277737b = r100.readString();
    }

    public boolean isEquals(LabelInfo r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (getLabelType() == r100.getLabelType()) goto L6;
        return false;
    L6:
        if (getLabelName().equals(r100.getLabelName()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public void setLabelName(String r100) {
        this.f277737b = r100;
    }

    public void setLabelType(int r100) {
        this.f277736a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f277736a);
        r100.writeString(this.f277737b);
    }
}
