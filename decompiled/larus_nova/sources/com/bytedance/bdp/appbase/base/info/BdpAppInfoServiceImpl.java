package com.bytedance.bdp.appbase.base.info;

import android.text.TextUtils;
import com.bytedance.bdp.appbase.base.ipc.BdpIpcService;
import com.bytedance.bdp.bdpbase.ipc.IpcException;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import f94.c;
import g94.b;

/* JADX INFO: loaded from: classes3.dex */
public class BdpAppInfoServiceImpl implements BdpAppInfoService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f200561a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f200562b;

    public BdpAppInfoServiceImpl() {
    }

    public static boolean E2(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        b.b("BdpAppInfoServiceImpl", new Object[]{"DID is empty."});
    L11:
        return false;
    L5:
        if (TextUtils.isDigitsOnly(r100.trim()) == true) goto L7;
    L9:
        b.b("BdpAppInfoServiceImpl", new Object[]{"Illegal format DID: ", r100});
        goto L11
    L7:
        if ("0".equals(r100) == true) goto L9;
        return true;
    }

    @Override // com.bytedance.bdp.appbase.base.info.BdpAppInfoService
    public final String getDeviceId(String r100) {
        if (TextUtils.isEmpty(f200561a) == false) goto L5;
        String r101 = ((BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class)).getHostInfo().getDeviceId(r100);
        if (E2(r101) == false) goto L11;
        String r102 = r101.trim();
        f200561a = r102;
        return r102;
    L11:
        if (f200562b != null) goto L24;
        f200562b = (c) ((BdpIpcService) BdpManager.getInst().getService(BdpIpcService.class)).getMainBdpIPC().f(c.class);
    L24:
        r101 = f200562b.getDeviceId();     // Catch: IpcException -> L16
    L19:
        if (E2(r101) == false) goto L22;
        String r103 = r101.trim();
        f200561a = r103;
        return r103;
    L22:
        b.b("BdpAppInfoServiceImpl", new Object[]{"No legal deviceId is found."});
        return f200561a;
    L16:
        e = move-exception;
        b.b("BdpAppInfoServiceImpl", new Object[]{"getDeviceId ipc fail", e});
        goto L19
    L5:
        return f200561a;
    }
}
