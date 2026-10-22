package com.bytedance.upc.common;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.upc.IUpcLifecycleService;
import com.bytedance.upc.a;
import com.bytedance.upc.common.activity.ActivityLifeObserver;
import com.bytedance.upc.common.network.UpcNetChangeManager;
import ip7.b;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/upc/common/CommonService;", "Lcom/bytedance/upc/IUpcLifecycleService;", "<init>", "()V", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public final class CommonService implements IUpcLifecycleService {
    public CommonService() {
    }

    @Override // com.bytedance.upc.IUpcLifecycleService
    public final int priority() {
        return 0;
    }

    @Override // com.bytedance.upc.IUpcLifecycleService
    public final void init(Context r110, a r111) {
        Application r100 = hp7.a.f486453a;
        Context r112 = r110.getApplicationContext();
        if (r112 == null) goto L41;
        Application r113 = (Application) r112;
        hp7.a.f486453a = r113;
        hp7.a.f486454b = r111;
        r113.registerActivityLifecycleCallbacks(ActivityLifeObserver.f272462e);
        b.f495310a = Intrinsics.areEqual(null, "local_test");
        IntentFilter r114 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Application r101 = hp7.a.f486453a;
        if (r101 == null) goto L39;
        UpcNetChangeManager.f272466c.getClass();
        UpcNetChangeManager r102 = (UpcNetChangeManager) UpcNetChangeManager.f272465b.getValue();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L32:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L37;
        ReceiverRegisterCrashOptimizer.registerReceiver(r102, r114);
        return;
    L37:
        throw e;
    L10:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r114) == false) goto L23;
        int r115 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r102, r114, 0, null, null, 2, r101).result;     // Catch: Exception -> L32
        if (r115 != 1) goto L16;
        r101.registerReceiver(r102, r114);     // Catch: Exception -> L32
        return;
    L16:
        if (r115 != 2) goto L18;
        new Intent();     // Catch: Exception -> L32
        return;
    L18:
        if (r115 == 3) goto L43;
        r101.registerReceiver(r102, r114);     // Catch: Exception -> L32
        return;
    L43:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L32
        r101.registerReceiver(r102, r114, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L32
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L30:
        r101.registerReceiver(r102, r114);     // Catch: Exception -> L32
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r114) == false) goto L30;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L32
        ContextCompat.registerReceiver(r101, r102, r114, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L32
        return;
    L39:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
    L41:
        throw new TypeCastException("null cannot be cast to non-null type android.app.Application");
    }
}
