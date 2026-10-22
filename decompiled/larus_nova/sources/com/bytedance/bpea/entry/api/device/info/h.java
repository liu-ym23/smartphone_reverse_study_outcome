package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202191a = 0;

    public static final class a {
        @JvmStatic
        public static WifiInfo a(final WifiManager r100, TokenCert r101) {
            int r102 = h.f202191a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r103 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L4
            int r104 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L4
            return (WifiInfo) r103.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r101, "deviceInfo_wifimanager_getConnectionInfo", 102301), new WifiManagerEntry$Companion$getConnectionInfoUnsafe$1(r100));
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
    }
}
