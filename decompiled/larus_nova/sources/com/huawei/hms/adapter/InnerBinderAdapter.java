package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class InnerBinderAdapter extends BinderAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f276906j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static BinderAdapter f276907k;

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 2001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 2002;
    }

    static {
        f276906j = new Object();
    }

    private InnerBinderAdapter(Context r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public static BinderAdapter getInstance(Context r100, String r101, String r102) {
        HMSLog.i("InnerBinderAdapter", "InnerBinderAdapter getInstance.");
        Object r103 = f276906j;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f276907k != null) goto L7;
        f276907k = new InnerBinderAdapter(r100, r101, r102);     // Catch: Throwable -> L10
    L7:
        BinderAdapter r104 = f276907k;     // Catch: Throwable -> L10
        monitor-exit(r103);     // Catch: Throwable -> L10
        return r104;
    }
}
