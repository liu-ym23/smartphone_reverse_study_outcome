package com.lynx.canvas.worker;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonNapiRuntimeFactory {
    private String TAG;
    private WeakReference<KryptonApp> mApp;

    private native void nativeOnNapiRuntimeAttach(long r100, long r101, String r102);

    private native void nativeOnNapiRuntimeDetach(long r100);

    private KryptonNapiRuntimeFactoryService getService() {
        KryptonApp r100 = this.mApp.get();
        if (r100 != null) goto L6;
        KryptonLLog.i(this.TAG, "[worker] app == null");
        return null;
    L6:
        KryptonNapiRuntimeFactoryService r101 = (KryptonNapiRuntimeFactoryService) r100.getService(KryptonNapiRuntimeFactoryService.class);
        if (r101 != null) goto L10;
        KryptonLLog.i(this.TAG, "[worker] service == null");
        return null;
    L10:
        return r101;
    }

    public KryptonNapiRuntimeFactory(KryptonApp r100) {
        this.TAG = "KryptonNapiRuntimeFactory";
        this.mApp = new WeakReference(r100);
    }

    public static /* synthetic */ String access$000(KryptonNapiRuntimeFactory r100) {
        return r100.TAG;
    }

    public Object createNapiRuntime(final long r100) {
        KryptonNapiRuntimeFactoryService r101 = getService();
        if (r101 != null) goto L6;
        return null;
    L6:
        KryptonLLog.i(this.TAG, "[worker] create napi runtime");
        return r101.createNapiRuntime(new AnonymousClass1(this, r100));
    }

    public void destroyNapiRuntime(Object r100) {
        KryptonNapiRuntimeFactoryService r101 = getService();
        if (r101 != null) goto L5;
        return;
    L5:
        KryptonLLog.i(this.TAG, "[worker] destory napi runtime");
        r101.destoryNapiRuntime(r100);
    }

    public static /* synthetic */ void access$200(KryptonNapiRuntimeFactory r100, long r101) {
        r100.nativeOnNapiRuntimeDetach(r101);
    }

    public static /* synthetic */ void access$100(KryptonNapiRuntimeFactory r100, long r101, long r102, String r103) {
        r100.nativeOnNapiRuntimeAttach(r101, r102, r103);
    }
}
