package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class OuterBinderAdapter extends BinderAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f276908j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static BinderAdapter f276909k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f276910l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f276911m;

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    public int getMsgDelayDisconnect() {
        return 1002;
    }

    static {
        f276908j = new Object();
    }

    private OuterBinderAdapter(Context r100, String r101, String r102) {
        super(r100, r101, r102);
    }

    public static BinderAdapter getInstance(Context r100, String r101, String r102) {
        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance.");
        Object r103 = f276908j;
        monitor-enter(r103);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f276909k != null) goto L8;
        f276910l = r101;     // Catch: Throwable -> L19
        f276911m = r102;     // Catch: Throwable -> L19
        f276909k = new OuterBinderAdapter(r100, r101, r102);     // Catch: Throwable -> L19
    L16:
        BinderAdapter r104 = f276909k;     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
        return r104;
    L8:
        if (Objects.equal(f276910l, r101) == true) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance refresh adapter");     // Catch: Throwable -> L19
        f276910l = r101;     // Catch: Throwable -> L19
        f276911m = r102;     // Catch: Throwable -> L19
        f276909k.unBind();     // Catch: Throwable -> L19
        f276909k = new OuterBinderAdapter(r100, r101, r102);     // Catch: Throwable -> L19
        goto L16
    L10:
        if (Objects.equal(f276911m, r102) == false) goto L13;
        r105 = false;
        goto L14
    }
}
