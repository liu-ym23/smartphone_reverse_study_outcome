package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoTransformFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEVideoTransformFilterParam> CREATOR = null;
    public float alpha;
    public long animComboEndTime;
    public String animComboPath;
    public long animComboStartTime;
    public int animEndTime;
    public long animInEndTime;
    public String animInPath;
    public long animInStartTime;
    public String animJsonParam;
    public long animOutEndTime;
    public String animOutPath;
    public long animOutStartTime;
    public String animPath;
    public int animStartTime;
    public String blendModePath;
    public int borderColor;
    public int borderWidth;
    public float degree;
    public boolean disableInsideScale;
    public int mirror;
    public float scaleFactor;
    public float transX;
    public float transY;
    public int transformType;

    public class a implements Parcelable.Creator<VEVideoTransformFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoTransformFilterParam createFromParcel(Parcel r100) {
            return new VEVideoTransformFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEVideoTransformFilterParam[] newArray(int r100) {
            return new VEVideoTransformFilterParam[r100];
        }
    }

    public static final enum paramType extends Enum<paramType> {
        private static final /* synthetic */ paramType[] $VALUES = null;
        public static final paramType UPDATE_VIDEO_ANIMATION = null;
        public static final paramType UPDATE_VIDEO_ANIMATION_AND_ANIMATION = null;
        public static final paramType UPDATE_VIDEO_ANIMATION_NEW = null;
        public static final paramType UPDATE_VIDEO_TRANSFORM = null;

        private static /* synthetic */ paramType[] $values() {
            return new paramType[]{UPDATE_VIDEO_TRANSFORM, UPDATE_VIDEO_ANIMATION, UPDATE_VIDEO_ANIMATION_AND_ANIMATION, UPDATE_VIDEO_ANIMATION_NEW};
        }

        static {
            UPDATE_VIDEO_TRANSFORM = new paramType("UPDATE_VIDEO_TRANSFORM", 0);
            UPDATE_VIDEO_ANIMATION = new paramType("UPDATE_VIDEO_ANIMATION", 1);
            UPDATE_VIDEO_ANIMATION_AND_ANIMATION = new paramType("UPDATE_VIDEO_ANIMATION_AND_ANIMATION", 2);
            UPDATE_VIDEO_ANIMATION_NEW = new paramType("UPDATE_VIDEO_ANIMATION_NEW", 3);
            $VALUES = $values();
        }

        public static paramType[] values() {
            return (paramType[]) $VALUES.clone();
        }

        public static paramType valueOf(String r100) {
            return (paramType) r27.a.a(paramType.class, r100);
        }

        private paramType(String r100, int r101) {
            super(r100, r101);
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
        return "VEVideoTransformFilterParam{scaleFactor=" + this.scaleFactor + ", disableInsideScale=" + this.disableInsideScale + ", degree=" + this.degree + ", transX=" + this.transX + ", transY=" + this.transY + ", mirror=" + this.mirror + ", blendModePath='" + this.blendModePath + "', alpha=" + this.alpha + ", animPath='" + this.animPath + "', animStartTime=" + this.animStartTime + ", animEndTime=" + this.animEndTime + ", animInPath='" + this.animInPath + "', animInStartTime='" + this.animInStartTime + "', animInEndTime='" + this.animInEndTime + "', animOutPath='" + this.animOutPath + "', animOutStartTime='" + this.animOutStartTime + "', animOutEndTime='" + this.animOutEndTime + "', animComboPath='" + this.animComboPath + "', animComboStartTime='" + this.animComboStartTime + "', animComboEndTime='" + this.animComboEndTime + "', animJsonParam=" + this.animJsonParam + ", transformType=" + this.transformType + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + "', borderColor =" + this.borderColor + "', borderWidth =" + this.borderWidth + '}';
    }

    public VEVideoTransformFilterParam() {
        this.animInPath = "";
        this.animInStartTime = 0;
        this.animInEndTime = 0;
        this.animOutPath = "";
        this.animOutStartTime = 0;
        this.animOutEndTime = 0;
        this.animComboPath = "";
        this.animComboStartTime = 0;
        this.animComboEndTime = 0;
        this.filterName = "canvas blend";
        this.filterType = 15;
        this.filterDurationType = 1;
        this.scaleFactor = 1.0f;
        this.degree = 0.0f;
        this.transX = 0.0f;
        this.transY = 0.0f;
        this.mirror = 0;
        this.alpha = 1.0f;
        this.animPath = "";
        this.blendModePath = "";
        this.animStartTime = 0;
        this.animEndTime = 0;
        this.animJsonParam = "";
        this.disableInsideScale = false;
        this.transformType = paramType.UPDATE_VIDEO_TRANSFORM.ordinal();
        this.borderColor = -1;
        this.borderWidth = 0;
    }

    public VEVideoTransformFilterParam(Parcel r100) {
        super(r100);
        this.animInPath = "";
        this.animInStartTime = 0;
        this.animInEndTime = 0;
        this.animOutPath = "";
        this.animOutStartTime = 0;
        this.animOutEndTime = 0;
        this.animComboPath = "";
        this.animComboStartTime = 0;
        this.animComboEndTime = 0;
        this.scaleFactor = r100.readFloat();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.disableInsideScale = r101;
        this.degree = r100.readFloat();
        this.transX = r100.readFloat();
        this.transY = r100.readFloat();
        this.mirror = r100.readInt();
        this.blendModePath = r100.readString();
        this.alpha = r100.readFloat();
        this.animPath = r100.readString();
        this.animStartTime = r100.readInt();
        this.animEndTime = r100.readInt();
        this.animJsonParam = r100.readString();
        this.transformType = r100.readInt();
        this.borderColor = r100.readInt();
        this.borderWidth = r100.readInt();
        this.animInPath = r100.readString();
        this.animInStartTime = r100.readLong();
        this.animInEndTime = r100.readLong();
        this.animOutPath = r100.readString();
        this.animOutStartTime = r100.readLong();
        this.animOutEndTime = r100.readLong();
        this.animComboPath = r100.readString();
        this.animComboStartTime = r100.readLong();
        this.animComboEndTime = r100.readLong();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.scaleFactor);
        r100.writeByte(this.disableInsideScale ? 1 : 0);
        r100.writeFloat(this.degree);
        r100.writeFloat(this.transX);
        r100.writeFloat(this.transY);
        r100.writeInt(this.mirror);
        r100.writeString(this.blendModePath);
        r100.writeFloat(this.alpha);
        r100.writeString(this.animPath);
        r100.writeInt(this.animStartTime);
        r100.writeInt(this.animEndTime);
        r100.writeString(this.animJsonParam);
        r100.writeInt(this.transformType);
        r100.writeInt(this.borderColor);
        r100.writeInt(this.borderWidth);
        r100.writeString(this.animInPath);
        r100.writeLong(this.animInStartTime);
        r100.writeLong(this.animInEndTime);
        r100.writeString(this.animOutPath);
        r100.writeLong(this.animOutStartTime);
        r100.writeLong(this.animOutEndTime);
        r100.writeString(this.animComboPath);
        r100.writeLong(this.animComboStartTime);
        r100.writeLong(this.animComboEndTime);
    }
}
