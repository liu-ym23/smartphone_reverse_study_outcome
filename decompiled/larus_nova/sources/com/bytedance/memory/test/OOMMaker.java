package com.bytedance.memory.test;

import com.bytedance.android.live.saas.middleware.alog.config.ALogDefaultConfig;
import com.bytedance.crash.CrashType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import r17.d;
import u17.a;

/* JADX INFO: loaded from: classes21.dex */
public class OOMMaker {
    private static ArrayList<Byte[]> sArrayList;

    public OOMMaker() {
    }

    private static void encreaseMem(int r100) {
    }

    static {
        sArrayList = new ArrayList();
    }

    public static void createOOM() {
        new a().onCrash(CrashType.JAVA, new OutOfMemoryError(EffectConstants.CHANNEL_TEST), ThreadMethodProxy.currentThread(), System.currentTimeMillis());
    }

    public static void encreaseMem() {
        encreaseMem(15728640);
    }

    public static void createReachTop(int r100) {
    L3:
        if (d.b() >= r100) goto L9;
        encreaseMem(ALogDefaultConfig.DEVICE_MAX_LOG_SPACE_SIZE);
        Thread.sleep(500);     // Catch: InterruptedException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L3
    }
}
