package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes16.dex */
public class PreloadEntity implements Parcelable {
    public static final Parcelable.Creator<PreloadEntity> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f217035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f217036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217037c;

    public class a implements Parcelable.Creator<PreloadEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PreloadEntity createFromParcel(Parcel r100) {
            return new PreloadEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final PreloadEntity[] newArray(int r100) {
            return new PreloadEntity[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PreloadEntity(Parcel r100) {
        this.f217035a = r100.readString();
        this.f217036b = r100.readString();
        this.f217037c = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f217035a);
        r100.writeString(this.f217036b);
        r100.writeString(this.f217037c);
    }
}
