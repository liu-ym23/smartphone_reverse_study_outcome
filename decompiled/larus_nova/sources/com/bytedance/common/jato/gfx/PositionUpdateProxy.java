package com.bytedance.common.jato.gfx;

/* JADX INFO: loaded from: classes15.dex */
public class PositionUpdateProxy {

    public interface PositionUpdateListener {
    }

    public static boolean positionChanged(Object r100, long r101, int r102, int r103, int r104, int r105) {
        return false;
    }

    public static boolean positionLost(Object r100, long r101) {
        return false;
    }

    public static void setGlobalPositionUpdateListener(PositionUpdateListener r100) {
    }
}
