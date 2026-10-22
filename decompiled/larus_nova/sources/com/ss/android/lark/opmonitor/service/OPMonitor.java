package com.ss.android.lark.opmonitor.service;

import android.os.SystemClock;
import android.os.Trace;
import byb.e;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes37.dex */
public class OPMonitor {
    private static final String TAG = "OPMonitor";

    @SerializedName(ReportCardMonitorPlugin.CATEGORIES)
    @Expose
    private HashMap<String, Object> categories;
    private OPMonitorCode code;
    private OPMonitorCode codeIfError;
    private HashMap<String, Object> commons;
    private long endTime;
    private boolean flushed;
    private OPMonitorLevel level;

    @SerializedName("metrics")
    @Expose
    private HashMap<String, Object> metrics;

    @SerializedName("name")
    @Expose
    private String name;
    private int reportPlatform;
    private e service;
    private long startTime;
    private Set<String> tags;
    private long time;

    private synchronized void flushInner() {
        monitor-enter(this);
    L46:
        th = move-exception;
        throw th;
    L4:
        if (this.flushed == false) goto L9;
        Log.w(TAG, "this opmonitor is already flushed!!!");     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L9:
        this.flushed = true;     // Catch: Throwable -> L46
        OPMonitorCode r100 = this.code;     // Catch: Throwable -> L46
        if (r100 == null) goto L13;
    L17:
        if (this.level != null) goto L20;
        if (r100 == null) goto L20;
        setLevel(r100.level);     // Catch: Throwable -> L46
    L20:
        if (r100 == null) goto L23;
        addCategoryValue(ReportCardMonitorPlugin.MONITOR_DOMAIN, r100.domain);     // Catch: Throwable -> L46
        addCategoryValue(ReportCardMonitorPlugin.MONITOR_CODE, Integer.valueOf(r100.code));     // Catch: Throwable -> L46
        addCategoryValue("monitor_id", r100.ID);     // Catch: Throwable -> L46
        addCategoryValue(ReportCardMonitorPlugin.MONITOR_MESSAGE, r100.message);     // Catch: Throwable -> L46
    L23:
        if (this.tags.size() <= 0) goto L26;
        addCategoryValue("monitor_tags", tagsInLine());     // Catch: Throwable -> L46
    L26:
        if (fyb.e.f479342b.f479343a == null) goto L28;
        this.commons.putAll(Collections.EMPTY_MAP);     // Catch: Throwable -> L46
    L28:
        Trace.beginSection("computeFlushCommons");     // Catch: Throwable -> L46
        HashMap<String, Object> r101 = this.commons;     // Catch: Throwable -> L46
        if (r101 != null) goto L31;
    L41:
        Trace.endSection();     // Catch: Throwable -> L46
        if (this.service == null) goto L44;
        Trace.beginSection("computeServiceFlush");     // Catch: Throwable -> L46
        this.service.flush(this);     // Catch: Throwable -> L46
        Trace.endSection();     // Catch: Throwable -> L46
        Trace.beginSection("computeServiceLog");     // Catch: Throwable -> L46
        this.service.log(this);     // Catch: Throwable -> L46
        Trace.endSection();     // Catch: Throwable -> L46
    L44:
        monitor-exit(this);
        return;
    L31:
        if (r101.size() <= 0) goto L41;
        Iterator<String> r102 = this.commons.keySet().iterator();     // Catch: Throwable -> L46
    L34:
        if (r102.hasNext() == false) goto L41;
        String r103 = r102.next();     // Catch: Throwable -> L46
        if (containsKey(r103) == true) goto L34;
        Object r104 = this.commons.get(r103);     // Catch: Throwable -> L46
        if ((r104 instanceof Number) == true) goto L39;
        addCategoryValue(r103, r104);     // Catch: Throwable -> L46
        goto L34
    L39:
        addMetricValue(r103, r104);     // Catch: Throwable -> L46
        goto L34
    L13:
        if (hasErrorInfo() == false) goto L15;
        r100 = this.codeIfError;     // Catch: Throwable -> L46
        goto L17
    L15:
        r100 = null;
        goto L17
    }

    public synchronized void flush() {
        monitor-enter(this);
        flushInner();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getCategories() {
        monitor-enter(this);
        HashMap<String, Object> r100 = this.categories;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getCommons() {
        monitor-enter(this);
        HashMap<String, Object> r100 = this.commons;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getData() {
        monitor-enter(this);
        HashMap<String, Object> r100 = new HashMap();     // Catch: Throwable -> L6
        r100.putAll(this.metrics);     // Catch: Throwable -> L6
        r100.putAll(this.categories);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitorLevel getLevel() {
        monitor-enter(this);
        OPMonitorLevel r100 = this.level;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HashMap<String, Object> getMetrics() {
        monitor-enter(this);
        HashMap<String, Object> r100 = this.metrics;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getName() {
        monitor-enter(this);
        String r100 = this.name;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor timing() {
        monitor-enter(this);
        long r100 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        long r101 = this.startTime;     // Catch: Throwable -> L9
        if (r101 != 0) goto L6;
        this.startTime = r100;     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return this;
    L6:
        this.endTime = r100;     // Catch: Throwable -> L9
        addMetricValue("duration", Long.valueOf(r100 - r101));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean hasErrorInfo() {
        if (getValue("error_code") == null) goto L5;
    L8:
        return true;
    L5:
        if (getValue("error_msg") != null) goto L8;
        return false;
    }

    private String tagsInLine() {
        Set<String> r100 = this.tags;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.size() == 0) goto L21;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = this.tags.iterator();
        boolean r103 = true;
    L9:
        if (r102.hasNext() == false) goto L15;
        String r104 = r102.next();
        if (r103 == true) goto L13;
        r101.append(",");
    L13:
        r101.append(r104);
        r103 = false;
        goto L9
    L15:
        return r101.toString();
    L21:
        return null;
    }

    public OPMonitorCode getMonitorCode() {
        OPMonitorCode r100 = this.code;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (hasErrorInfo() == true) goto L10;
        return null;
    L10:
        return this.codeIfError;
    }

    public OPMonitor setResultTypeCancel() {
        return setResultType("cancel");
    }

    public OPMonitor setResultTypeFail() {
        return setResultType("fail");
    }

    public OPMonitor setResultTypeSuccess() {
        return setResultType("success");
    }

    public OPMonitor setResultTypeTimeout() {
        return setResultType("timeout");
    }

    public int getReportPlatform() {
        return this.reportPlatform;
    }

    public OPMonitor(OPMonitorCode r100) {
        this(fyb.e.f479342b, null, r100);
    }

    public synchronized OPMonitor addCommonParams(Map<String, Object> r100) {
        monitor-enter(this);
        if (r100 != null) goto L13;
    L11:
        monitor-exit(this);
        return this;
    L13:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r100.size() <= 0) goto L11;
        this.commons.putAll(r100);     // Catch: Throwable -> L8
        goto L11
    }

    public OPMonitor addMap(Map<String, Object> r100) {
        Iterator<String> r101 = r100.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();
        Object r103 = r100.get(r102);
        if ((r103 instanceof Number) == true) goto L7;
        addCategoryValue(r102, r103);
        goto L4
    L7:
        addMetricValue(r102, r103);
        goto L4
    L9:
        return this;
    }

    public synchronized OPMonitor addTag(String r100) {
        monitor-enter(this);
        this.tags.add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean containsKey(String r100) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.metrics.containsKey(r100) == true) goto L9;
        if (this.categories.containsKey(r100) == true) goto L9;
        boolean r101 = false;
    L10:
        monitor-exit(this);
        return r101;
    L9:
        r101 = true;
        goto L10
    }

    public synchronized void flush(e r100) {
        monitor-enter(this);
        Trace.beginSection("computeMonitorTime");     // Catch: Throwable -> L23
        if (this.flushed == false) goto L9;
        Log.w(TAG, "this opmonitor is already flushed!!!");     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L9:
        if (r100 != null) goto L14;
        Log.w(TAG, "serviceInterface is null!");     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L14:
        if ((r100 instanceof OPTrace) == true) goto L16;
    L20:
        this.service = r100;     // Catch: Throwable -> L23
        flushInner();     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if (((OPTrace) r100).getBatchEnabled() == true) goto L20;
        Log.w(TAG, "batchEnabled is false,traceId:" + ((OPTrace) r100).getTracingID());     // Catch: Throwable -> L23
        Trace.endSection();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized Object getValue(String r100) {
        monitor-enter(this);
        Object r101 = this.metrics.get(r100);     // Catch: Throwable -> L8
        if (r101 != null) goto L6;
        r101 = this.categories.get(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public OPMonitor reportPlatform(int r100) {
        this.reportPlatform = r100;
        return this;
    }

    public OPMonitor setDuration(long r100) {
        addMetricValue("duration", Long.valueOf(r100));
        return this;
    }

    public OPMonitor setError(Throwable r100) {
        if (r100 == null) goto L8;
        StackTraceElement[] r101 = r100.getStackTrace();
        if (r101 == null) goto L8;
        if (r101.length <= 0) goto L8;
        addCategoryValue("monitor_line", Integer.valueOf(r101[0].getLineNumber()));
        addCategoryValue("monitor_function", r101[0].getMethodName());
        addCategoryValue("monitor_file", r101[0].getClassName());
    L8:
        return this;
    }

    public OPMonitor setErrorCode(String r100) {
        addCategoryValue("error_code", r100);
        return this;
    }

    public OPMonitor setErrorMessage(String r100) {
        addCategoryValue("error_msg", r100);
        return this;
    }

    public synchronized OPMonitor setLevel(OPMonitorLevel r100) {
        monitor-enter(this);
        this.level = r100;     // Catch: Throwable -> L6
        addCategoryValue("monitor_level", Integer.valueOf(r100.getNumber()));     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor setMonitorCode(OPMonitorCode r100) {
        monitor-enter(this);
        this.code = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor setMonitorCodeIfError(OPMonitorCode r100) {
        monitor-enter(this);
        this.codeIfError = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public OPMonitor setResultType(String r100) {
        addCategoryValue("result_type", r100);
        return this;
    }

    public synchronized OPMonitor setTime(long r100) {
        monitor-enter(this);
        this.time = r100;     // Catch: Throwable -> L6
        addMetricValue("time", Long.valueOf(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public OPMonitor tracing(OPTrace r100) {
        addCategoryValue(BindCardPayConfirmConstants.Key.TRACE_ID, r100.getTracingID());
        return this;
    }

    public OPMonitor(String r100) {
        this(fyb.e.f479342b, r100, null);
    }

    public OPMonitor tracing(String r100) {
        addCategoryValue(BindCardPayConfirmConstants.Key.TRACE_ID, r100);
        return this;
    }

    public OPMonitor(String r100, OPMonitorCode r101) {
        this(fyb.e.f479342b, r100, r101);
    }

    public synchronized OPMonitor addCategoryValue(String r100, Object r101) {
        monitor-enter(this);
        this.categories.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized OPMonitor addMetricValue(String r100, Object r101) {
        monitor-enter(this);
        this.metrics.put(r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public OPMonitor(e r100, OPMonitorCode r101) {
        this(r100, null, r101);
    }

    public OPMonitor(e r100, String r101) {
        this(r100, r101, null);
    }

    public OPMonitor(e r100, String r101, OPMonitorCode r102) {
        this.flushed = false;
        this.service = r100;
        this.name = r101;
        this.code = r102;
        this.metrics = new HashMap();
        this.categories = new HashMap();
        this.tags = new HashSet();
        this.commons = new HashMap();
    }
}
