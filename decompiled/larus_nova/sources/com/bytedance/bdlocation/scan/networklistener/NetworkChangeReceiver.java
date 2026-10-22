package com.bytedance.bdlocation.scan.networklistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.thread.AppExecutors;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkChangeReceiver extends BroadcastReceiver {
    private boolean doRegister;
    private NetworkInfo sLastNetWork;
    private long sLastNetWorkTime;
    private Object sLock;

    public NetworkChangeReceiver() {
        this.sLock = new Object();
    }

    public static /* synthetic */ Object access$000(NetworkChangeReceiver r100) {
        return r100.sLock;
    }

    public static /* synthetic */ NetworkInfo access$100(NetworkChangeReceiver r100) {
        return r100.sLastNetWork;
    }

    public static /* synthetic */ long access$200(NetworkChangeReceiver r100) {
        return r100.sLastNetWorkTime;
    }

    public void doRegister(boolean r100) {
        this.doRegister = r100;
    }

    public void notify(NetworkInfo r100) {
        NetworkManager.getInstance().notifyWifiChangedTwo(r100);
        this.sLastNetWork = r100;
        this.sLastNetWorkTime = System.currentTimeMillis();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context r100, final Intent r101) {
        if (this.doRegister == false) goto L6;
        Logger.i("NetworkChangeReceiver onReceive doRegister");
        this.doRegister = false;
        return;
    L6:
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass1(this, r101, r100));
    }
}
