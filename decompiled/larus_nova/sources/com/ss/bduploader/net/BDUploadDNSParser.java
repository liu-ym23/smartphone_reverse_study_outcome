package com.ss.bduploader.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.bduploader.BDUploadLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class BDUploadDNSParser {
    public static final int BDUPLOAD_DNS_BACKUP_TYPE = 1;
    public static final int BDUPLOAD_DNS_DEFAULT_EXPIRED_TIME = 2;
    public static final int BDUPLOAD_DNS_MAIN_DELAYED_USE_BACKUP_TIME = 3;
    public static final int BDUPLOAD_DNS_MAIN_TYPE = 0;
    public static final int DNS_TYPE_HTTP_ALI = 1;
    public static final int DNS_TYPE_HTTP_GOOGLE = 3;
    public static final int DNS_TYPE_HTTP_OWN = 2;
    public static final int DNS_TYPE_LOCAL = 0;
    public static final int MSG_IS_PARSER_ERROR = 2;
    public static final int MSG_IS_PARSER_RETRY = 1;
    public static final int MSG_IS_PARSER_SUCCESS = 3;
    public static final int PARSER_IS_BACKUP = 1;
    public static final int PARSER_IS_MAIN = 0;
    private static final String TAG = "BDUploadDNSParser";
    public static int mGlobalBackType = 2;
    public static int mGlobalBackUpDelayedTime = 0;
    public static int mGlobalDefaultExpiredTime = 60;
    public static int mGlobalMainType;
    private static BDUploadDNSParser mInstance;
    private Handler mHandler;
    private Lock mLock;
    private Map<String, BDUploadHostProcessor> mProcessors;
    private int mRefCount;
    private int mState;
    private HandlerThread mThread;
    private int mTimeOut;
    private int mType;

    public void release() {
    }

    public static BDUploadDNSParser getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(BDUploadDNSParser.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new BDUploadDNSParser();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDUploadDNSParser.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public BDUploadDNSParser() {
        this.mTimeOut = 5;
        this.mLock = new ReentrantLock();
        this.mProcessors = new HashMap();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(TAG);
        this.mThread = r100;
        ThreadMethodProxy.start(r100);
        final Looper r101 = this.mThread.getLooper();
        this.mHandler = new AnonymousClass1(this, r101);
    }

    private void addListenerInternal(String r110, BDUploadDNSParserListener r111) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        BDUploadLog.d(TAG, String.format("---add listener:%s for host:%s", new Object[]{r111, r110}));
        this.mLock.lock();
        BDUploadHostProcessor r100 = this.mProcessors.get(r110);     // Catch: Throwable -> L19
        BDUploadLog.d(TAG, String.format("get processor:%s", new Object[]{r100}));     // Catch: Throwable -> L19
        if (r100 != null) goto L9;
        r100 = new BDUploadHostProcessor(r110, this.mHandler, mGlobalMainType, mGlobalBackType, mGlobalBackUpDelayedTime);     // Catch: Throwable -> L19
        BDUploadLog.d(TAG, String.format("create processor:%s", new Object[]{r100}));     // Catch: Throwable -> L19
        boolean r101 = true;
    L10:
        if (r111 != null) goto L12;
    L14:
        this.mProcessors.put(r110, r100);     // Catch: Throwable -> L19
        if (r101 == false) goto L17;
        BDUploadLog.d(TAG, String.format("new processor implement parse", new Object[0]));     // Catch: Throwable -> L19
        r100.processMsg(0, new BDUploadDNSInfo(mGlobalMainType, r110, null, 0, null));     // Catch: Throwable -> L19
    L17:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end add listener", new Object[0]));
        return;
    L12:
        if (r100.mListeners.containsKey(r111) == true) goto L14;
        BDUploadLog.d(TAG, String.format("add listener", new Object[0]));     // Catch: Throwable -> L19
        r100.mListeners.put(r111, 1);     // Catch: Throwable -> L19
        goto L14
    L9:
        r101 = false;
    L19:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void proccessFailMsg(int r110, BDUploadDNSInfo r111) {
        if (r111 != null) goto L5;
    L27:
        BDUploadLog.d(TAG, String.format("proc fail msg  fail, info or host is null", new Object[0]));
        return;
    L5:
        if (r111.mHost == null) goto L27;
        BDUploadLog.d(TAG, String.format("----proc fail msg what:%d host:%s", new Object[]{Integer.valueOf(r110), r111.mHost}));
        this.mLock.lock();
        BDUploadHostProcessor r100 = this.mProcessors.get(r111.mHost);     // Catch: Throwable -> L24
        BDUploadLog.d(TAG, String.format("get processor:%s host:%s", new Object[]{r100, r111.mHost}));     // Catch: Throwable -> L24
        if (r100 != null) goto L11;
    L22:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end proc fail msg what", new Object[0]));
        return;
    L11:
        if (r100.isValidSourceId(r111.mId) == false) goto L22;
        r100.processResult(r110, r111);     // Catch: Throwable -> L24
        if (r100.isEnd() == false) goto L21;
        BDUploadLog.d(TAG, String.format("processor end, notify result", new Object[0]));     // Catch: Throwable -> L24
        Iterator<BDUploadDNSParserListener> r112 = r100.mListeners.keySet().iterator();     // Catch: Throwable -> L24
    L16:
        if (r112.hasNext() == false) goto L20;
        BDUploadDNSParserListener r101 = r112.next();     // Catch: Throwable -> L24
        if (r101 == null) goto L16;
        BDUploadLog.d(TAG, String.format("listener:%s oncompletion fail", new Object[]{r101}));     // Catch: Throwable -> L24
        r101.onCompletion(0, r111.mHost, null, 0, null);     // Catch: Throwable -> L24
        goto L16
    L20:
        r100.mListeners.clear();     // Catch: Throwable -> L24
        this.mProcessors.remove(r111.mHost);     // Catch: Throwable -> L24
        goto L22
    L21:
        BDUploadLog.d(TAG, String.format("processor is not end", new Object[0]));     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void proccessSucMsg(int r110, BDUploadDNSInfo r111) {
        if (r111 != null) goto L5;
    L24:
        BDUploadLog.d(TAG, String.format("proc suc msg  fail, info or host is null", new Object[0]));
        return;
    L5:
        if (r111.mHost == null) goto L24;
        BDUploadLog.d(TAG, String.format("----proc suc msg what:%d host:%s", new Object[]{Integer.valueOf(r110), r111.mHost}));
        this.mLock.lock();
        BDUploadHostProcessor r112 = this.mProcessors.get(r111.mHost);     // Catch: Throwable -> L21
        BDUploadLog.d(TAG, String.format("get processor:%s host:%s", new Object[]{r112, r111.mHost}));     // Catch: Throwable -> L21
        if (r112 == null) goto L19;
        HashMap<BDUploadDNSParserListener, Integer> r100 = r112.mListeners;     // Catch: Throwable -> L21
        if (r100 == null) goto L19;
        Iterator<BDUploadDNSParserListener> r101 = r100.keySet().iterator();     // Catch: Throwable -> L21
    L14:
        if (r101.hasNext() == false) goto L18;
        BDUploadDNSParserListener r102 = r101.next();     // Catch: Throwable -> L21
        if (r102 == null) goto L14;
        BDUploadLog.d(TAG, String.format("listener:%s oncompletion suc", new Object[]{r102}));     // Catch: Throwable -> L21
        r102.onCompletion(0, r111.mHost, r111.mIpList, r111.mExpiredTime, null);     // Catch: Throwable -> L21
        goto L14
    L18:
        r112.mListeners.clear();     // Catch: Throwable -> L21
        this.mProcessors.remove(r111.mHost);     // Catch: Throwable -> L21
        BDUploadLog.d(TAG, String.format("remove all listeners and remove host", new Object[0]));     // Catch: Throwable -> L21
    L19:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end proc suc msg", new Object[0]));
        return;
    L21:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void processParseMsg(int r100, BDUploadDNSInfo r101) {
        if (r101 != null) goto L5;
    L17:
        BDUploadLog.d(TAG, String.format("proc parser msg  fail, info or host is null", new Object[0]));
        return;
    L5:
        if (r101.mHost == null) goto L17;
        BDUploadLog.d(TAG, String.format("----proc parser msg what:%d host:%s", new Object[]{Integer.valueOf(r100), r101.mHost}));
        this.mLock.lock();
        BDUploadHostProcessor r102 = this.mProcessors.get(r101.mHost);     // Catch: Throwable -> L14
        if (r102 == null) goto L11;
        BDUploadLog.d(TAG, String.format("----get processor:%s host:%s", new Object[]{r102, r101.mHost}));     // Catch: Throwable -> L14
        r102.processMsg(r100, r101);     // Catch: Throwable -> L14
    L12:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end proc parser msg", new Object[0]));
        return;
    L11:
        BDUploadLog.d(TAG, String.format("****get processor null for host:%s", new Object[]{r101.mHost}));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    private void removeListenerInternal(String r100, BDUploadDNSParserListener r101) {
        if (TextUtils.isEmpty(r100) == true) goto L19;
        if (r101 == null) goto L22;
        BDUploadLog.d(TAG, String.format("---remove listener:%s for host:%s", new Object[]{r101, r100}));
        this.mLock.lock();
        BDUploadHostProcessor r102 = this.mProcessors.get(r100);     // Catch: Throwable -> L16
        BDUploadLog.d(TAG, String.format("get processor:%s", new Object[]{r102}));     // Catch: Throwable -> L16
        if (r102 == null) goto L10;
        BDUploadLog.d(TAG, String.format("remove listener", new Object[0]));     // Catch: Throwable -> L16
        r102.mListeners.remove(r101);     // Catch: Throwable -> L16
    L10:
        if (r102 != null) goto L12;
    L14:
        this.mLock.unlock();
        BDUploadLog.d(TAG, String.format("****end remove listener", new Object[0]));
        return;
    L12:
        if (r102.mListeners.size() != 0) goto L14;
        BDUploadLog.d(TAG, String.format("listeners empty remove host from processors", new Object[0]));     // Catch: Throwable -> L16
        this.mProcessors.remove(r100);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    L22:
        return;
    }

    public static void setIntValue(int r100, int r101) {
        BDUploadLog.d(TAG, String.format("****set value:%d for key:%d", new Object[]{Integer.valueOf(r101), Integer.valueOf(r100)}));
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L11;
        if (r100 != 2) goto L7;
        mGlobalDefaultExpiredTime = r101;
        return;
    L7:
        if (r100 != 3) goto L17;
        mGlobalBackUpDelayedTime = r101;
        return;
    L17:
        return;
    L11:
        mGlobalBackType = r101;
        return;
    L12:
        mGlobalMainType = r101;
    }

    public void addHost(String r100, BDUploadDNSParserListener r101) {
        addListenerInternal(r100, r101);
    }

    public void postParseHostMsg(String r100, int r110) {
        BDUploadDNSInfo r101 = new BDUploadDNSInfo(r110, r100, null, 0, null);
        Message r102 = new Message();
        r102.what = 0;
        r102.obj = r101;
        this.mHandler.sendMessage(r102);
    }

    public void removeHost(String r100, BDUploadDNSParserListener r101) {
        removeListenerInternal(r100, r101);
    }

    public static /* synthetic */ void access$000(BDUploadDNSParser r100, int r101, BDUploadDNSInfo r102) {
        r100.processParseMsg(r101, r102);
    }

    public static /* synthetic */ void access$100(BDUploadDNSParser r100, int r101, BDUploadDNSInfo r102) {
        r100.proccessFailMsg(r101, r102);
    }

    public static /* synthetic */ void access$200(BDUploadDNSParser r100, int r101, BDUploadDNSInfo r102) {
        r100.proccessSucMsg(r101, r102);
    }
}
