package com.bytedance.crash.general;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.s;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RomInfo implements Serializable {
    private static final String FILE_NAME = "rom.inf";
    public static final String KEY_OS_TYPE = "os";
    private static final String KEY_ROM_HARMONY_OS = "is_hm_os";
    private static final String KEY_ROM_INCREMENTAL = "rom";
    public static final String KEY_ROM_KERNEL_VERSION = "kernel_version";
    public static final String KEY_ROM_OS_API = "os_api";
    public static final String KEY_ROM_OS_VERSION = "os_version";
    private static final String KEY_ROM_VERSION = "rom_version";
    private static final long serialVersionUID = 1;
    private boolean mIsHarmonyOs;
    private String mKernelVersion;
    private int mOsApiLevel;
    private String mOsVersion;
    private String mRandomDeviceId;
    private String mRomIncremental;
    private String mRomVersion;

    public RomInfo() {
    }

    public String getRandomDeviceId() {
        return this.mRandomDeviceId;
    }

    public static RomInfo get(File r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, FILE_NAME);
        if (c.f203206a == null) goto L5;
    L14:
        String r102 = c.f203206a.a();
        RomInfo r103 = (RomInfo) s.a(r101);     // Catch: Exception -> L17
    L18:
        if (r103 != null) goto L20;
    L21:
        r103 = new RomInfo();
        r103.mRomVersion = r102;
        String r104 = Build.VERSION.RELEASE;
        if (r104.contains(".") == true) goto L25;
        r104 = r104.concat(".0");
    L25:
        r103.mOsVersion = r104;
        c.a("ohos.utils.system.SystemCapability");     // Catch: Throwable -> L28
        boolean r105 = true;
    L29:
        r103.mIsHarmonyOs = r105;
        String r106 = System.getProperty("os.version");     // Catch: Throwable -> L32
    L33:
        r103.mKernelVersion = r106;
        String r107 = Build.VERSION.INCREMENTAL;
        if (r107 != null) goto L36;
        r107 = "unknown";
    L36:
        r103.mRomIncremental = r107;
        r103.mOsApiLevel = Build.VERSION.SDK_INT;
        String r108 = UUID.randomUUID().toString();     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r108) == true) goto L40;
    L41:
        r103.mRandomDeviceId = r108;
        s.b(r101, r103);
    L42:
        return r103;
    L40:
        r108 = "0000-1111-2222-3333-4444";
    L32:
        r106 = "unknown";
    L28:
        r105 = false;
        goto L29
    L20:
        if (r102.equals(String.valueOf(r103.mRomVersion)) == true) goto L42;
    L17:
        r103 = null;
        goto L18
    L5:
        monitor-enter(c.i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c.f203206a != null) goto L9;
        c.f203206a = c.c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.i.class);     // Catch: Throwable -> L11
        goto L14
    }

    public void putTo(JSONObject r100) {
        j.h(r100, "os", "Android");
        j.h(r100, "os_version", this.mOsVersion);
        j.h(r100, "os_api", Integer.valueOf(this.mOsApiLevel));
        j.h(r100, KEY_ROM_HARMONY_OS, Boolean.valueOf(this.mIsHarmonyOs));
        j.h(r100, KEY_ROM_KERNEL_VERSION, this.mKernelVersion);
        j.h(r100, KEY_ROM_INCREMENTAL, this.mRomIncremental);
        j.h(r100, "rom_version", this.mRomVersion);
    }
}
