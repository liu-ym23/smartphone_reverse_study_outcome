package com.dtf.face.log;

import android.app.Activity;
import android.app.ActivityManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtf.face.utils.ClientConfigUtil;
import hs7.a;
import us7.h;

/* JADX INFO: loaded from: classes22.dex */
public class MemoryService {
    private static final String TRIGGER_INIT = "init";
    private static MemoryService s_instance;
    private long initAvailMem;

    public static class MemoryInfo extends ActivityManager.MemoryInfo {
        private long diffAvail;
        private int threadCount;
        private final String triggerTime;

        public String toString() {
            Object r100 = JSON.toJSON(this);     // Catch: Throwable -> L6
            if ((r100 instanceof JSONObject) == false) goto L12;
            return ((JSONObject) r100).toJSONString();
        L12:
            return "NULL";
        L6:
            th = move-exception;
            RecordService.getInstance().recordEvent(2, "memory", new String[]{"errMsg", RecordService.getStackTraceString(th)});
            return "NULL";
        }

        public long getDiffAvail() {
            return this.diffAvail;
        }

        public int getThreadCount() {
            return this.threadCount;
        }

        public String getTriggerTime() {
            return this.triggerTime;
        }

        public MemoryInfo(String r100) {
            this.triggerTime = r100;
        }

        public static /* synthetic */ int access$000(MemoryInfo r100) {
            return r100.threadCount;
        }

        public void setDiffAvail(long r100) {
            this.diffAvail = r100;
        }

        public void setThreadCount(int r100) {
            this.threadCount = r100;
        }
    }

    static {
        s_instance = new MemoryService();
    }

    public MemoryService() {
        this.initAvailMem = 0;
    }

    public void init() {
        if (ClientConfigUtil.g() == false) goto L6;
        recordMemoryInfo("init");
        return;
    }

    public static MemoryService getInstance() {
        return s_instance;
    }

    private void recordMemoryInfo(String r100) {
        ActivityManager r101 = (ActivityManager) a.h().getContext().getSystemService("activity");     // Catch: Throwable -> L16
        MemoryInfo r102 = new MemoryInfo(r100);     // Catch: Throwable -> L16
        r101.getMemoryInfo(r102);     // Catch: Throwable -> L16
        r102.setThreadCount(Thread.getAllStackTraces().size());     // Catch: Throwable -> L16
        if ("init".equals(r100) == false) goto L5;
        this.initAvailMem = ((ActivityManager.MemoryInfo) r102).availMem;     // Catch: Throwable -> L16
        r102.setDiffAvail(0);     // Catch: Throwable -> L16
        String r103 = r102.toString();     // Catch: Throwable -> L16
    L14:
        RecordService.getInstance().recordEvent(2, "memory", new String[]{"msg", r103});     // Catch: Throwable -> L16
        return;
    L5:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L16
        r104.put2("triggerTime", r100);     // Catch: Throwable -> L16
        r104.put2("availMem", Long.valueOf(((ActivityManager.MemoryInfo) r102).availMem));     // Catch: Throwable -> L16
        r104.put2("diffAvail", Long.valueOf(this.initAvailMem - ((ActivityManager.MemoryInfo) r102).availMem));     // Catch: Throwable -> L16
        r104.put2("threadCount", Integer.valueOf(MemoryInfo.access$000(r102)));     // Catch: Throwable -> L16
        r103 = r104.toJSONString();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        RecordService.getInstance().recordException(th);
    }

    public void trigger(String r100) {
        if (ClientConfigUtil.g() == true) goto L5;
        return;
    L5:
        if ("Z1008".equals(r100) == false) goto L9;
        Activity r101 = h.f551544b.b();
        if (r101 == null) goto L9;
        r100 = r100 + "-" + r101.getClass().getSimpleName();
    L9:
        recordMemoryInfo(r100);
    }
}
