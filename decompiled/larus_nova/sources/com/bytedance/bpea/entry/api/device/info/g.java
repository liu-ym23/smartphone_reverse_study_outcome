package com.bytedance.bpea.entry.api.device.info;

import android.net.wifi.WifiInfo;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202190a = 0;

    public static final class a {
        @JvmStatic
        public static Integer a(final WifiInfo r100, TokenCert r101) {
            int r102 = 0;
            int r103 = g.f202190a;     // Catch: BPEAException -> L5
            BaseAuthEntry.Companion r104 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L5
            int r105 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L5
            return Integer.valueOf(((Number) r104.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r101, "deviceInfo_wifiInfo_getIpAddress", 102304), new WifiInfoEntry$Companion$getIpAddressUnsafe$1(r100))).intValue());
        L5:
            e = move-exception;
            e.printStackTrace();
            return r102;
        }

        @JvmStatic
        public static String b(final WifiInfo r100, TokenCert r101) {
            int r102 = g.f202190a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r103 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L4
            int r104 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L4
            return (String) r103.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r101, "deviceInfo_wifiInfo_getMacAddress", 101700), new WifiInfoEntry$Companion$getMacAddressUnsafe$1(r100));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    static {
    }
}
