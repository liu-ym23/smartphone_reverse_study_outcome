package com.hihonor.mcs.system.diagnosis.core.resource;

import com.hihonor.mcs.system.diagnosis.core.IDoQueryComplete;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes23.dex */
public class PowerUsageCallbackWrapper extends IPowerUsageCallback.Stub {
    private static final String TAG = "PowerUsageCallbackWrapper";
    private IDoQueryComplete completion;
    private Condition powerUsageCondition;
    private Lock powerUsageLock;
    private PowerUsageStats powerUsageStats;

    public PowerUsageCallbackWrapper(Lock r100, Condition r101) {
        this.powerUsageStats = null;
        this.powerUsageLock = r100;
        this.powerUsageCondition = r101;
    }

    public PowerUsageStats getPowerStats() {
        return this.powerUsageStats;
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.resource.IPowerUsageCallback
    public void receiveQueryData(PowerUsageStats r100, IDoQueryComplete r101) {
        this.powerUsageStats = r100;
        this.completion = r101;
        Lock r102 = this.powerUsageLock;
        if (r102 != null) goto L5;
    L38:
        IDoQueryComplete r103 = this.completion;     // Catch: Exception -> L27
        if (r103 == null) goto L41;
        r103.doQueryComplete(this);     // Catch: Exception -> L27
        return;
    L41:
        return;
    L27:
        e = move-exception;
        e.getMessage();
        return;
    L5:
        if (this.powerUsageCondition == null) goto L38;
        r102.lock();
        this.powerUsageCondition.signalAll();     // Catch: Throwable -> L12 Exception -> L14
        this.powerUsageLock.unlock();     // Catch: Exception -> L10
    L30:
        goto L38
    L12:
        th = move-exception;
        this.powerUsageLock.unlock();     // Catch: Exception -> L20
    L22:
        throw th;
    L20:
        e = move-exception;
        e.getMessage();
    L14:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L12
        this.powerUsageLock.unlock();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.getMessage();
        goto L38
    }
}
