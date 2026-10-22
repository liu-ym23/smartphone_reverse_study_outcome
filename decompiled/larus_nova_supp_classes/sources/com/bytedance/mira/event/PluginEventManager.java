package com.bytedance.mira.event;

import com.bytedance.mira.log.MiraLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginEventManager {
    private static final String TAG = "PluginEventManager";
    private static volatile PluginEventManager sInstance;
    private final List<PluginEventListener> mPluginLogListeners;

    public static PluginEventManager getInstance() {
        if (sInstance != null) goto L13;
        monitor-enter(PluginEventManager.class);
        sInstance = new PluginEventManager();     // Catch: Throwable -> L9
        monitor-exit(PluginEventManager.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    private PluginEventManager() {
        this.mPluginLogListeners = new CopyOnWriteArrayList();
    }

    public void addPluginEventListener(PluginEventListener r2) {
        this.mPluginLogListeners.add(r2);
    }

    public void removePluginEventListener(PluginEventListener r2) {
        this.mPluginLogListeners.remove(r2);
    }

    public void notifyPluginEvent(int r10, String r11, int r12, long r13) {
        execEventListeners(r10, r11, r12, -1, null, r13);
    }

    public void notifyPluginErrorEvent(int r10, String r11, int r12, Throwable r13, long r14) {
        execEventListeners(r10, r11, r12, -1, r13, r14);
    }

    public void notifyPluginSuccessEvent(int r10, String r11, int r12, long r13, long r15) {
        execEventListeners(r10, r11, r12, r13, null, r15);
    }

    private void execEventListeners(int r19, String r20, int r21, long r22, Throwable r24, long r25) {
        String r1 = "PluginEventManager execEventListeners, size=" + this.mPluginLogListeners.size();
        String r8 = MiraLogger.TAG_LOAD;
        MiraLogger.i(MiraLogger.TAG_LOAD, r1);
        Iterator<PluginEventListener> r16 = this.mPluginLogListeners.iterator();
    L4:
        if (r16.hasNext() == false) goto L13;
        PluginEventListener r17 = r16.next();
        MiraLogger.i(r8, "PluginEventManager execEventListeners, status=" + r19 + ", packageName=" + r20 + ", versionCode=" + r21 + ", listener=" + r17.toString());     // Catch: Throwable -> L10
        String r0 = r8;
        r17.onPluginEvent(r19, r20, r21, r22, r24, r25);     // Catch: Throwable -> L14
    L12:
        r8 = r0;
    L11:
        MiraLogger.e(r0, "PluginEventManager execEventListeners has error, status=" + r19 + ", packageName=" + r20 + ", versionCode=" + r21 + ", listener=" + r17.toString(), r24);
    L10:
        r0 = r8;
        goto L11
    }
}
