package com.bytedance.badger.collect.impl.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.utils.ExecutorManager;
import com.bytedance.badger.collect.impl.utils.KLog;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes47.dex */
public class NetworkObserver {
    private final Context mContext;
    private final AtomicBoolean mHasListenNetwork;
    private final Set<WeakReference<OnNetworkReadyListener>> mListeners;

    public interface OnNetworkReadyListener {
        void onNetworkReady();
    }

    private synchronized void notifyObserver() {
        monitor-enter(this);
        ExecutorManager.getInstance().getHandler().post(new AnonymousClass2(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void tryListenNetChange() {
        if (this.mHasListenNetwork.compareAndSet(false, true) == false) goto L12;
        BroadcastReceiver r100 = new AnonymousClass1(this);
        IntentFilter r101 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        INVOKEVIRTUAL_com_bytedance_badger_collect_impl_network_NetworkObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r100, r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        KLog.e(Constants.TAGS.NETWORK, e.getMessage());
        return;
    }

    public NetworkObserver(Context r100) {
        this.mListeners = Collections.synchronizedSet(new HashSet());
        this.mHasListenNetwork = new AtomicBoolean(false);
        this.mContext = r100;
    }

    public static /* synthetic */ Context access$000(NetworkObserver r100) {
        return r100.mContext;
    }

    public static /* synthetic */ void access$100(NetworkObserver r100) {
        r100.notifyObserver();
    }

    public static /* synthetic */ Set access$200(NetworkObserver r100) {
        return r100.mListeners;
    }

    public synchronized void observe(OnNetworkReadyListener r100) {
        monitor-enter(this);
        this.mListeners.add(new WeakReference(r100));     // Catch: Throwable -> L6
        tryListenNetChange();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void unObserve(OnNetworkReadyListener r100) {
        monitor-enter(this);
        Iterator<WeakReference<OnNetworkReadyListener>> r101 = this.mListeners.iterator();     // Catch: Throwable -> L14
    L5:
        if (r101.hasNext() == false) goto L12;
        WeakReference<OnNetworkReadyListener> r102 = r101.next();     // Catch: Throwable -> L14
        if (r102 == null) goto L8;
        if (r102.get() != r100) goto L5;
        r101.remove();     // Catch: Throwable -> L14
        goto L12
    L8:
        r101.remove();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_badger_collect_impl_network_NetworkObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
