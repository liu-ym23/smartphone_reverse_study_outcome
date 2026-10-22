package com.ss.texturerender;

import com.ss.texturerender.effect.PicoTextureObj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes40.dex */
public interface VideoSurfaceTexturePicoInterface {
    int[] getFovResult();

    void setIsPicoVRScene(boolean r100);

    void updatePicoTextureObj(HashMap<Integer, PicoTextureObj> r100);
}
