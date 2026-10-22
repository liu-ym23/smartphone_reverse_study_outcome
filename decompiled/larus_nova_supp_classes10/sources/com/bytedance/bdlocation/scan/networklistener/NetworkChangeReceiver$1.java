package com.bytedance.bdlocation.scan.networklistener;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.bdlocation.log.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class NetworkChangeReceiver$1 implements Runnable {
    final /* synthetic */ NetworkChangeReceiver this$0;
    final /* synthetic */ Context val$context;
    final /* synthetic */ Intent val$intent;

    @Override // java.lang.Runnable
    public void run() {
        com_bytedance_bdlocation_scan_networklistener_NetworkChangeReceiver$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_bytedance_bdlocation_scan_networklistener_NetworkChangeReceiver$1__run$___twin___() {
        Object r0 = NetworkChangeReceiver.access$000(this.this$0);     // Catch: Exception -> L24
        monitor-enter(r0);     // Catch: Exception -> L24
        Logger.i(NetworkManager.TAG + ":NetworkChangeReceiver notify network change action:" + this.val$intent.getAction());     // Catch: Throwable -> L21
        NetworkInfo r1 = ((ConnectivityManager) this.val$context.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L21
        if (r1 == null) goto L15;
        Logger.i(NetworkManager.TAG + ":NetworkChangeReceiver  networkInfo type:" + r1.getType());     // Catch: Throwable -> L21
        if (NetworkChangeReceiver.access$100(this.this$0) != null) goto L9;
    L18:
        this.this$0.notify(r1);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L9:
        if (NetworkChangeReceiver.access$100(this.this$0).getType() != r1.getType()) goto L18;
        if ((System.currentTimeMillis() - NetworkChangeReceiver.access$200(this.this$0)) >= 1000) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L15:
        if ((System.currentTimeMillis() - NetworkChangeReceiver.access$200(this.this$0)) >= 1000) goto L18;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Exception -> L24
    L24:
        Logger.i(NetworkManager.TAG + ":NetworkChangeReceiver get active network info error");
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_bytedance_bdlocation_scan_networklistener_NetworkChangeReceiver$1_com_larus_apm_impl_protector_RunnableLancet_run(NetworkChangeReceiver$1 r1) {
        r1.com_bytedance_bdlocation_scan_networklistener_NetworkChangeReceiver$1__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public NetworkChangeReceiver$1(NetworkChangeReceiver r1, Intent r2, Context r3) {
        this.this$0 = r1;
        this.val$intent = r2;
        this.val$context = r3;
    }
}
