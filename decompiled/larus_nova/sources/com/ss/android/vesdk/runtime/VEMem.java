package com.ss.android.vesdk.runtime;

import android.os.Build;
import androidx.camera.video.AudioStats;
import com.ss.android.ttve.monitor.i;
import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class VEMem {
    public static final int ENTER_EDIT = 2;
    public static final int ENTER_PBULISH = 4;
    public static final int ENTER_RECORD = 0;
    public static final int LEAVE_EDIT = 3;
    public static final int LEAVE_PBULISH = 5;
    public static final int LEAVE_RECORD = 1;
    private static final String TAG = "VEMem";
    private static VEMem sInstance;
    private final int MEM_THRESHOLD;
    private boolean mEnableMemoryMode;
    private boolean mEnableUploadMemSize;
    private boolean mFirstTimeEnterRecord;
    private boolean mIsArm64v8a;
    private boolean mIsLocalTest;
    private int mLowMemThreshold;
    private int mTotalVirtualSize;

    private native String nativeGetRuntimeMemoryInfo();

    public static VEMem getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(VEMem.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new VEMem();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VEMem.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean inLowMemMode() {
        if (this.mEnableMemoryMode == true) goto L7;
        VELogUtil.i(TAG, "memory mode disabled");
        return false;
    L7:
        if (this.mIsArm64v8a == false) goto L10;
        VELogUtil.i(TAG, "cpu_abi is arm64-v8a, virtual mem info is unnecessary");
        return false;
    L10:
        double r100 = ((double) this.mTotalVirtualSize) - getVirtualMemSize();
        if (r100 >= this.mLowMemThreshold) goto L14;
        VELogUtil.w(TAG, "In low memory mode: free memory size = " + r100 + " threshold = " + this.mLowMemThreshold);
        return true;
    L14:
        return false;
    }

    static {
        TENativeLibsLoader.loadBase();
        sInstance = null;
    }

    private VEMem() {
        this.mIsLocalTest = false;
        this.mTotalVirtualSize = 4096;
        this.mEnableUploadMemSize = false;
        this.mEnableMemoryMode = false;
        this.MEM_THRESHOLD = 500;
        this.mIsArm64v8a = false;
        this.mLowMemThreshold = 300;
        this.mFirstTimeEnterRecord = true;
        TENativeLibsLoader.loadBase();
        this.mEnableUploadMemSize = VEConfigCenter.getInstance().getValue("ve_enable_upload_virtual_mem_size", false).booleanValue();
        this.mEnableMemoryMode = VEConfigCenter.getInstance().getValue("ve_enable_memory_mode", false).booleanValue();
        this.mLowMemThreshold = VEConfigCenter.getInstance().getValue("ve_low_memory_threshold", 300);
        boolean r100 = VEConfigCenter.getInstance().getValue("veabtest_fix_crash_opt", false).booleanValue();
        String r101 = Build.SUPPORTED_ABIS[0];
        if (r100 == true) goto L6;
        VELogUtil.i(TAG, "cpu_abi = " + r101);
    L6:
        if (r101.equals("armeabi-v7a") == false) goto L10;
        this.mTotalVirtualSize = 3072;
        if (r100 == true) goto L10;
        VELogUtil.i(TAG, "set mTotalVirtualSize to 3072MB");
    L10:
        this.mIsArm64v8a = VERuntime.isArm64();
    }

    public String getRuntimeMemoryInfo() {
        return nativeGetRuntimeMemoryInfo();
    }

    public double getVirtualMemSize() {
        return VERuntime.getVirtualMemInfo();
    }

    public boolean isArm64() {
        return this.mIsArm64v8a;
    }

    public void setIsLocalTest(boolean r100) {
        this.mIsLocalTest = r100;
    }

    public void uploadVirtualMemSize(int r110) {
        if (this.mEnableUploadMemSize == true) goto L7;
        VELogUtil.i(TAG, "upload mem size is disabled");
        return;
    L7:
        if (this.mIsArm64v8a == false) goto L10;
        VELogUtil.i(TAG, "cpu_abi is arm64-v8a, virtual mem info is unnecessary");
        return;
    L10:
        long r100 = System.currentTimeMillis();
        double r101 = getVirtualMemSize();
        long r102 = System.currentTimeMillis();
        VELogUtil.i(TAG, "get virtual mem size cost " + (r102 - r100) + "ms");
        if (r101 > AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        return;
    L13:
        if (r110 != 0) goto L15;
        String r111 = "te_record_enter_virtual_memory_size";
        i.e("te_record_enter_virtual_memory_size", r101);
    L31:
        VELogUtil.i(TAG, r111 + " virtual mem size " + r101 + "MB");
        long r103 = System.currentTimeMillis();
        StringBuilder r112 = new StringBuilder("upload virtual mem size cost ");
        r112.append(r103 - r102);
        VELogUtil.i(TAG, r112.toString());
        return;
    L15:
        if (r110 != 1) goto L17;
        r111 = "te_record_leave_virtual_memory_size";
        i.e("te_record_leave_virtual_memory_size", r101);
        goto L31
    L17:
        if (r110 != 2) goto L19;
        r111 = "te_edit_enter_virtual_memory_size";
        i.e("te_edit_enter_virtual_memory_size", r101);
        goto L31
    L19:
        if (r110 != 3) goto L21;
        r111 = "te_edit_leave_virtual_memory_size";
        i.e("te_edit_leave_virtual_memory_size", r101);
        goto L31
    L21:
        if (r110 != 4) goto L23;
        r111 = "te_composition_enter_virtual_memory_size";
        i.e("te_composition_enter_virtual_memory_size", r101);
        goto L31
    L23:
        if (r110 == 5) goto L25;
        r111 = "";
        goto L31
    L25:
        r111 = "te_composition_leave_virtual_memory_size";
        i.e("te_composition_leave_virtual_memory_size", r101);
        goto L31
    }
}
