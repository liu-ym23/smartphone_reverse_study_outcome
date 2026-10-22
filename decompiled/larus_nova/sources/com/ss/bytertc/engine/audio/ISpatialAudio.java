package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.PositionInfo;

/* JADX INFO: loaded from: classes40.dex */
public interface ISpatialAudio {
    void disableRemoteOrientation();

    void enableSpatialAudio(boolean r100);

    int removeAllRemotePosition();

    int removeRemotePosition(String r100);

    int updateRemotePosition(String r100, PositionInfo r101);

    int updateSelfPosition(PositionInfo r100);
}
