package com.ss.android.lark.auditsdk.v2.receivecheck;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f409657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConcurrentHashMap<String, ValidateIMFileResult> f409658b;

    public e(d r100, ConcurrentHashMap<String, ValidateIMFileResult> r101) {
        this.f409657a = r100;
        this.f409658b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentHashMap<a.InterfaceC4761a, Object> r100 = this.f409657a.f409656d;     // Catch: Throwable -> L7
        ConcurrentHashMap<String, ValidateIMFileResult> r101 = this.f409658b;     // Catch: Throwable -> L7
        Iterator<Map.Entry<a.InterfaceC4761a, Object>> r102 = r100.entrySet().iterator();     // Catch: Throwable -> L7
    L4:
        if (r102.hasNext() == false) goto L16;
        r102.next().getKey().a(r101);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
