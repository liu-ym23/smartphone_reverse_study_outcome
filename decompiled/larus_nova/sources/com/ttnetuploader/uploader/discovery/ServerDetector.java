package com.ttnetuploader.uploader.discovery;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ttnetuploader.uploader.api.IServerStatusChange;
import com.ttnetuploader.uploader.net.INetResponse;
import com.ttnetuploader.uploader.net.RequestFactory;
import com.ttnetuploader.uploader.request_protocol.UploaderRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public class ServerDetector {
    private static final int CHECK_INTERVAL = 4000;
    private static final int REACHABLE = 1;
    private static final String TAG = "ServerDetector";
    private static final int UNREACHABLE = 0;
    private final Context mContext;
    private ScheduledFuture<?> mFuture;
    private boolean mIsFirst;
    private final boolean mIsHttp;
    private final IServerStatusChange mOnServerStatusChange;
    ScheduledExecutorService mScheduler;
    private final String mSn;
    private volatile int mState;

    public void start() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mScheduler != null) goto L6;
        this.mScheduler = PThreadExecutorsUtils.newScheduledThreadPool(1, new DefaultThreadFactory("erverDetector"));     // Catch: Throwable -> L9
    L6:
        this.mFuture = this.mScheduler.scheduleWithFixedDelay(new AnonymousClass1(this), 4000, 4000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    public void stop() {
        monitor-enter(this);
        ScheduledFuture<?> r100 = this.mFuture;     // Catch: Throwable -> L11
        if (r100 == null) goto L6;
        r100.cancel(true);     // Catch: Throwable -> L11
        this.mFuture = null;     // Catch: Throwable -> L11
    L6:
        ScheduledExecutorService r101 = this.mScheduler;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.shutdown();     // Catch: Throwable -> L11
        this.mScheduler = null;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void checkServerReachable() {
        String r100 = DiscoveryManager.getInstance(this.mContext).getIpv4(this.mSn);
        int r101 = DiscoveryManager.getInstance(this.mContext).getPort(this.mSn);
        if (isServerReachable(r100, r101, this.mIsHttp) == false) goto L10;
        if (this.mState == 0) goto L7;
        return;
    L7:
        if (this.mOnServerStatusChange == null) goto L18;
        this.mIsFirst = false;
        this.mState = 1;
        this.mOnServerStatusChange.onFind(this.mSn, r100, r101);
        return;
    L18:
        return;
    L10:
        if (this.mIsFirst == false) goto L12;
    L15:
        this.mIsFirst = false;
        this.mState = 0;
        this.mOnServerStatusChange.onLost(this.mSn);
        return;
    L12:
        if (this.mState == 1) goto L14;
        return;
    L14:
        if (this.mOnServerStatusChange != null) goto L15;
    }

    public static /* synthetic */ void access$000(ServerDetector r100) {
        r100.checkServerReachable();
    }

    public boolean isReachable(boolean r100, boolean r101) {
        if (r100 == false) goto L6;
        return isServerReachable(DiscoveryManager.getInstance(this.mContext).getIpv4(this.mSn), DiscoveryManager.getInstance(this.mContext).getPort(this.mSn), r101);
    L6:
        if (this.mState == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isServerReachable(String r100, int r101, boolean r102) {
        if (r100 != null) goto L5;
    L15:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L15;
        if (r101 <= 0) goto L15;
        INetResponse r103 = null;
        System.currentTimeMillis();     // Catch: Exception -> L12
        r103 = RequestFactory.getRequest(0, this.mContext).httpGetRequest(UploaderRequest.getKeepAliveUrl(r100, r101, r102), null, UploaderRequest.getKeepAliveHeaders(), 5000);     // Catch: Exception -> L12
        System.currentTimeMillis();     // Catch: Exception -> L12
        return true;
    L13:
        if (r103 == null) goto L15;
        r103.getRequestLog();
        goto L15
    }

    public ServerDetector(String r100, IServerStatusChange r101, boolean r102, Context r103) {
        this.mScheduler = null;
        this.mState = 0;
        this.mIsFirst = true;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.mSn = r100;
        this.mOnServerStatusChange = r101;
        this.mContext = r103;
        this.mIsHttp = r102;
    }
}
