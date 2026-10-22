package com.dtf.toyger.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class HandlerThreadPool {
    private static final String TAG = "HandlerThreadPool";
    public static List<Integer> check_image_frame_result;
    public static List<Integer> check_raw_frame_result;
    public static List<String> result_image_frame_hash;
    public static String result_image_frame_recently_hash;
    public static List<String> result_raw_frame_hash;
    private static long sKeepAliveTime;
    private static Object sLock;
    private static HashMap<String, a> sThreads;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f273692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f273693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f273694c;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (r100.what != 0) goto L16;
            Object r101 = HandlerThreadPool.access$000();
            monitor-enter(r101);
        L13:
            th = move-exception;
            throw th;
        L7:
            if (this.f273693b != 0) goto L9;
            HandlerThreadPool.access$100().remove(this.f273692a);     // Catch: Throwable -> L13
            boolean r102 = true;
        L10:
            monitor-exit(r101);     // Catch: Throwable -> L13
            if (r102 == false) goto L19;
            b r103 = this.f273694c;
            r103.f273695a = true;
            r103.quitSafely();
            r103.f273695a = false;
            this.f273694c = null;
            return;
        L19:
            return;
        L9:
            r102 = false;
            goto L10
        }

        public a(String r100, b r101) {
            super(r101.getLooper());
            this.f273692a = r100;
            this.f273694c = r101;
        }
    }

    public static class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f273695a;

        @Override // android.os.HandlerThread
        public boolean quit() {
            if (this.f273695a == false) goto L7;
            return super.quit();
        L7:
            throw new IllegalStateException("HandlerThread borrowed from HandlerThreadPool cannot call quit directory, use HandlerThreadPool.returnThread() instead");
        }

        @Override // android.os.HandlerThread
        public boolean quitSafely() {
            if (this.f273695a == false) goto L7;
            return super.quitSafely();
        L7:
            throw new IllegalStateException("HandlerThread borrowed from HandlerThreadPool cannot call quitSafely directly, use HandlerThreadPool.returnThread() instead");
        }

        public b(String r100) {
            super(r100);
            this.f273695a = false;
        }
    }

    static {
        result_raw_frame_hash = new ArrayList();
        result_image_frame_hash = new ArrayList();
        check_raw_frame_result = new ArrayList();
        check_image_frame_result = new ArrayList();
        result_image_frame_recently_hash = "";
        sLock = new Object();
        sKeepAliveTime = 0;
        sThreads = new HashMap();
    }

    public static void clear() {
        result_raw_frame_hash.clear();
        result_image_frame_hash.clear();
        check_raw_frame_result.clear();
        check_image_frame_result.clear();
        result_image_frame_recently_hash = "";
    }

    public HandlerThreadPool() {
    }

    public static /* synthetic */ Object access$000() {
        return sLock;
    }

    public static /* synthetic */ HashMap access$100() {
        return sThreads;
    }

    public static HandlerThread borrowHandlerThread(String r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        a r102 = sThreads.get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L7;
    L8:
        b r103 = new b(r100);     // Catch: Throwable -> L13
        r103.start();     // Catch: Throwable -> L13
        a r104 = new a(r100, r103);     // Catch: Throwable -> L13
        sThreads.put(r100, r104);     // Catch: Throwable -> L13
        r102 = r104;
    L9:
        r102.removeMessages(0);     // Catch: Throwable -> L13
        r102.f273693b++;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r102.f273694c;
    L7:
        if (r102.f273694c != null) goto L9;
    L13:
        th = move-exception;
        throw th;
    }

    public static void returnHandlerThread(HandlerThread r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getName();
        Object r102 = sLock;
        monitor-enter(r102);
        a r103 = sThreads.get(r101);     // Catch: Throwable -> L18
        if (r103 != null) goto L10;
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L10:
        int r104 = r103.f273693b - 1;     // Catch: Throwable -> L18
        r103.f273693b = r104;     // Catch: Throwable -> L18
        if (r104 < 0) goto L17;
        if (r104 != 0) goto L14;
        r103.sendEmptyMessageDelayed(0, sKeepAliveTime);     // Catch: Throwable -> L18
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L18
        return;
    L17:
        throw new IllegalStateException("defRef called on dead thread");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static void setKeepAliveTime(long r100) {
        sKeepAliveTime = r100;
    }
}
