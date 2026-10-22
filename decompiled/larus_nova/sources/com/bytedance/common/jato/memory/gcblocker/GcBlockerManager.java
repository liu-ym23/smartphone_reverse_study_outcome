package com.bytedance.common.jato.memory.gcblocker;

import android.os.Build;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.JatoXL;
import com.bytedance.common.jato.JatoXLConfig;
import com.bytedance.common.jato.util.DeviceInfoUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;

/* JADX INFO: loaded from: classes3.dex */
public class GcBlockerManager {
    private static volatile AbsGcBlocker sGcBlocker;

    /* JADX INFO: renamed from: com.bytedance.common.jato.memory.gcblocker.GcBlockerManager$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static class VoidGcBlocker extends AbsGcBlocker {
        @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
        public void requestBlockGc(long r100) {
        }

        @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
        public void setHeapLimit(boolean r100, int r101, int r102) {
        }

        @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
        public void setMaxGcBlockDuration(int r100) {
        }

        @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
        public void startBlockGc(String r100) {
        }

        @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
        public void stopBlockGc(String r100) {
        }

        private VoidGcBlocker() {
        }

        public /* synthetic */ VoidGcBlocker(AnonymousClass1 r100) {
            this();
        }
    }

    public GcBlockerManager() {
    }

    public static AbsGcBlocker getInstance() {
        if (sGcBlocker != null) goto L29;
        monitor-enter(GcBlockerManager.class);
    L25:
        th = move-exception;
        throw th;
    L7:
        if (sGcBlocker != null) goto L23;
        AnonymousClass1 r100 = null;
        if (isEnabled() == true) goto L12;
        sGcBlocker = new VoidGcBlocker(r100);     // Catch: Throwable -> L25
        goto L23
    L12:
        if (JatoNativeLoader.loadLibrary() == true) goto L15;
        sGcBlocker = new VoidGcBlocker(r100);     // Catch: Throwable -> L25
        goto L23
    L15:
        if (JatoXL.getConfig().isEnabledDalvikGcBlocker() == false) goto L18;
        DeviceInfoUtils.isART();     // Catch: Throwable -> L25
    L18:
        if (JatoXL.getConfig().isEnabledArtGcBlocker() == true) goto L20;
    L22:
        sGcBlocker = new VoidGcBlocker(r100);     // Catch: Throwable -> L25
        goto L23
    L20:
        if (Build.VERSION.SDK_INT < 24) goto L22;
        JatoXLConfig r101 = JatoXL.getConfig();     // Catch: Throwable -> L25
        sGcBlocker = new GcBlocker(r101.getMaxGcBlockTimeout(), r101.isLargeHeapApp(), r101.getMaxHeapSize(), r101.getGcHeapLimit(), r101.getIsSupportApex());     // Catch: Throwable -> L25
    L23:
        monitor-exit(GcBlockerManager.class);     // Catch: Throwable -> L25
    L29:
        return sGcBlocker;
    }

    private static boolean isEnabled() {
        if (new PolarisFileWrapper("/data/local/tmp/disable-gcblocker").exists() == false) goto L6;
        return false;
    L6:
        if (DeviceInfoUtils.isEmulator() == false) goto L8;
    L15:
        return false;
    L8:
        if (DeviceInfoUtils.isEmulatorTrans2Arm() == true) goto L15;
        if (JatoXL.getConfig() != null) goto L13;
        return false;
    L13:
        return true;
    }
}
