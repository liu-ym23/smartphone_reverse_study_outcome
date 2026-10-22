package com.bytedance.common.jato.scheduler;

import android.content.Context;
import android.os.Build;
import com.bytedance.common.jato.util.DeviceInfoUtils;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import erc.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class JatoScheduler {
    private static JatoScheduler sInstance;
    private AtomicBoolean mIsInit;

    public static synchronized JatoScheduler getInstance() {
        monitor-enter(JatoScheduler.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new JatoScheduler();     // Catch: Throwable -> L10
    L7:
        JatoScheduler r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(JatoScheduler.class);
        return r100;
    }

    public JatoScheduler() {
        this.mIsInit = new AtomicBoolean(false);
    }

    public void init(Context r100, int r101) {
        if (this.mIsInit.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT > 22) goto L8;
        return;
    L8:
        if (SchedulerNativeHolder.ensureInited() == false) goto L17;
        int r102 = r100.getApplicationInfo().targetSdkVersion;
        a.a();
        if (DeviceInfoUtils.isEmulator() == false) goto L12;
    L13:
        r101 = r101 | DownloadErrorCode.ERROR_MAX_BYTE_LIMIT;
    L14:
        SchedulerNativeHolder.nativeInit(r102, r101, r100);
        return;
    L12:
        if (DeviceInfoUtils.isEmulatorTrans2Arm() == false) goto L14;
    }
}
