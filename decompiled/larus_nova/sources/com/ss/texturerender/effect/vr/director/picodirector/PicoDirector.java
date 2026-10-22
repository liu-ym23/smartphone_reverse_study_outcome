package com.ss.texturerender.effect.vr.director.picodirector;

import android.os.Bundle;
import android.view.Display;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.math.Matrix3x3d;

/* JADX INFO: loaded from: classes40.dex */
public class PicoDirector implements IDirector {
    private Display mDisplay;

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void reset() {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void setParam(Bundle r100) {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void start() {
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void stop() {
    }

    public PicoDirector(Display r100) {
        this.mDisplay = r100;
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirector
    public void getView(float[] r100, int r101) {
        if (PicoQuaternion.getVRQuaternion() == null) goto L6;
        Matrix3x3d.matrixToColumnArray(Matrix3x3d.rotationMatrix3x3(PicoQuaternion.getVRQuaternion()), r100);
        return;
    }
}
