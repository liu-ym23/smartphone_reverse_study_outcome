package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PreloadEntity implements Parcelable {
    public static final Parcelable.Creator<PreloadEntity> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;

    public class a implements Parcelable.Creator<PreloadEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PreloadEntity createFromParcel(Parcel r2) {
            return new PreloadEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final PreloadEntity[] newArray(int r1) {
            return new PreloadEntity[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public PreloadEntity(Parcel r2) {
        this.a = r2.readString();
        this.b = r2.readString();
        this.c = r2.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
    }
}
