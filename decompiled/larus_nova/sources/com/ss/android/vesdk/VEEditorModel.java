package com.ss.android.vesdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class VEEditorModel implements Parcelable {
    public static final Parcelable.Creator<VEEditorModel> CREATOR = null;
    public int audioEffectFilterIndex;
    public String[] audioPaths;
    public int backgroundColor;
    public int colorFilterIndex;
    public float colorFilterIntensity;
    public String colorFilterLeftPath;
    public float colorFilterPosition;
    public String colorFilterRightPath;
    public int effectHDRFilterIndex;
    public int hostTrackIndex;
    public int inPoint;
    public int mLensHDRFilterIndex;
    public int masterTrackIndex;
    public String modelDir;
    public String outputFile;
    public int outputPoint;
    public String projectXML;
    public boolean reverseDone;
    public boolean separateAV;
    public String[] transitions;
    public boolean useColorFilterResIntensity;
    public int videoBackgroundColor;
    public VEEditor.VIDEO_GRAVITY videoGravity;
    public VEEditor.VIDEO_RATIO videoOutRes;
    public String[] videoPaths;
    public VEEditor.VIDEO_SCALETYPE videoScaleType;
    public String watermarkFile;
    public double watermarkHeight;
    public double watermarkOffsetX;
    public double watermarkOffsetY;
    public double watermarkWidth;

    public class a implements Parcelable.Creator<VEEditorModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEEditorModel createFromParcel(Parcel r100) {
            return new VEEditorModel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEEditorModel[] newArray(int r100) {
            return new VEEditorModel[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "{\"projectXML\":\"" + this.projectXML + "\",\"inPoint\":" + this.inPoint + ",\"outputPoint\":" + this.outputPoint + ",\"reverseDone\":" + this.reverseDone + ",\"videoOutRes\":" + this.videoOutRes + ",\"separateAV\":" + this.separateAV + ",\"masterTrackIndex\":" + this.masterTrackIndex + ",\"hostTrackIndex\":" + this.hostTrackIndex + ",\"audioEffectFilterIndex\":" + this.audioEffectFilterIndex + ",\"modelDir\":\"" + this.modelDir + "\",\"colorFilterIndex\":" + this.colorFilterIndex + ",\"effectHDRFilterIndex\":" + this.effectHDRFilterIndex + ",\"mLensHDRFilterIndex\":" + this.mLensHDRFilterIndex + ",\"videoPaths\":" + Arrays.toString(this.videoPaths) + ",\"audioPaths\":" + Arrays.toString(this.audioPaths) + ",\"transitions\":" + Arrays.toString(this.transitions) + ",\"backgroundColor\":" + this.backgroundColor + ",\"videoBackgroundColor\":" + this.videoBackgroundColor + ",\"outputFile\":\"" + this.outputFile + "\",\"watermarkFile\":\"" + this.watermarkFile + "\",\"watermarkWidth\":" + this.watermarkWidth + ",\"watermarkHeight\":" + this.watermarkHeight + ",\"watermarkOffsetX\":" + this.watermarkOffsetX + ",\"watermarkOffsetY\":" + this.watermarkOffsetY + ",\"colorFilterLeftPath\":\"" + this.colorFilterLeftPath + "\",\"colorFilterRightPath\":\"" + this.colorFilterRightPath + "\",\"colorFilterPosition\":" + this.colorFilterPosition + ",\"colorFilterIntensity\":" + this.colorFilterIntensity + ",\"useColorFilterResIntensity\":" + this.useColorFilterResIntensity + ",\"videoGravity\":" + this.videoGravity + ",\"videoScaleType\":" + this.videoScaleType + '}';
    }

    public VEEditorModel() {
    }

    public VEEditorModel(Parcel r100) {
        this.projectXML = r100.readString();
        this.inPoint = r100.readInt();
        this.outputPoint = r100.readInt();
        boolean r101 = false;
        if (r100.readInt() != 1) goto L5;
        boolean r102 = true;
    L6:
        this.reverseDone = r102;
        this.videoOutRes = VEEditor.VIDEO_RATIO.values()[r100.readInt()];
        if (r100.readInt() != 1) goto L9;
        boolean r103 = true;
    L10:
        this.separateAV = r103;
        this.masterTrackIndex = r100.readInt();
        this.hostTrackIndex = r100.readInt();
        this.audioEffectFilterIndex = r100.readInt();
        this.modelDir = r100.readString();
        this.colorFilterIndex = r100.readInt();
        this.effectHDRFilterIndex = r100.readInt();
        this.mLensHDRFilterIndex = r100.readInt();
        int r104 = r100.readInt();
        if (r104 == (-1)) goto L13;
        String[] r105 = new String[r104];
        this.videoPaths = r105;
        r100.readStringArray(r105);
    L14:
        int r106 = r100.readInt();
        if (r106 == (-1)) goto L17;
        String[] r107 = new String[r106];
        this.audioPaths = r107;
        r100.readStringArray(r107);
    L18:
        int r108 = r100.readInt();
        if (r108 == (-1)) goto L21;
        String[] r109 = new String[r108];
        this.transitions = r109;
        r100.readStringArray(r109);
    L22:
        this.backgroundColor = r100.readInt();
        this.outputFile = r100.readString();
        this.watermarkFile = r100.readString();
        this.watermarkWidth = r100.readDouble();
        this.watermarkHeight = r100.readDouble();
        this.watermarkOffsetX = r100.readDouble();
        this.watermarkOffsetY = r100.readDouble();
        this.colorFilterLeftPath = r100.readString();
        this.colorFilterRightPath = r100.readString();
        this.colorFilterPosition = r100.readFloat();
        this.colorFilterIntensity = r100.readFloat();
        if (r100.readInt() != 1) goto L25;
        r101 = true;
    L25:
        this.useColorFilterResIntensity = r101;
        this.videoGravity = VEEditor.VIDEO_GRAVITY.values()[r100.readInt()];
        this.videoScaleType = VEEditor.VIDEO_SCALETYPE.values()[r100.readInt()];
        this.videoBackgroundColor = r100.readInt();
        return;
    L21:
        this.transitions = null;
        goto L22
    L17:
        this.audioPaths = null;
        goto L18
    L13:
        this.videoPaths = null;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.projectXML);
        r100.writeInt(this.inPoint);
        r100.writeInt(this.outputPoint);
        r100.writeInt(this.reverseDone ? 1 : 0);
        r100.writeInt(this.videoOutRes.ordinal());
        r100.writeInt(this.separateAV ? 1 : 0);
        r100.writeInt(this.masterTrackIndex);
        r100.writeInt(this.hostTrackIndex);
        r100.writeInt(this.audioEffectFilterIndex);
        r100.writeString(this.modelDir);
        r100.writeInt(this.colorFilterIndex);
        r100.writeInt(this.effectHDRFilterIndex);
        r100.writeInt(this.mLensHDRFilterIndex);
        String[] r102 = this.videoPaths;
        if (r102 == null) goto L5;
        r100.writeInt(r102.length);
        r100.writeStringArray(this.videoPaths);
    L6:
        String[] r103 = this.audioPaths;
        if (r103 == null) goto L9;
        r100.writeInt(r103.length);
        r100.writeStringArray(this.audioPaths);
    L10:
        String[] r104 = this.transitions;
        if (r104 == null) goto L13;
        r100.writeInt(r104.length);
        r100.writeStringArray(this.transitions);
    L14:
        r100.writeInt(this.backgroundColor);
        r100.writeString(this.outputFile);
        r100.writeString(this.watermarkFile);
        r100.writeDouble(this.watermarkWidth);
        r100.writeDouble(this.watermarkHeight);
        r100.writeDouble(this.watermarkOffsetX);
        r100.writeDouble(this.watermarkOffsetY);
        r100.writeString(this.colorFilterLeftPath);
        r100.writeString(this.colorFilterRightPath);
        r100.writeFloat(this.colorFilterPosition);
        r100.writeFloat(this.colorFilterIntensity);
        r100.writeInt(this.useColorFilterResIntensity ? 1 : 0);
        r100.writeInt(this.videoGravity.ordinal());
        r100.writeInt(this.videoScaleType.ordinal());
        r100.writeInt(this.videoBackgroundColor);
        return;
    L13:
        r100.writeInt(-1);
        goto L14
    L9:
        r100.writeInt(-1);
        goto L10
    L5:
        r100.writeInt(-1);
        goto L6
    }
}
