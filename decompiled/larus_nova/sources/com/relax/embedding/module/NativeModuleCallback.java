package com.relax.embedding.module;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import ipa.c;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public class NativeModuleCallback {
    private long mPtr;
    private boolean mWithCodec;
    private Handler mainHandler;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f404633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NativeModuleCallback f404634b;

        @Override // java.lang.Runnable
        public final void run() {
            NativeModuleCallback.access$000(this.f404634b, this.f404633a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(NativeModuleCallback r100, long r101) {
            this.f404634b = r100;
            this.f404633a = r101;
        }
    }

    private native void nativeDestroyNativeModuleCallback(long r100);

    private native void nativeOnInvokeFailed(long r100, int r101, String r102);

    private native void nativeOnInvokeSucceeded(long r100, byte[] r101);

    private native void nativeOnInvokeSucceededNoCodec(long r100, Object r101);

    public void destroy() {
        long r100 = this.mPtr;
        if (r100 == 0) goto L6;
        this.mainHandler.post(new a(this, r100));
        this.mPtr = 0;
        return;
    }

    public void finalize() throws Throwable {
        destroy();
        super.finalize();
    }

    public void onSucceeded(Object r100) {
        if (this.mWithCodec == false) goto L5;
        ByteBuffer r101 = c.b(r100);
        r101.flip();
        byte[] r102 = new byte[r101.remaining()];
        r101.get(r102);
        nativeOnInvokeSucceeded(this.mPtr, r102);
        return;
    L5:
        nativeOnInvokeSucceededNoCodec(this.mPtr, r100);
    }

    public NativeModuleCallback(long r100, boolean r101) {
        this.mWithCodec = true;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPtr = r100;
        this.mWithCodec = r101;
    }

    public static /* synthetic */ void access$000(NativeModuleCallback r100, long r101) {
        r100.nativeDestroyNativeModuleCallback(r101);
    }

    public void onFailed(int r100, String r101) {
        nativeOnInvokeFailed(this.mPtr, r100, r101);
    }
}
