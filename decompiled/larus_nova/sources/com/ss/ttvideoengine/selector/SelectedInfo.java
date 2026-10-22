package com.ss.ttvideoengine.selector;

import androidx.camera.video.AudioStats;
import com.ss.ttvideoengine.model.IVideoInfo;
import com.ss.ttvideoengine.utils.Error;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class SelectedInfo {
    public static final int DOUBLE_CALC_BITRATE = 0;
    private double calcBitRate;
    private final Error err;
    private Map<String, Object> gearResult;
    private final IVideoInfo selected;

    public boolean hasError() {
        if (this.err == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Error getError() {
        return this.err;
    }

    public Map<String, Object> getGearResult() {
        return this.gearResult;
    }

    public IVideoInfo getSelected() {
        return this.selected;
    }

    public IVideoInfo getVideoInfo() {
        return this.selected;
    }

    public SelectedInfo(IVideoInfo r100) {
        this.calcBitRate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.selected = r100;
        this.err = null;
    }

    public void setGearResult(Map<String, Object> r100) {
        this.gearResult = r100;
    }

    public SelectedInfo(Error r100) {
        this.calcBitRate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.selected = null;
        this.err = r100;
    }

    public SelectedInfo(IVideoInfo r100, Error r101) {
        this.calcBitRate = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.selected = r100;
        this.err = r101;
    }

    public double getDoubleValue(int r100, double r101) {
        if (r100 == 0) goto L4;
        return r101;
    L4:
        return this.calcBitRate;
    }

    public void setDoubleValue(int r100, double r101) {
        if (r100 != 0) goto L5;
        this.calcBitRate = r101;
        return;
    }
}
