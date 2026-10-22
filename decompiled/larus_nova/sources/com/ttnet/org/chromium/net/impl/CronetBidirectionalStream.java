package com.ttnet.org.chromium.net.impl;

import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetException;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("cronet")
public class CronetBidirectionalStream extends ExperimentalBidirectionalStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final VersionSafeCallbacks.BidirectionalStreamCallback mCallback;
    private final boolean mDelayRequestHeadersUntilFirstFlush;
    private boolean mEndOfStreamWritten;
    private CronetException mException;
    private final Executor mExecutor;
    private LinkedList<ByteBuffer> mFlushData;
    private final String mInitialMethod;
    private final int mInitialPriority;
    private final String mInitialUrl;
    private RequestFinishedInfo.Metrics mMetrics;
    private long mNativeStream;
    private final Object mNativeStreamLock;
    private final long mNetworkHandle;
    private Runnable mOnDestroyedCallbackForTesting;
    private OnReadCompletedRunnable mOnReadCompletedTask;
    private LinkedList<ByteBuffer> mPendingData;
    private int mReadState;
    private final Collection<Object> mRequestAnnotations;
    private final CronetUrlRequestContext mRequestContext;
    private final String[] mRequestHeaders;
    private boolean mRequestHeadersSent;
    private UrlResponseInfoImpl mResponseInfo;
    private final int mTrafficStatsTag;
    private final boolean mTrafficStatsTagSet;
    private final int mTrafficStatsUid;
    private final boolean mTrafficStatsUidSet;
    private int mWriteState;

    /* JADX INFO: loaded from: classes41.dex */
    public interface Natives {
        long createBidirectionalStream(CronetBidirectionalStream r100, long r101, boolean r102, boolean r103, int r104, boolean r105, int r106, long r107);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void destroy(long r100, CronetBidirectionalStream r101, boolean r102);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean readData(long r100, CronetBidirectionalStream r101, ByteBuffer r102, int r103, int r104);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        void sendRequestHeaders(long r100, CronetBidirectionalStream r101);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        int start(long r100, CronetBidirectionalStream r101, String r102, int r103, String r104, String[] r105, boolean r106);

        @NativeClassQualifiedName("CronetBidirectionalStreamAdapter")
        boolean writevData(long r100, CronetBidirectionalStream r101, ByteBuffer[] r102, int[] r103, int[] r104, boolean r105);
    }

    /* JADX INFO: loaded from: classes41.dex */
    public final class OnReadCompletedRunnable implements Runnable {
        ByteBuffer mByteBuffer;
        boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnReadCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnReadCompletedRunnable__run$___twin___() {
            ByteBuffer r100 = this.mByteBuffer;     // Catch: Exception -> L22
            this.mByteBuffer = null;     // Catch: Exception -> L22
            Object r101 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L22
            monitor-enter(r101);     // Catch: Exception -> L22
        L19:
            th = move-exception;
            throw th;     // Catch: Exception -> L22
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r101);     // Catch: Throwable -> L19
            return;
        L8:
            boolean r102 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$202(this.this$0, 4);     // Catch: Throwable -> L19
            if (CronetBidirectionalStream.access$300(this.this$0) != 10) goto L14;
            r102 = true;
        L14:
            monitor-exit(r101);     // Catch: Throwable -> L19
            VersionSafeCallbacks.BidirectionalStreamCallback r103 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L22
            CronetBidirectionalStream r104 = this.this$0;     // Catch: Exception -> L22
            r103.onReadCompleted(r104, CronetBidirectionalStream.access$400(r104), r100, this.mEndOfStream);     // Catch: Exception -> L22
            if (r102 == false) goto L27;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L22
            return;
        L27:
            return;
        L13:
            CronetBidirectionalStream.access$202(this.this$0, 2);     // Catch: Throwable -> L19
        L22:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }

        private OnReadCompletedRunnable(CronetBidirectionalStream r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnReadCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(OnReadCompletedRunnable r100) {
            r100.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnReadCompletedRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ OnReadCompletedRunnable(CronetBidirectionalStream r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public final class OnWriteCompletedRunnable implements Runnable {
        private ByteBuffer mByteBuffer;
        private final boolean mEndOfStream;
        final /* synthetic */ CronetBidirectionalStream this$0;

        @Override // java.lang.Runnable
        public void run() {
            com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnWriteCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnWriteCompletedRunnable__run$___twin___() {
            ByteBuffer r100 = this.mByteBuffer;     // Catch: Exception -> L21
            this.mByteBuffer = null;     // Catch: Exception -> L21
            Object r101 = CronetBidirectionalStream.access$000(this.this$0);     // Catch: Exception -> L21
            monitor-enter(r101);     // Catch: Exception -> L21
        L18:
            th = move-exception;
            throw th;     // Catch: Exception -> L21
        L5:
            if (CronetBidirectionalStream.access$100(this.this$0) == false) goto L8;
            monitor-exit(r101);     // Catch: Throwable -> L18
            return;
        L8:
            boolean r102 = false;
            if (this.mEndOfStream == false) goto L13;
            CronetBidirectionalStream.access$302(this.this$0, 10);     // Catch: Throwable -> L18
            if (CronetBidirectionalStream.access$200(this.this$0) != 4) goto L13;
            r102 = true;
        L13:
            monitor-exit(r101);     // Catch: Throwable -> L18
            VersionSafeCallbacks.BidirectionalStreamCallback r103 = CronetBidirectionalStream.access$500(this.this$0);     // Catch: Exception -> L21
            CronetBidirectionalStream r104 = this.this$0;     // Catch: Exception -> L21
            r103.onWriteCompleted(r104, CronetBidirectionalStream.access$400(r104), r100, this.mEndOfStream);     // Catch: Exception -> L21
            if (r102 == false) goto L26;
            CronetBidirectionalStream.access$600(this.this$0);     // Catch: Exception -> L21
            return;
        L26:
            return;
        L21:
            e = move-exception;
            CronetBidirectionalStream.access$700(this.this$0, e);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnWriteCompletedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(OnWriteCompletedRunnable r100) {
            r100.com_ttnet_org_chromium_net_impl_CronetBidirectionalStream$OnWriteCompletedRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public OnWriteCompletedRunnable(CronetBidirectionalStream r100, ByteBuffer r101, boolean r102) {
            this.this$0 = r100;
            this.mByteBuffer = r101;
            this.mEndOfStream = r102;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int CANCELED = 5;
        public static final int ERROR = 6;
        public static final int NOT_STARTED = 0;
        public static final int READING = 3;
        public static final int READING_DONE = 4;
        public static final int STARTED = 1;
        public static final int SUCCESS = 7;
        public static final int WAITING_FOR_FLUSH = 8;
        public static final int WAITING_FOR_READ = 2;
        public static final int WRITING = 9;
        public static final int WRITING_DONE = 10;
    }

    private boolean isDoneLocked() {
        if (this.mReadState != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mNativeStream != 0) goto L7;
        return true;
    }

    private void maybeOnSucceededOnExecutor() {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L9:
        if (this.mWriteState == 10) goto L11;
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.mReadState != 4) goto L20;
        this.mWriteState = 7;     // Catch: Throwable -> L22
        this.mReadState = 7;     // Catch: Throwable -> L22
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        this.mCallback.onSucceeded(this, this.mResponseInfo);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in onSucceeded method", new Object[]{e});
    }

    private void onCanceled() {
        postTaskToExecutor(new AnonymousClass4(this));
    }

    private void sendFlushDataLocked() {
        int r100 = this.mFlushData.size();
        ByteBuffer[] r101 = new ByteBuffer[r100];
        int[] r102 = new int[r100];
        int[] r103 = new int[r100];
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L5;
        ByteBuffer r105 = this.mFlushData.poll();
        r101[r104] = r105;
        r102[r104] = r105.position();
        r103[r104] = r105.limit();
        r104 = r104 + 1;
        goto L3
    L5:
        this.mWriteState = 9;
        this.mRequestHeadersSent = true;
        Natives r106 = CronetBidirectionalStreamJni.get();
        long r107 = this.mNativeStream;
        if (this.mEndOfStreamWritten == true) goto L8;
    L10:
        boolean r108 = false;
    L12:
        if (r106.writevData(r107, this, r101, r102, r103, r108) == false) goto L14;
        return;
    L14:
        this.mWriteState = 8;
        throw new IllegalArgumentException("Unable to call native writev.");
    L8:
        if (this.mPendingData.isEmpty() == false) goto L10;
        r108 = true;
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void cancel() {
        Object r100 = this.mNativeStreamLock;
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
        if (this.mReadState == 0) goto L12;
        this.mWriteState = 5;     // Catch: Throwable -> L14
        this.mReadState = 5;     // Catch: Throwable -> L14
        destroyNativeStreamLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void flush() {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == true) goto L31;
        int r101 = this.mWriteState;     // Catch: Throwable -> L33
        if (r101 == 8) goto L11;
        if (r101 != 9) goto L31;
    L11:
        if (this.mPendingData.isEmpty() == false) goto L22;
        if (this.mFlushData.isEmpty() == false) goto L22;
        if (this.mRequestHeadersSent == true) goto L19;
        this.mRequestHeadersSent = true;     // Catch: Throwable -> L33
        CronetBidirectionalStreamJni.get().sendRequestHeaders(this.mNativeStream, this);     // Catch: Throwable -> L33
        if (doesMethodAllowWriteData(this.mInitialMethod) == true) goto L19;
        this.mWriteState = 10;     // Catch: Throwable -> L33
    L19:
        monitor-exit(r100);     // Catch: Throwable -> L33
        return;
    L22:
        if (this.mPendingData.isEmpty() == true) goto L25;
        this.mFlushData.addAll(this.mPendingData);     // Catch: Throwable -> L33
        this.mPendingData.clear();     // Catch: Throwable -> L33
    L25:
        if (this.mWriteState != 9) goto L28;
        monitor-exit(r100);     // Catch: Throwable -> L33
        return;
    L28:
        sendFlushDataLocked();     // Catch: Throwable -> L33
        monitor-exit(r100);     // Catch: Throwable -> L33
        return;
    L31:
        monitor-exit(r100);     // Catch: Throwable -> L33
    }

    public List<ByteBuffer> getFlushDataForTesting() {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r102 = this.mFlushData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(r102.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public List<ByteBuffer> getPendingDataForTesting() {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
        LinkedList r101 = new LinkedList();     // Catch: Throwable -> L10
        Iterator<ByteBuffer> r102 = this.mPendingData.iterator();     // Catch: Throwable -> L10
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.add(r102.next().asReadOnlyBuffer());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public boolean isDone() {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
        boolean r101 = isDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void start() {
        Object r110 = this.mNativeStreamLock;
        monitor-enter(r110);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (this.mReadState != 0) goto L30;
        Natives r100 = CronetBidirectionalStreamJni.get();     // Catch: RuntimeException -> L25 Throwable -> L31
        long r101 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: RuntimeException -> L25 Throwable -> L31
        if (this.mDelayRequestHeadersUntilFirstFlush == true) goto L9;
        boolean r102 = true;
    L10:
        this.mNativeStream = r100.createBidirectionalStream(this, r101, r102, this.mTrafficStatsTagSet, this.mTrafficStatsTag, this.mTrafficStatsUidSet, this.mTrafficStatsUid, this.mNetworkHandle);     // Catch: RuntimeException -> L25 Throwable -> L31
        this.mRequestContext.onRequestStarted();     // Catch: RuntimeException -> L25 Throwable -> L31
        Natives r103 = CronetBidirectionalStreamJni.get();     // Catch: RuntimeException -> L25 Throwable -> L31
        long r104 = this.mNativeStream;     // Catch: RuntimeException -> L25 Throwable -> L31
        String r105 = this.mInitialUrl;     // Catch: RuntimeException -> L25 Throwable -> L31
        int r106 = this.mInitialPriority;     // Catch: RuntimeException -> L25 Throwable -> L31
        String r107 = this.mInitialMethod;     // Catch: RuntimeException -> L25 Throwable -> L31
        String[] r108 = this.mRequestHeaders;     // Catch: RuntimeException -> L25 Throwable -> L31
        if (doesMethodAllowWriteData(r107) == true) goto L13;
        boolean r109 = true;
    L14:
        int r111 = r103.start(r104, this, r105, r106, r107, r108, r109);     // Catch: RuntimeException -> L25 Throwable -> L31
        if (r111 == (-1)) goto L24;
        if (r111 > 0) goto L20;
        this.mWriteState = 1;     // Catch: RuntimeException -> L25 Throwable -> L31
        this.mReadState = 1;     // Catch: RuntimeException -> L25 Throwable -> L31
        monitor-exit(r110);     // Catch: Throwable -> L31
        return;
    L20:
        int r112 = r111 - 1;
        throw new IllegalArgumentException("Invalid header " + this.mRequestHeaders[r112] + ContainerUtils.KEY_VALUE_DELIMITER + this.mRequestHeaders[r112 + 1]);     // Catch: RuntimeException -> L25 Throwable -> L31
    L24:
        throw new IllegalArgumentException("Invalid http method " + this.mInitialMethod);     // Catch: RuntimeException -> L25 Throwable -> L31
    L13:
        r109 = false;
        goto L14
    L9:
        r102 = false;
    L25:
        e = move-exception;
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L31
        throw e;     // Catch: Throwable -> L31
    L30:
        throw new IllegalStateException("Stream is already started.");     // Catch: Throwable -> L31
    }

    static {
    }

    public static /* synthetic */ Object access$000(CronetBidirectionalStream r100) {
        return r100.mNativeStreamLock;
    }

    public static /* synthetic */ boolean access$100(CronetBidirectionalStream r100) {
        return r100.isDoneLocked();
    }

    public static /* synthetic */ String access$1000(CronetBidirectionalStream r100) {
        return r100.mInitialMethod;
    }

    public static /* synthetic */ boolean access$1100(String r100) {
        return doesMethodAllowWriteData(r100);
    }

    public static /* synthetic */ int access$200(CronetBidirectionalStream r100) {
        return r100.mReadState;
    }

    public static /* synthetic */ int access$300(CronetBidirectionalStream r100) {
        return r100.mWriteState;
    }

    public static /* synthetic */ UrlResponseInfoImpl access$400(CronetBidirectionalStream r100) {
        return r100.mResponseInfo;
    }

    public static /* synthetic */ VersionSafeCallbacks.BidirectionalStreamCallback access$500(CronetBidirectionalStream r100) {
        return r100.mCallback;
    }

    public static /* synthetic */ void access$600(CronetBidirectionalStream r100) {
        r100.maybeOnSucceededOnExecutor();
    }

    public static /* synthetic */ boolean access$900(CronetBidirectionalStream r100) {
        return r100.mRequestHeadersSent;
    }

    private static int convertStreamPriority(int r100) {
        if (r100 != 0) goto L5;
        return 1;
    L5:
        if (r100 != 1) goto L7;
        return 2;
    L7:
        if (r100 != 2) goto L9;
        return 3;
    L9:
        if (r100 == 3) goto L15;
        if (r100 != 4) goto L14;
        return 5;
    L14:
        throw new IllegalArgumentException("Invalid stream priority.");
    L15:
        return 4;
    }

    private void destroyNativeStreamLocked(boolean r100) {
        Log.i(CronetUrlRequestContext.LOG_TAG, "destroyNativeStreamLocked " + toString(), new Object[0]);
        if (this.mNativeStream != 0) goto L5;
        return;
    L5:
        CronetBidirectionalStreamJni.get().destroy(this.mNativeStream, this, r100);
        this.mRequestContext.onRequestDestroyed();
        this.mNativeStream = 0;
        Runnable r101 = this.mOnDestroyedCallbackForTesting;
        if (r101 == null) goto L9;
        r101.run();
        return;
    }

    private static boolean doesMethodAllowWriteData(String r100) {
        if (r100.equals("GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals("HEAD") == true) goto L7;
        return true;
    }

    private void failWithException(final CronetException r100) {
        postTaskToExecutor(new AnonymousClass5(this, r100));
    }

    private void failWithExceptionOnExecutor(CronetException r100) {
        this.mException = r100;
        Object r101 = this.mNativeStreamLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        this.mWriteState = 6;     // Catch: Throwable -> L15
        this.mReadState = 6;     // Catch: Throwable -> L15
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        this.mCallback.onFailed(this, this.mResponseInfo, r100);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception notifying of failed request", new Object[]{e});
    }

    private static ArrayList<Map.Entry<String, String>> headersListFromStrings(String[] r100) {
        ArrayList<Map.Entry<String, String>> r101 = new ArrayList(r100.length / 2);
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101.add(new AbstractMap.SimpleImmutableEntry(r100[r102], r100[r102 + 1]));
        r102 = r102 + 2;
        goto L4
    L6:
        return r101;
    }

    private void onCallbackException(Exception r100) {
        CallbackExceptionImpl r101 = new CallbackExceptionImpl("CalledByNative method has thrown an exception", r100);
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception in CalledByNative method", new Object[]{r100});
        failWithExceptionOnExecutor(r101);
    }

    private void onResponseTrailersReceived(String[] r100) {
        final UrlResponseInfoImpl.HeaderBlockImpl r101 = new UrlResponseInfoImpl.HeaderBlockImpl(headersListFromStrings(r100));
        postTaskToExecutor(new AnonymousClass3(this, r101));
    }

    private void onStreamReady(final boolean r100) {
        postTaskToExecutor(new AnonymousClass1(this, r100));
    }

    private void postTaskToExecutor(Runnable r100) {
        this.mExecutor.execute(r100);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(CronetUrlRequestContext.LOG_TAG, "Exception posting task to executor", new Object[]{e});
        monitor-enter(this.mNativeStreamLock);
        this.mWriteState = 6;     // Catch: Throwable -> L11
        this.mReadState = 6;     // Catch: Throwable -> L11
        destroyNativeStreamLocked(false);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static String[] stringsFromHeaderList(List<Map.Entry<String, String>> r100) {
        String[] r101 = new String[r100.size() * 2];
        Iterator<Map.Entry<String, String>> r102 = r100.iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r102.next();
        int r105 = r103 + 1;
        r101[r103] = r104.getKey();
        r103 = r105 + 1;
        r101[r105] = r104.getValue();
        goto L4
    L6:
        return r101;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void read(ByteBuffer r110) {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
        Preconditions.checkHasRemaining(r110);     // Catch: Throwable -> L21
        Preconditions.checkDirect(r110);     // Catch: Throwable -> L21
        if (this.mReadState != 2) goto L20;
        if (isDoneLocked() == false) goto L11;
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    L11:
        if (this.mOnReadCompletedTask != null) goto L13;
        this.mOnReadCompletedTask = new OnReadCompletedRunnable(this, null);     // Catch: Throwable -> L21
    L13:
        this.mReadState = 3;     // Catch: Throwable -> L21
        if (CronetBidirectionalStreamJni.get().readData(this.mNativeStream, this, r110, r110.position(), r110.limit()) == false) goto L17;
        monitor-exit(r100);     // Catch: Throwable -> L21
        return;
    L17:
        this.mReadState = 2;     // Catch: Throwable -> L21
        throw new IllegalArgumentException("Unable to call native read");     // Catch: Throwable -> L21
    L20:
        throw new IllegalStateException("Unexpected read attempt.");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public void setOnDestroyedCallbackForTesting(Runnable r100) {
        this.mOnDestroyedCallbackForTesting = r100;
    }

    public static /* synthetic */ void access$1200(CronetBidirectionalStream r100, CronetException r101) {
        r100.failWithExceptionOnExecutor(r101);
    }

    public static /* synthetic */ int access$202(CronetBidirectionalStream r100, int r101) {
        r100.mReadState = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(CronetBidirectionalStream r100, int r101) {
        r100.mWriteState = r101;
        return r101;
    }

    public static /* synthetic */ void access$700(CronetBidirectionalStream r100, Exception r101) {
        r100.onCallbackException(r101);
    }

    public static /* synthetic */ boolean access$902(CronetBidirectionalStream r100, boolean r101) {
        r100.mRequestHeadersSent = r101;
        return r101;
    }

    @Override // com.ttnet.org.chromium.net.BidirectionalStream
    public void write(ByteBuffer r100, boolean r101) {
        Object r102 = this.mNativeStreamLock;
        monitor-enter(r102);
        Preconditions.checkDirect(r100);     // Catch: Throwable -> L23
        if (r100.hasRemaining() == true) goto L11;
        if (r101 == true) goto L11;
        throw new IllegalArgumentException("Empty buffer before end of stream.");     // Catch: Throwable -> L23
    L11:
        if (this.mEndOfStreamWritten == true) goto L22;
        if (isDoneLocked() == false) goto L16;
        monitor-exit(r102);     // Catch: Throwable -> L23
        return;
    L16:
        this.mPendingData.add(r100);     // Catch: Throwable -> L23
        if (r101 == false) goto L19;
        this.mEndOfStreamWritten = true;     // Catch: Throwable -> L23
    L19:
        monitor-exit(r102);     // Catch: Throwable -> L23
        return;
    L22:
        throw new IllegalArgumentException("Write after writing end of stream.");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private void onResponseHeadersReceived(int r100, String r101, String[] r102, long r103) {
        this.mResponseInfo = prepareResponseInfoOnNetworkThread(r100, r101, r102, r103);     // Catch: Exception -> L5
        postTaskToExecutor(new AnonymousClass2(this));
        return;
    L5:
        failWithException(new CronetExceptionImpl("Cannot prepare ResponseInfo", null));
    }

    private void onWritevCompleted(ByteBuffer[] r100, int[] r101, int[] r102, boolean r110) {
        Object r103 = this.mNativeStreamLock;
        monitor-enter(r103);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L8;
        monitor-exit(r103);     // Catch: Throwable -> L29
        return;
    L8:
        this.mWriteState = 8;     // Catch: Throwable -> L29
        if (this.mFlushData.isEmpty() == true) goto L11;
        sendFlushDataLocked();     // Catch: Throwable -> L29
    L11:
        monitor-exit(r103);     // Catch: Throwable -> L29
        int r104 = 0;
    L14:
        if (r104 >= r100.length) goto L38;
        ByteBuffer r105 = r100[r104];
        if (r105.position() != r101[r104]) goto L27;
        if (r105.limit() != r102[r104]) goto L27;
        r105.position(r105.limit());
        if (r110 == false) goto L25;
        boolean r106 = true;
        if (r104 != (r100.length - 1)) goto L25;
    L26:
        postTaskToExecutor(new OnWriteCompletedRunnable(this, r105, r106));
        r104 = r104 + 1;
    L25:
        r106 = false;
    L27:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during write", null));
        return;
    }

    private UrlResponseInfoImpl prepareResponseInfoOnNetworkThread(int r110, String r111, String[] r112, long r113) {
        return new UrlResponseInfoImpl(Arrays.asList(new String[]{this.mInitialUrl}), r110, "", headersListFromStrings(r112), false, r111, null, r113);
    }

    private void onError(int r100, int r101, int r102, String r103, long r104) {
        UrlResponseInfoImpl r105 = this.mResponseInfo;
        if (r105 == null) goto L6;
        r105.setReceivedByteCount(r104);
    L6:
        if (r100 != 10) goto L8;
    L11:
        failWithException(new QuicExceptionImpl("Exception in BidirectionalStream: " + r103, r100, r101, r102));
        return;
    L8:
        if (r100 == 3) goto L11;
        failWithException(new BidirectionalStreamNetworkException("Exception in BidirectionalStream: " + r103, r100, r101));
    }

    private void onReadCompleted(ByteBuffer r100, int r101, int r102, int r103, long r104) {
        this.mResponseInfo.setReceivedByteCount(r104);
        if (r100.position() == r102) goto L5;
    L19:
        failWithException(new CronetExceptionImpl("ByteBuffer modified externally during read", null));
        return;
    L5:
        if (r100.limit() != r103) goto L19;
        if (r101 < 0) goto L17;
        int r105 = r102 + r101;
        if (r105 > r103) goto L17;
        r100.position(r105);
        OnReadCompletedRunnable r106 = this.mOnReadCompletedTask;
        r106.mByteBuffer = r100;
        if (r101 != 0) goto L14;
        boolean r107 = true;
    L15:
        r106.mEndOfStream = r107;
        postTaskToExecutor(r106);
        return;
    L14:
        r107 = false;
    L17:
        failWithException(new CronetExceptionImpl("Invalid number of bytes read", null));
    }

    public CronetBidirectionalStream(CronetUrlRequestContext r100, String r101, int r102, BidirectionalStream.Callback r103, Executor r104, String r105, List<Map.Entry<String, String>> r110, boolean r111, Collection<Object> r112, boolean r113, int r114, boolean r115, int r116, long r117) {
        this.mNativeStreamLock = new Object();
        this.mReadState = 0;
        this.mWriteState = 0;
        this.mRequestContext = r100;
        this.mInitialUrl = r101;
        this.mInitialPriority = convertStreamPriority(r102);
        this.mCallback = new VersionSafeCallbacks.BidirectionalStreamCallback(r103);
        this.mExecutor = r104;
        this.mInitialMethod = r105;
        this.mRequestHeaders = stringsFromHeaderList(r110);
        this.mDelayRequestHeadersUntilFirstFlush = r111;
        this.mPendingData = new LinkedList();
        this.mFlushData = new LinkedList();
        this.mRequestAnnotations = r112;
        this.mTrafficStatsTagSet = r113;
        this.mTrafficStatsTag = r114;
        this.mTrafficStatsUidSet = r115;
        this.mTrafficStatsUid = r116;
        this.mNetworkHandle = r117;
    }

    private void onMetricsCollected(long r510, long r511, long r512, long r513, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, boolean r714, long r715, long r810, String r811, long r812) {
        Object r100 = this.mNativeStreamLock;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mMetrics != null) goto L17;
        CronetMetrics r101 = new CronetMetrics(r510, r511, r512, r513, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r715, r810, r811, r812, 0, "", "", 0, 0, -1, "", false, false, -1);     // Catch: Throwable -> L18
        this.mMetrics = r101;     // Catch: Throwable -> L18
        int r102 = this.mReadState;     // Catch: Throwable -> L18
        if (r102 != 7) goto L10;
        int r103 = 0;
    L13:
        int r514 = r103;
        RequestFinishedInfoImpl r104 = new RequestFinishedInfoImpl(this.mInitialUrl, this.mRequestAnnotations, r101, r514, this.mResponseInfo, this.mException);     // Catch: Throwable -> L18
        this.mRequestContext.reportRequestFinished(r104);     // Catch: Throwable -> L18
        monitor-exit(r100);     // Catch: Throwable -> L18
        return;
    L10:
        if (r102 != 5) goto L12;
        r103 = 2;
        goto L13
    L12:
        r103 = 1;
        goto L13
    L17:
        throw new IllegalStateException("Metrics collection should only happen once.");     // Catch: Throwable -> L18
    }
}
