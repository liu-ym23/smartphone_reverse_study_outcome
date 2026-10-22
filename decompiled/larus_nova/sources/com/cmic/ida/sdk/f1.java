package com.cmic.ida.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public class f1 implements ServiceConnection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ThreadPoolExecutor f273117c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f273118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f273119b;

    static {
        TimeUnit r100 = TimeUnit.SECONDS;
        LinkedBlockingQueue r101 = new LinkedBlockingQueue(2048);
        ThreadPoolExecutor.DiscardPolicy r102 = new ThreadPoolExecutor.DiscardPolicy();
        f273117c = new PThreadPoolExecutor(0, 3, 60, r100, r101, new DefaultThreadFactory("ic/ida/sdk/f1"), r102);
    }

    public f1() {
        this.f273118a = false;
        this.f273119b = new LinkedBlockingQueue(1);
    }

    private /* synthetic */ void a(IBinder r100) {
        System.currentTimeMillis();     // Catch: Throwable -> L4
        this.f273119b.offer(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.getMessage();
    }

    public static /* synthetic */ void a(f1 r100, IBinder r101) {
        r100.a(r101);
    }

    public IBinder a() {
        if (this.f273118a == true) goto L7;
        this.f273118a = true;
        return this.f273119b.take();
    L7:
        throw new IllegalStateException();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r100, final IBinder r101) {
        f273117c.execute(new g1(this, r101));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r100) {
        System.currentTimeMillis();
    }
}
