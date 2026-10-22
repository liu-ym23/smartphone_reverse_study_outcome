package com.huawei.hms.framework.common;

import com.huawei.android.os.BuildEx;
import com.huawei.hms.android.SystemUtils;

/* JADX INFO: loaded from: classes23.dex */
public class EmuiUtil {
    private static final String ANDROID_SYSTEM_PROP = "android.os.SystemProperties";
    private static final String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
    public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    private static final int EMUI_3_0 = 7;
    private static final int EMUI_3_1 = 8;
    private static final int EMUI_4_0 = 9;
    private static final int EMUI_4_1 = 10;
    private static final int EMUI_5_0 = 11;
    private static final int EMUI_6_0 = 14;
    private static final int EMUI_8_0_1 = 15;
    private static final int EMUI_9_0 = 17;
    public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
    private static final int EMUI_TYPE_UNKOWN = -1;
    public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
    private static final String PRODUCT_MANUFACTURER = "ro.product.manufacturer";
    private static final String PROPERTY_GET = "get";
    private static final String TAG = "KPMS_Util_Emui";
    private static final int TYPE_EMUI_30 = 30;
    private static final int TYPE_EMUI_31 = 31;
    private static final int TYPE_EMUI_40 = 40;
    private static final int TYPE_EMUI_41 = 41;
    private static final int TYPE_EMUI_50 = 50;
    private static final int TYPE_EMUI_60 = 60;
    private static final int TYPE_EMUI_801 = 81;
    private static final int TYPE_EMUI_90 = 90;
    private static int emuiType = -1;
    private static boolean isHuaweiDevice;

    public EmuiUtil() {
    }

    public static boolean isEMUI() {
        if ((-1) == emuiType) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getEMUIVersionCode() {
        Object r100 = ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
        if (r100 != null) goto L11;
    L8:
        int r101 = 0;
    L9:
        Logger.d(TAG, "the emui version code is::" + r101);
        return r101;
    L11:
        r101 = ((Integer) r100).intValue();     // Catch: ClassCastException -> L6
    L6:
        e = move-exception;
        Logger.e(TAG, "getEMUIVersionCode ClassCastException:", e);
        goto L8
    }

    private static void initHuaweiDevice() {
        String r100 = SystemPropUtils.getProperty("get", "ro.product.manufacturer", ANDROID_SYSTEM_PROP, "");
        if (SystemUtils.PRODUCT_HUAWEI.equalsIgnoreCase(r100) == false) goto L5;
        isHuaweiDevice = true;
    L5:
        Logger.i(TAG, "Get Manufacturer: " + r100 + ", isHuaweiDevice : " + isHuaweiDevice);
    }

    public static boolean isUpPVersion() {
    L13:
        Logger.d(TAG, "no such method for com.huawei.android.os.BuildEx.VERSION");
    L14:
        Logger.d(TAG, "com.huawei.android.os.BuildEx : false");
        return false;
    L12:
        Logger.d(TAG, "com.huawei.android.os.BuildEx.VERSION has other exception");
        goto L14
    L4:
        if (ReflectionUtils.checkCompatible(BUILDEX_NAME) == false) goto L14;
        if (ReflectionUtils.checkCompatible(BUILDEX_VERSION) == false) goto L14;
    L9:
        if (BuildEx.VERSION.EMUI_SDK_INT < 17) goto L18;
        return true;
    L18:
        return false;
    }

    static {
        initEmuiType();
        initHuaweiDevice();
    }

    private static void initEmuiType() {
        int r100 = getEMUIVersionCode();
        Logger.d(TAG, "getEmuiType emuiVersionCode=" + r100);
        if (r100 < 17) goto L6;
        emuiType = 90;
    L27:
        if (emuiType != (-1)) goto L30;
        Logger.i(TAG, "emuiType is unkown");
        return;
    L30:
        return;
    L6:
        if (r100 < 15) goto L9;
        emuiType = 81;
        goto L27
    L9:
        if (r100 < 14) goto L12;
        emuiType = 60;
        goto L27
    L12:
        if (r100 < 11) goto L15;
        emuiType = 50;
        goto L27
    L15:
        if (r100 < 10) goto L18;
        emuiType = 41;
        goto L27
    L18:
        if (r100 < 9) goto L21;
        emuiType = 40;
        goto L27
    L21:
        if (r100 < 8) goto L24;
        emuiType = 31;
        goto L27
    L24:
        if (r100 < 7) goto L27;
        emuiType = 30;
        goto L27
    }

    public static boolean isHuaweiDevice() {
        return isHuaweiDevice;
    }
}
