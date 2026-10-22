package com.bytedance.memory.model;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class MemoryWidgetResult implements Serializable {
    private static final long serialVersionUID = 5865887187300488157L;
    private List<ResultLeakNode> mActivityLeakNodes;
    private List<ResultLeakNode> mBigObjLeakNodes;
    private List<ResultLeakNode> mBitmapLeakNodes;
    private List<ClassNumber> mClassNumbers;
    private MemoryWidgetMonitor mMemoryWidgetMonitor;

    public static class MemoryWidgetMonitor implements Serializable {
        private static final long serialVersionUID = -5276649811675595534L;
        private int appHeapInstanceSize;
        private long gcDurationMs;
        private long heapDumpDurationMs;
        private String heapDumpFilePath;
        private long heapDumpFileSize;
        private boolean isDebug;
        private int leakTraceSize;
        private String referenceName;
        private String stepTrace;
        private long watchDurationMs;

        public MemoryWidgetMonitor() {
        }

        public String toString() {
            JSONObject r100 = new JSONObject();
            r100.put("appHeapInstanceSize", getAppHeapInstanceSize());     // Catch: JSONException -> L5
            r100.put("gcDurationMs", getGcDurationMs());     // Catch: JSONException -> L5
            r100.put("heapDumpDurationMs", getHeapDumpDurationMs());     // Catch: JSONException -> L5
            r100.put("heapDumpFilePath", getHeapDumpFilePath());     // Catch: JSONException -> L5
            r100.put("heapDumpFileSize", getHeapDumpFileSize());     // Catch: JSONException -> L5
            r100.put("leakTraceSize", getLeakTraceSize());     // Catch: JSONException -> L5
            r100.put("referenceName", getReferenceName());     // Catch: JSONException -> L5
            r100.put("stepTrace", getStepTrace());     // Catch: JSONException -> L5
            r100.put("watchDurationMs", getWatchDurationMs());     // Catch: JSONException -> L5
        L8:
            return r100.toString();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }

        public int getAppHeapInstanceSize() {
            return this.appHeapInstanceSize;
        }

        public long getGcDurationMs() {
            return this.gcDurationMs;
        }

        public long getHeapDumpDurationMs() {
            return this.heapDumpDurationMs;
        }

        public String getHeapDumpFilePath() {
            return this.heapDumpFilePath;
        }

        public long getHeapDumpFileSize() {
            return this.heapDumpFileSize;
        }

        public int getLeakTraceSize() {
            return this.leakTraceSize;
        }

        public String getReferenceName() {
            return this.referenceName;
        }

        public String getStepTrace() {
            return this.stepTrace;
        }

        public long getWatchDurationMs() {
            return this.watchDurationMs;
        }

        public boolean isDebug() {
            return this.isDebug;
        }

        public void setAppHeapInstanceSize(int r100) {
            this.appHeapInstanceSize = r100;
        }

        public void setDebug(boolean r100) {
            this.isDebug = r100;
        }

        public void setGcDurationMs(long r100) {
            this.gcDurationMs = r100;
        }

        public void setHeapDumpDurationMs(long r100) {
            this.heapDumpDurationMs = r100;
        }

        public void setHeapDumpFilePath(String r100) {
            this.heapDumpFilePath = r100;
        }

        public void setHeapDumpFileSize(long r100) {
            this.heapDumpFileSize = r100;
        }

        public void setLeakTraceSize(int r100) {
            this.leakTraceSize = r100;
        }

        public void setReferenceName(String r100) {
            this.referenceName = r100;
        }

        public void setStepTrace(String r100) {
            this.stepTrace = r100;
        }

        public void setWatchDurationMs(long r100) {
            this.watchDurationMs = r100;
        }
    }

    public static class ResultLeakNode implements Serializable {
        private static final long serialVersionUID = -3143585016293965793L;
        private String leakClass;
        private String leakTrace;
        private double retainedHeapSize;

        public ResultLeakNode() {
        }

        public String toString() {
            JSONObject r100 = new JSONObject();
            r100.put("object_class", getLeakClass());     // Catch: JSONException -> L5
            r100.put("object_trace", getLeakTrace());     // Catch: JSONException -> L5
            r100.put("retained_heap_size", getRetainedHeapSize());     // Catch: JSONException -> L5
        L8:
            return r100.toString();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L8
        }

        public String getLeakClass() {
            return this.leakClass;
        }

        public String getLeakTrace() {
            return this.leakTrace;
        }

        public double getRetainedHeapSize() {
            return this.retainedHeapSize;
        }

        public void setLeakClass(String r100) {
            this.leakClass = r100;
        }

        public void setLeakTrace(String r100) {
            this.leakTrace = r100;
        }

        public void setRetainedHeapSize(double r100) {
            this.retainedHeapSize = r100;
        }
    }

    public String toString() {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        JSONArray r102 = new JSONArray();
        JSONArray r103 = new JSONArray();
        JSONArray r104 = new JSONArray();
        Iterator<ResultLeakNode> r105 = this.mBigObjLeakNodes.iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        r101.put(new JSONObject(r105.next().toString()));     // Catch: JSONException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L4
    L10:
        Iterator<ResultLeakNode> r106 = this.mActivityLeakNodes.iterator();
    L12:
        if (r106.hasNext() == false) goto L18;
        r102.put(new JSONObject(r106.next().toString()));     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L18:
        Iterator<ResultLeakNode> r107 = this.mBitmapLeakNodes.iterator();
    L20:
        if (r107.hasNext() == false) goto L26;
        r103.put(new JSONObject(r107.next().toString()));     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L26:
        Iterator<ClassNumber> r108 = this.mClassNumbers.iterator();
    L28:
        if (r108.hasNext() == true) goto L40;
        r100.put("object_node", r101);     // Catch: JSONException -> L36
        r100.put("activity_node", r102);     // Catch: JSONException -> L36
        r100.put("bitmap_node", r103);     // Catch: JSONException -> L36
        r100.put("instance_count_node", r104);     // Catch: JSONException -> L36
    L39:
        return r100.toString();
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L40:
        r104.put(new JSONObject(r108.next().toString()));     // Catch: JSONException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
        goto L28
    }

    public MemoryWidgetResult() {
        this.mBigObjLeakNodes = new ArrayList();
        this.mActivityLeakNodes = new ArrayList();
        this.mBitmapLeakNodes = new ArrayList();
        this.mClassNumbers = new ArrayList();
        this.mMemoryWidgetMonitor = new MemoryWidgetMonitor();
    }

    public List<ResultLeakNode> getActivityLeakNodes() {
        return this.mActivityLeakNodes;
    }

    public List<ResultLeakNode> getBigObjLeakNodes() {
        return this.mBigObjLeakNodes;
    }

    public List<ResultLeakNode> getBitmapLeakNodes() {
        return this.mBitmapLeakNodes;
    }

    public List<ClassNumber> getClassNumbers() {
        return this.mClassNumbers;
    }

    public MemoryWidgetMonitor getMemoryWidgetMonitor() {
        return this.mMemoryWidgetMonitor;
    }

    public void setActivityLeakNodes(List<ResultLeakNode> r100) {
        this.mActivityLeakNodes = r100;
    }

    public void setBigObjLeakNodes(List<ResultLeakNode> r100) {
        this.mBigObjLeakNodes = r100;
    }

    public void setBitmapLeakNodes(List<ResultLeakNode> r100) {
        this.mBitmapLeakNodes = r100;
    }

    public void setClassNumbers(List<ClassNumber> r100) {
        this.mClassNumbers = r100;
    }

    public void setMemoryWidgetMonitor(MemoryWidgetMonitor r100) {
        this.mMemoryWidgetMonitor = r100;
    }

    public void transForm(JSONArray r100, JSONObject r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L11;
        ResultLeakNode r103 = new ResultLeakNode();
        r103.setRetainedHeapSize(JSONArrayProtectorUtils.getJSONObject(r100, 0).optDouble("retainedHeapSize"));     // Catch: JSONException -> L8
        r103.setLeakClass(JSONArrayProtectorUtils.getJSONObject(r100, 0).optString("leakClass"));     // Catch: JSONException -> L8
        r103.setLeakTrace(JSONArrayProtectorUtils.getJSONObject(r100, 0).optString("leakTrace"));     // Catch: JSONException -> L8
    L10:
        this.mBigObjLeakNodes.add(r103);
        r102 = r102 + 1;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L11:
        this.mMemoryWidgetMonitor.setAppHeapInstanceSize(r101.optInt("appHeapInstanceSize"));
        this.mMemoryWidgetMonitor.setLeakTraceSize(r101.optInt("LeakTraceSize"));
        this.mMemoryWidgetMonitor.setHeapDumpFilePath(r101.optString("heapDumpFilePath"));
        this.mMemoryWidgetMonitor.setHeapDumpFileSize(r101.optInt("heapDumpFileSize"));
        this.mMemoryWidgetMonitor.setReferenceName(r101.optString("referenceName"));
        this.mMemoryWidgetMonitor.setDebug(r101.optBoolean("isDebug"));
        this.mMemoryWidgetMonitor.setWatchDurationMs(r101.optInt("watchDurationMs"));
        this.mMemoryWidgetMonitor.setGcDurationMs(r101.optInt("gcDurationMs"));
        this.mMemoryWidgetMonitor.setHeapDumpDurationMs(r101.optInt("heapDumpDurationMs"));
    }
}
