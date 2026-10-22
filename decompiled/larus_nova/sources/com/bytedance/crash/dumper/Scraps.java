package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.crash.d0;
import com.bytedance.crash.util.s;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Scraps implements Serializable {
    public static final String BATTERY = "battery";
    private static final String FILE_NAME = "scraps.inf";
    public static final String INNER_FREE = "inner_free";
    private static final String INNER_FREE_REAL = "inner_free_realUnit";
    public static final String INNER_TOTAL = "inner_total";
    private static final String INNER_TOTAL_REAL = "inner_total_realUnit";
    public static final String INNER_UNIT = "unit";
    public static final String SDCARD_FREE = "sdcard_free";
    private static final String SDCARD_TOTAL = "sdcard_total";
    public static final String STORAGE = "storage";
    private static final long serialVersionUID = 1;
    private int mBatteryLevel;
    private boolean mIsMiniApp;
    private int mMiniAppId;
    private String mMiniAppVersion;
    private long mSdcardFreeSize;
    private long mSdcardTotalSize;
    private long mStorageFreeSize;
    private long mStorageTotalSize;

    public Scraps() {
    }

    private void dumpBattery() {
        if (bi4.d.f19132b == null) goto L5;
    L14:
        this.mBatteryLevel = bi4.d.f19132b.f19133a;
        return;
    L5:
        monitor-enter(bi4.d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (bi4.d.f19132b != null) goto L9;
        bi4.d.f19132b = new bi4.d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(bi4.d.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void dumpMiniApp() {
        if (d0.f203143a == false) goto L5;
        this.mIsMiniApp = true;
        this.mMiniAppId = d0.f203144b;
        this.mMiniAppVersion = d0.f203145c;
        return;
    L5:
        this.mIsMiniApp = false;
    }

    private void dumpStorage() {
        Context r100 = com.bytedance.crash.i.getContext();
        long r101 = 0;
        if (r100 != null) goto L39;
    L8:
        long r102 = 0;
    L9:
        this.mStorageTotalSize = r102;
        Context r103 = com.bytedance.crash.i.getContext();
        if (r103 != null) goto L35;
    L15:
        long r104 = 0;
    L16:
        this.mStorageFreeSize = r104;
        String r105 = Environment.getExternalStorageState();     // Catch: Throwable -> L19
    L21:
        if (TextUtils.equals(r105, "mounted") == true) goto L33;
        long r106 = 0;
    L27:
        long r107 = r101;
        r101 = r106;
    L28:
        Pair r108 = new Pair(Long.valueOf(r101), Long.valueOf(r107));
        this.mSdcardTotalSize = ((Long) r108.first).longValue();
        this.mSdcardFreeSize = ((Long) r108.second).longValue();
        return;
    L33:
        StatFs r109 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());     // Catch: Throwable -> L25
        r107 = r109.getAvailableBytes();     // Catch: Throwable -> L25
        r106 = r109.getBlockSizeLong() * r109.getBlockCountLong();
        r101 = r107;
    L25:
        r107 = 0;
    L19:
        r105 = null;
        goto L21
    L35:
        r104 = new StatFs(r103.getFilesDir().getPath()).getFreeBytes();     // Catch: Throwable -> L31
    L39:
        r102 = new StatFs(r100.getFilesDir().getPath()).getTotalBytes();     // Catch: Throwable -> L32
        goto L9
    }

    public static void dump(File r100) {
        Scraps r101 = new Scraps();
        r101.dumpMiniApp();
        r101.dumpStorage();
        r101.dumpBattery();
        s.b(new PolarisFileWrapper(r100, FILE_NAME), r101);
    }

    private void loadBattery(JSONObject r100) {
        r100.put(BATTERY, this.mBatteryLevel);     // Catch: Throwable -> L4
        return;
    }

    private void loadStorage(JSONObject r100) {
        JSONObject r101 = new JSONObject();
        r101.put(SDCARD_TOTAL, this.mSdcardTotalSize / 52428800);     // Catch: Throwable -> L5
        r101.put(SDCARD_FREE, this.mSdcardFreeSize / 52428800);     // Catch: Throwable -> L5
        r101.put(INNER_FREE, p.a(this.mStorageFreeSize));     // Catch: Throwable -> L5
        r101.put(INNER_TOTAL, p.a(this.mStorageTotalSize));     // Catch: Throwable -> L5
        r101.put(INNER_FREE_REAL, this.mStorageFreeSize / 52428800);     // Catch: Throwable -> L5
        r101.put(INNER_TOTAL_REAL, this.mStorageTotalSize / 52428800);     // Catch: Throwable -> L5
        r101.put(INNER_UNIT, ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE);     // Catch: Throwable -> L5
        r100.put("storage", r101);     // Catch: Throwable -> L5
        return;
    }

    public static void pushTo(JSONObject r100) {
        pushTo(r100, null);
    }

    public void loadMiniApp(JSONObject r100) {
        if (this.mIsMiniApp == false) goto L6;
        r100.put("is_mp", 1);     // Catch: Throwable -> L8
        r100.put("miniapp_id", this.mMiniAppId);     // Catch: Throwable -> L8
        r100.put("miniapp_version", this.mMiniAppVersion);     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        r100.put("miniapp_id", 0);     // Catch: Throwable -> L8
    }

    public static void pushTo(JSONObject r100, File r101) {
        if (r101 == null) goto L4;
        Scraps r102 = (Scraps) s.a(new PolarisFileWrapper(r101, FILE_NAME));
    L5:
        if (r102 != null) goto L7;
        r102 = new Scraps();
        r102.dumpMiniApp();
        r102.dumpStorage();
        r102.dumpBattery();
    L7:
        r102.loadMiniApp(r100);
        r102.loadStorage(r100);
        r102.loadBattery(r100);
        return;
    L4:
        r102 = null;
        goto L5
    }
}
