package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VECanvasFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VECanvasFilterParam> CREATOR = null;
    public int color;
    public boolean enableAntialiasing;
    public int gradientBottomColor;
    public int gradientTopColor;
    public int height;
    public String imagePath;
    public int radius;
    public int sourceType;
    public int width;

    public static final enum SourceType extends Enum<SourceType> {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final SourceType COLOR = null;
        public static final SourceType GRADIENT_COLOR = null;
        public static final SourceType IMAGE = null;
        public static final SourceType VIDEOFRAME = null;

        private static /* synthetic */ SourceType[] $values() {
            return new SourceType[]{COLOR, VIDEOFRAME, IMAGE, GRADIENT_COLOR};
        }

        static {
            COLOR = new SourceType("COLOR", 0);
            VIDEOFRAME = new SourceType("VIDEOFRAME", 1);
            IMAGE = new SourceType("IMAGE", 2);
            GRADIENT_COLOR = new SourceType("GRADIENT_COLOR", 3);
            $VALUES = $values();
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) r27.a.a(SourceType.class, r100);
        }

        private SourceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a implements Parcelable.Creator<VECanvasFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VECanvasFilterParam createFromParcel(Parcel r100) {
            return new VECanvasFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VECanvasFilterParam[] newArray(int r100) {
            return new VECanvasFilterParam[r100];
        }
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VECanvasFilterParam{sourceType=" + this.sourceType + ", color=" + this.color + ", radius=" + this.radius + ", imagePath='" + this.imagePath + "', width=" + this.width + ", height=" + this.height + ", enableAntialiasing=" + this.enableAntialiasing + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VECanvasFilterParam() {
        this.filterName = "color_canvas";
        this.filterType = 15;
        this.filterDurationType = 1;
        this.sourceType = SourceType.COLOR.ordinal();
        this.color = -16777216;
        this.radius = 0;
        this.imagePath = "";
        this.width = -1;
        this.height = -1;
        this.enableAntialiasing = false;
    }

    public VECanvasFilterParam(Parcel r100) {
        super(r100);
        this.sourceType = r100.readInt();
        this.color = r100.readInt();
        this.radius = r100.readInt();
        this.imagePath = r100.readString();
        this.width = r100.readInt();
        this.height = r100.readInt();
        if (r100.readInt() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.enableAntialiasing = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.sourceType);
        r100.writeInt(this.color);
        r100.writeInt(this.radius);
        r100.writeString(this.imagePath);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.enableAntialiasing ? 1 : 0);
    }
}
