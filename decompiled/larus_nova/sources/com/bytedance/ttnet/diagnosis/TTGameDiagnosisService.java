package com.bytedance.ttnet.diagnosis;

import com.bytedance.common.utility.Logger;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;

/* JADX INFO: loaded from: classes22.dex */
public class TTGameDiagnosisService {
    private static final String TAG = null;
    private static volatile TTGameDiagnosisService sInstance;
    private IDiagnosisCallback mDiagnosisCallback;
    private volatile boolean mIsMonitoring;
    private IDiagnosisRequest mRequest;

    public static /* synthetic */ void a(String r100) {
        lambda$new$0(r100);
    }

    public void monitorEnd() {
        monitorEnd(null);
    }

    static {
        TAG = "TTGameDiagnosisService";
        sInstance = null;
    }

    public static TTGameDiagnosisService inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TTGameDiagnosisService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTGameDiagnosisService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTGameDiagnosisService.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TTGameDiagnosisService() {
        this.mRequest = null;
        this.mIsMonitoring = false;
        this.mDiagnosisCallback = new a();
    }

    public boolean isMonitoring() {
        return this.mIsMonitoring;
    }

    private static /* synthetic */ void lambda$new$0(String r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "onDiagnosisComplete: " + r100);
        return;
    }

    public void doDiagnosisDuringGaming(String r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mRequest.doExtraCommand("diagnosis", r100);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public void monitorEnd(String r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        if (r100 == null) goto L9;
        this.mRequest.doExtraCommand("extra_info", r100);     // Catch: Throwable -> L12
    L9:
        this.mRequest.doExtraCommand(VideoEventOneOutSync.END_TYPE_FINISH, "");     // Catch: Throwable -> L12
        this.mIsMonitoring = false;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public void monitorBegin(String r100, String r101) throws Exception {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        IDiagnosisRequest r102 = TTNetDiagnosisService.createRequest(4, r100, 0, Integer.MAX_VALUE);     // Catch: Throwable -> L10
        this.mRequest = r102;     // Catch: Throwable -> L10
        r102.start(this.mDiagnosisCallback);     // Catch: Throwable -> L10
        this.mRequest.doExtraCommand("extra_info", r101);     // Catch: Throwable -> L10
        this.mIsMonitoring = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }
}
