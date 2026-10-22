package com.bytedance.bpea.entry.api.device.info;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import java.net.Inet4Address;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f202185a = 0;

    public static final class a {
        @JvmStatic
        public static String a(final Inet4Address r100, TokenCert r101) {
            int r102 = b.f202185a;     // Catch: BPEAException -> L4
            BaseAuthEntry.Companion r103 = BaseAuthEntry.f202194a;     // Catch: BPEAException -> L4
            int r104 = com.bytedance.bpea.entry.api.device.info.a.f202184a;     // Catch: BPEAException -> L4
            return (String) r103.a(com.bytedance.bpea.entry.api.device.info.a.C2918a.a(r101, "deviceInfo_inet4Address_getHostAddress", SpeechCode.SPEECH_STATE_MACHINE_NO_SUPPORT_RESPONSE), new InetAddressEntry$Companion$getHostAddressUnsafe$2(r100));
        L4:
            e = move-exception;
            e.printStackTrace();
            return "";
        }
    }

    static {
    }
}
