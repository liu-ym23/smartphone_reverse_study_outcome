package com.huawei.hms.api;

import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class FailedBinderCallBack {
    private static final long AGING_TIME = 10000;
    public static final String CALLER_ID = "callId";
    private static final Object LOCK_OBJECT = null;
    private static final String TAG = "FailedBinderCallBack";
    private static Map<Long, BinderCallBack> binderCallBackMap;
    private static FailedBinderCallBack instance;

    public interface BinderCallBack {
        void binderCallBack(int r100);
    }

    static {
        binderCallBackMap = new ConcurrentHashMap();
        LOCK_OBJECT = new Object();
    }

    private void agingCheck() {
        long r100 = new Timestamp(System.currentTimeMillis()).getTime() - 10000;
        Iterator<Long> r101 = binderCallBackMap.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Long r102 = r101.next();
        if (r100 < r102.longValue()) goto L4;
        binderCallBackMap.remove(r102);
        goto L4
    }

    public static FailedBinderCallBack getInstance() {
        Object r100 = LOCK_OBJECT;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new FailedBinderCallBack();     // Catch: Throwable -> L10
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return instance;
    }

    private FailedBinderCallBack() {
    }

    public BinderCallBack getCallBack(Long r100) {
        Map<Long, BinderCallBack> r101 = binderCallBackMap;
        if (r101 != null) goto L7;
        HMSLog.e(TAG, "binderCallBackMap is null");
        return null;
    L7:
        return r101.remove(r100);
    }

    private void putCallBackInMap(Long r100, BinderCallBack r101) {
        if (binderCallBackMap != null) goto L6;
        HMSLog.e(TAG, "binderCallBackMap is null");
        return;
    L6:
        agingCheck();
        binderCallBackMap.put(r100, r101);
    }

    public void setCallBack(Long r100, BinderCallBack r101) {
        putCallBackInMap(r100, r101);
    }
}
