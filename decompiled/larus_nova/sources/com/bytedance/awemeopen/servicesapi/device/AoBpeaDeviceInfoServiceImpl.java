package com.bytedance.awemeopen.servicesapi.device;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/device/AoBpeaDeviceInfoServiceImpl;", "Lcom/bytedance/awemeopen/servicesapi/device/AoBpeaDeviceInfoService;", "<init>", "()V", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public final class AoBpeaDeviceInfoServiceImpl implements AoBpeaDeviceInfoService {
    public AoBpeaDeviceInfoServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.servicesapi.device.AoBpeaDeviceInfoService
    public final String o0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L22
        NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Exception -> L22
        if (r102 == null) goto L21;
        if (r102.isAvailable() == false) goto L21;
        int r103 = r102.getType();     // Catch: Exception -> L22
        if (r103 != 0) goto L10;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Exception -> L22
        Object r104 = r100.getSystemService("phone");     // Catch: Exception -> L22
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.telephony.TelephonyManager");     // Catch: Exception -> L22
        switch(((TelephonyManager) r104).getNetworkType()) {
            case 1: goto L30;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L30;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L30;
            case 8: goto L29;
            case 9: goto L29;
            case 10: goto L29;
            case 11: goto L30;
            case 12: goto L29;
            case 13: goto L28;
            case 14: goto L29;
            case 15: goto L29;
            default: goto L27;
        };     // Catch: Exception -> L22
    L27:
        return "unknown";
    L28:
        return CJPayBasicUtils.NETWORK_4G;
    L29:
        return CJPayBasicUtils.NETWORK_3G;
    L30:
        return CJPayBasicUtils.NETWORK_2G;
    L10:
        if (r103 == 1) goto L26;
        return "unknown";
    L26:
        return "wifi";
    L21:
        return "none";
    L31:
        return "unknown";
    }
}
