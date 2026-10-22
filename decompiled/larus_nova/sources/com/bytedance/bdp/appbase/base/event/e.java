package com.bytedance.bdp.appbase.base.event;

import android.app.Application;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.h;
import com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaDeviceInfoService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import kotlin.Lazy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements c.g {
    @Override // com.bytedance.bdp.appbase.base.event.c.g
    public final JSONObject getParams() {
        Lazy r100 = BdpAppEventHelper.f200541a;
        Application r101 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();     // Catch: JSONException -> L13
        boolean r102 = ((BdpBpeaDeviceInfoService) BdpManager.getInst().getService(BdpBpeaDeviceInfoService.class)).V0();     // Catch: JSONException -> L13
        String r103 = ((BdpBpeaDeviceInfoService) BdpManager.getInst().getService(BdpBpeaDeviceInfoService.class)).v0(r101);     // Catch: JSONException -> L13
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L13
        if (r102 == false) goto L6;
        int r105 = 1;
    L7:
        JSONObject r106 = r104.put(BdpAppEventConstant.PARAMS_IS_VPN_ON, r105);     // Catch: JSONException -> L13
        if (h.a(r101) == false) goto L10;
        int r107 = 1;
    L11:
        return r106.put(BdpAppEventConstant.PARAMS_NET_AVAILABLE, r107).put("net_type", r103);
    L10:
        r107 = 0;
        goto L11
    L6:
        r105 = 0;
    L13:
        e = move-exception;
        g94.b.b("BdpAppEventHelper", new Object[]{e});
        return new JSONObject();
    }

    public e() {
    }
}
