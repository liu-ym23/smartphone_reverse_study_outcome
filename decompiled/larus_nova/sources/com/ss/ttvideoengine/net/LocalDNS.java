package com.ss.ttvideoengine.net;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress mAddress;
    private Future mFuture;
    private boolean mRet;

    public static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_ttvideoengine_net_LocalDNS$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_ttvideoengine_net_LocalDNS$MyRunnable__run$___twin___() {
            LocalDNS r100 = this.mLocalDNSRef.get();
            if (r100 != null) goto L6;
            return;
        L6:
            monitor-enter(LocalDNS.class);
        L12:
            th = move-exception;
            throw th;
        L8:
            if (LocalDNS.access$100(r100) == true) goto L10;
            LocalDNS.access$102(r100, true);     // Catch: Throwable -> L12
            r100.notifyError(new Error(Error.LocalDNS, -10000));     // Catch: Throwable -> L12
        L10:
            monitor-exit(LocalDNS.class);     // Catch: Throwable -> L12
        }

        public MyRunnable(LocalDNS r100) {
            this.mLocalDNSRef = new WeakReference(r100);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_ttvideoengine_net_LocalDNS$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MyRunnable r100) {
            r100.com_ss_ttvideoengine_net_LocalDNS$MyRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void cancel() {
        if (this.mCancelled == false) goto L5;
        return;
    L5:
        this.mCancelled = true;
        Future r100 = this.mFuture;
        if (r100 == null) goto L9;
        r100.cancel(true);
        this.mFuture = null;
        return;
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void start() {
        this.mFuture = EngineThreadPool.addExecuteTask(new AnonymousClass1(this));     // Catch: Exception -> L4
    L6:
        this.mHandler.postDelayed(new MyRunnable(this), 10000);
        return;
    L4:
        e = move-exception;
        notifyError(new Error(Error.LocalDNS, Error.DnsParseError, e.getMessage()));
        goto L6
    }

    @Override // com.ss.ttvideoengine.net.BaseDNS
    public void close() {
        super.close();
        this.mCancelled = true;
        Future r100 = this.mFuture;
        if (r100 == null) goto L6;
        r100.cancel(true);
        this.mFuture = null;
        return;
    }

    public LocalDNS(String r100) {
        super(r100);
        this.mRet = false;
        TTVideoEngineLog.i(TAG, "DNS use LocalDNS");
    }

    public static /* synthetic */ InetAddress access$000(LocalDNS r100) {
        return r100.mAddress;
    }

    public static /* synthetic */ boolean access$100(LocalDNS r100) {
        return r100.mRet;
    }

    public static /* synthetic */ InetAddress access$002(LocalDNS r100, InetAddress r101) {
        r100.mAddress = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(LocalDNS r100, boolean r101) {
        r100.mRet = r101;
        return r101;
    }
}
