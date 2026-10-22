package com.douyin.janna.api;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum CapabilityType extends Enum<CapabilityType> {
    public static final CapabilityType APP_LONG_BOOST = null;
    public static final CapabilityType APP_SHORT_BOOST = null;
    public static final CapabilityType CANCEL_FPS = null;
    public static final CapabilityType DDR_BOOST = null;
    public static final CapabilityType GET_LOW_POWER_MODE = null;
    public static final CapabilityType GET_PHONE_TEMP = null;
    public static final CapabilityType GET_POWER_STATS = null;
    public static final CapabilityType GET_THERMAL_STATUS_INFO = null;
    public static final CapabilityType GPU_BOOST = null;
    public static final CapabilityType RECEIVE_PERFORMANCE_INFO = null;
    public static final CapabilityType RECEIVE_POWER_INFO = null;
    public static final CapabilityType RECEIVE_STABILITY_INFO = null;
    public static final CapabilityType RECEIVE_SYSTEM_INFO = null;
    public static final CapabilityType RECEIVE_THERMAL_STATUS_INFO = null;
    public static final CapabilityType SET_CPU_SCENE_INFO = null;
    public static final CapabilityType SET_FPS = null;
    public static final CapabilityType SET_IMPORTANT_THREAD = null;
    public static final CapabilityType SET_REFRESH_RATE = null;
    public static final CapabilityType TYPE_MAX = null;
    public static final CapabilityType TYPE_MIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CapabilityType[] f273565a = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private int f273566id;
    private String name;

    static {
        CapabilityType r100 = new CapabilityType("GET_PHONE_TEMP", 0, "get_phone_temp", 1);
        GET_PHONE_TEMP = r100;
        CapabilityType r101 = new CapabilityType("GET_THERMAL_STATUS_INFO", 1, "get_thermal_info", 2);
        GET_THERMAL_STATUS_INFO = r101;
        CapabilityType r102 = new CapabilityType("RECEIVE_THERMAL_STATUS_INFO", 2, "receive_thermal_info", 3);
        RECEIVE_THERMAL_STATUS_INFO = r102;
        CapabilityType r103 = new CapabilityType("RECEIVE_POWER_INFO", 3, "receive_power_info", 4);
        RECEIVE_POWER_INFO = r103;
        CapabilityType r104 = new CapabilityType("RECEIVE_PERFORMANCE_INFO", 4, "receive_performance_info", 5);
        RECEIVE_PERFORMANCE_INFO = r104;
        CapabilityType r105 = new CapabilityType("RECEIVE_SYSTEM_INFO", 5, "receive_system_info", 6);
        RECEIVE_SYSTEM_INFO = r105;
        CapabilityType r110 = new CapabilityType("RECEIVE_STABILITY_INFO", 6, "receive_stability_info", 7);
        RECEIVE_STABILITY_INFO = r110;
        CapabilityType r111 = new CapabilityType("SET_FPS", 7, "set_fps", 8);
        SET_FPS = r111;
        CapabilityType r112 = new CapabilityType("CANCEL_FPS", 8, "cancel_fps", 9);
        CANCEL_FPS = r112;
        CapabilityType r113 = new CapabilityType("SET_REFRESH_RATE", 9, "set_refresh_rate", 10);
        SET_REFRESH_RATE = r113;
        CapabilityType r114 = new CapabilityType("APP_SHORT_BOOST", 10, "app_short_boost", 11);
        APP_SHORT_BOOST = r114;
        CapabilityType r106 = new CapabilityType("APP_LONG_BOOST", 11, "app_long_boost", 12);
        APP_LONG_BOOST = r106;
        CapabilityType r107 = new CapabilityType("GPU_BOOST", 12, "gpu_boost", 13);
        GPU_BOOST = r107;
        CapabilityType r108 = new CapabilityType("DDR_BOOST", 13, "ddr_boost", 14);
        DDR_BOOST = r108;
        CapabilityType r109 = new CapabilityType("SET_IMPORTANT_THREAD", 14, "set_important_thread", 15);
        SET_IMPORTANT_THREAD = r109;
        CapabilityType r115 = new CapabilityType("GET_POWER_STATS", 15, "get_power_stats", 16);
        GET_POWER_STATS = r115;
        CapabilityType r116 = new CapabilityType("SET_CPU_SCENE_INFO", 16, "set_cpu_scene", 17);
        SET_CPU_SCENE_INFO = r116;
        CapabilityType r117 = new CapabilityType("GET_LOW_POWER_MODE", 17, "get_low_power_mode", 18);
        GET_LOW_POWER_MODE = r117;
        CapabilityType r118 = new CapabilityType("TYPE_MIN", 18, r100);
        TYPE_MIN = r118;
        CapabilityType r119 = new CapabilityType("TYPE_MAX", 19, r117);
        TYPE_MAX = r119;
        f273565a = new CapabilityType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119};
    }

    public static CapabilityType[] values() {
        return (CapabilityType[]) f273565a.clone();
    }

    public int getId() {
        return this.f273566id;
    }

    public String getName() {
        return this.name;
    }

    public static CapabilityType valueOf(String r100) {
        return (CapabilityType) a.a(CapabilityType.class, r100);
    }

    public CapabilityType(String r100, int r101, CapabilityType r102) {
        super(r100, r101);
        this.name = r102.name;
        this.f273566id = r102.f273566id;
    }

    public CapabilityType(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.name = r102;
        this.f273566id = r103;
    }
}
