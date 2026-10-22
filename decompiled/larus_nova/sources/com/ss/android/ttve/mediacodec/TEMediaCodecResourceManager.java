package com.ss.android.ttve.mediacodec;

import android.os.Build;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TEMediaCodecResourceManager {
    private static final String TAG = "TEMediaCodecResourceManager";
    public static volatile boolean sExistHWEncoder;
    public static volatile boolean sHWEncoderStateIsBeforeRunning;
    private static int sMaxCodecBlocksSize;
    private static List<Integer> sMediaCodecInstance;
    private static int sSafeLimitSize;
    private static int sUsedCodecBlocksSize;

    public TEMediaCodecResourceManager() {
    }

    static {
        sMediaCodecInstance = new ArrayList();
        sSafeLimitSize = 2304000;
        sHWEncoderStateIsBeforeRunning = false;
        sExistHWEncoder = false;
    }

    public static int getReuseDecoderType() {
        if (Build.MODEL.toLowerCase().contains("nth-an00") == false) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static synchronized int getUsedCodecBlocksSize() {
        monitor-enter(TEMediaCodecResourceManager.class);
        int r100 = sUsedCodecBlocksSize;     // Catch: Throwable -> L7
        monitor-exit(TEMediaCodecResourceManager.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void resetCodecBlocksSize() {
        monitor-enter(TEMediaCodecResourceManager.class);
        sUsedCodecBlocksSize = 0;     // Catch: Throwable -> L8
        sMaxCodecBlocksSize = 0;     // Catch: Throwable -> L8
        sMediaCodecInstance.clear();     // Catch: Throwable -> L8
        VELogUtil.d(TAG, "resetCodecBlocksSize");     // Catch: Throwable -> L8
        monitor-exit(TEMediaCodecResourceManager.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static int getAvailableCodecSize() {
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == false) goto L9;
        int r100 = getMaxCodecBlocksSize();
        if (r100 > 0) goto L8;
        return -1;
    L8:
        return r100 - sUsedCodecBlocksSize;
    L9:
        return -1;
    }

    public static synchronized int getMaxCodecBlocksSize() {
        monitor-enter(TEMediaCodecResourceManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMaxCodecBlocksSize != 0) goto L7;
        sMaxCodecBlocksSize = TEMediaCodecDecoder.getMaxBlocksSizePerSecond();     // Catch: Throwable -> L10
        VELogUtil.i(TAG, "sMaxCodecBlocksSize: " + sMaxCodecBlocksSize);     // Catch: Throwable -> L10
    L7:
        int r100 = sMaxCodecBlocksSize;     // Catch: Throwable -> L10
        monitor-exit(TEMediaCodecResourceManager.class);
        return r100;
    }

    public static synchronized int canUseHardwareDecoder(int r100) {
        monitor-enter(TEMediaCodecResourceManager.class);
        int r101 = 0;
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == true) goto L7;
        monitor-exit(TEMediaCodecResourceManager.class);
        return -1;
    L7:
        if (sMaxCodecBlocksSize != 0) goto L9;
        sMaxCodecBlocksSize = TEMediaCodecDecoder.getMaxBlocksSizePerSecond();     // Catch: Throwable -> L22
        VELogUtil.i(TAG, "sMaxCodecBlocksSize: " + sMaxCodecBlocksSize);     // Catch: Throwable -> L22
    L9:
        int r102 = sMaxCodecBlocksSize;     // Catch: Throwable -> L22
        if (r102 > 0) goto L14;
        monitor-exit(TEMediaCodecResourceManager.class);
        return -1;
    L14:
        if ((sUsedCodecBlocksSize + r100) > r102) goto L16;
        r101 = 1;
    L16:
        if (r101 != 0) goto L18;
        VELogUtil.w(TAG, "can't use hw decoder, sMaxCodecBlocksSize:" + sMaxCodecBlocksSize + ", sUsedCodecBlocksSize:" + sUsedCodecBlocksSize + ", blocksSize:" + r100);     // Catch: Throwable -> L22
    L18:
        monitor-exit(TEMediaCodecResourceManager.class);
        return r101;
    L22:
        th = move-exception;
        throw th;
    }

    public static synchronized void freeCodecBlocksSize(int r100, int r101) {
        monitor-enter(TEMediaCodecResourceManager.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sMediaCodecInstance.contains(Integer.valueOf(r101)) == true) goto L8;
        monitor-exit(TEMediaCodecResourceManager.class);
        return;
    L8:
        sUsedCodecBlocksSize -= r100;     // Catch: Throwable -> L13
        sMediaCodecInstance.remove(Integer.valueOf(r101));     // Catch: Throwable -> L13
        VELogUtil.d(TAG, "freeCodecBlocksSize blocksSize: " + r100 + ", sUsedCodecBlocksSize: " + sUsedCodecBlocksSize + ", " + r101);     // Catch: Throwable -> L13
        if (sUsedCodecBlocksSize >= 0) goto L11;
        VELogUtil.w(TAG, "freeCodecBlocksSize sUsedCodecBlocksSize < 0");     // Catch: Throwable -> L13
        sUsedCodecBlocksSize = 0;     // Catch: Throwable -> L13
    L11:
        monitor-exit(TEMediaCodecResourceManager.class);
    }

    public static synchronized boolean tryUseCodecBlocksSize(int r100, int r101) {
        monitor-enter(TEMediaCodecResourceManager.class);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (sMaxCodecBlocksSize != 0) goto L9;
        sMaxCodecBlocksSize = TEMediaCodecDecoder.getMaxBlocksSizePerSecond();     // Catch: Throwable -> L26
        VELogUtil.i(TAG, "sMaxCodecBlocksSize: " + sMaxCodecBlocksSize);     // Catch: Throwable -> L26
    L9:
        if (sMaxCodecBlocksSize != (-1)) goto L13;
        monitor-exit(TEMediaCodecResourceManager.class);
        return true;
    L13:
        if (sMediaCodecInstance.contains(Integer.valueOf(r101)) == false) goto L16;
        monitor-exit(TEMediaCodecResourceManager.class);
        return true;
    L16:
        int r102 = sUsedCodecBlocksSize;     // Catch: Throwable -> L26
        if ((r102 + r100) <= sMaxCodecBlocksSize) goto L23;
        VELogUtil.w(TAG, "sUsedCodecBlocksSize + blocksSize > sMaxCodecBlocksSize, sUsedCodecBlocksSize: " + sUsedCodecBlocksSize + ", blocksSize:" + r100);     // Catch: Throwable -> L26
        monitor-exit(TEMediaCodecResourceManager.class);
        return false;
    L23:
        sUsedCodecBlocksSize = r102 + r100;     // Catch: Throwable -> L26
        sMediaCodecInstance.add(Integer.valueOf(r101));     // Catch: Throwable -> L26
        VELogUtil.d(TAG, "tryUseCodecBlocksSize success blocksSize: " + r100 + ", sUsedCodecBlocksSize: " + sUsedCodecBlocksSize + ", " + r101);     // Catch: Throwable -> L26
        monitor-exit(TEMediaCodecResourceManager.class);
        return true;
    }

    public static synchronized boolean checkCanFastImport(int r100, int r110, int r111) {
        monitor-enter(TEMediaCodecResourceManager.class);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (sMaxCodecBlocksSize != 0) goto L7;
        sMaxCodecBlocksSize = TEMediaCodecDecoder.getMaxBlocksSizePerSecond();     // Catch: Throwable -> L28
        VELogUtil.i(TAG, "sMaxCodecBlocksSize: " + sMaxCodecBlocksSize);     // Catch: Throwable -> L28
    L7:
        int r101 = sMaxCodecBlocksSize;     // Catch: Throwable -> L28
        if (r101 != (-1)) goto L12;
        monitor-exit(TEMediaCodecResourceManager.class);
        return true;
    L12:
        int r102 = sUsedCodecBlocksSize;     // Catch: Throwable -> L28
        int r103 = (r100 * r110) * r111;     // Catch: Throwable -> L28
        if ((r102 + r103) <= r101) goto L17;
        VELogUtil.d(TAG, "checkCanFastImport is false, sUsedCodecBlocksSize: " + sUsedCodecBlocksSize + ", width: " + r100 + ", height: " + r110 + ", fps: " + r111);     // Catch: Throwable -> L28
        monitor-exit(TEMediaCodecResourceManager.class);
        return false;
    L17:
        if (r102 <= 0) goto L25;
        int r104 = sSafeLimitSize;     // Catch: Throwable -> L28
        if ((r101 - r104) <= 0) goto L25;
        if ((r102 + r103) <= (r101 - r104)) goto L25;
        VELogUtil.d(TAG, "checkCanFastImport is false, sUsedCodecBlocksSize: " + sUsedCodecBlocksSize + ", width: " + r100 + ", height: " + r110 + ", fps: " + r111);     // Catch: Throwable -> L28
        monitor-exit(TEMediaCodecResourceManager.class);
        return false;
    L25:
        VELogUtil.d(TAG, "checkCanFastImport is true");     // Catch: Throwable -> L28
        monitor-exit(TEMediaCodecResourceManager.class);
        return true;
    }
}
