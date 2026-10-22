package com.ss.bytertc.engine.device;

import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum DeviceError extends Enum<DeviceError> {
    private static final /* synthetic */ DeviceError[] $VALUES = null;
    public static final DeviceError AUDIO_DEVICE_OCCUPIED = null;
    public static final DeviceError AUDIO_DEVICE_PERMISSION = null;
    public static final DeviceError AUDIO_DEVICE_REMOVED = null;
    public static final DeviceError AUDIO_DEVICE_UNKNOWN_ERROR = null;
    public static final DeviceError AUDIO_PARAM_NOSUPPORT = null;
    public static final DeviceError DEVICE_NO_ERROR = null;
    public static final DeviceError DEVICE_UNKNOWN = null;
    public static final DeviceError NO_AUDIO_DEVICE = null;
    public static final DeviceError NO_VIDEO_DEVICE = null;
    public static final DeviceError VIDEO_DEVICE_OCCUPIED = null;
    public static final DeviceError VIDEO_DEVICE_PERMISSION = null;
    public static final DeviceError VIDEO_DEVICE_REMOVED = null;
    public static final DeviceError VIDEO_DEVICE_UNKNOWN_ERROR = null;
    static Map<Integer, DeviceError> hash;
    int errorCode;

    static {
        DeviceError r100 = new DeviceError("DEVICE_NO_ERROR", 0, 0);
        DEVICE_NO_ERROR = r100;
        DeviceError r101 = new DeviceError("NO_VIDEO_DEVICE", 1, 1);
        NO_VIDEO_DEVICE = r101;
        DeviceError r102 = new DeviceError("NO_AUDIO_DEVICE", 2, 2);
        NO_AUDIO_DEVICE = r102;
        DeviceError r103 = new DeviceError("AUDIO_DEVICE_REMOVED", 3, 3);
        AUDIO_DEVICE_REMOVED = r103;
        DeviceError r104 = new DeviceError("VIDEO_DEVICE_REMOVED", 4, 4);
        VIDEO_DEVICE_REMOVED = r104;
        DeviceError r105 = new DeviceError("AUDIO_PARAM_NOSUPPORT", 5, 5);
        AUDIO_PARAM_NOSUPPORT = r105;
        DeviceError r110 = new DeviceError("VIDEO_DEVICE_PERMISSION", 6, 6);
        VIDEO_DEVICE_PERMISSION = r110;
        DeviceError r111 = new DeviceError("AUDIO_DEVICE_PERMISSION", 7, 7);
        AUDIO_DEVICE_PERMISSION = r111;
        DeviceError r112 = new DeviceError("VIDEO_DEVICE_OCCUPIED", 8, 8);
        VIDEO_DEVICE_OCCUPIED = r112;
        DeviceError r113 = new DeviceError("AUDIO_DEVICE_OCCUPIED", 9, 9);
        AUDIO_DEVICE_OCCUPIED = r113;
        DeviceError r114 = new DeviceError("VIDEO_DEVICE_UNKNOWN_ERROR", 10, 10);
        VIDEO_DEVICE_UNKNOWN_ERROR = r114;
        DeviceError r115 = new DeviceError("AUDIO_DEVICE_UNKNOWN_ERROR", 11, 11);
        AUDIO_DEVICE_UNKNOWN_ERROR = r115;
        DeviceError r106 = new DeviceError("DEVICE_UNKNOWN", 12, 1000000);
        DEVICE_UNKNOWN = r106;
        $VALUES = new DeviceError[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        hash = new HashMap();
    }

    public static DeviceError[] values() {
        return (DeviceError[]) $VALUES.clone();
    }

    public int getId() {
        return this.errorCode;
    }

    public static DeviceError get(int r100) {
        if (hash.size() != 0) goto L8;
        DeviceError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        DeviceError r104 = r101[r103];
        hash.put(Integer.valueOf(r104.errorCode), r104);
        r103 = r103 + 1;
    L8:
        if (hash.containsKey(Integer.valueOf(r100)) == false) goto L12;
        return hash.get(Integer.valueOf(r100));
    L12:
        return DEVICE_UNKNOWN;
    }

    public static DeviceError valueOf(String r100) {
        return (DeviceError) a.a(DeviceError.class, r100);
    }

    private DeviceError(String r100, int r101, int r102) {
        super(r100, r101);
        this.errorCode = r102;
    }
}
