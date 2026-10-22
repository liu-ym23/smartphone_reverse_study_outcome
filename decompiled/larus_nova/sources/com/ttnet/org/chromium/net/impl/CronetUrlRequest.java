package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.InlineExecutionProhibitedException;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("cronet")
public final class CronetUrlRequest extends UrlRequestBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long mAddCookieCostUs;
    private final boolean mAllowDirectExecutor;
    private String mAuthCertPassword;
    private String mAuthCertUsername;
    private long mBizReadResponseBodyInterval;
    private final VersionSafeCallbacks.UrlRequestCallback mCallback;
    private String mCookieRelMetric;
    private final int mCronetEngineId;
    private String mCronetMapKey;
    private long mCurrentReadResponseBodyStart;
    private final boolean mDisableCache;
    private final boolean mDisableConnectionMigration;
    private CronetException mException;
    private final Executor mExecutor;
    private String mFinalUrl;
    private int mFinishedReason;
    private long mFirstReadResponseBodyStart;
    private final int mIdempotency;
    private String mInitialMethod;
    private final String mInitialUrl;
    private long mLastReadResponseBodyEnd;
    private final CronetLogger mLogger;
    private CronetMetrics mMetrics;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private final int mPriority;
    private boolean mQuicConnectionMigrationAttempted;
    private boolean mQuicConnectionMigrationSuccessful;
    private long mReadResponseBodyDuration;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private int mRequestCookieSource;
    private final VersionSafeCallbacks.RequestFinishedInfoListener mRequestFinishedListener;
    private int mRequestFlag;
    private final HeadersList mRequestHeaders;
    private int mRequestTimeout;
    private int mRequestTypeFlags;
    private long mResponseBodyReadTimes;
    private UrlResponseInfoImpl mResponseInfo;
    private long mSaveCookieCostUs;
    private int mSocketConnectTimeout;
    private int mSocketReadTimeout;
    private int mSocketWriteTimeout;
    private boolean mStarted;
    private long mThrottleNetSpeed;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private CronetUploadDataStream mUploadDataStream;
    private final List<String> mUrlChain;
    private long mUrlRequestAdapter;
    private final Object mUrlRequestAdapterLock;
    private boolean mWaitingOnRead;
    private boolean mWaitingOnRedirect;

    public static final class HeadersList extends ArrayList<Map.Entry<String, String>> {
        public HeadersList() {
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface Natives {
        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void abortWhenUploadException(long r100, CronetUrlRequest r101);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void addRequestCookieHeader(long r100, CronetUrlRequest r101, String r102, String r103);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean addRequestHeader(long r100, CronetUrlRequest r101, String r102, String r103);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void appTimeout(long r100, CronetUrlRequest r101);

        long createRequestAdapter(CronetUrlRequest r100, long r101, String r102, int r103, int r104, boolean r105, boolean r106, boolean r107, int r110, boolean r111, int r112, int r113, long r114);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void destroy(long r100, CronetUrlRequest r101, boolean r102);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void followDeferredRedirect(long r100, CronetUrlRequest r101);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void getStatus(long r100, CronetUrlRequest r101, VersionSafeCallbacks.UrlRequestStatusListener r102);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean readData(long r100, CronetUrlRequest r101, ByteBuffer r102, int r103, int r104);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void removeRequestCookieHeader(long r100, CronetUrlRequest r101);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setAuthCredentials(long r100, CronetUrlRequest r101, String r102, String r103);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        boolean setHttpMethod(long r100, CronetUrlRequest r101, String r102);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTimeout(long r100, CronetUrlRequest r101, int r102);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setRequestTypeFlags(long r100, CronetUrlRequest r101, int r102);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setSocketTimeout(long r100, CronetUrlRequest r101, int r102, int r103, int r104);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void setThrottleNetSpeed(long r100, CronetUrlRequest r101, long r102);

        @NativeClassQualifiedName("CronetURLRequestAdapter")
        void start(long r100, CronetUrlRequest r101);
    }

    /* JADX INFO: loaded from: classes5.dex */
    public final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        final /* synthetic */ CronetUrlRequest this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable__run$___twin___() {
            this.this$0.checkCallingThread();
            ByteBuffer r100 = this.mByteBuffer;
            this.mByteBuffer = null;
            Object r101 = CronetUrlRequest.access$000(this.this$0);     // Catch: Exception -> L16
            monitor-enter(r101);     // Catch: Exception -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L6:
            if (CronetUrlRequest.access$100(this.this$0) == false) goto L9;
            monitor-exit(r101);     // Catch: Throwable -> L13
            return;
        L9:
            CronetUrlRequest.access$202(this.this$0, true);     // Catch: Throwable -> L13
            monitor-exit(r101);     // Catch: Throwable -> L13
            VersionSafeCallbacks.UrlRequestCallback r102 = CronetUrlRequest.access$400(this.this$0);     // Catch: Exception -> L16
            CronetUrlRequest r103 = this.this$0;     // Catch: Exception -> L16
            r102.onReadCompleted(r103, CronetUrlRequest.access$300(r103), r100);     // Catch: Exception -> L16
            return;
        L16:
            e = move-exception;
            CronetUrlRequest.access$500(this.this$0, e);
        }

        private OnReadCompletedRunnable(CronetUrlRequest r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(OnReadCompletedRunnable r100) {
            r100.com_ttnet_org_chromium_net_impl_CronetUrlRequest$OnReadCompletedRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ OnReadCompletedRunnable(CronetUrlRequest r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private static int convertIdempotency(int r100) {
        int r101 = 1;
        if (r100 == 1) goto L8;
        r101 = 2;
        if (r100 == 2) goto L8;
        return 0;
    L8:
        return r101;
    }

    private static int convertRequestPriority(int r100) {
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 == 1) goto L14;
        if (r100 != 2) goto L8;
        return 3;
    L8:
        if (r100 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    private void MaybeRecordReadResponseBodyEnd() {
        if (this.mCurrentReadResponseBodyStart == (-1)) goto L9;
        long r100 = System.nanoTime();
        this.mLastReadResponseBodyEnd = r100;
        if (this.mReadResponseBodyDuration != (-1)) goto L7;
        this.mReadResponseBodyDuration = 0;
    L7:
        this.mReadResponseBodyDuration += r100 - this.mCurrentReadResponseBodyStart;
        this.mCurrentReadResponseBodyStart = -1;
        return;
    }

    private void RecordReadResponseBodyStart() {
        this.mResponseBodyReadTimes++;
        long r100 = System.nanoTime();
        this.mCurrentReadResponseBodyStart = r100;
        if (this.mFirstReadResponseBodyStart != (-1)) goto L5;
        this.mFirstReadResponseBodyStart = r100;
    L5:
        long r101 = this.mLastReadResponseBodyEnd;
        if (r101 != (-1)) goto L8;
        return;
    L8:
        if (this.mBizReadResponseBodyInterval != (-1)) goto L10;
        this.mBizReadResponseBodyInterval = 0;
    L10:
        this.mBizReadResponseBodyInterval += r100 - r101;
    }

    private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
        UrlResponseInfoImpl r100 = this.mResponseInfo;
        if (r100 == null) goto L5;
        Map<String, List<String>> r101 = r100.getAllHeaders();
        String r102 = this.mResponseInfo.getNegotiatedProtocol();
        int r103 = this.mResponseInfo.getHttpStatusCode();
        boolean r104 = this.mResponseInfo.wasCached();
        String r110 = r102;
        int r111 = r103;
    L6:
        long r105 = this.mMetrics.getSentByteCount().longValue();
        if (r104 == true) goto L9;
    L11:
        long r106 = estimateHeadersSizeInBytes(this.mRequestHeaders);
        long r107 = Math.max(0, r105 - r106);
    L12:
        long r108 = this.mMetrics.getReceivedByteCount().longValue();
        if (r104 == true) goto L15;
    L17:
        long r112 = estimateHeadersSizeInBytes(r101);
        long r113 = Math.max(0, r108 - r112);
    L19:
        if (this.mMetrics.getRequestStart() != null) goto L21;
    L23:
        Duration r109 = Duration.ofSeconds(0);
    L25:
        if (this.mMetrics.getRequestStart() != null) goto L27;
    L29:
        Duration r114 = Duration.ofSeconds(0);
    L31:
        return new CronetLogger.CronetTrafficInfo(r106, r107, r112, r113, r111, r109, r114, r110, this.mQuicConnectionMigrationAttempted, this.mQuicConnectionMigrationSuccessful);
    L27:
        if (this.mMetrics.getRequestEnd() == null) goto L29;
        r114 = Duration.ofMillis(this.mMetrics.getRequestEnd().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L31
    L21:
        if (this.mMetrics.getResponseStart() == null) goto L23;
        r109 = Duration.ofMillis(this.mMetrics.getResponseStart().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L25
    L15:
        if (r108 != 0) goto L17;
        r112 = 0;
        r113 = 0;
        goto L19
    L9:
        if (r105 != 0) goto L11;
        r106 = 0;
        r107 = 0;
        goto L12
    L5:
        r101 = Collections.emptyMap();
        r110 = "";
        r104 = false;
        r111 = 0;
        goto L6
    }

    private void checkNotStarted() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L11;
        if (isDoneLocked() == true) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L11:
        throw new IllegalStateException("Request is already started.");     // Catch: Throwable -> L12
    }

    private RequestFinishedInfo getRequestFinishedInfo() {
        return new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
    }

    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L7;
        return true;
    }

    private void maybeReportMetrics() {
        if (this.mMetrics != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L19;
    L10:
        this.mMetrics.setReadResponseBodyMetrics(this.mResponseBodyReadTimes, this.mFirstReadResponseBodyStart, this.mLastReadResponseBodyEnd, this.mReadResponseBodyDuration, this.mBizReadResponseBodyInterval);
        final RequestFinishedInfoImpl r100 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
        this.mRequestContext.reportRequestFinished(r100);
        VersionSafeCallbacks.RequestFinishedInfoListener r101 = this.mRequestFinishedListener;
        if (r101 == null) goto L22;
        r101.getExecutor().execute(new AnonymousClass9(this, r100));     // Catch: RejectedExecutionException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L22:
        return;
    L19:
        this.mLogger.logCronetTrafficInfo(this.mCronetEngineId, buildCronetTrafficInfo());     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Error while trying to log CronetTrafficInfo: ", new Object[]{e});
        goto L10
    }

    private void onCanceled() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Runnable r100 = new AnonymousClass6(this);
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(r100);
    }

    private void onNativeAdapterDestroyed() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
        Runnable r101 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L18
        if (r101 == null) goto L8;
        r101.run();     // Catch: Throwable -> L18
    L8:
        if (this.mException != null) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L18
        Runnable r102 = new AnonymousClass8(this);
        MaybeRecordReadResponseBodyEnd();     // Catch: RejectedExecutionException -> L15
        this.mExecutor.execute(r102);     // Catch: RejectedExecutionException -> L15
        return;
    L15:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private void startInternalLocked() {
        String r100 = this.mCronetMapKey;
        if (r100 == null) goto L5;
        CronetUrlRequestMapping.AddRequest(r100, this);
    L5:
        CronetUrlRequestJni.get().start(this.mUrlRequestAdapter, this);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void RemoveRequestCookieHeader() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().removeRequestCookieHeader(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void appTimeout() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().appTimeout(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancel() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked(2);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
    }

    public void checkCallingThread() {
        if (this.mAllowDirectExecutor == false) goto L5;
        return;
    L5:
        if (this.mRequestContext.isNetworkThread(ThreadMethodProxy.currentThread()) == true) goto L8;
        return;
    L8:
        throw new InlineExecutionProhibitedException();
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void followRedirect() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRedirect == false) goto L14;
        this.mWaitingOnRedirect = false;     // Catch: Throwable -> L15
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L10:
        CronetUrlRequestJni.get().followDeferredRedirect(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L15
    }

    public long getUrlRequestAdapterForTesting() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
        long r101 = this.mUrlRequestAdapter;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public boolean isDone() {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
        boolean r101 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest$Natives] */
    /* JADX WARN: Type inference failed for: r0v26, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest$Natives] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest$Natives] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.ttnet.org.chromium.net.impl.CronetUrlRequest] */
    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void start() {
        Object r110 = this.mUrlRequestAdapterLock;
        monitor-enter(r110);
        checkNotStarted();     // Catch: Throwable -> L78
    L90:
        Object r111 = r110;
        final ?? r100 = this;
        r100.mUrlRequestAdapter = CronetUrlRequestJni.get().createRequestAdapter(this, this.mRequestContext.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mRequestFlag, this.mDisableCache, this.mDisableConnectionMigration, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mIdempotency, this.mNetworkHandle);     // Catch: RuntimeException -> L63 Throwable -> L82
        r100.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L63 Throwable -> L82
        if (r100.mInitialMethod != null) goto L14;
    L18:
        Iterator<Map.Entry<String, String>> r101 = r100.mRequestHeaders.iterator();     // Catch: RuntimeException -> L63 Throwable -> L82
        boolean r112 = false;
    L20:
        if (r101.hasNext() == false) goto L36;
        Map.Entry<String, String> r102 = r101.next();     // Catch: RuntimeException -> L63 Throwable -> L82
        if (r102.getKey().equalsIgnoreCase("Content-Type") == false) goto L27;
        if (r102.getValue().isEmpty() == true) goto L27;
        r112 = true;
    L27:
        if (r102.getKey().equalsIgnoreCase("Tt-Map-Key") == false) goto L32;
        if (r102.getValue().isEmpty() == true) goto L32;
        r100.mCronetMapKey = r102.getValue();     // Catch: RuntimeException -> L63 Throwable -> L82
    L32:
        if (CronetUrlRequestJni.get().addRequestHeader(r100.mUrlRequestAdapter, this, r102.getKey(), r102.getValue()) == true) goto L20;
        throw new IllegalArgumentException("Invalid header " + r102.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + r102.getValue());     // Catch: RuntimeException -> L63 Throwable -> L82
    L36:
        CronetUrlRequestJni.get().setSocketTimeout(r100.mUrlRequestAdapter, this, r100.mSocketConnectTimeout, r100.mSocketReadTimeout, r100.mSocketWriteTimeout);     // Catch: RuntimeException -> L63 Throwable -> L82
        ?? r103 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        long r104 = r100.mUrlRequestAdapter;     // Catch: RuntimeException -> L63 Throwable -> L82
        r103.setRequestTimeout(r104, r100, r100.mRequestTimeout);     // Catch: RuntimeException -> L63 Throwable -> L82
        ?? r105 = r104;
        if (r100.mThrottleNetSpeed <= 0) goto L39;
        Natives r106 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        r106.setThrottleNetSpeed(r100.mUrlRequestAdapter, this, r100.mThrottleNetSpeed);     // Catch: RuntimeException -> L63 Throwable -> L82
        r105 = r106;
    L39:
        ?? r107 = r105;
        if (r100.mRequestTypeFlags <= 0) goto L42;
        ?? r108 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        long r109 = r100.mUrlRequestAdapter;     // Catch: RuntimeException -> L63 Throwable -> L82
        r108.setRequestTypeFlags(r109, r100, r100.mRequestTypeFlags);     // Catch: RuntimeException -> L63 Throwable -> L82
        r107 = r109;
    L42:
        ?? r113 = r107;
        if (r100.mAuthCertUsername == null) goto L47;
        r113 = r107;
        if (r100.mAuthCertPassword == null) goto L47;
        Natives r114 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        r114.setAuthCredentials(r100.mUrlRequestAdapter, this, r100.mAuthCertUsername, r100.mAuthCertPassword);     // Catch: RuntimeException -> L63 Throwable -> L82
        r113 = r114;
    L47:
        CronetUploadDataStream r115 = r100.mUploadDataStream;     // Catch: RuntimeException -> L63 Throwable -> L82
        if (r115 == null) goto L60;
        if (r112 == false) goto L58;
        r100.mStarted = true;     // Catch: RuntimeException -> L54 Throwable -> L82
        r115.postTaskToExecutor(new AnonymousClass1(r100));     // Catch: RuntimeException -> L54 Throwable -> L82
        monitor-exit(r111);     // Catch: Throwable -> L82
        return;
    L58:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: RuntimeException -> L54 Throwable -> L82
    L54:
        e = e;
    L76:
        r100.destroyRequestAdapterLocked(r113);     // Catch: Throwable -> L82
        throw e;     // Catch: Throwable -> L82
    L60:
        r100.mStarted = true;     // Catch: Throwable -> L82
        startInternalLocked();     // Catch: Throwable -> L82
        monitor-exit(r111);     // Catch: Throwable -> L82
        return;
    L14:
        if (CronetUrlRequestJni.get().setHttpMethod(r100.mUrlRequestAdapter, r100, r100.mInitialMethod) == true) goto L18;
        throw new IllegalArgumentException("Invalid http method " + r100.mInitialMethod);     // Catch: RuntimeException -> L63 Throwable -> L82
    L63:
        e = e;
        r100 = r100;
    L75:
        r113 = 1;
        goto L76
    L67:
        e = e;
        r113 = 1;
        r100 = this;
    L65:
        th = th;
    L80:
        monitor-exit(r111);     // Catch: Throwable -> L82
        throw th;
    L71:
        e = e;
        r100 = this;
    L69:
        th = th;
        r111 = r110;
    L73:
        e = e;
        r100 = this;
    L78:
        th = th;
        r111 = r110;
    L82:
        th = th;
        goto L80
    }

    static {
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public static /* synthetic */ Object access$000(CronetUrlRequest r100) {
        return r100.mUrlRequestAdapterLock;
    }

    public static /* synthetic */ boolean access$100(CronetUrlRequest r100) {
        return r100.isDoneLocked();
    }

    public static /* synthetic */ void access$1200(CronetUrlRequest r100) {
        r100.maybeReportMetrics();
    }

    public static /* synthetic */ CronetException access$1300(CronetUrlRequest r100) {
        return r100.mException;
    }

    public static /* synthetic */ VersionSafeCallbacks.RequestFinishedInfoListener access$1400(CronetUrlRequest r100) {
        return r100.mRequestFinishedListener;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$300(CronetUrlRequest r100) {
        return r100.mResponseInfo;
    }

    public static /* synthetic */ VersionSafeCallbacks.UrlRequestCallback access$400(CronetUrlRequest r100) {
        return r100.mCallback;
    }

    public static /* synthetic */ CronetUploadDataStream access$600(CronetUrlRequest r100) {
        return r100.mUploadDataStream;
    }

    public static /* synthetic */ long access$700(CronetUrlRequest r100) {
        return r100.mUrlRequestAdapter;
    }

    public static /* synthetic */ void access$800(CronetUrlRequest r100) {
        r100.startInternalLocked();
    }

    private void destroyRequestAdapterLocked(int r100) {
        this.mFinishedReason = r100;
        if (this.mUrlRequestAdapter != 0) goto L5;
        return;
    L5:
        this.mRequestContext.onRequestDestroyed();
        Natives r101 = CronetUrlRequestJni.get();
        long r102 = this.mUrlRequestAdapter;
        if (r100 != 2) goto L8;
        boolean r103 = true;
    L9:
        r101.destroy(r102, this, r103);
        this.mUrlRequestAdapter = 0;
        return;
    L8:
        r103 = false;
        goto L9
    }

    public static long estimateHeadersSizeInBytes(Map<String, List<String>> r100) {
        long r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, List<String>>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r103 = r102.next();
        String r104 = r103.getKey();
        if (r104 == null) goto L12;
        r101 = r101 + ((long) r104.length());
    L12:
        if (r103.getValue() == null) goto L7;
        Iterator<String> r105 = r103.getValue().iterator();
    L16:
        if (r105.hasNext() == false) goto L7;
        r101 = r101 + ((long) r105.next().length());
        goto L16
    L18:
        return r101;
    }

    private void failWithException(CronetException r100) {
        Object r101 = this.mUrlRequestAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        this.mException = r100;     // Catch: Throwable -> L11
        destroyRequestAdapterLocked(1);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    private int mapUrlRequestErrorToApiErrorCode(int r100) {
        switch(r100) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L3;
        };
    L3:
        Log.e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + r100, new Object[0]);
        return r100;
    L5:
        return 11;
    L7:
        return 10;
    L9:
        return 9;
    L11:
        return 8;
    L13:
        return 7;
    L15:
        return 6;
    L17:
        return 5;
    L19:
        return 4;
    L21:
        return 3;
    L23:
        return 2;
    L25:
        return 1;
    }

    private void onCallbackException(Exception r100) {
        CallbackExceptionImpl r101 = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r100);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r100});
        failWithException(r101);
    }

    private void onSucceeded(long r100) {
        this.mResponseInfo.setReceivedByteCount(r100);
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Runnable r101 = new AnonymousClass5(this);
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(r101);
    }

    private void postTaskToExecutor(Runnable r100) {
        this.mExecutor.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void getStatus(UrlRequest.StatusListener r100) {
        final VersionSafeCallbacks.UrlRequestStatusListener r101 = new VersionSafeCallbacks.UrlRequestStatusListener(r100);
        Object r102 = this.mUrlRequestAdapterLock;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter == 0) goto L9;
        CronetUrlRequestJni.get().getStatus(this.mUrlRequestAdapter, this, r101);     // Catch: Throwable -> L12
        monitor-exit(r102);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r102);     // Catch: Throwable -> L12
        postTaskToExecutor(new AnonymousClass2(this, r101));
    }

    public void onUploadException(Throwable r100) {
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", new Object[]{r100});
        Object r101 = this.mUrlRequestAdapterLock;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().abortWhenUploadException(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void read(ByteBuffer r100) {
        Preconditions.checkHasRemaining(r100);
        Preconditions.checkDirect(r100);
        Object r101 = this.mUrlRequestAdapterLock;
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRead == false) goto L17;
        this.mWaitingOnRead = false;     // Catch: Throwable -> L18
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L10:
        RecordReadResponseBodyStart();     // Catch: Throwable -> L18
        if (CronetUrlRequestJni.get().readData(this.mUrlRequestAdapter, this, r100, r100.position(), r100.limit()) == false) goto L14;
        monitor-exit(r101);     // Catch: Throwable -> L18
        return;
    L14:
        this.mWaitingOnRead = true;     // Catch: Throwable -> L18
        MaybeRecordReadResponseBodyEnd();     // Catch: Throwable -> L18
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L18
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAddCookieCostUs(long r100) {
        this.mAddCookieCostUs = r100;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setCookieRelMetric(String r100) {
        this.mCookieRelMetric = r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setHttpMethod(String r100) {
        checkNotStarted();
        if (r100 == null) goto L7;
        this.mInitialMethod = r100;
        return;
    L7:
        throw new NullPointerException("Method is required.");
    }

    public void setOnDestroyedCallbackForTesting(Runnable r100) {
        Object r101 = this.mUrlRequestAdapterLock;
        monitor-enter(r101);
        this.mOnDestroyedCallbackForTesting = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setOnDestroyedUploadCallbackForTesting(Runnable r100) {
        this.mUploadDataStream.setOnDestroyedCallbackForTesting(r100);
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestCookieSource(int r100) {
        this.mRequestCookieSource = r100;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestFlag(int r100) {
        this.mRequestFlag = r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setRequestTimeout(int r100) {
        this.mRequestTimeout = r100;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setRequestTypeFlags(int r100) {
        this.mRequestTypeFlags = r100 | this.mRequestTypeFlags;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setSaveCookieCostUs(long r100) {
        this.mSaveCookieCostUs = r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketConnectTimeout(int r100) {
        this.mSocketConnectTimeout = r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketReadTimeout(int r100) {
        this.mSocketReadTimeout = r100;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setSocketWriteTimeout(int r100) {
        this.mSocketWriteTimeout = r100;
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setThrottleNetSpeed(long r110) {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
        this.mThrottleNetSpeed = r110;     // Catch: Throwable -> L9
        if (this.mUrlRequestAdapter == 0) goto L7;
        CronetUrlRequestJni.get().setThrottleNetSpeed(this.mUrlRequestAdapter, this, r110);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static long estimateHeadersSizeInBytes(HeadersList r100) {
        long r101 = 0;
        if (r100 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        if (r104 == null) goto L12;
        r101 = r101 + ((long) r104.length());
    L12:
        if (r103.getValue() == null) goto L7;
        r101 = r101 + ((long) r103.getValue().length());
        goto L7
    L14:
        return r101;
    }

    public static /* synthetic */ void access$1100(CronetUrlRequest r100, int r101) {
        r100.destroyRequestAdapterLocked(r101);
    }

    public static /* synthetic */ boolean access$202(CronetUrlRequest r100, boolean r101) {
        r100.mWaitingOnRead = r101;
        return r101;
    }

    public static /* synthetic */ void access$500(CronetUrlRequest r100, Exception r101) {
        r100.onCallbackException(r101);
    }

    public static /* synthetic */ boolean access$902(CronetUrlRequest r100, boolean r101) {
        r100.mWaitingOnRedirect = r101;
        return r101;
    }

    private String[] addSecurityFactor(String r100, String[] r101) {
        HashMap r102 = new HashMap();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r101.length) goto L6;
        r102.put(r101[r104].toLowerCase(Locale.US), r101[r104 + 1]);
        r104 = r104 + 2;
        goto L4
    L6:
        Map<String, String> r105 = this.mRequestContext.onCallToAddSecurityFactor(r100, r102);
        if (r105 != null) goto L10;
        return null;
    L10:
        String[] r106 = new String[r105.size() * 2];
        Iterator<Map.Entry<String, String>> r107 = r105.entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        Map.Entry<String, String> r108 = r107.next();
        r106[r103] = r108.getKey();
        r106[r103 + 1] = r108.getValue();
        r103 = r103 + 2;
        goto L12
    L14:
        return r106;
    }

    private void onStatus(final VersionSafeCallbacks.UrlRequestStatusListener r100, final int r101) {
        postTaskToExecutor(new AnonymousClass7(this, r100, r101));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void AddRequestCookieHeader(String r100, String r101) {
        Object r102 = this.mUrlRequestAdapterLock;
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().addRequestCookieHeader(this.mUrlRequestAdapter, this, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void addHeader(String r100, String r101) {
        checkNotStarted();
        if (r100 == null) goto L10;
        if (r101 == null) goto L8;
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r100, r101));
        return;
    L8:
        throw new NullPointerException("Invalid header value.");
    L10:
        throw new NullPointerException("Invalid header name.");
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void cancelWithException(String r100, Throwable r101) {
        failWithException(new CronetExceptionImpl(r100, r101));
    }

    @Override // com.ttnet.org.chromium.net.UrlRequest
    public void setAuthCredentials(String r100, String r101) {
        this.mAuthCertUsername = r100;
        this.mAuthCertPassword = r101;
    }

    @Override // com.ttnet.org.chromium.net.impl.UrlRequestBase
    public void setUploadDataProvider(UploadDataProvider r100, Executor r101) {
        if (r100 == null) goto L9;
        if (this.mInitialMethod != null) goto L6;
        this.mInitialMethod = "POST";
    L6:
        this.mUploadDataStream = new CronetUploadDataStream(r100, r101, this);
        return;
    L9:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    private void onError(int r100, int r101, int r102, String r103, long r104) {
        UrlResponseInfoImpl r105 = this.mResponseInfo;
        if (r105 == null) goto L5;
        r105.setReceivedByteCount(r104);
    L5:
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        if (r100 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + r103, r100, r101, r102));
        return;
    L8:
        if (r100 == 3) goto L11;
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r103, mapUrlRequestErrorToApiErrorCode(r100), r101));
    }

    private void onReadCompleted(ByteBuffer r100, int r101, int r102, int r103, long r104) {
        this.mResponseInfo.setReceivedByteCount(r104);
        AnonymousClass1 r105 = null;
        if (r100.position() == r102) goto L5;
    L12:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r100.limit() != r103) goto L12;
        if (this.mOnReadCompletedTask != null) goto L10;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, r105);
    L10:
        r100.position(r102 + r101);
        this.mOnReadCompletedTask.mByteBuffer = r100;
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(this.mOnReadCompletedTask);
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r110, String r111, String[] r112, boolean r113, String r114, String r115, long r116) {
        HeadersList r100 = new HeadersList();
        int r101 = 0;
    L4:
        if (r101 >= r112.length) goto L7;
        r100.add(new AbstractMap.SimpleImmutableEntry(r112[r101], r112[r101 + 1]));
        r101 = r101 + 2;
        goto L4
    L7:
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), r110, r111, r100, r113, r114, r115, r116);
    }

    private void onResponseStarted(int r100, String r101, String[] r102, boolean r103, String r104, String r105, long r106, final String r107) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r100, r101, r102, r103, r104, r105, r106);
        postTaskToExecutor(new AnonymousClass4(this, r107));
    }

    private void onRedirectReceived(final String r110, int r111, String r112, String[] r113, boolean r114, String r115, String r116, long r117, final String r210) {
        final UrlResponseInfoImpl r100 = prepareResponseInfoOnNetworkThread(r111, r112, r113, r114, r115, r116, r117);
        this.mResponseInfo = r100;
        this.mUrlChain.add(r110);
        postTaskToExecutor(new AnonymousClass3(this, r100, r110, r210));
    }

    public CronetUrlRequest(CronetUrlRequestContext r100, String r110, int r111, UrlRequest.Callback r112, Executor r113, Collection<Object> r114, boolean r115, boolean r116, boolean r117, boolean r118, int r119, boolean r210, int r211, RequestFinishedInfo.Listener r212, int r213, long r214) {
        this.mUrlRequestAdapterLock = new Object();
        ArrayList r101 = new ArrayList();
        this.mUrlChain = r101;
        this.mRequestHeaders = new HeadersList();
        this.mResponseBodyReadTimes = 0;
        this.mFirstReadResponseBodyStart = -1;
        this.mCurrentReadResponseBodyStart = -1;
        this.mLastReadResponseBodyEnd = -1;
        this.mReadResponseBodyDuration = -1;
        this.mBizReadResponseBodyInterval = -1;
        if (r110 == null) goto L17;
        if (r112 == null) goto L15;
        if (r113 == null) goto L13;
        this.mAllowDirectExecutor = r117;
        this.mRequestContext = r100;
        this.mCronetEngineId = r100.getCronetEngineId();
        this.mLogger = r100.getCronetLogger();
        this.mInitialUrl = r110;
        r101.add(r110);
        this.mPriority = convertRequestPriority(r111);
        this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r112);
        this.mExecutor = r113;
        this.mRequestAnnotations = r114;
        this.mDisableCache = r115;
        this.mDisableConnectionMigration = r116;
        this.mTrafficStatsTagSet = r118;
        this.mTrafficStatsTag = r119;
        this.mTrafficStatsUidSet = r210;
        this.mTrafficStatsUid = r211;
        if (r212 == null) goto L9;
        VersionSafeCallbacks.RequestFinishedInfoListener r102 = new VersionSafeCallbacks.RequestFinishedInfoListener(r212);
    L10:
        this.mRequestFinishedListener = r102;
        this.mIdempotency = convertIdempotency(r213);
        this.mNetworkHandle = r214;
        return;
    L9:
        r102 = null;
        goto L10
    L13:
        throw new NullPointerException("Executor is required");
    L15:
        throw new NullPointerException("Listener is required");
    L17:
        throw new NullPointerException("URL is required");
    }

    private void onMetricsCollected(long r510, long r511, long r512, long r513, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, boolean r714, long r715, long r810, String r811, long r812, long r813, String r814, String r815, String r910, String r911, boolean r912, boolean r913, int r914, boolean r915, boolean r916) {
        Object r100 = this.mUrlRequestAdapterLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L10;
        CronetMetrics r101 = new CronetMetrics(r510, r511, r512, r513, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r715, r810, r811, r812, r813, r814, r815, this.mAddCookieCostUs, this.mSaveCookieCostUs, this.mRequestCookieSource, this.mCookieRelMetric, r912, r913, r914);     // Catch: Throwable -> L11
        this.mMetrics = r101;     // Catch: Throwable -> L11
        r101.setRequestLog(r911);     // Catch: Throwable -> L11
        this.mFinalUrl = r910;     // Catch: Throwable -> L11
        this.mQuicConnectionMigrationAttempted = r915;     // Catch: Throwable -> L11
        this.mQuicConnectionMigrationSuccessful = r916;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L11
    }
}
