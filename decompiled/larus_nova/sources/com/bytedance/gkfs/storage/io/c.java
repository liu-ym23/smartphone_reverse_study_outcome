package com.bytedance.gkfs.storage.io;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.iesgurd.core.EventSubType;
import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Throwable f245362a;

    public c(Throwable r100) {
        this.f245362a = r100;
    }

    public final void a() {
        EventSubType r100 = EventSubType.BUILD_MMAP_BLOCK_BUFFER_FAILED;
        String r101 = this.f245362a.getMessage();
        JSONObject r102 = new JSONObject();
        r102.put("sub_type", r100.getType());
        if (r101 == null) goto L5;
        r102.put(LocationMonitorConst.ERR_MSG, r101);
    L5:
        y86.a.c("geckosdk_event_message", r102);
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
