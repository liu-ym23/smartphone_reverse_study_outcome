package com.bytedance.bdinstall;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class b1 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f199621a;

    public b1(a1 r100, Handler r101) {
        this.f199621a = r100;
        super(r101);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        onChange(r100);
        a1 r102 = this.f199621a;
        monitor-enter(r102);
        String r103 = r101.getQueryParameter("key");     // Catch: Throwable -> L22
        String r104 = r101.getQueryParameter("value");     // Catch: Throwable -> L22
        String r105 = r101.getQueryParameter("aid");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r103) == false) goto L7;
    L19:
        t.b("multi process: key or value is nullvalue: " + r104 + " aid ：" + r105);     // Catch: Throwable -> L22
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L19;
        ((ConcurrentHashMap) a1.f199604c).put(r103, r104);     // Catch: Throwable -> L22
        t.a("install_info 发送到子进程 onUpdate " + r104 + " aid ：" + r105);     // Catch: Throwable -> L22
        List r106 = (List) ((ConcurrentHashMap) a1.f199605d).get(r103);     // Catch: Throwable -> L22
        if (r106 == null) goto L17;
        Iterator r107 = r106.iterator();     // Catch: Throwable -> L22
    L13:
        if (r107.hasNext() == false) goto L17;
        a1.c r108 = (a1.c) r107.next();     // Catch: Throwable -> L22
        if (r108 == null) goto L13;
        r108.b(r104, r105);     // Catch: Throwable -> L22
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
