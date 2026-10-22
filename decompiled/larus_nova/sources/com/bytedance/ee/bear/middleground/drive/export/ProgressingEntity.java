package com.bytedance.ee.bear.middleground.drive.export;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes18.dex */
public class ProgressingEntity implements Parcelable {
    public static final Parcelable.Creator<ProgressingEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f232468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f232469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f232470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f232471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f232472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f232473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f232474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f232475h;

    public class a implements Parcelable.Creator<ProgressingEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProgressingEntity createFromParcel(Parcel r100) {
            return new ProgressingEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProgressingEntity[] newArray(int r100) {
            return new ProgressingEntity[r100];
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
        return "ProgressingEntity{name='" + this.f232468a + "', fileId='" + this.f232469b + "', bytesTransferred='" + this.f232470c + "', bytesTotal='" + this.f232471d + "', progress=" + this.f232472e + ", status=" + this.f232473f + ", filePath='" + this.f232474g + "', mountNodePoint='" + this.f232475h + "'}";
    }

    public ProgressingEntity() {
    }

    public ProgressingEntity(Parcel r100) {
        this.f232468a = r100.readString();
        this.f232469b = r100.readString();
        this.f232470c = r100.readLong();
        this.f232471d = r100.readLong();
        this.f232472e = r100.readInt();
        this.f232473f = r100.readInt();
        this.f232474g = r100.readString();
        this.f232475h = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f232468a);
        r100.writeString(this.f232469b);
        r100.writeLong(this.f232470c);
        r100.writeLong(this.f232471d);
        r100.writeInt(this.f232472e);
        r100.writeInt(this.f232473f);
        r100.writeString(this.f232474g);
        r100.writeString(this.f232475h);
    }
}
