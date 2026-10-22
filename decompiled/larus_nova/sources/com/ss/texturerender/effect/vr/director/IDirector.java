package com.ss.texturerender.effect.vr.director;

import android.os.Bundle;

/* JADX INFO: loaded from: classes40.dex */
public interface IDirector {
    void getView(float[] r100, int r101);

    void reset();

    void setParam(Bundle r100);

    void start();

    void stop();
}
