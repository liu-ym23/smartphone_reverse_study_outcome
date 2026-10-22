package com.ss.mediakit.net;

import android.os.Handler;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class LocalDNSHosts {
    private static final String TAG = "BatchParseLocalDNSHosts";
    private static final int TIME_OUT = 10000;
    private InetAddress[] mAddress;
    protected boolean mCancelled;
    private Future mFuture;
    protected Handler mHandler;
    public String[] mHosts;
    public String mId;
    protected AVMDLNetClient mNetClient;
    private boolean mRet;

    /* JADX INFO: renamed from: com.ss.mediakit.net.LocalDNSHosts$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ LocalDNSHosts this$0;

        public static /* synthetic */ String a(String r100, Throwable r101) {
            return lambda$run$0(r100, r101);
        }

        public static /* synthetic */ String b() {
            return lambda$run$2();
        }

        public static /* synthetic */ String c(String r100, String r101) {
            return lambda$run$1(r100, r101);
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_mediakit_net_LocalDNSHosts$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private static /* synthetic */ String lambda$run$2() {
            return String.format(Locale.US, "****default expiredtime:%d force expiredtime:%d ", new Object[]{Integer.valueOf(AVMDLDNSParser.mGlobalDefaultExpiredTime), Integer.valueOf(AVMDLDNSParser.mGlobalForceExpiredTime)});
        }

        public void com_ss_mediakit_net_LocalDNSHosts$1__run$___twin___() {
            AVMDLLog.d(LocalDNSHosts.TAG, "----call local dns batch parse");
            int r100 = 0;
        L3:
            LocalDNSHosts r101 = this.this$0;
            String[] r102 = r101.mHosts;
            if (r100 >= r102.length) goto L35;
            if (TextUtils.isEmpty(r102[r100]) == true) goto L34;
            LocalDNSHosts r103 = this.this$0;     // Catch: Throwable -> L30
            LocalDNSHosts.access$002(r103, InetAddress.getAllByName(r103.mHosts[r100]));     // Catch: Throwable -> L30
            final String r110 = "";
            int r104 = 0;
        L11:
            if (r104 >= LocalDNSHosts.access$000(this.this$0).length) goto L21;
            String r105 = LocalDNSHosts.access$000(this.this$0)[r104].getHostAddress();
            if (TextUtils.isEmpty(r105) == true) goto L19;
            if (TextUtils.isEmpty(r110) == false) goto L17;
            String r106 = r110 + r105;
        L18:
            r110 = r106;
            goto L19
        L17:
            r106 = r110 + "," + r105;
        L19:
            r104 = r104 + 1;
            goto L11
        L21:
            if (AVMDLLog.isLogLevelEnabled(1) == false) goto L24;
            final String r107 = this.this$0.mHosts[r100];
            AVMDLLog.d(LocalDNSHosts.TAG, new a4(r107, r110));
        L24:
            if (TextUtils.isEmpty(r110) == true) goto L34;
            AVMDLLog.d(LocalDNSHosts.TAG, new b4());
            int r108 = AVMDLDNSParser.mGlobalForceExpiredTime;
            if (r108 > 0) goto L29;
            r108 = AVMDLDNSParser.mGlobalDefaultExpiredTime;
        L29:
            IPCache.getInstance().put(this.this$0.mHosts[r100], new AVMDLDNSInfo(0, this.this$0.mHosts[r100], r110, (r108 * 1000) + System.currentTimeMillis(), this.this$0.mId, -1));
        L30:
            th = move-exception;
            if (AVMDLLog.isLogLevelEnabled(1) == false) goto L34;
            final String r109 = this.this$0.mHosts[r100];
            AVMDLLog.d(LocalDNSHosts.TAG, new z3(r109, th));
        L34:
            r100 = r100 + 1;
            goto L3
        L35:
            LocalDNSHosts.access$102(r101, true);
            AVMDLLog.d(LocalDNSHosts.TAG, "****end call local dns batch parse");
        }

        public AnonymousClass1(LocalDNSHosts r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_mediakit_net_LocalDNSHosts$1_com_larus_apm_impl_protector_RunnableLancet_run(AnonymousClass1 r100) {
            r100.com_ss_mediakit_net_LocalDNSHosts$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private static /* synthetic */ String lambda$run$0(String r100, Throwable r101) {
            return String.format(Locale.US, "host:%s pasrse err:%s", new Object[]{r100, r101.getMessage()});
        }

        private static /* synthetic */ String lambda$run$1(String r100, String r101) {
            return String.format(Locale.US, "host:%s pasrse suc result:%s", new Object[]{r100, r101});
        }
    }

    public static class MyRunnable implements Runnable {
        private final WeakReference<LocalDNSHosts> mLocalDNSRef;

        public static /* synthetic */ String a() {
            return lambda$run$1();
        }

        public static /* synthetic */ String b() {
            return lambda$run$0();
        }

        public static /* synthetic */ String c() {
            return lambda$run$2();
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_mediakit_net_LocalDNSHosts$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private static /* synthetic */ String lambda$run$0() {
            return String.format(Locale.US, "----implement delayed check for local dns", new Object[0]);
        }

        private static /* synthetic */ String lambda$run$1() {
            return String.format(Locale.US, "****end implement delayed check for local dns, dns object null", new Object[0]);
        }

        private static /* synthetic */ String lambda$run$2() {
            return String.format(Locale.US, "****end implement delayed check cancel local dns,", new Object[0]);
        }

        public void com_ss_mediakit_net_LocalDNSHosts$MyRunnable__run$___twin___() {
            AVMDLLog.d(LocalDNSHosts.TAG, new c4());
            LocalDNSHosts r100 = this.mLocalDNSRef.get();
            if (r100 != null) goto L7;
            AVMDLLog.d(LocalDNSHosts.TAG, new d4());
            return;
        L7:
            if (LocalDNSHosts.access$100(r100) == true) goto L10;
            r100.cancel();
            AVMDLLog.d(LocalDNSHosts.TAG, new e4());
            return;
        }

        public MyRunnable(LocalDNSHosts r100) {
            this.mLocalDNSRef = new WeakReference(r100);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_mediakit_net_LocalDNSHosts$MyRunnable_com_larus_apm_impl_protector_RunnableLancet_run(MyRunnable r100) {
            r100.com_ss_mediakit_net_LocalDNSHosts$MyRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static /* synthetic */ String a(Exception r100) {
        return lambda$start$0(r100);
    }

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

    public void close() {
        Future r100 = this.mFuture;
        if (r100 == null) goto L6;
        r100.cancel(true);
        this.mFuture = null;
        return;
    }

    public void start() {
        this.mFuture = AVMDLThreadPool.addExecuteTask(new AnonymousClass1(this));     // Catch: Exception -> L4
    L6:
        this.mHandler.postDelayed(new MyRunnable(this), 10000);
        return;
    L4:
        e = move-exception;
        AVMDLLog.d(TAG, new y3(e));
        goto L6
    }

    public boolean isRunning() {
        return this.mRet;
    }

    public static /* synthetic */ InetAddress[] access$000(LocalDNSHosts r100) {
        return r100.mAddress;
    }

    public static /* synthetic */ boolean access$100(LocalDNSHosts r100) {
        return r100.mRet;
    }

    private static /* synthetic */ String lambda$start$0(Exception r100) {
        return String.format(Locale.US, "****end call local dns, exception:%s", new Object[]{r100});
    }

    public LocalDNSHosts(String[] r100, Handler r101) {
        this.mRet = false;
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHosts = r100;
        this.mHandler = r101;
    }

    public static /* synthetic */ InetAddress[] access$002(LocalDNSHosts r100, InetAddress[] r101) {
        r100.mAddress = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(LocalDNSHosts r100, boolean r101) {
        r100.mRet = r101;
        return r101;
    }
}
