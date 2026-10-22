package com.bytedance.common.jato;

import android.app.Application;
import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes15.dex */
public class Jato {
    public Jato() {
    }

    public static void glPrioPromote(String r100) {
    }

    public static void preloadBoostInfo() {
    }

    public static void preloadCpusetInfo() {
    }

    public static boolean isInited() {
        return JatoXL.isInited();
    }

    public static void bindBigCore() {
        JatoXL.bindBigCore();
    }

    public static void bindLittleCore() {
        JatoXL.bindLittleCore();
    }

    public static void disableClassVerify() {
        JatoXL.disableClassVerify();
    }

    public static void enableClassVerify() {
        JatoXL.enableClassVerify();
    }

    public static void optTextureBufferQueue() {
        JatoXL.optTextureBufferQueue();
    }

    public static void releaseBoost() {
        JatoXL.releaseBoost();
    }

    public static void resetCoreBind() {
        JatoXL.resetCoreBind();
    }

    public static void resetRenderThread() {
        JatoXL.resetRenderThread();
    }

    public static void bindBigCore(int r100) {
        JatoXL.bindBigCore(r100);
    }

    public static void bindLittleCore(int r100) {
        JatoXL.bindLittleCore(r100);
    }

    public static void boostGLESInit(boolean r100) {
        JatoXL.boostGLESInit(r100);
    }

    public static void initBoostFramework(Context r100) {
        JatoXL.initBoostFramework(r100);
    }

    public static void initScheduler(int r100) {
        JatoXL.initScheduler(r100);
    }

    public static void requestBlockGc(long r100) {
        JatoXL.requestBlockGc(r100);
    }

    public static void resetCoreBind(int r100) {
        JatoXL.resetCoreBind(r100);
    }

    public static void setDisableGcBlocker(boolean r100) {
        JatoXL.setDisableGcBlocker(r100);
    }

    public static void startBlockGc(String r100) {
        JatoXL.startBlockGc(r100);
    }

    public static void stopBlockGc(String r100) {
        JatoXL.stopBlockGc(r100);
    }

    public static void tryCpuBoost(long r100) {
        JatoXL.tryCpuBoost(r100);
    }

    public static void tryGpuBoost(long r100) {
        JatoXL.tryGpuBoost(r100);
    }

    public static void boostRenderThread(Application r100, int r101) {
        JatoXL.boostRenderThread(r100, r101);
    }

    public static synchronized void init(Context r100, boolean r101, JatoListener r102, ExecutorService r103) {
        monitor-enter(Jato.class);
        init(r100, r101, r102, r103, null);     // Catch: Throwable -> L8
        monitor-exit(Jato.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r100, boolean r101, JatoListener r102, ExecutorService r103, HostInfoModel r104) {
        monitor-enter(Jato.class);
        monitor-exit(Jato.class);
    }
}
