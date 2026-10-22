package com.ss.android.vesdk;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEBitmapWithInfo implements Parcelable {
    public static final Parcelable.Creator<VEBitmapWithInfo> CREATOR = null;
    public Bitmap bitmap;
    public int colorPrimary;
    public int colorSpace;
    public int colorTransfer;

    public static final enum COLOR_TYPE extends Enum<COLOR_TYPE> {
        public static final COLOR_TYPE BT2020_HLG = null;
        public static final COLOR_TYPE BT2020_PQ = null;
        public static final COLOR_TYPE BT601 = null;
        public static final COLOR_TYPE BT709 = null;
        public static final COLOR_TYPE UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ COLOR_TYPE[] f455514a = null;

        static {
            COLOR_TYPE r100 = new COLOR_TYPE("UNKNOWN", 0);
            UNKNOWN = r100;
            COLOR_TYPE r101 = new COLOR_TYPE("BT601", 1);
            BT601 = r101;
            COLOR_TYPE r102 = new COLOR_TYPE("BT709", 2);
            BT709 = r102;
            COLOR_TYPE r103 = new COLOR_TYPE("BT2020_PQ", 3);
            BT2020_PQ = r103;
            COLOR_TYPE r104 = new COLOR_TYPE("BT2020_HLG", 4);
            BT2020_HLG = r104;
            f455514a = new COLOR_TYPE[]{r100, r101, r102, r103, r104};
        }

        public static COLOR_TYPE[] values() {
            return (COLOR_TYPE[]) f455514a.clone();
        }

        public static COLOR_TYPE valueOf(String r100) {
            return (COLOR_TYPE) r27.a.a(COLOR_TYPE.class, r100);
        }

        public COLOR_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VEBitmapWithInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEBitmapWithInfo createFromParcel(Parcel r100) {
            return new VEBitmapWithInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEBitmapWithInfo[] newArray(int r100) {
            return new VEBitmapWithInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public VEBitmapWithInfo(Parcel r100) {
        this.colorSpace = r100.readInt();
        this.colorPrimary = r100.readInt();
        this.colorTransfer = r100.readInt();
        this.bitmap = (Bitmap) r100.readParcelable(Bitmap.class.getClassLoader());
    }

    public VEBitmapWithInfo(Bitmap r100) {
        this.bitmap = r100;
        COLOR_TYPE r101 = COLOR_TYPE.UNKNOWN;
        this.colorSpace = r101.ordinal();
        this.colorPrimary = r101.ordinal();
        this.colorTransfer = r101.ordinal();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.colorSpace);
        r100.writeInt(this.colorPrimary);
        r100.writeInt(this.colorTransfer);
        r100.writeParcelable(this.bitmap, r101);
    }

    public void setColorInfo(int r100, int r101, int r102) {
        this.colorSpace = r100;
        this.colorPrimary = r101;
        this.colorTransfer = r102;
    }

    public VEBitmapWithInfo(Bitmap r100, int r101, int r102, int r103) {
        this.bitmap = r100;
        this.colorSpace = r101;
        this.colorPrimary = r102;
        this.colorTransfer = r103;
    }
}
