package com.bytedance.crash.general;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.crash.i;
import com.bytedance.crash.util.g;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.s;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.utils.FileUtil;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class HardwareInfo implements Serializable {
    private static final String FILE_NAME = "hardware.inf";
    public static final String KEY_HW_CPU_ABI = "cpu_abi";
    public static final String KEY_HW_CPU_HARDWARE = "hardware";
    public static final String KEY_HW_CPU_MODEL = "cpu_model";
    public static final String KEY_HW_DENSITY_DPI = "density_dpi";
    public static final String KEY_HW_DISPLAY_DENSITY = "display_density";
    public static final String KEY_HW_DISPLAY_RESOLUTION = "resolution";
    public static final String KEY_HW_RAM_SIZE = "ram_size";
    public static final String KEY_HW_VENDOR_BRAND = "device_brand";
    public static final String KEY_HW_VENDOR_MANUFACTURER = "device_manufacturer";
    public static final String KEY_HW_VENDOR_MODEL = "device_model";
    private static final long serialVersionUID = 20241001154124L;
    private String mCpuAbi;
    private String mCpuHardware;
    private String mCpuModel;
    private String mDisplayDensity;
    private int mDisplayDensityDpi;
    private String mDisplayResolution;
    private long mJiffies;
    private String mRamSize;
    private String mVendorBrand;
    private String mVendorManufacturer;
    private String mVendorModel;

    public HardwareInfo() {
    }

    public long getJiffy() {
        return this.mJiffies;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_bytedance_crash_general_HardwareInfo_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void putTo(JSONObject r100) {
        j.h(r100, "device_brand", this.mVendorBrand);
        j.h(r100, "device_model", this.mVendorModel);
        j.h(r100, "device_manufacturer", this.mVendorManufacturer);
        j.h(r100, KEY_HW_DENSITY_DPI, Integer.valueOf(this.mDisplayDensityDpi));
        j.h(r100, "resolution", this.mDisplayResolution);
        j.h(r100, KEY_HW_DISPLAY_DENSITY, this.mDisplayDensity);
        j.h(r100, KEY_HW_CPU_ABI, this.mCpuAbi);
        j.h(r100, KEY_HW_CPU_HARDWARE, this.mCpuHardware);
        j.h(r100, KEY_HW_CPU_MODEL, this.mCpuModel);
        j.h(r100, KEY_HW_RAM_SIZE, this.mRamSize);
    }

    public static HardwareInfo get(Context r310, File r311) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r311, FILE_NAME);
        PolarisFileReaderWrapper r101 = null;
        BufferedReader r102 = null;
        BufferedReader r103 = null;
        HardwareInfo r104 = (HardwareInfo) s.a(r100);     // Catch: Exception -> L5
    L6:
        if (r104 != null) goto L109;
        r104 = new HardwareInfo();
        String r105 = Build.BRAND;
        String r106 = Build.MODEL;
        String r107 = "unknown";
        if (TextUtils.isEmpty(r106) == false) goto L12;
        if (r105 != null) goto L11;
        r106 = "unknown";
    L16:
        r104.mVendorModel = r106;
        if (TextUtils.isEmpty(r105) == false) goto L19;
        r105 = "unknown";
    L19:
        r104.mVendorBrand = r105;
        String r108 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r108) == false) goto L22;
        r108 = "unknown";
    L22:
        r104.mVendorManufacturer = r108;
        long r109 = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (r109 > 0) goto L26;
        r109 = 100;
    L26:
        r104.mJiffies = 1000 / r109;
        r104.mCpuAbi = b.a();
        int r110 = 0;
        PolarisFileReaderWrapper r111 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L49 IOException -> L56
        BufferedReader r112 = new BufferedReader(r111);     // Catch: Throwable -> L46 IOException -> L48
    L128:
        String r113 = r112.readLine();     // Catch: Throwable -> L43 IOException -> L45
        if (r113 == null) goto L41;
        if (r113.contains(":") == false) goto L128;
        String[] r114 = r113.split(":");     // Catch: Throwable -> L43 IOException -> L45
        if (r114[0].contains("Hardware") == true) goto L37;
        if (r114[0].contains("model name") == false) goto L128;
    L37:
        String r115 = r114[1];     // Catch: Throwable -> L43 IOException -> L45
        r111.close();     // Catch: IOException -> L40
        r112.close();     // Catch: IOException -> L40
    L65:
        r104.mCpuModel = r115;
        String r116 = Build.HARDWARE;
        if (TextUtils.isEmpty(r116) == true) goto L69;
        r107 = r116;
    L69:
        r104.mCpuHardware = r107;
        DisplayMetrics r117 = INVOKEVIRTUAL_com_bytedance_crash_general_HardwareInfo_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r310.getResources());
        if (r117 == null) goto L119;
        r104.mDisplayResolution = r117.heightPixels + "x" + r117.widthPixels;
        int r118 = r117.densityDpi;
        if (r118 != 120) goto L74;
        String r119 = "ldpi";
    L81:
        r104.mDisplayDensity = r119;
        r104.mDisplayDensityDpi = r118;
        goto L119
    L74:
        if (r118 != 240) goto L76;
        r119 = "hdpi";
        goto L81
    L76:
        if (r118 == 320) goto L78;
        r119 = "mdpi";
        goto L81
    L78:
        r119 = "xhdpi";
    L119:
        BufferedReader r120 = new BufferedReader(new PolarisFileReaderWrapper("/proc/meminfo"));     // Catch: Throwable -> L111
        String r121 = r120.readLine();     // Catch: Throwable -> L110
        if (r121 == null) goto L90;
        if (r121.startsWith("MemTotal:") == false) goto L90;
        long r122 = Long.parseLong(r121.substring(9).trim().split(" ")[0]) * 1024;
        g.a(r120);
    L93:
        if (r122 != 0) goto L99;
        Context r123 = i.getContext();
        if (r123 == null) goto L97;
        ActivityManager r124 = (ActivityManager) r123.getSystemService("activity");
        ActivityManager.MemoryInfo r125 = new ActivityManager.MemoryInfo();
        r124.getMemoryInfo(r125);
        r122 = r125.totalMem;
        goto L99
    L97:
        r122 = 0;
    L99:
        if (r122 > 0) goto L101;
        String r126 = "Invalid";
    L108:
        r104.mRamSize = r126;
        s.b(r100, r104);
        goto L109
    L101:
        long[] r127 = {256, 512, 1024, 2048, 3072, 4096, 5120, 6144, PlaybackStateCompat.ACTION_PLAY_FROM_URI, FileUtil.LOCAL_REPORT_FILE_MAX_SIZE, 12288, 16384, 24576, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, 49152, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576};
        String[] r128 = {"256MB", "512MB", "1GB", "2GB", "3GB", "4GB", "5GB", "6GB", "8GB", "10GB", "12GB", "16GB", "24GB", "32GB", "48GB", "64GB", "128GB", "256GB", "512GB", "1TB"};
    L102:
        if (r110 >= 20) goto L107;
        if (r122 < ((r127[r110] * 1024) * 1024)) goto L105;
        r110 = r110 + 1;
        goto L102
    L105:
        r126 = r128[r110];
        goto L108
    L107:
        r126 = "1TB+";
    L90:
        r103 = r120;
    L91:
        g.a(r103);
        r122 = 0;
        goto L93
        goto L57
    L41:
        r111.close();     // Catch: IOException -> L59
    L61:
        r112.close();     // Catch: IOException -> L59
    L43:
        th = th;
        r102 = r112;
    L47:
        BufferedReader r129 = r102;
        r101 = r111;
    L51:
        if (r101 != null) goto L115;
    L53:
        if (r129 == null) goto L55;
        r129.close();     // Catch: IOException -> L112
    L55:
        throw th;
    L115:
        r101.close();     // Catch: IOException -> L112
    L57:
        if (r111 == null) goto L60;
        r111.close();     // Catch: IOException -> L59
    L60:
        if (r112 == null) goto L62;
    L48:
        r112 = null;
    L46:
        th = th;
        goto L47
    L56:
        r111 = null;
        r112 = null;
    L49:
        th = th;
        r129 = null;
    L62:
        r115 = Build.BOARD;
        if (r115 != null) goto L65;
        r115 = "unknown";
        goto L65
    L11:
        r106 = r105;
        goto L16
    L12:
        if (r105 == null) goto L16;
        if (r106.contains(r105) == true) goto L16;
        r106 = r105 + ' ' + r106;
    L109:
        return r104;
    L5:
        r104 = null;
        goto L6
    }
}
