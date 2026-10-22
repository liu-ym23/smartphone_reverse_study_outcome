package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.data.ReceiveRange;
import com.ss.bytertc.engine.type.AttenuationType;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface IRangeAudio {
    void enableRangeAudio(boolean r100);

    int setAttenuationModel(AttenuationType r100, float r101);

    void setNoAttenuationFlags(List<String> r100);

    int updatePosition(Position r100);

    int updateReceiveRange(ReceiveRange r100);
}
