package com.bytedance.retrofit2.ttnet;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetExceptionStorage extends IOException {
    private static final long serialVersionUID = -1606114814728652693L;
    public Object infoObj;
    public boolean reportMonitorError;
    public boolean reportMonitorOk;
    public String traceCode;
    public String url;

    public TTNetExceptionStorage() {
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public String getTraceCode() {
        return this.traceCode;
    }

    public TTNetExceptionStorage(String r100) {
        super(r100);
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public TTNetExceptionStorage(String r100, Throwable r101) {
        super(r100, r101);
        this.reportMonitorOk = false;
        this.reportMonitorError = false;
        this.url = "empty url";
        this.traceCode = "empty traceCode";
        this.infoObj = null;
    }

    public static TTNetExceptionStorage wrapIfNeeded(Exception r100, String r101, String r102, Object r110) {
        if ((r100 instanceof TTNetExceptionStorage) == true) goto L5;
        TTNetExceptionStorage r103 = new TTNetExceptionStorage(r100.getMessage(), r100);
        r103.setInfo(false, true, r101, r102, r110);
        return r103;
    L5:
        return (TTNetExceptionStorage) r100;
    }

    public void setInfo(boolean r100, boolean r101, String r102, String r103, Object r104) {
        this.reportMonitorOk = r100;
        this.reportMonitorError = r101;
        this.url = r102;
        this.traceCode = r103;
        this.infoObj = r104;
    }
}
