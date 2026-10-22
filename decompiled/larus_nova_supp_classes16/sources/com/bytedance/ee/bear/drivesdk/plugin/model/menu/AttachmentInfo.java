package com.bytedance.ee.bear.drivesdk.plugin.model.menu;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class AttachmentInfo implements Parcelable {
    public static final Parcelable.Creator<AttachmentInfo> CREATOR = null;
    public String a;
    public String b;
    public String c;
    public String d;

    public class a implements Parcelable.Creator<AttachmentInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentInfo createFromParcel(Parcel r2) {
            return new AttachmentInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AttachmentInfo[] newArray(int r1) {
            return new AttachmentInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public AttachmentInfo() {
    }

    public String getType() {
        return this.c;
    }

    public AttachmentInfo(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readString();
        this.d = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeString(this.d);
    }
}
