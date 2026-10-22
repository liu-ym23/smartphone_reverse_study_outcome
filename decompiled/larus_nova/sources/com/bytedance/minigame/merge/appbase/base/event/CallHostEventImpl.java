package com.bytedance.minigame.merge.appbase.base.event;

import android.text.TextUtils;
import com.bytedance.bdp.bdpbase.ipc.r;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.event.BdpEventService;
import g94.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public class CallHostEventImpl implements r {
    private static final String TAG = "CallHostEventImpl";

    public CallHostEventImpl() {
    }

    public void sendEventV3(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L7:
        ((BdpEventService) BdpManager.getInst().getService(BdpEventService.class)).e0();
        return;
    L9:
        new JSONObject(r101);     // Catch: Throwable -> L6
    L6:
        b.b(TAG, new Object[]{"JSON params format error."});
        goto L7
    }

    public void sendEventV1(String r100, String r101, String r102, long r103, long r104, String r105) {
        if (TextUtils.isEmpty(r105) == false) goto L9;
    L7:
        ((BdpEventService) BdpManager.getInst().getService(BdpEventService.class)).c0();
        return;
    L9:
        new JSONObject(r105);     // Catch: Throwable -> L6
    L6:
        b.b(TAG, new Object[]{"JSON params format error."});
        goto L7
    }
}
