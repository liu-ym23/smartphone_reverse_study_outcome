package com.bytedance.bdp.bdpbase.ipc;

import android.os.IBinder;

/* JADX INFO: loaded from: classes11.dex */
public interface d extends IBinder {

    public static final class a {
        public static d a() {
            return new BdpIPCBinderImpl();
        }
    }

    void registerObject(r r100);
}
