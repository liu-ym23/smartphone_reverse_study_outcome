package com.ss.android.vesdk;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEWatermarkParam implements Parcelable {
    public static final Parcelable.Creator<VEWatermarkParam> CREATOR = null;
    public long duration;
    private VEWatermarkEntity[] entities;
    public String extFile;
    public int height;
    public String[] images;
    public int interval;
    public VEWatermarkMask mask;
    public boolean needExtFile;
    public VEWaterMarkPosition position;
    public int rotation;
    public String[] secondHalfImages;
    public Bitmap waterMarkBitmap;
    public int width;
    public int xOffset;
    public int yOffset;

    public static class VEWatermarkEntity implements Parcelable {
        public static final Parcelable.Creator<VEWatermarkEntity> CREATOR = null;
        public int height;
        public String[] images;
        public int interval;
        public VEWaterMarkPosition position;
        public int rotation;
        public long sequenceIn;
        public long sequenceOut;
        public int width;
        public int xOffset;
        public int yOffset;

        public class a implements Parcelable.Creator<VEWatermarkEntity> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VEWatermarkEntity createFromParcel(Parcel r100) {
                return new VEWatermarkEntity(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final VEWatermarkEntity[] newArray(int r100) {
                return new VEWatermarkEntity[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public int getPosition() {
            return this.position.ordinal();
        }

        public VEWatermarkEntity() {
            this.position = VEWaterMarkPosition.TL_BR;
            this.rotation = 0;
        }

        public VEWatermarkEntity(Parcel r100) {
            this.position = VEWaterMarkPosition.TL_BR;
            this.rotation = 0;
            this.images = r100.createStringArray();
            this.interval = r100.readInt();
            this.xOffset = r100.readInt();
            this.yOffset = r100.readInt();
            this.width = r100.readInt();
            this.height = r100.readInt();
            this.sequenceIn = r100.readLong();
            this.sequenceOut = r100.readLong();
            int r101 = r100.readInt();
            if (r101 != (-1)) goto L5;
            VEWaterMarkPosition r102 = null;
        L6:
            this.position = r102;
            this.rotation = r100.readInt();
            return;
        L5:
            r102 = VEWaterMarkPosition.values()[r101];
            goto L6
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeStringArray(this.images);
            r100.writeInt(this.interval);
            r100.writeInt(this.xOffset);
            r100.writeInt(this.yOffset);
            r100.writeInt(this.width);
            r100.writeInt(this.height);
            r100.writeLong(this.sequenceIn);
            r100.writeLong(this.sequenceOut);
            VEWaterMarkPosition r102 = this.position;
            if (r102 != null) goto L5;
            int r103 = -1;
        L6:
            r100.writeInt(r103);
            r100.writeInt(this.rotation);
            return;
        L5:
            r103 = r102.ordinal();
            goto L6
        }
    }

    public static class VEWatermarkMask implements Parcelable {
        public static final Parcelable.Creator<VEWatermarkMask> CREATOR = null;
        public int height;
        public String maskImage;
        public int width;
        public int xOffset;
        public int yOffset;

        public class a implements Parcelable.Creator<VEWatermarkMask> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final VEWatermarkMask createFromParcel(Parcel r100) {
                return new VEWatermarkMask(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final VEWatermarkMask[] newArray(int r100) {
                return new VEWatermarkMask[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public VEWatermarkMask() {
        }

        public VEWatermarkMask(Parcel r100) {
            this.maskImage = r100.readString();
            this.xOffset = r100.readInt();
            this.yOffset = r100.readInt();
            this.width = r100.readInt();
            this.height = r100.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.maskImage);
            r100.writeInt(this.xOffset);
            r100.writeInt(this.yOffset);
            r100.writeInt(this.width);
            r100.writeInt(this.height);
        }
    }

    public class a implements Parcelable.Creator<VEWatermarkParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEWatermarkParam createFromParcel(Parcel r100) {
            return new VEWatermarkParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEWatermarkParam[] newArray(int r100) {
            return new VEWatermarkParam[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public VEWatermarkEntity[] getEntities() {
        if (this.entities != null) goto L20;
        if (this.images == null) goto L20;
        if (this.secondHalfImages == null) goto L9;
        int r100 = 2;
    L10:
        this.entities = new VEWatermarkEntity[r100];
        int r101 = 0;
    L11:
        if (r101 >= r100) goto L13;
        VEWatermarkEntity r102 = new VEWatermarkEntity();
        r102.images = this.images;
        r102.interval = this.interval;
        r102.width = this.width;
        r102.height = this.height;
        r102.position = this.position;
        long r103 = this.duration;
        long r110 = r100;
        r102.sequenceIn = (((long) r101) * r103) / r110;
        int r104 = r101 + 1;
        r102.sequenceOut = (r103 * ((long) r104)) / r110;
        r102.rotation = this.rotation;
        r102.xOffset = this.xOffset;
        r102.yOffset = this.yOffset;
        this.entities[r101] = r102;
        r101 = r104;
        goto L11
    L13:
        if (r100 != 2) goto L16;
        this.entities[1].images = this.secondHalfImages;
    L16:
        if (this.position != VEWaterMarkPosition.TL_BR) goto L20;
        if (r100 != 2) goto L20;
        VEWatermarkEntity[] r105 = this.entities;
        r105[0].position = VEWaterMarkPosition.TL;
        r105[1].position = VEWaterMarkPosition.BR;
        goto L20
    L9:
        r100 = 1;
    L20:
        return this.entities;
    }

    public String toString() {
        return " needExtFile " + this.needExtFile;
    }

    public VEWatermarkParam() {
        this.duration = -1;
        this.position = VEWaterMarkPosition.TL_BR;
        this.rotation = 0;
    }

    public VEWatermarkParam(Parcel r100) {
        this.duration = -1;
        this.position = VEWaterMarkPosition.TL_BR;
        boolean r101 = false;
        this.rotation = 0;
        if (r100.readByte() == 0) goto L5;
        r101 = true;
    L5:
        this.needExtFile = r101;
        this.extFile = r100.readString();
        this.entities = (VEWatermarkEntity[]) r100.createTypedArray(VEWatermarkEntity.CREATOR);
        this.mask = (VEWatermarkMask) r100.readParcelable(VEWatermarkMask.class.getClassLoader());
        this.images = r100.createStringArray();
        this.waterMarkBitmap = (Bitmap) r100.readParcelable(Bitmap.class.getClassLoader());
        this.secondHalfImages = r100.createStringArray();
        this.interval = r100.readInt();
        this.xOffset = r100.readInt();
        this.yOffset = r100.readInt();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.duration = r100.readLong();
        int r102 = r100.readInt();
        if (r102 != (-1)) goto L8;
        VEWaterMarkPosition r103 = null;
    L9:
        this.position = r103;
        this.rotation = r100.readInt();
        return;
    L8:
        r103 = VEWaterMarkPosition.values()[r102];
        goto L9
    }

    public void setEntities(VEWatermarkEntity[] r100) {
        this.entities = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.needExtFile ? 1 : 0);
        r100.writeString(this.extFile);
        r100.writeTypedArray(this.entities, r101);
        r100.writeParcelable(this.mask, r101);
        r100.writeStringArray(this.images);
        r100.writeParcelable(this.waterMarkBitmap, r101);
        r100.writeStringArray(this.secondHalfImages);
        r100.writeInt(this.interval);
        r100.writeInt(this.xOffset);
        r100.writeInt(this.yOffset);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeLong(this.duration);
        VEWaterMarkPosition r102 = this.position;
        if (r102 != null) goto L5;
        int r103 = -1;
    L6:
        r100.writeInt(r103);
        r100.writeInt(this.rotation);
        return;
    L5:
        r103 = r102.ordinal();
        goto L6
    }
}
