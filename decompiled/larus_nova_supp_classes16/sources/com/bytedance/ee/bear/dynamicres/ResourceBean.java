package com.bytedance.ee.bear.dynamicres;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ResourceBean implements Parcelable {
    public static final Parcelable.Creator<ResourceBean> CREATOR = null;
    public final int a;
    public final String b;
    public final String c;
    public final String d;

    public class a implements Parcelable.Creator<ResourceBean> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceBean createFromParcel(Parcel r2) {
            return new ResourceBean(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ResourceBean[] newArray(int r1) {
            return new ResourceBean[r1];
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
        return "ResUpdateBean{version=" + this.a + ", channel='" + this.b + "', dir='" + this.c + "', zipName='" + this.d + "'}";
    }

    public ResourceBean() {
    }

    public ResourceBean(Parcel r2) {
        this.a = r2.readInt();
        this.b = r2.readString();
        this.c = r2.readString();
        this.d = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
    }
}
