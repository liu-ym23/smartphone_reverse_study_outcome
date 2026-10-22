package com.bytedance.bdp.appbase.base.event;

import android.text.TextUtils;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.event.BdpEventService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class CallHostEventImpl implements f {
    private static final String TAG = "CallHostEventImpl";

    public CallHostEventImpl() {
    }

    private void doSendEventV3(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L7:
        ((BdpEventService) BdpManager.getInst().getService(BdpEventService.class)).e0();
        return;
    L9:
        new JSONObject(r101);     // Catch: Throwable -> L6
    L6:
        g94.b.b(TAG, new Object[]{"JSON params format error."});
        goto L7
    }

    public void sendEventV3(String r100, String r101) {
        doSendEventV3(r100, r101);
    }

    @Override // com.bytedance.bdp.appbase.base.event.f
    public void sendEventV3Sync(String r100, String r101) {
        doSendEventV3(r100, r101);
    }

    public void sendEventV1(String r100, String r101, String r102, long r103, long r104, String r105) {
        if (TextUtils.isEmpty(r105) == false) goto L9;
    L7:
        ((BdpEventService) BdpManager.getInst().getService(BdpEventService.class)).c0();
        return;
    L9:
        new JSONObject(r105);     // Catch: Throwable -> L6
    L6:
        g94.b.b(TAG, new Object[]{"JSON params format error."});
        goto L7
    }
}
