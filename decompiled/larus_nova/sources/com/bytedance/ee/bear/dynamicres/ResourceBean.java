package com.bytedance.ee.bear.dynamicres;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class ResourceBean implements Parcelable {
    public static final Parcelable.Creator<ResourceBean> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f226009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f226010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f226011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f226012d;

    public class a implements Parcelable.Creator<ResourceBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceBean createFromParcel(Parcel r100) {
            return new ResourceBean(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceBean[] newArray(int r100) {
            return new ResourceBean[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "ResUpdateBean{version=" + this.f226009a + ", channel='" + this.f226010b + "', dir='" + this.f226011c + "', zipName='" + this.f226012d + "'}";
    }

    public ResourceBean() {
    }

    public ResourceBean(Parcel r100) {
        this.f226009a = r100.readInt();
        this.f226010b = r100.readString();
        this.f226011c = r100.readString();
        this.f226012d = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.f226009a);
        r100.writeString(this.f226010b);
        r100.writeString(this.f226011c);
        r100.writeString(this.f226012d);
    }
}
