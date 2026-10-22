package com.ss.android.vesdk.filterparam;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class VEPreMVPFilterParam extends VEBaseFilterParam {
    public double position_x_in_canvas;
    public double position_y_in_canvas;
    public double rotation;
    public double scale_x;
    public double scale_y;
    public double slot_width_height_ratio;

    public VEPreMVPFilterParam() {
        this.position_x_in_canvas = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.position_y_in_canvas = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.rotation = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.scale_x = 1.0d;
        this.scale_y = 1.0d;
        this.slot_width_height_ratio = 1.0d;
        this.filterName = "PreMVPFilterParam";
        this.filterType = 83;
        this.filterDurationType = 1;
    }
}
