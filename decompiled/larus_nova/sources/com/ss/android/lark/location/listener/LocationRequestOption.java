package com.ss.android.lark.location.listener;

import com.ss.android.lark.location.dto.LarkLocation;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
public final class LocationRequestOption {

    public static final enum LocationPriority extends Enum<LocationPriority> {
        public static final LocationPriority DEVICE_SENSORS = null;
        public static final LocationPriority PRIORITY_BALANCED_POWER_ACCURACY = null;
        public static final LocationPriority PRIORITY_HIGH_ACCURACY = null;
        public static final LocationPriority PRIORITY_LOW_POWER = null;
        public static final LocationPriority PRIORITY_NO_POWER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LocationPriority[] f431189a = null;

        static {
            LocationPriority r100 = new LocationPriority("PRIORITY_HIGH_ACCURACY", 0);
            PRIORITY_HIGH_ACCURACY = r100;
            LocationPriority r101 = new LocationPriority("PRIORITY_BALANCED_POWER_ACCURACY", 1);
            PRIORITY_BALANCED_POWER_ACCURACY = r101;
            LocationPriority r102 = new LocationPriority("PRIORITY_LOW_POWER", 2);
            PRIORITY_LOW_POWER = r102;
            LocationPriority r103 = new LocationPriority("PRIORITY_NO_POWER", 3);
            PRIORITY_NO_POWER = r103;
            LocationPriority r104 = new LocationPriority("DEVICE_SENSORS", 4);
            DEVICE_SENSORS = r104;
            f431189a = new LocationPriority[]{r100, r101, r102, r103, r104};
        }

        public static LocationPriority[] values() {
            return (LocationPriority[]) f431189a.clone();
        }

        public static LocationPriority valueOf(String r100) {
            return (LocationPriority) a.a(LocationPriority.class, r100);
        }

        public LocationPriority(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LocationRequestOption() {
        LarkLocation.CoordinateSystem r100 = LarkLocation.CoordinateSystem.DEFAULT;
        LocationPriority r101 = LocationPriority.PRIORITY_HIGH_ACCURACY;
    }
}
