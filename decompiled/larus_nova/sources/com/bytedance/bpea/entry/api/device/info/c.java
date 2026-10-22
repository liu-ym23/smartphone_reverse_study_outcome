package com.bytedance.bpea.entry.api.device.info;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import java.util.Enumeration;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202186a = 0;

    public static final class a {
        @JvmStatic
        public static Enumeration a(TokenCert r100) {
            int r101 = c.f202186a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r102 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L4
            int r103 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L4
            return (Enumeration) r102.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r100, "deviceInfo_networkInterface_getNetworkInterfaces", 100016), NetworkInterfaceEntry$Companion$getNetworkInterfacesUnsafe$1.INSTANCE);
        L4:
            e = move-exception;
            e.printStackTrace();
            return null;
        }
    }

    static {
    }
}
