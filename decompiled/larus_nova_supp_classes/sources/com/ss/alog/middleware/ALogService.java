package com.ss.alog.middleware;

import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class ALogService implements IALogProtocol {
    protected static ALogService sInstance;
    protected static volatile boolean sIsStrickMode;

    public static void destroySafely() {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.destroy();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void flushSafely() {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.flush();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void forceLogShardingSafely() {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.forceLogSharding();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void initSafely() {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.init();
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void releaseSafely() {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.release();
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

    public static void changeLevelSafely(int r1) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.changeLevel(r1);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void initSafely(String r1) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.init(r1);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void setAlogService(ALogService r0) {
        sInstance = r0;
    }

    public static void dSafely(String r1, String r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.d(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void eSafely(String r1, String r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.e(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void iSafely(String r1, String r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.i(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void vSafely(String r1, String r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.v(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void wSafely(String r1, String r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.w(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void eSafely(String r1, Throwable r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.e(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void wSafely(String r1, Throwable r2) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.w(r1, r2);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void bundleSafely(int r1, String r2, Bundle r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.bundle(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void eSafely(String r1, String r2, Throwable r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.e(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void headerSafely(int r1, String r2, String r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.header(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void intentSafely(int r1, String r2, Intent r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.intent(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void jsonSafely(int r1, String r2, String r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.json(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void statcktraceSafely(int r1, String r2, StackTraceElement[] r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.statcktrace(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void threadSafely(int r1, String r2, Thread r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.thread(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void throwableSafely(int r1, String r2, Throwable r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.throwable(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }

    public static void wSafely(String r1, String r2, Throwable r3) {
        ALogService r0 = sInstance;
        if (r0 == null) goto L5;
        r0.w(r1, r2, r3);
        return;
    L5:
        if (sIsStrickMode == true) goto L8;
        return;
    L8:
        throw new RuntimeException("implement AlogService and set sInstance first");
    }
}
