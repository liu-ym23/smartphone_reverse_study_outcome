package com.facebook.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes3.dex */
public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = null;
    private String mApplicationTag;
    private int mMinimumLoggingLevel;

    static {
        sInstance = new FLogDefaultLoggingDelegate();
    }

    private FLogDefaultLoggingDelegate() {
        this.mApplicationTag = "unknown";
        this.mMinimumLoggingLevel = 5;
    }

    public static FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    private static String getStackTraceString(Throwable r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        return r101.toString();
    }

    private String prefixTag(String r100) {
        if (this.mApplicationTag != null) goto L5;
        return r100;
    L5:
        return this.mApplicationTag + ":" + r100;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public boolean isLoggable(int r100) {
        if (this.mMinimumLoggingLevel > r100) goto L5;
        return true;
    L5:
        return false;
    }

    public void setApplicationTag(String r100) {
        this.mApplicationTag = r100;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void setMinimumLoggingLevel(int r100) {
        this.mMinimumLoggingLevel = r100;
    }

    private static String getMsg(String r100, Throwable r101) {
        return r100 + '\n' + getStackTraceString(r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String r100, String r101) {
        println(3, r100, r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String r100, String r101) {
        println(6, r100, r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String r100, String r101) {
        println(4, r100, r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String r100, String r101) {
        println(2, r100, r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String r100, String r101) {
        println(5, r100, r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String r100, String r101) {
        println(6, r100, r101);
    }

    private void println(int r100, String r101, String r102) {
        prefixTag(r101);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String r100, String r101, Throwable r102) {
        println(3, r100, r101, r102);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String r100, String r101, Throwable r102) {
        println(6, r100, r101, r102);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String r100, String r101, Throwable r102) {
        println(4, r100, r101, r102);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void log(int r100, String r101, String r102) {
        println(r100, r101, r102);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String r100, String r101, Throwable r102) {
        println(2, r100, r101, r102);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String r100, String r101, Throwable r102) {
        println(5, r100, r101, r102);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String r100, String r101, Throwable r102) {
        println(6, r100, r101, r102);
    }

    private void println(int r100, String r101, String r102, Throwable r103) {
        prefixTag(r101);
        getMsg(r102, r103);
    }
}
