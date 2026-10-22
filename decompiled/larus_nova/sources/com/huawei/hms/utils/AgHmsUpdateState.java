package com.huawei.hms.utils;

import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes3.dex */
public class AgHmsUpdateState {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277843c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile AgHmsUpdateState f277844d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HmsCheckedState f277845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277846b;

    static {
        f277843c = new Object();
    }

    public static AgHmsUpdateState getInstance() {
        if (f277844d != null) goto L15;
        Object r100 = f277843c;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f277844d != null) goto L9;
        f277844d = new AgHmsUpdateState();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return f277844d;
    }

    private AgHmsUpdateState() {
        this.f277845a = HmsCheckedState.UNCHECKED;
        this.f277846b = 0;
    }

    public boolean isUpdateHms() {
        if (getCheckedState() == HmsCheckedState.NEED_UPDATE) goto L5;
    L7:
        return false;
    L5:
        if (this.f277846b == 0) goto L7;
        return true;
    }

    public void resetUpdateState() {
        if (getCheckedState() == HmsCheckedState.NEED_UPDATE) goto L5;
        return;
    L5:
        setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        setTargetVersionCode(0);
    }

    public HmsCheckedState getCheckedState() {
        return this.f277845a;
    }

    public int getTargetVersionCode() {
        return this.f277846b;
    }

    public void setCheckedState(HmsCheckedState r100) {
        if (r100 != null) goto L5;
        HMSLog.e("AgHmsUpdateState", "para invalid: checkedState is null");
        return;
    L5:
        this.f277845a = r100;
    }

    public void setTargetVersionCode(int r100) {
        this.f277846b = r100;
    }
}
