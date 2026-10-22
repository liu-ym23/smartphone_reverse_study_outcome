package com.volcengine.zeus;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f462657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object[] f462658c;

        public final void a() {
            List<ZeusPluginStateListener> r100 = i.a().f462710b;
            if (r100 == null) goto L14;
            CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) r100;
            if (r101.size() <= 0) goto L18;
            Iterator r102 = r101.iterator();
        L8:
            if (r102.hasNext() == false) goto L19;
            ZeusPluginStateListener r103 = (ZeusPluginStateListener) r102.next();
            if (TextUtils.isEmpty(this.f462656a) == false) goto L12;
            String r104 = "UNKNOWN";
        L13:
            r103.onPluginStateChange(r104, this.f462657b, this.f462658c);
            goto L8
        L12:
            r104 = this.f462656a;
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

        public a(String r100, int r101, Object[] r102) {
            this.f462656a = r100;
            this.f462657b = r101;
            this.f462658c = r102;
        }
    }

    public ZeusPluginStateListener() {
    }

    public void onPluginStateChange(String r100, int r101, Object... r102) {
    }

    public void onStateChangeOnCurThread(String r100, int r101, Object... r102) {
    }

    static {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static void postStateChange(String r100, int r101, Object... r102) {
        mHandler.post(new a(r100, r101, r102));
        List<ZeusPluginStateListener> r103 = i.a().f462710b;
        if (r103 == null) goto L14;
        CopyOnWriteArrayList r104 = (CopyOnWriteArrayList) r103;
        if (r104.size() <= 0) goto L18;
        Iterator r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L19;
        ZeusPluginStateListener r106 = (ZeusPluginStateListener) r105.next();
        if (TextUtils.isEmpty(r100) == false) goto L12;
        String r107 = "UNKNOWN";
    L13:
        r106.onStateChangeOnCurThread(r107, r101, r102);
        goto L8
    L12:
        r107 = r100;
        goto L13
    L19:
        return;
    L18:
        return;
    }
}
