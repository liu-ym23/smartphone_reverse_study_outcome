package com.ss.android.socialbase.downloader.model;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DownloadThreadInfo {
    public Map<String, ThreadExecutorInfo> afterDownloadThreadExecutors;
    public Map<String, ThreadExecutorInfo> beforeDownloadThreadExecutors;

    /* JADX INFO: loaded from: classes38.dex */
    public static class ThreadExecutorInfo {
        public int activeCount;
        public int corePoolSize;
        public int maximumPoolSize;
        public int queueSize;

        public ThreadExecutorInfo() {
        }
    }

    public DownloadThreadInfo copy() {
        DownloadThreadInfo r100 = new DownloadThreadInfo();
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r101 = this.beforeDownloadThreadExecutors.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, ThreadExecutorInfo> r102 = r101.next();
        r100.beforeDownloadThreadExecutors.put(r102.getKey(), r102.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r103 = this.afterDownloadThreadExecutors.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry<String, ThreadExecutorInfo> r104 = r103.next();
        r100.afterDownloadThreadExecutors.put(r104.getKey(), r104.getValue());
        goto L8
    L10:
        return r100;
    }

    public JSONObject obtainStats() {
        JSONObject r100 = new JSONObject();
        r100.put("beforeDownload", translate(this.beforeDownloadThreadExecutors));     // Catch: Throwable -> L5
        r100.put("afterDownload", translate(this.afterDownloadThreadExecutors));     // Catch: Throwable -> L5
    L7:
        return r100;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public void reset() {
        this.beforeDownloadThreadExecutors.clear();
        this.afterDownloadThreadExecutors.clear();
    }

    public DownloadThreadInfo() {
        this.beforeDownloadThreadExecutors = new ConcurrentHashMap();
        this.afterDownloadThreadExecutors = new ConcurrentHashMap();
    }

    public static ThreadExecutorInfo parse(ExecutorService r100) {
        ThreadExecutorInfo r101 = new ThreadExecutorInfo();
        if (r100 != null) goto L5;
    L7:
        return r101;
    L5:
        if ((r100 instanceof ThreadPoolExecutor) == false) goto L7;
        ThreadPoolExecutor r102 = (ThreadPoolExecutor) r100;
        r101.activeCount = r102.getActiveCount();
        r101.corePoolSize = r102.getCorePoolSize();
        r101.maximumPoolSize = r102.getMaximumPoolSize();
        r101.queueSize = r102.getQueue().size();
        goto L7
    }

    private JSONObject translate(Map<String, ThreadExecutorInfo> r100) throws Throwable {
        JSONObject r101 = new JSONObject();
        Iterator<Map.Entry<String, ThreadExecutorInfo>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry<String, ThreadExecutorInfo> r103 = r102.next();
        ThreadExecutorInfo r104 = r103.getValue();
        JSONObject r105 = new JSONObject();
        r105.put("active", r104.activeCount);
        r105.put("core", r104.corePoolSize);
        r105.put(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, r104.maximumPoolSize);
        r105.put("queue", r104.queueSize);
        r101.put(r103.getKey(), r105);
        goto L4
    L6:
        return r101;
    }
}
