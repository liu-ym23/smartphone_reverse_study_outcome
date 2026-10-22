package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VEInfoStickerFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEInfoStickerFilterParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f455780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f455781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f455782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f455783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f455784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f455785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f455786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f455787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f455788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f455789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f455790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f455791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f455792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VEStickerAnimationParam f455793n;

    public static class VEStickerAnimationParam implements Parcelable {
        public static final Parcelable.Creator<VEStickerAnimationParam> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f455794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f455795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f455796c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f455797d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f455798e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f455799f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f455800g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f455801h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f455802i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f455803j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f455804k;

        public class a implements Parcelable.Creator<VEStickerAnimationParam> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VEStickerAnimationParam createFromParcel(Parcel r100) {
                return new VEStickerAnimationParam(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final VEStickerAnimationParam[] newArray(int r100) {
                return new VEStickerAnimationParam[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public VEStickerAnimationParam() {
            this.f455794a = false;
            this.f455795b = "";
            this.f455799f = "";
            this.f455801h = "";
            this.f455803j = "";
            this.f455804k = "";
        }

        public VEStickerAnimationParam(Parcel r100) {
            boolean r101 = false;
            this.f455794a = false;
            this.f455795b = "";
            this.f455799f = "";
            this.f455801h = "";
            this.f455803j = "";
            this.f455804k = "";
            if (r100.readByte() == 0) goto L5;
            r101 = true;
        L5:
            this.f455794a = r101;
            this.f455795b = r100.readString();
            this.f455796c = r100.readInt();
            this.f455797d = r100.readInt();
            this.f455798e = r100.readInt();
            this.f455799f = r100.readString();
            this.f455800g = r100.readInt();
            this.f455801h = r100.readString();
            this.f455802i = r100.readInt();
            this.f455803j = r100.readString();
            this.f455804k = r100.readString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeByte(this.f455794a ? 1 : 0);
            r100.writeString(this.f455795b);
            r100.writeInt(this.f455796c);
            r100.writeInt(this.f455797d);
            r100.writeInt(this.f455798e);
            r100.writeString(this.f455799f);
            r100.writeInt(this.f455800g);
            r100.writeString(this.f455801h);
            r100.writeInt(this.f455802i);
            r100.writeString(this.f455803j);
            r100.writeString(this.f455804k);
        }
    }

    public class a implements Parcelable.Creator<VEInfoStickerFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEInfoStickerFilterParam createFromParcel(Parcel r100) {
            return new VEInfoStickerFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEInfoStickerFilterParam[] newArray(int r100) {
            return new VEInfoStickerFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public final String toString() {
        return "VEInfoStickerFilterParam{resPath='" + this.f455780a + "', param=" + Arrays.toString(this.f455781b) + ", useRichText=" + this.f455782c + ", offsetX=" + this.f455783d + ", offsetY=" + this.f455784e + ", degree=" + this.f455785f + ", startTime=" + this.f455786g + ", endTime=" + this.f455787h + ", scale=" + this.f455788i + ", alpha=" + this.f455789j + ", layer=" + this.f455790k + ", flipX=" + this.f455791l + ", flipY=" + this.f455792m + ", animationParam=" + this.f455793n + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEInfoStickerFilterParam() {
        this.f455780a = "";
        this.f455781b = null;
        this.f455782c = false;
        this.f455785f = 0.0f;
        this.f455788i = 1.0f;
        this.f455789j = 1.0f;
        this.f455791l = false;
        this.f455792m = false;
        this.f455793n = null;
        this.filterName = "info sticker";
        this.filterType = 9;
        this.filterDurationType = 1;
        this.f455780a = "";
    }

    public VEInfoStickerFilterParam(Parcel r100) {
        super(r100);
        this.f455780a = "";
        this.f455781b = null;
        boolean r101 = false;
        this.f455782c = false;
        this.f455785f = 0.0f;
        this.f455788i = 1.0f;
        this.f455789j = 1.0f;
        this.f455791l = false;
        this.f455792m = false;
        this.f455793n = null;
        this.f455780a = r100.readString();
        this.f455781b = r100.createStringArray();
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.f455782c = r102;
        this.f455783d = r100.readFloat();
        this.f455784e = r100.readFloat();
        this.f455785f = r100.readFloat();
        this.f455786g = r100.readInt();
        this.f455787h = r100.readInt();
        this.f455788i = r100.readFloat();
        this.f455789j = r100.readFloat();
        this.f455790k = r100.readInt();
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.f455791l = r103;
        if (r100.readByte() == 0) goto L13;
        r101 = true;
    L13:
        this.f455792m = r101;
        this.f455793n = (VEStickerAnimationParam) r100.readParcelable(VEStickerAnimationParam.class.getClassLoader());
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.f455780a);
        r100.writeStringArray(this.f455781b);
        r100.writeByte(this.f455782c ? 1 : 0);
        r100.writeFloat(this.f455783d);
        r100.writeFloat(this.f455784e);
        r100.writeFloat(this.f455785f);
        r100.writeInt(this.f455786g);
        r100.writeInt(this.f455787h);
        r100.writeFloat(this.f455788i);
        r100.writeFloat(this.f455789j);
        r100.writeInt(this.f455790k);
        r100.writeByte(this.f455791l ? 1 : 0);
        r100.writeByte(this.f455792m ? 1 : 0);
        r100.writeParcelable(this.f455793n, r101);
    }
}
