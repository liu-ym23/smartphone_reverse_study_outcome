package com.ss.videoarch.live.ttquic;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TTLogManager implements com.ss.videoarch.live.ttquic.b {
    private static final int EVENT_NET_INFO = 3;
    private static final int EVENT_REQUEST_END = 4;
    private static final int EVENT_REQUEST_START = 1;
    private static final int EVENT_RESERVED = 0;
    private static final int EVENT_RESPONSE = 2;
    private static final int HTTPQ_ALOG = 101;
    private static final int HTTPQ_LOG = 100;
    private static final int HTTPX_ALOG = 1;
    private static final int HTTPX_LOG = 0;
    private static final String TAG = null;
    private static final String[] mAlogEventKey = null;
    private com.ss.videoarch.live.ttquic.b mListener;
    private Handler mLogHandler;
    private final Object mLogLock;
    private HandlerThread mLogThread;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f458603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f458604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f458605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TTLogManager f458606d;

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = TTLogManager.access$200(this.f458606d);     // Catch: Throwable -> L15
            monitor-enter(r100);     // Catch: Throwable -> L15
            int r101 = this.f458603a;     // Catch: Throwable -> L12
            if (r101 != 1) goto L7;
        L9:
            AppLogNewUtils.onEventV3(TTLogManager.access$300()[this.f458604b], this.f458605c);     // Catch: Throwable -> L12
        L10:
            monitor-exit(r100);     // Catch: Throwable -> L12
        L18:
            return;
        L7:
            if (r101 == 101) goto L9;
        L12:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L24;
            throw th;
        }

        public a(TTLogManager r100, int r101, int r102, JSONObject r103) {
            this.f458606d = r100;
            this.f458603a = r101;
            this.f458604b = r102;
            this.f458605c = r103;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f458607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f458608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f458609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TTLogManager f458610d;

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = TTLogManager.access$200(this.f458610d);     // Catch: Throwable -> L12
            monitor-enter(r100);     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L5:
            if (TTLogManager.access$400(this.f458610d) == null) goto L7;
            TTLogManager.access$400(this.f458610d).onMonitoryLog(this.f458607a, this.f458608b, this.f458609c);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r100);     // Catch: Throwable -> L9
        L15:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public b(TTLogManager r100, int r101, int r102, String r103) {
            this.f458610d = r100;
            this.f458607a = r101;
            this.f458608b = r102;
            this.f458609c = r103;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TTLogManager f458611a = null;

        static {
            f458611a = new TTLogManager(null);
        }
    }

    static {
        TAG = TTLogManager.class.getCanonicalName();
        mAlogEventKey = new String[]{"live_client_log_reserved", "live_client_log_request_start", "live_client_log_response", "live_client_log_net_info", "live_client_log_request_end"};
    }

    private void deInit() {
        Handler r100 = this.mLogHandler;
        if (r100 == null) goto L5;
        r100.removeCallbacksAndMessages(null);
        this.mLogHandler = null;
    L5:
        HandlerThread r101 = this.mLogThread;
        if (r101 == null) goto L9;
        r101.quit();
        this.mLogThread = null;
        return;
    }

    private void init() {
        if (this.mLogThread != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("ttquic_log_manager");
        this.mLogThread = r100;
        ThreadMethodProxy.start(r100);
    L6:
        if (this.mLogHandler != null) goto L9;
        this.mLogHandler = new Handler(this.mLogThread.getLooper());
        return;
    }

    private TTLogManager() {
        this.mListener = null;
        this.mLogThread = null;
        this.mLogHandler = null;
        this.mLogLock = new Object();
        init();
    }

    public static /* synthetic */ String[] access$300() {
        return mAlogEventKey;
    }

    public static TTLogManager getInstance() {
        return c.f458611a;
    }

    public static int sdk_int() {
        return Build.VERSION.SDK_INT;
    }

    public /* synthetic */ TTLogManager(a r100) {
        this();
    }

    public static /* synthetic */ Object access$200(TTLogManager r100) {
        return r100.mLogLock;
    }

    public static /* synthetic */ com.ss.videoarch.live.ttquic.b access$400(TTLogManager r100) {
        return r100.mListener;
    }

    public void setLogListener(com.ss.videoarch.live.ttquic.b r100) {
        Object r101 = this.mLogLock;
        monitor-enter(r101);
        this.mListener = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onAlog(int r100, int r101, String r102) {
        if (r101 < 0) goto L15;
        if (r101 > 4) goto L15;
    L15:
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L9
    L10:
        Handler r104 = this.mLogHandler;
        if (r104 == null) goto L17;
        if (r103 == null) goto L18;
        r104.post(new a(this, r100, r101, r103));
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.ss.videoarch.live.ttquic.b
    public void onMonitoryLog(int r100, int r101, String r102) {
        Handler r103 = this.mLogHandler;
        if (r103 == null) goto L6;
        r103.post(new b(this, r100, r101, r102));
        return;
    }
}
