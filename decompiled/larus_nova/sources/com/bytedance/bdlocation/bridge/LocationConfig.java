package com.bytedance.bdlocation.bridge;

/* JADX INFO: loaded from: classes10.dex */
public final class LocationConfig {
    public static final int SYSTEM_TYPE_ANDROID = 1;
    public static final int SYSTEM_TYPE_HARMONY_OS = 3;
    public static final int SYSTEM_TYPE_IOS = 2;
    public static final int SYSTEM_TYPE_UNKNOWN = 0;
    public static final int USER_MOTION_MODE_CYCLING = 2;
    public static final int USER_MOTION_MODE_DRIVING = 3;
    public static final int USER_MOTION_MODE_UNKNOWN = 0;
    public static final int USER_MOTION_MODE_WALKING = 1;
    public static final int WORK_MODE_CRUISE = 1;
    public static final int WORK_MODE_NAVIGATION = 2;
    public static final int WORK_MODE_NORMAL = 0;
    public final String deviceBrand;
    public final String deviceModel;
    public final boolean enableTrackUpload;
    public final String lifeId;
    public final int systemType;
    public final int trackIntervalSec;
    public final int userMotionMode;
    public final int workMode;

    public LocationConfig() {
        this(1, 0, true, 15, null, 0, null, null);
    }

    public LocationConfig(int r110, int r111, boolean r112, int r113) {
        this(r110, r111, r112, r113, null, 0, null, null);
    }

    public LocationConfig(int r110, int r111, boolean r112, int r113, String r114) {
        this(r110, r111, r112, r113, r114, 0, null, null);
    }

    public LocationConfig(int r110, int r111, boolean r112, int r113, String r114, int r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, null);
    }

    public LocationConfig(int r100, int r101, boolean r102, int r103, String r104, int r105, String r106, String r107) {
        this.workMode = r100;
        this.userMotionMode = r101;
        this.enableTrackUpload = r102;
        this.trackIntervalSec = r103;
        this.lifeId = r104;
        this.systemType = r105;
        this.deviceModel = r106;
        this.deviceBrand = r107;
    }
}
