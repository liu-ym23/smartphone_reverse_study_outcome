package com.larksuite.framework.thread;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public final class w extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f285809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f285810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f285811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f285812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f285813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<a0> f285814f;

    public final String a() {
        if (this.f285811c != null) goto L6;
        this.f285811c = ThreadMethodProxy.currentThread().getName();
    L6:
        return this.f285811c;
    }

    public final List<a0> b() {
        List<a0> r100 = this.f285814f;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList(this.f285814f);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public w(Looper r100) {
        super(r100);
        this.f285809a = 1000;
        this.f285810b = 1000;
        this.f285813e = "LarkHandler";
        this.f285814f = new LinkedList();
    }

    public final void c(String r100) {
        List<a0> r101 = this.f285814f;
        monitor-enter(r101);
        Iterator<a0> r102 = this.f285814f.iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        if (TextUtils.equals(r102.next().f285726a, r100) == false) goto L6;
        r102.remove();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message r110) {
        Runnable r100 = r110.getCallback();
        if (TextUtils.isEmpty(this.f285812d) == false) goto L7;
        if (r100 == null) goto L6;
        String r101 = r100.getClass().toString();
    L8:
        String r102 = r101;
        if (this.f285811c != null) goto L11;
        this.f285811c = ThreadMethodProxy.currentThread().getName();
    L11:
        long r103 = SystemClock.uptimeMillis();
        List<a0> r104 = this.f285814f;
        monitor-enter(r104);
        ((LinkedList) this.f285814f).add(new a0(r102, ThreadMethodProxy.currentThread(), System.currentTimeMillis()));     // Catch: Throwable -> L23
        monitor-exit(r104);     // Catch: Throwable -> L23
        Log.i("CoreThreadPool LarkHandler", "startTask:" + r102);
        super.dispatchMessage(r110);
        c(r102);
        long r105 = SystemClock.uptimeMillis();
        long r106 = r103 - r110.getWhen();
        long r107 = r105 - r103;
        if (r106 <= this.f285809a) goto L18;
    L19:
        Log.w("CoreThreadPool LarkHandler", this.f285811c + " " + r102 + ", dispatchtime & runtime is(ms) " + r106 + "， " + r107 + ", limit is  " + this.f285809a + "," + this.f285810b);
        l.a(r102, this.f285811c, r106, r107, this.f285809a, this.f285810b);
        CoreThreadPool.a r111 = CoreThreadPool.mCoreThreadPoolDep;
        if (r111 == null) goto L29;
        r111.b();
        return;
    L29:
        return;
    L18:
        if (r107 > this.f285810b) goto L19;
        return;
    L23:
        th = move-exception;
        throw th;
    L6:
        r101 = this.f285813e + "_" + r110.what;
        goto L8
    L7:
        r101 = this.f285812d;
        goto L8
    }

    public w(Looper r100, Handler.Callback r101) {
        super(r100, r101);
        this.f285809a = 1000;
        this.f285810b = 1000;
        this.f285813e = "LarkHandler";
        this.f285814f = new LinkedList();
        if (r101 == null) goto L6;
        this.f285812d = r101.getClass().toString();
        return;
    }

    @Override // android.os.Handler
    public final boolean sendMessageAtTime(Message r100, long r101) {
        Runnable r102 = r100.getCallback();
        if (TextUtils.isEmpty(this.f285812d) == false) goto L7;
        if (r102 == null) goto L6;
        String r103 = r102.getClass().toString();
    L8:
        Log.i("CoreThreadPool LarkHandler", "sendMessageAtTime taskname is: " + r103);
        return super.sendMessageAtTime(r100, r101);
    L6:
        r103 = this.f285813e + "_" + r100.what;
        goto L8
    L7:
        r103 = this.f285812d;
        goto L8
    }

    public w(Looper r100, String r101) {
        super(r100);
        this.f285809a = 1000;
        this.f285810b = 1000;
        this.f285813e = "LarkHandler";
        this.f285814f = new LinkedList();
        this.f285811c = r101;
    }
}
