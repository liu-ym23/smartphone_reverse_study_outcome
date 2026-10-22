package com.bytedance.bdp.bdpplatform.service.bpea;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.defaults.permission.BdpPermissionService;
import com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaDeviceInfoService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import kotlin.Metadata;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaDeviceInfoServiceImpl;", "Lcom/bytedance/bdp/serviceapi/hostimpl/bpea/BdpBpeaDeviceInfoService;", "Lcom/bytedance/bdp/bdpplatform/service/bpea/BdpBpeaServiceImpl;", "<init>", "()V", "bdp-service_release"}, k = 1, mv = {1, 4, 0})
public final class BdpBpeaDeviceInfoServiceImpl extends BdpBpeaServiceImpl implements BdpBpeaDeviceInfoService {
    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaDeviceInfoService
    public final boolean V0() {
        Object r100 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication().getSystemService("connectivity");     // Catch: Exception -> L21
        if (r100 == null) goto L19;
        ConnectivityManager r101 = (ConnectivityManager) r100;     // Catch: Exception -> L21
        Network[] r102 = r101.getAllNetworks();     // Catch: Exception -> L21
        int r103 = r102.length;     // Catch: Exception -> L21
        int r104 = 0;
        boolean r105 = false;
    L6:
        if (r104 >= r103) goto L20;
        Network r106 = r102[r104];     // Catch: Exception -> L21
        NetworkInfo r107 = r101.getNetworkInfo(r106);     // Catch: Exception -> L21
        if (r107 == null) goto L16;
        if (r107.isConnected() != true) goto L16;
        NetworkCapabilities r108 = r101.getNetworkCapabilities(r106);     // Catch: Exception -> L21
        if (r108 == null) goto L16;
        if (r108.hasTransport(4) != true) goto L16;
        r105 = true;
    L16:
        r104 = r104 + 1;     // Catch: Exception -> L21
        goto L6
    L20:
        return r105;
    L19:
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L21
    L29:
        return false;
    }

    public BdpBpeaDeviceInfoServiceImpl() {
    }

    public static String E2(Context r100) {
        Object r101 = r100.getSystemService("phone");     // Catch: Exception -> L21
        if (r101 == null) goto L18;
        TelephonyManager r102 = (TelephonyManager) r101;     // Catch: Exception -> L21
        Application r103 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();     // Catch: Exception -> L21
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        int r104 = r102.getNetworkType();     // Catch: Exception -> L21
    L11:
        switch(r104) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L25;
            case 15: goto L25;
            case 16: goto L26;
            case 17: goto L25;
            case 18: goto L24;
            case 19: goto L19;
            case 20: goto L23;
            default: goto L19;
        };     // Catch: Exception -> L21
    L23:
        return CJPayBasicUtils.NETWORK_MOBILE;
    L24:
        return CJPayBasicUtils.NETWORK_4G;
    L25:
        return CJPayBasicUtils.NETWORK_3G;
    L26:
        return CJPayBasicUtils.NETWORK_2G;
    L7:
        if (((BdpPermissionService) BdpManager.getInst().getService(BdpPermissionService.class)).hasPermission(r103, "android.permission.READ_PHONE_STATE") == false) goto L9;
        r104 = r102.getDataNetworkType();     // Catch: Exception -> L21
        goto L11
    L9:
        r104 = 0;
        goto L11
    L18:
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Exception -> L21
    L19:
        return "unknown";
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.bpea.BdpBpeaDeviceInfoService
    public final String v0(Context r100) {
        Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L20
        if (r101 == null) goto L17;
        NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Exception -> L20
        if (r102 == null) goto L24;
        if (r102.isAvailable() == false) goto L24;
        int r103 = r102.getType();     // Catch: Exception -> L20
        if (r103 == 0) goto L23;
        if (r103 != 1) goto L18;
        return "wifi";
    L23:
        return E2(r100);
    L24:
        return "none";
    L17:
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L20
    L18:
        return "unknown";
    }
}
