package com.lynx.canvas.worker;

import com.lynx.canvas.KryptonService;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonNapiRuntimeFactoryService extends KryptonService {

    public interface NapiRuntimeLifecycleListener {
        void onRuntimeAttach(long r100, String r101);

        void onRuntimeDetach();
    }

    public abstract Object createNapiRuntime(NapiRuntimeLifecycleListener r100);

    public abstract void destoryNapiRuntime(Object r100);

    public KryptonNapiRuntimeFactoryService() {
    }
}
