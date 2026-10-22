package com.bytedance.bdinstall.util;

import com.bytedance.android.live.uikit.util.RTLUtil;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum DeviceCategory extends Enum<DeviceCategory> {
    public static final DeviceCategory AR = null;
    public static final DeviceCategory CAR = null;
    public static final DeviceCategory PAD = null;
    public static final DeviceCategory PHONE = null;
    public static final DeviceCategory TV = null;
    public static final DeviceCategory VR = null;
    public static final DeviceCategory WATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeviceCategory[] f199796a = null;
    private String lower;

    static {
        DeviceCategory r100 = new DeviceCategory("PHONE", 0, "phone");
        PHONE = r100;
        DeviceCategory r101 = new DeviceCategory("PAD", 1, CommonCmd.AIDL_PLATFORM_TYPE_PAD);
        PAD = r101;
        DeviceCategory r102 = new DeviceCategory("TV", 2, CommonCmd.AIDL_PLATFORM_TYPE_TV);
        TV = r102;
        DeviceCategory r103 = new DeviceCategory("CAR", 3, CommonCmd.AIDL_PLATFORM_TYPE_CAR);
        CAR = r103;
        DeviceCategory r104 = new DeviceCategory("VR", 4, "vr");
        VR = r104;
        DeviceCategory r105 = new DeviceCategory("AR", 5, RTLUtil.ARABIA_LANG);
        AR = r105;
        DeviceCategory r110 = new DeviceCategory("WATCH", 6, "watch");
        WATCH = r110;
        f199796a = new DeviceCategory[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static DeviceCategory[] values() {
        return (DeviceCategory[]) f199796a.clone();
    }

    public String getLower() {
        return this.lower;
    }

    public static DeviceCategory valueOf(String r100) {
        return (DeviceCategory) a.a(DeviceCategory.class, r100);
    }

    public DeviceCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.lower = r102;
    }
}
