package com.bytedance.badger.z;

import android.content.Context;
import android.os.Looper;
import com.bytedance.badger.data.BadgerResult;
import com.bytedance.badger.data.DataJson;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.map.api.monitor.MonitorValueConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class k0 extends u0 {
    public k0() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public final BadgerResult a(Context r110, BadgerModuleBase.BadgerRequestData r111) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        CountDownLatch r100 = new CountDownLatch(1);
        JSONObject[] r112 = new JSONObject[1];
        String[] r113 = new String[1];
        AtomicBoolean r114 = new AtomicBoolean(false);
        Long r101 = Long.valueOf(System.currentTimeMillis());
        a74.p.b(r110.getApplicationContext());     // Catch: Exception -> L34
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.h r102 = com.bytedance.badger.v.d.O;
        KProperty[] r115 = com.bytedance.badger.v.d.f199311a;
        KProperty r103 = r115[41];
        int r116 = ((Number) r102.a()).intValue();
        com.bytedance.badger.v.h r104 = com.bytedance.badger.v.d.P;
        KProperty r105 = r115[42];
        a74.p.a(r116, ((Number) r104.a()).intValue(), new j0(this, r112, r114, r111, r101, r100, r113));
        com.bytedance.badger.v.k r106 = com.bytedance.badger.v.d.N;     // Catch: InterruptedException -> L32
        KProperty r107 = r115[40];     // Catch: InterruptedException -> L32
        if ((!r100.await(((Number) r106.a()).longValue(), TimeUnit.MILLISECONDS)) == false) goto L13;
        r114.set(true);     // Catch: InterruptedException -> L32
        return new BadgerResult.Failure(-1002, "Timeout waiting for sensor data.");
    L13:
        String r108 = r113[0];     // Catch: InterruptedException -> L32
        if (r108 == null) goto L27;
        if (MonitorValueConst.TYPE_CONTEXT_NULL.equals(r108) == true) goto L25;
        if ("bind_failed".equals(r113[0]) == true) goto L25;
        return new BadgerResult.Failure(-1003, "collection error: " + r113[0]);
    L25:
        return new BadgerResult.Failure(-1001, "Failed to bind to Service.");
    L27:
        if (r112[0] == null) goto L31;
        return new BadgerResult.Success(new DataJson(r112[0]));
    L31:
        return new BadgerResult.Failure(-1004, "Unknown error: received no data or error after wait.");
    L32:
        ThreadMethodProxy.currentThread().interrupt();
        return new BadgerResult.Failure(-1005, "Thread interrupted while waiting for sensor data.");
    L34:
        e = move-exception;
        return new BadgerResult.Failure(-1000, e.toString());
    L5:
        return new BadgerResult.Failure(-999, "cannot be called on the main thread.");
    }
}
