package com.ss.android.ttvecamera;

import android.content.Context;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public class TEVBoostInterface {
    public static final int SHORTEST_TIMEOUT = 50;
    private static final String TAG = "TEVBoostInterface";

    public static final enum VBoostCapabilityType extends Enum<VBoostCapabilityType> {
        private static final /* synthetic */ VBoostCapabilityType[] $VALUES = null;
        public static final VBoostCapabilityType BUS_FREQ_MAX = null;
        public static final VBoostCapabilityType BUS_FREQ_MIN = null;
        public static final VBoostCapabilityType CPU_AFFINITY = null;
        public static final VBoostCapabilityType CPU_CORE_MAX = null;
        public static final VBoostCapabilityType CPU_CORE_MIN = null;
        public static final VBoostCapabilityType CPU_FREQ_MAX = null;
        public static final VBoostCapabilityType CPU_FREQ_MIN = null;
        public static final VBoostCapabilityType GPU_FREQ_MAX = null;
        public static final VBoostCapabilityType GPU_FREQ_MIN = null;
        public static final VBoostCapabilityType IDLE_STATE = null;
        public static final VBoostCapabilityType IO_PRELOAD = null;
        public static final VBoostCapabilityType NETWORK_ENHANCE = null;
        public static final VBoostCapabilityType PRESET_SCENE = null;
        public static final VBoostCapabilityType TASK_PRIORITY = null;
        public static final VBoostCapabilityType THUMB_FETCH = null;
        public static final VBoostCapabilityType UFS_FREQ_MAX = null;
        public static final VBoostCapabilityType UFS_FREQ_MIN = null;
        public static final VBoostCapabilityType UNKNOWN = null;
        public static final VBoostCapabilityType VIBRATE_ENHANCE = null;

        private static /* synthetic */ VBoostCapabilityType[] $values() {
            return new VBoostCapabilityType[]{UNKNOWN, CPU_FREQ_MIN, CPU_FREQ_MAX, CPU_CORE_MIN, CPU_CORE_MAX, GPU_FREQ_MIN, GPU_FREQ_MAX, BUS_FREQ_MIN, BUS_FREQ_MAX, UFS_FREQ_MIN, UFS_FREQ_MAX, TASK_PRIORITY, CPU_AFFINITY, IDLE_STATE, IO_PRELOAD, NETWORK_ENHANCE, PRESET_SCENE, THUMB_FETCH, VIBRATE_ENHANCE};
        }

        static {
            UNKNOWN = new VBoostCapabilityType("UNKNOWN", 0);
            CPU_FREQ_MIN = new VBoostCapabilityType("CPU_FREQ_MIN", 1);
            CPU_FREQ_MAX = new VBoostCapabilityType("CPU_FREQ_MAX", 2);
            CPU_CORE_MIN = new VBoostCapabilityType("CPU_CORE_MIN", 3);
            CPU_CORE_MAX = new VBoostCapabilityType("CPU_CORE_MAX", 4);
            GPU_FREQ_MIN = new VBoostCapabilityType("GPU_FREQ_MIN", 5);
            GPU_FREQ_MAX = new VBoostCapabilityType("GPU_FREQ_MAX", 6);
            BUS_FREQ_MIN = new VBoostCapabilityType("BUS_FREQ_MIN", 7);
            BUS_FREQ_MAX = new VBoostCapabilityType("BUS_FREQ_MAX", 8);
            UFS_FREQ_MIN = new VBoostCapabilityType("UFS_FREQ_MIN", 9);
            UFS_FREQ_MAX = new VBoostCapabilityType("UFS_FREQ_MAX", 10);
            TASK_PRIORITY = new VBoostCapabilityType("TASK_PRIORITY", 11);
            CPU_AFFINITY = new VBoostCapabilityType("CPU_AFFINITY", 12);
            IDLE_STATE = new VBoostCapabilityType("IDLE_STATE", 13);
            IO_PRELOAD = new VBoostCapabilityType("IO_PRELOAD", 14);
            NETWORK_ENHANCE = new VBoostCapabilityType("NETWORK_ENHANCE", 15);
            PRESET_SCENE = new VBoostCapabilityType("PRESET_SCENE", 16);
            THUMB_FETCH = new VBoostCapabilityType("THUMB_FETCH", 17);
            VIBRATE_ENHANCE = new VBoostCapabilityType("VIBRATE_ENHANCE", 18);
            $VALUES = $values();
        }

        public static VBoostCapabilityType[] values() {
            return (VBoostCapabilityType[]) $VALUES.clone();
        }

        public static VBoostCapabilityType valueOf(String r100) {
            return (VBoostCapabilityType) r27.a.a(VBoostCapabilityType.class, r100);
        }

        private VBoostCapabilityType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TEVBoostInterface() {
    }

    public static int cancelRequest(VBoostCapabilityType r100) {
        return 0;
    }

    public static Set<VBoostCapabilityType> getSupportCapabilities() {
        return null;
    }

    public static void init(Context r100) {
    }

    public static boolean isSupportCapability(VBoostCapabilityType r100) {
        return false;
    }

    public static void requestCpuBoost() {
    }

    public static void requestCpuBoostLong() {
    }

    public static void requestCpuLimit() {
    }

    public static void requestCpuLimitLong() {
    }

    public static int requestCustomBoost(VBoostCapabilityType r100, int r101, long r102) {
        return 0;
    }

    public static void restoreCpuBoost() {
    }

    public static void restoreCpuLimit() {
    }
}
