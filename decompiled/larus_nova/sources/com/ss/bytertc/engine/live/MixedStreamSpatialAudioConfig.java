package com.ss.bytertc.engine.live;

import com.ss.bytertc.engine.data.HumanOrientation;
import com.ss.bytertc.engine.data.Position;

/* JADX INFO: loaded from: classes40.dex */
public class MixedStreamSpatialAudioConfig {
    public HumanOrientation audienceSpatialOrientation;
    public Position audienceSpatialPosition;
    public boolean enableSpatialRender;

    public MixedStreamSpatialAudioConfig() {
        this.enableSpatialRender = false;
        this.audienceSpatialPosition = new Position();
        this.audienceSpatialOrientation = new HumanOrientation();
    }

    public MixedStreamSpatialAudioConfig setAudienceSpatialPosition(float r100, float r101, float r102) {
        Position r103 = this.audienceSpatialPosition;
        r103.f456202x = r100;
        r103.f456203y = r101;
        r103.f456204z = r102;
        return this;
    }
}
