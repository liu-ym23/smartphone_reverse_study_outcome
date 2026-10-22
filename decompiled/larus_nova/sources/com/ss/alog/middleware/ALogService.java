package com.ss.alog.middleware;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class ALogService implements IALogProtocol {
    protected static ALogService sInstance;
    protected static volatile boolean sIsStrickMode;

    public static void destroySafely() {
        ALogService r100 = sInstance;
        if (r100 == null) goto L5;
        r100.destroy();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void flushSafely() {
        ALogService r100 = sInstance;
        if (r100 == null) goto L5;
        r100.flush();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void forceLogShardingSafely() {
        ALogService r100 = sInstance;
        if (r100 == null) goto L5;
        r100.forceLogSharding();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void initSafely() {
        ALogService r100 = sInstance;
        if (r100 == null) goto L5;
        r100.init();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void releaseSafely() {
        ALogService r100 = sInstance;
        if (r100 == null) goto L5;
        r100.release();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public ALogService() {
        sInstance = this;
    }

    public static void changeLevelSafely(int r100) {
        ALogService r101 = sInstance;
        if (r101 == null) goto L5;
        r101.changeLevel(r100);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void initSafely(String r100) {
        ALogService r101 = sInstance;
        if (r101 == null) goto L5;
        r101.init(r100);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void setAlogService(ALogService r100) {
        sInstance = r100;
    }

    public static void dSafely(String r100, String r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.d(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void eSafely(String r100, String r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.e(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void iSafely(String r100, String r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.i(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void vSafely(String r100, String r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.v(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void wSafely(String r100, String r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.w(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void eSafely(String r100, Throwable r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.e(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void wSafely(String r100, Throwable r101) {
        ALogService r102 = sInstance;
        if (r102 == null) goto L5;
        r102.w(r100, r101);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void bundleSafely(int r100, String r101, Bundle r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.bundle(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void eSafely(String r100, String r101, Throwable r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.e(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void headerSafely(int r100, String r101, String r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.header(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void intentSafely(int r100, String r101, Intent r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.intent(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void jsonSafely(int r100, String r101, String r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.json(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void statcktraceSafely(int r100, String r101, StackTraceElement[] r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.statcktrace(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void threadSafely(int r100, String r101, Thread r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.thread(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void throwableSafely(int r100, String r101, Throwable r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.throwable(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void wSafely(String r100, String r101, Throwable r102) {
        ALogService r103 = sInstance;
        if (r103 == null) goto L5;
        r103.w(r100, r101, r102);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }
}
