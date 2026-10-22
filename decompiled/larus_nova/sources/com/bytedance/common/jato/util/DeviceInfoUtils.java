package com.bytedance.common.jato.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceInfoUtils {
    private static final String VENDOR_VERSION = null;
    private static int sIsEmulator = -1;
    private static int sIsEmulatorTrans2Arm = -1;

    public static boolean isART() {
        String r100 = VENDOR_VERSION;     // Catch: Exception -> L13
        if (r100 != null) goto L6;
        return true;
    L6:
        if (r100.length() < 1) goto L17;
        if (CastIntegerProtector.parseInt(String.valueOf(r100.charAt(0))) >= 2) goto L18;
        return false;
    L18:
        return true;
    L17:
        return true;
    L19:
        return true;
    }

    static {
        VENDOR_VERSION = System.getProperty("java.vm.version", "");
    }

    public static synchronized boolean isEmulator() {
        monitor-enter(DeviceInfoUtils.class);
        int r100 = sIsEmulator;     // Catch: Throwable -> L24
        boolean r101 = true;
        if (r100 == (-1)) goto L28;
        if (r100 > 0) goto L10;
        r101 = false;
    L10:
        monitor-exit(DeviceInfoUtils.class);
        return r101;
    L28:
    L17:
        sIsEmulator = 0;     // Catch: Throwable -> L24
    L18:
        if (sIsEmulator > 0) goto L22;
        r101 = false;
    L22:
        monitor-exit(DeviceInfoUtils.class);
        return r101;
    L13:
        if (getSystemProperty("ro.kernel.qemu").equals("1") == false) goto L15;
        sIsEmulator = 1;     // Catch: Throwable -> L17
    L27:
    L15:
        sIsEmulator = 0;     // Catch: Throwable -> L17
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean isEmulatorTrans2Arm() {
        monitor-enter(DeviceInfoUtils.class);
        int r100 = sIsEmulatorTrans2Arm;     // Catch: Throwable -> L22
        boolean r101 = true;
        if (r100 == (-1)) goto L13;
        if (r100 > 0) goto L10;
        r101 = false;
    L10:
        monitor-exit(DeviceInfoUtils.class);
        return r101;
    L13:
        if (new PolarisFileWrapper("/system/lib/arm/nb/libc.so").exists() == false) goto L15;
        sIsEmulatorTrans2Arm = 1;     // Catch: Throwable -> L22
    L16:
        if (sIsEmulatorTrans2Arm > 0) goto L20;
        r101 = false;
    L20:
        monitor-exit(DeviceInfoUtils.class);
        return r101;
    L15:
        sIsEmulatorTrans2Arm = 0;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static int getPreviewVersion() {
        return CastIntegerProtector.parseInt(getSystemProperty("ro.build.version.preview_sdk"));
    L4:
        return 0;
    }

    public static synchronized String getSystemProperty(String r100) throws Exception {
        monitor-enter(DeviceInfoUtils.class);
        Class<?> r101 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L7
        String r102 = (String) r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});     // Catch: Throwable -> L7
        monitor-exit(DeviceInfoUtils.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }
}
