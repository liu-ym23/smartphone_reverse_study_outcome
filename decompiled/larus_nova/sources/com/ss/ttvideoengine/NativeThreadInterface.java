package com.ss.ttvideoengine;

import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public interface NativeThreadInterface {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.NativeThreadInterface$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getPowerMode(NativeThreadInterface r100) {
            return 0;
        }

        public static int $default$getThermalStatus(NativeThreadInterface r100) {
            return 0;
        }

        public static void $default$onLowPowerModeChanged(NativeThreadInterface r100, int r101) {
        }

        public static void $default$onTempStatusChanged(NativeThreadInterface r100, int r101) {
        }
    }

    void carethreadList(List<Integer> r100);

    int getPowerMode();

    float getProcessCpuUsage();

    int getThermalStatus();

    float getThreadCpuUsage(int r100);

    void onLowPowerModeChanged(int r100);

    void onTempStatusChanged(int r100);
}
