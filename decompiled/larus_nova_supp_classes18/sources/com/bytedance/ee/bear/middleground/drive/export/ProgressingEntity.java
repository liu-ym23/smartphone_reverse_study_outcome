package com.bytedance.ee.bear.middleground.drive.export;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ProgressingEntity implements Parcelable {
    public static final Parcelable.Creator<ProgressingEntity> CREATOR = null;
    public String a;
    public String b;
    public long c;
    public long d;
    public int e;
    public int f;
    public String g;
    public String h;

    public class a implements Parcelable.Creator<ProgressingEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProgressingEntity createFromParcel(Parcel r2) {
            return new ProgressingEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ProgressingEntity[] newArray(int r1) {
            return new ProgressingEntity[r1];
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
        return "ProgressingEntity{name='" + this.a + "', fileId='" + this.b + "', bytesTransferred='" + this.c + "', bytesTotal='" + this.d + "', progress=" + this.e + ", status=" + this.f + ", filePath='" + this.g + "', mountNodePoint='" + this.h + "'}";
    }

    public ProgressingEntity() {
    }

    public ProgressingEntity(Parcel r3) {
        this.a = r3.readString();
        this.b = r3.readString();
        this.c = r3.readLong();
        this.d = r3.readLong();
        this.e = r3.readInt();
        this.f = r3.readInt();
        this.g = r3.readString();
        this.h = r3.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.a);
        r3.writeString(this.b);
        r3.writeLong(this.c);
        r3.writeLong(this.d);
        r3.writeInt(this.e);
        r3.writeInt(this.f);
        r3.writeString(this.g);
        r3.writeString(this.h);
    }
}
