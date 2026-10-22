package com.ss.bduploader.net;

import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.bduploader.BDUploadLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class LocalDNS extends BaseDNS {
    private static final String TAG = "LocalDNS";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    private Future mFuture;
    private boolean mRet;

    public static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNS> mLocalDNSRef;

        public void com_ss_bduploader_net_LocalDNS$MyRunnable__run$___twin___() {
            BDUploadLog.d(LocalDNS.TAG, String.format("----implement delayed check for local dns", new Object[0]));
            LocalDNS r100 = this.mLocalDNSRef.get();
            if (r100 != null) goto L7;
            BDUploadLog.d(LocalDNS.TAG, String.format("****end implement delayed check for local dns, dns object null", new Object[0]));
            return;
        L7:
            if (LocalDNS.access$100(r100) == true) goto L10;
            r100.cancel();
            BDUploadLog.d(LocalDNS.TAG, String.format("****end implement delayed check cancel local dns,", new Object[0]));
            r100.notifyError(new BDUploadDNSInfo(0, r100.mHostname, null, 0, r100.mId));
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_bduploader_net_LocalDNS$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public MyRunnable(LocalDNS r100) {
            this.mLocalDNSRef = new WeakReference(r100);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_bduploader_net_LocalDNS$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MyRunnable r100) {
            r100.com_ss_bduploader_net_LocalDNS$MyRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.bduploader.net.BaseDNS
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

    @Override // com.ss.bduploader.net.BaseDNS
    public void start() {
        this.mFuture = BDUploadThreadPool.addExecuteTask(new AnonymousClass1(this));     // Catch: Exception -> L4
    L6:
        this.mHandler.postDelayed(new MyRunnable(this), 10000);
        return;
    L4:
        e = move-exception;
        BDUploadLog.d(TAG, String.format("****end call local dns, exception:%s host:%s", new Object[]{e, this.mHostname}));
        notifyError(new BDUploadDNSInfo(0, this.mHostname, null, 0, this.mId));
        goto L6
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public void close() {
        super.close();
        Future r100 = this.mFuture;
        if (r100 == null) goto L6;
        r100.cancel(true);
        this.mFuture = null;
        return;
    }

    @Override // com.ss.bduploader.net.BaseDNS
    public boolean isRunning() {
        return this.mRet;
    }

    public static /* synthetic */ InetAddress[] access$000(LocalDNS r100) {
        return r100.mAddress;
    }

    public static /* synthetic */ boolean access$100(LocalDNS r100) {
        return r100.mRet;
    }

    public LocalDNS(String r100, Handler r101) {
        super(r100, r101);
        this.mRet = false;
    }

    public static /* synthetic */ InetAddress[] access$002(LocalDNS r100, InetAddress[] r101) {
        r100.mAddress = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(LocalDNS r100, boolean r101) {
        r100.mRet = r101;
        return r101;
    }
}
