package com.volcengine.zeus;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FAILED = 12;
    public static final int EVENT_REQUEST_START = 11;
    public static final int EVENT_REQUEST_SUCCESS = 0;
    private static final Handler mHandler = null;

    public static class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object[] c;

        public final void a() {
            List<ZeusPluginStateListener> r0 = i.a().b;
            if (r0 == null) goto L14;
            CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) r0;
            if (r1.size() <= 0) goto L18;
            Iterator r2 = r1.iterator();
        L8:
            if (r2.hasNext() == false) goto L19;
            ZeusPluginStateListener r3 = (ZeusPluginStateListener) r2.next();
            if (TextUtils.isEmpty(this.a) == false) goto L12;
            String r4 = "UNKNOWN";
        L13:
            r3.onPluginStateChange(r4, this.b, this.c);
            goto L8
        L12:
            r4 = this.a;
            goto L13
        L19:
            return;
        L18:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r1, int r2, Object[] r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public ZeusPluginStateListener() {
    }

    public void onPluginStateChange(String r1, int r2, Object... r3) {
    }

    public void onStateChangeOnCurThread(String r1, int r2, Object... r3) {
    }

    static {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static void postStateChange(String r3, int r4, Object... r5) {
        mHandler.post(new a(r3, r4, r5));
        List<ZeusPluginStateListener> r0 = i.a().b;
        if (r0 == null) goto L14;
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) r0;
        if (r1.size() <= 0) goto L18;
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L19;
        ZeusPluginStateListener r6 = (ZeusPluginStateListener) r2.next();
        if (TextUtils.isEmpty(r3) == false) goto L12;
        String r7 = "UNKNOWN";
    L13:
        r6.onStateChangeOnCurThread(r7, r4, r5);
        goto L8
    L12:
        r7 = r3;
        goto L13
    L19:
        return;
    L18:
        return;
    }
}
