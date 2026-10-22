package com.lynx.canvas;

import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonSensorService extends KryptonService {

    public interface Listener {
        void notifyGyroscopeData(float r100, float r101, float r102, long r103);

        void notifyOrientationData(float r100, float r101, float r102, long r103);
    }

    public List<Integer> getAvailableSensorTypes(List<Integer> r100) {
        return null;
    }

    public abstract void setListener(Listener r100);

    public abstract boolean start(List<Integer> r100, int r101);

    public abstract void stop();

    public KryptonSensorService() {
    }
}
