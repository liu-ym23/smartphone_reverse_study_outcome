package com.bytedance.crypto.cloudsync;

import com.bytedance.crypto.monitor.ErrorEvent;
import com.bytedance.crypto.monitor.NormalEvent;
import com.bytedance.crypto.monitor.proto.CloudSyncData;

/* JADX INFO: loaded from: classes15.dex */
public class EventTrace {
    public EventTrace() {
    }

    public static void eventTrace(int r100, int r110, String r111, String r112, long r113, int r114) {
        int r101 = 1;
        if (r100 != 0) goto L10;
        if (r110 == 0) goto L8;
        if (r110 == 1) goto L8;
        NormalEvent.getInstance().eventRecord(0, r110, r111, r112, r113, r114);
        return;
    L8:
        NormalEvent.getInstance().eventReport(0, r110, r111, r112, r113);
        return;
    L10:
        if (r110 != 5) goto L12;
    L20:
        r101 = 2;
    L21:
        ErrorEvent.eventTrace(0, r110, r111, r112, r100, r113, CloudSyncData.newBuilder().setCryptoMode(r101).setDataSize(r114).build());
        return;
    L12:
        if (r110 == 7) goto L20;
        if (r110 == 4) goto L21;
        if (r110 == 6) goto L21;
        r101 = 0;
        goto L21
    }
}
