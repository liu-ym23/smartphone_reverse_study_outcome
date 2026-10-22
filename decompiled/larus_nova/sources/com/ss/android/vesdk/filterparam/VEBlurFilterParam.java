package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ttve.nativePort.TEBundle;

/* JADX INFO: loaded from: classes40.dex */
public class VEBlurFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEBlurFilterParam> CREATOR = null;
    public boolean dynamicIntensity;
    public int height;
    public float intensity;
    public float intensityStep;
    public int lastFacing;
    public float maxIntensity;
    public float minIntensity;
    public boolean usedByEffectBin;
    public int width;

    public class a implements Parcelable.Creator<VEBlurFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEBlurFilterParam createFromParcel(Parcel r100) {
            return new VEBlurFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEBlurFilterParam[] newArray(int r100) {
            return new VEBlurFilterParam[r100];
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
        return "VEBlurFilterParam{intensity=" + this.intensity + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + "usedByEffectBin=" + this.usedByEffectBin + "dynamicIntensity=" + this.dynamicIntensity + "minIntensity=" + this.minIntensity + "maxIntensity=" + this.maxIntensity + "intensityStep=" + this.intensityStep + '}';
    }

    public VEBlurFilterParam() {
        this.intensity = 0.0f;
        this.lastFacing = -1;
        this.height = -1;
        this.width = -1;
        this.usedByEffectBin = false;
        this.dynamicIntensity = false;
        this.minIntensity = 0.0f;
        this.maxIntensity = 0.0f;
        this.intensityStep = 0.0f;
        this.filterName = "ve_blur";
        this.filterType = 31;
        this.filterDurationType = 1;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setFloat("intensity", this.intensity);
        r100.setInt("lastFacing", this.lastFacing);
        r100.setInt("blurHeight", this.height);
        r100.setInt("blurWidth", this.width);
        r100.setBool("usedByEffectBin", this.usedByEffectBin);
        r100.setBool("dynamicIntensity", this.dynamicIntensity);
        r100.setFloat("minIntensity", this.minIntensity);
        r100.setFloat("maxIntensity", this.maxIntensity);
        r100.setFloat("intensityStep", this.intensityStep);
        return r100;
    }

    public VEBlurFilterParam(Parcel r100) {
        super(r100);
        this.intensity = 0.0f;
        this.lastFacing = -1;
        this.height = -1;
        this.width = -1;
        this.usedByEffectBin = false;
        this.dynamicIntensity = false;
        this.minIntensity = 0.0f;
        this.maxIntensity = 0.0f;
        this.intensityStep = 0.0f;
        this.intensity = r100.readFloat();
    }

    public void init(int r100) {
        this.intensity = 0.0f;
        this.lastFacing = r100;
        this.height = 0;
        this.width = 0;
        this.usedByEffectBin = true;
        this.dynamicIntensity = false;
        this.intensityStep = 0.0f;
        this.maxIntensity = 0.0f;
        this.minIntensity = 0.0f;
    }

    public void init(float r100, int r101) {
        this.intensity = r100;
        this.lastFacing = r101;
        this.height = 0;
        this.width = 0;
        this.usedByEffectBin = true;
        this.dynamicIntensity = false;
        this.intensityStep = 0.0f;
        this.maxIntensity = 0.0f;
        this.minIntensity = 0.0f;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeFloat(this.intensity);
    }

    public void init(int r100, float r101, float r102, float r103) {
        this.intensity = 0.0f;
        this.lastFacing = r100;
        this.height = 0;
        this.width = 0;
        this.usedByEffectBin = true;
        this.dynamicIntensity = true;
        this.minIntensity = r101;
        this.maxIntensity = Math.max(r102, r101);
        this.intensityStep = Math.max(r103, 0.0f);
    }

    public void init(float r100, int r101, int r102, int r103) {
        this.intensity = r100;
        this.lastFacing = r101;
        this.height = r102;
        this.width = r103;
        this.usedByEffectBin = false;
        this.dynamicIntensity = false;
        this.intensityStep = 0.0f;
        this.maxIntensity = 0.0f;
        this.minIntensity = 0.0f;
    }
}
