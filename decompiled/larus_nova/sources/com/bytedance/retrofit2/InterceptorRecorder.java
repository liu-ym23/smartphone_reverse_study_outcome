package com.bytedance.retrofit2;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class InterceptorRecorder {
    public Deque<LogEntry> interceptorLogStack;
    public Deque<LogEntry> interceptorLogTrace;

    public static class LogEntry {
        public String exception_name;
        public boolean isInternalInterceptor;
        public String name;
        public long reqEndNs;
        public long reqStartNs;
        public long rspEndNs;
        public long rspStartNs;

        public LogEntry deepCopy() {
            LogEntry r100 = new LogEntry(this.name, this.isInternalInterceptor, this.reqStartNs);
            r100.reqEndNs = this.reqEndNs;
            r100.rspStartNs = this.rspStartNs;
            r100.rspEndNs = this.rspEndNs;
            r100.exception_name = this.exception_name;
            return r100;
        }

        public LogEntry(String r100, boolean r101, long r102) {
            this.reqEndNs = -1;
            this.rspStartNs = -1;
            this.rspEndNs = -1;
            this.exception_name = null;
            this.name = r100;
            this.isInternalInterceptor = r101;
            this.reqStartNs = r102;
        }
    }

    public InterceptorRecorder deepCopy() {
        InterceptorRecorder r100 = new InterceptorRecorder();
        r100.interceptorLogStack = new ArrayDeque();
        Iterator<LogEntry> r101 = this.interceptorLogStack.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        LogEntry r102 = r101.next();
        r100.interceptorLogStack.push(r102.deepCopy());
        goto L4
    L6:
        r100.interceptorLogTrace = new ArrayDeque();
        Iterator<LogEntry> r103 = this.interceptorLogTrace.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        LogEntry r104 = r103.next();
        r100.interceptorLogTrace.push(r104.deepCopy());
        goto L8
    L10:
        return r100;
    }

    public LogEntry peek() {
        return this.interceptorLogStack.peek();
    }

    public LogEntry pop() {
        LogEntry r100 = this.interceptorLogStack.pop();     // Catch: NoSuchElementException -> L4
        this.interceptorLogTrace.push(r100);     // Catch: NoSuchElementException -> L4
        return r100;
    L4:
        return null;
    }

    public int size() {
        return this.interceptorLogStack.size();
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        new HashMap();
        Iterator<LogEntry> r102 = this.interceptorLogTrace.iterator();
        long r103 = 0;
        long r104 = 0;
    L4:
        if (r102.hasNext() == false) goto L15;
        LogEntry r105 = r102.next();
        JSONObject r110 = new JSONObject();
        r110.put("name", r105.name);
        long r111 = TTMetricsUtil.calculateDurationUs(r105.reqStartNs, r105.reqEndNs);
        if (r111 <= 0) goto L8;
        r103 = r103 + r111;
    L8:
        r110.put(HiAnalyticsConstant.Direction.REQUEST, r111);
        long r112 = TTMetricsUtil.calculateDurationUs(r105.rspStartNs, r105.rspEndNs);
        if (r112 <= 0) goto L11;
        r104 = r104 + r112;
    L11:
        r110.put(HiAnalyticsConstant.Direction.RESPONSE, r112);
        String r106 = r105.exception_name;
        if (r106 == null) goto L14;
        r110.put(BaseHttpRequestInfo.KEY_EXCEPTION, r106);
    L14:
        r101.put(r110);
        goto L4
    L15:
        r100.put("detail", r101);
        r100.put("req_total", r103);
        r100.put("rsp_total", r104);
        return r100;
    }

    public InterceptorRecorder() {
        this.interceptorLogStack = new ArrayDeque();
        this.interceptorLogTrace = new ArrayDeque();
    }

    public void push(LogEntry r100) {
        this.interceptorLogStack.push(r100);
    }
}
