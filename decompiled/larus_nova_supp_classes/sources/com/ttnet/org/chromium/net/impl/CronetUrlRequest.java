package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

    private static int convertIdempotency(int r1) {
        int r0 = 1;
        if (r1 == 1) goto L8;
        r0 = 2;
        if (r1 == 2) goto L8;
        return 0;
    L8:
        return r0;
    }

    private static int convertRequestPriority(int r2) {
        if (r2 != 0) goto L5;
        return 1;
    L5:
        if (r2 == 1) goto L14;
        if (r2 != 2) goto L8;
        return 3;
    L8:
        if (r2 == 4) goto L10;
        return 4;
    L10:
        return 5;
    L14:
        return 2;
    }

    private void MaybeRecordReadResponseBodyEnd() {
        if (this.mCurrentReadResponseBodyStart == (-1)) goto L9;
        long r0 = System.nanoTime();
        this.mLastReadResponseBodyEnd = r0;
        if (this.mReadResponseBodyDuration != (-1)) goto L7;
        this.mReadResponseBodyDuration = 0;
    L7:
        this.mReadResponseBodyDuration += r0 - this.mCurrentReadResponseBodyStart;
        this.mCurrentReadResponseBodyStart = -1;
        return;
    }

    private void RecordReadResponseBodyStart() {
        this.mResponseBodyReadTimes++;
        long r0 = System.nanoTime();
        this.mCurrentReadResponseBodyStart = r0;
        if (this.mFirstReadResponseBodyStart != (-1)) goto L5;
        this.mFirstReadResponseBodyStart = r0;
    L5:
        long r2 = this.mLastReadResponseBodyEnd;
        if (r2 != (-1)) goto L8;
        return;
    L8:
        if (this.mBizReadResponseBodyInterval != (-1)) goto L10;
        this.mBizReadResponseBodyInterval = 0;
    L10:
        this.mBizReadResponseBodyInterval += r0 - r2;
    }

    private CronetLogger.CronetTrafficInfo buildCronetTrafficInfo() {
        UrlResponseInfoImpl r1 = this.mResponseInfo;
        if (r1 == null) goto L5;
        Map r2 = r1.getAllHeaders();
        String r3 = this.mResponseInfo.getNegotiatedProtocol();
        int r4 = this.mResponseInfo.getHttpStatusCode();
        boolean r5 = this.mResponseInfo.wasCached();
        String r14 = r3;
        int r11 = r4;
    L6:
        long r6 = this.mMetrics.getSentByteCount().longValue();
        if (r5 == true) goto L9;
    L11:
        long r7 = estimateHeadersSizeInBytes(this.mRequestHeaders);
        long r9 = Math.max(0, r6 - r7);
    L12:
        long r8 = this.mMetrics.getReceivedByteCount().longValue();
        if (r5 == true) goto L15;
    L17:
        long r12 = estimateHeadersSizeInBytes(r2);
        long r15 = Math.max(0, r8 - r12);
    L19:
        if (this.mMetrics.getRequestStart() != null) goto L21;
    L23:
        Duration r10 = Duration.ofSeconds(0);
    L25:
        if (this.mMetrics.getRequestStart() != null) goto L27;
    L29:
        Duration r13 = Duration.ofSeconds(0);
    L31:
        return new CronetLogger.CronetTrafficInfo(r7, r9, r12, r15, r11, r10, r13, r14, this.mQuicConnectionMigrationAttempted, this.mQuicConnectionMigrationSuccessful);
    L27:
        if (this.mMetrics.getRequestEnd() == null) goto L29;
        r13 = Duration.ofMillis(this.mMetrics.getRequestEnd().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L31
    L21:
        if (this.mMetrics.getResponseStart() == null) goto L23;
        r10 = Duration.ofMillis(this.mMetrics.getResponseStart().getTime() - this.mMetrics.getRequestStart().getTime());
        goto L25
    L15:
        if (r8 != 0) goto L17;
        r12 = 0;
        r15 = 0;
        goto L19
    L9:
        if (r6 != 0) goto L11;
        r7 = 0;
        r9 = 0;
        goto L12
    L5:
        r2 = Collections.emptyMap();
        r14 = XmlPullParser.NO_NAMESPACE;
        r5 = false;
        r11 = 0;
        goto L6
    }

    private void checkNotStarted() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L11;
        if (isDoneLocked() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L12
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
        final RequestFinishedInfo r0 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, this.mMetrics, this.mFinishedReason, this.mResponseInfo, this.mException);
        this.mRequestContext.reportRequestFinished(r0);
        VersionSafeCallbacks.RequestFinishedInfoListener r3 = this.mRequestFinishedListener;
        if (r3 == null) goto L22;
        r3.getExecutor().execute(new AnonymousClass9(this, r0));     // Catch: RejectedExecutionException -> L14
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
        6 r0 = new 6(this);
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(r0);
    }

    private void onNativeAdapterDestroyed() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        Runnable r1 = this.mOnDestroyedCallbackForTesting;     // Catch: Throwable -> L18
        if (r1 == null) goto L8;
        r1.run();     // Catch: Throwable -> L18
    L8:
        if (this.mException != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L18
        Runnable r2 = new 8(this);
        MaybeRecordReadResponseBodyEnd();     // Catch: RejectedExecutionException -> L15
        this.mExecutor.execute(r2);     // Catch: RejectedExecutionException -> L15
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
        String r0 = this.mCronetMapKey;
        if (r0 == null) goto L5;
        CronetUrlRequestMapping.AddRequest(r0, this);
    L5:
        CronetUrlRequestJni.get().start(this.mUrlRequestAdapter, this);
    }

    public void RemoveRequestCookieHeader() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().removeRequestCookieHeader(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void appTimeout() {
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().appTimeout(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void cancel() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked(2);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
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

    public void followRedirect() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRedirect == false) goto L14;
        this.mWaitingOnRedirect = false;     // Catch: Throwable -> L15
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L10:
        CronetUrlRequestJni.get().followDeferredRedirect(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new IllegalStateException("No redirect to follow.");     // Catch: Throwable -> L15
    }

    public long getUrlRequestAdapterForTesting() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        long r1 = this.mUrlRequestAdapter;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isDone() {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        boolean r1 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public void start() {
        Object r14 = this.mUrlRequestAdapterLock;
        monitor-enter(r14);
        checkNotStarted();     // Catch: Throwable -> L78
    L90:
        Object r18 = r14;
        final ?? r8 = this;
        r8.mUrlRequestAdapter = CronetUrlRequestJni.get().createRequestAdapter(this, this.mRequestContext.getUrlRequestContextAdapter(), this.mInitialUrl, this.mPriority, this.mRequestFlag, this.mDisableCache, this.mDisableConnectionMigration, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mIdempotency, this.mNetworkHandle);     // Catch: RuntimeException -> L63 Throwable -> L82
        r8.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L63 Throwable -> L82
        if (r8.mInitialMethod != null) goto L14;
    L18:
        Iterator<Map.Entry<String, String>> r0 = r8.mRequestHeaders.iterator();     // Catch: RuntimeException -> L63 Throwable -> L82
        boolean r13 = false;
    L20:
        if (r0.hasNext() == false) goto L36;
        Map.Entry<String, String> r7 = r0.next();     // Catch: RuntimeException -> L63 Throwable -> L82
        if (r7.getKey().equalsIgnoreCase("Content-Type") == false) goto L27;
        if (r7.getValue().isEmpty() == true) goto L27;
        r13 = true;
    L27:
        if (r7.getKey().equalsIgnoreCase("Tt-Map-Key") == false) goto L32;
        if (r7.getValue().isEmpty() == true) goto L32;
        r8.mCronetMapKey = r7.getValue();     // Catch: RuntimeException -> L63 Throwable -> L82
    L32:
        if (CronetUrlRequestJni.get().addRequestHeader(r8.mUrlRequestAdapter, this, r7.getKey(), r7.getValue()) == true) goto L20;
        throw new IllegalArgumentException("Invalid header " + r7.getKey() + "=" + r7.getValue());     // Catch: RuntimeException -> L63 Throwable -> L82
    L36:
        CronetUrlRequestJni.get().setSocketTimeout(r8.mUrlRequestAdapter, this, r8.mSocketConnectTimeout, r8.mSocketReadTimeout, r8.mSocketWriteTimeout);     // Catch: RuntimeException -> L63 Throwable -> L82
        Natives r1 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        long r2 = r8.mUrlRequestAdapter;     // Catch: RuntimeException -> L63 Throwable -> L82
        r1.setRequestTimeout(r2, r8, r8.mRequestTimeout);     // Catch: RuntimeException -> L63 Throwable -> L82
        ?? r3 = r2;
        if (r8.mThrottleNetSpeed <= 0) goto L39;
        Natives r4 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        r4.setThrottleNetSpeed(r8.mUrlRequestAdapter, this, r8.mThrottleNetSpeed);     // Catch: RuntimeException -> L63 Throwable -> L82
        r3 = r4;
    L39:
        ?? r5 = r3;
        if (r8.mRequestTypeFlags <= 0) goto L42;
        Natives r6 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        long r9 = r8.mUrlRequestAdapter;     // Catch: RuntimeException -> L63 Throwable -> L82
        r6.setRequestTypeFlags(r9, r8, r8.mRequestTypeFlags);     // Catch: RuntimeException -> L63 Throwable -> L82
        r5 = r9;
    L42:
        ?? r10 = r5;
        if (r8.mAuthCertUsername == null) goto L47;
        r10 = r5;
        if (r8.mAuthCertPassword == null) goto L47;
        Natives r11 = CronetUrlRequestJni.get();     // Catch: RuntimeException -> L63 Throwable -> L82
        r11.setAuthCredentials(r8.mUrlRequestAdapter, this, r8.mAuthCertUsername, r8.mAuthCertPassword);     // Catch: RuntimeException -> L63 Throwable -> L82
        r10 = r11;
    L47:
        CronetUploadDataStream r12 = r8.mUploadDataStream;     // Catch: RuntimeException -> L63 Throwable -> L82
        if (r12 == null) goto L60;
        if (r13 == false) goto L58;
        r8.mStarted = true;     // Catch: RuntimeException -> L54 Throwable -> L82
        r12.postTaskToExecutor(new AnonymousClass1(r8));     // Catch: RuntimeException -> L54 Throwable -> L82
        monitor-exit(r18);     // Catch: Throwable -> L82
        return;
    L58:
        throw new IllegalArgumentException("Requests with upload data must have a Content-Type.");     // Catch: RuntimeException -> L54 Throwable -> L82
    L54:
        e = e;
    L76:
        r8.destroyRequestAdapterLocked(r10);     // Catch: Throwable -> L82
        throw e;     // Catch: Throwable -> L82
    L60:
        r8.mStarted = true;     // Catch: Throwable -> L82
        startInternalLocked();     // Catch: Throwable -> L82
        monitor-exit(r18);     // Catch: Throwable -> L82
        return;
    L14:
        if (CronetUrlRequestJni.get().setHttpMethod(r8.mUrlRequestAdapter, r8, r8.mInitialMethod) == true) goto L18;
        throw new IllegalArgumentException("Invalid http method " + r8.mInitialMethod);     // Catch: RuntimeException -> L63 Throwable -> L82
    L63:
        e = e;
        r8 = r8;
    L75:
        r10 = 1;
        goto L76
    L67:
        e = e;
        r10 = 1;
        r8 = this;
    L65:
        th = th;
    L80:
        monitor-exit(r18);     // Catch: Throwable -> L82
        throw th;
    L71:
        e = e;
        r8 = this;
    L69:
        th = th;
        r18 = r14;
    L73:
        e = e;
        r8 = this;
    L78:
        th = th;
        r18 = r14;
    L82:
        th = th;
        goto L80
    }

    static {
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public static /* synthetic */ Object access$000(CronetUrlRequest r0) {
        return r0.mUrlRequestAdapterLock;
    }

    public static /* synthetic */ boolean access$100(CronetUrlRequest r0) {
        return r0.isDoneLocked();
    }

    public static /* synthetic */ void access$1200(CronetUrlRequest r0) {
        r0.maybeReportMetrics();
    }

    public static /* synthetic */ CronetException access$1300(CronetUrlRequest r0) {
        return r0.mException;
    }

    public static /* synthetic */ VersionSafeCallbacks.RequestFinishedInfoListener access$1400(CronetUrlRequest r0) {
        return r0.mRequestFinishedListener;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$300(CronetUrlRequest r0) {
        return r0.mResponseInfo;
    }

    public static /* synthetic */ VersionSafeCallbacks.UrlRequestCallback access$400(CronetUrlRequest r0) {
        return r0.mCallback;
    }

    public static /* synthetic */ CronetUploadDataStream access$600(CronetUrlRequest r0) {
        return r0.mUploadDataStream;
    }

    public static /* synthetic */ long access$700(CronetUrlRequest r2) {
        return r2.mUrlRequestAdapter;
    }

    public static /* synthetic */ void access$800(CronetUrlRequest r0) {
        r0.startInternalLocked();
    }

    private void destroyRequestAdapterLocked(int r7) {
        this.mFinishedReason = r7;
        if (this.mUrlRequestAdapter != 0) goto L5;
        return;
    L5:
        this.mRequestContext.onRequestDestroyed();
        Natives r0 = CronetUrlRequestJni.get();
        long r4 = this.mUrlRequestAdapter;
        if (r7 != 2) goto L8;
        boolean r8 = true;
    L9:
        r0.destroy(r4, this, r8);
        this.mUrlRequestAdapter = 0;
        return;
    L8:
        r8 = false;
        goto L9
    }

    public static long estimateHeadersSizeInBytes(Map<String, List<String>> r5) {
        long r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, List<String>>> r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r2 = r6.next();
        String r3 = r2.getKey();
        if (r3 == null) goto L12;
        r0 = r0 + ((long) r3.length());
    L12:
        if (r2.getValue() == null) goto L7;
        Iterator<String> r4 = r2.getValue().iterator();
    L16:
        if (r4.hasNext() == false) goto L7;
        r0 = r0 + ((long) r4.next().length());
        goto L16
    L18:
        return r0;
    }

    private void failWithException(CronetException r3) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mException = r3;     // Catch: Throwable -> L11
        destroyRequestAdapterLocked(1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    private int mapUrlRequestErrorToApiErrorCode(int r4) {
        switch(r4) {
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
        Log.e(CronetUrlRequestContext.LOG_TAG, "Unknown error code: " + r4, new Object[0]);
        return r4;
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

    private void onCallbackException(Exception r5) {
        CallbackExceptionImpl r0 = new CallbackExceptionImpl("Exception received from UrlRequest.Callback", r5);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r5});
        failWithException(r0);
    }

    private void onSucceeded(long r2) {
        this.mResponseInfo.setReceivedByteCount(r2);
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        Runnable r3 = new AnonymousClass5(this);
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(r3);
    }

    private void postTaskToExecutor(Runnable r4) {
        this.mExecutor.execute(r4);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        failWithException(new CronetExceptionImpl("Exception posting task to executor", e));
    }

    public void getStatus(UrlRequest.StatusListener r7) {
        VersionSafeCallbacks.UrlRequestStatusListener r0 = new VersionSafeCallbacks.UrlRequestStatusListener(r7);
        Object r8 = this.mUrlRequestAdapterLock;
        monitor-enter(r8);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter == 0) goto L9;
        CronetUrlRequestJni.get().getStatus(this.mUrlRequestAdapter, this, r0);     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return;
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L12
        postTaskToExecutor(new 2(this, r0));
    }

    public void onUploadException(Throwable r6) {
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in upload method", new Object[]{r6});
        Object r7 = this.mUrlRequestAdapterLock;
        monitor-enter(r7);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r7);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().abortWhenUploadException(this.mUrlRequestAdapter, this);     // Catch: Throwable -> L11
        monitor-exit(r7);     // Catch: Throwable -> L11
    }

    public void read(ByteBuffer r9) {
        Preconditions.checkHasRemaining(r9);
        Preconditions.checkDirect(r9);
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mWaitingOnRead == false) goto L17;
        this.mWaitingOnRead = false;     // Catch: Throwable -> L18
        if (isDoneLocked() == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L10:
        RecordReadResponseBodyStart();     // Catch: Throwable -> L18
        if (CronetUrlRequestJni.get().readData(this.mUrlRequestAdapter, this, r9, r9.position(), r9.limit()) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L14:
        this.mWaitingOnRead = true;     // Catch: Throwable -> L18
        MaybeRecordReadResponseBodyEnd();     // Catch: Throwable -> L18
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L18
    L17:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L18
    }

    public void setAddCookieCostUs(long r1) {
        this.mAddCookieCostUs = r1;
    }

    public void setCookieRelMetric(String r1) {
        this.mCookieRelMetric = r1;
    }

    public void setHttpMethod(String r2) {
        checkNotStarted();
        if (r2 == null) goto L7;
        this.mInitialMethod = r2;
        return;
    L7:
        throw new NullPointerException("Method is required.");
    }

    public void setOnDestroyedCallbackForTesting(Runnable r2) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        this.mOnDestroyedCallbackForTesting = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setOnDestroyedUploadCallbackForTesting(Runnable r2) {
        this.mUploadDataStream.setOnDestroyedCallbackForTesting(r2);
    }

    public void setRequestCookieSource(int r1) {
        this.mRequestCookieSource = r1;
    }

    public void setRequestFlag(int r1) {
        this.mRequestFlag = r1;
    }

    public void setRequestTimeout(int r1) {
        this.mRequestTimeout = r1;
    }

    public void setRequestTypeFlags(int r2) {
        this.mRequestTypeFlags = r2 | this.mRequestTypeFlags;
    }

    public void setSaveCookieCostUs(long r1) {
        this.mSaveCookieCostUs = r1;
    }

    public void setSocketConnectTimeout(int r1) {
        this.mSocketConnectTimeout = r1;
    }

    public void setSocketReadTimeout(int r1) {
        this.mSocketReadTimeout = r1;
    }

    public void setSocketWriteTimeout(int r1) {
        this.mSocketWriteTimeout = r1;
    }

    public void setThrottleNetSpeed(long r13) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
        this.mThrottleNetSpeed = r13;     // Catch: Throwable -> L9
        if (this.mUrlRequestAdapter == 0) goto L7;
        CronetUrlRequestJni.get().setThrottleNetSpeed(this.mUrlRequestAdapter, this, r13);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static long estimateHeadersSizeInBytes(HeadersList r5) {
        long r0 = 0;
        if (r5 != null) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<String, String>> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r6.next();
        String r3 = r2.getKey();
        if (r3 == null) goto L12;
        r0 = r0 + ((long) r3.length());
    L12:
        if (r2.getValue() == null) goto L7;
        r0 = r0 + ((long) r2.getValue().length());
        goto L7
    L14:
        return r0;
    }

    public static /* synthetic */ void access$1100(CronetUrlRequest r0, int r1) {
        r0.destroyRequestAdapterLocked(r1);
    }

    public static /* synthetic */ boolean access$202(CronetUrlRequest r0, boolean r1) {
        r0.mWaitingOnRead = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(CronetUrlRequest r0, Exception r1) {
        r0.onCallbackException(r1);
    }

    public static /* synthetic */ boolean access$902(CronetUrlRequest r0, boolean r1) {
        r0.mWaitingOnRedirect = r1;
        return r1;
    }

    private String[] addSecurityFactor(String r6, String[] r7) {
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L4
    L6:
        Map<String, String> r8 = this.mRequestContext.onCallToAddSecurityFactor(r6, r0);
        if (r8 != null) goto L10;
        return null;
    L10:
        String[] r9 = new String[r8.size() * 2];
        Iterator<Map.Entry<String, String>> r10 = r8.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r10.next();
        r9[r1] = r3.getKey();
        r9[r1 + 1] = r3.getValue();
        r1 = r1 + 2;
        goto L12
    L14:
        return r9;
    }

    private void onStatus(VersionSafeCallbacks.UrlRequestStatusListener r2, int r3) {
        postTaskToExecutor(new 7(this, r2, r3));
    }

    public void AddRequestCookieHeader(String r8, String r9) {
        Object r0 = this.mUrlRequestAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mUrlRequestAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestJni.get().addRequestCookieHeader(this.mUrlRequestAdapter, this, r8, r9);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void addHeader(String r3, String r4) {
        checkNotStarted();
        if (r3 == null) goto L10;
        if (r4 == null) goto L8;
        this.mRequestHeaders.add(new AbstractMap.SimpleImmutableEntry(r3, r4));
        return;
    L8:
        throw new NullPointerException("Invalid header value.");
    L10:
        throw new NullPointerException("Invalid header name.");
    }

    public void cancelWithException(String r2, Throwable r3) {
        failWithException(new CronetExceptionImpl(r2, r3));
    }

    public void setAuthCredentials(String r1, String r2) {
        this.mAuthCertUsername = r1;
        this.mAuthCertPassword = r2;
    }

    public void setUploadDataProvider(UploadDataProvider r2, Executor r3) {
        if (r2 == null) goto L9;
        if (this.mInitialMethod != null) goto L6;
        this.mInitialMethod = "POST";
    L6:
        this.mUploadDataStream = new CronetUploadDataStream(r2, r3, this);
        return;
    L9:
        throw new NullPointerException("Invalid UploadDataProvider.");
    }

    private void onError(int r2, int r3, int r4, String r5, long r6) {
        UrlResponseInfoImpl r0 = this.mResponseInfo;
        if (r0 == null) goto L5;
        r0.setReceivedByteCount(r6);
    L5:
        CronetUrlRequestMapping.RemoveRequest(this.mCronetMapKey);
        if (r2 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in CronetUrlRequest: " + r5, r2, r3, r4));
        return;
    L8:
        if (r2 == 3) goto L11;
        failWithException(new NetworkExceptionImpl("Exception in CronetUrlRequest: " + r5, mapUrlRequestErrorToApiErrorCode(r2), r3));
    }

    private void onReadCompleted(ByteBuffer r2, int r3, int r4, int r5, long r6) {
        this.mResponseInfo.setReceivedByteCount(r6);
        if (r2.position() == r4) goto L5;
    L12:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r2.limit() != r5) goto L12;
        if (this.mOnReadCompletedTask != null) goto L10;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, null);
    L10:
        r2.position(r4 + r3);
        this.mOnReadCompletedTask.mByteBuffer = r2;
        MaybeRecordReadResponseBodyEnd();
        postTaskToExecutor(this.mOnReadCompletedTask);
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19) {
        HeadersList r4 = new HeadersList();
        int r1 = 0;
    L4:
        if (r1 >= r15.length) goto L7;
        r4.add(new AbstractMap.SimpleImmutableEntry(r15[r1], r15[r1 + 1]));
        r1 = r1 + 2;
        goto L4
    L7:
        return new UrlResponseInfoImpl(new ArrayList(this.mUrlChain), r13, r14, r4, r16, r17, r18, r19);
    }

    private void onResponseStarted(int r1, String r2, String[] r3, boolean r4, String r5, String r6, long r7, final String r9) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r1, r2, r3, r4, r5, r6, r7);
        postTaskToExecutor(new AnonymousClass4(this, r9));
    }

    private void onRedirectReceived(final String r12, int r13, String r14, String[] r15, boolean r16, String r17, String r18, long r19, final String r21) {
        final UrlResponseInfoImpl r0 = prepareResponseInfoOnNetworkThread(r13, r14, r15, r16, r17, r18, r19);
        this.mResponseInfo = r0;
        this.mUrlChain.add(r12);
        postTaskToExecutor(new AnonymousClass3(this, r0, r12, r21));
    }

    public CronetUrlRequest(CronetUrlRequestContext r9, String r10, int r11, UrlRequest.Callback r12, Executor r13, Collection<Object> r14, boolean r15, boolean r16, boolean r17, boolean r18, int r19, boolean r20, int r21, RequestFinishedInfo.Listener r22, int r23, long r24) {
        this.mUrlRequestAdapterLock = new Object();
        ArrayList r5 = new ArrayList();
        this.mUrlChain = r5;
        this.mRequestHeaders = new HeadersList();
        this.mResponseBodyReadTimes = 0;
        this.mFirstReadResponseBodyStart = -1;
        this.mCurrentReadResponseBodyStart = -1;
        this.mLastReadResponseBodyEnd = -1;
        this.mReadResponseBodyDuration = -1;
        this.mBizReadResponseBodyInterval = -1;
        if (r10 == null) goto L17;
        if (r12 == null) goto L15;
        if (r13 == null) goto L13;
        this.mAllowDirectExecutor = r17;
        this.mRequestContext = r9;
        this.mCronetEngineId = r9.getCronetEngineId();
        this.mLogger = r9.getCronetLogger();
        this.mInitialUrl = r10;
        r5.add(r10);
        this.mPriority = convertRequestPriority(r11);
        this.mCallback = new VersionSafeCallbacks.UrlRequestCallback(r12);
        this.mExecutor = r13;
        this.mRequestAnnotations = r14;
        this.mDisableCache = r15;
        this.mDisableConnectionMigration = r16;
        this.mTrafficStatsTagSet = r18;
        this.mTrafficStatsTag = r19;
        this.mTrafficStatsUidSet = r20;
        this.mTrafficStatsUid = r21;
        if (r22 == null) goto L9;
        VersionSafeCallbacks.RequestFinishedInfoListener r1 = new VersionSafeCallbacks.RequestFinishedInfoListener(r22);
    L10:
        this.mRequestFinishedListener = r1;
        this.mIdempotency = convertIdempotency(r23);
        this.mNetworkHandle = r24;
        return;
    L9:
        r1 = null;
        goto L10
    L13:
        throw new NullPointerException("Executor is required");
    L15:
        throw new NullPointerException("Listener is required");
    L17:
        throw new NullPointerException("URL is required");
    }

    private void onMetricsCollected(long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, long r68, long r70, long r72, long r74, long r76, boolean r78, long r79, long r81, String r83, long r84, long r86, String r88, String r89, String r90, String r91, boolean r92, boolean r93, int r94, boolean r95, boolean r96) {
        Object r2 = this.mUrlRequestAdapterLock;
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L10;
        CronetMetrics r0 = new CronetMetrics(r52, r54, r56, r58, r60, r62, r64, r66, r68, r70, r72, r74, r76, r78, r79, r81, r83, r84, r86, r88, r89, this.mAddCookieCostUs, this.mSaveCookieCostUs, this.mRequestCookieSource, this.mCookieRelMetric, r92, r93, r94);     // Catch: Throwable -> L11
        this.mMetrics = r0;     // Catch: Throwable -> L11
        r0.setRequestLog(r91);     // Catch: Throwable -> L11
        this.mFinalUrl = r90;     // Catch: Throwable -> L11
        this.mQuicConnectionMigrationAttempted = r95;     // Catch: Throwable -> L11
        this.mQuicConnectionMigrationSuccessful = r96;     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L11
    }
}
