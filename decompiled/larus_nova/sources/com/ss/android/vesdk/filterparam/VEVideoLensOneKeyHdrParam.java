package com.ss.android.vesdk.filterparam;

import android.os.Parcel;

/* JADX INFO: loaded from: classes40.dex */
public class VEVideoLensOneKeyHdrParam extends VEBaseFilterParam {
    public int asf_mode;
    public int disable_denoise;
    public int hdr_mode;
    public String kernel_path;
    public String model_path;
    public int power_level;
    public int scene_case;

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEVideoAjustmentFilterParam{, model_path=" + this.model_path + ", kernel_path=" + this.kernel_path + ", power_level=" + this.power_level + ", scene_case=" + this.scene_case + ", disable_denoise=" + this.disable_denoise + ", filterType=" + this.filterType + ", filterName='" + this.filterName + "', filterDurationType=" + this.filterDurationType + '}';
    }

    public VEVideoLensOneKeyHdrParam() {
        this.power_level = 3;
        this.scene_case = 20001;
        this.disable_denoise = 1;
        this.asf_mode = 0;
        this.hdr_mode = 0;
        this.filterName = "lens one key hdr";
        this.filterType = 35;
        this.filterDurationType = 1;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
    }
}
