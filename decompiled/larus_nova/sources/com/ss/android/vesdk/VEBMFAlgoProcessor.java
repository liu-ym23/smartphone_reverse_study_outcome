package com.ss.android.vesdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes40.dex */
public class VEBMFAlgoProcessor {
    private static final String TAG = "VEBMFAlgoProcessor";
    private final Map<String, VEListener.h> callbacks;
    private final AtomicBoolean destroyed;
    private long handle;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VEBMFAlgoProcessor f455512a;

        @Override // java.lang.Runnable
        public final void run() {
            VEBMFAlgoProcessor.access$000(this.f455512a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(VEBMFAlgoProcessor r100) {
            this.f455512a = r100;
        }
    }

    public static native long nativeCreate(Object r100, String r101);

    public static native void nativeDeconstruct(long r100);

    public static native void nativeDestroy(long r100);

    public static native void nativeProcess(long r100, String r101, int r102, String r103);

    private void deconstruct() {
        VELogUtil.i(TAG, "deconstruct handle=" + this.handle);
        long r100 = this.handle;
        if (r100 == 0) goto L6;
        nativeDeconstruct(r100);
        this.handle = 0;
        return;
    }

    public synchronized void destroy() {
        monitor-enter(this);
        VELogUtil.i(TAG, "destroy handle=" + this.handle);     // Catch: Throwable -> L11
        if (this.destroyed.get() == true) goto L9;
        long r100 = this.handle;     // Catch: Throwable -> L11
        if (r100 == 0) goto L9;
        nativeDestroy(r100);     // Catch: Throwable -> L11
        this.destroyed.set(true);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public VEBMFAlgoProcessor() {
        this.handle = 0;
        this.callbacks = new HashMap();
        this.destroyed = new AtomicBoolean(false);
    }

    public static /* synthetic */ void access$000(VEBMFAlgoProcessor r100) {
        r100.deconstruct();
    }

    public synchronized int create(String r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.destroyed.get() == false) goto L10;
        VELogUtil.i(TAG, "create fail cause by destroyed. Alloc new VEBMFAlgoProcessor please.");     // Catch: Throwable -> L18
        monitor-exit(this);
        return -1;
    L10:
        if (this.handle != 0) goto L15;
        this.handle = nativeCreate(this, r100);     // Catch: Throwable -> L18
        monitor-exit(this);
        return 0;
    L15:
        VELogUtil.i(TAG, "create handle=" + this.handle);     // Catch: Throwable -> L18
        monitor-exit(this);
        return -1;
    }

    public void onInfo(float r100, String r101) {
        if ("VEBMFAlgoProcessor_destroy_called".equals(r101) == false) goto L7;
        new Handler(Looper.getMainLooper()).post(new a(this));
        return;
    L7:
        if (this.callbacks.containsKey(r101) == true) goto L9;
        return;
    L9:
        if (this.callbacks.get(r101) == null) goto L13;
        this.callbacks.get(r101).onDone();
        this.callbacks.remove(r101);
        return;
    }

    public int process(String r100, VEQualityScoreType r101, VEListener.h r102) {
        if (this.destroyed.get() == false) goto L6;
        return -1;
    L6:
        if (r102 == null) goto L20;
        if (r100 == null) goto L20;
        if (new PolarisFileWrapper(r100).exists() == true) goto L14;
        VELogUtil.e(TAG, "File not found: ".concat(r100));
        return -100;
    L14:
        if (this.handle != 0) goto L16;
    L19:
        return -1;
    L16:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        String r103 = "VEBMFAlgoProcessor_" + String.valueOf(r100.hashCode());
        this.callbacks.put(r103, r102);
        nativeProcess(this.handle, r100, r101.ordinal(), r103);
        return 0;
    L20:
        VELogUtil.e(TAG, "mediaFile/callback is null");
        return -1;
    }
}
