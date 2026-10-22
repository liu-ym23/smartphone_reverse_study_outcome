package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class ForegroundBusResponseMgr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ForegroundBusResponseMgr f276862b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, BusResponseCallback> f276863a;

    static {
        f276862b = new ForegroundBusResponseMgr();
    }

    public ForegroundBusResponseMgr() {
        this.f276863a = new HashMap();
    }

    public static ForegroundBusResponseMgr getInstance() {
        return f276862b;
    }

    public BusResponseCallback get(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        Map<String, BusResponseCallback> r101 = this.f276863a;
        monitor-enter(r101);
        BusResponseCallback r102 = this.f276863a.get(r100);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public void unRegisterObserver(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Map<String, BusResponseCallback> r101 = this.f276863a;
        monitor-enter(r101);
        this.f276863a.remove(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void registerObserver(String r100, BusResponseCallback r101) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        if (r101 == null) goto L19;
        Map<String, BusResponseCallback> r102 = this.f276863a;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.f276863a.containsKey(r100) == true) goto L11;
        this.f276863a.put(r100, r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    }
}
