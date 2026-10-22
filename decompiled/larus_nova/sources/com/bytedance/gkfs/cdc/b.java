package com.bytedance.gkfs.cdc;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.iesgurd.core.EventSubType;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f245149a = null;

    static {
        f245149a = new b();
    }

    public b() {
    }

    public static void a() {
        EventSubType r100 = EventSubType.NON_HEAP_BUFFER_ALLOCATE_FAILED;
        JSONObject r101 = new JSONObject();
        r101.put("sub_type", r100.getType());
        r101.put(LocationMonitorConst.ERR_MSG, "allocate non-heap buffer failed");
        y86.a.c("geckosdk_event_message", r101);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
